package com.coolapk.market.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Extra implements Parcelable {
    public static final Parcelable.Creator<Extra> CREATOR = new Parcelable.Creator<Extra>() {
        /* class com.coolapk.market.model.Extra.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Extra createFromParcel(Parcel parcel) {
            return new Extra(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Extra[] newArray(int i) {
            return new Extra[i];
        }
    };
    public static final Object NULL = new Object() {
        /* class com.coolapk.market.model.Extra.AnonymousClass2 */

        public boolean equals(Object obj) {
            return obj == this || obj == null;
        }

        public String toString() {
            return "null";
        }
    };
    private final JSONObject data;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Extra() {
        this((String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    public Extra(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.data = jSONObject == null ? new JSONObject() : jSONObject;
        }
        jSONObject = null;
        this.data = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public Extra put(String str, boolean z) {
        try {
            this.data.put(str, z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Extra put(String str, double d) {
        try {
            this.data.put(str, d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Extra put(String str, int i) {
        try {
            this.data.put(str, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Extra put(String str, long j) {
        try {
            this.data.put(str, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Extra put(String str, Object obj) {
        try {
            this.data.put(str, wrap(obj));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.data.optBoolean(str, z);
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double getDouble(String str, double d) {
        return this.data.optDouble(str, d);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        return this.data.optInt(str, i);
    }

    public long getLong(String str) {
        return getLong(str, 0);
    }

    public long getLong(String str, long j) {
        return this.data.optLong(str, j);
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        return this.data.optString(str, str2);
    }

    public List<Object> getList(String str) {
        JSONArray optJSONArray = this.data.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.opt(i));
            }
        }
        return arrayList;
    }

    public <T> List<T> getTypeList(String str) {
        JSONArray optJSONArray = this.data.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.opt(i));
        }
        return arrayList;
    }

    public Object[] getArray(String str) {
        JSONArray optJSONArray = this.data.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        Object[] objArr = new Object[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            objArr[i] = optJSONArray.opt(i);
        }
        return objArr;
    }

    public <T> T[] getTypeArray(String str, T[] tArr) {
        Object[] array = getArray(str);
        if (array == null) {
            return null;
        }
        int length = array.length;
        if (tArr.length < length) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), length));
        }
        System.arraycopy(array, 0, tArr, 0, length);
        if (tArr.length > length) {
            tArr[length] = null;
        }
        return tArr;
    }

    public Object getObject(String str) {
        return this.data.opt(str);
    }

    public boolean containsKey(String str) {
        return this.data.has(str);
    }

    public Iterator<String> keys() {
        return this.data.keys();
    }

    public void copy(Extra extra) {
        Iterator<String> keys = extra.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            put(next, extra.getObject(next));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.data.toString());
    }

    protected Extra(Parcel parcel) {
        this(parcel.readString());
    }

    public static Object wrap(Object obj) {
        if (obj == null) {
            return NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return new JSONArray(obj);
                }
                JSONArray jSONArray = new JSONArray();
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    jSONArray.put(wrap(Array.get(obj, i)));
                }
                return jSONArray;
            } else if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            } else {
                if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short)) {
                    return obj;
                }
                if (obj instanceof String) {
                    return obj;
                }
                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                    return obj.toString();
                }
                return null;
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return this.data.toString();
    }
}
