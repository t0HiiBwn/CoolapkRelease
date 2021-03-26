package retrofit2.converter.scalars;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

final class ScalarRequestBodyConverter<T> implements Converter<T, RequestBody> {
    static final ScalarRequestBodyConverter<Object> INSTANCE = new ScalarRequestBodyConverter<>();
    private static final MediaType MEDIA_TYPE = MediaType.get("text/plain; charset=UTF-8");

    private ScalarRequestBodyConverter() {
    }

    @Override // retrofit2.Converter
    public RequestBody convert(T t) throws IOException {
        return RequestBody.create(MEDIA_TYPE, String.valueOf(t));
    }
}
