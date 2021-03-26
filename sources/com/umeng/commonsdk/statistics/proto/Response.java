package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.ci;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cm;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.cp;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cr;
import com.umeng.analytics.pro.cs;
import com.umeng.analytics.pro.ct;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Response implements bi<Response, e>, Serializable, Cloneable {
    private static final cc IMPRINT_FIELD_DESC = new cc("imprint", (byte) 12, 3);
    private static final cc MSG_FIELD_DESC = new cc("msg", (byte) 11, 2);
    private static final cc RESP_CODE_FIELD_DESC = new cc("resp_code", (byte) 8, 1);
    private static final cm STRUCT_DESC = new cm("Response");
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, bu> metaDataMap;
    private static final Map<Class<? extends cp>, cq> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;

    static {
        HashMap hashMap = new HashMap();
        schemes = hashMap;
        hashMap.put(cr.class, new b());
        hashMap.put(cs.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.RESP_CODE, (e) new bu("resp_code", (byte) 1, new bv((byte) 8)));
        enumMap.put((EnumMap) e.MSG, (e) new bu("msg", (byte) 2, new bv((byte) 11)));
        enumMap.put((EnumMap) e.IMPRINT, (e) new bu("imprint", (byte) 2, new bz((byte) 12, d.class)));
        Map<e, bu> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = unmodifiableMap;
        bu.a(Response.class, unmodifiableMap);
    }

    public enum e implements bp {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, "imprint");
        
        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it2 = EnumSet.allOf(e.class).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                d.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i == 1) {
                return RESP_CODE;
            }
            if (i == 2) {
                return MSG;
            }
            if (i != 3) {
                return null;
            }
            return IMPRINT;
        }

        public static e b(int i) {
            e a = a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return d.get(str);
        }

        private e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.bp
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.bp
        public String b() {
            return this.f;
        }
    }

    public Response() {
        this.__isset_bitfield = 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new d(response.imprint);
        }
    }

    /* Return type fixed from 'com.umeng.commonsdk.statistics.proto.Response' to match base method */
    @Override // com.umeng.analytics.pro.bi
    public bi<Response, e> deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = bf.b(this.__isset_bitfield, 0);
    }

    public boolean isSetResp_code() {
        return bf.a(this.__isset_bitfield, 0);
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = bf.a(this.__isset_bitfield, 0, z);
    }

    public String getMsg() {
        return this.msg;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public void setMsgIsSet(boolean z) {
        if (!z) {
            this.msg = null;
        }
    }

    public d getImprint() {
        return this.imprint;
    }

    public Response setImprint(d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public void setImprintIsSet(boolean z) {
        if (!z) {
            this.imprint = null;
        }
    }

    @Override // com.umeng.analytics.pro.bi
    public e fieldForId(int i) {
        return e.a(i);
    }

    @Override // com.umeng.analytics.pro.bi
    public void read(ch chVar) throws bo {
        schemes.get(chVar.D()).b().b(chVar, this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void write(ch chVar) throws bo {
        schemes.get(chVar.D()).b().a(chVar, this);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            d dVar = this.imprint;
            if (dVar == null) {
                sb.append("null");
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws bo {
        d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cb(new ct(objectOutputStream)));
        } catch (bo e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = 0;
            read(new cb(new ct(objectInputStream)));
        } catch (bo e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private static class b implements cq {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    private static class a extends cr<Response> {
        private a() {
        }

        /* renamed from: a */
        public void b(ch chVar, Response response) throws bo {
            chVar.j();
            while (true) {
                cc l2 = chVar.l();
                if (l2.b == 0) {
                    break;
                }
                short s = l2.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            ck.a(chVar, l2.b);
                        } else if (l2.b == 12) {
                            response.imprint = new d();
                            response.imprint.read(chVar);
                            response.setImprintIsSet(true);
                        } else {
                            ck.a(chVar, l2.b);
                        }
                    } else if (l2.b == 11) {
                        response.msg = chVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        ck.a(chVar, l2.b);
                    }
                } else if (l2.b == 8) {
                    response.resp_code = chVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    ck.a(chVar, l2.b);
                }
                chVar.m();
            }
            chVar.k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            throw new ci("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }

        /* renamed from: b */
        public void a(ch chVar, Response response) throws bo {
            response.validate();
            chVar.a(Response.STRUCT_DESC);
            chVar.a(Response.RESP_CODE_FIELD_DESC);
            chVar.a(response.resp_code);
            chVar.c();
            if (response.msg != null && response.isSetMsg()) {
                chVar.a(Response.MSG_FIELD_DESC);
                chVar.a(response.msg);
                chVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                chVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(chVar);
                chVar.c();
            }
            chVar.d();
            chVar.b();
        }
    }

    private static class d implements cq {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    private static class c extends cs<Response> {
        private c() {
        }

        public void a(ch chVar, Response response) throws bo {
            cn cnVar = (cn) chVar;
            cnVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            cnVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                cnVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(cnVar);
            }
        }

        public void b(ch chVar, Response response) throws bo {
            cn cnVar = (cn) chVar;
            response.resp_code = cnVar.w();
            response.setResp_codeIsSet(true);
            BitSet b = cnVar.b(2);
            if (b.get(0)) {
                response.msg = cnVar.z();
                response.setMsgIsSet(true);
            }
            if (b.get(1)) {
                response.imprint = new d();
                response.imprint.read(cnVar);
                response.setImprintIsSet(true);
            }
        }
    }
}
