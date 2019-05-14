package com.example.destroy.tosearch;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigation;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private RecyclerView postList;
    private Toolbar mtoolbar;

    private ImageButton addnewpost;
    private CircleImageView naveProfileImage;
    private TextView namveprofileusername;
    private FirebaseAuth mAuth;
    private DatabaseReference userRef;
    private DatabaseReference postref;

    String currcentUserid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        FirebaseUser checkvalidity = mAuth.getCurrentUser();
        if (checkvalidity!=null) {
            currcentUserid = mAuth.getCurrentUser().getUid();
        }
       userRef= FirebaseDatabase.getInstance().getReference().child("users");
        postref= FirebaseDatabase.getInstance().getReference().child("posts");


        addnewpost=(ImageButton)findViewById(R.id.add_new_post_button);
        mtoolbar=(Toolbar)findViewById(R.id.main_tool_bar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("home");


        drawer=(DrawerLayout)findViewById(R.id.main_drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawer,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigation=(NavigationView)findViewById(R.id.main_navigation);



        postList=(RecyclerView)findViewById(R.id.all_users_post);
        postList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        postList.setLayoutManager(linearLayoutManager);

        View navview=navigation.inflateHeaderView(R.layout.navigation_header);
        naveProfileImage=(CircleImageView)navview.findViewById(R.id.nav_profile_image);
        namveprofileusername=(TextView)navview.findViewById(R.id.user_name);




      if (checkvalidity!=null) {
          userRef.child(currcentUserid).addValueEventListener(new ValueEventListener() {
              @Override
              public void onDataChange(DataSnapshot dataSnapshot) {
                  if (dataSnapshot.exists()) {
                     if (dataSnapshot.hasChild("fullname")){
                         String name = dataSnapshot.child("fullname").getValue().toString();
                         namveprofileusername.setText(name);
                     }

                     if(dataSnapshot.hasChild("profileimage")) {
                         String image = dataSnapshot.child("profileimage").getValue().toString();
                         Picasso.with(MainActivity.this)
                                 .load(image)
                                 .placeholder(R.drawable.profile_icon)
                                 .into(naveProfileImage);
                     }

                  }
              }

              @Override
              public void onCancelled(DatabaseError databaseError) {

              }
          });
      }

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                usermkenueselection(item);
                return false;
            }
        });

      addnewpost.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              sendUserToPostActivity();
          }
      });


      DisplayAlluserpost();
    }


    private void DisplayAlluserpost() {

        FirebaseRecyclerAdapter<Post,PostViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Post, PostViewHolder>(
                Post.class,
                R.layout.show_all_post,
                PostViewHolder.class,
                postref) {
            @Override
            protected void populateViewHolder(PostViewHolder viewHolder, Post model, int position) {

               final String postKey=getRef(position).getKey();

                viewHolder.setFullname(model.getFullname());
                viewHolder.setTime(model.getTime());
                viewHolder.setdate(model.getDate());
                viewHolder.setDescription(model.getDescription());
                viewHolder.setProfileimage(getApplicationContext(),model.getProfileimage());
                viewHolder.setPostimage(getApplicationContext(),model.getPostimage());

                viewHolder.mview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent clickpostint=new Intent(MainActivity.this,Click_Post_Activity.class);
                        clickpostint.putExtra("postkey",postKey);
                        startActivity(clickpostint);
                    }
                });
            }
        };
        postList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        View mview;
        public PostViewHolder(View itemView) {
            super(itemView);
            mview=itemView;
        }

        public void setFullname(String fullname){
            TextView username =(TextView)mview.findViewById(R.id.ppost_profile_name);
            username.setText(fullname);
        }
        public void setProfileimage(Context ctx,String Profileimage){
            CircleImageView image=(CircleImageView)mview.findViewById(R.id.post_profile_image);
            Picasso.with(ctx).load(Profileimage).into(image);
        }

        public void setTime(String time){
            TextView username =(TextView)mview.findViewById(R.id.post_time);
            username.setText(" "+time);
        }
        public void setdate(String date){
            TextView username =(TextView)mview.findViewById(R.id.post_date);
            username.setText(" "+date);
        }

        public void setDescription(String description){
            TextView username =(TextView)mview.findViewById(R.id.post_description);
            username.setText(description);
        }

        public void setPostimage(Context ctx,String postimage){
            ImageView image=(ImageView) mview.findViewById(R.id.post_image);
            Picasso.with(ctx).load(postimage).into(image);
        }

    }


    private void sendUserToPostActivity() {

        Intent addnewintent=new Intent(MainActivity.this,PostActivity.class);
        startActivity(addnewintent);

    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       if (currentUser==null){
           sendtoLoginActivity();
       }
       else{

           checkuserExestince();
       }
    }


    private void checkuserExestince() {
        final String userid=mAuth.getCurrentUser().getUid();

       userRef.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               if (!dataSnapshot.hasChild(userid)){
                   sendUserToSetupActivity();
               }
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });

    }



    private void sendUserToSetupActivity() {
        Intent intent=new Intent(MainActivity.this,SetupActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void sendtoLoginActivity() {
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        //check if user set back button he cannoy go again
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void usermkenueselection(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_post:
                sendUserToPostActivity();
                break;
            case R.id.nav_profile:
                Toast.makeText(this, "all profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_home:
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_my_friends:
                Toast.makeText(this, "my friens", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_fnd_search:
                Toast.makeText(this, "search friends", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_setting:
                Intent inten=new Intent(MainActivity.this,SetupActivity.class);
                startActivity(inten);
                finish();
                break;
            case R.id.nav_log_out:
               mAuth.signOut();
               sendtoLoginActivity();
                break;
            case R.id.nav_message:
                Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();
                break;

        }
    }


}
