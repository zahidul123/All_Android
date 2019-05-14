package com.example.destroy.textualapp;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {
    private RecyclerView mfriendList;

    private DatabaseReference mFriendDatabase;
    private DatabaseReference mUserdatabase;

    private FirebaseAuth mAuth;

    private String mcurrent_user_id;

    private View mMainview;


    public FriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       mMainview = inflater.inflate(R.layout.fragment_friends, container, false);
       mfriendList=(RecyclerView)mMainview.findViewById(R.id.friend_list);
       mAuth=FirebaseAuth.getInstance();

       mcurrent_user_id=mAuth.getCurrentUser().getUid();

       mFriendDatabase=FirebaseDatabase.getInstance().getReference().child("Friends").child(mcurrent_user_id);
       mFriendDatabase.keepSynced(true);
       mUserdatabase=FirebaseDatabase.getInstance().getReference().child("Users");
       mUserdatabase.keepSynced(true);


       mfriendList.setHasFixedSize(true);
       mfriendList.setLayoutManager(new LinearLayoutManager(getContext()));

       return mMainview;

    }

    public  void  onStart() {

        super.onStart();

        FirebaseRecyclerAdapter <Friends,FriendsViewHolder>friendsrecyclerviewadepter=new FirebaseRecyclerAdapter<Friends, FriendsViewHolder>(
                Friends.class,
                R.layout.user_single_layout,
                FriendsViewHolder.class,
                mFriendDatabase
        ) {
            @Override
            protected void populateViewHolder(final FriendsViewHolder friendviewHolder, Friends model, int position) {

                friendviewHolder.setDate(model.getDate());

                final String list_user_id=getRef(position).getKey();

                mUserdatabase.child(list_user_id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        final String usernaem=dataSnapshot.child("name").getValue().toString();
                        String thumbimage=dataSnapshot.child("thumb_image").getValue().toString();

                        if(dataSnapshot.hasChild("online")){
                            String online= dataSnapshot.child("online").getValue().toString();
                            friendviewHolder.setuseronline(online);
                        }


                        friendviewHolder.setName(usernaem);
                        friendviewHolder.setdthumbimage(thumbimage,getContext());
                        friendviewHolder.mview.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                CharSequence options[]=new CharSequence[]{"open profile","send message"};

                                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());

                                builder.setTitle("select options");

                                builder.setItems(options, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        //click for items
                                        if (i==0){

                                            Intent profileintent=new Intent(getContext(),ProfileActivity.class);
                                            profileintent.putExtra("user id",list_user_id);
                                            startActivity(profileintent);

                                        }
                                        if(i==1){
                                            Intent chatactivity=new Intent(getContext(),ChatActivity.class);
                                            chatactivity.putExtra("user id",list_user_id);
                                            chatactivity.putExtra("user name",usernaem);
                                            startActivity(chatactivity);
                                        }


                                    }
                                });
                                builder.show();

                            }
                        });




                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

        };
        mfriendList.setAdapter(friendsrecyclerviewadepter);

    }

    public class FriendsViewHolder extends RecyclerView.ViewHolder{

        View mview;

        public FriendsViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
        }

        public void setDate(String date) {
            TextView usernameview=(TextView)mview.findViewById(R.id.user_single_status);
            usernameview.setText(date);
        }


        public void setName(String name) {
            TextView usernameview=(TextView)mview.findViewById(R.id.user_single_name);
            usernameview.setText(name);
        }


            public void setdthumbimage(String thumbimage, Context context) {

            CircleImageView userimageview=(CircleImageView)mview.findViewById(R.id.user_single_image);
            Picasso.with(context).load(thumbimage).placeholder(R.drawable.frame).into(userimageview);

        }

        public void setuseronline(String online_status){
            ImageView useronlinevie=(ImageView)mview.findViewById(R.id.user_single_online);
            if (online_status.equals("true")) {

                useronlinevie.setVisibility(View.VISIBLE);

            }else{
                useronlinevie.setVisibility(View.INVISIBLE);
            }
        }

    }


}
