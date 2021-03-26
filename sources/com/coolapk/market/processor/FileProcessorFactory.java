package com.coolapk.market.processor;

import android.content.Context;
import android.text.TextUtils;
import com.coolapk.market.model.Extra;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.StringUtils;
import java.util.Locale;

public class FileProcessorFactory {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (r8.equals("xpk") == false) goto L_0x001c;
     */
    public static FileProcessor getFileProcessor(Context context, String str, boolean z, boolean z2, boolean z3, ProcessorCallback processorCallback, Extra extra) throws UnsupportedFileException {
        Context applicationContext = context.getApplicationContext();
        String fileExtension = CoolFileUtils.getFileExtension(str);
        char c = 2;
        if (canHandleWith(fileExtension)) {
            fileExtension.hashCode();
            switch (fileExtension.hashCode()) {
                case 96796:
                    if (fileExtension.equals("apk")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 99679:
                    if (fileExtension.equals("dpk")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 118899:
                    break;
                case 3000726:
                    if (fileExtension.equals("apk2")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3433388:
                    if (fileExtension.equals("papk")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3671716:
                    if (fileExtension.equals("xapk")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            String str2 = null;
            switch (c) {
                case 0:
                    if (z3 && extra != null) {
                        str2 = extra.getString("PACKAGE_NAME");
                    }
                    return new ApkFileProcessor(applicationContext, str, z, z2, str2, processorCallback);
                case 1:
                case 2:
                case 5:
                    return new ExtendApkFileProcessor(applicationContext, str, z, z2, null, processorCallback);
                case 3:
                    String lowerCase = extra.getString("PACKAGE_NAME").toLowerCase(Locale.ENGLISH);
                    String string = extra.getString("VERSION_CODE");
                    String string2 = extra.getString("APK_ID");
                    String lowerCase2 = extra.getString("LOGO").toLowerCase(Locale.ENGLISH);
                    return new ExtendApkFileProcessor2(applicationContext, str, z, z2, null, StringUtils.toMd5(lowerCase + ":" + string + ":" + string2 + ":" + lowerCase2), processorCallback);
                case 4:
                    String string3 = extra.getString("PACKAGE_NAME");
                    String string4 = extra.getString("PATCH_MD5");
                    if (!TextUtils.isEmpty(string3)) {
                        return new PatchFileProcessor(applicationContext, string3, string4, str, z, z2, processorCallback);
                    }
                    throw new IllegalArgumentException(String.format("Do you forget extra for patch: %s", string3));
                default:
                    return null;
            }
        } else {
            throw new UnsupportedFileException(String.format("Unsupported file: %s, fileExtension: %s", str, fileExtension));
        }
    }

    public static boolean canHandleWith(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 96796:
                if (str.equals("apk")) {
                    c = 0;
                    break;
                }
                break;
            case 99679:
                if (str.equals("dpk")) {
                    c = 1;
                    break;
                }
                break;
            case 118899:
                if (str.equals("xpk")) {
                    c = 2;
                    break;
                }
                break;
            case 3000726:
                if (str.equals("apk2")) {
                    c = 3;
                    break;
                }
                break;
            case 3433388:
                if (str.equals("papk")) {
                    c = 4;
                    break;
                }
                break;
            case 3671716:
                if (str.equals("xapk")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }
}
