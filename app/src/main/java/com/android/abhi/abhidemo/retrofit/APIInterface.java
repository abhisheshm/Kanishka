package com.android.abhi.abhidemo.retrofit;

import android.telecom.Call;

import com.android.abhi.abhidemo.retrofit.model.ItemModel;

import java.util.ArrayList;

import retrofit2.http.GET;

public interface APIInterface {

    @GET("/android_data_json")
    retrofit2.Call<ArrayList<ItemModel>> getitem();

}
