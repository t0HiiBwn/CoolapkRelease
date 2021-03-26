package com.coolapk.market.view.feedv8.util;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R*\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/feedv8/util/HandleFocusRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "focusTargetPosition", "getFocusTargetPosition", "()Ljava/lang/Integer;", "setFocusTargetPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "delaySetFocus", "", "onRequestFocusInDescendants", "", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HandleFocusRecyclerView.kt */
public final class HandleFocusRecyclerView extends RecyclerView {
    private Integer focusTargetPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandleFocusRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Integer getFocusTargetPosition() {
        return this.focusTargetPosition;
    }

    public final void setFocusTargetPosition(Integer num) {
        this.focusTargetPosition = num;
        if (num != null) {
            postDelayed(new HandleFocusRecyclerView$sam$java_lang_Runnable$0(new HandleFocusRecyclerView$focusTargetPosition$1(this)), 300);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        Integer num = this.focusTargetPosition;
        if (num == null || findViewHolderForAdapterPosition(num.intValue()) == null) {
            return super.onRequestFocusInDescendants(i, rect);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void delaySetFocus() {
        EditText editText;
        Integer num = this.focusTargetPosition;
        if (num != null) {
            int intValue = num.intValue();
            KeyEvent.Callback callback = null;
            setFocusTargetPosition(null);
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(intValue);
            KeyEvent.Callback callback2 = findViewHolderForAdapterPosition != null ? findViewHolderForAdapterPosition.itemView : null;
            if (callback2 instanceof ViewGroup) {
                callback = callback2;
            }
            ViewGroup viewGroup = (ViewGroup) callback;
            if (viewGroup != null && (editText = (EditText) UiUtils.findFirstChildViewByType(viewGroup, EditText.class)) != null) {
                editText.requestFocus();
                editText.setSelection(editText.getText().length());
            }
        }
    }
}
