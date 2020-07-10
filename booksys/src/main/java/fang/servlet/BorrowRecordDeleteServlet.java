package fang.servlet;/*
 * @Program:book-sys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-10 20-27-49
 **/

import fang.dao.BorrowRecordDAO;
import fang.exception.BusinessException;
import fang.model.BorrowRecord;
import fang.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/borrowRecord/delete")
public class BorrowRecordDeleteServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] ids = req.getParameterValues("ids");//ids=4&ids=5....
        int num = BorrowRecordDAO.delete(ids);
        if(num != ids.length)
            throw new BusinessException("00010", "删除图书借阅信息数量异常");
        return null;
    }
}
