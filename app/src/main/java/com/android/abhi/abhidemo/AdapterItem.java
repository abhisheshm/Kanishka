package com.android.abhi.abhidemo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.abhi.abhidemo.retrofit.model.ItemModel;
import com.klinker.android.link_builder.Link;
import com.klinker.android.link_builder.LinkBuilder;

import java.util.ArrayList;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ViewHolder> {

    private ArrayList<ItemModel.Criterium> list;
    private String name;
    private Context context;

    AdapterItem(ArrayList<ItemModel.Criterium> list, String name, Context context) {

        this.list = list;
        this.name = name;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_second, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ItemModel.Criterium itemModel = list.get(i);

        if (name.equals("Apple")) {
            viewHolder.text.setText(itemModel.text);

        } else if (name.equals("Mango")) {
            viewHolder.text.setText(itemModel.text + "\n" + "\n" + "and ");

        } else if (name.equals("Pomegranate")) {
            String textpo = itemModel.text.replace("$17",
                    "(" + String.valueOf(itemModel.variable.$17.values.get(0)) + ")");
            SpannableString ss = new SpannableString(textpo);
            ClickableSpan span1 = new ClickableSpan() {
                @Override
                public void onClick(View textView) {

                    ThirdActivity.open(context, itemModel.variable.$17.values, "integer");
                }
            };


            ss.setSpan(span1, 43, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.text.setText(ss);
            viewHolder.text.setMovementMethod(LinkMovementMethod.getInstance());


        } else if (name.equals("Watermelon")) {
            String text2 = itemModel.text.replace
                    ("$2",
                            "(" + String.valueOf(itemModel.variable.$2.values.get(0)) + ")");
            String first = text2.replace("$1",
                    "(" + String.valueOf(itemModel.variable.$1.defaultValue)) + ")";
            viewHolder.text.setText(Html.fromHtml(first));

            SpannableString ss = new SpannableString(first);
            ClickableSpan span1 = new ClickableSpan() {
                @Override
                public void onClick(View textView) {

                    ThirdActivity.open(context, itemModel.variable.$2.values, "integer");

                }
            };
            ClickableSpan span = new ClickableSpan() {
                @Override
                public void onClick(View textView) {
                    ThirdActivity.open2(context, String.valueOf(itemModel.variable.$1.defaultValue)
                            , "value", String.valueOf(itemModel.variable.$1.studyType));

                }
            };

            ss.setSpan(span1, 43, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(span, 70, 74, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            viewHolder.text.setText(ss);
            viewHolder.text.setMovementMethod(LinkMovementMethod.getInstance());

        } else if (name.equals("Banana")) {

            if (itemModel.text.contains("$1")) {
                String textp = itemModel.text.replace("$1",
                        "(" + String.valueOf(itemModel.variable.$1.values
                                .get(0) + ")"));

                SpannableString ss = new SpannableString(textp + "\n" + "\n" + "and");
                ClickableSpan span1 = new ClickableSpan() {
                    @Override
                    public void onClick(View textView) {
                        ThirdActivity.open(context, itemModel.variable.$1.values, "integer");

                    }
                };
                ss.setSpan(span1, 51, 56, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                viewHolder.text.setText(ss);
                viewHolder.text.setMovementMethod(LinkMovementMethod.getInstance());


            } else if (itemModel.text.contains("$2")) {
                String text2 = itemModel.text.replace("$2", "(" +
                        String.valueOf(itemModel.variable.$2.values.get(0) + ")"));

                String first = text2.replace("$3",
                        "(" + String.valueOf(itemModel.variable.$3.values.get(0) + ")"));


                SpannableString ss = new SpannableString(first + "\n" + "\n" + "and");
                ClickableSpan span1 = new ClickableSpan() {
                    @Override
                    public void onClick(View textView) {
                        ThirdActivity.open(context, itemModel.variable.$2.values, "integer");


                    }
                };
                ClickableSpan span = new ClickableSpan() {
                    @Override
                    public void onClick(View textView) {
                        ThirdActivity.open1(context, itemModel.variable.$3.values, "float");

                    }
                };

                ss.setSpan(span1, 51, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ss.setSpan(span, 84, 89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                viewHolder.text.setText(ss);
                viewHolder.text.setMovementMethod(LinkMovementMethod.getInstance());

            } else if (itemModel.text.contains("$4")) {

                String first = itemModel.text.replace("$4",
                        "(" + String.valueOf(itemModel.variable.$4.defaultValue) + ")");
                SpannableString content = new SpannableString(first);
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);

                SpannableString ss = new SpannableString(first);
                ClickableSpan span1 = new ClickableSpan() {
                    @Override
                    public void onClick(View textView) {
                        ThirdActivity.open2(context, String.valueOf(itemModel.variable.$4.defaultValue)
                                , "value", String.valueOf(itemModel.variable.$4.studyType));

                    }
                };

                ss.setSpan(span1, 40, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                viewHolder.text.setText(ss);
                viewHolder.text.setMovementMethod(LinkMovementMethod.getInstance());

            }

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
        }
    }

}
