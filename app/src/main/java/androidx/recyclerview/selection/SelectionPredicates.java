package androidx.recyclerview.selection;

import androidx.recyclerview.selection.SelectionTracker;

public final class SelectionPredicates {
    private SelectionPredicates() {
    }

    public static <K> SelectionTracker.SelectionPredicate<K> createSelectAnything() {
        return new SelectionTracker.SelectionPredicate<K>() {
            /* class androidx.recyclerview.selection.SelectionPredicates.AnonymousClass1 */

            @Override // androidx.recyclerview.selection.SelectionTracker.SelectionPredicate
            public boolean canSelectMultiple() {
                return true;
            }

            @Override // androidx.recyclerview.selection.SelectionTracker.SelectionPredicate
            public boolean canSetStateAtPosition(int i, boolean z) {
                return true;
            }

            @Override // androidx.recyclerview.selection.SelectionTracker.SelectionPredicate
            public boolean canSetStateForKey(K k, boolean z) {
                return true;
            }
        };
    }

    public static <K> SelectionTracker.SelectionPredicate<K> createSelectSingleAnything() {
        return new SelectionTracker.SelectionPredicate<K>() {
            /* class androidx.recyclerview.selection.SelectionPredicates.AnonymousClass2 */

            @Override // androidx.recyclerview.selection.SelectionTracker.SelectionPredicate
            public boolean canSelectMultiple() {
                return false;
            }

            @Override // androidx.recyclerview.selection.SelectionTracker.SelectionPredicate
            public boolean canSetStateAtPosition(int i, boolean z) {
                return true;
            }

            @Override // androidx.recyclerview.selection.SelectionTracker.SelectionPredicate
            public boolean canSetStateForKey(K k, boolean z) {
                return true;
            }
        };
    }
}
