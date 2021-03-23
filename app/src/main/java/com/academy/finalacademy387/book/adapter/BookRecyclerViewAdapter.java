package com.academy.finalacademy387.book.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.academy.finalacademy387.R;
import com.academy.finalacademy387.book.BookActivity;
import com.academy.finalacademy387.book.model.BookItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * List<BookItem> -> List<BookItemViewHolder> book_item.xml
 *
 */
public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookItemViewHolder> {


    private BookActivity bookActivity;
    private List<BookItem> bookItemList = new ArrayList<>();

    public BookRecyclerViewAdapter(BookActivity bookActivity) {
        this.bookActivity = bookActivity;
    }

    public void addBookItemList(List<BookItem> bookItems){
        for(BookItem bookItem: bookItems){
            if(!bookItemList.contains(bookItem)){
                bookItemList.add(bookItem);
            }
        }
    }

    @NonNull
    @Override
    public BookItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bookItemView = LayoutInflater.from(bookActivity).inflate(R.layout.book_item, parent,false);
        BookItemViewHolder itemViewHolder = new BookItemViewHolder(bookItemView, bookActivity);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookItemViewHolder bookItemViewHolder, int position) {
        bookItemViewHolder.setBookItem(bookItemList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return bookItemList.size();
    }
}
