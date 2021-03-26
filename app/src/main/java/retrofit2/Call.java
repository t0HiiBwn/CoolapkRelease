package retrofit2;

import java.io.IOException;
import okhttp3.Request;
import okio.Timeout;

public interface Call<T> extends Cloneable {
    void cancel();

    @Override // java.lang.Object
    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}
