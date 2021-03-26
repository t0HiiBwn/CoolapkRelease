package com.coolapk.market.view.feed.reply;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.util.PhotoUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feed/reply/PictureDetailFragment$SinglePictureFeedFragment$onOptionsItemSelected$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Ljava/io/File;", "onNext", "", "file", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PictureDetailFragment.kt */
public final class PictureDetailFragment$SinglePictureFeedFragment$onOptionsItemSelected$1 extends EmptySubscriber<File> {
    PictureDetailFragment$SinglePictureFeedFragment$onOptionsItemSelected$1() {
    }

    public void onNext(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        super.onNext((PictureDetailFragment$SinglePictureFeedFragment$onOptionsItemSelected$1) file);
        PhotoUtils.setWallpaper(AppHolder.getCurrentActivity(), file.getAbsolutePath());
    }
}
