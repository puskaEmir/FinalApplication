package com.academy.finalacademy387.book.adapter;

import com.academy.finalacademy387.book.BookActivity;
import com.academy.finalacademy387.book.controller.BookController;
import com.academy.finalacademy387.book.model.Book;
import com.academy.finalacademy387.book.model.BookItem;

import java.util.List;
import java.util.Map;

public class BookItemAsyncDataLoader implements AsyncDataLoader{


      // 505 BookItem -> 10 korisnik skrola drugih 10 ...10

    private BookActivity bookActivity;
    private BookRecyclerViewAdapter adapter;
    private int maxResults;
    private int totalNumberOfBooks;
    private List<BookItem> bookItems;

    public BookItemAsyncDataLoader(BookActivity bookActivity, int maxResults) {
        this.bookActivity = bookActivity;
        this.maxResults = maxResults;
    }

    //BACKGROUND THREAD(Async Thread) -> neovisno od UI ili MAIN Thread
    @Override
    public void asyncDataLoad() {

        Book book = new BookController().loadBookItems(maxResults);
        bookItems = book.getItems();
        totalNumberOfBooks =book.getTotalItems();
    }

    @Override
    public void onPostAsyncDataLoad() {
        if(adapter == null) {
            adapter = bookActivity.getAdapter();
        }
        if(adapter!=null){
            adapter.addBookItemList(bookItems);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onPostAsyncErrorLoad(String errorMessage) {

    }
}
