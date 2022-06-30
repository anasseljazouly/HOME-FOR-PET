package com.example.home_for_pet.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.home_for_pet.R;
import com.example.home_for_pet.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    Fragment homeFragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        homeFragment= new HomeFragment();
        loadFragment(homeFragment);
}

    private void loadFragment(Fragment homeFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_container,homeFragment);
        transaction.commit();
    }
    }
