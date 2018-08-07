package test;

import com.yotwei.core.*;
import test.dao.UserDao;


/**
 * Created by YotWei on 2018/8/6.
 */
public class TestClient {

    public static void main(String[] args) {

        SqlSessionFactory factory = new SqlSessionFactory();
        SqlSession sqlSession = factory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        System.out.println(userDao.getUserInfo(3));
    }
}
