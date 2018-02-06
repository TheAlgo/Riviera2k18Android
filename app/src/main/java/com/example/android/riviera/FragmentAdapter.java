package com.example.android.riviera;


import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.android.riviera.fragments.Day1Fragment;
import com.example.android.riviera.fragments.Day2Fragment;
import com.example.android.riviera.fragments.Day3Fragment;
import com.example.android.riviera.fragments.Day4Fragment;

/**
 * Created by thealgo on 2/6/18.
 */

class FragmentAdapter extends FragmentStatePagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:

                Day1Fragment tf = new Day1Fragment();

                return tf;
            case 1:
                return new Day2Fragment();
            case 2:
                return new Day3Fragment();
            case 3:
                return  new Day4Fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            //
            //Your tab titles
            //
            case 0:return "Day 1";
            case 1:return "Day 2";
            case 2: return "Day 3";
            case 3: return "Day 4";
            default:return null;
        }
    }
}
