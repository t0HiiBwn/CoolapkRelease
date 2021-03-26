package com.coolapk.market.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.dyhv8.DyhActionPresenter;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0003/01B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0017H\u0002J\u001a\u0010&\u001a\u00020\u001b2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000eJ\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\nJ \u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0019H\u0002J\u0010\u0010.\u001a\u00020\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/coolapk/market/widget/DyhActionView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "collectState", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "extraListener", "Lrx/functions/Func1;", "Landroid/view/View;", "isInDetail", "likeState", "postingDelete", "postingLike", "presenter", "Lcom/coolapk/market/view/dyhv8/DyhActionPresenter;", "getHolder", "Lcom/coolapk/market/widget/DyhActionView$Holder;", "id", "", "init", "", "newItemView", "inflater", "Landroid/view/LayoutInflater;", "feedItem", "Lcom/coolapk/market/widget/DyhActionView$FeedItem;", "onClick", "v", "onLikeClick", "restoreView", "holder", "setExtraListener", "mExtraListener", "setIsInDetail", "detail", "setLikeViewState", "likeHolder", "hasLiked", "likeNum", "updateDyhArticle", "Companion", "FeedItem", "Holder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhActionView.kt */
public final class DyhActionView extends LinearLayout implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private static final FeedItem LIKE = new FeedItem(2131886790, 2131689494, 2131362527);
    private static final int LIKED = 2131689495;
    private static final FeedItem REPLY = new FeedItem(2131886791, 2131689479, 2131362528);
    private static final FeedItem SHARE = new FeedItem(2131886793, 2131689492, 2131362529);
    private boolean collectState;
    private DyhArticle dyhArticle;
    private Func1<View, Boolean> extraListener;
    private boolean isInDetail;
    private boolean likeState;
    private boolean postingDelete;
    private boolean postingLike;
    private final DyhActionPresenter presenter;

    public DyhActionView(Context context) {
        super(context);
        DyhActionPresenter instance = DyhActionPresenter.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DyhActionPresenter.getInstance()");
        this.presenter = instance;
        init(null);
    }

    public DyhActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DyhActionPresenter instance = DyhActionPresenter.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DyhActionPresenter.getInstance()");
        this.presenter = instance;
        init(attributeSet);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/widget/DyhActionView$Companion;", "", "()V", "LIKE", "Lcom/coolapk/market/widget/DyhActionView$FeedItem;", "getLIKE", "()Lcom/coolapk/market/widget/DyhActionView$FeedItem;", "LIKED", "", "getLIKED", "()I", "REPLY", "getREPLY", "SHARE", "getSHARE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhActionView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getLIKED() {
            return DyhActionView.LIKED;
        }

        public final FeedItem getLIKE() {
            return DyhActionView.LIKE;
        }

        public final FeedItem getREPLY() {
            return DyhActionView.REPLY;
        }

        public final FeedItem getSHARE() {
            return DyhActionView.SHARE;
        }
    }

    private final void init(AttributeSet attributeSet) {
        setOrientation(0);
        LayoutInflater from = LayoutInflater.from(getContext());
        Intrinsics.checkNotNullExpressionValue(from, "inflater");
        addView(newItemView(from, LIKE));
        addView(newItemView(from, REPLY));
        addView(newItemView(from, SHARE));
    }

    private final View newItemView(LayoutInflater layoutInflater, FeedItem feedItem) {
        View inflate = layoutInflater.inflate(2131558552, (ViewGroup) this, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.weight = 1.0f;
        }
        inflate.setId(feedItem.getContainerId());
        ViewUtil.clickListener(inflate, this);
        View findViewById = inflate.findViewById(2131362707);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.image_view)");
        View findViewById2 = inflate.findViewById(2131363533);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.text_view)");
        Holder holder = new Holder(inflate, (ImageView) findViewById, (TextView) findViewById2, feedItem);
        inflate.setTag(2131362526, holder);
        restoreView(holder);
        return inflate;
    }

    private final void restoreView(Holder holder) {
        FeedItem feedItem = holder.getFeedItem();
        holder.getTextView().setText(feedItem.getTitle());
        if (feedItem.getIcon() == null) {
            holder.getImageView().setVisibility(8);
        } else {
            holder.getImageView().setImageResource(feedItem.getIcon().intValue());
        }
    }

    public final void updateDyhArticle(DyhArticle dyhArticle2) {
        String str;
        if (dyhArticle2 != null) {
            this.dyhArticle = dyhArticle2;
            UserAction userAction = dyhArticle2.getUserAction();
            boolean z = false;
            this.postingLike = false;
            this.collectState = userAction != null && userAction.getFavorite() > 0;
            if (userAction != null && userAction.getLike() > 0) {
                z = true;
            }
            this.likeState = z;
            Holder holder = getHolder(LIKE.getContainerId());
            Holder holder2 = getHolder(REPLY.getContainerId());
            Holder holder3 = getHolder(SHARE.getContainerId());
            if (holder != null) {
                setLikeViewState(holder, this.likeState, dyhArticle2.getLikeNum());
            }
            String str2 = "";
            if (holder2 != null) {
                TextView textView = holder2.getTextView();
                if (dyhArticle2.getReplyNum() > 0) {
                    str = String.valueOf(dyhArticle2.getReplyNum());
                } else {
                    str = str2;
                }
                textView.setText(str);
            }
            if (holder3 != null) {
                int shareNum = dyhArticle2.getShareNum() + dyhArticle2.getForwardNum();
                TextView textView2 = holder3.getTextView();
                if (shareNum > 0) {
                    str2 = String.valueOf(shareNum);
                }
                textView2.setText(str2);
            }
        }
    }

    private final Holder getHolder(int i) {
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        Object tag = findViewById.getTag(2131362526);
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.widget.DyhActionView.Holder");
        return (Holder) tag;
    }

    public final void setIsInDetail(boolean z) {
        this.isInDetail = z;
    }

    public final void setExtraListener(Func1<View, Boolean> func1) {
        Intrinsics.checkNotNullParameter(func1, "mExtraListener");
        this.extraListener = func1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (this.dyhArticle != null) {
            Func1<View, Boolean> func1 = this.extraListener;
            if (func1 != null) {
                Intrinsics.checkNotNull(func1);
                Boolean call = func1.call(view);
                Intrinsics.checkNotNullExpressionValue(call, "extraListener!!.call(v)");
                if (call.booleanValue()) {
                    return;
                }
            }
            DyhArticle dyhArticle2 = this.dyhArticle;
            if (dyhArticle2 != null) {
                switch (view.getId()) {
                    case 2131362527:
                        ActionManager.checkLogin(getContext(), new DyhActionView$onClick$1(this));
                        return;
                    case 2131362528:
                        if (!TextUtils.isEmpty(dyhArticle2.getRawUrl())) {
                            String rawUrl = dyhArticle2.getRawUrl();
                            Intrinsics.checkNotNull(rawUrl);
                            Intrinsics.checkNotNullExpressionValue(rawUrl, "dyhArticle.rawUrl!!");
                            if (UriUtils.isInAppUrl(rawUrl)) {
                                Context context = getContext();
                                Intrinsics.checkNotNullExpressionValue(context, "context");
                                ActionManagerCompat.startActivityByUrl$default(context, dyhArticle2.getRawUrl(), null, null, 12, null);
                                return;
                            }
                        }
                        ActionManager.startDyhArticleDetailActivity(getContext(), dyhArticle2.getId());
                        return;
                    case 2131362529:
                        Context context2 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        ActionManager.startForwardEntityActivity(UiUtils.getActivityNullable(context2), dyhArticle2);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onLikeClick() {
        if (!this.postingLike) {
            this.postingLike = true;
            DyhArticle dyhArticle2 = this.dyhArticle;
            if (dyhArticle2 != null) {
                Object tag = findViewById(LIKE.getContainerId()).getTag(2131362526);
                Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.widget.DyhActionView.Holder");
                Holder holder = (Holder) tag;
                if (!this.likeState) {
                    this.presenter.dyhArticleLike(dyhArticle2).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new DyhActionView$onLikeClick$1(this, dyhArticle2));
                    this.likeState = true;
                    setLikeViewState(holder, true, dyhArticle2.getLikeNum() + 1);
                    return;
                }
                this.presenter.dyhArticleUnLike(dyhArticle2).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new DyhActionView$onLikeClick$2(this, dyhArticle2));
                this.likeState = false;
                setLikeViewState(holder, false, dyhArticle2.getLikeNum() - 1);
            }
        }
    }

    private final void setLikeViewState(Holder holder, boolean z, int i) {
        int i2;
        holder.getTextView().setText(i > 0 ? String.valueOf(i) : "");
        ImageView imageView = holder.getImageView();
        if (this.likeState) {
            i2 = LIKED;
        } else {
            Integer icon = LIKE.getIcon();
            Intrinsics.checkNotNull(icon);
            i2 = icon.intValue();
        }
        imageView.setImageResource(i2);
        holder.getImageView().setColorFilter(z ? AppHolder.getAppTheme().getColorAccent() : ResourceUtils.getColorInt(getContext(), 2131099892));
        holder.getTextView().setTextColor(z ? AppHolder.getAppTheme().getColorAccent() : ResourceUtils.getColorInt(getContext(), 2131099892));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/widget/DyhActionView$Holder;", "", "parent", "Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "feedItem", "Lcom/coolapk/market/widget/DyhActionView$FeedItem;", "(Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;Lcom/coolapk/market/widget/DyhActionView$FeedItem;)V", "getFeedItem", "()Lcom/coolapk/market/widget/DyhActionView$FeedItem;", "getImageView", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "getTextView", "()Landroid/widget/TextView;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhActionView.kt */
    private static final class Holder {
        private final FeedItem feedItem;
        private final ImageView imageView;
        private final View parent;
        private final TextView textView;

        public Holder(View view, ImageView imageView2, TextView textView2, FeedItem feedItem2) {
            Intrinsics.checkNotNullParameter(view, "parent");
            Intrinsics.checkNotNullParameter(imageView2, "imageView");
            Intrinsics.checkNotNullParameter(textView2, "textView");
            Intrinsics.checkNotNullParameter(feedItem2, "feedItem");
            this.parent = view;
            this.imageView = imageView2;
            this.textView = textView2;
            this.feedItem = feedItem2;
        }

        public final FeedItem getFeedItem() {
            return this.feedItem;
        }

        public final ImageView getImageView() {
            return this.imageView;
        }

        public final View getParent() {
            return this.parent;
        }

        public final TextView getTextView() {
            return this.textView;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/coolapk/market/widget/DyhActionView$FeedItem;", "", "title", "", "icon", "containerId", "(ILjava/lang/Integer;I)V", "getContainerId", "()I", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhActionView.kt */
    public static final class FeedItem {
        private final int containerId;
        private final Integer icon;
        private final int title;

        public FeedItem(int i, Integer num, int i2) {
            this.title = i;
            this.icon = num;
            this.containerId = i2;
        }

        public final int getTitle() {
            return this.title;
        }

        public final Integer getIcon() {
            return this.icon;
        }

        public final int getContainerId() {
            return this.containerId;
        }
    }
}
