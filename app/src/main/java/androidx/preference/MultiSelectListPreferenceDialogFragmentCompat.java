package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragmentCompat.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragmentCompat.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.values";
    CharSequence[] mEntries;
    CharSequence[] mEntryValues;
    Set<String> mNewValues = new HashSet();
    boolean mPreferenceChanged;

    public static MultiSelectListPreferenceDialogFragmentCompat newInstance(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragmentCompat.setArguments(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
        this.mNewValues.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.mPreferenceChanged = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.mEntries = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.mEntryValues = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.mNewValues));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.mPreferenceChanged);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.mEntries);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.mEntryValues);
    }

    private MultiSelectListPreference getListPreference() {
        return (MultiSelectListPreference) getPreference();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        int length = this.mEntryValues.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.mNewValues.contains(this.mEntryValues[i].toString());
        }
        builder.setMultiChoiceItems(this.mEntries, zArr, new DialogInterface.OnMultiChoiceClickListener() {
            /* class androidx.preference.MultiSelectListPreferenceDialogFragmentCompat.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
                    multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged = MultiSelectListPreferenceDialogFragmentCompat.this.mNewValues.add(MultiSelectListPreferenceDialogFragmentCompat.this.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged;
                    return;
                }
                MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat2 = MultiSelectListPreferenceDialogFragmentCompat.this;
                multiSelectListPreferenceDialogFragmentCompat2.mPreferenceChanged = MultiSelectListPreferenceDialogFragmentCompat.this.mNewValues.remove(MultiSelectListPreferenceDialogFragmentCompat.this.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragmentCompat2.mPreferenceChanged;
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z) {
        if (z && this.mPreferenceChanged) {
            MultiSelectListPreference listPreference = getListPreference();
            if (listPreference.callChangeListener(this.mNewValues)) {
                listPreference.setValues(this.mNewValues);
            }
        }
        this.mPreferenceChanged = false;
    }
}
