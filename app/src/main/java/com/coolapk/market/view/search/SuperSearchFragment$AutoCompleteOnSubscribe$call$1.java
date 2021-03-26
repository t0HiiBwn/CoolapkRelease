package com.coolapk.market.view.search;

import android.widget.Filter;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.view.search.SuperSearchFragment;
import kotlin.Metadata;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\t"}, d2 = {"com/coolapk/market/view/search/SuperSearchFragment$AutoCompleteOnSubscribe$call$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "", "publishResults", "", "results", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
public final class SuperSearchFragment$AutoCompleteOnSubscribe$call$1 extends Filter {
    final /* synthetic */ Subscriber $subscriber;
    final /* synthetic */ SuperSearchFragment.AutoCompleteOnSubscribe this$0;

    SuperSearchFragment$AutoCompleteOnSubscribe$call$1(SuperSearchFragment.AutoCompleteOnSubscribe autoCompleteOnSubscribe, Subscriber subscriber) {
        this.this$0 = autoCompleteOnSubscribe;
        this.$subscriber = subscriber;
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (charSequence != null) {
            this.$subscriber.onNext(charSequence.toString());
            filterResults.values = SuperSearchFragment.this.getDataList();
            filterResults.count = CollectionUtils.safeSize(SuperSearchFragment.this.getDataList());
        } else {
            this.$subscriber.onNext(null);
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        if (charSequence == null) {
            SuperSearchFragment.this.clearData();
        }
    }
}
