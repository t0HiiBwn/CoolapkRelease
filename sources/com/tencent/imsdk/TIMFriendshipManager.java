package com.tencent.imsdk;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.friendship.FriendshipNativeManager;
import com.tencent.imsdk.friendship.TIMCheckFriendResult;
import com.tencent.imsdk.friendship.TIMFriend;
import com.tencent.imsdk.friendship.TIMFriendCheckInfo;
import com.tencent.imsdk.friendship.TIMFriendGetResult;
import com.tencent.imsdk.friendship.TIMFriendGroup;
import com.tencent.imsdk.friendship.TIMFriendPendencyInfo;
import com.tencent.imsdk.friendship.TIMFriendPendencyRequest;
import com.tencent.imsdk.friendship.TIMFriendPendencyResponse;
import com.tencent.imsdk.friendship.TIMFriendRequest;
import com.tencent.imsdk.friendship.TIMFriendResponse;
import com.tencent.imsdk.friendship.TIMFriendResult;
import com.tencent.imsdk.friendship.TIMFriendshipListener;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.BaseManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TIMFriendshipManager {
    private static final String TAG = "TIMFriendshipManager";

    private TIMFriendshipManager() {
    }

    private static class TIMFriendshipManagerHolder {
        private static final TIMFriendshipManager mTIMFriendshipManager = new TIMFriendshipManager();

        private TIMFriendshipManagerHolder() {
        }
    }

    public static TIMFriendshipManager getInstance() {
        return TIMFriendshipManagerHolder.mTIMFriendshipManager;
    }

    public void init() {
        setFriendshipListenerInternal();
    }

    private void setFriendshipListenerInternal() {
        FriendshipNativeManager.nativeSetFriendshipListener(new TIMFriendshipListener() {
            /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass1 */

            @Override // com.tencent.imsdk.friendship.TIMFriendshipListener
            public void onAddFriends(List<String> list) {
                QLog.i("TIMFriendshipManager", "this is onAddFriends");
                final TIMFriendshipListener friendshipListener = TIMManager.getInstance().getUserConfig().getFriendshipListener();
                if (friendshipListener == null) {
                    QLog.e("TIMFriendshipManager", "onAddFriends, no TIMFriendshipListener found");
                    return;
                }
                final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass1.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        friendshipListener.onAddFriends(copyOnWriteArrayList);
                    }
                });
            }

            @Override // com.tencent.imsdk.friendship.TIMFriendshipListener
            public void onDelFriends(List<String> list) {
                QLog.i("TIMFriendshipManager", "this is onDelFriends");
                final TIMFriendshipListener friendshipListener = TIMManager.getInstance().getUserConfig().getFriendshipListener();
                if (friendshipListener == null) {
                    QLog.e("TIMFriendshipManager", "onDelFriends, no TIMFriendshipListener found");
                    return;
                }
                final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass1.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        friendshipListener.onDelFriends(copyOnWriteArrayList);
                    }
                });
            }

            @Override // com.tencent.imsdk.friendship.TIMFriendshipListener
            public void onFriendProfileUpdate(List<TIMSNSChangeInfo> list) {
                QLog.i("TIMFriendshipManager", "this is onFriendProfileUpdate");
                final TIMFriendshipListener friendshipListener = TIMManager.getInstance().getUserConfig().getFriendshipListener();
                if (friendshipListener == null) {
                    QLog.e("TIMFriendshipManager", "onFriendProfileUpdate, no TIMFriendshipListener found");
                    return;
                }
                final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass1.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        friendshipListener.onFriendProfileUpdate(copyOnWriteArrayList);
                    }
                });
            }

            @Override // com.tencent.imsdk.friendship.TIMFriendshipListener
            public void onAddFriendReqs(List<TIMFriendPendencyInfo> list) {
                QLog.i("TIMFriendshipManager", "this is onAddFriendReqs");
                final TIMFriendshipListener friendshipListener = TIMManager.getInstance().getUserConfig().getFriendshipListener();
                if (friendshipListener == null) {
                    QLog.e("TIMFriendshipManager", "onAddFriendReqs, no TIMFriendshipListener found");
                    return;
                }
                final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass1.AnonymousClass4 */

                    @Override // java.lang.Runnable
                    public void run() {
                        friendshipListener.onAddFriendReqs(copyOnWriteArrayList);
                    }
                });
            }
        });
    }

    public void getUsersProfile(List<String> list, boolean z, TIMValueCallBack<List<TIMUserProfile>> tIMValueCallBack) {
        QLog.i("TIMFriendshipManager", "getUsersProfile called");
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (list == null || list.isEmpty()) {
            QLog.e("TIMFriendshipManager", "getUsersProfile, identifiers is null or empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "identifiers is empty");
            }
        } else {
            FriendshipNativeManager.nativeGetUsersProfile(list, z, null, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass2 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "getUsersProfile success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.i("TIMFriendshipManager", "getUsersProfile fail = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public int getSelfProfile(final TIMValueCallBack<TIMUserProfile> tIMValueCallBack) {
        QLog.i("TIMFriendshipManager", "getSelfProfile called");
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
            return 6013;
        }
        String loginUser = TIMManager.getInstance().getLoginUser();
        if (!TextUtils.isEmpty(loginUser)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(loginUser);
            getUsersProfile(arrayList, true, new TIMValueCallBack<List<TIMUserProfile>>() {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass3 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    TIMValueCallBack tIMValueCallBack = tIMValueCallBack;
                    if (tIMValueCallBack != null) {
                        tIMValueCallBack.onError(i, str);
                    }
                }

                public void onSuccess(List<TIMUserProfile> list) {
                    TIMValueCallBack tIMValueCallBack = tIMValueCallBack;
                    if (tIMValueCallBack != null) {
                        tIMValueCallBack.onSuccess(list.get(0));
                    }
                }
            });
            return 0;
        } else if (tIMValueCallBack == null) {
            return -1;
        } else {
            tIMValueCallBack.onError(6017, "maybe not login");
            return -1;
        }
    }

    public TIMUserProfile querySelfProfile() {
        if (!BaseManager.getInstance().isInited()) {
            Log.e("TIMFriendshipManager", "querySelfProfile error, sdk not init");
            return null;
        }
        String loginUser = TIMManager.getInstance().getLoginUser();
        if (!TextUtils.isEmpty(loginUser)) {
            return queryUserProfile(loginUser);
        }
        QLog.e("TIMFriendshipManager", "querySelfProfile, maybe not login");
        return null;
    }

    public TIMUserProfile queryUserProfile(String str) {
        if (!BaseManager.getInstance().isInited()) {
            Log.e("TIMFriendshipManager", "queryUserProfile error, sdk not init");
            return null;
        } else if (!TextUtils.isEmpty(str)) {
            return FriendshipNativeManager.nativeQueryUserProfile(str);
        } else {
            QLog.e("TIMFriendshipManager", "queryUserProfile identifier is empty!");
            return null;
        }
    }

    public void modifySelfProfile(HashMap<String, Object> hashMap, TIMCallBack tIMCallBack) {
        QLog.i("TIMFriendshipManager", "modifySelfProfile called");
        if (!BaseManager.getInstance().isInited()) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6013, "sdk not init");
            }
        } else if (hashMap == null || hashMap.size() <= 0) {
            QLog.e("TIMFriendshipManager", "modifySelfProfile, profileMap is null or empty");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "profileMap is empty");
            }
        } else {
            FriendshipNativeManager.nativeModifySelfProfile(hashMap, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass4 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "modifySelfProfile success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "modifySelfProfile fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void getFriendList(TIMValueCallBack<List<TIMFriend>> tIMValueCallBack) {
        QLog.i("TIMFriendshipManager", "getFriendList called");
        if (BaseManager.getInstance().isInited()) {
            FriendshipNativeManager.nativeGetFriendList(new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass5 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "getFriendList success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "getFriendList fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void getFriendList(List<String> list, TIMValueCallBack<List<TIMFriendGetResult>> tIMValueCallBack) {
        QLog.i("TIMFriendshipManager", "getFriendList_specified called");
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (list != null && list.size() != 0) {
            FriendshipNativeManager.nativeGetSpecifiedFriendList(list, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass6 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "getFriendList_specified success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "getFriendList_specified fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6017, "userIDList is empty");
        }
    }

    public List<TIMFriend> queryFriendList() {
        QLog.i("TIMFriendshipManager", "queryFriendList called");
        if (BaseManager.getInstance().isInited()) {
            return FriendshipNativeManager.nativeQueryFriendList();
        }
        Log.e("TIMFriendshipManager", "queryFriendList error, sdk not init");
        return null;
    }

    public TIMFriend queryFriend(String str) {
        QLog.v("TIMFriendshipManager", "queryFriend called, identifier = " + str);
        if (!BaseManager.getInstance().isInited()) {
            Log.e("TIMFriendshipManager", "queryFriend error, sdk not init");
            return null;
        } else if (!TextUtils.isEmpty(str)) {
            return FriendshipNativeManager.nativeQueryFriend(str);
        } else {
            QLog.e("TIMFriendshipManager", "queryFriend, identifier is empty, ignore");
            return null;
        }
    }

    public void addFriend(TIMFriendRequest tIMFriendRequest, TIMValueCallBack<TIMFriendResult> tIMValueCallBack) {
        QLog.i("TIMFriendshipManager", "addFriend called");
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (tIMFriendRequest == null) {
            QLog.e("TIMFriendshipManager", "addFriend, timAddFriendRequest is null");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "timAddFriendRequest is empty");
            }
        } else {
            if (TextUtils.isEmpty(tIMFriendRequest.getAddSource())) {
                tIMFriendRequest.setAddSource("AddSource_Type_Unknow");
            }
            FriendshipNativeManager.nativeAddFriend(tIMFriendRequest, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass7 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "addFriend success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "addFriend fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void deleteFriends(List<String> list, int i, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        QLog.i("TIMFriendshipManager", "delFriend called");
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (list == null || list.size() == 0) {
            QLog.e("TIMFriendshipManager", "deleteFriends, identifiers is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "userIDList maybe empty");
            }
        } else if (i == 1 || i == 2) {
            FriendshipNativeManager.nativeDelFriend(list, i, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass8 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "deleteFriends success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "deleteFriends fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else {
            QLog.e("TIMFriendshipManager", "deleteFriends, delFriendType must be TIMDelFriendType.TIM_FRIEND_DEL_SINGLE or TIMDelFriendType.TIM_FRIEND_DEL_BOTH");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "delFriendType must be TIMDelFriendType.TIM_FRIEND_DEL_SINGLE or TIMDelFriendType.TIM_FRIEND_DEL_BOTH");
            }
        }
    }

    public void modifyFriend(String str, HashMap<String, Object> hashMap, TIMCallBack tIMCallBack) {
        QLog.i("TIMFriendshipManager", "modifyFriend called");
        if (!BaseManager.getInstance().isInited()) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6013, "sdk not init");
            }
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("TIMFriendshipManager", "modifyFriend, identifier is empty");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "identifier is empty");
            }
        } else if (hashMap == null || hashMap.size() <= 0) {
            QLog.e("TIMFriendshipManager", "modifyFriend, profileMap is null or empty");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "profileMap is empty");
            }
        } else {
            FriendshipNativeManager.nativeModifyFriendProfile(str, hashMap, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass9 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "modifyFriend success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "modifyFriend fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void doResponse(TIMFriendResponse tIMFriendResponse, TIMValueCallBack<TIMFriendResult> tIMValueCallBack) {
        QLog.i("TIMFriendshipManager", "doResponse called");
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (tIMFriendResponse == null) {
            QLog.e("TIMFriendshipManager", "doResponse, response is null");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "response is empty");
            }
        } else if (TextUtils.isEmpty(tIMFriendResponse.getIdentifier())) {
            QLog.e("TIMFriendshipManager", "doResponse, identifier is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "identifier is empty");
            }
        } else if (tIMFriendResponse.getResponseType() == 0 || tIMFriendResponse.getResponseType() == 1 || tIMFriendResponse.getResponseType() == 2) {
            FriendshipNativeManager.nativeDoResponse(tIMFriendResponse, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass10 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "doResponse success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "doResponse fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else {
            QLog.e("TIMFriendshipManager", "doResponse, delFriendType must be TIMFriendResponse.TIM_FRIEND_RESPONSE_AGREE or TIMFriendResponse.TIM_FRIEND_RESPONSE_AGREE_AND_ADD or TIMFriendResponse.TIM_FRIEND_RESPONSE_REJECT");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "responseType is invalid");
            }
        }
    }

    public void createFriendGroup(List<String> list, List<String> list2, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (list == null || list.size() == 0) {
            QLog.e("TIMFriendshipManager", "createFriendGroup group name list is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "groupNames is empty");
            }
        } else {
            FriendshipNativeManager.nativeCreateGroup(list, list2, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass11 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "createFriendGroup success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "createFriendGroup fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void getFriendGroups(List<String> list, TIMValueCallBack<List<TIMFriendGroup>> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            if (list != null && list.size() == 0) {
                list = null;
            }
            FriendshipNativeManager.nativeGetGroup(list, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass12 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "createFriendGroup success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "createFriendGroup fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void deleteFriendGroup(List<String> list, TIMCallBack tIMCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6013, "sdk not init");
            }
        } else if (list.size() == 0) {
            QLog.e("TIMFriendshipManager", "deleteFriendGroup group name list is empty");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "groupNames is empty");
            }
        } else {
            FriendshipNativeManager.nativeDeleteGroup(list, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass13 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "deleteFriendGroup success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "deleteFriendGroup fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void renameFriendGroup(String str, String str2, TIMCallBack tIMCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6013, "sdk not init");
            }
        } else if (TextUtils.isEmpty(str2)) {
            QLog.e("TIMFriendshipManager", "renameFriendGroup new group name is empty");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "newName is empty");
            }
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("TIMFriendshipManager", "renameFriendGroup old group name is empty");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "oldName is empty");
            }
        } else {
            FriendshipNativeManager.nativeRenameFriendGroup(str, str2, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass14 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "renameFriendGroup success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "renameFriendGroup fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void addFriendsToFriendGroup(String str, List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("TIMFriendshipManager", "addFriendsToFriendGroup groupName is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "groupName is empty");
            }
        } else if (list == null || list.size() == 0) {
            QLog.e("TIMFriendshipManager", "addFriendsToFriendGroup identifiers list is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "userIDList is empty");
            }
        } else {
            FriendshipNativeManager.nativeAddFriendsToFriendGroup(str, list, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass15 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "addFriendsToFriendGroup success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "addFriendsToFriendGroup fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void deleteFriendsFromFriendGroup(String str, List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("TIMFriendshipManager", "deleteFriendsFromFriendGroup groupName is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "groupName is empty");
            }
        } else if (list == null || list.size() == 0) {
            QLog.e("TIMFriendshipManager", "deleteFriendsFromFriendGroup identifiers list is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "userIDList is empty");
            }
        } else {
            FriendshipNativeManager.nativeDeleteFriendsFromFriendGroup(str, list, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass16 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "deleteFriendsFromFriendGroup success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "deleteFriendsFromFriendGroup fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void getPendencyList(TIMFriendPendencyRequest tIMFriendPendencyRequest, TIMValueCallBack<TIMFriendPendencyResponse> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (tIMFriendPendencyRequest == null) {
            QLog.e("TIMFriendshipManager", "getPendencyList timFriendPendencyRequest is null");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "timFriendPendencyRequest is empty");
            }
        } else {
            FriendshipNativeManager.nativeGetPendencyList(tIMFriendPendencyRequest.getTimPendencyGetType(), tIMFriendPendencyRequest.getSeq(), tIMFriendPendencyRequest.getTimestamp(), tIMFriendPendencyRequest.getNumPerPage(), new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass17 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "getPendencyList success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "getPendencyList fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void deletePendency(int i, List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (list == null || list.size() == 0) {
            QLog.e("TIMFriendshipManager", "deletePendency identifiers list is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "userIDList is empty");
            }
        } else {
            FriendshipNativeManager.nativeDeletePendency(i, list, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass18 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "deletePendency success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "deletePendency fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void pendencyReport(long j, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            FriendshipNativeManager.nativePendencyReport(j, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass19 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "deletePendency success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "deletePendency fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void getBlackList(TIMValueCallBack<List<TIMFriend>> tIMValueCallBack) {
        if (BaseManager.getInstance().isInited()) {
            FriendshipNativeManager.nativeGetBlackList(new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass20 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "getBlackList success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "getBlackList fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6013, "sdk not init");
        }
    }

    public void addBlackList(List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (list == null || list.size() == 0) {
            QLog.e("TIMFriendshipManager", "addBlackList identifiers list is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "userIDList is empty");
            }
        } else {
            FriendshipNativeManager.nativeAddBlackList(list, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass21 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "addBlackList success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "addBlackList fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void deleteBlackList(List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (list == null || list.size() == 0) {
            QLog.e("TIMFriendshipManager", "deleteBlackList identifiers list is empty");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "userIDList is empty");
            }
        } else {
            FriendshipNativeManager.nativeDeleteBlackList(list, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass22 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "deleteBlackList success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "deleteBlackList fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void checkFriends(TIMFriendCheckInfo tIMFriendCheckInfo, TIMValueCallBack<List<TIMCheckFriendResult>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (tIMFriendCheckInfo == null) {
            QLog.e("TIMFriendshipManager", "checkFriends checkInfo is null!");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "checkInfo is empty");
            }
        } else {
            FriendshipNativeManager.nativeCheckFriends(tIMFriendCheckInfo, new ICallback(tIMValueCallBack) {
                /* class com.tencent.imsdk.TIMFriendshipManager.AnonymousClass23 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("TIMFriendshipManager", "checkFriends success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("TIMFriendshipManager", "checkFriends fail code = " + i + ", desc = " + str);
                    super.fail(i, str);
                }
            });
        }
    }
}
