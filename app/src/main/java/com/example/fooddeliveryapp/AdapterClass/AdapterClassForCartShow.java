package com.example.fooddeliveryapp.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.Model.ModelCartShow;
import com.example.fooddeliveryapp.R;

import java.util.ArrayList;

public class AdapterClassForCartShow extends RecyclerView.Adapter<AdapterClassForCartShow.ViewHolder> {
    ArrayList<ModelCartShow> arrayList;
    Context context;

    public AdapterClassForCartShow(ArrayList<ModelCartShow> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterClassForCartShow.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.details_of_cart, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClassForCartShow.ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.money.setText("" + arrayList.get(position).getMoney());
        holder.cart.setText("" + arrayList.get(position).getNo());
        holder.image.setImageResource(arrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, money, cart;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            money = itemView.findViewById(R.id.money);
            cart = itemView.findViewById(R.id.cart);
            image = itemView.findViewById(R.id.image);

        }
    }
}
