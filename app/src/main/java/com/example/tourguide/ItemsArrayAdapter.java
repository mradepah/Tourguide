package com.example.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemsArrayAdapter extends ArrayAdapter<Items> {


    public ItemsArrayAdapter(Context context, ArrayList<Items> items) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the listitems.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for 1 TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.listitems, parent, false);
        }

        Items currentItem = getItem(position);

        // Find the TextView  with the appropriate ID
        //Gets the getter element  from the item class and sets it to the appropriate text view
//
        ImageView itemCover = listViewItem.findViewById(R.id.itemCover);
        assert currentItem != null;
        itemCover.setImageResource(currentItem.getItemImage());
        TextView SongTextView = listViewItem.findViewById(R.id.itemDescription);
        SongTextView.setText(currentItem.getshortItemDescription());

        // Return the whole list items item layout (containing 1 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listViewItem;
    }
}
