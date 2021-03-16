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
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //RowModel -> instancu koja nosi podatke
        RowModel rowModel = rowModelList.get(position);
        //ViewHolder -> prikazati podatke
        holder.setTitleText(rowModel.getTitle());
        holder.setDescriptionText(rowModel.getDescription());
        holder.setImageViewResourceId(rowModel.getImageResourceId());
        //holder instancom -> instancnu metodu ili funkciju
        //1.7 Anonymous inner type  LAMBDA mijenja NEW
        // Kada LAMBDA ne radi ništa drugo nego samo poziva neku funkciju  ::
        //ItemClickListener itemClickListener = this::onItemListen;
        holder.setItemClickListener(this::onItemListen);
    }


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
