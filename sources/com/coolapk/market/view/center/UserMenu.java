package com.coolapk.market.view.center;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CenterUserMenuPresenter.kt */
public final class UserMenu {
    private final String bubbleLongText;
    private final String bubbleText;
    private final boolean deletable;
    private final int iconRes;
    private final boolean showBubble;
    private final boolean showDot;
    private final int tintColor;
    private final int titleRes;
    private final String type;

    public static /* synthetic */ UserMenu copy$default(UserMenu userMenu, String str, int i, int i2, int i3, boolean z, boolean z2, String str2, String str3, boolean z3, int i4, Object obj) {
        return userMenu.copy((i4 & 1) != 0 ? userMenu.type : str, (i4 & 2) != 0 ? userMenu.titleRes : i, (i4 & 4) != 0 ? userMenu.iconRes : i2, (i4 & 8) != 0 ? userMenu.tintColor : i3, (i4 & 16) != 0 ? userMenu.showDot : z, (i4 & 32) != 0 ? userMenu.showBubble : z2, (i4 & 64) != 0 ? userMenu.bubbleText : str2, (i4 & 128) != 0 ? userMenu.bubbleLongText : str3, (i4 & 256) != 0 ? userMenu.deletable : z3);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.titleRes;
    }

    public final int component3() {
        return this.iconRes;
    }

    public final int component4() {
        return this.tintColor;
    }

    public final boolean component5() {
        return this.showDot;
    }

    public final boolean component6() {
        return this.showBubble;
    }

    public final String component7() {
        return this.bubbleText;
    }

    public final String component8() {
        return this.bubbleLongText;
    }

    public final boolean component9() {
        return this.deletable;
    }

    public final UserMenu copy(String str, int i, int i2, int i3, boolean z, boolean z2, String str2, String str3, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "bubbleText");
        Intrinsics.checkNotNullParameter(str3, "bubbleLongText");
        return new UserMenu(str, i, i2, i3, z, z2, str2, str3, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserMenu)) {
            return false;
        }
        UserMenu userMenu = (UserMenu) obj;
        return Intrinsics.areEqual(this.type, userMenu.type) && this.titleRes == userMenu.titleRes && this.iconRes == userMenu.iconRes && this.tintColor == userMenu.tintColor && this.showDot == userMenu.showDot && this.showBubble == userMenu.showBubble && Intrinsics.areEqual(this.bubbleText, userMenu.bubbleText) && Intrinsics.areEqual(this.bubbleLongText, userMenu.bubbleLongText) && this.deletable == userMenu.deletable;
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (((((((str != null ? str.hashCode() : 0) * 31) + this.titleRes) * 31) + this.iconRes) * 31) + this.tintColor) * 31;
        boolean z = this.showDot;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode + i3) * 31;
        boolean z2 = this.showBubble;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (i6 + i7) * 31;
        String str2 = this.bubbleText;
        int hashCode2 = (i10 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bubbleLongText;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i11 = (hashCode2 + i) * 31;
        boolean z3 = this.deletable;
        if (!z3) {
            i2 = z3 ? 1 : 0;
        }
        return i11 + i2;
    }

    public String toString() {
        return "UserMenu(type=" + this.type + ", titleRes=" + this.titleRes + ", iconRes=" + this.iconRes + ", tintColor=" + this.tintColor + ", showDot=" + this.showDot + ", showBubble=" + this.showBubble + ", bubbleText=" + this.bubbleText + ", bubbleLongText=" + this.bubbleLongText + ", deletable=" + this.deletable + ")";
    }

    public UserMenu(String str, int i, int i2, int i3, boolean z, boolean z2, String str2, String str3, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "bubbleText");
        Intrinsics.checkNotNullParameter(str3, "bubbleLongText");
        this.type = str;
        this.titleRes = i;
        this.iconRes = i2;
        this.tintColor = i3;
        this.showDot = z;
        this.showBubble = z2;
        this.bubbleText = str2;
        this.bubbleLongText = str3;
        this.deletable = z3;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getTintColor() {
        return this.tintColor;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getShowDot() {
        return this.showDot;
    }

    public final boolean getShowBubble() {
        return this.showBubble;
    }

    public final String getBubbleText() {
        return this.bubbleText;
    }

    public final String getBubbleLongText() {
        return this.bubbleLongText;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserMenu(String str, int i, int i2, int i3, boolean z, boolean z2, String str2, String str3, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3, (i4 & 16) != 0 ? false : z, (i4 & 32) != 0 ? false : z2, (i4 & 64) != 0 ? "" : str2, (i4 & 128) != 0 ? "" : str3, (i4 & 256) != 0 ? true : z3);
    }

    public final boolean getDeletable() {
        return this.deletable;
    }
}
