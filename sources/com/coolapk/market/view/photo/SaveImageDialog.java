package com.coolapk.market.view.photo;

import android.os.Bundle;
import com.bumptech.glide.load.model.GlideUrl;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FileDetail;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.PhotoUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0015H\u0002J\u0016\u0010\u0018\u001a\u00020\u00102\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00150\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\nX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/photo/SaveImageDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "feed", "Lcom/coolapk/market/model/Feed;", "feedType", "", "photoViewUrl", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "photoViewUrls", "", "position", "", "url", "urls", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "saveImage", "Lcom/bumptech/glide/load/model/GlideUrl;", "saveImageAndSetWallpaper", "saveImageAndShare", "saveImages", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SaveImageDialog.kt */
public final class SaveImageDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private Feed feed;
    private String feedType;
    private PhotoViewUrl photoViewUrl;
    private List<PhotoViewUrl> photoViewUrls;
    private int position;
    private String url;
    private List<String> urls;

    public static final /* synthetic */ PhotoViewUrl access$getPhotoViewUrl$p(SaveImageDialog saveImageDialog) {
        PhotoViewUrl photoViewUrl2 = saveImageDialog.photoViewUrl;
        if (photoViewUrl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoViewUrl");
        }
        return photoViewUrl2;
    }

    public static final /* synthetic */ List access$getPhotoViewUrls$p(SaveImageDialog saveImageDialog) {
        List<PhotoViewUrl> list = saveImageDialog.photoViewUrls;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoViewUrls");
        }
        return list;
    }

    public static final /* synthetic */ String access$getUrl$p(SaveImageDialog saveImageDialog) {
        String str = saveImageDialog.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        }
        return str;
    }

    public static final /* synthetic */ List access$getUrls$p(SaveImageDialog saveImageDialog) {
        List<String> list = saveImageDialog.urls;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("urls");
        }
        return list;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ$\u0010\u0003\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u0003\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/photo/SaveImageDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/photo/SaveImageDialog;", "photo", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "feedType", "", "fileDetail", "Lcom/coolapk/market/model/FileDetail;", "photos", "", "position", "", "feed", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SaveImageDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaveImageDialog newInstance(PhotoViewUrl photoViewUrl, String str, FileDetail fileDetail) {
            Intrinsics.checkNotNullParameter(photoViewUrl, "photo");
            Intrinsics.checkNotNullParameter(fileDetail, "fileDetail");
            Bundle bundle = new Bundle();
            bundle.putParcelable("photo", photoViewUrl);
            bundle.putString("feedType", str);
            bundle.putParcelable("fileDetail", fileDetail);
            SaveImageDialog saveImageDialog = new SaveImageDialog();
            saveImageDialog.setArguments(bundle);
            return saveImageDialog;
        }

        public final SaveImageDialog newInstance(List<PhotoViewUrl> list, int i, Feed feed) {
            Intrinsics.checkNotNullParameter(list, "photos");
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            if (!(list instanceof ArrayList)) {
                list = null;
            }
            bundle.putParcelableArrayList("photos", (ArrayList) list);
            bundle.putParcelable("feed", feed);
            SaveImageDialog saveImageDialog = new SaveImageDialog();
            saveImageDialog.setArguments(bundle);
            return saveImageDialog;
        }

        public final SaveImageDialog newInstance(List<PhotoViewUrl> list, int i, String str) {
            Intrinsics.checkNotNullParameter(list, "photos");
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            if (!(list instanceof ArrayList)) {
                list = null;
            }
            bundle.putParcelableArrayList("photos", (ArrayList) list);
            bundle.putString("feedType", str);
            SaveImageDialog saveImageDialog = new SaveImageDialog();
            saveImageDialog.setArguments(bundle);
            return saveImageDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.position = requireArguments().getInt("position");
        this.feed = (Feed) requireArguments().getParcelable("feed");
        ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("photos");
        Intrinsics.checkNotNull(parcelableArrayList);
        ArrayList arrayList = parcelableArrayList;
        this.photoViewUrls = arrayList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoViewUrls");
        }
        PhotoViewUrl photoViewUrl2 = (PhotoViewUrl) arrayList.get(this.position);
        this.photoViewUrl = photoViewUrl2;
        if (photoViewUrl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoViewUrl");
        }
        this.url = photoViewUrl2.getSource();
        List<PhotoViewUrl> list = this.photoViewUrls;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoViewUrls");
        }
        List<PhotoViewUrl> list2 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().getSource());
        }
        this.urls = arrayList2;
        Feed feed2 = this.feed;
        this.feedType = feed2 != null ? feed2 != null ? feed2.getFeedType() : null : requireArguments().getString("feedType");
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        updateDataList(new SaveImageDialog$onActivityCreated$1(this));
    }

    /* access modifiers changed from: private */
    public final void saveImage(GlideUrl glideUrl) {
        PhotoUtils.saveImageObservable(glideUrl, false).subscribe((Subscriber<? super File>) new EmptySubscriber());
    }

    /* access modifiers changed from: private */
    public final void saveImages(List<? extends GlideUrl> list) {
        PhotoUtils.saveImages(list, null, false).subscribe((Subscriber<? super File>) new EmptySubscriber());
    }

    /* access modifiers changed from: private */
    public final void saveImageAndSetWallpaper(String str) {
        PhotoUtils.saveImageObservable(str, true).subscribe((Subscriber<? super File>) new SaveImageDialog$saveImageAndSetWallpaper$1());
    }

    /* access modifiers changed from: private */
    public final void saveImageAndShare(GlideUrl glideUrl) {
        PhotoUtils.saveImageObservable(glideUrl, BitmapUtil.generateFileOutputPath(getActivity(), glideUrl.toStringUrl()), true).subscribe((Subscriber<? super File>) new SaveImageDialog$saveImageAndShare$1());
    }
}
