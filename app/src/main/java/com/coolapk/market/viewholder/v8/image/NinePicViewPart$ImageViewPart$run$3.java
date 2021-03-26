package com.coolapk.market.viewholder.v8.image;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.ItemFeedImageBinding;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "drawable", "Landroid/graphics/drawable/Drawable;", "<anonymous parameter 2>", "Landroid/view/View;", "<anonymous parameter 3>", "", "<anonymous parameter 4>", "", "onLoadComplete"}, k = 3, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
final class NinePicViewPart$ImageViewPart$run$3 implements OnImageLoadListener {
    final /* synthetic */ List $bindList;
    final /* synthetic */ ArrayList $currentDisplayList;
    final /* synthetic */ NinePicViewPart $parentViewPart;
    final /* synthetic */ String $source;
    final /* synthetic */ NinePicViewPart.ImageViewPart this$0;

    NinePicViewPart$ImageViewPart$run$3(NinePicViewPart.ImageViewPart imageViewPart, String str, ArrayList arrayList, List list, NinePicViewPart ninePicViewPart) {
        this.this$0 = imageViewPart;
        this.$source = str;
        this.$currentDisplayList = arrayList;
        this.$bindList = list;
        this.$parentViewPart = ninePicViewPart;
    }

    @Override // com.coolapk.market.app.OnImageLoadListener
    public final void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th) {
        if (drawable != null) {
            AppPictureSizeManager.getInstance().put(this.$source, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.$currentDisplayList.clear();
            ((ItemFeedImageBinding) this.this$0.getBinding()).getRoot().post(new Runnable(this) {
                /* class com.coolapk.market.viewholder.v8.image.NinePicViewPart$ImageViewPart$run$3.AnonymousClass1 */
                final /* synthetic */ NinePicViewPart$ImageViewPart$run$3 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    List<String> list = this.this$0.$bindList;
                    if (list != null) {
                        this.this$0.$parentViewPart.onBindToContent(list);
                    }
                }
            });
        }
    }
}
