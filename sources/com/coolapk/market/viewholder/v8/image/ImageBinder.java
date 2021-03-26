package com.coolapk.market.viewholder.v8.image;

import com.coolapk.market.util.DisplayUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH&J\u0006\u0010\u0012\u001a\u00020\u0010J\u0014\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "", "()V", "imagePreArgs", "Ljava/util/ArrayList;", "Lcom/coolapk/market/viewholder/v8/image/ImageArgs;", "Lkotlin/collections/ArrayList;", "getImagePreArgs", "()Ljava/util/ArrayList;", "outContainerHeight", "", "getOutContainerHeight", "()F", "setOutContainerHeight", "(F)V", "calculate", "", "maxWidth", "reset", "setup", "preArgs", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BinderHelper.kt */
public abstract class ImageBinder {
    public static final Companion Companion = new Companion(null);
    private static final float DIVIDER = ((float) DisplayUtils.dp2px(null, 3.0f));
    private final ArrayList<ImageArgs> imagePreArgs = new ArrayList<>();
    private float outContainerHeight;

    public abstract void calculate(float f);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/ImageBinder$Companion;", "", "()V", "DIVIDER", "", "getDIVIDER", "()F", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BinderHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float getDIVIDER() {
            return ImageBinder.DIVIDER;
        }
    }

    public final ArrayList<ImageArgs> getImagePreArgs() {
        return this.imagePreArgs;
    }

    public final float getOutContainerHeight() {
        return this.outContainerHeight;
    }

    public final void setOutContainerHeight(float f) {
        this.outContainerHeight = f;
    }

    public final void reset() {
        this.outContainerHeight = 0.0f;
    }

    public final void setup(List<ImageArgs> list) {
        Intrinsics.checkNotNullParameter(list, "preArgs");
        this.imagePreArgs.clear();
        this.imagePreArgs.addAll(list);
    }
}
