package com.alibaba.sdk.android.oss.model;

public class Range {
    public static final long INFINITE = -1;
    private long begin;
    private long end;

    public Range(long j, long j2) {
        setBegin(j);
        setEnd(j2);
    }

    public long getEnd() {
        return this.end;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public long getBegin() {
        return this.begin;
    }

    public void setBegin(long j) {
        this.begin = j;
    }

    public boolean checkIsValid() {
        long j = this.begin;
        if (j >= -1) {
            long j2 = this.end;
            if (j2 >= -1) {
                return j < 0 || j2 < 0 || j <= j2;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        long j = this.begin;
        String str = "";
        sb.append(j == -1 ? str : String.valueOf(j));
        sb.append("-");
        long j2 = this.end;
        if (j2 != -1) {
            str = String.valueOf(j2);
        }
        sb.append(str);
        return sb.toString();
    }
}
