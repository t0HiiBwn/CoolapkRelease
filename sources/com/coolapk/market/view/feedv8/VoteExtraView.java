package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.SubmitVoteExtraChildBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.widget.LinearMultiLayout;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.VoteResultShape;
import com.lany.picker.DatePicker;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoteExtraView.kt */
public final class VoteExtraView {
    public static final Companion Companion = new Companion(null);
    private static final String ITEM_TYPE_ADD_OPTION = "add_option";
    private static final String ITEM_TYPE_ANONYMOUS = "anonymous";
    private static final String ITEM_TYPE_BIND_PAGE = "bind_page";
    private static final String ITEM_TYPE_COLOR = "color";
    private static final String ITEM_TYPE_END_TIME = "end_time";
    private static final String ITEM_TYPE_LONG_DIVIDER = "long_divider";
    private static final String ITEM_TYPE_OPTION = "option";
    private static final String ITEM_TYPE_SHORT_DIVIDER = "short_divider";
    private static final String ITEM_TYPE_SHOW_AUTHOR = "show_author";
    private static final String ITEM_TYPE_VOTE_LIMIT = "vote_limit";
    private static final int LAYOUT_TYPE_ARGS = 3;
    private static final int LAYOUT_TYPE_COLOR = 1;
    private static final int LAYOUT_TYPE_LONG_DIVIDER = 5;
    private static final int LAYOUT_TYPE_OPTION = 2;
    private static final int LAYOUT_TYPE_SHORT_DIVIDER = 4;
    private static final int TOTAL_LAYOUT_TYPE = 5;
    private final Lazy adapter$delegate = LazyKt.lazy(new VoteExtraView$adapter$2(this));
    private int currentMultiOptionsCount;
    private final List<VoteViewData> dataList = new ArrayList();
    private final VoteContentHolder holder;
    private final VoteViewData longDivider;
    private final int maxOptionCount;
    private final List<VoteViewData> optionsDataList;
    private final List<VoteViewData> pkOptionsDataList;
    private final VoteViewData shortDivider;
    private boolean showMoreSetting;
    private final SparseArray<String> userInputOptions;

    private final DataAdapter getAdapter() {
        return (DataAdapter) this.adapter$delegate.getValue();
    }

    private final String voteAnonymousStatusToString(int i) {
        return i == 1 ? "允许" : "不允许";
    }

    private final String voteShowAuthorToString(int i) {
        return i != 1 ? "不显示" : "显示";
    }

    public VoteExtraView(VoteContentHolder voteContentHolder) {
        Intrinsics.checkNotNullParameter(voteContentHolder, "holder");
        this.holder = voteContentHolder;
        int i = UserPermissionChecker.INSTANCE.isLoginAdmin() ? 20 : 10;
        this.maxOptionCount = i;
        this.currentMultiOptionsCount = 4;
        this.userInputOptions = new SparseArray<>();
        VoteViewData voteViewData = new VoteViewData("short_divider", 0, null, null, 0, 30, null);
        this.shortDivider = voteViewData;
        this.longDivider = new VoteViewData("long_divider", 0, null, null, 0, 30, null);
        List<VoteViewData> mutableListOf = CollectionsKt.mutableListOf(new VoteViewData("option", 2131231464, "选项一", null, 0, 8, null), voteViewData, new VoteViewData("option", 2131231465, "选项二", null, 1, 8, null), voteViewData, new VoteViewData("option", 2131231466, "选项三", null, 2, 8, null), voteViewData, new VoteViewData("option", 2131231467, "选项四", null, 3, 8, null), voteViewData, new VoteViewData("option", 2131231468, "选项五", null, 4, 8, null), voteViewData, new VoteViewData("option", 2131231469, "选项六", null, 5, 8, null), voteViewData, new VoteViewData("option", 2131231470, "选项七", null, 6, 8, null), voteViewData, new VoteViewData("option", 2131231471, "选项八", null, 7, 8, null), voteViewData, new VoteViewData("option", 2131231472, "选项九", null, 8, 8, null), voteViewData, new VoteViewData("option", 2131231463, "选项十", null, 9, 8, null), voteViewData);
        int i2 = i - 10;
        for (int i3 = 0; i3 < i2; i3++) {
            mutableListOf.add(new VoteViewData("option", 2131231121, "选项" + (i3 + 11), null, i3 + 10, 8, null));
            mutableListOf.add(this.shortDivider);
        }
        Unit unit = Unit.INSTANCE;
        this.optionsDataList = mutableListOf;
        this.pkOptionsDataList = CollectionsKt.mutableListOf(new VoteViewData("option", 2131231464, "正方观点", null, 0, 8, null), this.shortDivider, new VoteViewData("option", 2131231465, "反方观点", null, 1, 8, null), this.shortDivider);
        getContainer().setAdapter(getAdapter());
        getAdapter().setNotifyOnChange(false);
        List<String> voteOptions = getMultiPart().voteOptions();
        Intrinsics.checkNotNullExpressionValue(voteOptions, "voteOptions");
        int i4 = 0;
        for (T t : voteOptions) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            this.userInputOptions.put(i4, t.toString());
            i4 = i5;
        }
        int size = voteOptions.size();
        if (size > this.currentMultiOptionsCount) {
            setCurrentMultiOptionsCount(size);
        }
        voteOptions.clear();
        int i6 = this.currentMultiOptionsCount;
        for (int i7 = 0; i7 < i6; i7++) {
            voteOptions.add(this.userInputOptions.get(i7, ""));
        }
    }

    public static final /* synthetic */ FeedMultiPart access$getMultiPart$p(VoteExtraView voteExtraView) {
        return voteExtraView.getMultiPart();
    }

    public static final /* synthetic */ void access$setMultiPart$p(VoteExtraView voteExtraView, FeedMultiPart feedMultiPart) {
        voteExtraView.setMultiPart(feedMultiPart);
    }

    private final LinearMultiLayout getContainer() {
        LinearMultiLayout linearMultiLayout = this.holder.getBinding$presentation_coolapkAppRelease().moreContainer;
        Intrinsics.checkNotNullExpressionValue(linearMultiLayout, "holder.binding.moreContainer");
        return linearMultiLayout;
    }

    public final Activity getActivity() {
        return this.holder.getActivity();
    }

    private final FeedMultiPart getMultiPart() {
        return this.holder.getMultiPart();
    }

    private final void setMultiPart(FeedMultiPart feedMultiPart) {
        this.holder.updateMultiPart$presentation_coolapkAppRelease(feedMultiPart);
    }

    public final FeedUIConfig getUiConfig() {
        return this.holder.getUiConfig();
    }

    public final void setUiConfig(FeedUIConfig feedUIConfig) {
        this.holder.updateUiConfig$presentation_coolapkAppRelease(feedUIConfig);
    }

    private final void requestCheckSubmittable() {
        this.holder.requestCheckSubmittable$presentation_coolapkAppRelease();
    }

    public final void setCurrentMultiOptionsCount(int i) {
        this.currentMultiOptionsCount = KotlinExtendKt.constrain(i, this.maxOptionCount, 2);
    }

    /* compiled from: VoteExtraView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void requestUpdateDataList() {
        this.dataList.clear();
        int voteType = getMultiPart().voteType();
        if (voteType == 0) {
            this.dataList.addAll(this.pkOptionsDataList);
            if (UserPermissionChecker.INSTANCE.getCanUseAdvancedVoteOptions()) {
                this.dataList.add(new VoteViewData("color", 2131231220, "自定义颜色", null, 0, 24, null));
            }
            this.dataList.add(this.longDivider);
        } else if (voteType == 1) {
            int i = this.currentMultiOptionsCount;
            if (i < this.maxOptionCount) {
                this.dataList.addAll(this.optionsDataList.subList(0, i * 2));
                this.dataList.add(new VoteViewData("add_option", 2131231121, "添加选项", null, 0, 24, null));
            } else {
                this.dataList.addAll(this.optionsDataList);
            }
            this.dataList.add(this.longDivider);
        }
        if (this.showMoreSetting) {
            this.dataList.add(new VoteViewData("anonymous", 2131231296, "允许匿名", voteAnonymousStatusToString(getMultiPart().voteAnonymousStatus()), 0, 16, null));
            this.dataList.add(this.shortDivider);
            this.dataList.add(new VoteViewData("end_time", 2131231209, "截止时间", voteEndTimeDataToString(getMultiPart().voteEndTime()), 0, 16, null));
            if (getMultiPart().voteType() == 1) {
                this.dataList.add(this.shortDivider);
                this.dataList.add(new VoteViewData("vote_limit", 2131231656, "投票上限", voteMaxSelectNumToString(getMultiPart().voteMaxSelectNum()), 0, 16, null));
            }
            if (UserPermissionChecker.INSTANCE.getCanUseAdvancedVoteOptions()) {
                this.dataList.add(this.shortDivider);
                this.dataList.add(new VoteViewData("show_author", 2131231117, "显示发起者信息", voteShowAuthorToString(getMultiPart().voteShowAuthor()), 0, 16, null));
            }
            if (UserPermissionChecker.INSTANCE.getCanUseAdvancedVoteOptions()) {
                this.dataList.add(this.shortDivider);
                List<VoteViewData> list = this.dataList;
                String votePage = getMultiPart().votePage();
                Intrinsics.checkNotNullExpressionValue(votePage, "multiPart.votePage()");
                list.add(new VoteViewData("bind_page", 2131231475, "绑定页面", KotlinExtendKt.limitLength(votePage, 10), 0, 16, null));
            }
        }
        notifyDataSetChanged();
    }

    private final void notifyDataSetChanged() {
        getAdapter().clear();
        getAdapter().addAll(this.dataList);
        getContainer().notifyDataSetChange();
    }

    public final void showMoreSettings() {
        if (!this.showMoreSetting) {
            this.showMoreSetting = true;
            requestUpdateDataList();
        }
    }

    public final void onItemClick(String str) {
        switch (str.hashCode()) {
            case -2095811475:
                if (str.equals("anonymous")) {
                    Integer[] numArr = {1, 0};
                    ArrayList arrayList = new ArrayList(2);
                    for (int i = 0; i < 2; i++) {
                        int intValue = numArr[i].intValue();
                        arrayList.add(new DialogUtil.DialogItemData(String.valueOf(intValue), voteAnonymousStatusToString(intValue), "", Boolean.valueOf(getMultiPart().voteAnonymousStatus() == intValue)));
                    }
                    DialogUtil.INSTANCE.showBottomSheetListDialog(getActivity(), arrayList, new VoteExtraView$onItemClick$1(this));
                    return;
                }
                return;
            case -930146991:
                if (str.equals("bind_page")) {
                    DialogUtil dialogUtil = DialogUtil.INSTANCE;
                    Activity activity = getActivity();
                    String votePage = getMultiPart().votePage();
                    Intrinsics.checkNotNullExpressionValue(votePage, "multiPart.votePage()");
                    DialogUtil.showCenterEditTextDialog$default(dialogUtil, activity, "绑定页面", votePage, "输入绑定页面链接，该页面会在提问详情页的一个新的【相关】tab内展示", new VoteExtraView$onItemClick$3(this), null, 32, null);
                    return;
                }
                return;
            case 25648397:
                if (str.equals("show_author")) {
                    Integer[] numArr2 = {1, 0};
                    ArrayList arrayList2 = new ArrayList(2);
                    for (int i2 = 0; i2 < 2; i2++) {
                        int intValue2 = numArr2[i2].intValue();
                        arrayList2.add(new DialogUtil.DialogItemData(String.valueOf(intValue2), voteShowAuthorToString(intValue2), "", Boolean.valueOf(getMultiPart().voteShowAuthor() == intValue2)));
                    }
                    DialogUtil.INSTANCE.showBottomSheetListDialog(getActivity(), arrayList2, new VoteExtraView$onItemClick$4(this));
                    return;
                }
                return;
            case 94842723:
                if (str.equals("color")) {
                    List<String> voteOptionColors = getMultiPart().voteOptionColors();
                    Intrinsics.checkNotNullExpressionValue(voteOptionColors, "multiPart.voteOptionColors()");
                    Integer stringToColor = ColorUtils.stringToColor((String) CollectionsKt.getOrNull(voteOptionColors, 0));
                    if (stringToColor == null) {
                        stringToColor = Integer.valueOf(ResourceUtils.getColorInt(getActivity(), 2131099792));
                    }
                    Intrinsics.checkNotNullExpressionValue(stringToColor, "ColorUtils.stringToColor…R.color.compare_view_red)");
                    int intValue3 = stringToColor.intValue();
                    List<String> voteOptionColors2 = getMultiPart().voteOptionColors();
                    Intrinsics.checkNotNullExpressionValue(voteOptionColors2, "multiPart.voteOptionColors()");
                    Integer stringToColor2 = ColorUtils.stringToColor((String) CollectionsKt.getOrNull(voteOptionColors2, 1));
                    if (stringToColor2 == null) {
                        stringToColor2 = Integer.valueOf(ResourceUtils.getColorInt(getActivity(), 2131099791));
                    }
                    Intrinsics.checkNotNullExpressionValue(stringToColor2, "ColorUtils.stringToColor….color.compare_view_blue)");
                    int intValue4 = stringToColor2.intValue();
                    VoteColorPickerFragment voteColorPickerFragment = new VoteColorPickerFragment();
                    voteColorPickerFragment.setInitValue(intValue3, intValue4, new VoteExtraView$onItemClick$$inlined$apply$lambda$1(this, intValue3, intValue4));
                    FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(getActivity()).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this@VoteExtraView.activ…().supportFragmentManager");
                    voteColorPickerFragment.show(supportFragmentManager, (String) null);
                    return;
                }
                return;
            case 1725551537:
                if (!str.equals("end_time")) {
                    return;
                }
                if (getMultiPart().voteEndTime() <= 2592000 || !UserPermissionChecker.INSTANCE.isLoginAdmin() || Build.VERSION.SDK_INT < 26) {
                    showPickDurationDialog();
                    return;
                } else {
                    showPickDateDialog();
                    return;
                }
            case 1941915091:
                if (str.equals("add_option")) {
                    onUserAddOption();
                    return;
                }
                return;
            case 2091100710:
                if (str.equals("vote_limit")) {
                    int voteMaxSelectNum = getMultiPart().voteMaxSelectNum();
                    int i3 = this.currentMultiOptionsCount;
                    ArrayList arrayList3 = new ArrayList(i3);
                    int i4 = 0;
                    while (i4 < i3) {
                        i4++;
                        arrayList3.add(Integer.valueOf(i4));
                    }
                    ArrayList<Number> arrayList4 = arrayList3;
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                    for (Number number : arrayList4) {
                        int intValue5 = number.intValue();
                        arrayList5.add(new DialogUtil.DialogItemData(String.valueOf(intValue5), voteMaxSelectNumToString(intValue5), "", Boolean.valueOf(voteMaxSelectNum == intValue5)));
                    }
                    DialogUtil.INSTANCE.showBottomSheetListDialog(getActivity(), arrayList5, new VoteExtraView$onItemClick$2(this));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void showPickDurationDialog() {
        if (!getUiConfig().canUpdateVoteTime()) {
            Toast.show$default(getActivity(), "截止时间不可修改", 0, false, 12, null);
            return;
        }
        long voteEndTime = getMultiPart().voteEndTime();
        List mutableListOf = CollectionsKt.mutableListOf(86400L, 604800L, 2592000L);
        if (UserPermissionChecker.INSTANCE.isLoginAdmin() && Build.VERSION.SDK_INT >= 26) {
            mutableListOf.add(-2L);
        }
        List<Number> list = mutableListOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Number number : list) {
            long longValue = number.longValue();
            arrayList.add(new DialogUtil.DialogItemData(String.valueOf(longValue), voteEndTimeDataToString(longValue), "", Boolean.valueOf(voteEndTime == longValue)));
        }
        DialogUtil.INSTANCE.showBottomSheetListDialog(getActivity(), arrayList, new VoteExtraView$showPickDurationDialog$1(this));
        requestCheckSubmittable();
    }

    public final void showPickDateDialog() {
        if (!getUiConfig().canUpdateVoteTime()) {
            Toast.show$default(getActivity(), "截止时间不可修改", 0, false, 12, null);
            return;
        }
        DatePicker datePicker = new DatePicker(getActivity());
        datePicker.setMinDate(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        long voteEndTime = getMultiPart().voteEndTime();
        if (voteEndTime > 2592000) {
            LocalDate localDate = Instant.ofEpochSecond(voteEndTime).atZone(ZoneId.systemDefault()).toLocalDate();
            Intrinsics.checkNotNullExpressionValue(localDate, "date");
            datePicker.updateDate(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());
        }
        AlertDialog create = new AlertDialog.Builder(getActivity()).setView(datePicker).create();
        create.setButton(-1, "确定", new VoteExtraView$showPickDateDialog$$inlined$apply$lambda$1(this, datePicker));
        create.setButton(-3, "时长模式", new VoteExtraView$showPickDateDialog$$inlined$apply$lambda$2(this, datePicker));
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder((act…      }\n                }");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(getActivity()).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
    }

    public final void onUserEditOptions(int i, String str) {
        if (!Intrinsics.areEqual(str, this.userInputOptions.get(i, ""))) {
            this.userInputOptions.put(i, str);
            List<String> voteOptions = getMultiPart().voteOptions();
            voteOptions.clear();
            int i2 = this.currentMultiOptionsCount;
            for (int i3 = 0; i3 < i2; i3++) {
                voteOptions.add(this.userInputOptions.get(i3, ""));
            }
            requestCheckSubmittable();
        }
    }

    public final void onUserRemoveOption(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.currentMultiOptionsCount;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 != i) {
                String str = this.userInputOptions.get(i4, "");
                Intrinsics.checkNotNullExpressionValue(str, "userInputOptions.get(it, \"\")");
                arrayList.add(str);
            }
        }
        this.userInputOptions.clear();
        getMultiPart().voteOptions().clear();
        getMultiPart().voteOptions().addAll(arrayList);
        setCurrentMultiOptionsCount(this.currentMultiOptionsCount - 1);
        for (Object obj : arrayList) {
            int i5 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            this.userInputOptions.put(i3, ((String) obj).toString());
            i3 = i5;
        }
        if (getMultiPart().voteMaxSelectNum() > this.currentMultiOptionsCount) {
            FeedMultiPart build = getMultiPart().newBuilder().voteMaxSelectNum(this.currentMultiOptionsCount).build();
            Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder().v…ultiOptionsCount).build()");
            setMultiPart(build);
        }
        requestUpdateDataList();
        requestCheckSubmittable();
    }

    private final void onUserAddOption() {
        setCurrentMultiOptionsCount(this.currentMultiOptionsCount + 1);
        List<String> voteOptions = getMultiPart().voteOptions();
        voteOptions.clear();
        int i = this.currentMultiOptionsCount;
        for (int i2 = 0; i2 < i; i2++) {
            voteOptions.add(this.userInputOptions.get(i2, ""));
        }
        requestUpdateDataList();
        requestCheckSubmittable();
    }

    private final String voteEndTimeDataToString(long j) {
        int i = (j > 2592000 ? 1 : (j == 2592000 ? 0 : -1));
        if (i > 0 && 26 <= Build.VERSION.SDK_INT) {
            String format = Instant.ofEpochSecond(j).atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
            Intrinsics.checkNotNullExpressionValue(format, "date.format(DateTimeForm…ofPattern(\"yyyy年MM月dd日\"))");
            return format;
        } else if (j == 86400) {
            return "24小时";
        } else {
            if (j == 604800) {
                return "7天";
            }
            if (i == 0) {
                return "30天";
            }
            if (j == -1) {
                return "未设置";
            }
            return j == -2 ? "日期模式" : "其他时间";
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int), (39033 char)] */
    private final String voteMaxSelectNumToString(int i) {
        if (i == 1) {
            return "单项";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append((char) 39033);
        return sb.toString();
    }

    /* compiled from: VoteExtraView.kt */
    private static final class VoteViewData {
        private final String description;
        private final int iconRes;
        private final String itemType;
        private final int optionIndex;
        private final String title;

        public static /* synthetic */ VoteViewData copy$default(VoteViewData voteViewData, String str, int i, String str2, String str3, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = voteViewData.itemType;
            }
            if ((i3 & 2) != 0) {
                i = voteViewData.iconRes;
            }
            if ((i3 & 4) != 0) {
                str2 = voteViewData.title;
            }
            if ((i3 & 8) != 0) {
                str3 = voteViewData.description;
            }
            if ((i3 & 16) != 0) {
                i2 = voteViewData.optionIndex;
            }
            return voteViewData.copy(str, i, str2, str3, i2);
        }

        public final String component1() {
            return this.itemType;
        }

        public final int component2() {
            return this.iconRes;
        }

        public final String component3() {
            return this.title;
        }

        public final String component4() {
            return this.description;
        }

        public final int component5() {
            return this.optionIndex;
        }

        public final VoteViewData copy(String str, int i, String str2, String str3, int i2) {
            Intrinsics.checkNotNullParameter(str, "itemType");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "description");
            return new VoteViewData(str, i, str2, str3, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VoteViewData)) {
                return false;
            }
            VoteViewData voteViewData = (VoteViewData) obj;
            return Intrinsics.areEqual(this.itemType, voteViewData.itemType) && this.iconRes == voteViewData.iconRes && Intrinsics.areEqual(this.title, voteViewData.title) && Intrinsics.areEqual(this.description, voteViewData.description) && this.optionIndex == voteViewData.optionIndex;
        }

        public int hashCode() {
            String str = this.itemType;
            int i = 0;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.iconRes) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return ((hashCode2 + i) * 31) + this.optionIndex;
        }

        public String toString() {
            return "VoteViewData(itemType=" + this.itemType + ", iconRes=" + this.iconRes + ", title=" + this.title + ", description=" + this.description + ", optionIndex=" + this.optionIndex + ")";
        }

        public VoteViewData(String str, int i, String str2, String str3, int i2) {
            Intrinsics.checkNotNullParameter(str, "itemType");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "description");
            this.itemType = str;
            this.iconRes = i;
            this.title = str2;
            this.description = str3;
            this.optionIndex = i2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ VoteViewData(String str, int i, String str2, String str3, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? -1 : i2);
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final String getItemType() {
            return this.itemType;
        }

        public final int getOptionIndex() {
            return this.optionIndex;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    /* compiled from: VoteExtraView.kt */
    private final class DataAdapter extends ArrayAdapter<VoteViewData> {
        private final int TAG_ID = 2131363510;
        final /* synthetic */ VoteExtraView this$0;

        @Override // android.widget.Adapter, android.widget.BaseAdapter
        public int getViewTypeCount() {
            return 5;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataAdapter(VoteExtraView voteExtraView, Context context) {
            super(context, 0);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = voteExtraView;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Object obj;
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1 || itemViewType == 2 || itemViewType == 3) {
                if (view == null) {
                    obj = createItemViewHolder(viewGroup, itemViewType);
                } else {
                    obj = view.getTag(this.TAG_ID);
                }
                ItemViewHolder itemViewHolder = (ItemViewHolder) obj;
                itemViewHolder.getBinding().getRoot().setTag(this.TAG_ID, itemViewHolder);
                Object item = getItem(i);
                Intrinsics.checkNotNull(item);
                Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
                itemViewHolder.bindTo((VoteViewData) item);
                View root = itemViewHolder.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "viewHolder.binding.root");
                return root;
            } else if (itemViewType == 4) {
                View view2 = (View) (view == null ? createShortDivider() : view.getTag(this.TAG_ID));
                view2.setTag(this.TAG_ID, view2);
                return view2;
            } else if (itemViewType != 5) {
                View view3 = super.getView(i, view, viewGroup);
                Intrinsics.checkNotNullExpressionValue(view3, "super.getView(position, convertView, parent)");
                return view3;
            } else {
                View view4 = (View) (view == null ? createLongDivider() : view.getTag(this.TAG_ID));
                view4.setTag(this.TAG_ID, view4);
                return view4;
            }
        }

        private final View createShortDivider() {
            View view = new View(getContext());
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(2131165598));
            layoutParams.leftMargin = NumberExtendsKt.getDp((Number) 16);
            layoutParams.rightMargin = NumberExtendsKt.getDp((Number) 16);
            Unit unit = Unit.INSTANCE;
            view.setLayoutParams(layoutParams);
            view.setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
            return view;
        }

        private final View createLongDivider() {
            View view = new View(getContext());
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(2131165372)));
            view.setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
            return view;
        }

        private final ItemViewHolder createItemViewHolder(ViewGroup viewGroup, int i) {
            VoteExtraView voteExtraView = this.this$0;
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), 2131559182, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…tra_child, parent, false)");
            ItemViewHolder itemViewHolder = new ItemViewHolder(voteExtraView, (SubmitVoteExtraChildBinding) inflate);
            itemViewHolder.initView(i);
            return itemViewHolder;
        }

        public final <T> T convertOrCreateHolder(View view, Function0<? extends T> function0) {
            Intrinsics.checkNotNullParameter(function0, "factor");
            return view == null ? (T) function0.invoke() : (T) view.getTag(this.TAG_ID);
        }

        @Override // android.widget.Adapter, android.widget.BaseAdapter
        public int getItemViewType(int i) {
            Object item = getItem(i);
            Intrinsics.checkNotNull(item);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
            String itemType = ((VoteViewData) item).getItemType();
            switch (itemType.hashCode()) {
                case -2095811475:
                    if (itemType.equals("anonymous")) {
                        return 3;
                    }
                    break;
                case -1136459178:
                    if (itemType.equals("short_divider")) {
                        return 4;
                    }
                    break;
                case -1010136971:
                    if (itemType.equals("option")) {
                        return 2;
                    }
                    break;
                case -930146991:
                    if (itemType.equals("bind_page")) {
                        return 3;
                    }
                    break;
                case 25648397:
                    if (itemType.equals("show_author")) {
                        return 3;
                    }
                    break;
                case 94842723:
                    if (itemType.equals("color")) {
                        return 1;
                    }
                    break;
                case 1569604694:
                    if (itemType.equals("long_divider")) {
                        return 5;
                    }
                    break;
                case 1725551537:
                    if (itemType.equals("end_time")) {
                        return 3;
                    }
                    break;
                case 1941915091:
                    if (itemType.equals("add_option")) {
                        return 3;
                    }
                    break;
                case 2091100710:
                    if (itemType.equals("vote_limit")) {
                        return 3;
                    }
                    break;
            }
            throw new RuntimeException("Check this error!!!");
        }
    }

    /* compiled from: VoteExtraView.kt */
    private final class ItemViewHolder {
        private final SubmitVoteExtraChildBinding binding;
        private VoteViewData data;
        final /* synthetic */ VoteExtraView this$0;

        public ItemViewHolder(VoteExtraView voteExtraView, SubmitVoteExtraChildBinding submitVoteExtraChildBinding) {
            Intrinsics.checkNotNullParameter(submitVoteExtraChildBinding, "binding");
            this.this$0 = voteExtraView;
            this.binding = submitVoteExtraChildBinding;
        }

        public final SubmitVoteExtraChildBinding getBinding() {
            return this.binding;
        }

        public final void initView(int i) {
            if (i == 1) {
                EditText editText = this.binding.editText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
                editText.setVisibility(4);
                ImageView imageView = this.binding.extraImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.extraImageView");
                imageView.setVisibility(0);
                TextView textView = this.binding.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
                textView.setVisibility(8);
                ImageView imageView2 = this.binding.arrowView;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.arrowView");
                imageView2.setVisibility(8);
                ImageView imageView3 = this.binding.extraImageView;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.extraImageView");
                ViewExtendsKt.clipView$default(imageView3, 2, 0.0f, 2, null);
            } else if (i == 2) {
                EditText editText2 = this.binding.editText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
                editText2.setVisibility(0);
                ImageView imageView4 = this.binding.extraImageView;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.extraImageView");
                imageView4.setVisibility(0);
                TextView textView2 = this.binding.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
                textView2.setVisibility(8);
                ImageView imageView5 = this.binding.arrowView;
                Intrinsics.checkNotNullExpressionValue(imageView5, "binding.arrowView");
                imageView5.setVisibility(8);
                this.binding.editText.addTextChangedListener(new VoteExtraView$ItemViewHolder$initView$1(this));
                EditText editText3 = this.binding.editText;
                Intrinsics.checkNotNullExpressionValue(editText3, "binding.editText");
                editText3.setOnFocusChangeListener(new VoteExtraView$ItemViewHolder$initView$2(this));
                this.binding.extraImageView.setImageResource(2131231211);
                ImageView imageView6 = this.binding.extraImageView;
                Intrinsics.checkNotNullExpressionValue(imageView6, "binding.extraImageView");
                imageView6.setImageTintList(ColorStateList.valueOf(ResourceUtils.getColorInt(this.this$0.getActivity(), 2131099896)));
                this.binding.extraImageView.setOnClickListener(new VoteExtraView$ItemViewHolder$initView$3(this));
            } else if (i == 3) {
                EditText editText4 = this.binding.editText;
                Intrinsics.checkNotNullExpressionValue(editText4, "binding.editText");
                editText4.setVisibility(4);
                ImageView imageView7 = this.binding.extraImageView;
                Intrinsics.checkNotNullExpressionValue(imageView7, "binding.extraImageView");
                imageView7.setVisibility(8);
                TextView textView3 = this.binding.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
                textView3.setVisibility(0);
                ImageView imageView8 = this.binding.arrowView;
                Intrinsics.checkNotNullExpressionValue(imageView8, "binding.arrowView");
                imageView8.setVisibility(0);
            }
        }

        public final void bindTo(VoteViewData voteViewData) {
            Intrinsics.checkNotNullParameter(voteViewData, "data");
            this.data = voteViewData;
            this.binding.imageView.setImageResource(voteViewData.getIconRes());
            TextView textView = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(voteViewData.getTitle());
            TextView textView2 = this.binding.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
            textView2.setText(voteViewData.getDescription());
            this.binding.getRoot().setOnClickListener(new VoteExtraView$ItemViewHolder$bindTo$1(this, voteViewData));
            String itemType = voteViewData.getItemType();
            int hashCode = itemType.hashCode();
            if (hashCode != -1010136971) {
                if (hashCode != 94842723) {
                    if (hashCode == 1941915091 && itemType.equals("add_option")) {
                        ImageView imageView = this.binding.arrowView;
                        Intrinsics.checkNotNullExpressionValue(imageView, "binding.arrowView");
                        imageView.setVisibility(4);
                    }
                } else if (itemType.equals("color")) {
                    List<String> voteOptionColors = VoteExtraView.access$getMultiPart$p(this.this$0).voteOptionColors();
                    Intrinsics.checkNotNullExpressionValue(voteOptionColors, "multiPart.voteOptionColors()");
                    Integer stringToColor = ColorUtils.stringToColor((String) CollectionsKt.getOrNull(voteOptionColors, 0));
                    if (stringToColor == null) {
                        stringToColor = Integer.valueOf(ResourceUtils.getColorInt(this.this$0.getActivity(), 2131099792));
                    }
                    Intrinsics.checkNotNullExpressionValue(stringToColor, "ColorUtils.stringToColor…R.color.compare_view_red)");
                    int intValue = stringToColor.intValue();
                    List<String> voteOptionColors2 = VoteExtraView.access$getMultiPart$p(this.this$0).voteOptionColors();
                    Intrinsics.checkNotNullExpressionValue(voteOptionColors2, "multiPart.voteOptionColors()");
                    Integer stringToColor2 = ColorUtils.stringToColor((String) CollectionsKt.getOrNull(voteOptionColors2, 1));
                    if (stringToColor2 == null) {
                        stringToColor2 = Integer.valueOf(ResourceUtils.getColorInt(this.this$0.getActivity(), 2131099791));
                    }
                    Intrinsics.checkNotNullExpressionValue(stringToColor2, "ColorUtils.stringToColor….color.compare_view_blue)");
                    int intValue2 = stringToColor2.intValue();
                    ImageView imageView2 = this.binding.extraImageView;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.extraImageView");
                    ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(imageView2);
                    if (marginParams != null) {
                        marginParams.width = NumberExtendsKt.getDp((Number) 40);
                        marginParams.height = NumberExtendsKt.getDp((Number) 14);
                    }
                    ImageView imageView3 = this.binding.extraImageView;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.extraImageView");
                    imageView3.setBackground(new ShapeDrawable(new VoteResultShape(intValue, intValue2, 0.5f, NumberExtendsKt.getDp((Number) 4))));
                }
            } else if (itemType.equals("option")) {
                this.binding.editText.setText((CharSequence) this.this$0.userInputOptions.get(voteViewData.getOptionIndex(), ""));
                ImageView imageView4 = this.binding.extraImageView;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.extraImageView");
                imageView4.setVisibility(VoteExtraView.access$getMultiPart$p(this.this$0).voteType() == 0 || this.this$0.currentMultiOptionsCount <= 2 ? 8 : 0);
                int i = VoteExtraView.access$getMultiPart$p(this.this$0).voteType() == 0 ? 5 : 15;
                EditText editText = this.binding.editText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
                editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(i)});
            }
        }
    }
}
