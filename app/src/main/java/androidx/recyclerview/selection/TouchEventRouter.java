package androidx.recyclerview.selection;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

final class TouchEventRouter implements RecyclerView.OnItemTouchListener {
    private static final String TAG = "TouchEventRouter";
    private final ToolHandlerRegistry<RecyclerView.OnItemTouchListener> mDelegates;
    private final GestureDetector mDetector;

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    TouchEventRouter(GestureDetector gestureDetector, RecyclerView.OnItemTouchListener onItemTouchListener) {
        boolean z = true;
        Preconditions.checkArgument(gestureDetector != null);
        Preconditions.checkArgument(onItemTouchListener == null ? false : z);
        this.mDetector = gestureDetector;
        this.mDelegates = new ToolHandlerRegistry<>(onItemTouchListener);
    }

    TouchEventRouter(GestureDetector gestureDetector) {
        this(gestureDetector, new RecyclerView.OnItemTouchListener() {
            /* class androidx.recyclerview.selection.TouchEventRouter.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }
        });
    }

    void register(int i, RecyclerView.OnItemTouchListener onItemTouchListener) {
        Preconditions.checkArgument(onItemTouchListener != null);
        this.mDelegates.set(i, onItemTouchListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        return this.mDelegates.get(motionEvent).onInterceptTouchEvent(recyclerView, motionEvent) | this.mDetector.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.mDelegates.get(motionEvent).onTouchEvent(recyclerView, motionEvent);
        this.mDetector.onTouchEvent(motionEvent);
    }
}
