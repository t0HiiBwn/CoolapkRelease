package androidx.recyclerview.selection;

import android.view.MotionEvent;

public abstract class ItemDetailsLookup<K> {
    public abstract ItemDetails<K> getItemDetails(MotionEvent motionEvent);

    final boolean overItem(MotionEvent motionEvent) {
        return getItemPosition(motionEvent) != -1;
    }

    final boolean overItemWithSelectionKey(MotionEvent motionEvent) {
        return overItem(motionEvent) && hasSelectionKey(getItemDetails(motionEvent));
    }

    final boolean inItemDragRegion(MotionEvent motionEvent) {
        return overItem(motionEvent) && getItemDetails(motionEvent).inDragRegion(motionEvent);
    }

    final boolean inItemSelectRegion(MotionEvent motionEvent) {
        return overItem(motionEvent) && getItemDetails(motionEvent).inSelectionHotspot(motionEvent);
    }

    final int getItemPosition(MotionEvent motionEvent) {
        ItemDetails<K> itemDetails = getItemDetails(motionEvent);
        if (itemDetails != null) {
            return itemDetails.getPosition();
        }
        return -1;
    }

    private static boolean hasSelectionKey(ItemDetails<?> itemDetails) {
        return (itemDetails == null || itemDetails.getSelectionKey() == null) ? false : true;
    }

    private static boolean hasPosition(ItemDetails<?> itemDetails) {
        return (itemDetails == null || itemDetails.getPosition() == -1) ? false : true;
    }

    public static abstract class ItemDetails<K> {
        public abstract int getPosition();

        public abstract K getSelectionKey();

        public boolean inDragRegion(MotionEvent motionEvent) {
            return false;
        }

        public boolean inSelectionHotspot(MotionEvent motionEvent) {
            return false;
        }

        public boolean hasSelectionKey() {
            return getSelectionKey() != null;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ItemDetails) && isEqualTo((ItemDetails) obj);
        }

        private boolean isEqualTo(ItemDetails itemDetails) {
            boolean z;
            K selectionKey = getSelectionKey();
            if (selectionKey == null) {
                z = itemDetails.getSelectionKey() == null;
            } else {
                z = selectionKey.equals(itemDetails.getSelectionKey());
            }
            if (!z || getPosition() != itemDetails.getPosition()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return getPosition() >>> 8;
        }
    }
}
