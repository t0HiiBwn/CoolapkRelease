package mtopsdk.mtop.domain;

public enum MethodEnum {
    GET("GET"),
    POST("POST"),
    HEAD("HEAD"),
    PATCH("PATCH");
    
    private String method;

    public final String getMethod() {
        return this.method;
    }

    private MethodEnum(String str) {
        this.method = str;
    }
}
