package com.coolapk.market.view.user.profile;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.UserProfileEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0014\u0010$\u001a\u00020\u00192\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&J\u000e\u0010+\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverPresenter;", "", "userProfile", "Lcom/coolapk/market/model/UserProfile;", "fragment", "Lcom/coolapk/market/view/user/profile/UserCoverFragment;", "(Lcom/coolapk/market/model/UserProfile;Lcom/coolapk/market/view/user/profile/UserCoverFragment;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "cropOutFile", "Ljava/io/File;", "<set-?>", "", "currentCover", "getCurrentCover", "()Ljava/lang/String;", "isRequesting", "", "userCustomCover", "getUserCustomCover", "setUserCustomCover", "(Ljava/lang/String;)V", "getUserProfile", "()Lcom/coolapk/market/model/UserProfile;", "checkAndUpload", "", "file", "compressAndCrop", "sourcePath", "getValueFlag", "url", "handleActivityResult", "requestCode", "", "data", "Landroid/content/Intent;", "notifyDataListChanged", "holderList", "", "Lcom/coolapk/market/model/HolderItem;", "notifyUserCoverChanged", "notifyUserCustomChanged", "processDataList", "requestChangeUserAvatarCover", "requestPickCustomCover", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserCoverPresenter.kt */
public final class UserCoverPresenter {
    public static final Companion Companion = new Companion(null);
    private static final String SELECT_TAG = "[SELECT_TAG]";
    private final FragmentActivity activity;
    private File cropOutFile;
    private String currentCover;
    private final UserCoverFragment fragment;
    private boolean isRequesting;
    private String userCustomCover;
    private final UserProfile userProfile;

    public UserCoverPresenter(UserProfile userProfile2, UserCoverFragment userCoverFragment) {
        Intrinsics.checkNotNullParameter(userProfile2, "userProfile");
        Intrinsics.checkNotNullParameter(userCoverFragment, "fragment");
        this.userProfile = userProfile2;
        this.fragment = userCoverFragment;
        FragmentActivity requireActivity = userCoverFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        this.activity = requireActivity;
        String str = "";
        this.currentCover = str;
        this.userCustomCover = str;
        String cover = userProfile2.getCover();
        this.currentCover = cover != null ? cover : str;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    public final String getCurrentCover() {
        return this.currentCover;
    }

    public final String getUserCustomCover() {
        return this.userCustomCover;
    }

    public final void setUserCustomCover(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userCustomCover = str;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverPresenter$Companion;", "", "()V", "SELECT_TAG", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserCoverPresenter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String getValueFlag(String str) {
        if (Intrinsics.areEqual(str, this.currentCover)) {
            return "[SELECT_TAG]";
        }
        return null;
    }

    public final List<HolderItem> processDataList(List<? extends HolderItem> list) {
        boolean z;
        T t;
        boolean z2;
        Integer intValue;
        Integer intValue2;
        Intrinsics.checkNotNullParameter(list, "holderList");
        List<? extends HolderItem> list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list2.iterator();
        while (true) {
            z = false;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            T t2 = next;
            if (Intrinsics.areEqual(t2.getEntityType(), "holder_type_image") && (intValue2 = t2.getIntValue()) != null && intValue2.intValue() == 0) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        ArrayList<HolderItem> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (HolderItem holderItem : arrayList2) {
            String valueFlag = getValueFlag(holderItem.getUrl());
            if (!Intrinsics.areEqual(holderItem.getValue(), valueFlag)) {
                holderItem = HolderItem.newBuilder(holderItem).value(valueFlag).build();
            }
            arrayList3.add(holderItem);
        }
        ArrayList arrayList4 = arrayList3;
        Iterator<T> it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                t = null;
                break;
            }
            t = it3.next();
            T t3 = t;
            if (!Intrinsics.areEqual(t3.getEntityType(), "holder_type_image") || (intValue = t3.getIntValue()) == null || intValue.intValue() != 1) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        T t4 = t;
        HolderItem build = HolderItem.newBuilder().entityType("holder_type_title").string("自定义背景").build();
        HolderItem build2 = HolderItem.newBuilder().entityType("holder_type_title").string("推荐背景").build();
        ArrayList arrayList5 = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(build, "customTitleHolder");
        arrayList5.add(build);
        if (this.userCustomCover.length() > 0) {
            z = true;
        }
        if (z) {
            HolderItem build3 = HolderItem.newBuilder().entityType("holder_type_image").url(this.userCustomCover).value(getValueFlag(this.userCustomCover)).intValue(1).build();
            Intrinsics.checkNotNullExpressionValue(build3, "HolderItem.newBuilder().…                 .build()");
            arrayList5.add(build3);
        } else if (t4 == null) {
            HolderItem build4 = HolderItem.newBuilder().entityType("holder_type_add").build();
            Intrinsics.checkNotNullExpressionValue(build4, "HolderItem.newBuilder().….HOLDER_TYPE_ADD).build()");
            arrayList5.add(build4);
        } else {
            String url = t4.getUrl();
            if (url == null) {
                url = "";
            }
            this.userCustomCover = url;
            HolderItem build5 = HolderItem.newBuilder(t4).value(getValueFlag(this.userCustomCover)).build();
            Intrinsics.checkNotNullExpressionValue(build5, "customHolder.let { Holde…erCustomCover)).build() }");
            arrayList5.add(build5);
        }
        Intrinsics.checkNotNullExpressionValue(build2, "recommendHolder");
        arrayList5.add(build2);
        arrayList5.addAll(arrayList4);
        return arrayList5;
    }

    public final void notifyDataListChanged(List<? extends HolderItem> list) {
        Intrinsics.checkNotNullParameter(list, "holderList");
        this.fragment.onDataListChanged(list);
    }

    public final void requestPickCustomCover() {
        ActionManager.startPhotoPickerActivity(this.fragment, 1, new ArrayList());
    }

    public final void handleActivityResult(int i, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        if (i == 3925) {
            String path = BitmapUtil.getPath(this.activity, intent.getData());
            if (TextUtils.isEmpty(path)) {
                Toast.show$default(this.activity, "无法读取图片", 0, false, 12, null);
                return;
            }
            Intrinsics.checkNotNullExpressionValue(path, "path");
            compressAndCrop(path);
        } else if (i == 69) {
            File file = this.cropOutFile;
            if (file == null || !file.exists() || file.length() <= 0) {
                Toast.show(this.activity, 2131886645);
            } else {
                checkAndUpload(file);
            }
        }
    }

    private final void compressAndCrop(String str) {
        Dialog showProgressDialog = DialogUtil.INSTANCE.showProgressDialog(this.activity, "正在处理...", false);
        BitmapUtil.compressImage(this.activity, CoolFileUtils.wrap(str), 0).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new UserCoverPresenter$compressAndCrop$1(showProgressDialog)).subscribe((Subscriber<? super R>) new UserCoverPresenter$compressAndCrop$2(this, BitmapUtil.generateFileOutputPath(this.activity, str + ".bak")));
    }

    private final void checkAndUpload(File file) {
        if (!this.isRequesting) {
            this.isRequesting = true;
            Dialog showProgressDialog$default = DialogUtil.showProgressDialog$default(DialogUtil.INSTANCE, this.activity, "正在处理, 请稍等...", false, 4, null);
            DataManager.getInstance().uploadImage(CollectionsKt.mutableListOf(ImageUploadOption.create(CoolFileUtils.wrap(file.getAbsolutePath()), "cover", "FEED", null))).map(UserCoverPresenter$checkAndUpload$1.INSTANCE).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new UserCoverPresenter$checkAndUpload$2(this, showProgressDialog$default)).subscribe((Subscriber<? super R>) new UserCoverPresenter$checkAndUpload$3(this));
        }
    }

    /* access modifiers changed from: private */
    public final void notifyUserCustomChanged(String str) {
        this.userCustomCover = str;
        notifyDataListChanged(processDataList(this.fragment.getDataList()));
        AppHolder.getMainThreadHandler().post(new UserCoverPresenter$notifyUserCustomChanged$1(this, str));
    }

    public final void requestChangeUserAvatarCover(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (!this.isRequesting) {
            this.isRequesting = true;
            DataManager.getInstance().changeAvatarCover(str).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new UserCoverPresenter$requestChangeUserAvatarCover$1(this, DialogUtil.showProgressDialog$default(DialogUtil.INSTANCE, this.activity, "正在处理, 请稍等...", false, 4, null))).subscribe((Subscriber<? super R>) new UserCoverPresenter$requestChangeUserAvatarCover$2(this, str));
        }
    }

    /* access modifiers changed from: private */
    public final void notifyUserCoverChanged(String str) {
        this.currentCover = str;
        notifyDataListChanged(processDataList(this.fragment.getDataList()));
        UserProfileEvent.Companion companion = UserProfileEvent.Companion;
        UserProfile build = UserProfile.builder(this.userProfile).setCover(this.currentCover).build();
        Intrinsics.checkNotNullExpressionValue(build, "UserProfile.builder(user…                 .build()");
        companion.dispatch("cover_event", build);
    }
}
