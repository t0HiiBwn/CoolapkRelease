package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.IMBridge;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMCustomElem;
import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.Msg;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class V2TIMConversationInternal {
    private static final String TAG = "V2TIMConvInternal";
    private Conversation mConversation;

    protected V2TIMConversationInternal(TIMConversation tIMConversation) {
        if (tIMConversation.getType() == TIMConversationType.Invalid) {
            QLog.e("V2TIMConvInternal", "conversation is null because type = " + tIMConversation.getType().value());
            this.mConversation = null;
        } else if (tIMConversation.getType() == TIMConversationType.System || !TextUtils.isEmpty(tIMConversation.getPeer())) {
            this.mConversation = new Conversation(tIMConversation.getType().value(), tIMConversation.getPeer());
        } else {
            QLog.e("V2TIMConvInternal", "conversation is null because type = " + tIMConversation.getType());
            this.mConversation = null;
        }
    }

    protected void sendSignalMessage(V2TIMSignalingInfo v2TIMSignalingInfo, TIMValueCallBack<TIMMessage> tIMValueCallBack) {
        if (v2TIMSignalingInfo == null) {
            QLog.e("V2TIMConvInternal", "sendSignalMessage error, info is null");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "info is empty");
            }
        } else if (this.mConversation == null) {
            QLog.e("V2TIMConvInternal", "sendSignalMessage fail, mConversation is null");
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "mConversation is null");
            }
        } else {
            TIMMessage tIMMessage = new TIMMessage();
            Msg msgFromTIMMessage = IMBridge.getMsgFromTIMMessage(tIMMessage);
            if (v2TIMSignalingInfo.isOnlineUserOnly()) {
                msgFromTIMMessage.setLifetime(0);
            }
            if (v2TIMSignalingInfo.getOfflinePushInfo() != null) {
                tIMMessage.setOfflinePushSettings(v2TIMSignalingInfo.getOfflinePushInfo().getTimMessageOfflinePushConfig());
            }
            if (v2TIMSignalingInfo.getActionType() == 1) {
                v2TIMSignalingInfo.setInviteID(tIMMessage.getMsgId());
            }
            v2TIMSignalingInfo.setBusinessID(1);
            byte[] bytes = signallingInfoToJsonString(v2TIMSignalingInfo).getBytes();
            TIMCustomElem tIMCustomElem = new TIMCustomElem();
            tIMCustomElem.setData(bytes);
            tIMMessage.addElement(tIMCustomElem);
            this.mConversation.sendMessage(false, true, tIMMessage, tIMValueCallBack);
        }
    }

    protected V2TIMSignalingInfo getSignalingInfo(TIMMessage tIMMessage) {
        byte[] data;
        V2TIMSignalingInfo v2TIMSignalingInfo;
        if (this.mConversation == null) {
            QLog.e("V2TIMConvInternal", "getSignalingInfo fail, mConversation is null");
            return null;
        }
        for (int i = 0; i < tIMMessage.getElementCount(); i++) {
            TIMElem element = tIMMessage.getElement(i);
            if ((element instanceof TIMCustomElem) && (data = ((TIMCustomElem) element).getData()) != null) {
                try {
                    v2TIMSignalingInfo = jsonStringToSignallingInfo(new String(data));
                } catch (Exception e) {
                    QLog.i("V2TIMConvInternal", "getSignalingInfo exception:" + e);
                    v2TIMSignalingInfo = null;
                }
                if (v2TIMSignalingInfo == null || v2TIMSignalingInfo.getBusinessID() != 1) {
                    return null;
                }
                return v2TIMSignalingInfo;
            }
        }
        return null;
    }

    private String signallingInfoToJsonString(V2TIMSignalingInfo v2TIMSignalingInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("businessID", v2TIMSignalingInfo.getBusinessID());
            jSONObject.put("inviteID", v2TIMSignalingInfo.getInviteID());
            jSONObject.put("groupID", v2TIMSignalingInfo.getGroupID());
            jSONObject.put("inviter", v2TIMSignalingInfo.getInviter());
            JSONArray jSONArray = new JSONArray();
            for (String str : v2TIMSignalingInfo.getInviteeList()) {
                jSONArray.put(str);
            }
            jSONObject.put("inviteeList", jSONArray);
            jSONObject.put("data", v2TIMSignalingInfo.getData());
            jSONObject.put("timeout", v2TIMSignalingInfo.getTimeout());
            jSONObject.put("actionType", v2TIMSignalingInfo.getActionType());
            jSONObject.put("onlineUserOnly", v2TIMSignalingInfo.isOnlineUserOnly());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private V2TIMSignalingInfo jsonStringToSignallingInfo(String str) {
        V2TIMSignalingInfo v2TIMSignalingInfo = new V2TIMSignalingInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            v2TIMSignalingInfo.setBusinessID(jSONObject.optInt("businessID"));
            v2TIMSignalingInfo.setInviteID(jSONObject.optString("inviteID"));
            v2TIMSignalingInfo.setGroupID(jSONObject.optString("groupID"));
            v2TIMSignalingInfo.setInviter(jSONObject.optString("inviter"));
            JSONArray optJSONArray = jSONObject.optJSONArray("inviteeList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
                v2TIMSignalingInfo.setInviteeList(arrayList);
            }
            v2TIMSignalingInfo.setData(jSONObject.optString("data"));
            v2TIMSignalingInfo.setTimeout(jSONObject.optInt("timeout"));
            v2TIMSignalingInfo.setActionType(jSONObject.optInt("actionType"));
            v2TIMSignalingInfo.setOnlineUserOnly(jSONObject.optBoolean("onlineUserOnly"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return v2TIMSignalingInfo;
    }
}
