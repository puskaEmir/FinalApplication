package com.academy.finalacademy387.book.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class UrlGetConnector {


    private String webServiceUrl;

    public UrlGetConnector(String url) {
        this.webServiceUrl = url;
    }

    public String getHttpsResponse(){
        try{
            URL url = new URL(webServiceUrl);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setHostnameVerifier((hostName, session)->true);
            httpsURLConnection.setRequestMethod("GET"); //GET, POST, PUT, HEAD; OPTIONS
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.connect();
            //ERRROR
            InputStream errorStream = httpsURLConnection.getErrorStream();
            StringBuffer buffer = new StringBuffer();// THREAD SAFE verziju StringBuilder
            if(errorStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String inputLine;
                while((inputLine = reader.readLine())!=null){
                    buffer.append(inputLine);
                }
                reader.close();
                httpsURLConnection.disconnect();
                return buffer.toString();
            }
            //DATA
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            StringBuffer dataBuffer = new StringBuffer();
            String dataLine;
            while((dataLine = reader.readLine())!=null){
                dataBuffer.append(dataLine);
            }
            return dataBuffer.toString();
        }catch (Exception exception){
            throw new RuntimeException(exception);
        }
    }
}
