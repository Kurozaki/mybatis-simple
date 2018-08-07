package test.dao;

import test.entity.User;

/**
 * Created by YotWei on 2018/8/6.
 */
public interface UserDao {

    User getUserInfo(int id);

    int updateUserName(String newName, int id);

    int insertUser(int id, String name, int age, String addr);
}
