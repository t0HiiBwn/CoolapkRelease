package mtopsdk.mtop.util;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private boolean a;
    private T b;
    private String c;
    private String d;
    private String e;
    private int f;

    public Result(T t) {
        this.a = true;
        this.b = t;
    }

    public Result() {
        this.a = true;
    }

    public Result(boolean z, String str, String str2) {
        this(z, null, str, str2);
    }

    public Result(boolean z, String str, String str2, String str3) {
        this.a = true;
        this.a = z;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public T getModel() {
        return this.b;
    }

    public void setModel(T t) {
        this.b = t;
    }

    public String getErrCode() {
        return this.d;
    }

    public void setErrCode(String str) {
        this.d = str;
    }

    public String getErrInfo() {
        return this.e;
    }

    public void setErrInfo(String str) {
        this.e = str;
    }

    public String getErrType() {
        return this.c;
    }

    public void setErrType(String str) {
        this.c = str;
    }

    public boolean isSuccess() {
        return this.a;
    }

    public void setSuccess(boolean z) {
        this.a = z;
    }

    public int getStatusCode() {
        return this.f;
    }

    public void setStatusCode(int i) {
        this.f = i;
    }
}
