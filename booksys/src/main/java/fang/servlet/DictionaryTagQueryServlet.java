package fang.servlet;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-06 20-06-44
 **/

import fang.dao.DictionaryTagDAO;
import fang.model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/dict/tag/query")
public class DictionaryTagQueryServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = DictionaryTagDAO.query(key);
        return tags;
    }
}
