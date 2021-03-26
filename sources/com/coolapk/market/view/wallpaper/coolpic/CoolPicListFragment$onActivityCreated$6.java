package com.coolapk.market.view.wallpaper.coolpic;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.event.CoolPicScrollEvent;
import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicListFragment$onActivityCreated$6", "Lcom/coolapk/market/view/wallpaper/coolpic/OnViewPagerListener;", "onInitComplete", "", "onPageRelease", "isNext", "", "position", "", "onPageSelected", "isBottom", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicListFragment.kt */
public final class CoolPicListFragment$onActivityCreated$6 implements OnViewPagerListener {
    final /* synthetic */ CoolPicListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CoolPicListFragment$onActivityCreated$6(CoolPicListFragment coolPicListFragment) {
        this.this$0 = coolPicListFragment;
    }

    @Override // com.coolapk.market.view.wallpaper.coolpic.OnViewPagerListener
    public void onInitComplete() {
        this.this$0.itemIndex = 0;
        CoolPicListFragment coolPicListFragment = this.this$0;
        Object obj = coolPicListFragment.dataList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "dataList[0]");
        String id = ((Entity) obj).getId();
        Intrinsics.checkNotNull(id);
        coolPicListFragment.setCurrentId(id);
    }

    @Override // com.coolapk.market.view.wallpaper.coolpic.OnViewPagerListener
    public void onPageSelected(int i, boolean z) {
        this.this$0.setIndex(0);
        this.this$0.itemIndex = i;
        this.this$0.showTip();
        this.this$0.setDetachedInCurrentView(false);
        CoolPicListFragment coolPicListFragment = this.this$0;
        Object obj = coolPicListFragment.dataList.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "dataList[position]");
        String id = ((Entity) obj).getId();
        Intrinsics.checkNotNull(id);
        coolPicListFragment.setCurrentId(id);
        CoolPicListFragment.access$getAdapter$p(this.this$0).getItem(i);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity instanceof CoolPicDetailActivity) {
            ((CoolPicDetailActivity) activity).setDonotCompress(false);
        }
    }

    @Override // com.coolapk.market.view.wallpaper.coolpic.OnViewPagerListener
    public void onPageRelease(boolean z, int i) {
        if (z) {
            CoolPicListFragment coolPicListFragment = this.this$0;
            coolPicListFragment.setListIndex(coolPicListFragment.getListIndex() + 1);
            coolPicListFragment.getListIndex();
        } else {
            CoolPicListFragment coolPicListFragment2 = this.this$0;
            coolPicListFragment2.setListIndex(coolPicListFragment2.getListIndex() - 1);
            coolPicListFragment2.getListIndex();
        }
        EventBus.getDefault().post(new CoolPicScrollEvent(this.this$0.getListIndex()));
    }
}
