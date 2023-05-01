package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
    ArrayList<RecyclerItem> recyclerList;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String json_url = "https://mobprog.webug.se/json-api?login=brom";
        new JsonTask(this).execute(json_url);
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<RecyclerItem>>() {}.getType();
        recyclerList = gson.fromJson(json, type);

        adapter = new RecyclerViewAdapter(this, recyclerList, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerItem recyclerItem) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
        RecyclerView view = findViewById(R.id.recycler_view);
        view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
