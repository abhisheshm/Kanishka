package com.android.abhi.abhidemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.abhi.abhidemo.retrofit.model.ItemModel;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private Context context;
    public static String From, mDvalue, mStudytype;
    public static ArrayList<Integer> mValues;
    public static ArrayList<Float> mValue;

    public static void open(Context context, ArrayList<Integer> values, String from) {
        Intent intent = new Intent(context, ThirdActivity.class);
        context.startActivity(intent);
        mValues = values;
        From = from;
    }

    public static void open1(Context context, ArrayList<Float> value, String from) {
        Intent intent = new Intent(context, ThirdActivity.class);
        context.startActivity(intent);
        mValue = value;
        From = from;
    }

    public static void open2(Context context, String dvalue, String from, String studytype) {
        Intent intent = new Intent(context, ThirdActivity.class);
        context.startActivity(intent);
        mDvalue = dvalue;
        From = from;
        mStudytype = studytype;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = ThirdActivity.this;
        setContentView(R.layout.activity_third);
        getSupportActionBar().hide();
        bindView();
    }

    public void bindView() {
        EditText edit_text = findViewById(R.id.edit_text);
        TextView tag_tv = findViewById(R.id.tag_tv);
        RelativeLayout rl_view = findViewById(R.id.rl_view);
        RecyclerView recyclerView = findViewById(R.id.item_rcview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        if (From.equals("value")) {
            tag_tv.setText(mStudytype.toUpperCase());
            edit_text.setText(mDvalue);
            recyclerView.setVisibility(View.GONE);
            rl_view.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            rl_view.setVisibility(View.GONE);
            AdapterThird adapterItem = new AdapterThird(mValues, context, From, mValue);
            recyclerView.setAdapter(adapterItem);
        }

    }
}
