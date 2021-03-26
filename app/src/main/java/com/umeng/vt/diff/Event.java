package com.umeng.vt.diff;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.tunnel.UMChannelAgent;
import com.umeng.vt.diff.util.ClassLoadUtil;
import java.lang.reflect.Method;
import java.util.Map;

public class Event {
    private static final int MAX_PROPERTY_LENGTH = 128;

    public static void init(Context context, String str, String str2, int i, String str3) {
    }

    public static void openDebug(String str) {
    }

    public static void commit(Context context, View view, String str, Map<String, Object> map, Boolean bool) {
        if (!bool.booleanValue()) {
            if (view != null) {
                String textPropertyFromView = textPropertyFromView(view);
                if (!TextUtils.isEmpty(textPropertyFromView)) {
                    map.put("_$!text", textPropertyFromView);
                }
                map.put("_$!pg", view.getContext().getClass().getName());
            } else {
                map.put("_$!pg", context.getClass().getName());
            }
            map.put("_$!style", 1);
            map.put("_$!uapp_pg", getPageName());
            UMRTLog.e("MobclickRT", "release:事件名: " + str);
            if (map.containsKey("_$!text")) {
                UMRTLog.e("MobclickRT", "release:事件名: " + str + "; 参数：" + ((String) map.get("_$!text")));
            }
            if (map.containsKey("_$!pg")) {
                UMRTLog.e("MobclickRT", "release:事件名: " + str + "; 页面：" + ((String) map.get("_$!pg")));
            }
            if (map.containsKey("_$!uapp_pg")) {
                UMRTLog.e("MobclickRT", "release:事件名: " + str + "; UApp页面路径：" + ((String) map.get("_$!uapp_pg")));
            }
            MobclickAgent.onEventObject(context, str, map);
        } else if (UMChannelAgent.init()) {
            if (view != null) {
                String textPropertyFromView2 = textPropertyFromView(view);
                if (!TextUtils.isEmpty(textPropertyFromView2)) {
                    map.put("_$!text", textPropertyFromView2);
                }
                map.put("_$!pg", view.getContext().getClass().getName());
            } else {
                map.put("_$!pg", context.getClass().getName());
            }
            map.put("_$!style", 1);
            map.put("_$!uapp_pg", getPageName());
            UMRTLog.e("MobclickRT", "config:事件名: " + str);
            if (map.containsKey("_$!text")) {
                UMRTLog.e("MobclickRT", "config:事件名: " + str + "; 参数：" + ((String) map.get("_$!text")));
            }
            if (map.containsKey("_$!pg")) {
                UMRTLog.e("MobclickRT", "config:事件名: " + str + "; 页面：" + ((String) map.get("_$!pg")));
            }
            if (map.containsKey("_$!uapp_pg")) {
                UMRTLog.e("MobclickRT", "config:事件名: " + str + "; UApp页面路径：" + ((String) map.get("_$!uapp_pg")));
            }
            UMChannelAgent.onDebugEvent(context, str, map);
        }
    }

    private static void reflectTrack(Context context, String str, Map<String, Object> map) {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.analytics.MobclickAgent");
            if (findClass != null && (method = findClass.getMethod("onEvent", Context.class, String.class, Map.class)) != null) {
                method.invoke(null, context, str, map);
            }
        } catch (Exception unused) {
        }
    }

    private static String textPropertyFromView(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                return text.toString();
            }
            return null;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount && sb.length() < 128; i++) {
                String textPropertyFromView = textPropertyFromView(viewGroup.getChildAt(i));
                if (textPropertyFromView != null && textPropertyFromView.length() > 0) {
                    if (z) {
                        sb.append(", ");
                    }
                    sb.append(textPropertyFromView);
                    z = true;
                }
            }
            if (sb.length() > 128) {
                return sb.substring(0, 128);
            }
            if (z) {
                return sb.toString();
            }
            return null;
        }
    }

    public static String getPageName(View view) {
        String pageName = getPageName();
        if (pageName != null && !pageName.equals("") && !pageName.equals("VT")) {
            return pageName;
        }
        String activityName = getActivityName(view);
        if (activityName == null || activityName.equals("")) {
            return "VT";
        }
        return activityName;
    }

    public static String getActivityName(View view) {
        Context context;
        if (view == null || (context = view.getContext()) == null) {
            return null;
        }
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return context.getClass().getCanonicalName();
        }
        return null;
    }

    public static String getPageName() {
        String currenPageName = PageNameMonitor.getInstance().getCurrenPageName();
        return TextUtils.isEmpty(currenPageName) ? "" : currenPageName;
    }
}
