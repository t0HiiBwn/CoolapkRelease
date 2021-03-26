package com.coolapk.market.viewholder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemSceneRelatedBinding;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.CouponInfo;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.main.SceneRelatedAppsHelper;
import com.coolapk.market.view.main.SceneRelatedAppsViewPart;
import com.coolapk.market.view.main.SceneRelatedAppsViewPartHotPlug;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.ActionButton;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/coolapk/market/viewholder/ServiceAppViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "Lcom/coolapk/market/design/CoolapkCardView$CardStyleCallback;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ServiceAppBinding;", "kotlin.jvm.PlatformType", "onCardChangedCallback", "Lkotlin/Function2;", "", "Lcom/coolapk/market/model/Entity;", "", "sceneRelatedAppsViewPartHotPlug", "Lcom/coolapk/market/view/main/SceneRelatedAppsViewPartHotPlug;", "sceneRelatedHelper", "Lcom/coolapk/market/view/main/SceneRelatedAppsHelper;", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "bindTo", "data", "", "onCardStyleDetermined", "cardStyle", "", "onClick", "view", "onRecycled", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "updateRelatedApps", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ServiceAppViewHolder.kt */
public class ServiceAppViewHolder extends StateViewHolder implements CoolapkCardView.CardStyleCallback, Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558931;
    private final ServiceAppBinding binding;
    private final Function2<String, Entity, Unit> onCardChangedCallback;
    private final SceneRelatedAppsViewPartHotPlug sceneRelatedAppsViewPartHotPlug;
    private final SceneRelatedAppsHelper sceneRelatedHelper;
    private ServiceApp serviceApp;

    public static final /* synthetic */ ServiceApp access$getServiceApp$p(ServiceAppViewHolder serviceAppViewHolder) {
        ServiceApp serviceApp2 = serviceAppViewHolder.serviceApp;
        if (serviceApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        return serviceApp2;
    }

    public ServiceAppViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ServiceAppBinding serviceAppBinding = (ServiceAppBinding) getBinding();
        this.binding = serviceAppBinding;
        DataBindingComponent component = getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "getComponent()");
        EntityListFragment entityListFragment = KotlinExtendKt.getEntityListFragment(component);
        SceneRelatedAppsHelper sceneRelatedHelper2 = entityListFragment != null ? entityListFragment.getSceneRelatedHelper() : null;
        this.sceneRelatedHelper = sceneRelatedHelper2;
        DataBindingComponent component2 = getComponent();
        Intrinsics.checkNotNullExpressionValue(component2, "getComponent()");
        this.sceneRelatedAppsViewPartHotPlug = new SceneRelatedAppsViewPartHotPlug(this, sceneRelatedHelper2, component2);
        ServiceAppViewHolder serviceAppViewHolder = this;
        ViewUtil.clickListener(serviceAppBinding.itemView, serviceAppViewHolder);
        serviceAppBinding.itemView.setOnLongClickListener(this);
        ViewUtil.directClickListener(serviceAppBinding.actionContainer, serviceAppViewHolder);
        ViewUtil.directClickListener(serviceAppBinding.couponView, serviceAppViewHolder);
        this.onCardChangedCallback = new ServiceAppViewHolder$onCardChangedCallback$1(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ServiceAppViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ServiceAppViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00e4: APUT  
      (r6v0 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x00e0: INVOKE  (r7v1 java.lang.String) = (r7v0 com.coolapk.market.model.ServiceApp) type: VIRTUAL call: com.coolapk.market.model.ServiceApp.getScore():java.lang.String)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x012c: APUT  
      (r5v5 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x0128: INVOKE  (r7v6 java.lang.String) = (r7v5 com.coolapk.market.model.ServiceApp) type: VIRTUAL call: com.coolapk.market.model.ServiceApp.getDownCount():java.lang.String)
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0280, code lost:
        if (r12.getDigest() == 1) goto L_0x0282;
     */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        Intrinsics.checkNotNullParameter(obj, "data");
        if (EntityUtils.isApkType(((Entity) obj).getEntityType())) {
            this.serviceApp = (ServiceApp) obj;
            LinearLayout linearLayout = this.binding.itemView;
            ServiceApp serviceApp2 = this.serviceApp;
            if (serviceApp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            linearLayout.setTag(2131362764, serviceApp2);
            ActionButton actionButton = this.binding.actionContainer;
            ServiceApp serviceApp3 = this.serviceApp;
            if (serviceApp3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            actionButton.setTag(2131362764, serviceApp3);
            ServiceAppBinding serviceAppBinding = this.binding;
            Intrinsics.checkNotNullExpressionValue(serviceAppBinding, "binding");
            ServiceApp serviceApp4 = this.serviceApp;
            if (serviceApp4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            serviceAppBinding.setApp(serviceApp4);
            this.binding.executePendingBindings();
            ActionButton actionButton2 = this.binding.actionContainer;
            ServiceApp serviceApp5 = this.serviceApp;
            if (serviceApp5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            actionButton2.bindWithApp(serviceApp5, false);
            ServiceApp serviceApp6 = this.serviceApp;
            if (serviceApp6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            if (serviceApp6.getHasCoupon()) {
                DataManager instance = DataManager.getInstance();
                ServiceApp serviceApp7 = this.serviceApp;
                if (serviceApp7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                MobileApp mobileAppExistFast = instance.getMobileAppExistFast(serviceApp7.getPackageName());
                ServiceApp serviceApp8 = this.serviceApp;
                if (serviceApp8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                List<CouponInfo> couponInfo = serviceApp8.getCouponInfo();
                Intrinsics.checkNotNull(couponInfo);
                CouponInfo couponInfo2 = couponInfo.get(0);
                TextView textView = this.binding.couponTitleView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.couponTitleView");
                Intrinsics.checkNotNullExpressionValue(couponInfo2, "couponInfo");
                textView.setText(couponInfo2.getTitle());
                TextView textView2 = this.binding.fetchCouponView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.fetchCouponView");
                textView2.setText(mobileAppExistFast == null ? "下载领取" : couponInfo2.getIsClicked() ? "已领取" : "打开领取");
            }
            TextView textView3 = this.binding.apkInfoView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.apkInfoView");
            Context context = getContext();
            Object[] objArr = new Object[2];
            ServiceApp serviceApp9 = this.serviceApp;
            if (serviceApp9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            objArr[0] = serviceApp9.getScore();
            ServiceApp serviceApp10 = this.serviceApp;
            if (serviceApp10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            boolean z = true;
            objArr[1] = serviceApp10.getApkSizeFormat();
            textView3.setText(context.getString(2131886910, objArr));
            TextView textView4 = this.binding.marketInfoView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.marketInfoView");
            ServiceApp serviceApp11 = this.serviceApp;
            if (serviceApp11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            String optSubTitle = EntityExtendsKt.optSubTitle(serviceApp11);
            if (optSubTitle != null) {
                str = optSubTitle;
            } else {
                Context context2 = getContext();
                Object[] objArr2 = new Object[2];
                ServiceApp serviceApp12 = this.serviceApp;
                if (serviceApp12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                objArr2[0] = serviceApp12.getDownCount();
                ServiceApp serviceApp13 = this.serviceApp;
                if (serviceApp13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                objArr2[1] = serviceApp13.getCommentCount();
                str = context2.getString(2131886912, objArr2);
            }
            textView4.setText(str);
            TextView textView5 = this.binding.apkSubtitleView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.apkSubtitleView");
            ServiceApp serviceApp14 = this.serviceApp;
            if (serviceApp14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            textView5.setText(serviceApp14.getApkSubTitle());
            ServiceApp serviceApp15 = this.serviceApp;
            if (serviceApp15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            if (serviceApp15.getUpdateFlag() != null) {
                ServiceApp serviceApp16 = this.serviceApp;
                if (serviceApp16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                String updateFlag = serviceApp16.getUpdateFlag();
                if (updateFlag != null) {
                    int hashCode = updateFlag.hashCode();
                    if (hashCode != -1754979095) {
                        if (hashCode != 72749) {
                            if (hashCode == 78208 && updateFlag.equals("New")) {
                                TextView textView6 = this.binding.newTagView;
                                Intrinsics.checkNotNullExpressionValue(textView6, "binding.newTagView");
                                textView6.setVisibility(0);
                                TextView textView7 = this.binding.newTagView;
                                Intrinsics.checkNotNullExpressionValue(textView7, "binding.newTagView");
                                textView7.setText("New");
                                TextView textView8 = this.binding.introductionView;
                                Intrinsics.checkNotNullExpressionValue(textView8, "binding.introductionView");
                                ServiceApp serviceApp17 = this.serviceApp;
                                if (serviceApp17 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                                }
                                textView8.setVisibility(TextUtils.isEmpty(serviceApp17.getDescription()) ? 8 : 0);
                                TextView textView9 = this.binding.introductionView;
                                ServiceApp serviceApp18 = this.serviceApp;
                                if (serviceApp18 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                                }
                                TextViewBindingAdapters.setTextViewLinkable(textView9, serviceApp18.getDescription());
                            }
                        } else if (updateFlag.equals("Hot")) {
                            TextView textView10 = this.binding.newTagView;
                            Intrinsics.checkNotNullExpressionValue(textView10, "binding.newTagView");
                            textView10.setVisibility(0);
                            TextView textView11 = this.binding.newTagView;
                            Intrinsics.checkNotNullExpressionValue(textView11, "binding.newTagView");
                            textView11.setText("Hot");
                            TextView textView12 = this.binding.introductionView;
                            Intrinsics.checkNotNullExpressionValue(textView12, "binding.introductionView");
                            textView12.setVisibility(8);
                        }
                    } else if (updateFlag.equals("Update")) {
                        TextView textView13 = this.binding.newTagView;
                        Intrinsics.checkNotNullExpressionValue(textView13, "binding.newTagView");
                        textView13.setVisibility(8);
                        TextView textView14 = this.binding.introductionView;
                        Intrinsics.checkNotNullExpressionValue(textView14, "binding.introductionView");
                        textView14.setVisibility(8);
                    }
                }
                TextView textView15 = this.binding.newTagView;
                Intrinsics.checkNotNullExpressionValue(textView15, "binding.newTagView");
                textView15.setVisibility(8);
                TextView textView16 = this.binding.introductionView;
                Intrinsics.checkNotNullExpressionValue(textView16, "binding.introductionView");
                textView16.setVisibility(8);
            } else {
                TextView textView17 = this.binding.newTagView;
                Intrinsics.checkNotNullExpressionValue(textView17, "binding.newTagView");
                textView17.setVisibility(8);
                TextView textView18 = this.binding.introductionView;
                Intrinsics.checkNotNullExpressionValue(textView18, "binding.introductionView");
                textView18.setVisibility(8);
            }
            ServiceApp serviceApp19 = this.serviceApp;
            if (serviceApp19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            if (!TextUtils.isEmpty(serviceApp19.getDescription())) {
                ServiceApp serviceApp20 = this.serviceApp;
                if (serviceApp20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                if (serviceApp20.getRecommend() != 1) {
                    ServiceApp serviceApp21 = this.serviceApp;
                    if (serviceApp21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                    }
                }
                TextView textView19 = this.binding.introductionView;
                Intrinsics.checkNotNullExpressionValue(textView19, "binding.introductionView");
                textView19.setVisibility(0);
                TextView textView20 = this.binding.introductionView;
                ServiceApp serviceApp22 = this.serviceApp;
                if (serviceApp22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                TextViewBindingAdapters.setTextViewLinkable(textView20, serviceApp22.getDescription());
            }
            ServiceApp serviceApp23 = this.serviceApp;
            if (serviceApp23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            if (!TextUtils.isEmpty(serviceApp23.getApkSubTitle())) {
                TextView textView21 = this.binding.marketInfoView;
                Intrinsics.checkNotNullExpressionValue(textView21, "binding.marketInfoView");
                textView21.setVisibility(8);
                TextView textView22 = this.binding.apkSubtitleView;
                Intrinsics.checkNotNullExpressionValue(textView22, "binding.apkSubtitleView");
                textView22.setVisibility(0);
            } else {
                TextView textView23 = this.binding.marketInfoView;
                Intrinsics.checkNotNullExpressionValue(textView23, "binding.marketInfoView");
                textView23.setVisibility(0);
                TextView textView24 = this.binding.apkSubtitleView;
                Intrinsics.checkNotNullExpressionValue(textView24, "binding.apkSubtitleView");
                textView24.setVisibility(8);
            }
            TextView textView25 = this.binding.apkInfoView;
            Intrinsics.checkNotNullExpressionValue(textView25, "binding.apkInfoView");
            textView25.setVisibility(8);
            LinearLayout linearLayout2 = this.binding.rankView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.rankView");
            linearLayout2.setVisibility(8);
            TextView textView26 = this.binding.introductionView;
            Intrinsics.checkNotNullExpressionValue(textView26, "binding.introductionView");
            ViewGroup.LayoutParams layoutParams = textView26.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = NumberExtendsKt.getDp((Number) 68);
            ServiceApp serviceApp24 = this.serviceApp;
            if (serviceApp24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            if (EntityExtendsKt.getIntExtraData(serviceApp24, "showSerialNumber", 0) != 1) {
                z = false;
            }
            if (z && (getComponent() instanceof FragmentBindingComponent)) {
                DataBindingComponent component = getComponent();
                Objects.requireNonNull(component, "null cannot be cast to non-null type com.coolapk.market.binding.FragmentBindingComponent");
                Fragment fragment = (Fragment) ((FragmentBindingComponent) component).getContainer();
                if (fragment instanceof EntityListFragment) {
                    int rankAwardCardIndex = ((EntityListFragment) fragment).getConfigHelper().getRankAwardCardIndex();
                    LinearLayout linearLayout3 = this.binding.rankView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.rankView");
                    linearLayout3.setVisibility(0);
                    int adapterPosition = getAdapterPosition();
                    if (rankAwardCardIndex != -1 && adapterPosition > rankAwardCardIndex) {
                        adapterPosition = (adapterPosition + 3) - rankAwardCardIndex;
                    }
                    TextView textView27 = this.binding.rankTextView;
                    Intrinsics.checkNotNullExpressionValue(textView27, "binding.rankTextView");
                    textView27.setText(String.valueOf(adapterPosition));
                    TextView textView28 = this.binding.rankTextView;
                    Intrinsics.checkNotNullExpressionValue(textView28, "binding.rankTextView");
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    textView28.setTypeface(ProductGlobalData.getNumberTypeface(context3));
                    marginLayoutParams.leftMargin = ConvertUtils.dp2px(97.0f);
                }
            }
            SceneRelatedAppsViewPartHotPlug sceneRelatedAppsViewPartHotPlug2 = this.sceneRelatedAppsViewPartHotPlug;
            ServiceApp serviceApp25 = this.serviceApp;
            if (serviceApp25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            sceneRelatedAppsViewPartHotPlug2.bindTo(serviceApp25);
            return;
        }
        throw new RuntimeException("Binding error! data should be apkType card");
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void onViewAttachedToWindow() {
        SceneRelatedAppsHelper sceneRelatedAppsHelper = this.sceneRelatedHelper;
        if (sceneRelatedAppsHelper != null) {
            sceneRelatedAppsHelper.addOnCardChangedCallback(this.onCardChangedCallback);
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void onViewDetachedFromWindow() {
        SceneRelatedAppsHelper sceneRelatedAppsHelper = this.sceneRelatedHelper;
        if (sceneRelatedAppsHelper != null) {
            sceneRelatedAppsHelper.removeOnCardChangedCallback(this.onCardChangedCallback);
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.sceneRelatedAppsViewPartHotPlug.onRecycled();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        SceneRelatedAppsHelper sceneRelatedHelper2;
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == 2131361887) {
            ActionButton actionButton = this.binding.actionContainer;
            Intrinsics.checkNotNullExpressionValue(actionButton, "binding.actionContainer");
            if (Intrinsics.areEqual(actionButton.getText(), getContext().getString(2131886128))) {
                DataBindingComponent component = getComponent();
                Intrinsics.checkNotNullExpressionValue(component, "component");
                EntityListFragment entityListFragment = KotlinExtendKt.getEntityListFragment(component);
                if (!(entityListFragment == null || (sceneRelatedHelper2 = entityListFragment.getSceneRelatedHelper()) == null)) {
                    ServiceApp serviceApp2 = this.serviceApp;
                    if (serviceApp2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                    }
                    sceneRelatedHelper2.loadCard(serviceApp2);
                }
            }
            super.onClick(view);
        } else if (id != 2131362342) {
            super.onClick(view);
        } else {
            DataManager instance = DataManager.getInstance();
            ServiceApp serviceApp3 = this.serviceApp;
            if (serviceApp3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            if (instance.getMobileAppExistFast(serviceApp3.getPackageName()) == null) {
                getItemActionHandler().onItemClick(this, this.binding.actionContainer);
                return;
            }
            Context context = getContext();
            ServiceApp serviceApp4 = this.serviceApp;
            if (serviceApp4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            String extraAnalysisData = serviceApp4.getExtraAnalysisData();
            ServiceApp serviceApp5 = this.serviceApp;
            if (serviceApp5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            ActionManager.reportCoupon(context, extraAnalysisData, 0, serviceApp5.getApkId());
            ServiceApp serviceApp6 = this.serviceApp;
            if (serviceApp6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            List<CouponInfo> couponInfo = serviceApp6.getCouponInfo();
            Intrinsics.checkNotNull(couponInfo);
            CouponInfo couponInfo2 = couponInfo.get(0);
            Intrinsics.checkNotNullExpressionValue(couponInfo2, "couponInfo");
            if (couponInfo2.getCouponType() == 1) {
                String adH5url = couponInfo2.getAdH5url();
                if (!TextUtils.isEmpty(adH5url)) {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    ActionManagerCompat.startActivityByUrl(context2, adH5url, null, null);
                }
            } else {
                String adApplink = couponInfo2.getAdApplink();
                if (!TextUtils.isEmpty(adApplink)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(adApplink));
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    ComponentName resolveActivity = intent.resolveActivity(context3.getPackageManager());
                    if (resolveActivity != null) {
                        intent.setComponent(resolveActivity);
                        getContext().startActivity(intent);
                    }
                }
            }
            if (!couponInfo2.getIsClicked()) {
                TextView textView = this.binding.fetchCouponView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.fetchCouponView");
                textView.setText("已领取");
            }
        }
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ServiceApp serviceApp2 = this.serviceApp;
        if (serviceApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        return StateViewHolder.isEventBelongTo(event, serviceApp2);
    }

    public final int updateRelatedApps(Event event) {
        int adapterPosition;
        ItemSceneRelatedBinding itemSceneRelatedBinding;
        Intrinsics.checkNotNullParameter(event, "event");
        SceneRelatedAppsViewPart sceneRelatedAppsViewPart = (SceneRelatedAppsViewPart) this.sceneRelatedAppsViewPartHotPlug.optViewPart();
        RecyclerView recyclerView = (sceneRelatedAppsViewPart == null || (itemSceneRelatedBinding = (ItemSceneRelatedBinding) sceneRelatedAppsViewPart.getBinding()) == null) ? null : itemSceneRelatedBinding.recyclerView;
        if (recyclerView != null) {
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
                if ((childViewHolder instanceof RVStateEventChangedAdapter.IStateViewHolder) && ((RVStateEventChangedAdapter.IStateViewHolder) childViewHolder).onStateEventChanged(event) && (adapterPosition = childViewHolder.getAdapterPosition()) != -1) {
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    Intrinsics.checkNotNull(adapter);
                    adapter.notifyItemChanged(adapterPosition);
                    return adapterPosition;
                }
            }
        }
        return -1;
    }

    @Override // com.coolapk.market.design.CoolapkCardView.CardStyleCallback
    public void onCardStyleDetermined(int i) {
        if (i == 4) {
            LinearLayout linearLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            LinearLayout linearLayout2 = linearLayout;
            linearLayout2.setPadding(linearLayout2.getPaddingLeft(), NumberExtendsKt.getDp((Number) 16), linearLayout2.getPaddingRight(), NumberExtendsKt.getDp((Number) 8));
        } else if (i != 5) {
            LinearLayout linearLayout3 = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.itemView");
            LinearLayout linearLayout4 = linearLayout3;
            linearLayout4.setPadding(linearLayout4.getPaddingLeft(), NumberExtendsKt.getDp((Number) 8), linearLayout4.getPaddingRight(), NumberExtendsKt.getDp((Number) 8));
        } else {
            LinearLayout linearLayout5 = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.itemView");
            LinearLayout linearLayout6 = linearLayout5;
            linearLayout6.setPadding(linearLayout6.getPaddingLeft(), NumberExtendsKt.getDp((Number) 8), linearLayout6.getPaddingRight(), NumberExtendsKt.getDp((Number) 16));
        }
    }
}
