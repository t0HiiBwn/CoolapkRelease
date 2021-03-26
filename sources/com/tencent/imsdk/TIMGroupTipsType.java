package com.tencent.imsdk;

public enum TIMGroupTipsType {
    Invalid(0),
    Join(1),
    Quit(2),
    Kick(3),
    SetAdmin(4),
    CancelAdmin(5),
    ModifyGroupInfo(6),
    ModifyMemberInfo(7),
    AaddGroup(8),
    DelGroup(9);
    
    private int type = 1;

    private TIMGroupTipsType(int i) {
        this.type = i;
    }

    public int value() {
        return this.type;
    }
}
