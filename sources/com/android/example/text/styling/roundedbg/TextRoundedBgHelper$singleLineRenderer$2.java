package com.android.example.text.styling.roundedbg;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/android/example/text/styling/roundedbg/SingleLineRenderer;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TextRoundedBgHelper.kt */
final class TextRoundedBgHelper$singleLineRenderer$2 extends Lambda implements Function0<SingleLineRenderer> {
    final /* synthetic */ Drawable $drawable;
    final /* synthetic */ int $verticalPadding;
    final /* synthetic */ TextRoundedBgHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextRoundedBgHelper$singleLineRenderer$2(TextRoundedBgHelper textRoundedBgHelper, int i, Drawable drawable) {
        super(0);
        this.this$0 = textRoundedBgHelper;
        this.$verticalPadding = i;
        this.$drawable = drawable;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SingleLineRenderer invoke() {
        return new SingleLineRenderer(this.this$0.getHorizontalPadding(), this.$verticalPadding, this.$drawable);
    }
}
