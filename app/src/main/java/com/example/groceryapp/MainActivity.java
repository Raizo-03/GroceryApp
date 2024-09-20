package com.example.groceryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    //1 - AdapterView : Recycler View
    RecyclerView recyclerView;

    //2- DataSource - List
    List<Item> itemList;

    //- Custom Adapter
    MyCustomAdapter adapter = new MyCustomAdapter(itemList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView imageView = findViewById(R.id.image_header);


        recyclerView = findViewById(R.id.recycler_view);
        itemList = new ArrayList<>();
        Item fruit = new Item(R.drawable.fruit, "Fruits", "Fresh fruits from the garden");
        Item vegetables = new Item(R.drawable.vegetables, "Vegetables", "Delicious vegetables");
        Item wheat_products = new Item(R.drawable.bread, "Wheat Products", "Oats, Bread, and Beans");
        Item beverages = new Item(R.drawable.beverage, "Beverages", "Juice, Tea, Coffee, and Soda");
        Item milk = new Item(R.drawable.milk, "Milk", "Milks Shake and Yogurts");
        Item snacks = new Item(R.drawable.popcorn, "Snacks", "Popcorn, Donuts, and Chips");

        itemList.add(fruit);
        itemList.add(vegetables);
        itemList.add(wheat_products);
        itemList.add(beverages);
        itemList.add(milk);
        itemList.add(snacks);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adapter.setClickListener(this);


        adapter = new MyCustomAdapter(itemList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(
                this,
                "You Chose " + itemList.get(position).getItemName(),
                Toast.LENGTH_SHORT).show();
    }
}