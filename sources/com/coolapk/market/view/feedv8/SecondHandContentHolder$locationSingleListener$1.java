package com.coolapk.market.view.feedv8;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.coolapk.market.model.LocationInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/amap/api/location/AMapLocation;", "kotlin.jvm.PlatformType", "onLocationChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: SecondHandContentHolder.kt */
final class SecondHandContentHolder$locationSingleListener$1 implements AMapLocationListener {
    final /* synthetic */ SecondHandContentHolder this$0;

    SecondHandContentHolder$locationSingleListener$1(SecondHandContentHolder secondHandContentHolder) {
        this.this$0 = secondHandContentHolder;
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            LocationInfo build = LocationInfo.newBuilder().setLongitude(Double.valueOf(aMapLocation.getLongitude())).setLatitude(Double.valueOf(aMapLocation.getLatitude())).setCity(aMapLocation.getCity()).setSnippet("").setBusinessArea("").setCountry(aMapLocation.getCountry()).setProvince(aMapLocation.getProvince()).setCityCode(aMapLocation.getCityCode()).setAdCode(aMapLocation.getAdCode()).setDistrict(aMapLocation.getDistrict()).setLongAddress(aMapLocation.getAddress()).setAddress(aMapLocation.getAddress()).setIsHideLocation(false).setIsChecked(false).setEntityType("location").setFeedType("ershou").build();
            SubmitSecondHandExtraViewPart extraView = this.this$0.getExtraView();
            Intrinsics.checkNotNullExpressionValue(build, "info");
            extraView.initLocation(build);
        }
    }
}
