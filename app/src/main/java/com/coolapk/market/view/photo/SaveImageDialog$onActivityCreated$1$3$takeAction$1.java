package com.coolapk.market.view.photo;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: SaveImageDialog.kt */
final class SaveImageDialog$onActivityCreated$1$3$takeAction$1 implements Runnable {
    final /* synthetic */ SaveImageDialog$onActivityCreated$1.AnonymousClass3 this$0;

    SaveImageDialog$onActivityCreated$1$3$takeAction$1(SaveImageDialog$onActivityCreated$1.AnonymousClass3 r1) {
        this.this$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GlideUrl glideUrl;
        SaveImageDialog saveImageDialog = this.this$0.this$0.this$0;
        List<PhotoViewUrl> access$getPhotoViewUrls$p = SaveImageDialog.access$getPhotoViewUrls$p(this.this$0.this$0.this$0);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(access$getPhotoViewUrls$p, 10));
        for (PhotoViewUrl photoViewUrl : access$getPhotoViewUrls$p) {
            Integer needCoolapkHeader = photoViewUrl.getNeedCoolapkHeader();
            if (needCoolapkHeader != null && needCoolapkHeader.intValue() == 1) {
                LazyHeaders.Builder createGlideCoolApkHeader = KotlinExtendKt.createGlideCoolApkHeader();
                KotlinExtendKt.appendCoolApkCookies(createGlideCoolApkHeader);
                glideUrl = new GlideUrl(photoViewUrl.getSource(), createGlideCoolApkHeader.build());
            } else {
                glideUrl = new GlideUrl(photoViewUrl.getSource());
            }
            arrayList.add(glideUrl);
        }
        saveImageDialog.saveImages(arrayList);
    }
}
