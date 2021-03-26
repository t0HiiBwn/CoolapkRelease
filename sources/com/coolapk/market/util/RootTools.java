package com.coolapk.market.util;

import com.coolapk.market.util.ShellUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RootTools {
    public static long lastCheckTime;

    public static boolean isRootAvailable() {
        return findBinary("su").size() > 0;
    }

    public static boolean isAccessGiven() {
        final HashSet<String> hashSet = new HashSet();
        try {
            LogUtils.v("Checking for Root access", new Object[0]);
            ShellUtils.execCommand("id", true, new ShellUtils.Callback() {
                /* class com.coolapk.market.util.RootTools.AnonymousClass1 */

                @Override // com.coolapk.market.util.ShellUtils.Callback
                public void onOutput(String str) {
                    hashSet.addAll(Arrays.asList(str.split(" ")));
                }
            });
            for (String str : hashSet) {
                LogUtils.v(str, new Object[0]);
                if (str.toLowerCase().contains("uid=0")) {
                    LogUtils.v("Access Given", new Object[0]);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isAccessGivenWithTimeOut() {
        long j = System.currentTimeMillis() - lastCheckTime > 600000 ? 10000 : 4000;
        lastCheckTime = System.currentTimeMillis();
        return isAccessGivenWithTimeOut(j);
    }

    public static boolean isAccessGivenWithTimeOut(long j) {
        return Observable.timer(j, TimeUnit.MILLISECONDS).map(new Func1<Long, Boolean>() {
            /* class com.coolapk.market.util.RootTools.AnonymousClass3 */

            public Boolean call(Long l2) {
                return false;
            }
        }).ambWith(Observable.defer(new Func0<Observable<Boolean>>() {
            /* class com.coolapk.market.util.RootTools.AnonymousClass2 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Boolean> call() {
                return Observable.just(Boolean.valueOf(RootTools.isAccessGiven()));
            }
        }).subscribeOn(Schedulers.io())).toBlocking().first().booleanValue();
    }

    private static List<String> findBinary(final String str) {
        boolean z;
        List<String> path = getPath();
        final ArrayList arrayList = new ArrayList();
        try {
            for (final String str2 : path) {
                if (!str2.endsWith("/")) {
                    str2 = str2 + "/";
                }
                ShellUtils.execCommand("stat " + str2 + str, false, new ShellUtils.Callback() {
                    /* class com.coolapk.market.util.RootTools.AnonymousClass4 */

                    @Override // com.coolapk.market.util.ShellUtils.Callback
                    public void onOutput(String str) {
                        if (str.contains("File: ") && str.contains(str)) {
                            arrayList.add(str2);
                            LogUtils.d(str + " was found here: " + str2, new Object[0]);
                        }
                    }
                });
            }
            z = !arrayList.isEmpty();
        } catch (IOException | InterruptedException unused) {
            LogUtils.e(str + " was not found, more information MAY be available with Debugging on.", new Object[0]);
            z = false;
        }
        if (!z) {
            LogUtils.v("Trying second method", new Object[0]);
            for (String str3 : path) {
                if (!str3.endsWith("/")) {
                    str3 = str3 + "/";
                }
                if (exists(str3 + str)) {
                    LogUtils.v(str + " was found here: " + str3, new Object[0]);
                    arrayList.add(str3);
                } else {
                    LogUtils.v(str + " was NOT found here: " + str3, new Object[0]);
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    private static List<String> getPath() {
        return Arrays.asList(System.getenv("PATH").split(":"));
    }

    private static boolean exists(String str) {
        return exists(str, false);
    }

    private static boolean exists(String str, boolean z) {
        final ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("ls ");
        sb.append(z ? "-d " : " ");
        String sb2 = sb.toString();
        try {
            ShellUtils.execCommand(sb2 + str, false, new ShellUtils.Callback() {
                /* class com.coolapk.market.util.RootTools.AnonymousClass5 */

                @Override // com.coolapk.market.util.ShellUtils.Callback
                public void onOutput(String str) {
                    arrayList.add(str);
                }
            });
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        for (String str2 : arrayList) {
            if (str2.trim().equals(str)) {
                return true;
            }
        }
        arrayList.clear();
        try {
            ShellUtils.execCommand(sb2 + str, true, new ShellUtils.Callback() {
                /* class com.coolapk.market.util.RootTools.AnonymousClass6 */

                @Override // com.coolapk.market.util.ShellUtils.Callback
                public void onOutput(String str) {
                    arrayList.add(str);
                }
            });
            ArrayList<String> arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            for (String str3 : arrayList2) {
                if (str3.trim().equals(str)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
