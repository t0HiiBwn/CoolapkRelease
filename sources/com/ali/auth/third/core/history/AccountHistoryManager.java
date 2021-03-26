package com.ali.auth.third.core.history;

import android.text.TextUtils;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.HistoryAccount;
import com.ali.auth.third.core.service.StorageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountHistoryManager {
    private static volatile AccountHistoryManager a;

    private AccountHistoryManager() {
    }

    private String a(List<HistoryAccount> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (HistoryAccount historyAccount : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userId", historyAccount.userId);
                jSONObject.put("tokenKey", historyAccount.tokenKey);
                jSONObject.put("nick", historyAccount.nick);
                jSONObject.put("email", historyAccount.email);
                jSONObject.put("mobile", historyAccount.mobile);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
        return jSONArray.toString();
    }

    private List<HistoryAccount> a(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                HistoryAccount historyAccount = new HistoryAccount();
                historyAccount.userId = jSONObject.optString("userId");
                historyAccount.tokenKey = jSONObject.optString("tokenKey");
                historyAccount.mobile = jSONObject.optString("mobile");
                historyAccount.nick = jSONObject.optString("nick");
                historyAccount.email = jSONObject.optString("email");
                arrayList.add(historyAccount);
            }
        }
        return arrayList;
    }

    public static AccountHistoryManager getInstance() {
        if (a == null) {
            synchronized (AccountHistoryManager.class) {
                if (a == null) {
                    a = new AccountHistoryManager();
                }
            }
        }
        return a;
    }

    public HistoryAccount findHistoryAccount(String str) {
        try {
            List<HistoryAccount> historyAccounts = getHistoryAccounts();
            if (historyAccounts != null) {
                for (HistoryAccount historyAccount : historyAccounts) {
                    if (historyAccount.userId != null && historyAccount.userId.equals(str)) {
                        return historyAccount;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public List<HistoryAccount> getHistoryAccounts() {
        String dDpExValue = ((StorageService) KernelContext.getService(StorageService.class)).getDDpExValue("taesdk_history_acounts");
        if (TextUtils.isEmpty(dDpExValue)) {
            return new ArrayList();
        }
        try {
            return a(dDpExValue);
        } catch (JSONException unused) {
            ArrayList arrayList = new ArrayList();
            ((StorageService) KernelContext.getService(StorageService.class)).removeDDpExValue("taesdk_history_acounts");
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0010  */
    public HistoryAccount matchHistoryAccount(String str) {
        List<HistoryAccount> historyAccounts = getHistoryAccounts();
        if (historyAccounts == null) {
            return null;
        }
        for (HistoryAccount historyAccount : historyAccounts) {
            if (TextUtils.equals(str, historyAccount.nick) || TextUtils.equals(str, historyAccount.email) || TextUtils.equals(str, historyAccount.mobile)) {
                return historyAccount;
            }
            while (r0.hasNext()) {
            }
        }
        return null;
    }

    public void putLoginHistory(HistoryAccount historyAccount, String str) {
        String str2;
        if (!ConfigManager.getInstance().isSaveHistoryWithSalt() || ((StorageService) KernelContext.getService(StorageService.class)).saveSafeToken(historyAccount.tokenKey, str)) {
            List<HistoryAccount> historyAccounts = getHistoryAccounts();
            if (historyAccounts != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(historyAccount);
                for (HistoryAccount historyAccount2 : historyAccounts) {
                    if (arrayList.size() >= ConfigManager.getInstance().getMaxHistoryAccount()) {
                        break;
                    } else if (TextUtils.isEmpty(historyAccount2.userId) || !historyAccount2.userId.equals(historyAccount.userId)) {
                        arrayList.add(historyAccount2);
                    }
                }
                str2 = a(arrayList);
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(historyAccount);
                str2 = a(arrayList2);
            }
            ((StorageService) KernelContext.getService(StorageService.class)).putDDpExValue("taesdk_history_acounts", str2);
        }
    }

    public void removeHistoryAccount(HistoryAccount historyAccount) {
        ArrayList arrayList;
        String dDpExValue;
        if (historyAccount != null) {
            try {
                ((StorageService) KernelContext.getService(StorageService.class)).removeSafeToken(historyAccount.tokenKey);
                try {
                    dDpExValue = ((StorageService) KernelContext.getService(StorageService.class)).getDDpExValue("taesdk_history_acounts");
                } catch (Exception unused) {
                }
                try {
                    arrayList = TextUtils.isEmpty(dDpExValue) ? new ArrayList() : a(dDpExValue);
                } catch (JSONException e) {
                    e.printStackTrace();
                    try {
                        Properties properties = new Properties();
                        properties.setProperty("errorCode", "80005");
                        properties.setProperty("cause", "JSONException: " + dDpExValue);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    arrayList = new ArrayList();
                    ((StorageService) KernelContext.getService(StorageService.class)).removeDDpExValue("taesdk_history_acounts");
                }
                if (arrayList != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (HistoryAccount historyAccount2 : arrayList) {
                        if (!historyAccount2.userId.equals(historyAccount.userId)) {
                            arrayList2.add(historyAccount2);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (arrayList == null) {
                    return;
                }
                if (arrayList == null || arrayList.isEmpty()) {
                    ((StorageService) KernelContext.getService(StorageService.class)).removeDDpExValue("taesdk_history_acounts");
                } else {
                    ((StorageService) KernelContext.getService(StorageService.class)).putDDpExValue("taesdk_history_acounts", a(arrayList));
                }
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    Properties properties2 = new Properties();
                    properties2.setProperty("errorCode", "80005");
                    properties2.setProperty("cause", "Throwable: " + th);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
