package com.facebook.stetho.common;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class ListUtil {

    private interface ImmutableList<E> extends List<E>, RandomAccess {
    }

    private ListUtil() {
    }

    public static <T> boolean identityEquals(List<? extends T> list, List<? extends T> list2) {
        if (list == list2) {
            return true;
        }
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static <T> List<T> copyToImmutableList(List<T> list) {
        if (list instanceof ImmutableList) {
            return list;
        }
        int size = list.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        if (size == 1) {
            return new OneItemImmutableList(list.get(0));
        }
        if (size == 2) {
            return new TwoItemImmutableList(list.get(0), list.get(1));
        }
        if (size == 3) {
            return new ThreeItemImmutableList(list.get(0), list.get(1), list.get(2));
        }
        if (size == 4) {
            return new FourItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3));
        }
        if (size != 5) {
            return new ImmutableArrayList(list.toArray());
        }
        return new FiveItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
    }

    public static <T> List<T> newImmutableList(T t) {
        return new OneItemImmutableList(t);
    }

    public static <T> List<T> newImmutableList(T t, T t2) {
        return new TwoItemImmutableList(t, t2);
    }

    private static final class ImmutableArrayList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final Object[] mArray;

        public ImmutableArrayList(Object[] objArr) {
            this.mArray = objArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            return (E) this.mArray[i];
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.mArray.length;
        }
    }

    private static final class OneItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem;

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return 1;
        }

        public OneItemImmutableList(E e) {
            this.mItem = e;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i == 0) {
                return this.mItem;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    private static final class TwoItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return 2;
        }

        public TwoItemImmutableList(E e, E e2) {
            this.mItem0 = e;
            this.mItem1 = e2;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i == 0) {
                return this.mItem0;
            }
            if (i == 1) {
                return this.mItem1;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    private static final class ThreeItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return 3;
        }

        public ThreeItemImmutableList(E e, E e2, E e3) {
            this.mItem0 = e;
            this.mItem1 = e2;
            this.mItem2 = e3;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i == 0) {
                return this.mItem0;
            }
            if (i == 1) {
                return this.mItem1;
            }
            if (i == 2) {
                return this.mItem2;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    private static final class FourItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return 4;
        }

        public FourItemImmutableList(E e, E e2, E e3, E e4) {
            this.mItem0 = e;
            this.mItem1 = e2;
            this.mItem2 = e3;
            this.mItem3 = e4;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i == 0) {
                return this.mItem0;
            }
            if (i == 1) {
                return this.mItem1;
            }
            if (i == 2) {
                return this.mItem2;
            }
            if (i == 3) {
                return this.mItem3;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    private static final class FiveItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;
        private final E mItem4;

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return 5;
        }

        public FiveItemImmutableList(E e, E e2, E e3, E e4, E e5) {
            this.mItem0 = e;
            this.mItem1 = e2;
            this.mItem2 = e3;
            this.mItem3 = e4;
            this.mItem4 = e5;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i == 0) {
                return this.mItem0;
            }
            if (i == 1) {
                return this.mItem1;
            }
            if (i == 2) {
                return this.mItem2;
            }
            if (i == 3) {
                return this.mItem3;
            }
            if (i == 4) {
                return this.mItem4;
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
