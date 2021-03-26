package com.bytedance.sdk.openadsdk.core.video.e;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;

/* compiled from: MediaUtils */
public class b {

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.e.b$b  reason: collision with other inner class name */
    /* compiled from: MediaUtils */
    public interface AbstractC0045b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, AbstractC0045b bVar) {
        new a(bVar, j).execute(str);
    }

    /* compiled from: MediaUtils */
    public static class a extends AsyncTask<String, Integer, Bitmap> {
        private AbstractC0045b a;
        private long b = 0;

        public a(AbstractC0045b bVar, long j) {
            this.a = bVar;
            this.b = j;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.b * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                u.c("MediaUtils", "MediaUtils doInBackground : ", th);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            AbstractC0045b bVar = this.a;
            if (bVar != null) {
                bVar.a(bitmap);
            }
        }
    }
}
