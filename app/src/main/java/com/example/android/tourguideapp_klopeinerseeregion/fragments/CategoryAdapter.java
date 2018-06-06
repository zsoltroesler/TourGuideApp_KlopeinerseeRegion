package com.example.android.tourguideapp_klopeinerseeregion.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Zsolt on 8/16/2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter{

    //Context of the app
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LakesFragment();
            case 1:
                return new SigthsFragment();
            case 2:
                return new ActiveFragment();
            case 3:
                return new FamilyFragment();
            case 4:
                return new CultureFragment();
        }
        return null;
    }

    /**
     * Get the page title {@link Fragment} that should be displayed for the fragment.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.category_lakes);
            case 1:
                return mContext.getString(R.string.category_sights);
            case 2:
                return mContext.getString(R.string.category_active);
            case 3:
                return mContext.getString(R.string.category_family);
            case 4:
                return mContext.getString(R.string.category_culture);
        }
        return null;
    }
}
