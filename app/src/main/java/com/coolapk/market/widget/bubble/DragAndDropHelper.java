package com.coolapk.market.widget.bubble;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.coolapk.market.util.UiUtils;

public class DragAndDropHelper {

    public interface DragAndDrawListener {
        void onTargetDrop(View view);
    }

    public static Builder withTarget(View view) {
        return new Builder(view);
    }

    public static class Builder {
        private int color;
        private DragAndDrawListener listener;
        private View target;

        private Builder(View view) {
            this.target = view;
        }

        public Builder setPaintColor(int i) {
            this.color = i;
            return this;
        }

        public Builder setDragListener(DragAndDrawListener dragAndDrawListener) {
            this.listener = dragAndDrawListener;
            return this;
        }

        int getColor() {
            return this.color;
        }

        DragAndDrawListener getListener() {
            return this.listener;
        }

        public View getTarget() {
            return this.target;
        }

        public void apply() {
            this.target.setOnTouchListener(new View.OnTouchListener() {
                /* class com.coolapk.market.widget.bubble.DragAndDropHelper.Builder.AnonymousClass1 */
                private DragAndDropView dragAndDropView;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getActionMasked() == 0) {
                        Activity activity = UiUtils.getActivity(view.getContext());
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                        DragAndDropView dragAndDropView2 = (DragAndDropView) viewGroup.findViewById(DragAndDropView.ID);
                        this.dragAndDropView = dragAndDropView2;
                        if (dragAndDropView2 == null) {
                            DragAndDropView dragAndDropView3 = new DragAndDropView(view.getContext());
                            this.dragAndDropView = dragAndDropView3;
                            dragAndDropView3.setId(DragAndDropView.ID);
                            viewGroup.addView(this.dragAndDropView, new FrameLayout.LayoutParams(-1, -1));
                        }
                    }
                    DragAndDropView dragAndDropView4 = this.dragAndDropView;
                    if (dragAndDropView4 != null) {
                        dragAndDropView4.onDragTargetView(Builder.this, motionEvent);
                    }
                    return true;
                }
            });
        }
    }
}
