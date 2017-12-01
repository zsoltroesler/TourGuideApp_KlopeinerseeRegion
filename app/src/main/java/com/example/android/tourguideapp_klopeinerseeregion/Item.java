package com.example.android.tourguideapp_klopeinerseeregion;

/**
 * Created by Zsolt on 8/18/2017.
 */

public class Item {

    // String resource ID for the title of the item
    private int mTitleItem;

    // String resource ID for the description of the item
    private int mDescriptionItem;

    // String resource ID for the location of the item
    private int mLocationItem;

    // Resource ID for the image of the item
    private int mImageResourceId;

    /**
     * Create a new Item object.
     *
     * @param titleItem         is the string resource ID for the title of the item
     * @param descriptionItem   is the string resource ID for the description of the item
     * @param locationItem   	is the string resource ID for the coordinates of the item
     * @param imageResourceId   is the drawable resource ID for the image of the item
     */
    public Item(int titleItem, int descriptionItem, int locationItem, int imageResourceId) {
        mTitleItem = titleItem;
        mDescriptionItem = descriptionItem;
        mLocationItem =locationItem;
        mImageResourceId = imageResourceId;
    }

    // Get the string resource ID for the title of the item.
    public int getTitleItem() {
        return mTitleItem;
    }

    // Get the string resource ID for the description of the item.
    public int getDescriptionItem() {
        return mDescriptionItem;
    }

    // Get the string resource ID for the location of the item.
    public int getLocationItem() {return mLocationItem;}

    // Return the image resource ID of the item.
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
