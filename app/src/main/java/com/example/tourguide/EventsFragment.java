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
public class EventsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_layout, container, false);
        //        create an array list and add custom details to it
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(R.drawable.homowo, getResources().getString(R.string.homowo), getResources().getString(R.string.homowodetails)));
        items.add(new Items(R.drawable.chalewote, getResources().getString(R.string.charlewote), getResources().getString(R.string.charlewotedetails)));
        items.add(new Items(R.drawable.rapperholic, getResources().getString(R.string.rapperholic), getResources().getString(R.string.rapperholicdetails)));
        items.add(new Items(R.drawable.kwahu, getResources().getString(R.string.kwahu), getResources().getString(R.string.kwahudetails)));
        items.add(new Items(R.drawable.damba, getResources().getString(R.string.damba), getResources().getString(R.string.dambadetails)));

// gets the listview and populates it with the items array adapter we created earlier
        ListView listView = view.findViewById(R.id.eventsListContents);
        ItemsArrayAdapter itemsAdapter = new ItemsArrayAdapter(getContext(), items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//          when an item is clicked all the indicated attributes of the item clicked
//              are passed to a new item details intent
                Items eventItem = (Items) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), ItemsDetails.class);
                intent.putExtra(getResources().getString(R.string.intentshort), eventItem.getshortItemDescription());
                intent.putExtra(getResources().getString(R.string.intentlong), eventItem.getlongItemDescription());
                intent.putExtra(getResources().getString(R.string.intentsimage), eventItem.getItemImage());


                startActivity(intent);
            }
        });

        return view;
    }
}
