package com.bytedance.embedapplog;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class be {
    public static View a(MenuItem menuItem) {
        View a;
        if (menuItem == null) {
            return null;
        }
        bh.a();
        View[] b = bh.b();
        try {
            for (View view : b) {
                if (view.getClass() == bh.a && (a = a(view, menuItem)) != null) {
                    return a;
                }
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0126, code lost:
        if (r5 >= 0) goto L_0x0128;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0355  */
    public static ar a(View view) {
        Activity a;
        ArrayList arrayList;
        String str;
        ArrayList arrayList2;
        int i;
        String str2;
        String str3;
        String a2;
        String str4 = null;
        if (bf.b(view) || (a = bb.a(view.getContext())) == null) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList(8);
        arrayList3.add(view);
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            if (bf.b((View) parent)) {
                return null;
            }
            arrayList3.add((ViewGroup) parent);
        }
        int size = arrayList3.size() - 1;
        View view2 = (View) arrayList3.get(size);
        bh.a();
        String a3 = bh.a(view2);
        boolean z = false;
        if (!bh.b(view2) && !(view2.getParent() instanceof View)) {
            a3 = a3 + "/" + bf.a(view2.getClass());
            String a4 = bf.a(view2, false);
            if (a4 != null) {
                if (view2.getTag(84159242) != null) {
                    z = true;
                }
                a3 = a3 + "#" + a4;
            }
        }
        if (view2 instanceof ViewGroup) {
            String str5 = a3;
            boolean z2 = z;
            ViewGroup viewGroup = (ViewGroup) view2;
            String str6 = str5;
            int i2 = size - 1;
            ArrayList arrayList4 = null;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                View view3 = (View) arrayList3.get(i2);
                Object tag = view3.getTag(R.id.tag_view_name);
                if (tag != null) {
                    str5 = str5 + "/" + tag;
                    arrayList2 = arrayList3;
                    str6 = "/" + tag;
                } else {
                    String a5 = bf.a(view3.getClass());
                    int indexOfChild = viewGroup.indexOfChild(view3);
                    if (bc.e(viewGroup)) {
                        indexOfChild = ((ViewPager) viewGroup).getCurrentItem();
                    } else if (bc.d(viewGroup)) {
                        indexOfChild = ((ViewPager) viewGroup).getCurrentItem();
                    } else if (viewGroup instanceof AdapterView) {
                        indexOfChild += ((AdapterView) viewGroup).getFirstVisiblePosition();
                    } else if (bc.a(viewGroup)) {
                        i = a(view3, viewGroup);
                    }
                    i = indexOfChild;
                    if (viewGroup instanceof ExpandableListView) {
                        ExpandableListView expandableListView = (ExpandableListView) viewGroup;
                        long expandableListPosition = expandableListView.getExpandableListPosition(i);
                        arrayList2 = arrayList3;
                        if (ExpandableListView.getPackedPositionType(expandableListPosition) != 2) {
                            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                            int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                            if (packedPositionChild != -1) {
                                if (arrayList4 == null) {
                                    arrayList4 = new ArrayList(4);
                                }
                                arrayList4.add(String.valueOf(packedPositionGroup));
                                arrayList4.add(String.valueOf(packedPositionChild));
                                str2 = str6 + "/ELVG[" + packedPositionGroup + "]/ELVC[" + packedPositionChild + "]/" + ((Object) a5) + "[0]";
                                str3 = str5 + "/ELVG[-]/ELVC[-]/" + ((Object) a5) + "[0]";
                            } else {
                                if (arrayList4 == null) {
                                    arrayList4 = new ArrayList(4);
                                }
                                arrayList4.add(String.valueOf(packedPositionGroup));
                                str2 = str6 + "/ELVG[" + packedPositionGroup + "]/" + ((Object) a5) + "[0]";
                                str3 = str5 + "/ELVG[-]/" + ((Object) a5) + "[0]";
                            }
                        } else if (i < expandableListView.getHeaderViewsCount()) {
                            str2 = str6 + "/ELH[" + i + "]/" + ((Object) a5) + "[0]";
                            str3 = str5 + "/ELH[" + i + "]/" + ((Object) a5) + "[0]";
                        } else {
                            int count = i - (expandableListView.getCount() - expandableListView.getFooterViewsCount());
                            str2 = str6 + "/ELF[" + count + "]/" + ((Object) a5) + "[0]";
                            str3 = str5 + "/ELF[" + count + "]/" + ((Object) a5) + "[0]";
                        }
                    } else {
                        arrayList2 = arrayList3;
                        if (bf.a(viewGroup)) {
                            Object tag2 = viewGroup.getTag(84159247);
                            if (tag2 instanceof List) {
                                List list = (List) tag2;
                                if (list.size() > 0) {
                                    i = bf.a(list, i);
                                    str4 = bf.a((String) list.get(i));
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList(4);
                                    }
                                    arrayList4.add(String.valueOf(i));
                                    str3 = str5 + "/" + ((Object) a5) + "[-]";
                                    str2 = str6 + "/" + ((Object) a5) + "[" + i + "]";
                                    a2 = bf.a(view3, z2);
                                    if (a2 != null) {
                                        if (view3.getTag(84159242) != null) {
                                            z2 = true;
                                        }
                                        str2 = str2 + "#" + a2;
                                        str3 = str3 + "#" + a2;
                                    }
                                    str5 = str3;
                                    str6 = str2;
                                }
                            }
                            str4 = str4;
                            if (arrayList4 == null) {
                            }
                            arrayList4.add(String.valueOf(i));
                            str3 = str5 + "/" + ((Object) a5) + "[-]";
                            str2 = str6 + "/" + ((Object) a5) + "[" + i + "]";
                            a2 = bf.a(view3, z2);
                            if (a2 != null) {
                            }
                            str5 = str3;
                            str6 = str2;
                        } else if (bc.g(viewGroup) || bc.f(viewGroup)) {
                            str2 = str6 + "/" + ((Object) a5) + "[0]";
                            str3 = str5 + "/" + ((Object) a5) + "[0]";
                        } else {
                            str2 = str6 + "/" + ((Object) a5) + "[" + i + "]";
                            str3 = str5 + "/" + ((Object) a5) + "[" + i + "]";
                        }
                    }
                    str4 = str4;
                    a2 = bf.a(view3, z2);
                    if (a2 != null) {
                    }
                    str5 = str3;
                    str6 = str2;
                }
                if (!(view3 instanceof ViewGroup)) {
                    break;
                }
                i2--;
                viewGroup = (ViewGroup) view3;
                arrayList3 = arrayList2;
            }
            arrayList = arrayList4;
            str = str5;
        } else {
            arrayList = null;
            str = a3;
        }
        String b = f.b();
        if (TextUtils.isEmpty(b)) {
            b = a.getClass().getSimpleName();
        }
        int width = view.getWidth();
        int height = view.getHeight();
        return new ar(b, str, width, height, width / 2, height / 2, bf.a(view, str4), arrayList);
    }

    private static int a(View view, ViewGroup viewGroup) {
        if (bc.c(viewGroup)) {
            return ((RecyclerView) viewGroup).getChildAdapterPosition(view);
        }
        if (bc.b(viewGroup)) {
            try {
                return ((RecyclerView) viewGroup).getChildAdapterPosition(view);
            } catch (Throwable unused) {
                return ((RecyclerView) viewGroup).getChildPosition(view);
            }
        } else if (bc.a) {
            return bc.a(viewGroup, view);
        } else {
            return -1;
        }
    }

    private static View a(View view, MenuItem menuItem) {
        if (bh.c(view) == menuItem) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return null;
            }
            View a = a(viewGroup.getChildAt(i), menuItem);
            if (a != null) {
                return a;
            }
            i++;
        }
    }
}
