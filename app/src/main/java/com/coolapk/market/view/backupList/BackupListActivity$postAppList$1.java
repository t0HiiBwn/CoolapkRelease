package com.coolapk.market.view.backupList;

import android.app.ProgressDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "", "kotlin.jvm.PlatformType", "it", "Lokhttp3/ResponseBody;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupListActivity.kt */
final class BackupListActivity$postAppList$1<T, R> implements Func1<ResponseBody, Observable<? extends List<? extends String>>> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ Ref.ObjectRef $id;
    final /* synthetic */ boolean $isCover;
    final /* synthetic */ String $json;
    final /* synthetic */ String $title;
    final /* synthetic */ BackupListActivity this$0;

    BackupListActivity$postAppList$1(BackupListActivity backupListActivity, Ref.ObjectRef objectRef, ProgressDialog progressDialog, String str, String str2, boolean z) {
        this.this$0 = backupListActivity;
        this.$id = objectRef;
        this.$dialog = progressDialog;
        this.$json = str;
        this.$title = str2;
        this.$isCover = z;
    }

    public final Observable<? extends List<String>> call(ResponseBody responseBody) {
        Integer num;
        T t;
        JsonElement parse = new JsonParser().parse(responseBody.string());
        Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(it.string())");
        JsonObject asJsonObject = parse.getAsJsonObject();
        if (asJsonObject.has("status")) {
            JsonElement jsonElement = asJsonObject.get("status");
            Intrinsics.checkNotNullExpressionValue(jsonElement, "jsonObject.get(\"status\")");
            num = Integer.valueOf(jsonElement.getAsInt());
        } else {
            num = null;
        }
        if (asJsonObject.has("message")) {
            JsonElement jsonElement2 = asJsonObject.get("message");
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject.get(\"message\")");
            t = (T) jsonElement2.getAsString();
        } else {
            t = null;
        }
        JsonElement jsonElement3 = asJsonObject.has("data") ? asJsonObject.get("data") : null;
        if (t == null || num == null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNull(jsonElement3);
            objectRef.element = (T) instance.parseJsonToEntity(jsonElement3.getAsJsonObject(), "back", "");
            if (objectRef.element instanceof BackupInfo) {
                this.this$0.getActivity().runOnUiThread(new Runnable(this) {
                    /* class com.coolapk.market.view.backupList.BackupListActivity$postAppList$1.AnonymousClass2 */
                    final /* synthetic */ BackupListActivity$postAppList$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Fragment fragment = this.this$0.this$0.getFragment();
                        Objects.requireNonNull(fragment, "null cannot be cast to non-null type com.coolapk.market.view.backupList.BackupListFragment");
                        ((BackupListFragment) fragment).putBackupInfo(objectRef.element, this.this$0.$isCover);
                        this.this$0.$dialog.dismiss();
                    }
                });
                Observable.empty();
            }
        } else if (num.intValue() == -4) {
            Intrinsics.checkNotNull(jsonElement3);
            String asString = jsonElement3.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "data!!.asString");
            List split$default = StringsKt.split$default((CharSequence) asString, new String[]{","}, false, 0, 6, (Object) null);
            this.$id.element = t;
            return Observable.just(split$default);
        } else if (num.intValue() != -6) {
            return Observable.error(new ClientException(num.intValue(), t));
        } else {
            this.$dialog.dismiss();
            final ConfirmDialog newInstance = ConfirmDialog.newInstance("备份停止，应用备份已存在", t, "覆盖备份", "取消");
            newInstance.setOnOkRunnable(new Runnable(this) {
                /* class com.coolapk.market.view.backupList.BackupListActivity$postAppList$1.AnonymousClass1 */
                final /* synthetic */ BackupListActivity$postAppList$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    newInstance.dismiss();
                    this.this$0.this$0.postAppList(this.this$0.$json, this.this$0.$title, true);
                }
            });
            FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
        return Observable.empty();
    }
}
