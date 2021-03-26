package com.tencent.imsdk.ext.message;

import java.util.ArrayList;
import java.util.List;

public class TIMBatchOprDetailInfo {
    private List<ErrInfo> errors = new ArrayList();
    private long failNum;
    private long succNum;

    TIMBatchOprDetailInfo(int i, int i2) {
        this.succNum = (long) i;
        this.failNum = (long) i2;
    }

    public long getSuccNum() {
        return this.succNum;
    }

    public long getFailNum() {
        return this.failNum;
    }

    public List<ErrInfo> getErrors() {
        return this.errors;
    }

    public static class ErrInfo {
        private int errCode;
        private String errMsg = "";
        private String id = "";

        public ErrInfo(String str, int i, String str2) {
            this.id = str;
            this.errCode = i;
            this.errMsg = str2;
        }

        public String getId() {
            return this.id;
        }

        public int getErrCode() {
            return this.errCode;
        }

        public String getErrMsg() {
            return this.errMsg;
        }
    }
}
