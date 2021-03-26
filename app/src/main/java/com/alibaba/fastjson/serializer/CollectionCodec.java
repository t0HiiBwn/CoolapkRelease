package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = new CollectionCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Type type2 = null;
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) || SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
            type2 = TypeUtils.getCollectionItemType(type);
        }
        Collection collection = (Collection) obj;
        SerialContext serialContext = jSONSerializer.context;
        int i2 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            if (HashSet.class == collection.getClass()) {
                serializeWriter.append((CharSequence) "Set");
            } else if (TreeSet.class == collection.getClass()) {
                serializeWriter.append((CharSequence) "TreeSet");
            }
        }
        try {
            serializeWriter.append('[');
            for (Object obj3 : collection) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    serializeWriter.append(',');
                }
                if (obj3 == null) {
                    serializeWriter.writeNull();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        serializeWriter.writeLong(((Long) obj3).longValue());
                        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                            serializeWriter.write(76);
                        }
                    } else {
                        ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(cls);
                        if (!SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName) || !(objectWriter instanceof JavaBeanSerializer)) {
                            objectWriter.write(jSONSerializer, obj3, Integer.valueOf(i3 - 1), type2, i);
                        } else {
                            ((JavaBeanSerializer) objectWriter).writeNoneASM(jSONSerializer, obj3, Integer.valueOf(i3 - 1), type2, i);
                        }
                    }
                }
                i2 = i3;
            }
            serializeWriter.append(']');
        } finally {
            jSONSerializer.context = serialContext;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        } else if (type == JSONArray.class) {
            T t = (T) new JSONArray();
            defaultJSONParser.parseArray((Collection) t);
            return t;
        } else {
            T t2 = (T) TypeUtils.createCollection(type);
            defaultJSONParser.parseArray(TypeUtils.getCollectionItemType(type), t2, obj);
            return t2;
        }
    }
}
