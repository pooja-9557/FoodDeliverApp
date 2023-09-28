package com.example.fooddeliveryapp.AdapterClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.Activity.CartFoodActivity;
import com.example.fooddeliveryapp.Model.ModelPopular;
import com.example.fooddeliveryapp.R;

import java.util.ArrayList;

public class AdapterClassPopular extends RecyclerView.Adapter<AdapterClassPopular.ViewHolder> {
    ArrayList<ModelPopular> list;
    Context context;
    public AdapterClassPopular(Context context, ArrayList<ModelPopular> list) {
        this.context=context;
        this.list= list;
    }

    @NonNull
    @Override
    public AdapterClassPopular.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_layout, parent, false);
       return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.image.setImageResource(list.get(position).getImage());
        holder.text.setText(list.get(position).getName());
        holder.money.setText(String.valueOf(list.get(position).getNo()));
// Set OnClickListener for the button
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();
                Intent intent = new Intent(context, CartFoodActivity.class);
                intent.putExtra("position",clickedPosition);
                if(view.getContext()!= null)
                {
                    view.getContext().startActivity(intent);
                }
                else {
                    Toast.makeText(view.getContext(), "Context is not finding",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text, money;
        Button add;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image);
            text= itemView.findViewById(R.id.name);
            money=itemView.findViewById(R.id.money);
            add= itemView.findViewById(R.id.add_cart);
        }
    }
}

