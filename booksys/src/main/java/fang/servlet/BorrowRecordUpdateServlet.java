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


@WebServlet("/borrowRecord/update")
public class BorrowRecordUpdateServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        BorrowRecord record = JSONUtil.read(req.getInputStream(), BorrowRecord.class);
        int num = BorrowRecordDAO.update(record);
        if(num != 1)
            throw new BusinessException("00009", "修改图书借阅信息数量异常");
        return null;
    }
}
