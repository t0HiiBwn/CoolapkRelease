package com.coolapk.market.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.coolapk.market.AppHolder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class SaveInstanceHelper {
    public static final String DEFAULT_NAME = "SaveInstanceHelper";
    private static final String KEY_STORED_BUNDLE_ID = "net.cattaka.android.snippets.issue.SaveInstanceHelper.KEY_STORED_BUNDLE_ID";
    private static SaveInstanceHelper sInstance;
    private File mDirForStoredBundle;
    private String mName;
    private SharedPreferences mPreferences;

    public static SaveInstanceHelper getsInstance() {
        if (sInstance == null) {
            sInstance = new SaveInstanceHelper(AppHolder.getApplication(), "save_instance_cache");
        }
        return sInstance;
    }

    public SaveInstanceHelper(Context context, String str) {
        this.mName = str;
        initialize(context);
    }

    private void initialize(Context context) {
        this.mPreferences = context.getSharedPreferences(this.mName, 0);
        File file = new File(context.getCacheDir(), this.mName);
        this.mDirForStoredBundle = file;
        if (!file.exists()) {
            this.mDirForStoredBundle.mkdirs();
        }
        long j = this.mPreferences.getLong("lastStoredBundleId", 1);
        clearDirForStoredBundle();
        this.mPreferences.edit().putLong("lastStoredBundleId", j).apply();
    }

    public void restoreSaveInstanceState(Bundle bundle, boolean z) {
        if (Build.VERSION.SDK_INT >= 23 && bundle != null && bundle.containsKey("net.cattaka.android.snippets.issue.SaveInstanceHelper.KEY_STORED_BUNDLE_ID")) {
            long j = bundle.getLong("net.cattaka.android.snippets.issue.SaveInstanceHelper.KEY_STORED_BUNDLE_ID");
            File file = this.mDirForStoredBundle;
            File file2 = new File(file, j + ".bin");
            Bundle loadBundle = loadBundle(file2);
            if (loadBundle != null) {
                bundle.putAll(loadBundle);
            }
            if (z && file2.exists()) {
                file2.delete();
            }
        }
    }

    public void saveInstanceState(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 23 && bundle != null) {
            long j = this.mPreferences.getLong("lastStoredBundleId", 1) + 1;
            this.mPreferences.edit().putLong("lastStoredBundleId", j).apply();
            File file = this.mDirForStoredBundle;
            saveBundle(bundle, new File(file, j + ".bin"));
            bundle.clear();
            bundle.putLong("net.cattaka.android.snippets.issue.SaveInstanceHelper.KEY_STORED_BUNDLE_ID", j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[SYNTHETIC, Splitter:B:13:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    private void saveBundle(Bundle bundle, File file) {
        Throwable th;
        byte[] marshall = marshall(bundle);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            try {
                gZIPOutputStream2.write(marshall);
                gZIPOutputStream2.flush();
                gZIPOutputStream2.close();
                try {
                    gZIPOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            if (gZIPOutputStream == null) {
                gZIPOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (gZIPOutputStream != null) {
                try {
                    gZIPOutputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[SYNTHETIC, Splitter:B:17:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c A[SYNTHETIC, Splitter:B:24:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0042 A[SYNTHETIC, Splitter:B:29:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    private Bundle loadBundle(File file) {
        byte[] bArr;
        GZIPInputStream gZIPInputStream;
        Throwable th;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(new FileInputStream(file));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read <= -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    gZIPInputStream.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                if (gZIPInputStream != null) {
                }
                bArr = null;
                if (bArr == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            gZIPInputStream = null;
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException unused4) {
                }
            }
            bArr = null;
            if (bArr == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
        if (bArr == null) {
            return null;
        }
        try {
            return (Bundle) unmarshall(bArr);
        } catch (Exception unused6) {
            return null;
        }
    }

    private void clearDirForStoredBundle() {
        File[] listFiles = this.mDirForStoredBundle.listFiles();
        for (File file : listFiles) {
            if (file.isFile() && file.getName().endsWith(".bin")) {
                file.delete();
            }
        }
    }

    private static <T extends Parcelable> byte[] marshall(T t) {
        Parcel obtain = Parcel.obtain();
        obtain.writeValue(t);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    private static <T extends Parcelable> T unmarshall(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T t = (T) ((Parcelable) obtain.readValue(SaveInstanceHelper.class.getClassLoader()));
        obtain.recycle();
        return t;
    }
}
