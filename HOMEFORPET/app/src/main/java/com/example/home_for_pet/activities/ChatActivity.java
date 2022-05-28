package com.example.home_for_pet.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home_for_pet.R;

public class ChatActivity extends AppCompatActivity {
    private String name;
    private String email;
    private String password;
    private RecyclerView messagesRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat2);
        messagesRecyclerView = findViewById(R.id.messagesRecyclerView);
        email=getIntent().getStringExtra("email");

        messagesRecyclerView.setHasFixedSize(true);
        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
