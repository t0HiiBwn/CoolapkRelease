package com.coolapk.market.view.node;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppMetadataKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.Topic;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.DividerRule;
import com.coolapk.market.view.node.app.AppNodePresenter;
import com.coolapk.market.view.node.app.AppNodeViewModel;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.view.FabVerticalMenuLayout;
import com.coolapk.market.widget.view.IndicatorView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\fH\u0002¢\u0006\u0002\u0010\rJ&\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bJ>\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\fJ\u001c\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\bJ&\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u001e\u0010&\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020%¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/node/NodeHelper;", "", "()V", "createCoverAdapter", "com/coolapk/market/view/node/NodeHelper$createCoverAdapter$1", "context", "Landroid/content/Context;", "picList", "", "", "thumbnailProvider", "Lkotlin/Function1;", "Lcom/coolapk/market/viewholder/v8/image/ThumbUrlProvider;", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lcom/coolapk/market/view/node/NodeHelper$createCoverAdapter$1;", "getNodeListApiFirstLastItem", "Lkotlin/Pair;", "dataList", "Landroid/os/Parcelable;", "setupIndicatorAndViewPager", "", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "indicator", "Lcom/coolapk/market/widget/view/IndicatorView;", "setupRecommendRows", "linearView", "Lcom/coolapk/market/widget/LinearAdapterLayout;", "rows", "Lcom/coolapk/market/model/NewHeadLine;", "showAppFabView", "activity", "Landroid/app/Activity;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "presenter", "Lcom/coolapk/market/view/node/app/AppNodePresenter;", "translationY", "", "showTopicFabView", "topic", "Lcom/coolapk/market/model/Topic;", "NodeDividerRule", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
public final class NodeHelper {
    public static final NodeHelper INSTANCE = new NodeHelper();

    private NodeHelper() {
    }

    public final void setupRecommendRows(LinearAdapterLayout linearAdapterLayout, List<? extends NewHeadLine> list) {
        Intrinsics.checkNotNullParameter(linearAdapterLayout, "linearView");
        Intrinsics.checkNotNullParameter(list, "rows");
        if (list.isEmpty()) {
            linearAdapterLayout.setVisibility(8);
            return;
        }
        if (list.size() > 1) {
            LinearAdapterLayout linearAdapterLayout2 = linearAdapterLayout;
            linearAdapterLayout2.setPadding(linearAdapterLayout2.getPaddingLeft(), NumberExtendsKt.getDp((Number) 8), linearAdapterLayout2.getPaddingRight(), NumberExtendsKt.getDp((Number) 8));
        } else {
            LinearAdapterLayout linearAdapterLayout3 = linearAdapterLayout;
            linearAdapterLayout3.setPadding(linearAdapterLayout3.getPaddingLeft(), NumberExtendsKt.getDp((Number) 0), linearAdapterLayout3.getPaddingRight(), NumberExtendsKt.getDp((Number) 0));
        }
        linearAdapterLayout.setVisibility(0);
        linearAdapterLayout.setAdapter(new NodeHelper$setupRecommendRows$1(linearAdapterLayout, list, linearAdapterLayout.getContext(), 0, list));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.node.NodeHelper */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setupIndicatorAndViewPager$default(NodeHelper nodeHelper, ViewPager viewPager, IndicatorView indicatorView, List list, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new NodeHelper$setupIndicatorAndViewPager$1(ImageArgs.Companion);
        }
        nodeHelper.setupIndicatorAndViewPager(viewPager, indicatorView, list, function1);
    }

    public final void setupIndicatorAndViewPager(ViewPager viewPager, IndicatorView indicatorView, List<String> list, Function1<? super String, String> function1) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(indicatorView, "indicator");
        Intrinsics.checkNotNullParameter(list, "picList");
        Intrinsics.checkNotNullParameter(function1, "thumbnailProvider");
        Context context = viewPager.getContext();
        int i = 8;
        if (list.isEmpty()) {
            viewPager.setAdapter(null);
            indicatorView.setVisibility(8);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "context");
        viewPager.setAdapter(createCoverAdapter(context, list, function1));
        IndicatorView indicatorView2 = indicatorView;
        boolean z = true;
        if (list.size() != 1) {
            z = false;
        }
        if (!z) {
            i = 0;
        }
        indicatorView2.setVisibility(i);
        indicatorView.setTotalIndicatorCount(list.size());
        indicatorView.setSelectedIndex(0);
        indicatorView.setSelectedDrawableColor(ResourceUtils.getColorInt(context, 2131100160));
        indicatorView.setUnSelectedDrawableColor(ResourceUtils.getColorInt(context, 2131100163));
        viewPager.addOnPageChangeListener(new NodeHelper$setupIndicatorAndViewPager$2(indicatorView));
    }

    private final NodeHelper$createCoverAdapter$1 createCoverAdapter(Context context, List<String> list, Function1<? super String, String> function1) {
        return new NodeHelper$createCoverAdapter$1(list, context, function1);
    }

    public final void showTopicFabView(Activity activity, Topic topic, float f) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Resources resources = activity.getResources();
        FrameLayout contentView = UiUtils.getContentView(activity);
        Intrinsics.checkNotNullExpressionValue(contentView, "content");
        Context context = contentView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "content.context");
        FabVerticalMenuLayout fabVerticalMenuLayout = new FabVerticalMenuLayout(context);
        FabVerticalMenuLayout fabVerticalMenuLayout2 = fabVerticalMenuLayout;
        fabVerticalMenuLayout2.setPadding(fabVerticalMenuLayout2.getPaddingLeft(), fabVerticalMenuLayout2.getPaddingTop(), fabVerticalMenuLayout2.getPaddingRight(), -((int) f));
        FabVerticalMenuLayout.setFabInfo$default(fabVerticalMenuLayout, 2131231500, Integer.valueOf(AppHolder.getAppTheme().getColorAccent()), (View.OnClickListener) null, 4, (Object) null);
        boolean areEqual = Intrinsics.areEqual(topic.getTitle(), "二手交易");
        if (areEqual) {
            Integer valueOf = Integer.valueOf(resources.getColor(2131099880));
            String string = resources.getString(2131886355);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…trance_simple_secondhand)");
            fabVerticalMenuLayout.addSubFabInfo(2131231546, valueOf, string, new NodeHelper$showTopicFabView$1(activity));
        }
        Integer valueOf2 = Integer.valueOf(resources.getColor(2131099881));
        String string2 = resources.getString(2131886357);
        String string3 = resources.getString(2131886351);
        if (!areEqual) {
            string2 = string3;
        }
        Intrinsics.checkNotNullExpressionValue(string2, "inSecondHand.valueTo(\n  …ed_entrance_simple_feed))");
        fabVerticalMenuLayout.addSubFabInfo(2131231269, valueOf2, string2, new NodeHelper$showTopicFabView$2(activity, topic));
        Integer valueOf3 = Integer.valueOf(resources.getColor(2131099883));
        String string4 = resources.getString(2131886349);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…_entrance_simple_article)");
        fabVerticalMenuLayout.addSubFabInfo(2131231185, valueOf3, string4, new NodeHelper$showTopicFabView$3(activity, topic));
        Integer valueOf4 = Integer.valueOf(resources.getColor(2131099887));
        String string5 = resources.getString(2131886353);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…entrance_simple_question)");
        fabVerticalMenuLayout.addSubFabInfo(2131231624, valueOf4, string5, new NodeHelper$showTopicFabView$4(activity, topic));
        if (topic.getTagType() == 1) {
            Integer valueOf5 = Integer.valueOf(resources.getColor(2131099885));
            String string6 = resources.getString(2131886350);
            Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.st…_entrance_simple_comment)");
            fabVerticalMenuLayout.addSubFabInfo(2131231256, valueOf5, string6, new NodeHelper$showTopicFabView$5(activity, topic));
        }
        fabVerticalMenuLayout.setFabLongClickListener(new NodeHelper$showTopicFabView$6(activity));
        contentView.addView(fabVerticalMenuLayout2, new FrameLayout.LayoutParams(-1, -1));
        fabVerticalMenuLayout.post(new NodeHelper$showTopicFabView$7(fabVerticalMenuLayout));
        fabVerticalMenuLayout.setOnDismiss(new NodeHelper$showTopicFabView$8(fabVerticalMenuLayout));
    }

    public final void showAppFabView(Activity activity, AppNodeViewModel appNodeViewModel, AppNodePresenter appNodePresenter, float f) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(appNodePresenter, "presenter");
        ServiceApp serviceApp = appNodeViewModel.getServiceApp().get();
        if (serviceApp != null) {
            Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get() ?: return");
            NodeHelper$showAppFabView$1 nodeHelper$showAppFabView$1 = new NodeHelper$showAppFabView$1(serviceApp, activity);
            if (serviceApp.getIsDownloadApp() != 1) {
                nodeHelper$showAppFabView$1.invoke();
                return;
            }
            Resources resources = activity.getResources();
            FrameLayout contentView = UiUtils.getContentView(activity);
            Intrinsics.checkNotNullExpressionValue(contentView, "content");
            Context context = contentView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "content.context");
            FabVerticalMenuLayout fabVerticalMenuLayout = new FabVerticalMenuLayout(context);
            FabVerticalMenuLayout fabVerticalMenuLayout2 = fabVerticalMenuLayout;
            fabVerticalMenuLayout2.setPadding(fabVerticalMenuLayout2.getPaddingLeft(), fabVerticalMenuLayout2.getPaddingTop(), fabVerticalMenuLayout2.getPaddingRight(), -((int) f));
            FabVerticalMenuLayout.setFabInfo$default(fabVerticalMenuLayout, 2131231500, Integer.valueOf(AppHolder.getAppTheme().getColorAccent()), (View.OnClickListener) null, 4, (Object) null);
            fabVerticalMenuLayout.addSubFabInfo(2131231269, Integer.valueOf(resources.getColor(2131099881)), "讨论", new NodeHelper$showAppFabView$2(nodeHelper$showAppFabView$1));
            AppMetadataKt.runOnAppMode$default(this, null, NodeHelper$showAppFabView$3.INSTANCE, null, new NodeHelper$showAppFabView$4(fabVerticalMenuLayout, resources, appNodePresenter, appNodeViewModel, activity), 5, null);
            contentView.addView(fabVerticalMenuLayout2, new FrameLayout.LayoutParams(-1, -1));
            fabVerticalMenuLayout.post(new NodeHelper$showAppFabView$5(fabVerticalMenuLayout));
            fabVerticalMenuLayout.setOnDismiss(new NodeHelper$showAppFabView$6(fabVerticalMenuLayout));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/node/NodeHelper$NodeDividerRule;", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "()V", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "", "current", "", "next", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodeHelper.kt */
    public static final class NodeDividerRule implements DividerRule {
        @Override // com.coolapk.market.view.cardlist.divider.DividerRule
        public DividerData getDividerData(int i, Object obj, Object obj2) {
            if (i == -1) {
                if (!(obj2 instanceof Entity) || !Intrinsics.areEqual(((Entity) obj2).getEntityTemplate(), "sortSelectCard")) {
                    return DividerData.Companion.getH12DP();
                }
                return DividerData.H8DP;
            } else if (obj2 == null) {
                return DividerData.Companion.getH12DP();
            } else {
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094  */
    public final Pair<String, String> getNodeListApiFirstLastItem(List<? extends Parcelable> list) {
        String str;
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(list, "dataList");
        Iterator<? extends Parcelable> it2 = list.iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable parcelable2 = (Parcelable) it2.next();
            if ((parcelable2 instanceof Entity) && Intrinsics.areEqual(((Entity) parcelable2).getEntityTemplate(), "sortSelectCard")) {
                break;
            }
            i++;
        }
        String str2 = null;
        if (i < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list.subList(i + 1, list.size())) {
            T t2 = t;
            if ((t2 instanceof Entity) && (!(t2 instanceof Feed) || t2.getIsStickTop() == 0)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        Parcelable parcelable3 = (Parcelable) CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        if (parcelable3 != null) {
            if (!(parcelable3 instanceof Entity)) {
                parcelable3 = null;
            }
            Entity entity = (Entity) parcelable3;
            if (entity != null) {
                str = entity.getEntityId();
                parcelable = (Parcelable) CollectionsKt.lastOrNull((List<? extends Object>) arrayList2);
                if (parcelable != null) {
                    if (!(parcelable instanceof Entity)) {
                        parcelable = null;
                    }
                    Entity entity2 = (Entity) parcelable;
                    if (entity2 != null) {
                        str2 = entity2.getEntityId();
                    }
                }
                return TuplesKt.to(str, str2);
            }
        }
        str = null;
        parcelable = (Parcelable) CollectionsKt.lastOrNull((List<? extends Object>) arrayList2);
        if (parcelable != null) {
        }
        return TuplesKt.to(str, str2);
    }
}
