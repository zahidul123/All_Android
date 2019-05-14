package com.example.destroy.textualapp;

import android.graphics.Color;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Destroy on 21-Jan-18.
 */

public  class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageviewHolder> {

    private List<Messages>mMessagelist;
    private FirebaseAuth mAuth;
    private DatabaseReference muserdatabase;

    public MessageAdapter(List<Messages>mMessagelist){
        this.mMessagelist=mMessagelist;
    }
    public MessageviewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.messagesingle_layout,parent,false);
        return new MessageviewHolder(v);

      }




    public class MessageviewHolder extends  RecyclerView.ViewHolder{

        public TextView messagetext;
        public CircleImageView profleimage;
        public ImageView messageImage;
        public TextView displayname;


        public MessageviewHolder(View view) {
            super(view);
            messagetext=(TextView)view.findViewById(R.id.message_text_layout);
            displayname=(TextView)view.findViewById(R.id.name_text_layout);
            profleimage=(CircleImageView)view.findViewById(R.id.message_profile_layout);
            messageImage=(ImageView)view.findViewById(R.id.message_image_layout);

        }





    }

    @Override
    public void onBindViewHolder(final MessageviewHolder holder, int position) {

        mAuth=FirebaseAuth.getInstance();
        String current_user_id=mAuth.getCurrentUser().getUid();

        Messages c=mMessagelist.get(position);

        String from_user=c.getFrom();
        String message_type=c.getType();
        muserdatabase= FirebaseDatabase.getInstance().getReference().child("users").child(from_user);

        muserdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("name").getValue().toString();
                String image=dataSnapshot.child("thumb image").getValue().toString();
                holder.displayname.setText(name);
                Picasso.with(holder.profleimage.getContext()).load(image).placeholder(R.drawable.frame).into(holder.profleimage);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        if (message_type.equals("text")) {
            if (from_user.equals(current_user_id)) {

                holder.messagetext.setBackgroundColor(Color.WHITE);
                holder.messagetext.setTextColor(Color.BLACK);

            } else {

                holder.messagetext.setBackgroundResource(R.drawable.message_text);
                holder.messagetext.setTextColor(Color.WHITE);

            }

            holder.messageImage.setVisibility(View.INVISIBLE);

        }else {


            holder.messagetext.setVisibility(View.INVISIBLE);

            Picasso.with(holder.profleimage.getContext()).load(c.getMessage()).placeholder(R.drawable.frame).into(holder.profleimage);

        }

        holder.messagetext.setText(c.getMessage());
    }

    @Override
    public int getItemCount() {
        return mMessagelist.size();
    }
}
