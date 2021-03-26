package com.coolapk.market.view.feed.vote;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedVoteCommentSmallBinding;
import com.coolapk.market.event.FeedEventRequester;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.model.Vote;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001bB\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentSmallViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedVoteCommentSmallBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "config", "Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;)V", "getConfig", "()Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "feed", "bindToContent", "", "data", "onClick", "view", "onRecycled", "setLikeState", "isLike", "", "likeNum", "", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteCommentSmallViewHolder.kt */
public final class VoteCommentSmallViewHolder extends GenericBindHolder<ItemFeedVoteCommentSmallBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558745;
    private final VoteCommentConfig config;
    private Feed feed;

    public final VoteCommentConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoteCommentSmallViewHolder(View view, DataBindingComponent dataBindingComponent, VoteCommentConfig voteCommentConfig) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(voteCommentConfig, "config");
        this.config = voteCommentConfig;
        ItemFeedVoteCommentSmallBinding itemFeedVoteCommentSmallBinding = (ItemFeedVoteCommentSmallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedVoteCommentSmallBinding, "binding");
        itemFeedVoteCommentSmallBinding.setClick(this);
        itemFeedVoteCommentSmallBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.view.feed.vote.VoteCommentSmallViewHolder.AnonymousClass1 */
            final /* synthetic */ VoteCommentSmallViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                this.this$0.showItemDialog();
                return true;
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentSmallViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteCommentSmallViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        ItemFeedVoteCommentSmallBinding itemFeedVoteCommentSmallBinding = (ItemFeedVoteCommentSmallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedVoteCommentSmallBinding, "binding");
        itemFeedVoteCommentSmallBinding.setModel(null);
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        ItemFeedVoteCommentSmallBinding itemFeedVoteCommentSmallBinding = (ItemFeedVoteCommentSmallBinding) getBinding();
        this.feed = feed2;
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        int contentBackgroundColor = AppHolder.getAppTheme().getContentBackgroundColor();
        int colorInt = ResourceUtils.getColorInt(getContext(), 2131099792);
        if (vote.getType() == 0) {
            colorInt = this.config.getPkOptionColor()[ArraysKt.indexOf(this.config.getPkOptionId(), feed2.getExtraKey())];
            contentBackgroundColor = ColorUtils.adjustAlpha(colorInt, 0.1f);
        }
        FrameLayout frameLayout = itemFeedVoteCommentSmallBinding.cardView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.cardView");
        frameLayout.setBackground(new ColorDrawable(contentBackgroundColor));
        ImageView imageView = itemFeedVoteCommentSmallBinding.waterMarkView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.waterMarkView");
        boolean z = false;
        imageView.setVisibility(feed2.getIsRecommendVoteComment() == 1 ? 0 : 8);
        ImageView imageView2 = itemFeedVoteCommentSmallBinding.waterMarkView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.waterMarkView");
        imageView2.setImageTintList(ColorStateList.valueOf(colorInt));
        CoolEllipsizeTextView coolEllipsizeTextView = itemFeedVoteCommentSmallBinding.textView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.textView");
        String message = feed2.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "data.message");
        ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView, 5, message);
        Intrinsics.checkNotNullExpressionValue(itemFeedVoteCommentSmallBinding, "binding");
        itemFeedVoteCommentSmallBinding.setModel(feed2);
        itemFeedVoteCommentSmallBinding.executePendingBindings();
        UserAction userAction = feed2.getUserAction();
        if (userAction != null && userAction.getLike() == 1) {
            z = true;
        }
        setLikeState(z, feed2.getLikeNum());
    }

    private final void setLikeState(boolean z, int i) {
        Vote vote;
        int i2;
        Feed feed2 = this.feed;
        if (feed2 != null && (vote = feed2.getVote()) != null) {
            Intrinsics.checkNotNullExpressionValue(vote, "feed?.vote ?: return");
            if (vote.getType() == 0) {
                String[] pkOptionId = this.config.getPkOptionId();
                Feed feed3 = this.feed;
                i2 = this.config.getPkOptionColor()[ArraysKt.indexOf(pkOptionId, feed3 != null ? feed3.getExtraKey() : null)];
            } else {
                i2 = AppHolder.getAppTheme().getColorAccent();
            }
            TextView textView = ((ItemFeedVoteCommentSmallBinding) getBinding()).likeNum;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.likeNum");
            textView.setText(i > 0 ? String.valueOf(i) : "");
            ((ItemFeedVoteCommentSmallBinding) getBinding()).likeNum.setTextColor(z ? i2 : AppHolder.getAppTheme().getTextColorTertiary());
            ((ItemFeedVoteCommentSmallBinding) getBinding()).likeIcon.setImageResource(z ? 2131689495 : 2131689494);
            ImageView imageView = ((ItemFeedVoteCommentSmallBinding) getBinding()).likeIcon;
            if (!z) {
                i2 = AppHolder.getAppTheme().getTextColorTertiary();
            }
            imageView.setColorFilter(i2);
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed2 = this.feed;
        if (feed2 != null) {
            switch (view.getId()) {
                case 2131362205:
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(feed2), null, null, 12, null);
                    return;
                case 2131362296:
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    ActionManager.startFeedCommentActivity(UiUtils.getActivityNullable(context2), feed2.getId(), feed2.getUserName());
                    return;
                case 2131362862:
                    FeedEventRequester feedEventRequester = FeedEventRequester.INSTANCE;
                    String id = feed2.getId();
                    if (id == null) {
                        id = "";
                    }
                    UserAction userAction = feed2.getUserAction();
                    FeedEventRequester.requestLike$default(feedEventRequester, id, userAction == null || userAction.getLike() != 1, 0, null, null, 24, null);
                    return;
                case 2131363900:
                case 2131363914:
                    ActionManager.startUserSpaceActivity(getContext(), feed2.getUid());
                    return;
                default:
                    super.onClick(view);
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showItemDialog() {
        Feed feed2 = this.feed;
        if (feed2 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            if (activityNullable != null) {
                EntityExtendsKt.showItemDialog(feed2, activityNullable);
            }
        }
    }
}
