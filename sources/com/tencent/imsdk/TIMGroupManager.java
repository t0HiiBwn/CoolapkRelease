package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imsdk.ext.group.ModifyGroupFlag;
import com.tencent.imsdk.ext.group.ModifyGroupMemberFlag;
import com.tencent.imsdk.ext.group.TIMGroupBaseInfo;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfo;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfoResult;
import com.tencent.imsdk.ext.group.TIMGroupMemberResult;
import com.tencent.imsdk.ext.group.TIMGroupMemberRoleFilter;
import com.tencent.imsdk.ext.group.TIMGroupMemberSucc;
import com.tencent.imsdk.ext.group.TIMGroupPendencyGetParam;
import com.tencent.imsdk.ext.group.TIMGroupPendencyListGetSucc;
import com.tencent.imsdk.ext.group.TIMGroupSelfInfo;
import com.tencent.imsdk.group.GroupBaseManager;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TIMGroupManager {
    private static final String TAG = "TIMGroupManager";
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_ADD_OPTION = 8192;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_APP_ID = 128;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_CREATE_TIME = 2;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_FACE_URL = 4096;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE = 16384;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_INTRODUCTION = 2048;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG = 32768;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG_TIME = 64;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_MAX_MEMBER_NUM = 512;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_MEMBER_NUM = 256;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_NAME = 1;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_NEXT_MSG_SEQ = 32;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_NOTIFICATION = 1024;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_OWNER_UIN = 4;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_SEQ = 8;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_TIME = 16;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_JOIN_TIME = 1;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_MSG_FLAG = 2;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_NAME_CARD = 32;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_ROLE_INFO = 8;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_SHUTUP_TIME = 16;
    private static final TIMGroupManager instance = new TIMGroupManager();
    private String userID = "";

    private TIMGroupManager() {
    }

    private String getIdentifier() {
        return this.userID;
    }

    public static TIMGroupManager getInstance() {
        return instance;
    }

    private GroupBaseManager getGroupManager() {
        return GroupBaseManager.getInstance();
    }

    public void createGroup(CreateGroupParam createGroupParam, TIMValueCallBack<String> tIMValueCallBack) {
        if (createGroupParam == null) {
            QLog.e(TAG, "createGroup fail, param is null");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "param is null");
                return;
            }
            return;
        }
        QLog.i("TAG", "createGroup: " + createGroupParam.toString());
        getGroupManager().createGroup(createGroupParam, tIMValueCallBack);
    }

    public void deleteGroup(String str, TIMCallBack tIMCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, "deleteGroup fail, groupId is empty");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        QLog.i("TAG", "deleteGroup: " + str);
        getGroupManager().deleteGroup(str, tIMCallBack);
    }

    public void applyJoinGroup(String str, String str2, TIMCallBack tIMCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, "applyJoinGroup fail, groupId is empty");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        getGroupManager().applyJoinGroup(str, str2, tIMCallBack);
    }

    public void quitGroup(String str, TIMCallBack tIMCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, "quitGroup fail, groupId is empty");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        getGroupManager().quitGroup(str, tIMCallBack);
    }

    public void inviteGroupMember(String str, List<String> list, TIMValueCallBack<List<TIMGroupMemberResult>> tIMValueCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, "inviteGroupMember fail, groupId is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "groupID is empty");
            }
        } else if (list == null || list.size() == 0) {
            QLog.e(TAG, "inviteGroupMember fail, memList is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "memList is empty");
            }
        } else {
            getGroupManager().inviteGroupMember(str, list, tIMValueCallBack);
        }
    }

    public void deleteGroupMember(DeleteMemberParam deleteMemberParam, TIMValueCallBack<List<TIMGroupMemberResult>> tIMValueCallBack) {
        if (deleteMemberParam == null || !deleteMemberParam.isValid()) {
            QLog.e(TAG, "deleteGroupMember fail, param is null or invalid");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "param is null or invalid");
                return;
            }
            return;
        }
        getGroupManager().deleteGroupMember(deleteMemberParam, tIMValueCallBack);
    }

    public void getGroupList(TIMValueCallBack<List<TIMGroupBaseInfo>> tIMValueCallBack) {
        getGroupManager().getGroupList(tIMValueCallBack);
    }

    public void getGroupInfo(List<String> list, TIMValueCallBack<List<TIMGroupDetailInfoResult>> tIMValueCallBack) {
        if (list == null || list.size() == 0) {
            QLog.e(TAG, "getGroupInfo fail: groupIdList is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "groupIdList is empty");
                return;
            }
            return;
        }
        getGroupManager().getGroupInfo(list, tIMValueCallBack);
    }

    public void getGroupOnlineMemberCount(String str, TIMValueCallBack<Integer> tIMValueCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, "getGroupOnlineMemberCount fail: groupId is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "groupId is empty");
                return;
            }
            return;
        }
        getGroupManager().getGroupOnlineMemberCount(str, tIMValueCallBack);
    }

    public TIMGroupDetailInfo queryGroupInfo(String str) {
        return getGroupManager().queryGroupInfo(str);
    }

    public void getGroupMembers(String str, TIMValueCallBack<List<TIMGroupMemberInfo>> tIMValueCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, "getGroupMembers fail: groupId is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "groupId is empty");
                return;
            }
            return;
        }
        getGroupManager().getGroupMembers(str, tIMValueCallBack);
    }

    public void getSelfInfo(String str, final TIMValueCallBack<TIMGroupSelfInfo> tIMValueCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, "getSelfInfo err, groupId is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "groupId is empty");
                return;
            }
            return;
        }
        String loginUser = TIMManager.getInstance().getLoginUser();
        if (TextUtils.isEmpty(loginUser)) {
            QLog.e(TAG, "getSelfInfo err, selfId is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6014, "not login");
                return;
            }
            return;
        }
        getGroupManager().getGroupSelfInfo(str, loginUser, new TIMValueCallBack<TIMGroupMemberInfo>() {
            /* class com.tencent.imsdk.TIMGroupManager.AnonymousClass1 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                String str2 = TIMGroupManager.TAG;
                QLog.e(str2, "getSelfInfo err, code = " + i + ", desc = " + str);
                TIMValueCallBack tIMValueCallBack = tIMValueCallBack;
                if (tIMValueCallBack != null) {
                    tIMValueCallBack.onError(i, str);
                }
            }

            public void onSuccess(TIMGroupMemberInfo tIMGroupMemberInfo) {
                if (tIMGroupMemberInfo == null) {
                    QLog.e(TIMGroupManager.TAG, "getSelfInfo onSuccess but timGroupMemberInfo is null!");
                    return;
                }
                TIMGroupSelfInfo tIMGroupSelfInfo = new TIMGroupSelfInfo(tIMGroupMemberInfo);
                TIMValueCallBack tIMValueCallBack = tIMValueCallBack;
                if (tIMValueCallBack != null) {
                    tIMValueCallBack.onSuccess(tIMGroupSelfInfo);
                }
            }
        });
    }

    public void getGroupMembersInfo(String str, List<String> list, TIMValueCallBack<List<TIMGroupMemberInfo>> tIMValueCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, "getGroupMembersInfo fail, groupId is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "groupId is empty");
            }
        } else if (list == null || list.size() == 0) {
            QLog.e(TAG, "getGroupMembersInfo fail, userIDs is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "userIDs is empty");
            }
        } else {
            getGroupManager().getGroupMembersInfo(str, list, tIMValueCallBack);
        }
    }

    public void getGroupMembersByFilter(String str, long j, TIMGroupMemberRoleFilter tIMGroupMemberRoleFilter, List<String> list, long j2, TIMValueCallBack<TIMGroupMemberSucc> tIMValueCallBack) {
        if (TextUtils.isEmpty(str) || j == 0 || tIMGroupMemberRoleFilter == null) {
            String str2 = TAG;
            QLog.e(str2, "invalid param, groupId: " + str + "|flags: " + j + "|filter: " + tIMGroupMemberRoleFilter);
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "invalid params");
                return;
            }
            return;
        }
        getGroupManager().getGroupMembersByFilter(str, j, tIMGroupMemberRoleFilter, list, j2, tIMValueCallBack);
    }

    public void modifyGroupInfo(ModifyGroupInfoParam modifyGroupInfoParam, TIMCallBack tIMCallBack) {
        if (modifyGroupInfoParam == null || !modifyGroupInfoParam.isValid()) {
            QLog.e(TAG, "modifyGroupInfo param is null or invalid");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "param is invalid");
                return;
            }
            return;
        }
        getGroupManager().modifyGroupInfo(modifyGroupInfoParam, tIMCallBack);
    }

    public void modifyGroupOwner(String str, String str2, TIMCallBack tIMCallBack) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            QLog.e(TAG, "modifyGroupOwner, group id or userID is empty!");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "group id or userID is empty!");
                return;
            }
            return;
        }
        getGroupManager().modifyGroupOwner(str, str2, tIMCallBack);
    }

    public void modifyMemberInfo(ModifyMemberInfoParam modifyMemberInfoParam, TIMCallBack tIMCallBack) {
        if (modifyMemberInfoParam == null || !modifyMemberInfoParam.isValid()) {
            QLog.e(TAG, "modifyMemberInfo, param is null or invalid");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "param is invalid");
                return;
            }
            return;
        }
        getGroupManager().modifyMemberInfo(modifyMemberInfoParam, tIMCallBack);
    }

    public void getGroupPendencyList(TIMGroupPendencyGetParam tIMGroupPendencyGetParam, TIMValueCallBack<TIMGroupPendencyListGetSucc> tIMValueCallBack) {
        if (tIMGroupPendencyGetParam == null) {
            QLog.e(TAG, "getGroupPendencyList, param is null");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "param is null");
                return;
            }
            return;
        }
        getGroupManager().getGroupPendencyList(tIMGroupPendencyGetParam, tIMValueCallBack);
    }

    public void reportGroupPendency(long j, TIMCallBack tIMCallBack) {
        getGroupManager().reportGroupPendency(j, tIMCallBack);
    }

    public static class CreateGroupParam {
        TIMGroupAddOpt addOption;
        Map<String, byte[]> customInfo = new HashMap();
        String faceUrl;
        String groupId;
        String groupName;
        String groupType;
        String introduction;
        long maxMemberNum = 0;
        List<TIMGroupMemberInfo> members;
        String notification;

        public CreateGroupParam(String str, String str2) {
            this.groupType = str;
            this.groupName = str2;
        }

        public CreateGroupParam setGroupType(String str) {
            this.groupType = str;
            return this;
        }

        public CreateGroupParam setGroupName(String str) {
            this.groupName = str;
            return this;
        }

        public CreateGroupParam setGroupId(String str) {
            this.groupId = str;
            return this;
        }

        public CreateGroupParam setNotification(String str) {
            this.notification = str;
            return this;
        }

        public CreateGroupParam setIntroduction(String str) {
            this.introduction = str;
            return this;
        }

        public CreateGroupParam setFaceUrl(String str) {
            this.faceUrl = str;
            return this;
        }

        public CreateGroupParam setAddOption(TIMGroupAddOpt tIMGroupAddOpt) {
            this.addOption = tIMGroupAddOpt;
            return this;
        }

        public CreateGroupParam setMaxMemberNum(long j) {
            this.maxMemberNum = j;
            return this;
        }

        public CreateGroupParam setCustomInfo(String str, byte[] bArr) {
            this.customInfo.put(str, bArr);
            return this;
        }

        public CreateGroupParam setMembers(List<TIMGroupMemberInfo> list) {
            this.members = list;
            return this;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CreateGroupParam:");
            stringBuffer.append("groupId=");
            stringBuffer.append(this.groupId);
            stringBuffer.append(";groupName=");
            stringBuffer.append(this.groupName);
            stringBuffer.append(";groupType=");
            stringBuffer.append(this.groupType);
            stringBuffer.append(";faceUrl=");
            stringBuffer.append(this.faceUrl);
            return stringBuffer.toString();
        }

        public String getGroupType() {
            return this.groupType;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getGroupName() {
            return this.groupName;
        }

        public String getNotification() {
            return this.notification;
        }

        public String getIntroduction() {
            return this.introduction;
        }

        public String getFaceUrl() {
            return this.faceUrl;
        }

        public TIMGroupAddOpt getAddOption() {
            return this.addOption;
        }

        public long getMaxMemberNum() {
            return this.maxMemberNum;
        }

        public Map<String, byte[]> getCustomInfo() {
            return this.customInfo;
        }

        public List<TIMGroupMemberInfo> getMembers() {
            return this.members;
        }
    }

    public static class DeleteMemberParam {
        private String groupId = "";
        private List<String> members = new ArrayList();
        private String reason = "";

        public DeleteMemberParam(String str, List<String> list) {
            this.groupId = str;
            this.members = list;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public List<String> getMembers() {
            return this.members;
        }

        public String getReason() {
            return this.reason;
        }

        public DeleteMemberParam setReason(String str) {
            if (str == null) {
                return this;
            }
            this.reason = str;
            return this;
        }

        public boolean isValid() {
            List<String> list;
            return !TextUtils.isEmpty(this.groupId) && (list = this.members) != null && !list.isEmpty();
        }
    }

    public static class ModifyGroupInfoParam {
        private TIMGroupAddOpt addOption = TIMGroupAddOpt.TIM_GROUP_ADD_ANY;
        Map<String, byte[]> customInfo = new HashMap();
        private String faceUrl = "";
        private long flags = 0;
        private String groupId = "";
        private String groupName = "";
        private String introduction = "";
        private boolean isSearchable = true;
        private boolean isSilenceAll = false;
        private boolean isVisable = true;
        private long maxMemberNum = 0;
        private String notification = "";

        public ModifyGroupInfoParam(String str) {
            this.groupId = str;
        }

        public void setGroupId(String str) {
            this.groupId = str;
        }

        public String getGroupName() {
            return this.groupName;
        }

        public ModifyGroupInfoParam setGroupName(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.groupName = str;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupName.swigValue();
            return this;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getNotification() {
            return this.notification;
        }

        public ModifyGroupInfoParam setNotification(String str) {
            if (str == null) {
                return this;
            }
            this.notification = str;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupNotification.swigValue();
            return this;
        }

        public String getIntroduction() {
            return this.introduction;
        }

        public ModifyGroupInfoParam setIntroduction(String str) {
            if (str == null) {
                return this;
            }
            this.introduction = str;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupIntroduction.swigValue();
            return this;
        }

        public String getFaceUrl() {
            return this.faceUrl;
        }

        public ModifyGroupInfoParam setFaceUrl(String str) {
            if (str == null) {
                return this;
            }
            this.faceUrl = str;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupFaceUrl.swigValue();
            return this;
        }

        public TIMGroupAddOpt getAddOption() {
            return this.addOption;
        }

        public ModifyGroupInfoParam setAddOption(TIMGroupAddOpt tIMGroupAddOpt) {
            if (tIMGroupAddOpt == null) {
                return this;
            }
            this.addOption = tIMGroupAddOpt;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupAddOption.swigValue();
            return this;
        }

        public long getMaxMemberNum() {
            return this.maxMemberNum;
        }

        public ModifyGroupInfoParam setMaxMemberNum(long j) {
            if (j <= 0) {
                return this;
            }
            this.maxMemberNum = j;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupMaxMmeberNum.swigValue();
            return this;
        }

        public boolean isVisable() {
            return this.isVisable;
        }

        public ModifyGroupInfoParam setVisable(boolean z) {
            this.isVisable = z;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupVisible.swigValue();
            return this;
        }

        public boolean isSearchable() {
            return this.isSearchable;
        }

        public boolean isSilenceAll() {
            return this.isSilenceAll;
        }

        public ModifyGroupInfoParam setSilenceAll(boolean z) {
            this.isSilenceAll = z;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupAllShutup.swigValue();
            return this;
        }

        public ModifyGroupInfoParam setSearchable(boolean z) {
            this.isSearchable = z;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupSearchable.swigValue();
            return this;
        }

        public Map<String, byte[]> getCustomInfo() {
            return this.customInfo;
        }

        public ModifyGroupInfoParam setCustomInfo(Map<String, byte[]> map) {
            if (map != null && !map.isEmpty()) {
                this.customInfo = map;
            }
            return this;
        }

        public long getFlags() {
            return this.flags;
        }

        public boolean isValid() {
            return !TextUtils.isEmpty(this.groupId) && ((this.flags & ((long) ModifyGroupFlag.kModifyGroupName.swigValue())) == 0 || !TextUtils.isEmpty(this.groupName));
        }
    }

    public static class ModifyMemberInfoParam {
        Map<String, byte[]> customInfo = new HashMap();
        private long flags;
        private String groupId = "";
        private String nameCard = "";
        private TIMGroupReceiveMessageOpt receiveMessageOpt = TIMGroupReceiveMessageOpt.ReceiveAndNotify;
        private int roleType = 0;
        private long silence;
        private String userID = "";

        public ModifyMemberInfoParam(String str, String str2) {
            this.groupId = str;
            this.userID = str2;
        }

        public void setGroupId(String str) {
            this.groupId = str;
        }

        public void setUserID(String str) {
            this.userID = str;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getIdentifier() {
            return this.userID;
        }

        public String getNameCard() {
            return this.nameCard;
        }

        public ModifyMemberInfoParam setNameCard(String str) {
            if (str == null) {
                return this;
            }
            this.nameCard = str;
            this.flags |= (long) ModifyGroupMemberFlag.kModifyGroupMemberNameCard.swigValue();
            return this;
        }

        public TIMGroupReceiveMessageOpt getReceiveMessageOpt() {
            return this.receiveMessageOpt;
        }

        public ModifyMemberInfoParam setReceiveMessageOpt(TIMGroupReceiveMessageOpt tIMGroupReceiveMessageOpt) {
            if (tIMGroupReceiveMessageOpt == null) {
                return this;
            }
            this.receiveMessageOpt = tIMGroupReceiveMessageOpt;
            this.flags |= (long) ModifyGroupMemberFlag.kModifyGroupMemberMsgFlag.swigValue();
            return this;
        }

        public int getRoleType() {
            return this.roleType;
        }

        public ModifyMemberInfoParam setRoleType(int i) {
            if (i == 400) {
                QLog.e(TIMGroupManager.TAG, "setRoleType, cannot be owner!");
                return this;
            }
            this.roleType = i;
            this.flags |= (long) ModifyGroupMemberFlag.kModifyGroupMemberRole.swigValue();
            return this;
        }

        public long getSilence() {
            return this.silence;
        }

        public ModifyMemberInfoParam setSilence(long j) {
            if (j < 0) {
                j = 0;
            }
            this.silence = j;
            this.flags |= (long) ModifyGroupMemberFlag.kModifyGroupMemberShutupTime.swigValue();
            return this;
        }

        public Map<String, byte[]> getCustomInfo() {
            return this.customInfo;
        }

        public ModifyMemberInfoParam setCustomInfo(Map<String, byte[]> map) {
            if (map != null && !map.isEmpty()) {
                this.customInfo = map;
            }
            return this;
        }

        public long getFlags() {
            return this.flags;
        }

        boolean isValid() {
            return !TextUtils.isEmpty(this.groupId) && !TextUtils.isEmpty(this.userID);
        }
    }
}
