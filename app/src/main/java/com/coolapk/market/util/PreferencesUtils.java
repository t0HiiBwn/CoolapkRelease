package com.coolapk.market.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUtils {
    private SharedPreferences defaultPreferences;

    public PreferencesUtils(Context context, String str) {
        this.defaultPreferences = context.getSharedPreferences(str, 0);
    }

    public void registerChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.defaultPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.defaultPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.defaultPreferences.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        return this.defaultPreferences.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        return this.defaultPreferences.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.defaultPreferences.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return this.defaultPreferences.getString(str, str2);
    }

    public boolean contains(String str) {
        return this.defaultPreferences.contains(str);
    }

    public EditorHelper edit() {
        return new EditorHelper(this.defaultPreferences.edit());
    }

    public static class EditorHelper {
        private SharedPreferences.Editor editor;

        public EditorHelper(SharedPreferences.Editor editor2) {
            this.editor = editor2;
        }

        public EditorHelper putBoolean(String str, boolean z) {
            this.editor.putBoolean(str, z);
            return this;
        }

        public EditorHelper putFloat(String str, float f) {
            this.editor.putFloat(str, f);
            return this;
        }

        public EditorHelper putInt(String str, int i) {
            this.editor.putInt(str, i);
            return this;
        }

        public EditorHelper putLong(String str, long j) {
            this.editor.putLong(str, j);
            return this;
        }

        public EditorHelper putString(String str, String str2) {
            this.editor.putString(str, str2);
            return this;
        }

        public EditorHelper remove(String str) {
            this.editor.remove(str);
            return this;
        }

        public EditorHelper clear() {
            this.editor.clear();
            return this;
        }

        public boolean commit() {
            boolean commit = this.editor.commit();
            this.editor = null;
            return commit;
        }

        public void apply() {
            this.editor.apply();
            this.editor = null;
        }
    }
}
