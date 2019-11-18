package com.cheise_proj.tourguideapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cheise_proj.tourguideapp.R;
import com.cheise_proj.tourguideapp.ui.sections.HotelFragment;
import com.cheise_proj.tourguideapp.ui.sections.MonumentFragment;
import com.cheise_proj.tourguideapp.ui.sections.NightFragment;
import com.cheise_proj.tourguideapp.ui.sections.ShoppingFragment;

/**
 * SectionAdapter provides view pager with FragmentPagerAdapter
 */
public class SectionAdapter extends FragmentPagerAdapter {
    private Context context;


    public SectionAdapter(@NonNull Context context, @NonNull FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MonumentFragment.newInstance();
            case 1:
                return HotelFragment.newInstance();
            case 2:
                return ShoppingFragment.newInstance();
            case 3:
                return NightFragment.newInstance();
            default:
                return null;
        }
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.tab_monument);
            case 1:
                return context.getString(R.string.tab_hotel);
            case 2:
                return context.getString(R.string.tab_shopping);
            case 3:
                return context.getString(R.string.tab_night);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
