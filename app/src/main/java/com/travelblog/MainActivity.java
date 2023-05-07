package com.travelblog;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainTextview = findViewById(R.id.mainTextView);
        mainTextview.setText(R.string.educative_io);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
