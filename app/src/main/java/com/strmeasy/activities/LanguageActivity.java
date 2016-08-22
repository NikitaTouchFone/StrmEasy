package com.strmeasy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.strmeasy.R;
import com.strmeasy.adapter.LanguageListAdapter;
import com.strmeasy.sharedpref.StrmEasySharedPref;

import java.util.ArrayList;

/**
 * Created by nikita on 13/7/16.
 */
public class LanguageActivity extends Activity {

    ArrayList<String> langaugeArray = new ArrayList<String>();
    LanguageListAdapter langAdapter;
    ListView langList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.langdialog);

        langaugeArray = getIntent().getStringArrayListExtra("langArray");
        langAdapter = new LanguageListAdapter(this,langaugeArray);
        langList = (ListView) findViewById(R.id.languageListView);
        langList.setAdapter(langAdapter);

        langList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.e("LanguageActivity","Selected Language   "+langaugeArray.get(i).toString());
                StrmEasySharedPref.setCountryCode(LanguageActivity.this,langaugeArray.get(i).toString());

                Intent intent = new Intent(LanguageActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
