package com.example.deepakrattan.retrofitdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.deepakrattan.retrofitdemo.R;

public class FirstActivity extends AppCompatActivity {
    private Button btnGet, btnPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btnGet = (Button) findViewById(R.id.btnGetRequest);
        btnPost = (Button) findViewById(R.id.btnPostRequest);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this, GetRequestActivity.class));
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this, PostRequestActivity.class));
            }
        });
    }
}
