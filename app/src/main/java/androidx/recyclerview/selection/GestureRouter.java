package androidx.recyclerview.selection;

import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import androidx.core.util.Preconditions;

final class GestureRouter<T extends GestureDetector.OnGestureListener & GestureDetector.OnDoubleTapListener> implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private final ToolHandlerRegistry<T> mDelegates;

    GestureRouter(T t) {
        Preconditions.checkArgument(t != null);
        this.mDelegates = new ToolHandlerRegistry<>(t);
    }

    GestureRouter() {
        this(new GestureDetector.SimpleOnGestureListener());
    }

    public void register(int i, T t) {
        this.mDelegates.set(i, t);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return this.mDelegates.get(motionEvent).onSingleTapConfirmed(motionEvent);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return this.mDelegates.get(motionEvent).onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return this.mDelegates.get(motionEvent).onDoubleTapEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.mDelegates.get(motionEvent).onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        this.mDelegates.get(motionEvent).onShowPress(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.mDelegates.get(motionEvent).onSingleTapUp(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.mDelegates.get(motionEvent2).onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.mDelegates.get(motionEvent).onLongPress(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.mDelegates.get(motionEvent2).onFling(motionEvent, motionEvent2, f, f2);
    }
}
