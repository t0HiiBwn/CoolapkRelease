package androidx.databinding.adapters;

import android.widget.AutoCompleteTextView;
import androidx.databinding.adapters.AdapterViewBindingAdapter;

public class AutoCompleteTextViewBindingAdapter {

    public interface FixText {
        CharSequence fixText(CharSequence charSequence);
    }

    public interface IsValid {
        boolean isValid(CharSequence charSequence);
    }

    public static void setValidator(AutoCompleteTextView autoCompleteTextView, final FixText fixText, final IsValid isValid) {
        if (fixText == null && isValid == null) {
            autoCompleteTextView.setValidator(null);
        } else {
            autoCompleteTextView.setValidator(new AutoCompleteTextView.Validator() {
                /* class androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.AnonymousClass1 */

                @Override // android.widget.AutoCompleteTextView.Validator
                public boolean isValid(CharSequence charSequence) {
                    IsValid isValid = isValid;
                    if (isValid != null) {
                        return isValid.isValid(charSequence);
                    }
                    return true;
                }

                @Override // android.widget.AutoCompleteTextView.Validator
                public CharSequence fixText(CharSequence charSequence) {
                    FixText fixText = fixText;
                    return fixText != null ? fixText.fixText(charSequence) : charSequence;
                }
            });
        }
    }

    public static void setOnItemSelectedListener(AutoCompleteTextView autoCompleteTextView, AdapterViewBindingAdapter.OnItemSelected onItemSelected, AdapterViewBindingAdapter.OnNothingSelected onNothingSelected) {
        if (onItemSelected == null && onNothingSelected == null) {
            autoCompleteTextView.setOnItemSelectedListener(null);
        } else {
            autoCompleteTextView.setOnItemSelectedListener(new AdapterViewBindingAdapter.OnItemSelectedComponentListener(onItemSelected, onNothingSelected, null));
        }
    }
}
