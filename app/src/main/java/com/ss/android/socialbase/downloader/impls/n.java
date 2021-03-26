package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.a;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* compiled from: IndependentDownloadServiceHandler */
public class n extends a implements ServiceConnection {
    private static final String e = "n";
    private h f;
    private m g;
    private int h = -1;

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void a(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.c.a.b(e, "bindService");
            Intent intent = new Intent(context, IndependentProcessDownloadService.class);
            if (e.a()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.g.a.c().a("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public IBinder a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            Log.w(e, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.g.a.a("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.c.a.b(e, "onBind IndependentDownloadBinder");
        return new m();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void b(DownloadTask downloadTask) {
        if (downloadTask != null) {
            String str = e;
            StringBuilder sb = new StringBuilder();
            sb.append("tryDownload aidlService == null:");
            sb.append(this.f == null);
            com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
            if (this.f == null) {
                a(downloadTask);
                a(b.L(), this);
                return;
            }
            if (this.a.get(downloadTask.getDownloadId()) != null) {
                synchronized (this.a) {
                    if (this.a.get(downloadTask.getDownloadId()) != null) {
                        this.a.remove(downloadTask.getDownloadId());
                    }
                }
            }
            try {
                this.f.a(f.a(downloadTask));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            synchronized (this.a) {
                SparseArray clone = this.a.clone();
                this.a.clear();
                if (b.C() != null) {
                    for (int i = 0; i < clone.size(); i++) {
                        if (((DownloadTask) clone.get(clone.keyAt(i))) != null) {
                            try {
                                this.f.a(f.a(downloadTask));
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void c(DownloadTask downloadTask) {
        if (downloadTask != null) {
            c.a().a(downloadTask.getDownloadId(), true);
            a C = b.C();
            if (C != null) {
                C.a(downloadTask);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = e;
        com.ss.android.socialbase.downloader.c.a.b(str, "onServiceConnected ");
        this.f = h.a.a(iBinder);
        m mVar = this.g;
        if (mVar != null) {
            mVar.a(iBinder);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onServiceConnected aidlService!=null");
        sb.append(this.f != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.a.size());
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        if (this.f != null) {
            c.a().b();
            this.b = true;
            this.d = false;
            int i = this.h;
            if (i != -1) {
                try {
                    this.f.l(i);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            synchronized (this.a) {
                if (this.f != null) {
                    SparseArray clone = this.a.clone();
                    this.a.clear();
                    for (int i2 = 0; i2 < clone.size(); i2++) {
                        DownloadTask downloadTask = (DownloadTask) clone.get(clone.keyAt(i2));
                        if (downloadTask != null) {
                            try {
                                this.f.a(f.a(downloadTask));
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.c.a.b(e, "onServiceDisconnected ");
        this.f = null;
        this.b = false;
        m mVar = this.g;
        if (mVar != null) {
            mVar.h();
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.f = null;
        m mVar = this.g;
        if (mVar != null) {
            mVar.h();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void a(m mVar) {
        this.g = mVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        h hVar = this.f;
        if (hVar == null) {
            this.h = i;
            return;
        }
        try {
            hVar.l(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        if (this.f == null) {
            a(b.L(), this);
        }
    }
}
