package mx.com.example.services.service.impl;

import mx.com.example.model.UserDO;
import mx.com.example.persistence.UserDAO;
import mx.com.example.services.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public void saveUser(UserDO user) {
        userDAO.save(user);
    }

    @Override
    public List<UserDO> getUsers() {
       return (List<UserDO>) userDAO.findAll();
    }
}
