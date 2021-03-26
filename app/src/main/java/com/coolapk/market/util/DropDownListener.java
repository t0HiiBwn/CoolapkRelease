package com.coolapk.market.util;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/util/DropDownListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "callback", "Lcom/coolapk/market/util/DropDownCallback;", "(Landroid/content/Context;Lcom/coolapk/market/util/DropDownCallback;)V", "getCallback", "()Lcom/coolapk/market/util/DropDownCallback;", "getContext", "()Landroid/content/Context;", "dropOffset", "", "isDropDownStarted", "", "startX", "", "startY", "touchSlop", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewDropDownUtils.kt */
public final class DropDownListener implements View.OnTouchListener {
    private final DropDownCallback callback;
    private final Context context;
    private int dropOffset;
    private boolean isDropDownStarted;
    private float startX;
    private float startY;
    private int touchSlop;

    public DropDownListener(Context context2, DropDownCallback dropDownCallback) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (r4 != 3) goto L_0x0052;
     */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.startY;
                    if (this.isDropDownStarted) {
                        if (rawY < ((float) 0)) {
                            rawY = 0.0f;
                        }
                        int i = (int) rawY;
                        this.dropOffset = i;
                        this.callback.onDropDownOffset(i);
                    } else if (rawY > ((float) this.touchSlop)) {
                        int i2 = (int) rawY;
                        this.dropOffset = i2;
                        this.callback.onDropDownOffset(i2);
                        this.isDropDownStarted = true;
                    }
                }
                return false;
            }
            if (this.isDropDownStarted) {
                this.callback.onDropDownEnd(this.dropOffset);
            }
            return false;
        }
        this.startX = motionEvent.getRawX();
        this.startY = motionEvent.getRawY();
        this.isDropDownStarted = false;
        return true;
    }
}
