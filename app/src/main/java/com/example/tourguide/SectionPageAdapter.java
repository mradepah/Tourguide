package com.example.tourguide;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionPageAdapter extends FragmentPagerAdapter {

    // create an array list of the different fragments to use and their titles
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    //        this method adds a fragment and its title to the array list of fragments
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    // this method gives us the position of the fragment in the array list
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    //this method returns the number of fragments in the list
    @Override
    public int getCount() {
        return mFragmentList.size();
    }

}
