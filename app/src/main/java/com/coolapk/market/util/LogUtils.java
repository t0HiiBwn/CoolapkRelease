package com.coolapk.market.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class LogUtils {
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
    private static final int CALL_STACK_INDEX = 2;
    private static final int JSON_INDENT = 4;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static boolean isInit = false;
    private static OnLogListener onLogListener;

    public interface OnLogListener {
        boolean onLog(int i, String str, String str2, Throwable th);
    }

    private static void saveInstallLog(String str, String str2, Object... objArr) {
    }

    private static void ensureInit() {
        if (!isInit) {
            isInit = true;
            Timber.plant(new TreeImpl());
        }
    }

    public static void v(String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).v(tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void v(Throwable th, String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).v(th, tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void d(String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).d(tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).d(th, tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void i(String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).i(tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void i(Throwable th, String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).i(th, tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void w(String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).w(tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void w(Throwable th, String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).w(th, tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void e(String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).e(tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void e(Throwable th) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(th.getMessage());
        Timber.tag(tagAndMessage[0]).e(th, tagAndMessage[1], new Object[0]);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], new Object[0]);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).e(th, tagAndMessage[1], objArr);
        saveInstallLog(tagAndMessage[0], tagAndMessage[1], objArr);
    }

    public static void wtf(String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).wtf(tagAndMessage[1], objArr);
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).wtf(th, tagAndMessage[1], objArr);
    }

    public static void log(int i, String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).log(i, tagAndMessage[1], objArr);
    }

    public static void log(int i, Throwable th, String str, Object... objArr) {
        ensureInit();
        String[] tagAndMessage = getTagAndMessage(str);
        Timber.tag(tagAndMessage[0]).log(i, th, tagAndMessage[1], objArr);
    }

    public static void json(String str) {
        ensureInit();
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException unused) {
        }
        String[] tagAndMessage = getTagAndMessage("");
        Timber.tag(tagAndMessage[0]).d(tagAndMessage[1], new Object[0]);
        Timber.tag(tagAndMessage[0]).d("╔═══════════════════════════════════════════════════════════════════════════════════════", new Object[0]);
        for (String str2 : str.split(LINE_SEPARATOR)) {
            Timber.tag(tagAndMessage[0]).d("║ %s", str2);
        }
        Timber.tag(tagAndMessage[0]).d("╚═══════════════════════════════════════════════════════════════════════════════════════", new Object[0]);
    }

    public static void setOnLogListener(OnLogListener onLogListener2) {
        onLogListener = onLogListener2;
    }

    private static String[] getTagAndMessage(String str) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 2) {
            StackTraceElement stackTraceElement = stackTrace[2];
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String substring = className.substring(className.lastIndexOf(46) + 1);
            return new String[]{substring, String.format("%s, at %s.%s(%s:%d)", str, substring, stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()))};
        }
        throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
    }

    private static class TreeImpl extends Timber.DebugTree {
        private TreeImpl() {
        }

        @Override // timber.log.Timber.DebugTree, timber.log.Timber.Tree
        protected void log(int i, String str, String str2, Throwable th) {
            if (LogUtils.onLogListener == null || LogUtils.onLogListener.onLog(i, str, str2, th)) {
                super.log(i, str, str2, th);
            }
        }
    }
}
