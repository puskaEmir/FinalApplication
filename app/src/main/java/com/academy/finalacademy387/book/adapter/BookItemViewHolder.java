package com.academy.finalacademy387.book.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.academy.finalacademy387.R;
import com.academy.finalacademy387.book.BookActivity;
import com.academy.finalacademy387.book.model.BookItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * BookItem --- ADAPTACIJA PRIKAZA PODATAKA UČITANIH SA WEB SERVICA -> BookItemViewHolder book_item.xml
 *
 *  BookItem bi1  ->BookItemViewHolder-> book_item.xml
 *  BookItem bi2  ->BookItemViewHolder->  book_item.xml
 *
 */
public class BookItemViewHolder extends RecyclerView.ViewHolder {

    private BookActivity bookActivity;
    private ImageView bookImage;
    private TextView bookLabel;
    private TextView bookItemTextView;
    private TextView volumeLabel;
    private TextView volumeItemTextView;

    public BookItemViewHolder(@NonNull View bookItemView, BookActivity bookActivity) {
        super(bookItemView);
        this.bookActivity = bookActivity;
        bookLabel = bookItemView.findViewById(R.id.bookLabel);
        bookItemTextView = bookItemView.findViewById(R.id.bookItem);
        volumeItemTextView = bookItemView.findViewById(R.id.volumeItem);
        bookImage = bookItemView.findViewById(R.id.bookImage);
    }


    public void setBookItem(BookItem bookItem, int position){
        bookItemTextView.setText(bookItem.getVolumeInfo().getTitle());
        volumeItemTextView.setText(bookItem.getKind());
        bookImage.setImageBitmap(bookItem.getBitmapImage());
    }
}
