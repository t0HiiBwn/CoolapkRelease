package com.coolapk.market.view.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.coolapk.market.databinding.ToolbarLayoutBinding;
import com.google.android.material.appbar.AppBarLayout;

public abstract class ToolbarFragment extends BaseFragment {
    private ToolbarLayoutBinding binding;
    private Fragment contentFragment;

    protected abstract String getToolbarTitle();

    protected abstract Fragment onCreateFragment();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ToolbarLayoutBinding toolbarLayoutBinding = (ToolbarLayoutBinding) DataBindingUtil.inflate(layoutInflater, 2131559207, viewGroup, false);
        this.binding = toolbarLayoutBinding;
        return toolbarLayoutBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.binding.toolbar.setTitle(getToolbarTitle());
        FragmentManager childFragmentManager = getChildFragmentManager();
        Fragment findFragmentById = childFragmentManager.findFragmentById(2131363614);
        this.contentFragment = findFragmentById;
        if (findFragmentById == null) {
            this.contentFragment = onCreateFragment();
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            Fragment fragment = this.contentFragment;
            beginTransaction.add(2131363614, fragment, fragment.getClass().getSimpleName()).commit();
        }
    }

    public Toolbar getToolbar() {
        return this.binding.toolbar;
    }

    public AppBarLayout getAppBarLayout() {
        return this.binding.appBar;
    }

    public Fragment getContentFragment() {
        return this.contentFragment;
    }
}
