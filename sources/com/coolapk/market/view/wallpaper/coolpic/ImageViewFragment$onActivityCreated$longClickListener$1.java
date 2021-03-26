package com.coolapk.market.view.wallpaper.coolpic;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.photo.PhotoViewUrl;
import com.coolapk.market.view.photo.SaveImageDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ImageViewFragment.kt */
final class ImageViewFragment$onActivityCreated$longClickListener$1 implements View.OnLongClickListener {
    final /* synthetic */ ImageViewFragment this$0;

    ImageViewFragment$onActivityCreated$longClickListener$1(ImageViewFragment imageViewFragment) {
        this.this$0 = imageViewFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        SaveImageDialog.Companion companion = SaveImageDialog.Companion;
        List<PhotoViewUrl> access$getImageUrls$p = ImageViewFragment.access$getImageUrls$p(this.this$0);
        int i = this.this$0.position;
        Feed feed = this.this$0.feed;
        Intrinsics.checkNotNull(feed);
        SaveImageDialog newInstance = companion.newInstance(access$getImageUrls$p, i, feed);
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        newInstance.show(childFragmentManager, (String) null);
        return true;
    }
}
