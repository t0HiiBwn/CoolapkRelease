package androidx.databinding.adapters;

import android.widget.CompoundButton;
import androidx.databinding.InverseBindingListener;

public class CompoundButtonBindingAdapter {
    public static void setChecked(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isChecked() != z) {
            compoundButton.setChecked(z);
        }
    }

    public static void setListeners(CompoundButton compoundButton, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class androidx.databinding.adapters.CompoundButtonBindingAdapter.AnonymousClass1 */

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = onCheckedChangeListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
