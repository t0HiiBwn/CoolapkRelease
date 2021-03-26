package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.friendship.FriendshipNativeManager;
import com.tencent.imsdk.friendship.TIMCheckFriendResult;
import com.tencent.imsdk.friendship.TIMFriend;
import com.tencent.imsdk.friendship.TIMFriendCheckInfo;
import com.tencent.imsdk.friendship.TIMFriendGetResult;
import com.tencent.imsdk.friendship.TIMFriendGroup;
import com.tencent.imsdk.friendship.TIMFriendPendencyItem;
import com.tencent.imsdk.friendship.TIMFriendPendencyRequest;
import com.tencent.imsdk.friendship.TIMFriendPendencyResponse;
import com.tencent.imsdk.friendship.TIMFriendResponse;
import com.tencent.imsdk.friendship.TIMFriendResult;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.BaseManager;
import java.util.ArrayList;
import java.util.List;

public class V2TIMFriendshipManagerImpl extends V2TIMFriendshipManager {
    private final String TAG;
    V2TIMFriendshipListener mV2TIMFriendshipListener;

    private static class V2TIMFriendshipManagerImplHolder {
        private static final V2TIMFriendshipManagerImpl v2TIMFriendshipManagerImpl = new V2TIMFriendshipManagerImpl();

        private V2TIMFriendshipManagerImplHolder() {
        }
    }

    static V2TIMFriendshipManagerImpl getInstance() {
        return V2TIMFriendshipManagerImplHolder.v2TIMFriendshipManagerImpl;
    }

    private V2TIMFriendshipManagerImpl() {
        this.TAG = "V2TIMFriendshipManagerImpl";
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void setFriendListener(V2TIMFriendshipListener v2TIMFriendshipListener) {
        this.mV2TIMFriendshipListener = v2TIMFriendshipListener;
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getFriendList(final V2TIMValueCallback<List<V2TIMFriendInfo>> v2TIMValueCallback) {
        TIMFriendshipManager.getInstance().getFriendList(new TIMValueCallBack<List<TIMFriend>>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass1 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMFriend> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMFriend tIMFriend : list) {
                        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                        v2TIMFriendInfo.setTIMFriend(tIMFriend);
                        arrayList.add(v2TIMFriendInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getFriendsInfo(List<String> list, final V2TIMValueCallback<List<V2TIMFriendInfoResult>> v2TIMValueCallback) {
        TIMFriendshipManager.getInstance().getFriendList(list, new TIMValueCallBack<List<TIMFriendGetResult>>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass2 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMFriendGetResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMFriendGetResult tIMFriendGetResult : list) {
                        V2TIMFriendInfoResult v2TIMFriendInfoResult = new V2TIMFriendInfoResult();
                        v2TIMFriendInfoResult.setTimFriendGetResult(tIMFriendGetResult);
                        arrayList.add(v2TIMFriendInfoResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void setFriendInfo(V2TIMFriendInfo v2TIMFriendInfo, final V2TIMCallback v2TIMCallback) {
        if (v2TIMFriendInfo != null) {
            TIMFriendshipManager.getInstance().modifyFriend(v2TIMFriendInfo.getModifyUserID(), v2TIMFriendInfo.getModifyFriendInfo(), new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass3 */

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
            v2TIMCallback.onError(6017, "info is null");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void addFriend(V2TIMFriendAddApplication v2TIMFriendAddApplication, final V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        if (v2TIMFriendAddApplication == null) {
            QLog.e("V2TIMFriendshipManagerImpl", "addFriend err, v2TIMFriendAddApplication is null");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "v2TIMFriendApplication is null");
                return;
            }
            return;
        }
        TIMFriendshipManager.getInstance().addFriend(v2TIMFriendAddApplication.getTIMFriendRequest(), new TIMValueCallBack<TIMFriendResult>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass4 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(TIMFriendResult tIMFriendResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                    v2TIMFriendOperationResult.setTIMFriendResult(tIMFriendResult);
                    v2TIMValueCallback.onSuccess(v2TIMFriendOperationResult);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFromFriendList(List<String> list, int i, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        int i2 = 2;
        if (i == 1 || i == 2) {
            if (i == 1) {
                i2 = 1;
            }
            TIMFriendshipManager.getInstance().deleteFriends(list, i2, new TIMValueCallBack<List<TIMFriendResult>>() {
                /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass5 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(List<TIMFriendResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TIMFriendResult tIMFriendResult : list) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setTIMFriendResult(tIMFriendResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            });
            return;
        }
        QLog.e("V2TIMFriendshipManagerImpl", "deleteFromFriendList err, deleteType is invalid : " + i);
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "deleteType is invalid : " + i);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void checkFriend(String str, int i, final V2TIMValueCallback<V2TIMFriendCheckResult> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "userID is empty");
            }
        } else if (i == 1 || i == 2) {
            TIMFriendCheckInfo tIMFriendCheckInfo = new TIMFriendCheckInfo();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            tIMFriendCheckInfo.setUsers(arrayList);
            tIMFriendCheckInfo.setCheckType(i);
            TIMFriendshipManager.getInstance().checkFriends(tIMFriendCheckInfo, new TIMValueCallBack<List<TIMCheckFriendResult>>() {
                /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass6 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(List<TIMCheckFriendResult> list) {
                    if (v2TIMValueCallback != null) {
                        V2TIMFriendCheckResult v2TIMFriendCheckResult = new V2TIMFriendCheckResult();
                        v2TIMFriendCheckResult.setTIMCheckFriendResult(list.get(0));
                        v2TIMValueCallback.onSuccess(v2TIMFriendCheckResult);
                    }
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "checkType is invalid : " + i);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getFriendApplicationList(final V2TIMValueCallback<V2TIMFriendApplicationResult> v2TIMValueCallback) {
        new ArrayList();
        TIMFriendPendencyRequest tIMFriendPendencyRequest = new TIMFriendPendencyRequest();
        tIMFriendPendencyRequest.setTimPendencyGetType(3);
        tIMFriendPendencyRequest.setNumPerPage(100);
        tIMFriendPendencyRequest.setTimestamp(0);
        tIMFriendPendencyRequest.setSeq(0);
        getV1FriendPendencyList(tIMFriendPendencyRequest, new V2TIMFriendApplicationResult(), new V2TIMValueCallback<V2TIMFriendApplicationResult>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass7 */

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                QLog.e("V2TIMFriendshipManagerImpl", "getFriendApplicationList error code = " + i + ", desc = " + str);
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(final V2TIMFriendApplicationResult v2TIMFriendApplicationResult) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMFriendApplication v2TIMFriendApplication : v2TIMFriendApplicationResult.getFriendApplicationList()) {
                    arrayList.add(v2TIMFriendApplication.getUserID());
                }
                if (arrayList.size() == 0) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(v2TIMFriendApplicationResult);
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("Tag_Profile_IM_Nick");
                arrayList2.add("Tag_Profile_IM_Image");
                FriendshipNativeManager.nativeGetUsersProfile(arrayList, true, arrayList2, new ICallback(new TIMValueCallBack<List<TIMUserProfile>>() {
                    /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass7.AnonymousClass1 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        QLog.e("V2TIMFriendshipManagerImpl", "getFriendApplicationList->GetUsersProfile error = " + i + ", desc = " + str);
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(i, str);
                        }
                    }

                    public void onSuccess(List<TIMUserProfile> list) {
                        for (V2TIMFriendApplication v2TIMFriendApplication : v2TIMFriendApplicationResult.getFriendApplicationList()) {
                            for (TIMUserProfile tIMUserProfile : list) {
                                if (v2TIMFriendApplication.getUserID().equals(tIMUserProfile.getIdentifier())) {
                                    v2TIMFriendApplication.setTIMUserProfile(tIMUserProfile);
                                }
                            }
                        }
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onSuccess(v2TIMFriendApplicationResult);
                        }
                    }
                }) {
                    /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass7.AnonymousClass2 */

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

    public void getV1FriendPendencyList(TIMFriendPendencyRequest tIMFriendPendencyRequest, final V2TIMFriendApplicationResult v2TIMFriendApplicationResult, final V2TIMValueCallback<V2TIMFriendApplicationResult> v2TIMValueCallback) {
        TIMFriendshipManager.getInstance().getPendencyList(tIMFriendPendencyRequest, new TIMValueCallBack<TIMFriendPendencyResponse>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass8 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                QLog.e("V2TIMFriendshipManagerImpl", "getV1FriendPendencyList error = " + i + ", desc = " + str);
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(TIMFriendPendencyResponse tIMFriendPendencyResponse) {
                List<TIMFriendPendencyItem> items = tIMFriendPendencyResponse.getItems();
                v2TIMFriendApplicationResult.setUnreadCount(v2TIMFriendApplicationResult.getUnreadCount() + ((int) tIMFriendPendencyResponse.getUnreadCnt()));
                ArrayList arrayList = new ArrayList();
                for (TIMFriendPendencyItem tIMFriendPendencyItem : items) {
                    V2TIMFriendApplication v2TIMFriendApplication = new V2TIMFriendApplication();
                    v2TIMFriendApplication.setTIMFriendPendencyItem(tIMFriendPendencyItem);
                    v2TIMFriendApplicationResult.getFriendApplicationList().add(v2TIMFriendApplication);
                    arrayList.add(tIMFriendPendencyItem.getIdentifier());
                }
                if (v2TIMFriendApplicationResult.getFriendApplicationList().size() == 0) {
                    v2TIMValueCallback.onSuccess(v2TIMFriendApplicationResult);
                    return;
                }
                long timestamp = tIMFriendPendencyResponse.getTimestamp();
                if (timestamp == 0) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(v2TIMFriendApplicationResult);
                        return;
                    }
                    return;
                }
                TIMFriendPendencyRequest tIMFriendPendencyRequest = new TIMFriendPendencyRequest();
                tIMFriendPendencyRequest.setTimPendencyGetType(3);
                tIMFriendPendencyRequest.setNumPerPage(100);
                tIMFriendPendencyRequest.setTimestamp(timestamp);
                tIMFriendPendencyRequest.setSeq(0);
                V2TIMFriendshipManagerImpl.this.getV1FriendPendencyList(tIMFriendPendencyRequest, v2TIMFriendApplicationResult, v2TIMValueCallback);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void acceptFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, int i, final V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        if (i != 0 && i != 1) {
            QLog.e("V2TIMFriendshipManagerImpl", "acceptFriendApplication, responseType is invalid : " + i);
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "responseType is invalid : " + i);
            }
        } else if (v2TIMFriendApplication == null) {
            QLog.e("V2TIMFriendshipManagerImpl", "acceptFriendApplication, v2TIMFriendApplication is null");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "v2TIMFriendApplication is null");
            }
        } else {
            TIMFriendResponse tIMFriendResponse = new TIMFriendResponse();
            tIMFriendResponse.setIdentifier(v2TIMFriendApplication.getUserID());
            tIMFriendResponse.setResponseType(i);
            TIMFriendshipManager.getInstance().doResponse(tIMFriendResponse, new TIMValueCallBack<TIMFriendResult>() {
                /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass9 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(TIMFriendResult tIMFriendResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setTIMFriendResult(tIMFriendResult);
                        v2TIMValueCallback.onSuccess(v2TIMFriendOperationResult);
                    }
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void refuseFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, final V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        if (v2TIMFriendApplication == null) {
            QLog.e("V2TIMFriendshipManagerImpl", "refuseFriendApplication, application is null");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "application is null");
                return;
            }
            return;
        }
        TIMFriendResponse tIMFriendResponse = new TIMFriendResponse();
        tIMFriendResponse.setIdentifier(v2TIMFriendApplication.getUserID());
        tIMFriendResponse.setResponseType(2);
        TIMFriendshipManager.getInstance().doResponse(tIMFriendResponse, new TIMValueCallBack<TIMFriendResult>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass10 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(TIMFriendResult tIMFriendResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                    v2TIMFriendOperationResult.setTIMFriendResult(tIMFriendResult);
                    v2TIMValueCallback.onSuccess(v2TIMFriendOperationResult);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, final V2TIMCallback v2TIMCallback) {
        if (v2TIMFriendApplication == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "application is null");
            }
            QLog.e("V2TIMFriendshipManagerImpl", "deleteFriendApplication, application is null");
        } else if (TextUtils.isEmpty(v2TIMFriendApplication.getUserID())) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "application userID is empty");
            }
            QLog.e("V2TIMFriendshipManagerImpl", "deleteFriendApplication, application userID is empty");
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(v2TIMFriendApplication.getUserID());
            TIMFriendshipManager.getInstance().deletePendency(v2TIMFriendApplication.getType(), arrayList, new TIMValueCallBack<List<TIMFriendResult>>() {
                /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass11 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(i, str);
                    }
                }

                public void onSuccess(List<TIMFriendResult> list) {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onSuccess();
                    }
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void setFriendApplicationRead(final V2TIMCallback v2TIMCallback) {
        TIMFriendshipManager.getInstance().pendencyReport(System.currentTimeMillis() / 1000, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass12 */

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

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void addToBlackList(List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        TIMFriendshipManager.getInstance().addBlackList(list, new TIMValueCallBack<List<TIMFriendResult>>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass13 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMFriendResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMFriendResult tIMFriendResult : list) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setTIMFriendResult(tIMFriendResult);
                        arrayList.add(v2TIMFriendOperationResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFromBlackList(List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        TIMFriendshipManager.getInstance().deleteBlackList(list, new TIMValueCallBack<List<TIMFriendResult>>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass14 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMFriendResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMFriendResult tIMFriendResult : list) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setTIMFriendResult(tIMFriendResult);
                        arrayList.add(v2TIMFriendOperationResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getBlackList(final V2TIMValueCallback<List<V2TIMFriendInfo>> v2TIMValueCallback) {
        TIMFriendshipManager.getInstance().getBlackList(new TIMValueCallBack<List<TIMFriend>>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass15 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMFriend> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMFriend tIMFriend : list) {
                        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                        v2TIMFriendInfo.setTIMFriend(tIMFriend);
                        arrayList.add(v2TIMFriendInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void createFriendGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (str == null) {
            QLog.e("V2TIMFriendshipManagerImpl", "createFriendGroup group name is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupNames is empty");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        TIMFriendshipManager.getInstance().createFriendGroup(arrayList, list, new TIMValueCallBack<List<TIMFriendResult>>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass16 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMFriendResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMFriendResult tIMFriendResult : list) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setTIMFriendResult(tIMFriendResult);
                        arrayList.add(v2TIMFriendOperationResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getFriendGroups(List<String> list, final V2TIMValueCallback<List<V2TIMFriendGroup>> v2TIMValueCallback) {
        TIMFriendshipManager.getInstance().getFriendGroups(list, new TIMValueCallBack<List<TIMFriendGroup>>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass17 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMFriendGroup> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMFriendGroup tIMFriendGroup : list) {
                        V2TIMFriendGroup v2TIMFriendGroup = new V2TIMFriendGroup();
                        v2TIMFriendGroup.setTIMFriendGroup(tIMFriendGroup);
                        arrayList.add(v2TIMFriendGroup);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFriendGroup(List<String> list, final V2TIMCallback v2TIMCallback) {
        TIMFriendshipManager.getInstance().deleteFriendGroup(list, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass18 */

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

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void renameFriendGroup(String str, String str2, final V2TIMCallback v2TIMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6013, "sdk not init");
            }
        } else if (TextUtils.isEmpty(str2)) {
            QLog.e("V2TIMFriendshipManagerImpl", "renameFriendGroup new group name is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "newName is empty");
            }
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMFriendshipManagerImpl", "renameFriendGroup old group name is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "oldName is empty");
            }
        } else {
            TIMFriendshipManager.getInstance().renameFriendGroup(str, str2, new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass19 */

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

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void addFriendsToFriendGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        TIMFriendshipManager.getInstance().addFriendsToFriendGroup(str, list, new TIMValueCallBack<List<TIMFriendResult>>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass20 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMFriendResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMFriendResult tIMFriendResult : list) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setTIMFriendResult(tIMFriendResult);
                        arrayList.add(v2TIMFriendOperationResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFriendsFromFriendGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        TIMFriendshipManager.getInstance().deleteFriendsFromFriendGroup(str, list, new TIMValueCallBack<List<TIMFriendResult>>() {
            /* class com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.AnonymousClass21 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(List<TIMFriendResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TIMFriendResult tIMFriendResult : list) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setTIMFriendResult(tIMFriendResult);
                        arrayList.add(v2TIMFriendOperationResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        });
    }
}
