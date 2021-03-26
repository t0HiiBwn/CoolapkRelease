package com.coolapk.market.viewholder.v8.image;

import android.widget.TextView;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
final class NinePicViewPart$measureView$1 implements Runnable {
    final /* synthetic */ MaxWidthFrameLayout $frameView;
    final /* synthetic */ List $preArgs;
    final /* synthetic */ NinePicViewPart this$0;

    NinePicViewPart$measureView$1(NinePicViewPart ninePicViewPart, List list, MaxWidthFrameLayout maxWidthFrameLayout) {
        this.this$0 = ninePicViewPart;
        this.$preArgs = list;
        this.$frameView = maxWidthFrameLayout;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00a5: INVOKE  (r0v13 int) = (r0v11 java.util.List) type: INTERFACE call: java.util.List.size():int), (22270 char)] */
    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.detachAllChildView();
        for (ImageArgs imageArgs : this.$preArgs) {
            if (!imageArgs.canBeShow()) {
                break;
            }
            NinePicViewPart.ImageViewPart imageViewPart = this.this$0.getUnusedImageViewPart(this.$frameView);
            this.$frameView.addView(imageViewPart.getView());
            imageViewPart.bindToContent(imageArgs);
            this.this$0.currentImageViewPartList.add(imageViewPart);
        }
        this.this$0.currentImageArgs.clear();
        this.this$0.currentImageArgs.addAll(this.$preArgs);
        this.this$0.handler.checkGif();
        List list = this.this$0.bindList;
        if (list == null) {
            list = Collections.emptyList();
        }
        int min = Math.min(this.this$0.getMaxShowCount(), this.this$0.getInternalMaxShowCount());
        if (list.size() > min && min > 0) {
            if (min >= 9 || list.size() < 9) {
                TextView textView = this.this$0.getImageCountView();
                StringBuilder sb = new StringBuilder();
                sb.append(list.size());
                sb.append((char) 22270);
                textView.setText(sb.toString());
            } else {
                this.this$0.getImageCountView().setText("9+");
            }
            this.$frameView.addView(this.this$0.getImageCountView());
        }
    }
}
