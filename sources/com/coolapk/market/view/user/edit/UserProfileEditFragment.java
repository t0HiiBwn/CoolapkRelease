package com.coolapk.market.view.user.edit;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.EditUserViewBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.WeUIItem;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;
import rx.functions.Action1;

public class UserProfileEditFragment extends BaseFragment {
    public static final String DATA_USER = "USER";
    public static final String EDIT_TYPE = "TYPE";
    public static final String EDIT_TYPE_COUNTRY = "COUNTRY";
    public static final String EDIT_TYPE_EMAIL = "EMAIL";
    public static final String EDIT_TYPE_EMAIL_CODE = "EMAIL_CODE";
    public static final String EDIT_TYPE_IMG_CODE = "IMG_CODE";
    public static final String EDIT_TYPE_PHONE = "PHONE";
    public static final String EDIT_TYPE_PHONE_CODE = "PHONE_CODE";
    public static final String EDIT_TYPE_USERNAME = "USERNAME";
    public static final int REQUESTCODE_COUNTY = 777;
    public static final int REQUESTCODE_EMAIL = 555;
    public static final int REQUESTCODE_PHONE = 666;
    private boolean canChanageUserName;
    private ImageView codeImageView;
    private String editType;
    private EditUserViewBinding mBinding;
    private FragmentBindingComponent mComponent;
    private UserProfile mUserProfile;
    private EditUserBaseViewModel model;

    public static UserProfileEditFragment newInstance(String str, UserProfile userProfile) {
        Bundle bundle = new Bundle();
        bundle.putString("TYPE", str);
        bundle.putParcelable("USER", userProfile);
        UserProfileEditFragment userProfileEditFragment = new UserProfileEditFragment();
        userProfileEditFragment.setArguments(bundle);
        return userProfileEditFragment;
    }

    public static UserProfileEditFragment newInstance() {
        Bundle bundle = new Bundle();
        UserProfileEditFragment userProfileEditFragment = new UserProfileEditFragment();
        userProfileEditFragment.setArguments(bundle);
        return userProfileEditFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentBindingComponent fragmentBindingComponent = new FragmentBindingComponent(this);
        this.mComponent = fragmentBindingComponent;
        EditUserViewBinding editUserViewBinding = (EditUserViewBinding) DataBindingUtil.inflate(layoutInflater, 2131558547, viewGroup, false, fragmentBindingComponent);
        this.mBinding = editUserViewBinding;
        return editUserViewBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.editType = getArguments().getString("TYPE");
        this.mUserProfile = (UserProfile) getArguments().getParcelable("USER");
        ((GradientDrawable) this.mBinding.editUserSave.getBackground()).setColor(AppHolder.getAppTheme().getColorAccent());
        String str = this.editType;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 66081660:
                if (str.equals("EMAIL")) {
                    c = 0;
                    break;
                }
                break;
            case 76105038:
                if (str.equals("PHONE")) {
                    c = 1;
                    break;
                }
                break;
            case 516913366:
                if (str.equals("USERNAME")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.model = new UserEmailViewModel();
                setWidth((TextView) this.mBinding.codeInputContainer.getViewById(2131363603), (TextView) this.mBinding.mainInputContainer.getViewById(2131363603));
                break;
            case 1:
                this.model = new UserPhoneViewModel();
                ImageView imageView = (ImageView) this.mBinding.imgCodeContainer.getViewById(2131362467);
                this.codeImageView = imageView;
                imageView.setVisibility(0);
                final TextView textView = (TextView) this.mBinding.codeInputContainer.getViewById(2131361978);
                textView.post(new Runnable() {
                    /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        UserProfileEditFragment.this.codeImageView.getLayoutParams().width = textView.getMeasuredWidth();
                        UserProfileEditFragment.this.codeImageView.requestLayout();
                    }
                });
                setWidth((TextView) this.mBinding.codeInputContainer.getViewById(2131363603), (TextView) this.mBinding.mainInputContainer.getViewById(2131363603));
                captchaImage();
                initInfo();
                break;
            case 2:
                checkUserNameStatus();
                this.model = new UserNameViewModel();
                break;
        }
        this.mBinding.setModel(this.model);
        this.mBinding.editUserSave.setTextColor(ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099917));
        ViewUtil.clickListener(this.mBinding.editUserSave, new View.OnClickListener() {
            /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final String text = UserProfileEditFragment.this.mBinding.mainInputContainer.getText();
                String text2 = UserProfileEditFragment.this.mBinding.codeInputContainer.getText();
                UserProfileEditFragment.this.model.setChanageText(StringUtils.defaultIfEmpty(text, ""));
                UserProfileEditFragment.this.model.setCodeText(StringUtils.defaultIfEmpty(text2, ""));
                if (TextUtils.isEmpty(text.trim())) {
                    Toast.show(UserProfileEditFragment.this.getActivity(), "你什么都没有输入");
                } else if (!StringUtils.isEmail(text) && UserProfileEditFragment.this.model.isEditEmail()) {
                    Toast.show(UserProfileEditFragment.this.getActivity(), "请输入合法的Email地址");
                } else if (TextUtils.isEmpty(text2.trim()) && UserProfileEditFragment.this.model.hasCode()) {
                    Toast.show(UserProfileEditFragment.this.getActivity(), "请输入验证码");
                } else if (StringUtils.isPhoneNumber(text) || !UserProfileEditFragment.this.model.isEditPhoneNumber()) {
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    newInstance.setTitle(UserProfileEditFragment.this.model.getDialogTitle());
                    newInstance.setMessage(UserProfileEditFragment.this.model.getDialogMessage() + text);
                    newInstance.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass2.AnonymousClass1 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            final ProgressDialog progressDialog = new ProgressDialog(UserProfileEditFragment.this.getActivity());
                            progressDialog.setProgressStyle(0);
                            progressDialog.setMessage(UserProfileEditFragment.this.getString(2131886825));
                            progressDialog.setCanceledOnTouchOutside(false);
                            progressDialog.setCancelable(false);
                            progressDialog.show();
                            UserProfileEditFragment.this.model.chanageUserInfo().compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
                                /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                public void onNext(Result<String> result) {
                                    super.onNext((AnonymousClass1) result);
                                    progressDialog.dismiss();
                                    if (result != null && !TextUtils.isEmpty(result.getData())) {
                                        Toast.show(UserProfileEditFragment.this.getActivity(), result.getData());
                                        if (UserProfileEditFragment.this.model.isEditUserName()) {
                                            LoginSession loginSession = DataManager.getInstance().getLoginSession();
                                            loginSession.reset();
                                            EventBus.getDefault().post(loginSession);
                                            if (!DataManager.getInstance().getLoginSession().isLogin()) {
                                                ActionManager.startLoginActivity(UserProfileEditFragment.this.getActivity());
                                            }
                                            UserProfileEditFragment.this.getActivity().finish();
                                        } else if (UserProfileEditFragment.this.model.isEditEmail()) {
                                            UserProfileEditFragment.this.getActivity().setResult(-1, new Intent().putExtra("EMAIL", text.trim()));
                                            UserProfileEditFragment.this.getActivity().finish();
                                        } else if (UserProfileEditFragment.this.model.isEditPhoneNumber()) {
                                            UserProfileEditFragment.this.getActivity().setResult(-1, new Intent().putExtra("PHONE", StringUtils.hideNumber(text.trim())));
                                            UserProfileEditFragment.this.getActivity().finish();
                                        }
                                    } else if (UserProfileEditFragment.this.model.isEditUserName()) {
                                        UserProfileEditFragment.this.showError(result.getMessage());
                                    } else {
                                        Toast.show(UserProfileEditFragment.this.getActivity(), result.getMessage());
                                    }
                                }

                                @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                public void onError(Throwable th) {
                                    super.onError(th);
                                    progressDialog.dismiss();
                                    Toast.error(UserProfileEditFragment.this.getActivity(), th);
                                }
                            });
                        }
                    });
                    newInstance.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
                    newInstance.show(UserProfileEditFragment.this.getChildFragmentManager(), (String) null);
                } else {
                    Toast.show(UserProfileEditFragment.this.getActivity(), "请输入正确的手机号");
                }
            }
        });
        this.mBinding.codeInputContainer.setListener(new Action1<String>() {
            /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass3 */

            public void call(String str) {
                String text = UserProfileEditFragment.this.mBinding.mainInputContainer.getText();
                String text2 = UserProfileEditFragment.this.mBinding.imgCodeContainer.getText();
                UserProfileEditFragment.this.model.setImgCodeText(text2);
                UserProfileEditFragment.this.model.setChanageText(text);
                if (TextUtils.isEmpty(text) && UserProfileEditFragment.this.model.isEditPhoneNumber()) {
                    Toast.show(UserProfileEditFragment.this.getActivity(), "手机号不能为空");
                } else if (TextUtils.isEmpty(text) && UserProfileEditFragment.this.model.isEditEmail()) {
                    Toast.show(UserProfileEditFragment.this.getActivity(), "邮箱不能为空");
                } else if (!StringUtils.isPhoneNumber(text) && UserProfileEditFragment.this.model.isEditPhoneNumber()) {
                    Toast.show(UserProfileEditFragment.this.getActivity(), "请输入正确的手机号");
                } else if (!StringUtils.isEmail(text) && UserProfileEditFragment.this.model.isEditEmail()) {
                    Toast.show(UserProfileEditFragment.this.getActivity(), "邮箱格式不正确");
                } else if (!TextUtils.isEmpty(text2) || !UserProfileEditFragment.this.model.isEditPhoneNumber()) {
                    final ProgressDialog progressDialog = new ProgressDialog(UserProfileEditFragment.this.getActivity());
                    progressDialog.setProgressStyle(0);
                    progressDialog.setMessage("正在提交");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    UserProfileEditFragment.this.model.getCode().compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
                        /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass3.AnonymousClass1 */

                        public void onNext(Result<String> result) {
                            super.onNext((AnonymousClass1) result);
                            progressDialog.dismiss();
                            if (result == null || TextUtils.isEmpty(result.getData())) {
                                if (UserProfileEditFragment.this.model.isEditPhoneNumber()) {
                                    UserProfileEditFragment.this.captchaImage();
                                }
                                Toast.show(UserProfileEditFragment.this.getActivity(), result.getMessage());
                                return;
                            }
                            Toast.show(UserProfileEditFragment.this.getActivity(), result.getData());
                            if (UserProfileEditFragment.this.model.isEditPhoneNumber()) {
                                UserProfileEditFragment.this.captchaImage();
                                return;
                            }
                            TextView textView = (TextView) UserProfileEditFragment.this.mBinding.codeInputContainer.getViewById(2131361978);
                            textView.setText("验证码已发送");
                            textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
                            textView.setClickable(false);
                        }

                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                        public void onError(Throwable th) {
                            super.onError(th);
                            progressDialog.dismiss();
                            Toast.error(UserProfileEditFragment.this.getActivity(), th);
                            if (UserProfileEditFragment.this.model.isEditPhoneNumber()) {
                                UserProfileEditFragment.this.captchaImage();
                            }
                        }
                    });
                } else {
                    Toast.show(UserProfileEditFragment.this.getActivity(), "你还没有填写图形验证码");
                }
            }
        });
        this.mBinding.headContainer.setListener(new Action1<String>() {
            /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass4 */

            public void call(String str) {
                ActionManager.startCountyListActivity(UserProfileEditFragment.this.getFragment());
            }
        });
        this.mBinding.imgCodeContainer.setListener(new Action1<String>() {
            /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass5 */

            public void call(String str) {
                UserProfileEditFragment.this.captchaImage();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 777 && intent != null) {
            HolderItem holderItem = (HolderItem) intent.getParcelableExtra("COUNTRY");
            ((UserPhoneViewModel) this.model).setCountyCode(holderItem.getValue());
            WeUIItem weUIItem = this.mBinding.mainInputContainer;
            weUIItem.setTitle("+" + holderItem.getValue());
            this.mBinding.headContainer.setActionText(holderItem.getString());
        }
    }

    private void checkUserNameStatus() {
        DataManager.getInstance().checkUserNameStatus().compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass6 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(UserProfileEditFragment.this.getActivity(), th);
                UserProfileEditFragment.this.setHasOptionsMenu(false);
            }

            public void onNext(Result<String> result) {
                String str;
                super.onNext((AnonymousClass6) result);
                if (result != null && !TextUtils.isEmpty(result.getData())) {
                    String[] split = result.getData().split(":");
                    int intValue = Integer.valueOf(split[0]).intValue();
                    Long valueOf = Long.valueOf(split[1]);
                    UserProfileEditFragment.this.canChanageUserName = intValue > 0;
                    if (!UserProfileEditFragment.this.canChanageUserName) {
                        ((EditText) UserProfileEditFragment.this.mBinding.mainInputContainer.getViewById(2131362448)).setText(DataManager.getInstance().getLoginSession().getUserName());
                        UserProfileEditFragment.this.mBinding.mainInputContainer.getViewById(2131362448).setFocusable(false);
                        UserProfileEditFragment.this.mBinding.editUserSave.setClickable(false);
                    }
                    TextView textView = UserProfileEditFragment.this.mBinding.tipView;
                    if (UserProfileEditFragment.this.canChanageUserName) {
                        str = "由于系统原因，用户名只能修改一次，您还有一次机会";
                    } else {
                        str = String.format("您已于 %s 修改过用户名，次数已用完", DateUtils.getTimeDescription(UserProfileEditFragment.this.getActivity(), valueOf));
                    }
                    textView.setText(str);
                    UserProfileEditFragment.this.mBinding.tipView.setTextColor(UserProfileEditFragment.this.canChanageUserName ? AppHolder.getAppTheme().getColorAccent() : -65536);
                    UserProfileEditFragment.this.initInfo();
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void captchaImage() {
        String str = DataManager.getInstance().getDataConfig().getApiEndpoint() + "account/captchaImage?" + System.currentTimeMillis();
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        try {
            List<String> coolMarketHeaders = DataManager.getInstance().getDataConfig().getCoolMarketHeaders();
            for (int i = 0; i < coolMarketHeaders.size(); i += 2) {
                builder.addHeader(coolMarketHeaders.get(i), coolMarketHeaders.get(i + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlideApp.with(getFragment()).load((Object) new GlideUrl(str, builder.build())).placeholder(2131231378).into(this.codeImageView);
    }

    /* access modifiers changed from: private */
    public void showError(String str) {
        this.mBinding.tipView.setText(str);
        this.mBinding.tipView.setTextColor(-65536);
    }

    /* access modifiers changed from: private */
    public void initInfo() {
        this.mBinding.otherInfo.setText(this.model.tipInfo());
    }

    private void setWidth(final TextView textView, final TextView textView2) {
        textView.post(new Runnable() {
            /* class com.coolapk.market.view.user.edit.UserProfileEditFragment.AnonymousClass7 */

            @Override // java.lang.Runnable
            public void run() {
                textView2.getLayoutParams().width = textView.getMeasuredWidth();
                if (UserProfileEditFragment.this.model.isEditPhoneNumber()) {
                    textView2.setGravity(5);
                }
                textView2.requestLayout();
            }
        });
    }
}
