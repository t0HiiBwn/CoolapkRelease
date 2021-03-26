package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

@Deprecated
public class EditTextPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_TEXT = "EditTextPreferenceDialogFragment.text";
    private EditText mEditText;
    private CharSequence mText;

    @Override // androidx.preference.PreferenceDialogFragment
    protected boolean needInputMethod() {
        return true;
    }

    @Deprecated
    public static EditTextPreferenceDialogFragment newInstance(String str) {
        EditTextPreferenceDialogFragment editTextPreferenceDialogFragment = new EditTextPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragment.setArguments(bundle);
        return editTextPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.mText = getEditTextPreference().getText();
        } else {
            this.mText = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.mText);
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        EditText editText = (EditText) view.findViewById(16908291);
        this.mEditText = editText;
        editText.requestFocus();
        EditText editText2 = this.mEditText;
        if (editText2 != null) {
            editText2.setText(this.mText);
            EditText editText3 = this.mEditText;
            editText3.setSelection(editText3.getText().length());
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    private EditTextPreference getEditTextPreference() {
        return (EditTextPreference) getPreference();
    }

    @Override // androidx.preference.PreferenceDialogFragment
    @Deprecated
    public void onDialogClosed(boolean z) {
        if (z) {
            String obj = this.mEditText.getText().toString();
            if (getEditTextPreference().callChangeListener(obj)) {
                getEditTextPreference().setText(obj);
            }
        }
    }
}
