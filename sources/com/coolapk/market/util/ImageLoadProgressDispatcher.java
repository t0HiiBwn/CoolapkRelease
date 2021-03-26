package com.coolapk.market.util;

import com.coolapk.market.event.ImageLoadEvent;
import com.coolapk.market.imageloader.GlideProgressHelper;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/util/ImageLoadProgressDispatcher;", "", "()V", "hashMap", "", "", "onProgress", "", "event", "Lcom/coolapk/market/event/ImageLoadEvent;", "printData", "put", "url", "view", "Lcom/coolapk/market/widget/view/ImageLoadProgressBar;", "remove", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageLoadProgressDispatcher.kt */
public final class ImageLoadProgressDispatcher {
    public static final ImageLoadProgressDispatcher INSTANCE;
    private static final Map<String, Object> hashMap = new LinkedHashMap();

    static {
        ImageLoadProgressDispatcher imageLoadProgressDispatcher = new ImageLoadProgressDispatcher();
        INSTANCE = imageLoadProgressDispatcher;
        EventBus.getDefault().register(imageLoadProgressDispatcher);
    }

    private ImageLoadProgressDispatcher() {
    }

    public final void put(String str, ImageLoadProgressBar imageLoadProgressBar) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(imageLoadProgressBar, "view");
        Map<String, Object> map = hashMap;
        Object obj = map.get(str);
        if (obj instanceof ImageLoadProgressBar) {
            map.put(str, CollectionsKt.mutableListOf((ImageLoadProgressBar) obj, imageLoadProgressBar));
        } else if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(imageLoadProgressBar);
        } else {
            map.put(str, imageLoadProgressBar);
        }
        GlideProgressHelper.expect(str);
    }

    public final void remove(String str, ImageLoadProgressBar imageLoadProgressBar) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(imageLoadProgressBar, "view");
        Map<String, Object> map = hashMap;
        Object obj = map.get(str);
        if (Intrinsics.areEqual(obj, imageLoadProgressBar)) {
            map.remove(str);
        } else if (obj instanceof ArrayList) {
            ((ArrayList) obj).remove(imageLoadProgressBar);
        }
        GlideProgressHelper.forget(str);
    }

    public final void printData() {
        LogUtils.d("remain data in " + hashMap, new Object[0]);
    }

    @Subscribe
    public final void onProgress(ImageLoadEvent imageLoadEvent) {
        Intrinsics.checkNotNullParameter(imageLoadEvent, "event");
        Object obj = hashMap.get(imageLoadEvent.getUrl());
        if (obj instanceof ImageLoadProgressBar) {
            ((ImageLoadProgressBar) obj).onProgress(imageLoadEvent);
        } else if (obj instanceof ArrayList) {
            for (ImageLoadProgressBar imageLoadProgressBar : (ArrayList) obj) {
                imageLoadProgressBar.onProgress(imageLoadEvent);
            }
        }
    }
}
