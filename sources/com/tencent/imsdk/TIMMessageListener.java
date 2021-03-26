package com.tencent.imsdk;

import java.util.List;

public interface TIMMessageListener {
    boolean onNewMessages(List<TIMMessage> list);
}
