package com.example.android.tourguideapp_klopeinerseeregion;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    /** Using to show the item on the map */
    private String location;

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items_list, container, false);

        // Create a list of items
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.walderlebniswelt_title, R.string.walderlebniswelt_description, R.string.walderlebniswelt_location, R.drawable.walderlebniswelt));
        items.add(new Item(R.string.bird_park_titel, R.string.bird_park_description, R.string.bird_park_location, R.drawable.bird_park));
        items.add(new Item(R.string.boat_trip_title, R.string.boat_trip_description, R.string.boat_trip_location, R.drawable.boat_trip));
        items.add(new Item(R.string.sablatnigmoor_title, R.string.sablatnigmoor_description, R.string.sablatnigmoor_location, R.drawable.sablatnigmoor));
        items.add(new Item(R.string.expi_title, R.string.expi_description, R.string.expi_location, R.drawable.expi));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // fragment_items_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PagerAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to show the item's location on the map if the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Item} object at the given position the user clicked on
                Item item = items.get(position);
                // Get the current item's location
                location = getString(item.getLocationItem());
                // Create a new intent to call implicit intent map
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(location));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }
}
