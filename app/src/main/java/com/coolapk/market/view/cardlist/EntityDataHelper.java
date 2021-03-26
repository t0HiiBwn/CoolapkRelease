package com.coolapk.market.view.cardlist;

import android.app.Application;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.widget.MainSpareHandler;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0014\u001a\u00020\u000fH\u0002R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityDataHelper;", "", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "assistDataMap", "Ljava/util/HashMap;", "Landroid/os/Parcelable;", "Lcom/coolapk/market/view/cardlist/EntityDataHelper$BaseAssistData;", "Lkotlin/collections/HashMap;", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "textView", "Landroid/widget/TextView;", "generateAssistDataFor", "", "entity", "Lcom/coolapk/market/model/Feed;", "notifyDataSetChange", "obtainAssistData", "postUpdataAssistData", "BaseAssistData", "FeedAssistData", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityDataHelper.kt */
public final class EntityDataHelper {
    private final HashMap<Parcelable, BaseAssistData> assistDataMap = new HashMap<>();
    private final EntityListFragment fragment;
    private final TextView textView = new TextView(AppHolder.getApplication());

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityDataHelper$BaseAssistData;", "", "()V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EntityDataHelper.kt */
    public static class BaseAssistData {
    }

    public EntityDataHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    public final void notifyDataSetChange() {
        if (this.fragment.isAdded()) {
            postUpdataAssistData();
        }
    }

    private final void postUpdataAssistData() {
        MainSpareHandler.Companion.getSInstance().post(new EntityDataHelper$postUpdataAssistData$1(this));
    }

    public final BaseAssistData obtainAssistData(Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "entity");
        return this.assistDataMap.get(parcelable);
    }

    /* access modifiers changed from: private */
    public final void generateAssistDataFor(Feed feed) {
        this.assistDataMap.put(feed, new FeedAssistData(feed, this.textView));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityDataHelper$FeedAssistData;", "Lcom/coolapk/market/view/cardlist/EntityDataHelper$BaseAssistData;", "entity", "Lcom/coolapk/market/model/Feed;", "textView", "Landroid/widget/TextView;", "(Lcom/coolapk/market/model/Feed;Landroid/widget/TextView;)V", "<set-?>", "", "briefMessage", "getBriefMessage", "()Ljava/lang/CharSequence;", "headerInfoHtml", "getHeaderInfoHtml", "replyText", "getReplyText", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EntityDataHelper.kt */
    public static final class FeedAssistData extends BaseAssistData {
        private CharSequence briefMessage;
        private CharSequence headerInfoHtml;
        private CharSequence replyText;

        public FeedAssistData(Feed feed, TextView textView) {
            Intrinsics.checkNotNullParameter(feed, "entity");
            Intrinsics.checkNotNullParameter(textView, "textView");
            Application application = AppHolder.getApplication();
            String message = feed.getMessage();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(application.getString(2131886656));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
            Unit unit = Unit.INSTANCE;
            ViewExtendsKt.setBriefMessage(textView, 90, message, spannableStringBuilder);
            this.briefMessage = textView.getText();
            FeedReply feedReply = null;
            this.headerInfoHtml = LinkTextUtils.convert(feed.getInfoHtml(), AppHolder.getAppTheme().getColorAccent(), null);
            List<FeedReply> replyRows = feed.getReplyRows();
            feedReply = replyRows != null ? (FeedReply) CollectionsKt.firstOrNull((List<? extends Object>) replyRows) : feedReply;
            if (feedReply != null) {
                TextViewBindingAdapters.setReplyText(textView, feedReply);
                this.replyText = textView.getText();
            }
        }

        public final CharSequence getBriefMessage() {
            return this.briefMessage;
        }

        public final CharSequence getHeaderInfoHtml() {
            return this.headerInfoHtml;
        }

        public final CharSequence getReplyText() {
            return this.replyText;
        }
    }
}
