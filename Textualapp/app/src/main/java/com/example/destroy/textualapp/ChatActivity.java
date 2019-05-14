package com.example.destroy.textualapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {
    private String mchatuser;
    private String musername;
    private String mcurrentuserid;

    private Toolbar chattoolbar;
    private DatabaseReference mrootref;
    private FirebaseAuth mauth;
    private TextView mtitleview;
    private TextView mlastseen;
    private CircleImageView mprofileimage;

    private ImageButton chataddbtn;
    private ImageButton chatsendbtn;
    private EditText chatmessageview;
    private SwipeRefreshLayout mRefreshLayout;


    private RecyclerView messagelist;
    MessageAdapter madapter;

    private final List<Messages>mmessagelist=new ArrayList<>();
    private LinearLayoutManager mlinearlayout;

    private static final int TOTAL_ITEM_TO_LOAD=10;
    private int currentpage=1;

    //solution
    private int itemPos=1;
    private String mLastkey="";
    private String mprevkey="";
    private static final int GALLERY_PICK=1;
    StorageReference mimagestorage;

  //  private DatabaseReference mMessageDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        chattoolbar=(Toolbar)findViewById(R.id.chat_app_bar);
        setSupportActionBar(chattoolbar);

        ActionBar actionbae=getSupportActionBar();
        actionbae.setDisplayHomeAsUpEnabled(true);
        actionbae.setDisplayShowCustomEnabled(true);

        chataddbtn=(ImageButton) findViewById(R.id.chat_add_btn);
        chatsendbtn=(ImageButton)findViewById(R.id.chat_send_btn);
        chatmessageview=(EditText)findViewById(R.id.chat_message);
        mRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.message_swipe_layout);


        mrootref= FirebaseDatabase.getInstance().getReference();
        mauth=FirebaseAuth.getInstance();
        mcurrentuserid=mauth.getCurrentUser().getUid();

        mchatuser=getIntent().getStringExtra("user id");
        musername=getIntent().getStringExtra("user name");

        getSupportActionBar().setTitle(musername);
        LayoutInflater inflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View action_bar_view=inflater.inflate(R.layout.chat_custom_bar,null);
        actionbae.setCustomView(action_bar_view);

        //......custom action bar...
        mtitleview=(TextView)findViewById(R.id.custom_bar_title);
        mlastseen=(TextView)findViewById(R.id.custom_bar_seen);
        mprofileimage=(CircleImageView)findViewById(R.id.custom_bar_image);


        madapter=new MessageAdapter(mmessagelist);

        messagelist=(RecyclerView)findViewById(R.id.message_list);
        mlinearlayout=new LinearLayoutManager(this);
        messagelist.setHasFixedSize(true);
        messagelist.setLayoutManager(mlinearlayout);
        messagelist.setAdapter(madapter);


        loadMessage();

        mtitleview.setText(musername);
        mrootref.child("Users").child(mchatuser).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String online=dataSnapshot.child("onlone").getValue().toString();
                String image=dataSnapshot.child("image").getValue().toString();

                if (online.equals("true")){
                    mlastseen.setText("online");

                }else {
                    GetTimeAgo gettimeago=new GetTimeAgo();
                    long pasttime=Long.parseLong(online);
                    String lastseentime=gettimeago.getTimeAgo(pasttime,getApplicationContext());
                    mlastseen.setText(lastseentime);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        chataddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galerryint=new Intent();
                galerryint.setType("image/*");
                galerryint.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(galerryint,"select image"),GALLERY_PICK);

            }
        });



        mrootref.child("chat").child(mcurrentuserid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (!dataSnapshot.hasChild(mchatuser)){

                    Map chataddmap=new HashMap();
                    chataddmap.put("seen",false);
                    chataddmap.put("time stamp", ServerValue.TIMESTAMP);

                    Map chatusermap=new HashMap();
                    chatusermap.put("chat/"+mcurrentuserid+"/"+mchatuser,chataddmap);
                    chatusermap.put("chat/"+mchatuser+"/"+mcurrentuserid,chataddmap);



                    mrootref.updateChildren(chatusermap, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                            if (databaseError!=null){

                                Log.d("CHAT_LOG",databaseError.getMessage().toString());

                            }
                        }
                    });
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        chatsendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendmessage();

            }
        });

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentpage++;
                itemPos=0;
                loadmoreMessage();

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GALLERY_PICK&&resultCode==RESULT_OK){

            Uri imageuri=data.getData();
            final String current_user_ref="messages/"+mcurrentuserid+"/"+mchatuser;
            final String chat_user_ref="messages/"+mchatuser+"/"+mcurrentuserid;

            DatabaseReference message_user_push=mrootref.child("message").child(mcurrentuserid).child(mchatuser).push();

            //StorageReference mimagestorage=new StorageReference();

            final String pushid=message_user_push.getKey();
            StorageReference filepath=mimagestorage.child("message image").child(pushid+".jpg");
            filepath.putFile(imageuri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                    if (task.isSuccessful()){
                        String download_url=task.getResult().getDownloadUrl().toString();
                        Map messagemap=new HashMap();

                        messagemap.put("message",download_url);
                        messagemap.put("seen",false);
                        messagemap.put("type","text");
                        messagemap.put("time",ServerValue.TIMESTAMP);
                        messagemap.put("from",mcurrentuserid);


                        Map messageusermap=new HashMap();
                        messageusermap.put(current_user_ref+"/"+pushid,messagemap);
                        messageusermap.put(chat_user_ref+"/"+pushid,messagemap);
                        chatmessageview.setText("");


                        mrootref.updateChildren(messageusermap, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                if (databaseError!=null){

                                    Log.d("CHAT_LOG",databaseError.getMessage().toString());

                                }
                            }
                        });
                    }


                }
            });




        }
    }

    private void loadmoreMessage() {
        DatabaseReference messageRef=mrootref.child("messages").child(mcurrentuserid).child(mchatuser);
        Query messagequery=messageRef.orderByKey().endAt(mLastkey).limitToLast(10);
        messagequery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Messages messages=dataSnapshot.getValue(Messages.class);

                String messagekey=dataSnapshot.getKey();

                if (!messagekey.equals(mprevkey)){

                    mmessagelist.add(itemPos++,messages);

                }else {

                    mprevkey=mLastkey;
                }


                if (itemPos==1){

                    mLastkey=messagekey;

                }
                Log.d("TOTALKEYS","Last key : "+mLastkey+"| previous key "+mprevkey+"| mesage key :"+messagekey);

                madapter.notifyDataSetChanged();

               // messagelist.scrollToPosition(mmessagelist.size()-1);

                mRefreshLayout.setRefreshing(false);
                mlinearlayout.scrollToPositionWithOffset(10,0);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void loadMessage() {

       DatabaseReference messageRef=mrootref.child("messages").child(mcurrentuserid).child(mchatuser);
        Query messagequery=messageRef.limitToLast(currentpage*TOTAL_ITEM_TO_LOAD);

              messagequery.addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Messages messages=dataSnapshot.getValue(Messages.class);
                itemPos++;


                if (itemPos==1){
                    String messagekey=dataSnapshot.getKey();
                    mLastkey=messagekey;
                    mprevkey=messagekey;

                }


                mmessagelist.add(messages);
                madapter.notifyDataSetChanged();

                messagelist.scrollToPosition(mmessagelist.size()-1);

                mRefreshLayout.setRefreshing(false);

            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }


            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }


            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void sendmessage() {

        String message=chatmessageview.getText().toString();

        if(!TextUtils.isEmpty(message)){

            String current_user_ref="messages/"+mcurrentuserid+"/"+mchatuser;
            String chat_user_ref="messages/"+mchatuser+"/"+mcurrentuserid;

            DatabaseReference message_user_push=mrootref.child("message").child(mcurrentuserid).child(mchatuser).push();

            String pushid=message_user_push.getKey();

            Map messagemap=new HashMap();

            messagemap.put("message",message);
            messagemap.put("seen",false);
            messagemap.put("type","text");
            messagemap.put("time",ServerValue.TIMESTAMP);
            messagemap.put("from",mcurrentuserid);


            Map messageusermap=new HashMap();
            messageusermap.put(current_user_ref+"/"+pushid,messagemap);
            messageusermap.put(chat_user_ref+"/"+pushid,messagemap);
            chatmessageview.setText("");


            mrootref.updateChildren(messageusermap, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                    if (databaseError!=null){

                        Log.d("CHAT_LOG",databaseError.getMessage().toString());

                    }
                }
            });

        }



    }
}
