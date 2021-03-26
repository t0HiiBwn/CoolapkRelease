package com.coolapk.market.view.product.viewholder;

import android.os.Parcel;
import android.os.Parcelable;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JL\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eHÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductLocalData;", "Landroid/os/Parcelable;", "type", "", "title", "product", "Lcom/coolapk/market/model/Product;", "products", "", "moreCard", "Lcom/coolapk/market/model/Entity;", "(Ljava/lang/String;Ljava/lang/String;Lcom/coolapk/market/model/Product;[Lcom/coolapk/market/model/Product;Lcom/coolapk/market/model/Entity;)V", "getMoreCard", "()Lcom/coolapk/market/model/Entity;", "getProduct", "()Lcom/coolapk/market/model/Product;", "getProducts", "()[Lcom/coolapk/market/model/Product;", "[Lcom/coolapk/market/model/Product;", "getTitle", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coolapk/market/model/Product;[Lcom/coolapk/market/model/Product;Lcom/coolapk/market/model/Entity;)Lcom/coolapk/market/view/product/viewholder/ProductLocalData;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductLocalData.kt */
public final class ProductLocalData implements Parcelable {
    public static final Parcelable.Creator<ProductLocalData> CREATOR = new Creator();
    private final Entity moreCard;
    private final Product product;
    private final Product[] products;
    private final String title;
    private final String type;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ProductLocalData> {
        @Override // android.os.Parcelable.Creator
        public final ProductLocalData createFromParcel(Parcel parcel) {
            Product[] productArr;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Product product = (Product) parcel.readParcelable(ProductLocalData.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                productArr = new Product[readInt];
                for (int i = 0; readInt > i; i++) {
                    productArr[i] = (Product) parcel.readParcelable(ProductLocalData.class.getClassLoader());
                }
            } else {
                productArr = null;
            }
            return new ProductLocalData(readString, readString2, product, productArr, (Entity) parcel.readParcelable(ProductLocalData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final ProductLocalData[] newArray(int i) {
            return new ProductLocalData[i];
        }
    }

    public static /* synthetic */ ProductLocalData copy$default(ProductLocalData productLocalData, String str, String str2, Product product2, Product[] productArr, Entity entity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = productLocalData.type;
        }
        if ((i & 2) != 0) {
            str2 = productLocalData.title;
        }
        if ((i & 4) != 0) {
            product2 = productLocalData.product;
        }
        if ((i & 8) != 0) {
            productArr = productLocalData.products;
        }
        if ((i & 16) != 0) {
            entity = productLocalData.moreCard;
        }
        return productLocalData.copy(str, str2, product2, productArr, entity);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.title;
    }

    public final Product component3() {
        return this.product;
    }

    public final Product[] component4() {
        return this.products;
    }

    public final Entity component5() {
        return this.moreCard;
    }

    public final ProductLocalData copy(String str, String str2, Product product2, Product[] productArr, Entity entity) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new ProductLocalData(str, str2, product2, productArr, entity);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductLocalData)) {
            return false;
        }
        ProductLocalData productLocalData = (ProductLocalData) obj;
        return Intrinsics.areEqual(this.type, productLocalData.type) && Intrinsics.areEqual(this.title, productLocalData.title) && Intrinsics.areEqual(this.product, productLocalData.product) && Intrinsics.areEqual(this.products, productLocalData.products) && Intrinsics.areEqual(this.moreCard, productLocalData.moreCard);
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Product product2 = this.product;
        int hashCode3 = (hashCode2 + (product2 != null ? product2.hashCode() : 0)) * 31;
        Product[] productArr = this.products;
        int hashCode4 = (hashCode3 + (productArr != null ? Arrays.hashCode(productArr) : 0)) * 31;
        Entity entity = this.moreCard;
        if (entity != null) {
            i = entity.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ProductLocalData(type=" + this.type + ", title=" + this.title + ", product=" + this.product + ", products=" + Arrays.toString(this.products) + ", moreCard=" + this.moreCard + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.product, i);
        Product[] productArr = this.products;
        if (productArr != null) {
            parcel.writeInt(1);
            int length = productArr.length;
            parcel.writeInt(length);
            for (int i2 = 0; length > i2; i2++) {
                parcel.writeParcelable(productArr[i2], i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.moreCard, i);
    }

    public ProductLocalData(String str, String str2, Product product2, Product[] productArr, Entity entity) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.type = str;
        this.title = str2;
        this.product = product2;
        this.products = productArr;
        this.moreCard = entity;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductLocalData(String str, String str2, Product product2, Product[] productArr, Entity entity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : product2, (i & 8) != 0 ? null : productArr, (i & 16) != 0 ? null : entity);
    }

    public final Product getProduct() {
        return this.product;
    }

    public final Product[] getProducts() {
        return this.products;
    }

    public final Entity getMoreCard() {
        return this.moreCard;
    }
}
