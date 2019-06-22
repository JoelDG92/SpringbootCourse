package mx.com.example.services.facade.impl;

import mx.com.example.commons.to.UserTO;
import mx.com.example.model.UserDO;
import mx.com.example.services.facade.IUserFacade;
import mx.com.example.services.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IUserFacadeImpl implements IUserFacade {
    @Autowired
    IUserService userService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveUser(UserTO userTO) {
        UserDO userDO = modelMapper.map(userTO, UserDO.class);
        userService.saveUser(userDO);
    }

    @Override
    public List<UserTO> getUser() {
       List<UserDO>userDOList= userService.getUsers();
        return userDOList.stream().map(x->{
            UserTO userTO = new UserTO();
            userTO.setName(x.getName());
            userTO.setLastName(x.getLastName());
            userTO.setAge(x.getAge());
            userTO.setId(x.getId());
            return userTO;
        }).collect(Collectors.toList());
    }
}
