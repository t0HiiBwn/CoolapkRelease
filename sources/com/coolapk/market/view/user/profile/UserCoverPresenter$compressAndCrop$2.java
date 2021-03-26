package com.coolapk.market.view.user.profile;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.CoolFileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/user/profile/UserCoverPresenter$compressAndCrop$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/ImageUrl;", "onNext", "", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserCoverPresenter.kt */
public final class UserCoverPresenter$compressAndCrop$2 extends EmptySubscriber<ImageUrl> {
    final /* synthetic */ String $tempFilePath;
    final /* synthetic */ UserCoverPresenter this$0;

    UserCoverPresenter$compressAndCrop$2(UserCoverPresenter userCoverPresenter, String str) {
        this.this$0 = userCoverPresenter;
        this.$tempFilePath = str;
    }

    public void onNext(ImageUrl imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "t");
        super.onNext((UserCoverPresenter$compressAndCrop$2) imageUrl);
        this.this$0.cropOutFile = new File(this.$tempFilePath);
        String unwrap = CoolFileUtils.unwrap(imageUrl.getCompressedUrl());
        Intrinsics.checkNotNullExpressionValue(unwrap, "CoolFileUtils.unwrap(t.compressedUrl)");
        File file = this.this$0.cropOutFile;
        Intrinsics.checkNotNull(file);
        ActionManagerCompat.startUCropActivity(this.this$0.activity, unwrap, file, 1.0f, 1080, 1080, this.this$0.fragment);
    }
}
