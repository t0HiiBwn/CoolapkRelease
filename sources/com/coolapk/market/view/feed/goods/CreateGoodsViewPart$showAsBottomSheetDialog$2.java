package com.coolapk.market.view.feed.goods;

import android.net.Uri;
import android.view.View;
import com.coolapk.market.databinding.CreateGoodsBinding;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.RxUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: CreateGoodsViewPart.kt */
final class CreateGoodsViewPart$showAsBottomSheetDialog$2 implements View.OnClickListener {
    final /* synthetic */ CreateGoodsViewPart this$0;

    CreateGoodsViewPart$showAsBottomSheetDialog$2(CreateGoodsViewPart createGoodsViewPart) {
        this.this$0 = createGoodsViewPart;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List<String> list;
        if (((CreateGoodsBinding) this.this$0.getBinding()).getImage() != null) {
            ImageUrl image = ((CreateGoodsBinding) this.this$0.getBinding()).getImage();
            Intrinsics.checkNotNull(image);
            Intrinsics.checkNotNullExpressionValue(image, "binding.image!!");
            String sourceUrl = image.getSourceUrl();
            Intrinsics.checkNotNullExpressionValue(sourceUrl, "binding.image!!.sourceUrl");
            list = CollectionsKt.listOf(sourceUrl);
        } else {
            list = CollectionsKt.emptyList();
        }
        ActionManagerCompat.INSTANCE.startPhotoPickerActivityWithCallback(this.this$0.getContext(), 1, list, new Function1<List<? extends String>, Unit>(this) {
            /* class com.coolapk.market.view.feed.goods.CreateGoodsViewPart$showAsBottomSheetDialog$2.AnonymousClass1 */
            final /* synthetic */ CreateGoodsViewPart$showAsBottomSheetDialog$2 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke((List<String>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(List<String> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                String str = (String) CollectionsKt.firstOrNull((List<? extends Object>) list);
                if (str != null) {
                    BitmapUtil.compressImage(this.this$0.this$0.getContext(), Uri.fromFile(new File(str)).toString(), 0).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new CreateGoodsViewPart$showAsBottomSheetDialog$2$1$$special$$inlined$let$lambda$1(this));
                }
            }
        });
    }
}
