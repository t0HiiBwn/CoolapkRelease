package com.tencent.imsdk.v2;

import com.tencent.imsdk.ext.group.TIMGroupMemberResult;

public class V2TIMGroupMemberOperationResult {
    public static final int OPERATION_RESULT_FAIL = 0;
    public static final int OPERATION_RESULT_INVALID = 2;
    public static final int OPERATION_RESULT_PENDING = 3;
    public static final int OPERATION_RESULT_SUCC = 1;
    private TIMGroupMemberResult timGroupMemberResult;

    void setTimGroupMemberResult(TIMGroupMemberResult tIMGroupMemberResult) {
        this.timGroupMemberResult = tIMGroupMemberResult;
    }

    public String getMemberID() {
        TIMGroupMemberResult tIMGroupMemberResult = this.timGroupMemberResult;
        if (tIMGroupMemberResult != null) {
            return tIMGroupMemberResult.getUser();
        }
        return null;
    }

    public int getResult() {
        TIMGroupMemberResult tIMGroupMemberResult = this.timGroupMemberResult;
        if (tIMGroupMemberResult != null) {
            return (int) tIMGroupMemberResult.getResult();
        }
        return 0;
    }
}
