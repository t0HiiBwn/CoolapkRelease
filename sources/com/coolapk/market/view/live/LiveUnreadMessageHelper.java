package com.coolapk.market.view.live;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.EntityDataFilter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/live/LiveUnreadMessageHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "viewGroup", "Landroid/widget/FrameLayout;", "callback", "Lcom/coolapk/market/view/live/LiveUnreadMessageHelper$Callback;", "(Landroid/widget/FrameLayout;Lcom/coolapk/market/view/live/LiveUnreadMessageHelper$Callback;)V", "getCallback", "()Lcom/coolapk/market/view/live/LiveUnreadMessageHelper$Callback;", "firstInit", "", "floatView", "Landroid/view/View;", "newMessageText", "Landroid/widget/TextView;", "getViewGroup", "()Landroid/widget/FrameLayout;", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "onLiveMessageCardLoaded", "", "entity", "Callback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveUnreadMessageHelper.kt */
public final class LiveUnreadMessageHelper extends EntityDataFilter {
    private final Callback callback;
    private boolean firstInit;
    private View floatView;
    private TextView newMessageText;
    private final FrameLayout viewGroup;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/live/LiveUnreadMessageHelper$Callback;", "", "onFloatViewClick", "", "view", "Landroid/view/View;", "num", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveUnreadMessageHelper.kt */
    public interface Callback {
        void onFloatViewClick(View view, int i);
    }

    public LiveUnreadMessageHelper(FrameLayout frameLayout, Callback callback2) {
        Intrinsics.checkNotNullParameter(frameLayout, "viewGroup");
        this.viewGroup = frameLayout;
        this.callback = callback2;
        this.firstInit = true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveUnreadMessageHelper(FrameLayout frameLayout, Callback callback2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(frameLayout, (i & 2) != 0 ? null : callback2);
    }

    public static final /* synthetic */ View access$getFloatView$p(LiveUnreadMessageHelper liveUnreadMessageHelper) {
        View view = liveUnreadMessageHelper.floatView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatView");
        }
        return view;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final FrameLayout getViewGroup() {
        return this.viewGroup;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
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
            if (Intrinsics.areEqual(((Entity) obj).getEntityType(), "messageUnRead")) {
                break;
            }
        }
        if (obj == null) {
            return list;
        }
        Entity entity = (Entity) obj;
        onLiveMessageCardLoaded(entity);
        return removeData$presentation_coolapkAppRelease(list, entity);
    }

    private final void onLiveMessageCardLoaded(Entity entity) {
        String title = entity.getTitle();
        Intrinsics.checkNotNull(title);
        Intrinsics.checkNotNullExpressionValue(title, "entity.title!!");
        int parseInt = Integer.parseInt(title);
        if (this.firstInit) {
            this.firstInit = false;
            View inflate = LayoutInflater.from(this.viewGroup.getContext()).inflate(2131559010, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(view…_float_new_message, null)");
            this.floatView = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatView");
            }
            inflate.setElevation((float) NumberExtendsKt.getDp((Number) 2));
            View view = this.floatView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatView");
            }
            view.setVisibility(8);
            View view2 = this.floatView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatView");
            }
            View findViewById = view2.findViewById(2131363013);
            Intrinsics.checkNotNullExpressionValue(findViewById, "floatView.findViewById(R.id.new_message_view)");
            TextView textView = (TextView) findViewById;
            this.newMessageText = textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newMessageText");
            }
            textView.setTextColor(AppHolder.getAppTheme().getColorAccent());
            FrameLayout frameLayout = this.viewGroup;
            View view3 = this.floatView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatView");
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 5;
            layoutParams.topMargin = NumberExtendsKt.getDp((Number) 8);
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(view3, layoutParams);
        }
        View view4 = this.floatView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatView");
        }
        view4.setOnClickListener(new LiveUnreadMessageHelper$onLiveMessageCardLoaded$2(this, parseInt));
        if (parseInt > 0) {
            View view5 = this.floatView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatView");
            }
            view5.setVisibility(0);
        } else {
            View view6 = this.floatView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatView");
            }
            view6.setVisibility(8);
        }
        String str = parseInt + " 与我相关";
        TextView textView2 = this.newMessageText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newMessageText");
        }
        textView2.setText(str);
    }
}
