package com.example.home_for_pet.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.home_for_pet.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText name,email,password;
    private FirebaseAuth auth;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        getSupportActionBar().hide();

        auth=FirebaseAuth.getInstance();
        if(auth.getCurrentUser() !=null){
            startActivity(new Intent(RegistrationActivity.this, HomeActivity.class));
        }
        final EditText name=findViewById(R.id.name);
        final EditText email=findViewById(R.id.email);
        final EditText password=findViewById(R.id.password);
        final Button registerBtn = findViewById(R.id.sign_up_on_sign_up);

        sharedPreferences =getSharedPreferences("OdadingScreen",MODE_PRIVATE);

        boolean isFirstTime=sharedPreferences.getBoolean("firstTime",true);
        if(isFirstTime){
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putBoolean("firstTime",false);
            editor.commit();
            Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();

        }
        registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String userName= name.getText().toString();
                String userEmail= email.getText().toString();
                String userPassword= password.getText().toString();
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(RegistrationActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(userEmail)){
                    Toast.makeText(RegistrationActivity.this, "Entrer l'e mail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(userPassword)){
                    Toast.makeText(RegistrationActivity.this, "Entrer le password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(userPassword.length()<8){
                    Toast.makeText(RegistrationActivity.this, "le mdp est too short, il faut au minimum 8 char", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(userEmail,userPassword)
                        .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(RegistrationActivity.this, "Successfully Registred" ,Toast.LENGTH_SHORT );
                                    startActivity(new Intent(RegistrationActivity.this , HomeActivity.class));
                                }else{
                                    Toast.makeText(RegistrationActivity.this , "Registration Failed"+task.getException() , Toast.LENGTH_SHORT);
                                }
                            }});

            }
        });



    }


    public void singin(android.view.View view) {
        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));}

}
