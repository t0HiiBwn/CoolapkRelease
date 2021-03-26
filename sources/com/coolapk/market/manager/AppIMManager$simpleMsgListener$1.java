package com.coolapk.market.manager;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.AppIMManager;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.util.LogUtils;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMSimpleMsgListener;
import com.tencent.imsdk.v2.V2TIMUserInfo;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"com/coolapk/market/manager/AppIMManager$simpleMsgListener$1", "Lcom/tencent/imsdk/v2/V2TIMSimpleMsgListener;", "onRecvC2CCustomMessage", "", "msgID", "", "sender", "Lcom/tencent/imsdk/v2/V2TIMUserInfo;", "customData", "", "onRecvC2CTextMessage", "text", "onRecvGroupCustomMessage", "groupID", "Lcom/tencent/imsdk/v2/V2TIMGroupMemberInfo;", "onRecvGroupTextMessage", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppIMManager.kt */
public final class AppIMManager$simpleMsgListener$1 extends V2TIMSimpleMsgListener {
    final /* synthetic */ AppIMManager this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppIMManager$simpleMsgListener$1(AppIMManager appIMManager) {
        this.this$0 = appIMManager;
    }

    @Override // com.tencent.imsdk.v2.V2TIMSimpleMsgListener
    public void onRecvC2CTextMessage(String str, V2TIMUserInfo v2TIMUserInfo, String str2) {
        LogUtils.d("[MsgListener] onRecvC2CTextMessage " + str2, new Object[0]);
    }

    @Override // com.tencent.imsdk.v2.V2TIMSimpleMsgListener
    public void onRecvC2CCustomMessage(String str, V2TIMUserInfo v2TIMUserInfo, byte[] bArr) {
        LogUtils.d("[MsgListener] onRecvC2CCustomMessage", new Object[0]);
    }

    @Override // com.tencent.imsdk.v2.V2TIMSimpleMsgListener
    public void onRecvGroupTextMessage(String str, String str2, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, String str3) {
        Intrinsics.checkNotNullParameter(str, "msgID");
        Intrinsics.checkNotNullParameter(str2, "groupID");
        Intrinsics.checkNotNullParameter(v2TIMGroupMemberInfo, "sender");
        Intrinsics.checkNotNullParameter(str3, "text");
        LogUtils.d("[MsgListener] onRecvGroupTextMessage " + str3, new Object[0]);
    }

    @Override // com.tencent.imsdk.v2.V2TIMSimpleMsgListener
    public void onRecvGroupCustomMessage(String str, String str2, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "msgID");
        Intrinsics.checkNotNullParameter(str2, "groupID");
        Intrinsics.checkNotNullParameter(v2TIMGroupMemberInfo, "sender");
        Intrinsics.checkNotNullParameter(bArr, "customData");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-8\")");
        String str3 = new String(bArr, forName);
        LogUtils.d("[MsgListener] onRecvGroupCustomMessage " + str + ' ' + str3, new Object[0]);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            String optString = jSONObject.optString("action");
            if (optString != null) {
                String str4 = null;
                switch (optString.hashCode()) {
                    case -742476495:
                        if (optString.equals("liveAddToBroadcast")) {
                            String optString2 = jSONObject.optString("params");
                            Intrinsics.checkNotNullExpressionValue(optString2, "body");
                            LiveMessage liveMessage = (LiveMessage) EntityExtendsKt.jsonToEntity(optString2);
                            if (liveMessage != null) {
                                for (AppIMManager.GroupMessageListener groupMessageListener : this.this$0.groupMessageListener) {
                                    groupMessageListener.onRecvAddToBroadcast(liveMessage);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 270270395:
                        if (optString.equals("newLiveMessage")) {
                            String optString3 = jSONObject.optString("params");
                            Intrinsics.checkNotNullExpressionValue(optString3, "body");
                            LiveMessage liveMessage2 = (LiveMessage) EntityExtendsKt.jsonToEntity(optString3);
                            if (liveMessage2 != null) {
                                for (AppIMManager.GroupMessageListener groupMessageListener2 : this.this$0.groupMessageListener) {
                                    groupMessageListener2.onRecvNewMessage(liveMessage2);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 365614471:
                        if (optString.equals("liveRemoveFromBroadcast")) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("params");
                            if (optJSONObject != null) {
                                str4 = optJSONObject.optString("messageId");
                            }
                            if (str4 != null) {
                                for (AppIMManager.GroupMessageListener groupMessageListener3 : this.this$0.groupMessageListener) {
                                    groupMessageListener3.onRecvRemoveFromBroadcast(str4);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 427578461:
                        if (optString.equals("liveDetail")) {
                            String optString4 = jSONObject.optString("params");
                            Intrinsics.checkNotNullExpressionValue(optString4, "body");
                            Live live = (Live) EntityExtendsKt.jsonToEntity(optString4);
                            for (AppIMManager.GroupMessageListener groupMessageListener4 : this.this$0.groupMessageListener) {
                                groupMessageListener4.onRecvLiveDetail(live);
                            }
                            return;
                        }
                        return;
                    case 1886833232:
                        if (optString.equals("liveDeleteMessage")) {
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("params");
                            if (optJSONObject2 != null) {
                                str4 = optJSONObject2.optString("messageId");
                            }
                            if (str4 != null) {
                                for (AppIMManager.GroupMessageListener groupMessageListener5 : this.this$0.groupMessageListener) {
                                    groupMessageListener5.onRecvDeleteMessage(str4);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 1949113916:
                        if (optString.equals("liveDeleteAllMessageByUid")) {
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("params");
                            if (optJSONObject3 != null) {
                                str4 = optJSONObject3.optString("uid");
                            }
                            if (str4 != null) {
                                for (AppIMManager.GroupMessageListener groupMessageListener6 : this.this$0.groupMessageListener) {
                                    groupMessageListener6.onRecvDeleteAllMessage(str4);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
