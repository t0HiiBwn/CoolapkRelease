package com.coolapk.market.view.product;

import android.content.Context;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/product/ProductGlobalData;", "", "()V", "PRODUCT_MEDIA_IMAGE", "", "PRODUCT_MEDIA_VIDEO", "PRODUCT_RATING_TYPE_PHONE", "appearanceRatingData", "Lcom/coolapk/market/view/product/RatingBarData;", "batteryRatingData", "cameraRatingData", "costPerformanceRatingData", "fluencyRatingData", "gameRatingData", "screenRatingData", "touchRatingData", "getNumberTypeface", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "getRatingDataList", "", "ratingType", "ratingScoreToStartScore", "", "ratingScore", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductGlobalData.kt */
public final class ProductGlobalData {
    public static final ProductGlobalData INSTANCE = new ProductGlobalData();
    public static final String PRODUCT_MEDIA_IMAGE = "image";
    public static final String PRODUCT_MEDIA_VIDEO = "video";
    public static final String PRODUCT_RATING_TYPE_PHONE = "1";
    private static final RatingBarData appearanceRatingData = new RatingBarData("rating_score_1", "外观", "审美灾难", "设计平庸", "中规中矩", "美观好看", "工业明珠");
    private static final RatingBarData batteryRatingData = new RatingBarData("rating_score_5", "流畅度", "卡爆了", "偶然卡顿", "基本流畅", "反应迅速", "丝般顺滑");
    private static final RatingBarData cameraRatingData = new RatingBarData("rating_score_4", "拍照", "模糊差劲", "能拍就行", "清晰好用", "画质优良", "堪比单反");
    private static final RatingBarData costPerformanceRatingData = new RatingBarData("rating_score_8", "性价比", "极低", "较低", "还行", "较高", "极高");
    private static final RatingBarData fluencyRatingData = new RatingBarData("rating_score_6", "续航", "一天多充", "移电随身", "勉强一天", "轻松一天", "强劲持久");
    private static final RatingBarData gameRatingData = new RatingBarData("rating_score_7", "游戏体验", "卡顿难受", "勉强玩玩", "流畅吃鸡", "高帧畅玩", "极致性能");
    private static final RatingBarData screenRatingData = new RatingBarData("rating_score_3", "屏幕", "大果粒", "较为精细", "色彩准确", "视觉盛宴", "震撼视野");
    private static final RatingBarData touchRatingData = new RatingBarData("rating_score_2", "手感", "沉重割手", "手感不适", "舒适趁手", "手感优秀", "真TM爽");

    public final float ratingScoreToStartScore(float f) {
        if (f >= 9.2f) {
            return 5.0f;
        }
        if (f >= 8.4f) {
            return 4.5f;
        }
        if (f >= 7.6f) {
            return 4.0f;
        }
        if (f >= 6.8f) {
            return 3.5f;
        }
        if (f >= 6.0f) {
            return 3.0f;
        }
        if (f >= 5.0f) {
            return 2.5f;
        }
        if (f >= 4.0f) {
            return 2.0f;
        }
        if (f >= 3.0f) {
            return 1.5f;
        }
        return f >= 1.0f ? 1.0f : 0.0f;
    }

    private ProductGlobalData() {
    }

    public final List<RatingBarData> getRatingDataList(String str) {
        Intrinsics.checkNotNullParameter(str, "ratingType");
        ArrayList arrayList = new ArrayList();
        if (str.hashCode() == 49 && str.equals("1")) {
            arrayList.add(appearanceRatingData);
            arrayList.add(touchRatingData);
            arrayList.add(screenRatingData);
            arrayList.add(cameraRatingData);
            arrayList.add(batteryRatingData);
            arrayList.add(fluencyRatingData);
            arrayList.add(gameRatingData);
            arrayList.add(costPerformanceRatingData);
        }
        return arrayList;
    }

    @JvmStatic
    public static final Typeface getNumberTypeface(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), "fonts/bebas.ttf");
            Intrinsics.checkNotNullExpressionValue(createFromAsset, "Typeface.createFromAsset…ssets, \"fonts/bebas.ttf\")");
            return createFromAsset;
        } catch (Exception unused) {
            Typeface typeface = Typeface.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(typeface, "Typeface.DEFAULT");
            return typeface;
        }
    }
}
