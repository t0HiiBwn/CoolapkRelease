package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;

public class UCropView extends FrameLayout {
    private final GestureCropImageView mGestureCropImageView;
    private final OverlayView mViewOverlay;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.ucrop_view, (ViewGroup) this, true);
        GestureCropImageView gestureCropImageView = (GestureCropImageView) findViewById(R.id.image_view_crop);
        this.mGestureCropImageView = gestureCropImageView;
        OverlayView overlayView = (OverlayView) findViewById(R.id.view_overlay);
        this.mViewOverlay = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        overlayView.processStyledAttributes(obtainStyledAttributes);
        gestureCropImageView.processStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        gestureCropImageView.setCropBoundsChangeListener(new CropBoundsChangeListener() {
            /* class com.yalantis.ucrop.view.UCropView.AnonymousClass1 */

            @Override // com.yalantis.ucrop.callback.CropBoundsChangeListener
            public void onCropAspectRatioChanged(float f) {
                UCropView.this.mViewOverlay.setTargetAspectRatio(f);
            }
        });
        overlayView.setOverlayViewChangeListener(new OverlayViewChangeListener() {
            /* class com.yalantis.ucrop.view.UCropView.AnonymousClass2 */

            @Override // com.yalantis.ucrop.callback.OverlayViewChangeListener
            public void onCropRectUpdated(RectF rectF) {
                UCropView.this.mGestureCropImageView.setCropRect(rectF);
            }
        });
    }

    public GestureCropImageView getCropImageView() {
        return this.mGestureCropImageView;
    }

    public OverlayView getOverlayView() {
        return this.mViewOverlay;
    }
}
