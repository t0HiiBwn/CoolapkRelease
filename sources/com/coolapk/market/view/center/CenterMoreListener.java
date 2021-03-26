package com.coolapk.market.view.center;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreListener;", "", "onEditModeChange", "", "isEditMode", "", "onUserMenuListChanged", "menuList", "", "Lcom/coolapk/market/view/center/UserMenu;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterMorePresenter.kt */
public interface CenterMoreListener {
    void onEditModeChange(boolean z);

    void onUserMenuListChanged(List<UserMenu> list);
}
