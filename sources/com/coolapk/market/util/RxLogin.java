package com.coolapk.market.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.LongSparseArray;
import androidx.appcompat.app.AppCompatActivity;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.widget.Toast;
import java.lang.ref.WeakReference;
import rx.Observable;
import rx.Subscriber;

public class RxLogin {
    private static RxLogin sInstance;
    private Context context;
    private LongSparseArray<WeakReference<Subscriber<? super Boolean>>> mSubscriberMap = new LongSparseArray<>();

    public static RxLogin getInstance(Context context2) {
        if (sInstance == null) {
            sInstance = new RxLogin(context2);
        }
        return sInstance;
    }

    private RxLogin(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public Observable<Boolean> requestLogin() {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            /* class com.coolapk.market.util.RxLogin.AnonymousClass1 */

            public void call(Subscriber<? super Boolean> subscriber) {
                if (DataManager.getInstance().getLoginSession().isLogin()) {
                    subscriber.onNext(true);
                    subscriber.onCompleted();
                    return;
                }
                RxLogin.this.startActivity(subscriber);
            }
        });
    }

    /* access modifiers changed from: private */
    public void startActivity(Subscriber<? super Boolean> subscriber) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mSubscriberMap.put(currentTimeMillis, new WeakReference<>(subscriber));
        Intent intent = new Intent(this.context, RequireLoginActivity.class);
        intent.putExtra("time", currentTimeMillis);
        intent.addFlags(268435456);
        intent.addFlags(65536);
        this.context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void onLoginResult(Long l) {
        for (int i = 0; i < this.mSubscriberMap.size(); i++) {
            WeakReference<Subscriber<? super Boolean>> valueAt = this.mSubscriberMap.valueAt(i);
            if (valueAt != null) {
                Subscriber<? super Boolean> subscriber = valueAt.get();
                if (subscriber != null) {
                    subscriber.onNext(Boolean.valueOf(DataManager.getInstance().getLoginSession().isLogin()));
                    subscriber.onCompleted();
                }
            } else {
                return;
            }
        }
        this.mSubscriberMap.clear();
    }

    public static class RequireLoginActivity extends AppCompatActivity {
        public static final int REQUEST_CODE = 2311;

        @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            ThemeUtils.setTranslucentStatusBar(this);
            ActionManager.startLoginActivity(this, "https://account.coolapk.com/auth/login?type=coolapk", 2311);
            Toast.show(this, 2131887022);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            RxLogin.getInstance(this).onLoginResult(Long.valueOf(getIntent().getLongExtra("time", 0)));
            finish();
            overridePendingTransition(0, 0);
        }
    }
}
