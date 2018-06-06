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
public class SigthsFragment extends Fragment {

    /**
     * Using to show the item on the map
     */
    private String location;

    @BindView(R.id.rv_list)
    RecyclerView recyclerView;

    private Unbinder unbinder;

    public SigthsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items_list, container, false);

        unbinder = ButterKnife.bind(this, rootView);

        // Create a list of items
        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.string.caves_title, R.string.cave_description, R.string.caves_location, R.drawable.obir_cave));
        items.add(new Item(R.string.waterfall_title, R.string.waterfall_description, R.string.waterfall_location, R.drawable.waterfall));
        items.add(new Item(R.string.troegerner_titel, R.string.troegerner_description, R.string.troegerner_location, R.drawable.troegernerklamm));
        items.add(new Item(R.string.tscheppa_title, R.string.tscheppa_description, R.string.tscheppa_location, R.drawable.tscheppaschlucht));
        items.add(new Item(R.string.petzen_title, R.string.petzen_description, R.string.petzen_location, R.drawable.petzen));

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
