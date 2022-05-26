package com.example.home_for_pet;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    EditText name,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        getSupportActionBar().hide();
        name=findViewById(R.id.name);
        name=findViewById(R.id.email);
        name=findViewById(R.id.password);
    }
    public void signup(View view){
        String userName= name.getText().toString();
        String userEmail= email.getText().toString();
        String userPassword= password.getText().toString();
        if(TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Entrer l'e mail", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Entrer le password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPassword.length()<8){
            Toast.makeText(this, "le mdp est too short, il faut au minimum 8 char", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
    }
}
