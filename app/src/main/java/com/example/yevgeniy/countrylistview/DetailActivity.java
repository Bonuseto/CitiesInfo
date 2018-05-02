package com.example.yevgeniy.countrylistview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DetailActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView mImageView;
    WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mWebView = findViewById(R.id.webView); //2

        Intent intent = getIntent();//2
        //получаем строку и формируем имя ресурса
        String resName = "n" + intent.getIntExtra("title", 0);//2
        Log.i("name", resName);//2
        Context context = getBaseContext();//2

        //читаем текстовый файл из ресурсов по имени
        String text = readRawTextFile(context, getResources().getIdentifier(resName,"raw",
                "com.example.yevgeniy.countrylistview"));//2

        mWebView.loadDataWithBaseURL(null,text,"text/html", "en_US",null);//2



        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mImageView = (ImageView) findViewById(R.id.imageView2);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            mToolbar.setTitle(mBundle.getString("countryName"));
            mImageView.setImageResource(mBundle.getInt("countryFlag"));
        }


    }
    //читаем текст из raw-ресурсов
    private String readRawTextFile(Context context, int resID) {
        InputStream inputStream = context.getResources().openRawResource(resID);

        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader buffReader = new BufferedReader(inputReader);
        String line;
        StringBuilder builder = new StringBuilder();

        try {
            while ((line = buffReader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();
     }
    }


