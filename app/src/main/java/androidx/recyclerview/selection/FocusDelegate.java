package androidx.recyclerview.selection;

import androidx.recyclerview.selection.ItemDetailsLookup;

public abstract class FocusDelegate<K> {
    public abstract void clearFocus();

    public abstract void focusItem(ItemDetailsLookup.ItemDetails<K> itemDetails);

    public abstract int getFocusedPosition();

    public abstract boolean hasFocusedItem();

    static <K> FocusDelegate<K> dummy() {
        return new FocusDelegate<K>() {
            /* class androidx.recyclerview.selection.FocusDelegate.AnonymousClass1 */

            @Override // androidx.recyclerview.selection.FocusDelegate
            public void clearFocus() {
            }

            @Override // androidx.recyclerview.selection.FocusDelegate
            public void focusItem(ItemDetailsLookup.ItemDetails<K> itemDetails) {
            }

            @Override // androidx.recyclerview.selection.FocusDelegate
            public int getFocusedPosition() {
                return -1;
            }

            @Override // androidx.recyclerview.selection.FocusDelegate
            public boolean hasFocusedItem() {
                return false;
            }
        };
    }
}
