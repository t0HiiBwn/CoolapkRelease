package com.coolapk.market.manager;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.MainInitEvent;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.LogUtils;
import java.util.List;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/manager/MainInitHelper$updateMainInitInfo$3", "Lcom/coolapk/market/app/EmptySubscriber;", "", "Lcom/coolapk/market/model/Entity;", "onNext", "", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainInitHelper.kt */
public final class MainInitHelper$updateMainInitInfo$3 extends EmptySubscriber<List<? extends Entity>> {
    MainInitHelper$updateMainInitInfo$3() {
    }

    public void onNext(List<? extends Entity> list) {
        super.onNext((MainInitHelper$updateMainInitInfo$3) list);
        if (list != null) {
            MainInitHelper.INSTANCE.onMainInitDataLoaded(list);
            MainInitHelper mainInitHelper = MainInitHelper.INSTANCE;
            MainInitHelper.isDataLoaded = true;
            LogUtils.d("配置文件加载完毕", new Object[0]);
            EventBus.getDefault().post(new MainInitEvent());
        }
    }
}
