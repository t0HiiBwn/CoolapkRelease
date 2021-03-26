package com.coolapk.market.view.danmaku;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/danmaku/DanmakuText;", "", "text", "", "danmakuTextStyle", "Lcom/coolapk/market/view/danmaku/DanmakuTextStyle;", "name", "(Ljava/lang/String;Lcom/coolapk/market/view/danmaku/DanmakuTextStyle;Ljava/lang/String;)V", "getDanmakuTextStyle", "()Lcom/coolapk/market/view/danmaku/DanmakuTextStyle;", "getName", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DanmakuText.kt */
public final class DanmakuText {
    private final DanmakuTextStyle danmakuTextStyle;
    private final String name;
    private final String text;

    public static /* synthetic */ DanmakuText copy$default(DanmakuText danmakuText, String str, DanmakuTextStyle danmakuTextStyle2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = danmakuText.text;
        }
        if ((i & 2) != 0) {
            danmakuTextStyle2 = danmakuText.danmakuTextStyle;
        }
        if ((i & 4) != 0) {
            str2 = danmakuText.name;
        }
        return danmakuText.copy(str, danmakuTextStyle2, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final DanmakuTextStyle component2() {
        return this.danmakuTextStyle;
    }

    public final String component3() {
        return this.name;
    }

    public final DanmakuText copy(String str, DanmakuTextStyle danmakuTextStyle2, String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(danmakuTextStyle2, "danmakuTextStyle");
        return new DanmakuText(str, danmakuTextStyle2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DanmakuText)) {
            return false;
        }
        DanmakuText danmakuText = (DanmakuText) obj;
        return Intrinsics.areEqual(this.text, danmakuText.text) && Intrinsics.areEqual(this.danmakuTextStyle, danmakuText.danmakuTextStyle) && Intrinsics.areEqual(this.name, danmakuText.name);
    }

    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DanmakuTextStyle danmakuTextStyle2 = this.danmakuTextStyle;
        int hashCode2 = (hashCode + (danmakuTextStyle2 != null ? danmakuTextStyle2.hashCode() : 0)) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "DanmakuText(text=" + this.text + ", danmakuTextStyle=" + this.danmakuTextStyle + ", name=" + this.name + ")";
    }

    public DanmakuText(String str, DanmakuTextStyle danmakuTextStyle2, String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(danmakuTextStyle2, "danmakuTextStyle");
        this.text = str;
        this.danmakuTextStyle = danmakuTextStyle2;
        this.name = str2;
    }

    public final String getText() {
        return this.text;
    }

    public final DanmakuTextStyle getDanmakuTextStyle() {
        return this.danmakuTextStyle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DanmakuText(String str, DanmakuTextStyle danmakuTextStyle2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, danmakuTextStyle2, (i & 4) != 0 ? null : str2);
    }

    public final String getName() {
        return this.name;
    }
}
