package com.cheise_proj.tourguideapp.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.cheise_proj.tourguideapp.R;
import com.cheise_proj.tourguideapp.adapter.SectionAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSectionTab();
    }

    //Setup tab layout
    private void initSectionTab() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        SectionAdapter sectionAdapter = new SectionAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(sectionAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}