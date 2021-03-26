package com.coolapk.market.view.feed;

import com.coolapk.market.event.FeedBlockEvent;
import com.coolapk.market.event.FeedCensorEvent;
import com.coolapk.market.event.FeedDeleteEvent;
import com.coolapk.market.event.FeedEditorChoiceEvent;
import com.coolapk.market.event.FeedFavoriteEvent;
import com.coolapk.market.event.FeedGoodsRecommendEvent;
import com.coolapk.market.event.FeedLikeEvent;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.event.FeedRecommendEvent;
import com.coolapk.market.event.FeedReplyBlockEvent;
import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001,B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0017H\u0007J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\"H\u0007J\u0006\u0010#\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\tJ2\u0010%\u001a\u00020&*\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u00032\u0006\u0010'\u001a\u00020(2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010+0*H\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/coolapk/market/view/feed/FeedEventProcessor;", "", "dataList", "", "Lcom/coolapk/market/model/Entity;", "interceptor", "Lcom/coolapk/market/view/feed/FeedEventProcessor$EventInterceptor;", "(Ljava/util/List;Lcom/coolapk/market/view/feed/FeedEventProcessor$EventInterceptor;)V", "onFeedBlocked", "", "event", "Lcom/coolapk/market/event/FeedBlockEvent;", "onFeedCensorChanged", "Lcom/coolapk/market/event/FeedCensorEvent;", "onFeedDeleted", "Lcom/coolapk/market/event/FeedDeleteEvent;", "onFeedFavoriteChange", "Lcom/coolapk/market/event/FeedFavoriteEvent;", "onFeedGoodsRecommend", "Lcom/coolapk/market/event/FeedGoodsRecommendEvent;", "onFeedPosted", "Lcom/coolapk/market/event/FeedPostEvent;", "onFeedRecommendChange", "Lcom/coolapk/market/event/FeedEditorChoiceEvent;", "Lcom/coolapk/market/event/FeedRecommendEvent;", "onFeedReply", "Lcom/coolapk/market/event/FeedReplyEvent;", "onFeedReplyBlock", "Lcom/coolapk/market/event/FeedReplyBlockEvent;", "onFeedReplyDelete", "Lcom/coolapk/market/event/FeedReplyDeleteEvent;", "onLikeChange", "Lcom/coolapk/market/event/FeedLikeEvent;", "onUserBlockedEvent", "Lcom/coolapk/market/event/UserBlockedEvent;", "register", "unregister", "handleFeedDataList", "", "feedId", "", "action", "Lkotlin/Function1;", "Lcom/coolapk/market/model/Feed;", "EventInterceptor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEventProcessor.kt */
public final class FeedEventProcessor {
    private final List<? super Entity> dataList;
    private final EventInterceptor interceptor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/FeedEventProcessor$EventInterceptor;", "", "shouldInterceptFeedEvent", "", "event", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedEventProcessor.kt */
    public interface EventInterceptor {
        boolean shouldInterceptFeedEvent(Object obj);
    }

    public FeedEventProcessor(List<? super Entity> list, EventInterceptor eventInterceptor) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        this.dataList = list;
        this.interceptor = eventInterceptor;
    }

    public final void register() {
        EventBus.getDefault().register(this);
    }

    public final void unregister() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public final void onLikeChange(FeedLikeEvent feedLikeEvent) {
        Intrinsics.checkNotNullParameter(feedLikeEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedLikeEvent)) {
            List<? super Entity> list = this.dataList;
            String id = feedLikeEvent.getId();
            Intrinsics.checkNotNullExpressionValue(id, "event.id");
            handleFeedDataList(list, id, new FeedEventProcessor$onLikeChange$1(feedLikeEvent));
        }
    }

    @Subscribe
    public final void onFeedGoodsRecommend(FeedGoodsRecommendEvent feedGoodsRecommendEvent) {
        Intrinsics.checkNotNullParameter(feedGoodsRecommendEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedGoodsRecommendEvent)) {
            handleFeedDataList(this.dataList, feedGoodsRecommendEvent.getId(), new FeedEventProcessor$onFeedGoodsRecommend$1(feedGoodsRecommendEvent));
        }
    }

    @Subscribe
    public final void onFeedReply(FeedReplyEvent feedReplyEvent) {
        Intrinsics.checkNotNullParameter(feedReplyEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedReplyEvent)) {
            List<? super Entity> list = this.dataList;
            FeedReply feedReply = feedReplyEvent.getFeedReply();
            Intrinsics.checkNotNullExpressionValue(feedReply, "event.feedReply");
            String feedId = feedReply.getFeedId();
            Intrinsics.checkNotNullExpressionValue(feedId, "event.feedReply.feedId");
            handleFeedDataList(list, feedId, new FeedEventProcessor$onFeedReply$1(feedReplyEvent));
        }
    }

    @Subscribe
    public final void onFeedFavoriteChange(FeedFavoriteEvent feedFavoriteEvent) {
        Intrinsics.checkNotNullParameter(feedFavoriteEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedFavoriteEvent)) {
            List<? super Entity> list = this.dataList;
            String id = feedFavoriteEvent.getId();
            Intrinsics.checkNotNullExpressionValue(id, "event.id");
            handleFeedDataList(list, id, new FeedEventProcessor$onFeedFavoriteChange$1(feedFavoriteEvent));
        }
    }

    @Subscribe
    public final void onFeedRecommendChange(FeedRecommendEvent feedRecommendEvent) {
        Intrinsics.checkNotNullParameter(feedRecommendEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedRecommendEvent)) {
            List<? super Entity> list = this.dataList;
            String id = feedRecommendEvent.getId();
            Intrinsics.checkNotNullExpressionValue(id, "event.id");
            handleFeedDataList(list, id, new FeedEventProcessor$onFeedRecommendChange$1(feedRecommendEvent));
        }
    }

    @Subscribe
    public final void onFeedRecommendChange(FeedEditorChoiceEvent feedEditorChoiceEvent) {
        Intrinsics.checkNotNullParameter(feedEditorChoiceEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedEditorChoiceEvent)) {
            List<? super Entity> list = this.dataList;
            String id = feedEditorChoiceEvent.getId();
            Intrinsics.checkNotNullExpressionValue(id, "event.id");
            handleFeedDataList(list, id, new FeedEventProcessor$onFeedRecommendChange$2(feedEditorChoiceEvent));
        }
    }

    @Subscribe
    public final void onFeedCensorChanged(FeedCensorEvent feedCensorEvent) {
        Intrinsics.checkNotNullParameter(feedCensorEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedCensorEvent)) {
            handleFeedDataList(this.dataList, feedCensorEvent.getFeedId(), new FeedEventProcessor$onFeedCensorChanged$1(feedCensorEvent));
        }
    }

    @Subscribe
    public final void onFeedReplyDelete(FeedReplyDeleteEvent feedReplyDeleteEvent) {
        Intrinsics.checkNotNullParameter(feedReplyDeleteEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedReplyDeleteEvent)) {
            List<? super Entity> list = this.dataList;
            FeedReply feedReply = feedReplyDeleteEvent.getFeedReply();
            Intrinsics.checkNotNullExpressionValue(feedReply, "event.feedReply");
            String feedId = feedReply.getFeedId();
            Intrinsics.checkNotNullExpressionValue(feedId, "event.feedReply.feedId");
            handleFeedDataList(list, feedId, new FeedEventProcessor$onFeedReplyDelete$1(feedReplyDeleteEvent));
        }
    }

    @Subscribe
    public final void onFeedReplyBlock(FeedReplyBlockEvent feedReplyBlockEvent) {
        Intrinsics.checkNotNullParameter(feedReplyBlockEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedReplyBlockEvent)) {
            List<? super Entity> list = this.dataList;
            FeedReply feedReply = feedReplyBlockEvent.getFeedReply();
            Intrinsics.checkNotNullExpressionValue(feedReply, "event.feedReply");
            String feedId = feedReply.getFeedId();
            Intrinsics.checkNotNullExpressionValue(feedId, "event.feedReply.feedId");
            handleFeedDataList(list, feedId, new FeedEventProcessor$onFeedReplyBlock$1(feedReplyBlockEvent));
        }
    }

    @Subscribe
    public final void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
        Intrinsics.checkNotNullParameter(userBlockedEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(userBlockedEvent)) {
            int i = 0;
            if (userBlockedEvent.getIsInBlackList() > 0) {
                while (i < this.dataList.size()) {
                    Object obj = this.dataList.get(i);
                    if (obj instanceof Feed) {
                        Feed removeFromChildList = userBlockedEvent.removeFromChildList((Feed) obj);
                        if (removeFromChildList == null) {
                            this.dataList.remove(i);
                            i--;
                        } else if (removeFromChildList != obj) {
                            this.dataList.set(i, removeFromChildList);
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Subscribe
    public final void onFeedPosted(FeedPostEvent feedPostEvent) {
        Intrinsics.checkNotNullParameter(feedPostEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedPostEvent)) {
            List<? super Entity> list = this.dataList;
            String id = feedPostEvent.getFeed().getId();
            if (id == null) {
                id = "";
            }
            handleFeedDataList(list, id, new FeedEventProcessor$onFeedPosted$1(feedPostEvent));
        }
    }

    @Subscribe
    public final void onFeedDeleted(FeedDeleteEvent feedDeleteEvent) {
        Intrinsics.checkNotNullParameter(feedDeleteEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if (eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedDeleteEvent)) {
            List<? super Entity> list = this.dataList;
            String str = feedDeleteEvent.id;
            Intrinsics.checkNotNullExpressionValue(str, "event.id");
            handleFeedDataList(list, str, FeedEventProcessor$onFeedDeleted$1.INSTANCE);
        }
    }

    @Subscribe
    public final void onFeedBlocked(FeedBlockEvent feedBlockEvent) {
        Intrinsics.checkNotNullParameter(feedBlockEvent, "event");
        EventInterceptor eventInterceptor = this.interceptor;
        if ((eventInterceptor == null || !eventInterceptor.shouldInterceptFeedEvent(feedBlockEvent)) && feedBlockEvent.isBlocked) {
            List<? super Entity> list = this.dataList;
            String str = feedBlockEvent.id;
            Intrinsics.checkNotNullExpressionValue(str, "event.id");
            handleFeedDataList(list, str, FeedEventProcessor$onFeedBlocked$1.INSTANCE);
        }
    }

    private final boolean handleFeedDataList(List<? super Entity> list, String str, Function1<? super Feed, ? extends Feed> function1) {
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (!(obj instanceof Feed) || !Intrinsics.areEqual(((Feed) obj).getId(), str)) {
                if (obj instanceof EntityCard) {
                    EntityCard entityCard = (EntityCard) obj;
                    List<Entity> entities = entityCard.getEntities();
                    Intrinsics.checkNotNull(entities);
                    if (entities.size() > 0) {
                        List<Entity> entities2 = entityCard.getEntities();
                        Intrinsics.checkNotNull(entities2);
                        Intrinsics.checkNotNullExpressionValue(entities2, "item.entities!!");
                        if (handleFeedDataList(entities2, str, function1)) {
                            if (entities2.size() == 0) {
                                list.remove(i);
                            } else {
                                list.set(i, obj);
                            }
                            return true;
                        }
                    }
                }
                if ((obj instanceof Album) && Intrinsics.areEqual(str, ((Album) obj).getId())) {
                    list.remove(i);
                    return true;
                }
            } else {
                Feed feed = (Feed) function1.invoke(obj);
                if (feed == null) {
                    list.remove(i);
                } else {
                    list.set(i, feed);
                }
                return true;
            }
        }
        return false;
    }
}
