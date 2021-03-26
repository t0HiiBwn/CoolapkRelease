package com.coolapk.market.view.user;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.DialogCityPickerBinding;
import com.coolapk.market.databinding.DialogDatePickerBinding;
import com.coolapk.market.databinding.DialogEditBinding;
import com.coolapk.market.databinding.DialogGenderPickerBinding;
import com.coolapk.market.databinding.ItemUserProfileAvatarBinding;
import com.coolapk.market.databinding.ItemUserProfileItemBinding;
import com.coolapk.market.event.UserProfileEvent;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.BottomDialogFragment;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.lany.picker.NumberPicker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.IOUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func1;

public class UserProfileFragment extends NewAsyncListFragment<List<HolderItem>> {
    public static final String HOLDER_ADDRESS = "holder_address";
    public static final String HOLDER_AVATAR = "holder_avatar";
    public static final String HOLDER_BIRTHDAY = "holder_birthday";
    public static final String HOLDER_COVER = "holder_cover";
    public static final String HOLDER_DEVICES = "holder_devices";
    public static final String HOLDER_EMAIL = "holder_email";
    public static final String HOLDER_GENDER = "holder_gender";
    public static final String HOLDER_HOME_PAGE = "holder_home_page";
    public static final String HOLDER_LOGOUT = "holder_logout";
    public static final String HOLDER_PHONE = "holder_phone";
    public static final String HOLDER_SIGNATURE = "holder_signature";
    public static final String HOLDER_USERNAME = "holder_username";
    public static final String HOLDER_USER_ACCOUNT = "holder_user_account";
    public static final String HOLDER_WEIBO = "holder_weibo";
    public static final String HOLDER_ZODIA_SIGN = "holder_zodia_sign";
    private static final String KEY_DATA = "DATA";
    private static final String KEY_USER_PROFILE = "PROFILE";
    private final ObservableArrayList<HolderItem> dataList = new ObservableArrayList<>();
    private UserProfile mUserProfile;

    public static UserProfileFragment newInstance() {
        Bundle bundle = new Bundle();
        UserProfileFragment userProfileFragment = new UserProfileFragment();
        userProfileFragment.setArguments(bundle);
        return userProfileFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
                this.mUserProfile = (UserProfile) bundle.getParcelable("PROFILE");
            }
        }
    }

    @Subscribe
    public void onUserProfileEvent(UserProfileEvent userProfileEvent) {
        UserProfile userProfile = this.mUserProfile;
        if (userProfile != null && userProfileEvent.canMatchUpWith(userProfile)) {
            this.mUserProfile = userProfileEvent.patch(this.mUserProfile);
            String type = userProfileEvent.getType();
            type.hashCode();
            char c = 65535;
            switch (type.hashCode()) {
                case -410342769:
                    if (type.equals("address_event")) {
                        c = 0;
                        break;
                    }
                    break;
                case -348261476:
                    if (type.equals("gender_event")) {
                        c = 1;
                        break;
                    }
                    break;
                case -288816045:
                    if (type.equals("signature_event")) {
                        c = 2;
                        break;
                    }
                    break;
                case 169100306:
                    if (type.equals("cover_event")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1872264986:
                    if (type.equals("birth_event")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    HolderItem holderItem = (HolderItem) EntityUtils.findFirstItem(getDataList(), "holder_address");
                    int indexOf = getDataList().indexOf(holderItem);
                    if (indexOf > 0) {
                        HolderItem build = HolderItem.newBuilder(holderItem).value(this.mUserProfile.getAddressString()).build();
                        getDataList().remove(indexOf);
                        getDataList().add(indexOf, build);
                        return;
                    }
                    return;
                case 1:
                    HolderItem holderItem2 = (HolderItem) EntityUtils.findFirstItem(getDataList(), "holder_gender");
                    int indexOf2 = getDataList().indexOf(holderItem2);
                    if (indexOf2 > 0) {
                        HolderItem build2 = HolderItem.newBuilder(holderItem2).value(getGenderString(getActivity(), this.mUserProfile.getGender())).build();
                        getDataList().remove(indexOf2);
                        getDataList().add(indexOf2, build2);
                        return;
                    }
                    return;
                case 2:
                    HolderItem holderItem3 = (HolderItem) EntityUtils.findFirstItem(getDataList(), "holder_signature");
                    int indexOf3 = getDataList().indexOf(holderItem3);
                    if (indexOf3 > 0) {
                        HolderItem build3 = HolderItem.newBuilder(holderItem3).value(this.mUserProfile.getSignature()).build();
                        getDataList().remove(indexOf3);
                        getDataList().add(indexOf3, build3);
                        return;
                    }
                    return;
                case 3:
                    HolderItem holderItem4 = (HolderItem) EntityUtils.findFirstItem(getDataList(), "holder_cover");
                    getDataList().set(getDataList().indexOf(holderItem4), HolderItem.newBuilder(holderItem4).value(this.mUserProfile.getCover()).build());
                    return;
                case 4:
                    UserProfile result = userProfileEvent.getResult();
                    HolderItem holderItem5 = (HolderItem) EntityUtils.findFirstItem(getDataList(), "holder_birthday");
                    int indexOf4 = getDataList().indexOf(holderItem5);
                    if (indexOf4 > 0) {
                        HolderItem build4 = HolderItem.newBuilder(holderItem5).value(this.mUserProfile.getBirthDayString()).build();
                        getDataList().remove(indexOf4);
                        getDataList().add(indexOf4, build4);
                    }
                    HolderItem holderItem6 = (HolderItem) EntityUtils.findFirstItem(getDataList(), "holder_zodia_sign");
                    if (holderItem6 == null) {
                        holderItem6 = HolderItem.newBuilder().entityType("holder_zodia_sign").build();
                    }
                    int indexOf5 = getDataList().indexOf(holderItem6);
                    if (indexOf5 < 0 && !TextUtils.isEmpty(result.getZodiacSign())) {
                        indexOf5 = indexOf4 + 1;
                    }
                    HolderItem build5 = HolderItem.newBuilder(holderItem6).value(this.mUserProfile.getZodiacSign()).build();
                    getDataList().remove(indexOf5);
                    getDataList().add(indexOf5, build5);
                    return;
                default:
                    return;
            }
        }
    }

    @Subscribe
    public void onLoginEvent(LoginSession loginSession) {
        if (!loginSession.isLogin()) {
            getActivity().finish();
        } else if (!getDataList().isEmpty()) {
            getRecyclerView().getAdapter().notifyItemChanged(0);
            HolderItem holderItem = (HolderItem) EntityUtils.findFirstItem(getDataList(), "holder_username");
            int indexOf = getDataList().indexOf(holderItem);
            if (indexOf > 0) {
                HolderItem build = HolderItem.newBuilder(holderItem).value(loginSession.getUserName()).build();
                getDataList().remove(indexOf);
                getDataList().add(indexOf, build);
            }
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        setLayoutManager(new LinearLayoutManager(getActivity()));
        setLoadMoreEnable(false);
        setRefreshEnable(false);
        DataAdapter dataAdapter = new DataAdapter();
        setAdapter(dataAdapter);
        this.dataList.addOnListChangedCallback(new AdapterListChangedCallback(dataAdapter));
        if (getUserVisibleHint()) {
            initData();
        }
        EventBus.getDefault().register(this);
    }

    public ObservableArrayList<HolderItem> getDataList() {
        return this.dataList;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<HolderItem> list) {
        getDataList().clear();
        getDataList().addAll(list);
        updateContentUI();
        return false;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 555 && intent != null) {
            String stringExtra = intent.getStringExtra("EMAIL");
            this.mUserProfile = UserProfile.builder(this.mUserProfile).setEMail(stringExtra).setEmailStatus(1).build();
            HolderItem holderItem = (HolderItem) EntityUtils.findFirstItem(getDataList(), "holder_email");
            int indexOf = getDataList().indexOf(holderItem);
            if (indexOf > 0) {
                HolderItem build = HolderItem.newBuilder(holderItem).value(stringExtra).build();
                getDataList().remove(indexOf);
                getDataList().add(indexOf, build);
            }
        } else if (i2 == -1 && i == 666 && intent != null) {
            String stringExtra2 = intent.getStringExtra("PHONE");
            this.mUserProfile = UserProfile.builder(this.mUserProfile).setPhoneNumber(stringExtra2).setMobileStatus(1).build();
            HolderItem holderItem2 = (HolderItem) EntityUtils.findFirstItem(getDataList(), "holder_phone");
            int indexOf2 = getDataList().indexOf(holderItem2);
            if (indexOf2 > 0) {
                HolderItem build2 = HolderItem.newBuilder(holderItem2).value(stringExtra2).build();
                getDataList().remove(indexOf2);
                getDataList().add(indexOf2, build2);
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
        bundle.putParcelable("PROFILE", this.mUserProfile);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<HolderItem>> onCreateRequest(boolean z, int i) {
        LoginSession loginSession = DataManager.getInstance().getLoginSession();
        if (!loginSession.isLogin()) {
            return null;
        }
        return DataManager.getInstance().getUserProfile(loginSession.getUid()).map(RxUtils.checkResultToData()).map(new Func1() {
            /* class com.coolapk.market.view.user.$$Lambda$UserProfileFragment$zxZjilbVFb7ywlzHDgJ9SQd0N2s */

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return UserProfileFragment.this.lambda$onCreateRequest$0$UserProfileFragment((UserProfile) obj);
            }
        });
    }

    public /* synthetic */ List lambda$onCreateRequest$0$UserProfileFragment(UserProfile userProfile) {
        this.mUserProfile = userProfile;
        return convert(userProfile);
    }

    private List<HolderItem> convert(UserProfile userProfile) {
        ArrayList arrayList = new ArrayList();
        Application application = AppHolder.getApplication();
        arrayList.add(HolderItem.newBuilder().entityType("holder_avatar").string(application.getString(2131887106)).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_cover").string(getString(2131887109)).value(userProfile.getCover()).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_username").string(application.getString(2131887116)).value(userProfile.getUserName()).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_gender").string(application.getString(2131887111)).value(getGenderString(AppHolder.getApplication(), userProfile.getGender())).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_birthday").string(application.getString(2131887107)).value(StringUtils.defaultIfEmpty(userProfile.getBirthDayString(), application.getString(2131887119))).build());
        if (!TextUtils.isEmpty(userProfile.getZodiacSign())) {
            arrayList.add(HolderItem.newBuilder().entityType("holder_zodia_sign").string(application.getString(2131887121)).value(StringUtils.defaultIfEmpty(userProfile.getZodiacSign(), application.getString(2131887119))).build());
        }
        arrayList.add(HolderItem.newBuilder().entityType("holder_address").string(getString(2131887108)).value(StringUtils.defaultIfEmpty(userProfile.getAddressString(), application.getString(2131887119))).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_signature").string(application.getString(2131887118)).value(userProfile.getSignature()).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_user_account").string("账号与绑定").build());
        return arrayList;
    }

    private String getGenderString(Context context, int i) {
        if (i == 0) {
            return context.getString(2131887113);
        }
        if (i != 1) {
            return context.getString(2131887119);
        }
        return context.getString(2131887112);
    }

    private static class ProfileItemViewHolder extends GenericBindHolder<ItemUserProfileItemBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558980;

        public ProfileItemViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemUserProfileItemBinding) getBinding()).setHolderItem(holderItem);
            ((ItemUserProfileItemBinding) getBinding()).titleView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            ((ItemUserProfileItemBinding) getBinding()).imageView.setVisibility(TextUtils.equals("holder_user_account", holderItem.getEntityType()) ? 0 : 8);
            ViewUtil.clickListener(((ItemUserProfileItemBinding) getBinding()).getRoot(), this);
            ((ItemUserProfileItemBinding) getBinding()).executePendingBindings();
        }
    }

    public static class ProfileAvatarViewHolder extends GenericBindHolder<ItemUserProfileAvatarBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558979;

        public ProfileAvatarViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            ViewUtil.clickListener(((ItemUserProfileAvatarBinding) getBinding()).getRoot(), this);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemUserProfileAvatarBinding) getBinding()).setHolderItem(holderItem);
            ((ItemUserProfileAvatarBinding) getBinding()).executePendingBindings();
            String entityType = holderItem.getEntityType();
            entityType.hashCode();
            if (entityType.equals("holder_avatar")) {
                String userAvatar = DataManager.getInstance().getLoginSession().getUserAvatar();
                ViewExtendsKt.clipView(((ItemUserProfileAvatarBinding) getBinding()).iconView, 0, (float) DisplayUtils.dp2px(getContext(), 24.0f));
                AppHolder.getContextImageLoader().displayImage(getContext(), userAvatar, ((ItemUserProfileAvatarBinding) getBinding()).iconView, 2131231152);
            } else if (entityType.equals("holder_cover")) {
                String value = holderItem.getValue();
                ViewExtendsKt.clipView(((ItemUserProfileAvatarBinding) getBinding()).iconView, 0, (float) DisplayUtils.dp2px(getContext(), 4.0f));
                AppHolder.getContextImageLoader().displayImage(getContext(), value, ((ItemUserProfileAvatarBinding) getBinding()).iconView, 2131231363);
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
        }
    }

    public static class BottomEditTextDialog extends BottomDialogFragment implements View.OnClickListener {
        private DialogEditBinding binding;
        private int limit;
        private Action1<String> listener;
        private String type;

        public static BottomEditTextDialog newInstance(String str, int i, String str2, String str3) {
            Bundle bundle = new Bundle();
            bundle.putString("DATA", str);
            bundle.putInt("TEXT_LIMIT", i);
            bundle.putString("HINT", str2);
            bundle.putString("TYPE", str3);
            BottomEditTextDialog bottomEditTextDialog = new BottomEditTextDialog();
            bottomEditTextDialog.setArguments(bundle);
            return bottomEditTextDialog;
        }

        public static BottomEditTextDialog newInstance(String str, String str2, String str3) {
            Bundle bundle = new Bundle();
            bundle.putString("DATA", str);
            bundle.putString("HINT", str2);
            bundle.putString("TYPE", str3);
            BottomEditTextDialog bottomEditTextDialog = new BottomEditTextDialog();
            bottomEditTextDialog.setArguments(bundle);
            return bottomEditTextDialog;
        }

        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            DialogEditBinding dialogEditBinding = (DialogEditBinding) DataBindingUtil.inflate(layoutInflater, 2131558523, viewGroup, false);
            this.binding = dialogEditBinding;
            return dialogEditBinding.getRoot();
        }

        public void setListener(Action1<String> action1) {
            this.listener = action1;
        }

        @Override // com.coolapk.market.view.base.BottomDialogFragment, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            String string = getArguments().getString("DATA");
            String string2 = getArguments().getString("HINT");
            this.type = getArguments().getString("TYPE");
            String emptyIfNull = StringUtils.emptyIfNull(string);
            this.limit = getArguments().getInt("TEXT_LIMIT", Integer.MAX_VALUE);
            this.binding.cancelButton.setOnClickListener(this);
            this.binding.okButton.setOnClickListener(this);
            this.binding.editText.append(emptyIfNull);
            this.binding.textInputLayout.setHint(string2);
            this.binding.textInputLayout.setHintTextColor(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
            setupForTextLimit();
            TintHelper.setCursorTint(this.binding.textInputLayout.getEditText(), AppHolder.getAppTheme().getColorAccent());
            int dp2px = DisplayUtils.dp2px(getActivity(), 8.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
            float f = (float) dp2px;
            gradientDrawable.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
            this.binding.contentView.setBackground(gradientDrawable);
            getDialog().setCanceledOnTouchOutside(false);
            UiUtils.openKeyboard(this.binding.editText);
            getDialog().getWindow().clearFlags(131080);
            getDialog().getWindow().setSoftInputMode(5);
        }

        public TextView getTipView() {
            return this.binding.tipView;
        }

        public ProgressBar getLoadingView() {
            return this.binding.loadingView;
        }

        private void setupForTextLimit() {
            if (this.limit < Integer.MAX_VALUE) {
                this.binding.textInputLayout.setCounterEnabled(true);
                this.binding.textInputLayout.setCounterMaxLength(this.limit);
                this.binding.editText.addTextChangedListener(new TextWatcher() {
                    /* class com.coolapk.market.view.user.UserProfileFragment.BottomEditTextDialog.AnonymousClass1 */

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        int i;
                        if (editable.length() > BottomEditTextDialog.this.limit) {
                            i = ResourceUtils.getColorInt(BottomEditTextDialog.this.getActivity(), 2131100035);
                        } else {
                            i = AppHolder.getAppTheme().getColorAccent();
                        }
                        BottomEditTextDialog.this.binding.okButton.setTextColor(i);
                        BottomEditTextDialog.this.binding.cancelButton.setTextColor(i);
                    }
                });
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131362196) {
                getDialog().dismiss();
            } else if (id == 2131363037) {
                this.binding.loadingView.setVisibility(0);
                if (this.binding.tipView.getText() != null) {
                    this.binding.tipView.setText((CharSequence) null);
                }
                String obj = this.binding.editText.getText().toString();
                if (this.listener == null) {
                    return;
                }
                if (obj.length() <= this.limit) {
                    this.listener.call(obj);
                } else {
                    Toast.show(getActivity(), String.format(Locale.getDefault(), "字数不能超过 %d 字", Integer.valueOf(this.limit)));
                }
            }
        }

        @Override // com.coolapk.market.view.base.BaseDialogFragment, androidx.fragment.app.DialogFragment
        public void show(FragmentManager fragmentManager, String str) {
            super.show(fragmentManager, str);
        }
    }

    public static class CityPickerDialog extends BaseDialogFragment implements DialogInterface.OnClickListener {
        private DialogCityPickerBinding binding;
        private Action2<String, String> listener;
        private List<Province> provinces;

        public static CityPickerDialog newInstance(UserProfile userProfile) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DATA", userProfile);
            CityPickerDialog cityPickerDialog = new CityPickerDialog();
            cityPickerDialog.setArguments(bundle);
            return cityPickerDialog;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            this.binding = (DialogCityPickerBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558520, null, false);
            initData();
            initUi();
            return new AlertDialog.Builder(getActivity()).setView(this.binding.getRoot()).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, this).create();
        }

        private void initData() {
            try {
                String iOUtils = IOUtils.toString(getActivity().getAssets().open("city.json"));
                this.provinces = new ArrayList();
                JSONObject jSONObject = new JSONObject(iOUtils);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(new City(jSONArray.getString(i)));
                    }
                    this.provinces.add(new Province(next, arrayList));
                }
            } catch (Throwable th) {
                Toast.error(getActivity(), th);
            }
        }

        public void setListener(Action2<String, String> action2) {
            this.listener = action2;
        }

        private void initUi() {
            UserProfile userProfile = (UserProfile) getArguments().getParcelable("DATA");
            if (!CollectionUtils.isEmpty(this.provinces)) {
                String[] strArr = new String[this.provinces.size()];
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < this.provinces.size(); i3++) {
                    strArr[i3] = this.provinces.get(i3).name;
                    if (TextUtils.equals(userProfile.getProvince(), this.provinces.get(i3).name)) {
                        i2 = i3;
                    }
                }
                this.binding.provincePicker.setMinValue(0);
                this.binding.provincePicker.setMaxValue(this.provinces.size() - 1);
                this.binding.provincePicker.setWrapSelectorWheel(false);
                this.binding.provincePicker.setDisplayedValues(strArr);
                this.binding.provincePicker.setValue(i2);
                int colorAccent = AppHolder.getAppTheme().getColorAccent();
                this.binding.provincePicker.setSelectionDivider(new ColorDrawable(colorAccent));
                this.binding.cityPicker.setSelectionDivider(new ColorDrawable(colorAccent));
                this.binding.provincePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    /* class com.coolapk.market.view.user.UserProfileFragment.CityPickerDialog.AnonymousClass1 */

                    @Override // com.lany.picker.NumberPicker.OnValueChangeListener
                    public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                        CityPickerDialog cityPickerDialog = CityPickerDialog.this;
                        cityPickerDialog.updateCities(((Province) cityPickerDialog.provinces.get(i2)).cities);
                    }
                });
                List<City> list = this.provinces.get(i2).cities;
                updateCities(list);
                if (!CollectionUtils.isEmpty(list)) {
                    int i4 = 0;
                    while (i < list.size()) {
                        if (TextUtils.equals(userProfile.getCity(), list.get(i).name)) {
                            i4 = i;
                        }
                        i++;
                    }
                    i = i4;
                }
                this.binding.cityPicker.setValue(i);
            }
        }

        /* access modifiers changed from: private */
        public void updateCities(List<City> list) {
            this.binding.cityPicker.setValue(0);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = list.get(i).name;
            }
            this.binding.cityPicker.setDisplayedValues(null);
            this.binding.cityPicker.setMinValue(0);
            this.binding.cityPicker.setMaxValue(list.size() - 1);
            this.binding.cityPicker.setWrapSelectorWheel(false);
            this.binding.cityPicker.setDisplayedValues(strArr);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            int value = this.binding.provincePicker.getValue();
            int value2 = this.binding.cityPicker.getValue();
            Province province = this.provinces.get(value);
            Action2<String, String> action2 = this.listener;
            if (action2 != null) {
                action2.call(province.name, province.cities.get(value2).name);
            }
        }

        private static class Province {
            public final List<City> cities;
            public final String name;

            public Province(String str, List<City> list) {
                this.name = str;
                this.cities = list;
            }
        }

        private static class City {
            public final String name;

            public City(String str) {
                this.name = str;
            }
        }
    }

    public static class GenderPicker extends BaseDialogFragment implements DialogInterface.OnClickListener {
        private DialogGenderPickerBinding binding;
        private Action1<Integer> listener;

        public static GenderPicker newInstance(UserProfile userProfile) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DATA", userProfile);
            GenderPicker genderPicker = new GenderPicker();
            genderPicker.setArguments(bundle);
            return genderPicker;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            this.binding = (DialogGenderPickerBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558525, null, false);
            initUi();
            return new AlertDialog.Builder(getActivity()).setView(this.binding.getRoot()).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, this).create();
        }

        public void setListener(Action1<Integer> action1) {
            this.listener = action1;
        }

        private void initUi() {
            int gender = ((UserProfile) getArguments().getParcelable("DATA")).getGender() + 1;
            if (gender < 0 || gender > 2) {
                gender = 0;
            }
            String[] strArr = {getActivity().getString(2131887119), getActivity().getString(2131887113), getActivity().getString(2131887112)};
            this.binding.picker.setMinValue(0);
            this.binding.picker.setMaxValue(2);
            this.binding.picker.setWrapSelectorWheel(false);
            this.binding.picker.setDisplayedValues(strArr);
            this.binding.picker.setValue(gender);
            this.binding.picker.setSelectionDivider(new ColorDrawable(AppHolder.getAppTheme().getColorAccent()));
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Action1<Integer> action1 = this.listener;
            if (action1 != null) {
                action1.call(Integer.valueOf(this.binding.picker.getValue() - 1));
            }
        }
    }

    public static class BirthDayDialog extends BaseDialogFragment implements DialogInterface.OnClickListener {
        private DialogDatePickerBinding binding;
        private Action3<String, String, String> listener;

        public static BirthDayDialog newInstance(UserProfile userProfile) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DATA", userProfile);
            BirthDayDialog birthDayDialog = new BirthDayDialog();
            birthDayDialog.setArguments(bundle);
            return birthDayDialog;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            this.binding = (DialogDatePickerBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558522, null, false);
            UserProfile userProfile = (UserProfile) getArguments().getParcelable("DATA");
            int birthyear = userProfile.getBirthyear();
            if (birthyear < 1900) {
                birthyear = 1990;
            }
            int birthmonth = userProfile.getBirthmonth();
            if (birthmonth > 0) {
                birthmonth--;
            }
            this.binding.datePicker.setMaxDate(System.currentTimeMillis());
            this.binding.datePicker.init(birthyear, birthmonth, userProfile.getBirthday());
            this.binding.datePicker.setSelectionDivider(new ColorDrawable(AppHolder.getAppTheme().getColorAccent()));
            return new AlertDialog.Builder(getActivity()).setView(this.binding.getRoot()).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, this).create();
        }

        public void setListener(Action3<String, String, String> action3) {
            this.listener = action3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Action3<String, String, String> action3 = this.listener;
            if (action3 != null) {
                action3.call(String.valueOf(this.binding.datePicker.getYear()), String.valueOf(this.binding.datePicker.getMonth() + 1), String.valueOf(this.binding.datePicker.getDayOfMonth()));
            }
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;

        public DataAdapter() {
            this.component = new FragmentBindingComponent(UserProfileFragment.this.getFragment());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            String entityType = ((HolderItem) UserProfileFragment.this.getDataList().get(i)).getEntityType();
            entityType.hashCode();
            return (entityType.equals("holder_avatar") || entityType.equals("holder_cover")) ? 2131558979 : 2131558980;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(UserProfileFragment.this.getActivity()).inflate(i, viewGroup, false);
            switch (i) {
                case 2131558979:
                    return new ProfileAvatarViewHolder(inflate, this.component, new ItemActionHandler() {
                        /* class com.coolapk.market.view.user.UserProfileFragment.DataAdapter.AnonymousClass1 */

                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            super.onItemClick(viewHolder, view);
                            String entityType = ((HolderItem) UserProfileFragment.this.getDataList().get(viewHolder.getAdapterPosition())).getEntityType();
                            entityType.hashCode();
                            if (entityType.equals("holder_avatar")) {
                                ActionManager.startChangeAvatar(UserProfileFragment.this.getActivity());
                            } else if (entityType.equals("holder_cover")) {
                                ActionManager.startChangeUserCover(UserProfileFragment.this.getActivity(), UserProfileFragment.this.mUserProfile);
                            }
                        }
                    });
                case 2131558980:
                    return new ProfileItemViewHolder(inflate, new ProfileActionHandler());
                default:
                    throw new RuntimeException("unknown view type...");
            }
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(UserProfileFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UserProfileFragment.this.dataList.size();
        }
    }

    private class ProfileActionHandler extends ItemActionHandler {
        private ProfileActionHandler() {
        }

        @Override // com.coolapk.market.viewholder.ItemActionHandler
        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
            super.onItemClick(viewHolder, view);
            int adapterPosition = viewHolder.getAdapterPosition();
            if (adapterPosition >= 0) {
                String entityType = ((HolderItem) UserProfileFragment.this.getDataList().get(adapterPosition)).getEntityType();
                entityType.hashCode();
                char c = 65535;
                switch (entityType.hashCode()) {
                    case -1970078948:
                        if (entityType.equals("holder_home_page")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1932241556:
                        if (entityType.equals("holder_user_account")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1921610231:
                        if (entityType.equals("holder_username")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1867994956:
                        if (entityType.equals("holder_gender")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1715811459:
                        if (entityType.equals("holder_logout")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -616068279:
                        if (entityType.equals("holder_email")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -606044901:
                        if (entityType.equals("holder_phone")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -599675755:
                        if (entityType.equals("holder_weibo")) {
                            c = 7;
                            break;
                        }
                        break;
                    case -586520656:
                        if (entityType.equals("holder_birthday")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -433277622:
                        if (entityType.equals("holder_devices")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 1154196577:
                        if (entityType.equals("holder_address")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 1280391653:
                        if (entityType.equals("holder_signature")) {
                            c = 11;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        ActionManager.startUserSpaceActivity(UserProfileFragment.this.getActivity(), DataManager.getInstance().getLoginSession().getUid());
                        return;
                    case 1:
                        ActionManager.startWebViewTitleActivity(UserProfileFragment.this.getActivity(), "https://account.coolapk.com/account/settings", "", true);
                        return;
                    case 2:
                        ActionManager.startWebViewTitleActivity(UserProfileFragment.this.getActivity(), "https://account.coolapk.com/account/changeUsername", "", true);
                        return;
                    case 3:
                        showGenderDialog();
                        return;
                    case 4:
                        LoginSession loginSession = DataManager.getInstance().getLoginSession();
                        loginSession.reset();
                        EventBus.getDefault().post(loginSession);
                        UserProfileFragment.this.getActivity().finish();
                        return;
                    case 5:
                        UserProfileFragment.this.checkStatus("EMAIL");
                        return;
                    case 6:
                        UserProfileFragment.this.checkStatus("PHONE");
                        return;
                    case 7:
                        BottomEditTextDialog newInstance = BottomEditTextDialog.newInstance(UserProfileFragment.this.mUserProfile.getWeibo(), "修改微博", "holder_weibo");
                        newInstance.setListener(new Action1<String>() {
                            /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass1 */

                            public void call(String str) {
                                DataManager.getInstance().changeWeiboProfile(str).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<UserProfile>() {
                                    /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass1.AnonymousClass1 */

                                    public void onNext(UserProfile userProfile) {
                                        super.onNext((AnonymousClass1) userProfile);
                                        UserProfileFragment.this.mUserProfile = UserProfile.builder(UserProfileFragment.this.mUserProfile).setWeibo(userProfile.getWeibo()).build();
                                        HolderItem holderItem = (HolderItem) EntityUtils.findFirstItem(UserProfileFragment.this.getDataList(), "holder_weibo");
                                        int indexOf = UserProfileFragment.this.getDataList().indexOf(holderItem);
                                        if (indexOf > 0) {
                                            HolderItem build = HolderItem.newBuilder(holderItem).value(userProfile.getWeibo()).build();
                                            UserProfileFragment.this.getDataList().remove(indexOf);
                                            UserProfileFragment.this.getDataList().add(indexOf, build);
                                        }
                                    }

                                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                    public void onError(Throwable th) {
                                        Toast.error(UserProfileFragment.this.getActivity(), th);
                                    }
                                });
                            }
                        });
                        newInstance.show(UserProfileFragment.this.getChildFragmentManager(), (String) null);
                        return;
                    case '\b':
                        showBirthDayDialog();
                        return;
                    case '\t':
                        ActionManager.startWebViewTitleActivity(UserProfileFragment.this.getActivity(), "https://m.coolapk.com/mp/do?c=userDevice&m=myDevice", UserProfileFragment.this.getString(2131886877));
                        return;
                    case '\n':
                        showAddressDialog();
                        return;
                    case 11:
                        showSignatureDialog();
                        return;
                    default:
                        return;
                }
            }
        }

        private void showSignatureDialog() {
            final BottomEditTextDialog newInstance = BottomEditTextDialog.newInstance(UserProfileFragment.this.mUserProfile.getSignature(), 60, "修改签名", "holder_signature");
            newInstance.setListener(new Action1<String>() {
                /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass2 */

                public void call(String str) {
                    DataManager.getInstance().changeSignatureProfile(str).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<UserProfile>() {
                        /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass2.AnonymousClass1 */

                        public void onNext(UserProfile userProfile) {
                            super.onNext((AnonymousClass1) userProfile);
                            UserProfileEvent.dispatch("signature_event", userProfile);
                            Toast.show(AppHolder.getApplication(), "修改成功");
                            newInstance.getLoadingView().setVisibility(8);
                            newInstance.dismiss();
                        }

                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                        public void onError(Throwable th) {
                            super.onError(th);
                            if (th != null) {
                                newInstance.getLoadingView().setVisibility(8);
                                newInstance.getTipView().setText(th.getCause().getMessage());
                            }
                        }
                    });
                }
            });
            newInstance.show(UserProfileFragment.this.getChildFragmentManager(), (String) null);
        }

        private void showAddressDialog() {
            CityPickerDialog newInstance = CityPickerDialog.newInstance(UserProfileFragment.this.mUserProfile);
            newInstance.setListener(new Action2<String, String>() {
                /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass3 */

                public void call(String str, String str2) {
                    try {
                        DataManager.getInstance().changeProfileValue("", new JSONObject().put("province", str).put("city", str2).toString()).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<UserProfile>() {
                            /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass3.AnonymousClass1 */

                            public void onNext(UserProfile userProfile) {
                                super.onNext((AnonymousClass1) userProfile);
                                UserProfileEvent.dispatch("address_event", userProfile);
                            }

                            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                            public void onError(Throwable th) {
                                Toast.error(UserProfileFragment.this.getActivity(), th);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            newInstance.show(UserProfileFragment.this.getChildFragmentManager(), (String) null);
        }

        private void showGenderDialog() {
            GenderPicker newInstance = GenderPicker.newInstance(UserProfileFragment.this.mUserProfile);
            newInstance.setListener(new Action1<Integer>() {
                /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass4 */

                public void call(Integer num) {
                    DataManager.getInstance().changeProfileValue("gender", String.valueOf(num)).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<UserProfile>() {
                        /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass4.AnonymousClass1 */

                        public void onNext(UserProfile userProfile) {
                            super.onNext((AnonymousClass1) userProfile);
                            UserProfileEvent.dispatch("gender_event", userProfile);
                        }

                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                        public void onError(Throwable th) {
                            Toast.error(UserProfileFragment.this.getActivity(), th);
                        }
                    });
                }
            });
            newInstance.show(UserProfileFragment.this.getChildFragmentManager(), (String) null);
        }

        private void showBirthDayDialog() {
            BirthDayDialog newInstance = BirthDayDialog.newInstance(UserProfileFragment.this.mUserProfile);
            newInstance.setListener(new Action3<String, String, String>() {
                /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass5 */

                public void call(String str, String str2, String str3) {
                    try {
                        DataManager.getInstance().changeProfileValue("", new JSONObject().put("birthyear", str).put("birthmonth", str2).put("birthday", str3).toString()).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<UserProfile>() {
                            /* class com.coolapk.market.view.user.UserProfileFragment.ProfileActionHandler.AnonymousClass5.AnonymousClass1 */

                            public void onNext(UserProfile userProfile) {
                                super.onNext((AnonymousClass1) userProfile);
                                UserProfileEvent.dispatch("birth_event", userProfile);
                            }

                            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                            public void onError(Throwable th) {
                                Toast.error(UserProfileFragment.this.getActivity(), th);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            newInstance.show(UserProfileFragment.this.getChildFragmentManager(), (String) null);
        }
    }

    /* access modifiers changed from: private */
    public void checkStatus(final String str) {
        String str2;
        boolean equals = TextUtils.equals(str, "EMAIL");
        boolean equals2 = TextUtils.equals(str, "PHONE");
        if (this.mUserProfile.getEmailStatus() == 0 && equals) {
            ActionManager.startEditUserInfoActivity(this, str, this.mUserProfile);
        } else if (this.mUserProfile.getMobileStatus() != 0 || !equals2) {
            if (equals) {
                str2 = "你的邮箱已绑定为：" + StringUtils.emptyIfNull(this.mUserProfile.getEMail()) + "\n确定要修改吗？";
            } else if (equals2) {
                str2 = "你的手机号已绑定为：" + StringUtils.emptyIfNull(this.mUserProfile.getPhoneNumber()) + "\n确定要修改吗？";
            } else {
                str2 = "";
            }
            SimpleDialog newInstance = SimpleDialog.newInstance();
            newInstance.setMessage(str2);
            newInstance.setNegativeButton(2131886706);
            newInstance.setPositiveButton(2131886710, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.user.UserProfileFragment.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    UserProfileFragment userProfileFragment = UserProfileFragment.this;
                    ActionManager.startEditUserInfoActivity(userProfileFragment, str, userProfileFragment.mUserProfile);
                }
            });
            newInstance.show(getChildFragmentManager(), (String) null);
        } else {
            ActionManager.startEditUserInfoActivity(this, str, this.mUserProfile);
        }
    }
}
