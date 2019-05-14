package com.example.destroy.tosearch;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Click_Post_Activity extends AppCompatActivity {
    private ImageView postImge;
    private TextView postDescription;
    Button deletepostbtn,editpostbtn;
    private String postkey,currentuserid,databaseuserId,description,image;
    private FirebaseAuth mAuth;
    private DatabaseReference clickpostref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click__post_);

        postkey=getIntent().getExtras().get("postkey").toString();
        mAuth=FirebaseAuth.getInstance();
        currentuserid = mAuth.getCurrentUser().getUid();


        clickpostref=FirebaseDatabase.getInstance().getReference().child("posts").child(postkey);


        postImge=(ImageView)findViewById(R.id.edite_post_image);
        postDescription=(TextView)findViewById(R.id.edit_post_description);
        deletepostbtn=(Button)findViewById(R.id.delete_post_btn);
        editpostbtn=(Button)findViewById(R.id.edit_post_btn);


        deletepostbtn.setVisibility(View.INVISIBLE);
        editpostbtn.setVisibility(View.INVISIBLE);




        clickpostref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    description = dataSnapshot.child("description").getValue().toString();
                    image = dataSnapshot.child("postimage").getValue().toString();
                    databaseuserId = dataSnapshot.child("uid").getValue().toString();

                    postDescription.setText(description);
                    Picasso.with(Click_Post_Activity.this).load(image).into(postImge);
                    if (currentuserid.equals(databaseuserId)) {
                        deletepostbtn.setVisibility(View.VISIBLE);
                        editpostbtn.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        deletepostbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCurrentPost();

            }
        });
        editpostbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editCurrentPost(description);

            }
        });

    }


    private void editCurrentPost(String description) {

        AlertDialog.Builder builder=new AlertDialog.Builder(Click_Post_Activity.this);
        builder.setTitle("Edit Post");
        final EditText inputfield=new EditText(Click_Post_Activity.this);
        inputfield.setText(description);
        builder.setView(inputfield);


        builder.setPositiveButton("update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                clickpostref.child("description").setValue(inputfield.getText().toString());
                Toast.makeText(Click_Post_Activity.this, "post Text is updated ", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        Dialog dialog=builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.holo_green_dark);
    }


    private void deleteCurrentPost() {
        clickpostref.removeValue();
        sendtomainActivity();
        Toast.makeText(this, "post has deleted .......", Toast.LENGTH_SHORT).show();
    }

    private void sendtomainActivity() {
        Intent intent=new Intent(Click_Post_Activity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
