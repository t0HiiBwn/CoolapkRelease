package com.coolapk.market.view.sharev8;

import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: ShareListActivity.kt */
final /* synthetic */ class ShareListActivity$initView$1 extends MutablePropertyReference0Impl {
    ShareListActivity$initView$1(ShareListActivity shareListActivity) {
        super(shareListActivity, ShareListActivity.class, "entity", "getEntity()Lcom/coolapk/market/model/Entity;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ShareListActivity.access$getEntity$p((ShareListActivity) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((ShareListActivity) this.receiver).entity = (Entity) obj;
    }
}
