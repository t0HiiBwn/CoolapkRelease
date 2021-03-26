package com.alibaba.baichuan.trade.common;

public enum Environment {
    SANDBOX(0, "沙箱环境"),
    TEST(1, "测试环境"),
    PRE(2, "预发环境"),
    ONLINE(3, "线上环境");
    
    private String desc;
    private int status;

    private Environment(int i, String str) {
        this.status = i;
        this.desc = str;
    }

    public static Environment valueOfStatus(int i) {
        Environment[] values = values();
        for (int i2 = 0; i2 < values.length; i2++) {
            if (i == values[i2].status) {
                return values[i2];
            }
        }
        return null;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
