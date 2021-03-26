package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

@Deprecated
public class ListPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_ENTRIES = "ListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "ListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_INDEX = "ListPreferenceDialogFragment.index";
    int mClickedDialogEntryIndex;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;

    @Deprecated
    public static ListPreferenceDialogFragment newInstance(String str) {
        ListPreferenceDialogFragment listPreferenceDialogFragment = new ListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragment.setArguments(bundle);
        return listPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference listPreference = getListPreference();
            if (listPreference.getEntries() == null || listPreference.getEntryValues() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.mClickedDialogEntryIndex = listPreference.findIndexOfValue(listPreference.getValue());
            this.mEntries = listPreference.getEntries();
            this.mEntryValues = listPreference.getEntryValues();
            return;
        }
        this.mClickedDialogEntryIndex = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.mEntries = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.mEntryValues = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.mClickedDialogEntryIndex);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.mEntries);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.mEntryValues);
    }

    private ListPreference getListPreference() {
        return (ListPreference) getPreference();
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        builder.setSingleChoiceItems(this.mEntries, this.mClickedDialogEntryIndex, new DialogInterface.OnClickListener() {
            /* class androidx.preference.ListPreferenceDialogFragment.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ListPreferenceDialogFragment.this.mClickedDialogEntryIndex = i;
                ListPreferenceDialogFragment.this.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.PreferenceDialogFragment
    @Deprecated
    public void onDialogClosed(boolean z) {
        int i;
        ListPreference listPreference = getListPreference();
        if (z && (i = this.mClickedDialogEntryIndex) >= 0) {
            String charSequence = this.mEntryValues[i].toString();
            if (listPreference.callChangeListener(charSequence)) {
                listPreference.setValue(charSequence);
            }
        }
    }
}
