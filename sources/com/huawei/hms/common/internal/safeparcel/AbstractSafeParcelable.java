package com.huawei.hms.common.internal.safeparcel;

import com.huawei.hms.support.api.client.Result;

public abstract class AbstractSafeParcelable extends Result implements SafeParcelable {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }
}
