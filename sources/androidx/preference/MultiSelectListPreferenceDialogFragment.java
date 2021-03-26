package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragment.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragment.values";
    CharSequence[] mEntries;
    CharSequence[] mEntryValues;
    Set<String> mNewValues = new HashSet();
    boolean mPreferenceChanged;

    @Deprecated
    public static MultiSelectListPreferenceDialogFragment newInstance(String str) {
        MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = new MultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragment.setArguments(bundle);
        return multiSelectListPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference listPreference = getListPreference();
            if (listPreference.getEntries() == null || listPreference.getEntryValues() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.mNewValues.clear();
            this.mNewValues.addAll(listPreference.getValues());
            this.mPreferenceChanged = false;
            this.mEntries = listPreference.getEntries();
            this.mEntryValues = listPreference.getEntryValues();
            return;
        }
        this.mNewValues.clear();
        this.mNewValues.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragment.values"));
        this.mPreferenceChanged = bundle.getBoolean("MultiSelectListPreferenceDialogFragment.changed", false);
        this.mEntries = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries");
        this.mEntryValues = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues");
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragment.values", new ArrayList<>(this.mNewValues));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragment.changed", this.mPreferenceChanged);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries", this.mEntries);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues", this.mEntryValues);
    }

    private MultiSelectListPreference getListPreference() {
        return (MultiSelectListPreference) getPreference();
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        int length = this.mEntryValues.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.mNewValues.contains(this.mEntryValues[i].toString());
        }
        builder.setMultiChoiceItems(this.mEntries, zArr, new DialogInterface.OnMultiChoiceClickListener() {
            /* class androidx.preference.MultiSelectListPreferenceDialogFragment.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                    multiSelectListPreferenceDialogFragment.mPreferenceChanged = MultiSelectListPreferenceDialogFragment.this.mNewValues.add(MultiSelectListPreferenceDialogFragment.this.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragment.mPreferenceChanged;
                    return;
                }
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment2 = MultiSelectListPreferenceDialogFragment.this;
                multiSelectListPreferenceDialogFragment2.mPreferenceChanged = MultiSelectListPreferenceDialogFragment.this.mNewValues.remove(MultiSelectListPreferenceDialogFragment.this.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragment2.mPreferenceChanged;
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragment
    @Deprecated
    public void onDialogClosed(boolean z) {
        MultiSelectListPreference listPreference = getListPreference();
        if (z && this.mPreferenceChanged) {
            Set<String> set = this.mNewValues;
            if (listPreference.callChangeListener(set)) {
                listPreference.setValues(set);
            }
        }
        this.mPreferenceChanged = false;
    }
}
