package com.coolapk.market.view.feed;

import androidx.databinding.ObservableArrayList;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0006R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/feed/FeedEventListener;", "", "source", "Lcom/coolapk/market/model/Feed;", "onUpdate", "Lkotlin/Function1;", "", "onDelete", "Lkotlin/Function0;", "(Lcom/coolapk/market/model/Feed;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "callback", "com/coolapk/market/view/feed/FeedEventListener$callback$1", "Lcom/coolapk/market/view/feed/FeedEventListener$callback$1;", "list", "Landroidx/databinding/ObservableArrayList;", "Lcom/coolapk/market/model/Entity;", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "getOnUpdate", "()Lkotlin/jvm/functions/Function1;", "processor", "Lcom/coolapk/market/view/feed/FeedEventProcessor;", "getSource", "()Lcom/coolapk/market/model/Feed;", "setSource", "(Lcom/coolapk/market/model/Feed;)V", "register", "resetFeed", "feed", "unregister", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEventListener.kt */
public final class FeedEventListener {
    private final FeedEventListener$callback$1 callback;
    private final ObservableArrayList<Entity> list;
    private final Function0<Unit> onDelete;
    private final Function1<Feed, Unit> onUpdate;
    private FeedEventProcessor processor;
    private Feed source;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.coolapk.market.model.Feed, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedEventListener(Feed feed, Function1<? super Feed, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(feed, "source");
        this.source = feed;
        this.onUpdate = function1;
        this.onDelete = function0;
        FeedEventListener$callback$1 feedEventListener$callback$1 = new FeedEventListener$callback$1(this);
        this.callback = feedEventListener$callback$1;
        ObservableArrayList<Entity> observableArrayList = new ObservableArrayList<>();
        observableArrayList.add(this.source);
        observableArrayList.addOnListChangedCallback(feedEventListener$callback$1);
        Unit unit = Unit.INSTANCE;
        this.list = observableArrayList;
    }

    public final Function0<Unit> getOnDelete() {
        return this.onDelete;
    }

    public final Function1<Feed, Unit> getOnUpdate() {
        return this.onUpdate;
    }

    public final Feed getSource() {
        return this.source;
    }

    public final void setSource(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "<set-?>");
        this.source = feed;
    }

    public final void resetFeed(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.source = feed;
        this.list.removeOnListChangedCallback(this.callback);
        this.list.set(0, feed);
        this.list.addOnListChangedCallback(this.callback);
    }

    public final void register() {
        if (this.processor == null) {
            FeedEventProcessor feedEventProcessor = new FeedEventProcessor(this.list, null);
            this.processor = feedEventProcessor;
            if (feedEventProcessor != null) {
                feedEventProcessor.register();
                return;
            }
            return;
        }
        throw new IllegalStateException("it had register before");
    }

    public final void unregister() {
        FeedEventProcessor feedEventProcessor = this.processor;
        if (feedEventProcessor != null) {
            feedEventProcessor.unregister();
        }
        this.processor = null;
    }
}
