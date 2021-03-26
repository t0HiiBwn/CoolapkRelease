package com.coolapk.market.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.ItemReplyListBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.binding.BindingExtensionKt;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001&B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\"H\u0016R\u000e\u0010\f\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001a8G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001a8G¢\u0006\u0006\u001a\u0004\b \u0010\u001c¨\u0006'"}, d2 = {"Lcom/coolapk/market/viewholder/UserReplyViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemReplyListBinding;", "Lcom/coolapk/market/model/FeedReply;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "feedReply", "inLikeList", "", "isShowContent", "()Z", "isShowSpamInfo", "isShowTime", "ninePicViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getNinePicViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "ninePicViewPart$delegate", "Lkotlin/Lazy;", "sourcePic", "", "getSourcePic", "()Ljava/lang/String;", "sourceTitle", "getSourceTitle", "sourceUrl", "getSourceUrl", "bindToContent", "", "onClick", "view", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserReplyViewHolder.kt */
public class UserReplyViewHolder extends GenericBindHolder<ItemReplyListBinding, FeedReply> implements Recyclable {
    public static final int CARD_VIEW_TYPE = 2131559247;
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558905;
    private FeedReply feedReply;
    private boolean inLikeList;
    private final Lazy ninePicViewPart$delegate;

    private final NinePicViewPart getNinePicViewPart() {
        return (NinePicViewPart) this.ninePicViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserReplyViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.ninePicViewPart$delegate = LazyKt.lazy(new UserReplyViewHolder$ninePicViewPart$2(this, dataBindingComponent));
    }

    @Bindable
    public final boolean isShowTime() {
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        return EntityExtendsKt.isDatelineVisible(feedReply2) || this.inLikeList;
    }

    @Bindable
    public final String getSourceTitle() {
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (!TextUtils.isEmpty(feedReply2.getExtraTitle())) {
            FeedReply feedReply3 = this.feedReply;
            if (feedReply3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            return feedReply3.getExtraTitle();
        }
        FeedReply feedReply4 = this.feedReply;
        if (feedReply4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (feedReply4.getReplyFeed() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("@");
            FeedReply feedReply5 = this.feedReply;
            if (feedReply5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            FeedReply.ReplyFeed replyFeed = feedReply5.getReplyFeed();
            Intrinsics.checkNotNull(replyFeed);
            Intrinsics.checkNotNullExpressionValue(replyFeed, "feedReply.replyFeed!!");
            sb.append(replyFeed.getUserName());
            sb.append("\n");
            FeedReply feedReply6 = this.feedReply;
            if (feedReply6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            FeedReply.ReplyFeed replyFeed2 = feedReply6.getReplyFeed();
            Intrinsics.checkNotNull(replyFeed2);
            Intrinsics.checkNotNullExpressionValue(replyFeed2, "feedReply.replyFeed!!");
            sb.append(replyFeed2.getMessage());
            return sb.toString();
        }
        FeedReply feedReply7 = this.feedReply;
        if (feedReply7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (feedReply7.getReplyArticle() == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        FeedReply feedReply8 = this.feedReply;
        if (feedReply8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        DyhArticle replyArticle = feedReply8.getReplyArticle();
        Intrinsics.checkNotNull(replyArticle);
        Intrinsics.checkNotNullExpressionValue(replyArticle, "feedReply.replyArticle!!");
        sb2.append(replyArticle.getDyhName());
        sb2.append("\n");
        FeedReply feedReply9 = this.feedReply;
        if (feedReply9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        DyhArticle replyArticle2 = feedReply9.getReplyArticle();
        Intrinsics.checkNotNull(replyArticle2);
        Intrinsics.checkNotNullExpressionValue(replyArticle2, "feedReply.replyArticle!!");
        sb2.append(replyArticle2.getFinalMessage());
        return sb2.toString();
    }

    @Bindable
    public final String getSourcePic() {
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (!TextUtils.isEmpty(feedReply2.getExtraPic())) {
            FeedReply feedReply3 = this.feedReply;
            if (feedReply3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            return feedReply3.getExtraPic();
        }
        FeedReply feedReply4 = this.feedReply;
        if (feedReply4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (feedReply4.getReplyFeed() != null) {
            FeedReply feedReply5 = this.feedReply;
            if (feedReply5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            FeedReply.ReplyFeed replyFeed = feedReply5.getReplyFeed();
            Intrinsics.checkNotNull(replyFeed);
            Intrinsics.checkNotNullExpressionValue(replyFeed, "feedReply.replyFeed!!");
            return replyFeed.getXsPic();
        }
        FeedReply feedReply6 = this.feedReply;
        if (feedReply6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (feedReply6.getReplyArticle() == null) {
            return null;
        }
        FeedReply feedReply7 = this.feedReply;
        if (feedReply7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        DyhArticle replyArticle = feedReply7.getReplyArticle();
        Intrinsics.checkNotNull(replyArticle);
        Intrinsics.checkNotNullExpressionValue(replyArticle, "feedReply.replyArticle!!");
        return replyArticle.getThumbSquarePic();
    }

    @Bindable
    public final String getSourceUrl() {
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (!TextUtils.isEmpty(feedReply2.getExtraUrl())) {
            FeedReply feedReply3 = this.feedReply;
            if (feedReply3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            return feedReply3.getExtraUrl();
        }
        FeedReply feedReply4 = this.feedReply;
        if (feedReply4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (feedReply4.getReplyFeed() != null) {
            FeedReply feedReply5 = this.feedReply;
            if (feedReply5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            FeedReply.ReplyFeed replyFeed = feedReply5.getReplyFeed();
            Intrinsics.checkNotNull(replyFeed);
            Intrinsics.checkNotNullExpressionValue(replyFeed, "feedReply.replyFeed!!");
            return replyFeed.getUrl();
        }
        FeedReply feedReply6 = this.feedReply;
        if (feedReply6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (feedReply6.getReplyArticle() == null) {
            return null;
        }
        FeedReply feedReply7 = this.feedReply;
        if (feedReply7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        DyhArticle replyArticle = feedReply7.getReplyArticle();
        Intrinsics.checkNotNull(replyArticle);
        Intrinsics.checkNotNullExpressionValue(replyArticle, "feedReply.replyArticle!!");
        return replyArticle.getUrl();
    }

    @Bindable
    public final boolean isShowContent() {
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        boolean z = !TextUtils.isEmpty(feedReply2.getExtraTitle());
        FeedReply feedReply3 = this.feedReply;
        if (feedReply3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        boolean z2 = z & (!TextUtils.isEmpty(feedReply3.getExtraPic()));
        FeedReply feedReply4 = this.feedReply;
        if (feedReply4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (feedReply4.getReplyFeed() != null) {
            return true;
        }
        FeedReply feedReply5 = this.feedReply;
        if (feedReply5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (feedReply5.getReplyArticle() != null || z2) {
            return true;
        }
        return false;
    }

    @Bindable
    public final boolean isShowSpamInfo() {
        boolean z;
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        if (TextUtils.isEmpty(feedReply2.getSpamReason())) {
            FeedReply feedReply3 = this.feedReply;
            if (feedReply3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            if (TextUtils.isEmpty(feedReply3.getSpamContent())) {
                z = true;
                return !z;
            }
        }
        z = false;
        return !z;
    }

    public void bindToContent(FeedReply feedReply2) {
        Intrinsics.checkNotNullParameter(feedReply2, "feedReply");
        this.feedReply = feedReply2;
        ItemReplyListBinding itemReplyListBinding = (ItemReplyListBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemReplyListBinding, "binding");
        itemReplyListBinding.setClick(this);
        itemReplyListBinding.setModel(feedReply2);
        itemReplyListBinding.setInLikeList(this.inLikeList);
        itemReplyListBinding.setViewHolder(this);
        boolean z = false;
        itemReplyListBinding.setTransformer(new CircleTransform(false, 0, 3, null));
        itemReplyListBinding.setTimeDescription(DateUtils.getTimeDescription(AppHolder.getApplication(), this.inLikeList ? Long.valueOf(feedReply2.getLikeTime()) : feedReply2.getDateline()));
        itemReplyListBinding.executePendingBindings();
        TextView textView = itemReplyListBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "binding.titleView.text");
        LinkTextUtils.removeSpannable(text, URLSpan.class);
        ((ItemReplyListBinding) getBinding()).cardView.setOnLongClickListener(new UserReplyViewHolder$bindToContent$1(this, feedReply2));
        String pic = feedReply2.getPic();
        if (pic == null || pic.length() == 0) {
            z = true;
        }
        if (z) {
            NinePicViewPart ninePicViewPart = getNinePicViewPart();
            List emptyList = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(emptyList, "Collections.emptyList()");
            ninePicViewPart.bindToContent(emptyList);
        } else {
            NinePicViewPart ninePicViewPart2 = getNinePicViewPart();
            String pic2 = feedReply2.getPic();
            if (pic2 == null) {
                pic2 = "";
            }
            ninePicViewPart2.bindToContent(CollectionsKt.listOf(pic2));
        }
        FeedWarningBinding feedWarningBinding = itemReplyListBinding.alertView;
        Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
        BindingExtensionKt.updateInfo(feedWarningBinding, feedReply2.getInnerInfo());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        switch (view.getId()) {
            case 2131362205:
                FeedReply feedReply2 = this.feedReply;
                if (feedReply2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                if (feedReply2.hasParentReply()) {
                    Context context = getContext();
                    FeedReply feedReply3 = this.feedReply;
                    if (feedReply3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                    }
                    ActionManager.startFeedReplyDetailActivity(context, feedReply3.getParentReplyId());
                    return;
                }
                Context context2 = getContext();
                FeedReply feedReply4 = this.feedReply;
                if (feedReply4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                ActionManager.startFeedReplyDetailActivity(context2, feedReply4);
                return;
            case 2131362322:
                ActionManager.startActivityByUrl(getContext(), getSourceUrl());
                return;
            case 2131362718:
                FeedReply feedReply5 = this.feedReply;
                if (feedReply5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                String pic = feedReply5.getPic();
                FeedReply feedReply6 = this.feedReply;
                if (feedReply6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                ActionManager.startPhotoViewActivity(view, pic, feedReply6.getMiddleSizePic());
                return;
            case 2131363900:
                FeedReply feedReply7 = this.feedReply;
                if (feedReply7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                String uid = feedReply7.getUid();
                FeedReply feedReply8 = this.feedReply;
                if (feedReply8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                ActionManager.startUserSpaceActivity(view, uid, feedReply8.getUserAvatar());
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        getNinePicViewPart().onRecycled();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/viewholder/UserReplyViewHolder$Companion;", "", "()V", "CARD_VIEW_TYPE", "", "LAYOUT_ID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserReplyViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
