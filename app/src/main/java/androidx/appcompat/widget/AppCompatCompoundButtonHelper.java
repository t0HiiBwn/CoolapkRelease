package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;
    private final CompoundButton mView;

    interface DirectSetButtonDrawableInterface {
        void setButtonDrawable(Drawable drawable);
    }

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    void loadFromAttributes(AttributeSet attributeSet, int i) {
        boolean z;
        int resourceId;
        int resourceId2;
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonCompat) && (resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    CompoundButton compoundButton = this.mView;
                    compoundButton.setButtonDrawable(AppCompatResources.getDrawable(compoundButton.getContext(), resourceId2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z && obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                    CompoundButton compoundButton2 = this.mView;
                    compoundButton2.setButtonDrawable(AppCompatResources.getDrawable(compoundButton2.getContext(), resourceId));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                    CompoundButtonCompat.setButtonTintList(this.mView, obtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                    CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
                }
            }
            z = false;
            CompoundButton compoundButton2 = this.mView;
            compoundButton2.setButtonDrawable(AppCompatResources.getDrawable(compoundButton2.getContext(), resourceId));
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    void setSupportButtonTintMode(PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }

    PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    void applyButtonTint() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.mHasButtonTint) {
                DrawableCompat.setTintList(mutate, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                DrawableCompat.setTintMode(mutate, this.mButtonTintMode);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.mView.getDrawableState());
            }
            this.mView.setButtonDrawable(mutate);
        }
    }

    int getCompoundPaddingLeft(int i) {
        Drawable buttonDrawable;
        return (Build.VERSION.SDK_INT >= 17 || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView)) == null) ? i : i + buttonDrawable.getIntrinsicWidth();
    }
}
