package com.coolapk.market.view.wallpaper.coolpic;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001:B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u001b\u001a\u00020\u0016J\b\u0010-\u001a\u00020,H\u0014J\b\u0010.\u001a\u00020,H\u0014J\u0012\u0010/\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0012\u00100\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020*H\u0016J\u000e\u00103\u001a\u00020,2\u0006\u0010\b\u001a\u00020\tJ\u000e\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u0016J\u000e\u00106\u001a\u00020,2\u0006\u0010\u001b\u001a\u00020\u0016J\u0012\u00107\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u00109\u001a\u00020,R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u000e\u0010\u001a\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "click", "Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicViewPager$VpClick;", "curP", "Landroid/graphics/PointF;", "getCurP", "()Landroid/graphics/PointF;", "setCurP", "(Landroid/graphics/PointF;)V", "currentDownTime", "", "currentId", "", "currentItemIndex", "detachedInCurrentVp", "", "downP", "getDownP", "setDownP", "hasMultiTouch", "isLocked", "mClickListener", "Landroid/view/View$OnClickListener;", "mClickRunnable", "Ljava/lang/Runnable;", "mDetector", "Landroid/view/GestureDetector;", "mGestureListener", "Landroid/view/GestureDetector$OnGestureListener;", "xDown", "", "xMove", "yDown", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "init", "", "onAttachedToWindow", "onDetachedFromWindow", "onInterceptEvent", "onInterceptTouchEvent", "onTouchEvent", "event", "setClick", "setDetachedInCurrentVp", "boolean", "setLocked", "setOnClickListener", "l", "toggleLock", "VpClick", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewPager.kt */
public final class CoolPicViewPager extends ViewPager {
    private VpClick click;
    private PointF curP = new PointF();
    private long currentDownTime;
    private int currentId;
    private int currentItemIndex;
    private boolean detachedInCurrentVp;
    private PointF downP = new PointF();
    private boolean hasMultiTouch;
    private boolean isLocked = false;
    private View.OnClickListener mClickListener;
    private final Runnable mClickRunnable = new CoolPicViewPager$mClickRunnable$1(this);
    private GestureDetector mDetector;
    private final GestureDetector.OnGestureListener mGestureListener = new CoolPicViewPager$mGestureListener$1(this);
    private float xDown;
    private float xMove;
    private float yDown;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicViewPager$VpClick;", "", "canScroll", "", "clickItem", "", "view", "Landroid/view/View;", "doubleClickItem", "xDown", "", "yDown", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolPicViewPager.kt */
    public interface VpClick {
        boolean canScroll();

        void clickItem(View view);

        void doubleClickItem(View view, float f, float f2);
    }

    public final PointF getCurP() {
        return this.curP;
    }

    public final void setCurP(PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.curP = pointF;
    }

    public final PointF getDownP() {
        return this.downP;
    }

    public final void setDownP(PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.downP = pointF;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolPicViewPager(Context context) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolPicViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    public final void setClick(VpClick vpClick) {
        Intrinsics.checkNotNullParameter(vpClick, "click");
        this.click = vpClick;
    }

    public final void setDetachedInCurrentVp(boolean z) {
        this.detachedInCurrentVp = z;
    }

    private final void init(Context context) {
        this.mDetector = new GestureDetector(context, this.mGestureListener);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isLocked) {
            return false;
        }
        try {
            return onInterceptEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private final boolean onInterceptEvent(MotionEvent motionEvent) {
        PointF pointF = this.curP;
        Float valueOf = motionEvent != null ? Float.valueOf(motionEvent.getX()) : null;
        Intrinsics.checkNotNull(valueOf);
        pointF.x = valueOf.floatValue();
        this.curP.y = motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        boolean z = true;
        if (action == 0) {
            this.downP.x = motionEvent.getX();
            this.downP.y = motionEvent.getY();
            this.xDown = motionEvent.getX();
            this.yDown = motionEvent.getY();
            if (motionEvent.getPointerCount() < 2) {
                z = false;
            }
            this.hasMultiTouch = z;
            this.currentDownTime = System.currentTimeMillis();
            super.onInterceptTouchEvent(motionEvent);
            return false;
        } else if (action == 2) {
            VpClick vpClick = this.click;
            Intrinsics.checkNotNull(vpClick);
            if (vpClick.canScroll() || this.hasMultiTouch) {
                return false;
            }
            this.xMove = motionEvent.getX();
            float y = motionEvent.getY();
            float f = (float) 2;
            if (Math.abs(this.xMove - this.xDown) <= f || Math.abs(this.xMove - this.xDown) - Math.abs(y - this.yDown) <= f) {
                z = false;
            }
            return z;
        } else if (action != 5) {
            return false;
        } else {
            this.hasMultiTouch = motionEvent.getPointerCount() >= 2;
            getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        return !this.isLocked && super.onTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (r5.canScroll() != false) goto L_0x005e;
     */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.mDetector;
        Intrinsics.checkNotNull(gestureDetector);
        gestureDetector.onTouchEvent(motionEvent);
        PointF pointF = this.curP;
        Float valueOf = motionEvent != null ? Float.valueOf(motionEvent.getX()) : null;
        Intrinsics.checkNotNull(valueOf);
        pointF.x = valueOf.floatValue();
        this.curP.y = motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.downP.x = motionEvent.getX();
            this.downP.y = motionEvent.getY();
            this.xDown = motionEvent.getX();
            this.yDown = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            this.xMove = motionEvent.getX();
            float y = motionEvent.getY();
            boolean z = false;
            this.hasMultiTouch = motionEvent.getPointerCount() >= 2;
            ViewParent parent = getParent();
            if (!this.hasMultiTouch) {
                VpClick vpClick = this.click;
                Intrinsics.checkNotNull(vpClick);
            }
            z = true;
            parent.requestDisallowInterceptTouchEvent(z);
            float abs = Math.abs(this.xMove - this.xDown) - Math.abs(y - this.yDown);
            float f = (float) 2;
            if (abs > f && Math.abs(this.xMove - this.xDown) > f) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mFirstLayout");
            Intrinsics.checkNotNullExpressionValue(declaredField, "mFirstLayout");
            declaredField.setAccessible(true);
            declaredField.set(this, false);
            PagerAdapter adapter = getAdapter();
            Intrinsics.checkNotNull(adapter);
            adapter.notifyDataSetChanged();
            if (getId() == this.currentId) {
                i = this.currentItemIndex;
            } else {
                i = getCurrentItem();
            }
            setCurrentItem(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        CoolPicListFragment fragment;
        super.onDetachedFromWindow();
        try {
            this.currentId = getId();
            this.currentItemIndex = getCurrentItem();
            Activity currentActivity = AppHolder.getCurrentActivity();
            if ((currentActivity instanceof CoolPicDetailActivity) && (fragment = ((CoolPicDetailActivity) currentActivity).getFragment()) != null) {
                this.detachedInCurrentVp = fragment.getDetachedInCurrentView();
            }
            if (!this.detachedInCurrentVp) {
                setCurrentItem(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void toggleLock() {
        this.isLocked = !this.isLocked;
    }

    public final void setLocked(boolean z) {
        this.isLocked = z;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mClickListener = onClickListener;
    }
}
