package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioGroupPlus extends LinearLayout {
    private int mCheckedId = -1;
    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private PassThroughHierarchyChangeListener mPassThroughListener;
    private boolean mProtectFromCheckedChange = false;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(RadioGroupPlus radioGroupPlus, int i);
    }

    public RadioGroupPlus(Context context) {
        super(context);
        setOrientation(1);
        init();
    }

    public RadioGroupPlus(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mChildOnCheckedChangeListener = new CheckedStateTracker();
        PassThroughHierarchyChangeListener passThroughHierarchyChangeListener = new PassThroughHierarchyChangeListener();
        this.mPassThroughListener = passThroughHierarchyChangeListener;
        super.setOnHierarchyChangeListener(passThroughHierarchyChangeListener);
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mPassThroughListener.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.mCheckedId;
        if (i != -1) {
            this.mProtectFromCheckedChange = true;
            setCheckedStateForView(i, true);
            this.mProtectFromCheckedChange = false;
            setCheckedId(this.mCheckedId);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof RadioButton) {
            RadioButton radioButton = (RadioButton) view;
            if (radioButton.isChecked()) {
                this.mProtectFromCheckedChange = true;
                int i2 = this.mCheckedId;
                if (i2 != -1) {
                    setCheckedStateForView(i2, false);
                }
                this.mProtectFromCheckedChange = false;
                setCheckedId(radioButton.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    public void check(int i) {
        if (i == -1 || i != this.mCheckedId) {
            int i2 = this.mCheckedId;
            if (i2 != -1) {
                setCheckedStateForView(i2, false);
            }
            if (i != -1) {
                setCheckedStateForView(i, true);
            }
            setCheckedId(i);
        }
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i) {
        this.mCheckedId = i;
        OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, i);
        }
    }

    /* access modifiers changed from: private */
    public void setCheckedStateForView(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof RadioButton)) {
            ((RadioButton) findViewById).setChecked(z);
        }
    }

    public int getCheckedRadioButtonId() {
        return this.mCheckedId;
    }

    public void clearCheck() {
        check(-1);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof RadioGroup.LayoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
    public CharSequence getAccessibilityClassName() {
        return RadioGroup.class.getName();
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            if (typedArray.hasValue(i)) {
                this.width = typedArray.getLayoutDimension(i, "layout_width");
            } else {
                this.width = -2;
            }
            if (typedArray.hasValue(i2)) {
                this.height = typedArray.getLayoutDimension(i2, "layout_height");
            } else {
                this.height = -2;
            }
        }
    }

    private class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!RadioGroupPlus.this.mProtectFromCheckedChange) {
                RadioGroupPlus.this.mProtectFromCheckedChange = true;
                if (RadioGroupPlus.this.mCheckedId != -1) {
                    RadioGroupPlus radioGroupPlus = RadioGroupPlus.this;
                    radioGroupPlus.setCheckedStateForView(radioGroupPlus.mCheckedId, false);
                }
                RadioGroupPlus.this.mProtectFromCheckedChange = false;
                RadioGroupPlus.this.setCheckedId(compoundButton.getId());
            }
        }
    }

    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;

        private PassThroughHierarchyChangeListener() {
        }

        public void traverseTree(View view) {
            if (view instanceof RadioButton) {
                if (view.getId() == -1) {
                    view.setId(View.generateViewId());
                }
                ((RadioButton) view).setOnCheckedChangeListener(RadioGroupPlus.this.mChildOnCheckedChangeListener);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() != 0) {
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        traverseTree(viewGroup.getChildAt(i));
                    }
                }
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            traverseTree(view2);
            if (view == RadioGroupPlus.this && (view2 instanceof RadioButton)) {
                if (view2.getId() == -1) {
                    view2.setId(View.generateViewId());
                }
                ((RadioButton) view2).setOnCheckedChangeListener(RadioGroupPlus.this.mChildOnCheckedChangeListener);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == RadioGroupPlus.this && (view2 instanceof RadioButton)) {
                ((RadioButton) view2).setOnCheckedChangeListener(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }
}
