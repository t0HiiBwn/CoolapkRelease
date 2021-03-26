package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedRelation;
import com.coolapk.market.model.FeedTarget;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.viewholder.iview.ViewPart;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import com.coolapk.market.widget.view.RelativeInfoView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "(Lcom/coolapk/market/widget/hotplug/ViewPartPool;)V", "ignoreTargetRow", "", "getIgnoreTargetRow", "()Z", "setIgnoreTargetRow", "(Z)V", "relationRowsToSingleLine", "getRelationRowsToSingleLine", "setRelationRowsToSingleLine", "getViewPartPool", "()Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "bindTo", "", "data", "Lcom/coolapk/market/model/Feed;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedRelativeInfoViewPart.kt */
public final class FeedRelativeInfoViewPart extends ViewPart {
    public static final Companion Companion = new Companion(null);
    private static final int LAYOUT_ID = FeedRelativeInfoViewPart.class.getName().hashCode();
    private boolean ignoreTargetRow;
    private boolean relationRowsToSingleLine;
    private final ViewPartPool viewPartPool;

    public FeedRelativeInfoViewPart() {
        this(null, 1, null);
    }

    public FeedRelativeInfoViewPart(ViewPartPool viewPartPool2) {
        this.viewPartPool = viewPartPool2;
        this.relationRowsToSingleLine = true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedRelativeInfoViewPart(ViewPartPool viewPartPool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : viewPartPool2);
    }

    public final ViewPartPool getViewPartPool() {
        return this.viewPartPool;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "getLAYOUT_ID", "()I", "shouldShowView", "", "data", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedRelativeInfoViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldShowView(Feed feed) {
            Intrinsics.checkNotNullParameter(feed, "data");
            if (EntityExtendsKt.isArticleNews(feed)) {
                return false;
            }
            String location = feed.getLocation();
            if ((location == null || location.length() == 0) && feed.getTargetRow() == null) {
                List<FeedRelation> relationRows = feed.getRelationRows();
                Intrinsics.checkNotNullExpressionValue(relationRows, "data.relationRows");
                if (!(!relationRows.isEmpty()) && !EntityUtils.isFeedByDyhHeaderType(feed.getEntityTemplate())) {
                    return false;
                }
            }
            return true;
        }

        public final int getLAYOUT_ID() {
            return FeedRelativeInfoViewPart.LAYOUT_ID;
        }
    }

    public final boolean getRelationRowsToSingleLine() {
        return this.relationRowsToSingleLine;
    }

    public final void setRelationRowsToSingleLine(boolean z) {
        this.relationRowsToSingleLine = z;
    }

    public final boolean getIgnoreTargetRow() {
        return this.ignoreTargetRow;
    }

    public final void setIgnoreTargetRow(boolean z) {
        this.ignoreTargetRow = z;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = layoutInflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        RelativeInfoView relativeInfoView = new RelativeInfoView(context);
        ViewPartPool viewPartPool2 = this.viewPartPool;
        if (viewPartPool2 == null) {
            viewPartPool2 = new ViewPartPool();
        }
        relativeInfoView.setViewPartPool(viewPartPool2);
        relativeInfoView.setOnItemClickListener(new FeedRelativeInfoViewPart$onCreateView$1$2(relativeInfoView));
        return relativeInfoView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0102, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(com.coolapk.market.util.UriUtils.getActionTypeFromUrl(r6), "dyh") != false) goto L_0x0107;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01aa  */
    public final void bindTo(Feed feed) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Intrinsics.checkNotNullParameter(feed, "data");
        View view = getView();
        if (!(view instanceof RelativeInfoView)) {
            view = null;
        }
        RelativeInfoView relativeInfoView = (RelativeInfoView) view;
        Intrinsics.checkNotNull(relativeInfoView);
        ArrayList arrayList = new ArrayList();
        boolean areEqual = Intrinsics.areEqual(feed.getEntityTemplate(), "feedByDyhHeader");
        String location = feed.getLocation();
        SecondHandInfo secondHandInfo = feed.getSecondHandInfo();
        int i = 0;
        if (secondHandInfo != null) {
            String str10 = location;
            z = !(str10 == null || str10.length() == 0) && secondHandInfo.getCity() != null && (Intrinsics.areEqual(secondHandInfo.getCity(), feed.getLocation()) ^ true);
        } else {
            String str11 = location;
            z = !(str11 == null || str11.length() == 0);
        }
        if (z) {
            if (location != null) {
                str9 = location;
            } else {
                str9 = "";
            }
            arrayList.add(new RelativeInfoView.RelativeItem(str9, String.valueOf(2131231415), null, true, false, null, 52, null));
        }
        if (areEqual) {
            StringBuilder sb = new StringBuilder();
            sb.append("来自 ");
            String userName = feed.getUserName();
            if (userName == null) {
                userName = "";
            }
            sb.append(userName);
            String sb2 = sb.toString();
            String userAvatar = feed.getUserAvatar();
            if (userAvatar != null) {
                str7 = userAvatar;
            } else {
                str7 = "";
            }
            UserInfo userInfo = feed.getUserInfo();
            String url = userInfo != null ? userInfo.getUrl() : null;
            if (url != null) {
                str8 = url;
            } else {
                str8 = "";
            }
            arrayList.add(new RelativeInfoView.RelativeItem(sb2, str7, str8, false, true, null, 32, null));
        }
        FeedTarget targetRow = feed.getTargetRow();
        if (!this.ignoreTargetRow && targetRow != null) {
            if (areEqual) {
                String url2 = targetRow.getUrl();
                if (url2 == null) {
                    url2 = "";
                }
            }
            z2 = true;
            if (z2) {
                Intrinsics.checkNotNull(targetRow);
                String title = targetRow.getTitle();
                if (title != null) {
                    str4 = title;
                } else {
                    str4 = "";
                }
                String logo = targetRow.getLogo();
                if (logo != null) {
                    str5 = logo;
                } else {
                    str5 = "";
                }
                String url3 = targetRow.getUrl();
                if (url3 != null) {
                    str6 = url3;
                } else {
                    str6 = "";
                }
                arrayList.add(new RelativeInfoView.RelativeItem(str4, str5, str6, false, false, null, 48, null));
            }
            List<FeedRelation> relationRows = feed.getRelationRows();
            Intrinsics.checkNotNullExpressionValue(relationRows, "data.relationRows");
            for (T t : relationRows) {
                if (areEqual) {
                    Intrinsics.checkNotNullExpressionValue(t, "item");
                    String url4 = t.getUrl();
                    if (url4 == null) {
                        url4 = "";
                    }
                    z3 = !Intrinsics.areEqual(UriUtils.getActionTypeFromUrl(url4), "dyh");
                } else {
                    z3 = true;
                }
                if (z3) {
                    Intrinsics.checkNotNullExpressionValue(t, "item");
                    String title2 = t.getTitle();
                    if (title2 != null) {
                        str = title2;
                    } else {
                        str = "";
                    }
                    String logo2 = t.getLogo();
                    if (logo2 != null) {
                        str2 = logo2;
                    } else {
                        str2 = "";
                    }
                    String url5 = t.getUrl();
                    if (url5 != null) {
                        str3 = url5;
                    } else {
                        str3 = "";
                    }
                    arrayList.add(new RelativeInfoView.RelativeItem(str, str2, str3, false, false, null, 48, null));
                }
            }
            if (!this.relationRowsToSingleLine) {
                relativeInfoView.setMaxLines(z ? 2 : 1);
            } else {
                relativeInfoView.setMaxLines(Integer.MAX_VALUE);
            }
            if (arrayList.isEmpty()) {
                i = 8;
            }
            relativeInfoView.setVisibility(i);
            if (!(!Intrinsics.areEqual(relativeInfoView.getDataItems(), arrayList))) {
                relativeInfoView.setDataItems(arrayList);
                relativeInfoView.notifyDataSetChange();
                return;
            }
            return;
        }
        z2 = false;
        if (z2) {
        }
        List<FeedRelation> relationRows = feed.getRelationRows();
        Intrinsics.checkNotNullExpressionValue(relationRows, "data.relationRows");
        while (r2.hasNext()) {
        }
        if (!this.relationRowsToSingleLine) {
        }
        if (arrayList.isEmpty()) {
        }
        relativeInfoView.setVisibility(i);
        if (!(!Intrinsics.areEqual(relativeInfoView.getDataItems(), arrayList))) {
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        super.onRecycled();
        this.relationRowsToSingleLine = true;
        this.ignoreTargetRow = false;
        View view = getView();
        if (!(view instanceof RelativeInfoView)) {
            view = null;
        }
        RelativeInfoView relativeInfoView = (RelativeInfoView) view;
        Intrinsics.checkNotNull(relativeInfoView);
        relativeInfoView.setDataItems(Collections.emptyList());
        relativeInfoView.notifyDataSetChange();
    }
}
