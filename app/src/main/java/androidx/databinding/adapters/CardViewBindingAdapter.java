package androidx.databinding.adapters;

import androidx.cardview.widget.CardView;

public class CardViewBindingAdapter {
    public static void setContentPadding(CardView cardView, int i) {
        cardView.setContentPadding(i, i, i, i);
    }

    public static void setContentPaddingLeft(CardView cardView, int i) {
        cardView.setContentPadding(i, cardView.getContentPaddingTop(), cardView.getContentPaddingRight(), cardView.getContentPaddingBottom());
    }

    public static void setContentPaddingTop(CardView cardView, int i) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), i, cardView.getContentPaddingRight(), cardView.getContentPaddingBottom());
    }

    public static void setContentPaddingRight(CardView cardView, int i) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), cardView.getContentPaddingTop(), i, cardView.getContentPaddingBottom());
    }

    public static void setContentPaddingBottom(CardView cardView, int i) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), cardView.getContentPaddingTop(), cardView.getContentPaddingRight(), i);
    }
}
