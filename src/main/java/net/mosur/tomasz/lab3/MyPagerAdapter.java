package net.mosur.tomasz.lab3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Tomek on 23/05/2017.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        Bundle movieInstanceState;
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                //        return MovieImagesF.newInstance(movieInstanceState);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                //     return MovieImagesF2.newInstance(movieInstanceState);
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return position == 0 ? "Szczegoly filmu" : "Kadry i aktorzy";
    }

}