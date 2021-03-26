package com.tencent.msdk.dns;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.executor.DnsExecutors;
import com.tencent.msdk.dns.base.log.ILogNode;
import com.tencent.msdk.dns.base.report.IReporter;
import com.tencent.msdk.dns.core.rest.share.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class DnsConfig {
    public final String appId;
    public final Set<String> asyncLookupDomains;
    public final boolean blockFirst;
    public final String channel;
    public final DnsExecutors.ExecutorSupplier executorSupplier;
    public final boolean initBuiltInReporters;
    public final int logLevel;
    public final List<ILogNode> logNodes;
    public final ILookedUpListener lookedUpListener;
    public final g lookupExtra;
    public final Set<String> preLookupDomains;
    public final Set<a> protectedDomains;
    public final List<IReporter> reporters;
    public final int timeoutMills;
    public final int token;
    public String userId;

    private DnsConfig(int i, String str, String str2, boolean z, String str3, String str4, int i2, Set<a> set, Set<String> set2, Set<String> set3, String str5, int i3, boolean z2, DnsExecutors.ExecutorSupplier executorSupplier2, ILookedUpListener iLookedUpListener, List<ILogNode> list, List<IReporter> list2) {
        this.logLevel = i;
        this.appId = str;
        this.userId = str2;
        this.initBuiltInReporters = z;
        this.lookupExtra = new g(str3, str4);
        this.timeoutMills = i2;
        this.protectedDomains = set;
        this.preLookupDomains = set2;
        this.asyncLookupDomains = set3;
        this.channel = str5;
        this.token = i3;
        this.blockFirst = z2;
        this.executorSupplier = executorSupplier2;
        this.lookedUpListener = iLookedUpListener;
        this.logNodes = list;
        this.reporters = list2;
    }

    boolean needProtect(String str) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                Set<a> set = this.protectedDomains;
                if (set == null) {
                    return true;
                }
                for (a aVar : set) {
                    if (aVar.a(trim)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        return "DnsConfig{logLevel=" + this.logLevel + ", appId='" + this.appId + "', userId='" + this.userId + "', lookupExtra=" + this.lookupExtra + ", timeoutMills=" + this.timeoutMills + ", protectedDomains=" + com.tencent.msdk.dns.base.e.a.b(this.protectedDomains) + ", preLookupDomains=" + com.tencent.msdk.dns.base.e.a.b(this.preLookupDomains) + ", asyncLookupDomains=" + com.tencent.msdk.dns.base.e.a.b(this.asyncLookupDomains) + ", channel='" + this.channel + "', token=" + this.token + ", blockFirst=" + this.blockFirst + ", executorSupplier=" + this.executorSupplier + ", lookedUpListener=" + this.lookedUpListener + ", logNodes=" + com.tencent.msdk.dns.base.e.a.b(this.logNodes) + ", reporters=" + com.tencent.msdk.dns.base.e.a.b(this.reporters) + '}';
    }

    static class a {
        private final boolean a;
        private final String b;

        private a(String str) {
            int lastIndexOf = str.lastIndexOf("*.");
            if (-1 == lastIndexOf) {
                this.b = str;
                this.a = false;
                return;
            }
            this.b = str.substring(lastIndexOf + 2);
            this.a = true;
        }

        boolean a(String str) {
            if (this.a) {
                return str.endsWith(this.b);
            }
            return this.b.equals(str);
        }

        public String toString() {
            return "WildcardDomain{mIsWildcard=" + this.a + ", mNakedDomain='" + this.b + "'}";
        }
    }

    public static final class Builder {
        private static final int DEFAULT_MAX_NUM_OF_PRE_LOOKUP_DOMAINS = 10;
        private String mAppId = "";
        private Set<String> mAsyncLookupDomains = null;
        private boolean mBlockFirst = false;
        private String mChannel = "DesHttp";
        private String mDnsId = "1";
        private String mDnsKey = "";
        private DnsExecutors.ExecutorSupplier mExecutorSupplier = null;
        private boolean mInitBuiltInReporters = false;
        private int mLogLevel = 5;
        private List<ILogNode> mLogNodes = null;
        private ILookedUpListener mLookedUpListener = null;
        private int mMaxNumOfPreLookupDomains = 10;
        private Set<String> mPreLookupDomains = null;
        private Set<a> mProtectedDomains = null;
        private List<IReporter> mReporters = null;
        private int mTimeoutMills = 1000;
        private int mToken = -1;
        private String mUserId = "";

        public Builder logLevel(int i) {
            this.mLogLevel = i;
            return this;
        }

        public Builder appId(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mAppId = str;
                return this;
            }
            throw new IllegalArgumentException("appId".concat(" can not be empty"));
        }

        public Builder userId(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mUserId = str;
                return this;
            }
            throw new IllegalArgumentException("userId".concat(" can not be empty"));
        }

        public Builder initBuiltInReporters() {
            this.mInitBuiltInReporters = true;
            return this;
        }

        public Builder notInitBuiltInReporters() {
            this.mInitBuiltInReporters = false;
            return this;
        }

        public Builder dnsId(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mDnsId = str;
                return this;
            }
            throw new IllegalArgumentException("dnsId".concat(" can not be empty"));
        }

        public Builder dnsKey(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mDnsKey = str;
                return this;
            }
            throw new IllegalArgumentException("dnsKey".concat(" can not be empty"));
        }

        public Builder timeoutMills(int i) {
            if (i > 0) {
                this.mTimeoutMills = i;
                return this;
            }
            throw new IllegalArgumentException("timeoutMills".concat(" can not less than 0"));
        }

        public Builder maxNumOfPreLookupDomains(int i) {
            if (i > 0) {
                this.mMaxNumOfPreLookupDomains = i;
                return this;
            }
            throw new IllegalArgumentException("maxNumOfPreLookupDomains".concat(" can not less than 0"));
        }

        public synchronized Builder protectedDomains(String... strArr) {
            boolean z;
            if (!com.tencent.msdk.dns.base.e.a.a((Object[]) strArr)) {
                if (this.mProtectedDomains == null) {
                    this.mProtectedDomains = com.tencent.msdk.dns.base.a.a.b(strArr.length);
                }
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        String trim = str.trim();
                        if (!TextUtils.isEmpty(trim)) {
                            this.mProtectedDomains.add(new a(trim));
                        }
                    }
                    throw new IllegalArgumentException("domain".concat(" can not be empty"));
                }
                Set<String> set = this.mPreLookupDomains;
                if (set != null) {
                    Iterator<String> it2 = set.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        Iterator<a> it3 = this.mProtectedDomains.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (it3.next().a(next)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (!z) {
                            it2.remove();
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("domains".concat(" can not be empty"));
            }
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006d, code lost:
            throw new java.lang.IllegalArgumentException("domain".concat(" can not be empty"));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x009e, code lost:
            throw new java.lang.IllegalArgumentException("domain".concat(" can not be empty"));
         */
        public synchronized Builder preLookupDomains(String... strArr) {
            boolean z;
            if (!com.tencent.msdk.dns.base.e.a.a((Object[]) strArr)) {
                if (this.mPreLookupDomains == null) {
                    this.mPreLookupDomains = com.tencent.msdk.dns.base.a.a.b(strArr.length);
                }
                int size = this.mPreLookupDomains.size();
                int i = 0;
                if (this.mProtectedDomains == null) {
                    int length = strArr.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str = strArr[i];
                        if (TextUtils.isEmpty(str)) {
                            break;
                        }
                        String trim = str.trim();
                        if (TextUtils.isEmpty(trim)) {
                            break;
                        }
                        this.mPreLookupDomains.add(trim);
                        size++;
                        if (this.mMaxNumOfPreLookupDomains <= size) {
                            break;
                        }
                        i++;
                    }
                } else {
                    int length2 = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        String str2 = strArr[i2];
                        if (TextUtils.isEmpty(str2)) {
                            break;
                        }
                        String trim2 = str2.trim();
                        if (TextUtils.isEmpty(trim2)) {
                            break;
                        }
                        Iterator<a> it2 = this.mProtectedDomains.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().a(trim2)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            this.mPreLookupDomains.add(trim2);
                            size++;
                        }
                        if (this.mMaxNumOfPreLookupDomains <= size) {
                            break;
                        }
                        i2++;
                    }
                }
                Set<String> set = this.mAsyncLookupDomains;
                if (set != null) {
                    Iterator<String> it3 = set.iterator();
                    while (it3.hasNext()) {
                        if (!this.mPreLookupDomains.contains(it3.next())) {
                            it3.remove();
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("domains".concat(" can not be empty"));
            }
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
            throw new java.lang.IllegalArgumentException("domain".concat(" can not be empty"));
         */
        public synchronized Builder asyncLookupDomains(String... strArr) {
            if (!com.tencent.msdk.dns.base.e.a.a((Object[]) strArr)) {
                if (this.mAsyncLookupDomains == null) {
                    this.mAsyncLookupDomains = com.tencent.msdk.dns.base.a.a.b(strArr.length);
                }
                int i = 0;
                if (this.mPreLookupDomains == null) {
                    int size = this.mAsyncLookupDomains.size();
                    int length = strArr.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str = strArr[i];
                        if (TextUtils.isEmpty(str)) {
                            break;
                        }
                        String trim = str.trim();
                        if (TextUtils.isEmpty(trim)) {
                            break;
                        }
                        this.mAsyncLookupDomains.add(trim);
                        size++;
                        if (this.mMaxNumOfPreLookupDomains <= size) {
                            break;
                        }
                        i++;
                    }
                } else {
                    int length2 = strArr.length;
                    while (i < length2) {
                        String str2 = strArr[i];
                        if (!TextUtils.isEmpty(str2)) {
                            String trim2 = str2.trim();
                            if (!TextUtils.isEmpty(trim2)) {
                                if (this.mPreLookupDomains.contains(trim2)) {
                                    this.mAsyncLookupDomains.add(trim2);
                                }
                                i++;
                            }
                        }
                        throw new IllegalArgumentException("domain".concat(" can not be empty"));
                    }
                }
            } else {
                throw new IllegalArgumentException("domains".concat(" can not be empty"));
            }
            return this;
        }

        Builder udp() {
            this.mChannel = "Udp";
            return this;
        }

        Builder aesHttp() {
            this.mChannel = "AesHttp";
            return this;
        }

        Builder desHttp() {
            this.mChannel = "DesHttp";
            return this;
        }

        Builder token(int i) {
            this.mToken = i;
            return this;
        }

        public Builder blockFirst() {
            this.mBlockFirst = true;
            return this;
        }

        public Builder nonBlockFirst() {
            this.mBlockFirst = false;
            return this;
        }

        public Builder executorSupplier(DnsExecutors.ExecutorSupplier executorSupplier) {
            if (executorSupplier != null) {
                this.mExecutorSupplier = executorSupplier;
                return this;
            }
            throw new IllegalArgumentException("executorSupplier".concat(" can not be null"));
        }

        public Builder lookedUpListener(ILookedUpListener iLookedUpListener) {
            if (iLookedUpListener != null) {
                this.mLookedUpListener = iLookedUpListener;
                return this;
            }
            throw new IllegalArgumentException("lookedUpListener".concat(" can not be null"));
        }

        public synchronized Builder logNode(ILogNode iLogNode) {
            if (iLogNode != null) {
                if (this.mLogNodes == null) {
                    this.mLogNodes = new ArrayList();
                }
                this.mLogNodes.add(iLogNode);
            } else {
                throw new IllegalArgumentException("logNode".concat(" can not be null"));
            }
            return this;
        }

        public synchronized Builder reporter(IReporter iReporter) {
            if (iReporter != null) {
                if (this.mReporters == null) {
                    this.mReporters = new ArrayList();
                }
                this.mReporters.add(iReporter);
            } else {
                throw new IllegalArgumentException("reporter".concat(" can not be null"));
            }
            return this;
        }

        public DnsConfig build() {
            return new DnsConfig(this.mLogLevel, this.mAppId, this.mUserId, this.mInitBuiltInReporters, this.mDnsId, this.mDnsKey, this.mTimeoutMills, this.mProtectedDomains, this.mPreLookupDomains, this.mAsyncLookupDomains, this.mChannel, this.mToken, this.mBlockFirst, this.mExecutorSupplier, this.mLookedUpListener, this.mLogNodes, this.mReporters);
        }
    }
}
