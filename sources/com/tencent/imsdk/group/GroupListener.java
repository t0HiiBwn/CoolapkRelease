package com.tencent.imsdk.group;

import com.tencent.imsdk.TIMGroupTipsElem;
import com.tencent.imsdk.conversation.Msg;
import java.util.Map;

public interface GroupListener {
    void onGroupAttributeChanged(String str, Map<String, String> map);

    void onGroupTipsEvent(TIMGroupTipsElem tIMGroupTipsElem);

    void onRecvGroup0x38TipsMessage(Msg msg);
}
