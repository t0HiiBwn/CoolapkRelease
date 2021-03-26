package com.coolapk.market.util;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import com.coolapk.market.widget.CoolMarketURLSpan;
import com.coolapk.market.widget.emotion.EmotionUtils;
import com.coolapk.market.widget.emotion.ImageSpanAlignCenter;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000bJ\u001c\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\bH\u0007J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/util/LinkTextUtils;", "", "()V", "FORWARD_PIC_A_TAG", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "FORWARD_PIC_PATTERN", "FORWARD_PIC_TEXT", "", "QQ_EMOTION_HTML_PATTERN", "convert", "Landroid/text/SpannableStringBuilder;", "text", "linkColor", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "convertPicFormatToATag", "reconvert", "reconvertForwardPicFormatToString", "reconvertQQEmotionHtmlFormatToString", "reconvertToString", "builder", "removeSpannable", "", "", "clazz", "Ljava/lang/Class;", "setLineToHtmlBr", "setRawWebUrlSpan", "trimSpannable", "spannable", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LinkTextUtils.kt */
public final class LinkTextUtils {
    private static final Pattern FORWARD_PIC_A_TAG = Pattern.compile(" \\[查看图片]\\((.+?)\\)");
    private static final Pattern FORWARD_PIC_PATTERN = Pattern.compile("<a class=\"feed-forward-pic.+?href=\"(.+?)\">查看图片</a>");
    private static final String FORWARD_PIC_TEXT = " [查看图片]($1) ";
    public static final LinkTextUtils INSTANCE = new LinkTextUtils();
    private static final Pattern QQ_EMOTION_HTML_PATTERN = Pattern.compile("<img src=\"http://static.coolapk.com/emoticons/default/\\d{1,2}.gif\" alt=\"(.{1,3})\"/>");

    private LinkTextUtils() {
    }

    @JvmStatic
    public static final SpannableStringBuilder convert(String str, int i, Html.ImageGetter imageGetter) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return new SpannableStringBuilder("");
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        String lineToHtmlBr = StringUtils.lineToHtmlBr(INSTANCE.convertPicFormatToATag(reconvertQQEmotionHtmlFormatToString(StringsKt.replace$default(StringsKt.trim((CharSequence) str2).toString(), "\n", "<br />", false, 4, (Object) null))));
        Spanned fromHtml = Html.fromHtml(lineToHtmlBr, imageGetter, null);
        URLSpan[] uRLSpanArr = (URLSpan[]) fromHtml.getSpans(0, lineToHtmlBr.length(), URLSpan.class);
        ImageSpan[] imageSpanArr = (ImageSpan[]) fromHtml.getSpans(0, lineToHtmlBr.length(), ImageSpan.class);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        for (ImageSpan imageSpan : imageSpanArr) {
            if (imageSpan instanceof ImageSpanAlignCenter) {
                break;
            }
            Intrinsics.checkNotNullExpressionValue(imageSpan, "imageSpan");
            spannableStringBuilder.setSpan(new ImageSpanAlignCenter(imageSpan.getDrawable(), imageSpan.getSource()), fromHtml.getSpanStart(imageSpan), fromHtml.getSpanEnd(imageSpan), 33);
            spannableStringBuilder.removeSpan(imageSpan);
        }
        for (URLSpan uRLSpan : uRLSpanArr) {
            Intrinsics.checkNotNullExpressionValue(uRLSpan, "span");
            if (TextUtils.isEmpty(uRLSpan.getURL())) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i), fromHtml.getSpanStart(uRLSpan), fromHtml.getSpanEnd(uRLSpan), fromHtml.getSpanFlags(uRLSpan));
            } else {
                spannableStringBuilder.setSpan(new CoolMarketURLSpan(uRLSpan.getURL(), i), fromHtml.getSpanStart(uRLSpan), fromHtml.getSpanEnd(uRLSpan), fromHtml.getSpanFlags(uRLSpan));
            }
            spannableStringBuilder.removeSpan(uRLSpan);
        }
        EmotionUtils.parserEmoticons(spannableStringBuilder, 0, fromHtml.length(), EmotionUtils.COUNT_INTERCEPT);
        FeedTextUtils.setFeedTextLinkIcon(spannableStringBuilder);
        return trimSpannable(spannableStringBuilder);
    }

    public final String reconvertToString(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "builder");
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        Object[] spans = spannableStringBuilder2.getSpans(0, spannableStringBuilder.length(), ImageSpanAlignCenter.class);
        Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        Object[] objArr = (ImageSpanAlignCenter[]) spans;
        for (Object obj : objArr) {
            int spanStart = spannableStringBuilder.getSpanStart(obj);
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            CharSequence subSequence = spannableStringBuilder.subSequence(spanStart, spanEnd);
            Intrinsics.checkNotNullExpressionValue(subSequence, "builder.subSequence(start, end)");
            if (Intrinsics.areEqual(subSequence.toString(), "查看图片")) {
                spannableStringBuilder.replace(spanStart, spanEnd, "");
                spannableStringBuilder.removeSpan(obj);
            }
        }
        Object[] spans2 = spannableStringBuilder2.getSpans(0, spannableStringBuilder.length(), CoolMarketURLSpan.class);
        Intrinsics.checkExpressionValueIsNotNull(spans2, "getSpans(start, end, T::class.java)");
        CoolMarketURLSpan[] coolMarketURLSpanArr = (CoolMarketURLSpan[]) spans2;
        for (CoolMarketURLSpan coolMarketURLSpan : coolMarketURLSpanArr) {
            int spanStart2 = spannableStringBuilder.getSpanStart(coolMarketURLSpan);
            int spanEnd2 = spannableStringBuilder.getSpanEnd(coolMarketURLSpan);
            CharSequence subSequence2 = spannableStringBuilder.subSequence(spanStart2, spanEnd2);
            Intrinsics.checkNotNullExpressionValue(subSequence2, "builder.subSequence(start, end)");
            if (Intrinsics.areEqual(subSequence2.toString(), "查看图片")) {
                spannableStringBuilder.replace(spanStart2, spanEnd2, " [查看图片](" + coolMarketURLSpan.getURL() + ')');
                spannableStringBuilder.removeSpan(coolMarketURLSpan);
            }
        }
        String spannableStringBuilder3 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder3, "builder.toString()");
        return spannableStringBuilder3;
    }

    @JvmStatic
    public static final String reconvertQQEmotionHtmlFormatToString(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        String replaceAll = QQ_EMOTION_HTML_PATTERN.matcher(str).replaceAll("[$1]");
        Intrinsics.checkNotNullExpressionValue(replaceAll, "QQ_EMOTION_HTML_PATTERN.…(text).replaceAll(\"[$1]\")");
        return replaceAll;
    }

    @JvmStatic
    public static final String reconvert(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        String obj = Html.fromHtml(StringUtils.lineToHtmlBr(reconvertForwardPicFormatToString(reconvertQQEmotionHtmlFormatToString(str)))).toString();
        if (!StringsKt.endsWith$default(obj, " 查看更多", false, 2, (Object) null)) {
            return obj;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
        String substring = obj.substring(0, obj.length() - 5);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @JvmStatic
    public static final String reconvertForwardPicFormatToString(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        String replaceAll = FORWARD_PIC_PATTERN.matcher(str).replaceAll(" [查看图片]($1) ");
        Intrinsics.checkNotNullExpressionValue(replaceAll, "FORWARD_PIC_PATTERN.matc…laceAll(FORWARD_PIC_TEXT)");
        return replaceAll;
    }

    private final String convertPicFormatToATag(String str) {
        String replaceAll = FORWARD_PIC_A_TAG.matcher(str).replaceAll(" <a class=\"feed-forward-pic\" href=\"$1\">查看图片</a> ");
        Intrinsics.checkNotNullExpressionValue(replaceAll, "FORWARD_PIC_A_TAG.matche…\" href=\\\"$1\\\">查看图片</a> \")");
        return replaceAll;
    }

    @JvmStatic
    public static final SpannableStringBuilder trimSpannable(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "spannable");
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i = 0;
        if (spannableStringBuilder2.length() == 0) {
            return spannableStringBuilder;
        }
        int length = spannableStringBuilder.length() - 1;
        while (i <= length && Intrinsics.compare((int) spannableStringBuilder.charAt(i), 32) <= 0) {
            i++;
        }
        int i2 = length;
        while (i2 >= i && Intrinsics.compare((int) spannableStringBuilder.charAt(i2), 32) <= 0) {
            i2--;
        }
        return (i == 0 && i2 == length) ? spannableStringBuilder : new SpannableStringBuilder(spannableStringBuilder2, i, i2 + 1);
    }

    @JvmStatic
    public static final void setRawWebUrlSpan(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        if (charSequence instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence;
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, charSequence.length(), URLSpan.class);
            for (URLSpan uRLSpan : uRLSpanArr) {
                if (!(uRLSpan instanceof CoolMarketURLSpan)) {
                    Intrinsics.checkNotNullExpressionValue(uRLSpan, "span");
                    String url = uRLSpan.getURL();
                    Intrinsics.checkNotNullExpressionValue(url, "span.url");
                    if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
                        int spanStart = spannable.getSpanStart(uRLSpan);
                        int spanEnd = spannable.getSpanEnd(uRLSpan);
                        int spanFlags = spannable.getSpanFlags(uRLSpan);
                        spannable.removeSpan(uRLSpan);
                        spannable.setSpan(new CoolMarketURLSpan(uRLSpan.getURL(), i, false), spanStart, spanEnd, spanFlags);
                    }
                }
            }
        }
    }

    @JvmStatic
    public static final void removeSpannable(CharSequence charSequence, Class<?> cls) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        if (charSequence instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence;
            for (Object obj : spannable.getSpans(0, charSequence.length(), cls)) {
                spannable.removeSpan(obj);
            }
        }
    }

    @JvmStatic
    public static final CharSequence setLineToHtmlBr(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lineToHtmlBr = StringUtils.lineToHtmlBr(str);
        Intrinsics.checkNotNullExpressionValue(lineToHtmlBr, "StringUtils.lineToHtmlBr(text)");
        return new SpannableStringBuilder(Html.fromHtml(lineToHtmlBr, null, null));
    }
}
