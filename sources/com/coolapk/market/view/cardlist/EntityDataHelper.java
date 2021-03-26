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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EntityDataHelper.kt */
public final class EntityDataHelper {
    private final HashMap<Parcelable, BaseAssistData> assistDataMap = new HashMap<>();
    private final EntityListFragment fragment;
    private final TextView textView = new TextView(AppHolder.getApplication());

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

    public final void generateAssistDataFor(Feed feed) {
        this.assistDataMap.put(feed, new FeedAssistData(feed, this.textView));
    }

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
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(application.getString(2131886718));
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
