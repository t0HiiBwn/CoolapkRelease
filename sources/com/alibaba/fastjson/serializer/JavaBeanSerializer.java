package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        boolean z;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        while (true) {
            FieldSerializer[] fieldSerializerArr = this.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
            i++;
        }
        if (serializeBeanInfo.fields == serializeBeanInfo.sortedFields) {
            this.getters = this.sortedGetters;
        } else {
            this.getters = new FieldSerializer[serializeBeanInfo.fields.length];
            int i2 = 0;
            while (true) {
                if (i2 >= this.getters.length) {
                    z = false;
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i2].name);
                if (fieldSerializer == null) {
                    z = true;
                    break;
                } else {
                    this.getters[i2] = fieldSerializer;
                    i2++;
                }
            }
            if (z) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
            }
        }
        if (serializeBeanInfo.jsonType != null) {
            for (Class<? extends SerializeFilter> cls : serializeBeanInfo.jsonType.serialzeFilters()) {
                try {
                    addFilter((SerializeFilter) cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                }
            }
        }
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:358:0x04ef */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:405:0x05cf */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.alibaba.fastjson.serializer.JavaBeanSerializer] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r1v35, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v49, types: [com.alibaba.fastjson.serializer.JavaBeanSerializer] */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x02bc, code lost:
        if ((r3 & com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask) == 0) goto L_0x037b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        r1 = r0;
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0064, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        r3 = r0;
        r2 = r7;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x0494, code lost:
        if (r5 == false) goto L_0x0473;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x04ca, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x04cc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x04cd, code lost:
        r26 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x04cf, code lost:
        r1 = r36;
        r3 = r0;
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x04fe, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x04ff, code lost:
        r1 = r0;
        r2 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0504, code lost:
        r0 = e;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0528, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0529, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x052d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x052e, code lost:
        r2 = r7;
        r1 = r10;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0531, code lost:
        r12 = null;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:?, code lost:
        r4 = r4 + ", class " + r36.getClass().getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x0559, code lost:
        r4 = r4 + ", fieldName : " + r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0572, code lost:
        r5 = r12.fieldInfo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0576, code lost:
        if (r5.method != null) goto L_0x0578;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x0578, code lost:
        r4 = r4 + ", method : " + r5.method.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0593, code lost:
        r4 = r4 + ", fieldName : " + r12.fieldInfo.name;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x05af, code lost:
        r4 = r4 + ", " + r3.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x05cb, code lost:
        r17 = r3.getCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x05d2, code lost:
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x05da, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0107, code lost:
        if (r13.fieldTransient != false) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x010a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x010b, code lost:
        r3 = r0;
        r2 = r7;
        r1 = r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f A[ExcHandler: all (r0v19 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r7 
      PHI: (r7v7 com.alibaba.fastjson.serializer.SerialContext) = (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v0 com.alibaba.fastjson.serializer.SerialContext), (r7v0 com.alibaba.fastjson.serializer.SerialContext) binds: [B:62:0x00da, B:63:?, B:65:0x00ec, B:66:?, B:100:0x0155, B:101:?, B:73:0x0105, B:74:?, B:23:0x005b, B:24:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:23:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x03ec  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0475  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x049a  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x04e3  */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x04ef A[SYNTHETIC, Splitter:B:358:0x04ef] */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x04fe A[Catch:{ Exception -> 0x0504, all -> 0x04fe }, ExcHandler: all (r0v10 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ Exception -> 0x0504, all -> 0x04fe }]), PHI: r33 
      PHI: (r33v4 com.alibaba.fastjson.serializer.SerialContext) = (r33v0 com.alibaba.fastjson.serializer.SerialContext), (r33v8 com.alibaba.fastjson.serializer.SerialContext), (r33v8 com.alibaba.fastjson.serializer.SerialContext), (r33v9 com.alibaba.fastjson.serializer.SerialContext), (r33v9 com.alibaba.fastjson.serializer.SerialContext) binds: [B:358:0x04ef, B:113:0x01a0, B:114:?, B:339:0x04a7, B:340:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:113:0x01a0] */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x050d A[Catch:{ Exception -> 0x0504, all -> 0x04fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0528 A[ExcHandler: all (th java.lang.Throwable), PHI: r7 
      PHI: (r7v1 com.alibaba.fastjson.serializer.SerialContext) = (r7v0 com.alibaba.fastjson.serializer.SerialContext), (r7v0 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext), (r7v2 com.alibaba.fastjson.serializer.SerialContext) binds: [B:29:0x006a, B:30:?, B:59:0x00d7, B:60:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:29:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x0537 A[SYNTHETIC, Splitter:B:387:0x0537] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0559  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x056c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x05af  */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x05cb  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00da A[SYNTHETIC, Splitter:B:62:0x00da] */
    /* JADX WARNING: Unknown variable types count: 1 */
    protected void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i, boolean z) throws IOException {
        FieldSerializer[] fieldSerializerArr;
        SerialContext serialContext;
        FieldSerializer fieldSerializer;
        Exception exc;
        Object obj3;
        boolean z2;
        FieldSerializer fieldSerializer2;
        int i2;
        FieldSerializer fieldSerializer3;
        Object obj4;
        Exception e;
        SerialContext serialContext2;
        ?? r1;
        Object obj5;
        FieldSerializer fieldSerializer4;
        char c;
        boolean z3;
        Object obj6;
        boolean z4;
        Map map;
        boolean z5;
        char c2;
        Class<?> cls;
        Object obj7 = obj;
        Type type2 = type;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj7 == null) {
            serializeWriter.writeNull();
        } else if (!writeReference(jSONSerializer, obj7, i)) {
            if (serializeWriter.sortField) {
                fieldSerializerArr = this.sortedGetters;
            } else {
                fieldSerializerArr = this.getters;
            }
            FieldSerializer[] fieldSerializerArr2 = fieldSerializerArr;
            SerialContext serialContext3 = jSONSerializer.context;
            if (!this.beanInfo.beanType.isEnum()) {
                jSONSerializer.setContext(serialContext3, obj, obj2, this.beanInfo.features, i);
            }
            boolean isWriteAsArray = isWriteAsArray(jSONSerializer, i);
            char c3 = isWriteAsArray ? '[' : '{';
            char c4 = isWriteAsArray ? ']' : '}';
            Throwable th = null;
            if (!z) {
                try {
                    serializeWriter.append(c3);
                } catch (Exception e2) {
                    fieldSerializer = fieldSerializer4;
                    obj3 = obj;
                    exc = e2;
                    serialContext = serialContext3;
                    String str = "write javaBean error, fastjson version 1.2.68";
                    if (obj3 != null) {
                    }
                    if (obj2 != null) {
                    }
                    if (exc.getMessage() != null) {
                    }
                    if (exc instanceof InvocationTargetException) {
                    }
                    if (th != null) {
                    }
                    throw new JSONException(str, exc);
                } catch (Throwable th2) {
                }
            }
            try {
                if (fieldSerializerArr2.length > 0 && serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                    jSONSerializer.incrementIndent();
                    jSONSerializer.println();
                }
                if (!((this.beanInfo.features & SerializerFeature.WriteClassName.mask) == 0 && (SerializerFeature.WriteClassName.mask & i) == 0 && !jSONSerializer.isWriteClassName(type2, obj7))) {
                    Class<?> cls2 = obj.getClass();
                    if (cls2 != ((cls2 == type2 || !(type2 instanceof WildcardType)) ? type2 : TypeUtils.getClass(type))) {
                        writeClassName(jSONSerializer, this.beanInfo.typeKey, obj7);
                        z2 = true;
                        char c5 = !z2 ? ',' : 0;
                        boolean isEnabled = serializeWriter.isEnabled(SerializerFeature.WriteClassName);
                        boolean z6 = writeBefore(jSONSerializer, obj7, c5) != ',';
                        boolean isEnabled2 = serializeWriter.isEnabled(SerializerFeature.SkipTransientField);
                        boolean isEnabled3 = serializeWriter.isEnabled(SerializerFeature.IgnoreNonFieldGetter);
                        boolean z7 = z6;
                        fieldSerializer2 = null;
                        i2 = 0;
                        while (i2 < fieldSerializerArr2.length) {
                            fieldSerializer4 = fieldSerializerArr2[i2];
                            Field field = fieldSerializer4.fieldInfo.field;
                            FieldInfo fieldInfo = fieldSerializer4.fieldInfo;
                            String str2 = fieldInfo.name;
                            Class<?> cls3 = fieldInfo.fieldClass;
                            fieldSerializer3 = fieldSerializer2;
                            boolean isEnabled4 = SerializerFeature.isEnabled(serializeWriter.features, fieldInfo.serialzeFeatures, SerializerFeature.UseSingleQuotes);
                            boolean z8 = serializeWriter.quoteFieldNames && !isEnabled4;
                            if (isEnabled2 && fieldInfo != null) {
                            }
                            if (!isEnabled3 || field != null) {
                                if (applyName(jSONSerializer, obj7, str2) && applyLabel(jSONSerializer, fieldInfo.label)) {
                                    z3 = false;
                                } else if (isWriteAsArray) {
                                    z3 = true;
                                }
                                if (this.beanInfo.typeKey == null || !str2.equals(this.beanInfo.typeKey) || !jSONSerializer.isWriteClassName(type2, obj7)) {
                                    if (!z3) {
                                        try {
                                            obj6 = fieldSerializer4.getPropertyValueDirect(obj7);
                                        } catch (InvocationTargetException e3) {
                                            if (serializeWriter.isEnabled(SerializerFeature.IgnoreErrorGetter)) {
                                                fieldSerializer3 = fieldSerializer4;
                                            } else {
                                                fieldSerializer = fieldSerializer4;
                                                serialContext2 = serialContext3;
                                                throw e3;
                                            }
                                        } catch (Exception e4) {
                                            obj5 = obj;
                                            exc = e4;
                                        } catch (Throwable th3) {
                                        }
                                        if (apply(jSONSerializer, obj7, str2, obj6)) {
                                            String str3 = obj6;
                                            if (cls3 == String.class) {
                                                str3 = obj6;
                                                str3 = obj6;
                                                if ("trim".equals(fieldInfo.format) && obj6 != null) {
                                                    str3 = ((String) obj6).trim();
                                                }
                                            }
                                            String processKey = processKey(jSONSerializer, obj7, str2, str3);
                                            r1 = this;
                                            c = c4;
                                            serialContext2 = serialContext3;
                                            try {
                                                int processValue = r1.processValue(jSONSerializer, fieldSerializer4.fieldContext, obj, str2, str3, i);
                                                if (processValue == null) {
                                                    int i3 = fieldInfo.serialzeFeatures;
                                                    JSONField annotation = fieldInfo.getAnnotation();
                                                    if (this.beanInfo.jsonType != null) {
                                                        i3 |= SerializerFeature.of(this.beanInfo.jsonType.serialzeFeatures());
                                                    }
                                                    if (annotation != null && !"".equals(annotation.defaultValue())) {
                                                        processValue = annotation.defaultValue();
                                                    } else if (cls3 == Boolean.class) {
                                                        int i4 = SerializerFeature.WriteNullBooleanAsFalse.mask;
                                                        int i5 = SerializerFeature.WriteMapNullValue.mask | i4;
                                                        if (!(!isWriteAsArray && (i3 & i5) == 0 && (i5 & serializeWriter.features) == 0)) {
                                                            if ((i3 & i4) != 0) {
                                                                processValue = false;
                                                            } else if ((i4 & serializeWriter.features) != 0 && (i3 & SerializerFeature.WriteMapNullValue.mask) == 0) {
                                                                processValue = false;
                                                            }
                                                        }
                                                        fieldSerializer2 = fieldSerializer3;
                                                        i2++;
                                                        obj7 = obj;
                                                        type2 = type;
                                                        fieldSerializerArr2 = fieldSerializerArr2;
                                                        c4 = c;
                                                        serialContext3 = serialContext2;
                                                    } else if (cls3 == String.class) {
                                                        int i6 = SerializerFeature.WriteNullStringAsEmpty.mask;
                                                        int i7 = SerializerFeature.WriteMapNullValue.mask | i6;
                                                        if (!(!isWriteAsArray && (i3 & i7) == 0 && (i7 & serializeWriter.features) == 0)) {
                                                            if ((i3 & i6) != 0 || ((i6 & serializeWriter.features) != 0 && (i3 & SerializerFeature.WriteMapNullValue.mask) == 0)) {
                                                                processValue = "";
                                                            }
                                                        }
                                                        fieldSerializer2 = fieldSerializer3;
                                                        i2++;
                                                        obj7 = obj;
                                                        type2 = type;
                                                        fieldSerializerArr2 = fieldSerializerArr2;
                                                        c4 = c;
                                                        serialContext3 = serialContext2;
                                                    } else if (Number.class.isAssignableFrom(cls3)) {
                                                        int i8 = SerializerFeature.WriteNullNumberAsZero.mask;
                                                        int i9 = SerializerFeature.WriteMapNullValue.mask | i8;
                                                        if (!(!isWriteAsArray && (i3 & i9) == 0 && (i9 & serializeWriter.features) == 0)) {
                                                            if ((i3 & i8) != 0) {
                                                                processValue = 0;
                                                            } else if ((i8 & serializeWriter.features) != 0 && (i3 & SerializerFeature.WriteMapNullValue.mask) == 0) {
                                                                processValue = 0;
                                                            }
                                                        }
                                                        fieldSerializer2 = fieldSerializer3;
                                                        i2++;
                                                        obj7 = obj;
                                                        type2 = type;
                                                        fieldSerializerArr2 = fieldSerializerArr2;
                                                        c4 = c;
                                                        serialContext3 = serialContext2;
                                                    } else if (Collection.class.isAssignableFrom(cls3)) {
                                                        int i10 = SerializerFeature.WriteNullListAsEmpty.mask;
                                                        int i11 = SerializerFeature.WriteMapNullValue.mask | i10;
                                                        if (!(!isWriteAsArray && (i3 & i11) == 0 && (i11 & serializeWriter.features) == 0)) {
                                                            if ((i3 & i10) != 0) {
                                                                processValue = Collections.emptyList();
                                                            } else if ((i10 & serializeWriter.features) != 0 && (i3 & SerializerFeature.WriteMapNullValue.mask) == 0) {
                                                                processValue = Collections.emptyList();
                                                            }
                                                        }
                                                        fieldSerializer2 = fieldSerializer3;
                                                        i2++;
                                                        obj7 = obj;
                                                        type2 = type;
                                                        fieldSerializerArr2 = fieldSerializerArr2;
                                                        c4 = c;
                                                        serialContext3 = serialContext2;
                                                    } else if (!isWriteAsArray) {
                                                        if (!fieldSerializer4.writeNull) {
                                                            if (!serializeWriter.isEnabled(SerializerFeature.WriteMapNullValue.mask)) {
                                                            }
                                                        }
                                                    }
                                                }
                                                if (processValue == null || ((!serializeWriter.notWriteDefaultValue && (fieldInfo.serialzeFeatures & SerializerFeature.NotWriteDefaultValue.mask) == 0 && (this.beanInfo.features & SerializerFeature.NotWriteDefaultValue.mask) == 0) || (!((cls = fieldInfo.fieldClass) == Byte.TYPE && (processValue instanceof Byte) && ((Byte) processValue).byteValue() == 0) && (!(cls == Short.TYPE && (processValue instanceof Short) && ((Short) processValue).shortValue() == 0) && (!(cls == Integer.TYPE && (processValue instanceof Integer) && ((Integer) processValue).intValue() == 0) && (!(cls == Long.TYPE && (processValue instanceof Long) && ((Long) processValue).longValue() == 0) && (!(cls == Float.TYPE && (processValue instanceof Float) && ((Float) processValue).floatValue() == 0.0f) && (!(cls == Double.TYPE && (processValue instanceof Double) && ((Double) processValue).doubleValue() == 0.0d) && (cls != Boolean.TYPE || !(processValue instanceof Boolean) || ((Boolean) processValue).booleanValue()))))))))) {
                                                    if (z7) {
                                                        if (!fieldInfo.unwrapped || !(processValue instanceof Map) || ((Map) processValue).size() != 0) {
                                                            serializeWriter.write(44);
                                                            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                                                jSONSerializer.println();
                                                            }
                                                        }
                                                    }
                                                    if (processKey != str2) {
                                                        if (!isWriteAsArray) {
                                                            serializeWriter.writeFieldName(processKey, true);
                                                        }
                                                        jSONSerializer.write(processValue);
                                                    } else if (str3 != processValue) {
                                                        if (!isWriteAsArray) {
                                                            fieldSerializer4.writePrefix(jSONSerializer);
                                                        }
                                                        jSONSerializer.write(processValue);
                                                    } else {
                                                        if (!isWriteAsArray) {
                                                            boolean isAssignableFrom = Map.class.isAssignableFrom(cls3);
                                                            boolean z9 = (!cls3.isPrimitive() && !cls3.getName().startsWith("java.")) || cls3 == Object.class;
                                                            if (isEnabled || !fieldInfo.unwrapped || (!isAssignableFrom && !z9)) {
                                                                if (z8) {
                                                                    c2 = 0;
                                                                    serializeWriter.write(fieldInfo.name_chars, 0, fieldInfo.name_chars.length);
                                                                } else {
                                                                    c2 = 0;
                                                                    fieldSerializer4.writePrefix(jSONSerializer);
                                                                }
                                                                if (isWriteAsArray) {
                                                                    JSONField annotation2 = fieldInfo.getAnnotation();
                                                                    if (cls3 == String.class && (annotation2 == null || annotation2.serializeUsing() == Void.class)) {
                                                                        if (processValue == null) {
                                                                            int i12 = fieldSerializer4.features;
                                                                            if (this.beanInfo.jsonType != null) {
                                                                                i12 |= SerializerFeature.of(this.beanInfo.jsonType.serialzeFeatures());
                                                                            }
                                                                            if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0 && (SerializerFeature.WriteMapNullValue.mask & i12) == 0) {
                                                                                serializeWriter.writeString("");
                                                                            } else if ((i12 & SerializerFeature.WriteNullStringAsEmpty.mask) != 0) {
                                                                                serializeWriter.writeString("");
                                                                            } else {
                                                                                serializeWriter.writeNull();
                                                                            }
                                                                        } else {
                                                                            String str4 = (String) processValue;
                                                                            if (isEnabled4) {
                                                                                serializeWriter.writeStringWithSingleQuote(str4);
                                                                            } else {
                                                                                serializeWriter.writeStringWithDoubleQuote(str4, c2);
                                                                            }
                                                                        }
                                                                    } else if (!fieldInfo.unwrapped || !(processValue instanceof Map) || ((Map) processValue).size() != 0) {
                                                                        fieldSerializer4.writeValue(jSONSerializer, processValue);
                                                                    } else {
                                                                        fieldSerializer2 = fieldSerializer3;
                                                                        z7 = false;
                                                                        i2++;
                                                                        obj7 = obj;
                                                                        type2 = type;
                                                                        fieldSerializerArr2 = fieldSerializerArr2;
                                                                        c4 = c;
                                                                        serialContext3 = serialContext2;
                                                                    }
                                                                } else {
                                                                    fieldSerializer4.writeValue(jSONSerializer, processValue);
                                                                }
                                                                if (fieldInfo.unwrapped && (processValue instanceof Map)) {
                                                                    map = (Map) processValue;
                                                                    if (map.size() != 0) {
                                                                        if (!jSONSerializer.isEnabled(SerializerFeature.WriteMapNullValue)) {
                                                                            Iterator it2 = map.values().iterator();
                                                                            while (true) {
                                                                                if (it2.hasNext()) {
                                                                                    if (it2.next() != null) {
                                                                                        z5 = true;
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    z5 = false;
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    z4 = true;
                                                                    if (!z4) {
                                                                        fieldSerializer2 = fieldSerializer3;
                                                                        z7 = true;
                                                                        i2++;
                                                                        obj7 = obj;
                                                                        type2 = type;
                                                                        fieldSerializerArr2 = fieldSerializerArr2;
                                                                        c4 = c;
                                                                        serialContext3 = serialContext2;
                                                                    }
                                                                    fieldSerializer2 = fieldSerializer3;
                                                                    i2++;
                                                                    obj7 = obj;
                                                                    type2 = type;
                                                                    fieldSerializerArr2 = fieldSerializerArr2;
                                                                    c4 = c;
                                                                    serialContext3 = serialContext2;
                                                                }
                                                                z4 = false;
                                                                if (!z4) {
                                                                }
                                                                fieldSerializer2 = fieldSerializer3;
                                                                i2++;
                                                                obj7 = obj;
                                                                type2 = type;
                                                                fieldSerializerArr2 = fieldSerializerArr2;
                                                                c4 = c;
                                                                serialContext3 = serialContext2;
                                                            }
                                                        }
                                                        c2 = 0;
                                                        if (isWriteAsArray) {
                                                        }
                                                        map = (Map) processValue;
                                                        if (map.size() != 0) {
                                                        }
                                                        z4 = true;
                                                        if (!z4) {
                                                        }
                                                        fieldSerializer2 = fieldSerializer3;
                                                        i2++;
                                                        obj7 = obj;
                                                        type2 = type;
                                                        fieldSerializerArr2 = fieldSerializerArr2;
                                                        c4 = c;
                                                        serialContext3 = serialContext2;
                                                    }
                                                    map = (Map) processValue;
                                                    if (map.size() != 0) {
                                                    }
                                                    z4 = true;
                                                    if (!z4) {
                                                    }
                                                    fieldSerializer2 = fieldSerializer3;
                                                    i2++;
                                                    obj7 = obj;
                                                    type2 = type;
                                                    fieldSerializerArr2 = fieldSerializerArr2;
                                                    c4 = c;
                                                    serialContext3 = serialContext2;
                                                }
                                                fieldSerializer2 = fieldSerializer3;
                                                i2++;
                                                obj7 = obj;
                                                type2 = type;
                                                fieldSerializerArr2 = fieldSerializerArr2;
                                                c4 = c;
                                                serialContext3 = serialContext2;
                                            } catch (Exception e5) {
                                                Exception e6 = e5;
                                                Object obj8 = obj;
                                                exc = e6;
                                                fieldSerializer = fieldSerializer3;
                                                obj5 = obj8;
                                                serialContext = serialContext2;
                                                obj3 = obj5;
                                                String str = "write javaBean error, fastjson version 1.2.68";
                                                if (obj3 != null) {
                                                }
                                                if (obj2 != null) {
                                                }
                                                if (exc.getMessage() != null) {
                                                }
                                                if (exc instanceof InvocationTargetException) {
                                                }
                                                if (th != null) {
                                                }
                                                throw new JSONException(str, exc);
                                            } catch (Throwable th3) {
                                            }
                                        }
                                    }
                                    obj6 = null;
                                    if (apply(jSONSerializer, obj7, str2, obj6)) {
                                    }
                                }
                            }
                            c = c4;
                            serialContext2 = serialContext3;
                            fieldSerializer2 = fieldSerializer3;
                            i2++;
                            obj7 = obj;
                            type2 = type;
                            fieldSerializerArr2 = fieldSerializerArr2;
                            c4 = c;
                            serialContext3 = serialContext2;
                        }
                        fieldSerializer3 = fieldSerializer2;
                        serialContext2 = serialContext3;
                        r1 = obj;
                        writeAfter(jSONSerializer, r1, !z7 ? ',' : 0);
                        if (fieldSerializerArr2.length > 0) {
                            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                jSONSerializer.decrementIdent();
                                jSONSerializer.println();
                            }
                        }
                        if (!z) {
                            serializeWriter.append(c4);
                        }
                        jSONSerializer.context = serialContext2;
                    }
                }
                z2 = false;
                if (!z2) {
                }
                boolean isEnabled = serializeWriter.isEnabled(SerializerFeature.WriteClassName);
                if (writeBefore(jSONSerializer, obj7, c5) != ',') {
                }
                boolean isEnabled2 = serializeWriter.isEnabled(SerializerFeature.SkipTransientField);
                boolean isEnabled3 = serializeWriter.isEnabled(SerializerFeature.IgnoreNonFieldGetter);
                boolean z7 = z6;
                fieldSerializer2 = null;
                i2 = 0;
                while (i2 < fieldSerializerArr2.length) {
                }
                fieldSerializer3 = fieldSerializer2;
                serialContext2 = serialContext3;
                r1 = obj;
                try {
                    writeAfter(jSONSerializer, r1, !z7 ? ',' : 0);
                    if (fieldSerializerArr2.length > 0) {
                    }
                    if (!z) {
                    }
                    jSONSerializer.context = serialContext2;
                } catch (Exception e7) {
                    e = e7;
                    serialContext = serialContext2;
                    obj4 = r1;
                    exc = e;
                    fieldSerializer = fieldSerializer3;
                    obj3 = obj4;
                    String str = "write javaBean error, fastjson version 1.2.68";
                    if (obj3 != null) {
                    }
                    if (obj2 != null) {
                    }
                    if (exc.getMessage() != null) {
                    }
                    if (exc instanceof InvocationTargetException) {
                    }
                    if (th != null) {
                    }
                    throw new JSONException(str, exc);
                } catch (Throwable th4) {
                    th = th4;
                    serialContext = serialContext2;
                    Throwable th5 = th;
                    jSONSerializer.context = serialContext;
                    throw th5;
                }
            } catch (Exception e8) {
                e = e8;
                fieldSerializer3 = fieldSerializer2;
                serialContext = serialContext3;
                obj4 = obj7;
                exc = e;
                fieldSerializer = fieldSerializer3;
                obj3 = obj4;
                String str = "write javaBean error, fastjson version 1.2.68";
                if (obj3 != null) {
                }
                if (obj2 != null) {
                }
                if (exc.getMessage() != null) {
                }
                if (exc instanceof InvocationTargetException) {
                }
                if (th != null) {
                }
                throw new JSONException(str, exc);
            } catch (Throwable th6) {
            }
        }
    }

    protected void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class<?> cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || jSONSerializer.references == null || !jSONSerializer.references.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (InvocationTargetException e) {
                throw new JSONException("getFieldValue error." + str, e);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            }
        } else {
            throw new JSONException("field not found. " + str);
        }
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (InvocationTargetException e) {
                throw new JSONException("getFieldValue error." + str, e);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            }
        } else if (!z) {
            return null;
        } else {
            throw new JSONException("field not found. " + str);
        }
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedGetters.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.sortedGetters[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[(this.sortedGetters.length * propertyNamingStrategyArr.length)];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArr) {
                    String translate = propertyNamingStrategy.translate(str);
                    if (!str.equals(translate)) {
                        jArr[i2] = TypeUtils.fnv1a_64(translate);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArr) {
                    String translate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(translate2) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate2))) >= 0) {
                        sArr[binarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        FieldSerializer[] fieldSerializerArr = this.sortedGetters;
        for (FieldSerializer fieldSerializer : fieldSerializerArr) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        HashSet hashSet = new HashSet();
        FieldSerializer[] fieldSerializerArr = this.sortedGetters;
        for (FieldSerializer fieldSerializer : fieldSerializerArr) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        FieldSerializer[] fieldSerializerArr = this.sortedGetters;
        for (FieldSerializer fieldSerializer : fieldSerializerArr) {
            boolean isEnabled = SerializerFeature.isEnabled(fieldSerializer.features, SerializerFeature.SkipTransientField);
            FieldInfo fieldInfo = fieldSerializer.fieldInfo;
            if (!isEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                if (fieldSerializer.fieldInfo.unwrapped) {
                    Object json = JSON.toJSON(fieldSerializer.getPropertyValue(obj));
                    if (json instanceof Map) {
                        linkedHashMap.putAll((Map) json);
                    } else {
                        linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                    }
                } else {
                    linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                }
            }
        }
        return linkedHashMap;
    }

    protected BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    protected Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    protected char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.beforeFilters != null) {
            for (BeforeFilter beforeFilter : jSONSerializer.beforeFilters) {
                c = beforeFilter.writeBefore(jSONSerializer, obj, c);
            }
        }
        if (this.beforeFilters != null) {
            for (BeforeFilter beforeFilter2 : this.beforeFilters) {
                c = beforeFilter2.writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.afterFilters != null) {
            for (AfterFilter afterFilter : jSONSerializer.afterFilters) {
                c = afterFilter.writeAfter(jSONSerializer, obj, c);
            }
        }
        if (this.afterFilters != null) {
            for (AfterFilter afterFilter2 : this.afterFilters) {
                c = afterFilter2.writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        if (jSONSerializer.labelFilters != null) {
            for (LabelFilter labelFilter : jSONSerializer.labelFilters) {
                if (!labelFilter.apply(str)) {
                    return false;
                }
            }
        }
        if (this.labelFilters == null) {
            return true;
        }
        for (LabelFilter labelFilter2 : this.labelFilters) {
            if (!labelFilter2.apply(str)) {
                return false;
            }
        }
        return true;
    }
}
