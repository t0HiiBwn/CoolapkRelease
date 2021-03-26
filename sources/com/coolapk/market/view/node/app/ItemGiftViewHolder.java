package com.coolapk.market.view.node.app;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemAppNodeGiftBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.app.FetchGiftDialog;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/node/app/ItemGiftViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "(Landroid/view/View;Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "binding", "Lcom/coolapk/market/databinding/ItemAppNodeGiftBinding;", "kotlin.jvm.PlatformType", "gift", "Lcom/coolapk/market/model/Gift;", "bindTo", "", "item", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemGiftViewHolder.kt */
public final class ItemGiftViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558594;
    private final ItemAppNodeGiftBinding binding;
    private Gift gift;
    private final AppNodeViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/app/ItemGiftViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemGiftViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemGiftViewHolder(View view, AppNodeViewModel appNodeViewModel) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        this.viewModel = appNodeViewModel;
        ItemAppNodeGiftBinding itemAppNodeGiftBinding = (ItemAppNodeGiftBinding) getBinding();
        this.binding = itemAppNodeGiftBinding;
        Intrinsics.checkNotNullExpressionValue(itemAppNodeGiftBinding, "binding");
        itemAppNodeGiftBinding.getRoot().setOnClickListener(this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Gift");
        this.gift = (Gift) obj;
        ItemAppNodeGiftBinding itemAppNodeGiftBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemAppNodeGiftBinding, "binding");
        Gift gift2 = this.gift;
        if (gift2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gift");
        }
        itemAppNodeGiftBinding.setGift(gift2);
        ItemAppNodeGiftBinding itemAppNodeGiftBinding2 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemAppNodeGiftBinding2, "binding");
        itemAppNodeGiftBinding2.setClick(this);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ServiceApp serviceApp = this.viewModel.getServiceApp().get();
        Intrinsics.checkNotNull(serviceApp);
        Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get()!!");
        ServiceApp serviceApp2 = serviceApp;
        if (view.getId() != 2131362547) {
            Context context = getContext();
            Gift gift2 = this.gift;
            if (gift2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gift");
            }
            String giftUrl = UriUtils.getGiftUrl(gift2);
            Gift gift3 = this.gift;
            if (gift3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gift");
            }
            ActionManager.startGiftWebViewActivity(context, giftUrl, gift3, serviceApp2);
            return;
        }
        Gift gift4 = this.gift;
        if (gift4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gift");
        }
        if (!gift4.isRequireInstalled() || PackageUtils.isInstalled(getContext(), serviceApp2.getPackageName())) {
            Gift gift5 = this.gift;
            if (gift5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gift");
            }
            FetchGiftDialog newInstance = FetchGiftDialog.newInstance(gift5, serviceApp2);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context2).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
            return;
        }
        SimpleDialog newInstance2 = SimpleDialog.newInstance();
        newInstance2.setMessage(getContext().getString(2131886822));
        newInstance2.setPositiveButton(2131886128, new ItemGiftViewHolder$onClick$1(this, serviceApp2));
        newInstance2.setNegativeButton(2131886115);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(context3).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "context.requireAppCompat…().supportFragmentManager");
        newInstance2.show(supportFragmentManager2, (String) null);
    }
}
