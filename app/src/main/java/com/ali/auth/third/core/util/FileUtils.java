package com.ali.auth.third.core.util;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtils {
    public static String readFileData(Context context, String str) {
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            int available = openFileInput.available();
            if (available <= 0) {
                return "";
            }
            byte[] bArr = new byte[available];
            openFileInput.read(bArr);
            String str2 = new String(bArr, "UTF-8");
            try {
                openFileInput.close();
            } catch (Exception unused) {
            }
            return str2;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static void writeFileData(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes());
            openFileOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
