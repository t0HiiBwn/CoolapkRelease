package com.coolapk.market.processor;

import android.content.Context;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.processor.ApkFileProcessor;
import com.coolapk.market.util.LogUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;

public class ExtendApkFileProcessor2 implements FileProcessor {
    private String apkPath;
    private final Context appContext;
    private final Callback callback;
    private final String expectPackageName;
    private final String filePath;
    private final boolean isRootModel;
    private final String password;
    private final boolean useSignatures;

    public interface Callback extends ApkFileProcessor.Callback {
        void onUnpacking();
    }

    public ExtendApkFileProcessor2(Context context, String str, boolean z, boolean z2, String str2, String str3, Callback callback2) {
        this.appContext = context;
        this.filePath = str;
        this.isRootModel = z;
        this.useSignatures = z2;
        this.expectPackageName = str2;
        this.password = str3;
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
        if (new File(this.filePath).exists()) {
            return unpackApk();
        }
        LogUtils.w("Extend apk file is not exists, %s", this.filePath);
        throw new FileNotFoundException("Extend apk file is not exists");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a2, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a3, code lost:
        r0.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a6, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a9, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00aa, code lost:
        if (r1 != null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b0, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b1, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b4, code lost:
        throw r2;
     */
    private boolean unpackApk() throws IOException {
        String str;
        File file = new File(DataManager.getInstance().getDataConfig().getCacheDir());
        if (file.exists() || file.mkdirs()) {
            ZipFile zipFile = new ZipFile(this.filePath);
            if (zipFile.isEncrypted() && (str = this.password) != null) {
                zipFile.setPassword(str.toCharArray());
            }
            for (FileHeader fileHeader : zipFile.getFileHeaders()) {
                if (!fileHeader.isDirectory() && fileHeader.getFileName().endsWith(".apk")) {
                    File file2 = new File(file, fileHeader.getFileName());
                    String absolutePath = file2.getAbsolutePath();
                    byte[] bArr = new byte[8192];
                    ZipInputStream inputStream = zipFile.getInputStream(fileHeader);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            this.apkPath = absolutePath;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        LogUtils.w("Can not make dir, %s", file.getPath());
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r5.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003c, code lost:
        r4.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003f, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r4.close();
     */
    public void extractWithZipInputStream(InputStream inputStream, char[] cArr, File file) throws IOException {
        byte[] bArr = new byte[8192];
        ZipInputStream zipInputStream = new ZipInputStream(inputStream, cArr);
        while (zipInputStream.getNextEntry() != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                int read = zipInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        }
        zipInputStream.close();
    }
}
