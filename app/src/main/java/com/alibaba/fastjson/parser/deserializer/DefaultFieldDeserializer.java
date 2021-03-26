package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class DefaultFieldDeserializer extends FieldDeserializer {
    protected boolean customDeserilizer = false;
    protected ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        boolean z = false;
        JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            Class<?> deserializeUsing = annotation.deserializeUsing();
            if (!(deserializeUsing == null || deserializeUsing == Void.class)) {
                z = true;
            }
            this.customDeserilizer = z;
        }
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation == null || annotation.deserializeUsing() == Void.class) {
                this.fieldValueDeserilizer = parserConfig.getDeserializer(this.fieldInfo.fieldClass, this.fieldInfo.fieldType);
            } else {
                try {
                    this.fieldValueDeserilizer = (ObjectDeserializer) annotation.deserializeUsing().newInstance();
                } catch (Exception e) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e);
                }
            }
        }
        return this.fieldValueDeserilizer;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        byte[] bArr;
        if (this.fieldValueDeserilizer == null) {
            getFieldValueDeserilizer(defaultJSONParser.getConfig());
        }
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        Type type2 = this.fieldInfo.fieldType;
        if (type instanceof ParameterizedType) {
            ParseContext context = defaultJSONParser.getContext();
            if (context != null) {
                context.type = type;
            }
            if (type2 != type) {
                type2 = FieldInfo.getFieldType(this.clazz, type, type2);
                objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
            }
        }
        if ((objectDeserializer instanceof JavaBeanDeserializer) && this.fieldInfo.parserFeatures != 0) {
            bArr = ((JavaBeanDeserializer) objectDeserializer).deserialze(defaultJSONParser, type2, this.fieldInfo.name, this.fieldInfo.parserFeatures);
        } else if (this.fieldInfo.format == null || !(objectDeserializer instanceof ContextObjectDeserializer)) {
            bArr = objectDeserializer.deserialze(defaultJSONParser, type2, this.fieldInfo.name);
        } else {
            bArr = ((ContextObjectDeserializer) objectDeserializer).deserialze(defaultJSONParser, type2, this.fieldInfo.name, this.fieldInfo.format, this.fieldInfo.parserFeatures);
        }
        if ((bArr instanceof byte[]) && ("gzip".equals(this.fieldInfo.format) || "gzip,base64".equals(this.fieldInfo.format))) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream((byte[]) bArr));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    byte[] bArr2 = new byte[1024];
                    int read = gZIPInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    } else if (read > 0) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                }
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new JSONException("unzip bytes error.", e);
            }
        }
        if (defaultJSONParser.getResolveStatus() == 1) {
            DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser.getLastResolveTask();
            lastResolveTask.fieldDeserializer = this;
            lastResolveTask.ownerContext = defaultJSONParser.getContext();
            defaultJSONParser.setResolveStatus(0);
        } else if (obj == null) {
            map.put(this.fieldInfo.name, bArr);
        } else {
            setValue(obj, bArr);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        if (objectDeserializer != null) {
            return objectDeserializer.getFastMatchToken();
        }
        return 2;
    }

    public void parseFieldUnwrapped(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        throw new JSONException("TODO");
    }
}
