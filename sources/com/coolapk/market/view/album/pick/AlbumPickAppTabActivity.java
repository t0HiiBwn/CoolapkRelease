package com.coolapk.market.view.album.pick;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.coolapk.market.event.AlbumaddEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.SimpleAlbumItem;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.view.collection.FavoriteApkPresenter;
import com.coolapk.market.view.search.SearchAppPresenter;
import com.coolapk.market.view.user.UserFollowAppPresenter;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.TabLayout;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class AlbumPickAppTabActivity extends TabActivity {
    public static final String EXTRA_ALBUM = "EXTRA_ALBUM";
    private static final String EXTRA_PAGE_INDEX = "PAGE_INDEX";
    private static final int PAGE_COLLECTION = 2;
    private static final int PAGE_FOLLOW = 1;
    private static final int PAGE_LOCAL = 0;
    private static final int PAGE_SEARCH = 3;
    private final Map<String, AlbumItem> commitApps = new HashMap();
    private ProgressDialog dialog;
    private Album mAlbum;
    private final List<SimpleAlbumItem> newAlbumItems = new ArrayList();
    private final AtomicInteger pageCounter = new AtomicInteger(1);
    private final ArrayList<AlbumItem> result = new ArrayList<>();

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void initSearchMenu() {
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{getString(2131887351), getString(2131887350), getString(2131887349), getString(2131887352)};
    }

    public void onDone() {
        if (this.commitApps.isEmpty()) {
            Toast.show(getActivity(), getString(2131887075));
            return;
        }
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        this.dialog = progressDialog;
        progressDialog.setProgressStyle(0);
        this.dialog.setCancelable(false);
        this.dialog.show();
        for (Map.Entry<String, AlbumItem> entry : this.commitApps.entrySet()) {
            this.result.add(this.commitApps.get(entry.getKey()));
        }
        Collections.sort(this.result, $$Lambda$AlbumPickAppTabActivity$lf6IevDKRhY9NHnpDBO24LgTHXI.INSTANCE);
        this.dialog.setMessage(getString(2131886640, new Object[]{1}));
        checkLogoFile(this.result, getActivity(), this.mAlbum.getAlbumId()).onBackpressureBuffer((long) this.result.size()).flatMap(new Func1() {
            /* class com.coolapk.market.view.album.pick.$$Lambda$AlbumPickAppTabActivity$upbJUc7fjW0T2mUKRIK9ZXyHfig */

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return AlbumPickAppTabActivity.this.lambda$onDone$3$AlbumPickAppTabActivity((AlbumItem) obj);
            }
        }).flatMap(new Func1() {
            /* class com.coolapk.market.view.album.pick.$$Lambda$AlbumPickAppTabActivity$29ODeYHNKmx5NPBykm_ksQiOgW4 */

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return AlbumPickAppTabActivity.this.lambda$onDone$5$AlbumPickAppTabActivity((AlbumItem) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<String>() {
            /* class com.coolapk.market.view.album.pick.AlbumPickAppTabActivity.AnonymousClass1 */

            public void onNext(String str) {
            }

            @Override // rx.Observer
            public void onCompleted() {
                AlbumPickAppTabActivity.this.order();
                AlbumPickAppTabActivity.this.pageCounter.set(1);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AlbumPickAppTabActivity.this.dialog.dismiss();
                AlbumPickAppTabActivity.this.pageCounter.set(1);
                Toast.error(AlbumPickAppTabActivity.this.getActivity(), th);
            }
        });
    }

    public /* synthetic */ Observable lambda$onDone$3$AlbumPickAppTabActivity(AlbumItem albumItem) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.coolapk.market.view.album.pick.$$Lambda$AlbumPickAppTabActivity$6lDxEJr5jCkpSGbMkeaiSh95URQ */

            @Override // java.lang.Runnable
            public final void run() {
                AlbumPickAppTabActivity.this.lambda$null$1$AlbumPickAppTabActivity();
            }
        });
        if (TextUtils.isEmpty(albumItem.getLogoUrl())) {
            return Observable.error(new ClientException(-1, "无法获取logo，暂时不能添加到应用集"));
        }
        if (!albumItem.isHttpLogo()) {
            return DataManager.getInstance().uploadAlbumLogoImage(albumItem).first().flatMap(new Func1() {
                /* class com.coolapk.market.view.album.pick.$$Lambda$AlbumPickAppTabActivity$UdcoEmaDbaOKbQZlR_D7QqzgJF8 */

                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    return Observable.just(AlbumItem.newBuilder(AlbumItem.this).setLogoUrl((String) ((Pair) obj).second).build());
                }
            });
        }
        return Observable.just(albumItem);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0018: APUT  
      (r2v0 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x0013: INVOKE  (r1v2 java.lang.Integer) = (r1v1 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    public /* synthetic */ void lambda$null$1$AlbumPickAppTabActivity() {
        ProgressDialog progressDialog = this.dialog;
        int i = 1;
        Object[] objArr = new Object[1];
        if (this.pageCounter.get() > 0) {
            i = this.pageCounter.get();
        }
        objArr[0] = Integer.valueOf(i);
        progressDialog.setMessage(getString(2131886640, objArr));
        this.pageCounter.incrementAndGet();
    }

    public /* synthetic */ Observable lambda$onDone$5$AlbumPickAppTabActivity(AlbumItem albumItem) {
        return addApk(albumItem, this.mAlbum.getAlbumId()).delay(300, TimeUnit.MILLISECONDS).map(RxUtils.checkResultToData()).onErrorResumeNext(new Func1() {
            /* class com.coolapk.market.view.album.pick.$$Lambda$AlbumPickAppTabActivity$eS7A1wyXWV_3FAskcuF3SHXkGp4 */

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return AlbumPickAppTabActivity.this.lambda$null$4$AlbumPickAppTabActivity((Throwable) obj);
            }
        });
    }

    public /* synthetic */ Observable lambda$null$4$AlbumPickAppTabActivity(Throwable th) {
        ClientException clientException;
        if (!(th instanceof RuntimeException) || !(th.getCause() instanceof ClientException) || (clientException = (ClientException) th.getCause()) == null) {
            return Observable.error(th);
        }
        if (clientException.getMessage().contains("200个应用")) {
            Toast.error(getActivity(), clientException);
            return Observable.create($$Lambda$FNtDOhKNeyY0sDo_apXvosHOsU.INSTANCE);
        }
        Toast.error(getActivity(), clientException);
        return Observable.just("");
    }

    private Observable<Result<String>> addApk(AlbumItem albumItem, String str) {
        Log.d("hfl", albumItem.getLogoUrl());
        return DataManager.getInstance().addApkToAlbum(str, albumItem.getPackageName(), albumItem.getTitle(), albumItem.getUrl(), albumItem.getNote(), albumItem.getDisplayOrder(), albumItem.getLogoUrl());
    }

    /* access modifiers changed from: private */
    public void order() {
        if (CollectionUtils.safeSize(this.mAlbum.getAlbumItems()) > 0) {
            this.result.addAll(this.mAlbum.getAlbumItems());
        }
        int i = 0;
        while (i < this.result.size()) {
            SimpleAlbumItem simpleAlbumItem = new SimpleAlbumItem();
            simpleAlbumItem.setPackageName(this.result.get(i).getPackageName());
            i++;
            simpleAlbumItem.setDisplayOrder(i);
            this.newAlbumItems.add(simpleAlbumItem);
        }
        DataManager.getInstance().editApkDisplayOrder(this.mAlbum.getAlbumId(), new Gson().toJson(this.newAlbumItems)).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
            /* class com.coolapk.market.view.album.pick.AlbumPickAppTabActivity.AnonymousClass2 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Toast.error(AlbumPickAppTabActivity.this.getActivity(), th);
            }

            public void onNext(Result<String> result) {
                AlbumPickAppTabActivity.this.dialog.dismiss();
                EventBus.getDefault().post(new AlbumaddEvent());
                AlbumPickAppTabActivity.this.getActivity().finish();
                ActionManager.startAlbumEditActivity(AlbumPickAppTabActivity.this.getActivity(), AlbumPickAppTabActivity.this.mAlbum);
            }
        });
    }

    private Observable<AlbumItem> checkLogoFile(List<AlbumItem> list, Context context, String str) {
        return Observable.from(list).map(new Func1(context, str) {
            /* class com.coolapk.market.view.album.pick.$$Lambda$AlbumPickAppTabActivity$YCk5N3499aw5wM7XhwGdIsewksU */
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return AlbumPickAppTabActivity.lambda$checkLogoFile$6(this.f$0, this.f$1, (AlbumItem) obj);
            }
        });
    }

    static /* synthetic */ AlbumItem lambda$checkLogoFile$6(Context context, String str, AlbumItem albumItem) {
        String str2;
        AlbumItem build = AlbumItem.newBuilder(albumItem).setDisplayOrder(0).build();
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        File file = new File(externalCacheDir.getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!TextUtils.isEmpty(build.getLogoUrl())) {
            return build;
        }
        Bitmap iconBitmap = BitmapUtil.getIconBitmap(context, build.getPackageName());
        File file2 = new File(file, build.getPackageName() + ".png");
        BitmapUtil.saveBitmapToFile(file2, iconBitmap, true);
        try {
            str2 = file2.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        return AlbumItem.newBuilder(build).setLogoUrl(str2).setAlbumId(str).build();
    }

    public Map<String, AlbumItem> getCommitApps() {
        return this.commitApps;
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getViewPager().setCurrentItem(getIntent().getIntExtra("PAGE_INDEX", 0));
        getToolbar().setTitle(2131887348);
        if (bundle != null) {
            for (int i = 0; i < getTabTitles().length; i++) {
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(getTabTitles()[i]);
                if (findFragmentByTag != null) {
                    setPresenter(findFragmentByTag, i);
                }
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131623964, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131361900) {
            onDone();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void setTabNum(int i, int i2) {
        TabLayout.Tab tabAt = getTabLayout().getTabAt(i);
        if (tabAt != null) {
            String str = getTabTitles()[i];
            if (i2 > 0) {
                str = str + "(" + i2 + ")";
            }
            tabAt.setText(str);
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        Fragment fragment;
        Album album = (Album) getIntent().getParcelableExtra("EXTRA_ALBUM");
        this.mAlbum = album;
        if (i == 0) {
            fragment = NewAlbumPickFragment.newInstance(album);
        } else if (i == 1 || i == 2) {
            fragment = AlbumPickFollowAppFragment.newInstance();
        } else if (i == 3) {
            fragment = PickSearchAlbumAppFragment.newInstance();
        } else {
            throw new RuntimeException("Unknown position: " + i);
        }
        setPresenter(fragment, i);
        return fragment;
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String getFragmentItemTag(int i) {
        return getTabTitles()[i];
    }

    private void setPresenter(Fragment fragment, int i) {
        String uid = DataManager.getInstance().getLoginSession().getUid();
        if (i == 0) {
            return;
        }
        if (i == 1) {
            AlbumPickFollowAppFragment albumPickFollowAppFragment = (AlbumPickFollowAppFragment) fragment;
            albumPickFollowAppFragment.setPresenter(new UserFollowAppPresenter(albumPickFollowAppFragment, uid));
        } else if (i == 2) {
            AlbumPickFollowAppFragment albumPickFollowAppFragment2 = (AlbumPickFollowAppFragment) fragment;
            albumPickFollowAppFragment2.setPresenter(new FavoriteApkPresenter(albumPickFollowAppFragment2, "apk"));
        } else if (i == 3) {
            PickSearchAlbumAppFragment pickSearchAlbumAppFragment = (PickSearchAlbumAppFragment) fragment;
            pickSearchAlbumAppFragment.setPresenter(new SearchAppPresenter(pickSearchAlbumAppFragment, "", "0"));
        } else {
            throw new RuntimeException("Unknown position: " + i);
        }
    }
}
