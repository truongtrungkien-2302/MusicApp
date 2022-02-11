package com.android45.musicapp.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android45.musicapp.R;
import com.android45.musicapp.fragment.FavoriteFragment;
import com.android45.musicapp.fragment.HomeFragment;
import com.android45.musicapp.fragment.SearchFragment;
import com.android45.musicapp.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity extends AppCompatActivity {
//    ActivityFragmentBinding activityFragmentBinding;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment);

//        activityFragmentBinding = DataBindingUtil.setContentView(this, R.layout.activity_fragment);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
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
                        fragment = new SearchFragment();
                        break;
                    case R.id.Favorite:
                        fragment = new FavoriteFragment();
                        break;
                    case R.id.User:
                        fragment = new UserFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });
    }
}