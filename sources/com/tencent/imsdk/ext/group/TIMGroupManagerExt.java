package com.tencent.imsdk.ext.group;

import android.text.TextUtils;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMGroupAddOpt;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupReceiveMessageOpt;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.group.GroupBaseManager;
import com.tencent.imsdk.group.GroupNativeManager;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class TIMGroupManagerExt {
    private static final String TAG = "TIMGroupManagerExt";
    private static final TIMGroupManagerExt instance = new TIMGroupManagerExt();
    private GroupBaseManager groupBaseManager = GroupBaseManager.getInstance();

    private TIMGroupManagerExt() {
    }

    public static TIMGroupManagerExt getInstance() {
        return instance;
    }

    @Deprecated
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

    @Deprecated
    public void deleteGroupMember(DeleteMemberParam deleteMemberParam, TIMValueCallBack<List<TIMGroupMemberResult>> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e("TIMGroupManagerExt", "deleteGroupMember ignore, callback is null");
        } else if (deleteMemberParam != null && deleteMemberParam.isValid()) {
            GroupNativeManager.nativeDeleteGroupMember(deleteMemberParam.getGroupId(), deleteMemberParam.getMembers(), deleteMemberParam.getReason(), new ICallback<List<TIMGroupMemberResult>>(tIMValueCallBack) {
                /* class com.tencent.imsdk.ext.group.TIMGroupManagerExt.AnonymousClass1 */

                public void done(List<TIMGroupMemberResult> list) {
                    QLog.i("TAG", "deleteGroupMember success");
                    super.done((AnonymousClass1) list);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.i("TIMGroupManagerExt", "deleteGroupMember fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        }
    }

    @Deprecated
    public void inviteGroupMember(String str, List<String> list, TIMValueCallBack<List<TIMGroupMemberResult>> tIMValueCallBack) {
        this.groupBaseManager.inviteGroupMember(str, list, tIMValueCallBack);
    }

    @Deprecated
    public void getGroupList(TIMValueCallBack<List<TIMGroupBaseInfo>> tIMValueCallBack) {
        this.groupBaseManager.getGroupList(tIMValueCallBack);
    }

    private enum GroupModifyOpType {
        Invalid(0),
        Name(1),
        Brief(2),
        Option(3),
        Notice(4),
        Icon(5);
        
        int value = 0;

        private GroupModifyOpType(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }

    private enum MemberModifyOpType {
        RecvMsgOpt(1),
        Role(2),
        Silence(3),
        NameCard(4);
        
        private long type;

        private MemberModifyOpType(long j) {
            this.type = j;
        }

        long getValue() {
            return this.type;
        }

        long getBitmap() {
            return (long) (1 << ((int) (this.type - 1)));
        }
    }

    @Deprecated
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

    @Deprecated
    public void modifyGroupInfo(ModifyGroupInfoParam modifyGroupInfoParam, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null && modifyGroupInfoParam != null && modifyGroupInfoParam.isValid()) {
            GroupNativeManager.nativeSetGroupInfo(modifyGroupInfoParam.getFlags(), modifyGroupInfoParam.getGroupId(), modifyGroupInfoParam.getGroupName(), modifyGroupInfoParam.getNotification(), modifyGroupInfoParam.getIntroduction(), modifyGroupInfoParam.getFaceUrl(), modifyGroupInfoParam.getAddOption().getValue(), modifyGroupInfoParam.getMaxMemberNum(), modifyGroupInfoParam.isVisable(), modifyGroupInfoParam.isSearchable(), modifyGroupInfoParam.isSilenceAll(), modifyGroupInfoParam.getCustomInfo(), new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.ext.group.TIMGroupManagerExt.AnonymousClass2 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMGroupManagerExt", "modifyGroupInfo success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMGroupManagerExt", "modifyGroupInfo fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        }
    }

    @Deprecated
    public void modifyGroupOwner(String str, String str2, TIMCallBack tIMCallBack) {
        this.groupBaseManager.modifyGroupOwner(str, str2, tIMCallBack);
    }

    @Deprecated
    public void getGroupInfo(List<String> list, TIMValueCallBack<List<TIMGroupDetailInfoResult>> tIMValueCallBack) {
        this.groupBaseManager.getGroupInfo(list, tIMValueCallBack);
    }

    @Deprecated
    public TIMGroupDetailInfo queryGroupInfo(String str) {
        return this.groupBaseManager.queryGroupInfo(str);
    }

    @Deprecated
    public static class ModifyMemberInfoParam {
        Map<String, byte[]> customInfo = new HashMap();
        private long flags;
        private String groupId = "";
        private String identifier = "";
        private String nameCard = "";
        private TIMGroupReceiveMessageOpt receiveMessageOpt = TIMGroupReceiveMessageOpt.ReceiveAndNotify;
        private int roleType = 0;
        private long silence;

        public ModifyMemberInfoParam(String str, String str2) {
            this.groupId = str;
            this.identifier = str2;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getIdentifier() {
            return this.identifier;
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
                QLog.e("TIMGroupManagerExt", "setRoleType, cannot be owner!");
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
            return !TextUtils.isEmpty(this.groupId) && !TextUtils.isEmpty(this.identifier);
        }
    }

    @Deprecated
    public void modifyMemberInfo(ModifyMemberInfoParam modifyMemberInfoParam, TIMCallBack tIMCallBack) {
        GroupNativeManager.nativeSetGroupMemberInfo(modifyMemberInfoParam.getFlags(), modifyMemberInfoParam.getGroupId(), modifyMemberInfoParam.getIdentifier(), modifyMemberInfoParam.getNameCard(), modifyMemberInfoParam.getReceiveMessageOpt().getValue(), (long) modifyMemberInfoParam.getRoleType(), modifyMemberInfoParam.getSilence(), modifyMemberInfoParam.getCustomInfo(), new ICallback(tIMCallBack) {
            /* class com.tencent.imsdk.ext.group.TIMGroupManagerExt.AnonymousClass3 */

            @Override // com.tencent.imsdk.common.ICallback
            public void done(Object obj) {
                QLog.i("TIMGroupManagerExt", "modifyMemberInfo success");
                super.done(obj);
            }

            @Override // com.tencent.imsdk.common.ICallback
            public void fail(int i, String str) {
                QLog.i("TIMGroupManagerExt", "modifyMemberInfo fail: " + i + ":" + str);
                super.fail(i, str);
            }
        });
    }

    @Deprecated
    public void getGroupMembers(String str, TIMValueCallBack<List<TIMGroupMemberInfo>> tIMValueCallBack) {
        this.groupBaseManager.getGroupMembers(str, tIMValueCallBack);
    }

    @Deprecated
    public void getGroupMembersInfo(String str, List<String> list, TIMValueCallBack<List<TIMGroupMemberInfo>> tIMValueCallBack) {
        this.groupBaseManager.getGroupMembersInfo(str, list, tIMValueCallBack);
    }

    @Deprecated
    public void getGroupMembersByFilter(String str, long j, TIMGroupMemberRoleFilter tIMGroupMemberRoleFilter, List<String> list, long j2, TIMValueCallBack<TIMGroupMemberSucc> tIMValueCallBack) {
        this.groupBaseManager.getGroupMembersByFilter(str, j, tIMGroupMemberRoleFilter, list, j2, tIMValueCallBack);
    }

    @Deprecated
    public void getSelfInfo(String str, final TIMValueCallBack<TIMGroupSelfInfo> tIMValueCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("TIMGroupManagerExt", "getSelfInfo err, groupId is empty");
            return;
        }
        String loginUser = TIMManager.getInstance().getLoginUser();
        if (TextUtils.isEmpty(loginUser)) {
            QLog.e("TIMGroupManagerExt", "getSelfInfo err, selfId is empty");
            return;
        }
        this.groupBaseManager.getGroupSelfInfo(str, loginUser, new TIMValueCallBack<TIMGroupMemberInfo>() {
            /* class com.tencent.imsdk.ext.group.TIMGroupManagerExt.AnonymousClass4 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                QLog.e("TIMGroupManagerExt", "getSelfInfo err, code = " + i + ", desc = " + str);
                tIMValueCallBack.onError(i, str);
            }

            public void onSuccess(TIMGroupMemberInfo tIMGroupMemberInfo) {
                if (tIMGroupMemberInfo == null) {
                    QLog.e("TIMGroupManagerExt", "getSelfInfo onSuccess but timGroupMemberInfo is null!");
                    return;
                }
                tIMValueCallBack.onSuccess(new TIMGroupSelfInfo(tIMGroupMemberInfo));
            }
        });
    }

    @Deprecated
    public void getGroupPendencyList(TIMGroupPendencyGetParam tIMGroupPendencyGetParam, TIMValueCallBack<TIMGroupPendencyListGetSucc> tIMValueCallBack) {
        this.groupBaseManager.getGroupPendencyList(tIMGroupPendencyGetParam, tIMValueCallBack);
    }

    @Deprecated
    public void reportGroupPendency(long j, TIMCallBack tIMCallBack) {
        this.groupBaseManager.reportGroupPendency(j, tIMCallBack);
    }
}
