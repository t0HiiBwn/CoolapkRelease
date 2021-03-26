package com.aurelhubert.ahbottomnavigation;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import java.util.ArrayList;
import java.util.List;

public class AHBottomNavigationAdapter {
    private Menu mMenu;
    private List<AHBottomNavigationItem> navigationItems;

    public AHBottomNavigationAdapter(Activity activity, int i) {
        this.mMenu = new PopupMenu(activity, null).getMenu();
        activity.getMenuInflater().inflate(i, this.mMenu);
    }

    public void setupWithBottomNavigation(AHBottomNavigation aHBottomNavigation) {
        setupWithBottomNavigation(aHBottomNavigation, null);
    }

    public void setupWithBottomNavigation(AHBottomNavigation aHBottomNavigation, int[] iArr) {
        List<AHBottomNavigationItem> list = this.navigationItems;
        if (list == null) {
            this.navigationItems = new ArrayList();
        } else {
            list.clear();
        }
        if (this.mMenu != null) {
            for (int i = 0; i < this.mMenu.size(); i++) {
                MenuItem item = this.mMenu.getItem(i);
                if (iArr == null || iArr.length < this.mMenu.size() || iArr[i] == 0) {
                    this.navigationItems.add(new AHBottomNavigationItem(String.valueOf(item.getTitle()), item.getIcon()));
                } else {
                    this.navigationItems.add(new AHBottomNavigationItem(String.valueOf(item.getTitle()), item.getIcon(), iArr[i]));
                }
            }
            aHBottomNavigation.removeAllItems();
            aHBottomNavigation.addItems(this.navigationItems);
        }
    }

    public MenuItem getMenuItem(int i) {
        return this.mMenu.getItem(i);
    }

    public AHBottomNavigationItem getNavigationItem(int i) {
        return this.navigationItems.get(i);
    }

    public Integer getPositionByMenuId(int i) {
        for (int i2 = 0; i2 < this.mMenu.size(); i2++) {
            if (this.mMenu.getItem(i2).getItemId() == i) {
                return Integer.valueOf(i2);
            }
        }
        return null;
    }
}
