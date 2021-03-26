package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public Type[] creatorConstructorParameterTypes;
    public String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;

    /* renamed from: kotlin  reason: collision with root package name */
    public boolean f1188kotlin;
    public Constructor<?> kotlinDefaultConstructor;
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        JSONField jSONField;
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String typeName2 = jSONType.typeName();
            String typeKey2 = jSONType.typeKey();
            this.typeKey = typeKey2.length() <= 0 ? null : typeKey2;
            if (typeName2.length() != 0) {
                this.typeName = typeName2;
            } else {
                this.typeName = cls.getName();
            }
            String[] orders2 = jSONType.orders();
            this.orders = orders2.length == 0 ? null : orders2;
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            this.orders = null;
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[list.size()];
        this.fields = fieldInfoArr;
        list.toArray(fieldInfoArr);
        FieldInfo[] fieldInfoArr2 = new FieldInfo[fieldInfoArr.length];
        boolean z = false;
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : fieldInfoArr) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            String[] strArr = this.orders;
            int i = 0;
            for (String str : strArr) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr2[i] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i++;
                }
            }
            for (FieldInfo fieldInfo3 : linkedHashMap.values()) {
                fieldInfoArr2[i] = fieldInfo3;
                i++;
            }
        } else {
            System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, fieldInfoArr.length);
            Arrays.sort(fieldInfoArr2);
        }
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr2) ? this.fields : fieldInfoArr2;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            boolean isKotlin = TypeUtils.isKotlin(cls);
            this.f1188kotlin = isKotlin;
            if (isKotlin) {
                this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                try {
                    this.kotlinDefaultConstructor = cls.getConstructor(new Class[0]);
                } catch (Throwable unused) {
                }
                Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor2);
                int i2 = 0;
                while (i2 < this.creatorConstructorParameters.length && i2 < parameterAnnotations.length) {
                    Annotation[] annotationArr = parameterAnnotations[i2];
                    int length = annotationArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            jSONField = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i3];
                        if (annotation instanceof JSONField) {
                            jSONField = (JSONField) annotation;
                            break;
                        }
                        i3++;
                    }
                    if (jSONField != null) {
                        String name = jSONField.name();
                        if (name.length() > 0) {
                            this.creatorConstructorParameters[i2] = name;
                        }
                    }
                    i2++;
                }
                return;
            }
            if (this.creatorConstructorParameterTypes.length == this.fields.length) {
                int i4 = 0;
                while (true) {
                    Type[] typeArr = this.creatorConstructorParameterTypes;
                    if (i4 >= typeArr.length) {
                        z = true;
                        break;
                    } else if (typeArr[i4] != this.fields[i4].fieldClass) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            if (!z) {
                this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
            }
        }
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo fieldInfo : list) {
            if (fieldInfo.name.equals(str)) {
                return fieldInfo;
            }
            Field field = fieldInfo.field;
            if (!(field == null || fieldInfo.getAnnotation() == null || !field.getName().equals(str))) {
                return fieldInfo;
            }
        }
        return null;
    }

    static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        for (int size = list.size() - 1; size >= 0; size--) {
            FieldInfo fieldInfo2 = list.get(size);
            if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                    list.set(size, fieldInfo);
                    return true;
                } else if (fieldInfo2.compareTo(fieldInfo) >= 0) {
                    return false;
                } else {
                    list.set(size, fieldInfo);
                    return true;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, false);
    }

    private static Map<TypeVariable, Type> buildGenericInfo(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            cls = superclass;
            if (cls == null || cls == Object.class) {
                break;
            }
            if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    if (hashMap.containsKey(actualTypeArguments[i])) {
                        hashMap.put(typeParameters[i], hashMap.get(actualTypeArguments[i]));
                    } else {
                        hashMap.put(typeParameters[i], actualTypeArguments[i]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return hashMap;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        return build(cls, type, propertyNamingStrategy, z, z2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:349:0x078a, code lost:
        if (r4 == null) goto L_0x078c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x097c, code lost:
        if (r1.deserialize() == false) goto L_0x098c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x05ef  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x05ff  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x07bf  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x07f3  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0859  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0869  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x086f  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x08b3  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x09e6  */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x0895 A[EDGE_INSN: B:475:0x0895->B:379:0x0895 ?: BREAK  , SYNTHETIC] */
    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2, boolean z3) {
        Constructor<?> constructor;
        JSONType jSONType;
        PropertyNamingStrategy propertyNamingStrategy2;
        Constructor<?> constructor2;
        Method[] methodArr;
        Method method;
        ArrayList arrayList;
        String str;
        PropertyNamingStrategy propertyNamingStrategy3;
        Field[] fieldArr;
        Method method2;
        ArrayList arrayList2;
        Class<?> cls2;
        char c;
        int length;
        int i;
        int i2;
        int length2;
        int i3;
        Field[] fieldArr2;
        int i4;
        int i5;
        Method[] methodArr2;
        Type type2;
        JSONField jSONField;
        Field[] fieldArr3;
        String str2;
        Field[] fieldArr4;
        String str3;
        int i6;
        int i7;
        Class<?> cls3;
        Method[] methodArr3;
        PropertyNamingStrategy propertyNamingStrategy4;
        int i8;
        Field[] fieldArr5;
        Field field;
        String str4;
        JSONField jSONField2;
        int i9;
        String substring;
        String str5;
        PropertyNamingStrategy propertyNamingStrategy5;
        Class<?> cls4;
        Field[] fieldArr6;
        Method[] methodArr4;
        int i10;
        int i11;
        Method method3;
        String str6;
        ArrayList arrayList3;
        String str7;
        String str8;
        int i12;
        int i13;
        int i14;
        String str9;
        StringBuilder sb;
        char charAt;
        String[] strArr;
        JSONField jSONField3;
        int i15;
        int i16;
        int i17;
        String[] lookupParameterNames;
        String[] strArr2;
        JSONField jSONField4;
        int i18;
        int i19;
        int i20;
        String str10;
        Annotation[][] annotationArr;
        JSONField jSONField5;
        int i21;
        int i22;
        int i23;
        String str11;
        Field field2;
        Field field3;
        String[] strArr3;
        Field field4;
        Constructor<?> constructor3;
        PropertyNamingStrategy naming;
        Class<?> cls5 = cls;
        boolean z4 = z3;
        JSONType jSONType2 = (JSONType) TypeUtils.getAnnotation(cls5, JSONType.class);
        PropertyNamingStrategy propertyNamingStrategy6 = (jSONType2 == null || (naming = jSONType2.naming()) == null || naming == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : naming;
        Class<?> builderClass2 = getBuilderClass(cls5, jSONType2);
        Field[] declaredFields = cls.getDeclaredFields();
        Method[] methods = cls.getMethods();
        Map<TypeVariable, Type> buildGenericInfo = buildGenericInfo(cls);
        boolean isKotlin = TypeUtils.isKotlin(cls);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (!isKotlin || declaredConstructors.length == 1) {
            if (builderClass2 == null) {
                constructor3 = getDefaultConstructor(cls5, declaredConstructors);
            } else {
                constructor3 = getDefaultConstructor(builderClass2, builderClass2.getDeclaredConstructors());
            }
            constructor = constructor3;
        } else {
            constructor = null;
        }
        Method method4 = null;
        ArrayList arrayList4 = new ArrayList();
        if (z) {
            for (Class<?> cls6 = cls5; cls6 != null; cls6 = cls6.getSuperclass()) {
                computeFields(cls5, type, propertyNamingStrategy6, arrayList4, cls6.getDeclaredFields());
            }
            if (constructor != null) {
                TypeUtils.setAccessible(constructor);
            }
            return new JavaBeanInfo(cls, builderClass2, constructor, null, null, null, jSONType2, arrayList4);
        }
        boolean z5 = cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
        if (!(constructor == null && builderClass2 == null) && !z5) {
            propertyNamingStrategy2 = propertyNamingStrategy6;
            jSONType = jSONType2;
            arrayList = arrayList4;
            methodArr = methods;
            constructor2 = null;
        } else {
            constructor2 = getCreatorConstructor(declaredConstructors);
            if (constructor2 == null || z5) {
                propertyNamingStrategy2 = propertyNamingStrategy6;
                jSONType = jSONType2;
                arrayList = arrayList4;
                methodArr = methods;
                method = getFactoryMethod(cls5, methodArr, z4);
                if (method != null) {
                    TypeUtils.setAccessible(method);
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length > 0) {
                        Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(method);
                        String[] strArr4 = null;
                        int i24 = 0;
                        while (i24 < parameterTypes.length) {
                            Annotation[] annotationArr2 = parameterAnnotations[i24];
                            int length3 = annotationArr2.length;
                            int i25 = 0;
                            while (true) {
                                if (i25 >= length3) {
                                    jSONField4 = null;
                                    break;
                                }
                                Annotation annotation = annotationArr2[i25];
                                if (annotation instanceof JSONField) {
                                    jSONField4 = (JSONField) annotation;
                                    break;
                                }
                                i25++;
                            }
                            if (jSONField4 != null || (z4 && TypeUtils.isJacksonCreator(method))) {
                                if (jSONField4 != null) {
                                    str10 = jSONField4.name();
                                    int ordinal = jSONField4.ordinal();
                                    int of = SerializerFeature.of(jSONField4.serialzeFeatures());
                                    i20 = ordinal;
                                    i18 = Feature.of(jSONField4.parseFeatures());
                                    i19 = of;
                                } else {
                                    str10 = null;
                                    i20 = 0;
                                    i19 = 0;
                                    i18 = 0;
                                }
                                if (str10 == null || str10.length() == 0) {
                                    if (strArr4 == null) {
                                        strArr4 = ASMUtils.lookupParameterNames(method);
                                    }
                                    str10 = strArr4[i24];
                                }
                                add(arrayList, new FieldInfo(str10, cls, parameterTypes[i24], method.getGenericParameterTypes()[i24], TypeUtils.getField(cls5, str10, declaredFields), i20, i19, i18));
                                i24++;
                                z4 = z3;
                                parameterTypes = parameterTypes;
                                strArr4 = strArr4;
                            } else {
                                throw new JSONException("illegal json creator");
                            }
                        }
                        return new JavaBeanInfo(cls, builderClass2, null, null, method, null, jSONType, arrayList);
                    }
                } else if (!z5) {
                    String name = cls.getName();
                    if (!isKotlin || declaredConstructors.length <= 0) {
                        String[] strArr5 = null;
                        for (Constructor<?> constructor4 : declaredConstructors) {
                            Class<?>[] parameterTypes2 = constructor4.getParameterTypes();
                            if (name.equals("org.springframework.security.web.authentication.WebAuthenticationDetails")) {
                                if (parameterTypes2.length == 2) {
                                    if (parameterTypes2[0] == String.class && parameterTypes2[1] == String.class) {
                                        constructor4.setAccessible(true);
                                        strArr2 = ASMUtils.lookupParameterNames(constructor4);
                                    }
                                }
                            } else if (name.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken")) {
                                if (parameterTypes2.length == 3 && parameterTypes2[0] == Object.class) {
                                    if (parameterTypes2[1] == Object.class && parameterTypes2[2] == Collection.class) {
                                        constructor4.setAccessible(true);
                                        strArr = new String[]{"principal", "credentials", "authorities"};
                                        constructor2 = constructor4;
                                    }
                                }
                            } else {
                                if (!name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                    if (((constructor4.getModifiers() & 1) != 0) && (lookupParameterNames = ASMUtils.lookupParameterNames(constructor4)) != null && lookupParameterNames.length != 0 && (constructor2 == null || strArr5 == null || lookupParameterNames.length > strArr5.length)) {
                                        constructor2 = constructor4;
                                        strArr5 = lookupParameterNames;
                                    }
                                } else if (parameterTypes2.length == 1) {
                                    if (parameterTypes2[0] == String.class) {
                                        strArr2 = new String[]{"authority"};
                                    }
                                }
                            }
                            strArr = strArr2;
                            constructor2 = constructor4;
                            break;
                        }
                        strArr = strArr5;
                        Class<?>[] parameterTypes3 = strArr == null ? constructor2.getParameterTypes() : null;
                        if (strArr == null && parameterTypes3.length == strArr.length) {
                            Annotation[][] parameterAnnotations2 = TypeUtils.getParameterAnnotations(constructor2);
                            int i26 = 0;
                            while (i26 < parameterTypes3.length) {
                                Annotation[] annotationArr3 = parameterAnnotations2[i26];
                                String str12 = strArr[i26];
                                int length4 = annotationArr3.length;
                                int i27 = 0;
                                while (true) {
                                    if (i27 >= length4) {
                                        jSONField3 = null;
                                        break;
                                    }
                                    Annotation annotation2 = annotationArr3[i27];
                                    if (annotation2 instanceof JSONField) {
                                        jSONField3 = (JSONField) annotation2;
                                        break;
                                    }
                                    i27++;
                                }
                                Class<?> cls7 = parameterTypes3[i26];
                                Type type3 = constructor2.getGenericParameterTypes()[i26];
                                Field field5 = TypeUtils.getField(cls5, str12, declaredFields);
                                if (field5 != null && jSONField3 == null) {
                                    jSONField3 = (JSONField) TypeUtils.getAnnotation(field5, JSONField.class);
                                }
                                if (jSONField3 != null) {
                                    String name2 = jSONField3.name();
                                    if (name2.length() != 0) {
                                        str12 = name2;
                                    }
                                    int ordinal2 = jSONField3.ordinal();
                                    int of2 = SerializerFeature.of(jSONField3.serialzeFeatures());
                                    i15 = Feature.of(jSONField3.parseFeatures());
                                    i16 = of2;
                                    i17 = ordinal2;
                                } else if (!"org.springframework.security.core.userdetails.User".equals(name) || !"password".equals(str12)) {
                                    i17 = 0;
                                    i16 = 0;
                                    i15 = 0;
                                } else {
                                    i15 = Feature.InitStringFieldAsEmpty.mask;
                                    i17 = 0;
                                    i16 = 0;
                                }
                                add(arrayList, new FieldInfo(str12, cls, cls7, type3, field5, i17, i16, i15));
                                i26++;
                                name = name;
                                strArr = strArr;
                                parameterTypes3 = parameterTypes3;
                            }
                            if (!isKotlin && !cls.getName().equals("javax.servlet.http.Cookie")) {
                                return new JavaBeanInfo(cls, builderClass2, null, constructor2, null, null, jSONType, arrayList);
                            }
                        } else {
                            throw new JSONException("default constructor not found. " + cls5);
                        }
                    } else {
                        String[] koltinConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                        Constructor<?> koltinConstructor = TypeUtils.getKoltinConstructor(declaredConstructors, koltinConstructorParameters);
                        TypeUtils.setAccessible(koltinConstructor);
                        constructor2 = koltinConstructor;
                        strArr = koltinConstructorParameters;
                    }
                    if (strArr == null) {
                    }
                    if (strArr == null) {
                    }
                    throw new JSONException("default constructor not found. " + cls5);
                }
                if (constructor != null) {
                    TypeUtils.setAccessible(constructor);
                }
                String str13 = "set";
                if (builderClass2 == null) {
                    JSONPOJOBuilder jSONPOJOBuilder = (JSONPOJOBuilder) TypeUtils.getAnnotation(builderClass2, JSONPOJOBuilder.class);
                    String withPrefix = jSONPOJOBuilder != null ? jSONPOJOBuilder.withPrefix() : null;
                    if (withPrefix == null) {
                        withPrefix = "with";
                    }
                    String str14 = withPrefix;
                    Method[] methods2 = builderClass2.getMethods();
                    int length5 = methods2.length;
                    int i28 = 0;
                    while (i28 < length5) {
                        Method method5 = methods2[i28];
                        if (!Modifier.isStatic(method5.getModifiers()) && method5.getReturnType().equals(builderClass2)) {
                            JSONField jSONField6 = (JSONField) TypeUtils.getAnnotation(method5, JSONField.class);
                            if (jSONField6 == null) {
                                jSONField6 = TypeUtils.getSuperMethodAnnotation(cls5, method5);
                            }
                            if (jSONField6 == null) {
                                i11 = i28;
                                i10 = length5;
                                methodArr4 = methods2;
                                str7 = str14;
                                str8 = str13;
                                fieldArr6 = declaredFields;
                                cls4 = builderClass2;
                                method3 = method;
                                propertyNamingStrategy5 = propertyNamingStrategy2;
                                arrayList3 = arrayList;
                                i14 = 0;
                                i13 = 0;
                                i12 = 0;
                            } else if (jSONField6.deserialize()) {
                                int ordinal3 = jSONField6.ordinal();
                                int of3 = SerializerFeature.of(jSONField6.serialzeFeatures());
                                int of4 = Feature.of(jSONField6.parseFeatures());
                                if (jSONField6.name().length() != 0) {
                                    i11 = i28;
                                    i10 = length5;
                                    methodArr4 = methods2;
                                    fieldArr6 = declaredFields;
                                    cls4 = builderClass2;
                                    method3 = method;
                                    propertyNamingStrategy5 = propertyNamingStrategy2;
                                    arrayList3 = arrayList;
                                    add(arrayList3, new FieldInfo(jSONField6.name(), method5, null, cls, type, ordinal3, of3, of4, jSONField6, null, null, buildGenericInfo));
                                    str6 = str14;
                                    str5 = str13;
                                    i28 = i11 + 1;
                                    arrayList = arrayList3;
                                    str14 = str6;
                                    method = method3;
                                    length5 = i10;
                                    methods2 = methodArr4;
                                    declaredFields = fieldArr6;
                                    builderClass2 = cls4;
                                    propertyNamingStrategy2 = propertyNamingStrategy5;
                                    str13 = str5;
                                } else {
                                    i11 = i28;
                                    i10 = length5;
                                    methodArr4 = methods2;
                                    str7 = str14;
                                    str8 = str13;
                                    fieldArr6 = declaredFields;
                                    cls4 = builderClass2;
                                    method3 = method;
                                    propertyNamingStrategy5 = propertyNamingStrategy2;
                                    arrayList3 = arrayList;
                                    i14 = ordinal3;
                                    i13 = of3;
                                    i12 = of4;
                                }
                            }
                            String name3 = method5.getName();
                            if (name3.startsWith(str8) && name3.length() > 3) {
                                sb = new StringBuilder(name3.substring(3));
                            } else if (str7.length() == 0) {
                                sb = new StringBuilder(name3);
                            } else {
                                str9 = str7;
                                if (name3.startsWith(str9) && name3.length() > str9.length()) {
                                    sb = new StringBuilder(name3.substring(str9.length()));
                                    charAt = sb.charAt(0);
                                    if (str9.length() == 0 || Character.isUpperCase(charAt)) {
                                        sb.setCharAt(0, Character.toLowerCase(charAt));
                                        str6 = str9;
                                        str5 = str8;
                                        add(arrayList3, new FieldInfo(sb.toString(), method5, null, cls, type, i14, i13, i12, jSONField6, null, null, buildGenericInfo));
                                        i28 = i11 + 1;
                                        arrayList = arrayList3;
                                        str14 = str6;
                                        method = method3;
                                        length5 = i10;
                                        methods2 = methodArr4;
                                        declaredFields = fieldArr6;
                                        builderClass2 = cls4;
                                        propertyNamingStrategy2 = propertyNamingStrategy5;
                                        str13 = str5;
                                    }
                                }
                                str6 = str9;
                                str5 = str8;
                                i28 = i11 + 1;
                                arrayList = arrayList3;
                                str14 = str6;
                                method = method3;
                                length5 = i10;
                                methods2 = methodArr4;
                                declaredFields = fieldArr6;
                                builderClass2 = cls4;
                                propertyNamingStrategy2 = propertyNamingStrategy5;
                                str13 = str5;
                            }
                            str9 = str7;
                            charAt = sb.charAt(0);
                            sb.setCharAt(0, Character.toLowerCase(charAt));
                            str6 = str9;
                            str5 = str8;
                            add(arrayList3, new FieldInfo(sb.toString(), method5, null, cls, type, i14, i13, i12, jSONField6, null, null, buildGenericInfo));
                            i28 = i11 + 1;
                            arrayList = arrayList3;
                            str14 = str6;
                            method = method3;
                            length5 = i10;
                            methods2 = methodArr4;
                            declaredFields = fieldArr6;
                            builderClass2 = cls4;
                            propertyNamingStrategy2 = propertyNamingStrategy5;
                            str13 = str5;
                        }
                        i11 = i28;
                        i10 = length5;
                        methodArr4 = methods2;
                        str6 = str14;
                        str5 = str13;
                        fieldArr6 = declaredFields;
                        cls4 = builderClass2;
                        method3 = method;
                        propertyNamingStrategy5 = propertyNamingStrategy2;
                        arrayList3 = arrayList;
                        i28 = i11 + 1;
                        arrayList = arrayList3;
                        str14 = str6;
                        method = method3;
                        length5 = i10;
                        methods2 = methodArr4;
                        declaredFields = fieldArr6;
                        builderClass2 = cls4;
                        propertyNamingStrategy2 = propertyNamingStrategy5;
                        str13 = str5;
                    }
                    str = str13;
                    fieldArr = declaredFields;
                    method2 = method;
                    propertyNamingStrategy3 = propertyNamingStrategy2;
                    arrayList2 = arrayList;
                    cls2 = builderClass2;
                    if (cls2 != null) {
                        JSONPOJOBuilder jSONPOJOBuilder2 = (JSONPOJOBuilder) TypeUtils.getAnnotation(cls2, JSONPOJOBuilder.class);
                        String buildMethod2 = jSONPOJOBuilder2 != null ? jSONPOJOBuilder2.buildMethod() : null;
                        if (buildMethod2 == null || buildMethod2.length() == 0) {
                            buildMethod2 = "build";
                        }
                        c = 0;
                        try {
                            method4 = cls2.getMethod(buildMethod2, new Class[0]);
                        } catch (NoSuchMethodException | SecurityException unused) {
                        }
                        if (method4 == null) {
                            try {
                                method4 = cls2.getMethod("create", new Class[0]);
                            } catch (NoSuchMethodException | SecurityException unused2) {
                            }
                        }
                        if (method4 != null) {
                            TypeUtils.setAccessible(method4);
                            length = methodArr.length;
                            i = 0;
                            while (true) {
                                i2 = 4;
                                if (i >= length) {
                                    break;
                                }
                                Method method6 = methodArr[i];
                                int i29 = 0;
                                int i30 = 0;
                                int i31 = 0;
                                String name4 = method6.getName();
                                if (!Modifier.isStatic(method6.getModifiers())) {
                                    Class<?> returnType = method6.getReturnType();
                                    if ((returnType.equals(Void.TYPE) || returnType.equals(method6.getDeclaringClass())) && method6.getDeclaringClass() != Object.class) {
                                        Class<?>[] parameterTypes4 = method6.getParameterTypes();
                                        if (parameterTypes4.length != 0 && parameterTypes4.length <= 2) {
                                            JSONField jSONField7 = (JSONField) TypeUtils.getAnnotation(method6, JSONField.class);
                                            if (jSONField7 != null && parameterTypes4.length == 2 && parameterTypes4[c] == String.class && parameterTypes4[1] == Object.class) {
                                                i7 = i;
                                                i6 = length;
                                                cls3 = cls2;
                                                add(arrayList2, new FieldInfo("", method6, null, cls, type, 0, 0, 0, jSONField7, null, null, buildGenericInfo));
                                            } else {
                                                i7 = i;
                                                i6 = length;
                                                cls3 = cls2;
                                                if (parameterTypes4.length == 1) {
                                                    JSONField superMethodAnnotation = jSONField7 == null ? TypeUtils.getSuperMethodAnnotation(cls5, method6) : jSONField7;
                                                    if (superMethodAnnotation != null || name4.length() >= 4) {
                                                        if (superMethodAnnotation == null) {
                                                            methodArr3 = methodArr;
                                                            i8 = 1;
                                                        } else if (superMethodAnnotation.deserialize()) {
                                                            i29 = superMethodAnnotation.ordinal();
                                                            i30 = SerializerFeature.of(superMethodAnnotation.serialzeFeatures());
                                                            int of5 = Feature.of(superMethodAnnotation.parseFeatures());
                                                            if (superMethodAnnotation.name().length() != 0) {
                                                                methodArr3 = methodArr;
                                                                add(arrayList2, new FieldInfo(superMethodAnnotation.name(), method6, null, cls, type, i29, i30, of5, superMethodAnnotation, null, null, buildGenericInfo));
                                                                fieldArr4 = fieldArr;
                                                                propertyNamingStrategy4 = propertyNamingStrategy3;
                                                                str3 = str;
                                                                i = i7 + 1;
                                                                cls5 = cls;
                                                                propertyNamingStrategy3 = propertyNamingStrategy4;
                                                                methodArr = methodArr3;
                                                                cls2 = cls3;
                                                                length = i6;
                                                                str = str3;
                                                                fieldArr = fieldArr4;
                                                                c = 0;
                                                            } else {
                                                                methodArr3 = methodArr;
                                                                i8 = 1;
                                                                i31 = of5;
                                                            }
                                                        }
                                                        if ((superMethodAnnotation != null || name4.startsWith(str)) && cls3 == null) {
                                                            char charAt2 = name4.charAt(3);
                                                            if (Character.isUpperCase(charAt2) || charAt2 > 512) {
                                                                fieldArr5 = fieldArr;
                                                                str4 = TypeUtils.compatibleWithJavaBean ? TypeUtils.decapitalize(name4.substring(3)) : Character.toLowerCase(name4.charAt(3)) + name4.substring(4);
                                                                field = null;
                                                                if (field == null) {
                                                                    field = TypeUtils.getField(cls5, str4, fieldArr5);
                                                                }
                                                                if (field == null && parameterTypes4[0] == Boolean.TYPE) {
                                                                    field = TypeUtils.getField(cls5, "is" + Character.toUpperCase(str4.charAt(0)) + str4.substring(i8), fieldArr5);
                                                                }
                                                                if (field == null) {
                                                                    JSONField jSONField8 = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                                                                    if (jSONField8 != null) {
                                                                        if (jSONField8.deserialize()) {
                                                                            i29 = jSONField8.ordinal();
                                                                            i30 = SerializerFeature.of(jSONField8.serialzeFeatures());
                                                                            i31 = Feature.of(jSONField8.parseFeatures());
                                                                            if (jSONField8.name().length() != 0) {
                                                                                fieldArr4 = fieldArr5;
                                                                                str3 = str;
                                                                                add(arrayList2, new FieldInfo(jSONField8.name(), method6, field, cls, type, i29, i30, i31, superMethodAnnotation, jSONField8, null, buildGenericInfo));
                                                                                propertyNamingStrategy4 = propertyNamingStrategy3;
                                                                                i = i7 + 1;
                                                                                cls5 = cls;
                                                                                propertyNamingStrategy3 = propertyNamingStrategy4;
                                                                                methodArr = methodArr3;
                                                                                cls2 = cls3;
                                                                                length = i6;
                                                                                str = str3;
                                                                                fieldArr = fieldArr4;
                                                                                c = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                    fieldArr4 = fieldArr5;
                                                                    str3 = str;
                                                                    i9 = i31;
                                                                    jSONField2 = jSONField8;
                                                                } else {
                                                                    fieldArr4 = fieldArr5;
                                                                    str3 = str;
                                                                    i9 = i31;
                                                                    jSONField2 = null;
                                                                }
                                                                propertyNamingStrategy4 = propertyNamingStrategy3;
                                                                add(arrayList2, new FieldInfo(propertyNamingStrategy4 == null ? propertyNamingStrategy4.translate(str4) : str4, method6, field, cls, type, i29, i30, i9, superMethodAnnotation, jSONField2, null, buildGenericInfo));
                                                                i = i7 + 1;
                                                                cls5 = cls;
                                                                propertyNamingStrategy3 = propertyNamingStrategy4;
                                                                methodArr = methodArr3;
                                                                cls2 = cls3;
                                                                length = i6;
                                                                str = str3;
                                                                fieldArr = fieldArr4;
                                                                c = 0;
                                                            } else {
                                                                if (charAt2 == '_') {
                                                                    str4 = name4.substring(4);
                                                                    fieldArr5 = fieldArr;
                                                                    field = TypeUtils.getField(cls5, str4, fieldArr5);
                                                                    if (field == null && (field = TypeUtils.getField(cls5, (substring = name4.substring(3)), fieldArr5)) != null) {
                                                                        str4 = substring;
                                                                    }
                                                                } else {
                                                                    fieldArr5 = fieldArr;
                                                                    if (charAt2 == 'f') {
                                                                        str4 = name4.substring(3);
                                                                    } else if (name4.length() < 5 || !Character.isUpperCase(name4.charAt(4))) {
                                                                        str4 = name4.substring(3);
                                                                        field = TypeUtils.getField(cls5, str4, fieldArr5);
                                                                    } else {
                                                                        str4 = TypeUtils.decapitalize(name4.substring(3));
                                                                    }
                                                                    field = null;
                                                                }
                                                                if (field == null) {
                                                                }
                                                                field = TypeUtils.getField(cls5, "is" + Character.toUpperCase(str4.charAt(0)) + str4.substring(i8), fieldArr5);
                                                                if (field == null) {
                                                                }
                                                                propertyNamingStrategy4 = propertyNamingStrategy3;
                                                                add(arrayList2, new FieldInfo(propertyNamingStrategy4 == null ? propertyNamingStrategy4.translate(str4) : str4, method6, field, cls, type, i29, i30, i9, superMethodAnnotation, jSONField2, null, buildGenericInfo));
                                                                i = i7 + 1;
                                                                cls5 = cls;
                                                                propertyNamingStrategy3 = propertyNamingStrategy4;
                                                                methodArr = methodArr3;
                                                                cls2 = cls3;
                                                                length = i6;
                                                                str = str3;
                                                                fieldArr = fieldArr4;
                                                                c = 0;
                                                            }
                                                            fieldArr4 = fieldArr5;
                                                            str3 = str;
                                                        } else {
                                                            str3 = str;
                                                            fieldArr4 = fieldArr;
                                                        }
                                                        propertyNamingStrategy4 = propertyNamingStrategy3;
                                                        i = i7 + 1;
                                                        cls5 = cls;
                                                        propertyNamingStrategy3 = propertyNamingStrategy4;
                                                        methodArr = methodArr3;
                                                        cls2 = cls3;
                                                        length = i6;
                                                        str = str3;
                                                        fieldArr = fieldArr4;
                                                        c = 0;
                                                    }
                                                }
                                            }
                                            methodArr3 = methodArr;
                                            fieldArr4 = fieldArr;
                                            propertyNamingStrategy4 = propertyNamingStrategy3;
                                            str3 = str;
                                            i = i7 + 1;
                                            cls5 = cls;
                                            propertyNamingStrategy3 = propertyNamingStrategy4;
                                            methodArr = methodArr3;
                                            cls2 = cls3;
                                            length = i6;
                                            str = str3;
                                            fieldArr = fieldArr4;
                                            c = 0;
                                        }
                                    }
                                }
                                i7 = i;
                                i6 = length;
                                cls3 = cls2;
                                methodArr3 = methodArr;
                                fieldArr4 = fieldArr;
                                propertyNamingStrategy4 = propertyNamingStrategy3;
                                str3 = str;
                                i = i7 + 1;
                                cls5 = cls;
                                propertyNamingStrategy3 = propertyNamingStrategy4;
                                methodArr = methodArr3;
                                cls2 = cls3;
                                length = i6;
                                str = str3;
                                fieldArr = fieldArr4;
                                c = 0;
                            }
                            Field[] fieldArr7 = fieldArr;
                            int i32 = 3;
                            Class<?> cls8 = cls;
                            Type type4 = type;
                            computeFields(cls8, type4, propertyNamingStrategy3, arrayList2, cls.getFields());
                            Method[] methods3 = cls.getMethods();
                            length2 = methods3.length;
                            i3 = 0;
                            while (i3 < length2) {
                                Method method7 = methods3[i3];
                                String name5 = method7.getName();
                                if (name5.length() >= i2 && !Modifier.isStatic(method7.getModifiers()) && cls2 == null && name5.startsWith("get") && Character.isUpperCase(name5.charAt(i32)) && method7.getParameterTypes().length == 0 && ((Collection.class.isAssignableFrom(method7.getReturnType()) || Map.class.isAssignableFrom(method7.getReturnType()) || AtomicBoolean.class == method7.getReturnType() || AtomicInteger.class == method7.getReturnType() || AtomicLong.class == method7.getReturnType()) && ((jSONField = (JSONField) TypeUtils.getAnnotation(method7, JSONField.class)) == null || !jSONField.deserialize()))) {
                                    if (jSONField == null || jSONField.name().length() <= 0) {
                                        str2 = Character.toLowerCase(name5.charAt(i32)) + name5.substring(i2);
                                        fieldArr3 = fieldArr7;
                                        Field field6 = TypeUtils.getField(cls8, str2, fieldArr3);
                                        if (field6 != null) {
                                            JSONField jSONField9 = (JSONField) TypeUtils.getAnnotation(field6, JSONField.class);
                                            if (jSONField9 != null) {
                                            }
                                        }
                                    } else {
                                        str2 = jSONField.name();
                                        fieldArr3 = fieldArr7;
                                    }
                                    if (propertyNamingStrategy3 != null) {
                                        str2 = propertyNamingStrategy3.translate(str2);
                                    }
                                    if (getField(arrayList2, str2) == null) {
                                        fieldArr2 = fieldArr3;
                                        i4 = i3;
                                        i5 = length2;
                                        methodArr2 = methods3;
                                        type2 = type4;
                                        add(arrayList2, new FieldInfo(str2, method7, null, cls, type, 0, 0, 0, jSONField, null, null, buildGenericInfo));
                                        i3 = i4 + 1;
                                        type4 = type2;
                                        methods3 = methodArr2;
                                        length2 = i5;
                                        fieldArr7 = fieldArr2;
                                        i2 = 4;
                                        i32 = 3;
                                        cls8 = cls;
                                    }
                                    fieldArr2 = fieldArr3;
                                    i4 = i3;
                                    i5 = length2;
                                    methodArr2 = methods3;
                                    type2 = type4;
                                } else {
                                    i4 = i3;
                                    i5 = length2;
                                    methodArr2 = methods3;
                                    type2 = type4;
                                    fieldArr2 = fieldArr7;
                                }
                                i3 = i4 + 1;
                                type4 = type2;
                                methods3 = methodArr2;
                                length2 = i5;
                                fieldArr7 = fieldArr2;
                                i2 = 4;
                                i32 = 3;
                                cls8 = cls;
                            }
                            if (arrayList2.size() == 0) {
                                if (TypeUtils.isXmlField(cls) ? true : z) {
                                    for (Class<?> cls9 = cls; cls9 != null; cls9 = cls9.getSuperclass()) {
                                        computeFields(cls, type4, propertyNamingStrategy3, arrayList2, fieldArr7);
                                    }
                                }
                            }
                            return new JavaBeanInfo(cls, cls2, constructor, constructor2, method2, method4, jSONType, arrayList2);
                        }
                        throw new JSONException("buildMethod not found.");
                    }
                } else {
                    str = str13;
                    fieldArr = declaredFields;
                    method2 = method;
                    propertyNamingStrategy3 = propertyNamingStrategy2;
                    arrayList2 = arrayList;
                    cls2 = builderClass2;
                }
                c = 0;
                length = methodArr.length;
                i = 0;
                while (true) {
                    i2 = 4;
                    if (i >= length) {
                    }
                    i = i7 + 1;
                    cls5 = cls;
                    propertyNamingStrategy3 = propertyNamingStrategy4;
                    methodArr = methodArr3;
                    cls2 = cls3;
                    length = i6;
                    str = str3;
                    fieldArr = fieldArr4;
                    c = 0;
                }
                Field[] fieldArr7 = fieldArr;
                int i32 = 3;
                Class<?> cls8 = cls;
                Type type4 = type;
                computeFields(cls8, type4, propertyNamingStrategy3, arrayList2, cls.getFields());
                Method[] methods3 = cls.getMethods();
                length2 = methods3.length;
                i3 = 0;
                while (i3 < length2) {
                }
                if (arrayList2.size() == 0) {
                }
                return new JavaBeanInfo(cls, cls2, constructor, constructor2, method2, method4, jSONType, arrayList2);
            }
            TypeUtils.setAccessible(constructor2);
            Class<?>[] parameterTypes5 = constructor2.getParameterTypes();
            if (parameterTypes5.length > 0) {
                Annotation[][] parameterAnnotations3 = TypeUtils.getParameterAnnotations(constructor2);
                String[] strArr6 = null;
                int i33 = 0;
                while (i33 < parameterTypes5.length && i33 < parameterAnnotations3.length) {
                    Annotation[] annotationArr4 = parameterAnnotations3[i33];
                    int length6 = annotationArr4.length;
                    int i34 = 0;
                    while (true) {
                        if (i34 >= length6) {
                            annotationArr = parameterAnnotations3;
                            jSONField5 = null;
                            break;
                        }
                        Annotation annotation3 = annotationArr4[i34];
                        annotationArr = parameterAnnotations3;
                        if (annotation3 instanceof JSONField) {
                            jSONField5 = (JSONField) annotation3;
                            break;
                        }
                        i34++;
                        parameterAnnotations3 = annotationArr;
                    }
                    Class<?> cls10 = parameterTypes5[i33];
                    Type type5 = constructor2.getGenericParameterTypes()[i33];
                    if (jSONField5 != null) {
                        field2 = TypeUtils.getField(cls5, jSONField5.name(), declaredFields);
                        int ordinal4 = jSONField5.ordinal();
                        i22 = SerializerFeature.of(jSONField5.serialzeFeatures());
                        i21 = Feature.of(jSONField5.parseFeatures());
                        String name6 = jSONField5.name();
                        i23 = ordinal4;
                        str11 = name6;
                    } else {
                        field2 = null;
                        str11 = null;
                        i23 = 0;
                        i22 = 0;
                        i21 = 0;
                    }
                    if (str11 == null || str11.length() == 0) {
                        if (strArr6 == null) {
                            strArr6 = ASMUtils.lookupParameterNames(constructor2);
                        }
                        str11 = strArr6[i33];
                    }
                    if (field2 == null) {
                        if (strArr6 == null) {
                            if (isKotlin) {
                                strArr6 = TypeUtils.getKoltinConstructorParameters(cls);
                            } else {
                                strArr6 = ASMUtils.lookupParameterNames(constructor2);
                            }
                        }
                        field4 = field2;
                        if (strArr6.length > i33) {
                            strArr3 = strArr6;
                            field3 = TypeUtils.getField(cls5, strArr6[i33], declaredFields);
                            add(arrayList4, new FieldInfo(str11, cls, cls10, type5, field3, i23, i22, i21));
                            i33++;
                            arrayList4 = arrayList4;
                            methods = methods;
                            propertyNamingStrategy6 = propertyNamingStrategy6;
                            jSONType2 = jSONType2;
                            strArr6 = strArr3;
                            parameterAnnotations3 = annotationArr;
                        }
                    } else {
                        field4 = field2;
                    }
                    field3 = field4;
                    strArr3 = strArr6;
                    add(arrayList4, new FieldInfo(str11, cls, cls10, type5, field3, i23, i22, i21));
                    i33++;
                    arrayList4 = arrayList4;
                    methods = methods;
                    propertyNamingStrategy6 = propertyNamingStrategy6;
                    jSONType2 = jSONType2;
                    strArr6 = strArr3;
                    parameterAnnotations3 = annotationArr;
                }
            }
            propertyNamingStrategy2 = propertyNamingStrategy6;
            jSONType = jSONType2;
            arrayList = arrayList4;
            methodArr = methods;
        }
        method = null;
        if (constructor != null) {
        }
        String str13 = "set";
        if (builderClass2 == null) {
        }
        c = 0;
        length = methodArr.length;
        i = 0;
        while (true) {
            i2 = 4;
            if (i >= length) {
            }
            i = i7 + 1;
            cls5 = cls;
            propertyNamingStrategy3 = propertyNamingStrategy4;
            methodArr = methodArr3;
            cls2 = cls3;
            length = i6;
            str = str3;
            fieldArr = fieldArr4;
            c = 0;
        }
        Field[] fieldArr7 = fieldArr;
        int i32 = 3;
        Class<?> cls8 = cls;
        Type type4 = type;
        computeFields(cls8, type4, propertyNamingStrategy3, arrayList2, cls.getFields());
        Method[] methods3 = cls.getMethods();
        length2 = methods3.length;
        i3 = 0;
        while (i3 < length2) {
        }
        if (arrayList2.size() == 0) {
        }
        return new JavaBeanInfo(cls, cls2, constructor, constructor2, method2, method4, jSONType, arrayList2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        if ((java.util.Map.class.isAssignableFrom(r2) || java.util.Collection.class.isAssignableFrom(r2) || java.util.concurrent.atomic.AtomicLong.class.equals(r2) || java.util.concurrent.atomic.AtomicInteger.class.equals(r2) || java.util.concurrent.atomic.AtomicBoolean.class.equals(r2)) == false) goto L_0x0018;
     */
    private static void computeFields(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, List<FieldInfo> list, Field[] fieldArr) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Map<TypeVariable, Type> buildGenericInfo = buildGenericInfo(cls);
        int length = fieldArr.length;
        int i6 = 0;
        while (i6 < length) {
            Field field = fieldArr[i6];
            int modifiers = field.getModifiers();
            if ((modifiers & 8) == 0) {
                boolean z = true;
                if ((modifiers & 16) != 0) {
                    Class<?> type2 = field.getType();
                }
                Iterator<FieldInfo> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().name.equals(field.getName())) {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    String name = field.getName();
                    JSONField jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                    if (jSONField == null) {
                        i5 = 0;
                        i4 = 0;
                        i3 = 0;
                    } else if (jSONField.deserialize()) {
                        int ordinal = jSONField.ordinal();
                        int of = SerializerFeature.of(jSONField.serialzeFeatures());
                        int of2 = Feature.of(jSONField.parseFeatures());
                        if (jSONField.name().length() != 0) {
                            name = jSONField.name();
                        }
                        i5 = ordinal;
                        i4 = of;
                        i3 = of2;
                    }
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    i2 = i6;
                    i = length;
                    add(list, new FieldInfo(name, null, field, cls, type, i5, i4, i3, null, jSONField, null, buildGenericInfo));
                    i6 = i2 + 1;
                    length = i;
                }
            }
            i2 = i6;
            i = length;
            i6 = i2 + 1;
            length = i;
        }
    }

    static Constructor<?> getDefaultConstructor(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        int length = constructorArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Constructor<?> constructor2 = constructorArr[i];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i++;
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Class<?>[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] constructorArr) {
        boolean z;
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor == null) {
                    constructor = constructor2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor3);
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i];
                    int length2 = annotationArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z = false;
                            break;
                        } else if (annotationArr[i2] instanceof JSONField) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    continue;
                } else if (constructor == null) {
                    constructor = constructor3;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        if (constructor != null) {
        }
        return constructor;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr, boolean z) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) TypeUtils.getAnnotation(method2, JSONCreator.class)) != null) {
                if (method == null) {
                    method = method2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        if (method != null || !z) {
            return method;
        }
        for (Method method3 : methodArr) {
            if (TypeUtils.isJacksonCreator(method3)) {
                return method3;
            }
        }
        return method;
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        return getBuilderClass(null, jSONType);
    }

    public static Class<?> getBuilderClass(Class<?> cls, JSONType jSONType) {
        Class<?> builder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (jSONType == null || (builder = jSONType.builder()) == Void.class) {
            return null;
        }
        return builder;
    }
}
