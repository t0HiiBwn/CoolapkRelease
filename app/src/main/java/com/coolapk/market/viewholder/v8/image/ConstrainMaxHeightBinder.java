package com.coolapk.market.viewholder.v8.image;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/ConstrainMaxHeightBinder;", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "()V", "fullSizeBinder", "maxHeight", "", "calculate", "", "maxWidth", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NinePicBinders.kt */
public final class ConstrainMaxHeightBinder extends ImageBinder {
    private static final ConstrainMaxHeightBinder CONSTRAIN_MAX_HEIGHT_BINDER = new ConstrainMaxHeightBinder();
    public static final Companion Companion = new Companion(null);
    private final ImageBinder fullSizeBinder = NinePicBindersKt.getFULL_SIZE_SINGLE_BINDER();
    private int maxHeight;

    private ConstrainMaxHeightBinder() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/ConstrainMaxHeightBinder$Companion;", "", "()V", "CONSTRAIN_MAX_HEIGHT_BINDER", "Lcom/coolapk/market/viewholder/v8/image/ConstrainMaxHeightBinder;", "newInstance", "height", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NinePicBinders.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConstrainMaxHeightBinder newInstance(int i) {
            ConstrainMaxHeightBinder constrainMaxHeightBinder = ConstrainMaxHeightBinder.CONSTRAIN_MAX_HEIGHT_BINDER;
            constrainMaxHeightBinder.maxHeight = i;
            return constrainMaxHeightBinder;
        }
    }

    @Override // com.coolapk.market.viewholder.v8.image.ImageBinder
    public void calculate(float f) {
        this.fullSizeBinder.reset();
        this.fullSizeBinder.setup(getImagePreArgs());
        this.fullSizeBinder.calculate(f);
        int i = this.maxHeight;
        if (i <= 0 || ((float) i) >= this.fullSizeBinder.getOutContainerHeight()) {
            setOutContainerHeight(this.fullSizeBinder.getOutContainerHeight());
            return;
        }
        ImageArgs imageArgs = getImagePreArgs().get(0);
        Intrinsics.checkNotNullExpressionValue(imageArgs, "imagePreArgs[0]");
        ImageArgs imageArgs2 = imageArgs;
        imageArgs2.setOutWidth((imageArgs2.getOutWidth() / imageArgs2.getOutHeight()) * ((float) this.maxHeight));
        imageArgs2.setOutHeight((float) this.maxHeight);
        setOutContainerHeight(imageArgs2.getOutHeight());
    }
}
