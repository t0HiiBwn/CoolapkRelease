package com.coolapk.market.viewholder;

import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.product.ProductGlobalData;
import java.util.concurrent.atomic.AtomicInteger;

public class RankViewHolder extends ServiceAppViewHolder {
    public static final int LAYOUT_ID = 2131558924;
    private ServiceAppBinding binding;
    private final AtomicInteger podiumCardIndex;

    public RankViewHolder(View view, DataBindingComponent dataBindingComponent, AtomicInteger atomicInteger, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ServiceAppBinding serviceAppBinding = (ServiceAppBinding) getBinding();
        this.binding = serviceAppBinding;
        this.podiumCardIndex = atomicInteger;
        serviceAppBinding.rankTextView.setTypeface(ProductGlobalData.getNumberTypeface(getContext()));
    }

    @Override // com.coolapk.market.viewholder.ServiceAppViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        int i;
        super.bindTo(obj);
        this.binding.rankView.setVisibility(0);
        ServiceApp serviceApp = (ServiceApp) obj;
        int adapterPosition = getAdapterPosition();
        int i2 = this.podiumCardIndex.get();
        if (i2 != -1 && adapterPosition > i2) {
            adapterPosition = (adapterPosition + 3) - i2;
        }
        this.binding.rankTextView.setText(String.valueOf(adapterPosition));
        if (serviceApp.getUpDown() > 0) {
            i = ContextCompat.getColor(getContext(), 2131099688);
            this.binding.rankUpDownView.setText("↑");
        } else if (serviceApp.getUpDown() < 0) {
            i = ContextCompat.getColor(getContext(), 2131099680);
            this.binding.rankUpDownView.setText("↓");
        } else {
            i = AppHolder.getAppTheme().getTextColorSecondary();
            this.binding.rankUpDownView.setText("—");
        }
        this.binding.rankUpDownView.setTextColor(i);
        this.binding.introductionView.setVisibility(8);
    }
}
