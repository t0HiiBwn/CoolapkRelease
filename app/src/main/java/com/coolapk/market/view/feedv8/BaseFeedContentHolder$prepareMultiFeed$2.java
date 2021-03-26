package com.coolapk.market.view.feedv8;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.RxUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"com/coolapk/market/view/feedv8/BaseFeedContentHolder$prepareMultiFeed$2", "Lrx/functions/Func1;", "", "Lrx/Observable;", "call", "aBoolean", "(Ljava/lang/Boolean;)Lrx/Observable;", "isPackageScheme", "uri", "Landroid/net/Uri;", "uploadLogo", "packageName", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
public final class BaseFeedContentHolder$prepareMultiFeed$2 implements Func1<Boolean, Observable<Boolean>> {
    final /* synthetic */ BaseFeedContentHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseFeedContentHolder$prepareMultiFeed$2(BaseFeedContentHolder baseFeedContentHolder) {
        this.this$0 = baseFeedContentHolder;
    }

    public Observable<Boolean> call(Boolean bool) {
        Uri parse = Uri.parse(this.this$0.getMultiPart().extraPic());
        if (isPackageScheme(parse)) {
            Intrinsics.checkNotNullExpressionValue(parse, "logo");
            String schemeSpecificPart = parse.getSchemeSpecificPart();
            Intrinsics.checkNotNullExpressionValue(schemeSpecificPart, "packageName");
            return uploadLogo(schemeSpecificPart);
        }
        Observable<Boolean> just = Observable.just(true);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(true)");
        return just;
    }

    private final boolean isPackageScheme(Uri uri) {
        return uri != null && Intrinsics.areEqual("package", uri.getScheme());
    }

    private final Observable<Boolean> uploadLogo(String str) {
        Application application = AppHolder.getApplication();
        Bitmap iconBitmap = BitmapUtil.getIconBitmap(application, str);
        File file = new File(BitmapUtil.generateFileOutputPath(application, str));
        BitmapUtil.saveBitmapToFile(file, iconBitmap, true);
        Observable<R> map = DataManager.getInstance().uploadLogoImage(file).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).map(new BaseFeedContentHolder$prepareMultiFeed$2$uploadLogo$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…                        }");
        return map;
    }
}
