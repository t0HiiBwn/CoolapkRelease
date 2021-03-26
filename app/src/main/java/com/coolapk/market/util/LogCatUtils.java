package com.coolapk.market.util;

import android.content.Context;
import android.net.Uri;
import com.coolapk.market.util.ShellUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

public class LogCatUtils {
    public static Uri saveApplicationLog(Context context, File file) throws Exception {
        String packageName = context.getPackageName();
        ShellUtils.execCommand(String.format("ls -la /storage/emulated/0/Android/data/ | grep %s", packageName), false, TimeUnit.SECONDS.toMillis(20), (ShellUtils.Callback) null);
        final StringBuilder sb = new StringBuilder();
        ShellUtils.execCommand(String.format("logcat -d -v time | grep `ps | grep %s | cut -c10-15 | head -n 1`", packageName), false, TimeUnit.SECONDS.toMillis(60), (ShellUtils.Callback) new ShellUtils.Callback() {
            /* class com.coolapk.market.util.LogCatUtils.AnonymousClass1 */

            @Override // com.coolapk.market.util.ShellUtils.Callback
            public void onOutput(String str) {
                sb.append(str);
                sb.append("\n");
            }
        });
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
        bufferedWriter.append((CharSequence) sb);
        bufferedWriter.flush();
        bufferedWriter.close();
        return Uri.fromFile(file);
    }
}
