package com.kk.taurus.playerbase.receiver;

import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class GroupValue implements ValueInter {
    private Map<IReceiverGroup.OnGroupValueUpdateListener, String[]> mListenerKeys = new ConcurrentHashMap();
    private List<IReceiverGroup.OnGroupValueUpdateListener> mOnGroupValueUpdateListeners = new CopyOnWriteArrayList();
    private Map<String, Object> mValueMap = new ConcurrentHashMap();

    public void registerOnGroupValueUpdateListener(IReceiverGroup.OnGroupValueUpdateListener onGroupValueUpdateListener) {
        if (!this.mOnGroupValueUpdateListeners.contains(onGroupValueUpdateListener)) {
            this.mOnGroupValueUpdateListeners.add(onGroupValueUpdateListener);
            String[] filterKeys = onGroupValueUpdateListener.filterKeys();
            Arrays.sort(filterKeys);
            this.mListenerKeys.put(onGroupValueUpdateListener, filterKeys);
            checkCurrentKeySet(onGroupValueUpdateListener);
        }
    }

    private void checkCurrentKeySet(IReceiverGroup.OnGroupValueUpdateListener onGroupValueUpdateListener) {
        for (String str : this.mValueMap.keySet()) {
            if (containsKey(this.mListenerKeys.get(onGroupValueUpdateListener), str)) {
                onGroupValueUpdateListener.onValueUpdate(str, this.mValueMap.get(str));
            }
        }
    }

    public void unregisterOnGroupValueUpdateListener(IReceiverGroup.OnGroupValueUpdateListener onGroupValueUpdateListener) {
        this.mListenerKeys.remove(onGroupValueUpdateListener);
        this.mOnGroupValueUpdateListeners.remove(onGroupValueUpdateListener);
    }

    public void clearOnGroupValueUpdateListeners() {
        this.mOnGroupValueUpdateListeners.clear();
    }

    public void clearValues() {
        this.mValueMap.clear();
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putBoolean(String str, boolean z) {
        put(str, Boolean.valueOf(z));
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putInt(String str, int i) {
        put(str, Integer.valueOf(i));
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putString(String str, String str2) {
        put(str, str2);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putFloat(String str, float f) {
        put(str, Float.valueOf(f));
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putLong(String str, long j) {
        put(str, Long.valueOf(j));
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putDouble(String str, double d) {
        put(str, Double.valueOf(d));
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putObject(String str, Object obj) {
        put(str, obj);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putBoolean(String str, boolean z, boolean z2) {
        put(str, Boolean.valueOf(z), z2);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putInt(String str, int i, boolean z) {
        put(str, Integer.valueOf(i), z);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putString(String str, String str2, boolean z) {
        put(str, str2, z);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putFloat(String str, float f, boolean z) {
        put(str, Float.valueOf(f), z);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putLong(String str, long j, boolean z) {
        put(str, Long.valueOf(j), z);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putDouble(String str, double d, boolean z) {
        put(str, Double.valueOf(d), z);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public void putObject(String str, Object obj, boolean z) {
        put(str, obj, z);
    }

    private void put(String str, Object obj) {
        put(str, obj, true);
    }

    private void put(String str, Object obj, boolean z) {
        this.mValueMap.put(str, obj);
        if (z) {
            callBackValueUpdate(str, obj);
        }
    }

    private void callBackValueUpdate(String str, Object obj) {
        ArrayList<IReceiverGroup.OnGroupValueUpdateListener> arrayList = new ArrayList();
        for (IReceiverGroup.OnGroupValueUpdateListener onGroupValueUpdateListener : this.mOnGroupValueUpdateListeners) {
            if (containsKey(this.mListenerKeys.get(onGroupValueUpdateListener), str)) {
                arrayList.add(onGroupValueUpdateListener);
            }
        }
        for (IReceiverGroup.OnGroupValueUpdateListener onGroupValueUpdateListener2 : arrayList) {
            onGroupValueUpdateListener2.onValueUpdate(str, obj);
        }
    }

    private boolean containsKey(String[] strArr, String str) {
        if (strArr == null || strArr.length <= 0 || Arrays.binarySearch(strArr, str) < 0) {
            return false;
        }
        return true;
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public <T> T get(String str) {
        T t = (T) this.mValueMap.get(str);
        if (t != null) {
            return t;
        }
        return null;
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public boolean getBoolean(String str, boolean z) {
        Boolean bool = (Boolean) get(str);
        if (bool == null) {
            return z;
        }
        return bool.booleanValue();
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public int getInt(String str, int i) {
        Integer num = (Integer) get(str);
        if (num == null) {
            return i;
        }
        return num.intValue();
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public String getString(String str) {
        return (String) get(str);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public float getFloat(String str, float f) {
        Float f2 = (Float) get(str);
        if (f2 == null) {
            return f;
        }
        return f2.floatValue();
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public long getLong(String str) {
        return getLong(str, 0);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public long getLong(String str, long j) {
        Long l = (Long) get(str);
        if (l == null) {
            return j;
        }
        return l.longValue();
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    @Override // com.kk.taurus.playerbase.receiver.ValueInter
    public double getDouble(String str, double d) {
        Double d2 = (Double) get(str);
        if (d2 == null) {
            return d;
        }
        return d2.doubleValue();
    }
}
