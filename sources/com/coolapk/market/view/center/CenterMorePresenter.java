package com.coolapk.market.view.center;

import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0005J\u0014\u0010\u0019\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0012J\u0014\u0010\u001e\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/center/CenterMorePresenter;", "", "()V", "editingMenuList", "", "Lcom/coolapk/market/view/center/UserMenu;", "<set-?>", "", "isEditing", "()Z", "menuPresenter", "Lcom/coolapk/market/view/center/CenterUserMenuPresenter;", "getMenuPresenter", "()Lcom/coolapk/market/view/center/CenterUserMenuPresenter;", "modeListeners", "", "Lcom/coolapk/market/view/center/CenterMoreListener;", "addCenterMoreListener", "", "listener", "getEditingMenuList", "", "removeCenterMoreListener", "requestAddUserMenu", "menu", "requestEditModeFinish", "menuList", "requestEditModeStart", "requestRemoveUserMenu", "requestRestoreDefaultMenuList", "requestSaveEditingOrder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterMorePresenter.kt */
public final class CenterMorePresenter {
    private final List<UserMenu> editingMenuList;
    private boolean isEditing;
    private final CenterUserMenuPresenter menuPresenter;
    private final Set<CenterMoreListener> modeListeners = new LinkedHashSet();

    public CenterMorePresenter() {
        CenterUserMenuPresenter instance = CenterUserMenuPresenter.Companion.getInstance();
        this.menuPresenter = instance;
        ArrayList arrayList = new ArrayList();
        this.editingMenuList = arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (T t : instance.getActiveUserMenu()) {
            if (!Intrinsics.areEqual(t.getType(), "TYPE_MORE")) {
                arrayList2.add(t);
            }
        }
        arrayList.addAll(arrayList2);
    }

    public final CenterUserMenuPresenter getMenuPresenter() {
        return this.menuPresenter;
    }

    public final boolean isEditing() {
        return this.isEditing;
    }

    public final void requestEditModeStart() {
        if (!this.isEditing) {
            this.isEditing = true;
            Object[] array = this.modeListeners.toArray(new CenterMoreListener[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            for (Object obj : array) {
                ((CenterMoreListener) obj).onEditModeChange(true);
            }
        }
    }

    public final void requestSaveEditingOrder(List<UserMenu> list) {
        Intrinsics.checkNotNullParameter(list, "menuList");
        if (this.isEditing) {
            this.editingMenuList.clear();
            this.editingMenuList.addAll(list);
            CenterUserMenuPresenter centerUserMenuPresenter = this.menuPresenter;
            List<UserMenu> list2 = this.editingMenuList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getType());
            }
            centerUserMenuPresenter.setActiveUserMenu(arrayList);
        }
    }

    public final void requestEditModeFinish(List<UserMenu> list) {
        Intrinsics.checkNotNullParameter(list, "menuList");
        if (this.isEditing) {
            requestSaveEditingOrder(list);
            this.isEditing = false;
            Object[] array = this.modeListeners.toArray(new CenterMoreListener[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            for (Object obj : array) {
                ((CenterMoreListener) obj).onEditModeChange(false);
            }
        }
    }

    public final void requestRestoreDefaultMenuList() {
        this.editingMenuList.clear();
        List<UserMenu> list = this.editingMenuList;
        ArrayList arrayList = new ArrayList();
        for (T t : this.menuPresenter.getDefaultUserMenu()) {
            if (!Intrinsics.areEqual(t.getType(), "TYPE_MORE")) {
                arrayList.add(t);
            }
        }
        list.addAll(arrayList);
        CenterUserMenuPresenter centerUserMenuPresenter = this.menuPresenter;
        List<UserMenu> list2 = this.editingMenuList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().getType());
        }
        centerUserMenuPresenter.setActiveUserMenu(arrayList2);
        Object[] array = this.modeListeners.toArray(new CenterMoreListener[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        for (Object obj : array) {
            ((CenterMoreListener) obj).onUserMenuListChanged(this.editingMenuList);
        }
    }

    public final void requestAddUserMenu(UserMenu userMenu) {
        Intrinsics.checkNotNullParameter(userMenu, "menu");
        if (this.isEditing && !this.editingMenuList.contains(userMenu)) {
            if (this.editingMenuList.size() >= 7) {
                Toast.show$default(AppHolder.getCurrentActivity(), "最多添加7个", 0, true, 4, null);
                return;
            }
            this.editingMenuList.add(userMenu);
            CenterUserMenuPresenter centerUserMenuPresenter = this.menuPresenter;
            List<UserMenu> list = this.editingMenuList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getType());
            }
            centerUserMenuPresenter.setActiveUserMenu(arrayList);
            Object[] array = this.modeListeners.toArray(new CenterMoreListener[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            for (Object obj : array) {
                ((CenterMoreListener) obj).onUserMenuListChanged(this.editingMenuList);
            }
        }
    }

    public final void requestRemoveUserMenu(UserMenu userMenu) {
        Intrinsics.checkNotNullParameter(userMenu, "menu");
        if (this.isEditing) {
            if (this.editingMenuList.size() == 1) {
                Toast.show$default(AppHolder.getCurrentActivity(), "至少添加1个", 0, true, 4, null);
                return;
            }
            this.editingMenuList.remove(userMenu);
            CenterUserMenuPresenter centerUserMenuPresenter = this.menuPresenter;
            List<UserMenu> list = this.editingMenuList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getType());
            }
            centerUserMenuPresenter.setActiveUserMenu(arrayList);
            Object[] array = this.modeListeners.toArray(new CenterMoreListener[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            for (Object obj : array) {
                ((CenterMoreListener) obj).onUserMenuListChanged(this.editingMenuList);
            }
        }
    }

    public final List<UserMenu> getEditingMenuList() {
        return this.editingMenuList;
    }

    public final void addCenterMoreListener(CenterMoreListener centerMoreListener) {
        Intrinsics.checkNotNullParameter(centerMoreListener, "listener");
        this.modeListeners.add(centerMoreListener);
    }

    public final void removeCenterMoreListener(CenterMoreListener centerMoreListener) {
        Intrinsics.checkNotNullParameter(centerMoreListener, "listener");
        this.modeListeners.remove(centerMoreListener);
    }
}
