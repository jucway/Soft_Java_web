package main.java;

import java.sql.SQLException;
import java.util.List;

public class testDao {
    private static int id = 1;
    private int row = 1;
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();
        List<entry.Users> list = userDao.findAllUsers();


        for (entry.Users users : list)
        {
            System.out.println(users.getId()+','+users.getUsername()+","+users.getPassword());
        }


        // 添加数据
//        entry.Users user = new entry.Users();
//        user.setUsername("jucw");
//        user.setPassword("1323");
//        int row = userDao.addUser(user);
//        System.out.println("\t 第"+row+"行添加数据！！！");

        // 删除
//        entry.Users user = userDao.findUsersById(id);
//        int row = userDao.updateUser(user);
//        System.out.println("\t 成功删除第"+row+"行数据！！！");


        // 修改密码数据
//        int id = 3;
//        entry.Users user = userDao.findUsersById(id); // 查找到用户的Id
//        user.setPassword("5201314");
//        int row = userDao.updateUser(user);
//        System.out.println("\t 更新第"+row+"行数据成功");

        // 查找id
//        int id = 3;
//        entry.Users user = userDao.findUsersById(id); // 查找id返回user
//        System.out.println(user.getUsername()+','+user.getPassword());



    }
}
