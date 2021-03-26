package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class BaseMediaObject implements Parcelable {
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final int MEDIA_TYPE_MULITI_IMAGE = 6;
    public static final int MEDIA_TYPE_SOURCE_VIDEO = 7;
    public static final int MEDIA_TYPE_TEXT = 1;
    public static final int MEDIA_TYPE_WEBPAGE = 5;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract int getObjType();

    protected abstract BaseMediaObject toExtraMediaObject(String str);

    protected abstract String toExtraMediaString();

    public BaseMediaObject() {
    }

    public BaseMediaObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037 A[SYNTHETIC, Splitter:B:20:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public final void setThumbImage(Bitmap bitmap) {
        Throwable th;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                this.thumbData = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    e.printStackTrace();
                    LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
                    if (byteArrayOutputStream == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
            if (byteArrayOutputStream == null) {
                byteArrayOutputStream.close();
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }

    protected boolean checkArgs() {
        String str = this.actionUrl;
        if (str == null || str.length() > 512) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
            return false;
        }
        String str2 = this.identify;
        if (str2 == null || str2.length() > 512) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
            return false;
        }
        byte[] bArr = this.thumbData;
        if (bArr == null || bArr.length > 32768) {
            StringBuilder sb = new StringBuilder();
            sb.append("checkArgs fail, thumbData is invalid,size is ");
            byte[] bArr2 = this.thumbData;
            sb.append(bArr2 != null ? bArr2.length : -1);
            sb.append("! more then 32768.");
            LogUtil.e("Weibo.BaseMediaObject", sb.toString());
            return false;
        }
        String str3 = this.title;
        if (str3 == null || str3.length() > 512) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
            return false;
        }
        String str4 = this.description;
        if (str4 != null && str4.length() <= 1024) {
            return true;
        }
        LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
        return false;
    }
}
