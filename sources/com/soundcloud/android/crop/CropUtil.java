package com.soundcloud.android.crop;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.soundcloud.android.crop.MonitoredActivity;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class CropUtil {
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_FILE = "file";

    CropUtil() {
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int getExifRotation(File file) {
        if (file == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            Log.e("Error getting Exif data", e);
            return 0;
        }
    }

    public static boolean copyExifRotation(File file, File file2) {
        if (!(file == null || file2 == null)) {
            try {
                ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
                ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
                exifInterface2.setAttribute("Orientation", exifInterface.getAttribute("Orientation"));
                exifInterface2.saveAttributes();
                return true;
            } catch (IOException e) {
                Log.e("Error copying Exif data", e);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        if (r3 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0079, code lost:
        if (r3 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
        r3.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    public static File getFromMediaUri(Context context, ContentResolver contentResolver, Uri uri) {
        Throwable th;
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        if (uri == null) {
            return null;
        }
        if ("file".equals(uri.getScheme())) {
            return new File(uri.getPath());
        }
        if ("content".equals(uri.getScheme())) {
            try {
                cursor = contentResolver.query(uri, new String[]{"_data", "_display_name"}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            if (uri.toString().startsWith("content://com.google.android.gallery3d")) {
                                i = cursor.getColumnIndex("_display_name");
                            } else {
                                i = cursor.getColumnIndex("_data");
                            }
                            if (i != -1) {
                                String string = cursor.getString(i);
                                if (!TextUtils.isEmpty(string)) {
                                    File file = new File(string);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return file;
                                }
                            }
                        }
                    } catch (IllegalArgumentException unused) {
                        cursor2 = cursor;
                        try {
                            File fromMediaUriPfd = getFromMediaUriPfd(context, contentResolver, uri);
                            if (cursor2 != null) {
                            }
                            return fromMediaUriPfd;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (SecurityException unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (IllegalArgumentException unused3) {
                File fromMediaUriPfd = getFromMediaUriPfd(context, contentResolver, uri);
                if (cursor2 != null) {
                    cursor2.close();
                }
                return fromMediaUriPfd;
            } catch (SecurityException unused4) {
                cursor = null;
            }
        }
        return null;
    }

    private static String getTempFilename(Context context) throws IOException {
        return File.createTempFile("image", "tmp", context.getCacheDir()).getAbsolutePath();
    }

    private static File getFromMediaUriPfd(Context context, ContentResolver contentResolver, Uri uri) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        String tempFilename;
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(contentResolver.openFileDescriptor(uri, "r").getFileDescriptor());
            try {
                tempFilename = getTempFilename(context);
                fileOutputStream = new FileOutputStream(tempFilename);
            } catch (IOException unused) {
                fileOutputStream = null;
                closeSilently(fileInputStream);
                closeSilently(fileOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                closeSilently(fileInputStream2);
                closeSilently(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        File file = new File(tempFilename);
                        closeSilently(fileInputStream);
                        closeSilently(fileOutputStream);
                        return file;
                    }
                }
            } catch (IOException unused2) {
                closeSilently(fileInputStream);
                closeSilently(fileOutputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                closeSilently(fileInputStream2);
                closeSilently(fileOutputStream);
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
            closeSilently(fileInputStream);
            closeSilently(fileOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            closeSilently(fileInputStream2);
            closeSilently(fileOutputStream);
            throw th;
        }
    }

    public static void startBackgroundJob(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new BackgroundJob(monitoredActivity, runnable, ProgressDialog.show(monitoredActivity, str, str2, true, false), handler)).start();
    }

    private static class BackgroundJob extends MonitoredActivity.LifeCycleAdapter implements Runnable {
        private final MonitoredActivity activity;
        private final Runnable cleanupRunner = new Runnable() {
            /* class com.soundcloud.android.crop.CropUtil.BackgroundJob.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                BackgroundJob.this.activity.removeLifeCycleListener(BackgroundJob.this);
                if (BackgroundJob.this.dialog.getWindow() != null) {
                    BackgroundJob.this.dialog.dismiss();
                }
            }
        };
        private final ProgressDialog dialog;
        private final Handler handler;
        private final Runnable job;

        public BackgroundJob(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler2) {
            this.activity = monitoredActivity;
            this.dialog = progressDialog;
            this.job = runnable;
            monitoredActivity.addLifeCycleListener(this);
            this.handler = handler2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.job.run();
            } finally {
                this.handler.post(this.cleanupRunner);
            }
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleAdapter, com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityDestroyed(MonitoredActivity monitoredActivity) {
            this.cleanupRunner.run();
            this.handler.removeCallbacks(this.cleanupRunner);
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleAdapter, com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStopped(MonitoredActivity monitoredActivity) {
            this.dialog.hide();
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleAdapter, com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStarted(MonitoredActivity monitoredActivity) {
            this.dialog.show();
        }
    }
}
