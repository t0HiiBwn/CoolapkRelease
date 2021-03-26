package com.coolapk.market.view.node.app;

import android.app.Activity;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import com.coolapk.market.widget.Toast;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscription;

/* compiled from: AppNodeContract.kt */
public final class AppNodePresenter {
    public static final Companion Companion = new Companion(null);
    public static final int REQUEST_FAVORITE = 2;
    public static final int REQUEST_FOLLOW = 1;
    public static final int REQUEST_RATING = 0;
    private HashMap<Integer, Request> requestSet = new HashMap<>();
    private final AppNodeView view;
    private final AppNodeViewModel viewModel;

    public AppNodePresenter(AppNodeView appNodeView, AppNodeViewModel appNodeViewModel) {
        Intrinsics.checkNotNullParameter(appNodeView, "view");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        this.view = appNodeView;
        this.viewModel = appNodeViewModel;
    }

    public final AppNodeView getView() {
        return this.view;
    }

    public final AppNodeViewModel getViewModel() {
        return this.viewModel;
    }

    /* compiled from: AppNodeContract.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void ratingAppV10$default(AppNodePresenter appNodePresenter, AppNodeViewModel appNodeViewModel, Activity activity, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = appNodeViewModel.getMyScore().get();
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        appNodePresenter.ratingAppV10(appNodeViewModel, activity, i, z);
    }

    public final void ratingAppV10(AppNodeViewModel appNodeViewModel, Activity activity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(activity, "context");
        ServiceApp serviceApp = appNodeViewModel.getServiceApp().get();
        if (serviceApp != null) {
            Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get() ?: return");
            if (serviceApp.getCommentStatus() == -1) {
                Toast.show$default(activity, "此应用禁止点评", 0, true, 4, null);
                return;
            }
            boolean z2 = true;
            if (serviceApp.getIsDownloadApp() != 1) {
                Toast.show$default(activity, "应用未上架，还不能点评哦~", 0, true, 4, null);
            } else if (DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName()) == null) {
                Toast.show$default(activity, "抱歉，安装应用后才可以点评", 0, true, 4, null);
            } else {
                String str = appNodeViewModel.getRatingFeedUrl().get();
                if (str == null) {
                    str = "";
                }
                if (appNodeViewModel.getMyScore().get() > 0) {
                    if (str.length() <= 0) {
                        z2 = false;
                    }
                    if (z2) {
                        ActionManagerCompat.startActivityByUrl$default(activity, str, null, null, 12, null);
                        return;
                    }
                }
                FeedMultiPart build = FeedArgsFactoryKt.applyToRating(FeedArgsFactoryKt.applyServiceApp(FeedArgsFactory.multiPartForFeed(), serviceApp)).ratingScore1(i).build();
                Activity activity2 = activity;
                ActionManager.startSubmitFeedV8Activity(UiUtils.getActivity(activity2), FeedArgsFactoryKt.applyToRating(FeedArgsFactoryKt.applyServiceApp(FeedArgsFactory.uiConfigForFeed(activity2), serviceApp), "apk").isRatingTextCollapsed(z).build(), build);
            }
        }
    }

    public final void ratingApp(String str, int i, int i2) {
        Request request = this.requestSet.get(0);
        if (request != null) {
            request.cancel();
        }
        this.requestSet.put(0, Request.Companion.run(new AppNodePresenter$ratingApp$1(this, str, i, i2)));
    }

    public final void unratingApp(String str, int i) {
        Request request = this.requestSet.get(0);
        if (request != null) {
            request.cancel();
        }
        this.requestSet.put(0, Request.Companion.run(new AppNodePresenter$unratingApp$1(this, str, i)));
    }

    public final void followApp(String str, boolean z, boolean z2) {
        Request request = this.requestSet.get(1);
        if (request != null) {
            request.cancel();
        }
        this.requestSet.put(1, Request.Companion.run(new AppNodePresenter$followApp$1(this, z2, str, z)));
    }

    public final void favoriteApp(String str, boolean z, boolean z2) {
        ServiceApp serviceApp = this.viewModel.getServiceApp().get();
        if (serviceApp != null) {
            Request request = this.requestSet.get(2);
            if (request != null) {
                request.cancel();
            }
            this.requestSet.put(2, Request.Companion.run(new AppNodePresenter$favoriteApp$1(this, z2, str, serviceApp, z)));
        }
    }

    /* compiled from: AppNodeContract.kt */
    public static abstract class Request {
        public static final Companion Companion = new Companion(null);
        private boolean isLoading;
        private Subscription subscription;

        public abstract Subscription onCreate();

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final void setLoading(boolean z) {
            this.isLoading = z;
        }

        /* compiled from: AppNodeContract.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Request run(Function1<? super Request, ? extends Subscription> function1) {
                Intrinsics.checkNotNullParameter(function1, "create");
                AppNodePresenter$Request$Companion$run$1 appNodePresenter$Request$Companion$run$1 = new AppNodePresenter$Request$Companion$run$1(function1);
                appNodePresenter$Request$Companion$run$1.run();
                return appNodePresenter$Request$Companion$run$1;
            }
        }

        public final void run() {
            this.isLoading = true;
            this.subscription = onCreate();
        }

        public final void cancel() {
            RxUtils.unsubscribe(this.subscription);
        }

        public final <T> Observable.Transformer<T, T> applyLoading() {
            return new AppNodePresenter$Request$applyLoading$1(this);
        }
    }
}
