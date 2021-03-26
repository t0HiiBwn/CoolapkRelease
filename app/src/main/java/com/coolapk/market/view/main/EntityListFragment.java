package com.coolapk.market.view.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Ads;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.GridCard;
import com.coolapk.market.model.Link;
import com.coolapk.market.model.LinkCard;
import com.coolapk.market.model.MessageCard;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.TabGroupCard;
import com.coolapk.market.model.TopCard;
import com.coolapk.market.model.TopGroupCard;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.view.cardlist.SpecialDividerItemDecoration;
import com.coolapk.market.viewholder.AdsViewHolder;
import com.coolapk.market.viewholder.AlbumViewHolder;
import com.coolapk.market.viewholder.AppForumViewHolder;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.DocMarqueeCardViewHolder;
import com.coolapk.market.viewholder.GridCardViewHolder;
import com.coolapk.market.viewholder.ImageCardViewHolder;
import com.coolapk.market.viewholder.ImageListCardViewHolder;
import com.coolapk.market.viewholder.ImageScrollCardViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.LinkCardViewHolder;
import com.coolapk.market.viewholder.ListCardViewHolder;
import com.coolapk.market.viewholder.MessageCardViewHolder;
import com.coolapk.market.viewholder.ServiceAppViewHolder;
import com.coolapk.market.viewholder.TabGroupCardViewHolder;
import com.coolapk.market.viewholder.TextImageCardViewHolder;
import com.coolapk.market.viewholder.TitleCardViewHolder;
import com.coolapk.market.viewholder.TopGroupCardViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.multitype.EmptyViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EntityListFragment extends NewAsyncListFragment<List<Entity>> {
    public static final String APK_TYPE_ALL = "0";
    public static final String APK_TYPE_APP = "1";
    public static final String APK_TYPE_DYH = "9";
    public static final String APK_TYPE_GAME = "2";
    private static final String KEY_DATA = "DATA";
    private static final String KEY_TAB_GROUP_CARD_INDEX = "TAB_GROUP_CARD_INDEX";
    private final ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private AdapterListChangedCallback onListChangeCallback;
    private RVStateEventChangedAdapter stateEventChangedAdapter;
    private AtomicInteger tabGroupCardIndex = new AtomicInteger(1);

    protected String getApkType() {
        return "0";
    }

    protected int getDataIndex(int i) {
        return i;
    }

    protected int[] getIgnoreSpecialDividerItemViewType() {
        return null;
    }

    protected String getMainEntityType() {
        return null;
    }

    protected boolean isListCardFollowUserRunning(String str) {
        return false;
    }

    protected void onGridCardActionViewClick(RecyclerView.ViewHolder viewHolder, View view, int i, int i2) {
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
            this.tabGroupCardIndex.set(bundle.getInt("TAB_GROUP_CARD_INDEX"));
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((PreventAutoScrollRecyclerView) getRecyclerView()).setPreventAutoScroll(true);
        setEmptyData(getString(2131886764), 0);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558924, 2131231051).type(2131558577, 2131231052).type(2131558800, 2131231051).type(2131558765, 2131231051).type(2131558674, 2131231051).type(2131558791, 2131231051).type(2131558764, 2131231051).type(2131558578, 2131231052).type(2131558825, 2131231051).type(2131558959, 2131231051).type(2131558942, 2131231051).type(2131558949, 2131231051).type(2131558787, 2131231051).type(2131558803, 2131231051).type(2131558955, 2131231052).type(2131558792, 2131231051).type(2131558591, 2131231052).create());
        getRecyclerView().addItemDecoration(new SpecialDividerItemDecoration(getActivity(), new int[]{2131558924, 2131558578}, getIgnoreSpecialDividerItemViewType()));
        getRecyclerView().setItemAnimator(null);
        setAdapter(new DataAdapter(this));
        if (getUserVisibleHint()) {
            initData();
        }
        RVStateEventChangedAdapter rVStateEventChangedAdapter = new RVStateEventChangedAdapter(getRecyclerView());
        this.stateEventChangedAdapter = rVStateEventChangedAdapter;
        rVStateEventChangedAdapter.onAttach();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
        bundle.putInt("TAB_GROUP_CARD_INDEX", this.tabGroupCardIndex.get());
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.stateEventChangedAdapter.onDetach();
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<Entity> list) {
        int i;
        boolean z2 = true;
        if (!CollectionUtils.isEmpty(list)) {
            EntityUtils.removeReduplicatedEntity(list, getDataList(), null);
            if (z) {
                if (getMainEntityType() != null) {
                    Iterator<Entity> it2 = getDataList().iterator();
                    i = 0;
                    while (it2.hasNext() && !TextUtils.equals(it2.next().getEntityType(), getMainEntityType())) {
                        i++;
                    }
                } else {
                    i = 0;
                }
                if (i == getDataList().size()) {
                    getDataList().clear();
                } else {
                    for (int i2 = i - 1; i2 >= 0; i2--) {
                        getDataList().remove(i2);
                    }
                }
                getDataList().addAll(0, list);
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                getDataList().addAll(list);
            }
        } else {
            z2 = false;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        AdapterListChangedCallback adapterListChangedCallback = this.onListChangeCallback;
        if (adapterListChangedCallback != null) {
            this.dataList.removeOnListChangedCallback(adapterListChangedCallback);
            this.onListChangeCallback = null;
        }
        AdapterListChangedCallback adapterListChangedCallback2 = new AdapterListChangedCallback(adapter);
        this.onListChangeCallback = adapterListChangedCallback2;
        this.dataList.addOnListChangedCallback(adapterListChangedCallback2);
    }

    public List<Entity> getDataList() {
        return this.dataList;
    }

    protected void changeTabGroupCardIndex() {
        if (this.tabGroupCardIndex.get() == 0) {
            this.tabGroupCardIndex.set(1);
        } else {
            this.tabGroupCardIndex.set(0);
        }
    }

    public int entityType2ItemViewType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2136267384:
                if (str.equals("titleCard")) {
                    c = 0;
                    break;
                }
                break;
            case -1974884838:
                if (str.equals("tabGroupCard")) {
                    c = 1;
                    break;
                }
                break;
            case -1583570103:
                if (str.equals("imageListCard")) {
                    c = 2;
                    break;
                }
                break;
            case -1216055496:
                if (str.equals("imageScrollCard")) {
                    c = 3;
                    break;
                }
                break;
            case -1079225818:
                if (str.equals("docListCard")) {
                    c = 4;
                    break;
                }
                break;
            case -878677237:
                if (str.equals("imageCard")) {
                    c = 5;
                    break;
                }
                break;
            case -873622601:
                if (str.equals("messageCard")) {
                    c = 6;
                    break;
                }
                break;
            case 96432:
                if (str.equals("ads")) {
                    c = 7;
                    break;
                }
                break;
            case 96796:
                if (str.equals("apk")) {
                    c = '\b';
                    break;
                }
                break;
            case 92896879:
                if (str.equals("album")) {
                    c = '\t';
                    break;
                }
                break;
            case 181378138:
                if (str.equals("topGroupCard")) {
                    c = '\n';
                    break;
                }
                break;
            case 317548406:
                if (str.equals("gridCard")) {
                    c = 11;
                    break;
                }
                break;
            case 362109016:
                if (str.equals("imageTextCard")) {
                    c = '\f';
                    break;
                }
                break;
            case 1144606592:
                if (str.equals("appForum")) {
                    c = '\r';
                    break;
                }
                break;
            case 1193677354:
                if (str.equals("linkCard")) {
                    c = 14;
                    break;
                }
                break;
            case 1345134798:
                if (str.equals("listCard")) {
                    c = 15;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 2131558955;
            case 1:
                return 2131558942;
            case 2:
                return 2131558791;
            case 3:
                return 2131558792;
            case 4:
                return 2131558674;
            case 5:
                return 2131558787;
            case 6:
                return 2131558825;
            case 7:
                return 2131558577;
            case '\b':
                return 2131558924;
            case '\t':
                return 2131558578;
            case '\n':
                return 2131558959;
            case 11:
                return 2131558765;
            case '\f':
                return 2131558949;
            case '\r':
                return 2131558591;
            case 14:
                return 2131558800;
            case 15:
                return 2131558803;
            default:
                return 2131558617;
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private FragmentBindingComponent component;

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            switch (i) {
                case 2131558577:
                    return new AdsViewHolder(inflate, this.component, null);
                case 2131558578:
                    return new AlbumViewHolder(inflate, this.component, new ItemActionHandler() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass5 */

                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            if (viewHolder.getAdapterPosition() != -1 && view.getId() == 2131362752) {
                                Entity entity = EntityListFragment.this.getDataList().get(viewHolder.getAdapterPosition());
                                if (EntityUtils.isAlbumType(entity.getEntityType())) {
                                    ActionManager.startV8AlbumDetailActivity(EntityListFragment.this.getActivity(), entity);
                                }
                            }
                        }
                    });
                case 2131558591:
                    return new AppForumViewHolder(inflate, this.component, null);
                case 2131558617:
                    return new EmptyViewHolder(inflate);
                case 2131558674:
                    return new DocMarqueeCardViewHolder(inflate, this.component);
                case 2131558765:
                    return new GridCardViewHolder(inflate, this.component, EntityListFragment.this.getApkType(), new ItemActionHandler() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass4 */

                        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0122: APUT  (r6v5 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r2v17 java.lang.String) */
                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            if (viewHolder.getAdapterPosition() != -1) {
                                int dataIndex = EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition());
                                EntityCard entityCard = (EntityCard) EntityListFragment.this.getDataList().get(dataIndex);
                                if (view.getId() == 2131362970) {
                                    DataAdapter.this.onEntityCardClick(entityCard);
                                } else if (view.getId() == 2131362257) {
                                    DataManager.getInstance().getPreferencesEditor().putLong("HEADLINE_ADS_GRID_CLOSE_TIMESTAMP", System.currentTimeMillis()).putString("HEADLINE_ADS_CLOSE_URL", entityCard.getUrl()).apply();
                                    Toast.show(EntityListFragment.this.getActivity(), 2131887213);
                                    EntityListFragment.this.getDataList().remove(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()));
                                } else {
                                    int intValue = ((Integer) view.getTag()).intValue();
                                    if (entityCard.getUrl().startsWith("/apk")) {
                                        ServiceApp serviceApp = (ServiceApp) entityCard.getEntities().get(intValue);
                                        int id = view.getId();
                                        if (id == 2131361876) {
                                            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
                                            UpgradeInfo upgradeInfo = mobileAppExistFast != null ? mobileAppExistFast.getUpgradeInfo() : null;
                                            ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
                                            String[] strArr = new String[4];
                                            strArr[0] = serviceApp.getDownloadUrlMd5(0);
                                            strArr[1] = serviceApp.getDownloadUrlMd5(2);
                                            strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                                            strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
                                            StateUtils.handleClick(EntityListFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), null);
                                        } else if (id == 2131362768) {
                                            ActionManager.startAppViewActivity(EntityListFragment.this.getActivity(), view.findViewById(2131362672), serviceApp.getPackageName(), serviceApp.getLogo(), serviceApp.getAppName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi());
                                        }
                                    } else if (entityCard.getUrl().startsWith("/album")) {
                                        ImageView imageView = (ImageView) view.findViewById(2131362672);
                                        ActionManager.startV8AlbumDetailActivity(EntityListFragment.this.getActivity(), (Album) entityCard.getEntities().get(intValue));
                                    } else if (entityCard.getUrl().startsWith("/ads")) {
                                        Ads ads = (Ads) entityCard.getEntities().get(intValue);
                                        int id2 = view.getId();
                                        if (id2 == 2131361976) {
                                            EntityListFragment.this.onGridCardActionViewClick(viewHolder, view, dataIndex, intValue);
                                        } else if (id2 == 2131362768) {
                                            ActionManager.startActivityByUrl(EntityListFragment.this.getActivity(), ads.getUrl());
                                        }
                                    } else if (entityCard.getUrl().startsWith("/appForum")) {
                                        AppForum appForum = (AppForum) entityCard.getEntities().get(intValue);
                                        ActionManager.startAppForumActivity(EntityListFragment.this.getActivity(), (ImageView) view.findViewById(2131362672), appForum.packageName(), appForum.logo(), appForum.title(), null);
                                    }
                                }
                            }
                        }
                    });
                case 2131558787:
                    return new ImageCardViewHolder(inflate, this.component, null);
                case 2131558791:
                    return new ImageListCardViewHolder(inflate, this.component);
                case 2131558792:
                    return new ImageScrollCardViewHolder(inflate, this.component, new ItemActionHandler() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass10 */

                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            if (viewHolder.getAdapterPosition() != -1) {
                                EntityCard entityCard = (EntityCard) EntityListFragment.this.getDataList().get(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()));
                                if (view.getId() == 2131362970) {
                                    ActionManager.startActivityByLink(EntityListFragment.this.getActivity(), entityCard.getTitle(), entityCard.getUrl(), EntityListFragment.this.getApkType(), entityCard.getSubTitle());
                                }
                            }
                        }
                    });
                case 2131558800:
                    return new LinkCardViewHolder(inflate, new ItemActionHandler() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass9 */

                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            if (viewHolder.getAdapterPosition() != -1) {
                                Link link = ((LinkCard) EntityListFragment.this.getDataList().get(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()))).getEntities().get(((Integer) view.getTag()).intValue());
                                ActionManager.startActivityByLink(EntityListFragment.this.getActivity(), link.getTitle(), link.getUrl(), EntityListFragment.this.getApkType(), link.getSubTitle());
                            }
                        }
                    });
                case 2131558803:
                    return new ListCardViewHolder(inflate, this.component, new ItemActionHandler() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass7 */

                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            if (viewHolder.getAdapterPosition() != -1) {
                                EntityCard entityCard = (EntityCard) EntityListFragment.this.getDataList().get(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()));
                                if (view.getId() == 2131362257) {
                                    DataManager.getInstance().getPreferencesEditor().putLong("HEADLINE_ADS_LIST_CLOSE_TIMESTAMP", System.currentTimeMillis()).putString("HEADLINE_ADS_CLOSE_URL", entityCard.getUrl()).apply();
                                    Toast.show(EntityListFragment.this.getActivity(), 2131887213);
                                    EntityListFragment.this.getDataList().remove(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()));
                                } else if (view.getId() == 2131362970) {
                                    DataAdapter.this.onEntityCardClick(entityCard);
                                }
                            }
                        }
                    }, new ListCardViewHolder.ExternalDataAdapter() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass8 */

                        @Override // com.coolapk.market.viewholder.ListCardViewHolder.ExternalDataAdapter
                        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                            return DataAdapter.this.onCreateViewHolder(viewGroup, i);
                        }

                        @Override // com.coolapk.market.viewholder.ListCardViewHolder.ExternalDataAdapter
                        public int getItemViewType(String str) {
                            return EntityListFragment.this.entityType2ItemViewType(str);
                        }
                    });
                case 2131558825:
                    return new MessageCardViewHolder(inflate, new ItemActionHandler() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass1 */

                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            if (viewHolder.getAdapterPosition() != -1 && view.getId() == 2131362257) {
                                DataManager.getInstance().getPreferencesEditor().putString("HEADLINE_MESSAGE_CLOSE_URL", ((MessageCard) EntityListFragment.this.getDataList().get(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()))).getUrl()).apply();
                                EntityListFragment.this.getDataList().remove(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()));
                            }
                        }
                    });
                case 2131558924:
                    return new ServiceAppViewHolder(inflate, this.component, new ItemActionHandler() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass6 */

                        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00be: APUT  (r4v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r0v8 java.lang.String) */
                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            if (viewHolder.getAdapterPosition() != -1) {
                                viewHolder.getAdapterPosition();
                                Entity entity = EntityListFragment.this.getDataList().get(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()));
                                int id = view.getId();
                                if (id != 2131361886) {
                                    if (id == 2131362768 && EntityUtils.isApkType(entity.getEntityType())) {
                                        ServiceApp serviceApp = (ServiceApp) entity;
                                        ActionManager.startAppViewActivity(EntityListFragment.this.getActivity(), ((ServiceAppBinding) ((BindingViewHolder) viewHolder).getBinding()).iconView, serviceApp.getPackageName(), serviceApp.getLogo(), serviceApp.getAppName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi());
                                    }
                                } else if (EntityUtils.isApkType(entity.getEntityType())) {
                                    ServiceApp serviceApp2 = (ServiceApp) entity;
                                    MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp2.getPackageName());
                                    String str = null;
                                    UpgradeInfo upgradeInfo = mobileAppExistFast != null ? mobileAppExistFast.getUpgradeInfo() : null;
                                    ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp2).packageName(serviceApp2.getPackageName()).targetUrl(serviceApp2.getDownloadUrl(0));
                                    String[] strArr = new String[4];
                                    strArr[0] = serviceApp2.getDownloadUrlMd5(0);
                                    strArr[1] = serviceApp2.getDownloadUrlMd5(2);
                                    strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                                    if (upgradeInfo != null) {
                                        str = upgradeInfo.getDownloadUrlMd5(1);
                                    }
                                    strArr[3] = str;
                                    StateUtils.handleClick(EntityListFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), view);
                                }
                            }
                        }
                    });
                case 2131558942:
                    return new TabGroupCardViewHolder(inflate, this.component, EntityListFragment.this.tabGroupCardIndex, new ItemActionHandler() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass3 */

                        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0147: APUT  (r5v7 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r14v12 java.lang.String) */
                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            if (viewHolder.getAdapterPosition() != -1) {
                                GridCard gridCard = ((TabGroupCard) EntityListFragment.this.getDataList().get(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()))).getEntities().get(EntityListFragment.this.tabGroupCardIndex.get());
                                switch (view.getId()) {
                                    case 2131362970:
                                        ActionManager.startActivityByLink(EntityListFragment.this.getActivity(), gridCard.getTitle(), gridCard.getUrl(), EntityListFragment.this.getApkType(), gridCard.getSubTitle());
                                        return;
                                    case 2131363483:
                                        EntityListFragment.this.tabGroupCardIndex.set(0);
                                        DataAdapter.this.notifyItemChanged(viewHolder.getAdapterPosition());
                                        return;
                                    case 2131363484:
                                        EntityListFragment.this.tabGroupCardIndex.set(1);
                                        DataAdapter.this.notifyItemChanged(viewHolder.getAdapterPosition());
                                        return;
                                    default:
                                        ServiceApp serviceApp = gridCard.getEntities().get(((Integer) view.getTag()).intValue());
                                        int id = view.getId();
                                        if (id == 2131361876) {
                                            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
                                            UpgradeInfo upgradeInfo = mobileAppExistFast != null ? mobileAppExistFast.getUpgradeInfo() : null;
                                            ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
                                            String[] strArr = new String[4];
                                            strArr[0] = serviceApp.getDownloadUrlMd5(0);
                                            strArr[1] = serviceApp.getDownloadUrlMd5(2);
                                            strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                                            strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
                                            StateUtils.handleClick(EntityListFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), null);
                                            return;
                                        } else if (id == 2131362768) {
                                            ActionManager.startAppViewActivity(EntityListFragment.this.getActivity(), view.findViewById(2131362672), serviceApp.getPackageName(), serviceApp.getLogo(), serviceApp.getAppName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi());
                                            ActionManager.startActivityByLink(EntityListFragment.this.getActivity(), gridCard.getTitle(), gridCard.getUrl(), EntityListFragment.this.getApkType(), gridCard.getSubTitle());
                                            return;
                                        } else {
                                            return;
                                        }
                                }
                            }
                        }
                    });
                case 2131558949:
                    return new TextImageCardViewHolder(inflate, this.component, null);
                case 2131558955:
                    return new TitleCardViewHolder(inflate, this.component);
                case 2131558959:
                    return new TopGroupCardViewHolder(inflate, this.component, new ItemActionHandler() {
                        /* class com.coolapk.market.view.main.EntityListFragment.DataAdapter.AnonymousClass2 */

                        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0184: APUT  (r5v3 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r10v13 java.lang.String) */
                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            if (viewHolder.getAdapterPosition() != -1) {
                                Entity entity = EntityListFragment.this.getDataList().get(EntityListFragment.this.getDataIndex(viewHolder.getAdapterPosition()));
                                int id = view.getId();
                                if (id == 2131361876) {
                                    ServiceApp serviceApp = ((TopGroupCard) entity).getEntities().get(2).getEntities().get(((Integer) view.getTag()).intValue());
                                    MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
                                    UpgradeInfo upgradeInfo = mobileAppExistFast != null ? mobileAppExistFast.getUpgradeInfo() : null;
                                    ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
                                    String[] strArr = new String[4];
                                    strArr[0] = serviceApp.getDownloadUrlMd5(0);
                                    strArr[1] = serviceApp.getDownloadUrlMd5(2);
                                    strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                                    strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
                                    StateUtils.handleClick(EntityListFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), null);
                                } else if (id != 2131362768) {
                                    switch (id) {
                                        case 2131362781:
                                            ActionManager.startActivityByUrl(EntityListFragment.this.getActivity(), ((TopGroupCard) entity).getEntities().get(0).getSubUrl());
                                            return;
                                        case 2131362782:
                                            ActionManager.startActivityByUrl(EntityListFragment.this.getActivity(), ((TopGroupCard) entity).getEntities().get(1).getSubUrl());
                                            return;
                                        case 2131362783:
                                            TopCard topCard = ((TopGroupCard) entity).getEntities().get(0);
                                            ActionManager.startActivityByLink(EntityListFragment.this.getActivity(), topCard.getTitle(), topCard.getUrl(), EntityListFragment.this.getApkType(), topCard.getSubTitle());
                                            return;
                                        case 2131362784:
                                            TopCard topCard2 = ((TopGroupCard) entity).getEntities().get(1);
                                            ActionManager.startActivityByLink(EntityListFragment.this.getActivity(), topCard2.getTitle(), topCard2.getUrl(), EntityListFragment.this.getApkType(), topCard2.getSubTitle());
                                            return;
                                        default:
                                            return;
                                    }
                                } else {
                                    ServiceApp serviceApp2 = ((TopGroupCard) entity).getEntities().get(2).getEntities().get(((Integer) view.getTag()).intValue());
                                    ActionManager.startAppViewActivity(EntityListFragment.this.getActivity(), view.findViewById(2131362672), serviceApp2.getPackageName(), serviceApp2.getLogo(), serviceApp2.getAppName(), serviceApp2.getExtraAnalysisData(), serviceApp2.getRequestContext(), serviceApp2.getExtraFromApi());
                                }
                            }
                        }
                    });
                default:
                    throw new IllegalStateException("Unknown view type " + i);
            }
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(EntityListFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return EntityListFragment.this.getDataList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return EntityListFragment.this.entityType2ItemViewType(EntityListFragment.this.getDataList().get(i).getEntityType());
        }

        /* access modifiers changed from: private */
        public void onEntityCardClick(EntityCard entityCard) {
            ActionManagerCompat.startActivityByUrl(EntityListFragment.this.getActivity(), entityCard.getUrl(), entityCard.getTitle(), entityCard.getSubTitle());
        }
    }
}
