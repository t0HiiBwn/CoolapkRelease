package com.coolapk.market.view.contact;

import android.app.Application;
import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.User;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.PreferencesUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.contact.ContactContract;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import rx.Observable;
import rx.functions.Func1;

public class ContactPickPresenter extends ContactContract.PickPresenter {
    public static final int MAX_SAVE_COUNT = 6;
    private static final String PREF_KEY_AT_USER = "at_user_array";
    private String uid;
    private ContactContract.View view;

    public ContactPickPresenter(ContactContract.View view2, String str) {
        super(view2);
        this.uid = str;
        this.view = view2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(final boolean z, final int i) {
        return DataManager.getInstance().getUserFollowerList(this.uid, i, this.view.findFirstItem(), this.view.findLastItem()).compose(RxUtils.applyIOSchedulers()).flatMap(new Func1<Result<List<Entity>>, Observable<Result<List<Entity>>>>() {
            /* class com.coolapk.market.view.contact.ContactPickPresenter.AnonymousClass1 */

            public Observable<Result<List<Entity>>> call(Result<List<Entity>> result) {
                List<Entity> data = result.getData();
                if (data != null && z && i == 1) {
                    ArrayList arrayList = new ArrayList();
                    Application application = AppHolder.getApplication();
                    List loadRecentAtUser = ContactPickPresenter.this.loadRecentAtUser();
                    if (loadRecentAtUser != null && !loadRecentAtUser.isEmpty()) {
                        arrayList.add(HolderItem.newBuilder().entityType("holder_type_delete_recent").string(application.getString(2131886797)).value(application.getString(2131886772)).build());
                        arrayList.addAll(loadRecentAtUser);
                    }
                    arrayList.add(HolderItem.newBuilder().entityType("holder_title").string(application.getString(2131887261)).build());
                    arrayList.addAll(data);
                    data = arrayList;
                }
                return Observable.just(new Result(result.getStatus(), result.getMessage(), result.getForwardUrl(), data));
            }
        });
    }

    /* access modifiers changed from: private */
    public List<User> loadRecentAtUser() {
        int i = 6;
        ArrayList arrayList = new ArrayList(6);
        String preferencesString = DataManager.getInstance().getPreferencesString("at_user_array", null);
        if (!TextUtils.isEmpty(preferencesString)) {
            try {
                JSONArray jSONArray = new JSONArray(preferencesString);
                if (jSONArray.length() <= 6) {
                    i = jSONArray.length();
                }
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(User.fromJson(jSONArray.getJSONObject(i2)));
                }
            } catch (Exception e) {
                e.printStackTrace();
                clearUserEntities();
            }
        }
        return arrayList;
    }

    @Override // com.coolapk.market.view.contact.ContactContract.PickPresenter
    public void saveUserEntities(List<User> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < list.size(); i++) {
            linkedHashMap.put(list.get(i).getUserName(), list.get(i));
        }
        List<User> loadRecentAtUser = loadRecentAtUser();
        for (int i2 = 0; i2 < loadRecentAtUser.size(); i2++) {
            linkedHashMap.put(loadRecentAtUser.get(i2).getUserName(), loadRecentAtUser.get(i2));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(linkedHashMap.values());
        String str = null;
        if (!arrayList.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            int size = arrayList.size();
            if (size > 6) {
                size = 6;
            }
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    jSONArray.put(((User) arrayList.get(i3)).toJsonObject());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (jSONArray.length() != 0) {
                str = jSONArray.toString();
            }
        }
        PreferencesUtils.EditorHelper preferencesEditor = DataManager.getInstance().getPreferencesEditor();
        if (TextUtils.isEmpty(str)) {
            preferencesEditor.remove("at_user_array");
        } else {
            preferencesEditor.putString("at_user_array", str);
        }
        preferencesEditor.apply();
    }

    @Override // com.coolapk.market.view.contact.ContactContract.PickPresenter
    public void clearUserEntities() {
        DataManager.getInstance().getPreferencesEditor().remove("at_user_array").apply();
    }
}
