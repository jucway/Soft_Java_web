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


        // �������
//        entry.Users user = new entry.Users();
//        user.setUsername("jucw");
//        user.setPassword("1323");
//        int row = userDao.addUser(user);
//        System.out.println("\t ��"+row+"��������ݣ�����");

        // ɾ��
//        entry.Users user = userDao.findUsersById(id);
//        int row = userDao.updateUser(user);
//        System.out.println("\t �ɹ�ɾ����"+row+"�����ݣ�����");


        // �޸���������
//        int id = 3;
//        entry.Users user = userDao.findUsersById(id); // ���ҵ��û���Id
//        user.setPassword("5201314");
//        int row = userDao.updateUser(user);
//        System.out.println("\t ���µ�"+row+"�����ݳɹ�");

        // ����id
//        int id = 3;
//        entry.Users user = userDao.findUsersById(id); // ����id����user
//        System.out.println(user.getUsername()+','+user.getPassword());



    }
}
