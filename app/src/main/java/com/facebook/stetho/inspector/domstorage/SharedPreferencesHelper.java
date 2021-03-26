package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

public class SharedPreferencesHelper {
    private static final String PREFS_SUFFIX = ".xml";

    private SharedPreferencesHelper() {
    }

    public static List<String> getSharedPreferenceTags(Context context) {
        ArrayList arrayList = new ArrayList();
        File file = new File(context.getApplicationInfo().dataDir + "/shared_prefs");
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                String name = file2.getName();
                if (name.endsWith(".xml")) {
                    arrayList.add(name.substring(0, name.length() - 4));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Set<Map.Entry<String, ?>> getSharedPreferenceEntriesSorted(SharedPreferences sharedPreferences) {
        TreeSet treeSet = new TreeSet(new Comparator<Map.Entry<String, ?>>() {
            /* class com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper.AnonymousClass1 */

            public int compare(Map.Entry<String, ?> entry, Map.Entry<String, ?> entry2) {
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        treeSet.addAll(sharedPreferences.getAll().entrySet());
        return treeSet;
    }

    public static String valueToString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Set)) {
            return obj.toString();
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : (Set) obj) {
            jSONArray.put(str);
        }
        return jSONArray.toString();
    }

    @Nullable
    public static Object valueFromString(String str, Object obj) throws IllegalArgumentException {
        if (obj instanceof Integer) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (obj instanceof Boolean) {
            return parseBoolean(str);
        }
        if (obj instanceof String) {
            return str;
        }
        if (obj instanceof Set) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                HashSet hashSet = new HashSet(length);
                for (int i = 0; i < length; i++) {
                    hashSet.add(jSONArray.getString(i));
                }
                return hashSet;
            } catch (JSONException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported type: " + obj.getClass().getName());
        }
    }

    private static Boolean parseBoolean(String str) throws IllegalArgumentException {
        if ("1".equals(str) || "true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("0".equals(str) || "false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException("Expected boolean, got " + str);
    }
}
