package com.example.tourguide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.view_pager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
//        initialise and create page fragments with their various titles
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new HistoryFragment(), getResources().getString(R.string.history));
        adapter.addFragment(new PlacesFragment(), getResources().getString(R.string.places));
        adapter.addFragment(new EventsFragment(), getResources().getString(R.string.events));
        adapter.addFragment(new FoodFragment(), getResources().getString(R.string.foods));
        viewPager.setAdapter(adapter);
    }

}