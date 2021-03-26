package com.tencent.imsdk.ext.group;

public enum ModifyGroupMemberFlag {
    kModifyGroupMemberNone(0),
    kModifyGroupMemberMsgFlag(1),
    kModifyGroupMemberRole(2),
    kModifyGroupMemberShutupTime(4),
    kModifyGroupMemberNameCard(8);
    
    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ModifyGroupMemberFlag swigToEnum(int i) {
        ModifyGroupMemberFlag[] modifyGroupMemberFlagArr = (ModifyGroupMemberFlag[]) ModifyGroupMemberFlag.class.getEnumConstants();
        if (i < modifyGroupMemberFlagArr.length && i >= 0 && modifyGroupMemberFlagArr[i].swigValue == i) {
            return modifyGroupMemberFlagArr[i];
        }
        for (ModifyGroupMemberFlag modifyGroupMemberFlag : modifyGroupMemberFlagArr) {
            if (modifyGroupMemberFlag.swigValue == i) {
                return modifyGroupMemberFlag;
            }
        }
        throw new IllegalArgumentException("No enum " + ModifyGroupMemberFlag.class + " with value " + i);
    }

    private ModifyGroupMemberFlag() {
        this.swigValue = SwigNext.access$008();
    }

    private ModifyGroupMemberFlag(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    private ModifyGroupMemberFlag(ModifyGroupMemberFlag modifyGroupMemberFlag) {
        int i = modifyGroupMemberFlag.swigValue;
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
