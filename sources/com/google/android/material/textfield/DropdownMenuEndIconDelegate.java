package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;

class DropdownMenuEndIconDelegate extends EndIconDelegate {
    private static final int ANIMATION_FADE_IN_DURATION = 67;
    private static final int ANIMATION_FADE_OUT_DURATION = 50;
    private static final boolean IS_LOLLIPOP = (Build.VERSION.SDK_INT >= 21);
    private final TextInputLayout.AccessibilityDelegate accessibilityDelegate = new TextInputLayout.AccessibilityDelegate(this.textInputLayout) {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass3 */

        @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            AutoCompleteTextView castAutoCompleteTextViewOrThrow = dropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(dropdownMenuEndIconDelegate.textInputLayout.getEditText());
            if (accessibilityEvent.getEventType() == 1 && DropdownMenuEndIconDelegate.this.accessibilityManager.isTouchExplorationEnabled()) {
                DropdownMenuEndIconDelegate.this.showHideDropdown(castAutoCompleteTextViewOrThrow);
            }
        }
    };
    private AccessibilityManager accessibilityManager;
    private final TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass4 */

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(TextInputLayout textInputLayout) {
            AutoCompleteTextView castAutoCompleteTextViewOrThrow = DropdownMenuEndIconDelegate.this.castAutoCompleteTextViewOrThrow(textInputLayout.getEditText());
            DropdownMenuEndIconDelegate.this.setPopupBackground(castAutoCompleteTextViewOrThrow);
            DropdownMenuEndIconDelegate.this.addRippleEffect(castAutoCompleteTextViewOrThrow);
            DropdownMenuEndIconDelegate.this.setUpDropdownShowHideBehavior(castAutoCompleteTextViewOrThrow);
            castAutoCompleteTextViewOrThrow.setThreshold(0);
            castAutoCompleteTextViewOrThrow.removeTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
            castAutoCompleteTextViewOrThrow.addTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            textInputLayout.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.this.accessibilityDelegate);
            textInputLayout.setEndIconVisible(true);
        }
    };
    private long dropdownPopupActivatedAt = Long.MAX_VALUE;
    private boolean dropdownPopupDirty = false;
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass5 */

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i == 3) {
                autoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
                if (autoCompleteTextView.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.this.onFocusChangeListener) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                if (DropdownMenuEndIconDelegate.IS_LOLLIPOP) {
                    autoCompleteTextView.setOnDismissListener(null);
                }
            }
        }
    };
    private final TextWatcher exposedDropdownEndIconTextWatcher = new TextWatcher() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass1 */

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            final AutoCompleteTextView castAutoCompleteTextViewOrThrow = dropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(dropdownMenuEndIconDelegate.textInputLayout.getEditText());
            castAutoCompleteTextViewOrThrow.post(new Runnable() {
                /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass1.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    boolean isPopupShowing = castAutoCompleteTextViewOrThrow.isPopupShowing();
                    DropdownMenuEndIconDelegate.this.setEndIconChecked(isPopupShowing);
                    DropdownMenuEndIconDelegate.this.dropdownPopupDirty = isPopupShowing;
                }
            });
        }
    };
    private ValueAnimator fadeInAnim;
    private ValueAnimator fadeOutAnim;
    private StateListDrawable filledPopupBackground;
    private boolean isEndIconChecked = false;
    private final View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass2 */

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            DropdownMenuEndIconDelegate.this.textInputLayout.setEndIconActivated(z);
            if (!z) {
                DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
                DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
            }
        }
    };
    private MaterialShapeDrawable outlinedPopupBackground;

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isBoxBackgroundModeSupported(int i) {
        return i != 0;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean shouldTintIconOnError() {
        return true;
    }

    DropdownMenuEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        float dimensionPixelOffset = (float) this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable popUpMaterialShapeDrawable = getPopUpMaterialShapeDrawable(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable popUpMaterialShapeDrawable2 = getPopUpMaterialShapeDrawable(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.outlinedPopupBackground = popUpMaterialShapeDrawable;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.filledPopupBackground = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, popUpMaterialShapeDrawable);
        this.filledPopupBackground.addState(new int[0], popUpMaterialShapeDrawable2);
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, IS_LOLLIPOP ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass6 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DropdownMenuEndIconDelegate.this.showHideDropdown((AutoCompleteTextView) DropdownMenuEndIconDelegate.this.textInputLayout.getEditText());
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
        ViewCompat.setImportantForAccessibility(this.endIconView, 2);
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
    }

    /* access modifiers changed from: private */
    public void showHideDropdown(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView != null) {
            if (isDropdownPopupActive()) {
                this.dropdownPopupDirty = false;
            }
            if (!this.dropdownPopupDirty) {
                if (IS_LOLLIPOP) {
                    setEndIconChecked(!this.isEndIconChecked);
                } else {
                    this.isEndIconChecked = !this.isEndIconChecked;
                    this.endIconView.toggle();
                }
                if (this.isEndIconChecked) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            this.dropdownPopupDirty = false;
        }
    }

    /* access modifiers changed from: private */
    public void setPopupBackground(AutoCompleteTextView autoCompleteTextView) {
        if (IS_LOLLIPOP) {
            int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.outlinedPopupBackground);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.filledPopupBackground);
            }
        }
    }

    /* access modifiers changed from: private */
    public void addRippleEffect(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() == null) {
            int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
            MaterialShapeDrawable boxBackground = this.textInputLayout.getBoxBackground();
            int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorControlHighlight);
            int[][] iArr = {new int[]{16842919}, new int[0]};
            if (boxBackgroundMode == 2) {
                addRippleEffectOnOutlinedLayout(autoCompleteTextView, color, iArr, boxBackground);
            } else if (boxBackgroundMode == 1) {
                addRippleEffectOnFilledLayout(autoCompleteTextView, color, iArr, boxBackground);
            }
        }
    }

    private void addRippleEffectOnOutlinedLayout(AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, MaterialShapeDrawable materialShapeDrawable) {
        LayerDrawable layerDrawable;
        int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorSurface);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        int layer = MaterialColors.layer(i, color, 0.1f);
        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, new int[]{layer, 0}));
        if (IS_LOLLIPOP) {
            materialShapeDrawable2.setTint(color);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{layer, color});
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
            materialShapeDrawable3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable});
        }
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
    }

    private void addRippleEffectOnFilledLayout(AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, MaterialShapeDrawable materialShapeDrawable) {
        int boxBackgroundColor = this.textInputLayout.getBoxBackgroundColor();
        int[] iArr2 = {MaterialColors.layer(i, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (IS_LOLLIPOP) {
            ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), materialShapeDrawable, materialShapeDrawable));
            return;
        }
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable, materialShapeDrawable2});
        int paddingStart = ViewCompat.getPaddingStart(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    /* access modifiers changed from: private */
    public void setUpDropdownShowHideBehavior(final AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass7 */

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (DropdownMenuEndIconDelegate.this.isDropdownPopupActive()) {
                        DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
                    }
                    DropdownMenuEndIconDelegate.this.showHideDropdown(autoCompleteTextView);
                }
                return false;
            }
        });
        autoCompleteTextView.setOnFocusChangeListener(this.onFocusChangeListener);
        if (IS_LOLLIPOP) {
            autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() {
                /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass8 */

                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public void onDismiss() {
                    DropdownMenuEndIconDelegate.this.dropdownPopupDirty = true;
                    DropdownMenuEndIconDelegate.this.dropdownPopupActivatedAt = System.currentTimeMillis();
                    DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
                }
            });
        }
    }

    private MaterialShapeDrawable getPopUpMaterialShapeDrawable(float f, float f2, float f3, int i) {
        ShapeAppearanceModel build = ShapeAppearanceModel.builder().setTopLeftCornerSize(f).setTopRightCornerSize(f).setBottomLeftCornerSize(f2).setBottomRightCornerSize(f2).build();
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.context, f3);
        createWithElevationOverlay.setShapeAppearanceModel(build);
        createWithElevationOverlay.setPadding(0, i, 0, i);
        return createWithElevationOverlay;
    }

    /* access modifiers changed from: private */
    public boolean isDropdownPopupActive() {
        long currentTimeMillis = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* access modifiers changed from: private */
    public AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* access modifiers changed from: private */
    public void setEndIconChecked(boolean z) {
        if (this.isEndIconChecked != z) {
            this.isEndIconChecked = z;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(67, 0.0f, 1.0f);
        ValueAnimator alphaAnimator = getAlphaAnimator(50, 1.0f, 0.0f);
        this.fadeOutAnim = alphaAnimator;
        alphaAnimator.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass9 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate.this.endIconView.setChecked(DropdownMenuEndIconDelegate.this.isEndIconChecked);
                DropdownMenuEndIconDelegate.this.fadeInAnim.start();
            }
        });
    }

    private ValueAnimator getAlphaAnimator(int i, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration((long) i);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass10 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }
}
