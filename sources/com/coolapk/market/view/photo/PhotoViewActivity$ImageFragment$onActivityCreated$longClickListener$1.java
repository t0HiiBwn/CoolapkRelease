package com.coolapk.market.view.photo;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.view.photo.PhotoViewActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
final class PhotoViewActivity$ImageFragment$onActivityCreated$longClickListener$1 implements View.OnLongClickListener {
    final /* synthetic */ PhotoViewActivity.ImageFragment this$0;

    PhotoViewActivity$ImageFragment$onActivityCreated$longClickListener$1(PhotoViewActivity.ImageFragment imageFragment) {
        this.this$0 = imageFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        try {
            SaveImageDialog newInstance = SaveImageDialog.Companion.newInstance(PhotoViewActivity.ImageFragment.access$getImageUrls$p(this.this$0), this.this$0.position, this.this$0.feedType);
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentManager supportFragmentManager = requireActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
            newInstance.show(supportFragmentManager, "SaveImageDialog");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
