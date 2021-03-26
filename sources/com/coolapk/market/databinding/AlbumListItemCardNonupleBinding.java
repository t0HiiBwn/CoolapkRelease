package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Card;
import com.coolapk.market.viewholder.AlbumMainCardViewHolder;

public abstract class AlbumListItemCardNonupleBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView headerDividerView;
    public final TextView headerMoreView;
    public final TextView headerTitleView;
    public final LinearLayout headerView;
    public final AlbumListItemCardNonupleItemBinding itemView1;
    public final AlbumListItemCardNonupleItemBinding itemView10;
    public final AlbumListItemCardNonupleItemBinding itemView11;
    public final AlbumListItemCardNonupleItemBinding itemView12;
    public final AlbumListItemCardNonupleItemBinding itemView2;
    public final AlbumListItemCardNonupleItemBinding itemView3;
    public final AlbumListItemCardNonupleItemBinding itemView4;
    public final AlbumListItemCardNonupleItemBinding itemView5;
    public final AlbumListItemCardNonupleItemBinding itemView6;
    public final AlbumListItemCardNonupleItemBinding itemView7;
    public final AlbumListItemCardNonupleItemBinding itemView8;
    public final AlbumListItemCardNonupleItemBinding itemView9;
    @Bindable
    protected Card mCard;
    @Bindable
    protected AlbumMainCardViewHolder mViewHolder;

    public abstract void setCard(Card card);

    public abstract void setViewHolder(AlbumMainCardViewHolder albumMainCardViewHolder);

    protected AlbumListItemCardNonupleBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout2, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding2, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding3, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding4, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding5, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding6, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding7, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding8, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding9, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding10, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding11, AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding12) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.headerDividerView = imageView;
        this.headerMoreView = textView;
        this.headerTitleView = textView2;
        this.headerView = linearLayout2;
        this.itemView1 = albumListItemCardNonupleItemBinding;
        this.itemView10 = albumListItemCardNonupleItemBinding2;
        this.itemView11 = albumListItemCardNonupleItemBinding3;
        this.itemView12 = albumListItemCardNonupleItemBinding4;
        this.itemView2 = albumListItemCardNonupleItemBinding5;
        this.itemView3 = albumListItemCardNonupleItemBinding6;
        this.itemView4 = albumListItemCardNonupleItemBinding7;
        this.itemView5 = albumListItemCardNonupleItemBinding8;
        this.itemView6 = albumListItemCardNonupleItemBinding9;
        this.itemView7 = albumListItemCardNonupleItemBinding10;
        this.itemView8 = albumListItemCardNonupleItemBinding11;
        this.itemView9 = albumListItemCardNonupleItemBinding12;
    }

    public AlbumMainCardViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public Card getCard() {
        return this.mCard;
    }

    public static AlbumListItemCardNonupleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumListItemCardNonupleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumListItemCardNonupleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558449, viewGroup, z, obj);
    }

    public static AlbumListItemCardNonupleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumListItemCardNonupleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumListItemCardNonupleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558449, null, false, obj);
    }

    public static AlbumListItemCardNonupleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumListItemCardNonupleBinding bind(View view, Object obj) {
        return (AlbumListItemCardNonupleBinding) bind(obj, view, 2131558449);
    }
}
