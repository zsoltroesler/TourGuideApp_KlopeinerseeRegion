package com.example.android.tourguideapp_klopeinerseeregion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zsolt on 8/18/2017.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    /**
     * Create a new {@link ItemAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param items   is the fragment_items_list of {@link Item}s to be displayed.
     */
    public ItemAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    // Create the ViewHolder class to hold title, description and image as references
    class ViewHolder {
        private TextView titleTextView;
        private TextView descriptionTextView;
        private ImageView imageView;

        // Add a public constructor, instantiate all of the references to the private variables
        public ViewHolder (View view) {
            this.titleTextView = (TextView) view.findViewById(R.id.title);
            this.descriptionTextView = (TextView) view.findViewById(R.id.description);
            this.imageView = (ImageView) view.findViewById(R.id.image);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);

            // Set up the ViewHolder
            viewHolder = new ViewHolder(listItemView);

            // Store the holder with the view.
            listItemView.setTag(viewHolder);

        // Use of viewHolder, which is already stored, avoid calling again findViewById()
        } else {
            viewHolder = (ViewHolder) listItemView.getTag();
        }

        // Get the {@link Item} object located at this position in the fragment_items_list
        Item currentItem = getItem(position);

        // Get the title from the current Item object and set this text on the title TextView.
        viewHolder.titleTextView.setText(currentItem.getTitleItem());

        // Get the description from the current Item object and set this text on the
        // description TextView.
        viewHolder.descriptionTextView.setText(currentItem.getDescriptionItem());

        // Get the image resource ID from the current Item object and set this on the
        // image ImageView
        viewHolder.imageView.setImageResource(currentItem.getImageResourceId());

        return listItemView;
    }
}
