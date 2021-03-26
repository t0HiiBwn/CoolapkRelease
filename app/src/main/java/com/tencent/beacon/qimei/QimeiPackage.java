package com.tencent.beacon.qimei;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;

public final class QimeiPackage extends JceStruct implements Cloneable {
    public String androidId = "";
    public String brand = "";
    public boolean broot = false;
    public String cid = "";
    public String imei = "";
    public String imsi = "";
    public String mac = "";
    public String model = "";
    public String osVersion = "";
    public String qimei = "";
    public String qq = "";

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void writeTo(b bVar) {
        String str = this.qimei;
        if (str != null) {
            bVar.a(str, 0);
        }
        String str2 = this.imei;
        if (str2 != null) {
            bVar.a(str2, 1);
        }
        String str3 = this.mac;
        if (str3 != null) {
            bVar.a(str3, 2);
        }
        String str4 = this.imsi;
        if (str4 != null) {
            bVar.a(str4, 3);
        }
        String str5 = this.androidId;
        if (str5 != null) {
            bVar.a(str5, 4);
        }
        String str6 = this.model;
        if (str6 != null) {
            bVar.a(str6, 5);
        }
        String str7 = this.brand;
        if (str7 != null) {
            bVar.a(str7, 6);
        }
        String str8 = this.osVersion;
        if (str8 != null) {
            bVar.a(str8, 7);
        }
        bVar.a(this.broot, 8);
        String str9 = this.qq;
        if (str9 != null) {
            bVar.a(str9, 9);
        }
        String str10 = this.cid;
        if (str10 != null) {
            bVar.a(str10, 10);
        }
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void readFrom(a aVar) {
        this.qimei = aVar.b(0, false);
        this.imei = aVar.b(1, false);
        this.mac = aVar.b(2, false);
        this.imsi = aVar.b(3, false);
        this.androidId = aVar.b(4, false);
        this.model = aVar.b(5, false);
        this.brand = aVar.b(6, false);
        this.osVersion = aVar.b(7, false);
        this.broot = aVar.a(8, false);
        this.qq = aVar.b(9, false);
        this.cid = aVar.b(10, false);
    }
}
