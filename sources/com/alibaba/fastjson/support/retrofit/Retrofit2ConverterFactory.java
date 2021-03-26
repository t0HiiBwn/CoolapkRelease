package com.alibaba.fastjson.support.retrofit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class Retrofit2ConverterFactory extends Converter.Factory {
    @Deprecated
    private static final Feature[] EMPTY_SERIALIZER_FEATURES = new Feature[0];
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private FastJsonConfig fastJsonConfig;
    @Deprecated
    private int featureValues;
    @Deprecated
    private Feature[] features;
    @Deprecated
    private ParserConfig parserConfig;
    @Deprecated
    private SerializeConfig serializeConfig;
    @Deprecated
    private SerializerFeature[] serializerFeatures;

    @Deprecated
    public Retrofit2ConverterFactory setParserFeatureValues(int i) {
        return this;
    }

    public Retrofit2ConverterFactory() {
        this.parserConfig = ParserConfig.getGlobalInstance();
        this.featureValues = JSON.DEFAULT_PARSER_FEATURE;
        this.fastJsonConfig = new FastJsonConfig();
    }

    public Retrofit2ConverterFactory(FastJsonConfig fastJsonConfig2) {
        this.parserConfig = ParserConfig.getGlobalInstance();
        this.featureValues = JSON.DEFAULT_PARSER_FEATURE;
        this.fastJsonConfig = fastJsonConfig2;
    }

    public static Retrofit2ConverterFactory create() {
        return create(new FastJsonConfig());
    }

    public static Retrofit2ConverterFactory create(FastJsonConfig fastJsonConfig2) {
        Objects.requireNonNull(fastJsonConfig2, "fastJsonConfig == null");
        return new Retrofit2ConverterFactory(fastJsonConfig2);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, Object> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new ResponseBodyConverter(type);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<Object, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new RequestBodyConverter();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public Retrofit2ConverterFactory setFastJsonConfig(FastJsonConfig fastJsonConfig2) {
        this.fastJsonConfig = fastJsonConfig2;
        return this;
    }

    @Deprecated
    public ParserConfig getParserConfig() {
        return this.fastJsonConfig.getParserConfig();
    }

    @Deprecated
    public Retrofit2ConverterFactory setParserConfig(ParserConfig parserConfig2) {
        this.fastJsonConfig.setParserConfig(parserConfig2);
        return this;
    }

    @Deprecated
    public int getParserFeatureValues() {
        return JSON.DEFAULT_PARSER_FEATURE;
    }

    @Deprecated
    public Feature[] getParserFeatures() {
        return this.fastJsonConfig.getFeatures();
    }

    @Deprecated
    public Retrofit2ConverterFactory setParserFeatures(Feature[] featureArr) {
        this.fastJsonConfig.setFeatures(featureArr);
        return this;
    }

    @Deprecated
    public SerializeConfig getSerializeConfig() {
        return this.fastJsonConfig.getSerializeConfig();
    }

    @Deprecated
    public Retrofit2ConverterFactory setSerializeConfig(SerializeConfig serializeConfig2) {
        this.fastJsonConfig.setSerializeConfig(serializeConfig2);
        return this;
    }

    @Deprecated
    public SerializerFeature[] getSerializerFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public Retrofit2ConverterFactory setSerializerFeatures(SerializerFeature[] serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
        return this;
    }

    final class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        private Type type;

        ResponseBodyConverter(Type type2) {
            this.type = type2;
        }

        public T convert(ResponseBody responseBody) throws IOException {
            try {
                T t = (T) JSON.parseObject(responseBody.bytes(), Retrofit2ConverterFactory.this.fastJsonConfig.getCharset(), this.type, Retrofit2ConverterFactory.this.fastJsonConfig.getParserConfig(), Retrofit2ConverterFactory.this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, Retrofit2ConverterFactory.this.fastJsonConfig.getFeatures());
                responseBody.close();
                return t;
            } catch (Exception e) {
                throw new IOException("JSON parse error: " + e.getMessage(), e);
            } catch (Throwable th) {
                responseBody.close();
                throw th;
            }
        }
    }

    final class RequestBodyConverter<T> implements Converter<T, RequestBody> {
        RequestBodyConverter() {
        }

        @Override // retrofit2.Converter
        public RequestBody convert(T t) throws IOException {
            try {
                return RequestBody.create(Retrofit2ConverterFactory.MEDIA_TYPE, JSON.toJSONBytes(Retrofit2ConverterFactory.this.fastJsonConfig.getCharset(), t, Retrofit2ConverterFactory.this.fastJsonConfig.getSerializeConfig(), Retrofit2ConverterFactory.this.fastJsonConfig.getSerializeFilters(), Retrofit2ConverterFactory.this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, Retrofit2ConverterFactory.this.fastJsonConfig.getSerializerFeatures()));
            } catch (Exception e) {
                throw new IOException("Could not write JSON: " + e.getMessage(), e);
            }
        }
    }
}
