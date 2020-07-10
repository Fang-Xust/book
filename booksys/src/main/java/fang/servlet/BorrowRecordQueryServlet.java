package fang.servlet;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-06 18-57-25
 **/

import fang.dao.BorrowRecordDAO;
import fang.model.BorrowRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/borrowRecord/query")
public class BorrowRecordQueryServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<BorrowRecord> records = BorrowRecordDAO.query();
        return records;
    }
}
