package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.android.tpush.logging.TLogger;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
public class f extends AsyncTask<Void, Void, Bitmap> {
    private String a;
    private View b;
    private Context c;
    private int d;

    public f(String str, View view, Context context, int i) {
        this.a = str;
        this.b = view;
        this.c = context;
        this.d = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (Exception e) {
            TLogger.e("ImageLoadTask", "InAppMsg ImageLoadTask doInBackground :" + e.toString());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        try {
            View view = this.b;
            if (view == null) {
                return;
            }
            if (view instanceof ImageView) {
                if (bitmap != null) {
                    ((ImageView) view).setImageBitmap(bitmap);
                }
            } else if ((view instanceof RelativeLayout) && bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f = (float) width;
                Matrix matrix = new Matrix();
                matrix.postScale(f / f, ((float) this.b.getHeight()) / ((float) height));
                RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(this.c.getResources(), Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true));
                create.setAntiAlias(true);
                create.setCornerRadius((float) this.d);
                this.b.setBackground(create);
            }
        } catch (Throwable th) {
            TLogger.e("ImageLoadTask", "InAppMsg ImageLoadTask onPostExecute :" + th.toString());
        }
    }
}
