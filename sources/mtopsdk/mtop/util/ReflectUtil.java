package mtopsdk.mtop.util;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;

public class ReflectUtil {
    public static MtopRequest convertToMtopRequest(Object obj) {
        MtopRequest mtopRequest = new MtopRequest();
        if (obj != null) {
            a(mtopRequest, obj);
        }
        return mtopRequest;
    }

    public static MtopRequest convertToMtopRequest(IMTOPDataObject iMTOPDataObject) {
        MtopRequest mtopRequest = new MtopRequest();
        if (iMTOPDataObject != null) {
            a(mtopRequest, iMTOPDataObject);
        }
        return mtopRequest;
    }

    private static void a(MtopRequest mtopRequest, Object obj) {
        try {
            HashMap hashMap = new HashMap();
            Class<?> cls = obj.getClass();
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(cls.getFields()));
            hashSet.addAll(Arrays.asList(cls.getDeclaredFields()));
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                Field field = (Field) it2.next();
                String name = field.getName();
                if (!name.contains("$") && !name.equals("serialVersionUID") && !name.equals("ORIGINALJSON")) {
                    boolean z = true;
                    field.setAccessible(true);
                    char c = 65535;
                    switch (name.hashCode()) {
                        case -513196083:
                            if (name.equals("NEED_SESSION")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 397645513:
                            if (name.equals("NEED_ECODE")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1069590712:
                            if (name.equals("VERSION")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1779423664:
                            if (name.equals("API_NAME")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    if (c == 0) {
                        Object obj2 = field.get(obj);
                        if (obj2 != null) {
                            mtopRequest.setApiName(obj2.toString());
                        }
                    } else if (c == 1) {
                        Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            mtopRequest.setVersion(obj3.toString());
                        }
                    } else if (c == 2) {
                        Boolean valueOf = Boolean.valueOf(field.getBoolean(obj));
                        if (valueOf == null || !valueOf.booleanValue()) {
                            z = false;
                        }
                        mtopRequest.setNeedEcode(z);
                    } else if (c != 3) {
                        Object obj4 = field.get(obj);
                        if (obj4 != null) {
                            if (obj4 instanceof String) {
                                hashMap.put(name, obj4.toString());
                            } else {
                                hashMap.put(name, JSON.toJSONString(obj4));
                            }
                        }
                    } else {
                        Boolean valueOf2 = Boolean.valueOf(field.getBoolean(obj));
                        if (valueOf2 == null || !valueOf2.booleanValue()) {
                            z = false;
                        }
                        mtopRequest.setNeedSession(z);
                    }
                }
            }
            mtopRequest.dataParams = hashMap;
            mtopRequest.setData(convertMapToDataStr(hashMap));
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.ReflectUtil", "parseParams failed.", e);
        }
    }

    public static String convertMapToDataStr(Map<String, String> map) {
        StringBuilder sb = new StringBuilder(64);
        sb.append("{");
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!(key == null || value == null)) {
                    try {
                        sb.append(JSON.toJSONString(key));
                        sb.append(":");
                        sb.append(JSON.toJSONString(value));
                        sb.append(",");
                    } catch (Throwable th) {
                        StringBuilder sb2 = new StringBuilder(64);
                        sb2.append("[convertMapToDataStr] convert key=");
                        sb2.append(key);
                        sb2.append(",value=");
                        sb2.append(value);
                        sb2.append(" to dataStr error.");
                        TBSdkLog.e("mtopsdk.ReflectUtil", sb2.toString(), th);
                    }
                }
            }
            int length = sb.length();
            if (length > 1) {
                sb.deleteCharAt(length - 1);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public static String converMapToDataStr(Map<String, String> map) {
        return convertMapToDataStr(map);
    }

    @Deprecated
    public static Map<String, String> parseDataParams(IMTOPDataObject iMTOPDataObject) {
        if (iMTOPDataObject == null) {
            return new HashMap();
        }
        Class<?> cls = iMTOPDataObject.getClass();
        HashMap hashMap = new HashMap();
        a(iMTOPDataObject, cls.getDeclaredFields(), hashMap, false);
        a(iMTOPDataObject, cls.getFields(), hashMap, true);
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d A[Catch:{ all -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e A[Catch:{ all -> 0x0066 }] */
    @Deprecated
    private static void a(Object obj, Field[] fieldArr, HashMap<String, String> hashMap, boolean z) {
        Object obj2;
        boolean z2;
        if (!(fieldArr == null || fieldArr.length == 0)) {
            String str = null;
            for (Field field : fieldArr) {
                try {
                    str = field.getName();
                    if (!str.contains("$") && !"API_NAME".equals(str) && !"VERSION".equals(str) && !"NEED_ECODE".equals(str) && !"NEED_SESSION".equals(str)) {
                        if (!"serialVersionUID".equalsIgnoreCase(str)) {
                            if (!"ORIGINALJSON".equalsIgnoreCase(str)) {
                                if (z) {
                                    z2 = hashMap.containsKey(str);
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    field.setAccessible(true);
                                    obj2 = field.get(obj);
                                    if (obj2 != null) {
                                        try {
                                            if (obj2 instanceof String) {
                                                hashMap.put(str, obj2.toString());
                                            } else {
                                                hashMap.put(str, JSON.toJSONString(obj2));
                                            }
                                        } catch (Throwable th) {
                                            TBSdkLog.e("mtopsdk.ReflectUtil", "[parseFieldsToMap]transform biz param to json string error.---" + th.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                } catch (Throwable th2) {
                    TBSdkLog.e("mtopsdk.ReflectUtil", "[parseFieldsToMap]get biz param error through reflection.---" + th2.toString());
                    obj2 = null;
                }
            }
        }
    }

    @Deprecated
    public static void parseUrlParams(MtopRequest mtopRequest, Object obj) {
        if (obj != null) {
            Object fieldValueByName = getFieldValueByName("API_NAME", obj);
            if (fieldValueByName != null) {
                mtopRequest.setApiName(fieldValueByName.toString());
            }
            Object fieldValueByName2 = getFieldValueByName("VERSION", obj);
            if (fieldValueByName2 != null) {
                mtopRequest.setVersion(fieldValueByName2.toString());
            }
            if (needEcode(obj)) {
                mtopRequest.setNeedEcode(true);
            }
            if (needSession(obj)) {
                mtopRequest.setNeedSession(true);
            }
        }
    }

    @Deprecated
    public static Object getFieldValueByName(String str, Object obj) {
        if (!(obj == null || str == null)) {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (field.getName().equals(str)) {
                    try {
                        return field.get(obj);
                    } catch (IllegalArgumentException e) {
                        TBSdkLog.e("mtopsdk.ReflectUtil", e.toString());
                    } catch (IllegalAccessException e2) {
                        TBSdkLog.e("mtopsdk.ReflectUtil", e2.toString());
                    }
                }
            }
        }
        return null;
    }

    @Deprecated
    public static boolean needEcode(Object obj) {
        Object fieldValueByName = getFieldValueByName("NEED_ECODE", obj);
        Boolean bool = false;
        if (fieldValueByName != null) {
            bool = (Boolean) fieldValueByName;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public static boolean needSession(Object obj) {
        Object fieldValueByName = getFieldValueByName("NEED_SESSION", obj);
        Boolean bool = false;
        if (fieldValueByName != null) {
            bool = (Boolean) fieldValueByName;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public static boolean needJsonType(Object obj) {
        Object fieldValueByName = getFieldValueByName("ORIGINALJSON", obj);
        Boolean bool = false;
        if (fieldValueByName != null) {
            bool = (Boolean) fieldValueByName;
        }
        return bool.booleanValue();
    }
}
