package com.coolapk.market.view.userv9;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
final /* synthetic */ class UserSpaceV9Activity$onCreate$1 extends MutablePropertyReference0Impl {
    UserSpaceV9Activity$onCreate$1(UserSpaceV9Activity userSpaceV9Activity) {
        super(userSpaceV9Activity, UserSpaceV9Activity.class, "tabHelper", "getTabHelper()Lcom/coolapk/market/view/userv9/UserSpaceV9TabHelper;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return UserSpaceV9Activity.access$getTabHelper$p((UserSpaceV9Activity) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((UserSpaceV9Activity) this.receiver).tabHelper = (UserSpaceV9TabHelper) obj;
    }
}
