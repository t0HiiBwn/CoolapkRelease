package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

final class ExpandButton extends Preference {
    private long mId;

    ExpandButton(Context context, List<Preference> list, long j) {
        super(context);
        initLayout();
        setSummary(list);
        this.mId = j + 1000000;
    }

    private void initLayout() {
        setLayoutResource(R.layout.expand_button);
        setIcon(R.drawable.ic_arrow_down_24dp);
        setTitle(R.string.expand_button_title);
        setOrder(999);
    }

    private void setSummary(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence charSequence = null;
        for (Preference preference : list) {
            CharSequence title = preference.getTitle();
            boolean z = preference instanceof PreferenceGroup;
            if (z && !TextUtils.isEmpty(title)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.getParent())) {
                if (z) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(title)) {
                if (charSequence == null) {
                    charSequence = title;
                } else {
                    charSequence = getContext().getString(R.string.summary_collapsed_preference_list, charSequence, title);
                }
            }
        }
        setSummary(charSequence);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.setDividerAllowedAbove(false);
    }

    @Override // androidx.preference.Preference
    long getId() {
        return this.mId;
    }
}
