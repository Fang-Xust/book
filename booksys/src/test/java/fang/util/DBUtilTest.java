package fang.util;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-03 20-58-40
 **/

import org.junit.Assert;
import org.junit.Test;

public class DBUtilTest {
    @Test
    public void test(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
