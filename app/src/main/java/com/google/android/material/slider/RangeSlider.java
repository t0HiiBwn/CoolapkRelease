package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.google.android.material.R;
import com.google.android.material.slider.BaseSlider;
import java.util.ArrayList;
import java.util.List;

public class RangeSlider extends BaseSlider<RangeSlider, OnChangeListener, OnSliderTouchListener> {

    public interface OnChangeListener extends BaseOnChangeListener<RangeSlider> {
    }

    public interface OnSliderTouchListener extends BaseOnSliderTouchListener<RangeSlider> {
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void clearOnChangeListeners() {
        super.clearOnChangeListeners();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void clearOnSliderTouchListeners() {
        super.clearOnSliderTouchListeners();
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getActiveThumbIndex() {
        return super.getActiveThumbIndex();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getFocusedThumbIndex() {
        return super.getFocusedThumbIndex();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getHaloRadius() {
        return super.getHaloRadius();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getHaloTintList() {
        return super.getHaloTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getLabelBehavior() {
        return super.getLabelBehavior();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getStepSize() {
        return super.getStepSize();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getThumbElevation() {
        return super.getThumbElevation();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getThumbRadius() {
        return super.getThumbRadius();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getThumbTintList() {
        return super.getThumbTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTickActiveTintList() {
        return super.getTickActiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTickInactiveTintList() {
        return super.getTickInactiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTickTintList() {
        return super.getTickTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTrackActiveTintList() {
        return super.getTrackActiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTrackHeight() {
        return super.getTrackHeight();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTrackInactiveTintList() {
        return super.getTrackInactiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTrackSidePadding() {
        return super.getTrackSidePadding();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTrackTintList() {
        return super.getTrackTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTrackWidth() {
        return super.getTrackWidth();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getValueFrom() {
        return super.getValueFrom();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getValueTo() {
        return super.getValueTo();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ boolean hasLabelFormatter() {
        return super.hasLabelFormatter();
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i) {
        super.setFocusedThumbIndex(i);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadius(int i) {
        super.setHaloRadius(i);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadiusResource(int i) {
        super.setHaloRadiusResource(i);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloTintList(ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelBehavior(int i) {
        super.setLabelBehavior(i);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelFormatter(BaseSlider.LabelFormatter labelFormatter) {
        super.setLabelFormatter(labelFormatter);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setStepSize(float f) {
        super.setStepSize(f);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevation(float f) {
        super.setThumbElevation(f);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevationResource(int i) {
        super.setThumbElevationResource(i);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadius(int i) {
        super.setThumbRadius(i);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadiusResource(int i) {
        super.setThumbRadiusResource(i);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbTintList(ColorStateList colorStateList) {
        super.setThumbTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveTintList(ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveTintList(ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickTintList(ColorStateList colorStateList) {
        super.setTickTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackActiveTintList(ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackHeight(int i) {
        super.setTrackHeight(i);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackTintList(ColorStateList colorStateList) {
        super.setTrackTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setValueFrom(float f) {
        super.setValueFrom(f);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setValueTo(float f) {
        super.setValueTo(f);
    }

    public RangeSlider(Context context) {
        this(context, null);
    }

    public RangeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public RangeSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.values});
        if (obtainStyledAttributes.hasValue(0)) {
            setValues(convertToFloat(obtainStyledAttributes.getResources().obtainTypedArray(obtainStyledAttributes.getResourceId(0, 0))));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(Float... fArr) {
        super.setValues(fArr);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(List<Float> list) {
        super.setValues(list);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public List<Float> getValues() {
        return super.getValues();
    }

    private static List<Float> convertToFloat(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < typedArray.length(); i++) {
            arrayList.add(Float.valueOf(typedArray.getFloat(i, -1.0f)));
        }
        return arrayList;
    }
}
