package com.example.android.tourguideapp_klopeinerseeregion.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguideapp_klopeinerseeregion.model.Item;
import com.example.android.tourguideapp_klopeinerseeregion.model.ItemAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActiveFragment extends Fragment {

    /**
     * Using to show the item on the map
     */
    private String location;

    @BindView(R.id.rv_list)
    RecyclerView recyclerView;

    private Unbinder unbinder;

    public ActiveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items_list, container, false);

        unbinder = ButterKnife.bind(this, rootView);

        // Create a list of items
        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.string.mtb_title, R.string.mtb_description, R.string.mtb_location, R.drawable.mtb));
        items.add(new Item(R.string.cycling_title, R.string.cycling_description, R.string.cycling_location, R.drawable.cycling));
        items.add(new Item(R.string.hiking_titel, R.string.hiking_description, R.string.hiking_location, R.drawable.hiking));
        items.add(new Item(R.string.golf_title, R.string.golf_description, R.string.golf_location, R.drawable.golf));
        items.add(new Item(R.string.ski_title, R.string.ski_description, R.string.ski_location, R.drawable.ski));

        // Attach a LayoutManager to this RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(items, new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
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
        recyclerView.setAdapter(adapter);
        adapter.setItemList(items);
        adapter.notifyDataSetChanged();

        return rootView;
    }

    // Binding reset
    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
