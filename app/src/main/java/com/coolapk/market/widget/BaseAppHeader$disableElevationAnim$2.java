package com.coolapk.market.widget;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/animation/StateListAnimator;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseAppHeader.kt */
final class BaseAppHeader$disableElevationAnim$2 extends Lambda implements Function0<StateListAnimator> {
    final /* synthetic */ BaseAppHeader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseAppHeader$disableElevationAnim$2(BaseAppHeader baseAppHeader) {
        super(0);
        this.this$0 = baseAppHeader;
    }

    @Override // kotlin.jvm.functions.Function0
    public final StateListAnimator invoke() {
        return AnimatorInflater.loadStateListAnimator(this.this$0.getContext(), 2130837510);
    }
}
