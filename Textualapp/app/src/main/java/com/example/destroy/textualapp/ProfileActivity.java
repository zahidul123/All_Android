package com.example.destroy.textualapp;

import android.app.ProgressDialog;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    private TextView mprofilestatus;
    private TextView mprofilefriend;
    private TextView mprofilename;
    private ImageView mprofileImage;
    private Button mprofilefriendreq;
    private Button mprofiledeclinereq;


    private DatabaseReference mrootRef;
    private DatabaseReference muserdatabase;
    private DatabaseReference msendfriendreq;
    private DatabaseReference mfrienddatabase;
    private DatabaseReference mNotificationDatabase;
    private FirebaseUser mcurrent_user;

    private ProgressDialog mprogressdialogue;

    private String mcurrent_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final String user_id=getIntent().getStringExtra("user_id");


        mrootRef=FirebaseDatabase.getInstance().getReference();
        muserdatabase= FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);
        msendfriendreq=FirebaseDatabase.getInstance().getReference().child("Friend_req");
        mfrienddatabase=FirebaseDatabase.getInstance().getReference().child("Friends");
        mNotificationDatabase=FirebaseDatabase.getInstance().getReference().child("notifications");
        mcurrent_user= FirebaseAuth.getInstance().getCurrentUser();



        mprofilename=(TextView)findViewById(R.id.profile_displayname);
        mprofilefriend=(TextView)findViewById(R.id.profile_totalFriend);
        mprofilestatus=(TextView)findViewById(R.id.profile_status);
        mprofileImage=(ImageView)findViewById(R.id.profile_image);
        mprofilefriendreq=(Button)findViewById(R.id.profile_send_req_btn);
        mprofiledeclinereq=(Button)findViewById(R.id.profile_decline_btn);

        mcurrent_state="no friend";

        mprogressdialogue=new ProgressDialog(this);
        mprogressdialogue.setTitle("Profile data");
        mprogressdialogue.setMessage("profile data are loading............");
        mprogressdialogue.setCanceledOnTouchOutside(false);
        mprogressdialogue.show();


        muserdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String display_name=dataSnapshot.child("name").getValue().toString();
                String status=dataSnapshot.child("status").getValue().toString();
                String image=dataSnapshot.child("image").getValue().toString();
                mprofilename.setText(display_name);
                mprofilestatus.setText(status);

                Picasso.with(ProfileActivity.this).load(image).placeholder(R.drawable.frame).into(mprofileImage);

                //...............friend request accept ................


                msendfriendreq.child(mcurrent_user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(user_id)){
                            String req_Type=dataSnapshot.child(user_id).child("request_type").getValue().toString();
                            if (req_Type.equals("received")){

                                mcurrent_state="req_received";
                                mprofilefriendreq.setText("Accept friend request");

                                mprofiledeclinereq.setVisibility(View.VISIBLE);
                                mprofiledeclinereq.setEnabled(true);


                            }else if (req_Type.equals("sent")){

                                mcurrent_state="req send";
                                mprofilefriendreq.setText("cancel friend request");

                                mprofiledeclinereq.setVisibility(View.INVISIBLE);
                                mprofiledeclinereq.setEnabled(false);

                            }else{

                                mfrienddatabase.child(mcurrent_user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.hasChild(user_id)){
                                            mcurrent_state="friends";
                                            mprofilefriendreq.setText("unfriend this person");

                                            mprofiledeclinereq.setVisibility(View.INVISIBLE);
                                            mprofiledeclinereq.setEnabled(false);

                                        }
                                        mprogressdialogue.dismiss();
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                        mprogressdialogue.dismiss();
                                    }
                                });
                            }
                        }
                        mprogressdialogue.dismiss();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mprofilefriendreq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ///................send request process..............//

                mprofilefriendreq.setEnabled(false);
                if (mcurrent_state.equals("not friend")){


                    DatabaseReference newNotificationref=mrootRef.child("notifications").child(user_id).push();
                    String newNotificationId=newNotificationref.getKey();

                     HashMap<String,String>notificationData=new HashMap<>();
                    notificationData.put("from",mcurrent_user.getUid());
                    notificationData.put("type","request");

                  Map requestMap=new HashMap();
                  requestMap.put("Friend_req/"+mcurrent_user.getUid()+"/"+user_id+"/request_type","sent");
                  requestMap.put("Friend_req/"+user_id+"/"+mcurrent_user.getUid()+"/request_type","received");
                  requestMap.put("notification/"+user_id+"/"+newNotificationId,notificationData);

                  mrootRef.updateChildren(requestMap, new DatabaseReference.CompletionListener() {
                      @Override
                      public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                          if (databaseError!=null){

                              Toast.makeText(ProfileActivity.this,"there is some error to send this request",Toast.LENGTH_SHORT).show();
                          }

                          mcurrent_state="req send";
                          mprofilefriendreq.setText("cancle friend request");

                          mprofiledeclinereq.setEnabled(true);

                      }
                  });


                }

                //// .............cancel request process......//

                if (mcurrent_state.equals("req send")){
                    msendfriendreq.child(mcurrent_user.getUid()).child(user_id).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            msendfriendreq.child(mcurrent_user.getUid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    mprofilefriendreq.setEnabled(true);
                                    mcurrent_state="not friend";
                                    mprofilefriendreq.setText("send friend request");

                                    mprofiledeclinereq.setVisibility(View.INVISIBLE);
                                    mprofiledeclinereq.setEnabled(false);


                                }
                            });
                        }
                    });
                }

                //........request receive state..........

                if (mcurrent_state.equals("req_received")) {

                    final String currentdate= DateFormat.getDateTimeInstance().format(new Date());
                    mfrienddatabase.child(mcurrent_user.getUid()).child(user_id).setValue(currentdate).addOnSuccessListener(
                            new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    mfrienddatabase.child(user_id).child(mcurrent_user.getUid()).setValue(currentdate)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    msendfriendreq.child(mcurrent_user.getUid()).child(user_id).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void aVoid) {
                                                            msendfriendreq.child(mcurrent_user.getUid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                @Override
                                                                public void onSuccess(Void aVoid) {

                                                                    mprofilefriendreq.setEnabled(true);
                                                                    mcurrent_state="friends";
                                                                    mprofilefriendreq.setText("unfriend this person ");

                                                                    mprofiledeclinereq.setVisibility(View.INVISIBLE);
                                                                    mprofiledeclinereq.setEnabled(false);

                                                                }
                                                            });
                                                        }
                                                    });
                                                }
                                            });

                                }
                            });

                }



                //.............unfriend..............

                if(mcurrent_state.equals("friends")){
                    Map unfriendMap=new HashMap();
                    unfriendMap.put("Friends"+mcurrent_user.getUid()+"/"+user_id,null);
                    unfriendMap.put("Friends"+user_id+"/"+mcurrent_user.getUid(),null);

                    mrootRef.updateChildren(unfriendMap, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                            if (databaseError==null){

                                mcurrent_state="not friends";
                                mprofilefriendreq.setText(" send friend request ");

                                mprofiledeclinereq.setVisibility(View.INVISIBLE);
                                mprofiledeclinereq.setEnabled(false);

                            }else{
                                String error=databaseError.getMessage();
                                Toast.makeText(ProfileActivity.this,error,Toast.LENGTH_SHORT).show();
                            }


                            mprofiledeclinereq.setEnabled(true);

                        }
                    });

                }

            }
        });

    }
}
