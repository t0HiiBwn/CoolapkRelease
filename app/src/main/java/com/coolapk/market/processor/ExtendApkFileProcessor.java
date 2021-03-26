package com.coolapk.market.processor;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.processor.ApkFileProcessor;
import com.coolapk.market.util.LogUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExtendApkFileProcessor implements FileProcessor {
    private String apkPath;
    private final Context appContext;
    private final Callback callback;
    private final String expectPackageName;
    private final String filePath;
    private final boolean isRootModel;
    private final boolean useSignatures;

    public interface Callback extends ApkFileProcessor.Callback {
        @Override // com.coolapk.market.processor.ExtendApkFileProcessor2.Callback
        void onUnpacking();
    }

    public ExtendApkFileProcessor(Context context, String str, boolean z, boolean z2, String str2, Callback callback2) {
        this.appContext = context;
        this.filePath = str;
        this.isRootModel = z;
        this.useSignatures = z2;
        this.expectPackageName = str2;
        this.callback = callback2;
    }

    @Override // com.coolapk.market.processor.FileProcessor
    public boolean process() throws Throwable {
        return unpack() && new ApkFileProcessor(this.appContext, this.apkPath, this.isRootModel, this.useSignatures, this.expectPackageName, this.callback).process();
    }

    @Override // com.coolapk.market.processor.FileProcessor
    public String getOutputFilePath() {
        return this.apkPath;
    }

    private boolean unpack() throws IOException {
        this.callback.onUnpacking();
        if (!new File(this.filePath).exists()) {
            LogUtils.w("Extend apk file is not exists, %s", this.filePath);
            throw new FileNotFoundException("Extend apk file is not exists");
        } else if (!unpackApk() || !unpackObb()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean unpackApk() throws IOException {
        File file = new File(DataManager.getInstance().getDataConfig().getCacheDir());
        if (file.exists() || file.mkdirs()) {
            ZipFile zipFile = new ZipFile(this.filePath);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (!zipEntry.isDirectory()) {
                        String name = zipEntry.getName();
                        if (name.endsWith(".apk")) {
                            File file2 = new File(file, name.substring(name.indexOf("/") + 1));
                            InputStream inputStream = zipFile.getInputStream(zipEntry);
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                this.apkPath = file2.getAbsolutePath();
                                return true;
                            } finally {
                                try {
                                    inputStream.close();
                                    fileOutputStream.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                try {
                    zipFile.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return false;
            } finally {
                try {
                    zipFile.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } else {
            LogUtils.w("Can not make dir, %s", file.getPath());
            return false;
        }
    }

    private boolean unpackObb() throws IOException {
        PackageInfo packageArchiveInfo = this.appContext.getPackageManager().getPackageArchiveInfo(this.apkPath, 0);
        if (packageArchiveInfo == null) {
            LogUtils.e("Can load archive info, %s", this.apkPath);
            return false;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory, "/Android/obb/" + packageArchiveInfo.packageName);
        if (file.exists() || file.mkdirs()) {
            ZipFile zipFile = new ZipFile(this.filePath);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (!zipEntry.isDirectory()) {
                        String name = zipEntry.getName();
                        if (name.endsWith(".obb")) {
                            File file2 = new File(file, name.substring(name.indexOf("/") + 1));
                            InputStream inputStream = zipFile.getInputStream(zipEntry);
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read != -1) {
                                        fileOutputStream.write(bArr, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException e) {
                                        }
                                    }
                                }
                                return true;
                            } finally {
                                try {
                                    inputStream.close();
                                    fileOutputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return false;
            } finally {
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } else {
            LogUtils.w("Can not make dir, %s", file.getPath());
            return false;
        }
    }
}
