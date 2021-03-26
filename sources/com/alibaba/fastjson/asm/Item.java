package com.alibaba.fastjson.asm;

final class Item {
    int hashCode;
    int index;
    int intVal;
    long longVal;
    Item next;
    String strVal1;
    String strVal2;
    String strVal3;
    int type;

    Item() {
    }

    Item(int i, Item item) {
        this.index = i;
        this.type = item.type;
        this.intVal = item.intVal;
        this.longVal = item.longVal;
        this.strVal1 = item.strVal1;
        this.strVal2 = item.strVal2;
        this.strVal3 = item.strVal3;
        this.hashCode = item.hashCode;
    }

    void set(int i, String str, String str2, String str3) {
        this.type = i;
        this.strVal1 = str;
        this.strVal2 = str2;
        this.strVal3 = str3;
        if (!(i == 1 || i == 7 || i == 8)) {
            if (i == 12) {
                this.hashCode = (i + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (i != 13) {
                this.hashCode = (i + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                return;
            }
        }
        this.hashCode = (i + str.hashCode()) & Integer.MAX_VALUE;
    }

    void set(int i) {
        this.type = 3;
        this.intVal = i;
        this.hashCode = Integer.MAX_VALUE & (3 + i);
    }

    boolean isEqualTo(Item item) {
        int i = this.type;
        if (i != 1) {
            if (i != 15) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 3:
                            case 4:
                                if (item.intVal == this.intVal) {
                                    return true;
                                }
                                return false;
                            case 5:
                            case 6:
                                break;
                            case 7:
                            case 8:
                                break;
                            default:
                                if (!item.strVal1.equals(this.strVal1) || !item.strVal2.equals(this.strVal2) || !item.strVal3.equals(this.strVal3)) {
                                    return false;
                                }
                                return true;
                        }
                    }
                } else if (!item.strVal1.equals(this.strVal1) || !item.strVal2.equals(this.strVal2)) {
                    return false;
                } else {
                    return true;
                }
            }
            if (item.longVal == this.longVal) {
                return true;
            }
            return false;
        }
        return item.strVal1.equals(this.strVal1);
    }
}
