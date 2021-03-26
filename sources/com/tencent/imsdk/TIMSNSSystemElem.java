package com.tencent.imsdk;

import com.tencent.imsdk.friendship.TIMFriendPendencyInfo;
import java.util.ArrayList;
import java.util.List;

public class TIMSNSSystemElem extends TIMElem {
    private List<String> addBlacklistUserList = new ArrayList();
    private List<String> addFriendGroupList = new ArrayList();
    private List<TIMSNSChangeInfo> changeInfoList = new ArrayList();
    private long decideReportTimestamp;
    private List<String> delBlacklistUserList = new ArrayList();
    private List<String> delFriendAddDecideList = new ArrayList();
    private List<String> delFriendAddPendencyList = new ArrayList();
    private List<String> delFriendGroupList = new ArrayList();
    private List<String> delRecommendList = new ArrayList();
    private List<String> delRequestAddFriendUserList = new ArrayList();
    private List<String> friendAddDecideList = new ArrayList();
    private List<TIMFriendPendencyInfo> friendAddPendencyList = new ArrayList();
    private long pendencyReportTimestamp;
    private List<String> recommendList = new ArrayList();
    private long recommendReportTimestamp;
    private List<String> requestAddFriendUserList = new ArrayList();
    private int subType = 0;
    private List<String> updateFriendGroupList = new ArrayList();

    public TIMSNSSystemElem() {
        this.type = TIMElemType.SNSTips;
    }

    public int getSubType() {
        return this.subType;
    }

    public List<String> getRequestAddFriendUserList() {
        return this.requestAddFriendUserList;
    }

    public List<String> getDelRequestAddFriendUserList() {
        return this.delRequestAddFriendUserList;
    }

    public List<String> getAddBlacklistUserList() {
        return this.addBlacklistUserList;
    }

    public List<String> getDelBlacklistUserList() {
        return this.delBlacklistUserList;
    }

    public List<TIMFriendPendencyInfo> getFriendAddPendencyList() {
        return this.friendAddPendencyList;
    }

    public List<String> getDelFriendAddPendencyList() {
        return this.delFriendAddPendencyList;
    }

    public List<TIMSNSChangeInfo> getChangeInfoList() {
        return this.changeInfoList;
    }

    public long getPendencyReportTimestamp() {
        return this.pendencyReportTimestamp;
    }
}
