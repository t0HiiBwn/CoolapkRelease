package com.tencent.imsdk;

public class TIMFriendProfileOption {
    private int expiredSeconds;

    public int getExpiredSeconds() {
        return this.expiredSeconds;
    }

    public void setExpiredSeconds(int i) {
        if (i <= 0) {
            this.expiredSeconds = 0;
        } else {
            this.expiredSeconds = i;
        }
    }
}
