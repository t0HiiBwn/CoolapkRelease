package com.coolapk.market.view.node.app;

import android.widget.RatingBar;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.RxLogin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "ratingBar", "Landroid/widget/RatingBar;", "kotlin.jvm.PlatformType", "rating", "", "fromUser", "", "onRatingChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppRatingDialog.kt */
final class AppRatingDialog$onCreateDialog$1 implements RatingBar.OnRatingBarChangeListener {
    final /* synthetic */ AppRatingDialog this$0;

    AppRatingDialog$onCreateDialog$1(AppRatingDialog appRatingDialog) {
        this.this$0 = appRatingDialog;
    }

    @Override // android.widget.RatingBar.OnRatingBarChangeListener
    public final void onRatingChanged(RatingBar ratingBar, final float f, boolean z) {
        if (z) {
            RxLogin.getInstance(this.this$0.getActivity()).requestLogin().subscribe(new Action1<Boolean>(this) {
                /* class com.coolapk.market.view.node.app.AppRatingDialog$onCreateDialog$1.AnonymousClass1 */
                final /* synthetic */ AppRatingDialog$onCreateDialog$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(Boolean bool) {
                    Intrinsics.checkNotNullExpressionValue(bool, "isLogin");
                    if (bool.booleanValue()) {
                        ServiceApp serviceApp = this.this$0.this$0.getViewModel().getServiceApp().get();
                        Intrinsics.checkNotNull(serviceApp);
                        Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get()!!");
                        ServiceApp serviceApp2 = serviceApp;
                        int i = (int) f;
                        int i2 = this.this$0.this$0.getViewModel().getMyScore().get();
                        if (i > 0) {
                            this.this$0.this$0.getPresenter().ratingApp(serviceApp2.getApkId(), i, i2);
                        } else {
                            this.this$0.this$0.getPresenter().unratingApp(serviceApp2.getApkId(), i2);
                        }
                        this.this$0.this$0.getViewModel().getMyScore().set(i);
                    }
                }
            });
        }
    }
}
