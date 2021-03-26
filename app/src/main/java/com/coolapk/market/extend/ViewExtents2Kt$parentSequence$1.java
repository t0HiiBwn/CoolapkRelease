package com.coolapk.market.extend;

import android.view.View;
import android.view.ViewParent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"com/coolapk/market/extend/ViewExtents2Kt$parentSequence$1", "Lkotlin/sequences/Sequence;", "Landroid/view/ViewParent;", "iterator", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtents2.kt */
public final class ViewExtents2Kt$parentSequence$1 implements Sequence<ViewParent> {
    final /* synthetic */ View $this_parentSequence;

    ViewExtents2Kt$parentSequence$1(View view) {
        this.$this_parentSequence = view;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<ViewParent> iterator() {
        return ViewExtents2Kt.iteratorParent(this.$this_parentSequence);
    }
}
