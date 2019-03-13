package com.android.abhi.abhidemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.abhi.abhidemo.retrofit.model.ItemModel;

import java.util.ArrayList;

public class AdapterThird extends RecyclerView.Adapter<AdapterThird.ViewHolder> {

    private ArrayList<Integer> list;
    private ArrayList<Float> list1;
    private Context context;
    private String From;

    public AdapterThird(ArrayList<Integer> list, Context context, String From, ArrayList<Float> list1) {

        this.list = list;
        this.context = context;
        this.From = From;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_third, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        if (From.equals("integer")) {
            Integer integer = list.get(i);
            viewHolder.text.setText(String.valueOf(integer));
        } else {
            Float aFloat = list1.get(i);
            viewHolder.text.setText(String.valueOf(aFloat));
        }


    }

    @Override
    public int getItemCount() {

        if (From.equals("integer")) {
            return list.size();

        } else {
            return list1.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);

        }
    }
}