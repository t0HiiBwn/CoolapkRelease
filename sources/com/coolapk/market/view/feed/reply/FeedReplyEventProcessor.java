package com.coolapk.market.view.feed.reply;

import com.coolapk.market.event.FeedReplyBlockEvent;
import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.event.FeedReplyLikeEvent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bj\u0002`\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u001eH\u0007R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bj\u0002`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyEventProcessor;", "", "dataList", "", "Lcom/coolapk/market/model/Entity;", "feedId", "", "handleFeedReply", "Lkotlin/Function2;", "Lcom/coolapk/market/model/FeedReply;", "", "", "Lcom/coolapk/market/view/feed/reply/HandleFeedReplyListener;", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getDataList", "()Ljava/util/List;", "getFeedId", "()Ljava/lang/String;", "attach", "detach", "onFeedReply", "event", "Lcom/coolapk/market/event/FeedReplyEvent;", "onFeedReplyBlock", "Lcom/coolapk/market/event/FeedReplyBlockEvent;", "onFeedReplyDelete", "Lcom/coolapk/market/event/FeedReplyDeleteEvent;", "onFeedReplyLike", "Lcom/coolapk/market/event/FeedReplyLikeEvent;", "onUserBlockedEvent", "Lcom/coolapk/market/event/UserBlockedEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyEventProcessor.kt */
public final class FeedReplyEventProcessor {
    private final List<? super Entity> dataList;
    private final String feedId;
    private final Function2<FeedReply, Boolean, Unit> handleFeedReply;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super com.coolapk.market.model.FeedReply, ? super java.lang.Boolean, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedReplyEventProcessor(List<? super Entity> list, String str, Function2<? super FeedReply, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        Intrinsics.checkNotNullParameter(str, "feedId");
        Intrinsics.checkNotNullParameter(function2, "handleFeedReply");
        this.dataList = list;
        this.feedId = str;
        this.handleFeedReply = function2;
    }

    public final List<? super Entity> getDataList() {
        return this.dataList;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final void attach() {
        EventBus.getDefault().register(this);
    }

    public final void detach() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public final void onFeedReply(FeedReplyEvent feedReplyEvent) {
        Intrinsics.checkNotNullParameter(feedReplyEvent, "event");
        FeedReply feedReply = feedReplyEvent.getFeedReply();
        Intrinsics.checkNotNullExpressionValue(feedReply, "reply");
        if (!(!Intrinsics.areEqual(feedReply.getFeedId(), this.feedId))) {
            boolean z = false;
            if (feedReply.hasParentReply()) {
                int i = 0;
                for (T t : this.dataList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (!(t instanceof FeedReply)) {
                        t = null;
                    }
                    T t2 = t;
                    if (t2 != null && Intrinsics.areEqual(t2.getId(), feedReply.getParentReplyId())) {
                        ArrayList arrayList = new ArrayList();
                        if (!CollectionUtils.isEmpty(t2.getReplyRows())) {
                            arrayList.addAll(t2.getReplyRows());
                        }
                        arrayList.add(feedReply);
                        FeedReply build = FeedReply.builder(t2).setReplyRowsCount(t2.getReplyRowsCount() + 1).setReplyRows(arrayList).build();
                        Intrinsics.checkNotNullExpressionValue(build, "FeedReply.builder(source…                 .build()");
                        this.dataList.set(i, build);
                        z = true;
                    }
                    i = i2;
                }
            }
            this.handleFeedReply.invoke(feedReply, Boolean.valueOf(z));
        }
    }

    @Subscribe
    public final void onFeedReplyLike(FeedReplyLikeEvent feedReplyLikeEvent) {
        Intrinsics.checkNotNullParameter(feedReplyLikeEvent, "event");
        List<? super Entity> list = this.dataList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if ((obj instanceof FeedReply) && Intrinsics.areEqual(((FeedReply) obj).getId(), feedReplyLikeEvent.getId())) {
                Object obj2 = list.get(i);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.coolapk.market.model.FeedReply");
                FeedReply handleEvent = feedReplyLikeEvent.handleEvent((FeedReply) obj2);
                Intrinsics.checkNotNullExpressionValue(handleEvent, "event.handleEvent(newFeedReply)");
                this.dataList.set(i, handleEvent);
            }
        }
    }

    @Subscribe
    public final void onFeedReplyDelete(FeedReplyDeleteEvent feedReplyDeleteEvent) {
        Intrinsics.checkNotNullParameter(feedReplyDeleteEvent, "event");
        List<? super Entity> list = this.dataList;
        FeedReply feedReply = feedReplyDeleteEvent.getFeedReply();
        int i = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (obj instanceof FeedReply) {
                FeedReply feedReply2 = (FeedReply) obj;
                String id = feedReply2.getId();
                Intrinsics.checkNotNullExpressionValue(feedReply, "newReply");
                if (Intrinsics.areEqual(id, feedReply.getId())) {
                    list.remove(i);
                } else if (feedReply.hasParentReply() && Intrinsics.areEqual(feedReply2.getId(), feedReply.getParentReplyId())) {
                    int size = feedReply2.getReplyRows().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        FeedReply feedReply3 = feedReply2.getReplyRows().get(i2);
                        Intrinsics.checkNotNullExpressionValue(feedReply3, "sourceReply.replyRows[j]");
                        if (Intrinsics.areEqual(feedReply3.getId(), feedReply.getId())) {
                            ArrayList arrayList = new ArrayList();
                            if (!CollectionUtils.isEmpty(feedReply2.getReplyRows())) {
                                arrayList.addAll(feedReply2.getReplyRows());
                            }
                            arrayList.remove(i2);
                            List<? super Entity> list2 = this.dataList;
                            FeedReply build = FeedReply.builder(feedReply2).setReplyRowsCount(feedReply2.getReplyRowsCount() - 1).setReplyRows(arrayList).build();
                            Intrinsics.checkNotNullExpressionValue(build, "FeedReply.builder(source…                 .build()");
                            list2.set(i, build);
                        }
                    }
                }
            }
            i++;
        }
    }

    @Subscribe
    public final void onFeedReplyBlock(FeedReplyBlockEvent feedReplyBlockEvent) {
        Intrinsics.checkNotNullParameter(feedReplyBlockEvent, "event");
        List<? super Entity> list = this.dataList;
        FeedReply feedReply = feedReplyBlockEvent.getFeedReply();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj instanceof FeedReply) {
                FeedReply feedReply2 = (FeedReply) obj;
                if (feedReply.hasParentReply()) {
                    String id = feedReply2.getId();
                    Intrinsics.checkNotNullExpressionValue(feedReply, "newReply");
                    if (Intrinsics.areEqual(id, feedReply.getParentReplyId())) {
                        int size2 = feedReply2.getReplyRows().size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            FeedReply feedReply3 = feedReply2.getReplyRows().get(i2);
                            Intrinsics.checkNotNullExpressionValue(feedReply3, "sourceReply.replyRows[j]");
                            if (Intrinsics.areEqual(feedReply3.getId(), feedReply.getId())) {
                                ArrayList arrayList = new ArrayList();
                                if (!CollectionUtils.isEmpty(feedReply2.getReplyRows())) {
                                    arrayList.addAll(feedReply2.getReplyRows());
                                }
                                arrayList.remove(i2);
                                feedReply2 = FeedReply.builder(feedReply2).setReplyRowsCount(feedReply2.getReplyRowsCount() - 1).setReplyRows(arrayList).build();
                                Intrinsics.checkNotNullExpressionValue(feedReply2, "FeedReply.builder(source…                 .build()");
                                this.dataList.set(i, feedReply2);
                            }
                        }
                    }
                } else {
                    String id2 = feedReply2.getId();
                    Intrinsics.checkNotNullExpressionValue(feedReply, "newReply");
                    if (Intrinsics.areEqual(id2, feedReply.getId())) {
                        list.remove(i);
                    }
                }
            }
        }
    }

    @Subscribe
    public final void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
        Intrinsics.checkNotNullParameter(userBlockedEvent, "event");
        int i = 0;
        if (userBlockedEvent.getIsInBlackList() > 0) {
            List<? super Entity> list = this.dataList;
            while (i < list.size()) {
                Object obj = list.get(i);
                if (obj instanceof Feed) {
                    Feed removeFromChildList = userBlockedEvent.removeFromChildList((Feed) obj);
                    if (removeFromChildList != null) {
                        if (removeFromChildList != obj) {
                            list.set(i, removeFromChildList);
                        }
                    } else {
                        return;
                    }
                } else if (obj instanceof FeedReply) {
                    FeedReply removeFeedReply = userBlockedEvent.removeFeedReply((FeedReply) obj);
                    if (removeFeedReply == null) {
                        list.remove(i);
                        i--;
                    } else if (removeFeedReply != obj) {
                        list.set(i, removeFeedReply);
                    }
                    i++;
                }
                i++;
            }
        }
    }
}
