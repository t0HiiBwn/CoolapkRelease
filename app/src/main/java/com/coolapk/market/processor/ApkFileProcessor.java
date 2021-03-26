package com.coolapk.market.processor;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.RootTools;
import com.coolapk.market.util.SystemUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ApkFileProcessor implements FileProcessor {
    private final Context appContext;
    private final Callback callback;
    private final String expectPackageName;
    private final String filePath;
    private final boolean isRootModel;
    private final boolean useSignatures;

    public interface Callback {
        void onInstalling();

        void onVerify();
    }

    public ApkFileProcessor(Context context, String str, boolean z, boolean z2, String str2, Callback callback2) {
        this.appContext = context;
        this.filePath = str;
        this.isRootModel = z;
        this.useSignatures = z2;
        this.expectPackageName = str2;
        this.callback = callback2;
    }

    @Override // com.coolapk.market.processor.FileProcessor
    public boolean process() throws Throwable {
        if (!verifyApk() || !install()) {
            return false;
        }
        LogUtils.i("Install success", new Object[0]);
        return true;
    }

    @Override // com.coolapk.market.processor.FileProcessor
    public String getOutputFilePath() {
        return this.filePath;
    }

    private boolean verifyApk() throws SignaturesException, PackageParseException, FileNotFoundException, ExpectPackageException, SamePackageException {
        boolean z;
        this.callback.onVerify();
        if (new File(this.filePath).exists()) {
            PackageManager packageManager = this.appContext.getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(this.filePath, 64);
            if (packageArchiveInfo != null) {
                packageArchiveInfo.applicationInfo.sourceDir = this.filePath;
                packageArchiveInfo.applicationInfo.publicSourceDir = this.filePath;
                String str = this.expectPackageName;
                if (str != null && !TextUtils.equals(str, packageArchiveInfo.packageName)) {
                    LogUtils.e("PackageName is incompatible, %s, %s", packageArchiveInfo.packageName, this.filePath);
                    throw new ExpectPackageException(this.expectPackageName, packageArchiveInfo.packageName, packageArchiveInfo.applicationInfo.loadLabel(packageManager).toString(), packageArchiveInfo.versionName, packageArchiveInfo.versionCode);
                } else if (!this.isRootModel || !packageArchiveInfo.packageName.equals(this.appContext.getPackageName()) || !packageArchiveInfo.versionName.equals(SystemUtils.getVersionName(this.appContext)) || packageArchiveInfo.versionCode != SystemUtils.getVersionCode(this.appContext)) {
                    if (this.useSignatures) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(packageArchiveInfo.packageName, 64);
                            if (packageInfo != null) {
                                if (packageArchiveInfo.signatures == null || packageInfo.signatures == null) {
                                    z = false;
                                } else {
                                    z = packageArchiveInfo.signatures.length != packageInfo.signatures.length;
                                    int i = 0;
                                    while (true) {
                                        if (i >= packageArchiveInfo.signatures.length) {
                                            break;
                                        } else if (z) {
                                            break;
                                        } else {
                                            if (packageArchiveInfo.signatures[i].equals(packageInfo.signatures[i])) {
                                                if (packageArchiveInfo.signatures[i].toCharsString().equals(packageInfo.signatures[i].toCharsString())) {
                                                    z = false;
                                                    i++;
                                                }
                                            }
                                            z = true;
                                            i++;
                                        }
                                    }
                                }
                                if (z) {
                                    LogUtils.e("Signatures is incompatible, %s, %s", packageArchiveInfo.packageName, this.filePath);
                                    throw new SignaturesException(String.format("Signatures is incompatible, %s, %s", packageArchiveInfo.packageName, this.filePath));
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                            LogUtils.v("Mobile app not found: %s", packageArchiveInfo.packageName);
                        }
                    }
                    return true;
                } else {
                    throw new SamePackageException(packageArchiveInfo.packageName, packageArchiveInfo.versionName, packageArchiveInfo.versionCode);
                }
            } else {
                LogUtils.e("Can load archive info, %s", this.filePath);
                throw new PackageParseException(String.format("Can load archive info, %s", this.filePath));
            }
        } else {
            LogUtils.w("Apk file is not exists, %s", this.filePath);
            throw new FileNotFoundException(String.format("Apk file is not exists, %s", this.filePath));
        }
    }

    private boolean install() throws IOException, InterruptedException, TimeoutException {
        this.callback.onInstalling();
        if (this.isRootModel) {
            boolean isAccessGivenWithTimeOut = RootTools.isAccessGivenWithTimeOut();
            LogUtils.v("Is root access given? %s", Boolean.valueOf(isAccessGivenWithTimeOut));
            if (isAccessGivenWithTimeOut) {
                LogUtils.v("Install by root mode", new Object[0]);
                if (PackageUtils.installSilent(this.filePath, false)) {
                    return true;
                }
            }
        }
        LogUtils.v("Install by normal mode", new Object[0]);
        return PackageUtils.installNormal(this.appContext, this.filePath);
    }
}
