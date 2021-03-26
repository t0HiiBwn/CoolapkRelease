package com.facebook.stetho.dumpapp;

import java.util.ArrayList;
import java.util.Iterator;

public class ArgsHelper {
    public static String nextOptionalArg(Iterator<String> it2, String str) {
        return it2.hasNext() ? it2.next() : str;
    }

    public static String nextArg(Iterator<String> it2, String str) throws DumpUsageException {
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new DumpUsageException(str);
    }

    public static String[] drainToArray(Iterator<String> it2) {
        ArrayList arrayList = new ArrayList();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
