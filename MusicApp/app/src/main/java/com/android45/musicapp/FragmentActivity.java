package com.android45.musicapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.android45.musicapp.databinding.ActivityFragmentBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity extends AppCompatActivity {
    ActivityFragmentBinding activityFragmentBinding;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        activityFragmentBinding = DataBindingUtil.setContentView(this, R.layout.activity_fragment);

        getSupportActionBar().hide();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.bottomNavigationView, new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.Home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.Home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.Search:
                        break;
                    case R.id.Favorite:
                        break;
                    case R.id.User:
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.bottomNavigationView, fragment).commit();
                return true;
            }
        });
    }
}