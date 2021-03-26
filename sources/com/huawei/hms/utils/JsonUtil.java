package com.huawei.hms.utils;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    protected static final int VAL_BYTE = 2;
    protected static final int VAL_ENTITY = 0;
    protected static final int VAL_LIST = 1;
    protected static final int VAL_MAP = 3;
    protected static final int VAL_NULL = -1;
    protected static final String VAL_TYPE = "_val_type_";

    public static String createJsonString(IMessageEntity iMessageEntity) {
        if (iMessageEntity == null) {
            HMSLog.e("JsonUtil", "createJsonString error, the input IMessageEntity is null");
            return "";
        }
        try {
            return a(iMessageEntity);
        } catch (IllegalAccessException e) {
            HMSLog.e("JsonUtil", "catch IllegalAccessException " + e.getMessage());
            return "";
        } catch (JSONException e2) {
            HMSLog.e("JsonUtil", "catch JSONException " + e2.getMessage());
            return "";
        }
    }

    private static String a(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(Packed.class)) {
                    boolean isAccessible = field.isAccessible();
                    a(field, true);
                    String name = field.getName();
                    Object obj = field.get(iMessageEntity);
                    a(field, isAccessible);
                    a(name, obj, jSONObject);
                }
            }
        }
        return jSONObject.toString();
    }

    private static void a(final Field field, final boolean z) {
        AccessController.doPrivileged(new PrivilegedAction() {
            /* class com.huawei.hms.utils.JsonUtil.AnonymousClass1 */

            @Override // java.security.PrivilegedAction
            public Object run() {
                field.setAccessible(z);
                return null;
            }
        });
    }

    private static boolean a(String str, Object obj, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        if (obj instanceof String) {
            jSONObject.put(str, (String) obj);
            return true;
        } else if (obj instanceof Integer) {
            jSONObject.put(str, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Short) {
            jSONObject.put(str, (Short) obj);
            return true;
        } else if (obj instanceof Long) {
            jSONObject.put(str, (Long) obj);
            return true;
        } else if (obj instanceof Float) {
            jSONObject.put(str, (Float) obj);
            return true;
        } else if (obj instanceof Double) {
            jSONObject.put(str, (Double) obj);
            return true;
        } else if (obj instanceof Boolean) {
            jSONObject.put(str, (Boolean) obj);
            return true;
        } else if (obj instanceof JSONObject) {
            jSONObject.put(str, (JSONObject) obj);
            return true;
        } else if (obj instanceof byte[]) {
            a(str, (byte[]) obj, jSONObject);
            return true;
        } else if (obj instanceof List) {
            a(str, (List<?>) ((List) obj), jSONObject);
            return true;
        } else if (obj instanceof Map) {
            a(str, (Map) obj, jSONObject);
            return true;
        } else {
            if (obj instanceof IMessageEntity) {
                try {
                    jSONObject.put(str, a((IMessageEntity) obj));
                    return true;
                } catch (IllegalAccessException e) {
                    HMSLog.e("JsonUtil", "IllegalAccessException , " + e);
                }
            }
            return false;
        }
    }

    private static void a(String str, Map map, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof IMessageEntity) {
                jSONArray.put(a((IMessageEntity) key));
            } else {
                jSONArray.put(key);
            }
            if (value instanceof IMessageEntity) {
                jSONArray.put(a((IMessageEntity) value));
            } else {
                jSONArray.put(value);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("_val_type_", 3);
        jSONObject2.put("_map_", jSONArray.toString());
        jSONObject.put(str, jSONObject2);
    }

    private static void a(String str, byte[] bArr, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("_val_type_", 2);
        try {
            jSONObject2.put("_byte_", Base64.encode(bArr));
        } catch (IllegalArgumentException e) {
            HMSLog.e("JsonUtil", "writeByte failed : " + e.getMessage());
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void a(String str, List<?> list, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("_val_type_", 1);
        jSONObject2.put("_list_size_", list.size());
        for (int i = 0; i < list.size(); i++) {
            a("_list_item_" + i, list.get(i), jSONObject2);
            if (list.get(i) instanceof IMessageEntity) {
                jSONObject2.put("_val_type_", 0);
            }
        }
        jSONObject.put(str, jSONObject2);
    }

    public static IMessageEntity jsonToEntity(String str, IMessageEntity iMessageEntity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                Field[] declaredFields = cls.getDeclaredFields();
                for (Field field : declaredFields) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        try {
                            a(iMessageEntity, field, jSONObject);
                        } catch (IllegalAccessException unused) {
                            HMSLog.e("JsonUtil", "jsonToEntity, set value of the field exception, field name:" + field.getName());
                        }
                    }
                }
            }
        } catch (JSONException e) {
            HMSLog.e("JsonUtil", "catch JSONException when parse jsonString" + e.getMessage());
        }
        return iMessageEntity;
    }

    private static void a(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object b = b(iMessageEntity, field, jSONObject);
        if (b != null) {
            boolean isAccessible = field.isAccessible();
            a(field, true);
            field.set(iMessageEntity, b);
            a(field, isAccessible);
        }
    }

    private static Object b(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object a = a(field.getName(), jSONObject);
        if (a != null) {
            try {
                if (field.getType().getName().startsWith("com.huawei") && (field.getType().newInstance() instanceof IMessageEntity)) {
                    return jsonToEntity((String) a, (IMessageEntity) field.getType().newInstance());
                }
                if (!(a instanceof JSONObject) || !((JSONObject) a).has("_val_type_")) {
                    return a;
                }
                int i = ((JSONObject) a).getInt("_val_type_");
                if (i != 1) {
                    if (i != 0) {
                        if (i == 2) {
                            return a((JSONObject) a);
                        }
                        if (i == 3) {
                            return a(field.getGenericType(), (JSONObject) a);
                        }
                        HMSLog.e("JsonUtil", "cannot support type : " + i);
                    }
                }
                return b(field.getGenericType(), (JSONObject) a);
            } catch (InstantiationException unused) {
                HMSLog.e("JsonUtil", "InstantiationException  ");
            }
        }
        return null;
    }

    private static Object a(String str, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.get(str);
        }
        if (jSONObject.has("header") && jSONObject.getJSONObject("header").has(str)) {
            return jSONObject.getJSONObject("header").get(str);
        }
        if (!jSONObject.has("body") || !jSONObject.getJSONObject("body").has(str)) {
            return null;
        }
        return jSONObject.getJSONObject("body").get(str);
    }

    private static Map a(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        JSONArray jSONArray = new JSONArray(jSONObject.getString("_map_"));
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i += 2) {
            if (cls.newInstance() instanceof IMessageEntity) {
                hashMap.put(jSONArray.get(i), jsonToEntity(jSONArray.getString(i + 1), (IMessageEntity) cls.newInstance()));
            } else {
                hashMap.put(jSONArray.get(i), jSONArray.get(i + 1));
            }
        }
        return hashMap;
    }

    private static List<Object> b(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        int i = jSONObject.getInt("_list_size_");
        int i2 = jSONObject.getInt("_val_type_");
        ArrayList arrayList = new ArrayList(i);
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = jSONObject.get("_list_item_" + i3);
            if (i2 == 0) {
                arrayList.add(jsonToEntity((String) obj, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else if (i2 == 1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static byte[] a(JSONObject jSONObject) throws JSONException {
        try {
            return Base64.decode(jSONObject.getString("_byte_"));
        } catch (IllegalArgumentException e) {
            HMSLog.e("JsonUtil", "readByte failed : " + e.getMessage());
            return null;
        }
    }

    public static Object getInfoFromJsonobject(String str, String str2) {
        if (!str.isEmpty() && !str2.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has(str2)) {
                    return null;
                }
                Object obj = jSONObject.get(str2);
                if (obj instanceof String) {
                    return obj;
                }
            } catch (JSONException unused) {
                HMSLog.e("JsonUtil", "getInfoFromJsonobject:parser json error :" + str2);
            }
        }
        return null;
    }

    public static String getStringValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    public static int getIntValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return -1;
        }
        return jSONObject.getInt(str);
    }
}
