package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.core.aidl.IMessageEntity;

public class Scope implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<Scope> CREATOR = new Parcelable.Creator<Scope>() {
        /* class com.huawei.hms.support.api.entity.auth.Scope.AnonymousClass1 */

        /* renamed from: a */
        public Scope createFromParcel(Parcel parcel) {
            return new Scope(parcel);
        }

        /* renamed from: a */
        public Scope[] newArray(int i) {
            return new Scope[i];
        }
    };
    private String mScopeUri;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Scope() {
        this.mScopeUri = null;
    }

    public Scope(String str) {
        this.mScopeUri = str;
    }

    protected Scope(Parcel parcel) {
        this.mScopeUri = parcel.readString();
    }

    public String getScopeUri() {
        return this.mScopeUri;
    }

    @Deprecated
    public boolean equeals(Object obj) {
        return equals(obj);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return Objects.equal(this.mScopeUri, ((Scope) obj).mScopeUri);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        String str = this.mScopeUri;
        return str == null ? super.hashCode() : str.hashCode();
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.mScopeUri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mScopeUri);
    }
}
