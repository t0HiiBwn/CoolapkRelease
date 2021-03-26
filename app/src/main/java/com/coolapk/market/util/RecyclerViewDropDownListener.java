package com.coolapk.market.util;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/util/RecyclerViewDropDownListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "context", "Landroid/content/Context;", "callback", "Lcom/coolapk/market/util/DropDownCallback;", "(Landroid/content/Context;Lcom/coolapk/market/util/DropDownCallback;)V", "getCallback", "()Lcom/coolapk/market/util/DropDownCallback;", "getContext", "()Landroid/content/Context;", "dropOffset", "", "interceptFollowEvent", "", "Ljava/lang/Boolean;", "startX", "", "startY", "touchSlop", "onInterceptTouchEvent", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "event", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "disallowIntercept", "onTouchEvent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewDropDownUtils.kt */
public final class RecyclerViewDropDownListener implements RecyclerView.OnItemTouchListener {
    private final DropDownCallback callback;
    private final Context context;
    private int dropOffset;
    private Boolean interceptFollowEvent;
    private float startX;
    private float startY;
    private int touchSlop;

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public RecyclerViewDropDownListener(Context context2, DropDownCallback dropDownCallback) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(dropDownCallback, "callback");
        this.context = context2;
        this.callback = dropDownCallback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public final DropDownCallback getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.startY;
                    if (rawY < ((float) 0)) {
                        rawY = 0.0f;
                    }
                    int i = (int) rawY;
                    this.dropOffset = i;
                    this.callback.onDropDownOffset(i);
                    return;
                } else if (action != 3) {
                    return;
                }
            }
            this.callback.onDropDownEnd(this.dropOffset);
            return;
        }
        this.startX = motionEvent.getRawX();
        this.startY = motionEvent.getRawY();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startX = motionEvent.getRawX();
            this.startY = motionEvent.getRawY();
            this.interceptFollowEvent = null;
        } else if (action == 2) {
            Boolean bool = this.interceptFollowEvent;
            if (bool != null) {
                Intrinsics.checkNotNull(bool);
                return bool.booleanValue();
            } else if (!ViewExtendsKt.canScrollDown(recyclerView) && motionEvent.getRawY() - this.startY > ((float) this.touchSlop)) {
                return true;
            } else {
                if (this.startY - motionEvent.getRawY() > ((float) this.touchSlop)) {
                    this.interceptFollowEvent = false;
                }
            }
        }
        return false;
    }
}
