package com.academy.finalacademy387.book.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.academy.finalacademy387.book.BookActivity;

import androidx.annotation.Nullable;


public class AsyncTaskExecutor extends AsyncTask<Void, Boolean , Boolean> {


    private Activity activity;
    private  AsyncDataLoader asyncDataLoader;
    private ProgressDialog progressDialog;
    private StringBuffer error = new StringBuffer();

    public AsyncTaskExecutor(AsyncDataLoader dataLoader, Activity bookActivity) {
        this.asyncDataLoader = dataLoader;
        this.activity = bookActivity;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle("Data loading");
        progressDialog.setMessage("Please wait. We are loading data");
        progressDialog.show();
    }

    //EXECUTION -> background thread execution
    @Override
    protected Boolean doInBackground(Void... voids) {
        if(false){
            error.append("Site is unreachable");
            return false;
        }else{
            asyncDataLoader.asyncDataLoad();
            return true;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if(result){
            asyncDataLoader.onPostAsyncDataLoad();
        }else{
            if(error.length()>0){
                asyncDataLoader.onPostAsyncErrorLoad(error.toString());
            }
        }
        progressDialog.dismiss();
    }
}
