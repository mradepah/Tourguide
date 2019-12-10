package com.example.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.food_layout, container, false);
        //        create an array list and add custom details to it
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(R.drawable.jollof, getResources().getString(R.string.jollof), getResources().getString(R.string.jollofdetails)));
        items.add(new Items(R.drawable.ampesi, getResources().getString(R.string.ampesi), getResources().getString(R.string.jollofdetails)));
        items.add(new Items(R.drawable.kenkey, getResources().getString(R.string.kenkeyandfish), getResources().getString(R.string.jollofdetails)));
        items.add(new Items(R.drawable.plantain, getResources().getString(R.string.boiledplantain), getResources().getString(R.string.jollofdetails)));
        items.add(new Items(R.drawable.waakye, getResources().getString(R.string.waakye), getResources().getString(R.string.jollofdetails)));
        items.add(new Items(R.drawable.banku, getResources().getString(R.string.bankuandtilapia), getResources().getString(R.string.jollofdetails)));
        items.add(new Items(R.drawable.riceandbeans, getResources().getString(R.string.riceandbeans), getResources().getString(R.string.jollofdetails)));

        // gets the listview and populates it with the items array adapter we created earlier
        ListView listView = view.findViewById(R.id.foodListContents);
        ItemsArrayAdapter itemsAdapter = new ItemsArrayAdapter(getContext(), items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//          when an item is clicked all the indicated attributes of the item clicked
//              are passed to a new item details intent
                Items foodItem = (Items) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), ItemsDetails.class);
                intent.putExtra(getResources().getString(R.string.intentshort), foodItem.getshortItemDescription());
                intent.putExtra(getResources().getString(R.string.intentlong), foodItem.getlongItemDescription());
                intent.putExtra(getResources().getString(R.string.intentsimage), foodItem.getItemImage());

                startActivity(intent);
            }
        });

        return view;
    }
}
