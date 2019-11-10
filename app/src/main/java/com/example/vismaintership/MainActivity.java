package com.example.vismaintership;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity<result> extends AppCompatActivity {

    ListView listView;
    ArrayList<DogsInfo> arrayList;
    String result = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //list view to a accept DogsAdapter
        listView = (ListView) findViewById(R.id.listView);
        //array list to keep dogs data fetched from JSON
        ArrayList<DogsInfo> arrayList = new ArrayList<DogsInfo>();


        JSONObject object = null;
        try {
            object = new JSONObject(readJSON());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = null;
        try {
            array = object.getJSONArray("urls");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < array.length(); i++) {

            try {
                result = array.getString(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            arrayList.add(new DogsInfo(result));

        }

        //create instance of adapter and pass arrayList
        DogsAdapter adapter = new DogsAdapter(this, arrayList);

        //pass adapter to a listView
        listView.setAdapter(adapter);
    }

    //method to read JSON from Assets folder
    public String readJSON() {
        String json = null;
        try {

            InputStream inputStream = getAssets().open("dog_urls.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}

