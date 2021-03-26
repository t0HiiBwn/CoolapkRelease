package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class JSONPath implements JSONAware {
    static final long LENGTH = -1580386065683472715L;
    static final long SIZE = 5614464919154503228L;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private boolean hasRefSegment;
    private ParserConfig parserConfig;
    private final String path;
    private Segment[] segments;
    private SerializeConfig serializeConfig;

    interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    interface Segment {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);

        void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context);
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public JSONPath(String str, SerializeConfig serializeConfig2, ParserConfig parserConfig2) {
        if (str == null || str.length() == 0) {
            throw new JSONPathException("json-path can not be null or empty");
        }
        this.path = str;
        this.serializeConfig = serializeConfig2;
        this.parserConfig = parserConfig2;
    }

    protected void init() {
        if (this.segments == null) {
            if ("*".equals(this.path)) {
                this.segments = new Segment[]{WildCardSegment.instance};
                return;
            }
            JSONPathParser jSONPathParser = new JSONPathParser(this.path);
            this.segments = jSONPathParser.explain();
            this.hasRefSegment = jSONPathParser.hasRefSegment;
        }
    }

    public boolean isRef() {
        init();
        int i = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return true;
            }
            Class<?> cls = segmentArr[i].getClass();
            if (cls != ArrayAccessSegment.class && cls != PropertySegment.class) {
                return false;
            }
            i++;
        }
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return obj2;
            }
            obj2 = segmentArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public Object extract(DefaultJSONParser defaultJSONParser) {
        if (defaultJSONParser == null) {
            return null;
        }
        init();
        if (this.hasRefSegment) {
            return eval(defaultJSONParser.parse());
        }
        if (this.segments.length == 0) {
            return defaultJSONParser.parse();
        }
        Context context = null;
        int i = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return context.object;
            }
            Segment segment = segmentArr[i];
            boolean z = true;
            boolean z2 = i == segmentArr.length - 1;
            if (context == null || context.object == null) {
                if (!z2) {
                    Segment segment2 = this.segments[i + 1];
                    if ((!(segment instanceof PropertySegment) || !((PropertySegment) segment).deep || (!(segment2 instanceof ArrayAccessSegment) && !(segment2 instanceof MultiIndexSegment) && !(segment2 instanceof MultiPropertySegment) && !(segment2 instanceof SizeSegment) && !(segment2 instanceof PropertySegment) && !(segment2 instanceof FilterSegment))) && ((!(segment2 instanceof ArrayAccessSegment) || ((ArrayAccessSegment) segment2).index >= 0) && !(segment2 instanceof FilterSegment) && !(segment instanceof WildCardSegment))) {
                        z = false;
                    }
                }
                Context context2 = new Context(context, z);
                segment.extract(this, defaultJSONParser, context2);
                context = context2;
            } else {
                context.object = segment.eval(this, null, context.object);
            }
            i++;
        }
    }

    private static class Context {
        final boolean eval;
        Object object;
        final Context parent;

        public Context(Context context, boolean z) {
            this.parent = context;
            this.eval = z;
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return true;
            }
            Object eval = segmentArr[i].eval(this, obj, obj2);
            if (eval == null) {
                return false;
            }
            if (eval == Collections.EMPTY_LIST && (obj2 instanceof List)) {
                return ((List) obj2).contains(eval);
            }
            i++;
            obj2 = eval;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object eval = eval(obj);
        if (eval == obj2) {
            return true;
        }
        if (eval == null) {
            return false;
        }
        if (!(eval instanceof Iterable)) {
            return eq(eval, obj2);
        }
        for (Object obj3 : (Iterable) eval) {
            if (eq(obj3, obj2)) {
                return true;
            }
        }
        return false;
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return evalSize(obj2);
            }
            obj2 = segmentArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public Set<?> keySet(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return evalKeySet(obj2);
            }
            obj2 = segmentArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr != null && objArr.length != 0 && obj != null) {
            init();
            Object obj2 = null;
            int i = 0;
            Object obj3 = obj;
            int i2 = 0;
            while (true) {
                Segment[] segmentArr = this.segments;
                if (i2 >= segmentArr.length) {
                    break;
                }
                if (i2 == segmentArr.length - 1) {
                    obj2 = obj3;
                }
                obj3 = segmentArr[i2].eval(this, obj, obj3);
                i2++;
            }
            if (obj3 == null) {
                throw new JSONPathException("value not found in path " + this.path);
            } else if (obj3 instanceof Collection) {
                Collection collection = (Collection) obj3;
                int length = objArr.length;
                while (i < length) {
                    collection.add(objArr[i]);
                    i++;
                }
            } else {
                Class<?> cls = obj3.getClass();
                if (cls.isArray()) {
                    int length2 = Array.getLength(obj3);
                    Object newInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
                    System.arraycopy(obj3, 0, newInstance, 0, length2);
                    while (i < objArr.length) {
                        Array.set(newInstance, length2 + i, objArr[i]);
                        i++;
                    }
                    Segment[] segmentArr2 = this.segments;
                    Segment segment = segmentArr2[segmentArr2.length - 1];
                    if (segment instanceof PropertySegment) {
                        ((PropertySegment) segment).setValue(this, obj2, newInstance);
                    } else if (segment instanceof ArrayAccessSegment) {
                        ((ArrayAccessSegment) segment).setValue(this, obj2, newInstance);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    throw new JSONException("unsupported array put operation. " + cls);
                }
            }
        }
    }

    public boolean remove(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        init();
        Collection<Object> collection = null;
        Segment[] segmentArr = this.segments;
        Segment segment = segmentArr[segmentArr.length - 1];
        Object obj2 = obj;
        int i = 0;
        while (true) {
            Segment[] segmentArr2 = this.segments;
            if (i >= segmentArr2.length) {
                break;
            } else if (i == segmentArr2.length - 1) {
                collection = obj2;
                break;
            } else {
                Segment segment2 = segmentArr2[i];
                if (i == segmentArr2.length - 2 && (segment instanceof FilterSegment) && (segment2 instanceof PropertySegment)) {
                    FilterSegment filterSegment = (FilterSegment) segment;
                    if (obj2 instanceof List) {
                        PropertySegment propertySegment = (PropertySegment) segment2;
                        Iterator it2 = ((List) obj2).iterator();
                        while (it2.hasNext()) {
                            Object eval = propertySegment.eval(this, obj, it2.next());
                            if (eval instanceof Iterable) {
                                filterSegment.remove(this, obj, eval);
                            } else if ((eval instanceof Map) && filterSegment.filter.apply(this, obj, obj2, eval)) {
                                it2.remove();
                            }
                        }
                        return true;
                    } else if (obj2 instanceof Map) {
                        PropertySegment propertySegment2 = (PropertySegment) segment2;
                        Object eval2 = propertySegment2.eval(this, obj, obj2);
                        if (eval2 == null) {
                            return false;
                        }
                        if ((eval2 instanceof Map) && filterSegment.filter.apply(this, obj, obj2, eval2)) {
                            propertySegment2.remove(this, obj2);
                            return true;
                        }
                    }
                }
                obj2 = segment2.eval(this, obj, obj2);
                if (obj2 == null) {
                    break;
                }
                i++;
            }
        }
        if (collection == null) {
            return false;
        }
        if (segment instanceof PropertySegment) {
            PropertySegment propertySegment3 = (PropertySegment) segment;
            if (collection instanceof Collection) {
                Segment[] segmentArr3 = this.segments;
                if (segmentArr3.length > 1) {
                    Segment segment3 = segmentArr3[segmentArr3.length - 2];
                    if ((segment3 instanceof RangeSegment) || (segment3 instanceof MultiIndexSegment)) {
                        for (Object obj3 : collection) {
                            if (propertySegment3.remove(this, obj3)) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            }
            return propertySegment3.remove(this, collection);
        } else if (segment instanceof ArrayAccessSegment) {
            return ((ArrayAccessSegment) segment).remove(this, collection);
        } else {
            if (segment instanceof FilterSegment) {
                return ((FilterSegment) segment).remove(this, obj, collection);
            }
            throw new UnsupportedOperationException();
        }
    }

    public boolean set(Object obj, Object obj2) {
        return set(obj, obj2, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    public boolean set(Object obj, Object obj2, boolean z) {
        JavaBeanDeserializer javaBeanDeserializer;
        Class<?> cls;
        if (obj == null) {
            return false;
        }
        init();
        Object obj3 = obj;
        Object obj4 = null;
        int i = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                obj3 = obj4;
                break;
            }
            Segment segment = segmentArr[i];
            Object eval = segment.eval(this, obj, obj3);
            if (eval == null) {
                Segment[] segmentArr2 = this.segments;
                Segment segment2 = i < segmentArr2.length - 1 ? segmentArr2[i + 1] : null;
                if (segment2 instanceof PropertySegment) {
                    if (segment instanceof PropertySegment) {
                        String str = ((PropertySegment) segment).propertyName;
                        JavaBeanDeserializer javaBeanDeserializer2 = getJavaBeanDeserializer(obj3.getClass());
                        if (javaBeanDeserializer2 != null) {
                            cls = javaBeanDeserializer2.getFieldDeserializer(str).fieldInfo.fieldClass;
                            javaBeanDeserializer = getJavaBeanDeserializer(cls);
                            if (javaBeanDeserializer != null) {
                                eval = new JSONObject();
                            } else if (javaBeanDeserializer.beanInfo.defaultConstructor == null) {
                                return false;
                            } else {
                                eval = javaBeanDeserializer.createInstance((DefaultJSONParser) null, cls);
                            }
                        }
                    }
                    cls = null;
                    javaBeanDeserializer = null;
                    if (javaBeanDeserializer != null) {
                    }
                } else {
                    eval = segment2 instanceof ArrayAccessSegment ? new JSONArray() : null;
                }
                if (eval != null) {
                    if (!(segment instanceof PropertySegment)) {
                        if (!(segment instanceof ArrayAccessSegment)) {
                            break;
                        }
                        ((ArrayAccessSegment) segment).setValue(this, obj3, eval);
                    } else {
                        ((PropertySegment) segment).setValue(this, obj3, eval);
                    }
                } else {
                    break;
                }
            }
            i++;
            obj4 = obj3;
            obj3 = eval;
        }
        if (obj3 == null) {
            return false;
        }
        Segment[] segmentArr3 = this.segments;
        Segment segment3 = segmentArr3[segmentArr3.length - 1];
        if (segment3 instanceof PropertySegment) {
            ((PropertySegment) segment3).setValue(this, obj3, obj2);
            return true;
        } else if (segment3 instanceof ArrayAccessSegment) {
            return ((ArrayAccessSegment) segment3).setValue(this, obj3, obj2);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static int size(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalSize(compile.eval(obj));
    }

    public static Set<?> keySet(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalKeySet(compile.eval(obj));
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }

    public static boolean remove(Object obj, String str) {
        return compile(str).remove(obj);
    }

    public static JSONPath compile(String str) {
        if (str != null) {
            JSONPath jSONPath = pathCache.get(str);
            if (jSONPath != null) {
                return jSONPath;
            }
            JSONPath jSONPath2 = new JSONPath(str);
            if (pathCache.size() >= 1024) {
                return jSONPath2;
            }
            pathCache.putIfAbsent(str, jSONPath2);
            return pathCache.get(str);
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    public static Object extract(String str, String str2, ParserConfig parserConfig2, int i, Feature... featureArr) {
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig2, i | Feature.OrderedField.mask);
        Object extract = compile(str2).extract(defaultJSONParser);
        defaultJSONParser.lexer.close();
        return extract;
    }

    public static Object extract(String str, String str2) {
        return extract(str, str2, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
    }

    public static Map<String, Object> paths(Object obj) {
        return paths(obj, SerializeConfig.globalInstance);
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig2) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        HashMap hashMap = new HashMap();
        paths(identityHashMap, hashMap, "/", obj, serializeConfig2);
        return hashMap;
    }

    private static void paths(Map<Object, String> map, Map<String, Object> map2, String str, Object obj, SerializeConfig serializeConfig2) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (obj != null) {
            int i = 0;
            if (map.put(obj, str) != null) {
                if (!((obj instanceof String) || (obj instanceof Number) || (obj instanceof Date) || (obj instanceof UUID))) {
                    return;
                }
            }
            map2.put(str, obj);
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        if (str.equals("/")) {
                            sb4 = new StringBuilder();
                        } else {
                            sb4 = new StringBuilder();
                            sb4.append(str);
                        }
                        sb4.append("/");
                        sb4.append(key);
                        paths(map, map2, sb4.toString(), entry.getValue(), serializeConfig2);
                    }
                }
            } else if (obj instanceof Collection) {
                for (Object obj2 : (Collection) obj) {
                    if (str.equals("/")) {
                        sb3 = new StringBuilder();
                    } else {
                        sb3 = new StringBuilder();
                        sb3.append(str);
                    }
                    sb3.append("/");
                    sb3.append(i);
                    paths(map, map2, sb3.toString(), obj2, serializeConfig2);
                    i++;
                }
            } else {
                Class<?> cls = obj.getClass();
                if (cls.isArray()) {
                    int length = Array.getLength(obj);
                    while (i < length) {
                        Object obj3 = Array.get(obj, i);
                        if (str.equals("/")) {
                            sb2 = new StringBuilder();
                        } else {
                            sb2 = new StringBuilder();
                            sb2.append(str);
                        }
                        sb2.append("/");
                        sb2.append(i);
                        paths(map, map2, sb2.toString(), obj3, serializeConfig2);
                        i++;
                    }
                } else if (!ParserConfig.isPrimitive2(cls) && !cls.isEnum()) {
                    ObjectSerializer objectWriter = serializeConfig2.getObjectWriter(cls);
                    if (objectWriter instanceof JavaBeanSerializer) {
                        try {
                            for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                                String key2 = entry2.getKey();
                                if (key2 instanceof String) {
                                    if (str.equals("/")) {
                                        sb = new StringBuilder();
                                        sb.append("/");
                                        sb.append(key2);
                                    } else {
                                        sb = new StringBuilder();
                                        sb.append(str);
                                        sb.append("/");
                                        sb.append(key2);
                                    }
                                    paths(map, map2, sb.toString(), entry2.getValue(), serializeConfig2);
                                }
                            }
                        } catch (Exception e) {
                            throw new JSONException("toJSON error", e);
                        }
                    }
                }
            }
        }
    }

    public String getPath() {
        return this.path;
    }

    static class JSONPathParser {
        private static final Pattern strArrayPatternx = Pattern.compile("'\\s*,\\s*'");
        private static final String strArrayRegex = "'\\s*,\\s*'";
        private char ch;
        private boolean hasRefSegment;
        private int level;
        private final String path;
        private int pos;

        static boolean isDigitFirst(char c) {
            return c == '-' || c == '+' || (c >= '0' && c <= '9');
        }

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        void next() {
            String str = this.path;
            int i = this.pos;
            this.pos = i + 1;
            this.ch = str.charAt(i);
        }

        char getNextChar() {
            return this.path.charAt(this.pos);
        }

        boolean isEOF() {
            return this.pos >= this.path.length();
        }

        Segment readSegement() {
            boolean z = true;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new ArrayAccessSegment(this.ch - '0');
                }
                char c = this.ch;
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    return new PropertySegment(Character.toString(c), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c2 = this.ch;
                if (c2 == '$') {
                    next();
                } else if (c2 == '.' || c2 == '/') {
                    next();
                    if (c2 == '.' && this.ch == '.') {
                        next();
                        int length = this.path.length();
                        int i = this.pos;
                        if (length > i + 3 && this.ch == '[' && this.path.charAt(i) == '*' && this.path.charAt(this.pos + 1) == ']' && this.path.charAt(this.pos + 2) == '.') {
                            next();
                            next();
                            next();
                            next();
                        }
                    } else {
                        z = false;
                    }
                    char c3 = this.ch;
                    if (c3 == '*') {
                        if (!isEOF()) {
                            next();
                        }
                        return z ? WildCardSegment.instance_deep : WildCardSegment.instance;
                    } else if (isDigitFirst(c3)) {
                        return parseArrayAccess(false);
                    } else {
                        String readName = readName();
                        if (this.ch != '(') {
                            return new PropertySegment(readName, z);
                        }
                        next();
                        if (this.ch == ')') {
                            if (!isEOF()) {
                                next();
                            }
                            if ("size".equals(readName) || "length".equals(readName)) {
                                return SizeSegment.instance;
                            }
                            if ("max".equals(readName)) {
                                return MaxSegment.instance;
                            }
                            if ("min".equals(readName)) {
                                return MinSegment.instance;
                            }
                            if ("keySet".equals(readName)) {
                                return KeySetSegment.instance;
                            }
                            throw new JSONPathException("not support jsonpath : " + this.path);
                        }
                        throw new JSONPathException("not support jsonpath : " + this.path);
                    }
                } else if (c2 == '[') {
                    return parseArrayAccess(true);
                } else {
                    if (this.level == 0) {
                        return new PropertySegment(readName(), false);
                    }
                    throw new JSONPathException("not support jsonpath : " + this.path);
                }
            }
            return null;
        }

        public final void skipWhitespace() {
            while (true) {
                char c = this.ch;
                if (c > ' ') {
                    return;
                }
                if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                    next();
                } else {
                    return;
                }
            }
        }

        Segment parseArrayAccess(boolean z) {
            Object parseArrayAccessFilter = parseArrayAccessFilter(z);
            if (parseArrayAccessFilter instanceof Segment) {
                return (Segment) parseArrayAccessFilter;
            }
            return new FilterSegment((Filter) parseArrayAccessFilter);
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00cc  */
        Object parseArrayAccessFilter(boolean z) {
            boolean z2;
            int i;
            char c;
            char c2;
            char c3;
            char c4;
            char c5;
            Filter filter;
            char c6;
            Filter filter2;
            char c7;
            String[] strArr;
            String str;
            String str2;
            String str3;
            Operator operator;
            Filter filter3;
            char c8;
            Filter filter4;
            char c9;
            Filter filter5;
            char c10;
            int i2;
            Filter filter6;
            char c11;
            char c12;
            char c13;
            char c14;
            int i3;
            String substring;
            String str4;
            int i4;
            char c15;
            if (z) {
                accept('[');
            }
            if (this.ch == '?') {
                next();
                accept('(');
                i = 1;
                while (this.ch == '(') {
                    next();
                    i++;
                }
                z2 = true;
            } else {
                i = 0;
                z2 = false;
            }
            if (z2 || IOUtils.firstIdentifier(this.ch) || (c14 = this.ch) == '\\' || c14 == '@') {
                if (this.ch == '@') {
                    next();
                    accept('.');
                }
                String readName = readName();
                skipWhitespace();
                if (z2 && this.ch == ')') {
                    next();
                    Filter notNullSegement = new NotNullSegement(readName);
                    while (true) {
                        c13 = this.ch;
                        if (c13 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c13 == '&' || c13 == '|') {
                        notNullSegement = filterRest(notNullSegement);
                    }
                    if (z) {
                        accept(']');
                    }
                    return notNullSegement;
                } else if (!z || this.ch != ']') {
                    Operator readOp = readOp();
                    skipWhitespace();
                    if (readOp == Operator.BETWEEN || readOp == Operator.NOT_BETWEEN) {
                        boolean z3 = readOp == Operator.NOT_BETWEEN;
                        Object readValue = readValue();
                        if ("and".equalsIgnoreCase(readName())) {
                            Object readValue2 = readValue();
                            if (readValue == null || readValue2 == null) {
                                throw new JSONPathException(this.path);
                            } else if (JSONPath.isInt(readValue.getClass()) && JSONPath.isInt(readValue2.getClass())) {
                                return new IntBetweenSegement(readName, TypeUtils.longExtractValue((Number) readValue), TypeUtils.longExtractValue((Number) readValue2), z3);
                            } else {
                                throw new JSONPathException(this.path);
                            }
                        } else {
                            throw new JSONPathException(this.path);
                        }
                    } else if (readOp == Operator.IN || readOp == Operator.NOT_IN) {
                        boolean z4 = readOp == Operator.NOT_IN;
                        accept('(');
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.add(readValue());
                        while (true) {
                            skipWhitespace();
                            if (this.ch != ',') {
                                break;
                            }
                            next();
                            jSONArray.add(readValue());
                        }
                        boolean z5 = true;
                        boolean z6 = true;
                        boolean z7 = true;
                        for (Object obj : jSONArray) {
                            if (obj != null) {
                                Class<?> cls = obj.getClass();
                                if (!(!z5 || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class)) {
                                    z5 = false;
                                    z7 = false;
                                }
                                if (z6 && cls != String.class) {
                                    z6 = false;
                                }
                            } else if (z5) {
                                z5 = false;
                            }
                        }
                        if (jSONArray.size() == 1 && jSONArray.get(0) == null) {
                            if (z4) {
                                filter = new NotNullSegement(readName);
                            } else {
                                filter = new NullSegement(readName);
                            }
                            while (true) {
                                c6 = this.ch;
                                if (c6 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c6 == '&' || c6 == '|') {
                                filter = filterRest(filter);
                            }
                            accept(')');
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return filter;
                        } else if (z5) {
                            if (jSONArray.size() == 1) {
                                Filter intOpSegement = new IntOpSegement(readName, TypeUtils.longExtractValue((Number) jSONArray.get(0)), z4 ? Operator.NE : Operator.EQ);
                                while (true) {
                                    c5 = this.ch;
                                    if (c5 != ' ') {
                                        break;
                                    }
                                    next();
                                }
                                if (c5 == '&' || c5 == '|') {
                                    intOpSegement = filterRest(intOpSegement);
                                }
                                accept(')');
                                if (z2) {
                                    accept(')');
                                }
                                if (z) {
                                    accept(']');
                                }
                                return intOpSegement;
                            }
                            int size = jSONArray.size();
                            long[] jArr = new long[size];
                            for (int i5 = 0; i5 < size; i5++) {
                                jArr[i5] = TypeUtils.longExtractValue((Number) jSONArray.get(i5));
                            }
                            Filter intInSegement = new IntInSegement(readName, jArr, z4);
                            while (true) {
                                c4 = this.ch;
                                if (c4 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c4 == '&' || c4 == '|') {
                                intInSegement = filterRest(intInSegement);
                            }
                            accept(')');
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return intInSegement;
                        } else if (!z6) {
                            if (z7) {
                                int size2 = jSONArray.size();
                                Long[] lArr = new Long[size2];
                                for (int i6 = 0; i6 < size2; i6++) {
                                    Number number = (Number) jSONArray.get(i6);
                                    if (number != null) {
                                        lArr[i6] = Long.valueOf(TypeUtils.longExtractValue(number));
                                    }
                                }
                                Filter intObjInSegement = new IntObjInSegement(readName, lArr, z4);
                                while (true) {
                                    c = this.ch;
                                    if (c != ' ') {
                                        break;
                                    }
                                    next();
                                }
                                if (c == '&' || c == '|') {
                                    intObjInSegement = filterRest(intObjInSegement);
                                }
                                accept(')');
                                if (z2) {
                                    accept(')');
                                }
                                if (z) {
                                    accept(']');
                                }
                                return intObjInSegement;
                            }
                            throw new UnsupportedOperationException();
                        } else if (jSONArray.size() == 1) {
                            Filter stringOpSegement = new StringOpSegement(readName, (String) jSONArray.get(0), z4 ? Operator.NE : Operator.EQ);
                            while (true) {
                                c3 = this.ch;
                                if (c3 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c3 == '&' || c3 == '|') {
                                stringOpSegement = filterRest(stringOpSegement);
                            }
                            accept(')');
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return stringOpSegement;
                        } else {
                            String[] strArr2 = new String[jSONArray.size()];
                            jSONArray.toArray(strArr2);
                            Filter stringInSegement = new StringInSegement(readName, strArr2, z4);
                            while (true) {
                                c2 = this.ch;
                                if (c2 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c2 == '&' || c2 == '|') {
                                stringInSegement = filterRest(stringInSegement);
                            }
                            accept(')');
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return stringInSegement;
                        }
                    } else {
                        char c16 = this.ch;
                        if (c16 == '\'' || c16 == '\"') {
                            String readString = readString();
                            if (readOp == Operator.RLIKE) {
                                filter2 = new RlikeSegement(readName, readString, false);
                            } else if (readOp == Operator.NOT_RLIKE) {
                                filter2 = new RlikeSegement(readName, readString, true);
                            } else if (readOp == Operator.LIKE || readOp == Operator.NOT_LIKE) {
                                while (readString.indexOf("%%") != -1) {
                                    readString = readString.replaceAll("%%", "%");
                                }
                                boolean z8 = readOp == Operator.NOT_LIKE;
                                int indexOf = readString.indexOf(37);
                                if (indexOf == -1) {
                                    if (readOp == Operator.LIKE) {
                                        operator = Operator.EQ;
                                    } else {
                                        operator = Operator.NE;
                                    }
                                    filter2 = new StringOpSegement(readName, readString, operator);
                                } else {
                                    String[] split = readString.split("%");
                                    if (indexOf != 0) {
                                        if (readString.charAt(readString.length() - 1) == '%') {
                                            if (split.length == 1) {
                                                str3 = split[0];
                                            } else {
                                                strArr = split;
                                            }
                                        } else if (split.length == 1) {
                                            str3 = split[0];
                                        } else {
                                            if (split.length == 2) {
                                                str2 = split[0];
                                                str = split[1];
                                                strArr = null;
                                            } else {
                                                String str5 = split[0];
                                                String str6 = split[split.length - 1];
                                                int length = split.length - 2;
                                                String[] strArr3 = new String[length];
                                                System.arraycopy(split, 1, strArr3, 0, length);
                                                str2 = str5;
                                                strArr = strArr3;
                                                str = str6;
                                            }
                                            filter2 = new MatchSegement(readName, str2, str, strArr, z8);
                                        }
                                        str2 = str3;
                                        str = null;
                                        strArr = null;
                                        filter2 = new MatchSegement(readName, str2, str, strArr, z8);
                                    } else if (readString.charAt(readString.length() - 1) == '%') {
                                        int length2 = split.length - 1;
                                        String[] strArr4 = new String[length2];
                                        System.arraycopy(split, 1, strArr4, 0, length2);
                                        strArr = strArr4;
                                    } else {
                                        String str7 = split[split.length - 1];
                                        if (split.length > 2) {
                                            int length3 = split.length - 2;
                                            String[] strArr5 = new String[length3];
                                            System.arraycopy(split, 1, strArr5, 0, length3);
                                            str = str7;
                                            strArr = strArr5;
                                            str2 = null;
                                        } else {
                                            str = str7;
                                            str2 = null;
                                            strArr = null;
                                        }
                                        filter2 = new MatchSegement(readName, str2, str, strArr, z8);
                                    }
                                    str2 = null;
                                    str = null;
                                    filter2 = new MatchSegement(readName, str2, str, strArr, z8);
                                }
                            } else {
                                filter2 = new StringOpSegement(readName, readString, readOp);
                            }
                            while (true) {
                                c7 = this.ch;
                                if (c7 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c7 == '&' || c7 == '|') {
                                filter2 = filterRest(filter2);
                            }
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return filter2;
                        } else if (isDigitFirst(c16)) {
                            long readLongValue = readLongValue();
                            double readDoubleValue = this.ch == '.' ? readDoubleValue(readLongValue) : 0.0d;
                            if (readDoubleValue == 0.0d) {
                                filter6 = new IntOpSegement(readName, readLongValue, readOp);
                            } else {
                                filter6 = new DoubleOpSegement(readName, readDoubleValue, readOp);
                            }
                            while (true) {
                                c11 = this.ch;
                                if (c11 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (i > 1 && c11 == ')') {
                                next();
                            }
                            char c17 = this.ch;
                            if (c17 == '&' || c17 == '|') {
                                filter6 = filterRest(filter6);
                            }
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return filter6;
                        } else {
                            char c18 = this.ch;
                            if (c18 == '$') {
                                RefOpSegement refOpSegement = new RefOpSegement(readName, readSegement(), readOp);
                                this.hasRefSegment = true;
                                while (this.ch == ' ') {
                                    next();
                                }
                                if (z2) {
                                    accept(')');
                                }
                                if (z) {
                                    accept(']');
                                }
                                return refOpSegement;
                            } else if (c18 == '/') {
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    next();
                                    char c19 = this.ch;
                                    if (c19 == '/') {
                                        break;
                                    } else if (c19 == '\\') {
                                        next();
                                        sb.append(this.ch);
                                    } else {
                                        sb.append(c19);
                                    }
                                }
                                next();
                                if (this.ch == 'i') {
                                    next();
                                    i2 = 2;
                                } else {
                                    i2 = 0;
                                }
                                RegMatchSegement regMatchSegement = new RegMatchSegement(readName, Pattern.compile(sb.toString(), i2), readOp);
                                if (z2) {
                                    accept(')');
                                }
                                if (z) {
                                    accept(']');
                                }
                                return regMatchSegement;
                            } else {
                                if (c18 == 'n') {
                                    if ("null".equals(readName())) {
                                        if (readOp == Operator.EQ) {
                                            filter5 = new NullSegement(readName);
                                        } else {
                                            filter5 = readOp == Operator.NE ? new NotNullSegement(readName) : null;
                                        }
                                        if (filter5 != null) {
                                            while (true) {
                                                c10 = this.ch;
                                                if (c10 != ' ') {
                                                    break;
                                                }
                                                next();
                                            }
                                            if (c10 == '&' || c10 == '|') {
                                                filter5 = filterRest(filter5);
                                            }
                                        }
                                        if (z2) {
                                            accept(')');
                                        }
                                        accept(']');
                                        if (filter5 != null) {
                                            return filter5;
                                        }
                                        throw new UnsupportedOperationException();
                                    }
                                } else if (c18 == 't') {
                                    if ("true".equals(readName())) {
                                        if (readOp == Operator.EQ) {
                                            filter4 = new ValueSegment(readName, Boolean.TRUE, true);
                                        } else {
                                            filter4 = readOp == Operator.NE ? new ValueSegment(readName, Boolean.TRUE, false) : null;
                                        }
                                        if (filter4 != null) {
                                            while (true) {
                                                c9 = this.ch;
                                                if (c9 != ' ') {
                                                    break;
                                                }
                                                next();
                                            }
                                            if (c9 == '&' || c9 == '|') {
                                                filter4 = filterRest(filter4);
                                            }
                                        }
                                        if (z2) {
                                            accept(')');
                                        }
                                        accept(']');
                                        if (filter4 != null) {
                                            return filter4;
                                        }
                                        throw new UnsupportedOperationException();
                                    }
                                } else if (c18 == 'f' && "false".equals(readName())) {
                                    if (readOp == Operator.EQ) {
                                        filter3 = new ValueSegment(readName, Boolean.FALSE, true);
                                    } else {
                                        filter3 = readOp == Operator.NE ? new ValueSegment(readName, Boolean.FALSE, false) : null;
                                    }
                                    if (filter3 != null) {
                                        while (true) {
                                            c8 = this.ch;
                                            if (c8 != ' ') {
                                                break;
                                            }
                                            next();
                                        }
                                        if (c8 == '&' || c8 == '|') {
                                            filter3 = filterRest(filter3);
                                        }
                                    }
                                    if (z2) {
                                        accept(')');
                                    }
                                    accept(']');
                                    if (filter3 != null) {
                                        return filter3;
                                    }
                                    throw new UnsupportedOperationException();
                                }
                                throw new UnsupportedOperationException();
                            }
                        }
                    }
                } else {
                    next();
                    Filter notNullSegement2 = new NotNullSegement(readName);
                    while (true) {
                        c12 = this.ch;
                        if (c12 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c12 == '&' || c12 == '|') {
                        notNullSegement2 = filterRest(notNullSegement2);
                    }
                    accept(')');
                    if (z2) {
                        accept(')');
                    }
                    if (z) {
                        accept(']');
                    }
                    return notNullSegement2;
                }
            } else {
                int i7 = this.pos - 1;
                while (true) {
                    char c20 = this.ch;
                    if (c20 == ']' || c20 == '/' || isEOF() || ((c15 = this.ch) == '.' && !z2 && !z2 && c14 != '\'')) {
                        break;
                    }
                    if (c15 == '\\') {
                        next();
                    }
                    next();
                }
                if (z) {
                    i4 = this.pos;
                } else {
                    char c21 = this.ch;
                    if (c21 == '/' || c21 == '.') {
                        i4 = this.pos;
                    } else {
                        i3 = this.pos;
                        substring = this.path.substring(i7, i3);
                        if (substring.indexOf("\\.") == -1) {
                            if (c14 == '\'' && substring.length() > 2 && substring.charAt(substring.length() - 1) == c14) {
                                str4 = substring.substring(1, substring.length() - 1);
                            } else {
                                str4 = substring.replaceAll("\\\\\\.", "\\.");
                                if (str4.indexOf("\\-") != -1) {
                                    str4 = str4.replaceAll("\\\\-", "-");
                                }
                            }
                            if (z2) {
                                accept(')');
                            }
                            return new PropertySegment(str4, false);
                        }
                        Segment buildArraySegement = buildArraySegement(substring);
                        if (z && !isEOF()) {
                            accept(']');
                        }
                        return buildArraySegement;
                    }
                }
                i3 = i4 - 1;
                substring = this.path.substring(i7, i3);
                if (substring.indexOf("\\.") == -1) {
                }
            }
        }

        Filter filterRest(Filter filter) {
            char c = this.ch;
            boolean z = true;
            boolean z2 = c == '&';
            if ((c != '&' || getNextChar() != '&') && (this.ch != '|' || getNextChar() != '|')) {
                return filter;
            }
            next();
            next();
            if (this.ch == '(') {
                next();
            } else {
                z = false;
            }
            while (this.ch == ' ') {
                next();
            }
            FilterGroup filterGroup = new FilterGroup(filter, (Filter) parseArrayAccessFilter(false), z2);
            if (z && this.ch == ')') {
                next();
            }
            return filterGroup;
        }

        protected long readLongValue() {
            int i = this.pos - 1;
            char c = this.ch;
            if (c == '+' || c == '-') {
                next();
            }
            while (true) {
                char c2 = this.ch;
                if (c2 < '0' || c2 > '9') {
                    break;
                }
                next();
            }
            return Long.parseLong(this.path.substring(i, this.pos - 1));
        }

        protected double readDoubleValue(long j) {
            int i = this.pos - 1;
            next();
            while (true) {
                char c = this.ch;
                if (c < '0' || c > '9') {
                    break;
                }
                next();
            }
            return Double.parseDouble(this.path.substring(i, this.pos - 1)) + ((double) j);
        }

        protected Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            char c = this.ch;
            if (c == '\"' || c == '\'') {
                return readString();
            }
            if (c != 'n') {
                throw new UnsupportedOperationException();
            } else if ("null".equals(readName())) {
                return null;
            } else {
                throw new JSONPathException(this.path);
            }
        }

        protected Operator readOp() {
            Operator operator;
            char c = this.ch;
            if (c == '=') {
                next();
                char c2 = this.ch;
                if (c2 == '~') {
                    next();
                    operator = Operator.REG_MATCH;
                } else if (c2 == '=') {
                    next();
                    operator = Operator.EQ;
                } else {
                    operator = Operator.EQ;
                }
            } else if (c == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (c == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String readName = readName();
            if ("not".equalsIgnoreCase(readName)) {
                skipWhitespace();
                String readName2 = readName();
                if ("like".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            } else if ("nin".equalsIgnoreCase(readName)) {
                return Operator.NOT_IN;
            } else {
                if ("like".equalsIgnoreCase(readName)) {
                    return Operator.LIKE;
                }
                if ("rlike".equalsIgnoreCase(readName)) {
                    return Operator.RLIKE;
                }
                if ("in".equalsIgnoreCase(readName)) {
                    return Operator.IN;
                }
                if ("between".equalsIgnoreCase(readName)) {
                    return Operator.BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
        }

        String readName() {
            skipWhitespace();
            char c = this.ch;
            if (c == '\\' || Character.isJavaIdentifierStart(c)) {
                StringBuilder sb = new StringBuilder();
                while (!isEOF()) {
                    char c2 = this.ch;
                    if (c2 == '\\') {
                        next();
                        sb.append(this.ch);
                        if (isEOF()) {
                            return sb.toString();
                        }
                        next();
                    } else if (!Character.isJavaIdentifierPart(c2)) {
                        break;
                    } else {
                        sb.append(this.ch);
                        next();
                    }
                }
                if (isEOF() && Character.isJavaIdentifierPart(this.ch)) {
                    sb.append(this.ch);
                }
                return sb.toString();
            }
            throw new JSONPathException("illeal jsonpath syntax. " + this.path);
        }

        String readString() {
            char c = this.ch;
            next();
            int i = this.pos - 1;
            while (this.ch != c && !isEOF()) {
                next();
            }
            String substring = this.path.substring(i, isEOF() ? this.pos : this.pos - 1);
            accept(c);
            return substring;
        }

        void accept(char c) {
            if (this.ch != c) {
                throw new JSONPathException("expect '" + c + ", but '" + this.ch + "'");
            } else if (!isEOF()) {
                next();
            }
        }

        public Segment[] explain() {
            String str = this.path;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            Segment[] segmentArr = new Segment[8];
            while (true) {
                Segment readSegement = readSegement();
                if (readSegement == null) {
                    break;
                }
                if (readSegement instanceof PropertySegment) {
                    PropertySegment propertySegment = (PropertySegment) readSegement;
                    if (!propertySegment.deep && propertySegment.propertyName.equals("*")) {
                    }
                }
                int i = this.level;
                if (i == segmentArr.length) {
                    Segment[] segmentArr2 = new Segment[((i * 3) / 2)];
                    System.arraycopy(segmentArr, 0, segmentArr2, 0, i);
                    segmentArr = segmentArr2;
                }
                int i2 = this.level;
                this.level = i2 + 1;
                segmentArr[i2] = readSegement;
            }
            int i3 = this.level;
            if (i3 == segmentArr.length) {
                return segmentArr;
            }
            Segment[] segmentArr3 = new Segment[i3];
            System.arraycopy(segmentArr, 0, segmentArr3, 0, i3);
            return segmentArr3;
        }

        Segment buildArraySegement(String str) {
            int length = str.length();
            char charAt = str.charAt(0);
            int i = 1;
            int i2 = length - 1;
            char charAt2 = str.charAt(i2);
            int indexOf = str.indexOf(44);
            int i3 = -1;
            if (str.length() > 2 && charAt == '\'' && charAt2 == '\'') {
                String substring = str.substring(1, i2);
                if (indexOf == -1 || !strArrayPatternx.matcher(str).find()) {
                    return new PropertySegment(substring, false);
                }
                return new MultiPropertySegment(substring.split("'\\s*,\\s*'"));
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf == -1 && indexOf2 == -1) {
                if (TypeUtils.isNumber(str)) {
                    try {
                        return new ArrayAccessSegment(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new PropertySegment(str, false);
                    }
                } else {
                    if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                        str = str.substring(1, str.length() - 1);
                    }
                    return new PropertySegment(str, false);
                }
            } else if (indexOf != -1) {
                String[] split = str.split(",");
                int[] iArr = new int[split.length];
                for (int i4 = 0; i4 < split.length; i4++) {
                    iArr[i4] = Integer.parseInt(split[i4]);
                }
                return new MultiIndexSegment(iArr);
            } else if (indexOf2 != -1) {
                String[] split2 = str.split(":");
                int length2 = split2.length;
                int[] iArr2 = new int[length2];
                for (int i5 = 0; i5 < split2.length; i5++) {
                    String str2 = split2[i5];
                    if (str2.length() != 0) {
                        iArr2[i5] = Integer.parseInt(str2);
                    } else if (i5 == 0) {
                        iArr2[i5] = 0;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
                int i6 = iArr2[0];
                if (length2 > 1) {
                    i3 = iArr2[1];
                }
                if (length2 == 3) {
                    i = iArr2[2];
                }
                if (i3 >= 0 && i3 < i6) {
                    throw new UnsupportedOperationException("end must greater than or equals start. start " + i6 + ",  end " + i3);
                } else if (i > 0) {
                    return new RangeSegment(i6, i3, i);
                } else {
                    throw new UnsupportedOperationException("step must greater than zero : " + i);
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    static class SizeSegment implements Segment {
        public static final SizeSegment instance = new SizeSegment();

        SizeSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static class MaxSegment implements Segment {
        public static final MaxSegment instance = new MaxSegment();

        MaxSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 instanceof Collection) {
                Object obj3 = null;
                for (Object obj4 : (Collection) obj2) {
                    if (obj4 != null && (obj3 == null || JSONPath.compare(obj3, obj4) < 0)) {
                        obj3 = obj4;
                    }
                }
                return obj3;
            }
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static class MinSegment implements Segment {
        public static final MinSegment instance = new MinSegment();

        MinSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 instanceof Collection) {
                Object obj3 = null;
                for (Object obj4 : (Collection) obj2) {
                    if (obj4 != null && (obj3 == null || JSONPath.compare(obj3, obj4) > 0)) {
                        obj3 = obj4;
                    }
                }
                return obj3;
            }
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static int compare(Object obj, Object obj2) {
        Object obj3;
        Object f;
        if (obj.getClass() == obj2.getClass()) {
            return ((Comparable) obj).compareTo(obj2);
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (cls != BigDecimal.class) {
            if (cls == Long.class) {
                if (cls2 == Integer.class) {
                    f = new Long((long) ((Integer) obj2).intValue());
                } else if (cls2 == BigDecimal.class) {
                    obj3 = new BigDecimal(((Long) obj).longValue());
                } else if (cls2 == Float.class) {
                    obj3 = new Float((float) ((Long) obj).longValue());
                } else {
                    if (cls2 == Double.class) {
                        obj3 = new Double((double) ((Long) obj).longValue());
                    }
                    return ((Comparable) obj).compareTo(obj2);
                }
            } else if (cls == Integer.class) {
                if (cls2 == Long.class) {
                    obj3 = new Long((long) ((Integer) obj).intValue());
                } else if (cls2 == BigDecimal.class) {
                    obj3 = new BigDecimal(((Integer) obj).intValue());
                } else if (cls2 == Float.class) {
                    obj3 = new Float((float) ((Integer) obj).intValue());
                } else {
                    if (cls2 == Double.class) {
                        obj3 = new Double((double) ((Integer) obj).intValue());
                    }
                    return ((Comparable) obj).compareTo(obj2);
                }
            } else if (cls != Double.class) {
                if (cls == Float.class) {
                    if (cls2 == Integer.class) {
                        f = new Float((float) ((Integer) obj2).intValue());
                    } else if (cls2 == Long.class) {
                        f = new Float((float) ((Long) obj2).longValue());
                    } else if (cls2 == Double.class) {
                        obj3 = new Double((double) ((Float) obj).floatValue());
                    }
                }
                return ((Comparable) obj).compareTo(obj2);
            } else if (cls2 == Integer.class) {
                f = new Double((double) ((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f = new Double((double) ((Long) obj2).longValue());
            } else {
                if (cls2 == Float.class) {
                    f = new Double((double) ((Float) obj2).floatValue());
                }
                return ((Comparable) obj).compareTo(obj2);
            }
            obj = obj3;
            return ((Comparable) obj).compareTo(obj2);
        } else if (cls2 == Integer.class) {
            f = new BigDecimal(((Integer) obj2).intValue());
        } else if (cls2 == Long.class) {
            f = new BigDecimal(((Long) obj2).longValue());
        } else if (cls2 == Float.class) {
            f = new BigDecimal((double) ((Float) obj2).floatValue());
        } else {
            if (cls2 == Double.class) {
                f = new BigDecimal(((Double) obj2).doubleValue());
            }
            return ((Comparable) obj).compareTo(obj2);
        }
        obj2 = f;
        return ((Comparable) obj).compareTo(obj2);
    }

    static class KeySetSegment implements Segment {
        public static final KeySetSegment instance = new KeySetSegment();

        KeySetSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.evalKeySet(obj2);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static class PropertySegment implements Segment {
        private final boolean deep;
        private final String propertyName;
        private final long propertyNameHash;

        public PropertySegment(String str, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.deep = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepScan(obj2, this.propertyName, arrayList);
            return arrayList;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Object obj;
            Object obj2;
            JSONArray jSONArray;
            Object obj3;
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            if (this.deep && context.object == null) {
                context.object = new JSONArray();
            }
            if (jSONLexerBase.token() != 14) {
                boolean z = this.deep;
                if (z) {
                    while (true) {
                        int seekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNameHash, this.deep);
                        if (seekObjectToField != -1) {
                            if (seekObjectToField == 3) {
                                if (context.eval) {
                                    int i = jSONLexerBase.token();
                                    if (i == 2) {
                                        obj = jSONLexerBase.integerValue();
                                        jSONLexerBase.nextToken(16);
                                    } else if (i == 3) {
                                        obj = jSONLexerBase.decimalValue();
                                        jSONLexerBase.nextToken(16);
                                    } else if (i != 4) {
                                        obj = defaultJSONParser.parse();
                                    } else {
                                        obj = jSONLexerBase.stringVal();
                                        jSONLexerBase.nextToken(16);
                                    }
                                    if (context.eval) {
                                        if (context.object instanceof List) {
                                            List list = (List) context.object;
                                            if (list.size() != 0 || !(obj instanceof List)) {
                                                list.add(obj);
                                            } else {
                                                context.object = obj;
                                            }
                                        } else {
                                            context.object = obj;
                                        }
                                    }
                                }
                            } else if (seekObjectToField == 1 || seekObjectToField == 2) {
                                extract(jSONPath, defaultJSONParser, context);
                            }
                        } else {
                            return;
                        }
                    }
                } else if (jSONLexerBase.seekObjectToField(this.propertyNameHash, z) == 3 && context.eval) {
                    int i2 = jSONLexerBase.token();
                    if (i2 == 2) {
                        obj2 = jSONLexerBase.integerValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i2 == 3) {
                        obj2 = jSONLexerBase.decimalValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i2 != 4) {
                        obj2 = defaultJSONParser.parse();
                    } else {
                        obj2 = jSONLexerBase.stringVal();
                        jSONLexerBase.nextToken(16);
                    }
                    if (context.eval) {
                        context.object = obj2;
                    }
                }
            } else if (!"*".equals(this.propertyName)) {
                jSONLexerBase.nextToken();
                if (this.deep) {
                    jSONArray = (JSONArray) context.object;
                } else {
                    jSONArray = new JSONArray();
                }
                while (true) {
                    int i3 = jSONLexerBase.token();
                    if (i3 == 12) {
                        boolean z2 = this.deep;
                        if (z2) {
                            extract(jSONPath, defaultJSONParser, context);
                        } else {
                            int seekObjectToField2 = jSONLexerBase.seekObjectToField(this.propertyNameHash, z2);
                            if (seekObjectToField2 == 3) {
                                int i4 = jSONLexerBase.token();
                                if (i4 == 2) {
                                    obj3 = jSONLexerBase.integerValue();
                                    jSONLexerBase.nextToken();
                                } else if (i4 != 4) {
                                    obj3 = defaultJSONParser.parse();
                                } else {
                                    obj3 = jSONLexerBase.stringVal();
                                    jSONLexerBase.nextToken();
                                }
                                jSONArray.add(obj3);
                                if (jSONLexerBase.token() == 13) {
                                    jSONLexerBase.nextToken();
                                } else {
                                    jSONLexerBase.skipObject(false);
                                }
                            } else if (seekObjectToField2 == -1) {
                                continue;
                            } else if (!this.deep) {
                                jSONLexerBase.skipObject(false);
                            } else {
                                throw new UnsupportedOperationException(jSONLexerBase.info());
                            }
                        }
                    } else if (i3 != 14) {
                        switch (i3) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                jSONLexerBase.nextToken();
                                break;
                        }
                    } else if (this.deep) {
                        extract(jSONPath, defaultJSONParser, context);
                    } else {
                        jSONLexerBase.skipObject(false);
                    }
                    if (jSONLexerBase.token() == 15) {
                        jSONLexerBase.nextToken();
                        if (!this.deep && jSONArray.size() > 0) {
                            context.object = jSONArray;
                            return;
                        }
                        return;
                    } else if (jSONLexerBase.token() == 16) {
                        jSONLexerBase.nextToken();
                    } else {
                        throw new JSONException("illegal json : " + jSONLexerBase.info());
                    }
                }
            }
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, this.propertyNameHash, obj2);
            } else {
                jSONPath.setPropertyValue(obj, this.propertyName, this.propertyNameHash, obj2);
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName, this.deep);
        }
    }

    static class MultiPropertySegment implements Segment {
        private final String[] propertyNames;
        private final long[] propertyNamesHash;

        public MultiPropertySegment(String[] strArr) {
            this.propertyNames = strArr;
            this.propertyNamesHash = new long[strArr.length];
            int i = 0;
            while (true) {
                long[] jArr = this.propertyNamesHash;
                if (i < jArr.length) {
                    jArr[i] = TypeUtils.fnv1a_64(strArr[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            int i = 0;
            while (true) {
                String[] strArr = this.propertyNames;
                if (i >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getPropertyValue(obj2, strArr[i], this.propertyNamesHash[i]));
                i++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            JSONArray jSONArray;
            Object obj;
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            if (context.object == null) {
                jSONArray = new JSONArray();
                context.object = jSONArray;
            } else {
                jSONArray = (JSONArray) context.object;
            }
            for (int size = jSONArray.size(); size < this.propertyNamesHash.length; size++) {
                jSONArray.add(null);
            }
            do {
                int seekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNamesHash);
                if (jSONLexerBase.matchStat == 3) {
                    int i = jSONLexerBase.token();
                    if (i == 2) {
                        obj = jSONLexerBase.integerValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i == 3) {
                        obj = jSONLexerBase.decimalValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i != 4) {
                        obj = defaultJSONParser.parse();
                    } else {
                        obj = jSONLexerBase.stringVal();
                        jSONLexerBase.nextToken(16);
                    }
                    jSONArray.set(seekObjectToField, obj);
                } else {
                    return;
                }
            } while (jSONLexerBase.token() == 16);
        }
    }

    static class WildCardSegment implements Segment {
        public static final WildCardSegment instance = new WildCardSegment(false);
        public static final WildCardSegment instance_deep = new WildCardSegment(true);
        private boolean deep;

        private WildCardSegment(boolean z) {
            this.deep = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValues(obj2);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepGetPropertyValues(obj2, arrayList);
            return arrayList;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object parse = defaultJSONParser.parse();
                if (this.deep) {
                    ArrayList arrayList = new ArrayList();
                    jSONPath.deepGetPropertyValues(parse, arrayList);
                    context.object = arrayList;
                    return;
                } else if (parse instanceof JSONObject) {
                    Collection<Object> values = ((JSONObject) parse).values();
                    JSONArray jSONArray = new JSONArray(values.size());
                    for (Object obj : values) {
                        jSONArray.add(obj);
                    }
                    context.object = jSONArray;
                    return;
                } else if (parse instanceof JSONArray) {
                    context.object = parse;
                    return;
                }
            }
            throw new JSONException("TODO");
        }
    }

    static class ArrayAccessSegment implements Segment {
        private final int index;

        public ArrayAccessSegment(int i) {
            this.index = i;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (((JSONLexerBase) defaultJSONParser.lexer).seekArrayToItem(this.index) && context.eval) {
                context.object = defaultJSONParser.parse();
            }
        }
    }

    static class MultiIndexSegment implements Segment {
        private final int[] indexes;

        public MultiIndexSegment(int[] iArr) {
            this.indexes = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            JSONArray jSONArray = new JSONArray(this.indexes.length);
            int i = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i >= iArr.length) {
                    return jSONArray;
                }
                jSONArray.add(jSONPath.getArrayItem(obj2, iArr[i]));
                i++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object parse = defaultJSONParser.parse();
                if (parse instanceof List) {
                    int[] iArr = this.indexes;
                    int length = iArr.length;
                    int[] iArr2 = new int[length];
                    boolean z = false;
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                    if (iArr2[0] >= 0) {
                        z = true;
                    }
                    List list = (List) parse;
                    if (z) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            if (Arrays.binarySearch(iArr2, size) < 0) {
                                list.remove(size);
                            }
                        }
                        context.object = list;
                        return;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    static class RangeSegment implements Segment {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegment(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.step = i3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = SizeSegment.instance.eval(jSONPath, obj, obj2).intValue();
            int i = this.start;
            if (i < 0) {
                i += intValue;
            }
            int i2 = this.end;
            if (i2 < 0) {
                i2 += intValue;
            }
            int i3 = ((i2 - i) / this.step) + 1;
            if (i3 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i3);
            while (i <= i2 && i < intValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i));
                i += this.step;
            }
            return arrayList;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    static class NotNullSegement implements Filter {
        private final String propertyName;
        private final long propertyNameHash;

        public NotNullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) != null;
        }
    }

    static class NullSegement implements Filter {
        private final String propertyName;
        private final long propertyNameHash;

        public NullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) == null;
        }
    }

    static class ValueSegment implements Filter {
        private boolean eq = true;
        private final String propertyName;
        private final long propertyNameHash;
        private final Object value;

        public ValueSegment(String str, Object obj, boolean z) {
            if (obj != null) {
                this.propertyName = str;
                this.propertyNameHash = TypeUtils.fnv1a_64(str);
                this.value = obj;
                this.eq = z;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.value.equals(jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash));
            return !this.eq ? !equals : equals;
        }
    }

    static class IntInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final long[] values;

        public IntInSegement(String str, long[] jArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = jArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                for (long j : this.values) {
                    if (j == longExtractValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    static class IntBetweenSegement implements Filter {
        private final long endValue;
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final long startValue;

        public IntBetweenSegement(String str, long j, long j2, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.startValue = j;
            this.endValue = j2;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                if (longExtractValue >= this.startValue && longExtractValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    static class IntObjInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final Long[] values;

        public IntObjInSegement(String str, Long[] lArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = lArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            int i = 0;
            if (propertyValue == null) {
                Long[] lArr = this.values;
                int length = lArr.length;
                while (i < length) {
                    if (lArr[i] == null) {
                        return !this.not;
                    }
                    i++;
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i < length2) {
                    Long l = lArr2[i];
                    if (l != null && l.longValue() == longExtractValue) {
                        return !this.not;
                    }
                    i++;
                }
            }
            return this.not;
        }
    }

    static class StringInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final String[] values;

        public StringInSegement(String str, String[] strArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = strArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            String[] strArr = this.values;
            for (String str : strArr) {
                if (str == propertyValue) {
                    return !this.not;
                }
                if (str != null && str.equals(propertyValue)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    static class IntOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final long value;
        private BigDecimal valueDecimal;
        private Double valueDouble;
        private Float valueFloat;

        public IntOpSegement(String str, long j, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = j;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            if (propertyValue instanceof BigDecimal) {
                if (this.valueDecimal == null) {
                    this.valueDecimal = BigDecimal.valueOf(this.value);
                }
                int compareTo = this.valueDecimal.compareTo((BigDecimal) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (compareTo == 0) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (compareTo != 0) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (compareTo <= 0) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (compareTo < 0) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (compareTo >= 0) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (compareTo > 0) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            } else if (propertyValue instanceof Float) {
                if (this.valueFloat == null) {
                    this.valueFloat = Float.valueOf((float) this.value);
                }
                int compareTo2 = this.valueFloat.compareTo((Float) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (compareTo2 == 0) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (compareTo2 != 0) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (compareTo2 <= 0) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (compareTo2 < 0) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (compareTo2 >= 0) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (compareTo2 > 0) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            } else if (propertyValue instanceof Double) {
                if (this.valueDouble == null) {
                    this.valueDouble = Double.valueOf((double) this.value);
                }
                int compareTo3 = this.valueDouble.compareTo((Double) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (compareTo3 == 0) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (compareTo3 != 0) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (compareTo3 <= 0) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (compareTo3 < 0) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (compareTo3 >= 0) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (compareTo3 > 0) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            } else {
                long longExtractValue = TypeUtils.longExtractValue((Number) propertyValue);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (longExtractValue == this.value) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (longExtractValue != this.value) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (longExtractValue >= this.value) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (longExtractValue > this.value) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (longExtractValue <= this.value) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (longExtractValue < this.value) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        }
    }

    /* renamed from: com.alibaba.fastjson.JSONPath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPath$Operator;

        static {
            int[] iArr = new int[Operator.values().length];
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator = iArr;
            try {
                iArr[Operator.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static class DoubleOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final double value;

        public DoubleOpSegement(String str, double d, Operator operator) {
            this.propertyName = str;
            this.value = d;
            this.op = operator;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            double doubleValue = ((Number) propertyValue).doubleValue();
            switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                case 1:
                    if (doubleValue == this.value) {
                        return true;
                    }
                    return false;
                case 2:
                    if (doubleValue != this.value) {
                        return true;
                    }
                    return false;
                case 3:
                    if (doubleValue >= this.value) {
                        return true;
                    }
                    return false;
                case 4:
                    if (doubleValue > this.value) {
                        return true;
                    }
                    return false;
                case 5:
                    if (doubleValue <= this.value) {
                        return true;
                    }
                    return false;
                case 6:
                    if (doubleValue < this.value) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    static class RefOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final Segment refSgement;

        public RefOpSegement(String str, Segment segment, Operator operator) {
            this.propertyName = str;
            this.refSgement = segment;
            this.op = operator;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            Object eval = this.refSgement.eval(jSONPath, obj, obj);
            if ((eval instanceof Integer) || (eval instanceof Long) || (eval instanceof Short) || (eval instanceof Byte)) {
                long longExtractValue = TypeUtils.longExtractValue((Number) eval);
                if ((propertyValue instanceof Integer) || (propertyValue instanceof Long) || (propertyValue instanceof Short) || (propertyValue instanceof Byte)) {
                    long longExtractValue2 = TypeUtils.longExtractValue((Number) propertyValue);
                    switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            if (longExtractValue2 == longExtractValue) {
                                return true;
                            }
                            return false;
                        case 2:
                            if (longExtractValue2 != longExtractValue) {
                                return true;
                            }
                            return false;
                        case 3:
                            if (longExtractValue2 >= longExtractValue) {
                                return true;
                            }
                            return false;
                        case 4:
                            if (longExtractValue2 > longExtractValue) {
                                return true;
                            }
                            return false;
                        case 5:
                            if (longExtractValue2 <= longExtractValue) {
                                return true;
                            }
                            return false;
                        case 6:
                            if (longExtractValue2 < longExtractValue) {
                                return true;
                            }
                            return false;
                    }
                } else if (propertyValue instanceof BigDecimal) {
                    int compareTo = BigDecimal.valueOf(longExtractValue).compareTo((BigDecimal) propertyValue);
                    switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            if (compareTo == 0) {
                                return true;
                            }
                            return false;
                        case 2:
                            if (compareTo != 0) {
                                return true;
                            }
                            return false;
                        case 3:
                            if (compareTo <= 0) {
                                return true;
                            }
                            return false;
                        case 4:
                            if (compareTo < 0) {
                                return true;
                            }
                            return false;
                        case 5:
                            if (compareTo >= 0) {
                                return true;
                            }
                            return false;
                        case 6:
                            if (compareTo > 0) {
                                return true;
                            }
                            return false;
                        default:
                            return false;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    static class MatchSegement implements Filter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final String startsWithValue;

        public MatchSegement(String str, String str2, String str3, String[] strArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z;
            int length = str2 != null ? str2.length() + 0 : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.minLength = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            String obj4 = propertyValue.toString();
            if (obj4.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                i = 0;
            } else if (!obj4.startsWith(str)) {
                return this.not;
            } else {
                i = this.startsWithValue.length() + 0;
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i);
                    if (indexOf == -1) {
                        return this.not;
                    }
                    i = indexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            if (str3 == null || obj4.endsWith(str3)) {
                return !this.not;
            }
            return this.not;
        }
    }

    static class RlikeSegement implements Filter {
        private final boolean not;
        private final Pattern pattern;
        private final String propertyName;
        private final long propertyNameHash;

        public RlikeSegement(String str, String str2, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.pattern = Pattern.compile(str2);
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            boolean matches = this.pattern.matcher(propertyValue.toString()).matches();
            return this.not ? !matches : matches;
        }
    }

    static class StringOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final String value;

        public StringOpSegement(String str, String str2, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = str2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (this.op == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (this.op == Operator.NE) {
                return !this.value.equals(propertyValue);
            }
            if (propertyValue == null) {
                return false;
            }
            int compareTo = this.value.compareTo(propertyValue.toString());
            if (this.op == Operator.GE) {
                if (compareTo <= 0) {
                    return true;
                }
                return false;
            } else if (this.op == Operator.GT) {
                if (compareTo < 0) {
                    return true;
                }
                return false;
            } else if (this.op == Operator.LE) {
                if (compareTo >= 0) {
                    return true;
                }
                return false;
            } else if (this.op != Operator.LT || compareTo <= 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    static class RegMatchSegement implements Filter {
        private final Operator op;
        private final Pattern pattern;
        private final String propertyName;
        private final long propertyNameHash;

        public RegMatchSegement(String str, Pattern pattern2, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.pattern = pattern2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            return this.pattern.matcher(propertyValue.toString()).matches();
        }
    }

    public static class FilterSegment implements Segment {
        private final Filter filter;

        public FilterSegment(Filter filter2) {
            this.filter = filter2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (obj2 instanceof Iterable) {
                for (Object obj3 : (Iterable) obj2) {
                    if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                        jSONArray.add(obj3);
                    }
                }
                return jSONArray;
            } else if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                return obj2;
            } else {
                return null;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null || !(obj2 instanceof Iterable)) {
                return false;
            }
            Iterator it2 = ((Iterable) obj2).iterator();
            while (it2.hasNext()) {
                if (this.filter.apply(jSONPath, obj, obj2, it2.next())) {
                    it2.remove();
                }
            }
            return true;
        }
    }

    static class FilterGroup implements Filter {
        private boolean and;
        private List<Filter> fitlers;

        public FilterGroup(Filter filter, Filter filter2, boolean z) {
            ArrayList arrayList = new ArrayList(2);
            this.fitlers = arrayList;
            arrayList.add(filter);
            this.fitlers.add(filter2);
            this.and = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            if (this.and) {
                for (Filter filter : this.fitlers) {
                    if (!filter.apply(jSONPath, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            for (Filter filter2 : this.fitlers) {
                if (filter2.apply(jSONPath, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    protected Object getArrayItem(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                if (i < list.size()) {
                    return list.get(i);
                }
                return null;
            } else if (Math.abs(i) <= list.size()) {
                return list.get(list.size() + i);
            } else {
                return null;
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    return Array.get(obj, i);
                }
                return null;
            } else if (Math.abs(i) <= length) {
                return Array.get(obj, length + i);
            } else {
                return null;
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i));
            return obj2 == null ? map.get(Integer.toString(i)) : obj2;
        } else if (obj instanceof Collection) {
            int i2 = 0;
            for (Object obj3 : (Collection) obj) {
                if (i2 == i) {
                    return obj3;
                }
                i2++;
            }
            return null;
        } else if (i == 0) {
            return obj;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                list.set(i, obj2);
            } else {
                list.set(list.size() + i, obj2);
            }
            return true;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    Array.set(obj, i, obj2);
                }
            } else if (Math.abs(i) <= length) {
                Array.set(obj, length + i, obj2);
            }
            return true;
        }
        throw new JSONPathException("unsupported set operation." + cls);
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i < 0) {
                int size = list.size() + i;
                if (size < 0) {
                    return false;
                }
                list.remove(size);
                return true;
            } else if (i >= list.size()) {
                return false;
            } else {
                list.remove(i);
                return true;
            }
        } else {
            Class<?> cls = obj.getClass();
            throw new JSONPathException("unsupported set operation." + cls);
        }
    }

    protected Collection<Object> getPropertyValues(Object obj) {
        if (obj == null) {
            return null;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof Map) {
            return ((Map) obj).values();
        } else {
            if (obj instanceof Collection) {
                return (Collection) obj;
            }
            throw new UnsupportedOperationException();
        }
    }

    protected void deepGetPropertyValues(Object obj, List<Object> list) {
        Collection collection;
        Class<?> cls = obj.getClass();
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
        if (javaBeanSerializer != null) {
            try {
                collection = javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof Map) {
            collection = ((Map) obj).values();
        } else {
            collection = obj instanceof Collection ? (Collection) obj : null;
        }
        if (collection != null) {
            for (Object obj2 : collection) {
                if (obj2 == null || ParserConfig.isPrimitive2(obj2.getClass())) {
                    list.add(obj2);
                } else {
                    deepGetPropertyValues(obj2, list);
                }
            }
            return;
        }
        throw new UnsupportedOperationException(cls.getName());
    }

    static boolean eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (!(obj instanceof Number)) {
            return obj.equals(obj2);
        }
        if (obj2 instanceof Number) {
            return eqNotNull((Number) obj, (Number) obj2);
        }
        return false;
    }

    static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean isInt = isInt(cls);
        Class<?> cls2 = number2.getClass();
        boolean isInt2 = isInt(cls2);
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (isInt2) {
                return bigDecimal.equals(BigDecimal.valueOf(TypeUtils.longExtractValue(number2)));
            }
        }
        if (isInt) {
            if (isInt2) {
                if (number.longValue() == number2.longValue()) {
                    return true;
                }
                return false;
            } else if (number2 instanceof BigInteger) {
                return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
            }
        }
        if (isInt2 && (number instanceof BigInteger)) {
            return ((BigInteger) number).equals(BigInteger.valueOf(TypeUtils.longExtractValue(number2)));
        }
        boolean isDouble = isDouble(cls);
        boolean isDouble2 = isDouble(cls2);
        if (((!isDouble || !isDouble2) && ((!isDouble || !isInt2) && (!isDouble2 || !isInt))) || number.doubleValue() != number2.doubleValue()) {
            return false;
        }
        return true;
    }

    protected static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    protected static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    protected Object getPropertyValue(Object obj, String str, long j) {
        JSONArray jSONArray = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            try {
                obj = JSON.parseObject((String) obj);
            } catch (Exception unused) {
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(str);
            if (obj2 == null) {
                return (5614464919154503228L == j || -1580386065683472715L == j) ? Integer.valueOf(map.size()) : obj2;
            }
            return obj2;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj, str, j, false);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
            }
        } else {
            int i = 0;
            if (obj instanceof List) {
                List list = (List) obj;
                if (5614464919154503228L == j || -1580386065683472715L == j) {
                    return Integer.valueOf(list.size());
                }
                while (i < list.size()) {
                    Object obj3 = list.get(i);
                    if (obj3 == list) {
                        if (jSONArray == null) {
                            jSONArray = new JSONArray(list.size());
                        }
                        jSONArray.add(obj3);
                    } else {
                        Object propertyValue = getPropertyValue(obj3, str, j);
                        if (propertyValue instanceof Collection) {
                            Collection collection = (Collection) propertyValue;
                            if (jSONArray == null) {
                                jSONArray = new JSONArray(list.size());
                            }
                            jSONArray.addAll(collection);
                        } else if (propertyValue != null) {
                            if (jSONArray == null) {
                                jSONArray = new JSONArray(list.size());
                            }
                            jSONArray.add(propertyValue);
                        }
                    }
                    i++;
                }
                if (jSONArray == null) {
                    return Collections.emptyList();
                }
                return jSONArray;
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (5614464919154503228L == j || -1580386065683472715L == j) {
                    return Integer.valueOf(objArr.length);
                }
                JSONArray jSONArray2 = new JSONArray(objArr.length);
                while (i < objArr.length) {
                    Object obj4 = objArr[i];
                    if (obj4 == objArr) {
                        jSONArray2.add(obj4);
                    } else {
                        Object propertyValue2 = getPropertyValue(obj4, str, j);
                        if (propertyValue2 instanceof Collection) {
                            jSONArray2.addAll((Collection) propertyValue2);
                        } else if (propertyValue2 != null) {
                            jSONArray2.add(propertyValue2);
                        }
                    }
                    i++;
                }
                return jSONArray2;
            } else {
                if (obj instanceof Enum) {
                    Enum r8 = (Enum) obj;
                    if (-4270347329889690746L == j) {
                        return r8.name();
                    }
                    if (-1014497654951707614L == j) {
                        return Integer.valueOf(r8.ordinal());
                    }
                }
                if (obj instanceof Calendar) {
                    Calendar calendar = (Calendar) obj;
                    if (8963398325558730460L == j) {
                        return Integer.valueOf(calendar.get(1));
                    }
                    if (-811277319855450459L == j) {
                        return Integer.valueOf(calendar.get(2));
                    }
                    if (-3851359326990528739L == j) {
                        return Integer.valueOf(calendar.get(5));
                    }
                    if (4647432019745535567L == j) {
                        return Integer.valueOf(calendar.get(11));
                    }
                    if (6607618197526598121L == j) {
                        return Integer.valueOf(calendar.get(12));
                    }
                    if (-6586085717218287427L == j) {
                        return Integer.valueOf(calendar.get(13));
                    }
                }
                return null;
            }
        }
    }

    protected void deepScan(Object obj, String str, List<Object> list) {
        if (obj != null) {
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object value = entry.getValue();
                    if (str.equals(entry.getKey())) {
                        if (value instanceof Collection) {
                            list.addAll((Collection) value);
                        } else {
                            list.add(value);
                        }
                    } else if (value != null && !ParserConfig.isPrimitive2(value.getClass())) {
                        deepScan(value, str, list);
                    }
                }
            } else if (obj instanceof Collection) {
                for (Object obj2 : (Collection) obj) {
                    if (!ParserConfig.isPrimitive2(obj2.getClass())) {
                        deepScan(obj2, str, list);
                    }
                }
            } else {
                JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
                if (javaBeanSerializer != null) {
                    try {
                        FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
                        if (fieldSerializer != null) {
                            try {
                                list.add(fieldSerializer.getPropertyValueDirect(obj));
                            } catch (InvocationTargetException e) {
                                throw new JSONException("getFieldValue error." + str, e);
                            } catch (IllegalAccessException e2) {
                                throw new JSONException("getFieldValue error." + str, e2);
                            }
                        } else {
                            for (Object obj3 : javaBeanSerializer.getFieldValues(obj)) {
                                deepScan(obj3, str, list);
                            }
                        }
                    } catch (Exception e3) {
                        throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e3);
                    }
                } else if (obj instanceof List) {
                    List list2 = (List) obj;
                    for (int i = 0; i < list2.size(); i++) {
                        deepScan(list2.get(i), str, list);
                    }
                }
            }
        }
    }

    protected void deepSet(Object obj, String str, long j, Object obj2) {
        if (obj != null) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(str)) {
                    map.get(str);
                    map.put(str, obj2);
                    return;
                }
                for (Object obj3 : map.values()) {
                    deepSet(obj3, str, j, obj2);
                }
                return;
            }
            Class<?> cls = obj.getClass();
            JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
            if (javaBeanDeserializer != null) {
                try {
                    FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                    if (fieldDeserializer != null) {
                        fieldDeserializer.setValue(obj, obj2);
                        return;
                    }
                    for (Object obj4 : getJavaBeanSerializer(cls).getObjectFieldValues(obj)) {
                        deepSet(obj4, str, j, obj2);
                    }
                } catch (Exception e) {
                    throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                for (int i = 0; i < list.size(); i++) {
                    deepSet(list.get(i), str, j, obj2);
                }
            }
        }
    }

    protected boolean setPropertyValue(Object obj, String str, long j, Object obj2) {
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        } else if (obj instanceof List) {
            for (Object obj3 : (List) obj) {
                if (obj3 != null) {
                    setPropertyValue(obj3, str, j, obj2);
                }
            }
            return true;
        } else {
            ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
            JavaBeanDeserializer javaBeanDeserializer = null;
            if (deserializer instanceof JavaBeanDeserializer) {
                javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
            }
            if (javaBeanDeserializer != null) {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(j);
                if (fieldDeserializer == null) {
                    return false;
                }
                fieldDeserializer.setValue(obj, obj2);
                return true;
            }
            throw new UnsupportedOperationException();
        }
    }

    protected boolean removePropertyValue(Object obj, String str, boolean z) {
        boolean z2 = true;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.remove(str) == null) {
                z2 = false;
            }
            if (z) {
                for (Object obj2 : map.values()) {
                    removePropertyValue(obj2, str, z);
                }
            }
            return z2;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer != null) {
            FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
            if (fieldDeserializer != null) {
                fieldDeserializer.setValue(obj, (String) null);
            } else {
                z2 = false;
            }
            if (z) {
                for (Object obj3 : getPropertyValues(obj)) {
                    if (obj3 != null) {
                        removePropertyValue(obj3, str, z);
                    }
                }
            }
            return z2;
        } else if (z) {
            return false;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    protected JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        return null;
    }

    protected JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(cls);
        if (deserializer instanceof JavaBeanDeserializer) {
            return (JavaBeanDeserializer) deserializer;
        }
        return null;
    }

    int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            int i = 0;
            for (Object obj2 : ((Map) obj).values()) {
                if (obj2 != null) {
                    i++;
                }
            }
            return i;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            return javaBeanSerializer.getSize(obj);
        } catch (Exception e) {
            throw new JSONPathException("evalSize error : " + this.path, e);
        }
    }

    Set<?> evalKeySet(Object obj) {
        JavaBeanSerializer javaBeanSerializer;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).keySet();
        }
        if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (javaBeanSerializer = getJavaBeanSerializer(obj.getClass())) == null) {
            return null;
        }
        try {
            return javaBeanSerializer.getFieldNames(obj);
        } catch (Exception e) {
            throw new JSONPathException("evalKeySet error : " + this.path, e);
        }
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }

    public static Object reserveToArray(Object obj, String... strArr) {
        JSONArray jSONArray = new JSONArray();
        if (!(strArr == null || strArr.length == 0)) {
            for (String str : strArr) {
                JSONPath compile = compile(str);
                compile.init();
                jSONArray.add(compile.eval(obj));
            }
        }
        return jSONArray;
    }

    public static Object reserveToObject(Object obj, String... strArr) {
        Object eval;
        if (strArr == null || strArr.length == 0) {
            return obj;
        }
        JSONObject jSONObject = new JSONObject(true);
        for (String str : strArr) {
            JSONPath compile = compile(str);
            compile.init();
            Segment[] segmentArr = compile.segments;
            if ((segmentArr[segmentArr.length - 1] instanceof PropertySegment) && (eval = compile.eval(obj)) != null) {
                compile.set(jSONObject, eval);
            }
        }
        return jSONObject;
    }
}
