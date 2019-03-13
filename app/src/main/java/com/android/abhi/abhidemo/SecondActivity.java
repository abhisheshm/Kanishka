package com.android.abhi.abhidemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.abhi.abhidemo.retrofit.model.ItemModel;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private TextView item_name, item_place;
    private static String mName, mTag, mcolor;
    private static ArrayList<ItemModel.Criterium> mList;
    public Context context;


    public static void open(Context context, String name, String tag,
                            ArrayList<ItemModel.Criterium> list, String color) {
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
        mName = name;
        mTag = tag;
        mList = list;
        mcolor = color;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context= SecondActivity.this;
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();
        bindView();
    }

    public void bindView() {
        item_name = findViewById(R.id.item_name);
        item_place = findViewById(R.id.item_place);
        RecyclerView recyclerView = findViewById(R.id.item_rcview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AdapterItem adapterItem = new AdapterItem(mList,mName,context);
        recyclerView.setAdapter(adapterItem);
        setTextvalue();


    }

    public void setTextvalue() {
        item_name.setText(mName);

        if (mcolor.equals("red")) {
            item_place.setTextColor(Color.parseColor("#E60B0B"));
            item_place.setText(mTag);

        } else if (mcolor.equals("Yellow")) {
            item_place.setTextColor(Color.parseColor("#FFFFEB3B"));
            item_place.setText(mTag);

        } else if (mcolor.equals("green")) {
            item_place.setTextColor(Color.parseColor("#FF4CAF50"));
            item_place.setText(mTag);

        }
    }

}
