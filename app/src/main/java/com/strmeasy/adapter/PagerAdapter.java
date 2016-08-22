package com.strmeasy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by nikita on 27/7/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> swipeFragments;

    public PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.swipeFragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = swipeFragments.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return swipeFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence fragmentTag = null;
        if(position == 0)
        {
            fragmentTag = "Home";
        }
        else if(position == 1)
        {
            fragmentTag = "Recommended";
        }
        else if(position == 2)
        {
            fragmentTag = "TopRated";
        }
        else if(position == 3)
        {
            fragmentTag = "Genear";
        }
        return fragmentTag;
    }
}
