package com.example.fooddeliveryapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fooddeliveryapp.HelperClass.DbHelper;
import com.example.fooddeliveryapp.Model.ModelCartShow;
import com.example.fooddeliveryapp.Model.ModelCartView;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.databinding.ActivityCartFoodBinding;

import java.util.ArrayList;

public class CartFoodActivity extends AppCompatActivity {
    ActivityCartFoodBinding binding;
    ArrayList<ModelCartView> model= new ArrayList<>();
    ArrayList<ModelCartShow> arrayList=new ArrayList<>();
    int total=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityCartFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int position= getIntent().getIntExtra("position",0);
        //Add in cart
        model.add(new ModelCartView("Margherita Pizza", 150, R.drawable.margherita_pizza,R.string.Margherita_Pizza));
        model.add(new ModelCartView("Cheese Pizza",200,R.drawable.cheese_pizza,R.string.cheese_pizza));
        model.add(new ModelCartView("Burger Cheese", 100,R.drawable.burger_cheese,R.string.burger_cheese));
        model.add(new ModelCartView("Black Forest Cake",300,R.drawable.blackforest,R.string.Black_Forest));

        binding.name.setText(model.get(position).getName());
        binding.money.setText(String.valueOf(model.get(position).getMoney()));
        binding.imageView.setImageResource(model.get(position).getImage());
        binding.description.setText(model.get(position).getDescription());
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total++;
                binding.showTotal.setText(String.valueOf(total));
            }
        });
        binding.substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(total>1)
                {
                    total--;
                    binding.showTotal.setText(String.valueOf(total));
                }

            }
        });
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper helper= new DbHelper(getApplicationContext());
                String name= model.get(position).getName();
                int money= model.get(position).getMoney();
                int image= model.get(position).getImage();
                int value= total;
                int sum=money*value;
                arrayList= helper.FetchUnique(name);
                if(arrayList.size()!=0)
                {
                    int new_no= arrayList.get(0).getNo()+value;
                    int new_sum= arrayList.get(0).getTotal()+sum;
                    helper.DataUpdate(name,money,new_no,image,new_sum);
                }
                else
                {
                    helper.InsertData(name,money,value,image,sum);
                }
                Toast.makeText(CartFoodActivity.this, "Successfully added in Cart", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),DashBoardActivity.class));
            }
        });
    }
}