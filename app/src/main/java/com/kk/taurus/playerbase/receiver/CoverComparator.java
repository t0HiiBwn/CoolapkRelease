package com.kk.taurus.playerbase.receiver;

import java.util.Comparator;

public class CoverComparator implements Comparator<IReceiver> {
    public int compare(IReceiver iReceiver, IReceiver iReceiver2) {
        int coverLevel = iReceiver instanceof BaseCover ? ((BaseCover) iReceiver).getCoverLevel() : 0;
        int coverLevel2 = iReceiver2 instanceof BaseCover ? ((BaseCover) iReceiver2).getCoverLevel() : 0;
        if (coverLevel < coverLevel2) {
            return -1;
        }
        if (coverLevel == coverLevel2) {
            return 0;
        }
        return 1;
    }
}
