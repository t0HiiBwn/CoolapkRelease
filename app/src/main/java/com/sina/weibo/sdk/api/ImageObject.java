package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageObject extends BaseMediaObject {
    public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator<ImageObject>() {
        /* class com.sina.weibo.sdk.api.ImageObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    };
    private static final int DATA_SIZE = 2097152;
    public byte[] imageData;
    public String imagePath;

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public int getObjType() {
        return 2;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    protected BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    protected String toExtraMediaString() {
        return "";
    }

    public ImageObject() {
    }

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037 A[SYNTHETIC, Splitter:B:20:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public final void setImageObject(Bitmap bitmap) {
        Throwable th;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                this.imageData = byteArrayOutputStream2.toByteArray();
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
                    LogUtil.e("Weibo.ImageObject", "put thumb failed");
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
            LogUtil.e("Weibo.ImageObject", "put thumb failed");
            if (byteArrayOutputStream == null) {
                byteArrayOutputStream.close();
            }
        }
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public boolean checkArgs() {
        byte[] bArr = this.imageData;
        if (bArr == null && this.imagePath == null) {
            LogUtil.e("Weibo.ImageObject", "imageData and imagePath are null");
            return false;
        } else if (bArr == null || bArr.length <= 2097152) {
            String str = this.imagePath;
            if (str != null && str.length() > 512) {
                LogUtil.e("Weibo.ImageObject", "imagePath is too length");
                return false;
            } else if (this.imagePath == null) {
                return true;
            } else {
                File file = new File(this.imagePath);
                try {
                    if (file.exists() && file.length() != 0 && file.length() <= 10485760) {
                        return true;
                    }
                    LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                    return false;
                } catch (SecurityException unused) {
                    LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                    return false;
                }
            }
        } else {
            LogUtil.e("Weibo.ImageObject", "imageData is too large");
            return false;
        }
    }
}
