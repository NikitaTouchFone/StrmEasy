package com.strmeasy.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.strmeasy.R;

/**
 * Created by nikita on 27/7/16.
 */
public class TopRatedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View toprated = inflater.inflate(R.layout.topratedfrag, container, false);
        ((TextView)toprated.findViewById(R.id.textView)).setText("Top Rated");
        return toprated;
    }
}
