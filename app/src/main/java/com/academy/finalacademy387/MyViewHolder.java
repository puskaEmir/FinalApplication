package com.academy.finalacademy387;


import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    private CardView cardView;
    private ImageView imageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private ItemClickListener itemClickListener;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardView);
        imageView = itemView.findViewById(R.id.imageView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
    }

    public void setTitleText(String title){
        titleTextView.setText(title);
    }

    public void setDescriptionText(String description){
        descriptionTextView.setText(description);
    }

    public void setImageViewResourceId(int resource){
        imageView.setImageResource(resource);
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        //CardClickListener cardClickListener = new CardClickListener(itemClickListener);
        //Lambda sluzi kao shorctut za operator new ->
        View.OnClickListener clickListener = view -> itemClickListener.onItemClickListener(view, getLayoutPosition());
        this.cardView.setOnClickListener(clickListener);
    }

  /*  private class CardClickListener implements View.OnClickListener{

        private ItemClickListener itemClickListener;

        public CardClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClickListener(view, getLayoutPosition());
        }
    }*/
}
