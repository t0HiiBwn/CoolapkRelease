package com.tencent.imsdk.v2;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupReceiveMessageOpt;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.ext.group.TIMGroupAVMemberInfo;
import com.tencent.imsdk.ext.group.TIMGroupBaseInfo;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfo;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfoResult;
import com.tencent.imsdk.ext.group.TIMGroupMemberResult;
import com.tencent.imsdk.ext.group.TIMGroupMemberRoleFilter;
import com.tencent.imsdk.ext.group.TIMGroupMemberSucc;
import com.tencent.imsdk.ext.group.TIMGroupPendencyGetParam;
import com.tencent.imsdk.ext.group.TIMGroupPendencyItem;
import com.tencent.imsdk.ext.group.TIMGroupPendencyListGetSucc;
import com.tencent.imsdk.ext.group.TIMGroupPendencyMeta;
import com.tencent.imsdk.friendship.FriendshipNativeManager;
import com.tencent.imsdk.group.GroupBaseManager;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V2TIMGroupManagerImpl extends V2TIMGroupManager {
    private final String TAG;

    private static class V2TIMGroupManagerImplHolder {
        private static final V2TIMGroupManagerImpl v2TIMGroupManagerImpl = new V2TIMGroupManagerImpl();

        private V2TIMGroupManagerImplHolder() {
        }
    }

    static V2TIMGroupManagerImpl getInstance() {
        return V2TIMGroupManagerImplHolder.v2TIMGroupManagerImpl;
    }

    private V2TIMGroupManagerImpl() {
        this.TAG = "V2TIMAdvGroupMgrImpl";
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void createGroup(V2TIMGroupInfo v2TIMGroupInfo, List<V2TIMCreateGroupMemberInfo> list, final V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMGroupInfo != null) {
            TIMGroupManager.CreateGroupParam createGroupParam = v2TIMGroupInfo.getCreateGroupParam();
            if (createGroupParam != null) {
                ArrayList arrayList = null;
                if (list != null) {
                    for (V2TIMCreateGroupMemberInfo v2TIMCreateGroupMemberInfo : list) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        TIMGroupMemberInfo tIMGroupMemberInfo = new TIMGroupMemberInfo(v2TIMCreateGroupMemberInfo.getUserID());
                        tIMGroupMemberInfo.setRole(v2TIMCreateGroupMemberInfo.getRole());
                        arrayList.add(tIMGroupMemberInfo);
                    }
                }
                createGroupParam.setMembers(arrayList);
                TIMGroupManager.getInstance().createGroup(createGroupParam, new TIMValueCallBack<String>() {
                    /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass1 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(i, str);
                        }
                    }

                    public void onSuccess(String str) {
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onSuccess(str);
                        }
                    }
                });
            } else if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "info->createGroupParam is null");
            }
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "info is null");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupsInfo(List<String> list, final V2TIMValueCallback<List<V2TIMGroupInfoResult>> v2TIMValueCallback) {
        TIMGroupManager.getInstance().getGroupInfo(list, new TIMValueCallBack<List<TIMGroupDetailInfoResult>>() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass2 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMGroupDetailInfoResult> list) {
                if (v2TIMValueCallback != null) {
                    if (list == null || list.size() == 0) {
                        v2TIMValueCallback.onSuccess(null);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (TIMGroupDetailInfoResult tIMGroupDetailInfoResult : list) {
                        V2TIMGroupInfoResult v2TIMGroupInfoResult = new V2TIMGroupInfoResult();
                        v2TIMGroupInfoResult.setTimGroupDetailInfoResult(tIMGroupDetailInfoResult);
                        arrayList.add(v2TIMGroupInfoResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupInfo(V2TIMGroupInfo v2TIMGroupInfo, final V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupInfo == null) {
            QLog.e("V2TIMAdvGroupMgrImpl", "setGroupInfo error, info is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "info is empty");
                return;
            }
            return;
        }
        TIMGroupManager.getInstance().modifyGroupInfo(v2TIMGroupInfo.getModifyGroupInfoParam(), new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass3 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void initGroupAttributes(String str, HashMap<String, String> hashMap, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMAdvGroupMgrImpl", "initGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        GroupBaseManager.getInstance().initGroupAttributes(str, hashMap, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass4 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupAttributes(String str, HashMap<String, String> hashMap, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMAdvGroupMgrImpl", "setGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
            }
        } else if (hashMap == null || hashMap.size() == 0) {
            QLog.e("V2TIMAdvGroupMgrImpl", "setGroupAttributes error, attributes is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "attributes is empty");
            }
        } else {
            GroupBaseManager.getInstance().setGroupAttributes(str, hashMap, new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass5 */

                @Override // com.tencent.imsdk.TIMCallBack
                public void onError(int i, String str) {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.TIMCallBack
                public void onSuccess() {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onSuccess();
                    }
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void deleteGroupAttributes(String str, List<String> list, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMAdvGroupMgrImpl", "deleteGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        GroupBaseManager.getInstance().deleteGroupAttributes(str, list, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass6 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupAttributes(String str, List<String> list, final V2TIMValueCallback<Map<String, String>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMAdvGroupMgrImpl", "getGroupAttributes error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        GroupBaseManager.getInstance().getGroupAttributes(str, list, new TIMValueCallBack<Map<String, String>>() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass7 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(Map<String, String> map) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onSuccess(map);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupOnlineMemberCount(String str, final V2TIMValueCallback<Integer> v2TIMValueCallback) {
        TIMGroupManager.getInstance().getGroupOnlineMemberCount(str, new TIMValueCallBack<Integer>() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass8 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(Integer num) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onSuccess(num);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setReceiveMessageOpt(String str, int i, final V2TIMCallback v2TIMCallback) {
        TIMGroupReceiveMessageOpt tIMGroupReceiveMessageOpt;
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMAdvGroupMgrImpl", "setReceiveMessageOpt err, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        if (i == 0) {
            tIMGroupReceiveMessageOpt = TIMGroupReceiveMessageOpt.ReceiveAndNotify;
        } else if (i == 1) {
            tIMGroupReceiveMessageOpt = TIMGroupReceiveMessageOpt.NotReceive;
        } else if (i == 2) {
            tIMGroupReceiveMessageOpt = TIMGroupReceiveMessageOpt.ReceiveNotNotify;
        } else {
            QLog.e("V2TIMAdvGroupMgrImpl", "setReceiveMessageOpt error opt = " + i);
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "opt is error");
                return;
            }
            return;
        }
        TIMGroupManager.ModifyMemberInfoParam modifyMemberInfoParam = new TIMGroupManager.ModifyMemberInfoParam(str, V2TIMManagerImpl.getInstance().getLoginUser());
        modifyMemberInfoParam.setReceiveMessageOpt(tIMGroupReceiveMessageOpt);
        TIMGroupManager.getInstance().modifyMemberInfo(modifyMemberInfoParam, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass9 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupMemberList(final String str, final int i, final long j, final V2TIMValueCallback<V2TIMGroupMemberInfoResult> v2TIMValueCallback) {
        final TIMGroupMemberRoleFilter tIMGroupMemberRoleFilter;
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMAdvGroupMgrImpl", "getGroupMemberList error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        if (i == 1) {
            tIMGroupMemberRoleFilter = TIMGroupMemberRoleFilter.Owner;
        } else if (i == 2) {
            tIMGroupMemberRoleFilter = TIMGroupMemberRoleFilter.Admin;
        } else if (i != 4) {
            tIMGroupMemberRoleFilter = TIMGroupMemberRoleFilter.All;
        } else {
            tIMGroupMemberRoleFilter = TIMGroupMemberRoleFilter.Normal;
        }
        GroupBaseManager.getInstance().getGroupsType(str, new GroupBaseManager.GroupTypeCallback() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass10 */

            @Override // com.tencent.imsdk.group.GroupBaseManager.GroupTypeCallback
            public void onGetGroupType(String str) {
                String str2;
                if (str.equals("AVChatRoom")) {
                    TIMGroupDetailInfo queryGroupInfo = TIMGroupManager.getInstance().queryGroupInfo(str);
                    if (queryGroupInfo == null) {
                        str2 = "";
                    } else {
                        str2 = queryGroupInfo.getGroupOwner();
                    }
                    int i = i;
                    if (i == 0) {
                        getAVMembers(str2, true);
                    } else if (i == 1) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str2);
                        TIMGroupManager.getInstance().getGroupMembersInfo(str, arrayList, new TIMValueCallBack<List<TIMGroupMemberInfo>>() {
                            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass10.AnonymousClass1 */

                            @Override // com.tencent.imsdk.TIMValueCallBack
                            public void onError(int i, String str) {
                                if (v2TIMValueCallback != null) {
                                    v2TIMValueCallback.onError(i, str);
                                }
                            }

                            public void onSuccess(List<TIMGroupMemberInfo> list) {
                                V2TIMGroupManagerImpl.this.getV2MemberInfos(list, new V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>>() {
                                    /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass10.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                                    public void onError(int i, String str) {
                                        if (v2TIMValueCallback != null) {
                                            v2TIMValueCallback.onError(i, str);
                                        }
                                    }

                                    public void onSuccess(List<V2TIMGroupMemberFullInfo> list) {
                                        if (v2TIMValueCallback != null) {
                                            v2TIMValueCallback.onSuccess(new V2TIMGroupMemberInfoResult(0, list));
                                        }
                                    }
                                });
                            }
                        });
                    } else if (i == 2) {
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(6017, "AVChatRoom not support admin role");
                        }
                    } else if (i == 4) {
                        getAVMembers(str2, false);
                    }
                } else {
                    TIMGroupManager.getInstance().getGroupMembersByFilter(str, 59, tIMGroupMemberRoleFilter, null, j, new TIMValueCallBack<TIMGroupMemberSucc>() {
                        /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass10.AnonymousClass2 */

                        @Override // com.tencent.imsdk.TIMValueCallBack
                        public void onError(int i, String str) {
                            if (v2TIMValueCallback != null) {
                                v2TIMValueCallback.onError(i, str);
                            }
                        }

                        public void onSuccess(final TIMGroupMemberSucc tIMGroupMemberSucc) {
                            V2TIMGroupManagerImpl.this.getV2MemberInfos(tIMGroupMemberSucc.getMemberInfoList(), new V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>>() {
                                /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass10.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                                public void onError(int i, String str) {
                                    if (v2TIMValueCallback != null) {
                                        v2TIMValueCallback.onError(i, str);
                                    }
                                }

                                public void onSuccess(List<V2TIMGroupMemberFullInfo> list) {
                                    if (v2TIMValueCallback != null) {
                                        v2TIMValueCallback.onSuccess(new V2TIMGroupMemberInfoResult(tIMGroupMemberSucc.getNextSeq(), list));
                                    }
                                }
                            });
                        }
                    });
                }
            }

            private void getAVMembers(final String str, final boolean z) {
                GroupBaseManager.getInstance().getAVChatRoomMembers(str, new TIMValueCallBack<List<TIMGroupAVMemberInfo>>() {
                    /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass10.AnonymousClass3 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(i, str);
                        }
                    }

                    public void onSuccess(List<TIMGroupAVMemberInfo> list) {
                        final ArrayList arrayList = new ArrayList();
                        boolean z = false;
                        for (TIMGroupAVMemberInfo tIMGroupAVMemberInfo : list) {
                            if (tIMGroupAVMemberInfo.getUserID().equals(str)) {
                                z = true;
                                if (z) {
                                    tIMGroupAVMemberInfo.setRole(400);
                                    V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                                    v2TIMGroupMemberFullInfo.setTimGroupAVMemberInfo(tIMGroupAVMemberInfo);
                                    arrayList.add(v2TIMGroupMemberFullInfo);
                                }
                            } else {
                                tIMGroupAVMemberInfo.setRole(200);
                                V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo2 = new V2TIMGroupMemberFullInfo();
                                v2TIMGroupMemberFullInfo2.setTimGroupAVMemberInfo(tIMGroupAVMemberInfo);
                                arrayList.add(v2TIMGroupMemberFullInfo2);
                            }
                        }
                        if (z && !z) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(str);
                            TIMGroupManager.getInstance().getGroupMembersInfo(str, arrayList2, new TIMValueCallBack<List<TIMGroupMemberInfo>>() {
                                /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass10.AnonymousClass3.AnonymousClass1 */

                                @Override // com.tencent.imsdk.TIMValueCallBack
                                public void onError(int i, String str) {
                                    if (v2TIMValueCallback != null) {
                                        v2TIMValueCallback.onError(i, str);
                                    }
                                }

                                public void onSuccess(List<TIMGroupMemberInfo> list) {
                                    V2TIMGroupManagerImpl.this.getV2MemberInfos(list, new V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>>() {
                                        /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass10.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                                        public void onError(int i, String str) {
                                            if (v2TIMValueCallback != null) {
                                                v2TIMValueCallback.onError(i, str);
                                            }
                                        }

                                        public void onSuccess(List<V2TIMGroupMemberFullInfo> list) {
                                            if (v2TIMValueCallback != null) {
                                                if (list.size() > 0) {
                                                    arrayList.add(0, list.get(0));
                                                }
                                                v2TIMValueCallback.onSuccess(new V2TIMGroupMemberInfoResult(0, arrayList));
                                            }
                                        }
                                    });
                                }
                            });
                        } else if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onSuccess(new V2TIMGroupMemberInfoResult(0, arrayList));
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void getV2MemberInfos(final List<TIMGroupMemberInfo> list, final V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>> v2TIMValueCallback) {
        ArrayList arrayList = new ArrayList();
        for (TIMGroupMemberInfo tIMGroupMemberInfo : list) {
            arrayList.add(tIMGroupMemberInfo.getUser());
        }
        if (arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("Tag_Profile_IM_Nick");
            arrayList2.add("Tag_Profile_IM_Image");
            FriendshipNativeManager.nativeGetUsersProfile(arrayList, false, arrayList2, new ICallback(new TIMValueCallBack<List<TIMUserProfile>>() {
                /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass11 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("V2TIMAdvGroupMgrImpl", "getGroupMemberList->GetUsersProfile error = " + i + ", desc = " + str);
                    v2TIMValueCallback.onError(i, str);
                }

                public void onSuccess(List<TIMUserProfile> list) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMGroupMemberInfo tIMGroupMemberInfo : list) {
                        for (TIMUserProfile tIMUserProfile : list) {
                            if (tIMGroupMemberInfo.getUser().equals(tIMUserProfile.getIdentifier())) {
                                V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                                v2TIMGroupMemberFullInfo.setTimGroupMemberInfo(tIMGroupMemberInfo);
                                v2TIMGroupMemberFullInfo.setTimUserProfile(tIMUserProfile);
                                arrayList.add(v2TIMGroupMemberFullInfo);
                            }
                        }
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }) {
                /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass12 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onSuccess(new ArrayList());
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupMembersInfo(String str, List<String> list, final V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            QLog.e("V2TIMAdvGroupMgrImpl", "getGroupMembersInfo fail, memberList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "memberList is empty");
            }
        } else if (TextUtils.isEmpty(V2TIMManagerImpl.getInstance().getLoginUser())) {
            QLog.e("V2TIMAdvGroupMgrImpl", "getGroupMemberInfo, selfID is empty, maybe not login");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6014, "selfID is empty");
            }
        } else {
            TIMGroupManager.getInstance().getGroupMembersInfo(str, list, new TIMValueCallBack<List<TIMGroupMemberInfo>>() {
                /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass13 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(List<TIMGroupMemberInfo> list) {
                    V2TIMGroupManagerImpl.this.getV2MemberInfos(list, new V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>>() {
                        /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass13.AnonymousClass1 */

                        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                        public void onError(int i, String str) {
                            if (v2TIMValueCallback != null) {
                                v2TIMValueCallback.onError(i, str);
                            }
                            QLog.e("V2TIMAdvGroupMgrImpl", "getGroupMemberInfo->getV2MemberInfos error:" + i + ", desc:" + str);
                        }

                        public void onSuccess(List<V2TIMGroupMemberFullInfo> list) {
                            if (v2TIMValueCallback != null) {
                                v2TIMValueCallback.onSuccess(list);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupMemberInfo(String str, V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str) || v2TIMGroupMemberFullInfo == null) {
            QLog.e("V2TIMAdvGroupMgrImpl", "setGroupMemberInfo error, groupID is empty or profile is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty or profile is null");
                return;
            }
            return;
        }
        TIMGroupManager.ModifyMemberInfoParam modifyMemberInfoParam = v2TIMGroupMemberFullInfo.getModifyMemberInfoParam();
        if (modifyMemberInfoParam == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "setGroupMemberInfo->modifyMemberInfoParam is null");
            }
            QLog.e("V2TIMAdvGroupMgrImpl", "setGroupMemberInfo->modifyMemberInfoParam is null");
            return;
        }
        modifyMemberInfoParam.setGroupId(str);
        TIMGroupManager.getInstance().modifyMemberInfo(modifyMemberInfoParam, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass14 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void muteGroupMember(String str, String str2, int i, final V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            TIMGroupManager.ModifyMemberInfoParam modifyMemberInfoParam = new TIMGroupManager.ModifyMemberInfoParam(str, str2);
            modifyMemberInfoParam.setSilence((long) i);
            TIMGroupManager.getInstance().modifyMemberInfo(modifyMemberInfoParam, new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass15 */

                @Override // com.tencent.imsdk.TIMCallBack
                public void onError(int i, String str) {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.TIMCallBack
                public void onSuccess() {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onSuccess();
                    }
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "groupID or userID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void inviteUserToGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            QLog.e("V2TIMAdvGroupMgrImpl", "inviteUserToGroup error, groupID or userList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID or userList is empty");
                return;
            }
            return;
        }
        TIMGroupManager.getInstance().inviteGroupMember(str, list, new TIMValueCallBack<List<TIMGroupMemberResult>>() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass16 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMGroupMemberResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMGroupMemberResult tIMGroupMemberResult : list) {
                        V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                        v2TIMGroupMemberOperationResult.setTimGroupMemberResult(tIMGroupMemberResult);
                        arrayList.add(v2TIMGroupMemberOperationResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void kickGroupMember(String str, List<String> list, String str2, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            QLog.e("V2TIMAdvGroupMgrImpl", "kickGroupMember error, groupID or memberList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID or memberList is empty");
                return;
            }
            return;
        }
        TIMGroupManager.DeleteMemberParam deleteMemberParam = new TIMGroupManager.DeleteMemberParam(str, list);
        deleteMemberParam.setReason(str2);
        TIMGroupManager.getInstance().deleteGroupMember(deleteMemberParam, new TIMValueCallBack<List<TIMGroupMemberResult>>() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass17 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMGroupMemberResult> list) {
                if (v2TIMValueCallback == null) {
                    return;
                }
                if (list.size() == 0) {
                    v2TIMValueCallback.onSuccess(null);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (TIMGroupMemberResult tIMGroupMemberResult : list) {
                    V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                    v2TIMGroupMemberOperationResult.setTimGroupMemberResult(tIMGroupMemberResult);
                    arrayList.add(v2TIMGroupMemberOperationResult);
                }
                v2TIMValueCallback.onSuccess(arrayList);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupMemberRole(String str, String str2, int i, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            QLog.e("V2TIMAdvGroupMgrImpl", "setGroupMemberRole error, groupID or userID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID or userID is empty");
                return;
            }
            return;
        }
        TIMGroupManager.ModifyMemberInfoParam modifyMemberInfoParam = new TIMGroupManager.ModifyMemberInfoParam(str, str2);
        modifyMemberInfoParam.setRoleType(i);
        TIMGroupManager.getInstance().modifyMemberInfo(modifyMemberInfoParam, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass18 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void transferGroupOwner(String str, String str2, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            QLog.e("V2TIMAdvGroupMgrImpl", "transferGroupOwner error, groupID or userID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID or userID is empty");
                return;
            }
            return;
        }
        TIMGroupManager.getInstance().modifyGroupOwner(str, str2, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass19 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getJoinedGroupList(final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        TIMGroupManager.getInstance().getGroupList(new TIMValueCallBack<List<TIMGroupBaseInfo>>() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass20 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMGroupBaseInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMGroupBaseInfo tIMGroupBaseInfo : list) {
                        Log.e("V2TIMAdvGroupMgrImpl", "test: getJoinedGroupList :" + tIMGroupBaseInfo.toString() + "\n");
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setTIMGroupBaseInfo(tIMGroupBaseInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupApplicationList(final V2TIMValueCallback<V2TIMGroupApplicationResult> v2TIMValueCallback) {
        V2TIMGroupApplicationResult v2TIMGroupApplicationResult = new V2TIMGroupApplicationResult();
        TIMGroupPendencyGetParam tIMGroupPendencyGetParam = new TIMGroupPendencyGetParam();
        tIMGroupPendencyGetParam.setTimestamp(0);
        tIMGroupPendencyGetParam.setNumPerPage(10);
        getV1GroupPendencyList(tIMGroupPendencyGetParam, v2TIMGroupApplicationResult, new V2TIMValueCallback<V2TIMGroupApplicationResult>() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass21 */

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                QLog.e("V2TIMAdvGroupMgrImpl", "getGroupApplicationList, error = " + i + ", desc = " + str);
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(final V2TIMGroupApplicationResult v2TIMGroupApplicationResult) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMGroupApplication v2TIMGroupApplication : v2TIMGroupApplicationResult.getGroupApplicationList()) {
                    arrayList.add(v2TIMGroupApplication.getFromUser());
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("Tag_Profile_IM_Nick");
                arrayList2.add("Tag_Profile_IM_Image");
                FriendshipNativeManager.nativeGetUsersProfile(arrayList, true, arrayList2, new ICallback(new TIMValueCallBack<List<TIMUserProfile>>() {
                    /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass21.AnonymousClass1 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        QLog.e("V2TIMAdvGroupMgrImpl", "getGroupApplicationList->GetUsersProfile error = " + i + ", desc = " + str);
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(i, str);
                        }
                    }

                    public void onSuccess(List<TIMUserProfile> list) {
                        for (V2TIMGroupApplication v2TIMGroupApplication : v2TIMGroupApplicationResult.getGroupApplicationList()) {
                            for (TIMUserProfile tIMUserProfile : list) {
                                if (v2TIMGroupApplication.getFromUser().equals(tIMUserProfile.getIdentifier())) {
                                    v2TIMGroupApplication.setTIMUserProfile(tIMUserProfile);
                                }
                            }
                        }
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onSuccess(v2TIMGroupApplicationResult);
                        }
                    }
                }) {
                    /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass21.AnonymousClass2 */

                    @Override // com.tencent.imsdk.common.ICallback
                    public void done(Object obj) {
                        super.done(obj);
                    }

                    @Override // com.tencent.imsdk.common.ICallback
                    public void fail(int i, String str) {
                        super.fail(i, str);
                    }
                });
            }
        });
    }

    public void getV1GroupPendencyList(TIMGroupPendencyGetParam tIMGroupPendencyGetParam, final V2TIMGroupApplicationResult v2TIMGroupApplicationResult, final V2TIMValueCallback<V2TIMGroupApplicationResult> v2TIMValueCallback) {
        TIMGroupManager.getInstance().getGroupPendencyList(tIMGroupPendencyGetParam, new TIMValueCallBack<TIMGroupPendencyListGetSucc>() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass22 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(TIMGroupPendencyListGetSucc tIMGroupPendencyListGetSucc) {
                TIMGroupPendencyMeta pendencyMeta = tIMGroupPendencyListGetSucc.getPendencyMeta();
                v2TIMGroupApplicationResult.setUnreadCount(v2TIMGroupApplicationResult.getUnreadCount());
                for (TIMGroupPendencyItem tIMGroupPendencyItem : tIMGroupPendencyListGetSucc.getPendencies()) {
                    V2TIMGroupApplication v2TIMGroupApplication = new V2TIMGroupApplication();
                    v2TIMGroupApplication.setTIMGroupPendencyItem(tIMGroupPendencyItem);
                    v2TIMGroupApplicationResult.getGroupApplicationList().add(v2TIMGroupApplication);
                }
                if (pendencyMeta.getNextStartTimestamp() == 0) {
                    v2TIMGroupApplicationResult.setReportedTimestamp(pendencyMeta.getReportedTimestamp());
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(v2TIMGroupApplicationResult);
                        return;
                    }
                    return;
                }
                TIMGroupPendencyGetParam tIMGroupPendencyGetParam = new TIMGroupPendencyGetParam();
                tIMGroupPendencyGetParam.setTimestamp(pendencyMeta.getNextStartTimestamp());
                tIMGroupPendencyGetParam.setNumPerPage(10);
                V2TIMGroupManagerImpl.this.getV1GroupPendencyList(tIMGroupPendencyGetParam, v2TIMGroupApplicationResult, v2TIMValueCallback);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void acceptGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, final V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupApplication == null || v2TIMGroupApplication.getTIMGroupPendencyItem() == null) {
            QLog.e("V2TIMAdvGroupMgrImpl", "acceptGroupApplication err, v2TIMGroupApplication or TIMGroupPendencyItem is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "v2TIMGroupApplication or TIMGroupPendencyItem is null");
                return;
            }
            return;
        }
        v2TIMGroupApplication.getTIMGroupPendencyItem().accept(str, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass23 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void refuseGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, final V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupApplication == null || v2TIMGroupApplication.getTIMGroupPendencyItem() == null) {
            QLog.e("V2TIMAdvGroupMgrImpl", "acceptGroupApplication err, v2TIMGroupApplication or TIMGroupPendencyItem is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "v2TIMGroupApplication or TIMGroupPendencyItem is null");
                return;
            }
            return;
        }
        v2TIMGroupApplication.getTIMGroupPendencyItem().refuse(str, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass24 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupApplicationRead(final V2TIMCallback v2TIMCallback) {
        TIMGroupManager.getInstance().reportGroupPendency(System.currentTimeMillis() / 1000, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMGroupManagerImpl.AnonymousClass25 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }
}
