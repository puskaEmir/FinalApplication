package com.academy.finalacademy387.book.controller;

import android.app.Service;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.academy.finalacademy387.book.model.Book;
import com.academy.finalacademy387.book.model.BookItem;
import com.academy.finalacademy387.book.model.VolumeInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
  *
 * {
 *     "author":"Meša selimović",
 *     "books":[
 *              {},
 *              {},
 *              {}
 *     ]
 *
 * }
 *
 *
 *
 *
 *
 */
public class BookController {


    /**
     *
     * PARSIRAATI sadržaj koji dobijemo kao RESPONSE od web servisa
     *
     * ..UrlGetConnector
     *
     * Map<Integer, List<BookItem>>
     *
     * @param maxResults
     * @return
     */
    public Book loadBookItems(int maxResults){
        try{
            List<BookItem> bookItemList = new ArrayList<>();
            //ADRESU
            String url = ServiceUrl.getBookListUrl(maxResults);
            //GET metode
            UrlGetConnector urlGetConnector = new UrlGetConnector(url);
            String response = urlGetConnector.getHttpsResponse();//response -> JSON
            // JSON response  -> JSONObject, JSONArray
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for(int i = 0; i<jsonItems.length(); i++){
                JSONObject jObject = (JSONObject) jsonItems.get(i);
                BookItem bookItem = new BookItem();
                bookItem.setKind(jsonObject.getString("kind"));
                VolumeInfo volumeInfo = new VolumeInfo();
                JSONObject volumeInfoObject = (JSONObject) jObject.get("volumeInfo");
                volumeInfo.setTitle(volumeInfoObject.getString("title"));
                bookItem.setVolumeInfo(volumeInfo);
                JSONObject imageLinksObject = (JSONObject) volumeInfoObject.get("imageLinks");
                String bitmapUrl = imageLinksObject.getString("thumbnail");
                try{
                    URL imageUrl = new URL(bitmapUrl);
                    try(InputStream inputStream = imageUrl.openConnection().getInputStream()){
                        Bitmap bitmapImage = BitmapFactory.decodeStream(inputStream);
                        bookItem.setBitmapImage(bitmapImage);
                    }catch(Exception e){
                        Log.i("PIC URL EXC", e.getMessage());
                    }
                }catch (Exception e){
                    Log.i("PIC URL EXC", e.getMessage());
                }
                bookItemList.add(bookItem);
            }
            Book book = new Book();
            Integer totalItems = jsonObject.getInt("totalItems");
            book.setTotalItems(totalItems);
            book.setItems(bookItemList);
            return book;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }



}
