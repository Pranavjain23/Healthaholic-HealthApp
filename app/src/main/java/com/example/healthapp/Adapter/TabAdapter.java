package com.example.healthapp.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.healthapp.R;
import com.example.healthapp.fragments.WeightGain;
import com.example.healthapp.fragments.WeightLoss;

public class TabAdapter extends FragmentPagerAdapter {

    private static final int[] TAB_TITLES =
            new int[] {R.string.weightGain ,R.string.weightLoss};
    private final Context mContext;
    public TabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                WeightGain weightGain = new WeightGain();
                return weightGain;
            case 1:
                WeightLoss weightLoss = new WeightLoss();
                return weightLoss;

            default:
                return null;
        }
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
    @Override
    public int getCount() {
        return 2;
    }
}
