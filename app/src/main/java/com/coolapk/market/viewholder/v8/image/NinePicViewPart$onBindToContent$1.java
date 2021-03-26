package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002R\u001a\u0010\u0004\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"com/coolapk/market/viewholder/v8/image/NinePicViewPart$onBindToContent$1", "Lkotlin/Function1;", "", "", "lastWidth", "getLastWidth", "()I", "setLastWidth", "(I)V", "invoke", "newWidth", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
public final class NinePicViewPart$onBindToContent$1 implements Function1<Integer, Unit> {
    private int lastWidth = -1;
    final /* synthetic */ NinePicViewPart this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NinePicViewPart$onBindToContent$1(NinePicViewPart ninePicViewPart) {
        this.this$0 = ninePicViewPart;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final int getLastWidth() {
        return this.lastWidth;
    }

    public final void setLastWidth(int i) {
        this.lastWidth = i;
    }

    public void invoke(int i) {
        if (this.lastWidth != i) {
            this.this$0.measureView(i);
            this.lastWidth = i;
        }
    }
}
