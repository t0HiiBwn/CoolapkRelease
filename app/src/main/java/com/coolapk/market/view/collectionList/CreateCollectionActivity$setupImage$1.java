package com.coolapk.market.view.collectionList;

import android.util.Pair;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/collectionList/CreateCollectionActivity$setupImage$1", "Lrx/Subscriber;", "Landroid/util/Pair;", "", "onCompleted", "", "onError", "e", "", "onNext", "pair", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CreateCollectionActivity.kt */
public final class CreateCollectionActivity$setupImage$1 extends Subscriber<Pair<String, String>> {
    final /* synthetic */ CreateCollectionActivity this$0;

    @Override // rx.Observer
    public void onCompleted() {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CreateCollectionActivity$setupImage$1(CreateCollectionActivity createCollectionActivity) {
        this.this$0 = createCollectionActivity;
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getActivity(), th);
        LinearLayout linearLayout = CreateCollectionActivity.access$getBinding$p(this.this$0).picAddPh;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.picAddPh");
        linearLayout.setVisibility(8);
        ImageView imageView = CreateCollectionActivity.access$getBinding$p(this.this$0).picCloseView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.picCloseView");
        imageView.setVisibility(0);
    }

    public void onNext(Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        this.this$0.isLoaded = true;
        ImageView imageView = CreateCollectionActivity.access$getBinding$p(this.this$0).picCloseView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.picCloseView");
        imageView.setVisibility(0);
        LinearLayout linearLayout = CreateCollectionActivity.access$getBinding$p(this.this$0).picAddPh;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.picAddPh");
        linearLayout.setVisibility(8);
        if (pair.second != null) {
            Object obj = pair.second;
            Intrinsics.checkNotNullExpressionValue(obj, "pair.second");
            if (StringsKt.startsWith$default((String) obj, "http", false, 2, (Object) null)) {
                CreateCollectionActivity createCollectionActivity = this.this$0;
                Object obj2 = pair.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "pair.second");
                createCollectionActivity.coverUrl = (String) obj2;
                return;
            }
        }
        Toast.show$default(this.this$0.getActivity(), "图片上传失败，请重试", 0, false, 12, null);
    }
}
