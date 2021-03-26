package com.coolapk.market.view.feedv8;

import android.text.TextUtils;
import android.util.Pair;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.view.feedv8.BaseFeedContentHolder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, d2 = {"com/coolapk/market/view/feedv8/BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$2", "Lrx/functions/Action1;", "Landroid/util/Pair;", "", "call", "", "pairs", "findIndexForCompressUrl", "", "comp", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
public final class BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$2 implements Action1<Pair<String, String>> {
    final /* synthetic */ BaseFeedContentHolder$prepareMultiFeed$5 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$2(BaseFeedContentHolder$prepareMultiFeed$5 baseFeedContentHolder$prepareMultiFeed$5) {
        this.this$0 = baseFeedContentHolder$prepareMultiFeed$5;
    }

    public void call(Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "pairs");
        List<ImageUrl> imageUriList = this.this$0.this$0.getMultiPart().imageUriList();
        Object obj = pair.first;
        Intrinsics.checkNotNullExpressionValue(obj, "pairs.first");
        int findIndexForCompressUrl = findIndexForCompressUrl((String) obj);
        if (findIndexForCompressUrl >= 0) {
            ImageUrl imageUrl = imageUriList.get(findIndexForCompressUrl);
            Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
            imageUriList.set(findIndexForCompressUrl, ImageUrl.create(imageUrl.getSourceUrl(), (String) pair.second));
            if (findIndexForCompressUrl < imageUriList.size() - 1) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.getDefault(), "上传图片(%d/%d)", Arrays.copyOf(new Object[]{Integer.valueOf(findIndexForCompressUrl + 2), Integer.valueOf(imageUriList.size())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                this.this$0.$dialog.setMessage(format);
                BaseFeedContentHolder.PostListener postListener = this.this$0.this$0.listener;
                if (postListener != null) {
                    postListener.onNewMessage(format);
                }
            }
        }
    }

    private final int findIndexForCompressUrl(String str) {
        List<ImageUrl> imageUriList = this.this$0.this$0.getMultiPart().imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "imageUrls");
        int size = imageUriList.size();
        for (int i = 0; i < size; i++) {
            ImageUrl imageUrl = imageUriList.get(i);
            Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
            if (TextUtils.equals(imageUrl.getCompressedUrl(), str)) {
                return i;
            }
        }
        return -1;
    }
}
