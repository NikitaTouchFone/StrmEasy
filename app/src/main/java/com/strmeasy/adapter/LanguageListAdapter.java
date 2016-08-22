package com.strmeasy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.strmeasy.R;

import java.util.ArrayList;

/**
 * Created by nikita on 13/7/16.
 */
public class LanguageListAdapter extends BaseAdapter {

    Context mcontext;
    ArrayList<String> languageArray;
    LayoutInflater inflater;

    public LanguageListAdapter(Context context, ArrayList<String> langArray)
    {
        this.mcontext = context;
        this.languageArray = langArray;
        inflater = (LayoutInflater.from(mcontext));
    }
    @Override
    public int getCount() {
        return languageArray.size();
    }

    @Override
    public Object getItem(int i) {
        return languageArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if(convertView==null){
            convertView = inflater.inflate(R.layout.lang_item, null);
            viewHolder = new ViewHolder();
            viewHolder.langName = (TextView) convertView.findViewById(R.id.langname);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.langName.setText(String.valueOf(languageArray.get(i).toString()));
        return convertView;
    }

    static class ViewHolder {
        public TextView langName;
        public ImageView langLogo;
    }
}
