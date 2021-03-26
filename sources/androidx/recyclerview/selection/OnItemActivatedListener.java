package androidx.recyclerview.selection;

import android.view.MotionEvent;
import androidx.recyclerview.selection.ItemDetailsLookup;

public interface OnItemActivatedListener<K> {
    boolean onItemActivated(ItemDetailsLookup.ItemDetails<K> itemDetails, MotionEvent motionEvent);
}
