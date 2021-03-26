package com.coolapk.market.view.dyhv8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.FeedCommentBarBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0003H\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u000eH\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleCommentBarViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/FeedCommentBarBinding;", "Lcom/coolapk/market/model/DyhArticle;", "Landroid/view/View$OnClickListener;", "()V", "dyhArticle", "getDyhArticle", "()Lcom/coolapk/market/model/DyhArticle;", "setDyhArticle", "(Lcom/coolapk/market/model/DyhArticle;)V", "externalListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "getExternalListener", "()Lkotlin/jvm/functions/Function1;", "setExternalListener", "(Lkotlin/jvm/functions/Function1;)V", "onBindToContent", "data", "onClick", "v", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleCommentBarViewPart.kt */
public final class DyhArticleCommentBarViewPart extends BindingViewPart<FeedCommentBarBinding, DyhArticle> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private DyhArticle dyhArticle;
    private Function1<? super View, Unit> externalListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleCommentBarViewPart$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/dyhv8/DyhArticleCommentBarViewPart;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleCommentBarViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DyhArticleCommentBarViewPart newInstance(DyhArticle dyhArticle, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(dyhArticle, "dyhArticle");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            DyhArticleCommentBarViewPart dyhArticleCommentBarViewPart = new DyhArticleCommentBarViewPart();
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewGroup.context)");
            dyhArticleCommentBarViewPart.createView(from, viewGroup);
            dyhArticleCommentBarViewPart.bindToContent(dyhArticle);
            return dyhArticleCommentBarViewPart;
        }
    }

    public final DyhArticle getDyhArticle() {
        return this.dyhArticle;
    }

    public final void setDyhArticle(DyhArticle dyhArticle2) {
        this.dyhArticle = dyhArticle2;
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
    public FeedCommentBarBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558558, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…nt_bar, viewGroup, false)");
        return (FeedCommentBarBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        View root = ((FeedCommentBarBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtendsKt.setTopElevation$default(root, 0.0f, 1, null);
        FrameLayout frameLayout = ((FeedCommentBarBinding) getBinding()).likeView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.likeView");
        ViewExtendsKt.disableAccessibilityClick(frameLayout);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(DyhArticle dyhArticle2) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(dyhArticle2, "data");
        super.onBindToContent((DyhArticleCommentBarViewPart) dyhArticle2);
        if (!Intrinsics.areEqual(this.dyhArticle, dyhArticle2)) {
            this.dyhArticle = dyhArticle2;
            ((FeedCommentBarBinding) getBinding()).setClick(this);
            String valueOf = String.valueOf(dyhArticle2.getReplyNum());
            String valueOf2 = String.valueOf(dyhArticle2.getLikeNum());
            String valueOf3 = String.valueOf(dyhArticle2.getFavNum());
            String valueOf4 = String.valueOf(dyhArticle2.getShareNum());
            TextView textView = ((FeedCommentBarBinding) getBinding()).commentCount;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.commentCount");
            textView.setText(dyhArticle2.getReplyNum() > 0 ? valueOf : "");
            TextView textView2 = ((FeedCommentBarBinding) getBinding()).likeCount;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.likeCount");
            if (dyhArticle2.getLikeNum() > 0) {
                str = valueOf2;
            }
            textView2.setText(str);
            TextView textView3 = ((FeedCommentBarBinding) getBinding()).starCount;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.starCount");
            if (dyhArticle2.getFavNum() > 0) {
                str2 = valueOf3;
            }
            textView3.setText(str2);
            TextView textView4 = ((FeedCommentBarBinding) getBinding()).shareCount;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.shareCount");
            if (dyhArticle2.getShareNum() > 0) {
                str3 = valueOf4;
            }
            textView4.setText(str3);
            ((FeedCommentBarBinding) getBinding()).executePendingBindings();
            UserAction userAction = dyhArticle2.getUserAction();
            boolean z = false;
            boolean z2 = userAction != null && userAction.getLike() == 1;
            UserAction userAction2 = dyhArticle2.getUserAction();
            if (userAction2 != null && userAction2.getCollect() == 1) {
                z = true;
            }
            ((FeedCommentBarBinding) getBinding()).likeIcon.setImageResource(z2 ? 2131689495 : 2131689494);
            ImageView imageView = ((FeedCommentBarBinding) getBinding()).likeIcon;
            AppTheme appTheme = AppHolder.getAppTheme();
            imageView.setColorFilter(z2 ? appTheme.getColorAccent() : appTheme.getTextColorSecondary());
            ((FeedCommentBarBinding) getBinding()).likeCount.setTextColor(z2 ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorSecondary());
            ((FeedCommentBarBinding) getBinding()).starIcon.setImageResource(z ? 2131689478 : 2131689477);
            ImageView imageView2 = ((FeedCommentBarBinding) getBinding()).starIcon;
            AppTheme appTheme2 = AppHolder.getAppTheme();
            imageView2.setColorFilter(z ? appTheme2.getColorAccent() : appTheme2.getTextColorSecondary());
            TextView textView5 = ((FeedCommentBarBinding) getBinding()).starCount;
            AppTheme appTheme3 = AppHolder.getAppTheme();
            textView5.setTextColor(z ? appTheme3.getColorAccent() : appTheme3.getTextColorSecondary());
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
}
