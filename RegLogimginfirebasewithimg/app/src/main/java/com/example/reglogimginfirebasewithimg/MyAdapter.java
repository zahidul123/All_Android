package com.example.reglogimginfirebasewithimg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<profile> profiles;

    public MyAdapter(Context c , ArrayList<profile> p)
    {
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(profiles.get(position).getName());
        holder.email.setText(profiles.get(position).getEmail());
        holder.phone.setText(profiles.get(position).getPhone());
        Picasso.get().load(profiles.get(position).getProfilePic()).into(holder.profilePic);
        holder.btn.setVisibility(View.VISIBLE);
        holder.onClick(position);

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,email,phone;
        ImageView profilePic;
        Button btn;
        public MyViewHolder(View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.name);
            phone =  itemView.findViewById(R.id.phone);
            email =  itemView.findViewById(R.id.email);
            profilePic =  itemView.findViewById(R.id.imagefield);
            btn = itemView.findViewById(R.id.accept);
        }
        public void onClick(final int position)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position+" is clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}