package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
    private ArrayList<RecyclerItem> recyclerList;
    private RecyclerViewAdapter adapter;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPreferences = getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        String json_url = "https://mobprog.webug.se/json-api?login=a22solmi";
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
                intent.putExtra("name", recyclerItem.getName());
                intent.putExtra("paradigm", recyclerItem.getParadigm());
                intent.putExtra("use", recyclerItem.getUse());
                intent.putExtra("example", recyclerItem.getExample());
                intent.putExtra("aux", recyclerItem.getAux());
                startActivity(intent);
            }
        });
        RecyclerView view = findViewById(R.id.recycler_view);
        view.setAdapter(adapter);
        Set<String> set = sharedPreferences.getStringSet("perf",  Collections.emptySet());
        adapter.filter(set.toArray(new String[3]));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.menu_filter) {
            Intent intent = new Intent(MainActivity.this, FilterActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
