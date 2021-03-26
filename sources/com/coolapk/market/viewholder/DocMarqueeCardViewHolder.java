package com.coolapk.market.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ViewFlipper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemDocListCardItemBinding;
import com.coolapk.market.databinding.ItemDocMarqueeCardBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.app.FetchGiftDialog;
import com.coolapk.market.view.base.SimpleDialog;
import com.gongwen.marqueen.MarqueeFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DocMarqueeCardViewHolder extends BindingViewHolder implements IAnimationBehavior {
    public static final int LAYOUT_ID = 2131558674;
    private final ItemDocMarqueeCardBinding binding;
    private final DataBindingComponent component;
    private int displayedChild;
    private EntityCard entityCard;

    public DocMarqueeCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        this.component = dataBindingComponent;
        ItemDocMarqueeCardBinding itemDocMarqueeCardBinding = (ItemDocMarqueeCardBinding) getBinding();
        this.binding = itemDocMarqueeCardBinding;
        itemDocMarqueeCardBinding.marqueeView.setInterval(3000);
        itemDocMarqueeCardBinding.marqueeView.setAutoStart(true);
        itemDocMarqueeCardBinding.marqueeView.setAnimateFirstView(false);
        itemDocMarqueeCardBinding.marqueeView.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            /* class com.coolapk.market.viewholder.DocMarqueeCardViewHolder.AnonymousClass1 */

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                DocMarqueeCardViewHolder docMarqueeCardViewHolder = DocMarqueeCardViewHolder.this;
                docMarqueeCardViewHolder.displayedChild = docMarqueeCardViewHolder.binding.marqueeView.getDisplayedChild();
            }
        });
    }

    @Override // com.coolapk.market.viewholder.IAnimationBehavior
    public void startAnimation() {
        try {
            Field declaredField = ViewFlipper.class.getDeclaredField("mStarted");
            declaredField.setAccessible(true);
            declaredField.setBoolean(this.binding.marqueeView, true);
            Method declaredMethod = ViewFlipper.class.getDeclaredMethod("updateRunning", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.binding.marqueeView, false);
        } catch (Exception unused) {
        }
    }

    @Override // com.coolapk.market.viewholder.IAnimationBehavior
    public void stopAnimation() {
        this.binding.marqueeView.stopFlipping();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.entityCard = (EntityCard) obj;
        ItemMF itemMF = new ItemMF(getContext(), this.component);
        itemMF.setData(this.entityCard.getEntities());
        itemMF.setOnItemClickListener(new MarqueeFactory.OnItemClickListener<View, Entity>() {
            /* class com.coolapk.market.viewholder.DocMarqueeCardViewHolder.AnonymousClass2 */

            @Override // com.gongwen.marqueen.MarqueeFactory.OnItemClickListener
            public void onItemClickListener(MarqueeFactory.ViewHolder<View, Entity> viewHolder) {
                V v = viewHolder.mView;
                P p = viewHolder.data;
                final Context context = DocMarqueeCardViewHolder.this.getContext();
                ItemDocListCardItemBinding itemDocListCardItemBinding = (ItemDocListCardItemBinding) DataBindingUtil.findBinding(v);
                if (v.getId() != 2131362605) {
                    if (p instanceof Gift) {
                        P p2 = p;
                        ActionManager.startAppViewActivity(UiUtils.getActivity(context), itemDocListCardItemBinding.iconView, p2.getApkName(), p2.getApkLogo(), p2.getApkTitle(), p2.getExtraAnalysisData(), null, null);
                    } else if (p instanceof NewHeadLine) {
                        ActionManager.startActivityByUrl(context, p.getUrl());
                    }
                    StatisticHelper.getInstance().recordEntityEvent("", p, DocMarqueeCardViewHolder.this.getAdapterPosition(), DocMarqueeCardViewHolder.this.entityCard, "");
                    return;
                }
                final P p3 = p;
                if (!p3.isGet()) {
                    if (!p3.isRequireInstalled() || PackageUtils.isInstalled(context, p3.getApkName())) {
                        FetchGiftDialog.newInstance(p3).show(ContextExtendsKt.requireAppCompatActivity(DocMarqueeCardViewHolder.this.getContext()).getSupportFragmentManager(), (String) null);
                        return;
                    }
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    newInstance.setMessage(context.getString(2131886822));
                    newInstance.setPositiveButton(2131886128, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.viewholder.DocMarqueeCardViewHolder.AnonymousClass2.AnonymousClass1 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActionManager.startAppViewActivity(context, p3.getApkName(), true);
                        }
                    });
                    newInstance.setNegativeButton(2131886115);
                    newInstance.show(ContextExtendsKt.requireAppCompatActivity(DocMarqueeCardViewHolder.this.getContext()).getSupportFragmentManager(), (String) null);
                }
            }
        });
        this.binding.marqueeView.setMarqueeFactory(itemMF);
        this.binding.marqueeView.setDisplayedChild(this.displayedChild);
        this.binding.executePendingBindings();
    }

    private static class ItemMF extends MarqueeFactory<View, Entity> {
        private DataBindingComponent component;
        private Context context;
        private LayoutInflater inflater;

        public ItemMF(Context context2, DataBindingComponent dataBindingComponent) {
            super(context2);
            this.context = context2;
            this.component = dataBindingComponent;
            this.inflater = LayoutInflater.from(context2);
        }

        public View generateMarqueeItemView(Entity entity) {
            View inflate = this.inflater.inflate(2131558673, (ViewGroup) null, false);
            ItemDocListCardItemBinding itemDocListCardItemBinding = (ItemDocListCardItemBinding) DataBindingUtil.bind(inflate, this.component);
            if (entity instanceof Gift) {
                itemDocListCardItemBinding.setIsGift(true);
                itemDocListCardItemBinding.setTitle(entity.getTitle());
                itemDocListCardItemBinding.setEntityTypeName(entity.getEntityTypeName());
                itemDocListCardItemBinding.setLogo(((Gift) entity).getApkLogo());
            } else if (entity instanceof NewHeadLine) {
                itemDocListCardItemBinding.setIsGift(false);
                itemDocListCardItemBinding.setTitle(entity.getTitle());
                itemDocListCardItemBinding.setEntityTypeName(entity.getEntityTypeName());
                itemDocListCardItemBinding.setLogo(entity.getLogo());
            }
            itemDocListCardItemBinding.executePendingBindings();
            UiUtils.setDrawableColors(itemDocListCardItemBinding.entityTypeNameView.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
            return inflate;
        }
    }
}
