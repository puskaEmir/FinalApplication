package com.academy.finalacademy387.book.adapter;

public interface AsyncDataLoader {

    /**
     * U background(u drugoj programskoj niti)
     */
    void asyncDataLoad();


    /**
     * dobiti podatke nakon što završi asyncDataLoad()
     */
    void onPostAsyncDataLoad();

    /**
     * dobiti error poruku nakon što završi asyncDataLoad() ako web servis odgovori sa errorom
     *
     * @param errorMessage
     */
    void onPostAsyncErrorLoad(String errorMessage);
}
