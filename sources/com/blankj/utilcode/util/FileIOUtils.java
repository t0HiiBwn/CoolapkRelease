package com.blankj.utilcode.util;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public final class FileIOUtils {
    private static int sBufferSize = 524288;

    public interface OnProgressUpdateListener {
        void onProgressUpdate(double d);
    }

    private FileIOUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream) {
        return writeFileFromIS(UtilsBridge.getFileByPath(str), inputStream, false, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream, boolean z) {
        return writeFileFromIS(UtilsBridge.getFileByPath(str), inputStream, z, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromIS(File file, InputStream inputStream) {
        return writeFileFromIS(file, inputStream, false, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromIS(File file, InputStream inputStream, boolean z) {
        return writeFileFromIS(file, inputStream, z, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromIS(UtilsBridge.getFileByPath(str), inputStream, false, onProgressUpdateListener);
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream, boolean z, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromIS(UtilsBridge.getFileByPath(str), inputStream, z, onProgressUpdateListener);
    }

    public static boolean writeFileFromIS(File file, InputStream inputStream, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromIS(file, inputStream, false, onProgressUpdateListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0070 A[SYNTHETIC, Splitter:B:41:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0083 A[SYNTHETIC, Splitter:B:51:0x0083] */
    public static boolean writeFileFromIS(File file, InputStream inputStream, boolean z, OnProgressUpdateListener onProgressUpdateListener) {
        Throwable th;
        IOException e;
        if (inputStream == null || !UtilsBridge.createOrExistsFile(file)) {
            Log.e("FileIOUtils", "create file <" + file + "> failed.");
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z), sBufferSize);
            if (onProgressUpdateListener != null) {
                double available = (double) inputStream.available();
                onProgressUpdateListener.onProgressUpdate(0.0d);
                byte[] bArr = new byte[sBufferSize];
                int i = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream2.write(bArr, 0, read);
                    i += read;
                    onProgressUpdateListener.onProgressUpdate(((double) i) / available);
                }
            } else {
                try {
                    byte[] bArr2 = new byte[sBufferSize];
                    while (true) {
                        int read2 = inputStream.read(bArr2);
                        if (read2 == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr2, 0, read2);
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        e.printStackTrace();
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        if (bufferedOutputStream != null) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = bufferedOutputStream2;
                    inputStream.close();
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            }
            try {
                inputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            try {
                bufferedOutputStream2.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            return true;
        } catch (IOException e8) {
            e = e8;
            e.printStackTrace();
            inputStream.close();
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            return false;
        }
    }

    public static boolean writeFileFromBytesByStream(String str, byte[] bArr) {
        return writeFileFromBytesByStream(UtilsBridge.getFileByPath(str), bArr, false, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromBytesByStream(String str, byte[] bArr, boolean z) {
        return writeFileFromBytesByStream(UtilsBridge.getFileByPath(str), bArr, z, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromBytesByStream(File file, byte[] bArr) {
        return writeFileFromBytesByStream(file, bArr, false, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromBytesByStream(File file, byte[] bArr, boolean z) {
        return writeFileFromBytesByStream(file, bArr, z, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromBytesByStream(String str, byte[] bArr, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromBytesByStream(UtilsBridge.getFileByPath(str), bArr, false, onProgressUpdateListener);
    }

    public static boolean writeFileFromBytesByStream(String str, byte[] bArr, boolean z, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromBytesByStream(UtilsBridge.getFileByPath(str), bArr, z, onProgressUpdateListener);
    }

    public static boolean writeFileFromBytesByStream(File file, byte[] bArr, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromBytesByStream(file, bArr, false, onProgressUpdateListener);
    }

    public static boolean writeFileFromBytesByStream(File file, byte[] bArr, boolean z, OnProgressUpdateListener onProgressUpdateListener) {
        if (bArr == null) {
            return false;
        }
        return writeFileFromIS(file, new ByteArrayInputStream(bArr), z, onProgressUpdateListener);
    }

    public static boolean writeFileFromBytesByChannel(String str, byte[] bArr, boolean z) {
        return writeFileFromBytesByChannel(UtilsBridge.getFileByPath(str), bArr, false, z);
    }

    public static boolean writeFileFromBytesByChannel(String str, byte[] bArr, boolean z, boolean z2) {
        return writeFileFromBytesByChannel(UtilsBridge.getFileByPath(str), bArr, z, z2);
    }

    public static boolean writeFileFromBytesByChannel(File file, byte[] bArr, boolean z) {
        return writeFileFromBytesByChannel(file, bArr, false, z);
    }

    public static boolean writeFileFromBytesByChannel(File file, byte[] bArr, boolean z, boolean z2) {
        if (bArr == null) {
            Log.e("FileIOUtils", "bytes is null.");
            return false;
        } else if (!UtilsBridge.createOrExistsFile(file)) {
            Log.e("FileIOUtils", "create file <" + file + "> failed.");
            return false;
        } else {
            FileChannel fileChannel = null;
            try {
                FileChannel channel = new FileOutputStream(file, z).getChannel();
                if (channel == null) {
                    Log.e("FileIOUtils", "fc is null.");
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return false;
                }
                channel.position(channel.size());
                channel.write(ByteBuffer.wrap(bArr));
                if (z2) {
                    channel.force(true);
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                if (0 != 0) {
                    try {
                        fileChannel.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        fileChannel.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static boolean writeFileFromBytesByMap(String str, byte[] bArr, boolean z) {
        return writeFileFromBytesByMap(str, bArr, false, z);
    }

    public static boolean writeFileFromBytesByMap(String str, byte[] bArr, boolean z, boolean z2) {
        return writeFileFromBytesByMap(UtilsBridge.getFileByPath(str), bArr, z, z2);
    }

    public static boolean writeFileFromBytesByMap(File file, byte[] bArr, boolean z) {
        return writeFileFromBytesByMap(file, bArr, false, z);
    }

    public static boolean writeFileFromBytesByMap(File file, byte[] bArr, boolean z, boolean z2) {
        if (bArr == null || !UtilsBridge.createOrExistsFile(file)) {
            Log.e("FileIOUtils", "create file <" + file + "> failed.");
            return false;
        }
        FileChannel fileChannel = null;
        try {
            FileChannel channel = new FileOutputStream(file, z).getChannel();
            if (channel == null) {
                Log.e("FileIOUtils", "fc is null.");
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, channel.size(), (long) bArr.length);
            map.put(bArr);
            if (z2) {
                map.force();
            }
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return true;
        } catch (IOException e3) {
            e3.printStackTrace();
            if (0 != 0) {
                try {
                    fileChannel.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    fileChannel.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean writeFileFromString(String str, String str2) {
        return writeFileFromString(UtilsBridge.getFileByPath(str), str2, false);
    }

    public static boolean writeFileFromString(String str, String str2, boolean z) {
        return writeFileFromString(UtilsBridge.getFileByPath(str), str2, z);
    }

    public static boolean writeFileFromString(File file, String str) {
        return writeFileFromString(file, str, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A[SYNTHETIC, Splitter:B:33:0x0059] */
    public static boolean writeFileFromString(File file, String str, boolean z) {
        Throwable th;
        IOException e;
        if (file == null || str == null) {
            return false;
        }
        if (!UtilsBridge.createOrExistsFile(file)) {
            Log.e("FileIOUtils", "create file <" + file + "> failed.");
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, z));
            try {
                bufferedWriter2.write(str);
                try {
                    bufferedWriter2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (IOException e3) {
                e = e3;
                bufferedWriter = bufferedWriter2;
                try {
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            return false;
        }
    }

    public static List<String> readFile2List(String str) {
        return readFile2List(UtilsBridge.getFileByPath(str), (String) null);
    }

    public static List<String> readFile2List(String str, String str2) {
        return readFile2List(UtilsBridge.getFileByPath(str), str2);
    }

    public static List<String> readFile2List(File file) {
        return readFile2List(file, 0, Integer.MAX_VALUE, (String) null);
    }

    public static List<String> readFile2List(File file, String str) {
        return readFile2List(file, 0, Integer.MAX_VALUE, str);
    }

    public static List<String> readFile2List(String str, int i, int i2) {
        return readFile2List(UtilsBridge.getFileByPath(str), i, i2, (String) null);
    }

    public static List<String> readFile2List(String str, int i, int i2, String str2) {
        return readFile2List(UtilsBridge.getFileByPath(str), i, i2, str2);
    }

    public static List<String> readFile2List(File file, int i, int i2) {
        return readFile2List(file, i, i2, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A[SYNTHETIC, Splitter:B:32:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006b A[SYNTHETIC, Splitter:B:40:0x006b] */
    public static List<String> readFile2List(File file, int i, int i2, String str) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        BufferedReader bufferedReader2 = null;
        if (!UtilsBridge.isFileExists(file) || i > i2) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int i3 = 1;
            if (UtilsBridge.isSpace(str)) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
            }
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (i3 > i2) {
                            break;
                        }
                        if (i <= i3 && i3 <= i2) {
                            arrayList.add(readLine);
                        }
                        i3++;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return arrayList;
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
            e.printStackTrace();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    public static String readFile2String(String str) {
        return readFile2String(UtilsBridge.getFileByPath(str), (String) null);
    }

    public static String readFile2String(String str, String str2) {
        return readFile2String(UtilsBridge.getFileByPath(str), str2);
    }

    public static String readFile2String(File file) {
        return readFile2String(file, (String) null);
    }

    public static String readFile2String(File file, String str) {
        byte[] readFile2BytesByStream = readFile2BytesByStream(file);
        if (readFile2BytesByStream == null) {
            return null;
        }
        if (UtilsBridge.isSpace(str)) {
            return new String(readFile2BytesByStream);
        }
        try {
            return new String(readFile2BytesByStream, str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] readFile2BytesByStream(String str) {
        return readFile2BytesByStream(UtilsBridge.getFileByPath(str), (OnProgressUpdateListener) null);
    }

    public static byte[] readFile2BytesByStream(File file) {
        return readFile2BytesByStream(file, (OnProgressUpdateListener) null);
    }

    public static byte[] readFile2BytesByStream(String str, OnProgressUpdateListener onProgressUpdateListener) {
        return readFile2BytesByStream(UtilsBridge.getFileByPath(str), onProgressUpdateListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073 A[SYNTHETIC, Splitter:B:39:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0087 A[SYNTHETIC, Splitter:B:50:0x0087] */
    public static byte[] readFile2BytesByStream(File file, OnProgressUpdateListener onProgressUpdateListener) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        IOException e;
        if (!UtilsBridge.isFileExists(file)) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), sBufferSize);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[sBufferSize];
                    if (onProgressUpdateListener != null) {
                        double available = (double) bufferedInputStream.available();
                        onProgressUpdateListener.onProgressUpdate(0.0d);
                        int i = 0;
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, sBufferSize);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                            i += read;
                            onProgressUpdateListener.onProgressUpdate(((double) i) / available);
                        }
                    } else {
                        while (true) {
                            int read2 = bufferedInputStream.read(bArr, 0, sBufferSize);
                            if (read2 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read2);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return byteArray;
                } catch (IOException e4) {
                    e = e4;
                    try {
                        e.printStackTrace();
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e9) {
                e = e9;
                byteArrayOutputStream = null;
                e.printStackTrace();
                bufferedInputStream.close();
                if (byteArrayOutputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                bufferedInputStream.close();
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static byte[] readFile2BytesByChannel(String str) {
        return readFile2BytesByChannel(UtilsBridge.getFileByPath(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A[SYNTHETIC, Splitter:B:32:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0060 A[SYNTHETIC, Splitter:B:40:0x0060] */
    public static byte[] readFile2BytesByChannel(File file) {
        Throwable th;
        FileChannel fileChannel;
        IOException e;
        FileChannel fileChannel2 = null;
        if (!UtilsBridge.isFileExists(file)) {
            return null;
        }
        try {
            fileChannel = new RandomAccessFile(file, "r").getChannel();
            if (fileChannel == null) {
                try {
                    Log.e("FileIOUtils", "fc is null.");
                    byte[] bArr = new byte[0];
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return bArr;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel2 = fileChannel;
                        if (fileChannel2 != null) {
                        }
                        throw th;
                    }
                }
            } else {
                ByteBuffer allocate = ByteBuffer.allocate((int) fileChannel.size());
                do {
                } while (fileChannel.read(allocate) > 0);
                byte[] array = allocate.array();
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return array;
            }
        } catch (IOException e6) {
            e = e6;
            fileChannel = null;
            e.printStackTrace();
            if (fileChannel != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileChannel2 != null) {
                try {
                    fileChannel2.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static byte[] readFile2BytesByMap(String str) {
        return readFile2BytesByMap(UtilsBridge.getFileByPath(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0058 A[SYNTHETIC, Splitter:B:30:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0065 A[SYNTHETIC, Splitter:B:38:0x0065] */
    public static byte[] readFile2BytesByMap(File file) {
        Throwable th;
        FileChannel fileChannel;
        IOException e;
        FileChannel fileChannel2 = null;
        if (!UtilsBridge.isFileExists(file)) {
            return null;
        }
        try {
            fileChannel = new RandomAccessFile(file, "r").getChannel();
            if (fileChannel == null) {
                try {
                    Log.e("FileIOUtils", "fc is null.");
                    byte[] bArr = new byte[0];
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return bArr;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (fileChannel != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel2 = fileChannel;
                        if (fileChannel2 != null) {
                            try {
                                fileChannel2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } else {
                int size = (int) fileChannel.size();
                byte[] bArr2 = new byte[size];
                fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, (long) size).load().get(bArr2, 0, size);
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return bArr2;
            }
        } catch (IOException e6) {
            e = e6;
            fileChannel = null;
            e.printStackTrace();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileChannel2 != null) {
            }
            throw th;
        }
    }

    public static void setBufferSize(int i) {
        sBufferSize = i;
    }
}
