package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private Map<String, FieldDeserializer> fieldDeserializerMap;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        this.sortedFieldDeserializers = new FieldDeserializer[javaBeanInfo.sortedFields.length];
        int length = javaBeanInfo.sortedFields.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            if (length > 128) {
                if (this.fieldDeserializerMap == null) {
                    this.fieldDeserializerMap = new HashMap();
                }
                this.fieldDeserializerMap.put(fieldInfo.name, createFieldDeserializer);
            }
            String[] strArr = fieldInfo.alternateNames;
            for (String str : strArr) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        this.fieldDeserializers = new FieldDeserializer[javaBeanInfo.fields.length];
        int length2 = javaBeanInfo.fields.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        if (str == null) {
            return null;
        }
        Map<String, FieldDeserializer> map = this.fieldDeserializerMap;
        if (map != null && (fieldDeserializer = map.get(str)) != null) {
            return fieldDeserializer;
        }
        int i = 0;
        int length = this.sortedFieldDeserializers.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo > 0) {
                length = i2 - 1;
            } else if (isSetFlag(i2, iArr)) {
                return null;
            } else {
                return this.sortedFieldDeserializers[i2];
            }
        }
        Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    public FieldDeserializer getFieldDeserializer(long j) {
        int i = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = TypeUtils.fnv1a_64(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i;
                }
                i++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch];
        if (s != -1) {
            return this.sortedFieldDeserializers[s];
        }
        return null;
    }

    static boolean isSetFlag(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i2 = i / 32;
        int i3 = i % 32;
        if (i2 < iArr.length) {
            if (((1 << i3) & iArr[i2]) != 0) {
                return true;
            }
        }
        return false;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object obj;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        Object obj2 = null;
        if (this.beanInfo.defaultConstructor == null && this.beanInfo.factoryMethod == null) {
            return null;
        }
        if (this.beanInfo.factoryMethod != null && this.beanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            Constructor<?> constructor = this.beanInfo.defaultConstructor;
            if (this.beanInfo.defaultConstructorParameterSize != 0) {
                ParseContext context = defaultJSONParser.getContext();
                if (context == null || context.object == null) {
                    throw new JSONException("can't create non-static inner class instance.");
                } else if (type instanceof Class) {
                    String name = ((Class) type).getName();
                    String substring = name.substring(0, name.lastIndexOf(36));
                    Object obj3 = context.object;
                    String name2 = obj3.getClass().getName();
                    if (!name2.equals(substring)) {
                        ParseContext parseContext = context.parent;
                        if (parseContext == null || parseContext.object == null || (!"java.util.ArrayList".equals(name2) && !"java.util.List".equals(name2) && !"java.util.Collection".equals(name2) && !"java.util.Map".equals(name2) && !"java.util.HashMap".equals(name2))) {
                            obj2 = obj3;
                        } else if (parseContext.object.getClass().getName().equals(substring)) {
                            obj2 = parseContext.object;
                        }
                        obj3 = obj2;
                    }
                    if (obj3 == null || ((obj3 instanceof Collection) && ((Collection) obj3).isEmpty())) {
                        throw new JSONException("can't create non-static inner class instance.");
                    }
                    obj = constructor.newInstance(obj3);
                } else {
                    throw new JSONException("can't create non-static inner class instance.");
                }
            } else if (constructor != null) {
                obj = constructor.newInstance(new Object[0]);
            } else {
                obj = this.beanInfo.factoryMethod.invoke(null, new Object[0]);
            }
            if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                FieldInfo[] fieldInfoArr = this.beanInfo.fields;
                for (FieldInfo fieldInfo : fieldInfoArr) {
                    if (fieldInfo.fieldClass == String.class) {
                        try {
                            fieldInfo.set(obj, "");
                        } catch (Exception e) {
                            throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                        }
                    }
                }
            }
            return obj;
        } catch (JSONException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i, null);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> r1;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            String scanTypeName = jSONLexer.scanTypeName(defaultJSONParser.symbolTable);
            if (scanTypeName != null) {
                ObjectDeserializer seeAlso = getSeeAlso(defaultJSONParser.getConfig(), this.beanInfo, scanTypeName);
                if (seeAlso == null) {
                    seeAlso = defaultJSONParser.getConfig().getDeserializer(defaultJSONParser.getConfig().checkAutoType(scanTypeName, TypeUtils.getClass(type), jSONLexer.getFeatures()));
                }
                if (seeAlso instanceof JavaBeanDeserializer) {
                    return (T) ((JavaBeanDeserializer) seeAlso).deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                }
            }
            T t = (T) createInstance(defaultJSONParser, type);
            int i = 0;
            int length = this.sortedFieldDeserializers.length;
            while (true) {
                int i2 = 16;
                if (i >= length) {
                    break;
                }
                char c = i == length + -1 ? ']' : ',';
                FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
                Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c));
                } else if (cls == String.class) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c));
                } else if (cls == Long.TYPE) {
                    fieldDeserializer.setValue(t, jSONLexer.scanLong(c));
                } else if (cls.isEnum()) {
                    char current = jSONLexer.getCurrent();
                    if (current == '\"' || current == 'n') {
                        r1 = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                    } else if (current < '0' || current > '9') {
                        r1 = scanEnum(jSONLexer, c);
                    } else {
                        r1 = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                    }
                    fieldDeserializer.setValue(t, r1);
                } else if (cls == Boolean.TYPE) {
                    fieldDeserializer.setValue(t, jSONLexer.scanBoolean(c));
                } else if (cls == Float.TYPE) {
                    fieldDeserializer.setValue(t, Float.valueOf(jSONLexer.scanFloat(c)));
                } else if (cls == Double.TYPE) {
                    fieldDeserializer.setValue(t, Double.valueOf(jSONLexer.scanDouble(c)));
                } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                    fieldDeserializer.setValue(t, new Date(jSONLexer.scanLong(c)));
                } else if (cls == BigDecimal.class) {
                    fieldDeserializer.setValue(t, jSONLexer.scanDecimal(c));
                } else {
                    jSONLexer.nextToken(14);
                    fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType, fieldDeserializer.fieldInfo.name));
                    if (jSONLexer.token() == 15) {
                        break;
                    }
                    if (c == ']') {
                        i2 = 15;
                    }
                    check(jSONLexer, i2);
                }
                i++;
            }
            jSONLexer.nextToken(16);
            return t;
        }
        throw new JSONException("error");
    }

    protected void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    protected Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:121:0x01c5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:731:0x0825 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:624:0x0868 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:710:0x093a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.alibaba.fastjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.alibaba.fastjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.alibaba.fastjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r4v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v33, types: [java.lang.Class<?>] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r2v64, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r4v126 */
    /* JADX WARN: Type inference failed for: r15v43 */
    /* JADX WARN: Type inference failed for: r15v44 */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0391, code lost:
        if (r12.matchStat == -2) goto L_0x0393;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x069f, code lost:
        r1 = r18;
        r5 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:677:0x096b, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r12.token()));
     */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x030d A[Catch:{ all -> 0x03a2, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x03b6 A[Catch:{ all -> 0x03a2, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0573  */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x057e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x05c6  */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x0627 A[Catch:{ all -> 0x0638 }] */
    /* JADX WARNING: Removed duplicated region for block: B:477:0x0692  */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x0696  */
    /* JADX WARNING: Removed duplicated region for block: B:604:0x0829 A[SYNTHETIC, Splitter:B:604:0x0829] */
    /* JADX WARNING: Removed duplicated region for block: B:624:0x0868 A[SYNTHETIC, Splitter:B:624:0x0868] */
    /* JADX WARNING: Removed duplicated region for block: B:690:0x098e  */
    /* JADX WARNING: Unknown variable types count: 5 */
    protected <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        ?? r15;
        T t;
        ParseContext parseContext;
        Throwable th;
        Throwable th2;
        String str;
        Object obj3;
        int[] iArr2;
        ?? r5;
        HashMap hashMap;
        int i2;
        int i3;
        int i4;
        JSONField jSONField;
        DefaultFieldDeserializer defaultFieldDeserializer;
        Class<?> cls;
        FieldInfo fieldInfo;
        boolean z;
        int[] iArr3;
        String str2;
        HashMap hashMap2;
        int i5;
        int i6;
        int[] iArr4;
        Object obj4;
        int i7;
        FieldInfo fieldInfo2;
        boolean z2;
        Object obj5;
        boolean z3;
        byte b;
        ParseContext parseContext2;
        Throwable th3;
        Object[] objArr;
        boolean z4;
        Object obj6;
        Exception exc;
        String str3;
        ParseContext parseContext3;
        Class<?> cls2;
        String str4;
        ParseContext parseContext4;
        HashMap hashMap3;
        Throwable th4;
        int i8;
        ParseContext parseContext5;
        Throwable th5;
        ParseContext context;
        Class<?> cls3;
        FieldDeserializer fieldDeserializer;
        T t2;
        Object obj7;
        int[] iArr5;
        Object obj8;
        char[] cArr;
        Class<?> cls4;
        if (type == JSON.class || type == JSONObject.class) {
            return (T) defaultJSONParser.parse();
        }
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        ParserConfig config = defaultJSONParser.getConfig();
        int i9 = jSONLexerBase.token();
        Object obj9 = null;
        int[] iArr6 = null;
        if (i9 == 8) {
            jSONLexerBase.nextToken(16);
            return null;
        }
        ParseContext context2 = defaultJSONParser.getContext();
        if (!(obj2 == null || context2 == null)) {
            context2 = context2.parent;
        }
        ParseContext parseContext6 = context2;
        if (i9 == 13) {
            try {
                jSONLexerBase.nextToken(16);
                T t3 = obj2 == null ? (T) createInstance((DefaultJSONParser) defaultJSONParser, type) : (T) obj2;
                defaultJSONParser.setContext(parseContext6);
                return t3;
            } catch (Throwable th6) {
                th5 = th6;
                t = (T) obj2;
                th = th5;
                iArr5 = iArr6;
                parseContext = parseContext6;
                r15 = iArr5;
                if (r15 != 0) {
                }
                defaultJSONParser.setContext(parseContext);
                throw th;
            }
        } else {
            if (i9 == 14) {
                int i10 = Feature.SupportArrayToBean.mask;
                if (((this.beanInfo.parserFeatures & i10) == 0 && !jSONLexerBase.isEnabled(Feature.SupportArrayToBean) && (i & i10) == 0) ? false : true) {
                    T t4 = (T) deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                    defaultJSONParser.setContext(parseContext6);
                    return t4;
                }
            }
            if (i9 == 12 || i9 == 16) {
                try {
                    if (defaultJSONParser.resolveStatus == 2) {
                        defaultJSONParser.resolveStatus = 0;
                    }
                    str = this.beanInfo.typeKey;
                    obj3 = obj2;
                    iArr2 = iArr;
                    r5 = 0;
                    hashMap = null;
                    i2 = 0;
                    i3 = 0;
                    parseContext2 = parseContext6;
                    HashMap hashMap4 = hashMap;
                    b = 0;
                    ?? r52 = r5;
                    if (t != null) {
                        parseContext = parseContext2;
                    } else if (hashMap4 == null) {
                        try {
                            T t5 = (T) createInstance((DefaultJSONParser) defaultJSONParser, type);
                            if (r52 == 0) {
                                parseContext = parseContext2;
                                try {
                                    parseContext3 = defaultJSONParser.setContext(parseContext, t5, obj);
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    t = t5;
                                    obj9 = r52;
                                }
                            } else {
                                parseContext = parseContext2;
                                parseContext3 = r52;
                            }
                            if (parseContext3 != null) {
                                parseContext3.object = t5;
                            }
                            defaultJSONParser.setContext(parseContext);
                            return t5;
                        } catch (Throwable th8) {
                            th3 = th8;
                            parseContext = parseContext2;
                            th = th3;
                            r15 = r52;
                            if (r15 != 0) {
                            }
                            defaultJSONParser.setContext(parseContext);
                            throw th;
                        }
                    } else {
                        parseContext = parseContext2;
                        try {
                            String[] strArr = this.beanInfo.creatorConstructorParameters;
                            String str5 = "";
                            if (strArr != null) {
                                objArr = new Object[strArr.length];
                                int i11 = 0;
                                while (i11 < strArr.length) {
                                    long remove = hashMap4.remove(strArr[i11]);
                                    if (remove == null) {
                                        Type type2 = this.beanInfo.creatorConstructorParameterTypes[i11];
                                        FieldInfo fieldInfo3 = this.beanInfo.fields[i11];
                                        if (type2 == Byte.TYPE) {
                                            remove = Byte.valueOf(b);
                                        } else if (type2 == Short.TYPE) {
                                            remove = Short.valueOf(b);
                                        } else if (type2 == Integer.TYPE) {
                                            remove = Integer.valueOf(b);
                                        } else if (type2 == Long.TYPE) {
                                            remove = 0L;
                                        } else if (type2 == Float.TYPE) {
                                            remove = Float.valueOf(0.0f);
                                        } else if (type2 == Double.TYPE) {
                                            remove = Double.valueOf(0.0d);
                                        } else if (type2 == Boolean.TYPE) {
                                            remove = Boolean.FALSE;
                                        } else if (type2 == String.class && (fieldInfo3.parserFeatures & Feature.InitStringFieldAsEmpty.mask) != 0) {
                                            remove = str5;
                                        }
                                    } else if (this.beanInfo.creatorConstructorParameterTypes != null && i11 < this.beanInfo.creatorConstructorParameterTypes.length) {
                                        Type type3 = this.beanInfo.creatorConstructorParameterTypes[i11];
                                        if (type3 instanceof Class) {
                                            Class cls5 = (Class) type3;
                                            if (!cls5.isInstance(remove) && (remove instanceof List)) {
                                                List list = (List) remove;
                                                if (list.size() == 1) {
                                                    if (cls5.isInstance(list.get(0))) {
                                                        remove = list.get(0);
                                                    }
                                                    objArr[i11] = remove;
                                                    i11++;
                                                    b = 0;
                                                }
                                            }
                                        }
                                    }
                                    objArr[i11] = remove;
                                    i11++;
                                    b = 0;
                                }
                            } else {
                                FieldInfo[] fieldInfoArr = this.beanInfo.fields;
                                int length = fieldInfoArr.length;
                                Object[] objArr2 = new Object[length];
                                int i12 = 0;
                                while (i12 < length) {
                                    FieldInfo fieldInfo4 = fieldInfoArr[i12];
                                    long j = hashMap4.get(fieldInfo4.name);
                                    if (j == null) {
                                        Type type4 = fieldInfo4.fieldType;
                                        str3 = str5;
                                        if (type4 == Byte.TYPE) {
                                            j = (byte) 0;
                                        } else if (type4 == Short.TYPE) {
                                            j = (short) 0;
                                        } else if (type4 == Integer.TYPE) {
                                            j = 0;
                                        } else if (type4 == Long.TYPE) {
                                            j = 0L;
                                        } else if (type4 == Float.TYPE) {
                                            j = Float.valueOf(0.0f);
                                        } else if (type4 == Double.TYPE) {
                                            j = Double.valueOf(0.0d);
                                        } else if (type4 == Boolean.TYPE) {
                                            j = Boolean.FALSE;
                                        } else if (type4 == String.class && (fieldInfo4.parserFeatures & Feature.InitStringFieldAsEmpty.mask) != 0) {
                                            j = str3;
                                        }
                                    } else {
                                        str3 = str5;
                                    }
                                    objArr2[i12] = j;
                                    i12++;
                                    str5 = str3;
                                }
                                objArr = objArr2;
                            }
                            if (this.beanInfo.creatorConstructor != null) {
                                ?? r4 = this.beanInfo.f192kotlin;
                                if (r4 != 0) {
                                    r4 = 0;
                                    while (true) {
                                        if (r4 >= objArr.length) {
                                            break;
                                        } else if (objArr[r4] != null || this.beanInfo.fields == null || r4 >= this.beanInfo.fields.length) {
                                            r4++;
                                        } else {
                                            r4 = this.beanInfo.fields[r4].fieldClass;
                                            if (r4 == String.class) {
                                                z4 = true;
                                                obj6 = r4;
                                            }
                                        }
                                    }
                                    if (z4) {
                                        try {
                                            if (this.beanInfo.kotlinDefaultConstructor != null) {
                                                obj6 = this.beanInfo.kotlinDefaultConstructor.newInstance(new Object[0]);
                                                for (int i13 = 0; i13 < objArr.length; i13++) {
                                                    try {
                                                        Object obj10 = objArr[i13];
                                                        if (!(obj10 == null || this.beanInfo.fields == null || i13 >= this.beanInfo.fields.length)) {
                                                            this.beanInfo.fields[i13].set(obj6, obj10);
                                                        }
                                                    } catch (Exception e) {
                                                        exc = e;
                                                        throw new JSONException("create instance error, " + strArr + ", " + this.beanInfo.creatorConstructor.toGenericString(), exc);
                                                    }
                                                }
                                                if (strArr != null) {
                                                    for (Map.Entry<String, Object> entry : hashMap4.entrySet()) {
                                                        FieldDeserializer fieldDeserializer2 = getFieldDeserializer(entry.getKey());
                                                        if (fieldDeserializer2 != null) {
                                                            fieldDeserializer2.setValue(obj6, entry.getValue());
                                                        }
                                                    }
                                                }
                                                t = (T) obj6;
                                            }
                                        } catch (Exception e2) {
                                            exc = e2;
                                            throw new JSONException("create instance error, " + strArr + ", " + this.beanInfo.creatorConstructor.toGenericString(), exc);
                                        } catch (Throwable th9) {
                                            th = th9;
                                            t = (T) obj6;
                                            r15 = r52;
                                            if (r15 != 0) {
                                            }
                                            defaultJSONParser.setContext(parseContext);
                                            throw th;
                                        }
                                    }
                                    obj6 = this.beanInfo.creatorConstructor.newInstance(objArr);
                                    if (strArr != null) {
                                    }
                                    t = (T) obj6;
                                }
                                z4 = false;
                                obj6 = r4;
                                if (z4) {
                                }
                                obj6 = this.beanInfo.creatorConstructor.newInstance(objArr);
                                if (strArr != null) {
                                }
                                t = (T) obj6;
                            } else if (this.beanInfo.factoryMethod != null) {
                                try {
                                    t = (T) this.beanInfo.factoryMethod.invoke(null, objArr);
                                } catch (Exception e3) {
                                    throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e3);
                                }
                            }
                            if (r52 != 0) {
                                r52.object = t;
                            }
                        } catch (Throwable th10) {
                            th3 = th10;
                            th = th3;
                            r15 = r52;
                            if (r15 != 0) {
                                r15.object = t;
                            }
                            defaultJSONParser.setContext(parseContext);
                            throw th;
                        }
                    }
                    Method method = this.beanInfo.buildMethod;
                    if (method == null) {
                        if (r52 != 0) {
                            r52.object = t;
                        }
                        defaultJSONParser.setContext(parseContext);
                        return (T) t;
                    }
                    try {
                        T t6 = (T) method.invoke(t, new Object[0]);
                        if (r52 != 0) {
                            r52.object = t;
                        }
                        defaultJSONParser.setContext(parseContext);
                        return t6;
                    } catch (Exception e4) {
                        throw new JSONException("build object error", e4);
                    }
                } catch (Throwable th11) {
                    th2 = th11;
                    parseContext = parseContext6;
                    t = obj2;
                    th = th2;
                    r15 = obj9;
                    if (r15 != 0) {
                    }
                    defaultJSONParser.setContext(parseContext);
                    throw th;
                }
                while (true) {
                    try {
                        FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                        if (i3 >= fieldDeserializerArr.length || i2 >= 16) {
                            i4 = i3;
                            z = false;
                            fieldInfo = null;
                            cls = null;
                            defaultFieldDeserializer = null;
                            jSONField = null;
                        } else {
                            try {
                                FieldDeserializer fieldDeserializer3 = fieldDeserializerArr[i3];
                                FieldInfo fieldInfo5 = fieldDeserializer3.fieldInfo;
                                i4 = i3;
                                Class<?> cls6 = fieldInfo5.fieldClass;
                                jSONField = fieldInfo5.getAnnotation();
                                if (jSONField != null) {
                                    cls4 = cls6;
                                    if (fieldDeserializer3 instanceof DefaultFieldDeserializer) {
                                        z = ((DefaultFieldDeserializer) fieldDeserializer3).customDeserilizer;
                                        fieldInfo = fieldInfo5;
                                        defaultFieldDeserializer = fieldDeserializer3;
                                        cls = cls4;
                                    }
                                } else {
                                    cls4 = cls6;
                                }
                                fieldInfo = fieldInfo5;
                                z = false;
                                defaultFieldDeserializer = fieldDeserializer3;
                                cls = cls4;
                            } catch (Throwable th12) {
                                th2 = th12;
                                t = obj3;
                                obj9 = r5;
                                parseContext = parseContext6;
                                th = th2;
                                r15 = obj9;
                                if (r15 != 0) {
                                }
                                defaultJSONParser.setContext(parseContext);
                                throw th;
                            }
                        }
                        fieldInfo2 = fieldInfo;
                        z3 = false;
                        obj5 = null;
                        obj7 = iArr;
                        z2 = false;
                        iArr = obj7;
                        if (!z3) {
                        }
                        if (t == null) {
                        }
                        iArr = r5;
                        parseContext5 = iArr;
                        hashMap3 = hashMap;
                        iArr3 = iArr4;
                        parseContext4 = parseContext5;
                        if (!z3) {
                        }
                        r5 = parseContext4;
                        i3 = i6 + 1;
                        obj3 = t;
                        str = str2;
                        iArr2 = iArr3;
                        parseContext6 = parseContext;
                        i2 = i5;
                        hashMap = hashMap2;
                        r5 = r5;
                    } catch (Throwable th13) {
                        th2 = th13;
                        t = obj3;
                        parseContext = parseContext6;
                        obj9 = r5;
                        th = th2;
                        r15 = obj9;
                        if (r15 != 0) {
                        }
                        defaultJSONParser.setContext(parseContext);
                        throw th;
                    }
                    if (defaultFieldDeserializer != null) {
                        iArr4 = iArr2;
                        try {
                            cArr = fieldInfo.name_chars;
                            fieldInfo2 = fieldInfo;
                            z3 = true;
                            obj5 = null;
                            obj7 = iArr;
                            z2 = false;
                            iArr = obj7;
                            if (!z3) {
                            }
                            if (t == null) {
                            }
                            iArr = r5;
                            parseContext5 = iArr;
                            hashMap3 = hashMap;
                            iArr3 = iArr4;
                            parseContext4 = parseContext5;
                            if (!z3) {
                            }
                            r5 = parseContext4;
                            i3 = i6 + 1;
                            obj3 = t;
                            str = str2;
                            iArr2 = iArr3;
                            parseContext6 = parseContext;
                            i2 = i5;
                            hashMap = hashMap2;
                            r5 = r5;
                        } catch (Throwable th14) {
                            th = th14;
                            obj8 = iArr;
                            t = (T) obj8;
                            th = th;
                            iArr5 = r5;
                            parseContext = parseContext6;
                            r15 = iArr5;
                            if (r15 != 0) {
                            }
                            defaultJSONParser.setContext(parseContext);
                            throw th;
                        }
                        if (!z || !jSONLexerBase.matchField(cArr)) {
                            iArr = obj3;
                            if (cls == Integer.TYPE || cls == Integer.class) {
                                fieldInfo2 = fieldInfo;
                                int scanFieldInt = jSONLexerBase.scanFieldInt(cArr);
                                if (scanFieldInt == 0 && jSONLexerBase.matchStat == 5) {
                                    obj5 = null;
                                } else {
                                    obj5 = Integer.valueOf(scanFieldInt);
                                }
                                if (jSONLexerBase.matchStat > 0) {
                                }
                            } else {
                                if (cls != Long.TYPE) {
                                    if (cls != Long.class) {
                                        if (cls == String.class) {
                                            obj5 = jSONLexerBase.scanFieldString(cArr);
                                            if (jSONLexerBase.matchStat <= 0) {
                                                if (jSONLexerBase.matchStat == -2) {
                                                    i6 = i4;
                                                    t = iArr;
                                                    i5 = i2 + 1;
                                                    str2 = str;
                                                    parseContext = parseContext6;
                                                    hashMap2 = hashMap;
                                                    iArr = iArr;
                                                    iArr3 = iArr4;
                                                    i3 = i6 + 1;
                                                    obj3 = t;
                                                    str = str2;
                                                    iArr2 = iArr3;
                                                    parseContext6 = parseContext;
                                                    i2 = i5;
                                                    hashMap = hashMap2;
                                                    r5 = r5;
                                                }
                                                fieldInfo2 = fieldInfo;
                                                z3 = false;
                                                obj7 = iArr;
                                                z2 = false;
                                                iArr = obj7;
                                                if (!z3) {
                                                    str4 = jSONLexerBase.scanSymbol(defaultJSONParser.symbolTable);
                                                    if (str4 == null) {
                                                        i7 = i2;
                                                        int i14 = jSONLexerBase.token();
                                                        cls2 = cls;
                                                        if (i14 == 13) {
                                                            jSONLexerBase.nextToken(16);
                                                            t = (T) iArr;
                                                            break;
                                                        } else if (i14 == 16 && jSONLexerBase.isEnabled(Feature.AllowArbitraryCommas)) {
                                                            t = iArr;
                                                            obj4 = iArr;
                                                            i6 = i4;
                                                            str2 = str;
                                                            parseContext = parseContext6;
                                                            hashMap2 = hashMap;
                                                            i5 = i7;
                                                            iArr = obj4;
                                                            iArr3 = iArr4;
                                                            i3 = i6 + 1;
                                                            obj3 = t;
                                                            str = str2;
                                                            iArr2 = iArr3;
                                                            parseContext6 = parseContext;
                                                            i2 = i5;
                                                            hashMap = hashMap2;
                                                            r5 = r5;
                                                        }
                                                    } else {
                                                        i7 = i2;
                                                        cls2 = cls;
                                                    }
                                                    if ("$ref" == str4 && parseContext6 != null) {
                                                        jSONLexerBase.nextTokenWithColon(4);
                                                        int i15 = jSONLexerBase.token();
                                                        if (i15 == 4) {
                                                            String stringVal = jSONLexerBase.stringVal();
                                                            if ("@".equals(stringVal)) {
                                                                t2 = (T) parseContext6.object;
                                                            } else {
                                                                if ("..".equals(stringVal)) {
                                                                    ParseContext parseContext7 = parseContext6.parent;
                                                                    if (parseContext7.object != null) {
                                                                        t2 = (T) parseContext7.object;
                                                                    } else {
                                                                        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext7, stringVal));
                                                                        defaultJSONParser.resolveStatus = 1;
                                                                    }
                                                                } else if ("$".equals(stringVal)) {
                                                                    ParseContext parseContext8 = parseContext6;
                                                                    while (parseContext8.parent != null) {
                                                                        parseContext8 = parseContext8.parent;
                                                                    }
                                                                    if (parseContext8.object != null) {
                                                                        t2 = (T) parseContext8.object;
                                                                    } else {
                                                                        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext8, stringVal));
                                                                        defaultJSONParser.resolveStatus = 1;
                                                                    }
                                                                } else {
                                                                    if (stringVal.indexOf(92) > 0) {
                                                                        StringBuilder sb = new StringBuilder();
                                                                        int i16 = 0;
                                                                        while (i16 < stringVal.length()) {
                                                                            char charAt = stringVal.charAt(i16);
                                                                            if (charAt == '\\') {
                                                                                i16++;
                                                                                charAt = stringVal.charAt(i16);
                                                                            }
                                                                            sb.append(charAt);
                                                                            i16++;
                                                                        }
                                                                        stringVal = sb.toString();
                                                                    }
                                                                    ?? resolveReference = defaultJSONParser.resolveReference(stringVal);
                                                                    if (resolveReference != null) {
                                                                        t2 = resolveReference;
                                                                    } else {
                                                                        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext6, stringVal));
                                                                        defaultJSONParser.resolveStatus = 1;
                                                                    }
                                                                }
                                                                t2 = (T) iArr;
                                                            }
                                                            jSONLexerBase.nextToken(13);
                                                            if (jSONLexerBase.token() == 13) {
                                                                jSONLexerBase.nextToken(16);
                                                                defaultJSONParser.setContext(parseContext6, t2, obj);
                                                                if (r5 != 0) {
                                                                    r5.object = t2;
                                                                }
                                                                defaultJSONParser.setContext(parseContext6);
                                                                return t2;
                                                            }
                                                            throw new JSONException("illegal ref");
                                                        }
                                                        throw new JSONException("illegal ref, " + JSONToken.name(i15));
                                                    } else if ((str == null || !str.equals(str4)) && JSON.DEFAULT_TYPE_KEY != str4) {
                                                        t = iArr;
                                                    } else {
                                                        jSONLexerBase.nextTokenWithColon(4);
                                                        if (jSONLexerBase.token() == 4) {
                                                            String stringVal2 = jSONLexerBase.stringVal();
                                                            jSONLexerBase.nextToken(16);
                                                            if (stringVal2.equals(this.beanInfo.typeName) || defaultJSONParser.isEnabled(Feature.IgnoreAutoType)) {
                                                                t = (T) iArr;
                                                                try {
                                                                    obj4 = iArr;
                                                                    if (jSONLexerBase.token() == 13) {
                                                                        jSONLexerBase.nextToken();
                                                                        break;
                                                                    }
                                                                    i6 = i4;
                                                                    str2 = str;
                                                                    parseContext = parseContext6;
                                                                    hashMap2 = hashMap;
                                                                    i5 = i7;
                                                                    iArr = obj4;
                                                                    iArr3 = iArr4;
                                                                    i3 = i6 + 1;
                                                                    obj3 = t;
                                                                    str = str2;
                                                                    iArr2 = iArr3;
                                                                    parseContext6 = parseContext;
                                                                    i2 = i5;
                                                                    hashMap = hashMap2;
                                                                    r5 = r5;
                                                                } catch (Throwable th15) {
                                                                    th = th15;
                                                                    th = th;
                                                                    iArr5 = r5;
                                                                    parseContext = parseContext6;
                                                                    r15 = iArr5;
                                                                    if (r15 != 0) {
                                                                    }
                                                                    defaultJSONParser.setContext(parseContext);
                                                                    throw th;
                                                                }
                                                            } else {
                                                                ObjectDeserializer seeAlso = getSeeAlso(config, this.beanInfo, stringVal2);
                                                                if (seeAlso == null) {
                                                                    cls3 = config.checkAutoType(stringVal2, TypeUtils.getClass(type), jSONLexerBase.getFeatures());
                                                                    seeAlso = defaultJSONParser.getConfig().getDeserializer(cls3);
                                                                } else {
                                                                    cls3 = null;
                                                                }
                                                                T t7 = (T) seeAlso.deserialze(defaultJSONParser, cls3, obj);
                                                                if (seeAlso instanceof JavaBeanDeserializer) {
                                                                    JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) seeAlso;
                                                                    if (!(str == null || (fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str)) == null)) {
                                                                        fieldDeserializer.setValue((Object) t7, stringVal2);
                                                                    }
                                                                }
                                                                if (r5 != 0) {
                                                                    r5.object = iArr;
                                                                }
                                                                defaultJSONParser.setContext(parseContext6);
                                                                return t7;
                                                            }
                                                        } else {
                                                            throw new JSONException("syntax error");
                                                        }
                                                    }
                                                } else {
                                                    i7 = i2;
                                                    cls2 = cls;
                                                    t = iArr;
                                                    str4 = null;
                                                }
                                                if (t == null || hashMap != null) {
                                                    iArr = r5;
                                                    parseContext5 = iArr;
                                                } else {
                                                    try {
                                                        t = (T) createInstance((DefaultJSONParser) defaultJSONParser, type);
                                                        if (t == null) {
                                                            iArr = r5;
                                                            try {
                                                                hashMap = new HashMap(this.fieldDeserializers.length);
                                                            } catch (Throwable th16) {
                                                                th5 = th16;
                                                                iArr6 = iArr;
                                                                th = th5;
                                                                iArr5 = iArr6;
                                                                parseContext = parseContext6;
                                                                r15 = iArr5;
                                                                if (r15 != 0) {
                                                                }
                                                                defaultJSONParser.setContext(parseContext);
                                                                throw th;
                                                            }
                                                        } else {
                                                            iArr = r5;
                                                        }
                                                        context = defaultJSONParser.setContext(parseContext6, t, obj);
                                                    } catch (Throwable th17) {
                                                        th5 = th17;
                                                        iArr = r5;
                                                        iArr6 = iArr;
                                                        th = th5;
                                                        iArr5 = iArr6;
                                                        parseContext = parseContext6;
                                                        r15 = iArr5;
                                                        if (r15 != 0) {
                                                        }
                                                        defaultJSONParser.setContext(parseContext);
                                                        throw th;
                                                    }
                                                    if (iArr4 == null) {
                                                        parseContext4 = context;
                                                        hashMap3 = hashMap;
                                                        iArr3 = new int[((this.fieldDeserializers.length / 32) + 1)];
                                                        if (!z3) {
                                                            if (z2) {
                                                                if (t == null) {
                                                                    hashMap3.put(fieldInfo2.name, obj5);
                                                                } else if (obj5 != null) {
                                                                    defaultFieldDeserializer.setValue(t, obj5);
                                                                } else if (!(cls2 == Integer.TYPE || cls2 == Long.TYPE || cls2 == Float.TYPE || cls2 == Double.TYPE || cls2 == Boolean.TYPE)) {
                                                                    defaultFieldDeserializer.setValue(t, obj5);
                                                                }
                                                                if (iArr3 != null) {
                                                                    int i17 = i4 / 32;
                                                                    iArr3[i17] = (1 << (i4 % 32)) | iArr3[i17];
                                                                }
                                                                if (jSONLexerBase.matchStat == 4) {
                                                                    hashMap2 = hashMap3;
                                                                    parseContext2 = parseContext6;
                                                                    b = 0;
                                                                    break;
                                                                }
                                                            } else {
                                                                try {
                                                                    defaultFieldDeserializer.parseField(defaultJSONParser, t, type, hashMap3);
                                                                } catch (Throwable th18) {
                                                                    th = th18;
                                                                    parseContext = parseContext6;
                                                                    r15 = parseContext4;
                                                                    if (r15 != 0) {
                                                                    }
                                                                    defaultJSONParser.setContext(parseContext);
                                                                    throw th;
                                                                }
                                                            }
                                                            i6 = i4;
                                                            hashMap2 = hashMap3;
                                                            str2 = str;
                                                            parseContext2 = parseContext6;
                                                            i5 = i7;
                                                            b = 0;
                                                            i8 = 13;
                                                            if (jSONLexerBase.token() == 16) {
                                                                if (jSONLexerBase.token() == i8) {
                                                                    jSONLexerBase.nextToken(16);
                                                                    break;
                                                                }
                                                                parseContext = parseContext2;
                                                                try {
                                                                    r5 = parseContext4;
                                                                    i3 = i6 + 1;
                                                                    obj3 = t;
                                                                    str = str2;
                                                                    iArr2 = iArr3;
                                                                    parseContext6 = parseContext;
                                                                    i2 = i5;
                                                                    hashMap = hashMap2;
                                                                    r5 = r5;
                                                                } catch (Throwable th19) {
                                                                    th4 = th19;
                                                                    th = th4;
                                                                    r15 = parseContext4;
                                                                    if (r15 != 0) {
                                                                    }
                                                                    defaultJSONParser.setContext(parseContext);
                                                                    throw th;
                                                                }
                                                                if (jSONLexerBase.token() == 18 || jSONLexerBase.token() == 1) {
                                                                    break;
                                                                }
                                                            } else {
                                                                parseContext = parseContext2;
                                                            }
                                                        } else {
                                                            i5 = i7;
                                                            i6 = i4;
                                                            hashMap2 = hashMap3;
                                                            b = 0;
                                                            str2 = str;
                                                            i8 = 13;
                                                            parseContext2 = parseContext6;
                                                            try {
                                                                if (!parseField(defaultJSONParser, str4, t, type, hashMap3 == null ? new HashMap(this.fieldDeserializers.length) : hashMap3, iArr3)) {
                                                                    try {
                                                                        if (jSONLexerBase.token() == 13) {
                                                                            jSONLexerBase.nextToken();
                                                                            break;
                                                                        }
                                                                        parseContext = parseContext2;
                                                                    } catch (Throwable th20) {
                                                                        th = th20;
                                                                        r15 = parseContext4;
                                                                        parseContext = parseContext2;
                                                                        if (r15 != 0) {
                                                                        }
                                                                        defaultJSONParser.setContext(parseContext);
                                                                        throw th;
                                                                    }
                                                                } else {
                                                                    if (jSONLexerBase.token() == 17) {
                                                                        throw new JSONException("syntax error, unexpect token ':'");
                                                                    }
                                                                    if (jSONLexerBase.token() == 16) {
                                                                    }
                                                                }
                                                            } catch (Throwable th21) {
                                                                th4 = th21;
                                                                parseContext = parseContext2;
                                                                th = th4;
                                                                r15 = parseContext4;
                                                                if (r15 != 0) {
                                                                }
                                                                defaultJSONParser.setContext(parseContext);
                                                                throw th;
                                                            }
                                                        }
                                                        r5 = parseContext4;
                                                        i3 = i6 + 1;
                                                        obj3 = t;
                                                        str = str2;
                                                        iArr2 = iArr3;
                                                        parseContext6 = parseContext;
                                                        i2 = i5;
                                                        hashMap = hashMap2;
                                                        r5 = r5;
                                                    } else {
                                                        parseContext5 = context;
                                                    }
                                                }
                                                hashMap3 = hashMap;
                                                iArr3 = iArr4;
                                                parseContext4 = parseContext5;
                                                if (!z3) {
                                                }
                                                r5 = parseContext4;
                                                i3 = i6 + 1;
                                                obj3 = t;
                                                str = str2;
                                                iArr2 = iArr3;
                                                parseContext6 = parseContext;
                                                i2 = i5;
                                                hashMap = hashMap2;
                                                r5 = r5;
                                            }
                                        } else if (cls == Date.class && fieldInfo.format == null) {
                                            obj5 = jSONLexerBase.scanFieldDate(cArr);
                                            if (jSONLexerBase.matchStat <= 0) {
                                                if (jSONLexerBase.matchStat == -2) {
                                                    i6 = i4;
                                                    t = iArr;
                                                    i5 = i2 + 1;
                                                    str2 = str;
                                                    parseContext = parseContext6;
                                                    hashMap2 = hashMap;
                                                    iArr = iArr;
                                                    iArr3 = iArr4;
                                                    i3 = i6 + 1;
                                                    obj3 = t;
                                                    str = str2;
                                                    iArr2 = iArr3;
                                                    parseContext6 = parseContext;
                                                    i2 = i5;
                                                    hashMap = hashMap2;
                                                    r5 = r5;
                                                }
                                                fieldInfo2 = fieldInfo;
                                                z3 = false;
                                                obj7 = iArr;
                                                z2 = false;
                                                iArr = obj7;
                                                if (!z3) {
                                                }
                                                if (t == null) {
                                                }
                                                iArr = r5;
                                                parseContext5 = iArr;
                                                hashMap3 = hashMap;
                                                iArr3 = iArr4;
                                                parseContext4 = parseContext5;
                                                if (!z3) {
                                                }
                                                r5 = parseContext4;
                                                i3 = i6 + 1;
                                                obj3 = t;
                                                str = str2;
                                                iArr2 = iArr3;
                                                parseContext6 = parseContext;
                                                i2 = i5;
                                                hashMap = hashMap2;
                                                r5 = r5;
                                            }
                                        } else if (cls == BigDecimal.class) {
                                            obj5 = jSONLexerBase.scanFieldDecimal(cArr);
                                            if (jSONLexerBase.matchStat <= 0) {
                                                if (jSONLexerBase.matchStat == -2) {
                                                    i6 = i4;
                                                    t = iArr;
                                                    i5 = i2 + 1;
                                                    str2 = str;
                                                    parseContext = parseContext6;
                                                    hashMap2 = hashMap;
                                                    iArr = iArr;
                                                    iArr3 = iArr4;
                                                    i3 = i6 + 1;
                                                    obj3 = t;
                                                    str = str2;
                                                    iArr2 = iArr3;
                                                    parseContext6 = parseContext;
                                                    i2 = i5;
                                                    hashMap = hashMap2;
                                                    r5 = r5;
                                                }
                                                fieldInfo2 = fieldInfo;
                                                z3 = false;
                                                obj7 = iArr;
                                                z2 = false;
                                                iArr = obj7;
                                                if (!z3) {
                                                }
                                                if (t == null) {
                                                }
                                                iArr = r5;
                                                parseContext5 = iArr;
                                                hashMap3 = hashMap;
                                                iArr3 = iArr4;
                                                parseContext4 = parseContext5;
                                                if (!z3) {
                                                }
                                                r5 = parseContext4;
                                                i3 = i6 + 1;
                                                obj3 = t;
                                                str = str2;
                                                iArr2 = iArr3;
                                                parseContext6 = parseContext;
                                                i2 = i5;
                                                hashMap = hashMap2;
                                                r5 = r5;
                                            }
                                        } else if (cls == BigInteger.class) {
                                            obj5 = jSONLexerBase.scanFieldBigInteger(cArr);
                                            if (jSONLexerBase.matchStat <= 0) {
                                                if (jSONLexerBase.matchStat == -2) {
                                                    i6 = i4;
                                                    t = iArr;
                                                    i5 = i2 + 1;
                                                    str2 = str;
                                                    parseContext = parseContext6;
                                                    hashMap2 = hashMap;
                                                    iArr = iArr;
                                                    iArr3 = iArr4;
                                                    i3 = i6 + 1;
                                                    obj3 = t;
                                                    str = str2;
                                                    iArr2 = iArr3;
                                                    parseContext6 = parseContext;
                                                    i2 = i5;
                                                    hashMap = hashMap2;
                                                    r5 = r5;
                                                }
                                                fieldInfo2 = fieldInfo;
                                                z3 = false;
                                                obj7 = iArr;
                                                z2 = false;
                                                iArr = obj7;
                                                if (!z3) {
                                                }
                                                if (t == null) {
                                                }
                                                iArr = r5;
                                                parseContext5 = iArr;
                                                hashMap3 = hashMap;
                                                iArr3 = iArr4;
                                                parseContext4 = parseContext5;
                                                if (!z3) {
                                                }
                                                r5 = parseContext4;
                                                i3 = i6 + 1;
                                                obj3 = t;
                                                str = str2;
                                                iArr2 = iArr3;
                                                parseContext6 = parseContext;
                                                i2 = i5;
                                                hashMap = hashMap2;
                                                r5 = r5;
                                            }
                                        } else {
                                            if (cls != Boolean.TYPE) {
                                                if (cls != Boolean.class) {
                                                    if (cls != Float.TYPE) {
                                                        if (cls != Float.class) {
                                                            if (cls != Double.TYPE) {
                                                                if (cls != Double.class) {
                                                                    if (!cls.isEnum() || !(defaultJSONParser.getConfig().getDeserializer(cls) instanceof EnumDeserializer) || !(jSONField == null || jSONField.deserializeUsing() == Void.class)) {
                                                                        if (cls == int[].class) {
                                                                            obj5 = jSONLexerBase.scanFieldIntArray(cArr);
                                                                            if (jSONLexerBase.matchStat <= 0) {
                                                                                if (jSONLexerBase.matchStat == -2) {
                                                                                    i6 = i4;
                                                                                    t = iArr;
                                                                                    i5 = i2 + 1;
                                                                                    str2 = str;
                                                                                    parseContext = parseContext6;
                                                                                    hashMap2 = hashMap;
                                                                                    iArr = iArr;
                                                                                    iArr3 = iArr4;
                                                                                    i3 = i6 + 1;
                                                                                    obj3 = t;
                                                                                    str = str2;
                                                                                    iArr2 = iArr3;
                                                                                    parseContext6 = parseContext;
                                                                                    i2 = i5;
                                                                                    hashMap = hashMap2;
                                                                                    r5 = r5;
                                                                                }
                                                                                fieldInfo2 = fieldInfo;
                                                                                z3 = false;
                                                                                obj7 = iArr;
                                                                                z2 = false;
                                                                                iArr = obj7;
                                                                                if (!z3) {
                                                                                }
                                                                                if (t == null) {
                                                                                }
                                                                                iArr = r5;
                                                                                parseContext5 = iArr;
                                                                                hashMap3 = hashMap;
                                                                                iArr3 = iArr4;
                                                                                parseContext4 = parseContext5;
                                                                                if (!z3) {
                                                                                }
                                                                                r5 = parseContext4;
                                                                                i3 = i6 + 1;
                                                                                obj3 = t;
                                                                                str = str2;
                                                                                iArr2 = iArr3;
                                                                                parseContext6 = parseContext;
                                                                                i2 = i5;
                                                                                hashMap = hashMap2;
                                                                                r5 = r5;
                                                                            }
                                                                        } else if (cls == float[].class) {
                                                                            obj5 = jSONLexerBase.scanFieldFloatArray(cArr);
                                                                            if (jSONLexerBase.matchStat <= 0) {
                                                                                if (jSONLexerBase.matchStat == -2) {
                                                                                    i6 = i4;
                                                                                    t = iArr;
                                                                                    i5 = i2 + 1;
                                                                                    str2 = str;
                                                                                    parseContext = parseContext6;
                                                                                    hashMap2 = hashMap;
                                                                                    iArr = iArr;
                                                                                    iArr3 = iArr4;
                                                                                    i3 = i6 + 1;
                                                                                    obj3 = t;
                                                                                    str = str2;
                                                                                    iArr2 = iArr3;
                                                                                    parseContext6 = parseContext;
                                                                                    i2 = i5;
                                                                                    hashMap = hashMap2;
                                                                                    r5 = r5;
                                                                                }
                                                                                fieldInfo2 = fieldInfo;
                                                                                z3 = false;
                                                                                obj7 = iArr;
                                                                                z2 = false;
                                                                                iArr = obj7;
                                                                                if (!z3) {
                                                                                }
                                                                                if (t == null) {
                                                                                }
                                                                                iArr = r5;
                                                                                parseContext5 = iArr;
                                                                                hashMap3 = hashMap;
                                                                                iArr3 = iArr4;
                                                                                parseContext4 = parseContext5;
                                                                                if (!z3) {
                                                                                }
                                                                                r5 = parseContext4;
                                                                                i3 = i6 + 1;
                                                                                obj3 = t;
                                                                                str = str2;
                                                                                iArr2 = iArr3;
                                                                                parseContext6 = parseContext;
                                                                                i2 = i5;
                                                                                hashMap = hashMap2;
                                                                                r5 = r5;
                                                                            }
                                                                        } else if (cls == float[][].class) {
                                                                            obj5 = jSONLexerBase.scanFieldFloatArray2(cArr);
                                                                            if (jSONLexerBase.matchStat <= 0) {
                                                                                if (jSONLexerBase.matchStat == -2) {
                                                                                    i6 = i4;
                                                                                    t = iArr;
                                                                                    i5 = i2 + 1;
                                                                                    str2 = str;
                                                                                    parseContext = parseContext6;
                                                                                    hashMap2 = hashMap;
                                                                                    iArr = iArr;
                                                                                    iArr3 = iArr4;
                                                                                    i3 = i6 + 1;
                                                                                    obj3 = t;
                                                                                    str = str2;
                                                                                    iArr2 = iArr3;
                                                                                    parseContext6 = parseContext;
                                                                                    i2 = i5;
                                                                                    hashMap = hashMap2;
                                                                                    r5 = r5;
                                                                                }
                                                                                fieldInfo2 = fieldInfo;
                                                                                z3 = false;
                                                                                obj7 = iArr;
                                                                                z2 = false;
                                                                                iArr = obj7;
                                                                                if (!z3) {
                                                                                }
                                                                                if (t == null) {
                                                                                }
                                                                                iArr = r5;
                                                                                parseContext5 = iArr;
                                                                                hashMap3 = hashMap;
                                                                                iArr3 = iArr4;
                                                                                parseContext4 = parseContext5;
                                                                                if (!z3) {
                                                                                }
                                                                                r5 = parseContext4;
                                                                                i3 = i6 + 1;
                                                                                obj3 = t;
                                                                                str = str2;
                                                                                iArr2 = iArr3;
                                                                                parseContext6 = parseContext;
                                                                                i2 = i5;
                                                                                hashMap = hashMap2;
                                                                                r5 = r5;
                                                                            }
                                                                        } else if (!jSONLexerBase.matchField(cArr)) {
                                                                            t = iArr;
                                                                            i7 = i2;
                                                                            obj4 = iArr;
                                                                            i6 = i4;
                                                                            str2 = str;
                                                                            parseContext = parseContext6;
                                                                            hashMap2 = hashMap;
                                                                            i5 = i7;
                                                                            iArr = obj4;
                                                                            iArr3 = iArr4;
                                                                            i3 = i6 + 1;
                                                                            obj3 = t;
                                                                            str = str2;
                                                                            iArr2 = iArr3;
                                                                            parseContext6 = parseContext;
                                                                            i2 = i5;
                                                                            hashMap = hashMap2;
                                                                            r5 = r5;
                                                                        }
                                                                    } else if (defaultFieldDeserializer instanceof DefaultFieldDeserializer) {
                                                                        obj5 = scanEnum(jSONLexerBase, cArr, defaultFieldDeserializer.fieldValueDeserilizer);
                                                                        if (jSONLexerBase.matchStat > 0) {
                                                                            z3 = true;
                                                                            z2 = true;
                                                                        } else if (jSONLexerBase.matchStat == -2) {
                                                                            i6 = i4;
                                                                            t = iArr;
                                                                            i5 = i2 + 1;
                                                                            str2 = str;
                                                                            parseContext = parseContext6;
                                                                            hashMap2 = hashMap;
                                                                            iArr = iArr;
                                                                            iArr3 = iArr4;
                                                                            i3 = i6 + 1;
                                                                            obj3 = t;
                                                                            str = str2;
                                                                            iArr2 = iArr3;
                                                                            parseContext6 = parseContext;
                                                                            i2 = i5;
                                                                            hashMap = hashMap2;
                                                                            r5 = r5;
                                                                        } else {
                                                                            z3 = false;
                                                                            z2 = false;
                                                                        }
                                                                        fieldInfo2 = fieldInfo;
                                                                        iArr = iArr;
                                                                        if (!z3) {
                                                                        }
                                                                        if (t == null) {
                                                                        }
                                                                        iArr = r5;
                                                                        parseContext5 = iArr;
                                                                        hashMap3 = hashMap;
                                                                        iArr3 = iArr4;
                                                                        parseContext4 = parseContext5;
                                                                        if (!z3) {
                                                                        }
                                                                        r5 = parseContext4;
                                                                        i3 = i6 + 1;
                                                                        obj3 = t;
                                                                        str = str2;
                                                                        iArr2 = iArr3;
                                                                        parseContext6 = parseContext;
                                                                        i2 = i5;
                                                                        hashMap = hashMap2;
                                                                        r5 = r5;
                                                                    }
                                                                }
                                                            }
                                                            double scanFieldDouble = jSONLexerBase.scanFieldDouble(cArr);
                                                            if (scanFieldDouble == 0.0d) {
                                                                fieldInfo2 = fieldInfo;
                                                                if (jSONLexerBase.matchStat == 5) {
                                                                    obj5 = null;
                                                                    if (jSONLexerBase.matchStat <= 0) {
                                                                        if (jSONLexerBase.matchStat == -2) {
                                                                            i6 = i4;
                                                                            t = iArr;
                                                                            i5 = i2 + 1;
                                                                            str2 = str;
                                                                            parseContext = parseContext6;
                                                                            hashMap2 = hashMap;
                                                                            iArr = iArr;
                                                                            iArr3 = iArr4;
                                                                            i3 = i6 + 1;
                                                                            obj3 = t;
                                                                            str = str2;
                                                                            iArr2 = iArr3;
                                                                            parseContext6 = parseContext;
                                                                            i2 = i5;
                                                                            hashMap = hashMap2;
                                                                            r5 = r5;
                                                                        }
                                                                        z3 = false;
                                                                        obj7 = iArr;
                                                                        z2 = false;
                                                                        iArr = obj7;
                                                                        if (!z3) {
                                                                        }
                                                                        if (t == null) {
                                                                        }
                                                                        iArr = r5;
                                                                        parseContext5 = iArr;
                                                                        hashMap3 = hashMap;
                                                                        iArr3 = iArr4;
                                                                        parseContext4 = parseContext5;
                                                                        if (!z3) {
                                                                        }
                                                                        r5 = parseContext4;
                                                                        i3 = i6 + 1;
                                                                        obj3 = t;
                                                                        str = str2;
                                                                        iArr2 = iArr3;
                                                                        parseContext6 = parseContext;
                                                                        i2 = i5;
                                                                        hashMap = hashMap2;
                                                                        r5 = r5;
                                                                    }
                                                                }
                                                            } else {
                                                                fieldInfo2 = fieldInfo;
                                                            }
                                                            obj5 = Double.valueOf(scanFieldDouble);
                                                            if (jSONLexerBase.matchStat <= 0) {
                                                            }
                                                        }
                                                    }
                                                    fieldInfo2 = fieldInfo;
                                                    float scanFieldFloat = jSONLexerBase.scanFieldFloat(cArr);
                                                    if (scanFieldFloat == 0.0f && jSONLexerBase.matchStat == 5) {
                                                        obj5 = null;
                                                    } else {
                                                        obj5 = Float.valueOf(scanFieldFloat);
                                                    }
                                                    if (jSONLexerBase.matchStat <= 0) {
                                                        if (jSONLexerBase.matchStat == -2) {
                                                            i6 = i4;
                                                            t = iArr;
                                                            i5 = i2 + 1;
                                                            str2 = str;
                                                            parseContext = parseContext6;
                                                            hashMap2 = hashMap;
                                                            iArr = iArr;
                                                            iArr3 = iArr4;
                                                            i3 = i6 + 1;
                                                            obj3 = t;
                                                            str = str2;
                                                            iArr2 = iArr3;
                                                            parseContext6 = parseContext;
                                                            i2 = i5;
                                                            hashMap = hashMap2;
                                                            r5 = r5;
                                                        }
                                                        z3 = false;
                                                        obj7 = iArr;
                                                        z2 = false;
                                                        iArr = obj7;
                                                        if (!z3) {
                                                        }
                                                        if (t == null) {
                                                        }
                                                        iArr = r5;
                                                        parseContext5 = iArr;
                                                        hashMap3 = hashMap;
                                                        iArr3 = iArr4;
                                                        parseContext4 = parseContext5;
                                                        if (!z3) {
                                                        }
                                                        r5 = parseContext4;
                                                        i3 = i6 + 1;
                                                        obj3 = t;
                                                        str = str2;
                                                        iArr2 = iArr3;
                                                        parseContext6 = parseContext;
                                                        i2 = i5;
                                                        hashMap = hashMap2;
                                                        r5 = r5;
                                                    }
                                                }
                                            }
                                            fieldInfo2 = fieldInfo;
                                            boolean scanFieldBoolean = jSONLexerBase.scanFieldBoolean(cArr);
                                            if (jSONLexerBase.matchStat == 5) {
                                                obj5 = null;
                                            } else {
                                                obj5 = Boolean.valueOf(scanFieldBoolean);
                                            }
                                            if (jSONLexerBase.matchStat <= 0) {
                                                if (jSONLexerBase.matchStat == -2) {
                                                    i6 = i4;
                                                    t = iArr;
                                                    i5 = i2 + 1;
                                                    str2 = str;
                                                    parseContext = parseContext6;
                                                    hashMap2 = hashMap;
                                                    iArr = iArr;
                                                    iArr3 = iArr4;
                                                    i3 = i6 + 1;
                                                    obj3 = t;
                                                    str = str2;
                                                    iArr2 = iArr3;
                                                    parseContext6 = parseContext;
                                                    i2 = i5;
                                                    hashMap = hashMap2;
                                                    r5 = r5;
                                                }
                                                z3 = false;
                                                obj7 = iArr;
                                                z2 = false;
                                                iArr = obj7;
                                                if (!z3) {
                                                }
                                                if (t == null) {
                                                }
                                                iArr = r5;
                                                parseContext5 = iArr;
                                                hashMap3 = hashMap;
                                                iArr3 = iArr4;
                                                parseContext4 = parseContext5;
                                                if (!z3) {
                                                }
                                                r5 = parseContext4;
                                                i3 = i6 + 1;
                                                obj3 = t;
                                                str = str2;
                                                iArr2 = iArr3;
                                                parseContext6 = parseContext;
                                                i2 = i5;
                                                hashMap = hashMap2;
                                                r5 = r5;
                                            }
                                        }
                                        fieldInfo2 = fieldInfo;
                                    }
                                }
                                fieldInfo2 = fieldInfo;
                                long scanFieldLong = jSONLexerBase.scanFieldLong(cArr);
                                if (scanFieldLong == 0 && jSONLexerBase.matchStat == 5) {
                                    obj5 = null;
                                } else {
                                    obj5 = Long.valueOf(scanFieldLong);
                                }
                                if (jSONLexerBase.matchStat <= 0) {
                                    if (jSONLexerBase.matchStat == -2) {
                                        i6 = i4;
                                        t = iArr;
                                        i5 = i2 + 1;
                                        str2 = str;
                                        parseContext = parseContext6;
                                        hashMap2 = hashMap;
                                        iArr = iArr;
                                        iArr3 = iArr4;
                                        i3 = i6 + 1;
                                        obj3 = t;
                                        str = str2;
                                        iArr2 = iArr3;
                                        parseContext6 = parseContext;
                                        i2 = i5;
                                        hashMap = hashMap2;
                                        r5 = r5;
                                    }
                                    z3 = false;
                                    obj7 = iArr;
                                    z2 = false;
                                    iArr = obj7;
                                    if (!z3) {
                                    }
                                    if (t == null) {
                                    }
                                    iArr = r5;
                                    parseContext5 = iArr;
                                    hashMap3 = hashMap;
                                    iArr3 = iArr4;
                                    parseContext4 = parseContext5;
                                    if (!z3) {
                                    }
                                    r5 = parseContext4;
                                    i3 = i6 + 1;
                                    obj3 = t;
                                    str = str2;
                                    iArr2 = iArr3;
                                    parseContext6 = parseContext;
                                    i2 = i5;
                                    hashMap = hashMap2;
                                    r5 = r5;
                                }
                            }
                            z3 = true;
                            z2 = true;
                            iArr = iArr;
                            if (!z3) {
                            }
                            if (t == null) {
                            }
                            iArr = r5;
                            parseContext5 = iArr;
                            hashMap3 = hashMap;
                            iArr3 = iArr4;
                            parseContext4 = parseContext5;
                            if (!z3) {
                            }
                            r5 = parseContext4;
                            i3 = i6 + 1;
                            obj3 = t;
                            str = str2;
                            iArr2 = iArr3;
                            parseContext6 = parseContext;
                            i2 = i5;
                            hashMap = hashMap2;
                            r5 = r5;
                        } else {
                            iArr = obj3;
                        }
                    } else {
                        iArr = obj3;
                        iArr4 = iArr2;
                    }
                }
            } else if (jSONLexerBase.isBlankInput()) {
                defaultJSONParser.setContext(parseContext6);
                return null;
            } else {
                if (i9 == 4) {
                    String stringVal3 = jSONLexerBase.stringVal();
                    if (stringVal3.length() == 0) {
                        jSONLexerBase.nextToken();
                        defaultJSONParser.setContext(parseContext6);
                        return null;
                    } else if (this.beanInfo.jsonType != null) {
                        Class<?>[] seeAlso2 = this.beanInfo.jsonType.seeAlso();
                        for (Class<?> cls7 : seeAlso2) {
                            if (Enum.class.isAssignableFrom(cls7)) {
                                try {
                                    T t8 = (T) Enum.valueOf(cls7, stringVal3);
                                    defaultJSONParser.setContext(parseContext6);
                                    return t8;
                                } catch (IllegalArgumentException unused) {
                                    continue;
                                }
                            }
                        }
                    }
                }
                if (i9 == 14 && jSONLexerBase.getCurrent() == ']') {
                    jSONLexerBase.next();
                    jSONLexerBase.nextToken();
                    defaultJSONParser.setContext(parseContext6);
                    return null;
                }
                if (this.beanInfo.factoryMethod != null && this.beanInfo.fields.length == 1) {
                    try {
                        FieldInfo fieldInfo6 = this.beanInfo.fields[0];
                        if (fieldInfo6.fieldClass == Integer.class) {
                            if (i9 == 2) {
                                int intValue = jSONLexerBase.intValue();
                                jSONLexerBase.nextToken();
                                T t9 = (T) createFactoryInstance(config, Integer.valueOf(intValue));
                                defaultJSONParser.setContext(parseContext6);
                                return t9;
                            }
                        } else if (fieldInfo6.fieldClass == String.class && i9 == 4) {
                            String stringVal4 = jSONLexerBase.stringVal();
                            jSONLexerBase.nextToken();
                            T t10 = (T) createFactoryInstance(config, stringVal4);
                            defaultJSONParser.setContext(parseContext6);
                            return t10;
                        }
                    } catch (Exception e5) {
                        throw new JSONException(e5.getMessage(), e5);
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("syntax error, expect {, actual ");
                sb2.append(jSONLexerBase.tokenName());
                sb2.append(", pos ");
                sb2.append(jSONLexerBase.pos());
                if (obj instanceof String) {
                    sb2.append(", fieldName ");
                    sb2.append(obj);
                }
                sb2.append(", fastjson-version ");
                sb2.append("1.2.68");
                throw new JSONException(sb2.toString());
            }
        }
    }

    protected Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanEnumSymbol = jSONLexerBase.scanEnumSymbol(cArr);
        if (jSONLexerBase.matchStat <= 0) {
            return null;
        }
        Enum enumByHashCode = enumDeserializer.getEnumByHashCode(scanEnumSymbol);
        if (enumByHashCode == null) {
            if (scanEnumSymbol == -3750763034362895579L) {
                return null;
            }
            if (jSONLexerBase.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + enumDeserializer.enumClass);
            }
        }
        return enumByHashCode;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        ?? r17;
        JSONLexer jSONLexer;
        FieldDeserializer fieldDeserializer2;
        FieldDeserializer fieldDeserializer3;
        Field[] fieldArr;
        FieldDeserializer fieldDeserializer4;
        JSONLexer jSONLexer2 = defaultJSONParser.lexer;
        int i = Feature.DisableFieldSmartMatch.mask;
        if (jSONLexer2.isEnabled(i) || (i & this.beanInfo.parserFeatures) != 0) {
            fieldDeserializer = getFieldDeserializer(str);
        } else {
            fieldDeserializer = smartMatch(str, iArr);
        }
        int i2 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer != null || (!jSONLexer2.isEnabled(i2) && (i2 & this.beanInfo.parserFeatures) == 0)) {
            fieldDeserializer3 = fieldDeserializer;
        } else {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                Class<?> cls = this.clazz;
                while (cls != null && cls != Object.class) {
                    Field[] declaredFields = cls.getDeclaredFields();
                    int length = declaredFields.length;
                    int i3 = 0;
                    while (i3 < length) {
                        Field field = declaredFields[i3];
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                fieldDeserializer4 = fieldDeserializer;
                                JSONField jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                                if (jSONField != null) {
                                    String name2 = jSONField.name();
                                    fieldArr = declaredFields;
                                    if (!"".equals(name2)) {
                                        name = name2;
                                    }
                                } else {
                                    fieldArr = declaredFields;
                                }
                                concurrentHashMap.put(name, field);
                                i3++;
                                fieldDeserializer = fieldDeserializer4;
                                declaredFields = fieldArr;
                            }
                        }
                        fieldDeserializer4 = fieldDeserializer;
                        fieldArr = declaredFields;
                        i3++;
                        fieldDeserializer = fieldDeserializer4;
                        declaredFields = fieldArr;
                    }
                    cls = cls.getSuperclass();
                }
                fieldDeserializer3 = fieldDeserializer;
                this.extraFieldDeserializers = concurrentHashMap;
            } else {
                fieldDeserializer3 = fieldDeserializer;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    fieldDeserializer2 = (FieldDeserializer) obj2;
                    jSONLexer = jSONLexer2;
                    r17 = 1;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    r17 = 1;
                    jSONLexer = jSONLexer2;
                    fieldDeserializer2 = new DefaultFieldDeserializer(defaultJSONParser.getConfig(), this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer2);
                }
                if (fieldDeserializer2 == null) {
                    int i4 = 0;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                        if (i4 >= fieldDeserializerArr.length) {
                            i4 = -1;
                            break;
                        } else if (fieldDeserializerArr[i4] == fieldDeserializer2) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i4 == -1 || iArr == null || !str.startsWith("_") || !isSetFlag(i4, iArr)) {
                        jSONLexer.nextTokenWithColon(fieldDeserializer2.getFastMatchToken());
                        fieldDeserializer2.parseField(defaultJSONParser, obj, type, map);
                        if (iArr != null) {
                            int i5 = i4 / 32;
                            int i6 = iArr[i5];
                            int i7 = r17 == true ? 1 : 0;
                            int i8 = r17 == true ? 1 : 0;
                            int i9 = r17 == true ? 1 : 0;
                            int i10 = r17 == true ? 1 : 0;
                            iArr[i5] = i6 | (i7 << (i4 % 32));
                        }
                        return r17;
                    }
                    defaultJSONParser.parseExtra(obj, str);
                    return false;
                } else if (jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
                    int i11 = 0;
                    int i12 = -1;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i11 >= fieldDeserializerArr2.length) {
                            break;
                        }
                        FieldDeserializer fieldDeserializer5 = fieldDeserializerArr2[i11];
                        FieldInfo fieldInfo = fieldDeserializer5.fieldInfo;
                        if (fieldInfo.unwrapped && (fieldDeserializer5 instanceof DefaultFieldDeserializer)) {
                            if (fieldInfo.field != null) {
                                DefaultFieldDeserializer defaultFieldDeserializer = (DefaultFieldDeserializer) fieldDeserializer5;
                                ObjectDeserializer fieldValueDeserilizer = defaultFieldDeserializer.getFieldValueDeserilizer(defaultJSONParser.getConfig());
                                if (fieldValueDeserilizer instanceof JavaBeanDeserializer) {
                                    FieldDeserializer fieldDeserializer6 = ((JavaBeanDeserializer) fieldValueDeserilizer).getFieldDeserializer(str);
                                    if (fieldDeserializer6 != null) {
                                        try {
                                            Object obj3 = fieldInfo.field.get(obj);
                                            if (obj3 == null) {
                                                obj3 = ((JavaBeanDeserializer) fieldValueDeserilizer).createInstance(defaultJSONParser, fieldInfo.fieldType);
                                                fieldDeserializer5.setValue(obj, obj3);
                                            }
                                            jSONLexer.nextTokenWithColon(defaultFieldDeserializer.getFastMatchToken());
                                            fieldDeserializer6.parseField(defaultJSONParser, obj3, type, map);
                                        } catch (Exception e) {
                                            throw new JSONException("parse unwrapped field error.", e);
                                        }
                                    }
                                } else if (fieldValueDeserilizer instanceof MapDeserializer) {
                                    MapDeserializer mapDeserializer = (MapDeserializer) fieldValueDeserilizer;
                                    try {
                                        Map<Object, Object> map2 = (Map) fieldInfo.field.get(obj);
                                        if (map2 == null) {
                                            map2 = mapDeserializer.createMap(fieldInfo.fieldType);
                                            fieldDeserializer5.setValue(obj, map2);
                                        }
                                        jSONLexer.nextTokenWithColon();
                                        map2.put(str, defaultJSONParser.parse(str));
                                    } catch (Exception e2) {
                                        throw new JSONException("parse unwrapped field error.", e2);
                                    }
                                }
                            } else if (fieldInfo.method.getParameterTypes().length == 2) {
                                jSONLexer.nextTokenWithColon();
                                Object parse = defaultJSONParser.parse(str);
                                try {
                                    Method method = fieldInfo.method;
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str;
                                    char c = r17 == true ? 1 : 0;
                                    char c2 = r17 == true ? 1 : 0;
                                    char c3 = r17 == true ? 1 : 0;
                                    char c4 = r17 == true ? 1 : 0;
                                    objArr[c] = parse;
                                    method.invoke(obj, objArr);
                                } catch (Exception e3) {
                                    throw new JSONException("parse unwrapped field error.", e3);
                                }
                            }
                            i12 = i11;
                        }
                        i11++;
                    }
                    if (i12 != -1) {
                        if (iArr != null) {
                            int i13 = i12 / 32;
                            iArr[i13] = iArr[i13] | (r17 << (i12 % 32));
                        }
                        return r17;
                    }
                    defaultJSONParser.parseExtra(obj, str);
                    return false;
                } else {
                    throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
                }
            }
        }
        jSONLexer = jSONLexer2;
        r17 = 1;
        fieldDeserializer2 = fieldDeserializer3;
        if (fieldDeserializer2 == null) {
        }
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        boolean z;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            long fnv1a_64_lower = TypeUtils.fnv1a_64_lower(str);
            int i = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i2 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i2 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i2] = TypeUtils.fnv1a_64_lower(fieldDeserializerArr[i2].fieldInfo.name);
                    i2++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv1a_64_lower);
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s = this.smartMatchHashArrayMapping[binarySearch];
                if (s != -1 && !isSetFlag(s, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s];
                }
            }
            if (fieldDeserializer != null) {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class<?> cls = fieldInfo.fieldClass;
                if (!(!z || cls == Boolean.TYPE || cls == Boolean.class)) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    private Object createFactoryInstance(ParserConfig parserConfig, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return this.beanInfo.factoryMethod.invoke(null, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0248, code lost:
        if (r12.beanInfo.fields[r13].fieldClass == java.lang.String.class) goto L_0x024f;
     */
    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Integer num;
        Object obj;
        double d;
        float f;
        boolean z = true;
        if (this.beanInfo.creatorConstructor == null && this.beanInfo.factoryMethod == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                FieldDeserializer smartMatch = smartMatch(entry.getKey());
                if (smartMatch != null) {
                    FieldInfo fieldInfo = smartMatch.fieldInfo;
                    Field field = smartMatch.fieldInfo.field;
                    Type type = fieldInfo.fieldType;
                    if (fieldInfo.declaringClass == null || fieldInfo.getAnnotation() == null || fieldInfo.getAnnotation().deserializeUsing() == Void.class || !fieldInfo.fieldClass.isInstance(value)) {
                        if (field != null) {
                            Class<?> type2 = field.getType();
                            if (type2 == Boolean.TYPE) {
                                if (value == Boolean.FALSE) {
                                    field.setBoolean(createInstance, false);
                                } else if (value == Boolean.TRUE) {
                                    field.setBoolean(createInstance, true);
                                }
                            } else if (type2 == Integer.TYPE) {
                                if (value instanceof Number) {
                                    field.setInt(createInstance, ((Number) value).intValue());
                                }
                            } else if (type2 == Long.TYPE) {
                                if (value instanceof Number) {
                                    field.setLong(createInstance, ((Number) value).longValue());
                                }
                            } else if (type2 == Float.TYPE) {
                                if (value instanceof Number) {
                                    field.setFloat(createInstance, ((Number) value).floatValue());
                                } else if (value instanceof String) {
                                    String str = (String) value;
                                    if (str.length() <= 10) {
                                        f = TypeUtils.parseFloat(str);
                                    } else {
                                        f = Float.parseFloat(str);
                                    }
                                    field.setFloat(createInstance, f);
                                }
                            } else if (type2 == Double.TYPE) {
                                if (value instanceof Number) {
                                    field.setDouble(createInstance, ((Number) value).doubleValue());
                                } else if (value instanceof String) {
                                    String str2 = (String) value;
                                    if (str2.length() <= 10) {
                                        d = TypeUtils.parseDouble(str2);
                                    } else {
                                        d = Double.parseDouble(str2);
                                    }
                                    field.setDouble(createInstance, d);
                                }
                            } else if (value != null && type == value.getClass()) {
                                field.set(createInstance, value);
                            }
                        }
                        String str3 = fieldInfo.format;
                        if (str3 != null && type == Date.class) {
                            obj = TypeUtils.castToDate(value, str3);
                        } else if (str3 != null && (type instanceof Class) && ((Class) type).getName().equals("java.time.LocalDateTime")) {
                            obj = TypeUtils.castToLocalDateTime(value, str3);
                        } else if (type instanceof ParameterizedType) {
                            obj = TypeUtils.cast(value, (ParameterizedType) type, parserConfig);
                        } else {
                            obj = TypeUtils.cast(value, type, parserConfig);
                        }
                        smartMatch.setValue(createInstance, obj);
                    } else {
                        smartMatch.parseField(new DefaultJSONParser(JSON.toJSONString(value)), createInstance, type, null);
                    }
                }
            }
            if (this.beanInfo.buildMethod == null) {
                return createInstance;
            }
            try {
                return this.beanInfo.buildMethod.invoke(createInstance, new Object[0]);
            } catch (Exception e) {
                throw new JSONException("build object error", e);
            }
        } else {
            FieldInfo[] fieldInfoArr = this.beanInfo.fields;
            int length = fieldInfoArr.length;
            Object[] objArr = new Object[length];
            HashMap hashMap = null;
            for (int i = 0; i < length; i++) {
                FieldInfo fieldInfo2 = fieldInfoArr[i];
                boolean z2 = map.get(fieldInfo2.name);
                if (z2 == null) {
                    Class<?> cls = fieldInfo2.fieldClass;
                    if (cls == Integer.TYPE) {
                        z2 = 0;
                    } else if (cls == Long.TYPE) {
                        z2 = 0L;
                    } else if (cls == Short.TYPE) {
                        z2 = (short) 0;
                    } else if (cls == Byte.TYPE) {
                        z2 = (byte) 0;
                    } else if (cls == Float.TYPE) {
                        z2 = Float.valueOf(0.0f);
                    } else if (cls == Double.TYPE) {
                        z2 = Double.valueOf(0.0d);
                    } else if (cls == Character.TYPE) {
                        z2 = '0';
                    } else if (cls == Boolean.TYPE) {
                        z2 = false;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(fieldInfo2.name, Integer.valueOf(i));
                }
                objArr[i] = z2;
            }
            if (hashMap != null) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    Object value2 = entry2.getValue();
                    FieldDeserializer smartMatch2 = smartMatch(entry2.getKey());
                    if (!(smartMatch2 == null || (num = (Integer) hashMap.get(smartMatch2.fieldInfo.name)) == null)) {
                        objArr[num.intValue()] = value2;
                    }
                }
            }
            if (this.beanInfo.creatorConstructor != null) {
                if (this.beanInfo.f192kotlin) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (objArr[i2] != null || this.beanInfo.fields == null || i2 >= this.beanInfo.fields.length) {
                            i2++;
                        }
                    }
                    if (z || this.beanInfo.kotlinDefaultConstructor == null) {
                        return this.beanInfo.creatorConstructor.newInstance(objArr);
                    }
                    try {
                        Object newInstance = this.beanInfo.kotlinDefaultConstructor.newInstance(new Object[0]);
                        for (int i3 = 0; i3 < length; i3++) {
                            Object obj2 = objArr[i3];
                            if (!(obj2 == null || this.beanInfo.fields == null || i3 >= this.beanInfo.fields.length)) {
                                this.beanInfo.fields[i3].set(newInstance, obj2);
                            }
                        }
                        return newInstance;
                    } catch (Exception e2) {
                        throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e2);
                    }
                }
                z = false;
                if (z) {
                }
                try {
                    return this.beanInfo.creatorConstructor.newInstance(objArr);
                } catch (Exception e3) {
                    throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e3);
                }
            } else if (this.beanInfo.factoryMethod == null) {
                return null;
            } else {
                try {
                    return this.beanInfo.factoryMethod.invoke(null, objArr);
                } catch (Exception e4) {
                    throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e4);
                }
            }
        }
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    protected static JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        if (javaBeanInfo.jsonType == null) {
            return null;
        }
        for (Class<?> cls : javaBeanInfo.jsonType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    protected static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            } else if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
            return;
        }
        jSONLexerBase.nextToken(16);
    }
}
