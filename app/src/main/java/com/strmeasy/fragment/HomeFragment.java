package com.strmeasy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.network.controller.NetworkManager;
import com.network.model.RestError;
import com.network.model.Status;
import com.network.subscriber.ResponseSubscriber;
import com.strmeasy.R;
import com.strmeasy.adapter.PagerAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by nikita on 27/7/16.
 */
public class HomeFragment extends Fragment {
    LinearLayout parentLayout;
    LinearLayout itemHolder;
    TextView sub_category_name;
    View homeFragment;
    View entityView;
    View entity_list_item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeFragment = inflater.inflate(R.layout.homefragment, container, false);
        parentLayout = (LinearLayout) homeFragment.findViewById(R.id.parentcontainer);
        entityView = LayoutInflater.from(getActivity()).inflate(
                R.layout.entity_item, parentLayout, false);
        /*sub_category_name = (TextView) entityView.findViewById(R.id.sub_category_title);
        sub_category_name.setText("PlayList");
        itemHolder = (LinearLayout) entityView.findViewById(R.id.more_result_list_items_holder);
        entity_list_item = LayoutInflater.from(getActivity()).inflate(
                R.layout.entity_list_item, itemHolder, false);
        itemHolder.addView(entity_list_item);*/
        parentLayout.addView(entityView);
        return homeFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        NetworkManager.getInstance().enqueueMoreApiRequest(new ResponseSubscriber() {
            @Override
            public void onSuccess(Object responseModel) {
                if (null != responseModel) {

                    Status objMoreAPIModel = (Status) responseModel;
                    if (objMoreAPIModel.getSuccess())
                        try {
                            Log.e("HomeApi", " Data[] size is ***** " + objMoreAPIModel.getData().size()
                                    /*" \n Title is ****  " + objHomeAPIModel.getData().get(0).getTitle() +
                                    " \n Sections[] size is **** " + objHomeAPIModel.getData().get(0).getSections().size() +
                                    " \n Sections Title ****  " + objHomeAPIModel.getData().get(0).getSections().get(0).getTitle() +
                                    " \n Items[] size ****  " + objHomeAPIModel.getData().get(0).getSections().get(0).getItems().size() +
                                    " \n Title One ****  " + objHomeAPIModel.getData().get(0).getSections().get(0).getItems().get(0).getTitle() +
                                    " \n Title Two ***  " + objHomeAPIModel.getData().get(0).getSections().get(0).getItems().get(1).getTitle()+
                                    " \n Category Title ***  " + objHomeAPIModel.getData().get(0).getSections().get(0).getItems().get(0).getCategories().get(0).getTitle()*/);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            }

            @Override
            public void onFailure(RestError restError) {
            }

            @Override
            public void onFailure(Throwable t) {
            }

            @Override
            public void onResponseHeaders(Map<String, List<String>> nameValuePairs) {

            }
        });

    }

}
