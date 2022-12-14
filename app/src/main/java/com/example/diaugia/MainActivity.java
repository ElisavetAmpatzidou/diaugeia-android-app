package com.example.diaugia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button resultsButton;
    private TextView uomTxt1,uomTxt2,uomTxt3,uoaTxt1,uoaTxt2,uoaTxt3,uoiTxt1,uoiTxt2,uoiTxt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultsButton = (Button) findViewById(R.id.resultsButton);

        University UoA = new University("UoA");
        University UoM = new University("UoM");
        University UoI = new University("UoI");

    }
    public void resultsOnClick(View v) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //intent.putExtra("location",givenName);
        startActivity(intent);

    }


}