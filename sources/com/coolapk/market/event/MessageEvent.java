package com.coolapk.market.event;

import com.coolapk.market.model.Message;

public class MessageEvent {
    private int action;
    private final String id;
    private boolean isDelete = false;
    private final Message mMessage;
    private final String uKey;

    public MessageEvent(Message message, int i) {
        this.mMessage = message;
        this.id = message.getId();
        this.action = i;
        this.uKey = message.getUKey();
    }

    public int getAction() {
        return this.action;
    }

    public String getuKey() {
        return this.uKey;
    }

    public boolean isDeleteChat() {
        return this.action == 0;
    }

    public boolean isDeleteMessage() {
        return this.action == 4;
    }

    public boolean isAddTop() {
        return this.action == 2;
    }

    public boolean isRemoveTop() {
        return this.action == 3;
    }

    public boolean isUpdataMessage() {
        return this.action == 1;
    }

    public Message getMessage() {
        if (isAddTop()) {
            return Message.builder(this.mMessage).setIsTop(1).build();
        }
        if (isRemoveTop()) {
            return Message.builder(this.mMessage).setIsTop(0).build();
        }
        return this.mMessage;
    }

    public String getId() {
        return this.id;
    }
}
