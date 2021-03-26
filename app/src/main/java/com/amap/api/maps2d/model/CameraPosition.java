package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore2d.cl;
import com.amap.api.mapcore2d.cm;

public final class CameraPosition implements Parcelable {
    public static final b CREATOR = new b();
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        if (latLng == null) {
            Log.w("CameraPosition", "构建CameraPosition时,位置(target)不能为null");
        }
        this.target = latLng;
        this.zoom = cm.b(f);
        this.tilt = cm.a(f2);
        this.bearing = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        if (latLng != null) {
            this.isAbroad = !cl.a(latLng.latitude, latLng.longitude);
        } else {
            this.isAbroad = false;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.bearing);
        LatLng latLng = this.target;
        if (latLng != null) {
            parcel.writeFloat((float) latLng.latitude);
            parcel.writeFloat((float) this.target.longitude);
        }
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return super.hashCode();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public String toString() {
        return cm.a(cm.a("target", this.target), cm.a("zoom", Float.valueOf(this.zoom)), cm.a("tilt", Float.valueOf(this.tilt)), cm.a("bearing", Float.valueOf(this.bearing)));
    }

    public static final class Builder {
        private LatLng a;
        private float b;
        private float c;
        private float d;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }

        public Builder target(LatLng latLng) {
            this.a = latLng;
            return this;
        }

        public Builder zoom(float f) {
            this.b = f;
            return this;
        }

        public Builder tilt(float f) {
            this.c = f;
            return this;
        }

        public Builder bearing(float f) {
            this.d = f;
            return this;
        }

        public CameraPosition build() {
            try {
                if (this.a != null) {
                    return new CameraPosition(this.a, this.b, this.c, this.d);
                }
                Log.w("CameraPosition", "target is null");
                return null;
            } catch (Throwable th) {
                cm.a(th, "CameraPosition", "build");
                return null;
            }
        }
    }
}
