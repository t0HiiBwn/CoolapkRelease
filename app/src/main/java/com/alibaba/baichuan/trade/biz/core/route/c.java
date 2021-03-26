package com.alibaba.baichuan.trade.biz.core.route;

import com.alibaba.baichuan.trade.biz.core.config.model.ActionDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ParamDO;
import com.alibaba.baichuan.trade.biz.core.config.model.RouteConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback;
import com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c implements ConfigParse {
    private ConfigParse a;

    @Override // com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse
    public UrlRequest handleParse(ConfigDO configDO, UrlRequest urlRequest, RequestBuildCallback requestBuildCallback, ParseCallback parseCallback) {
        String url = urlRequest.getUrl();
        if (url == null || url.length() == 0) {
            requestBuildCallback.onBuildFail(1600);
            return null;
        }
        if (configDO != null) {
            ArrayList arrayList = new ArrayList();
            for (RouteConfigDO routeConfigDO : configDO.getRouteConfig()) {
                int[] index = routeConfigDO.getIndex();
                Matcher matcher = Pattern.compile(routeConfigDO.getMatch()).matcher(url);
                if (matcher.find()) {
                    for (int i : index) {
                        if (i <= matcher.groupCount()) {
                            arrayList.add(matcher.group(i));
                        }
                    }
                    List<ActionDO> action = routeConfigDO.getAction();
                    for (ActionDO actionDO : action) {
                        ParamDO param = actionDO.getParam();
                        String targetPath = param.getTargetPath();
                        if (!(targetPath == null || targetPath.length() == 0)) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                targetPath = targetPath.replace("{" + i2 + "}", (CharSequence) arrayList.get(i2));
                            }
                        }
                        param.setTargetPath(targetPath);
                        actionDO.setParam(param);
                    }
                    urlRequest.setActionPriorityList(action);
                    return urlRequest;
                }
            }
        } else {
            requestBuildCallback.onBuildFail(1100);
        }
        return null;
    }

    @Override // com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse
    public void setSuccessor(ConfigParse configParse) {
        this.a = configParse;
    }
}
