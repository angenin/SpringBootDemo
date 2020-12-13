package com.angenin.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @package_name: com.angenin.springboot.config
 * @name: MyLocaleResolver
 * @author: angenin
 * @dateTime: 2020/12/13 下午1:37
 **/
// 登录检查
public class MyLocaleResolver implements LocaleResolver {
    @Override   //解析区域信息
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求的l参数
        String l = httpServletRequest.getParameter("l");
        //默认的信息
        Locale locale = Locale.getDefault();
        //检测l参数是否为空
        if(!StringUtils.isEmpty(l)){
            //不为空
            String[] s = l.split("_");
            //第一个参数为语言代码，第二个参数为国家代码
            locale = new Locale(s[0], s[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
