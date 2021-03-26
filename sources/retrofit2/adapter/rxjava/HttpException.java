package retrofit2.adapter.rxjava;

import retrofit2.Response;

@Deprecated
public final class HttpException extends retrofit2.HttpException {
    public HttpException(Response<?> response) {
        super(response);
    }
}
