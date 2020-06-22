package com.example.teamscore.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.teamscore.R;
import com.example.teamscore.ui.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {
    public FragmentManager fm;
    SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        if (savedInstanceState == null) {
            searchFragment = new SearchFragment();
            fm.beginTransaction().add(R.id.main_frame, searchFragment)
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {

    }
}