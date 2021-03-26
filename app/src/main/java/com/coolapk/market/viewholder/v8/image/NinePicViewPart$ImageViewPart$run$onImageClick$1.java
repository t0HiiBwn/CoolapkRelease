package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "position", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
final /* synthetic */ class NinePicViewPart$ImageViewPart$run$onImageClick$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    NinePicViewPart$ImageViewPart$run$onImageClick$1(NinePicViewPart ninePicViewPart) {
        super(1, ninePicViewPart, NinePicViewPart.class, "onImageClick", "onImageClick(I)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((NinePicViewPart) this.receiver).onImageClick(i);
    }
}
