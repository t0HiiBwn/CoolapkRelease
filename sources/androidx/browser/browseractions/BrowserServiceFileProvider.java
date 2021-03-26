package androidx.browser.browseractions;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.FileProvider;
import androidx.core.util.AtomicFile;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Deprecated
public final class BrowserServiceFileProvider extends FileProvider {
    private static final String AUTHORITY_SUFFIX = ".image_provider";
    private static final String CLIP_DATA_LABEL = "image_provider_uris";
    private static final String CONTENT_SCHEME = "content";
    private static final String FILE_EXTENSION = ".png";
    private static final String FILE_SUB_DIR = "image_provider";
    private static final String FILE_SUB_DIR_NAME = "image_provider_images/";
    private static final String LAST_CLEANUP_TIME_KEY = "last_cleanup_time";
    private static final String TAG = "BrowserServiceFP";
    static Object sFileCleanupLock = new Object();

    private static class FileCleanupTask extends AsyncTask<Void, Void, Void> {
        private static final long CLEANUP_REQUIRED_TIME_SPAN = TimeUnit.DAYS.toMillis(7);
        private static final long DELETION_FAILED_REATTEMPT_DURATION = TimeUnit.DAYS.toMillis(1);
        private static final long IMAGE_RETENTION_DURATION = TimeUnit.DAYS.toMillis(7);
        private final Context mAppContext;

        FileCleanupTask(Context context) {
            this.mAppContext = context.getApplicationContext();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            long j;
            SharedPreferences sharedPreferences = this.mAppContext.getSharedPreferences(this.mAppContext.getPackageName() + ".image_provider", 0);
            if (!shouldCleanUp(sharedPreferences)) {
                return null;
            }
            synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
                File file = new File(this.mAppContext.getFilesDir(), "image_provider");
                if (!file.exists()) {
                    return null;
                }
                File[] listFiles = file.listFiles();
                long currentTimeMillis = System.currentTimeMillis() - IMAGE_RETENTION_DURATION;
                boolean z = true;
                for (File file2 : listFiles) {
                    if (isImageFile(file2)) {
                        if (file2.lastModified() < currentTimeMillis && !file2.delete()) {
                            Log.e("BrowserServiceFP", "Fail to delete image: " + file2.getAbsoluteFile());
                            z = false;
                        }
                    }
                }
                if (z) {
                    j = System.currentTimeMillis();
                } else {
                    j = (System.currentTimeMillis() - CLEANUP_REQUIRED_TIME_SPAN) + DELETION_FAILED_REATTEMPT_DURATION;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong("last_cleanup_time", j);
                edit.apply();
                return null;
            }
        }

        private static boolean isImageFile(File file) {
            return file.getName().endsWith("..png");
        }

        private static boolean shouldCleanUp(SharedPreferences sharedPreferences) {
            return System.currentTimeMillis() > sharedPreferences.getLong("last_cleanup_time", System.currentTimeMillis()) + CLEANUP_REQUIRED_TIME_SPAN;
        }
    }

    private static class FileSaveTask extends AsyncTask<String, Void, Void> {
        private final Context mAppContext;
        private final Bitmap mBitmap;
        private final Uri mFileUri;
        private final String mFilename;
        private final ResolvableFuture<Uri> mResultFuture;

        FileSaveTask(Context context, String str, Bitmap bitmap, Uri uri, ResolvableFuture<Uri> resolvableFuture) {
            this.mAppContext = context.getApplicationContext();
            this.mFilename = str;
            this.mBitmap = bitmap;
            this.mFileUri = uri;
            this.mResultFuture = resolvableFuture;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... strArr) {
            saveFileIfNeededBlocking();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void r3) {
            new FileCleanupTask(this.mAppContext).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }

        private void saveFileIfNeededBlocking() {
            File file = new File(this.mAppContext.getFilesDir(), "image_provider");
            synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
                if (file.exists() || file.mkdir()) {
                    File file2 = new File(file, this.mFilename + ".png");
                    if (file2.exists()) {
                        this.mResultFuture.set(this.mFileUri);
                    } else {
                        saveFileBlocking(file2);
                    }
                    file2.setLastModified(System.currentTimeMillis());
                    return;
                }
                this.mResultFuture.setException(new IOException("Could not create file directory."));
            }
        }

        private void saveFileBlocking(File file) {
            FileOutputStream fileOutputStream;
            IOException e;
            if (Build.VERSION.SDK_INT >= 22) {
                AtomicFile atomicFile = new AtomicFile(file);
                try {
                    fileOutputStream = atomicFile.startWrite();
                    try {
                        this.mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.close();
                        atomicFile.finishWrite(fileOutputStream);
                        this.mResultFuture.set(this.mFileUri);
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = null;
                    atomicFile.failWrite(fileOutputStream);
                    this.mResultFuture.setException(e);
                }
            } else {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    this.mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    fileOutputStream2.close();
                    this.mResultFuture.set(this.mFileUri);
                } catch (IOException e4) {
                    this.mResultFuture.setException(e4);
                }
            }
        }
    }

    public static ResolvableFuture<Uri> saveBitmap(Context context, Bitmap bitmap, String str, int i) {
        String str2 = str + "_" + Integer.toString(i);
        Uri generateUri = generateUri(context, str2);
        ResolvableFuture<Uri> create = ResolvableFuture.create();
        new FileSaveTask(context, str2, bitmap, generateUri, create).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        return create;
    }

    private static Uri generateUri(Context context, String str) {
        return new Uri.Builder().scheme("content").authority(context.getPackageName() + ".image_provider").path("image_provider_images/" + str + ".png").build();
    }

    public static void grantReadPermission(Intent intent, List<Uri> list, Context context) {
        if (!(list == null || list.size() == 0)) {
            ContentResolver contentResolver = context.getContentResolver();
            intent.addFlags(1);
            ClipData newUri = ClipData.newUri(contentResolver, "image_provider_uris", list.get(0));
            for (int i = 1; i < list.size(); i++) {
                newUri.addItem(new ClipData.Item(list.get(i)));
            }
            intent.setClipData(newUri);
        }
    }

    public static ListenableFuture<Bitmap> loadBitmap(final ContentResolver contentResolver, final Uri uri) {
        final ResolvableFuture create = ResolvableFuture.create();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            /* class androidx.browser.browseractions.BrowserServiceFileProvider.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                    if (openFileDescriptor == null) {
                        create.setException(new FileNotFoundException());
                        return;
                    }
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                    openFileDescriptor.close();
                    if (decodeFileDescriptor == null) {
                        create.setException(new IOException("File could not be decoded."));
                    } else {
                        create.set(decodeFileDescriptor);
                    }
                } catch (IOException e) {
                    create.setException(e);
                }
            }
        });
        return create;
    }
}
