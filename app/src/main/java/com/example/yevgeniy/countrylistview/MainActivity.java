package com.example.yevgeniy.countrylistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;

    String[] countryNames = {"Amsterdam", "Antalya", "Athens", "Kiev", "Moscow", "Munich", "Prague"};
    int[] countryFlags = {
            R.drawable.flag_amsterdam,
            R.drawable.flag_antalya,
            R.drawable.flag_athens,
            R.drawable.flag_kiev,
            R.drawable.flag_moscow,
            R.drawable.flag_munich,
            R.drawable.flag_prague,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, countryNames, countryFlags);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(MainActivity.this, DetailActivity.class);
                mIntent.putExtra("countryName", countryNames[i]);
                mIntent.putExtra("countryFlag", countryFlags[i]);
                mIntent.putExtra("title", i);

                startActivity(mIntent);
            }
        }));


    }
}
