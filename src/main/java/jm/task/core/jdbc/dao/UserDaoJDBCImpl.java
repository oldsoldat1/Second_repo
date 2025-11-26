package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;
import java.util.SimpleTimeZone;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String create = "";

    }

    public void dropUsersTable() {

        String drop = "";

    }

    public void saveUser(String name, String lastName, byte age) {
        String save = "";
    }

    public void removeUserById(long id) {
        String remove = "";
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        String clean = "";

    }
}
