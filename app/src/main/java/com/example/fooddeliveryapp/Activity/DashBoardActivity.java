package com.example.fooddeliveryapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fooddeliveryapp.AdapterClass.AdapterClassCatagories;
import com.example.fooddeliveryapp.AdapterClass.AdapterClassPopular;
import com.example.fooddeliveryapp.Model.ModelCatagory;
import com.example.fooddeliveryapp.Model.ModelPopular;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddeliveryapp.databinding.ActivityDashBoardBinding;

import com.example.fooddeliveryapp.R;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {
    private ActivityDashBoardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<ModelCatagory> list= new ArrayList<>();
        list.add(new ModelCatagory(R.drawable.margherita_pizza,"Pizza"));
        list.add(new ModelCatagory(R.drawable.burger_cheese,"Burger"));
        list.add(new ModelCatagory(R.drawable.cocktail,"Drink"));
        list.add(new ModelCatagory(R.drawable.blackforest,"Cake"));
        list.add(new ModelCatagory(R.drawable.sweet,"Sweet"));

        AdapterClassCatagories adapterClassCatagories= new AdapterClassCatagories(getApplicationContext(),list);
        binding.recycler.setAdapter(adapterClassCatagories);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recycler.setLayoutManager(layoutManager);

        ArrayList<ModelPopular> array= new ArrayList<>();
        array.add(new ModelPopular("Margherita Pizza",R.drawable.peparoni,150));
        array.add(new ModelPopular("Cheese Pizza",R.drawable.cheese_pizza,200));
        array.add(new ModelPopular("Burger Cheese",R.drawable.burger_cheese,100));
        array.add(new ModelPopular("Black Forest Cake",R.drawable.blackforest,300));


        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recycler2.setLayoutManager(layoutManager2);
        AdapterClassPopular adapterClassPopular= new AdapterClassPopular(getApplicationContext(),array);
        binding.recycler2.setAdapter(adapterClassPopular);

        binding.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ShowCartDetailActivity.class));
            }
        });

    }
}