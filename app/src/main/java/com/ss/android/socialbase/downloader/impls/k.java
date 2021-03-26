package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DownloadCache */
public class k implements i {
    private final SparseArray<DownloadInfo> a = new SparseArray<>();
    private final SparseArray<List<b>> b = new SparseArray<>();
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.f.i>> c = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i, int i2, int i3, int i4) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(int i, List<b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean c() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean d() {
        return false;
    }

    public SparseArray<DownloadInfo> a() {
        return this.a;
    }

    public SparseArray<List<b>> e() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo g(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setStatus(2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo b(int i) {
        DownloadInfo downloadInfo;
        synchronized (this.a) {
            try {
                downloadInfo = this.a.get(i);
            } catch (Exception e) {
                e.printStackTrace();
                downloadInfo = null;
            }
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> a(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            try {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    DownloadInfo valueAt = this.a.valueAt(i);
                    if (str != null && str.equals(valueAt.getUrl())) {
                        arrayList.add(valueAt);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.a) {
            if (this.a.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.a.size(); i++) {
                DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i));
                if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                    arrayList.add(downloadInfo);
                }
            }
            return arrayList;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.a) {
            if (this.a.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.a.size(); i++) {
                DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i));
                if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                    arrayList.add(downloadInfo);
                }
            }
            return arrayList;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.a) {
            if (this.a.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.a.size(); i++) {
                DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i));
                if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                    arrayList.add(downloadInfo);
                }
            }
            return arrayList;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<b> c(int i) {
        return this.b.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public synchronized void d(int i) {
        this.b.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public synchronized void a(b bVar) {
        int k = bVar.k();
        List<b> list = this.b.get(k);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(k, list);
        }
        list.add(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i, int i2, long j) {
        List<b> c2 = c(i);
        if (c2 != null) {
            for (b bVar : c2) {
                if (bVar != null && bVar.s() == i2) {
                    bVar.b(j);
                    return;
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i, int i2, int i3, long j) {
        List<b> c2 = c(i);
        if (c2 != null) {
            for (b bVar : c2) {
                if (!(bVar == null || bVar.s() != i3 || bVar.f())) {
                    if (bVar.g() != null) {
                        for (b bVar2 : bVar.g()) {
                            if (bVar2 != null && bVar2.s() == i2) {
                                bVar2.b(j);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo a(int i, int i2) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setChunkCount(i2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean a(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        synchronized (this.a) {
            if (this.a.get(downloadInfo.getId()) == null) {
                z = false;
            }
            this.a.put(downloadInfo.getId(), downloadInfo);
        }
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean e(int i) {
        synchronized (this.a) {
            this.a.remove(i);
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean f(int i) {
        e(i);
        d(i);
        m(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b() {
        synchronized (this.a) {
            this.a.clear();
            this.b.clear();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo a(int i, long j, String str, String str2) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setTotalBytes(j);
            b2.seteTag(str);
            if (TextUtils.isEmpty(b2.getName()) && !TextUtils.isEmpty(str2)) {
                b2.setName(str2);
            }
            b2.setStatus(3);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo a(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setCurBytes(j, false);
            if (!(b2.getStatus() == -3 || b2.getStatus() == -2 || DownloadStatus.isFailedStatus(b2.getStatus()) || b2.getStatus() == -4)) {
                b2.setStatus(4);
            }
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo b(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setCurBytes(j, false);
            b2.setStatus(-1);
            b2.setFirstDownload(false);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo h(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setStatus(5);
            b2.setFirstDownload(false);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo c(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setCurBytes(j, false);
            b2.setStatus(-3);
            b2.setFirstDownload(false);
            b2.setFirstSuccess(false);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo d(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setCurBytes(j, false);
            b2.setStatus(-2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo i(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setStatus(1);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo j(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setStatus(-7);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(DownloadInfo downloadInfo) {
        a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i, List<b> list) {
        if (list != null) {
            d(i);
            for (b bVar : list) {
                if (bVar != null) {
                    a(bVar);
                    if (bVar.f()) {
                        for (b bVar2 : bVar.g()) {
                            a(bVar2);
                        }
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<com.ss.android.socialbase.downloader.f.i> n(int i) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> map = this.c.get(i);
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new ArrayList(map.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i) {
        return this.c.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean a(int i, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.c.put(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void m(int i) {
        this.c.remove(i);
    }
}
