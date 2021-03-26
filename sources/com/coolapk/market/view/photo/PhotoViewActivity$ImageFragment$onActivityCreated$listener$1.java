package com.coolapk.market.view.photo;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.view.photo.PhotoViewActivity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
final class PhotoViewActivity$ImageFragment$onActivityCreated$listener$1 implements View.OnClickListener {
    final /* synthetic */ PhotoViewActivity.ImageFragment this$0;

    PhotoViewActivity$ImageFragment$onActivityCreated$listener$1(PhotoViewActivity.ImageFragment imageFragment) {
        this.this$0 = imageFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (System.currentTimeMillis() - this.this$0.activityInitTime >= ((long) 800) && (this.this$0.allowExit) && this.this$0.getActivity() != null) {
            FragmentActivity activity = this.this$0.getActivity();
            if (!(activity instanceof PhotoViewActivity)) {
                activity = null;
            }
            PhotoViewActivity photoViewActivity = (PhotoViewActivity) activity;
            if (photoViewActivity != null) {
                PhotoViewActivity.access$getTransitionHelper$p(photoViewActivity).doFinishAnimation();
            }
        }
    }
}
