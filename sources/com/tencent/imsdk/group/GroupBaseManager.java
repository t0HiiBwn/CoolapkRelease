package com.tencent.imsdk.group;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMGroupEventListener;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupTipsElem;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.conversation.Msg;
import com.tencent.imsdk.ext.group.TIMGroupAVMemberInfo;
import com.tencent.imsdk.ext.group.TIMGroupBaseInfo;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfo;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfoResult;
import com.tencent.imsdk.ext.group.TIMGroupMemberResult;
import com.tencent.imsdk.ext.group.TIMGroupMemberRoleFilter;
import com.tencent.imsdk.ext.group.TIMGroupMemberSucc;
import com.tencent.imsdk.ext.group.TIMGroupPendencyGetParam;
import com.tencent.imsdk.ext.group.TIMGroupPendencyGetType;
import com.tencent.imsdk.ext.group.TIMGroupPendencyHandledStatus;
import com.tencent.imsdk.ext.group.TIMGroupPendencyItem;
import com.tencent.imsdk.ext.group.TIMGroupPendencyListGetSucc;
import com.tencent.imsdk.ext.group.TIMGroupPendencyOperationType;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.BaseManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupBaseManager {
    private static final String TAG = "GroupBaseManager";
    private static final GroupBaseManager instance = new GroupBaseManager();
    private GroupInternalListener groupInternalListener;

    public interface GroupInternalListener {
        void onRecvGroup0x38TipsMessage(Msg msg);

        void onRecvGroupAttribute(String str, Map<String, String> map);
    }

    public interface GroupTypeCallback {
        void onGetGroupType(String str);
    }

    private GroupBaseManager() {
    }

    public static GroupBaseManager getInstance() {
        return instance;
    }

    public void createGroup(TIMGroupManager.CreateGroupParam createGroupParam, TIMValueCallBack tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeCreateGroup(createGroupParam.getGroupType(), createGroupParam.getGroupId(), createGroupParam.getGroupName(), createGroupParam.getNotification(), createGroupParam.getIntroduction(), createGroupParam.getFaceUrl(), createGroupParam.getAddOption() == null ? -1 : createGroupParam.getAddOption().getValue(), createGroupParam.getMaxMemberNum(), createGroupParam.getMembers(), createGroupParam.getCustomInfo(), new ICallback<String>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass1 */

                public void done(String str) {
                    QLog.i("GroupBaseManager", "createGroup success, groupid: " + str);
                    super.done((AnonymousClass1) str);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "createGroup fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void deleteGroup(String str, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeDeleteGroup(str, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass2 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("GroupBaseManager", "deleteGroup success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "deleteGroup fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void applyJoinGroup(String str, String str2, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeJoinGroup(str, str2, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass3 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("GroupBaseManager", "applyJoinGroup success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "applyJoinGroup fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void quitGroup(String str, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeQuitGroup(str, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass4 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("GroupBaseManager", "quitGroup success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "quitGroup fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void deleteGroupMember(TIMGroupManager.DeleteMemberParam deleteMemberParam, TIMValueCallBack<List<TIMGroupMemberResult>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (deleteMemberParam != null && deleteMemberParam.isValid()) {
            GroupNativeManager.nativeDeleteGroupMember(deleteMemberParam.getGroupId(), deleteMemberParam.getMembers(), deleteMemberParam.getReason(), new ICallback<List<TIMGroupMemberResult>>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass5 */

                public void done(List<TIMGroupMemberResult> list) {
                    QLog.i("GroupBaseManager", "deleteGroupMember success");
                    super.done((AnonymousClass5) list);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "deleteGroupMember fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void inviteGroupMember(String str, List<String> list, TIMValueCallBack<List<TIMGroupMemberResult>> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeInviteGroupMember(str, list, "", new ICallback<List<TIMGroupMemberResult>>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass6 */

                public void done(List<TIMGroupMemberResult> list) {
                    QLog.i("GroupBaseManager", "inviteGroupMember success");
                    super.done((AnonymousClass6) list);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "inviteGroupMember fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void getGroupList(TIMValueCallBack<List<TIMGroupBaseInfo>> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeGetJoinedGroups(new ICallback<List<TIMGroupBaseInfo>>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass7 */

                public void done(List<TIMGroupBaseInfo> list) {
                    QLog.i("GroupBaseManager", "getJoinedGroup success");
                    super.done((AnonymousClass7) list);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "getJoinedGroup fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void modifyGroupInfo(TIMGroupManager.ModifyGroupInfoParam modifyGroupInfoParam, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeSetGroupInfo(modifyGroupInfoParam.getFlags(), modifyGroupInfoParam.getGroupId(), modifyGroupInfoParam.getGroupName(), modifyGroupInfoParam.getNotification(), modifyGroupInfoParam.getIntroduction(), modifyGroupInfoParam.getFaceUrl(), modifyGroupInfoParam.getAddOption().getValue(), modifyGroupInfoParam.getMaxMemberNum(), modifyGroupInfoParam.isVisable(), modifyGroupInfoParam.isSearchable(), modifyGroupInfoParam.isSilenceAll(), modifyGroupInfoParam.getCustomInfo(), new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass8 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("GroupBaseManager", "modifyGroupInfo success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "modifyGroupInfo fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void modifyGroupOwner(String str, String str2, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeModifyGroupOwner(str, str2, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass9 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("GroupBaseManager", "modifyGroupOwner success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "modifyGroupOwner fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void getGroupInfo(List<String> list, TIMValueCallBack<List<TIMGroupDetailInfoResult>> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeGetGroupsInfo(list, new ICallback<List<TIMGroupDetailInfoResult>>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass10 */

                public void done(List<TIMGroupDetailInfoResult> list) {
                    QLog.i("GroupBaseManager", "nativeGetGroupsInfo success");
                    super.done((AnonymousClass10) list);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "nativeGetGroupsInfo fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public TIMGroupDetailInfo queryGroupInfo(String str) {
        if (!BaseManager.getInstance().isInited()) {
            QLog.e("GroupBaseManager", "sdk not init");
            return null;
        } else if (!TextUtils.isEmpty(str)) {
            return GroupNativeManager.nativeQueryGroupInfo(str);
        } else {
            QLog.e("GroupBaseManager", "queryGroupInfo, groupId is empty");
            return null;
        }
    }

    public void modifyMemberInfo(TIMGroupManager.ModifyMemberInfoParam modifyMemberInfoParam, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeSetGroupMemberInfo(modifyMemberInfoParam.getFlags(), modifyMemberInfoParam.getGroupId(), modifyMemberInfoParam.getIdentifier(), modifyMemberInfoParam.getNameCard(), modifyMemberInfoParam.getReceiveMessageOpt().getValue(), (long) modifyMemberInfoParam.getRoleType(), modifyMemberInfoParam.getSilence(), modifyMemberInfoParam.getCustomInfo(), new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass11 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("GroupBaseManager", "modifyMemberInfo success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "modifyMemberInfo fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void getGroupMembers(String str, TIMValueCallBack<List<TIMGroupMemberInfo>> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeGetGroupMembers(str, new ICallback<List<TIMGroupMemberInfo>>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass12 */

                public void done(List<TIMGroupMemberInfo> list) {
                    QLog.i("GroupBaseManager", "getGroupMembers success");
                    super.done((AnonymousClass12) list);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "getGroupMembers fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void getGroupMembersInfo(String str, List<String> list, TIMValueCallBack<List<TIMGroupMemberInfo>> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeGetGroupMembersInfo(str, list, new ICallback<List<TIMGroupMemberInfo>>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass13 */

                public void done(List<TIMGroupMemberInfo> list) {
                    QLog.i("GroupBaseManager", "getGroupMembersInfo success");
                    super.done((AnonymousClass13) list);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "getGroupMembers fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void getGroupSelfInfo(String str, String str2, TIMValueCallBack<TIMGroupMemberInfo> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeGetGroupSelfInfo(str, str2, new ICallback<TIMGroupMemberInfo>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass14 */

                public void done(TIMGroupMemberInfo tIMGroupMemberInfo) {
                    QLog.i("GroupBaseManager", "getGroupSelfInfo success");
                    super.done((AnonymousClass14) tIMGroupMemberInfo);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "getGroupSelfInfo fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void getGroupPendencyList(TIMGroupPendencyGetParam tIMGroupPendencyGetParam, TIMValueCallBack<TIMGroupPendencyListGetSucc> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeGetGroupPendencies(tIMGroupPendencyGetParam.getTimestamp(), tIMGroupPendencyGetParam.getNumPerPage(), new ICallback<TIMGroupPendencyListGetSucc>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass15 */

                public void done(TIMGroupPendencyListGetSucc tIMGroupPendencyListGetSucc) {
                    QLog.i("GroupBaseManager", "getGroupPendencyList success");
                    super.done((AnonymousClass15) tIMGroupPendencyListGetSucc);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "getGroupPendencyList fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void reportGroupPendency(long j, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeReportGroupPendencies(j, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass16 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("GroupBaseManager", "reportGroupPendency success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "reportGroupPendency fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void acceptPendency(TIMGroupPendencyItem tIMGroupPendencyItem, String str, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            tIMGroupPendencyItem.setHandledMsg(str);
            GroupNativeManager.nativeAcceptPendency(tIMGroupPendencyItem.getGroupId(), -1, tIMGroupPendencyItem.getFromUser(), -1, tIMGroupPendencyItem.getToUser(), tIMGroupPendencyItem.getAddTime(), (tIMGroupPendencyItem.getPendencyType() == null ? TIMGroupPendencyGetType.APPLY_BY_SELF : tIMGroupPendencyItem.getPendencyType()).getValue(), (tIMGroupPendencyItem.getOperationType() == null ? TIMGroupPendencyOperationType.REFUSE : tIMGroupPendencyItem.getOperationType()).getValue(), (tIMGroupPendencyItem.getHandledStatus() == null ? TIMGroupPendencyHandledStatus.NOT_HANDLED : tIMGroupPendencyItem.getHandledStatus()).getValue(), tIMGroupPendencyItem.getRequestMsg(), tIMGroupPendencyItem.getRequestUserData(), tIMGroupPendencyItem.getHandledMsg(), tIMGroupPendencyItem.getHandledUserData(), tIMGroupPendencyItem.getKey() == null ? null : new String(tIMGroupPendencyItem.getKey()), tIMGroupPendencyItem.getAuth() == null ? null : new String(tIMGroupPendencyItem.getAuth()), tIMGroupPendencyItem.getIdentifer(), tIMGroupPendencyItem.getHandledMsg(), new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass17 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("GroupBaseManager", "acceptPendency success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "acceptPendency fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void refusePendency(TIMGroupPendencyItem tIMGroupPendencyItem, String str, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            tIMGroupPendencyItem.setHandledMsg(str);
            GroupNativeManager.nativeRefusePendency(tIMGroupPendencyItem.getGroupId(), -1, tIMGroupPendencyItem.getFromUser(), -1, tIMGroupPendencyItem.getToUser(), tIMGroupPendencyItem.getAddTime(), (tIMGroupPendencyItem.getPendencyType() == null ? TIMGroupPendencyGetType.APPLY_BY_SELF : tIMGroupPendencyItem.getPendencyType()).getValue(), (tIMGroupPendencyItem.getOperationType() == null ? TIMGroupPendencyOperationType.REFUSE : tIMGroupPendencyItem.getOperationType()).getValue(), (tIMGroupPendencyItem.getHandledStatus() == null ? TIMGroupPendencyHandledStatus.NOT_HANDLED : tIMGroupPendencyItem.getHandledStatus()).getValue(), tIMGroupPendencyItem.getRequestMsg(), tIMGroupPendencyItem.getRequestUserData(), tIMGroupPendencyItem.getHandledMsg(), tIMGroupPendencyItem.getHandledUserData(), tIMGroupPendencyItem.getKey() == null ? null : new String(tIMGroupPendencyItem.getKey()), tIMGroupPendencyItem.getAuth() == null ? null : new String(tIMGroupPendencyItem.getAuth()), tIMGroupPendencyItem.getIdentifer(), tIMGroupPendencyItem.getHandledMsg(), new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass18 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("GroupBaseManager", "refusePendency success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "refusePendency fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void getGroupMembersByFilter(String str, long j, TIMGroupMemberRoleFilter tIMGroupMemberRoleFilter, List<String> list, long j2, TIMValueCallBack<TIMGroupMemberSucc> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeGetGroupMembersByFilter(str, j, tIMGroupMemberRoleFilter.value(), list, j2, new ICallback<TIMGroupMemberSucc>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass19 */

                public void done(TIMGroupMemberSucc tIMGroupMemberSucc) {
                    QLog.v("GroupBaseManager", "nativeGetGroupMembersByFilter success");
                    super.done((AnonymousClass19) tIMGroupMemberSucc);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "nativeGetGroupMembersByFilter err = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void getAVChatRoomMembers(String str, TIMValueCallBack<List<TIMGroupAVMemberInfo>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (!TextUtils.isEmpty(str)) {
            GroupNativeManager.nativeGetAVChatRoomMembers(str, new ICallback<List<TIMGroupAVMemberInfo>>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass20 */

                public void done(List<TIMGroupAVMemberInfo> list) {
                    QLog.v("GroupBaseManager", "nativeGetAVChatRoomMembers success");
                    super.done((AnonymousClass20) list);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "nativeGetAVChatRoomMembers err = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "groupID is empty");
        }
    }

    public void initGroupAttributes(String str, Map<String, String> map, TIMCallBack tIMCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6013, "sdk not init");
            }
        } else if (!TextUtils.isEmpty(str)) {
            GroupNativeManager.nativeInitGroupAttributes(str, map, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass21 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.v("GroupBaseManager", "nativeInitGroupAttributes success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "nativeInitGroupAttributes err = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "groupID is empty");
        }
    }

    public void setGroupAttributes(String str, Map<String, String> map, TIMCallBack tIMCallBack) {
        Log.i("GroupBaseManager", "nativeSetGroupAttributes callBack = " + tIMCallBack);
        if (!BaseManager.getInstance().isInited()) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6013, "sdk not init");
            }
        } else if (!TextUtils.isEmpty(str)) {
            GroupNativeManager.nativeSetGroupAttributes(str, map, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass22 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.v("GroupBaseManager", "nativeSetGroupAttributes success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "nativeSetGroupAttributes err = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "groupID is empty");
        }
    }

    public void deleteGroupAttributes(String str, List<String> list, TIMCallBack tIMCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6013, "sdk not init");
            }
        } else if (!TextUtils.isEmpty(str)) {
            GroupNativeManager.nativeDeleteGroupAttributes(str, list, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass23 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.v("GroupBaseManager", "nativeDeleteGroupAttributes success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "nativeDeleteGroupAttributes err = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "groupID is empty");
        }
    }

    public void getGroupAttributes(String str, List<String> list, TIMValueCallBack<Map<String, String>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (!TextUtils.isEmpty(str)) {
            GroupNativeManager.nativeGetGroupAttributes(str, list, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass24 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.v("GroupBaseManager", "nativeGetGroupAttributes success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "nativeGetGroupAttributes err = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "groupID is empty");
        }
    }

    public void getGroupOnlineMemberCount(String str, TIMValueCallBack<Integer> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            GroupNativeManager.nativeGetGroupOnlineMemberCount(str, new ICallback<Integer>(tIMValueCallBack) {
                /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass25 */

                public void done(Integer num) {
                    QLog.i("GroupBaseManager", "nativeGetGroupOnlineMemberCount success");
                    super.done((AnonymousClass25) num);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("GroupBaseManager", "nativeGetGroupOnlineMemberCount fail: " + i + ":" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void getGroupsType(String str, final GroupTypeCallback groupTypeCallback) {
        if (!TextUtils.isEmpty(str) && groupTypeCallback != null) {
            TIMGroupDetailInfo queryGroupInfo = TIMGroupManager.getInstance().queryGroupInfo(str);
            if (queryGroupInfo == null || TextUtils.isEmpty(queryGroupInfo.getGroupType())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                TIMGroupManager.getInstance().getGroupInfo(arrayList, new TIMValueCallBack<List<TIMGroupDetailInfoResult>>() {
                    /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass26 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        QLog.e("GroupBaseManager", "getGroupsType failed, code = " + i + ", desc = " + str);
                        groupTypeCallback.onGetGroupType("");
                    }

                    public void onSuccess(List<TIMGroupDetailInfoResult> list) {
                        if (list == null || list.size() == 0) {
                            QLog.e("GroupBaseManager", "getGroupsType, getGroupInfo timGroupDetailInfoResults is empty");
                        } else {
                            groupTypeCallback.onGetGroupType(list.get(0).getGroupType());
                        }
                    }
                });
                return;
            }
            groupTypeCallback.onGetGroupType(queryGroupInfo.getGroupType());
        }
    }

    public void initGroupModule() {
        GroupNativeManager.nativeSetGroupListener(new GroupListener() {
            /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass27 */

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupTipsEvent(final TIMGroupTipsElem tIMGroupTipsElem) {
                final TIMGroupEventListener groupEventListener = TIMManager.getInstance().getUserConfig().getGroupEventListener();
                if (groupEventListener != null) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.group.GroupBaseManager.AnonymousClass27.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            groupEventListener.onGroupTipsEvent(tIMGroupTipsElem);
                        }
                    });
                } else {
                    QLog.i("GroupBaseManager", "no group event listener found");
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onRecvGroup0x38TipsMessage(Msg msg) {
                if (GroupBaseManager.this.groupInternalListener != null) {
                    GroupBaseManager.this.groupInternalListener.onRecvGroup0x38TipsMessage(msg);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupAttributeChanged(String str, Map<String, String> map) {
                if (GroupBaseManager.this.groupInternalListener != null) {
                    GroupBaseManager.this.groupInternalListener.onRecvGroupAttribute(str, map);
                }
            }
        });
    }

    public void setGroupInternalListener(GroupInternalListener groupInternalListener2) {
        this.groupInternalListener = groupInternalListener2;
    }
}
