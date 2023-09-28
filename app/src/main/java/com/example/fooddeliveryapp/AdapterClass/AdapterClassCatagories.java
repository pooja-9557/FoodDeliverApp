package com.example.fooddeliveryapp.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.Model.ModelCatagory;
import com.example.fooddeliveryapp.R;

import java.util.ArrayList;

public class AdapterClassCatagories extends RecyclerView.Adapter<AdapterClassCatagories.ViewHolder> {
    ArrayList<ModelCatagory> list;
    Context context;
    public AdapterClassCatagories(Context dashBoardActivity, ArrayList<ModelCatagory> list) {
        this.context=dashBoardActivity;
        this.list= list;
    }

    @NonNull
    @Override
    public AdapterClassCatagories.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClassCatagories.ViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.text.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image);
            text= itemView.findViewById(R.id.text);
        }
    }
}
