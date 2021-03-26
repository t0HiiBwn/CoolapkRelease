package com.coolapk.market.view.feedv8;

import android.net.Uri;
import com.coolapk.market.model.ImageUrl;
import rx.functions.Func1;

/* renamed from: com.coolapk.market.view.feedv8.-$$Lambda$PickPhotoAdapterV8$6iYLc_dp7PBMmMoWLDAhFm1fY1E  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$PickPhotoAdapterV8$6iYLc_dp7PBMmMoWLDAhFm1fY1E implements Func1 {
    public static final /* synthetic */ $$Lambda$PickPhotoAdapterV8$6iYLc_dp7PBMmMoWLDAhFm1fY1E INSTANCE = new $$Lambda$PickPhotoAdapterV8$6iYLc_dp7PBMmMoWLDAhFm1fY1E();

    private /* synthetic */ $$Lambda$PickPhotoAdapterV8$6iYLc_dp7PBMmMoWLDAhFm1fY1E() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return Uri.parse(((ImageUrl) obj).getSourceUrl()).getPath();
    }
}
