package com.coolapk.market.view.cardlist;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.widget.view.HorizonExpandedCircle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0006\u0010\u0018\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityRefreshCardHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "dismissActionMap", "", "Lcom/coolapk/market/model/Entity;", "Ljava/lang/Runnable;", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "toastDismissAction", "toastView", "Landroid/view/View;", "modifyData", "", "list", "isRefresh", "", "removeAllCallback", "", "removeDismissCallback", "entity", "removeToastAction", "requestFragmentScrollToTop", "setDismissCallback", "setupToastAction", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityRefreshCardHelper.kt */
public final class EntityRefreshCardHelper extends EntityDataFilter {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558900;
    private Map<Entity, Runnable> dismissActionMap = new LinkedHashMap();
    private final EntityListFragment fragment;
    private Runnable toastDismissAction;
    private View toastView;

    public EntityRefreshCardHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
        Lifecycle lifecycle = entityListFragment.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "fragment.lifecycle");
        LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new Function0<Unit>(this) {
            /* class com.coolapk.market.view.cardlist.EntityRefreshCardHelper.AnonymousClass1 */
            final /* synthetic */ EntityRefreshCardHelper this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                this.this$0.removeAllCallback();
            }
        });
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityRefreshCardHelper$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EntityRefreshCardHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void removeAllCallback() {
        for (Runnable runnable : this.dismissActionMap.values()) {
            this.fragment.getRecyclerView().removeCallbacks(runnable);
        }
        this.dismissActionMap.clear();
        removeToastAction();
    }

    public final void removeDismissCallback(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Runnable runnable = this.dismissActionMap.get(entity);
        if (runnable != null) {
            this.fragment.getRecyclerView().removeCallbacks(runnable);
            this.dismissActionMap.remove(entity);
        }
    }

    public final void setDismissCallback(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        int intExtraData = EntityExtendsKt.getIntExtraData(entity, "delayTime", 0);
        if (intExtraData > 0) {
            EntityRefreshCardHelper$setDismissCallback$dismissAction$1 entityRefreshCardHelper$setDismissCallback$dismissAction$1 = new EntityRefreshCardHelper$setDismissCallback$dismissAction$1(this, this.fragment.getDataList(), entity);
            this.fragment.getRecyclerView().postDelayed(entityRefreshCardHelper$setDismissCallback$dismissAction$1, ((long) intExtraData) * 1000);
            this.dismissActionMap.put(entity, entityRefreshCardHelper$setDismissCallback$dismissAction$1);
        }
    }

    public final void requestFragmentScrollToTop() {
        if (this.fragment.isVisible()) {
            this.fragment.scrollToTop(true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            Entity entity = (Entity) obj;
            boolean z2 = false;
            if (Intrinsics.areEqual(entity.getEntityTemplate(), "refreshCard") && EntityExtendsKt.getIntExtraData(entity, "showToast", 0) > 0) {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (obj == null) {
            return list;
        }
        Entity entity2 = (Entity) obj;
        this.fragment.getRecyclerView().post(new EntityRefreshCardHelper$modifyData$1(this, entity2, z));
        if (list instanceof ArrayList) {
            ((ArrayList) list).remove(entity2);
            return list;
        }
        List<Entity> mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.remove(entity2);
        return mutableList;
    }

    /* access modifiers changed from: private */
    public final void removeToastAction() {
        View view = this.toastView;
        if (view != null) {
            ViewExtendsKt.detachFromParent(view);
            this.toastView = null;
        }
        Runnable runnable = this.toastDismissAction;
        if (runnable != null) {
            View view2 = this.fragment.getView();
            if (view2 != null) {
                view2.removeCallbacks(runnable);
            }
            this.toastDismissAction = null;
        }
    }

    /* access modifiers changed from: private */
    public final void setupToastAction(Entity entity, boolean z) {
        int i;
        int i2;
        View view = this.fragment.getView();
        if (!(view instanceof FrameLayout)) {
            view = null;
        }
        FrameLayout frameLayout = (FrameLayout) view;
        if (frameLayout != null) {
            long intExtraData = ((long) EntityExtendsKt.getIntExtraData(entity, "showToast", 0)) * 1000;
            if (z) {
                i = ConvertUtils.dp2px(22.0f);
                i2 = -ConvertUtils.dp2px(24.0f);
            } else {
                i = frameLayout.getHeight() - ConvertUtils.dp2px(128.0f);
                i2 = ConvertUtils.dp2px(24.0f);
            }
            LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
            linearLayout.setOrientation(0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = ConvertUtils.dp2px(16.0f);
            layoutParams.leftMargin = ConvertUtils.dp2px(16.0f);
            layoutParams.gravity = 1;
            Unit unit = Unit.INSTANCE;
            linearLayout.setLayoutParams(layoutParams);
            float f = (float) i;
            linearLayout.setY(((float) i2) + f);
            linearLayout.setAlpha(0.0f);
            linearLayout.setClipToPadding(false);
            linearLayout.setClipChildren(false);
            linearLayout.setClipToOutline(false);
            int dp2px = DisplayUtils.dp2px(null, 4.0f);
            linearLayout.setPadding(dp2px, dp2px, dp2px, dp2px);
            TextView textView = new TextView(linearLayout.getContext());
            textView.setTextColor(-1);
            textView.setText(entity.getTitle());
            textView.setTextSize(14.0f);
            textView.setPadding(ConvertUtils.dp2px(16.0f), ConvertUtils.dp2px(8.0f), ConvertUtils.dp2px(16.0f), ConvertUtils.dp2px(8.0f));
            textView.setBackground(new HorizonExpandedCircle());
            textView.setZ((float) ConvertUtils.dp2px(2.0f));
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            LinearLayout linearLayout2 = linearLayout;
            frameLayout.addView(linearLayout2);
            linearLayout.animate().setDuration(300).alpha(1.0f).y(f).start();
            this.toastView = linearLayout2;
            EntityRefreshCardHelper$setupToastAction$1 entityRefreshCardHelper$setupToastAction$1 = new EntityRefreshCardHelper$setupToastAction$1(this, linearLayout);
            this.toastDismissAction = entityRefreshCardHelper$setupToastAction$1;
            frameLayout.postDelayed(entityRefreshCardHelper$setupToastAction$1, intExtraData);
        }
    }
}
