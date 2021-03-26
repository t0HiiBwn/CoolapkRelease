package com.coolapk.market.view.feed.reply;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemArticleDetailAnswerTopBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticleAnswerTopViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemArticleDetailAnswerTopBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "headerViewPart", "Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "isCheckAnswerCount", "", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "bindToContent", "", "data", "enterAnswerActivity", "onAddAnswerViewClick", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleAnswerTopViewHolder.kt */
public final class ArticleAnswerTopViewHolder extends GenericBindHolder<ItemArticleDetailAnswerTopBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558610;
    private final Lazy headerViewPart$delegate;
    private boolean isCheckAnswerCount;
    private final FeedDetailPresenter presenter;

    private final FeedFollowableHeaderViewPart getHeaderViewPart() {
        return (FeedFollowableHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleAnswerTopViewHolder(View view, DataBindingComponent dataBindingComponent, FeedDetailPresenter feedDetailPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.presenter = feedDetailPresenter;
        ItemArticleDetailAnswerTopBinding itemArticleDetailAnswerTopBinding = (ItemArticleDetailAnswerTopBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemArticleDetailAnswerTopBinding, "binding");
        itemArticleDetailAnswerTopBinding.setClick(this);
        this.headerViewPart$delegate = LazyKt.lazy(new ArticleAnswerTopViewHolder$headerViewPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticleAnswerTopViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleAnswerTopViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        Feed feed = this.presenter.getFeed();
        ItemArticleDetailAnswerTopBinding itemArticleDetailAnswerTopBinding = (ItemArticleDetailAnswerTopBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemArticleDetailAnswerTopBinding, "binding");
        itemArticleDetailAnswerTopBinding.setModel(feed);
        JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(feed);
        if (jsonExtraData == null) {
            jsonExtraData = new JSONObject();
        }
        TextView textView = ((ItemArticleDetailAnswerTopBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        String messageTitle = feed.getMessageTitle();
        if (messageTitle == null) {
            messageTitle = "";
        }
        textView.setText(jsonExtraData.optString("questionTitle", messageTitle));
        getHeaderViewPart().bindToContent(feed);
        if (jsonExtraData.optInt("questionStatus", -1) == 0) {
            TextView textView2 = ((ItemArticleDetailAnswerTopBinding) getBinding()).countView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.countView");
            textView2.setText("提问已删除");
            TextView textView3 = ((ItemArticleDetailAnswerTopBinding) getBinding()).countView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.countView");
            textView3.setClickable(false);
            TextView textView4 = ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerText;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.addAnswerText");
            textView4.setText("无法回答");
            LinearLayout linearLayout = ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addAnswerView");
            linearLayout.setClickable(true);
            ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerText.setTextColor(AppHolder.getAppTheme().getTextColorTertiary());
            ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerImage.setColorFilter(AppHolder.getAppTheme().getTextColorTertiary());
        } else {
            int optInt = jsonExtraData.optInt("questionAnswerNum", 0);
            TextView textView5 = ((ItemArticleDetailAnswerTopBinding) getBinding()).countView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.countView");
            textView5.setText(getContext().getString(2131886595, Integer.valueOf(optInt)));
            TextView textView6 = ((ItemArticleDetailAnswerTopBinding) getBinding()).countView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.countView");
            textView6.setClickable(true);
            TextView textView7 = ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerText;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.addAnswerText");
            textView7.setText("添加回答");
            LinearLayout linearLayout2 = ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.addAnswerView");
            linearLayout2.setClickable(true);
            ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerText.setTextColor(AppHolder.getAppTheme().getColorAccent());
            ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerImage.setColorFilter(AppHolder.getAppTheme().getColorAccent());
        }
        ((ItemArticleDetailAnswerTopBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        Feed feed = this.presenter.getFeed();
        if (!EntityExtendsKt.isDeletedQuestion(feed)) {
            int id = view.getId();
            if (id == 2131361998) {
                onAddAnswerViewClick();
                StatisticHelper.Companion.getInstance().recordAnswerAction("点击添加回答");
            } else if (id == 2131362330 || id == 2131363582) {
                String stringExtraData = EntityExtendsKt.getStringExtraData(feed, "questionUrl", "");
                if (stringExtraData.length() == 0) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(feed), null, null, 12, null);
                } else {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    ActionManagerCompat.startActivityByUrl$default(context2, stringExtraData, null, null, 12, null);
                }
                StatisticHelper.Companion.getInstance().recordAnswerAction(view.getId() == 2131363582 ? "点标题跳转到提问页" : "点【查看全部xx个回答】到提问页");
            }
        }
    }

    private final void onAddAnswerViewClick() {
        if (!this.isCheckAnswerCount) {
            this.isCheckAnswerCount = true;
            LinearLayout linearLayout = ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addAnswerView");
            linearLayout.setClickable(false);
            ImageView imageView = ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerImage;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.addAnswerImage");
            imageView.setVisibility(8);
            TextView textView = ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.addAnswerText");
            textView.setVisibility(8);
            ProgressBar progressBar = ((ItemArticleDetailAnswerTopBinding) getBinding()).addAnswerProgress;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.addAnswerProgress");
            progressBar.setVisibility(0);
            DataManager.getInstance().checkAnswerCount(this.presenter.getFeed().getId(), null).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new ArticleAnswerTopViewHolder$onAddAnswerViewClick$1(this)).subscribe((Subscriber<? super R>) new ArticleAnswerTopViewHolder$onAddAnswerViewClick$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void enterAnswerActivity() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null) {
            ActionManager.startAnswerFeedActivity(activityNullable, this.presenter.getFeed());
        }
    }
}
