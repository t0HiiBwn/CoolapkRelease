package mtopsdk.mtop.common;

import android.os.Handler;
import com.taobao.tao.remotebusiness.b.e;
import mtopsdk.a.b.a;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.network.Call;

public class ApiID implements IMTOPDataObject {
    private static final String TAG = "mtopsdk.ApiID";
    private volatile Call call;
    private volatile boolean isCancelled = false;
    private e mtopContext$3c737c5b;

    public ApiID(Call call2, e eVar) {
        this.call = call2;
        this.mtopContext$3c737c5b = eVar;
    }

    public e getMtopContext$6e9e401a() {
        return this.mtopContext$3c737c5b;
    }

    public Call getCall() {
        return this.call;
    }

    public void setCall(Call call2) {
        this.call = call2;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public boolean cancelApiCall() {
        if (this.call != null) {
            this.call.cancel();
            this.isCancelled = true;
        }
        return true;
    }

    public ApiID retryApiCall(Handler handler) {
        e eVar = this.mtopContext$3c737c5b;
        if (eVar == null) {
            return null;
        }
        eVar.d.handler = handler;
        a aVar = this.mtopContext$3c737c5b.a.getMtopConfig().filterManager;
        if (aVar != null) {
            aVar.a(null, this.mtopContext$3c737c5b);
        }
        mtopsdk.a.c.a.a(aVar, this.mtopContext$3c737c5b);
        return new ApiID(null, this.mtopContext$3c737c5b);
    }

    public ApiID retryApiCall() {
        return retryApiCall(null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("ApiID [call=");
        sb.append(this.call);
        sb.append(", mtopContext=");
        sb.append(this.mtopContext$3c737c5b);
        sb.append("]");
        return sb.toString();
    }
}
