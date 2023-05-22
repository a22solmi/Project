package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle(getIntent().getStringExtra("name"));

        ImageView imageView = findViewById(R.id.detail_image);
        Picasso.get()
                .load("file:///android_asset/" + getIntent().getStringExtra("aux"))
                .into(imageView);

        TextView detailParadigm = findViewById(R.id.detail_paradigm);
        detailParadigm.setText("Paradigm: ");
        LinearLayout linearLayout = findViewById(R.id.paradigm_layout);
        String[] paradigms = getIntent().getStringArrayExtra("paradigm");
        for (String paradigm: paradigms) {
            TextView textView = new TextView(this);
            textView.setText(paradigm);
            textView.setBackgroundResource(R.drawable.tag_background);
            textView.setPadding(10, 0, 10, 0);
            linearLayout.addView(textView);
        }


        TextView detailUse = findViewById(R.id.detail_use);
        detailUse.setText(getIntent().getStringExtra("use"));

        TextView detailExample = findViewById(R.id.detail_example);
        detailExample.setText(getIntent().getStringExtra("example") + "\n");
    }
}