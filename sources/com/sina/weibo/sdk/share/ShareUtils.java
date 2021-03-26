package com.sina.weibo.sdk.share;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public final class ShareUtils {
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0111 A[Catch:{ Exception -> 0x0139, all -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0124 A[Catch:{ Exception -> 0x0134 }, LOOP:0: B:46:0x011d->B:48:0x0124, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0154 A[SYNTHETIC, Splitter:B:71:0x0154] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0159 A[Catch:{ Exception -> 0x015c }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0161 A[SYNTHETIC, Splitter:B:80:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0166 A[Catch:{ Exception -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0129 A[EDGE_INSN: B:86:0x0129->B:49:0x0129 ?: BREAK  , SYNTHETIC] */
    protected static String copyFileToWeiboTem(Context context, Uri uri, int i) {
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Exception e;
        Throwable th2;
        Cursor cursor;
        String str;
        File file;
        byte[] bArr;
        int read;
        Exception e2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            String packageName = WeiboAppManager.queryWbInfoInternal(context).getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = "com.sina.weibo";
            }
            String str2 = "/Android/data/" + packageName + "/files/.composerTem/";
            new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str2).mkdirs();
            Calendar instance = Calendar.getInstance();
            try {
                if (uri.getScheme().equals("file")) {
                    str = instance.getTimeInMillis() + uri.getLastPathSegment();
                    cursor = null;
                } else {
                    cursor = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                str = cursor.getString(cursor.getColumnIndex("_display_name"));
                            }
                        } catch (Exception e3) {
                            e2 = e3;
                            try {
                                Log.v("weibo sdk rename", e2.toString());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                str = null;
                                if (TextUtils.isEmpty(str)) {
                                }
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + str);
                                if (file.exists()) {
                                }
                                fileOutputStream = new FileOutputStream(file);
                                bArr = new byte[1444];
                                while (true) {
                                    read = bufferedInputStream.read(bArr);
                                    if (read == -1) {
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                String path = file.getPath();
                                try {
                                    bufferedInputStream.close();
                                    fileOutputStream.close();
                                } catch (Exception unused) {
                                }
                                return path;
                            } catch (Throwable th3) {
                                th2 = th3;
                                if (cursor != null) {
                                }
                                throw th2;
                            }
                        }
                    }
                    str = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e4) {
                e2 = e4;
                cursor = null;
                Log.v("weibo sdk rename", e2.toString());
                if (cursor != null) {
                }
                str = null;
                if (TextUtils.isEmpty(str)) {
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + str);
                if (file.exists()) {
                }
                fileOutputStream = new FileOutputStream(file);
                bArr = new byte[1444];
                while (true) {
                    read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path = file.getPath();
                bufferedInputStream.close();
                fileOutputStream.close();
                return path;
            } catch (Throwable th4) {
                th2 = th4;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(Calendar.getInstance().getTimeInMillis());
                sb.append(i == 0 ? "_sdk_temp.mp4" : "_sdk_temp.jpg");
                str = sb.toString();
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
            try {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + str);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
                try {
                    LogUtil.e("weibo sdk copy", e.toString());
                    if (bufferedInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                bArr = new byte[1444];
                while (true) {
                    read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path = file.getPath();
                bufferedInputStream.close();
                fileOutputStream.close();
                return path;
            } catch (Exception e6) {
                e = e6;
                LogUtil.e("weibo sdk copy", e.toString());
                if (bufferedInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                return null;
            }
        } catch (Exception e7) {
            e = e7;
            bufferedInputStream = null;
            fileOutputStream = null;
            LogUtil.e("weibo sdk copy", e.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception unused2) {
                    return null;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused3) {
                    throw th;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
