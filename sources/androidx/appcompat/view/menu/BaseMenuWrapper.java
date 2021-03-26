package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class BaseMenuWrapper {
    final Context mContext;
    private Map<SupportMenuItem, MenuItem> mMenuItems;
    private Map<SupportSubMenu, SubMenu> mSubMenus;

    BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new ArrayMap();
        }
        MenuItem menuItem2 = this.mMenuItems.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.mContext, supportMenuItem);
        this.mMenuItems.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.mSubMenus == null) {
            this.mSubMenus = new ArrayMap();
        }
        SubMenu subMenu2 = this.mSubMenus.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.mContext, supportSubMenu);
        this.mSubMenus.put(supportSubMenu, subMenuWrapperICS);
        return subMenuWrapperICS;
    }

    final void internalClear() {
        Map<SupportMenuItem, MenuItem> map = this.mMenuItems;
        if (map != null) {
            map.clear();
        }
        Map<SupportSubMenu, SubMenu> map2 = this.mSubMenus;
        if (map2 != null) {
            map2.clear();
        }
    }

    final void internalRemoveGroup(int i) {
        Map<SupportMenuItem, MenuItem> map = this.mMenuItems;
        if (map != null) {
            Iterator<SupportMenuItem> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                if (i == it2.next().getGroupId()) {
                    it2.remove();
                }
            }
        }
    }

    final void internalRemoveItem(int i) {
        Map<SupportMenuItem, MenuItem> map = this.mMenuItems;
        if (map != null) {
            Iterator<SupportMenuItem> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                if (i == it2.next().getItemId()) {
                    it2.remove();
                    return;
                }
            }
        }
    }
}
