package androidx.databinding.adapters;

import android.widget.RadioGroup;
import androidx.databinding.InverseBindingListener;

public class RadioGroupBindingAdapter {
    public static void setCheckedButton(RadioGroup radioGroup, int i) {
        if (i != radioGroup.getCheckedRadioButtonId()) {
            radioGroup.check(i);
        }
    }

    public static void setListeners(RadioGroup radioGroup, final RadioGroup.OnCheckedChangeListener onCheckedChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                /* class androidx.databinding.adapters.RadioGroupBindingAdapter.AnonymousClass1 */

                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = onCheckedChangeListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(radioGroup, i);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
