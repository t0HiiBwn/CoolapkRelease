package com.coolapk.market.view.contact;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemContactBinding;
import com.coolapk.market.databinding.ItemSearchViewBinding;
import com.coolapk.market.databinding.ItemUserBinding;
import com.coolapk.market.databinding.ItemUserDeleteRecentBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.User;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.ToolbarActivity;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment;
import com.coolapk.market.view.contact.ContactContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ContactViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.TitleViewHolder;
import com.coolapk.market.viewholder.UserViewHolder;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ContactPickFragment extends SimpleAsyncListFragment<Result<List<Entity>>, Entity> implements ContactContract.View {
    public static final String EXTRA_ERROR_TEXT = "EXTRA_ERROR_TEXT";
    public static final String EXTRA_MAX_COUNT = "EXTRA_MAX_COUNT";
    public static final String HOLDER_TYPE_DELETE = "holder_type_delete_recent";
    public static final String HOLDER_TYPE_SEARCH = "holder_type_search";
    public static final String RESULT_CONTACTS = "result_contact";
    private String errorText = "";
    private FloatingActionButton fab;
    private ContactContract.PickPresenter mPickPresenter;
    private int maxCount = Integer.MAX_VALUE;
    private Map<String, User> userMap;

    public static ContactPickFragment newInstance(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_ERROR_TEXT", str);
        bundle.putInt("EXTRA_MAX_COUNT", i);
        ContactPickFragment contactPickFragment = new ContactPickFragment();
        contactPickFragment.setArguments(bundle);
        return contactPickFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList parcelableArrayList;
        this.maxCount = getArguments().getInt("EXTRA_MAX_COUNT", Integer.MAX_VALUE);
        this.errorText = getArguments().getString("EXTRA_ERROR_TEXT", "");
        this.userMap = new LinkedHashMap();
        if (!(bundle == null || (parcelableArrayList = bundle.getParcelableArrayList("userDict")) == null)) {
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                User user = (User) parcelableArrayList.get(i);
                this.userMap.put(user.getUserName(), user);
            }
        }
        if (getActivity() instanceof ToolbarActivity) {
            this.fab = ((ToolbarActivity) getActivity()).getFab();
        } else if (getActivity() instanceof ContactPickActivityV9) {
            this.fab = ((ContactPickActivityV9) getActivity()).getFab();
        }
        this.fab.setBackgroundTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        this.fab.setImageTintList(ColorStateList.valueOf(-1));
        this.fab.setVisibility(this.userMap.size() > 0 ? 0 : 8);
        ViewUtil.clickListener(this.fab, new View.OnClickListener() {
            /* class com.coolapk.market.view.contact.ContactPickFragment.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContactPickFragment.this.onDone();
            }
        });
        super.onActivityCreated(bundle);
        ((PreventAutoScrollRecyclerView) getRecyclerView()).setPreventAutoScroll(false);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558967, 2131231052).type(2131558660, 2131231052).type(2131558917, 2131231052).type(2131558954, 2131231052).type(2131558971, 2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setClipToPadding(false);
        getRecyclerView().post(new Runnable() {
            /* class com.coolapk.market.view.contact.ContactPickFragment.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (ContactPickFragment.this.fab != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ContactPickFragment.this.fab.getLayoutParams();
                    ContactPickFragment.this.getRecyclerView().setPadding(0, 0, 0, ContactPickFragment.this.fab.getHeight() + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin);
                }
            }
        });
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setRefreshEnable(false);
        if (getUserVisibleHint()) {
            initData();
        }
    }

    /* access modifiers changed from: private */
    public void onDone() {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.userMap.size());
        arrayList.addAll(this.userMap.values());
        this.mPickPresenter.saveUserEntities(arrayList);
        getActivity().setResult(-1, new Intent().putParcelableArrayListExtra("result_contact", arrayList));
        getActivity().finish();
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter) {
        this.mPickPresenter = (ContactContract.PickPresenter) presenter;
        super.setPresenter(presenter);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.userMap != null) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.userMap.size());
            arrayList.addAll(this.userMap.values());
            bundle.putParcelableArrayList("userDict", arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        boolean z2 = false;
        if (result.getData() != null && !result.getData().isEmpty()) {
            if (z) {
                getDataList().addAll(0, result.getData());
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                getDataList().addAll(result.getData());
            }
            z2 = true;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FloatingActionButton floatingActionButton = this.fab;
        if (floatingActionButton != null) {
            ViewUtil.clickListener(floatingActionButton, null);
            this.fab = null;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public int getItemViewType(int i) {
        String entityType = ((Entity) getDataList().get(i)).getEntityType();
        entityType.hashCode();
        char c = 65535;
        switch (entityType.hashCode()) {
            case -602316283:
                if (entityType.equals("holder_title")) {
                    c = 0;
                    break;
                }
                break;
            case -567451565:
                if (entityType.equals("contacts")) {
                    c = 1;
                    break;
                }
                break;
            case 3599307:
                if (entityType.equals("user")) {
                    c = 2;
                    break;
                }
                break;
            case 1668787357:
                if (entityType.equals("holder_type_delete_recent")) {
                    c = 3;
                    break;
                }
                break;
            case 2037983290:
                if (entityType.equals("holder_type_search")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 2131558954;
            case 1:
                return 2131558660;
            case 2:
                return 2131558967;
            case 3:
                return 2131558971;
            case 4:
                return 2131558917;
            default:
                throw new RuntimeException("unknown viewType");
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        switch (i) {
            case 2131558660:
                return new ContactPickViewHolder(inflate, getComponent(), null);
            case 2131558917:
                return new SearchViewHolder(inflate, null, null);
            case 2131558954:
                return new TitleViewHolder(inflate, null);
            case 2131558967:
                return new UserPickViewHolder(inflate, getComponent(), null);
            case 2131558971:
                return new DeleteRecentViewHolder(inflate, null);
            default:
                return null;
        }
    }

    @Override // com.coolapk.market.view.contact.ContactContract.View
    public String findFirstItem() {
        Contacts findFirstContactsType = EntityUtils.findFirstContactsType(getDataList());
        if (findFirstContactsType == null) {
            return null;
        }
        return findFirstContactsType.getFollowUid();
    }

    @Override // com.coolapk.market.view.contact.ContactContract.View
    public String findLastItem() {
        Contacts findLastContactsType = EntityUtils.findLastContactsType(getDataList());
        if (findLastContactsType == null) {
            return null;
        }
        return findLastContactsType.getFollowUid();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3478 && i2 == -1) {
            User user = (User) intent.getParcelableExtra("result_user");
            this.userMap.put(user.getUserName(), user);
            onDone();
        }
    }

    public void putPickUser(User user) {
        this.userMap.put(user.getUserName(), user);
        onDone();
    }

    public class SearchViewHolder extends GenericBindHolder<ItemSearchViewBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558917;

        public SearchViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ViewUtil.clickListener(((ItemSearchViewBinding) getBinding()).imageView, new View.OnClickListener() {
                /* class com.coolapk.market.view.contact.ContactPickFragment.SearchViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ContactPickFragment.this.userMap.size() >= ContactPickFragment.this.maxCount) {
                        Toast.show(ContactPickFragment.this.getActivity(), ContactPickFragment.this.errorText);
                        return;
                    }
                    String obj = ((ItemSearchViewBinding) SearchViewHolder.this.getBinding()).editText.getText().toString();
                    if (!TextUtils.isEmpty(obj.trim())) {
                        ActionManager.startSearchUserActivity(ContactPickFragment.this, obj, 3478);
                    }
                }
            });
            ((ItemSearchViewBinding) getBinding()).editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                /* class com.coolapk.market.view.contact.ContactPickFragment.SearchViewHolder.AnonymousClass2 */

                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                        return false;
                    }
                    String obj = ((ItemSearchViewBinding) SearchViewHolder.this.getBinding()).editText.getText().toString();
                    if (TextUtils.isEmpty(obj.trim()) || keyEvent.getAction() != 0) {
                        return true;
                    }
                    ActionManager.startSearchUserActivity(ContactPickFragment.this, obj, 3478);
                    return true;
                }
            });
        }
    }

    public class DeleteRecentViewHolder extends GenericBindHolder<ItemUserDeleteRecentBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558971;

        public DeleteRecentViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, null, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemUserDeleteRecentBinding) getBinding()).setModel(holderItem);
            ViewUtil.clickListener(((ItemUserDeleteRecentBinding) getBinding()).actionView, new View.OnClickListener() {
                /* class com.coolapk.market.view.contact.ContactPickFragment.DeleteRecentViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 0;
                    while (i < ContactPickFragment.this.getDataList().size()) {
                        int itemViewType = ContactPickFragment.this.getItemViewType(i);
                        if (itemViewType == 2131558971 || itemViewType == 2131558967) {
                            ContactPickFragment.this.getDataList().remove(i);
                            i--;
                        }
                        i++;
                    }
                    ContactPickFragment.this.mPickPresenter.clearUserEntities();
                }
            });
            ((ItemUserDeleteRecentBinding) getBinding()).executePendingBindings();
        }
    }

    public class UserPickViewHolder extends UserViewHolder implements CompoundButton.OnCheckedChangeListener {
        private User mUser;

        public UserPickViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.UserViewHolder
        public void bindToContent(User user) {
            super.bindToContent(user);
            this.mUser = user;
            CheckBox checkBox = ((ItemUserBinding) getBinding()).checkBox;
            checkBox.setVisibility(0);
            checkBox.setOnCheckedChangeListener(this);
            checkBox.setChecked(ContactPickFragment.this.userMap.containsKey(user.getUserName()));
            ViewUtil.clickListener(((ItemUserBinding) getBinding()).cardView, new View.OnClickListener() {
                /* class com.coolapk.market.view.contact.ContactPickFragment.UserPickViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CheckBox checkBox = ((ItemUserBinding) UserPickViewHolder.this.getBinding()).checkBox;
                    checkBox.setChecked(!checkBox.isChecked());
                    ContactPickFragment.this.fab.setVisibility(ContactPickFragment.this.userMap.size() > 0 ? 0 : 8);
                }
            });
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
                boolean containsKey = ContactPickFragment.this.userMap.containsKey(this.mUser.getUserName());
                User user = this.mUser;
                int i = 0;
                if (!z || containsKey) {
                    if (!z && containsKey) {
                        ContactPickFragment.this.userMap.remove(user.getUserName());
                    }
                } else if (ContactPickFragment.this.userMap.size() >= ContactPickFragment.this.maxCount) {
                    compoundButton.setChecked(false);
                    Toast.show(ContactPickFragment.this.getActivity(), ContactPickFragment.this.errorText);
                    return;
                } else {
                    ContactPickFragment.this.userMap.put(user.getUserName(), user);
                }
                FloatingActionButton floatingActionButton = ContactPickFragment.this.fab;
                if (ContactPickFragment.this.userMap.size() <= 0) {
                    i = 8;
                }
                floatingActionButton.setVisibility(i);
            }
        }
    }

    public class ContactPickViewHolder extends ContactViewHolder implements CompoundButton.OnCheckedChangeListener {
        private Contacts mContacts;

        public ContactPickViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler, 1);
        }

        @Override // com.coolapk.market.viewholder.ContactViewHolder
        public void bindToContent(Contacts contacts) {
            super.bindToContent(contacts);
            this.mContacts = contacts;
            CheckBox checkBox = ((ItemContactBinding) getBinding()).checkBox;
            checkBox.setVisibility(0);
            checkBox.setOnCheckedChangeListener(this);
            checkBox.setChecked(ContactPickFragment.this.userMap.containsKey(contacts.getFollowUserName()));
            ViewUtil.clickListener(((ItemContactBinding) getBinding()).cardView, new View.OnClickListener() {
                /* class com.coolapk.market.view.contact.ContactPickFragment.ContactPickViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CheckBox checkBox = ((ItemContactBinding) ContactPickViewHolder.this.getBinding()).checkBox;
                    checkBox.setChecked(!checkBox.isChecked());
                    ContactPickFragment.this.fab.setVisibility(ContactPickFragment.this.userMap.size() > 0 ? 0 : 8);
                }
            });
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
                boolean containsKey = ContactPickFragment.this.userMap.containsKey(this.mContacts.getFollowUserName());
                User build = ((User.Builder) ((User.Builder) User.builder().setDeprecatedUserAvatar(this.mContacts.getFollowerUserAvatar())).setIsFollow(this.mContacts.getIsFriend()).setDeprecatedUserName(this.mContacts.getFollowUserName())).setUid(this.mContacts.getFollowUid()).setEntityType("user").build();
                int i = 0;
                if (!z || containsKey) {
                    if (!z && containsKey) {
                        ContactPickFragment.this.userMap.remove(build.getUserName());
                    }
                } else if (ContactPickFragment.this.userMap.size() >= ContactPickFragment.this.maxCount) {
                    compoundButton.setChecked(false);
                    Toast.show(ContactPickFragment.this.getActivity(), ContactPickFragment.this.errorText);
                    return;
                } else {
                    ContactPickFragment.this.userMap.put(build.getUserName(), build);
                }
                FloatingActionButton floatingActionButton = ContactPickFragment.this.fab;
                if (ContactPickFragment.this.userMap.size() <= 0) {
                    i = 8;
                }
                floatingActionButton.setVisibility(i);
            }
        }
    }
}
