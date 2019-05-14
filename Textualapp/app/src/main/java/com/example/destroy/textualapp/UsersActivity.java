package com.example.destroy.textualapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class UsersActivity extends AppCompatActivity {
    private RecyclerView muserslist;
    private Toolbar musertoolbar;

    private DatabaseReference muserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        muserslist=(RecyclerView)findViewById(R.id.users_list);
        musertoolbar=(Toolbar)findViewById(R.id.users_appbar);
        setSupportActionBar(musertoolbar);
        getSupportActionBar().setTitle("Friend list");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        muserDatabase= FirebaseDatabase.getInstance().getReference().child("Users");

        muserslist.setHasFixedSize(true);
        muserslist.setLayoutManager(new LinearLayoutManager(this));


    }

    protected void onStart() {

        super.onStart();

        FirebaseRecyclerAdapter<Users,UserViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                Users.class,
                R.layout.user_single_layout,
                UserViewHolder.class,
                muserDatabase

        ) {
            @Override
            protected void populateViewHolder(UserViewHolder userViewHolder, Users model, int position) {

                userViewHolder.setdName(model.getName());
                userViewHolder.setdStatus(model.getStatus());
                userViewHolder.setdthumbimage(model.getThumb_image(),getApplicationContext());

                final String user_id=getRef(position).getKey();//getting user id number

                userViewHolder.mview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        Intent profileIntent=new Intent(UsersActivity.this,ProfileActivity.class);
                        profileIntent.putExtra("user_id",user_id);
                        startActivity(profileIntent);
                    }

                });

            }
        };
       muserslist.setAdapter(firebaseRecyclerAdapter);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        View mview;
        public UserViewHolder(View itemView) {
            super(itemView);
            mview=itemView;
        }
        public void setdName(String name){
            TextView username=(TextView)mview.findViewById(R.id.user_single_name);
            username.setText(name);
        }

        public void setdStatus(String status) {
            TextView defaultStatus=(TextView) mview.findViewById(R.id.user_single_status);
            defaultStatus.setText(status);
        }


        public void setdthumbimage(String thumb_image, Context cntx) {

            CircleImageView userimageview=(CircleImageView)mview.findViewById(R.id.user_single_image);
            Picasso.with(cntx).load(thumb_image).placeholder(R.drawable.frame).into(userimageview);
        }
    }
}
