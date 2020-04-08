package com.blobart.objectlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupInventoryList();
    }

    private void setupInventoryList() {

        List<Inventory> inventory_list = new ArrayList<Inventory>();
        inventory_list.add(new Inventory("JCA", "Inventory item 1", 1, 12));
        inventory_list.add(new Inventory("LHC", "Inventory item 2", 2, 80));
        inventory_list.add(new Inventory("LSK", "Inventory item 3", 3, 0));
        inventory_list.add(new Inventory("LLP", "Inventory item 4", 4, 50));
        inventory_list.add(new Inventory("CBH", "Inventory item 5", 5, 0));

        InventoryAdapter inventory_adapter = new InventoryAdapter(MainActivity.this, inventory_list);

        ListView inventory_list_view = (ListView) findViewById(R.id.inventory_view);

        //adapters can format the array to a list
        inventory_list_view.setAdapter(inventory_adapter);

        // handle onItemClick here

    }
}
