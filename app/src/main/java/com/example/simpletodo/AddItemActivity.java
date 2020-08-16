package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    Button btnAddItem;
    EditText etItem;
    EditText etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        btnAddItem = findViewById(R.id.btnAddItem);
        etItem = findViewById(R.id.etItem);
        etDate = findViewById(R.id.etDate);
    }
}