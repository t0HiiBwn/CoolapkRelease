package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0002\b\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0010¢\u0006\u0002\b\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feedv8/CoolPicContentHolder;", "Lcom/coolapk/market/view/feedv8/NormalFeedContentHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "shouldSubmitAfterPickTopic", "", "checkSubmittable", "checkSubmittable$presentation_coolapkAppRelease", "onCreateContentView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "onPickImageListChange", "", "pathList", "", "", "onSubmitToButtonClick", "prepareMultiFeed", "Lrx/Observable;", "Lcom/coolapk/market/model/FeedMultiPart;", "prepareMultiFeed$presentation_coolapkAppRelease", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicContentHolder.kt */
public final class CoolPicContentHolder extends NormalFeedContentHolder {
    private boolean shouldSubmitAfterPickTopic;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolPicContentHolder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.coolapk.market.view.feedv8.NormalFeedContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        String str;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getMultiPart().imageUriList());
        getMultiPart().imageUriList().clear();
        View onCreateContentView$presentation_coolapkAppRelease = super.onCreateContentView$presentation_coolapkAppRelease(layoutInflater);
        FeedMultiPart multiPart = getMultiPart();
        if (multiPart.compressFlag() != 1) {
            FeedMultiPart build = FeedMultiPart.builder(multiPart).compressFlag(1).build();
            Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder(mu…                 .build()");
            updateMultiPart$presentation_coolapkAppRelease(build);
        }
        getAdapter$presentation_coolapkAppRelease().setCompressFlag(1);
        ArrayList<ImageUrl> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ImageUrl imageUrl : arrayList2) {
            arrayList3.add(Uri.parse(imageUrl.getSourceUrl()));
        }
        ArrayList<Uri> arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        for (Uri uri : arrayList4) {
            Intrinsics.checkNotNullExpressionValue(uri, "it");
            if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                str = uri.getPath();
                if (str == null) {
                    str = "";
                }
            } else {
                str = uri.toString();
            }
            arrayList5.add(str);
        }
        onPickImageListChange(arrayList5);
        return onCreateContentView$presentation_coolapkAppRelease;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0066, code lost:
        if (r3 >= 720) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0013 A[SYNTHETIC] */
    @Override // com.coolapk.market.view.feedv8.NormalFeedContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickImageListChange(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "pathList");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            boolean z = false;
            if (StringsKt.startsWith$default((String) t2, "file", false, 2, (Object) null) || StringsKt.startsWith$default((String) t2, "/", false, 2, (Object) null)) {
                Uri parse = Uri.parse(CoolFileUtils.wrap(t2));
                Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(CoolFileUtils.wrap(it))");
                Pair<Integer, Integer> bitmapSize = KotlinExtendKt.getBitmapSize(parse, getActivity());
                int intValue = bitmapSize.component1().intValue();
                int intValue2 = bitmapSize.component2().intValue();
                if (intValue >= 720) {
                }
                if (!z) {
                    arrayList.add(t);
                }
            }
            z = true;
            if (!z) {
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() != list.size()) {
            Toast.show$default(getActivity(), "已移除720P以下图片", 0, false, 12, null);
        }
        super.onPickImageListChange(arrayList2);
    }

    @Override // com.coolapk.market.view.feedv8.NormalFeedContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public boolean checkSubmittable$presentation_coolapkAppRelease() {
        if (getAdapter$presentation_coolapkAppRelease().isEmpty()) {
            return false;
        }
        return super.checkSubmittable$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.NormalFeedContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public Observable<FeedMultiPart> prepareMultiFeed$presentation_coolapkAppRelease() {
        FeedMultiPart multiPart = getMultiPart();
        if (multiPart.compressFlag() != 1) {
            FeedMultiPart build = multiPart.newBuilder().compressFlag(1).build();
            Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …                 .build()");
            updateMultiPart$presentation_coolapkAppRelease(build);
        }
        return super.prepareMultiFeed$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.NormalFeedContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitToButtonClick() {
        super.onSubmitToButtonClick();
        ActionManager.startPickPicCategoryFragment(getActivity());
    }
}
