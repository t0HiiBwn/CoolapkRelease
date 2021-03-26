package com.coolapk.market.view.node;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.view.ScalingImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\nH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"com/coolapk/market/view/node/NodeHelper$createCoverAdapter$1", "Landroidx/viewpager/widget/PagerAdapter;", "viewMap", "Landroid/util/SparseArray;", "Landroid/view/View;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "any", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "obj", "onImageClick", "index", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
public final class NodeHelper$createCoverAdapter$1 extends PagerAdapter {
    final /* synthetic */ Context $context;
    final /* synthetic */ List $picList;
    final /* synthetic */ Function1 $thumbnailProvider;
    private final SparseArray<View> viewMap = new SparseArray<>();

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return view == obj;
    }

    NodeHelper$createCoverAdapter$1(List list, Context context, Function1 function1) {
        this.$picList = list;
        this.$context = context;
        this.$thumbnailProvider = function1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.$picList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        ScalingImageView scalingImageView = new ScalingImageView(this.$context);
        String str = (String) this.$thumbnailProvider.invoke(this.$picList.get(i));
        ScalingImageView scalingImageView2 = scalingImageView;
        viewGroup.addView(scalingImageView2, -1, -1);
        AppHolder.getContextImageLoader().displayImage(this.$context, str, (ImageView) scalingImageView, ImageLoaderOptions.newBuilder().useAnimate(true).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) null);
        ViewExtendsKt.setUtilClickListener(scalingImageView2, new NodeHelper$createCoverAdapter$1$instantiateItem$1(this, i));
        this.viewMap.put(i, scalingImageView);
        return scalingImageView;
    }

    /* access modifiers changed from: private */
    public final void onImageClick(int i) {
        Rect[] rectArr = new Rect[this.$picList.size()];
        View view = this.viewMap.get(i);
        Intrinsics.checkNotNullExpressionValue(view, "imageView");
        Rect globalRect = ViewExtendsKt.getGlobalRect(view);
        if (globalRect == null) {
            globalRect = new Rect();
        }
        rectArr[i] = globalRect;
        Activity activityNullable = UiUtils.getActivityNullable(this.$context);
        Intrinsics.checkNotNull(activityNullable);
        Object[] array = this.$picList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        List<Object> list = this.$picList;
        Function1 function1 = this.$thumbnailProvider;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Object obj : list) {
            arrayList.add(function1.invoke(obj));
        }
        Object[] array2 = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        ActionManager.startPhotoViewActivity(activityNullable, strArr, (String[]) array2, i, null, null, rectArr);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "any");
        viewGroup.removeView((View) obj);
        this.viewMap.remove(i);
    }
}
