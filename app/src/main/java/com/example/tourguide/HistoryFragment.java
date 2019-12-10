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
public class HistoryFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_layout, container, false);
        //        create an array list and add custom details to it
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(R.drawable.independenceanniversary, getResources().getString(R.string.independence), getResources().getString(R.string.independencedetails)));
        items.add(new Items(R.drawable.ghanacedis, getResources().getString(R.string.ghanacedi), getResources().getString(R.string.ghanacedidetails)));
        items.add(new Items(R.drawable.adomibrigbe, getResources().getString(R.string.adomibridge), getResources().getString(R.string.adomibridgedetails)));
        items.add(new Items(R.drawable.ghanamap, getResources().getString(R.string.ghanamap), getResources().getString(R.string.ghanamapdetails)));

        // gets the listview and populates it with the items array adapter we created earlier
        ListView listView = view.findViewById(R.id.mainListContents);
        ItemsArrayAdapter itemsAdapter = new ItemsArrayAdapter(getContext(), items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//          when an item is clicked all the indicated attributes of the item clicked
//              are passed to a new item details intent
                Items historyItem = (Items) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), ItemsDetails.class);

                intent.putExtra(getResources().getString(R.string.intentshort), historyItem.getshortItemDescription());
                intent.putExtra(getResources().getString(R.string.intentlong), historyItem.getlongItemDescription());
                intent.putExtra(getResources().getString(R.string.intentsimage), historyItem.getItemImage());

                startActivity(intent);
            }
        });

        return view;
    }
}
