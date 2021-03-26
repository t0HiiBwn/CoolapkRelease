package com.coolapk.market.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import com.coolapk.market.util.ReflectUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;

public class TintHelper {
    private static int getDefaultRippleColor(Context context, boolean z) {
        return ContextCompat.getColor(context, z ? 2131100042 : 2131100041);
    }

    private static ColorStateList getDisabledColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910}}, new int[]{i2, i});
    }

    public static void setTintSelector(View view, int i, boolean z, boolean z2) {
        ColorStateList colorStateList;
        boolean isColorLight = ATEUtil.isColorLight(i);
        int color = ContextCompat.getColor(view.getContext(), z2 ? 2131099723 : 2131099724);
        float f = 0.9f;
        int shiftColor = ATEUtil.shiftColor(i, z ? 0.9f : 1.1f);
        if (z) {
            f = 1.1f;
        }
        int shiftColor2 = ATEUtil.shiftColor(i, f);
        int defaultRippleColor = getDefaultRippleColor(view.getContext(), isColorLight);
        int color2 = ContextCompat.getColor(view.getContext(), isColorLight ? 2131099736 : 2131099735);
        boolean z3 = view instanceof Button;
        if (z3) {
            colorStateList = getDisabledColorStateList(i, color);
            if (Build.VERSION.SDK_INT >= 21 && (view.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) view.getBackground()).setColor(ColorStateList.valueOf(defaultRippleColor));
            }
            ((Button) view).setTextColor(getDisabledColorStateList(color2, ContextCompat.getColor(view.getContext(), z2 ? 2131099725 : 2131099726)));
        } else if (view instanceof FloatingActionButton) {
            ColorStateList colorStateList2 = new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{i, shiftColor});
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            floatingActionButton.setRippleColor(defaultRippleColor);
            floatingActionButton.setBackgroundTintList(colorStateList2);
            if (floatingActionButton.getDrawable() != null) {
                floatingActionButton.setImageDrawable(createTintedDrawable(floatingActionButton.getDrawable(), color2));
                return;
            }
            return;
        } else {
            colorStateList = new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910}, new int[]{16842910, 16842919}, new int[]{16842910, 16843518}, new int[]{16842910, 16842912}}, new int[]{color, i, shiftColor, shiftColor2, shiftColor2});
        }
        Drawable background = view.getBackground();
        if (background != null) {
            ATEUtil.setBackgroundCompat(view, createTintedDrawable(background, colorStateList));
        }
        if ((view instanceof TextView) && !z3) {
            ((TextView) view).setTextColor(getDisabledColorStateList(color2, ContextCompat.getColor(view.getContext(), isColorLight ? 2131099748 : 2131099747)));
        }
    }

    public static void setTintAuto(View view, int i, boolean z, boolean z2) {
        Drawable background;
        if (!z) {
            if (view instanceof RadioButton) {
                setTint((RadioButton) view, i, z2);
            } else if (view instanceof SeekBar) {
                setTint((SeekBar) view, i, z2);
            } else if (view instanceof ProgressBar) {
                setTint((ProgressBar) view, i);
            } else if (view instanceof EditText) {
                setTint((EditText) view, i, z2);
            } else if (view instanceof CheckBox) {
                setTint((CheckBox) view, i, z2);
            } else if (view instanceof ImageView) {
                setTint((ImageView) view, i);
            } else if (view instanceof Switch) {
                setTint((Switch) view, i, z2);
            } else if (view instanceof SwitchCompat) {
                setTint((SwitchCompat) view, i, z2);
            } else {
                z = true;
            }
            if (Build.VERSION.SDK_INT >= 21 && !z && (view.getBackground() instanceof RippleDrawable)) {
                RippleDrawable rippleDrawable = (RippleDrawable) view.getBackground();
                int color = ContextCompat.getColor(view.getContext(), z2 ? 2131100041 : 2131100042);
                int adjustAlpha = ATEUtil.adjustAlpha(i, 0.4f);
                rippleDrawable.setColor(new ColorStateList(new int[][]{new int[]{-16843518, -16842912}, new int[]{16843518}, new int[]{16842912}}, new int[]{color, adjustAlpha, adjustAlpha}));
            }
        }
        if (!z) {
            return;
        }
        if ((view instanceof FloatingActionButton) || (view instanceof Button)) {
            setTintSelector(view, i, false, z2);
        } else if (view.getBackground() != null && (background = view.getBackground()) != null) {
            ATEUtil.setBackgroundCompat(view, createTintedDrawable(background, i));
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0036: APUT  
      (r1v1 int[])
      (0 ??[int, short, byte, char])
      (wrap: int : 0x0032: INVOKE  (r5v5 int) = 
      (wrap: int : 0x002e: INVOKE  (r5v4 int) = (r5v3 android.content.Context), (r7v0 int) type: STATIC call: androidx.core.content.ContextCompat.getColor(android.content.Context, int):int)
     type: STATIC call: com.coolapk.market.util.ATEUtil.stripAlpha(int):int)
     */
    public static void setTint(RadioButton radioButton, int i, boolean z) {
        int[][] iArr = {new int[]{-16842910}, new int[]{16842910, -16842912}, new int[]{16842910, 16842912}};
        int[] iArr2 = new int[3];
        iArr2[0] = ATEUtil.stripAlpha(ContextCompat.getColor(radioButton.getContext(), z ? 2131099727 : 2131099728));
        iArr2[1] = ContextCompat.getColor(radioButton.getContext(), z ? 2131099729 : 2131099730);
        iArr2[2] = i;
        ColorStateList colorStateList = new ColorStateList(iArr, iArr2);
        if (Build.VERSION.SDK_INT >= 21) {
            radioButton.setButtonTintList(colorStateList);
        } else {
            radioButton.setButtonDrawable(createTintedDrawable(ContextCompat.getDrawable(radioButton.getContext(), 2131230736), colorStateList));
        }
    }

    public static void setTint(SeekBar seekBar, int i, boolean z) {
        ColorStateList disabledColorStateList = getDisabledColorStateList(i, ContextCompat.getColor(seekBar.getContext(), z ? 2131099727 : 2131099728));
        if (Build.VERSION.SDK_INT >= 21) {
            seekBar.setThumbTintList(disabledColorStateList);
            seekBar.setProgressTintList(disabledColorStateList);
        } else if (Build.VERSION.SDK_INT > 10) {
            seekBar.setProgressDrawable(createTintedDrawable(seekBar.getProgressDrawable(), disabledColorStateList));
            if (Build.VERSION.SDK_INT >= 16) {
                seekBar.setThumb(createTintedDrawable(seekBar.getThumb(), disabledColorStateList));
            }
        } else {
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            if (Build.VERSION.SDK_INT <= 10) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (seekBar.getIndeterminateDrawable() != null) {
                seekBar.getIndeterminateDrawable().setColorFilter(i, mode);
            }
            if (seekBar.getProgressDrawable() != null) {
                seekBar.getProgressDrawable().setColorFilter(i, mode);
            }
        }
    }

    public static void setTint(ProgressBar progressBar, int i) {
        setTint(progressBar, i, false);
    }

    public static void setTint(ProgressBar progressBar, int i, boolean z) {
        ColorStateList valueOf = ColorStateList.valueOf(i);
        if (Build.VERSION.SDK_INT >= 21) {
            progressBar.setProgressTintList(valueOf);
            progressBar.setSecondaryProgressTintList(valueOf);
            if (!z) {
                progressBar.setIndeterminateTintList(valueOf);
                return;
            }
            return;
        }
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (Build.VERSION.SDK_INT <= 10) {
            mode = PorterDuff.Mode.MULTIPLY;
        }
        if (!z && progressBar.getIndeterminateDrawable() != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(i, mode);
        }
        if (progressBar.getProgressDrawable() != null) {
            progressBar.getProgressDrawable().setColorFilter(i, mode);
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002f: APUT  
      (r1v1 int[])
      (0 ??[int, short, byte, char])
      (wrap: int : 0x002b: INVOKE  (r4v4 int) = (r4v3 android.content.Context), (r7v0 int) type: STATIC call: androidx.core.content.ContextCompat.getColor(android.content.Context, int):int)
     */
    public static void setTint(EditText editText, int i, boolean z) {
        int[][] iArr = {new int[]{-16842910}, new int[]{16842910, -16842919, -16842908}, new int[0]};
        int[] iArr2 = new int[3];
        iArr2[0] = ContextCompat.getColor(editText.getContext(), z ? 2131099747 : 2131099748);
        iArr2[1] = ContextCompat.getColor(editText.getContext(), z ? 2131099729 : 2131099730);
        iArr2[2] = i;
        ColorStateList colorStateList = new ColorStateList(iArr, iArr2);
        Drawable background = editText.getBackground();
        if (background != null && !(background instanceof ColorDrawable)) {
            if (editText instanceof TintableBackgroundView) {
                ViewCompat.setBackgroundTintList(editText, colorStateList);
            } else if (Build.VERSION.SDK_INT >= 21) {
                editText.setBackgroundTintList(colorStateList);
            }
        }
        setCursorTint(editText, i);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0032: APUT  
      (r1v1 int[])
      (0 ??[int, short, byte, char])
      (wrap: int : 0x002e: INVOKE  (r5v4 int) = (r5v3 android.content.Context), (r7v0 int) type: STATIC call: androidx.core.content.ContextCompat.getColor(android.content.Context, int):int)
     */
    public static void setTint(CheckBox checkBox, int i, boolean z) {
        int[][] iArr = {new int[]{-16842910}, new int[]{16842910, -16842912}, new int[]{16842910, 16842912}};
        int[] iArr2 = new int[3];
        iArr2[0] = ContextCompat.getColor(checkBox.getContext(), z ? 2131099727 : 2131099728);
        iArr2[1] = ContextCompat.getColor(checkBox.getContext(), z ? 2131099729 : 2131099730);
        iArr2[2] = i;
        ColorStateList colorStateList = new ColorStateList(iArr, iArr2);
        if (Build.VERSION.SDK_INT >= 21) {
            checkBox.setButtonTintList(colorStateList);
        } else {
            checkBox.setButtonDrawable(createTintedDrawable(ContextCompat.getDrawable(checkBox.getContext(), 2131230730), colorStateList));
        }
    }

    public static void setTint(ImageView imageView, int i) {
        imageView.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    public static void setTextTint(TextView textView, int i) {
        textView.setTextColor(i);
    }

    private static Drawable modifySwitchDrawable(Context context, Drawable drawable, int i, boolean z, boolean z2, boolean z3) {
        int i2;
        int i3;
        if (z3) {
            i = ATEUtil.shiftColor(i, 1.1f);
        }
        int adjustAlpha = ATEUtil.adjustAlpha(i, (!z2 || z) ? 1.0f : 0.5f);
        if (z) {
            i2 = ContextCompat.getColor(context, z3 ? 2131099739 : 2131099740);
            i3 = ContextCompat.getColor(context, z3 ? 2131099741 : 2131099742);
        } else {
            i2 = ContextCompat.getColor(context, z3 ? 2131099743 : 2131099744);
            i3 = ContextCompat.getColor(context, z3 ? 2131099745 : 2131099746);
        }
        if (!z2) {
            i3 = ATEUtil.stripAlpha(i3);
        }
        return createTintedDrawable(drawable, new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, -16843518, -16842912}, new int[]{16842910, 16843518}, new int[]{16842910, 16842912}}, new int[]{i2, i3, adjustAlpha, adjustAlpha}));
    }

    public static void setTint(Switch r7, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            if (r7.getTrackDrawable() != null) {
                r7.setTrackDrawable(modifySwitchDrawable(r7.getContext(), r7.getTrackDrawable(), i, false, false, z));
            }
            if (r7.getThumbDrawable() != null) {
                r7.setThumbDrawable(modifySwitchDrawable(r7.getContext(), r7.getThumbDrawable(), i, true, false, z));
            }
        }
    }

    public static void setTint(SwitchCompat switchCompat, int i, boolean z) {
        if (switchCompat.getTrackDrawable() != null) {
            switchCompat.setTrackDrawable(modifySwitchDrawable(switchCompat.getContext(), switchCompat.getTrackDrawable(), i, false, true, z));
        }
        if (switchCompat.getThumbDrawable() != null) {
            switchCompat.setThumbDrawable(modifySwitchDrawable(switchCompat.getContext(), switchCompat.getThumbDrawable(), i, true, true, z));
        }
    }

    public static Drawable createTintedDrawable(Drawable drawable, int i) {
        if (drawable == null) {
            return null;
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_IN);
        DrawableCompat.setTint(wrap, i);
        return wrap;
    }

    public static Drawable createTintedDrawable(Drawable drawable, ColorStateList colorStateList) {
        if (drawable == null) {
            return null;
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTintList(wrap, colorStateList);
        return wrap;
    }

    public static void setCursorTint(EditText editText, int i) {
        try {
            int i2 = ReflectUtils.findField(TextView.class, "mCursorDrawableRes").getInt(editText);
            Field findField = ReflectUtils.findField(TextView.class, "mEditor");
            findField.setAccessible(true);
            Object obj = findField.get(editText);
            Field findField2 = ReflectUtils.findField(obj.getClass(), "mCursorDrawable");
            findField2.setAccessible(true);
            Drawable[] drawableArr = new Drawable[2];
            drawableArr[0] = ContextCompat.getDrawable(editText.getContext(), i2);
            drawableArr[0] = createTintedDrawable(drawableArr[0], i);
            drawableArr[1] = ContextCompat.getDrawable(editText.getContext(), i2);
            drawableArr[1] = createTintedDrawable(drawableArr[1], i);
            findField2.set(obj, drawableArr);
            editText.setHighlightColor(ColorUtils.setAlphaComponent(i, 128));
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN);
            ReflectUtils.ReflectObject wrap = ReflectUtils.wrap(obj);
            ReflectUtils.ReflectObject wrap2 = ReflectUtils.wrap(editText);
            Drawable drawable = (Drawable) wrap.getChildField("mSelectHandleLeft").getAs(Drawable.class);
            if (drawable == null) {
                drawable = editText.getContext().getDrawable(((Integer) wrap2.getChildField("mTextSelectHandleLeftRes").getAs(Integer.class)).intValue());
            }
            drawable.setColorFilter(porterDuffColorFilter);
            Drawable drawable2 = (Drawable) wrap.getChildField("mSelectHandleRight").getAs(Drawable.class);
            if (drawable2 == null) {
                drawable2 = editText.getContext().getDrawable(((Integer) wrap2.getChildField("mTextSelectHandleRightRes").getAs(Integer.class)).intValue());
            }
            drawable2.setColorFilter(porterDuffColorFilter);
            Drawable drawable3 = (Drawable) wrap.getChildField("mSelectHandleCenter").getAs(Drawable.class);
            if (drawable3 == null) {
                drawable3 = editText.getContext().getDrawable(((Integer) wrap2.getChildField("mTextSelectHandleRes").getAs(Integer.class)).intValue());
            }
            drawable3.setColorFilter(porterDuffColorFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setTextInputLayoutHint(TextInputLayout textInputLayout, int i) {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mDefaultTextColor");
            declaredField.setAccessible(true);
            declaredField.set(textInputLayout, ColorStateList.valueOf(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setTextInputLayoutAccent(TextInputLayout textInputLayout, int i) {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mFocusedTextColor");
            declaredField.setAccessible(true);
            declaredField.set(textInputLayout, ColorStateList.valueOf(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
