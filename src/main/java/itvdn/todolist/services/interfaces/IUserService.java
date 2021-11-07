package itvdn.todolist.services.interfaces;

import itvdn.todolist.domain.User;

public interface IUserService {
    int createUser(User user);
    User getUser(long id);
    int updateUser(User user);
    int deleteUser(long id);
    void createTableUser();


}
