package com.coolapk.market.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.CoolMarketURLSpan;
import com.coolapk.market.widget.emotion.ImageSpanAlignCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/util/FeedTextUtils;", "", "()V", "LINK_INDICATOR", "", "PHOTO_INDICATOR", "VIDEO_INDICATOR", "appendPhotoLink", "", "builder", "Landroid/text/SpannableStringBuilder;", "imageUrl", "Lcom/coolapk/market/model/ImageUrl;", "buildPhotoSpanText", "insertPhotoLink", "insertReconvertedPhotoLink", "text", "feed", "Lcom/coolapk/market/model/Feed;", "newLinkDrawable", "Landroid/graphics/drawable/Drawable;", "tintColor", "", "newPhotoDrawable", "newPlayBoxDrawable", "setFeedTextLinkIcon", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedTextUtils.kt */
public final class FeedTextUtils {
    public static final FeedTextUtils INSTANCE = new FeedTextUtils();
    private static final String LINK_INDICATOR = "[链接]";
    private static final String PHOTO_INDICATOR = "[图片]";
    private static final String VIDEO_INDICATOR = "[视频]";

    private FeedTextUtils() {
    }

    private final Drawable newLinkDrawable(int i) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{ResourceUtils.getDrawable(AppHolder.getApplication(), 2131231408)});
        layerDrawable.setLayerInset(0, NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 1), NumberExtendsKt.getDp((Number) 2), 0);
        layerDrawable.setTint(i);
        return layerDrawable;
    }

    private final Drawable newPlayBoxDrawable(int i) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{ResourceUtils.getDrawable(AppHolder.getApplication(), 2131231496)});
        layerDrawable.setLayerInset(0, NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 2), 0);
        layerDrawable.setTint(i);
        return layerDrawable;
    }

    private final Drawable newPhotoDrawable(int i) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{ResourceUtils.getDrawable(AppHolder.getApplication(), 2131231373)});
        layerDrawable.setLayerInset(0, NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 1), NumberExtendsKt.getDp((Number) 2), 0);
        layerDrawable.setTint(i);
        return layerDrawable;
    }

    @JvmStatic
    public static final void setFeedTextLinkIcon(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "builder");
        CoolMarketURLSpan[] coolMarketURLSpanArr = (CoolMarketURLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), CoolMarketURLSpan.class);
        for (CoolMarketURLSpan coolMarketURLSpan : coolMarketURLSpanArr) {
            Intrinsics.checkNotNullExpressionValue(coolMarketURLSpan, "span");
            int linkColor = coolMarketURLSpan.getLinkColor();
            int spanStart = spannableStringBuilder.getSpanStart(coolMarketURLSpan);
            String obj = spannableStringBuilder.subSequence(spanStart, spannableStringBuilder.getSpanEnd(coolMarketURLSpan)).toString();
            if (Intrinsics.areEqual(obj, "视频链接")) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("[视频]");
                ImageSpanAlignCenter imageSpanAlignCenter = new ImageSpanAlignCenter(INSTANCE.newPlayBoxDrawable(linkColor), "[视频]");
                CoolMarketURLSpan coolMarketURLSpan2 = new CoolMarketURLSpan(coolMarketURLSpan);
                spannableStringBuilder2.setSpan(imageSpanAlignCenter, 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder2.setSpan(coolMarketURLSpan2, 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.insert(spanStart, (CharSequence) spannableStringBuilder2);
            } else if (Intrinsics.areEqual(obj, "查看链接»") || Intrinsics.areEqual(obj, "查看链接")) {
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("[链接]");
                ImageSpanAlignCenter imageSpanAlignCenter2 = new ImageSpanAlignCenter(INSTANCE.newLinkDrawable(linkColor), "[链接]");
                CoolMarketURLSpan coolMarketURLSpan3 = new CoolMarketURLSpan(coolMarketURLSpan);
                spannableStringBuilder3.setSpan(imageSpanAlignCenter2, 0, spannableStringBuilder3.length(), 33);
                spannableStringBuilder3.setSpan(coolMarketURLSpan3, 0, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.insert(spanStart, (CharSequence) spannableStringBuilder3);
            } else if (Intrinsics.areEqual(obj, "查看图片")) {
                ImageArgs.Companion companion = ImageArgs.Companion;
                String url = coolMarketURLSpan.getURL();
                Intrinsics.checkNotNullExpressionValue(url, "span.url");
                if (!companion.isCoolApkHostImage(url)) {
                    spannableStringBuilder.removeSpan(coolMarketURLSpan);
                } else {
                    ImageSpanAlignCenter imageSpanAlignCenter3 = new ImageSpanAlignCenter(INSTANCE.newPhotoDrawable(linkColor), obj);
                    coolMarketURLSpan.setExtraListener(FeedTextUtils$setFeedTextLinkIcon$1.INSTANCE);
                    CoolMarketURLSpan coolMarketURLSpan4 = new CoolMarketURLSpan(coolMarketURLSpan);
                    SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(obj);
                    spannableStringBuilder4.setSpan(imageSpanAlignCenter3, 0, spannableStringBuilder4.length(), 33);
                    spannableStringBuilder4.setSpan(coolMarketURLSpan4, 0, spannableStringBuilder4.length(), 33);
                    spannableStringBuilder.insert(spanStart, (CharSequence) spannableStringBuilder4);
                    spannableStringBuilder.setSpan(new CommentHelper.FastDeleteSpan(), spanStart, spannableStringBuilder.getSpanEnd(coolMarketURLSpan), 33);
                }
            } else if (StringsKt.startsWith$default(obj, "[视频]", false, 2, (Object) null)) {
                spannableStringBuilder.setSpan(new ImageSpanAlignCenter(INSTANCE.newPlayBoxDrawable(linkColor), "[视频]"), spanStart, spanStart + 4, 33);
            } else if (StringsKt.startsWith$default(obj, "[链接]", false, 2, (Object) null)) {
                spannableStringBuilder.setSpan(new ImageSpanAlignCenter(INSTANCE.newLinkDrawable(linkColor), "[链接]"), spanStart, spanStart + 4, 33);
            }
        }
    }

    @JvmStatic
    public static final String insertReconvertedPhotoLink(String str, Feed feed) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (!feed.isForwardFeed()) {
            return str;
        }
        String pic = feed.getPic();
        if (pic == null || pic.length() == 0) {
            return str;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, "//@", 0, false, 6, (Object) null);
        String pic2 = feed.getPic();
        if (pic2 == null) {
            pic2 = "";
        }
        String str2 = " [查看图片](" + pic2 + ") ";
        StringBuilder sb = new StringBuilder(str);
        if (indexOf$default >= 0) {
            sb.insert(indexOf$default, str2);
        } else {
            sb.append(str2);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    @JvmStatic
    public static final void insertPhotoLink(SpannableStringBuilder spannableStringBuilder, ImageUrl imageUrl) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "builder");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "builder.toString()");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) spannableStringBuilder2, "//@", 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            spannableStringBuilder.insert(indexOf$default, (CharSequence) INSTANCE.buildPhotoSpanText(imageUrl));
        } else {
            spannableStringBuilder.append((CharSequence) INSTANCE.buildPhotoSpanText(imageUrl));
        }
    }

    @JvmStatic
    public static final void appendPhotoLink(SpannableStringBuilder spannableStringBuilder, ImageUrl imageUrl) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "builder");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        spannableStringBuilder.append((CharSequence) INSTANCE.buildPhotoSpanText(imageUrl));
    }

    public final SpannableStringBuilder buildPhotoSpanText(ImageUrl imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        SpannableStringBuilder append = new SpannableStringBuilder("[图片]").append((CharSequence) "查看图片");
        ImageSpanAlignCenter imageSpanAlignCenter = new ImageSpanAlignCenter(newPhotoDrawable(AppHolder.getAppTheme().getColorAccent()), "[链接]");
        CoolMarketURLSpan coolMarketURLSpan = new CoolMarketURLSpan("[图片]", AppHolder.getAppTheme().getColorAccent());
        coolMarketURLSpan.setExtraListener(new FeedTextUtils$buildPhotoSpanText$1(imageUrl));
        append.setSpan(imageSpanAlignCenter, 0, 4, 33);
        append.setSpan(coolMarketURLSpan, 0, append.length(), 33);
        SpannableStringBuilder append2 = append.append((CharSequence) " ");
        Intrinsics.checkNotNullExpressionValue(append2, "iconSpannable.append(\" \")");
        return append2;
    }
}
