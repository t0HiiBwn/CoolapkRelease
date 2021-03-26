package com.android.example.text.styling.roundedbg;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/android/example/text/styling/roundedbg/MultiLineRenderer;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TextRoundedBgHelper.kt */
final class TextRoundedBgHelper$multiLineRenderer$2 extends Lambda implements Function0<MultiLineRenderer> {
    final /* synthetic */ Drawable $drawableLeft;
    final /* synthetic */ Drawable $drawableMid;
    final /* synthetic */ Drawable $drawableRight;
    final /* synthetic */ int $verticalPadding;
    final /* synthetic */ TextRoundedBgHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextRoundedBgHelper$multiLineRenderer$2(TextRoundedBgHelper textRoundedBgHelper, int i, Drawable drawable, Drawable drawable2, Drawable drawable3) {
        super(0);
        this.this$0 = textRoundedBgHelper;
        this.$verticalPadding = i;
        this.$drawableLeft = drawable;
        this.$drawableMid = drawable2;
        this.$drawableRight = drawable3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final MultiLineRenderer invoke() {
        return new MultiLineRenderer(this.this$0.getHorizontalPadding(), this.$verticalPadding, this.$drawableLeft, this.$drawableMid, this.$drawableRight);
    }
}
