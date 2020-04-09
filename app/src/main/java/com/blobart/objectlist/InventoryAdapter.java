package com.blobart.objectlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class InventoryAdapter extends BaseAdapter implements ListAdapter {

    private List<Inventory> inventory_adapter_list;
    private Context context;

    public InventoryAdapter(Context context, List<Inventory> inventory_adapter_list) {
        // You could also make this adapter get the list itself if in a db or something
        // This we pass it through the constructor because we hardcoded a 5-element list
        this.inventory_adapter_list = inventory_adapter_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return inventory_adapter_list.size();
    }

    @Override
    public Object getItem(int position) {
        return inventory_adapter_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // needed for onclick
        return inventory_adapter_list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // just do this...the inventory_list_item.xml is in fact al layout that needs to be instantiated
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Getting the XML layout in...
        assert inflater != null;
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.inventory_list_item_rel, null);

        //Get the inventory item you want to display
        Inventory inventory_item = inventory_adapter_list.get(position);

        TextView abbr_view = (TextView) view.findViewById(R.id.textview_abbreviation);
        abbr_view.setText(inventory_item.getAbbreviation());

        TextView descr_view = (TextView) view.findViewById(R.id.textview_decsription);
        descr_view.setText(inventory_item.getDescription());

        TextView quan_view = (TextView) view.findViewById(R.id.textview_quantity);
        quan_view.setText(context.getString(R.string.in_stock) + " " + String.valueOf(inventory_item.getStock()));

        ImageView iv = (ImageView) view.findViewById(R.id.imageview_icon);
        if (inventory_item.getStock() == 0){
            iv.setImageResource(R.mipmap.out_of_stock);
            quan_view.setTextColor(Color.RED);
        } else {
            iv.setImageResource(R.mipmap.in_stock);
            quan_view.setTextColor(Color.BLACK);
        }

        return view;
    }
}
