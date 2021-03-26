package com.tencent.av;

import java.net.InetAddress;

public class ServerInfo {
    public IDC idc;
    private byte idcNo;
    public InetAddress ip;
    public ServerType isp;
    private byte ispNo;
    public short port;

    public enum IDC {
        UNKNOW,
        SH,
        SZ,
        CD,
        TJ,
        NJ,
        HZ,
        GZ
    }

    public enum ServerType {
        UNKNOW,
        TEL,
        CNC,
        CMCC
    }

    protected byte getIdcNo() {
        return this.idcNo;
    }

    protected byte getIspNo() {
        return this.ispNo;
    }

    protected void setIDC(byte b) {
        this.idcNo = b;
        switch (b) {
            case 1:
                this.idc = IDC.SH;
                return;
            case 2:
                this.idc = IDC.SZ;
                return;
            case 3:
                this.idc = IDC.CD;
                return;
            case 4:
                this.idc = IDC.TJ;
                return;
            case 5:
                this.idc = IDC.NJ;
                return;
            case 6:
                this.idc = IDC.HZ;
                return;
            case 7:
                this.idc = IDC.GZ;
                return;
            default:
                this.idc = IDC.UNKNOW;
                return;
        }
    }

    protected void setISP(byte b) {
        this.ispNo = b;
        if (b == 2) {
            this.isp = ServerType.TEL;
        } else if (b == 3) {
            this.isp = ServerType.CNC;
        } else if (b != 5) {
            this.isp = ServerType.UNKNOW;
        } else {
            this.isp = ServerType.CMCC;
        }
    }
}
