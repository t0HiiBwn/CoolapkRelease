package com.soundcloud.android.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.soundcloud.android.crop.HighlightView;
import com.soundcloud.android.crop.ImageViewTouchBase;
import java.util.ArrayList;
import java.util.Iterator;

public class CropImageView extends ImageViewTouchBase {
    Context context;
    ArrayList<HighlightView> highlightViews = new ArrayList<>();
    private float lastX;
    private float lastY;
    private int motionEdge;
    HighlightView motionHighlightView;
    private int validPointerId;

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ Matrix getUnrotatedMatrix() {
        return super.getUnrotatedMatrix();
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase, android.view.KeyEvent.Callback, android.view.View
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase, android.view.KeyEvent.Callback, android.view.View
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase, android.widget.ImageView
    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        super.setImageBitmapResetBase(bitmap, z);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(RotateBitmap rotateBitmap, boolean z) {
        super.setImageRotateBitmapResetBase(rotateBitmap, z);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setRecycler(ImageViewTouchBase.Recycler recycler) {
        super.setRecycler(recycler);
    }

    public CropImageView(Context context2) {
        super(context2);
    }

    public CropImageView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
    }

    public CropImageView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bitmapDisplayed.getBitmap() != null) {
            Iterator<HighlightView> it2 = this.highlightViews.iterator();
            while (it2.hasNext()) {
                HighlightView next = it2.next();
                next.matrix.set(getUnrotatedMatrix());
                next.invalidate();
                if (next.hasFocus()) {
                    centerBasedOnHighlightView(next);
                }
            }
        }
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    protected void zoomTo(float f, float f2, float f3) {
        super.zoomTo(f, f2, f3);
        Iterator<HighlightView> it2 = this.highlightViews.iterator();
        while (it2.hasNext()) {
            HighlightView next = it2.next();
            next.matrix.set(getUnrotatedMatrix());
            next.invalidate();
        }
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    protected void zoomIn() {
        super.zoomIn();
        Iterator<HighlightView> it2 = this.highlightViews.iterator();
        while (it2.hasNext()) {
            HighlightView next = it2.next();
            next.matrix.set(getUnrotatedMatrix());
            next.invalidate();
        }
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    protected void zoomOut() {
        super.zoomOut();
        Iterator<HighlightView> it2 = this.highlightViews.iterator();
        while (it2.hasNext()) {
            HighlightView next = it2.next();
            next.matrix.set(getUnrotatedMatrix());
            next.invalidate();
        }
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    protected void postTranslate(float f, float f2) {
        super.postTranslate(f, f2);
        Iterator<HighlightView> it2 = this.highlightViews.iterator();
        while (it2.hasNext()) {
            HighlightView next = it2.next();
            next.matrix.postTranslate(f, f2);
            next.invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (((CropImageActivity) this.context).isSaving()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            Iterator<HighlightView> it2 = this.highlightViews.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                HighlightView next = it2.next();
                int hit = next.getHit(motionEvent.getX(), motionEvent.getY());
                if (hit != 1) {
                    this.motionEdge = hit;
                    this.motionHighlightView = next;
                    this.lastX = motionEvent.getX();
                    this.lastY = motionEvent.getY();
                    this.validPointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.motionHighlightView.setMode(hit == 32 ? HighlightView.ModifyMode.Move : HighlightView.ModifyMode.Grow);
                }
            }
        } else if (action == 1) {
            HighlightView highlightView = this.motionHighlightView;
            if (highlightView != null) {
                centerBasedOnHighlightView(highlightView);
                this.motionHighlightView.setMode(HighlightView.ModifyMode.None);
            }
            this.motionHighlightView = null;
            center();
        } else if (action == 2) {
            if (this.motionHighlightView != null && motionEvent.getPointerId(motionEvent.getActionIndex()) == this.validPointerId) {
                this.motionHighlightView.handleMotion(this.motionEdge, motionEvent.getX() - this.lastX, motionEvent.getY() - this.lastY);
                this.lastX = motionEvent.getX();
                this.lastY = motionEvent.getY();
            }
            if (getScale() == 1.0f) {
                center();
            }
        }
        return true;
    }

    private void ensureVisible(HighlightView highlightView) {
        Rect rect = highlightView.drawRect;
        int max = Math.max(0, getLeft() - rect.left);
        int min = Math.min(0, getRight() - rect.right);
        int max2 = Math.max(0, getTop() - rect.top);
        int min2 = Math.min(0, getBottom() - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 == 0) {
            max2 = min2;
        }
        if (max != 0 || max2 != 0) {
            panBy((float) max, (float) max2);
        }
    }

    private void centerBasedOnHighlightView(HighlightView highlightView) {
        Rect rect = highlightView.drawRect;
        float max = Math.max(1.0f, Math.min((((float) getWidth()) / ((float) rect.width())) * 0.6f, (((float) getHeight()) / ((float) rect.height())) * 0.6f) * getScale());
        if (((double) (Math.abs(max - getScale()) / max)) > 0.1d) {
            float[] fArr = {highlightView.cropRect.centerX(), highlightView.cropRect.centerY()};
            getUnrotatedMatrix().mapPoints(fArr);
            zoomTo(max, fArr[0], fArr[1], 300.0f);
        }
        ensureVisible(highlightView);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator<HighlightView> it2 = this.highlightViews.iterator();
        while (it2.hasNext()) {
            it2.next().draw(canvas);
        }
    }

    public void add(HighlightView highlightView) {
        this.highlightViews.add(highlightView);
        invalidate();
    }
}
