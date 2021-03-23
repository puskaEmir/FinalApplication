package com.academy.finalacademy387.book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.academy.finalacademy387.R;
import com.academy.finalacademy387.book.adapter.AsyncTaskExecutor;
import com.academy.finalacademy387.book.adapter.BookItemAsyncDataLoader;
import com.academy.finalacademy387.book.adapter.BookRecyclerViewAdapter;

public class BookActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private BookRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        recyclerView = findViewById(R.id.booksRecyclerView);
        BookItemAsyncDataLoader asyncDataLoader = new BookItemAsyncDataLoader(this, 20);
        new AsyncTaskExecutor(asyncDataLoader, this).execute();


        adapter = new BookRecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public BookRecyclerViewAdapter getAdapter() {
        return adapter;
    }
}