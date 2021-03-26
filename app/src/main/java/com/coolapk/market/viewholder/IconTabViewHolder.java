package com.coolapk.market.viewholder;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.ItemIconLinkMiniGridCardItemBinding;
import com.coolapk.market.databinding.ItemTabViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import com.coolapk.market.view.cardlist.EntityRequestArgHelper;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.widget.FakeTabIndicator;
import com.coolapk.market.widget.view.TabLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010%\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\u001cH\u0002R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/coolapk/market/viewholder/IconTabViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;", "view", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;", "topHelper", "Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;)V", "binding", "Lcom/coolapk/market/databinding/ItemTabViewBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "fakeIndicator", "Lcom/coolapk/market/widget/FakeTabIndicator;", "isBinding", "", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;", "getTopHelper", "()Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "data", "", "calcSelectedTab", "", "onTabReselected", "tab", "Lcom/coolapk/market/widget/view/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "resetTab", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconTabViewHolder.kt */
public final class IconTabViewHolder extends BindingViewHolder implements TabLayout.OnTabSelectedListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558945;
    private final ItemTabViewBinding binding;
    private EntityCard card;
    private final FakeTabIndicator fakeIndicator;
    private boolean isBinding;
    private final EntityRequestArgHelper presenter;
    private final EntityListFixTopHelper topHelper;
    private final TitleViewPart viewPart;

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    public final EntityRequestArgHelper getPresenter() {
        return this.presenter;
    }

    public final EntityListFixTopHelper getTopHelper() {
        return this.topHelper;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconTabViewHolder(View view, DataBindingComponent dataBindingComponent, EntityRequestArgHelper entityRequestArgHelper, EntityListFixTopHelper entityListFixTopHelper) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        Intrinsics.checkNotNullParameter(entityRequestArgHelper, "presenter");
        Intrinsics.checkNotNullParameter(entityListFixTopHelper, "topHelper");
        this.presenter = entityRequestArgHelper;
        this.topHelper = entityListFixTopHelper;
        ItemTabViewBinding itemTabViewBinding = (ItemTabViewBinding) getBinding();
        this.binding = itemTabViewBinding;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        FrameLayout frameLayout = itemTabViewBinding.tabContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.tabContainer");
        this.viewPart = companion.newInstance(frameLayout, this);
        AppTheme appTheme = AppHolder.getAppTheme();
        itemTabViewBinding.tabs.setTabTextColors(ResourceUtils.getColorInt(getContext(), 2131099891), appTheme.getColorAccent());
        itemTabViewBinding.tabs.setSelectedTabIndicatorColor(0);
        itemTabViewBinding.tabs.addOnTabSelectedListener(this);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TabLayout tabLayout = itemTabViewBinding.tabs;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        FakeTabIndicator fakeTabIndicator = new FakeTabIndicator(context, tabLayout);
        fakeTabIndicator.setSelectedIndicatorColor(appTheme.getColorAccent());
        fakeTabIndicator.setSelectedIndicatorHeight(DisplayUtils.dp2px(null, 2.5f));
        fakeTabIndicator.setIndicatorWidth(DisplayUtils.dp2px(null, 36.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DisplayUtils.dp2px(null, 2.5f));
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        fakeTabIndicator.setLayoutParams(layoutParams);
        Unit unit2 = Unit.INSTANCE;
        this.fakeIndicator = fakeTabIndicator;
        itemTabViewBinding.tabContainer.addView(fakeTabIndicator);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/IconTabViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconTabViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        if (!Intrinsics.areEqual(obj, this.card)) {
            this.isBinding = true;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
            EntityCard entityCard = (EntityCard) obj;
            this.card = entityCard;
            if (entityCard != null) {
                this.viewPart.bindToContent(entityCard);
                TabLayout tabLayout = this.binding.tabs;
                Intrinsics.checkNotNullExpressionValue(tabLayout, "binding.tabs");
                if (!Intrinsics.areEqual(tabLayout.getTag(), entityCard.getEntities())) {
                    this.binding.tabs.removeAllTabs();
                    List<Entity> entities = entityCard.getEntities();
                    Intrinsics.checkNotNull(entities);
                    Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
                    Iterator<T> it2 = entities.iterator();
                    while (it2.hasNext()) {
                        LayoutInflater from = LayoutInflater.from(getContext());
                        TabLayout.Tab newTab = this.binding.tabs.newTab();
                        Intrinsics.checkNotNullExpressionValue(newTab, "binding.tabs.newTab()");
                        ItemIconLinkMiniGridCardItemBinding itemIconLinkMiniGridCardItemBinding = (ItemIconLinkMiniGridCardItemBinding) DataBindingUtil.inflate(from, 2131558781, null, false, getComponent());
                        Intrinsics.checkNotNullExpressionValue(itemIconLinkMiniGridCardItemBinding, "childBinding");
                        itemIconLinkMiniGridCardItemBinding.setEntity(it2.next());
                        View root = itemIconLinkMiniGridCardItemBinding.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "childBinding.root");
                        root.setBackground(null);
                        itemIconLinkMiniGridCardItemBinding.executePendingBindings();
                        newTab.setCustomView(itemIconLinkMiniGridCardItemBinding.getRoot());
                        this.binding.tabs.addTab(newTab);
                    }
                    TabLayout tabLayout2 = this.binding.tabs;
                    Intrinsics.checkNotNullExpressionValue(tabLayout2, "binding.tabs");
                    tabLayout2.setTag(entityCard.getEntities());
                    List<Entity> entities2 = entityCard.getEntities();
                    Intrinsics.checkNotNull(entities2);
                    if (entities2.size() > 5) {
                        TabLayout tabLayout3 = this.binding.tabs;
                        Intrinsics.checkNotNullExpressionValue(tabLayout3, "binding.tabs");
                        tabLayout3.setTabMode(0);
                        this.fakeIndicator.setVisibility(8);
                        this.binding.tabs.setSelectedTabIndicatorColor(AppHolder.getAppTheme().getColorAccent());
                    } else {
                        TabLayout tabLayout4 = this.binding.tabs;
                        Intrinsics.checkNotNullExpressionValue(tabLayout4, "binding.tabs");
                        tabLayout4.setTabMode(1);
                        this.fakeIndicator.setVisibility(0);
                        this.binding.tabs.setSelectedTabIndicatorColor(0);
                    }
                }
                resetTab();
                EntityListFixTopHelper entityListFixTopHelper = this.topHelper;
                FrameLayout frameLayout = this.binding.tabContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.tabContainer");
                LinearLayout linearLayout = this.binding.itemView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
                entityListFixTopHelper.setFixTopView(frameLayout, linearLayout, (Parcelable) obj);
                this.isBinding = false;
            }
        }
    }

    private final int calcSelectedTab() {
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            return -1;
        }
        List<Entity> entities = entityCard.getEntities();
        if (entities != null) {
            int i = 0;
            for (T t : entities) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                if (t2 != null && Intrinsics.areEqual(t2, this.presenter.getRequestArg())) {
                    return i;
                }
                i = i2;
            }
        }
        return EntityExtendsKt.getIntExtraData(entityCard, "selectedTab", -1);
    }

    private final void resetTab() {
        int calcSelectedTab = calcSelectedTab();
        if (calcSelectedTab >= 0) {
            TabLayout.Tab tabAt = this.binding.tabs.getTabAt(calcSelectedTab);
            if (tabAt != null) {
                tabAt.select();
            }
            this.fakeIndicator.setIndicatorPositionFromTabPosition(calcSelectedTab, 0.0f);
        }
    }

    @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        EntityCard entityCard = this.card;
        if (entityCard != null) {
            List<Entity> entities = entityCard.getEntities();
            Intrinsics.checkNotNull(entities);
            Entity entity = entities.get(tab.getPosition());
            Intrinsics.checkNotNullExpressionValue(entity, "item");
            String url = entity.getUrl();
            boolean z = false;
            if (url == null || url.length() == 0) {
                resetTab();
            } else if (!this.isBinding) {
                this.fakeIndicator.animateIndicatorToPosition(tab.getPosition(), 300);
                if (EntityExtendsKt.getIntExtraData(entity, "openNewActivity", 0) != 1) {
                    z = true;
                }
                if (z) {
                    this.presenter.setRequestArg(entity);
                    return;
                }
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
            }
        }
    }
}
