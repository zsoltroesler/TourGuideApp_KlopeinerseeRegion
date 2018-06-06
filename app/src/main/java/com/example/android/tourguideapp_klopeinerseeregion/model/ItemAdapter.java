package com.example.android.tourguideapp_klopeinerseeregion.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zsolt on 8/18/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    private ArrayList<Item> itemList;
    private final OnItemClickListener listener;

    public ItemAdapter(ArrayList<Item> itemList, OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        return  new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {

        final Item item = itemList.get(position);

        // Get and set the corresponding item title
        int itemTitle = item.getTitleItem();
        holder.title.setText(itemTitle);

        // Get and set the corresponding item description
        int itemDescription = item.getDescriptionItem();
        holder.description.setText(itemDescription);

        // Get and set the corresponding item description
        int itemImage = item.getImageResourceId();
        holder.image.setImageResource(itemImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // Create the ViewHolder class for references
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.image)
        ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    // Helper method to clear or update recipe list
    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
}
