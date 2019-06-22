package mx.com.example.services.service;

import mx.com.example.model.UserDO;

import java.util.List;

public interface IUserService {
    void saveUser(UserDO user);
    List<UserDO> getUsers();
}
