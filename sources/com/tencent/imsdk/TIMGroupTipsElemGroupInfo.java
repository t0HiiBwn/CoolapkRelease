package com.tencent.imsdk;

public class TIMGroupTipsElemGroupInfo {
    private String content;
    private String key;
    private TIMGroupTipsGroupInfoType type = TIMGroupTipsGroupInfoType.Invalid;

    public TIMGroupTipsGroupInfoType getType() {
        return this.type;
    }

    void setType(int i) {
        TIMGroupTipsGroupInfoType[] values = TIMGroupTipsGroupInfoType.values();
        for (TIMGroupTipsGroupInfoType tIMGroupTipsGroupInfoType : values) {
            if (tIMGroupTipsGroupInfoType.value() == i) {
                this.type = tIMGroupTipsGroupInfoType;
            }
        }
    }

    public String getContent() {
        return this.content;
    }

    public String getKey() {
        return this.key;
    }
}
