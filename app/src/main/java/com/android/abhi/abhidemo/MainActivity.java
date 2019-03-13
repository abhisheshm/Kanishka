package com.android.abhi.abhidemo;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.abhi.abhidemo.retrofit.APIClient;
import com.android.abhi.abhidemo.retrofit.APIInterface;
import com.android.abhi.abhidemo.retrofit.model.ItemModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_view;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        getSupportActionBar().hide();
        bindView();
    }

    public void bindView() {
        recycler_view = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layoutManager);
        callApi();
    }

    public void callApi() {

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<ItemModel>> call = apiInterface.getitem();
        call.enqueue(new Callback<ArrayList<ItemModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ItemModel>> call, Response<ArrayList<ItemModel>> response) {
                ArrayList<ItemModel> itemModel = response.body();
                Adapter adapter = new Adapter(itemModel, context);
                recycler_view.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<ItemModel>> call, Throwable t) {
                H.L("Failed");
            }
        });

    }


}
