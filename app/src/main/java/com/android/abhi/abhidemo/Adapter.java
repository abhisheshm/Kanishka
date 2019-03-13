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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<ItemModel> list;
    private Context context;

    Adapter(ArrayList<ItemModel> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final ItemModel itemModel = list.get(i);
        viewHolder.item_name.setText(itemModel.name);
        if (itemModel.color.equals("red")) {
            viewHolder.item_place.setTextColor(Color.parseColor("#E60B0B"));
            viewHolder.item_place.setText(itemModel.tag);

        } else if (itemModel.color.equals("Yellow")) {
            viewHolder.item_place.setTextColor(Color.parseColor("#FFFFEB3B"));
            viewHolder.item_place.setText(itemModel.tag);

        } else if (itemModel.color.equals("green")) {
            viewHolder.item_place.setTextColor(Color.parseColor("#FF4CAF50"));
            viewHolder.item_place.setText(itemModel.tag);

        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.open(context, itemModel.name, itemModel.tag, itemModel.criteria, itemModel.color);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item_name, item_place;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_place = itemView.findViewById(R.id.item_place);
        }
    }

}
