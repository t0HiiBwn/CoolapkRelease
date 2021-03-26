package com.coolapk.market.view.feed.reply;

import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.util.PhotoUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: PictureDetailFragment.kt */
final class PictureDetailFragment$onPopulateSingleImg$3 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ PictureDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PictureDetailFragment$onPopulateSingleImg$3(PictureDetailFragment pictureDetailFragment) {
        super(1);
        this.this$0 = pictureDetailFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        PhotoUtils.saveImageObservable(this.this$0.getFeed().getPic(), true).subscribe((Subscriber<? super File>) new EmptySubscriber<File>() {
            /* class com.coolapk.market.view.feed.reply.PictureDetailFragment$onPopulateSingleImg$3.AnonymousClass1 */

            public void onNext(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                super.onNext((AnonymousClass1) file);
                PhotoUtils.setWallpaper(AppHolder.getCurrentActivity(), file.getAbsolutePath());
            }
        });
    }
}
