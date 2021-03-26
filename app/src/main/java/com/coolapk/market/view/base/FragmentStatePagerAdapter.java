package com.coolapk.market.view.base;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.coolapk.market.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private boolean mSaveStateWithTag = false;
    private ArrayList<Fragment.SavedState> mSavedState = new ArrayList<>();
    private Map<String, Fragment.SavedState> mSavedStateMap = new HashMap();

    public abstract Fragment getItem(int i);

    public abstract String getItemTag(int i);

    public String getItemTag(Object obj) {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public FragmentStatePagerAdapter(FragmentManager fragmentManager, boolean z) {
        this.mFragmentManager = fragmentManager;
        this.mSaveStateWithTag = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.mFragments.size() > i && (fragment = this.mFragments.get(i)) != null) {
            return fragment;
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        Fragment item = getItem(i);
        if (this.mSaveStateWithTag) {
            Fragment.SavedState savedState2 = this.mSavedStateMap.get(getItemTag(i));
            if (savedState2 != null) {
                item.setInitialSavedState(savedState2);
            }
        } else if (this.mSavedState.size() > i && (savedState = this.mSavedState.get(i)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.mFragments.size() <= i) {
            this.mFragments.add(null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        this.mFragments.set(i, item);
        this.mCurTransaction.add(viewGroup.getId(), item, getItemTag(i));
        return item;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        if (!this.mSaveStateWithTag) {
            while (this.mSavedState.size() <= i) {
                this.mSavedState.add(null);
            }
            this.mSavedState.set(i, fragment.isAdded() ? this.mFragmentManager.saveFragmentInstanceState(fragment) : null);
        } else if (fragment.isAdded()) {
            this.mSavedStateMap.put(getItemTag(obj), this.mFragmentManager.saveFragmentInstanceState(fragment));
        } else {
            this.mSavedStateMap.remove(getItemTag(obj));
        }
        this.mFragments.set(i, null);
        this.mCurTransaction.remove(fragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.mCurTransaction = null;
            try {
                this.mFragmentManager.executePendingTransactions();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle;
        int i;
        if (this.mSaveStateWithTag) {
            if (this.mSavedStateMap.size() > 0) {
                bundle = new Bundle();
                Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.mSavedState.size()];
                this.mSavedStateMap.values().toArray(savedStateArr);
                bundle.putParcelableArray("states", savedStateArr);
                for (i = 0; i < this.mFragments.size(); i++) {
                    Fragment fragment = this.mFragments.get(i);
                    if (fragment != null && fragment.isAdded()) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        this.mFragmentManager.putFragment(bundle, "f" + i, fragment);
                    }
                }
                return bundle;
            }
        } else if (this.mSavedState.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr2 = new Fragment.SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(savedStateArr2);
            bundle.putParcelableArray("states", savedStateArr2);
            while (i < this.mFragments.size()) {
            }
            return bundle;
        }
        bundle = null;
        while (i < this.mFragments.size()) {
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Fragment fragment;
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.mSavedStateMap.clear();
            this.mSavedState.clear();
            this.mFragments.clear();
            if (parcelableArray != null) {
                for (int i = 0; i < parcelableArray.length; i++) {
                    if (this.mSaveStateWithTag) {
                        this.mSavedStateMap.put(getItemTag(i), (Fragment.SavedState) parcelableArray[i]);
                    } else {
                        this.mSavedState.add((Fragment.SavedState) parcelableArray[i]);
                    }
                }
            }
            for (T t : bundle.keySet()) {
                if (t.startsWith("f")) {
                    int parseInt = Integer.parseInt(t.substring(1));
                    try {
                        fragment = this.mFragmentManager.getFragment(bundle, t);
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                        fragment = null;
                    }
                    if (fragment != null) {
                        while (this.mFragments.size() <= parseInt) {
                            this.mFragments.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.mFragments.set(parseInt, fragment);
                    } else {
                        LogUtils.w("Bad fragment at key " + ((String) t), new Object[0]);
                    }
                }
            }
        }
    }
}
