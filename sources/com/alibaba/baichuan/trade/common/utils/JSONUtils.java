package com.alibaba.baichuan.trade.common.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
    public static JSONObject getJsonObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String objectToJson(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static Boolean optBoolean(JSONObject jSONObject, String str) {
        return Boolean.valueOf(jSONObject.has(str) ? jSONObject.optBoolean(str) : false);
    }

    public static Integer optInteger(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.optInt(str));
        }
        return null;
    }

    public static Long optLong(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.optLong(str));
        }
        return null;
    }

    public static String optString(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        return null;
    }

    public static List<String> parseString2List(String str) {
        List<String> list;
        JSONException e;
        List<String> emptyList = Collections.emptyList();
        if (TextUtils.isEmpty(str)) {
            return emptyList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            list = new ArrayList<>(jSONArray.length());
            try {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    jSONArray.get(i);
                    list.add(jSONArray.get(i).toString());
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return list;
            }
        } catch (JSONException e3) {
            e = e3;
            list = emptyList;
            e.printStackTrace();
            return list;
        }
        return list;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:114:0x0145 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Byte[]] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Character[], T] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static <T> T parseStringValue(String str, Class<T> cls) {
        ?? r0 = (T) false;
        if (str == 0 || cls == null) {
            return null;
        }
        if (String.class.equals(cls)) {
            return str;
        }
        if (Short.TYPE.equals(cls) || Short.class.equals(cls)) {
            return (T) Short.valueOf(str);
        }
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls)) {
            return (T) Integer.valueOf(str);
        }
        if (Long.TYPE.equals(cls) || Long.class.equals(cls)) {
            return (T) Long.valueOf(str);
        }
        if (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) {
            return (T) Boolean.valueOf(str);
        }
        if (Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return (T) Float.valueOf(str);
        }
        if (Double.TYPE.equals(cls) || Double.class.equals(cls)) {
            return (T) Double.valueOf(str);
        }
        if (Byte.TYPE.equals(cls) || Byte.class.equals(cls)) {
            return (T) Byte.valueOf(str);
        }
        int i = 0;
        if (Character.TYPE.equals(cls) || Character.class.equals(cls)) {
            return (T) Character.valueOf(str.charAt(0));
        }
        if (Date.class.isAssignableFrom(cls)) {
            try {
                return (T) new SimpleDateFormat("yyyyMMddHHmmssSSSZ", Locale.US).parse(str);
            } catch (ParseException e) {
                throw new RuntimeException("Parse Date error", e);
            }
        } else {
            char charAt = str.charAt(0);
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (charAt == '[') {
                    try {
                        return (T) toPOJOArray(new JSONArray(str), componentType);
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                } else if (String.class.equals(componentType)) {
                    return (T) str.split(",");
                } else {
                    if (Character.TYPE.equals(componentType)) {
                        return (T) str.toCharArray();
                    }
                    if (Character.class.equals(componentType)) {
                        char[] charArray = str.toCharArray();
                        int length = charArray.length;
                        ?? r02 = (T) new Character[length];
                        while (i < length) {
                            r02[i] = Character.valueOf(charArray[i]);
                            i++;
                        }
                        return r02;
                    } else if (Byte.TYPE.equals(componentType)) {
                        return (T) Base64.decode(str, 0);
                    } else {
                        if (Byte.class.equals(componentType)) {
                            byte[] decode = Base64.decode(str, 0);
                            int length2 = decode.length;
                            r0 = (T) new Byte[length2];
                            while (i < length2) {
                                r0[i] = Byte.valueOf(decode[i]);
                                i++;
                            }
                        }
                        return (T) r0;
                    }
                }
            } else if (charAt == '{') {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return Map.class.isAssignableFrom(cls) ? (T) toMap(jSONObject) : (T) toPOJO(jSONObject, cls);
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            } else if (cls.isAssignableFrom(String.class)) {
                return str;
            } else {
                return null;
            }
        }
    }

    public static String toJson(Map<String, ? extends Object> map) {
        return toJsonObject(map).toString();
    }

    public static JSONArray toJsonArray(List<Object> list) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj instanceof Map) {
                obj = toJsonObject((Map) obj);
            }
            jSONArray.put(obj);
        }
        return jSONArray;
    }

    public static JSONArray toJsonArray(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            if (obj instanceof Map) {
                obj = toJsonObject((Map) obj);
            }
            jSONArray.put(obj);
        }
        return jSONArray;
    }

    public static JSONObject toJsonObject(Map<String, ? extends Object> map) {
        String key;
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof Map) {
                        key = entry.getKey();
                        value = toJsonObject((Map) value);
                    } else if (value instanceof List) {
                        key = entry.getKey();
                        value = toJsonArray((List) value);
                    } else if (value.getClass().isArray()) {
                        key = entry.getKey();
                        value = toJsonArray((Object[]) value);
                    } else {
                        key = entry.getKey();
                    }
                    jSONObject.put(key, value);
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJsonString(List<? extends Object> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                jSONArray.put(obj);
            }
        }
        return jSONArray.toString();
    }

    public static List<Object> toList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            arrayList.add(obj instanceof JSONObject ? toMap((JSONObject) obj) : obj instanceof JSONArray ? toList((JSONArray) obj) : jSONArray.get(i));
        }
        return arrayList;
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof JSONObject) {
                opt = toMap((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                opt = toList((JSONArray) opt);
            }
            hashMap.put(next, opt);
        }
        return hashMap;
    }

    public static <T> T toPOJO(JSONObject jSONObject, Class<T> cls) {
        char c;
        Object obj;
        if (jSONObject == null || cls == null || cls == Void.TYPE) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                Class<?> type = field.getType();
                String name = field.getName();
                if (jSONObject.has(name)) {
                    if (!type.isPrimitive()) {
                        if (type == String.class) {
                            obj = jSONObject.getString(name);
                        } else {
                            if (!(type == Boolean.class || type == Integer.class || type == Short.class || type == Long.class)) {
                                if (type != Double.class) {
                                    obj = type.isArray() ? toPOJOArray(jSONObject.getJSONArray(name), type.getComponentType()) : Map.class.isAssignableFrom(type) ? toMap(jSONObject.getJSONObject(name)) : toPOJO(jSONObject.getJSONObject(name), type);
                                }
                            }
                            obj = jSONObject.get(name);
                        }
                        field.set(newInstance, obj);
                    } else if (type == Boolean.TYPE) {
                        field.setBoolean(newInstance, jSONObject.getBoolean(name));
                    } else if (type == Byte.TYPE) {
                        field.setByte(newInstance, (byte) jSONObject.getInt(name));
                    } else if (type == Character.TYPE) {
                        String string = jSONObject.getString(name);
                        if (string != null) {
                            if (string.length() != 0) {
                                c = string.charAt(0);
                                field.setChar(newInstance, c);
                            }
                        }
                        c = 0;
                        field.setChar(newInstance, c);
                    } else if (type == Short.TYPE) {
                        field.setShort(newInstance, (short) jSONObject.getInt(name));
                    } else if (type == Integer.TYPE) {
                        field.setInt(newInstance, jSONObject.getInt(name));
                    } else if (type == Long.TYPE) {
                        field.setLong(newInstance, jSONObject.getLong(name));
                    } else if (type == Float.TYPE) {
                        field.setFloat(newInstance, (float) jSONObject.getDouble(name));
                    } else if (type == Double.TYPE) {
                        field.setDouble(newInstance, jSONObject.getDouble(name));
                    }
                }
            }
            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T[] toPOJOArray(JSONArray jSONArray, Class<T> cls) {
        char c;
        Object obj;
        if (jSONArray == null || cls == null || cls == Void.TYPE) {
            return null;
        }
        Object newInstance = Array.newInstance((Class<?>) cls, jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (!cls.isPrimitive()) {
                    if (cls == String.class) {
                        obj = jSONArray.getString(i);
                    } else {
                        if (!(cls == Boolean.class || cls == Integer.class || cls == Short.class || cls == Long.class)) {
                            if (cls != Double.class) {
                                obj = cls.isArray() ? toPOJOArray(jSONArray.getJSONArray(i), cls.getComponentType()) : Map.class.isAssignableFrom(cls) ? toMap(jSONArray.getJSONObject(i)) : toPOJO(jSONArray.getJSONObject(i), cls);
                            }
                        }
                        obj = jSONArray.get(i);
                    }
                    Array.set(newInstance, i, obj);
                } else if (cls == Boolean.TYPE) {
                    Array.setBoolean(newInstance, i, jSONArray.getBoolean(i));
                } else if (cls == Byte.TYPE) {
                    Array.setByte(newInstance, i, (byte) jSONArray.getInt(i));
                } else if (cls == Character.TYPE) {
                    String string = jSONArray.getString(i);
                    if (string != null) {
                        if (string.length() != 0) {
                            c = string.charAt(0);
                            Array.setChar(newInstance, i, c);
                        }
                    }
                    c = 0;
                    Array.setChar(newInstance, i, c);
                } else if (cls == Short.TYPE) {
                    Array.setShort(newInstance, i, (short) jSONArray.getInt(i));
                } else if (cls == Integer.TYPE) {
                    Array.setInt(newInstance, i, jSONArray.getInt(i));
                } else if (cls == Long.TYPE) {
                    Array.setLong(newInstance, i, jSONArray.getLong(i));
                } else if (cls == Float.TYPE) {
                    Array.setFloat(newInstance, i, (float) jSONArray.getDouble(i));
                } else if (cls == Double.TYPE) {
                    Array.setDouble(newInstance, i, jSONArray.getDouble(i));
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return (T[]) ((Object[]) newInstance);
    }

    public static String[] toStringArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new String[0];
        }
        String[] strArr = new String[jSONArray.length()];
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    public static Map<String, String> toStringMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.getString(next));
        }
        return hashMap;
    }
}
