package com.tencent.imsdk.friendship;

import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.List;

public class TIMFriendCheckInfo {
    private static final String TAG = "TIMFriendCheckInfo";
    private int checkType = 1;
    private List<String> users = new ArrayList();

    public List<String> getUsers() {
        return this.users;
    }

    public void setUsers(List<String> list) {
        this.users = list;
    }

    public int getCheckType() {
        return this.checkType;
    }

    public void setCheckType(int i) {
        if (i == 1 || i == 2) {
            this.checkType = i;
            return;
        }
        QLog.e("TIMFriendCheckInfo", "setCheckType type = " + i + ", invalid type, force to TIMFriendCheckType.TIM_FRIEND_CHECK_TYPE_UNIDIRECTION");
        this.checkType = 1;
    }
}
