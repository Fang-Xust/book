package fang.filter;/*
 * @Program:book-sys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-10 19-43-40
 **/

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String uri = req.getServletPath();
//        if(!"/login.html".equals(uri) && !uri.startsWith("/public/") && !uri.startsWith("/static/")
//                && !"/user/login".equals(uri)){
//            HttpSession session = req.getSession(false);
//            if(session == null){//访问敏感资源，没有登录，需要跳转到登录页面
//                String schema = req.getScheme();//http
//                String host = req.getServerName();//服务器ip域名
//                int port = req.getServerPort();//服务器端口号
//                String contextPath = req.getContextPath();
//                String basePath = schema + "://" + host + ":" + port + contextPath;
//                ((HttpServletResponse)servletResponse).sendRedirect(basePath + "/public/index.html");
//                return;
//            }
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
        if("/login.html".equals(uri) || uri.startsWith("/public/") || uri.startsWith("/static/")
                || "/user/login".equals(uri)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            HttpSession session = req.getSession(false);
            if(session == null){//访问敏感资源，没有登录，需要跳转到登录页面
                String schema = req.getScheme();//http
                String host = req.getServerName();//服务器ip域名
                int port = req.getServerPort();//服务器端口号
                String contextPath = req.getContextPath();
                String basePath = schema + "://" + host + ":" + port + contextPath;
                ((HttpServletResponse)servletResponse).sendRedirect(basePath + "/public/index.html");
                return;
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
