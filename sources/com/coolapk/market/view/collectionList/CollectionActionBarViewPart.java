package com.coolapk.market.view.collectionList;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.ItemCollectionFootBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001 B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0014J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u000eH\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionActionBarViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemCollectionFootBinding;", "Lcom/coolapk/market/model/Collection;", "Landroid/view/View$OnClickListener;", "()V", "collection", "getCollection", "()Lcom/coolapk/market/model/Collection;", "setCollection", "(Lcom/coolapk/market/model/Collection;)V", "externalListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "getExternalListener", "()Lkotlin/jvm/functions/Function1;", "setExternalListener", "(Lkotlin/jvm/functions/Function1;)V", "applyWindowsInset", "inset", "Landroid/graphics/Rect;", "onBindToContent", "data", "onClick", "v", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionActionBarViewPart.kt */
public final class CollectionActionBarViewPart extends BindingViewPart<ItemCollectionFootBinding, Collection> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private Collection collection;
    private Function1<? super View, Unit> externalListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionActionBarViewPart$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/collectionList/CollectionActionBarViewPart;", "collection", "Lcom/coolapk/market/model/Collection;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CollectionActionBarViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CollectionActionBarViewPart newInstance(Collection collection, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(collection, "collection");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            CollectionActionBarViewPart collectionActionBarViewPart = new CollectionActionBarViewPart();
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewGroup.context)");
            collectionActionBarViewPart.createView(from, viewGroup);
            collectionActionBarViewPart.bindToContent(collection);
            return collectionActionBarViewPart;
        }
    }

    public final Collection getCollection() {
        return this.collection;
    }

    public final void setCollection(Collection collection2) {
        this.collection = collection2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit>, kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> */
    public final Function1<View, Unit> getExternalListener() {
        return this.externalListener;
    }

    public final void setExternalListener(Function1<? super View, Unit> function1) {
        this.externalListener = function1;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemCollectionFootBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558660, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…n_foot, viewGroup, false)");
        return (ItemCollectionFootBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        View root = ((ItemCollectionFootBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtendsKt.setTopElevation$default(root, 0.0f, 1, null);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Collection collection2) {
        Intrinsics.checkNotNullParameter(collection2, "data");
        super.onBindToContent((CollectionActionBarViewPart) collection2);
        if (!Intrinsics.areEqual(this.collection, collection2)) {
            this.collection = collection2;
            ((ItemCollectionFootBinding) getBinding()).setClick(this);
            String str = "1w+";
            String valueOf = collection2.getLikeNum() < 9999 ? String.valueOf(collection2.getLikeNum()) : str;
            if (collection2.getShareNum() < 9999) {
                str = String.valueOf(collection2.getShareNum());
            }
            TextView textView = ((ItemCollectionFootBinding) getBinding()).likeTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.likeTextView");
            if (collection2.getLikeNum() <= 0) {
                valueOf = "点赞";
            }
            textView.setText(valueOf);
            TextView textView2 = ((ItemCollectionFootBinding) getBinding()).shareTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.shareTextView");
            if (collection2.getShareNum() <= 0) {
                str = "分享";
            }
            textView2.setText(str);
            TextView textView3 = ((ItemCollectionFootBinding) getBinding()).followTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.followTextView");
            UserAction userAction = collection2.getUserAction();
            Intrinsics.checkNotNull(userAction);
            Intrinsics.checkNotNullExpressionValue(userAction, "data.userAction!!");
            boolean z = true;
            textView3.setText(userAction.getFollow() == 1 ? "已关注" : "关注");
            ((ItemCollectionFootBinding) getBinding()).executePendingBindings();
            UserAction userAction2 = collection2.getUserAction();
            boolean z2 = userAction2 != null && userAction2.getLike() == 1;
            UserAction userAction3 = collection2.getUserAction();
            if (userAction3 == null || userAction3.getFollow() != 1) {
                z = false;
            }
            ((ItemCollectionFootBinding) getBinding()).followImageView.setImageResource(z ? 2131689475 : 2131689489);
            TextView textView4 = ((ItemCollectionFootBinding) getBinding()).followTextView;
            AppTheme appTheme = AppHolder.getAppTheme();
            textView4.setTextColor(z ? appTheme.getColorAccent() : appTheme.getTextColorSecondary());
            ImageView imageView = ((ItemCollectionFootBinding) getBinding()).followImageView;
            AppTheme appTheme2 = AppHolder.getAppTheme();
            imageView.setColorFilter(z ? appTheme2.getColorAccent() : appTheme2.getTextColorSecondary());
            ((ItemCollectionFootBinding) getBinding()).likeImageView.setImageResource(z2 ? 2131689495 : 2131689494);
            ImageView imageView2 = ((ItemCollectionFootBinding) getBinding()).likeImageView;
            AppTheme appTheme3 = AppHolder.getAppTheme();
            imageView2.setColorFilter(z2 ? appTheme3.getColorAccent() : appTheme3.getTextColorSecondary());
            ((ItemCollectionFootBinding) getBinding()).likeTextView.setTextColor(z2 ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorSecondary());
            ((ItemCollectionFootBinding) getBinding()).shareImageView.setImageResource(2131689492);
            ((ItemCollectionFootBinding) getBinding()).shareImageView.setColorFilter(AppHolder.getAppTheme().getTextColorSecondary());
            ((ItemCollectionFootBinding) getBinding()).shareTextView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        Function1<? super View, Unit> function1 = this.externalListener;
        if (function1 != null) {
            function1.invoke(view);
        }
    }

    public final void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "inset");
        LinearLayout linearLayout = ((ItemCollectionFootBinding) getBinding()).contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
        LinearLayout linearLayout2 = linearLayout;
        linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), rect.bottom);
    }
}
