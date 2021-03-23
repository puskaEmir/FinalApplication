package com.academy.finalacademy387.book.controller;

public class ServiceUrl {

    //https://www.googleapis.com/books/v1/volumes?q=james&maxResults=10
    public static String getBookListUrl(int maxResult){
        StringBuilder sb = new StringBuilder();
        sb.append("https://www.googleapis.com/books/v1/volumes?q=james&maxResults=");
        sb.append(maxResult);
        return sb.toString();
    }
}
