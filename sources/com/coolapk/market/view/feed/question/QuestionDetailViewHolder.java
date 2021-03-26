package com.coolapk.market.view.feed.question;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemQuestionDetailViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/coolapk/market/view/feed/question/QuestionDetailViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemQuestionDetailViewBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/feed/question/QuestionPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/question/QuestionPresenter;)V", "extraPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getExtraPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "extraPart$delegate", "Lkotlin/Lazy;", "getPresenter", "()Lcom/coolapk/market/view/feed/question/QuestionPresenter;", "relativeInfoViewPart", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "getRelativeInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "relativeInfoViewPart$delegate", "showMaxWords", "", "bindToContent", "", "holder", "onClick", "view", "setContentMessage", "setFollowQuestionState", "following", "followCount", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionDetailViewHolder.kt */
public final class QuestionDetailViewHolder extends GenericBindHolder<ItemQuestionDetailViewBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558885;
    private final Lazy extraPart$delegate;
    private final QuestionPresenter presenter;
    private final Lazy relativeInfoViewPart$delegate = LazyKt.lazy(new QuestionDetailViewHolder$relativeInfoViewPart$2(this));
    private boolean showMaxWords;

    private final NinePicViewPart getExtraPart() {
        return (NinePicViewPart) this.extraPart$delegate.getValue();
    }

    private final FeedRelativeInfoViewPart getRelativeInfoViewPart() {
        return (FeedRelativeInfoViewPart) this.relativeInfoViewPart$delegate.getValue();
    }

    public final QuestionPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QuestionDetailViewHolder(View view, DataBindingComponent dataBindingComponent, QuestionPresenter questionPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(questionPresenter, "presenter");
        this.presenter = questionPresenter;
        ItemQuestionDetailViewBinding itemQuestionDetailViewBinding = (ItemQuestionDetailViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemQuestionDetailViewBinding, "binding");
        itemQuestionDetailViewBinding.setClick(this);
        itemQuestionDetailViewBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.view.feed.question.QuestionDetailViewHolder.AnonymousClass1 */
            final /* synthetic */ QuestionDetailViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed feed = this.this$0.getPresenter().getFeed();
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(feed, context);
                return true;
            }
        });
        this.extraPart$delegate = LazyKt.lazy(new QuestionDetailViewHolder$extraPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/question/QuestionDetailViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: QuestionDetailViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "holder");
        Feed feed = this.presenter.getFeed();
        ItemQuestionDetailViewBinding itemQuestionDetailViewBinding = (ItemQuestionDetailViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemQuestionDetailViewBinding, "binding");
        itemQuestionDetailViewBinding.setModel(feed);
        getExtraPart().setMaxShowCount(3);
        getExtraPart().bindToContent(EntityExtendsKt.getHtmlPicArray(feed));
        getRelativeInfoViewPart().bindTo(feed);
        setContentMessage();
        ((ItemQuestionDetailViewBinding) getBinding()).textViewContainer.setOnClickListener(new QuestionDetailViewHolder$bindToContent$1(this));
        FrameLayout frameLayout = ((ItemQuestionDetailViewBinding) getBinding()).textViewContainer;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        String message = feed.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "feed.message");
        boolean z = false;
        boolean z2 = message.length() == 0;
        int dp2px = DisplayUtils.dp2px(frameLayout.getContext(), 0.0f);
        if (!z2) {
            dp2px = -2;
        }
        layoutParams.height = dp2px;
        frameLayout.requestLayout();
        TextView textView = ((ItemQuestionDetailViewBinding) getBinding()).countView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.countView");
        textView.setText(getContext().getString(2131886594, Integer.valueOf(feed.getQuestionAnswerNum())));
        UserAction userAction = feed.getUserAction();
        if (userAction != null && userAction.getFollow() == 1) {
            z = true;
        }
        setFollowQuestionState(z, feed.getQuestionFollowNum());
        String order = this.presenter.getOrder();
        int i = 2131886548;
        switch (order.hashCode()) {
            case 3321751:
                if (order.equals("like")) {
                    i = 2131886549;
                    break;
                }
                break;
            case 93832333:
                if (order.equals("block")) {
                    i = 2131887132;
                    break;
                }
                break;
            case 108401386:
                order.equals("reply");
                break;
            case 1793464482:
                if (order.equals("dateline")) {
                    i = 2131886547;
                    break;
                }
                break;
        }
        ((ItemQuestionDetailViewBinding) getBinding()).orderText.setText(i);
        ((ItemQuestionDetailViewBinding) getBinding()).executePendingBindings();
    }

    /* access modifiers changed from: private */
    public final void setContentMessage() {
        Feed feed = this.presenter.getFeed();
        if (this.showMaxWords) {
            TextView textView = ((ItemQuestionDetailViewBinding) getBinding()).textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            ViewExtendsKt.setBriefMessage(textView, Integer.MAX_VALUE, feed.getMessage(), "");
            return;
        }
        TextView textView2 = ((ItemQuestionDetailViewBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
        String message = feed.getMessage();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131886656));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
        Unit unit = Unit.INSTANCE;
        ViewExtendsKt.setBriefMessage(textView2, 75, message, spannableStringBuilder);
    }

    private final void setFollowQuestionState(boolean z, int i) {
        T t;
        Feed feed = this.presenter.getFeed();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        List<RelatedData> userFollowList = feed.getUserFollowList();
        Intrinsics.checkNotNullExpressionValue(userFollowList, "feed.userFollowList");
        Iterator<T> it2 = userFollowList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            String uid = t2.getUid();
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (Intrinsics.areEqual(uid, loginSession.getUid())) {
                break;
            }
        }
        T t3 = t;
        boolean z2 = t3 != null;
        if (t3 == null) {
            RelatedData.Builder newBuilder = RelatedData.newBuilder();
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            t3 = ((RelatedData.Builder) ((RelatedData.Builder) ((RelatedData.Builder) newBuilder.setUid(loginSession.getUid())).setDisplayUserName(loginSession.getUserName())).setValue(0).setDeprecatedUserAvatar(loginSession.getUserAvatar())).build();
        }
        if (z && !z2) {
            feed.getUserFollowList().add(0, t3);
        } else if (!z && z2) {
            feed.getUserFollowList().remove(t3);
        }
        ItemQuestionDetailViewBinding itemQuestionDetailViewBinding = (ItemQuestionDetailViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemQuestionDetailViewBinding, "binding");
        itemQuestionDetailViewBinding.setModel(this.presenter.getFeed());
        String uid2 = this.presenter.getFeed().getUid();
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        LoginSession loginSession2 = instance2.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
        boolean z3 = Intrinsics.areEqual(uid2, loginSession2.getUid()) || this.presenter.getFeed().getIsAnonymous() == 1;
        TextView textView = ((ItemQuestionDetailViewBinding) getBinding()).followView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.followView");
        textView.setVisibility(z3 ? 8 : 0);
        TextView textView2 = ((ItemQuestionDetailViewBinding) getBinding()).followNumView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.followNumView");
        textView2.setText(getContext().getString(2131886814, Integer.valueOf(i)));
        if (z) {
            TextView textView3 = ((ItemQuestionDetailViewBinding) getBinding()).followView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.followView");
            textView3.setText("已关注");
            TextView textView4 = ((ItemQuestionDetailViewBinding) getBinding()).followView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.followView");
            textView4.setBackgroundTintList(ColorStateList.valueOf(ResourceUtils.getColorInt(getContext(), 2131099911)));
            ((ItemQuestionDetailViewBinding) getBinding()).followView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131099891));
        } else {
            TextView textView5 = ((ItemQuestionDetailViewBinding) getBinding()).followView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.followView");
            textView5.setText("关注问题");
            TextView textView6 = ((ItemQuestionDetailViewBinding) getBinding()).followView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.followView");
            textView6.setBackgroundTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
            ((ItemQuestionDetailViewBinding) getBinding()).followView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131099912));
        }
        ((ItemQuestionDetailViewBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed = this.presenter.getFeed();
        boolean z = false;
        switch (view.getId()) {
            case 2131362200:
                return;
            case 2131362582:
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                    Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                    if (checkLogin.booleanValue()) {
                        StatisticHelper.Companion.getInstance().recordQuestionAction("关注问题");
                        UserAction userAction = feed.getUserAction();
                        if (userAction != null && userAction.getFollow() == 1) {
                            z = true;
                        }
                        int questionFollowNum = feed.getQuestionFollowNum() + (z ? -1 : 1);
                        QuestionPresenter questionPresenter = this.presenter;
                        String id = feed.getId();
                        if (id == null) {
                            id = "";
                        }
                        questionPresenter.followQuestion(z, id);
                        setFollowQuestionState(!z, questionFollowNum);
                        return;
                    }
                    return;
                }
                return;
            case 2131362708:
                List<RelatedData> userFollowList = feed.getUserFollowList();
                Intrinsics.checkNotNullExpressionValue(userFollowList, "feed.userFollowList");
                RelatedData relatedData = (RelatedData) CollectionsKt.getOrNull(userFollowList, 0);
                if (relatedData != null) {
                    ActionManager.startUserSpaceActivity(view, relatedData.getUid(), relatedData.getUserAvatar());
                    return;
                }
                return;
            case 2131362709:
                List<RelatedData> userFollowList2 = feed.getUserFollowList();
                Intrinsics.checkNotNullExpressionValue(userFollowList2, "feed.userFollowList");
                RelatedData relatedData2 = (RelatedData) CollectionsKt.getOrNull(userFollowList2, 1);
                if (relatedData2 != null) {
                    ActionManager.startUserSpaceActivity(view, relatedData2.getUid(), relatedData2.getUserAvatar());
                    return;
                }
                return;
            case 2131362710:
                List<RelatedData> userFollowList3 = feed.getUserFollowList();
                Intrinsics.checkNotNullExpressionValue(userFollowList3, "feed.userFollowList");
                RelatedData relatedData3 = (RelatedData) CollectionsKt.getOrNull(userFollowList3, 2);
                if (relatedData3 != null) {
                    ActionManager.startUserSpaceActivity(view, relatedData3.getUid(), relatedData3.getUserAvatar());
                    return;
                }
                return;
            case 2131362961:
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManager.startFeedFollowerListActivity(UiUtils.getActivityNullable(context), feed.getId());
                return;
            case 2131363058:
                this.presenter.showOrderPopMenu(view);
                return;
            case 2131363877:
                ActionManager.startUserSpaceActivity(view, feed.getUid(), feed.getUserAvatar());
                return;
            default:
                super.onClick(view);
                return;
        }
    }
}
