package com.coolapk.market.view.message;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedDraft;
import com.coolapk.market.model.Message;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.PrivacyAlertDialog;
import com.coolapk.market.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0014J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\bH\u0016J \u0010'\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0002J\u001a\u0010*\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010\b2\u0006\u0010,\u001a\u00020\bH\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/coolapk/market/view/message/ChattingActivity;", "Lcom/coolapk/market/view/message/NewBaseChatActivity;", "()V", "messageList", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Message;", "Lkotlin/collections/ArrayList;", "myId", "", "picMidList", "picSourceList", "uKey", "userId", "getMessageList", "", "getPicMidList", "getPicSourceList", "initData", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "postReply", "text", "sendMessage", "messagePic", "messageExtra", "setPhoto", "path", "uid", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChattingActivity.kt */
public final class ChattingActivity extends NewBaseChatActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_MESSAGE = "MESSAGE";
    public static final String KEY_TITLE = "TITLE";
    public static final String KEY_USER_ID = "USER_ID";
    private ArrayList<Message> messageList = new ArrayList<>();
    private String myId;
    private ArrayList<String> picMidList = new ArrayList<>();
    private ArrayList<String> picSourceList = new ArrayList<>();
    private String uKey;
    private String userId;

    @Override // com.coolapk.market.view.message.NewBaseChatActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        FeedDraft draftLike = DataManager.getInstance().getDraftLike(FeedDraft.builder().setType("message").setExtraId(this.uKey).build());
        if (draftLike != null) {
            getEditText().append(draftLike.getMessage());
        }
        getBinding().toolbar.setNavigationOnClickListener(new ChattingActivity$onCreate$1(this));
        setTitle(getIntent().getStringExtra("TITLE"));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (((ChatListFragment) supportFragmentManager.findFragmentById(2131363614)) == null) {
            supportFragmentManager.beginTransaction().add(2131363614, ChatListFragment.Companion.newInstance(this.uKey, this.myId, this.userId)).commit();
        }
    }

    public final List<String> getPicMidList() {
        return this.picMidList;
    }

    public final List<Message> getMessageList() {
        return this.messageList;
    }

    public final List<String> getPicSourceList() {
        return this.picSourceList;
    }

    private final void initData() {
        String str;
        try {
            this.userId = getIntent().getStringExtra("USER_ID");
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            this.myId = loginSession.getUid();
            if (TextUtils.isEmpty(this.userId)) {
                throw new NullPointerException("USER_ID can't be null");
            } else if (!TextUtils.isEmpty(this.myId)) {
                String str2 = this.myId;
                Intrinsics.checkNotNull(str2);
                long longValue = Long.valueOf(str2).longValue();
                String str3 = this.userId;
                Intrinsics.checkNotNull(str3);
                Long valueOf = Long.valueOf(str3);
                Intrinsics.checkNotNullExpressionValue(valueOf, "java.lang.Long.valueOf(userId!!)");
                if (longValue > valueOf.longValue()) {
                    str = this.userId + "_" + this.myId;
                } else {
                    str = this.myId + "_" + this.userId;
                }
                this.uKey = str;
            } else {
                throw new NullPointerException("哼，你没有登录，还想插进来？？");
            }
        } catch (Exception e) {
            Toast.error(getActivity(), e);
            finish();
        }
    }

    @Override // com.coolapk.market.view.message.NewBaseChatActivity, com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || intent == null || i != 3925) {
            return;
        }
        if (intent.getData() != null) {
            String path = BitmapUtil.getPath(getActivity(), intent.getData());
            String str = this.userId;
            Intrinsics.checkNotNull(str);
            setPhoto(path, str);
            return;
        }
        Toast.show$default(getActivity(), "无法读取图片", 0, false, 12, null);
    }

    private final void setPhoto(String str, String str2) {
        if (str != null) {
            File file = new File(str);
            if (!file.exists() || file.length() <= ((long) 10485760)) {
                BitmapUtil.compressImage(getActivity(), CoolFileUtils.wrap(str), 0).flatMap(new ChattingActivity$setPhoto$1(this)).onErrorResumeNext(ChattingActivity$setPhoto$2.INSTANCE).flatMap(new ChattingActivity$setPhoto$3(this)).flatMap(ChattingActivity$setPhoto$4.INSTANCE).compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new ChattingActivity$setPhoto$5(this)).subscribe((Subscriber<? super R>) new ChattingActivity$setPhoto$6(this));
            } else {
                Toast.show$default(getActivity(), "图片大小大于10兆，请压缩大小后继续操作", 0, false, 12, null);
            }
        }
    }

    @Override // com.coolapk.market.view.message.NewBaseChatActivity
    public void postReply(String str) {
        if (PrivacyAlertDialog.Companion.shouldShowByIntent()) {
            PrivacyAlertDialog newInstance = PrivacyAlertDialog.Companion.newInstance();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        } else if (TextUtils.isEmpty(str)) {
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Toast.show(activity, 2131886710);
        } else if (isPosting()) {
            BaseActivity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            Toast.show(activity2, 2131886711);
        } else {
            Intrinsics.checkNotNull(str);
            sendMessage(str, "", "");
        }
    }

    private final void sendMessage(String str, String str2, String str3) {
        DataManager.getInstance().sendMessage(this.userId, str, str2, str3).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new ChattingActivity$sendMessage$1(this)).subscribe((Subscriber<? super R>) new ChattingActivity$sendMessage$2(this, str));
    }

    @Override // com.coolapk.market.view.message.NewBaseChatActivity, com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (setEmotionPanelVisibleWithAnim(false)) {
            UiUtils.closeKeyboard(getEditText());
            setEmotionPanelVisibleWithAnim(false);
            return;
        }
        Intent parentActivityIntent = getParentActivityIntent();
        if (shouldUpRecreateTask(parentActivityIntent) || isTaskRoot()) {
            TaskStackBuilder.create(this).addNextIntentWithParentStack(parentActivityIntent).startActivities();
            return;
        }
        AppHolder instance = AppHolder.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "AppHolder.getInstance()");
        if (instance.isMainActivityExist()) {
            finish();
        } else {
            navigateUpTo(parentActivityIntent);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(2131623973, menu);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        Menu menu2 = toolbar.getMenu();
        if (menu2 == null) {
            return false;
        }
        MenuItem findItem = menu2.findItem(2131361961);
        Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.action_search)");
        findItem.setVisible(false);
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        boolean z = loginSession.isLogin() && !TextUtils.equals(this.userId, loginSession.getUid()) && !TextUtils.equals("10086", this.userId);
        MenuItem findItem2 = menu2.findItem(2131361858);
        if (findItem2 != null && loginSession.isAdmin() && z) {
            findItem2.setVisible(true);
        }
        MenuItem findItem3 = menu2.findItem(2131361926);
        Intrinsics.checkNotNull(findItem3);
        findItem3.setVisible(false);
        MenuItem findItem4 = menu2.findItem(2131361985);
        Intrinsics.checkNotNull(findItem4);
        findItem4.setVisible(true);
        MenuItem findItem5 = menu2.findItem(2131361875);
        if (findItem5 != null && z) {
            findItem5.setVisible(true);
        }
        MenuItem findItem6 = menu2.findItem(2131361958);
        if (findItem6 != null && z) {
            findItem6.setVisible(true);
        }
        MenuItem findItem7 = menu2.findItem(2131361969);
        Intrinsics.checkNotNullExpressionValue(findItem7, "menuItem");
        findItem7.setVisible(false);
        return true;
    }

    @Override // com.coolapk.market.view.message.NewBaseChatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 2131361858:
                if (this.userId == null) {
                    return false;
                }
                String str = this.userId;
                Intrinsics.checkNotNull(str);
                ActionManager.startWebViewActivity(getActivity(), UriUtils.getUserManageUrl(str));
                return true;
            case 2131361875:
                BaseActivity activity = getActivity();
                String str2 = this.userId;
                String stringExtra = getIntent().getStringExtra("TITLE");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                ActionManager.startBlackListSettingActivity(activity, str2, stringExtra);
                return true;
            case 2131361958:
                if (this.userId == null) {
                    return false;
                }
                String str3 = this.userId;
                Intrinsics.checkNotNull(str3);
                ActionManager.startWebViewActivity(getActivity(), UriUtils.buildUserReportUrl(str3));
                return true;
            case 2131361985:
                ActionManager.startUserSpaceActivity(getActivity(), this.userId);
                return true;
            default:
                return false;
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DataManager.getInstance().addFeedDraft(FeedDraft.builder().setType("message").setExtraId(this.uKey).setMessage(getEditText().getText().toString()).build());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/message/ChattingActivity$Companion;", "", "()V", "KEY_MESSAGE", "", "KEY_TITLE", "KEY_USER_ID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChattingActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
