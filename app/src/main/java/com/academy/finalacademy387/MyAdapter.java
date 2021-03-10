package com.academy.finalacademy387;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.academy.finalacademy387.bmi.BmiActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 1. row.xml
 * 2. RowModel
 * 3. MyViewHolder kojeg ćemo integrisati sa RecyclerView.Adapter
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final Context context;
    private final List<RowModel> rowModelList;

    public MyAdapter(Context context, List<RowModel> rowModels){
        this.context = context;
        this.rowModelList = rowModels;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        CardView cardView = view.findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RowModel model = rowModelList.iterator().next();
                if(model.getTitle().equals("BMI calculator")){
                    Log.i("INSIDE activity startup", "mskdksmdks");
                    Intent intent = new Intent(context, BmiActivity.class);
                    context.startActivity(intent);
                }else if(model.getTitle().equals("Calculator")){

                }
            }
        });
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.getTitleTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RowModel model = rowModelList.iterator().next();
                if(model.getTitle().equals("BMI calculator")){
                    Log.i("INSIDE activity startup", "mskdksmdks");
                    Intent intent = new Intent(context, BmiActivity.class);
                    context.startActivity(intent);
                }else if(model.getTitle().equals("Calculator")){

                }
            }
        });
        myViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Log.i("EXECUTE_TAG", "ULAZI---------.......");
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //podatak koji nosi neki Java objekat
        Log.i("BIND_VIEW", "BindViewHolder------------.......");
        RowModel rowModel = rowModelList.get(position);
        //setovati u ViewHolder
        holder.setTitleText(rowModel.getTitle());
        holder.setDescriptionText(rowModel.getDescription());
        holder.setImageViewResourceId(rowModel.getImageResourceId());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Log.i("EXECUTE_TAG", "ULAZI---------.......");
                RowModel model = rowModelList.get(position);
                if(model.getTitle().equals("BMI calculator")){
                    Log.i("INSIDE activity startup", "mskdksmdks");
                    Intent intent = new Intent(context, BmiActivity.class);
                    context.startActivity(intent);
                }else if(model.getTitle().equals("Calculator")){

                }
            }
        });
    }

    //new  ...   ->     ::
    private void onItemListen(View view, int position){
        RowModel model = rowModelList.get(position);
        if(model.getTitle().equals("BMI calculator")){
            Intent intent = new Intent(context, BmiActivity.class);
            context.startActivity(intent);
        }else if(model.getTitle().equals("Calculator")){

        }
    }

    @Override
    public int getItemCount() {
        return rowModelList.size();
    }
}
