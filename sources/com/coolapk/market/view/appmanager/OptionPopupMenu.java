package com.coolapk.market.view.appmanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentManager;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.widget.MinimumWidthDialog;
import com.coolapk.market.widget.Toast;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0003\u0017\u0018\u0019Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/appmanager/OptionPopupMenu;", "Lcom/coolapk/market/view/base/refresh/BasePopMenu;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "context", "Landroid/content/Context;", "fm", "Landroidx/fragment/app/FragmentManager;", "anchorView", "Landroid/view/View;", "type", "", "title", "", "packageName", "versionName", "versionCode", "filePath", "listener", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Landroid/view/View;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;)V", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "Companion", "PackageMD5DialogFragment", "Type", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OptionPopupMenu.kt */
public final class OptionPopupMenu extends BasePopMenu implements PopupMenu.OnMenuItemClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int LOADER_64B = 3;
    public static final int LOADER_APK = 1;
    public static final int LOADER_MD5 = 2;
    public static final int TYPE_DOWNLOAD_MANAGER = 2131623946;
    public static final int TYPE_LOCAL_APK = 2131623955;
    public static final int TYPE_MOBILE_APP = 2131623962;
    public static final int TYPE_UPGRADE = 2131623972;
    private final View anchorView;
    private final Context context;
    private final String filePath;
    private final FragmentManager fm;
    private final PopupMenu.OnMenuItemClickListener listener;
    private final String packageName;
    private final String title;
    private final int type;
    private final int versionCode;
    private final String versionName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/coolapk/market/view/appmanager/OptionPopupMenu$Type;", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* compiled from: OptionPopupMenu.kt */
    public @interface Type {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OptionPopupMenu(Context context2, FragmentManager fragmentManager, View view, int i, String str, String str2, String str3, int i2, String str4, PopupMenu.OnMenuItemClickListener onMenuItemClickListener) {
        super(context2, view);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.fm = fragmentManager;
        this.anchorView = view;
        this.type = i;
        this.title = str;
        this.packageName = str2;
        this.versionName = str3;
        this.versionCode = i2;
        this.filePath = str4;
        this.listener = onMenuItemClickListener;
        inflate(i);
        setOnMenuItemClickListener(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/appmanager/OptionPopupMenu$Companion;", "", "()V", "LOADER_64B", "", "LOADER_APK", "LOADER_MD5", "TYPE_DOWNLOAD_MANAGER", "TYPE_LOCAL_APK", "TYPE_MOBILE_APP", "TYPE_UPGRADE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: OptionPopupMenu.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\u001e\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/appmanager/OptionPopupMenu$PackageMD5DialogFragment;", "Lcom/coolapk/market/widget/MinimumWidthDialog;", "Landroidx/loader/app/LoaderManager$LoaderCallbacks;", "", "()V", "arm64bView", "Landroid/widget/TextView;", "filePath", "md5View", "targetApiView", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateLoader", "Landroidx/loader/content/Loader;", "id", "", "args", "onLoadFinished", "loader", "data", "onLoaderReset", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: OptionPopupMenu.kt */
    public static final class PackageMD5DialogFragment extends MinimumWidthDialog implements LoaderManager.LoaderCallbacks<String> {
        public static final Companion Companion = new Companion(null);
        private TextView arm64bView;
        private String filePath;
        private TextView md5View;
        private TextView targetApiView;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/appmanager/OptionPopupMenu$PackageMD5DialogFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/appmanager/OptionPopupMenu$PackageMD5DialogFragment;", "title", "", "packageName", "versionName", "versionCode", "", "filePath", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: OptionPopupMenu.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PackageMD5DialogFragment newInstance(String str, String str2, String str3, int i, String str4) {
                Bundle bundle = new Bundle();
                bundle.putString("title", str);
                bundle.putString("packageName", str2);
                bundle.putString("versionName", str3);
                bundle.putInt("versionCode", i);
                bundle.putString("filePath", str4);
                PackageMD5DialogFragment packageMD5DialogFragment = new PackageMD5DialogFragment();
                packageMD5DialogFragment.setArguments(bundle);
                return packageMD5DialogFragment;
            }
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            String string = requireArguments().getString("title");
            String string2 = requireArguments().getString("packageName");
            String string3 = requireArguments().getString("versionName");
            int i = requireArguments().getInt("versionCode");
            this.filePath = requireArguments().getString("filePath");
            View inflate = LayoutInflater.from(getActivity()).inflate(2131559307, (ViewGroup) null, false);
            View findViewById = inflate.findViewById(2131363604);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(string);
            View findViewById2 = inflate.findViewById(2131363079);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById2).setText(string2);
            View findViewById3 = inflate.findViewById(2131363934);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s (%d)", Arrays.copyOf(new Object[]{string3, Integer.valueOf(i)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            ((TextView) findViewById3).setText(format);
            View findViewById4 = inflate.findViewById(2131363526);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.target_api_view)");
            this.targetApiView = (TextView) findViewById4;
            View findViewById5 = inflate.findViewById(2131362923);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.md5_view)");
            this.md5View = (TextView) findViewById5;
            View findViewById6 = inflate.findViewById(2131362089);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.arm64b_view)");
            this.arm64bView = (TextView) findViewById6;
            AlertDialog create = new AlertDialog.Builder(getActivity()).setView(inflate).setPositiveButton(2131886118, OptionPopupMenu$PackageMD5DialogFragment$onCreateDialog$1.INSTANCE).setNegativeButton(2131886121, new OptionPopupMenu$PackageMD5DialogFragment$onCreateDialog$2(this, string, string3, i, string2)).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
            return create;
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            TextView textView = this.targetApiView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetApiView");
            }
            textView.setText(2131887014);
            TextView textView2 = this.arm64bView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arm64bView");
            }
            textView2.setText(2131887014);
            TextView textView3 = this.md5View;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("md5View");
            }
            textView3.setText(2131887014);
            PackageMD5DialogFragment packageMD5DialogFragment = this;
            PackageMD5DialogFragment packageMD5DialogFragment2 = this;
            LoaderManager.getInstance(packageMD5DialogFragment).initLoader(1, null, packageMD5DialogFragment2).forceLoad();
            LoaderManager.getInstance(packageMD5DialogFragment).initLoader(2, null, packageMD5DialogFragment2).forceLoad();
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader<String> onCreateLoader(int i, Bundle bundle) {
            if (i == 1) {
                return new OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$1(this, requireActivity());
            }
            if (i == 2) {
                return new OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$2(this, requireActivity());
            }
            if (i == 3) {
                return new OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$3(this, requireActivity());
            }
            throw new RuntimeException("Unknown is loader " + i);
        }

        public void onLoadFinished(Loader<String> loader, String str) {
            Intrinsics.checkNotNullParameter(loader, "loader");
            Intrinsics.checkNotNullParameter(str, "data");
            int id = loader.getId();
            if (id == 1) {
                TextView textView = this.targetApiView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("targetApiView");
                }
                textView.setText(str);
            } else if (id == 2) {
                TextView textView2 = this.md5View;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("md5View");
                }
                textView2.setText(str);
            } else if (id == 3) {
                TextView textView3 = this.arm64bView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("arm64bView");
                }
                textView3.setText(str);
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<String> loader) {
            Intrinsics.checkNotNullParameter(loader, "loader");
            int id = loader.getId();
            if (id == 1) {
                TextView textView = this.targetApiView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("targetApiView");
                }
                textView.setText((CharSequence) null);
            } else if (id == 2) {
                TextView textView2 = this.md5View;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("md5View");
                }
                textView2.setText((CharSequence) null);
            } else if (id == 3) {
                TextView textView3 = this.arm64bView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("arm64bView");
                }
                textView3.setText((CharSequence) null);
            }
        }
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        PopupMenu.OnMenuItemClickListener onMenuItemClickListener = this.listener;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem)) {
            return true;
        }
        switch (menuItem.getItemId()) {
            case 2131361896:
                ActionManager.startShareFeedV8Activity(UiUtils.getActivity(this.context), this.packageName);
                return true;
            case 2131361939:
                try {
                    ActionManager.openApp(this.context, this.packageName);
                } catch (ActivityNotFoundException unused) {
                    Context context2 = this.context;
                    Toast.show$default(context2, context2.getString(2131887276), 0, false, 12, null);
                }
                return true;
            case 2131361940:
                try {
                    ActionManager.openApplicationInfo(this.context, this.packageName);
                } catch (ActivityNotFoundException unused2) {
                    Context context3 = this.context;
                    Toast.show$default(context3, context3.getString(2131887276), 0, false, 12, null);
                }
                return true;
            case 2131361941:
                ActionManager.startExternalMarketByName(this.context, null, null, this.packageName);
                return true;
            case 2131361981:
                if (TextUtils.equals(this.packageName, this.context.getPackageName())) {
                    Toast.show(this.context, 2131887278);
                } else {
                    AppSetting appSetting = AppHolder.getAppSetting();
                    Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
                    if (appSetting.isInstallSilent()) {
                        SimpleDialog newInstance = SimpleDialog.newInstance();
                        newInstance.setMessage(this.context.getString(2131887110, this.title));
                        newInstance.setNegativeButton(2131886140);
                        newInstance.setPositiveButton(2131886162, new OptionPopupMenu$onMenuItemClick$1(this));
                        FragmentManager fragmentManager = this.fm;
                        Intrinsics.checkNotNull(fragmentManager);
                        newInstance.show(fragmentManager, (String) null);
                    } else {
                        ActionManager.uninstall(this.context, this.packageName, this.title);
                    }
                }
                return true;
            case 2131361982:
                ActionManager.startAppViewActivity(this.context, this.packageName);
                return true;
            case 2131361987:
                PackageMD5DialogFragment newInstance2 = PackageMD5DialogFragment.Companion.newInstance(this.title, this.packageName, this.versionName, this.versionCode, this.filePath);
                FragmentManager fragmentManager2 = this.fm;
                Intrinsics.checkNotNull(fragmentManager2);
                newInstance2.show(fragmentManager2, (String) null);
                return true;
            default:
                return false;
        }
    }
}
