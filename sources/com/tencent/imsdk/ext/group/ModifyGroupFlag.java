package com.tencent.imsdk.ext.group;

public enum ModifyGroupFlag {
    kModifyGroupNone(0),
    kModifyGroupName(1),
    kModifyGroupNotification(2),
    kModifyGroupIntroduction(4),
    kModifyGroupFaceUrl(8),
    kModifyGroupAddOption(16),
    kModifyGroupMaxMmeberNum(32),
    kModifyGroupVisible(64),
    kModifyGroupSearchable(128),
    kModifyGroupAllShutup(256);
    
    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ModifyGroupFlag swigToEnum(int i) {
        ModifyGroupFlag[] modifyGroupFlagArr = (ModifyGroupFlag[]) ModifyGroupFlag.class.getEnumConstants();
        if (i < modifyGroupFlagArr.length && i >= 0 && modifyGroupFlagArr[i].swigValue == i) {
            return modifyGroupFlagArr[i];
        }
        for (ModifyGroupFlag modifyGroupFlag : modifyGroupFlagArr) {
            if (modifyGroupFlag.swigValue == i) {
                return modifyGroupFlag;
            }
        }
        throw new IllegalArgumentException("No enum " + ModifyGroupFlag.class + " with value " + i);
    }

    private ModifyGroupFlag() {
        this.swigValue = SwigNext.access$008();
    }

    private ModifyGroupFlag(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    private ModifyGroupFlag(ModifyGroupFlag modifyGroupFlag) {
        int i = modifyGroupFlag.swigValue;
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        static /* synthetic */ int access$008() {
            int i = next;
            next = i + 1;
            return i;
        }

        private SwigNext() {
        }
    }
}
