package com.filter;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class IpFilter implements Filter {

    //用来存放允许访问的ip
    private List<String> allowList = new ArrayList<String>();

    @Override
    public void init(FilterConfig arg0) {
        try {
            System.out.println("过滤器IpFilter开始初始化，功能：IP访问限制");
            initConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {


        //获取访问的IP地址
        String remoteAddr = request.getRemoteAddr();
//        System.out.println(request.getRemoteAddr());
        System.out.println("IP:" + remoteAddr);
        //如果allowList为空,则认为没做限制,不为空则检查是否限制
        if (allowList.size() == 0 || allowList == null) {
            filterChain.doFilter(request, response);
        } else {
            //访问标志，默认为false，限制访问
            Boolean flag = false;
            //进行逐个检查
            for (String regex : allowList) {
                if (remoteAddr.matches(regex)) {
                    //ip没被限制，正常访问
                    filterChain.doFilter(request, response);
                    //置为true，表示不限制访问
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                //ip被限制，直接返回
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter out = response.getWriter();
                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("requestID", encrypt(remoteAddr));
                jsonObject.put("code", "3000");
                jsonObject.put("message", "非法ip:" + remoteAddr);
                jsonObject.put("params", "[]");
                out.append(jsonObject.toString());
            }
        }

    }

    @Override
    public void destroy() {
        System.out.println("过滤器IpFilter结束。");
    }

    public void initConfig() throws IOException {

    }


}

