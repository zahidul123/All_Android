package com.example.onekkosteachi;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onekkosteachi.All_ModelClass.Book;
import com.example.onekkosteachi.All_ModelClass.Booklist;
import com.example.onekkosteachi.All_ModelClass.Results;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Bookadapter extends RecyclerView.Adapter<Bookadapter.Bookviewholder> {
    Context context;
    List<Results>arrbooklists;
    public Bookadapter(MainActivity mainActivity, List<Results> arrbooklists) {
        this.context=mainActivity;
        this.arrbooklists=arrbooklists;
    }

    @NonNull
    @Override
    public Bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recyclerview_book,null);
        return new Bookviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Bookviewholder holder, int position) {
        Results base=arrbooklists.get(position);
        List<Book> book=base.getBooks();
         Book booklist=book.get(position);
          holder.title.setText(booklist.getTitle());
          holder.price.setText(booklist.getPrice());
          holder.rating.setText(booklist.getAsterisk());
          holder.rank.setText(booklist.getRank());
          int ranks= booklist.getAsterisk();
        Log.e(" book rate "," "+ranks);
        holder.ratingstr.setNumStars(booklist.getAsterisk());
        Picasso.get()
                .load(booklist.getBookImage())
                .placeholder(R.drawable.horror)
                .fit()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return arrbooklists.size();
    }

    public class Bookviewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView price,rating,rank,details,title;
        RatingBar ratingstr;
        public Bookviewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.bookTitle);
            imageView=itemView.findViewById(R.id.bookimage);
            price=itemView.findViewById(R.id.price);
            rating=itemView.findViewById(R.id.rating);
            rank=itemView.findViewById(R.id.ranking);
            details=itemView.findViewById(R.id.details);
            ratingstr=itemView.findViewById(R.id.ratingBar);
        }
    }
}
