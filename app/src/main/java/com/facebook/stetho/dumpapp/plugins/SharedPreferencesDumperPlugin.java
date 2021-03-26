package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper;
import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SharedPreferencesDumperPlugin implements DumperPlugin {
    private static final String NAME = "prefs";
    private static final String XML_SUFFIX = ".xml";
    private final Context mAppContext;

    @Override // com.facebook.stetho.dumpapp.DumperPlugin
    public String getName() {
        return "prefs";
    }

    public SharedPreferencesDumperPlugin(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    @Override // com.facebook.stetho.dumpapp.DumperPlugin
    public void dump(DumperContext dumperContext) throws DumpUsageException {
        PrintStream stdout = dumperContext.getStdout();
        List<String> argsAsList = dumperContext.getArgsAsList();
        String remove = argsAsList.isEmpty() ? "" : argsAsList.remove(0);
        if (remove.equals("print")) {
            doPrint(stdout, argsAsList);
        } else if (remove.equals("write")) {
            doWrite(argsAsList);
        } else {
            doUsage(stdout);
        }
    }

    private void doWrite(List<String> list) throws DumpUsageException {
        Iterator<String> it2 = list.iterator();
        String nextArg = nextArg(it2, "Expected <path>");
        String nextArg2 = nextArg(it2, "Expected <key>");
        Type of = Type.of(nextArg(it2, "Expected <type>"));
        if (of != null) {
            SharedPreferences.Editor edit = getSharedPreferences(nextArg).edit();
            switch (AnonymousClass1.$SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type[of.ordinal()]) {
                case 1:
                    edit.putBoolean(nextArg2, Boolean.valueOf(nextArgValue(it2)).booleanValue());
                    break;
                case 2:
                    edit.putInt(nextArg2, Integer.valueOf(nextArgValue(it2)).intValue());
                    break;
                case 3:
                    edit.putLong(nextArg2, Long.valueOf(nextArgValue(it2)).longValue());
                    break;
                case 4:
                    edit.putFloat(nextArg2, Float.valueOf(nextArgValue(it2)).floatValue());
                    break;
                case 5:
                    edit.putString(nextArg2, nextArgValue(it2));
                    break;
                case 6:
                    putStringSet(edit, nextArg2, it2);
                    break;
            }
            edit.commit();
            return;
        }
        throw new DumpUsageException(Type.appendNamesList(new StringBuilder("Usage: prefs write <path> <key> <type> <value>, where type is one of: "), ", ").toString());
    }

    /* renamed from: com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type = iArr;
            try {
                iArr[Type.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type[Type.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type[Type.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type[Type.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type[Type.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type[Type.SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Nonnull
    private static String nextArg(Iterator<String> it2, String str) throws DumpUsageException {
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new DumpUsageException(str);
    }

    @Nonnull
    private static String nextArgValue(Iterator<String> it2) throws DumpUsageException {
        return nextArg(it2, "Expected <value>");
    }

    private static void putStringSet(SharedPreferences.Editor editor, String str, Iterator<String> it2) {
        HashSet hashSet = new HashSet();
        while (it2.hasNext()) {
            hashSet.add(it2.next());
        }
        editor.putStringSet(str, hashSet);
    }

    private void doPrint(PrintStream printStream, List<String> list) {
        String str;
        String str2 = this.mAppContext.getApplicationInfo().dataDir + "/shared_prefs";
        String str3 = list.isEmpty() ? "" : list.get(0);
        if (list.size() > 1) {
            str = list.get(1);
        } else {
            str = "";
        }
        printRecursive(printStream, str2, "", str3, str);
    }

    private void printRecursive(PrintStream printStream, String str, String str2, String str3, String str4) {
        String[] list;
        File file = new File(str, str2);
        if (file.isFile()) {
            if (str2.endsWith(".xml")) {
                printFile(printStream, str2.substring(0, str2.length() - 4), str4);
            }
        } else if (file.isDirectory() && (list = file.list()) != null) {
            for (int i = 0; i < list.length; i++) {
                String str5 = TextUtils.isEmpty(str2) ? list[i] : str2 + File.separator + list[i];
                if (str5.startsWith(str3)) {
                    printRecursive(printStream, str, str5, str3, str4);
                }
            }
        }
    }

    private void printFile(PrintStream printStream, String str, String str2) {
        printStream.println(str + ":");
        for (Map.Entry<String, ?> entry : SharedPreferencesHelper.getSharedPreferenceEntriesSorted(getSharedPreferences(str))) {
            if (entry.getKey().startsWith(str2)) {
                printStream.println("  " + entry.getKey() + " = " + entry.getValue());
            }
        }
    }

    private void doUsage(PrintStream printStream) {
        printStream.println("Usage: dumpapp prefs <command> [command-options]");
        printStream.println("Usage: dumpapp prefs print [pathPrefix [keyPrefix]]");
        StringBuilder sb = new StringBuilder("       dumpapp prefs ");
        sb.append("write <path> <key> <");
        StringBuilder appendNamesList = Type.appendNamesList(sb, "|");
        appendNamesList.append("> <value>");
        printStream.println(appendNamesList);
        printStream.println();
        printStream.println("dumpapp prefs print: Print all matching values from the shared preferences");
        printStream.println();
        printStream.println("dumpapp prefs write: Writes a value to the shared preferences");
    }

    private SharedPreferences getSharedPreferences(String str) {
        return this.mAppContext.getSharedPreferences(str, 4);
    }

    private enum Type {
        BOOLEAN("boolean"),
        INT("int"),
        LONG("long"),
        FLOAT("float"),
        STRING("string"),
        SET("set");
        
        private final String name;

        private Type(String str) {
            this.name = str;
        }

        @Nullable
        public static Type of(String str) {
            Type[] values = values();
            for (Type type : values) {
                if (type.name.equals(str)) {
                    return type;
                }
            }
            return null;
        }

        public static StringBuilder appendNamesList(StringBuilder sb, String str) {
            Type[] values = values();
            boolean z = true;
            for (Type type : values) {
                if (z) {
                    z = false;
                } else {
                    sb.append(str);
                }
                sb.append(type.name);
            }
            return sb;
        }
    }
}
