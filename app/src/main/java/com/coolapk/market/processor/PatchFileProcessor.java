package com.coolapk.market.processor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.coolapk.market.processor.ApkFileProcessor;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.LocalApkUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.PatchUtils;
import java.io.File;
import java.io.FileNotFoundException;

public class PatchFileProcessor implements FileProcessor {
    private String apkPath;
    private final Context appContext;
    private final Callback callback;
    private final String expectPatchMd5;
    private final boolean isRootModel;
    private final String packageName;
    private final String patchPath;
    private final boolean useSignatures;

    public interface Callback extends ApkFileProcessor.Callback {
        void onPatch();
    }

    public PatchFileProcessor(Context context, String str, String str2, String str3, boolean z, boolean z2, Callback callback2) {
        this.appContext = context;
        this.packageName = str;
        this.expectPatchMd5 = str2;
        this.patchPath = str3;
        this.isRootModel = z;
        this.useSignatures = z2;
        this.callback = callback2;
    }

    @Override // com.coolapk.market.processor.FileProcessor
    public boolean process() throws Throwable {
        return patch() && new ApkFileProcessor(this.appContext, this.apkPath, this.isRootModel, this.useSignatures, this.packageName, this.callback).process();
    }

    @Override // com.coolapk.market.processor.FileProcessor
    public String getOutputFilePath() {
        return this.apkPath;
    }

    private boolean patch() throws PackageManager.NameNotFoundException, FileNotFoundException, Md5NotMatchException {
        this.callback.onPatch();
        File file = new File(this.patchPath);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf != -1) {
            name = name.substring(0, lastIndexOf);
        }
        File file2 = new File(file.getParent(), name + ".apk");
        if (file2.isDirectory()) {
            LogUtils.w("File is directory cancel patch, %s", file2.getPath());
            return false;
        } else if (file2.exists()) {
            LogUtils.v("File is already exists, no need to patch, %s", file2.getPath());
            this.apkPath = file2.getAbsolutePath();
            return true;
        } else if (file.exists()) {
            if (!TextUtils.isEmpty(this.expectPatchMd5)) {
                String fileMd5 = CoolFileUtils.getFileMd5(this.patchPath);
                if (!TextUtils.equals(fileMd5, this.expectPatchMd5)) {
                    LogUtils.e("Download patch's MD5 is not matching! expect: %s file: %s", this.expectPatchMd5, fileMd5);
                    throw new Md5NotMatchException();
                }
            }
            String filePath = LocalApkUtils.getApp(this.appContext.getPackageManager(), this.appContext.getPackageManager().getPackageInfo(this.packageName, 8192), false).getFilePath();
            String absolutePath = file2.getAbsolutePath();
            PatchUtils.patch(filePath, absolutePath, this.patchPath);
            if (!file.delete()) {
                LogUtils.w("Can not delete file, %s", file.getPath());
            }
            this.apkPath = absolutePath;
            return true;
        } else {
            LogUtils.w("Patch file is not exists, %s", file.getPath());
            throw new FileNotFoundException("Patch file is not exists");
        }
    }
}
