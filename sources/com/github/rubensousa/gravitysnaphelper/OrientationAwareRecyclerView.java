package com.github.rubensousa.gravitysnaphelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public class OrientationAwareRecyclerView extends RecyclerView {
    private float lastX;
    private float lastY;
    private boolean scrolling;

    public OrientationAwareRecyclerView(Context context) {
        this(context, null);
    }

    public OrientationAwareRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrientationAwareRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastX = 0.0f;
        this.lastY = 0.0f;
        this.scrolling = false;
        addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class com.github.rubensousa.gravitysnaphelper.OrientationAwareRecyclerView.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                OrientationAwareRecyclerView.this.scrolling = i != 0;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z2 = true;
        if (actionMasked == 0) {
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
            if (this.scrolling) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(1);
                return super.onInterceptTouchEvent(obtain);
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (Math.abs(y - this.lastY) > Math.abs(x - this.lastX)) {
                z = layoutManager.canScrollVertically();
            } else {
                z = layoutManager.canScrollHorizontally();
            }
            z2 = z;
        }
        if (!z2) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
