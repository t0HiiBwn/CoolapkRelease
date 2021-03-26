package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.album.AlbumActionPresenter;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 32\u00020\u00012\u00020\u0002:\u0003345B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\rH\u0016J\b\u0010'\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0012H\u0002J\u001a\u0010*\u001a\u00020\u001f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fJ\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\nJ \u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u001dH\u0002J\u0010\u00102\u001a\u00020\u001f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/coolapk/market/widget/AlbumFeedActionView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "collectState", "", "extraListener", "Lrx/functions/Func1;", "Landroid/view/View;", "feed", "Lcom/coolapk/market/model/Album;", "holderArray", "Landroid/util/SparseArray;", "Lcom/coolapk/market/widget/AlbumFeedActionView$Holder;", "initRunnable", "Ljava/lang/Runnable;", "isInDetail", "likeState", "postingDelete", "postingLike", "presenter", "Lcom/coolapk/market/view/album/AlbumActionPresenter;", "getHolder", "id", "", "init", "", "newItemView", "inflater", "Landroid/view/LayoutInflater;", "feedItem", "Lcom/coolapk/market/widget/AlbumFeedActionView$FeedItem;", "onClick", "v", "onLikeClick", "restoreView", "holder", "setExtraListener", "mExtraListener", "setIsInDetail", "detail", "setLikeViewState", "likeHolder", "hasLiked", "likeNum", "updateFeed", "Companion", "FeedItem", "Holder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumFeedActionView.kt */
public final class AlbumFeedActionView extends LinearLayout implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private static final FeedItem LIKE = new FeedItem(2131886852, 2131689494, 2131362535);
    private static final int LIKED = 2131689495;
    private static final FeedItem REPLY = new FeedItem(2131886853, 2131689479, 2131362536);
    private static final FeedItem SHARE = new FeedItem(2131886855, 2131689492, 2131362537);
    private boolean collectState;
    private Func1<View, Boolean> extraListener;
    private Album feed;
    private SparseArray<Holder> holderArray = new SparseArray<>();
    private final Runnable initRunnable = new AlbumFeedActionView$initRunnable$1(this);
    private boolean isInDetail;
    private boolean likeState;
    private boolean postingDelete;
    private boolean postingLike;
    private final AlbumActionPresenter presenter;

    public AlbumFeedActionView(Context context) {
        super(context);
        AlbumActionPresenter instance = AlbumActionPresenter.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "AlbumActionPresenter.getInstance()");
        this.presenter = instance;
        init(null);
    }

    public AlbumFeedActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AlbumActionPresenter instance = AlbumActionPresenter.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "AlbumActionPresenter.getInstance()");
        this.presenter = instance;
        init(attributeSet);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/widget/AlbumFeedActionView$Companion;", "", "()V", "LIKE", "Lcom/coolapk/market/widget/AlbumFeedActionView$FeedItem;", "getLIKE", "()Lcom/coolapk/market/widget/AlbumFeedActionView$FeedItem;", "LIKED", "", "getLIKED", "()I", "REPLY", "getREPLY", "SHARE", "getSHARE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumFeedActionView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getLIKED() {
            return AlbumFeedActionView.LIKED;
        }

        public final FeedItem getLIKE() {
            return AlbumFeedActionView.LIKE;
        }

        public final FeedItem getREPLY() {
            return AlbumFeedActionView.REPLY;
        }

        public final FeedItem getSHARE() {
            return AlbumFeedActionView.SHARE;
        }
    }

    private final void init(AttributeSet attributeSet) {
        setOrientation(0);
    }

    /* access modifiers changed from: private */
    public final View newItemView(LayoutInflater layoutInflater, FeedItem feedItem) {
        View inflate = layoutInflater.inflate(2131558554, (ViewGroup) this, false);
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
        View findViewById = inflate.findViewById(2131362718);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.image_view)");
        View findViewById2 = inflate.findViewById(2131363551);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.text_view)");
        Holder holder = new Holder(inflate, (ImageView) findViewById, (TextView) findViewById2, feedItem);
        inflate.setTag(2131362534, holder);
        restoreView(holder);
        this.holderArray.put(feedItem.getContainerId(), holder);
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

    public final void updateFeed(Album album) {
        if (album != null) {
            this.feed = album;
            if (this.holderArray.size() == 0) {
                removeCallbacks(this.initRunnable);
                post(this.initRunnable);
                return;
            }
            UserAction userAction = album.getUserAction();
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
                setLikeViewState(holder, this.likeState, album.getLikeNum());
            }
            String str = "";
            if (holder2 != null) {
                holder2.getTextView().setText(album.getReplyNum() > 0 ? String.valueOf(album.getReplyNum()) : str);
            }
            if (holder3 != null) {
                int shareNum = album.getShareNum() + album.getForwardNum();
                TextView textView = holder3.getTextView();
                if (shareNum > 0) {
                    str = String.valueOf(shareNum);
                }
                textView.setText(str);
            }
        }
    }

    private final Holder getHolder(int i) {
        Holder holder = this.holderArray.get(i);
        if (holder != null) {
            return holder;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        Object tag = findViewById.getTag(2131362534);
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.widget.AlbumFeedActionView.Holder");
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
        if (this.feed != null) {
            Func1<View, Boolean> func1 = this.extraListener;
            if (func1 != null) {
                Intrinsics.checkNotNull(func1);
                Boolean call = func1.call(view);
                Intrinsics.checkNotNullExpressionValue(call, "extraListener!!.call(v)");
                if (call.booleanValue()) {
                    return;
                }
            }
            Album album = this.feed;
            if (album != null) {
                switch (view.getId()) {
                    case 2131362535:
                        Boolean checkLogin = ActionManager.checkLogin(getContext());
                        Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(context)");
                        if (checkLogin.booleanValue()) {
                            onLikeClick();
                            return;
                        } else {
                            StatisticHelper.Companion.getInstance().recordLoginClickEvent("点赞");
                            return;
                        }
                    case 2131362536:
                        if (album.getReplyNum() > 0) {
                            ActionManager.startV8AlbumDetailActivity(UiUtils.getActivity(getContext()), album.getAlbumId(), null, 1);
                            return;
                        }
                        Boolean checkLogin2 = ActionManager.checkLogin(getContext());
                        Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(context)");
                        if (checkLogin2.booleanValue()) {
                            ActionManager.startFeedCommentActivity(UiUtils.getActivity(getContext()), album.getId(), album.getUserName());
                            return;
                        } else {
                            StatisticHelper.Companion.getInstance().recordLoginClickEvent("回复");
                            return;
                        }
                    case 2131362537:
                        ActionManager.shareText(getContext(), album);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private final void onLikeClick() {
        if (!this.postingLike) {
            this.postingLike = true;
            Album album = this.feed;
            if (album != null) {
                Object tag = findViewById(LIKE.getContainerId()).getTag(2131362534);
                Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.widget.AlbumFeedActionView.Holder");
                Holder holder = (Holder) tag;
                if (!this.likeState) {
                    this.presenter.likeAlbum(album).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AlbumFeedActionView$onLikeClick$1(this, album));
                    this.likeState = true;
                    setLikeViewState(holder, true, album.getLikeNum() + 1);
                    return;
                }
                this.presenter.unlikeAlbum(album).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AlbumFeedActionView$onLikeClick$2(this, album));
                this.likeState = false;
                setLikeViewState(holder, false, album.getLikeNum() - 1);
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
        holder.getImageView().setColorFilter(z ? AppHolder.getAppTheme().getColorAccent() : ResourceUtils.getColorInt(getContext(), 2131099897));
        holder.getTextView().setTextColor(z ? AppHolder.getAppTheme().getColorAccent() : ResourceUtils.getColorInt(getContext(), 2131099897));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/widget/AlbumFeedActionView$Holder;", "", "parent", "Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "feedItem", "Lcom/coolapk/market/widget/AlbumFeedActionView$FeedItem;", "(Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;Lcom/coolapk/market/widget/AlbumFeedActionView$FeedItem;)V", "getFeedItem", "()Lcom/coolapk/market/widget/AlbumFeedActionView$FeedItem;", "getImageView", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "getTextView", "()Landroid/widget/TextView;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumFeedActionView.kt */
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/coolapk/market/widget/AlbumFeedActionView$FeedItem;", "", "title", "", "icon", "containerId", "(ILjava/lang/Integer;I)V", "getContainerId", "()I", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumFeedActionView.kt */
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
