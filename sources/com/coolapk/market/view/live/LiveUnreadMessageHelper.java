package com.coolapk.market.view.live;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.AppIMManagerKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.view.cardlist.EntityDataFilter;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010$\u001a\u00020\u0011H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\"H\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/coolapk/market/view/live/LiveUnreadMessageHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "viewGroup", "Landroid/widget/FrameLayout;", "callback", "Lcom/coolapk/market/view/live/LiveUnreadMessageHelper$Callback;", "(Landroid/widget/FrameLayout;Lcom/coolapk/market/view/live/LiveUnreadMessageHelper$Callback;)V", "getCallback", "()Lcom/coolapk/market/view/live/LiveUnreadMessageHelper$Callback;", "floatView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getFloatView", "()Landroid/view/View;", "floatView$delegate", "Lkotlin/Lazy;", "isAddGroup", "", "newMessageText", "Landroid/widget/TextView;", "getNewMessageText", "()Landroid/widget/TextView;", "newMessageText$delegate", "getViewGroup", "()Landroid/widget/FrameLayout;", "handleLiveMessageInsert", "", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "handleUnread", "unreadNum", "", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "onLiveMessageCardLoaded", "entity", "Callback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveUnreadMessageHelper.kt */
public final class LiveUnreadMessageHelper extends EntityDataFilter {
    private final Callback callback;
    private final Lazy floatView$delegate;
    private boolean isAddGroup;
    private final Lazy newMessageText$delegate;
    private final FrameLayout viewGroup;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/live/LiveUnreadMessageHelper$Callback;", "", "onFloatViewClick", "", "view", "Landroid/view/View;", "num", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveUnreadMessageHelper.kt */
    public interface Callback {
        void onFloatViewClick(View view, int i);
    }

    /* access modifiers changed from: private */
    public final View getFloatView() {
        return (View) this.floatView$delegate.getValue();
    }

    private final TextView getNewMessageText() {
        return (TextView) this.newMessageText$delegate.getValue();
    }

    public LiveUnreadMessageHelper(FrameLayout frameLayout, Callback callback2) {
        Intrinsics.checkNotNullParameter(frameLayout, "viewGroup");
        this.viewGroup = frameLayout;
        this.callback = callback2;
        this.floatView$delegate = LazyKt.lazy(new LiveUnreadMessageHelper$floatView$2(this));
        this.newMessageText$delegate = LazyKt.lazy(new LiveUnreadMessageHelper$newMessageText$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveUnreadMessageHelper(FrameLayout frameLayout, Callback callback2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(frameLayout, (i & 2) != 0 ? null : callback2);
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final FrameLayout getViewGroup() {
        return this.viewGroup;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual(((Entity) obj).getEntityType(), "messageUnRead")) {
                break;
            }
        }
        if (obj == null) {
            return list;
        }
        Entity entity = (Entity) obj;
        onLiveMessageCardLoaded(entity);
        return removeData$presentation_coolapkAppRelease(list, entity);
    }

    private final void onLiveMessageCardLoaded(Entity entity) {
        String title = entity.getTitle();
        Intrinsics.checkNotNull(title);
        Intrinsics.checkNotNullExpressionValue(title, "entity.title!!");
        handleUnread(Integer.parseInt(title));
    }

    public final void handleLiveMessageInsert(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "liveMessage");
        int unreadNum = AppIMManagerKt.getUnreadNum(liveMessage);
        if (unreadNum != -1) {
            handleUnread(unreadNum);
        }
    }

    private final void handleUnread(int i) {
        int i2 = 8;
        boolean z = true;
        if (!this.isAddGroup) {
            this.isAddGroup = true;
            FrameLayout frameLayout = this.viewGroup;
            View floatView = getFloatView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 5;
            layoutParams.topMargin = NumberExtendsKt.getDp((Number) 8);
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(floatView, layoutParams);
        }
        getFloatView().setOnClickListener(new LiveUnreadMessageHelper$handleUnread$2(this, i));
        View floatView2 = getFloatView();
        Intrinsics.checkNotNullExpressionValue(floatView2, "floatView");
        if (i <= 0) {
            z = false;
        }
        if (z) {
            i2 = 0;
        }
        floatView2.setVisibility(i2);
        TextView newMessageText = getNewMessageText();
        Intrinsics.checkNotNullExpressionValue(newMessageText, "newMessageText");
        newMessageText.setText(i + " 与我相关");
    }
}
