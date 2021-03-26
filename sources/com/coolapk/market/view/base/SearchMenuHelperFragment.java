package com.coolapk.market.view.base;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.manager.ActionManager;
import java.util.HashMap;
import java.util.Map;

public class SearchMenuHelperFragment extends BaseFragment {
    public static final String TAG = "SearchMenuHelperFragment";
    private HashMap<View, Integer> menuViewVisibleSet = new HashMap<>();

    public static SearchMenuHelperFragment newInstance() {
        Bundle bundle = new Bundle();
        SearchMenuHelperFragment searchMenuHelperFragment = new SearchMenuHelperFragment();
        searchMenuHelperFragment.setArguments(bundle);
        return searchMenuHelperFragment;
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menuInflater.inflate(2131623969, menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131361961) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActionManager.startSearchActivity(getActivity());
        return true;
    }

    private void saveMenu(Toolbar toolbar) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View childAt = toolbar.getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                ActionMenuView actionMenuView = (ActionMenuView) childAt;
                for (int i2 = 0; i2 < actionMenuView.getChildCount(); i2++) {
                    View childAt2 = actionMenuView.getChildAt(i2);
                    if (childAt2 instanceof ActionMenuItemView) {
                        this.menuViewVisibleSet.put(childAt2, Integer.valueOf(childAt2.getVisibility()));
                    }
                }
                return;
            }
        }
    }

    private void restoreMenu() {
        for (Map.Entry<View, Integer> entry : this.menuViewVisibleSet.entrySet()) {
            int intValue = entry.getValue().intValue();
            if (intValue == 0) {
                entry.getKey().setVisibility(0);
            } else if (intValue == 4) {
                entry.getKey().setVisibility(4);
            } else if (intValue == 8) {
                entry.getKey().setVisibility(8);
            }
        }
        this.menuViewVisibleSet.clear();
    }

    private <T extends View> T findView(int i) {
        return (T) getActivity().getWindow().getDecorView().findViewById(i);
    }
}
