package com.coolapk.market.view.feed.reply;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.SecondHandCommentBarBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001#B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0003H\u0014J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\tH\u0014R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/feed/reply/SecondHandCommentBarViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/SecondHandCommentBarBinding;", "Lcom/coolapk/market/model/Feed;", "Landroid/view/View$OnClickListener;", "()V", "externalListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "getExternalListener", "()Lkotlin/jvm/functions/Function1;", "setExternalListener", "(Lkotlin/jvm/functions/Function1;)V", "feed", "getFeed", "()Lcom/coolapk/market/model/Feed;", "setFeed", "(Lcom/coolapk/market/model/Feed;)V", "applyWindowsInset", "inset", "Landroid/graphics/Rect;", "changeStatus", "isSell", "", "onBindToContent", "data", "onClick", "v", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandCommentBarViewPart.kt */
public final class SecondHandCommentBarViewPart extends BindingViewPart<SecondHandCommentBarBinding, Feed> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private Function1<? super View, Unit> externalListener;
    private Feed feed;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/reply/SecondHandCommentBarViewPart$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/reply/SecondHandCommentBarViewPart;", "feed", "Lcom/coolapk/market/model/Feed;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandCommentBarViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SecondHandCommentBarViewPart newInstance(Feed feed, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            SecondHandCommentBarViewPart secondHandCommentBarViewPart = new SecondHandCommentBarViewPart();
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewGroup.context)");
            secondHandCommentBarViewPart.createView(from, viewGroup);
            secondHandCommentBarViewPart.bindToContent(feed);
            return secondHandCommentBarViewPart;
        }
    }

    public final Feed getFeed() {
        return this.feed;
    }

    public final void setFeed(Feed feed2) {
        this.feed = feed2;
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
    public SecondHandCommentBarBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559132, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…nt_bar, viewGroup, false)");
        return (SecondHandCommentBarBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        View root = ((SecondHandCommentBarBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtendsKt.setTopElevation$default(root, 0.0f, 1, null);
    }

    public final void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "inset");
        ((SecondHandCommentBarBinding) getBinding()).rootView.setPadding(0, 0, NumberExtendsKt.getDp((Number) 16), rect.bottom);
        ((SecondHandCommentBarBinding) getBinding()).rootView.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((SecondHandCommentBarViewPart) feed2);
        if (!Intrinsics.areEqual(this.feed, feed2)) {
            this.feed = feed2;
            ((SecondHandCommentBarBinding) getBinding()).setClick(this);
            String str4 = "1w+";
            String valueOf = feed2.getReplyNum() < 9999 ? String.valueOf(feed2.getReplyNum()) : str4;
            String valueOf2 = feed2.getLikeNum() < 9999 ? String.valueOf(feed2.getLikeNum()) : str4;
            String valueOf3 = feed2.getFavoriteNum() < 9999 ? String.valueOf(feed2.getFavoriteNum()) : str4;
            if (feed2.getShareNum() < 9999) {
                str4 = String.valueOf(feed2.getShareNum());
            }
            TextView textView = ((SecondHandCommentBarBinding) getBinding()).commentCount;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.commentCount");
            textView.setText(feed2.getReplyNum() > 0 ? valueOf : "");
            TextView textView2 = ((SecondHandCommentBarBinding) getBinding()).likeCount;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.likeCount");
            if (feed2.getLikeNum() > 0) {
                str = valueOf2;
            }
            textView2.setText(str);
            TextView textView3 = ((SecondHandCommentBarBinding) getBinding()).starCount;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.starCount");
            if (feed2.getFavoriteNum() > 0) {
                str2 = valueOf3;
            }
            textView3.setText(str2);
            TextView textView4 = ((SecondHandCommentBarBinding) getBinding()).shareCount;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.shareCount");
            if (feed2.getShareNum() > 0) {
                str3 = str4;
            }
            textView4.setText(str3);
            ((SecondHandCommentBarBinding) getBinding()).executePendingBindings();
            UserAction userAction = feed2.getUserAction();
            boolean z = true;
            boolean z2 = userAction != null && userAction.getLike() == 1;
            UserAction userAction2 = feed2.getUserAction();
            boolean z3 = userAction2 != null && userAction2.getCollect() == 1;
            ((SecondHandCommentBarBinding) getBinding()).likeIcon.setImageResource(z2 ? 2131689495 : 2131689494);
            ImageView imageView = ((SecondHandCommentBarBinding) getBinding()).likeIcon;
            AppTheme appTheme = AppHolder.getAppTheme();
            imageView.setColorFilter(z2 ? appTheme.getColorAccent() : appTheme.getTextColorSecondary());
            ((SecondHandCommentBarBinding) getBinding()).likeCount.setTextColor(z2 ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorSecondary());
            ((SecondHandCommentBarBinding) getBinding()).starIcon.setImageResource(z3 ? 2131689478 : 2131689477);
            ImageView imageView2 = ((SecondHandCommentBarBinding) getBinding()).starIcon;
            AppTheme appTheme2 = AppHolder.getAppTheme();
            imageView2.setColorFilter(z3 ? appTheme2.getColorAccent() : appTheme2.getTextColorSecondary());
            ((SecondHandCommentBarBinding) getBinding()).starCount.setTextColor(z3 ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorSecondary());
            SecondHandInfo secondHandInfo = feed2.getSecondHandInfo();
            Intrinsics.checkNotNull(secondHandInfo);
            if (secondHandInfo.getSecondHandStatus() >= 0) {
                z = false;
            }
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            boolean areEqual = Intrinsics.areEqual(loginSession.getUid(), feed2.getUid());
            String str5 = "关闭交易";
            if (!areEqual && !secondHandInfo.hasLink()) {
                TextView textView5 = ((SecondHandCommentBarBinding) getBinding()).goToSecongHand;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.goToSecongHand");
                textView5.setBackground(ShapeUtils.createStrokeBg(getContext(), 4, AppHolder.getAppTheme().getCurrencyColorDivider(), 1.0f, AppHolder.getAppTheme().getContentBackgroundColor()));
                ((SecondHandCommentBarBinding) getBinding()).goToSecongHand.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
                TextView textView6 = ((SecondHandCommentBarBinding) getBinding()).goToSecongHand;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.goToSecongHand");
                textView6.setClickable(false);
                str5 = "无链接";
            } else if (z) {
                TextView textView7 = ((SecondHandCommentBarBinding) getBinding()).goToSecongHand;
                Intrinsics.checkNotNullExpressionValue(textView7, "binding.goToSecongHand");
                textView7.setBackground(ShapeUtils.createStrokeBg(getContext(), 4, AppHolder.getAppTheme().getCurrencyColorDivider(), 1.0f, AppHolder.getAppTheme().getContentBackgroundColor()));
                ((SecondHandCommentBarBinding) getBinding()).goToSecongHand.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
                TextView textView8 = ((SecondHandCommentBarBinding) getBinding()).goToSecongHand;
                Intrinsics.checkNotNullExpressionValue(textView8, "binding.goToSecongHand");
                textView8.setClickable(false);
                str5 = "交易已结束";
            } else if ((!areEqual || !secondHandInfo.hasLink()) && (!areEqual || z)) {
                StringBuilder sb = new StringBuilder();
                sb.append((char) 21435);
                SecondHandInfo secondHandInfo2 = feed2.getSecondHandInfo();
                Intrinsics.checkNotNull(secondHandInfo2);
                Intrinsics.checkNotNullExpressionValue(secondHandInfo2, "data.secondHandInfo!!");
                sb.append(secondHandInfo2.getSource());
                sb.append("交易");
                str5 = sb.toString();
            }
            TextView textView9 = ((SecondHandCommentBarBinding) getBinding()).goToSecongHand;
            Intrinsics.checkNotNullExpressionValue(textView9, "binding.goToSecongHand");
            textView9.setText(str5);
        }
    }

    public final void changeStatus(boolean z) {
        String str;
        if (z) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            String uid = loginSession.getUid();
            Feed feed2 = this.feed;
            Intrinsics.checkNotNull(feed2);
            boolean areEqual = Intrinsics.areEqual(uid, feed2.getUid());
            if (z) {
                TextView textView = ((SecondHandCommentBarBinding) getBinding()).goToSecongHand;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.goToSecongHand");
                textView.setBackground(ShapeUtils.createStrokeBg(getContext(), 4, Color.parseColor("#BDBDBD"), 1.0f, AppHolder.getAppTheme().getContentBackgroundColor()));
                ((SecondHandCommentBarBinding) getBinding()).goToSecongHand.setTextColor(Color.parseColor("#BDBDBD"));
                TextView textView2 = ((SecondHandCommentBarBinding) getBinding()).goToSecongHand;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.goToSecongHand");
                textView2.setClickable(false);
                str = "交易已结束";
            } else if (!areEqual || z) {
                StringBuilder sb = new StringBuilder();
                sb.append((char) 21435);
                Feed feed3 = this.feed;
                Intrinsics.checkNotNull(feed3);
                SecondHandInfo secondHandInfo = feed3.getSecondHandInfo();
                Intrinsics.checkNotNull(secondHandInfo);
                Intrinsics.checkNotNullExpressionValue(secondHandInfo, "feed!!.secondHandInfo!!");
                sb.append(secondHandInfo.getSource());
                sb.append("交易");
                str = sb.toString();
            } else {
                str = "关闭交易";
            }
            TextView textView3 = ((SecondHandCommentBarBinding) getBinding()).goToSecongHand;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.goToSecongHand");
            textView3.setText(str);
            TextView textView4 = ((SecondHandCommentBarBinding) getBinding()).goToSecongHand;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.goToSecongHand");
            textView4.setVisibility(0);
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
