package androidx.work.impl.model;

public class Preference {
    public String mKey;
    public Long mValue;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Preference(String str, boolean z) {
        this(str, z ? 1 : 0);
    }

    public Preference(String str, long j) {
        this.mKey = str;
        this.mValue = Long.valueOf(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        if (!this.mKey.equals(preference.mKey)) {
            return false;
        }
        Long l2 = this.mValue;
        Long l3 = preference.mValue;
        if (l2 != null) {
            return l2.equals(l3);
        }
        if (l3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.mKey.hashCode() * 31;
        Long l2 = this.mValue;
        return hashCode + (l2 != null ? l2.hashCode() : 0);
    }
}
