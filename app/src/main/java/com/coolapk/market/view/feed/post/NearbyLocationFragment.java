package com.coolapk.market.view.feed.post;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemLocationBinding;
import com.coolapk.market.databinding.PoiListBinding;
import com.coolapk.market.model.LocationInfo;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.OnLoadMoreListener;
import com.coolapk.market.view.feed.post.NearbyLocationFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class NearbyLocationFragment extends BaseFragment implements AMapLocationListener, PoiSearch.OnPoiSearchListener {
    public static final int CODE_LOCATION = 888;
    public static final String KEY_BIND_TYPE = "KEY_BIND_TYPE";
    private static final String KEY_DATA = "DATA";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_LOCATION_INFO = "locationInfo";
    private static final String KEY_PAGE = "PAGE";
    private String bindType;
    private PoiListBinding binding;
    private String city;
    private String country;
    private final ObservableArrayList<LocationInfo> dataList = new ObservableArrayList<>();
    private boolean isLoadingPoi = false;
    private LocationInfo lastLocationInfo;
    private double latitude;
    private String longAddress;
    private double longitude;
    private AMapLocationClient myLocationClient;
    private int myLocationIndex = -1;
    private boolean noMorePage = false;
    private AtomicInteger pageCounter = new AtomicInteger(1);
    private String province;
    private PoiSearch.Query query;
    private PoiSearch search;

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiItemSearched(PoiItem poiItem, int i) {
    }

    public static NearbyLocationFragment newInstance(LocationInfo locationInfo) {
        Bundle bundle = new Bundle();
        NearbyLocationFragment nearbyLocationFragment = new NearbyLocationFragment();
        bundle.putParcelable("locationInfo", locationInfo);
        nearbyLocationFragment.setArguments(bundle);
        return nearbyLocationFragment;
    }

    public static NearbyLocationFragment newInstance(LocationInfo locationInfo, String str) {
        Bundle bundle = new Bundle();
        NearbyLocationFragment nearbyLocationFragment = new NearbyLocationFragment();
        bundle.putParcelable("locationInfo", locationInfo);
        bundle.putString("KEY_BIND_TYPE", str);
        nearbyLocationFragment.setArguments(bundle);
        return nearbyLocationFragment;
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lastLocationInfo = (LocationInfo) getArguments().getParcelable("locationInfo");
        this.bindType = getArguments().getString("KEY_BIND_TYPE", "");
        initLocate();
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
            this.pageCounter = new AtomicInteger(bundle.getInt("PAGE", 0));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        PoiListBinding poiListBinding = (PoiListBinding) DataBindingUtil.inflate(layoutInflater, 2131559088, viewGroup, false);
        this.binding = poiListBinding;
        poiListBinding.recyclerView.getItemAnimator().setChangeDuration(0);
        return this.binding.getRoot();
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
        bundle.putInt("PAGE", this.pageCounter.get());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.binding.recyclerView.addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558813, 2131231052).last(2131231052).create());
        this.binding.recyclerView.getItemAnimator().setChangeDuration(0);
        this.binding.recyclerView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        this.binding.recyclerView.setClipToPadding(false);
        this.binding.recyclerView.addOnScrollListener(new OnLoadMoreListener() {
            /* class com.coolapk.market.view.feed.post.NearbyLocationFragment.AnonymousClass1 */

            @Override // com.coolapk.market.view.base.OnLoadMoreListener
            protected void onLoadMore(int i) {
                if (!NearbyLocationFragment.this.isLoadingPoi && !NearbyLocationFragment.this.noMorePage) {
                    NearbyLocationFragment nearbyLocationFragment = NearbyLocationFragment.this;
                    nearbyLocationFragment.startPoiSearch(nearbyLocationFragment.pageCounter.get());
                }
            }
        });
        DataAdapter dataAdapter = new DataAdapter();
        this.binding.recyclerView.setAdapter(dataAdapter);
        this.dataList.addOnListChangedCallback(new AdapterListChangedCallback(dataAdapter));
    }

    private void initLocate() {
        AMapLocationClient aMapLocationClient = new AMapLocationClient(AppHolder.getApplication().getApplicationContext());
        this.myLocationClient = aMapLocationClient;
        aMapLocationClient.setLocationListener(this);
        this.myLocationClient.setLocationOption(getOption());
        this.myLocationClient.startLocation();
    }

    private AMapLocationClientOption getOption() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setHttpTimeOut(30000);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setLocationCacheEnable(true);
        aMapLocationClientOption.setOnceLocation(false);
        return aMapLocationClientOption;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AMapLocationClient aMapLocationClient = this.myLocationClient;
        if (aMapLocationClient != null) {
            aMapLocationClient.onDestroy();
            this.myLocationClient = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AMapLocationClient aMapLocationClient = this.myLocationClient;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
    }

    /* access modifiers changed from: private */
    public void startPoiSearch(int i) {
        this.query.setPageNum(i);
        this.search.searchPOIAsyn();
        this.isLoadingPoi = true;
    }

    private void initPoiSearch(int i) {
        PoiSearch.Query query2 = new PoiSearch.Query("", "商务住宅|风景名胜|餐饮服务|购物服务|生活服务|住宿服务|道路附属设施|地址地名信息", "");
        this.query = query2;
        query2.setPageSize(20);
        this.query.setPageNum(i);
        PoiSearch poiSearch = new PoiSearch(getActivity(), this.query);
        this.search = poiSearch;
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(this.latitude, this.longitude), 3000, false));
        this.search.setOnPoiSearchListener(this);
    }

    @Override // com.amap.api.location.AMapLocationListener
    public void onLocationChanged(AMapLocation aMapLocation) {
        LocationInfo locationInfo;
        this.noMorePage = false;
        this.myLocationClient.stopLocation();
        if (aMapLocation == null) {
            return;
        }
        if (aMapLocation.getErrorCode() == 0) {
            this.binding.emptyTextView.setVisibility(8);
            aMapLocation.getLocationType();
            this.latitude = aMapLocation.getLatitude();
            this.longitude = aMapLocation.getLongitude();
            this.longAddress = aMapLocation.getAddress();
            aMapLocation.getCountry();
            aMapLocation.getCity();
            aMapLocation.getDistrict();
            aMapLocation.getAccuracy();
            this.city = aMapLocation.getCity();
            this.country = aMapLocation.getCountry();
            this.province = aMapLocation.getProvince();
            boolean z = true;
            if (!TextUtils.equals("ershou", this.bindType)) {
                LocationInfo.Builder country2 = LocationInfo.newBuilder().setAddress(getString(2131886880)).setSnippet("").setLongAddress("").setLatitude(Double.valueOf(0.0d)).setLongitude(Double.valueOf(0.0d)).setBusinessArea("").setCityCode("").setProvince("").setCity("").setCountry("");
                LocationInfo locationInfo2 = this.lastLocationInfo;
                this.dataList.add(country2.setIsChecked(locationInfo2 == null || locationInfo2.getIsHideLocation()).setIsHideLocation(true).setEntityType("location").build());
            }
            LocationInfo locationInfo3 = this.lastLocationInfo;
            if (locationInfo3 == null || !TextUtils.equals(locationInfo3.getAddress(), aMapLocation.getCity())) {
                this.dataList.add(LocationInfo.newBuilder().setAddress(aMapLocation.getCity()).setSnippet("").setLongAddress(this.longAddress).setLatitude(Double.valueOf(this.latitude)).setLongitude(Double.valueOf(this.longitude)).setBusinessArea("").setCityCode(aMapLocation.getCityCode()).setProvince(aMapLocation.getProvince()).setCity(aMapLocation.getCity()).setCountry(aMapLocation.getCountry()).setEntityType("location").setIsHideLocation(false).setIsChecked(false).build());
            }
            LocationInfo locationInfo4 = this.lastLocationInfo;
            if (locationInfo4 == null || !TextUtils.equals(locationInfo4.getAddress(), aMapLocation.getAoiName())) {
                z = false;
            }
            if (!z && (locationInfo = this.lastLocationInfo) != null && !locationInfo.getIsHideLocation()) {
                this.dataList.add(this.lastLocationInfo);
            }
            LocationInfo build = LocationInfo.newBuilder().setAddress(aMapLocation.getAoiName()).setSnippet(this.longAddress).setLongAddress(this.longAddress).setLatitude(Double.valueOf(this.latitude)).setLongitude(Double.valueOf(this.longitude)).setCityCode(aMapLocation.getCityCode()).setProvince(aMapLocation.getProvince()).setBusinessArea("").setCity(aMapLocation.getCity()).setCountry(aMapLocation.getCountry()).setEntityType("location").setIsHideLocation(false).setIsChecked(z).build();
            this.dataList.add(build);
            this.myLocationIndex = this.dataList.indexOf(build);
            initPoiSearch(this.pageCounter.get());
            startPoiSearch(this.pageCounter.get());
            return;
        }
        this.binding.progressBar.setVisibility(8);
        this.binding.emptyTextView.setVisibility(0);
        this.binding.emptyTextView.setText("定位失败，无法加载数据\n请检查定位权限或网络设置");
    }

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiSearched(PoiResult poiResult, int i) {
        this.isLoadingPoi = false;
        this.binding.progressBar.setVisibility(8);
        if (i != 1000) {
            return;
        }
        if (CollectionUtils.isEmpty(poiResult.getPois())) {
            this.noMorePage = true;
            return;
        }
        Iterator<PoiItem> it2 = poiResult.getPois().iterator();
        while (it2.hasNext()) {
            PoiItem next = it2.next();
            LocationInfo locationInfo = this.lastLocationInfo;
            if (locationInfo == null || !TextUtils.equals(locationInfo.getAddress(), next.getTitle())) {
                this.dataList.add(LocationInfo.newBuilder().setAddress(next.getTitle()).setBusinessArea(next.getBusinessArea()).setLongAddress(this.longAddress).setSnippet(next.getSnippet()).setLatitude(Double.valueOf(this.latitude)).setLongitude(Double.valueOf(this.longitude)).setCity(this.city).setCityCode(next.getCityCode()).setProvince(this.province).setCountry(this.country).setIsHideLocation(false).setEntityType("location").setIsChecked(false).build());
            }
        }
        this.pageCounter.incrementAndGet();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558813;
        }

        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (i == 2131558813) {
                return new LocationViewHolder(inflate, null, null);
            }
            throw new IllegalStateException("Unknown view type " + i);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(NearbyLocationFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return NearbyLocationFragment.this.dataList.size();
        }
    }

    private class LocationViewHolder extends GenericBindHolder<ItemLocationBinding, LocationInfo> {
        public static final int LAYOUT_ID = 2131558813;
        private final ItemLocationBinding binding = ((ItemLocationBinding) getBinding());

        public LocationViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(LocationInfo locationInfo) {
            if (getAdapterPosition() == NearbyLocationFragment.this.myLocationIndex) {
                TextView textView = this.binding.titleView;
                textView.setText(locationInfo.getAddress() + "(" + NearbyLocationFragment.this.getString(2131886881) + ")");
            } else {
                this.binding.titleView.setText(locationInfo.getAddress());
            }
            this.binding.contentView.setText(locationInfo.getSnippet());
            int i = 0;
            this.binding.imageView.setVisibility(locationInfo.getIsChecked() ? 0 : 8);
            TextView textView2 = this.binding.contentView;
            if (TextUtils.isEmpty(locationInfo.getSnippet())) {
                i = 8;
            }
            textView2.setVisibility(i);
            this.binding.executePendingBindings();
            ViewUtil.clickListener(this.binding.itemView, new View.OnClickListener(locationInfo) {
                /* class com.coolapk.market.view.feed.post.$$Lambda$NearbyLocationFragment$LocationViewHolder$2GupN95SmyRUgHjg7j7Bjnf7eUg */
                public final /* synthetic */ LocationInfo f$1;

                {
                    this.f$1 = r2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbyLocationFragment.LocationViewHolder.this.lambda$bindToContent$0$NearbyLocationFragment$LocationViewHolder(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$bindToContent$0$NearbyLocationFragment$LocationViewHolder(LocationInfo locationInfo, View view) {
            LocationInfo build = LocationInfo.newBuilder(locationInfo).setIsChecked(true).build();
            FragmentActivity requireActivity = NearbyLocationFragment.this.requireActivity();
            requireActivity.setResult(-1, new Intent().putExtra("KEY_LOCATION", build));
            requireActivity.finish();
        }
    }
}
