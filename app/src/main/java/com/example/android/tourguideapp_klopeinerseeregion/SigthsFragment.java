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
public class SigthsFragment extends Fragment {

    /** Using to show the item on the map */
    private String location;

    public SigthsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items_list, container, false);

        // Create a list of items
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.caves_title, R.string.cave_description, R.string.caves_location, R.drawable.obir_cave));
        items.add(new Item(R.string.waterfall_title, R.string.waterfall_description, R.string.waterfall_location, R.drawable.waterfall));
        items.add(new Item(R.string.troegerner_titel, R.string.troegerner_description, R.string.troegerner_location, R.drawable.troegernerklamm));
        items.add(new Item(R.string.tscheppa_title, R.string.tscheppa_description, R.string.tscheppa_location, R.drawable.tscheppaschlucht));
        items.add(new Item(R.string.petzen_title, R.string.petzen_description, R.string.petzen_location, R.drawable.petzen));

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
