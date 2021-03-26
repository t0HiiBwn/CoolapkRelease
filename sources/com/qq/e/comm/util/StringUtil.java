package com.qq.e.comm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String join(String str, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (!(str == null || i == 0)) {
                    stringBuffer.append(str);
                }
                stringBuffer.append(strArr[i]);
            }
        }
        return stringBuffer.toString();
    }

    public static int parseInteger(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i;
        }
    }

    public static String readAll(File file) throws IOException {
        BufferedReader bufferedReader;
        Throwable th;
        IOException e;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception e2) {
                    GDTLogger.e("Exception while close bufferreader", e2);
                }
                return sb2;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                    GDTLogger.e("Exception while close bufferreader", e5);
                }
            }
            throw th;
        }
    }

    public static void writeTo(String str, File file) throws IOException {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
            return;
        }
        throw new IOException("Target File Can not be null in StringUtil.writeTo");
    }
}
