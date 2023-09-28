package com.example.fooddeliveryapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddeliveryapp.AdapterClass.AdapterClassForCartShow;
import com.example.fooddeliveryapp.HelperClass.DbHelper;
import com.example.fooddeliveryapp.Model.ModelCartShow;
import com.example.fooddeliveryapp.databinding.ActivityShowCartDetailBinding;

import java.util.ArrayList;

public class ShowCartDetailActivity extends AppCompatActivity {
    ActivityShowCartDetailBinding binding;
    ArrayList<ModelCartShow> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowCartDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DbHelper helper = new DbHelper(this);
        arrayList = helper.FetchData();
        int total = 0;
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                total = total + arrayList.get(i).getTotal();

            }
        }
        binding.totalmoney.setText(String.valueOf(total));
        int Total_Order = total + 12;
        binding.total.setText(String.valueOf(Total_Order));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);

        AdapterClassForCartShow adapterClassForCartShow = new AdapterClassForCartShow(arrayList, getApplicationContext());
        binding.recyclerView.setAdapter(adapterClassForCartShow);
    }
}