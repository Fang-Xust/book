package fang.servlet;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-07 14-26-31
 **/

import fang.dao.BookDAO;
import fang.model.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/book/queryAsDict")
public class BookQueryAsDictServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Book> books = BookDAO.queryAsDict();
        return books;
    }
}
