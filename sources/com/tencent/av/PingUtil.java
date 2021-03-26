package com.tencent.av;

import android.util.Log;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.timint.TIMIntManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PingUtil implements Runnable {
    private static final PingUtil instance = new PingUtil();
    private static final String tag = "av.PingUtil";
    TIMPingCallBack callback;
    DatagramChannel channel;
    InetAddress client;
    byte[] data;
    int interval;
    List<PingResult> pingResults = new ArrayList();
    int pkgNum;
    private volatile boolean running;
    List<ServerInfo> server = new ArrayList();
    Map<Integer, Calendar> timeRecord = new HashMap();
    int timeout;
    private TIMUser user;

    public static PingUtil getInstance() {
        return instance;
    }

    public void setUser(TIMUser tIMUser) {
        this.user = tIMUser;
    }

    public void init(byte[] bArr, TIMPingCallBack tIMPingCallBack) {
        try {
            byte[] bArr2 = new byte[4];
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            allocate.put(bArr);
            allocate.position(0);
            short s = allocate.getShort();
            int i = allocate.getInt();
            allocate.getShort();
            allocate.position(18);
            allocate.get();
            allocate.get(bArr2);
            InetAddress byAddress = InetAddress.getByAddress(bArr2);
            allocate.get();
            allocate.getShort();
            allocate.getShort();
            int i2 = allocate.getInt();
            int i3 = allocate.getInt();
            int i4 = allocate.getInt();
            int i5 = allocate.getInt();
            if (i5 <= allocate.remaining()) {
                byte[] bArr3 = new byte[i5];
                allocate.get(bArr3);
                allocate.get();
                byte b = allocate.get();
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < b; i6++) {
                    ServerInfo serverInfo = new ServerInfo();
                    for (int i7 = 3; i7 >= 0; i7--) {
                        bArr2[i7] = allocate.get();
                    }
                    serverInfo.ip = InetAddress.getByAddress(bArr2);
                    serverInfo.port = allocate.getShort();
                    serverInfo.setIDC(allocate.get());
                    serverInfo.setISP(allocate.get());
                    arrayList.add(serverInfo);
                }
                Log.d("av.PingUtil", "subcmd:" + ((int) s) + "|retcode:" + i + "|servers:" + arrayList.size());
                allocate.clear();
                this.server = arrayList;
                this.data = bArr3;
                this.interval = i2;
                this.pkgNum = i4;
                this.timeout = i3;
                this.callback = tIMPingCallBack;
                this.client = byAddress;
                if (tIMPingCallBack != null) {
                    tIMPingCallBack.onStart(arrayList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(ServerInfo serverInfo) throws IOException, InterruptedException {
        for (int i = 0; i < this.pkgNum && this.running; i++) {
            byte[] GetPingPackage = GetPingPackage(this.data);
            ByteBuffer allocate = ByteBuffer.allocate(GetPingPackage.length);
            allocate.put(GetPingPackage);
            allocate.flip();
            try {
                this.channel.write(allocate);
            } catch (Exception unused) {
            }
            allocate.clear();
            TIMPingCallBack tIMPingCallBack = this.callback;
            if (tIMPingCallBack != null) {
                tIMPingCallBack.onProgress(serverInfo, this.pkgNum, i);
            }
            Thread.sleep((long) this.interval);
        }
    }

    public void stop() {
        this.server.clear();
        this.pingResults.clear();
        this.timeRecord.clear();
        this.running = false;
    }

    public void start() {
        new Thread(instance).start();
        this.running = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        try {
            List<ServerInfo> list = this.server;
            if (list == null) {
                return;
            }
            if (list.size() != 0) {
                for (ServerInfo serverInfo : this.server) {
                    if (this.running) {
                        final ArrayList<Long> arrayList = new ArrayList();
                        final Selector open = Selector.open();
                        DatagramChannel open2 = DatagramChannel.open();
                        this.channel = open2;
                        open2.connect(new InetSocketAddress(serverInfo.ip, serverInfo.port));
                        int i2 = 0;
                        this.channel.configureBlocking(false);
                        this.channel.register(open, 1);
                        new Thread(new Runnable() {
                            /* class com.tencent.av.PingUtil.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                while (open.isOpen()) {
                                    try {
                                        if (open.select() != 0) {
                                            Iterator<SelectionKey> it2 = open.selectedKeys().iterator();
                                            while (it2.hasNext()) {
                                                if (it2.next().isReadable()) {
                                                    ByteBuffer allocate = ByteBuffer.allocate(600);
                                                    PingUtil.this.channel.read(allocate);
                                                    allocate.flip();
                                                    allocate.get();
                                                    allocate.getShort();
                                                    Calendar calendar = PingUtil.this.timeRecord.get(Integer.valueOf(allocate.getInt()));
                                                    if (calendar != null) {
                                                        arrayList.add(Long.valueOf(Calendar.getInstance().getTimeInMillis() - calendar.getTimeInMillis()));
                                                    }
                                                    it2.remove();
                                                }
                                            }
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }).start();
                        send(serverInfo);
                        if (this.running) {
                            while (true) {
                                if (i2 >= this.timeout / 100) {
                                    break;
                                } else if (arrayList.size() == this.pkgNum) {
                                    break;
                                } else {
                                    Thread.sleep(100);
                                    i2++;
                                }
                            }
                            open.close();
                            long j = 0;
                            long j2 = 0;
                            for (Long l : arrayList) {
                                if (l.longValue() < ((long) this.timeout)) {
                                    j++;
                                    j2 += l.longValue();
                                }
                            }
                            PingResult pingResult = new PingResult();
                            pingResult.server = serverInfo;
                            pingResult.receivePkg = (int) j;
                            pingResult.totalPkg = this.pkgNum;
                            if (j == 0) {
                                i = Integer.MAX_VALUE;
                            } else {
                                i = (int) (j2 / j);
                            }
                            pingResult.useTime = i;
                            this.pingResults.add(pingResult);
                            TIMPingCallBack tIMPingCallBack = this.callback;
                            if (tIMPingCallBack != null) {
                                tIMPingCallBack.onSuccess(pingResult);
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                logResult();
                reportToServer();
                TIMPingCallBack tIMPingCallBack2 = this.callback;
                if (tIMPingCallBack2 != null) {
                    tIMPingCallBack2.onFinish();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void logResult() {
        QLog.i("av.PingUtil", "ping result from " + this.pingResults.size() + " servers");
        for (PingResult pingResult : this.pingResults) {
            QLog.i("av.PingUtil", "serverIp:" + pingResult.server.ip.toString() + " useTime:" + pingResult.useTime + " totalPkg:" + pingResult.totalPkg + " receivePkg:" + pingResult.receivePkg);
        }
    }

    public byte[] GetPingPackage(byte[] bArr) {
        int length = bArr.length + 46 + 1;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.put((byte) 2);
        allocate.put(getLongConnUdtDataHeadV2((short) length, 469));
        allocate.putInt(bArr.length);
        allocate.put(bArr);
        allocate.put((byte) 3);
        return allocate.array();
    }

    private byte[] getLongConnUdtDataHeadV2(short s, short s2) {
        long j;
        TIMUser tIMUser = this.user;
        if (tIMUser == null) {
            QLog.e("av.PingUtil", "user is empty: ");
            j = 0;
        } else {
            j = tIMUser.getTinyId();
        }
        ByteBuffer allocate = ByteBuffer.allocate(41);
        int nextInt = TIMAvManager.getInstance().random.nextInt();
        allocate.putShort(s);
        allocate.putInt(nextInt);
        allocate.putShort(s2);
        allocate.putLong(j);
        allocate.putInt(0);
        allocate.putInt(0);
        allocate.putShort(0);
        allocate.putLong(0);
        allocate.put((byte) 0);
        allocate.putInt(nextInt);
        allocate.putShort(0);
        Calendar instance2 = Calendar.getInstance();
        this.timeRecord.put(Integer.valueOf(nextInt), instance2);
        QLog.i("av.PingUtil", "send seq " + nextInt + " time " + instance2.getTimeInMillis());
        return allocate.array();
    }

    private void reportToServer() {
        if (this.user == null) {
            QLog.e("av.PingUtil", "user is empty: ");
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate((this.pingResults.size() * 30) + 19 + 2 + 2);
        int sdkAppId = TIMManager.getInstance().getSdkConfig().getSdkAppId();
        int i = this.interval;
        allocate.clear();
        allocate.put((byte) 2).put((byte) 1).putShort(7).putShort(6).putInt(sdkAppId).putInt(23678484).putInt(i).put((byte) this.pingResults.size());
        for (PingResult pingResult : this.pingResults) {
            allocate.put(pingResult.server.ip.getAddress());
            allocate.putShort(pingResult.server.port);
            allocate.put(pingResult.server.getIdcNo());
            allocate.put(pingResult.server.getIspNo());
            allocate.put(this.client.getAddress());
            allocate.putInt(this.pkgNum);
            allocate.putInt(pingResult.receivePkg);
            allocate.putInt(pingResult.useTime);
            allocate.putInt(0);
            allocate.putShort(0);
        }
        allocate.putShort(0);
        allocate.putShort(0);
        TIMIntManager.getInstance().requestMultiVideoInfo(NetworkUtil.formReq(this.user.getTinyId(), 210, 0, "", allocate.array()), new TIMValueCallBack<byte[]>() {
            /* class com.tencent.av.PingUtil.AnonymousClass2 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                QLog.e("av.PingUtil", "reportError: code " + i + " desc " + str);
            }

            public void onSuccess(byte[] bArr) {
                QLog.e("av.PingUtil", "ping report Success");
            }
        });
        this.running = false;
    }
}
