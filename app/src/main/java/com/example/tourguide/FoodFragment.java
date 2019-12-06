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
        items.add(new Items(R.drawable.jollof, "JOLLOF", "Ghanaian jollof rice is made of vegetable oil, onion, bell pepper, cloves of pressed garlic, chillies, tomato paste, beef or goat meat or chicken (some times alternated with mixed vegetables), jasmine or basmati rice and black pepper.[11] The method of cooking jollof begins with first preparing the beef or chicken by seasoning and frying it until it is well-cooked[11] The rest of the ingredients are then fried all together, starting from onions, tomatoes and spices in that order. After all the ingredients have been fried, rice is then added and cooked until the meal is prepared."));
        items.add(new Items(R.drawable.ampesi, "AMPESI", "enkey or kormi or kokoe or dorkunu is a staple dish similar to sourdough dumpling from the Ga-inhabited regions of West Africa, usually served with pepper sauce and fried fish or soup, stew. Areas where kenkey is eaten are Ghana,"));
        items.add(new Items(R.drawable.kenkey, "KENKEY AND FISH", "kenkey or kormi or kokoe or dorkunu is a staple dish similar to sourdough dumpling from the Ga-inhabited regions of West Africa, usually served with pepper sauce and fried fish or soup, stew. Areas where kenkey is eaten are Ghana,"));
        items.add(new Items(R.drawable.plantain, "BOILED PLANTAIN", "enkey or kormi or kokoe or dorkunu is a staple dish similar to sourdough dumpling from the Ga-inhabited regions of West Africa, usually served with pepper sauce and fried fish or soup, stew. Areas where kenkey is eaten are Ghana,"));
        items.add(new Items(R.drawable.waakye, "WAAKYE", "Kenkey or kormi or kokoe or dorkunu is a staple dish similar to sourdough dumpling from the Ga-inhabited regions of West Africa, usually served with pepper sauce and fried fish or soup, stew. Areas where kenkey is eaten are Ghana,"));
        items.add(new Items(R.drawable.banku, "BANKU AND TILAPIA", "Banku is a Ghanaian dish which is cooked by a proportionate mixture of fermented corn and cassava dough in hot water into a smooth, whitish paste,[1][2] served with soup, stew or a pepper sauce with fish.[3] It is mostly preferred by the people of the Southern Regions of Ghana; the Ewe tribe of the Volta Region, the Fante and the Ga tribe but also eaten across the other regions in Ghana. Banku is found throughout Ghana, and is one of the staple foods enjoyed by all tribes in the country"));
        items.add(new Items(R.drawable.riceandbeans, " RICE AND BEANS ", "Kenkey or kormi or kokoe or dorkunu is a staple dish similar to sourdough dumpling from the Ga-inhabited regions of West Africa, usually served with pepper sauce and fried fish or soup, stew. Areas where kenkey is eaten are Ghana,"));

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
                intent.putExtra("shortDescription", foodItem.getshortItemDescription());
                intent.putExtra("longDescription", foodItem.getlongItemDescription());
                intent.putExtra("imageDescription", foodItem.getItemImage());


                startActivity(intent);
            }
        });

        return view;
    }
}
