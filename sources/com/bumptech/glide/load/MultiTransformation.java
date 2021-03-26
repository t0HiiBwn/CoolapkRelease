package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> transformations;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length != 0) {
            this.transformations = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public MultiTransformation(Collection<? extends Transformation<T>> collection) {
        if (!collection.isEmpty()) {
            this.transformations = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<T> transform(Context context, Resource<T> resource, int i, int i2) {
        Iterator<? extends Transformation<T>> it2 = this.transformations.iterator();
        Resource<T> resource2 = resource;
        while (it2.hasNext()) {
            Resource<T> transform = ((Transformation) it2.next()).transform(context, resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform)) {
                resource2.recycle();
            }
            resource2 = transform;
        }
        return resource2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.transformations.equals(((MultiTransformation) obj).transformations);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.transformations.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Iterator<? extends Transformation<T>> it2 = this.transformations.iterator();
        while (it2.hasNext()) {
            ((Transformation) it2.next()).updateDiskCacheKey(messageDigest);
        }
    }
}
