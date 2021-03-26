package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;

public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {
    public static final MediaType APPLICATION_JAVASCRIPT = new MediaType("application", "javascript");
    @Deprecated
    protected String dateFormat;
    private FastJsonConfig fastJsonConfig = new FastJsonConfig();
    @Deprecated
    protected SerializerFeature[] features = new SerializerFeature[0];
    @Deprecated
    protected SerializeFilter[] filters = new SerializeFilter[0];

    protected boolean supports(Class<?> cls) {
        return true;
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig2) {
        this.fastJsonConfig = fastJsonConfig2;
    }

    public FastJsonHttpMessageConverter() {
        super(MediaType.ALL);
    }

    @Deprecated
    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @Deprecated
    public void setCharset(Charset charset) {
        this.fastJsonConfig.setCharset(charset);
    }

    @Deprecated
    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    @Deprecated
    public void addSerializeFilter(SerializeFilter serializeFilter) {
        if (serializeFilter != null) {
            int length = this.fastJsonConfig.getSerializeFilters().length;
            int i = length + 1;
            SerializeFilter[] serializeFilterArr = new SerializeFilter[i];
            System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, serializeFilterArr, 0, length);
            serializeFilterArr[i - 1] = serializeFilter;
            this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
        }
    }

    public boolean canRead(Type type, Class<?> cls, MediaType mediaType) {
        return FastJsonHttpMessageConverter.super.canRead(cls, mediaType);
    }

    public boolean canWrite(Type type, Class<?> cls, MediaType mediaType) {
        return FastJsonHttpMessageConverter.super.canWrite(cls, mediaType);
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(type, cls), httpInputMessage);
    }

    public void write(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        FastJsonHttpMessageConverter.super.write(obj, mediaType, httpOutputMessage);
    }

    protected Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(cls, null), httpInputMessage);
    }

    private Object readType(Type type, HttpInputMessage httpInputMessage) {
        try {
            return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        } catch (JSONException e) {
            throw new HttpMessageNotReadableException("JSON parse error: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new HttpMessageNotReadableException("I/O error while reading input message", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0049, code lost:
        if ((r12 instanceof com.alibaba.fastjson.JSONPObject) != false) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0082 A[Catch:{ JSONException -> 0x00a0, all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008f A[Catch:{ JSONException -> 0x00a0, all -> 0x009e }] */
    protected void writeInternal(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        boolean z;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HttpHeaders headers = httpOutputMessage.getHeaders();
            ArrayList arrayList = new ArrayList(Arrays.asList(this.fastJsonConfig.getSerializeFilters()));
            Object strangeCodeForJackson = strangeCodeForJackson(obj);
            if (strangeCodeForJackson instanceof FastJsonContainer) {
                FastJsonContainer fastJsonContainer = (FastJsonContainer) strangeCodeForJackson;
                arrayList.addAll(fastJsonContainer.getFilters().getFilters());
                strangeCodeForJackson = fastJsonContainer.getValue();
            }
            if (strangeCodeForJackson instanceof MappingFastJsonValue) {
                if (!StringUtils.isEmpty(((MappingFastJsonValue) strangeCodeForJackson).getJsonpFunction())) {
                }
                z = false;
                int writeJSONString = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), strangeCodeForJackson, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) arrayList.toArray(new SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
                if (z) {
                    headers.setContentType(APPLICATION_JAVASCRIPT);
                }
                if (this.fastJsonConfig.isWriteContentLength()) {
                    headers.setContentLength((long) writeJSONString);
                }
                byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
                byteArrayOutputStream.close();
            }
            z = true;
            int writeJSONString = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), strangeCodeForJackson, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) arrayList.toArray(new SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
            if (z) {
            }
            if (this.fastJsonConfig.isWriteContentLength()) {
            }
            byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
            byteArrayOutputStream.close();
        } catch (JSONException e) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + e.getMessage(), e);
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }

    private Object strangeCodeForJackson(Object obj) {
        return (obj == null || !"com.fasterxml.jackson.databind.node.ObjectNode".equals(obj.getClass().getName())) ? obj : obj.toString();
    }

    protected Type getType(Type type, Class<?> cls) {
        return Spring4TypeResolvableHelper.isSupport() ? Spring4TypeResolvableHelper.getType(type, cls) : type;
    }

    private static class Spring4TypeResolvableHelper {
        private static boolean hasClazzResolvableType;

        private Spring4TypeResolvableHelper() {
        }

        static {
            try {
                Class.forName("org.springframework.core.ResolvableType");
                hasClazzResolvableType = true;
            } catch (ClassNotFoundException unused) {
                hasClazzResolvableType = false;
            }
        }

        /* access modifiers changed from: private */
        public static boolean isSupport() {
            return hasClazzResolvableType;
        }

        /* access modifiers changed from: private */
        public static Type getType(Type type, Class<?> cls) {
            if (cls == null) {
                return type;
            }
            ResolvableType forType = ResolvableType.forType(type);
            if (type instanceof TypeVariable) {
                ResolvableType resolveVariable = resolveVariable((TypeVariable) type, ResolvableType.forClass(cls));
                if (resolveVariable != ResolvableType.NONE) {
                    return resolveVariable.resolve();
                }
                return type;
            } else if (!(type instanceof ParameterizedType) || !forType.hasUnresolvableGenerics()) {
                return type;
            } else {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class[] clsArr = new Class[parameterizedType.getActualTypeArguments().length];
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    Type type2 = actualTypeArguments[i];
                    if (type2 instanceof TypeVariable) {
                        ResolvableType resolveVariable2 = resolveVariable((TypeVariable) type2, ResolvableType.forClass(cls));
                        if (resolveVariable2 != ResolvableType.NONE) {
                            clsArr[i] = resolveVariable2.resolve();
                        } else {
                            clsArr[i] = ResolvableType.forType(type2).resolve();
                        }
                    } else {
                        clsArr[i] = ResolvableType.forType(type2).resolve();
                    }
                }
                return ResolvableType.forClassWithGenerics(forType.getRawClass(), clsArr).getType();
            }
        }

        private static ResolvableType resolveVariable(TypeVariable<?> typeVariable, ResolvableType resolvableType) {
            if (resolvableType.hasGenerics()) {
                ResolvableType forType = ResolvableType.forType(typeVariable, resolvableType);
                if (forType.resolve() != null) {
                    return forType;
                }
            }
            ResolvableType superType = resolvableType.getSuperType();
            if (superType != ResolvableType.NONE) {
                ResolvableType resolveVariable = resolveVariable(typeVariable, superType);
                if (resolveVariable.resolve() != null) {
                    return resolveVariable;
                }
            }
            for (ResolvableType resolvableType2 : resolvableType.getInterfaces()) {
                ResolvableType resolveVariable2 = resolveVariable(typeVariable, resolvableType2);
                if (resolveVariable2.resolve() != null) {
                    return resolveVariable2;
                }
            }
            return ResolvableType.NONE;
        }
    }
}
