package com.coolapk.market.view.main;

import android.content.Context;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.coolapk.market.view.center.CenterV9Fragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/main/NavigationHelper;", "", "()V", "itemAppAndGame", "Lcom/coolapk/market/view/main/NavigationItem;", "itemDiscovery", "itemHome", "itemMine", "itemPhoneBa", "navigationItems", "", "getNavigationItems", "()[Lcom/coolapk/market/view/main/NavigationItem;", "navigationItems$delegate", "Lkotlin/Lazy;", "getAHBottomNavigationItems", "", "Lcom/aurelhubert/ahbottomnavigation/AHBottomNavigationItem;", "context", "Landroid/content/Context;", "getNavigationItem", "pageName", "Lcom/coolapk/market/view/main/PageName;", "index", "", "getNavigationItemIndex", "getPageName", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
public final class NavigationHelper {
    private final NavigationItem itemAppAndGame = new NavigationItem(2131887224, 2131231132, 2131231136, MarketFragmentV8.class);
    private final NavigationItem itemDiscovery = new NavigationItem(2131887244, 2131231251, 2131231252, DiscoveryFragmentV11.class);
    private final NavigationItem itemHome = new NavigationItem(2131887273, 2131231352, 2131231354, HomeFragmentV9.class);
    private final NavigationItem itemMine = new NavigationItem(2131887278, 2131231419, 2131231420, CenterV9Fragment.class);
    private final NavigationItem itemPhoneBa = new NavigationItem(2131887285, 2131231476, 2131231477, ProductFragmentVX.class);
    private final Lazy navigationItems$delegate = LazyKt.lazy(new NavigationHelper$navigationItems$2(this));

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PageName.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PageName.HOME.ordinal()] = 1;
            iArr[PageName.MOBILE_BAR.ordinal()] = 2;
            iArr[PageName.DISCOVERY.ordinal()] = 3;
            iArr[PageName.APP_AND_GAME.ordinal()] = 4;
            iArr[PageName.CENTER.ordinal()] = 5;
        }
    }

    public final NavigationItem[] getNavigationItems() {
        return (NavigationItem[]) this.navigationItems$delegate.getValue();
    }

    public final PageName getPageName(int i) {
        NavigationItem navigationItem = getNavigationItem(i);
        if (Intrinsics.areEqual(navigationItem, this.itemHome)) {
            return PageName.HOME;
        }
        if (Intrinsics.areEqual(navigationItem, this.itemPhoneBa)) {
            return PageName.MOBILE_BAR;
        }
        if (Intrinsics.areEqual(navigationItem, this.itemDiscovery)) {
            return PageName.DISCOVERY;
        }
        if (Intrinsics.areEqual(navigationItem, this.itemAppAndGame)) {
            return PageName.APP_AND_GAME;
        }
        if (Intrinsics.areEqual(navigationItem, this.itemMine)) {
            return PageName.CENTER;
        }
        throw new RuntimeException("Unknown item");
    }

    public final int getNavigationItemIndex(PageName pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        int i = WhenMappings.$EnumSwitchMapping$0[pageName.ordinal()];
        if (i == 1) {
            return ArraysKt.indexOf(getNavigationItems(), this.itemHome);
        }
        if (i == 2) {
            return ArraysKt.indexOf(getNavigationItems(), this.itemPhoneBa);
        }
        if (i == 3) {
            return ArraysKt.indexOf(getNavigationItems(), this.itemDiscovery);
        }
        if (i == 4) {
            return ArraysKt.indexOf(getNavigationItems(), this.itemAppAndGame);
        }
        if (i == 5) {
            return ArraysKt.indexOf(getNavigationItems(), this.itemMine);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final NavigationItem getNavigationItem(int i) {
        return getNavigationItems()[i];
    }

    public final NavigationItem getNavigationItem(PageName pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return getNavigationItem(getNavigationItemIndex(pageName));
    }

    public final List<AHBottomNavigationItem> getAHBottomNavigationItems(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NavigationItem[] navigationItems = getNavigationItems();
        ArrayList arrayList = new ArrayList();
        for (NavigationItem navigationItem : navigationItems) {
            arrayList.add(new AHBottomNavigationItem(context.getString(navigationItem.getTitleRes$presentation_coolapkAppRelease()), navigationItem.getIconDrawable(context)));
        }
        return arrayList;
    }
}
