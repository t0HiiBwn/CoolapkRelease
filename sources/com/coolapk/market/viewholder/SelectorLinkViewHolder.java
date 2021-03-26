package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemSelectorLinkViewBinding;
import com.coolapk.market.databinding.ItemTitleViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.SimpleEntity;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import com.coolapk.market.view.cardlist.EntityRequestArgHelper;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.viewholder.iview.ViewPart;
import com.coolapk.market.widget.CoolFlowLayout;
import com.coolapk.market.widget.LinearAdapterLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005,-./0B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\"\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\"\u0010*\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u000f0+0\u000f*\u00020\u0003R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/coolapk/market/viewholder/SelectorLinkViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemSelectorLinkViewBinding;", "Lcom/coolapk/market/model/EntityCard;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "entityRequestArgHelper", "Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;", "entityListFixTopHelper", "Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;)V", "data", "defaultSelectedTitle", "", "", "getEntityListFixTopHelper", "()Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "getEntityRequestArgHelper", "()Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;", "groupAdapter", "Lcom/coolapk/market/viewholder/SelectorLinkViewHolder$SelectorGroupAdapter;", "isFixingTop", "", "isMultiSelectMode", "titleViewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindToContent", "", "findOrCreateViewPart", "Lcom/coolapk/market/viewholder/SelectorLinkViewHolder$SelectiveViewPart;", "convertView", "parent", "Landroid/view/ViewGroup;", "layoutType", "isChildEntitySelected", "entity", "Lcom/coolapk/market/model/Entity;", "measureAndCheckFixTop", "onItemClick", "updateCoolFlowView", "getSubMenu", "Lkotlin/Pair;", "ButtonTextViewPart", "Companion", "SelectiveViewPart", "SelectorAdapter", "SelectorGroupAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SelectorLinkViewHolder.kt */
public final class SelectorLinkViewHolder extends GenericBindHolder<ItemSelectorLinkViewBinding, EntityCard> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558930;
    public static final String LAYOUT_TYPE_BUTTON = "button";
    public static final String LAYOUT_TYPE_CAPSULE = "capsule";
    public static final String LAYOUT_TYPE_MINI_BUTTON = "miniButton";
    public static final String LAYOUT_TYPE_MINI_CAPSULE = "miniCapsule";
    private static final String[] VALID_LAYOUT_TYPE_GROUP = {"capsule", "button", "miniButton", "miniCapsule"};
    private EntityCard data;
    private List<String> defaultSelectedTitle = CollectionsKt.emptyList();
    private final EntityListFixTopHelper entityListFixTopHelper;
    private final EntityRequestArgHelper entityRequestArgHelper;
    private SelectorGroupAdapter groupAdapter;
    private boolean isFixingTop;
    private boolean isMultiSelectMode;
    private final TitleViewPart titleViewPart;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/coolapk/market/viewholder/SelectorLinkViewHolder$SelectiveViewPart;", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "bindTo", "", "entity", "Lcom/coolapk/market/model/Entity;", "selected", "", "fixingTop", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SelectorLinkViewHolder.kt */
    public interface SelectiveViewPart {
        void bindTo(Entity entity, boolean z, boolean z2);

        View getView();
    }

    public final EntityRequestArgHelper getEntityRequestArgHelper() {
        return this.entityRequestArgHelper;
    }

    public final EntityListFixTopHelper getEntityListFixTopHelper() {
        return this.entityListFixTopHelper;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectorLinkViewHolder(View view, DataBindingComponent dataBindingComponent, EntityRequestArgHelper entityRequestArgHelper2, EntityListFixTopHelper entityListFixTopHelper2) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityRequestArgHelper2, "entityRequestArgHelper");
        Intrinsics.checkNotNullParameter(entityListFixTopHelper2, "entityListFixTopHelper");
        this.entityRequestArgHelper = entityRequestArgHelper2;
        this.entityListFixTopHelper = entityListFixTopHelper2;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        LinearAdapterLayout linearAdapterLayout = ((ItemSelectorLinkViewBinding) getBinding()).itemView;
        Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.itemView");
        TitleViewPart newInstance = companion.newInstance(linearAdapterLayout, this);
        this.titleViewPart = newInstance;
        final View root = ((ItemTitleViewBinding) newInstance.getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "titleViewPart.binding.root");
        root.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            /* class com.coolapk.market.viewholder.SelectorLinkViewHolder.AnonymousClass1 */
            final /* synthetic */ SelectorLinkViewHolder this$0;

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "v");
            }

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "v");
                if (Intrinsics.areEqual(root.getParent(), ((ItemSelectorLinkViewBinding) this.this$0.getBinding()).frameView)) {
                    root.setElevation((float) NumberExtendsKt.getDp((Number) 0));
                    root.setBackground(null);
                    ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(root);
                    if (marginParams != null) {
                        marginParams.bottomMargin = NumberExtendsKt.getDp((Number) 0);
                    }
                    this.this$0.isFixingTop = false;
                } else {
                    this.this$0.isFixingTop = true;
                    root.setElevation((float) NumberExtendsKt.getDp((Number) 1));
                    root.setBackground(new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor()));
                    ViewGroup.MarginLayoutParams marginParams2 = ViewExtendsKt.getMarginParams(root);
                    if (marginParams2 != null) {
                        marginParams2.bottomMargin = NumberExtendsKt.getDp((Number) 1);
                    }
                }
                this.this$0.updateCoolFlowView();
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/SelectorLinkViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "LAYOUT_TYPE_BUTTON", "", "LAYOUT_TYPE_CAPSULE", "LAYOUT_TYPE_MINI_BUTTON", "LAYOUT_TYPE_MINI_CAPSULE", "VALID_LAYOUT_TYPE_GROUP", "", "getVALID_LAYOUT_TYPE_GROUP", "()[Ljava/lang/String;", "[Ljava/lang/String;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SelectorLinkViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String[] getVALID_LAYOUT_TYPE_GROUP() {
            return SelectorLinkViewHolder.VALID_LAYOUT_TYPE_GROUP;
        }
    }

    public void bindToContent(EntityCard entityCard) {
        String str;
        Intrinsics.checkNotNullParameter(entityCard, "data");
        if (Intrinsics.areEqual(this.data, entityCard)) {
            measureAndCheckFixTop();
            return;
        }
        this.data = entityCard;
        this.titleViewPart.bindToContent(entityCard);
        ((ItemSelectorLinkViewBinding) getBinding()).executePendingBindings();
        String url = entityCard.getUrl();
        this.isMultiSelectMode = !(url == null || StringsKt.isBlank(url));
        EntityCard entityCard2 = entityCard;
        this.defaultSelectedTitle = StringsKt.split$default((CharSequence) EntityExtendsKt.getStringExtraData(entityCard2, "selectedTab", ""), new String[]{"|"}, false, 0, 6, (Object) null);
        String stringExtraData = EntityExtendsKt.getStringExtraData(entityCard2, "cardLayoutMode", "flex");
        String str2 = "FLEX";
        switch (stringExtraData.hashCode()) {
            case -907680051:
                if (stringExtraData.equals("scroll")) {
                    str2 = "SCROLL";
                    break;
                }
                break;
            case 3145721:
                stringExtraData.equals("flex");
                break;
            case 3181382:
                if (stringExtraData.equals("grid")) {
                    str2 = "GRID";
                    break;
                }
                break;
            case 96757556:
                if (stringExtraData.equals("equal")) {
                    str2 = "EQUAL";
                    break;
                }
                break;
        }
        String stringExtraData2 = EntityExtendsKt.getStringExtraData(entityCard2, "cardLayoutStyle", "button");
        if (ArraysKt.contains(VALID_LAYOUT_TYPE_GROUP, stringExtraData2)) {
            str = stringExtraData2;
        } else {
            str = "button";
        }
        List<Pair<String, List<Entity>>> subMenu = getSubMenu(entityCard);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.groupAdapter = new SelectorGroupAdapter(this, context, subMenu, str2, str);
        LinearAdapterLayout linearAdapterLayout = ((ItemSelectorLinkViewBinding) getBinding()).itemView;
        Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.itemView");
        linearAdapterLayout.setAdapter(this.groupAdapter);
        measureAndCheckFixTop();
    }

    private final void measureAndCheckFixTop() {
        EntityCard entityCard = this.data;
        if (entityCard == null) {
            return;
        }
        if (EntityExtendsKt.getIntExtraData(entityCard, "cardFixedToTop", 0) == 1) {
            View root = ((ItemTitleViewBinding) this.titleViewPart.getBinding()).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "titleViewPart.binding.root");
            if (Intrinsics.areEqual(root.getParent(), ((ItemSelectorLinkViewBinding) getBinding()).frameView)) {
                FrameLayout frameLayout = ((ItemSelectorLinkViewBinding) getBinding()).frameView;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frameView");
                ViewExtendsKt.measureWithScreenWidth$default(frameLayout, 0, 1, null);
                FrameLayout frameLayout2 = ((ItemSelectorLinkViewBinding) getBinding()).frameView;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.frameView");
                FrameLayout frameLayout3 = ((ItemSelectorLinkViewBinding) getBinding()).frameView;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.frameView");
                frameLayout2.setMinimumHeight(frameLayout3.getMeasuredHeight());
            }
            EntityListFixTopHelper entityListFixTopHelper2 = this.entityListFixTopHelper;
            FrameLayout frameLayout4 = ((ItemSelectorLinkViewBinding) getBinding()).frameView;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.frameView");
            entityListFixTopHelper2.setFixTopView(root, frameLayout4, entityCard);
            return;
        }
        FrameLayout frameLayout5 = ((ItemSelectorLinkViewBinding) getBinding()).frameView;
        Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.frameView");
        frameLayout5.setMinimumHeight(0);
        this.entityListFixTopHelper.unsetTopView();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001B=\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/viewholder/SelectorLinkViewHolder$SelectorGroupAdapter;", "Landroid/widget/ArrayAdapter;", "Lkotlin/Pair;", "", "", "Lcom/coolapk/market/model/Entity;", "context", "Landroid/content/Context;", "data", "flowLayoutMode", "layoutType", "(Lcom/coolapk/market/viewholder/SelectorLinkViewHolder;Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SelectorLinkViewHolder.kt */
    public final class SelectorGroupAdapter extends ArrayAdapter<Pair<? extends String, ? extends List<? extends Entity>>> {
        private final String flowLayoutMode;
        private final String layoutType;
        final /* synthetic */ SelectorLinkViewHolder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectorGroupAdapter(SelectorLinkViewHolder selectorLinkViewHolder, Context context, List<? extends Pair<String, ? extends List<? extends Entity>>> list, String str, String str2) {
            super(context, 0, list);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "data");
            Intrinsics.checkNotNullParameter(str, "flowLayoutMode");
            Intrinsics.checkNotNullParameter(str2, "layoutType");
            this.this$0 = selectorLinkViewHolder;
            this.flowLayoutMode = str;
            this.layoutType = str2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x00ae, code lost:
            if (r5.equals("capsule") != false) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x00b7, code lost:
            if (r5.equals("button") != false) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x00b9, code lost:
            r10.setTextSize(14.0f);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00c5, code lost:
            if (r5.equals("miniButton") != false) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00c7, code lost:
            r10.setTextSize(13.0f);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0142, code lost:
            if (r1.equals("GRID") != false) goto L_0x0156;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x014b, code lost:
            if (r1.equals("FLEX") != false) goto L_0x0156;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0154, code lost:
            if (r1.equals("SCROLL") != false) goto L_0x0156;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0156, code lost:
            r0.setHorizontalDividerWidth(com.coolapk.market.extend.NumberExtendsKt.getDp((java.lang.Number) 12));
            r0.setVerticalDividerHeight(com.coolapk.market.extend.NumberExtendsKt.getDp((java.lang.Number) 12));
            r0.setPadding(com.coolapk.market.view.cardlist.divider.ViewMarginData.Companion.getDEFAULT_SIZE(), 0, com.coolapk.market.view.cardlist.divider.ViewMarginData.Companion.getDEFAULT_SIZE(), 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x00a5, code lost:
            if (r5.equals("miniCapsule") != false) goto L_0x00c7;
         */
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Object item = getItem(i);
            Intrinsics.checkNotNull(item);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
            Pair pair = (Pair) item;
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            boolean z = true;
            linearLayout.setOrientation(1);
            if (((CharSequence) pair.getFirst()).length() <= 0) {
                z = false;
            }
            if (z) {
                TextView textView = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = ViewMarginData.Companion.getDEFAULT_SIZE();
                layoutParams.topMargin = NumberExtendsKt.getDp((Number) 6);
                layoutParams.rightMargin = NumberExtendsKt.getDp((Number) 16);
                layoutParams.bottomMargin = NumberExtendsKt.getDp((Number) 6);
                Unit unit = Unit.INSTANCE;
                textView.setLayoutParams(layoutParams);
                textView.setText((CharSequence) pair.getFirst());
                textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
                String str = this.layoutType;
                switch (str.hashCode()) {
                    case -1613931927:
                        break;
                    case -1377687758:
                        break;
                    case 552555053:
                        break;
                    case 1818920406:
                        break;
                }
                linearLayout.addView(textView);
            }
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = NumberExtendsKt.getDp((Number) 6);
            layoutParams2.bottomMargin = NumberExtendsKt.getDp((Number) 6);
            Unit unit2 = Unit.INSTANCE;
            horizontalScrollView.setLayoutParams(layoutParams2);
            horizontalScrollView.setScrollBarSize(0);
            horizontalScrollView.setHorizontalScrollBarEnabled(false);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            CoolFlowLayout coolFlowLayout = new CoolFlowLayout(context, null, 2, null);
            coolFlowLayout.setLayoutMode(this.flowLayoutMode);
            String str2 = this.flowLayoutMode;
            switch (str2.hashCode()) {
                case -1854350643:
                    break;
                case 2160633:
                    break;
                case 2196294:
                    break;
                case 66219796:
                    if (str2.equals("EQUAL")) {
                        coolFlowLayout.setHorizontalDividerWidth(NumberExtendsKt.getDp((Number) 16));
                        coolFlowLayout.setPadding(0, 0, 0, 0);
                        break;
                    }
                    break;
            }
            SelectorLinkViewHolder selectorLinkViewHolder = this.this$0;
            Context context2 = coolFlowLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            coolFlowLayout.setAdapter(new SelectorAdapter(selectorLinkViewHolder, context2, (List) pair.getSecond(), this.layoutType));
            horizontalScrollView.addView(coolFlowLayout);
            linearLayout.addView(horizontalScrollView);
            return linearLayout;
        }
    }

    /* access modifiers changed from: private */
    public final void onItemClick(Entity entity) {
        Object obj;
        String str = null;
        if (this.isMultiSelectMode) {
            EntityCard entityCard = this.data;
            if (entityCard != null) {
                String url = entityCard.getUrl();
                if (url == null) {
                    url = "";
                }
                Uri parse = Uri.parse(url);
                HashMap hashMap = new HashMap();
                Intrinsics.checkNotNullExpressionValue(parse, "baseUri");
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null) {
                    for (T t : queryParameterNames) {
                        String queryParameter = parse.getQueryParameter(t);
                        if (queryParameter == null) {
                            queryParameter = "";
                        }
                        hashMap.put(t, queryParameter);
                    }
                }
                Uri.Builder clearQuery = parse.buildUpon().clearQuery();
                for (T t2 : getSubMenu(entityCard)) {
                    if (((List) t2.getSecond()).contains(entity)) {
                        HashMap hashMap2 = hashMap;
                        String entityType = entity.getEntityType();
                        Intrinsics.checkNotNullExpressionValue(entityType, "entity.entityType");
                        String url2 = entity.getUrl();
                        if (url2 == null) {
                            url2 = "";
                        }
                        hashMap2.put(entityType, url2);
                    } else {
                        Iterator it2 = ((Iterable) t2.getSecond()).iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            if (isChildEntitySelected((Entity) obj)) {
                                break;
                            }
                        }
                        Entity entity2 = (Entity) obj;
                        if (entity2 != null) {
                            HashMap hashMap3 = hashMap;
                            String entityType2 = entity2.getEntityType();
                            Intrinsics.checkNotNullExpressionValue(entityType2, "selected.entityType");
                            String url3 = entity2.getUrl();
                            if (url3 == null) {
                                url3 = "";
                            }
                            hashMap3.put(entityType2, url3);
                        }
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    clearQuery.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                this.entityRequestArgHelper.setRequestArg(SimpleEntity.builder().setEntityType(entity.getEntityType()).setUrl(clearQuery.build().toString()).build());
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                DataBindingComponent component = getComponent();
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (!(fragment instanceof BaseFragment)) {
                    fragment = null;
                }
                BaseFragment baseFragment = (BaseFragment) fragment;
                if (baseFragment != null) {
                    str = baseFragment.getFixedRecordId();
                }
                instance.recordEntityEvent(str, entity, getAdapterPosition(), null, "多选");
            } else {
                return;
            }
        } else {
            this.entityRequestArgHelper.setRequestArg(entity);
            StatisticHelper instance2 = StatisticHelper.Companion.getInstance();
            DataBindingComponent component2 = getComponent();
            if (!(component2 instanceof FragmentBindingComponent)) {
                component2 = null;
            }
            FragmentBindingComponent fragmentBindingComponent2 = (FragmentBindingComponent) component2;
            Fragment fragment2 = fragmentBindingComponent2 != null ? (Fragment) fragmentBindingComponent2.getContainer() : null;
            if (!(fragment2 instanceof BaseFragment)) {
                fragment2 = null;
            }
            BaseFragment baseFragment2 = (BaseFragment) fragment2;
            if (baseFragment2 != null) {
                str = baseFragment2.getFixedRecordId();
            }
            StatisticHelper.recordEntityEvent$default(instance2, str, entity, getAdapterPosition(), null, null, 16, null);
        }
        updateCoolFlowView();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        if (r4 == null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        r4 = r4.getTag(2131363510);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if ((r4 instanceof com.coolapk.market.viewholder.SelectorLinkViewHolder.ButtonTextViewPart) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r1 == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r1 = new com.coolapk.market.viewholder.SelectorLinkViewHolder.ButtonTextViewPart();
        r4 = android.view.LayoutInflater.from(getContext());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "LayoutInflater.from(context)");
        r1.createView(r4, r5);
        r1.getView().setTag(2131363510, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        r1.setShape(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0063, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r6.equals("miniCapsule") != false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r6.equals("capsule") != false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (r6.equals("button") != false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r6.equals("miniButton") != false) goto L_0x002b;
     */
    public final SelectiveViewPart findOrCreateViewPart(View view, ViewGroup viewGroup, String str) {
        switch (str.hashCode()) {
            case -1613931927:
                break;
            case -1377687758:
                break;
            case 552555053:
                break;
            case 1818920406:
                break;
            default:
                throw new RuntimeException("make sure it will not happen");
        }
    }

    /* access modifiers changed from: private */
    public final boolean isChildEntitySelected(Entity entity) {
        Entity requestArg = this.entityRequestArgHelper.getRequestArg();
        String url = requestArg != null ? requestArg.getUrl() : null;
        String str = url;
        if (str == null || StringsKt.isBlank(str)) {
            return CollectionsKt.contains(this.defaultSelectedTitle, entity.getTitle());
        }
        if (this.isMultiSelectMode) {
            return Intrinsics.areEqual(entity.getUrl(), Uri.parse(url).getQueryParameter(entity.getEntityType()));
        }
        return Intrinsics.areEqual(entity.getUrl(), url);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/viewholder/SelectorLinkViewHolder$ButtonTextViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "Lcom/coolapk/market/viewholder/SelectorLinkViewHolder$SelectiveViewPart;", "()V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "bindTo", "", "entity", "Lcom/coolapk/market/model/Entity;", "selected", "", "fixingTop", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "setMiniMode", "mini", "setShape", "type", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SelectorLinkViewHolder.kt */
    private static final class ButtonTextViewPart extends ViewPart implements SelectiveViewPart {
        private final TextView getTextView() {
            View view = getView();
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) view;
        }

        @Override // com.coolapk.market.viewholder.iview.ViewPart
        protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            TextView textView = new TextView(layoutInflater.getContext());
            textView.setGravity(17);
            textView.setTextSize(14.0f);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setMaxLines(1);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            TextView textView2 = textView;
            ViewExtendsKt.setCompatForeground(textView2, ResourceUtils.getDrawable(textView.getContext(), ResourceUtils.resolveResId(textView.getContext(), 16843534)));
            ViewExtendsKt.clipView(textView2, 0, (float) NumberExtendsKt.getDp((Number) 4));
            textView.setPadding(NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 6), NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 6));
            return textView2;
        }

        private final void setMiniMode(boolean z) {
            TextView textView = getTextView();
            if (z) {
                textView.setTextSize(12.0f);
                textView.setPadding(NumberExtendsKt.getDp((Number) 10), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 10), NumberExtendsKt.getDp((Number) 4));
                return;
            }
            textView.setTextSize(14.0f);
            textView.setPadding(NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 6), NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 6));
        }

        public final void setShape(String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            switch (str.hashCode()) {
                case -1613931927:
                    if (str.equals("miniButton")) {
                        setMiniMode(true);
                        ViewExtendsKt.clipView$default(getTextView(), 0, (float) NumberExtendsKt.getDp((Number) 4), 1, null);
                        return;
                    }
                    return;
                case -1377687758:
                    if (str.equals("button")) {
                        setMiniMode(false);
                        ViewExtendsKt.clipView$default(getTextView(), 0, (float) NumberExtendsKt.getDp((Number) 4), 1, null);
                        return;
                    }
                    return;
                case 552555053:
                    if (str.equals("capsule")) {
                        setMiniMode(false);
                        ViewExtendsKt.clipView$default(getTextView(), 2, 0.0f, 2, null);
                        return;
                    }
                    return;
                case 1818920406:
                    if (str.equals("miniCapsule")) {
                        setMiniMode(true);
                        ViewExtendsKt.clipView$default(getTextView(), 2, 0.0f, 2, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // com.coolapk.market.viewholder.SelectorLinkViewHolder.SelectiveViewPart
        public void bindTo(Entity entity, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            getTextView().setText(entity.getTitle());
            if (z) {
                getTextView().setBackgroundColor(AppHolder.getAppTheme().getColorAccent());
                getTextView().setTextColor(AppHolder.getAppTheme().getContentBackgroundColor());
            } else if (z2) {
                getTextView().setBackgroundColor(ResourceUtils.resolveData(getTextView().getContext(), 2130968793));
                getTextView().setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            } else {
                getTextView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
                getTextView().setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/viewholder/SelectorLinkViewHolder$SelectorAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/coolapk/market/model/Entity;", "context", "Landroid/content/Context;", "data", "", "layoutType", "", "(Lcom/coolapk/market/viewholder/SelectorLinkViewHolder;Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SelectorLinkViewHolder.kt */
    public final class SelectorAdapter extends ArrayAdapter<Entity> {
        private final String layoutType;
        final /* synthetic */ SelectorLinkViewHolder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectorAdapter(SelectorLinkViewHolder selectorLinkViewHolder, Context context, List<? extends Entity> list, String str) {
            super(context, 0, list);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "data");
            Intrinsics.checkNotNullParameter(str, "layoutType");
            this.this$0 = selectorLinkViewHolder;
            this.layoutType = str;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Object item = getItem(i);
            Intrinsics.checkNotNull(item);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
            Entity entity = (Entity) item;
            SelectiveViewPart findOrCreateViewPart = this.this$0.findOrCreateViewPart(view, viewGroup, this.layoutType);
            findOrCreateViewPart.bindTo(entity, this.this$0.isChildEntitySelected(entity), this.this$0.isFixingTop);
            ViewExtendsKt.setUtilClickListener(findOrCreateViewPart.getView(), new SelectorLinkViewHolder$SelectorAdapter$getView$1(this, entity));
            return findOrCreateViewPart.getView();
        }
    }

    public final List<Pair<String, List<Entity>>> getSubMenu(EntityCard entityCard) {
        String str;
        Intrinsics.checkNotNullParameter(entityCard, "$this$getSubMenu");
        ArrayList arrayList = new ArrayList();
        List<Entity> entities = entityCard.getEntities();
        if (entities != null && !entities.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = entities.iterator();
            loop0:
            while (true) {
                str = "";
                while (true) {
                    if (!it2.hasNext()) {
                        break loop0;
                    }
                    T next = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next, "it");
                    String url = next.getUrl();
                    if (url == null || url.length() == 0) {
                        ArrayList arrayList3 = arrayList2;
                        if (true ^ arrayList3.isEmpty()) {
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.addAll(arrayList3);
                            Unit unit = Unit.INSTANCE;
                            arrayList.add(TuplesKt.to(str, arrayList4));
                            arrayList2.clear();
                        }
                        str = next.getTitle();
                        if (str != null) {
                        }
                    } else {
                        arrayList2.add(next);
                    }
                }
            }
            ArrayList arrayList5 = arrayList2;
            if (!arrayList5.isEmpty()) {
                ArrayList arrayList6 = new ArrayList();
                arrayList6.addAll(arrayList5);
                Unit unit2 = Unit.INSTANCE;
                arrayList.add(TuplesKt.to(str, arrayList6));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void updateCoolFlowView() {
        LinearAdapterLayout linearAdapterLayout = ((ItemSelectorLinkViewBinding) getBinding()).itemView;
        Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.itemView");
        ViewExtendsKt.foreachChild(linearAdapterLayout, 3, SelectorLinkViewHolder$updateCoolFlowView$1.INSTANCE);
    }
}
