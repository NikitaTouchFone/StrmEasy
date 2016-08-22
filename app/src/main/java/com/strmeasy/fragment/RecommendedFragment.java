package com.strmeasy.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.strmeasy.R;
import com.strmeasy.adapter.PagerAdapter;

/**
 * Created by nikita on 27/7/16.
 */
public class RecommendedFragment extends Fragment {

    PagerAdapter adapter;
    ViewPager pager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View recommended = inflater.inflate(R.layout.recomendedfrag, container, false);
        ((TextView)recommended.findViewById(R.id.textView)).setText("Recommended");

        /*adapter =  new TabPagerAdapter(getChildFragmentManager());

        pager = (ViewPager) recommended.findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
*/
        return recommended;

    }
}
