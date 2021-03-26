package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class GsonConverterFactory extends Converter.Factory {
    private final Gson gson;

    public static GsonConverterFactory create() {
        return create(new Gson());
    }

    public static GsonConverterFactory create(Gson gson2) {
        Objects.requireNonNull(gson2, "gson == null");
        return new GsonConverterFactory(gson2);
    }

    private GsonConverterFactory(Gson gson2) {
        this.gson = gson2;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.getAdapter(TypeToken.get(type)));
    }
}
