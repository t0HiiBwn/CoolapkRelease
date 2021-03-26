package com.bytedance.embedapplog;

public interface IOaidObserver {
    void onOaidLoaded(Oaid oaid);

    public static final class Oaid {
        public final String id;

        public Oaid(String str) {
            this.id = str;
        }
    }
}
