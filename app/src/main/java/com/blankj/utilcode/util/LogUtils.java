package com.blankj.utilcode.util;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.blankj.utilcode.util.UtilsBridge;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class LogUtils {
    public static final int A = 7;
    private static final String ARGS = "args";
    private static final String BOTTOM_BORDER = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String BOTTOM_CORNER = "└";
    private static final Config CONFIG = new Config();
    public static final int D = 3;
    public static final int E = 6;
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
    private static final int FILE = 16;
    private static final String FILE_SEP = System.getProperty("file.separator");
    public static final int I = 4;
    private static final SimpleArrayMap<Class, IFormatter> I_FORMATTER_MAP = new SimpleArrayMap<>();
    private static final int JSON = 32;
    private static final String LEFT_BORDER = "│ ";
    private static final String LINE_SEP = System.getProperty("line.separator");
    private static final int MAX_LEN = 1100;
    private static final String MIDDLE_BORDER = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String MIDDLE_CORNER = "├";
    private static final String MIDDLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String NOTHING = "log nothing";
    private static final String NULL = "null";
    private static final String PLACEHOLDER = " ";
    private static final String SIDE_DIVIDER = "────────────────────────────────────────────────────────";
    private static final char[] T = {'V', 'D', 'I', 'W', 'E', 'A'};
    private static final String TOP_BORDER = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String TOP_CORNER = "┌";
    public static final int V = 2;
    public static final int W = 5;
    private static final int XML = 48;
    private static SimpleDateFormat simpleDateFormat;

    public interface IFileWriter {
        void write(String str, String str2);
    }

    public static abstract class IFormatter<T> {
        public abstract String format(T t);
    }

    public interface OnConsoleOutputListener {
        void onConsoleOutput(int i, String str, String str2);
    }

    public interface OnFileOutputListener {
        void onFileOutput(String str, String str2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {
    }

    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Config getConfig() {
        return CONFIG;
    }

    public static void v(Object... objArr) {
        log(2, CONFIG.getGlobalTag(), objArr);
    }

    public static void vTag(String str, Object... objArr) {
        log(2, str, objArr);
    }

    public static void d(Object... objArr) {
        log(3, CONFIG.getGlobalTag(), objArr);
    }

    public static void dTag(String str, Object... objArr) {
        log(3, str, objArr);
    }

    public static void i(Object... objArr) {
        log(4, CONFIG.getGlobalTag(), objArr);
    }

    public static void iTag(String str, Object... objArr) {
        log(4, str, objArr);
    }

    public static void w(Object... objArr) {
        log(5, CONFIG.getGlobalTag(), objArr);
    }

    public static void wTag(String str, Object... objArr) {
        log(5, str, objArr);
    }

    public static void e(Object... objArr) {
        log(6, CONFIG.getGlobalTag(), objArr);
    }

    public static void eTag(String str, Object... objArr) {
        log(6, str, objArr);
    }

    public static void a(Object... objArr) {
        log(7, CONFIG.getGlobalTag(), objArr);
    }

    public static void aTag(String str, Object... objArr) {
        log(7, str, objArr);
    }

    public static void file(Object obj) {
        log(19, CONFIG.getGlobalTag(), obj);
    }

    public static void file(int i, Object obj) {
        log(i | 16, CONFIG.getGlobalTag(), obj);
    }

    public static void file(String str, Object obj) {
        log(19, str, obj);
    }

    public static void file(int i, String str, Object obj) {
        log(i | 16, str, obj);
    }

    public static void json(Object obj) {
        log(35, CONFIG.getGlobalTag(), obj);
    }

    public static void json(int i, Object obj) {
        log(i | 32, CONFIG.getGlobalTag(), obj);
    }

    public static void json(String str, Object obj) {
        log(35, str, obj);
    }

    public static void json(int i, String str, Object obj) {
        log(i | 32, str, obj);
    }

    public static void xml(String str) {
        log(51, CONFIG.getGlobalTag(), str);
    }

    public static void xml(int i, String str) {
        log(i | 48, CONFIG.getGlobalTag(), str);
    }

    public static void xml(String str, String str2) {
        log(51, str, str2);
    }

    public static void xml(int i, String str, String str2) {
        log(i | 48, str, str2);
    }

    public static void log(int i, String str, Object... objArr) {
        Config config = CONFIG;
        if (config.isLogSwitch()) {
            final int i2 = i & 15;
            int i3 = i & 240;
            if (!config.isLog2ConsoleSwitch() && !config.isLog2FileSwitch() && i3 != 16) {
                return;
            }
            if (i2 >= config.mConsoleFilter || i2 >= config.mFileFilter) {
                final TagHead processTagAndHead = processTagAndHead(str);
                final String processBody = processBody(i3, objArr);
                if (config.isLog2ConsoleSwitch() && i3 != 16 && i2 >= config.mConsoleFilter) {
                    print2Console(i2, processTagAndHead.tag, processTagAndHead.consoleHead, processBody);
                }
                if ((config.isLog2FileSwitch() || i3 == 16) && i2 >= config.mFileFilter) {
                    EXECUTOR.execute(new Runnable() {
                        /* class com.blankj.utilcode.util.LogUtils.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            int i = i2;
                            String str = processTagAndHead.tag;
                            LogUtils.print2File(i, str, processTagAndHead.fileHead + processBody);
                        }
                    });
                }
            }
        }
    }

    public static String getCurrentLogFilePath() {
        return getCurrentLogFilePath(new Date());
    }

    public static List<File> getLogFiles() {
        File file = new File(CONFIG.getDir());
        if (!file.exists()) {
            return new ArrayList();
        }
        File[] listFiles = file.listFiles(new FilenameFilter() {
            /* class com.blankj.utilcode.util.LogUtils.AnonymousClass2 */

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return LogUtils.isMatchLogFileName(str);
            }
        });
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, listFiles);
        return arrayList;
    }

    private static TagHead processTagAndHead(String str) {
        String str2;
        String str3;
        String str4;
        Config config = CONFIG;
        if (config.mTagIsSpace || config.isLogHeadSwitch()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int stackOffset = config.getStackOffset() + 3;
            if (stackOffset >= stackTrace.length) {
                String fileName = getFileName(stackTrace[3]);
                if (!config.mTagIsSpace || !UtilsBridge.isSpace(str)) {
                    str4 = str;
                } else {
                    int indexOf = fileName.indexOf(46);
                    str4 = indexOf == -1 ? fileName : fileName.substring(0, indexOf);
                }
                return new TagHead(str4, null, ": ");
            }
            StackTraceElement stackTraceElement = stackTrace[stackOffset];
            String fileName2 = getFileName(stackTraceElement);
            if (!config.mTagIsSpace || !UtilsBridge.isSpace(str)) {
                str3 = str;
            } else {
                int indexOf2 = fileName2.indexOf(46);
                str3 = indexOf2 == -1 ? fileName2 : fileName2.substring(0, indexOf2);
            }
            if (config.isLogHeadSwitch()) {
                String name = Thread.currentThread().getName();
                String formatter = new Formatter().format("%s, %s.%s(%s:%d)", name, stackTraceElement.getClassName(), stackTraceElement.getMethodName(), fileName2, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                String str5 = " [" + formatter + "]: ";
                if (config.getStackDeep() <= 1) {
                    return new TagHead(str3, new String[]{formatter}, str5);
                }
                int min = Math.min(config.getStackDeep(), stackTrace.length - stackOffset);
                String[] strArr = new String[min];
                strArr[0] = formatter;
                String formatter2 = new Formatter().format("%" + (name.length() + 2) + "s", "").toString();
                for (int i = 1; i < min; i++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i + stackOffset];
                    strArr[i] = new Formatter().format("%s%s.%s(%s:%d)", formatter2, stackTraceElement2.getClassName(), stackTraceElement2.getMethodName(), getFileName(stackTraceElement2), Integer.valueOf(stackTraceElement2.getLineNumber())).toString();
                }
                return new TagHead(str3, strArr, str5);
            }
            str2 = str3;
        } else {
            str2 = config.getGlobalTag();
        }
        return new TagHead(str2, null, ": ");
    }

    private static String getFileName(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        if (fileName != null) {
            return fileName;
        }
        String className = stackTraceElement.getClassName();
        String[] split = className.split("\\.");
        if (split.length > 0) {
            className = split[split.length - 1];
        }
        int indexOf = className.indexOf(36);
        if (indexOf != -1) {
            className = className.substring(0, indexOf);
        }
        return className + ".java";
    }

    private static String processBody(int i, Object... objArr) {
        String str;
        if (objArr != null) {
            if (objArr.length == 1) {
                str = formatObject(i, objArr[0]);
            } else {
                StringBuilder sb = new StringBuilder();
                int length = objArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = objArr[i2];
                    sb.append("args");
                    sb.append("[");
                    sb.append(i2);
                    sb.append("]");
                    sb.append(" = ");
                    sb.append(formatObject(obj));
                    sb.append(LINE_SEP);
                }
                str = sb.toString();
            }
        } else {
            str = "null";
        }
        return str.length() == 0 ? "log nothing" : str;
    }

    private static String formatObject(int i, Object obj) {
        if (obj == null) {
            return "null";
        }
        if (i == 32) {
            return LogFormatter.object2String(obj, 32);
        }
        if (i == 48) {
            return LogFormatter.object2String(obj, 48);
        }
        return formatObject(obj);
    }

    /* access modifiers changed from: private */
    public static String formatObject(Object obj) {
        IFormatter iFormatter;
        if (obj == null) {
            return "null";
        }
        SimpleArrayMap<Class, IFormatter> simpleArrayMap = I_FORMATTER_MAP;
        if (simpleArrayMap.isEmpty() || (iFormatter = simpleArrayMap.get(getClassFromObject(obj))) == null) {
            return LogFormatter.object2String(obj);
        }
        return iFormatter.format(obj);
    }

    private static void print2Console(int i, String str, String[] strArr, String str2) {
        if (CONFIG.isSingleTagSwitch()) {
            printSingleTagMsg(i, str, processSingleTagMsg(i, str, strArr, str2));
            return;
        }
        printBorder(i, str, true);
        printHead(i, str, strArr);
        printMsg(i, str, str2);
        printBorder(i, str, false);
    }

    private static void printBorder(int i, String str, boolean z) {
        if (CONFIG.isLogBorderSwitch()) {
            print2Console(i, str, z ? "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────" : "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }
    }

    private static void printHead(int i, String str, String[] strArr) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (CONFIG.isLogBorderSwitch()) {
                    str2 = "│ " + str2;
                }
                print2Console(i, str, str2);
            }
            if (CONFIG.isLogBorderSwitch()) {
                print2Console(i, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
        }
    }

    private static void printMsg(int i, String str, String str2) {
        int length = str2.length();
        int i2 = length / 1100;
        if (i2 > 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1100;
                printSubMsg(i, str, str2.substring(i4, i5));
                i3++;
                i4 = i5;
            }
            if (i4 != length) {
                printSubMsg(i, str, str2.substring(i4, length));
                return;
            }
            return;
        }
        printSubMsg(i, str, str2);
    }

    private static void printSubMsg(int i, String str, String str2) {
        if (!CONFIG.isLogBorderSwitch()) {
            print2Console(i, str, str2);
            return;
        }
        String[] split = str2.split(LINE_SEP);
        for (String str3 : split) {
            print2Console(i, str, "│ " + str3);
        }
    }

    private static String processSingleTagMsg(int i, String str, String[] strArr, String str2) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (CONFIG.isLogBorderSwitch()) {
            sb.append(" ");
            String str3 = LINE_SEP;
            sb.append(str3);
            sb.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb.append(str3);
            if (strArr != null) {
                for (String str4 : strArr) {
                    sb.append("│ ");
                    sb.append(str4);
                    sb.append(LINE_SEP);
                }
                sb.append("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                sb.append(LINE_SEP);
            }
            String[] split = str2.split(LINE_SEP);
            int length = split.length;
            while (i2 < length) {
                String str5 = split[i2];
                sb.append("│ ");
                sb.append(str5);
                sb.append(LINE_SEP);
                i2++;
            }
            sb.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        } else {
            if (strArr != null) {
                sb.append(" ");
                sb.append(LINE_SEP);
                int length2 = strArr.length;
                while (i2 < length2) {
                    sb.append(strArr[i2]);
                    sb.append(LINE_SEP);
                    i2++;
                }
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    private static void printSingleTagMsg(int i, String str, String str2) {
        int length = str2.length();
        Config config = CONFIG;
        int i2 = 1100;
        int i3 = config.isLogBorderSwitch() ? (length - 113) / 1100 : length / 1100;
        if (i3 > 0) {
            int i4 = 1;
            if (config.isLogBorderSwitch()) {
                print2Console(i, str, str2.substring(0, 1100) + LINE_SEP + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                while (i4 < i3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" ");
                    String str3 = LINE_SEP;
                    sb.append(str3);
                    sb.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                    sb.append(str3);
                    sb.append("│ ");
                    int i5 = i2 + 1100;
                    sb.append(str2.substring(i2, i5));
                    sb.append(str3);
                    sb.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                    print2Console(i, str, sb.toString());
                    i4++;
                    i2 = i5;
                }
                if (i2 != length - 113) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" ");
                    String str4 = LINE_SEP;
                    sb2.append(str4);
                    sb2.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                    sb2.append(str4);
                    sb2.append("│ ");
                    sb2.append(str2.substring(i2, length));
                    print2Console(i, str, sb2.toString());
                    return;
                }
                return;
            }
            print2Console(i, str, str2.substring(0, 1100));
            while (i4 < i3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" ");
                sb3.append(LINE_SEP);
                int i6 = i2 + 1100;
                sb3.append(str2.substring(i2, i6));
                print2Console(i, str, sb3.toString());
                i4++;
                i2 = i6;
            }
            if (i2 != length) {
                print2Console(i, str, " " + LINE_SEP + str2.substring(i2, length));
                return;
            }
            return;
        }
        print2Console(i, str, str2);
    }

    private static void print2Console(int i, String str, String str2) {
        Log.println(i, str, str2);
        Config config = CONFIG;
        if (config.mOnConsoleOutputListener != null) {
            config.mOnConsoleOutputListener.onConsoleOutput(i, str, str2);
        }
    }

    /* access modifiers changed from: private */
    public static void print2File(int i, String str, String str2) {
        Date date = new Date();
        String format = getSdf().format(date);
        String substring = format.substring(0, 10);
        String currentLogFilePath = getCurrentLogFilePath(date);
        if (!createOrExistsFile(currentLogFilePath, substring)) {
            Log.e("LogUtils", "create " + currentLogFilePath + " failed!");
            return;
        }
        String substring2 = format.substring(11);
        input2File(currentLogFilePath, substring2 + T[i - 2] + "/" + str + str2 + LINE_SEP);
    }

    private static String getCurrentLogFilePath(Date date) {
        String substring = getSdf().format(date).substring(0, 10);
        StringBuilder sb = new StringBuilder();
        Config config = CONFIG;
        sb.append(config.getDir());
        sb.append(config.getFilePrefix());
        sb.append("_");
        sb.append(substring);
        sb.append("_");
        sb.append(config.getProcessName());
        sb.append(config.getFileExtension());
        return sb.toString();
    }

    private static SimpleDateFormat getSdf() {
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.getDefault());
        }
        return simpleDateFormat;
    }

    private static boolean createOrExistsFile(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!UtilsBridge.createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            deleteDueLogs(str, str2);
            boolean createNewFile = file.createNewFile();
            if (createNewFile) {
                printDeviceInfo(str, str2);
            }
            return createNewFile;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void deleteDueLogs(String str, String str2) {
        File[] listFiles;
        Config config = CONFIG;
        if (config.getSaveDays() > 0 && (listFiles = new File(str).getParentFile().listFiles(new FilenameFilter() {
            /* class com.blankj.utilcode.util.LogUtils.AnonymousClass3 */

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return LogUtils.isMatchLogFileName(str);
            }
        })) != null && listFiles.length > 0) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault());
            try {
                long time = simpleDateFormat2.parse(str2).getTime() - (((long) config.getSaveDays()) * 86400000);
                for (final File file : listFiles) {
                    String name = file.getName();
                    name.length();
                    if (simpleDateFormat2.parse(findDate(name)).getTime() <= time) {
                        EXECUTOR.execute(new Runnable() {
                            /* class com.blankj.utilcode.util.LogUtils.AnonymousClass4 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (!file.delete()) {
                                    Log.e("LogUtils", "delete " + file + " failed!");
                                }
                            }
                        });
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean isMatchLogFileName(String str) {
        return str.matches("^" + CONFIG.getFilePrefix() + "_[0-9]{4}_[0-9]{2}_[0-9]{2}_.*$");
    }

    private static String findDate(String str) {
        Matcher matcher = Pattern.compile("[0-9]{4}_[0-9]{2}_[0-9]{2}").matcher(str);
        return matcher.find() ? matcher.group() : "";
    }

    private static void printDeviceInfo(String str, String str2) {
        Config config = CONFIG;
        config.mFileHead.addFirst("Date of Log", str2);
        input2File(str, config.mFileHead.toString());
    }

    private static void input2File(String str, String str2) {
        Config config = CONFIG;
        if (config.mFileWriter == null) {
            UtilsBridge.writeFileFromString(str, str2, true);
        } else {
            config.mFileWriter.write(str, str2);
        }
        if (config.mOnFileOutputListener != null) {
            config.mOnFileOutputListener.onFileOutput(str, str2);
        }
    }

    public static final class Config {
        private int mConsoleFilter;
        private String mDefaultDir;
        private String mDir;
        private String mFileExtension;
        private int mFileFilter;
        private UtilsBridge.FileHead mFileHead;
        private String mFilePrefix;
        private IFileWriter mFileWriter;
        private String mGlobalTag;
        private boolean mLog2ConsoleSwitch;
        private boolean mLog2FileSwitch;
        private boolean mLogBorderSwitch;
        private boolean mLogHeadSwitch;
        private boolean mLogSwitch;
        private OnConsoleOutputListener mOnConsoleOutputListener;
        private OnFileOutputListener mOnFileOutputListener;
        private String mProcessName;
        private int mSaveDays;
        private boolean mSingleTagSwitch;
        private int mStackDeep;
        private int mStackOffset;
        private boolean mTagIsSpace;

        private Config() {
            this.mFilePrefix = "util";
            this.mFileExtension = ".txt";
            this.mLogSwitch = true;
            this.mLog2ConsoleSwitch = true;
            this.mGlobalTag = "";
            this.mTagIsSpace = true;
            this.mLogHeadSwitch = true;
            this.mLog2FileSwitch = false;
            this.mLogBorderSwitch = true;
            this.mSingleTagSwitch = true;
            this.mConsoleFilter = 2;
            this.mFileFilter = 2;
            this.mStackDeep = 1;
            this.mStackOffset = 0;
            this.mSaveDays = -1;
            this.mProcessName = UtilsBridge.getCurrentProcessName();
            this.mFileHead = new UtilsBridge.FileHead("Log");
            if (!UtilsBridge.isSDCardEnableByEnvironment() || Utils.getApp().getExternalFilesDir(null) == null) {
                this.mDefaultDir = Utils.getApp().getFilesDir() + LogUtils.FILE_SEP + "log" + LogUtils.FILE_SEP;
                return;
            }
            this.mDefaultDir = Utils.getApp().getExternalFilesDir(null) + LogUtils.FILE_SEP + "log" + LogUtils.FILE_SEP;
        }

        public final Config setLogSwitch(boolean z) {
            this.mLogSwitch = z;
            return this;
        }

        public final Config setConsoleSwitch(boolean z) {
            this.mLog2ConsoleSwitch = z;
            return this;
        }

        public final Config setGlobalTag(String str) {
            if (UtilsBridge.isSpace(str)) {
                this.mGlobalTag = "";
                this.mTagIsSpace = true;
            } else {
                this.mGlobalTag = str;
                this.mTagIsSpace = false;
            }
            return this;
        }

        public final Config setLogHeadSwitch(boolean z) {
            this.mLogHeadSwitch = z;
            return this;
        }

        public final Config setLog2FileSwitch(boolean z) {
            this.mLog2FileSwitch = z;
            return this;
        }

        public final Config setDir(String str) {
            if (UtilsBridge.isSpace(str)) {
                this.mDir = null;
            } else {
                if (!str.endsWith(LogUtils.FILE_SEP)) {
                    str = str + LogUtils.FILE_SEP;
                }
                this.mDir = str;
            }
            return this;
        }

        public final Config setDir(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + LogUtils.FILE_SEP;
            }
            this.mDir = str;
            return this;
        }

        public final Config setFilePrefix(String str) {
            if (UtilsBridge.isSpace(str)) {
                this.mFilePrefix = "util";
            } else {
                this.mFilePrefix = str;
            }
            return this;
        }

        public final Config setFileExtension(String str) {
            if (UtilsBridge.isSpace(str)) {
                this.mFileExtension = ".txt";
            } else if (str.startsWith(".")) {
                this.mFileExtension = str;
            } else {
                this.mFileExtension = "." + str;
            }
            return this;
        }

        public final Config setBorderSwitch(boolean z) {
            this.mLogBorderSwitch = z;
            return this;
        }

        public final Config setSingleTagSwitch(boolean z) {
            this.mSingleTagSwitch = z;
            return this;
        }

        public final Config setConsoleFilter(int i) {
            this.mConsoleFilter = i;
            return this;
        }

        public final Config setFileFilter(int i) {
            this.mFileFilter = i;
            return this;
        }

        public final Config setStackDeep(int i) {
            this.mStackDeep = i;
            return this;
        }

        public final Config setStackOffset(int i) {
            this.mStackOffset = i;
            return this;
        }

        public final Config setSaveDays(int i) {
            this.mSaveDays = i;
            return this;
        }

        public final <T> Config addFormatter(IFormatter<T> iFormatter) {
            if (iFormatter != null) {
                LogUtils.I_FORMATTER_MAP.put(LogUtils.getTypeClassFromParadigm(iFormatter), iFormatter);
            }
            return this;
        }

        public final Config setFileWriter(IFileWriter iFileWriter) {
            this.mFileWriter = iFileWriter;
            return this;
        }

        public final Config setOnConsoleOutputListener(OnConsoleOutputListener onConsoleOutputListener) {
            this.mOnConsoleOutputListener = onConsoleOutputListener;
            return this;
        }

        public final Config setOnFileOutputListener(OnFileOutputListener onFileOutputListener) {
            this.mOnFileOutputListener = onFileOutputListener;
            return this;
        }

        public final Config addFileExtraHead(Map<String, String> map) {
            this.mFileHead.append(map);
            return this;
        }

        public final Config addFileExtraHead(String str, String str2) {
            this.mFileHead.append(str, str2);
            return this;
        }

        public final String getProcessName() {
            String str = this.mProcessName;
            if (str == null) {
                return "";
            }
            return str.replace(":", "_");
        }

        public final String getDefaultDir() {
            return this.mDefaultDir;
        }

        public final String getDir() {
            String str = this.mDir;
            return str == null ? this.mDefaultDir : str;
        }

        public final String getFilePrefix() {
            return this.mFilePrefix;
        }

        public final String getFileExtension() {
            return this.mFileExtension;
        }

        public final boolean isLogSwitch() {
            return this.mLogSwitch;
        }

        public final boolean isLog2ConsoleSwitch() {
            return this.mLog2ConsoleSwitch;
        }

        public final String getGlobalTag() {
            if (UtilsBridge.isSpace(this.mGlobalTag)) {
                return "";
            }
            return this.mGlobalTag;
        }

        public final boolean isLogHeadSwitch() {
            return this.mLogHeadSwitch;
        }

        public final boolean isLog2FileSwitch() {
            return this.mLog2FileSwitch;
        }

        public final boolean isLogBorderSwitch() {
            return this.mLogBorderSwitch;
        }

        public final boolean isSingleTagSwitch() {
            return this.mSingleTagSwitch;
        }

        public final char getConsoleFilter() {
            return LogUtils.T[this.mConsoleFilter - 2];
        }

        public final char getFileFilter() {
            return LogUtils.T[this.mFileFilter - 2];
        }

        public final int getStackDeep() {
            return this.mStackDeep;
        }

        public final int getStackOffset() {
            return this.mStackOffset;
        }

        public final int getSaveDays() {
            return this.mSaveDays;
        }

        public final boolean haveSetOnConsoleOutputListener() {
            return this.mOnConsoleOutputListener != null;
        }

        public final boolean haveSetOnFileOutputListener() {
            return this.mOnFileOutputListener != null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("process: ");
            sb.append(getProcessName());
            sb.append(LogUtils.LINE_SEP);
            sb.append("logSwitch: ");
            sb.append(isLogSwitch());
            sb.append(LogUtils.LINE_SEP);
            sb.append("consoleSwitch: ");
            sb.append(isLog2ConsoleSwitch());
            sb.append(LogUtils.LINE_SEP);
            sb.append("tag: ");
            sb.append(getGlobalTag().equals("") ? "null" : getGlobalTag());
            sb.append(LogUtils.LINE_SEP);
            sb.append("headSwitch: ");
            sb.append(isLogHeadSwitch());
            sb.append(LogUtils.LINE_SEP);
            sb.append("fileSwitch: ");
            sb.append(isLog2FileSwitch());
            sb.append(LogUtils.LINE_SEP);
            sb.append("dir: ");
            sb.append(getDir());
            sb.append(LogUtils.LINE_SEP);
            sb.append("filePrefix: ");
            sb.append(getFilePrefix());
            sb.append(LogUtils.LINE_SEP);
            sb.append("borderSwitch: ");
            sb.append(isLogBorderSwitch());
            sb.append(LogUtils.LINE_SEP);
            sb.append("singleTagSwitch: ");
            sb.append(isSingleTagSwitch());
            sb.append(LogUtils.LINE_SEP);
            sb.append("consoleFilter: ");
            sb.append(getConsoleFilter());
            sb.append(LogUtils.LINE_SEP);
            sb.append("fileFilter: ");
            sb.append(getFileFilter());
            sb.append(LogUtils.LINE_SEP);
            sb.append("stackDeep: ");
            sb.append(getStackDeep());
            sb.append(LogUtils.LINE_SEP);
            sb.append("stackOffset: ");
            sb.append(getStackOffset());
            sb.append(LogUtils.LINE_SEP);
            sb.append("saveDays: ");
            sb.append(getSaveDays());
            sb.append(LogUtils.LINE_SEP);
            sb.append("formatter: ");
            sb.append(LogUtils.I_FORMATTER_MAP);
            sb.append(LogUtils.LINE_SEP);
            sb.append("fileWriter: ");
            sb.append(this.mFileWriter);
            sb.append(LogUtils.LINE_SEP);
            sb.append("onConsoleOutputListener: ");
            sb.append(this.mOnConsoleOutputListener);
            sb.append(LogUtils.LINE_SEP);
            sb.append("onFileOutputListener: ");
            sb.append(this.mOnFileOutputListener);
            sb.append(LogUtils.LINE_SEP);
            sb.append("fileExtraHeader: ");
            sb.append(this.mFileHead.getAppended());
            return sb.toString();
        }
    }

    private static final class TagHead {
        String[] consoleHead;
        String fileHead;
        String tag;

        TagHead(String str, String[] strArr, String str2) {
            this.tag = str;
            this.consoleHead = strArr;
            this.fileHead = str2;
        }
    }

    private static final class LogFormatter {
        private LogFormatter() {
        }

        static String object2String(Object obj) {
            return object2String(obj, -1);
        }

        static String object2String(Object obj, int i) {
            if (obj.getClass().isArray()) {
                return array2String(obj);
            }
            if (obj instanceof Throwable) {
                return UtilsBridge.getFullStackTrace((Throwable) obj);
            }
            if (obj instanceof Bundle) {
                return bundle2String((Bundle) obj);
            }
            if (obj instanceof Intent) {
                return intent2String((Intent) obj);
            }
            if (i == 32) {
                return object2Json(obj);
            }
            if (i == 48) {
                return formatXml(obj.toString());
            }
            return obj.toString();
        }

        private static String bundle2String(Bundle bundle) {
            String str;
            Iterator<String> it2 = bundle.keySet().iterator();
            if (!it2.hasNext()) {
                return "Bundle {}";
            }
            StringBuilder sb = new StringBuilder(128);
            sb.append("Bundle { ");
            while (true) {
                String next = it2.next();
                Object obj = bundle.get(next);
                sb.append(next);
                sb.append('=');
                if (obj instanceof Bundle) {
                    if (obj == bundle) {
                        str = "(this Bundle)";
                    } else {
                        str = bundle2String((Bundle) obj);
                    }
                    sb.append(str);
                } else {
                    sb.append(LogUtils.formatObject(obj));
                }
                if (!it2.hasNext()) {
                    sb.append(" }");
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        }

        private static String intent2String(Intent intent) {
            boolean z;
            Intent selector;
            String str;
            ClipData clipData;
            StringBuilder sb = new StringBuilder(128);
            sb.append("Intent { ");
            String action = intent.getAction();
            boolean z2 = true;
            boolean z3 = false;
            if (action != null) {
                sb.append("act=");
                sb.append(action);
                z = false;
            } else {
                z = true;
            }
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("cat=[");
                for (String str2 : categories) {
                    if (!z2) {
                        sb.append(',');
                    }
                    sb.append(str2);
                    z2 = false;
                }
                sb.append("]");
                z = false;
            }
            Uri data = intent.getData();
            if (data != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("dat=");
                sb.append(data);
                z = false;
            }
            String type = intent.getType();
            if (type != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("typ=");
                sb.append(type);
                z = false;
            }
            int flags = intent.getFlags();
            if (flags != 0) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("flg=0x");
                sb.append(Integer.toHexString(flags));
                z = false;
            }
            String str3 = intent.getPackage();
            if (str3 != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("pkg=");
                sb.append(str3);
                z = false;
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("cmp=");
                sb.append(component.flattenToShortString());
                z = false;
            }
            Rect sourceBounds = intent.getSourceBounds();
            if (sourceBounds != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("bnds=");
                sb.append(sourceBounds.toShortString());
                z = false;
            }
            if (Build.VERSION.SDK_INT >= 16 && (clipData = intent.getClipData()) != null) {
                if (!z) {
                    sb.append(' ');
                }
                clipData2String(clipData, sb);
                z = false;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("extras={");
                sb.append(bundle2String(extras));
                sb.append('}');
            } else {
                z3 = z;
            }
            if (Build.VERSION.SDK_INT >= 15 && (selector = intent.getSelector()) != null) {
                if (!z3) {
                    sb.append(' ');
                }
                sb.append("sel={");
                if (selector == intent) {
                    str = "(this Intent)";
                } else {
                    str = intent2String(selector);
                }
                sb.append(str);
                sb.append("}");
            }
            sb.append(" }");
            return sb.toString();
        }

        private static void clipData2String(ClipData clipData, StringBuilder sb) {
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt == null) {
                sb.append("ClipData.Item {}");
                return;
            }
            sb.append("ClipData.Item { ");
            String htmlText = itemAt.getHtmlText();
            if (htmlText != null) {
                sb.append("H:");
                sb.append(htmlText);
                sb.append("}");
                return;
            }
            CharSequence text = itemAt.getText();
            if (text != null) {
                sb.append("T:");
                sb.append(text);
                sb.append("}");
                return;
            }
            Uri uri = itemAt.getUri();
            if (uri != null) {
                sb.append("U:");
                sb.append(uri);
                sb.append("}");
                return;
            }
            Intent intent = itemAt.getIntent();
            if (intent != null) {
                sb.append("I:");
                sb.append(intent2String(intent));
                sb.append("}");
                return;
            }
            sb.append("NULL");
            sb.append("}");
        }

        private static String object2Json(Object obj) {
            if (obj instanceof CharSequence) {
                return UtilsBridge.formatJson(obj.toString());
            }
            try {
                return UtilsBridge.getGson4LogUtils().toJson(obj);
            } catch (Throwable unused) {
                return obj.toString();
            }
        }

        private static String formatJson(String str) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == '{') {
                        return new JSONObject(str).toString(2);
                    }
                    if (charAt == '[') {
                        return new JSONArray(str).toString(2);
                    }
                    if (!Character.isWhitespace(charAt)) {
                        return str;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return str;
        }

        private static String formatXml(String str) {
            try {
                StreamSource streamSource = new StreamSource(new StringReader(str));
                StreamResult streamResult = new StreamResult(new StringWriter());
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                newTransformer.setOutputProperty("indent", "yes");
                newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                newTransformer.transform(streamSource, streamResult);
                String obj = streamResult.getWriter().toString();
                return obj.replaceFirst(">", ">" + LogUtils.LINE_SEP);
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }

        private static String array2String(Object obj) {
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
        }
    }

    /* access modifiers changed from: private */
    public static <T> Class getTypeClassFromParadigm(IFormatter<T> iFormatter) {
        Type type;
        Type[] genericInterfaces = iFormatter.getClass().getGenericInterfaces();
        if (genericInterfaces.length == 1) {
            type = genericInterfaces[0];
        } else {
            type = iFormatter.getClass().getGenericSuperclass();
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        while (type2 instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type2).getRawType();
        }
        String obj = type2.toString();
        if (obj.startsWith("class ")) {
            obj = obj.substring(6);
        } else if (obj.startsWith("interface ")) {
            obj = obj.substring(10);
        }
        try {
            return Class.forName(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Class getClassFromObject(Object obj) {
        String str;
        Class<?> cls = obj.getClass();
        if (cls.isAnonymousClass() || cls.isSynthetic()) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces.length == 1) {
                Type type = genericInterfaces[0];
                while (type instanceof ParameterizedType) {
                    type = ((ParameterizedType) type).getRawType();
                }
                str = type.toString();
            } else {
                Type genericSuperclass = cls.getGenericSuperclass();
                while (genericSuperclass instanceof ParameterizedType) {
                    genericSuperclass = ((ParameterizedType) genericSuperclass).getRawType();
                }
                str = genericSuperclass.toString();
            }
            if (str.startsWith("class ")) {
                str = str.substring(6);
            } else if (str.startsWith("interface ")) {
                str = str.substring(10);
            }
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cls;
    }
}
