package com.coolapk.market.view.goodsList;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemEditGoodsBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.center.TouchCallBack;
import com.coolapk.market.view.goodsList.AddGoodsDialogFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.touchhelper.ItemTouchHelperViewHolder;
import java.util.HashSet;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0002$%B5\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0017J\u001a\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListEditViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemEditGoodsBinding;", "Lcom/coolapk/market/model/GoodsListItem;", "Lcom/coolapk/market/widget/touchhelper/ItemTouchHelperViewHolder;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "callBack", "Lcom/coolapk/market/view/center/TouchCallBack;", "delList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/center/TouchCallBack;Ljava/util/HashSet;)V", "getCallBack", "()Lcom/coolapk/market/view/center/TouchCallBack;", "goodsListItem", "viewModel", "Lcom/coolapk/market/view/goodsList/GoodsListItemViewModel;", "bindToContent", "", "data", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "onClick", "view", "onItemClear", "position", "", "onItemSelected", "pickGoodsItem", "Companion", "ItemTouch", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsListEditViewHolder.kt */
public final class GoodsListEditViewHolder extends GenericBindHolder<ItemEditGoodsBinding, GoodsListItem> implements ItemTouchHelperViewHolder, CompoundButton.OnCheckedChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558692;
    private final TouchCallBack callBack;
    private final HashSet<GoodsListItem> delList;
    private GoodsListItem goodsListItem;
    private GoodsListItemViewModel viewModel;

    public final TouchCallBack getCallBack() {
        return this.callBack;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsListEditViewHolder(View view, DataBindingComponent dataBindingComponent, TouchCallBack touchCallBack, HashSet<GoodsListItem> hashSet) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(touchCallBack, "callBack");
        Intrinsics.checkNotNullParameter(hashSet, "delList");
        this.callBack = touchCallBack;
        this.delList = hashSet;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListEditViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsListEditViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(GoodsListItem goodsListItem2) {
        Intrinsics.checkNotNullParameter(goodsListItem2, "data");
        GoodsListItemViewModel goodsListItemViewModel = new GoodsListItemViewModel();
        this.viewModel = goodsListItemViewModel;
        if (goodsListItemViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        goodsListItemViewModel.setGoodsListItem(goodsListItem2);
        GoodsListItemViewModel goodsListItemViewModel2 = this.viewModel;
        if (goodsListItemViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        this.goodsListItem = goodsListItemViewModel2.getGoodsListItem();
        ItemEditGoodsBinding itemEditGoodsBinding = (ItemEditGoodsBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemEditGoodsBinding, "binding");
        GoodsListItemViewModel goodsListItemViewModel3 = this.viewModel;
        if (goodsListItemViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        itemEditGoodsBinding.setModel(goodsListItemViewModel3);
        ItemEditGoodsBinding itemEditGoodsBinding2 = (ItemEditGoodsBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemEditGoodsBinding2, "binding");
        itemEditGoodsBinding2.setClick(this);
        CheckBox checkBox = ((ItemEditGoodsBinding) getBinding()).checkView;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkView");
        checkBox.setChecked(this.delList.contains(goodsListItem2));
        ((ItemEditGoodsBinding) getBinding()).checkView.setOnCheckedChangeListener(this);
        ((ItemEditGoodsBinding) getBinding()).dragView.setOnTouchListener(new ItemTouch(this, this));
        ((ItemEditGoodsBinding) getBinding()).executePendingBindings();
    }

    private final void pickGoodsItem() {
        if (CollectionsKt.contains(this.delList, this.goodsListItem)) {
            CheckBox checkBox = ((ItemEditGoodsBinding) getBinding()).checkView;
            Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkView");
            checkBox.setChecked(false);
            HashSet<GoodsListItem> hashSet = this.delList;
            GoodsListItem goodsListItem2 = this.goodsListItem;
            Objects.requireNonNull(hashSet, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            TypeIntrinsics.asMutableCollection(hashSet).remove(goodsListItem2);
        } else {
            HashSet<GoodsListItem> hashSet2 = this.delList;
            GoodsListItem goodsListItem3 = this.goodsListItem;
            Intrinsics.checkNotNull(goodsListItem3);
            hashSet2.add(goodsListItem3);
            CheckBox checkBox2 = ((ItemEditGoodsBinding) getBinding()).checkView;
            Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.checkView");
            checkBox2.setChecked(true);
        }
        DataBindingComponent component = getComponent();
        LifecycleOwner lifecycleOwner = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (lifecycleOwner2 instanceof GoodGoodsEditListFragment) {
            lifecycleOwner = lifecycleOwner2;
        }
        GoodGoodsEditListFragment goodGoodsEditListFragment = (GoodGoodsEditListFragment) lifecycleOwner;
        if (goodGoodsEditListFragment != null) {
            goodGoodsEditListFragment.delListChange();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131363038) {
            Activity activityNullable = UiUtils.getActivityNullable(getContext());
            AddGoodsDialogFragment.Companion companion = AddGoodsDialogFragment.Companion;
            GoodsListItem goodsListItem2 = this.goodsListItem;
            String feedId = goodsListItem2 != null ? goodsListItem2.getFeedId() : null;
            Intrinsics.checkNotNull(feedId);
            Intrinsics.checkNotNullExpressionValue(feedId, "goodsListItem?.feedId!!");
            GoodsListItem goodsListItem3 = this.goodsListItem;
            String productGoodsId = goodsListItem3 != null ? goodsListItem3.getProductGoodsId() : null;
            Intrinsics.checkNotNull(productGoodsId);
            Intrinsics.checkNotNullExpressionValue(productGoodsId, "goodsListItem?.productGoodsId!!");
            GoodsListItem goodsListItem4 = this.goodsListItem;
            String productGoodsLogo = goodsListItem4 != null ? goodsListItem4.getProductGoodsLogo() : null;
            Intrinsics.checkNotNull(productGoodsLogo);
            Intrinsics.checkNotNullExpressionValue(productGoodsLogo, "goodsListItem?.productGoodsLogo!!");
            GoodsListItem goodsListItem5 = this.goodsListItem;
            String productGoodsTitle = goodsListItem5 != null ? goodsListItem5.getProductGoodsTitle() : null;
            Intrinsics.checkNotNull(productGoodsTitle);
            Intrinsics.checkNotNullExpressionValue(productGoodsTitle, "goodsListItem?.productGoodsTitle!!");
            GoodsListItem goodsListItem6 = this.goodsListItem;
            String note = goodsListItem6 != null ? goodsListItem6.getNote() : null;
            Intrinsics.checkNotNull(note);
            Intrinsics.checkNotNullExpressionValue(note, "goodsListItem?.note!!");
            AddGoodsDialogFragment newInstance = companion.newInstance(feedId, productGoodsId, productGoodsLogo, productGoodsTitle, note, true);
            GoodsListItemViewModel goodsListItemViewModel = this.viewModel;
            if (goodsListItemViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            newInstance.setViewModel(goodsListItemViewModel);
            Intrinsics.checkNotNullExpressionValue(activityNullable, "activity");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activityNullable).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        } else if (valueOf != null && valueOf.intValue() == 2131362205) {
            pickGoodsItem();
        }
    }

    @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperViewHolder
    public void onItemSelected() {
        ((ItemEditGoodsBinding) getBinding()).cardView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        ((ItemEditGoodsBinding) getBinding()).cardView.animate().scaleX(1.1f).scaleY(1.1f).z((float) NumberExtendsKt.getDp((Number) 8)).setListener(null).start();
    }

    @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperViewHolder
    public void onItemClear(int i) {
        GoodsListEditViewHolder goodsListEditViewHolder = this;
        this.callBack.findPosition(i, goodsListEditViewHolder);
        ((ItemEditGoodsBinding) getBinding()).cardView.animate().scaleX(1.0f).scaleY(1.0f).z((float) NumberExtendsKt.getDp((Number) 0)).setListener(new GoodsListEditViewHolder$onItemClear$1(this)).start();
        this.callBack.itemClear(i, goodsListEditViewHolder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListEditViewHolder$ItemTouch;", "Landroid/view/View$OnTouchListener;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/coolapk/market/view/goodsList/GoodsListEditViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsListEditViewHolder.kt */
    private final class ItemTouch implements View.OnTouchListener {
        private final RecyclerView.ViewHolder holder;
        final /* synthetic */ GoodsListEditViewHolder this$0;

        public ItemTouch(GoodsListEditViewHolder goodsListEditViewHolder, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            this.this$0 = goodsListEditViewHolder;
            this.holder = viewHolder;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(view, "v");
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            int action = motionEvent.getAction();
            if (action == 0) {
                this.this$0.getCallBack().downTouch(view, this.holder);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.this$0.getCallBack().upTouch(view, this.holder);
                return false;
            }
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
            if (z) {
                if (!CollectionsKt.contains(this.delList, this.goodsListItem)) {
                    HashSet<GoodsListItem> hashSet = this.delList;
                    GoodsListItem goodsListItem2 = this.goodsListItem;
                    Intrinsics.checkNotNull(goodsListItem2);
                    hashSet.add(goodsListItem2);
                }
            } else if (CollectionsKt.contains(this.delList, this.goodsListItem)) {
                HashSet<GoodsListItem> hashSet2 = this.delList;
                GoodsListItem goodsListItem3 = this.goodsListItem;
                Objects.requireNonNull(hashSet2, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                TypeIntrinsics.asMutableCollection(hashSet2).remove(goodsListItem3);
            }
            DataBindingComponent component = getComponent();
            LifecycleOwner lifecycleOwner = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (lifecycleOwner2 instanceof GoodGoodsEditListFragment) {
                lifecycleOwner = lifecycleOwner2;
            }
            GoodGoodsEditListFragment goodGoodsEditListFragment = (GoodGoodsEditListFragment) lifecycleOwner;
            if (goodGoodsEditListFragment != null) {
                goodGoodsEditListFragment.delListChange();
            }
        }
    }
}
