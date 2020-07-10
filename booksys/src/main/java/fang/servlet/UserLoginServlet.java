package fang.servlet;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-03 18-33-13
 **/

import fang.dao.UserDAO;
import fang.exception.BusinessException;
import fang.model.User;
import fang.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/login")
//后端这里要加  /
public class UserLoginServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //req.getParameter("")这个方式只能获取url和请求体，k = v 形式的数据
        User user = JSONUtil.read(req.getInputStream(), User.class);//http请求解析的用户数据
        User queryUser = UserDAO.query(user);//通过请求的用户名密码在数据库查询，获取查询的用户信息
        if(queryUser == null)
            throw new BusinessException("00001", "用户名密码校验失败！");
        HttpSession session = req.getSession();
        session.setAttribute("user", queryUser);
        return null;
    }
}
