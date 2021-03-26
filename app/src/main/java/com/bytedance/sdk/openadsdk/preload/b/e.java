package com.bytedance.sdk.openadsdk.preload.b;

/* compiled from: InterceptorFactory */
public interface e {
    <T> T a(Class<T> cls);

    /* compiled from: InterceptorFactory */
    public static class a implements e {
        @Override // com.bytedance.sdk.openadsdk.preload.b.e
        public <T> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
