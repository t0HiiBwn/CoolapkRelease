package retrofit2.converter.scalars;

import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class ScalarResponseBodyConverters {
    private ScalarResponseBodyConverters() {
    }

    static final class StringResponseBodyConverter implements Converter<ResponseBody, String> {
        static final StringResponseBodyConverter INSTANCE = new StringResponseBodyConverter();

        StringResponseBodyConverter() {
        }

        public String convert(ResponseBody responseBody) throws IOException {
            return responseBody.string();
        }
    }

    static final class BooleanResponseBodyConverter implements Converter<ResponseBody, Boolean> {
        static final BooleanResponseBodyConverter INSTANCE = new BooleanResponseBodyConverter();

        BooleanResponseBodyConverter() {
        }

        public Boolean convert(ResponseBody responseBody) throws IOException {
            return Boolean.valueOf(responseBody.string());
        }
    }

    static final class ByteResponseBodyConverter implements Converter<ResponseBody, Byte> {
        static final ByteResponseBodyConverter INSTANCE = new ByteResponseBodyConverter();

        ByteResponseBodyConverter() {
        }

        public Byte convert(ResponseBody responseBody) throws IOException {
            return Byte.valueOf(responseBody.string());
        }
    }

    static final class CharacterResponseBodyConverter implements Converter<ResponseBody, Character> {
        static final CharacterResponseBodyConverter INSTANCE = new CharacterResponseBodyConverter();

        CharacterResponseBodyConverter() {
        }

        public Character convert(ResponseBody responseBody) throws IOException {
            String string = responseBody.string();
            if (string.length() == 1) {
                return Character.valueOf(string.charAt(0));
            }
            throw new IOException("Expected body of length 1 for Character conversion but was " + string.length());
        }
    }

    static final class DoubleResponseBodyConverter implements Converter<ResponseBody, Double> {
        static final DoubleResponseBodyConverter INSTANCE = new DoubleResponseBodyConverter();

        DoubleResponseBodyConverter() {
        }

        public Double convert(ResponseBody responseBody) throws IOException {
            return Double.valueOf(responseBody.string());
        }
    }

    static final class FloatResponseBodyConverter implements Converter<ResponseBody, Float> {
        static final FloatResponseBodyConverter INSTANCE = new FloatResponseBodyConverter();

        FloatResponseBodyConverter() {
        }

        public Float convert(ResponseBody responseBody) throws IOException {
            return Float.valueOf(responseBody.string());
        }
    }

    static final class IntegerResponseBodyConverter implements Converter<ResponseBody, Integer> {
        static final IntegerResponseBodyConverter INSTANCE = new IntegerResponseBodyConverter();

        IntegerResponseBodyConverter() {
        }

        public Integer convert(ResponseBody responseBody) throws IOException {
            return Integer.valueOf(responseBody.string());
        }
    }

    static final class LongResponseBodyConverter implements Converter<ResponseBody, Long> {
        static final LongResponseBodyConverter INSTANCE = new LongResponseBodyConverter();

        LongResponseBodyConverter() {
        }

        public Long convert(ResponseBody responseBody) throws IOException {
            return Long.valueOf(responseBody.string());
        }
    }

    static final class ShortResponseBodyConverter implements Converter<ResponseBody, Short> {
        static final ShortResponseBodyConverter INSTANCE = new ShortResponseBodyConverter();

        ShortResponseBodyConverter() {
        }

        public Short convert(ResponseBody responseBody) throws IOException {
            return Short.valueOf(responseBody.string());
        }
    }
}
