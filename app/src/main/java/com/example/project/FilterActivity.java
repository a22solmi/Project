package com.example.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        getSupportActionBar().setTitle("Filter");

        List<CheckBox> checkBoxList = new ArrayList<>();
        checkBoxList.add(this.findViewById(R.id.checkbox_p));
        checkBoxList.add(this.findViewById(R.id.checkbox_o));
        checkBoxList.add(this.findViewById(R.id.checkbox_f));
        Button button = findViewById(R.id.filter_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> selected = new ArrayList<>();
                for (CheckBox checkBox: checkBoxList) {
                    if (checkBox.isChecked()) {
                        String text = checkBox.getText().toString();
                        selected.add(text);
                    }
                }
                Set<String> set = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    set = selected.stream().collect(Collectors.toSet());
                }
                SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE).edit();
                editor.putStringSet("perf", set);
                editor.apply();
            }
        });
    }
}
