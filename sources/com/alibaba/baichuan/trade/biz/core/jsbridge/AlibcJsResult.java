package com.alibaba.baichuan.trade.biz.core.jsbridge;

import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;

public class AlibcJsResult {
    public static final String APP_NOT_INSTALL = "8";
    public static final String CLOSED = "7";
    public static final String FAIL = "6";
    public static final String NO_METHOD = "1";
    public static final String NO_PERMISSION = "4";
    public static final String PARAM_ERR = "2";
    public static final AlibcJsResult RET_CLOSED = new AlibcJsResult("7");
    public static final AlibcJsResult RET_FAIL = new AlibcJsResult("6");
    public static final AlibcJsResult RET_NO_METHOD = new AlibcJsResult("1");
    public static final AlibcJsResult RET_NO_PERMISSION = new AlibcJsResult("4");
    public static final AlibcJsResult RET_PARAM_ERR = new AlibcJsResult("2");
    public static final AlibcJsResult RET_SUCCESS = new AlibcJsResult("0");
    public static final String SUCCESS = "0";
    public static final String TIMEOUT = "5";
    public static final String UNKNOWN_ERR = "3";
    private JSONObject a = new JSONObject();
    private String b = "6";
    private String c = "";

    public AlibcJsResult() {
    }

    public AlibcJsResult(String str) {
        setResultMsg(str);
    }

    public void addData(String str, Object obj) {
        this.a.put(str, obj);
    }

    public String getErrorMessage(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c2 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 3;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c2 = 4;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c2 = 5;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c2 = 6;
                    break;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "BC_SUCCESS";
            case 1:
                return "BC_NO_HANDLER";
            case 2:
                return "BC_PARAM_ERR";
            case 3:
                return "BC_UNKNOWN_ERR";
            case 4:
                return "BC_NO_PERMISSION";
            case 5:
                return "BC_TIMEOUT";
            case 6:
                return "BC_FAILED";
            case 7:
                return "BC_CLOSED";
            default:
                return "BC_UNKNOWN";
        }
    }

    public void setResultCode(String str) {
        this.b = str;
        this.c = getErrorMessage(str);
    }

    public void setResultMsg(String str) {
        this.c = str;
    }

    public void setSuccess() {
        this.b = "0";
        this.c = getErrorMessage("0");
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", (Object) this.b);
            jSONObject.put("msg", (Object) this.c);
            jSONObject.put("data", (Object) this.a);
        } catch (Exception e) {
            AlibcLogger.e("alibc", e.getMessage());
        }
        return jSONObject.toString();
    }
}
