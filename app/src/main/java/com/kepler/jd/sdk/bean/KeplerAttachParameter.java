package com.kepler.jd.sdk.bean;

import com.kepler.jd.sdk.exception.KeplerAttachException;
import com.kepler.jd.sdk.exception.KeplerBufferOverflowException;
import com.kepler.sdk.af;
import com.kepler.sdk.ag;
import com.kepler.sdk.j;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

public class KeplerAttachParameter implements Serializable {
    private HashMap<String, String> mapAttachParameter = new HashMap<>();

    public String putKeplerAttachParameter(String str, String str2) throws KeplerBufferOverflowException, KeplerAttachException {
        if (af.a(str)) {
            throw new KeplerAttachException("put key isEmpty");
        } else if (af.a(str2)) {
            return this.mapAttachParameter.put(str, ag.a("null"));
        } else {
            String a = ag.a(ag.a(str2));
            j.b("suwg", a);
            if (a.length() <= 256) {
                return this.mapAttachParameter.put(str, ag.a(str2));
            }
            throw new KeplerBufferOverflowException("customerInfo string url encode length must <=256 bytes," + a.length());
        }
    }

    public String get(String str) {
        String str2 = this.mapAttachParameter.get(str);
        return !af.a(str2) ? str2 : "null";
    }

    public void add2Map(Hashtable<String, String> hashtable) {
        if (hashtable != null) {
            for (String str : this.mapAttachParameter.keySet()) {
                hashtable.put(str, this.mapAttachParameter.get(str));
            }
        }
    }

    public void reset() {
        this.mapAttachParameter.clear();
    }
}
