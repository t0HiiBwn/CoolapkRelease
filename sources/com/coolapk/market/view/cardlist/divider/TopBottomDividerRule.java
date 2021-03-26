package com.coolapk.market.view.cardlist.divider;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.divider.DividerData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/TopBottomDividerRule;", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "top", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "bottom", "(Lcom/coolapk/market/view/cardlist/divider/DividerData;Lcom/coolapk/market/view/cardlist/divider/DividerData;)V", "getDividerData", "rawPosition", "", "current", "", "next", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListDividerRule.kt */
public final class TopBottomDividerRule implements DividerRule {
    public static final Companion Companion = new Companion(null);
    private static final TopBottomDividerRule EMPTY = new TopBottomDividerRule(DividerData.Companion.getEMPTY(), DividerData.Companion.getEMPTY());
    private static final TopBottomDividerRule EMPTY12DP = new TopBottomDividerRule(DividerData.Companion.getEMPTY(), DividerData.Companion.getH12DP());
    private static final TopBottomDividerRule NULL = new TopBottomDividerRule(null, null);
    public static final TopBottomDividerRule TB12DP = new TopBottomDividerRule(DividerData.Companion.getH12DP(), DividerData.Companion.getH12DP());
    private DividerData bottom;
    private DividerData top;

    public TopBottomDividerRule() {
        this(null, null, 3, null);
    }

    public TopBottomDividerRule(DividerData dividerData, DividerData dividerData2) {
        this.top = dividerData;
        this.bottom = dividerData2;
        DividerData dividerData3 = null;
        this.top = dividerData != null ? dividerData.toImmutable() : null;
        DividerData dividerData4 = this.bottom;
        this.bottom = dividerData4 != null ? dividerData4.toImmutable() : dividerData3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopBottomDividerRule(DividerData dividerData, DividerData dividerData2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dividerData, (i & 2) != 0 ? null : dividerData2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/TopBottomDividerRule$Companion;", "", "()V", "EMPTY", "Lcom/coolapk/market/view/cardlist/divider/TopBottomDividerRule;", "getEMPTY", "()Lcom/coolapk/market/view/cardlist/divider/TopBottomDividerRule;", "EMPTY12DP", "getEMPTY12DP", "NULL", "getNULL", "TB12DP", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EntityListDividerRule.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TopBottomDividerRule getEMPTY() {
            return TopBottomDividerRule.EMPTY;
        }

        public final TopBottomDividerRule getNULL() {
            return TopBottomDividerRule.NULL;
        }

        public final TopBottomDividerRule getEMPTY12DP() {
            return TopBottomDividerRule.EMPTY12DP;
        }
    }

    @Override // com.coolapk.market.view.cardlist.divider.DividerRule
    public DividerData getDividerData(int i, Object obj, Object obj2) {
        int cardDividerBottom;
        if (obj == null) {
            if (obj2 instanceof Entity) {
                Entity entity = (Entity) obj2;
                int cardDividerTop = EntityExtendsKt.getCardDividerTop(entity);
                if (cardDividerTop != Integer.MIN_VALUE) {
                    return DividerData.Companion.obtain$default(DividerData.Companion, 0, 0, cardDividerTop, null, 11, null);
                }
                String uniqueType = EntityExtendsKt.uniqueType(entity);
                int hashCode = uniqueType.hashCode();
                if (hashCode == -2136267384 ? uniqueType.equals("titleCard") : !(hashCode != -1116287728 || !uniqueType.equals("headCard"))) {
                    return DividerData.Companion.getEMPTY();
                }
            }
            return this.top;
        } else if (obj2 != null) {
            return null;
        } else {
            if (!(obj instanceof Entity) || (cardDividerBottom = EntityExtendsKt.getCardDividerBottom((Entity) obj)) == Integer.MIN_VALUE) {
                return this.bottom;
            }
            return DividerData.Companion.obtain$default(DividerData.Companion, 0, 0, cardDividerBottom, null, 11, null);
        }
    }
}
