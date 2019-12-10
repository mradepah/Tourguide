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
public class PlacesFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.places_layout, container, false);

//        create an array list and add custom details to it
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(R.drawable.kwamenkrumahmemorial, getResources().getString(R.string.jollof), getResources().getString(R.string.jollof)));
        items.add(new Items(R.drawable.blackstargate, getResources().getString(R.string.jollof), getResources().getString(R.string.jollof)));
        items.add(new Items(R.drawable.osucastle, getResources().getString(R.string.jollof), getResources().getString(R.string.jollof)));
        items.add(new Items(R.drawable.elmina, getResources().getString(R.string.jollof), getResources().getString(R.string.jollof)));
        items.add(new Items(R.drawable.capecoast, getResources().getString(R.string.jollof), getResources().getString(R.string.jollof)));
        items.add(new Items(R.drawable.lakebosomtwi, getResources().getString(R.string.jollof), getResources().getString(R.string.jollof)));
        items.add(new Items(R.drawable.tonggo, getResources().getString(R.string.jollof), getResources().getString(R.string.jollof)));
        items.add(new Items(R.drawable.larabangamosque, getResources().getString(R.string.jollof), getResources().getString(R.string.jollof)));

// gets the listview and populates it with the items array adapter we created earlier
        ListView listView = view.findViewById(R.id.placesListContents);
        ItemsArrayAdapter itemsAdapter = new ItemsArrayAdapter(getContext(), items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                when an item is clicked all the indicated attributes of the item clicked
//                are passed to a new item details intent
                Items placeItem = (Items) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), ItemsDetails.class);
                intent.putExtra(getResources().getString(R.string.intentshort), placeItem.getshortItemDescription());
                intent.putExtra(getResources().getString(R.string.intentlong), placeItem.getlongItemDescription());
                intent.putExtra(getResources().getString(R.string.intentsimage), placeItem.getItemImage());


                startActivity(intent);
            }
        });

        return view;
    }
}