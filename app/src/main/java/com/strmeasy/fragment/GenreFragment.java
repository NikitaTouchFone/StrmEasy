package com.strmeasy.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.strmeasy.R;

/**
 * Created by nikita on 27/7/16.
 */
public class GenreFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View genear = inflater.inflate(R.layout.genrefragment, container, false);
        ((TextView)genear.findViewById(R.id.textView)).setText("Genear");
        return genear;

    }
}
