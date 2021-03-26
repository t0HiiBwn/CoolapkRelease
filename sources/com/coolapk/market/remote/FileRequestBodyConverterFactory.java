package com.coolapk.market.remote;

import com.coolapk.market.util.CoolFileUtils;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class FileRequestBodyConverterFactory extends Converter.Factory {
    public static FileRequestBodyConverterFactory create() {
        return new FileRequestBodyConverterFactory();
    }

    @Override // retrofit2.Converter.Factory
    public Converter<File, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new FileRequestBodyConverter();
    }

    public static class FileRequestBodyConverter implements Converter<File, RequestBody> {
        public RequestBody convert(File file) throws IOException {
            return RequestBody.create(CoolFileUtils.mediaType(file.getAbsolutePath()), file);
        }
    }
}
