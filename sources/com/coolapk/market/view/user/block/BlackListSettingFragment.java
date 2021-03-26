package com.coolapk.market.view.user.block;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.ItemBlackListBinding;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.refresh.LocalDataFragment;
import com.coolapk.market.view.user.block.BlackListSettingFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

public class BlackListSettingFragment extends LocalDataFragment<HolderItem> {
    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_UID = "uid";
    public static final String EXTRA_USERNAME = "username";
    private static final int ID_BLACK_LIST = 123;
    private static final int ID_IGNORE_LIST = 456;
    private static final int ID_LIMIT_LIST = 789;
    private static final String TYPE_BLACK_LIST = "black_list";
    private static final String TYPE_IGNORE_LIST = "ignore_list";
    private static final String TYPE_LIMIT_LIST = "limit_list";
    private boolean isDestroy;
    private Subscription mSubscription;
    private String uid;
    private String userName;
    private UserProfile userProfile;

    public static BlackListSettingFragment newInstance(UserProfile userProfile2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", userProfile2);
        BlackListSettingFragment blackListSettingFragment = new BlackListSettingFragment();
        blackListSettingFragment.setArguments(bundle);
        return blackListSettingFragment;
    }

    public static BlackListSettingFragment newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("uid", str);
        bundle.putString("username", str2);
        BlackListSettingFragment blackListSettingFragment = new BlackListSettingFragment();
        blackListSettingFragment.setArguments(bundle);
        return blackListSettingFragment;
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.userProfile = (UserProfile) getArguments().getParcelable("data");
        this.uid = getArguments().getString("uid");
        this.userName = getArguments().getString("username");
        if (this.userProfile != null) {
            getActivity().setTitle(this.userProfile.getUserName());
            this.uid = this.userProfile.getUid();
            this.userName = this.userProfile.getUserName();
        }
        if (!TextUtils.isEmpty(this.userName)) {
            getActivity().setTitle(this.userName);
        }
        this.mSubscription = DataManager.getInstance().getUserSpaceProfile(this.uid).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new Subscriber<Result<UserProfile>>() {
            /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Toast.error(BlackListSettingFragment.this.getActivity(), th);
            }

            public void onNext(Result<UserProfile> result) {
                if (result.isSuccess()) {
                    BlackListSettingFragment.this.userProfile = result.getData();
                    BlackListSettingFragment blackListSettingFragment = BlackListSettingFragment.this;
                    blackListSettingFragment.uid = blackListSettingFragment.userProfile.getUid();
                    BlackListSettingFragment blackListSettingFragment2 = BlackListSettingFragment.this;
                    blackListSettingFragment2.userName = blackListSettingFragment2.userProfile.getUserName();
                    BlackListSettingFragment.this.initData();
                }
            }
        });
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().addItemDecoration(new PaddingDividerItemDecoration(new PaddingDividerItemDecoration.SimpleCallBack(getActivity()) {
            /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass2 */

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getItemCount() {
                return BlackListSettingFragment.this.getDataList().size();
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getDividerHeight(int i) {
                if (i == 0) {
                    return this.m8dp;
                }
                return this.m1dp;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getFirstHeight() {
                return this.m8dp;
            }
        }));
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public int getItemViewType(int i) {
        String entityType = ((HolderItem) getDataList().get(i)).getEntityType();
        entityType.hashCode();
        char c = 65535;
        switch (entityType.hashCode()) {
            case -1749337438:
                if (entityType.equals("limit_list")) {
                    c = 0;
                    break;
                }
                break;
            case -1638203170:
                if (entityType.equals("black_list")) {
                    c = 1;
                    break;
                }
                break;
            case 1538342635:
                if (entityType.equals("ignore_list")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 789;
            case 1:
                return 123;
            case 2:
                return 456;
            default:
                return i;
        }
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558624, viewGroup, false);
        if (i == 123) {
            return new BlackListViewHolder(inflate, null) {
                /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass3 */

                @Override // com.coolapk.market.view.user.block.BlackListSettingFragment.BlackListViewHolder
                public void bindToContent(HolderItem holderItem) {
                    super.bindToContent(holderItem);
                    if (BlackListSettingFragment.this.userProfile != null && !TextUtils.isEmpty(BlackListSettingFragment.this.uid)) {
                        ((ItemBlackListBinding) getBinding()).switchView.setChecked(BlackListSettingFragment.this.userProfile.getIsInBlackList() > 0);
                        ((ItemBlackListBinding) getBinding()).switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass3.AnonymousClass1 */
                            private boolean ignoreNext;

                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                            public void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
                                if (this.ignoreNext) {
                                    this.ignoreNext = false;
                                } else {
                                    Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                                        /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass3.AnonymousClass1.AnonymousClass2 */

                                        public Observable<Result<String>> call(Boolean bool) {
                                            if (bool.booleanValue()) {
                                                return DataManager.getInstance().addToBlackList(BlackListSettingFragment.this.uid);
                                            }
                                            return DataManager.getInstance().removeFromBlackList(BlackListSettingFragment.this.uid);
                                        }
                                    }).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber) new EmptySubscriber<Result<String>>() {
                                        /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                        public void onError(Throwable th) {
                                            Toast.error(BlackListSettingFragment.this.getActivity(), th);
                                            AnonymousClass1.this.ignoreNext = true;
                                            ((ItemBlackListBinding) AnonymousClass3.this.getBinding()).switchView.setChecked(true ^ z);
                                        }

                                        public void onNext(Result<String> result) {
                                            super.onNext((AnonymousClass1) result);
                                            BlackListSettingFragment.this.userProfile = UserProfile.builder(BlackListSettingFragment.this.userProfile).setIsInBlackList(z ? 1 : 0).build();
                                            if (BlackListSettingFragment.this.isDestroy) {
                                                EventBus.getDefault().post(new UserBlockedEvent(BlackListSettingFragment.this.userProfile));
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }
                }
            };
        }
        if (i == 456) {
            return new BlackListViewHolder(inflate, null) {
                /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass5 */

                @Override // com.coolapk.market.view.user.block.BlackListSettingFragment.BlackListViewHolder
                public void bindToContent(HolderItem holderItem) {
                    super.bindToContent(holderItem);
                    ((ItemBlackListBinding) getBinding()).switchView.setChecked(BlackListSettingFragment.this.userProfile.getIsInIgnoreList() > 0);
                    ((ItemBlackListBinding) getBinding()).switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass5.AnonymousClass1 */
                        private boolean ignoreNext;

                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
                            if (this.ignoreNext) {
                                this.ignoreNext = false;
                            } else {
                                Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                                    /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass5.AnonymousClass1.AnonymousClass2 */

                                    public Observable<Result<String>> call(Boolean bool) {
                                        if (bool.booleanValue()) {
                                            return DataManager.getInstance().addToIgnoreList(BlackListSettingFragment.this.uid);
                                        }
                                        return DataManager.getInstance().removeFromIgnoreList(BlackListSettingFragment.this.uid);
                                    }
                                }).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber) new EmptySubscriber<Result<String>>() {
                                    /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                    public void onError(Throwable th) {
                                        Toast.error(BlackListSettingFragment.this.getActivity(), th);
                                        AnonymousClass1.this.ignoreNext = true;
                                        ((ItemBlackListBinding) AnonymousClass5.this.getBinding()).switchView.setChecked(true ^ z);
                                    }

                                    public void onNext(Result<String> result) {
                                        super.onNext((AnonymousClass1) result);
                                        BlackListSettingFragment.this.userProfile = UserProfile.builder(BlackListSettingFragment.this.userProfile).setIsInIgnoreList(z ? 1 : 0).build();
                                        if (BlackListSettingFragment.this.isDestroy) {
                                            EventBus.getDefault().post(new UserBlockedEvent(BlackListSettingFragment.this.userProfile));
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            };
        }
        if (i != 789) {
            return null;
        }
        return new BlackListViewHolder(inflate, null) {
            /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass4 */

            @Override // com.coolapk.market.view.user.block.BlackListSettingFragment.BlackListViewHolder
            public void bindToContent(HolderItem holderItem) {
                super.bindToContent(holderItem);
                ((ItemBlackListBinding) getBinding()).switchView.setChecked(BlackListSettingFragment.this.userProfile.getIsInLimitList() > 0);
                ((ItemBlackListBinding) getBinding()).switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass4.AnonymousClass1 */
                    private boolean ignoreNext;

                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
                        if (this.ignoreNext) {
                            this.ignoreNext = false;
                        } else {
                            Observable.just(Boolean.valueOf(z)).flatMap(new Func1() {
                                /* class com.coolapk.market.view.user.block.$$Lambda$BlackListSettingFragment$4$1$7E5yJzldHbxM3KjOw4l1VBbOIug */

                                @Override // rx.functions.Func1
                                public final Object call(Object obj) {
                                    return BlackListSettingFragment.AnonymousClass4.AnonymousClass1.this.lambda$onCheckedChanged$0$BlackListSettingFragment$4$1((Boolean) obj);
                                }
                            }).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber) new EmptySubscriber<Result<String>>() {
                                /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                public void onError(Throwable th) {
                                    Toast.error(BlackListSettingFragment.this.getActivity(), th);
                                    AnonymousClass1.this.ignoreNext = true;
                                    ((ItemBlackListBinding) AnonymousClass4.this.getBinding()).switchView.setChecked(true ^ z);
                                }

                                public void onNext(Result<String> result) {
                                    super.onNext((AnonymousClass1) result);
                                    BlackListSettingFragment.this.userProfile = UserProfile.builder(BlackListSettingFragment.this.userProfile).setIsInLimitList(z ? 1 : 0).build();
                                    if (BlackListSettingFragment.this.isDestroy) {
                                        EventBus.getDefault().post(new UserBlockedEvent(BlackListSettingFragment.this.userProfile));
                                    }
                                }
                            });
                        }
                    }

                    public /* synthetic */ Observable lambda$onCheckedChanged$0$BlackListSettingFragment$4$1(Boolean bool) {
                        if (bool.booleanValue()) {
                            return DataManager.getInstance().addToLimitList(BlackListSettingFragment.this.userProfile.getUid());
                        }
                        return DataManager.getInstance().removeFromLimitList(BlackListSettingFragment.this.userProfile.getUid());
                    }
                });
            }
        };
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
        }
        AppHolder.getMainThreadHandler().post(new Runnable() {
            /* class com.coolapk.market.view.user.block.BlackListSettingFragment.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                BlackListSettingFragment.this.isDestroy = true;
                EventBus.getDefault().post(new UserBlockedEvent(BlackListSettingFragment.this.userProfile));
            }
        });
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        getDataList().add(HolderItem.newBuilder().entityType("black_list").string(getString(2131887062)).value("加入黑名单后，你不会再看到TA的任何动态，TA也不能再关注你或给你发评论、消息以及@通知，但TA可以看到你的动态。").build());
    }

    private abstract class BlackListViewHolder extends GenericBindHolder<ItemBlackListBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558624;

        public BlackListViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemBlackListBinding) getBinding()).setHolder(holderItem);
            ((ItemBlackListBinding) getBinding()).switchView.setOnCheckedChangeListener(null);
        }
    }
}
