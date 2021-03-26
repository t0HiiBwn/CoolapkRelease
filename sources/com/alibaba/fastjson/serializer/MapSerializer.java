package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});
    public static MapSerializer instance = new MapSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e6, code lost:
        if (applyName(r24, r0, r1) == false) goto L_0x00e8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01fd A[Catch:{ all -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0219 A[Catch:{ all -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0255 A[Catch:{ all -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x026c A[Catch:{ all -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0297 A[Catch:{ all -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02a4 A[Catch:{ all -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7 A[Catch:{ all -> 0x0313 }] */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i, boolean z) throws IOException {
        TreeMap treeMap;
        boolean z2;
        Class<?> cls;
        String str;
        Object obj3;
        boolean z3;
        Class<?> cls2;
        Type type2;
        Object obj4;
        boolean z4;
        Object obj5 = obj;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj5 == null) {
            serializeWriter.writeNull();
            return;
        }
        Map<String, Object> map = (Map) obj5;
        int i2 = SerializerFeature.MapSortField.mask;
        if (!((serializeWriter.features & i2) == 0 && (i2 & i) == 0)) {
            if (map instanceof JSONObject) {
                map = ((JSONObject) map).getInnerMap();
            }
            if (!(map instanceof SortedMap) && !(map instanceof LinkedHashMap)) {
                try {
                    treeMap = new TreeMap(map);
                } catch (Exception unused) {
                }
                if (!jSONSerializer.containsReference(obj)) {
                    jSONSerializer.writeReference(obj);
                    return;
                }
                SerialContext serialContext = jSONSerializer.context;
                jSONSerializer.setContext(serialContext, obj5, obj2, 0);
                if (!z) {
                    try {
                        serializeWriter.write(123);
                    } catch (Throwable th) {
                        jSONSerializer.context = serialContext;
                        throw th;
                    }
                }
                jSONSerializer.incrementIndent();
                if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                    String str2 = jSONSerializer.config.typeKey;
                    Class<?> cls3 = treeMap.getClass();
                    if (!((cls3 == JSONObject.class || cls3 == HashMap.class || cls3 == LinkedHashMap.class) && treeMap.containsKey(str2))) {
                        serializeWriter.writeFieldName(str2);
                        serializeWriter.writeString(obj.getClass().getName());
                        z2 = false;
                        boolean z5 = z2;
                        Class<?> cls4 = null;
                        ObjectSerializer objectSerializer = null;
                        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                            Object value = entry.getValue();
                            String key = entry.getKey();
                            List list = jSONSerializer.propertyPreFilters;
                            if (list != null && list.size() > 0) {
                                if (key != null) {
                                    if (!(key instanceof String)) {
                                        if ((key.getClass().isPrimitive() || (key instanceof Number)) && !applyName(jSONSerializer, obj5, JSON.toJSONString(key))) {
                                            cls = cls4;
                                            obj5 = obj;
                                            cls4 = cls;
                                        }
                                    }
                                }
                            }
                            List list2 = this.propertyPreFilters;
                            if (list2 != null && list2.size() > 0) {
                                if (key != null) {
                                    if (!(key instanceof String)) {
                                        if ((key.getClass().isPrimitive() || (key instanceof Number)) && !applyName(jSONSerializer, obj5, JSON.toJSONString(key))) {
                                            cls = cls4;
                                            obj5 = obj;
                                            cls4 = cls;
                                        }
                                    }
                                }
                                if (!applyName(jSONSerializer, obj5, key)) {
                                    cls = cls4;
                                    obj5 = obj;
                                    cls4 = cls;
                                }
                            }
                            List list3 = jSONSerializer.propertyFilters;
                            if (list3 != null && list3.size() > 0) {
                                if (key != null) {
                                    if (!(key instanceof String)) {
                                        if ((key.getClass().isPrimitive() || (key instanceof Number)) && !apply(jSONSerializer, obj5, JSON.toJSONString(key), value)) {
                                            cls = cls4;
                                            obj5 = obj;
                                            cls4 = cls;
                                        }
                                    }
                                }
                                if (!apply(jSONSerializer, obj5, key, value)) {
                                    cls = cls4;
                                    obj5 = obj;
                                    cls4 = cls;
                                }
                            }
                            List list4 = this.propertyFilters;
                            if (list4 != null && list4.size() > 0) {
                                if (key != null) {
                                    if (!(key instanceof String)) {
                                        if ((key.getClass().isPrimitive() || (key instanceof Number)) && !apply(jSONSerializer, obj5, JSON.toJSONString(key), value)) {
                                            cls = cls4;
                                            obj5 = obj;
                                            cls4 = cls;
                                        }
                                    }
                                }
                                if (!apply(jSONSerializer, obj5, key, value)) {
                                    cls = cls4;
                                    obj5 = obj;
                                    cls4 = cls;
                                }
                            }
                            List list5 = jSONSerializer.nameFilters;
                            if (list5 != null && list5.size() > 0) {
                                if (key != null) {
                                    if (!(key instanceof String)) {
                                        if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                            key = processKey(jSONSerializer, obj5, JSON.toJSONString(key), value);
                                        }
                                    }
                                }
                                key = processKey(jSONSerializer, obj5, key, value);
                            }
                            List list6 = this.nameFilters;
                            if (list6 != null && list6.size() > 0) {
                                if (key != null) {
                                    if (!(key instanceof String)) {
                                        if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                            key = processKey(jSONSerializer, obj5, JSON.toJSONString(key), value);
                                        }
                                    }
                                }
                                key = processKey(jSONSerializer, obj5, key, value);
                            }
                            if (key != null) {
                                if (!(key instanceof String)) {
                                    if (!(key instanceof Map)) {
                                        if (!(key instanceof Collection)) {
                                            z4 = false;
                                            if (z4) {
                                                str = key;
                                                cls = cls4;
                                                z3 = true;
                                                obj4 = processValue(jSONSerializer, null, obj, JSON.toJSONString(key), value, i);
                                                obj3 = obj4;
                                                if (obj3 != null || SerializerFeature.isEnabled(serializeWriter.features, i, SerializerFeature.WriteMapNullValue)) {
                                                    if (str instanceof String) {
                                                        String str3 = str;
                                                        if (!z5) {
                                                            serializeWriter.write(44);
                                                        }
                                                        if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                                            jSONSerializer.println();
                                                        }
                                                        serializeWriter.writeFieldName(str3, z3);
                                                    } else {
                                                        if (!z5) {
                                                            serializeWriter.write(44);
                                                        }
                                                        if ((serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING) || SerializerFeature.isEnabled(i, SerializerFeature.WriteNonStringKeyAsString)) && !(str instanceof Enum)) {
                                                            jSONSerializer.write(JSON.toJSONString(str));
                                                        } else {
                                                            jSONSerializer.write((Object) str);
                                                        }
                                                        serializeWriter.write(58);
                                                    }
                                                    if (obj3 == null) {
                                                        serializeWriter.writeNull();
                                                        obj5 = obj;
                                                        cls4 = cls;
                                                    } else {
                                                        Class<?> cls5 = obj3.getClass();
                                                        if (cls5 != cls) {
                                                            objectSerializer = jSONSerializer.getObjectWriter(cls5);
                                                            cls2 = cls5;
                                                        } else {
                                                            cls2 = cls;
                                                        }
                                                        if (!SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName) || !(objectSerializer instanceof JavaBeanSerializer)) {
                                                            objectSerializer = objectSerializer;
                                                            objectSerializer.write(jSONSerializer, obj3, str, null, i);
                                                        } else {
                                                            if (type instanceof ParameterizedType) {
                                                                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                                                                if (actualTypeArguments.length == 2) {
                                                                    char c = z3 ? 1 : 0;
                                                                    char c2 = z3 ? 1 : 0;
                                                                    char c3 = z3 ? 1 : 0;
                                                                    char c4 = z3 ? 1 : 0;
                                                                    char c5 = z3 ? 1 : 0;
                                                                    type2 = actualTypeArguments[c];
                                                                    JavaBeanSerializer javaBeanSerializer = (JavaBeanSerializer) objectSerializer;
                                                                    objectSerializer = objectSerializer;
                                                                    javaBeanSerializer.writeNoneASM(jSONSerializer, obj3, str, type2, i);
                                                                }
                                                            }
                                                            type2 = null;
                                                            JavaBeanSerializer javaBeanSerializer = (JavaBeanSerializer) objectSerializer;
                                                            objectSerializer = objectSerializer;
                                                            javaBeanSerializer.writeNoneASM(jSONSerializer, obj3, str, type2, i);
                                                        }
                                                        obj5 = obj;
                                                        cls4 = cls2;
                                                    }
                                                    z5 = false;
                                                }
                                                obj5 = obj;
                                                cls4 = cls;
                                            } else {
                                                str = key;
                                                cls = cls4;
                                                z3 = true;
                                                obj3 = value;
                                                if (str instanceof String) {
                                                }
                                                if (obj3 == null) {
                                                }
                                                z5 = false;
                                            }
                                        }
                                    }
                                    z4 = true;
                                    if (z4) {
                                    }
                                }
                            }
                            str = key;
                            cls = cls4;
                            z3 = true;
                            obj4 = processValue(jSONSerializer, null, obj, str, value, i);
                            obj3 = obj4;
                            if (str instanceof String) {
                            }
                            if (obj3 == null) {
                            }
                            z5 = false;
                        }
                        jSONSerializer.context = serialContext;
                        jSONSerializer.decrementIdent();
                        if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat) && treeMap.size() > 0) {
                            jSONSerializer.println();
                        }
                        if (z) {
                            serializeWriter.write(125);
                            return;
                        }
                        return;
                    }
                }
                z2 = true;
                boolean z5 = z2;
                Class<?> cls4 = null;
                ObjectSerializer objectSerializer = null;
                while (r16.hasNext()) {
                }
                jSONSerializer.context = serialContext;
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                if (z) {
                }
            }
        }
        treeMap = map;
        if (!jSONSerializer.containsReference(obj)) {
        }
    }
}
