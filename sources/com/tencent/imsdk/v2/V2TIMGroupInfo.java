package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.TIMGroupAddOpt;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.ext.group.TIMGroupBaseInfo;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfo;
import com.tencent.imsdk.log.QLog;
import java.util.Map;

public class V2TIMGroupInfo {
    static final String GROUP_TYPE_INTERNAL_CHATROOM = "ChatRoom";
    static final String GROUP_TYPE_INTERNAL_PRIVATE = "Private";
    public static final int V2TIM_GROUP_ADD_ANY = 2;
    public static final int V2TIM_GROUP_ADD_AUTH = 1;
    public static final int V2TIM_GROUP_ADD_FORBID = 0;
    public static final int V2TIM_GROUP_NOT_RECEIVE_MESSAGE = 1;
    public static final int V2TIM_GROUP_RECEIVE_MESSAGE = 0;
    public static final int V2TIM_GROUP_RECEIVE_NOT_NOTIFY_MESSAGE = 2;
    final int GROUP_INFO_TYPE_BASE = 0;
    final int GROUP_INFO_TYPE_DETAIL = 1;
    private final String TAG = "V2TIMGroupInfo";
    private TIMGroupManager.CreateGroupParam createGroupParam;
    private int groupInfoType = 0;
    private TIMGroupManager.ModifyGroupInfoParam modifyGroupInfoParam;
    private TIMGroupBaseInfo timGroupBaseInfo;
    private TIMGroupDetailInfo timGroupDetailInfo = new TIMGroupDetailInfo();

    void setTIMGroupBaseInfo(TIMGroupBaseInfo tIMGroupBaseInfo) {
        this.timGroupBaseInfo = tIMGroupBaseInfo;
        this.groupInfoType = 0;
    }

    void setTIMGroupDetailInfo(TIMGroupDetailInfo tIMGroupDetailInfo) {
        this.timGroupDetailInfo = tIMGroupDetailInfo;
        this.groupInfoType = 1;
    }

    TIMGroupManager.CreateGroupParam getCreateGroupParam() {
        return this.createGroupParam;
    }

    TIMGroupManager.ModifyGroupInfoParam getModifyGroupInfoParam() {
        return this.modifyGroupInfoParam;
    }

    public String getGroupID() {
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getGroupId();
            }
            return null;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getGroupId();
        }
        return null;
    }

    public void setGroupID(String str) {
        if (this.createGroupParam == null) {
            this.createGroupParam = new TIMGroupManager.CreateGroupParam("", "");
        }
        this.createGroupParam.setGroupId(str);
        if (this.modifyGroupInfoParam == null) {
            this.modifyGroupInfoParam = new TIMGroupManager.ModifyGroupInfoParam(str);
        }
        this.modifyGroupInfoParam.setGroupId(str);
    }

    public String getGroupType() {
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                String groupType = tIMGroupBaseInfo.getGroupType();
                if (TextUtils.isEmpty(groupType)) {
                    return null;
                }
                if (groupType.equals("Private")) {
                    return "Work";
                }
                if (groupType.equals("ChatRoom")) {
                    return "Meeting";
                }
                return groupType;
            }
        } else {
            TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
            if (tIMGroupDetailInfo != null) {
                String groupType2 = tIMGroupDetailInfo.getGroupType();
                if (TextUtils.isEmpty(groupType2)) {
                    return null;
                }
                if (groupType2.equals("Private")) {
                    return "Work";
                }
                if (groupType2.equals("ChatRoom")) {
                    return "Meeting";
                }
                return groupType2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    public void setGroupType(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMGroupInfo", "setGroupType error type is null");
            return;
        }
        if (!str.equalsIgnoreCase("Work")) {
            if (!str.equalsIgnoreCase("Meeting")) {
                if (!str.equalsIgnoreCase("Private")) {
                    if (!str.equalsIgnoreCase("ChatRoom")) {
                        if (str.equalsIgnoreCase("Public")) {
                            str = "Public";
                        } else if (str.equalsIgnoreCase("AVChatRoom")) {
                            str = "AVChatRoom";
                        }
                        if (this.createGroupParam == null) {
                            this.createGroupParam = new TIMGroupManager.CreateGroupParam("", "");
                        }
                        this.createGroupParam.setGroupType(str);
                    }
                }
            }
            str = "ChatRoom";
            if (this.createGroupParam == null) {
            }
            this.createGroupParam.setGroupType(str);
        }
        str = "Private";
        if (this.createGroupParam == null) {
        }
        this.createGroupParam.setGroupType(str);
    }

    public String getGroupName() {
        TIMGroupManager.CreateGroupParam createGroupParam2 = this.createGroupParam;
        if (createGroupParam2 != null) {
            return createGroupParam2.getGroupName();
        }
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getGroupName();
            }
            return null;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getGroupName();
        }
        return null;
    }

    public void setGroupName(String str) {
        if (this.createGroupParam == null) {
            this.createGroupParam = new TIMGroupManager.CreateGroupParam("", "");
        }
        this.createGroupParam.setGroupName(str);
        if (this.modifyGroupInfoParam == null) {
            this.modifyGroupInfoParam = new TIMGroupManager.ModifyGroupInfoParam("");
        }
        this.modifyGroupInfoParam.setGroupName(str);
    }

    public String getNotification() {
        TIMGroupManager.CreateGroupParam createGroupParam2 = this.createGroupParam;
        if (createGroupParam2 != null) {
            return createGroupParam2.getNotification();
        }
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getGroupNotification();
            }
            return null;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getGroupNotification();
        }
        return null;
    }

    public void setNotification(String str) {
        if (this.createGroupParam == null) {
            this.createGroupParam = new TIMGroupManager.CreateGroupParam("", "");
        }
        this.createGroupParam.setNotification(str);
        if (this.modifyGroupInfoParam == null) {
            this.modifyGroupInfoParam = new TIMGroupManager.ModifyGroupInfoParam("");
        }
        this.modifyGroupInfoParam.setNotification(str);
    }

    public String getIntroduction() {
        TIMGroupManager.CreateGroupParam createGroupParam2 = this.createGroupParam;
        if (createGroupParam2 != null) {
            return createGroupParam2.getIntroduction();
        }
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getGroupIntroduction();
            }
            return null;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getGroupIntroduction();
        }
        return null;
    }

    public void setIntroduction(String str) {
        if (this.createGroupParam == null) {
            this.createGroupParam = new TIMGroupManager.CreateGroupParam("", "");
        }
        this.createGroupParam.setIntroduction(str);
        if (this.modifyGroupInfoParam == null) {
            this.modifyGroupInfoParam = new TIMGroupManager.ModifyGroupInfoParam("");
        }
        this.modifyGroupInfoParam.setIntroduction(str);
    }

    public String getFaceUrl() {
        TIMGroupManager.CreateGroupParam createGroupParam2 = this.createGroupParam;
        if (createGroupParam2 != null) {
            return createGroupParam2.getFaceUrl();
        }
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getFaceUrl();
            }
            return null;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getFaceUrl();
        }
        return null;
    }

    public void setFaceUrl(String str) {
        if (this.createGroupParam == null) {
            this.createGroupParam = new TIMGroupManager.CreateGroupParam("", "");
        }
        this.createGroupParam.setFaceUrl(str);
        if (this.modifyGroupInfoParam == null) {
            this.modifyGroupInfoParam = new TIMGroupManager.ModifyGroupInfoParam("");
        }
        this.modifyGroupInfoParam.setFaceUrl(str);
    }

    public boolean isAllMuted() {
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.isSilenceAll();
            }
            return false;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.isSilenceAll();
        }
        return false;
    }

    public void setAllMuted(boolean z) {
        if (this.modifyGroupInfoParam == null) {
            this.modifyGroupInfoParam = new TIMGroupManager.ModifyGroupInfoParam("");
        }
        this.modifyGroupInfoParam.setSilenceAll(z);
    }

    public String getOwner() {
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getGroupOwner();
            }
            return null;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getGroupOwner();
        }
        return null;
    }

    public long getCreateTime() {
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getCreateTime();
            }
            return 0;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getCreateTime();
        }
        return 0;
    }

    public int getGroupAddOpt() {
        long j;
        TIMGroupManager.CreateGroupParam createGroupParam2 = this.createGroupParam;
        if (createGroupParam2 != null) {
            j = createGroupParam2.getAddOption().getValue();
        } else {
            if (this.groupInfoType == 0) {
                TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
                if (tIMGroupBaseInfo != null) {
                    j = tIMGroupBaseInfo.getAddOption().getValue();
                }
            } else {
                TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
                if (tIMGroupDetailInfo != null) {
                    j = tIMGroupDetailInfo.getAddOption().getValue();
                }
            }
            j = 2;
        }
        if (j == TIMGroupAddOpt.TIM_GROUP_ADD_ANY.getValue()) {
            return 2;
        }
        if (j == TIMGroupAddOpt.TIM_GROUP_ADD_FORBID.getValue()) {
            return 0;
        }
        if (j == TIMGroupAddOpt.TIM_GROUP_ADD_AUTH.getValue()) {
            return 1;
        }
        return 2;
    }

    public void setGroupAddOpt(int i) {
        TIMGroupAddOpt tIMGroupAddOpt = TIMGroupAddOpt.TIM_GROUP_ADD_FORBID;
        long j = (long) i;
        if (j == TIMGroupAddOpt.TIM_GROUP_ADD_ANY.getValue()) {
            tIMGroupAddOpt = TIMGroupAddOpt.TIM_GROUP_ADD_ANY;
        } else if (j == TIMGroupAddOpt.TIM_GROUP_ADD_FORBID.getValue()) {
            tIMGroupAddOpt = TIMGroupAddOpt.TIM_GROUP_ADD_FORBID;
        } else if (j == TIMGroupAddOpt.TIM_GROUP_ADD_AUTH.getValue()) {
            tIMGroupAddOpt = TIMGroupAddOpt.TIM_GROUP_ADD_AUTH;
        }
        if (this.createGroupParam == null) {
            this.createGroupParam = new TIMGroupManager.CreateGroupParam("", "");
        }
        this.createGroupParam.setAddOption(tIMGroupAddOpt);
        if (this.modifyGroupInfoParam == null) {
            this.modifyGroupInfoParam = new TIMGroupManager.ModifyGroupInfoParam("");
        }
        this.modifyGroupInfoParam.setAddOption(tIMGroupAddOpt);
    }

    public void setCustomInfo(Map<String, byte[]> map) {
        if (map != null) {
            if (this.createGroupParam == null) {
                this.createGroupParam = new TIMGroupManager.CreateGroupParam("", "");
            }
            for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                this.createGroupParam.setCustomInfo(entry.getKey(), entry.getValue());
            }
            if (this.modifyGroupInfoParam == null) {
                this.modifyGroupInfoParam = new TIMGroupManager.ModifyGroupInfoParam("");
            }
            this.modifyGroupInfoParam.setCustomInfo(map);
        }
    }

    public Map<String, byte[]> getCustomInfo() {
        TIMGroupManager.CreateGroupParam createGroupParam2 = this.createGroupParam;
        if (createGroupParam2 != null) {
            return createGroupParam2.getCustomInfo();
        }
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getCustom();
            }
            return null;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getCustom();
        }
        return null;
    }

    public long getLastInfoTime() {
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getLastInfoTime();
            }
            return 0;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getLastInfoTime();
        }
        return 0;
    }

    public long getLastMessageTime() {
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getLastMsgTime();
            }
            return 0;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getLastMsgTime();
        }
        return 0;
    }

    public int getMemberCount() {
        long memberNum;
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo == null) {
                return 0;
            }
            memberNum = tIMGroupBaseInfo.getMemberNumber();
        } else {
            TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
            if (tIMGroupDetailInfo == null) {
                return 0;
            }
            memberNum = tIMGroupDetailInfo.getMemberNum();
        }
        return (int) memberNum;
    }

    public int getOnlineCount() {
        long onlineMemberNum;
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo == null) {
                return 0;
            }
            onlineMemberNum = tIMGroupBaseInfo.getOnlineMemberNumber();
        } else {
            TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
            if (tIMGroupDetailInfo == null) {
                return 0;
            }
            onlineMemberNum = tIMGroupDetailInfo.getOnlineMemberNum();
        }
        return (int) onlineMemberNum;
    }

    public int getRole() {
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getRole();
            }
            return 0;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getRole();
        }
        return 0;
    }

    public int getRecvOpt() {
        long value;
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo == null) {
                return 0;
            }
            value = tIMGroupBaseInfo.getRecvOpt().getValue();
        } else {
            TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
            if (tIMGroupDetailInfo == null) {
                return 0;
            }
            value = tIMGroupDetailInfo.getRecvOpt().getValue();
        }
        return (int) value;
    }

    public long getJoinTime() {
        if (this.groupInfoType == 0) {
            TIMGroupBaseInfo tIMGroupBaseInfo = this.timGroupBaseInfo;
            if (tIMGroupBaseInfo != null) {
                return tIMGroupBaseInfo.getJoinTime();
            }
            return 0;
        }
        TIMGroupDetailInfo tIMGroupDetailInfo = this.timGroupDetailInfo;
        if (tIMGroupDetailInfo != null) {
            return tIMGroupDetailInfo.getJoinTime();
        }
        return 0;
    }
}
