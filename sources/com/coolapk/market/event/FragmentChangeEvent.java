package com.coolapk.market.event;

import androidx.fragment.app.Fragment;

public class FragmentChangeEvent {
    private Fragment fragment;

    public FragmentChangeEvent(Fragment fragment2) {
        this.fragment = fragment2;
    }

    public Fragment getFragment() {
        return this.fragment;
    }
}
