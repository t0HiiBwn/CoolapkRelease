package com.coolapk.market.viewholder;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedReplyBinding;
import com.coolapk.market.extend.DrawableExtendsKt;
import com.coolapk.market.extend.DrawableFactory;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.CoolMarketURLSpan;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001+B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0014J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001aH\u0002J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0002J%\u0010&\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\u00032\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0014¢\u0006\u0002\u0010*R\u001a\u0010\f\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/coolapk/market/viewholder/FeedReplyViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedReplyBinding;", "Lcom/coolapk/market/model/FeedReply;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "feedReply", "getFeedReply", "()Lcom/coolapk/market/model/FeedReply;", "setFeedReply", "(Lcom/coolapk/market/model/FeedReply;)V", "isPosting", "", "ninePicViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getNinePicViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "ninePicViewPart$delegate", "Lkotlin/Lazy;", "bindToContent", "", "reply", "onClick", "view", "onLikeClick", "onPopulateSubReplyView", "onRecycled", "populateImageView", "setLikeState", "hasLiked", "likeNum", "", "showItemDialog", "spans", "", "Landroid/text/style/URLSpan;", "(Lcom/coolapk/market/model/FeedReply;[Landroid/text/style/URLSpan;)V", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyViewHolder.kt */
public class FeedReplyViewHolder extends GenericBindHolder<ItemFeedReplyBinding, FeedReply> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558723;
    public FeedReply feedReply;
    private boolean isPosting;
    private final Lazy ninePicViewPart$delegate;

    private final NinePicViewPart getNinePicViewPart() {
        return (NinePicViewPart) this.ninePicViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedReplyViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.ninePicViewPart$delegate = LazyKt.lazy(new FeedReplyViewHolder$ninePicViewPart$2(this, dataBindingComponent));
        ItemFeedReplyBinding itemFeedReplyBinding = (ItemFeedReplyBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedReplyBinding, "binding");
        itemFeedReplyBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/FeedReplyViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final FeedReply getFeedReply() {
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        return feedReply2;
    }

    public final void setFeedReply(FeedReply feedReply2) {
        Intrinsics.checkNotNullParameter(feedReply2, "<set-?>");
        this.feedReply = feedReply2;
    }

    public void bindToContent(FeedReply feedReply2) {
        int i;
        Intrinsics.checkNotNullParameter(feedReply2, "reply");
        this.feedReply = feedReply2;
        ItemFeedReplyBinding itemFeedReplyBinding = (ItemFeedReplyBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedReplyBinding, "binding");
        if (!Intrinsics.areEqual(feedReply2, itemFeedReplyBinding.getModel())) {
            itemFeedReplyBinding.setModel(feedReply2);
            TextView textView = itemFeedReplyBinding.replyReplyInfoText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.replyReplyInfoText");
            textView.setText(StringUtils.getReplyInfoText(DateUtils.getTimeDescription(AppHolder.getApplication(), feedReply2.getDateline())));
            itemFeedReplyBinding.executePendingBindings();
            ImageView imageView = itemFeedReplyBinding.foldedSignView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.foldedSignView");
            if (feedReply2.getBlockStatus() == 1) {
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                if (loginSession.isAdmin()) {
                    i = 0;
                    imageView.setVisibility(i);
                    onPopulateSubReplyView(feedReply2);
                    itemFeedReplyBinding.cardView.setOnLongClickListener(new FeedReplyViewHolder$bindToContent$1(this, itemFeedReplyBinding));
                }
            }
            i = 8;
            imageView.setVisibility(i);
            onPopulateSubReplyView(feedReply2);
            itemFeedReplyBinding.cardView.setOnLongClickListener(new FeedReplyViewHolder$bindToContent$1(this, itemFeedReplyBinding));
        }
        this.isPosting = false;
        populateImageView();
        setLikeState(feedReply2.hasLike(), feedReply2.getLikeNum());
        TextView textView2 = itemFeedReplyBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(feedReply2.getUserName());
        String uid = feedReply2.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "reply.uid");
        spannableStringBuilder.setSpan(new CoolMarketURLSpan(UriUtils.buildUserPageUrl(uid), AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
        if (feedReply2.getIsFeedAuthor() > 0) {
            spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) " ");
            spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) DrawableExtendsKt.toSpannable(DrawableFactory.INSTANCE.createAuthorIndicator(), "[楼主]"));
            spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) " ");
        }
        if (feedReply2.hasOtherReplyUser()) {
            spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) "回复");
            int length = spannableStringBuilder.length();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(feedReply2.getReplyUserName());
            String replyUid = feedReply2.getReplyUid();
            if (replyUid == null) {
                replyUid = "";
            }
            spannableStringBuilder2.setSpan(new CoolMarketURLSpan(UriUtils.buildUserPageUrl(replyUid), AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder2.length(), 33);
            Unit unit = Unit.INSTANCE;
            spannableStringBuilder.insert(length, (CharSequence) spannableStringBuilder2);
        }
        Unit unit2 = Unit.INSTANCE;
        textView2.setText(spannableStringBuilder);
        TextView textView3 = itemFeedReplyBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
        ViewExtendsKt.makeSpanClickable(textView3);
    }

    protected void showItemDialog(FeedReply feedReply2, URLSpan[] uRLSpanArr) {
        Intrinsics.checkNotNullParameter(feedReply2, "feedReply");
        Activity activity = UiUtils.getActivity(getContext());
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        EntityExtendsKt.showItemDialog(feedReply2, activity);
    }

    private final void populateImageView() {
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        String pic = feedReply2.getPic();
        if (pic == null || pic.length() == 0) {
            NinePicViewPart ninePicViewPart = getNinePicViewPart();
            List emptyList = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(emptyList, "Collections.emptyList()");
            ninePicViewPart.bindToContent(emptyList);
            return;
        }
        NinePicViewPart ninePicViewPart2 = getNinePicViewPart();
        FeedReply feedReply3 = this.feedReply;
        if (feedReply3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedReply");
        }
        String pic2 = feedReply3.getPic();
        if (pic2 == null) {
            pic2 = "";
        }
        ninePicViewPart2.bindToContent(CollectionsKt.listOf(pic2));
    }

    protected void onPopulateSubReplyView(FeedReply feedReply2) {
        Intrinsics.checkNotNullParameter(feedReply2, "reply");
        LinearLayout linearLayout = ((ItemFeedReplyBinding) getBinding()).subReplyContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.subReplyContainer");
        linearLayout.setVisibility(8);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        switch (view.getId()) {
            case 2131362205:
                Activity activity = UiUtils.getActivity(getContext());
                FeedReply feedReply2 = this.feedReply;
                if (feedReply2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                ActionManager.startReplyActivity(activity, feedReply2);
                return;
            case 2131362294:
            case 2131362296:
                if (DataManager.getInstance().getLoginSession().isLogin()) {
                    Activity activity2 = UiUtils.getActivity(getContext());
                    FeedReply feedReply3 = this.feedReply;
                    if (feedReply3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                    }
                    ActionManager.startReplyActivity(activity2, feedReply3);
                    return;
                }
                StatisticHelper.Companion.getInstance().recordLoginClickEvent("回复");
                ActionManager.startLoginActivity(getContext());
                return;
            case 2131362718:
                FeedReply feedReply4 = this.feedReply;
                if (feedReply4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                String pic = feedReply4.getPic();
                FeedReply feedReply5 = this.feedReply;
                if (feedReply5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                ActionManager.startPhotoViewActivity(view, pic, feedReply5.getMiddleSizePic());
                return;
            case 2131362862:
                Boolean checkLogin = ActionManager.checkLogin(getContext());
                Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(context)");
                if (checkLogin.booleanValue()) {
                    onLikeClick();
                    return;
                } else {
                    StatisticHelper.Companion.getInstance().recordLoginClickEvent("点赞");
                    return;
                }
            case 2131363900:
                FeedReply feedReply6 = this.feedReply;
                if (feedReply6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                String uid = feedReply6.getUid();
                FeedReply feedReply7 = this.feedReply;
                if (feedReply7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                ActionManager.startUserSpaceActivity(view, uid, feedReply7.getUserAvatar());
                return;
            default:
                return;
        }
    }

    private final void onLikeClick() {
        if (!this.isPosting) {
            this.isPosting = true;
            FeedReply feedReply2 = this.feedReply;
            if (feedReply2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            if (feedReply2.hasLike()) {
                DataManager instance = DataManager.getInstance();
                FeedReply feedReply3 = this.feedReply;
                if (feedReply3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                instance.unlikeReply(feedReply3.getId()).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedReplyViewHolder$onLikeClick$1(this));
                FeedReply feedReply4 = this.feedReply;
                if (feedReply4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedReply");
                }
                setLikeState(false, feedReply4.getLikeNum() - 1);
                return;
            }
            DataManager instance2 = DataManager.getInstance();
            FeedReply feedReply5 = this.feedReply;
            if (feedReply5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            instance2.likeReply(feedReply5.getId()).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedReplyViewHolder$onLikeClick$2(this));
            FeedReply feedReply6 = this.feedReply;
            if (feedReply6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedReply");
            }
            setLikeState(true, feedReply6.getLikeNum() + 1);
        }
    }

    /* access modifiers changed from: private */
    public final void setLikeState(boolean z, int i) {
        TextView textView = ((ItemFeedReplyBinding) getBinding()).likeNum;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.likeNum");
        textView.setText(i > 0 ? String.valueOf(i) : "");
        ((ItemFeedReplyBinding) getBinding()).likeNum.setTextColor(z ? AppHolder.getAppTheme().getColorAccent() : ResourceUtils.getColorInt(getContext(), 2131099898));
        ((ItemFeedReplyBinding) getBinding()).likeIcon.setImageResource(z ? 2131689495 : 2131689494);
        ((ItemFeedReplyBinding) getBinding()).likeIcon.setColorFilter(z ? AppHolder.getAppTheme().getColorAccent() : ResourceUtils.getColorInt(getContext(), 2131099898));
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        getNinePicViewPart().onRecycled();
    }
}
