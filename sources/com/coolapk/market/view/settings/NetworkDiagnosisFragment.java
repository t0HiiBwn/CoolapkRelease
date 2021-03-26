package com.coolapk.market.view.settings;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.NetworkDiagnosisBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;

public class NetworkDiagnosisFragment extends BaseFragment {
    private static final String VALID_IP_ADDRESS_REGEX = "\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b";
    private NetworkDiagnosisBinding mBinding;
    private ConnectivityManager mConManager;
    private NetworkInfo mNetInfo;
    private Subscription mSubscribetion;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NetworkDiagnosisBinding networkDiagnosisBinding = (NetworkDiagnosisBinding) DataBindingUtil.inflate(layoutInflater, 2131559052, viewGroup, false);
        this.mBinding = networkDiagnosisBinding;
        return networkDiagnosisBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        restoreStartState();
        this.mBinding.copy.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.settings.NetworkDiagnosisFragment.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetworkDiagnosisFragment.this.copyText();
            }
        });
        printInfos();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Subscription subscription = this.mSubscribetion;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscribetion.unsubscribe();
        }
    }

    /* access modifiers changed from: private */
    public void restoreStartState() {
        this.mBinding.start.setText(2131886150);
        this.mBinding.start.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.settings.NetworkDiagnosisFragment.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetworkDiagnosisFragment.this.printInfos();
            }
        });
    }

    /* access modifiers changed from: private */
    public void printInfos() {
        this.mSubscribetion = collectInfos().compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new Action0() {
            /* class com.coolapk.market.view.settings.$$Lambda$NetworkDiagnosisFragment$AY9RSQ8MIxPePZBSBAu72rxrfT0 */

            @Override // rx.functions.Action0
            public final void call() {
                NetworkDiagnosisFragment.this.lambda$printInfos$0$NetworkDiagnosisFragment();
            }
        }).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.settings.$$Lambda$NetworkDiagnosisFragment$exZQzWN1eoP6tEwD4jjwQz2DZfc */

            @Override // rx.functions.Action0
            public final void call() {
                NetworkDiagnosisFragment.this.restoreStartState();
            }
        }).subscribe((Subscriber<? super R>) new Subscriber<CharSequence>() {
            /* class com.coolapk.market.view.settings.NetworkDiagnosisFragment.AnonymousClass3 */

            @Override // rx.Observer
            public void onCompleted() {
                NetworkDiagnosisFragment.this.mBinding.copy.setVisibility(0);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                NetworkDiagnosisFragment.this.addText(StringUtils.emptyIfNull(th.getMessage()));
            }

            public void onNext(CharSequence charSequence) {
                NetworkDiagnosisFragment.this.addText(charSequence);
            }

            @Override // rx.Subscriber
            public void onStart() {
                super.onStart();
                NetworkDiagnosisFragment.this.mBinding.copy.setVisibility(4);
                NetworkDiagnosisFragment networkDiagnosisFragment = NetworkDiagnosisFragment.this;
                networkDiagnosisFragment.mConManager = (ConnectivityManager) networkDiagnosisFragment.getActivity().getSystemService("connectivity");
                NetworkDiagnosisFragment networkDiagnosisFragment2 = NetworkDiagnosisFragment.this;
                networkDiagnosisFragment2.mNetInfo = networkDiagnosisFragment2.mConManager.getActiveNetworkInfo();
                NetworkDiagnosisFragment.this.clearText();
            }
        });
    }

    public /* synthetic */ void lambda$printInfos$0$NetworkDiagnosisFragment() {
        this.mBinding.start.setText("停止测试");
        this.mBinding.start.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.settings.NetworkDiagnosisFragment.AnonymousClass4 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RxUtils.unsubscribe(NetworkDiagnosisFragment.this.mSubscribetion);
                NetworkDiagnosisFragment.this.restoreStartState();
                NetworkDiagnosisFragment.this.clearText();
            }
        });
    }

    private Observable<CharSequence> collectInfos() {
        return Observable.create(new Observable.OnSubscribe<CharSequence>() {
            /* class com.coolapk.market.view.settings.NetworkDiagnosisFragment.AnonymousClass5 */

            public void call(Subscriber<? super CharSequence> subscriber) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("网络是否连接: ");
                    sb.append(NetworkDiagnosisFragment.this.isNetworkConnected() ? "是" : "否");
                    sb.append("\n");
                    subscriber.onNext(sb.toString());
                    if (NetworkDiagnosisFragment.this.isNetworkConnected()) {
                        subscriber.onNext("网络类型: ");
                        subscriber.onNext(NetworkDiagnosisFragment.this.getNetworkType() + "\n");
                        subscriber.onNext("服务状态: ");
                        subscriber.onNext(NetworkDiagnosisFragment.this.textPing() + "\n");
                        subscriber.onNext("当前API: ");
                        subscriber.onNext(NetworkDiagnosisFragment.this.getApiHost() + "\n");
                        subscriber.onNext("本机IP: ");
                        subscriber.onNext(NetworkDiagnosisFragment.this.getIPAddress() + "\n");
                        subscriber.onNext("\n");
                        addPing(subscriber, "api.coolapk.com");
                        addPing(subscriber, "api2.coolapk.com");
                        addPing(subscriber, "www.coolapk.com");
                        addPing(subscriber, "m.coolapk.com");
                        addPing(subscriber, "dl.coolapk.com");
                        addPing(subscriber, "dl.coolapkmarket.com");
                        addPing(subscriber, "dl-cdn.coolapkmarket.com");
                        addPing(subscriber, "image.coolapk.com");
                        addPing(subscriber, "dd.myapp.com");
                        addPing(subscriber, "gdown.baidu.com");
                        addPing(subscriber, "m.shouji.360tpcdn.com");
                        addPing(subscriber, "apps.wandoujia.com");
                        addPing(subscriber, "downum.game.uc.cn");
                        addPing(subscriber, "api.np.mobilem.360.cn");
                        addPing(subscriber, "imtt.dd.qq.com");
                        subscriber.onNext("\n");
                        subscriber.onNext("测试完毕");
                    } else {
                        subscriber.onNext("网络未连接，无法测试...");
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
                subscriber.onCompleted();
            }

            private void addPing(Subscriber<? super CharSequence> subscriber, String str) {
                subscriber.onNext("");
                subscriber.onNext("PING [" + str + "] --> \n");
                StringBuilder sb = new StringBuilder();
                sb.append("ping -c 2 ");
                sb.append(str);
                subscriber.onNext(NetworkDiagnosisFragment.executeCmd(sb.toString(), false).replaceAll("\n+", "\n"));
                subscriber.onNext("\n");
            }

            private String findIp(String str) {
                Matcher matcher = Pattern.compile("\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b").matcher(str);
                if (matcher.find()) {
                    return matcher.group(0);
                }
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void addText(CharSequence charSequence) {
        this.mBinding.text.append(charSequence);
    }

    /* access modifiers changed from: private */
    public void clearText() {
        this.mBinding.text.setText("");
    }

    /* access modifiers changed from: private */
    public void copyText() {
        ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("textFromCoolapk", this.mBinding.text.getText()));
        Toast.show(getActivity(), "结果已复制");
    }

    /* access modifiers changed from: private */
    public boolean isNetworkConnected() {
        NetworkInfo networkInfo = this.mNetInfo;
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    /* access modifiers changed from: private */
    public String getNetworkType() {
        return this.mNetInfo.getTypeName();
    }

    public String getIPAddress() {
        return DataManager.getInstance().getIpAddress().map(RxUtils.checkResultToData()).onErrorResumeNext(Observable.just("Unknown host")).toBlocking().first();
    }

    public String textPing() {
        return DataManager.getInstance().getIpAddress().map(RxUtils.checkResultToData()).onErrorReturn(new Func1<Throwable, String>() {
            /* class com.coolapk.market.view.settings.NetworkDiagnosisFragment.AnonymousClass6 */

            public String call(Throwable th) {
                if ((th instanceof RuntimeException) && th.getCause() != null) {
                    th = th.getCause();
                }
                return th.getMessage();
            }
        }).toBlocking().first();
    }

    public String getApiHost() {
        return DataManager.getInstance().getDataConfig().getApiHost();
    }

    public static String executeCmd(String str, boolean z) {
        Process process;
        if (!z) {
            try {
                process = Runtime.getRuntime().exec(str);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } else {
            process = Runtime.getRuntime().exec(new String[]{"su", "-c", str});
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine + "\n";
            } else {
                process.destroy();
                return str2;
            }
        }
    }
}
