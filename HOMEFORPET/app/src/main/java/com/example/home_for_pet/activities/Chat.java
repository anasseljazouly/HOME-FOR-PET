package com.example.home_for_pet.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home_for_pet.R;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat2);
        final Button backBtn=findViewById(R.id.backBtn);
        final TextView nameTv=findViewById(R.id.name);
        final EditText messageEditText=findViewById(R.id.editText);
        final ImageView sendBtn=findViewById(R.id.sendmsg);
        final ImageView profilpic=findViewById(R.id.profilpic);

        //get data from messages adapter class
        final String getName = getIntent().getStringExtra("name");
        final String getProfilPic = getIntent().getStringExtra("profile_pic");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
