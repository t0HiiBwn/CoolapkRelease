package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;

class ClearTextEndIconDelegate extends EndIconDelegate {
    private static final int ANIMATION_FADE_DURATION = 100;
    private static final int ANIMATION_SCALE_DURATION = 150;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private final TextWatcher clearTextEndIconTextWatcher = new TextWatcher() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass1 */

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (ClearTextEndIconDelegate.this.textInputLayout.getSuffixText() == null) {
                ClearTextEndIconDelegate.this.animateIcon(ClearTextEndIconDelegate.hasText(editable));
            }
        }
    };
    private final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass3 */

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(ClearTextEndIconDelegate.hasText(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(ClearTextEndIconDelegate.this.onFocusChangeListener);
            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            editText.addTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
        }
    };
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass4 */

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 2) {
                editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
                if (editText.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.onFocusChangeListener) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        }
    };
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    private final View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass2 */

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
            ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
            if (!z3 || !z) {
                z2 = false;
            }
            clearTextEndIconDelegate.animateIcon(z2);
        }
    };

    ClearTextEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R.drawable.mtrl_ic_cancel));
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass5 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Editable text = ClearTextEndIconDelegate.this.textInputLayout.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void onSuffixVisibilityChanged(boolean z) {
        if (this.textInputLayout.getSuffixText() != null) {
            animateIcon(z);
        }
    }

    /* access modifiers changed from: private */
    public void animateIcon(boolean z) {
        boolean z2 = this.textInputLayout.isEndIconVisible() == z;
        if (z) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z2) {
                this.iconInAnim.end();
                return;
            }
            return;
        }
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (z2) {
            this.iconOutAnim.end();
        }
    }

    private void initAnimators() {
        ValueAnimator scaleAnimator = getScaleAnimator();
        ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(scaleAnimator, alphaAnimator);
        this.iconInAnim.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass6 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
            }
        });
        ValueAnimator alphaAnimator2 = getAlphaAnimator(1.0f, 0.0f);
        this.iconOutAnim = alphaAnimator2;
        alphaAnimator2.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass7 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
            }
        });
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass8 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass9 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ClearTextEndIconDelegate.this.endIconView.setScaleX(floatValue);
                ClearTextEndIconDelegate.this.endIconView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public static boolean hasText(Editable editable) {
        return editable.length() > 0;
    }
}
