package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        String str4 = (String) Preconditions.checkNotNull(str);
        this.mProviderAuthority = str4;
        String str5 = (String) Preconditions.checkNotNull(str2);
        this.mProviderPackage = str5;
        String str6 = (String) Preconditions.checkNotNull(str3);
        this.mQuery = str6;
        this.mCertificates = (List) Preconditions.checkNotNull(list);
        this.mCertificatesArray = 0;
        this.mIdentifier = str4 + "-" + str5 + "-" + str6;
    }

    public FontRequest(String str, String str2, String str3, int i) {
        String str4 = (String) Preconditions.checkNotNull(str);
        this.mProviderAuthority = str4;
        String str5 = (String) Preconditions.checkNotNull(str2);
        this.mProviderPackage = str5;
        String str6 = (String) Preconditions.checkNotNull(str3);
        this.mQuery = str6;
        this.mCertificates = null;
        Preconditions.checkArgument(i != 0);
        this.mCertificatesArray = i;
        this.mIdentifier = str4 + "-" + str5 + "-" + str6;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        for (int i = 0; i < this.mCertificates.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.mCertificates.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.mCertificatesArray);
        return sb.toString();
    }
}
