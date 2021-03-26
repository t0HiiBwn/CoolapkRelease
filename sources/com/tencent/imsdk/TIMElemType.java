package com.tencent.imsdk;

public enum TIMElemType {
    Invalid(0),
    Text(1),
    Image(2),
    Sound(3),
    Custom(4),
    File(5),
    GroupTips(6),
    Face(7),
    Location(8),
    GroupSystem(9),
    SNSTips(10),
    ProfileTips(11),
    Video(12);
    
    private int type = 0;

    private TIMElemType(int i) {
        this.type = i;
    }

    public int value() {
        return this.type;
    }
}
