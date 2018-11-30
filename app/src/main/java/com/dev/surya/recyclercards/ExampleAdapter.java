package com.dev.surya.recyclercards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

        private ArrayList<ExampleItem> mExampleList;

    //1
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        //4
        public ImageView imageView;
        public TextView textView;

        //2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            //4.1
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    //6
    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        this.mExampleList = exampleList;
    }

    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //5
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup,false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        //7
        ExampleItem currentItem = mExampleList.get(i);
        exampleViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        exampleViewHolder.textView.setText(currentItem.getmTest());
    }

    @Override
    public int getItemCount() {
        //8
        return mExampleList.size();
    }


}
