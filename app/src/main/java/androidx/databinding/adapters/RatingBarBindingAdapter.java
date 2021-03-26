package androidx.databinding.adapters;

import android.widget.RatingBar;
import androidx.databinding.InverseBindingListener;

public class RatingBarBindingAdapter {
    public static void setRating(RatingBar ratingBar, float f) {
        if (ratingBar.getRating() != f) {
            ratingBar.setRating(f);
        }
    }

    public static void setListeners(RatingBar ratingBar, final RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            ratingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
        } else {
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                /* class androidx.databinding.adapters.RatingBarBindingAdapter.AnonymousClass1 */

                @Override // android.widget.RatingBar.OnRatingBarChangeListener
                public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                    RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = onRatingBarChangeListener;
                    if (onRatingBarChangeListener != null) {
                        onRatingBarChangeListener.onRatingChanged(ratingBar, f, z);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
