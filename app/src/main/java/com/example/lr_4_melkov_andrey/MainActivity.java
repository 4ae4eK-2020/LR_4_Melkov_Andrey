package com.example.lr_4_melkov_andrey;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button morningBtn, dayBtn, eveningBtn, nightBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainActivitySingleton.setMainActivity(this);

        morningBtn = findViewById(R.id.morningBtn);
        dayBtn = findViewById(R.id.dayBtn);
        eveningBtn = findViewById(R.id.eveningBtn);
        nightBtn = findViewById(R.id.nightBtn);

        morningBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MorningActivity.class);
                changeAppWindow(intent);
            }
        });

        dayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DayAcrivity.class);
                changeAppWindow(intent);
            }
        });

        eveningBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EveningActivity.class);
                changeAppWindow(intent);
            }
        });

        nightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NightActivity.class);
                changeAppWindow(intent);
            }
        });
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivitySingleton.setMainActivity(null);
    }

    private void changeAppWindow(Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}