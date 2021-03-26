package com.coolapk.market.view.photo;

import android.view.LayoutInflater;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.SplashViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/databinding/SplashViewBinding;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SplashView.kt */
final class SplashView$binding$2 extends Lambda implements Function0<SplashViewBinding> {
    final /* synthetic */ SplashView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SplashView$binding$2(SplashView splashView) {
        super(0);
        this.this$0 = splashView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SplashViewBinding invoke() {
        return (SplashViewBinding) DataBindingUtil.inflate(LayoutInflater.from(this.this$0.getActivity()), 2131559146, this.this$0, true);
    }
}
