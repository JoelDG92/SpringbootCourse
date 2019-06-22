package mx.com.example.services.facade.impl;

import mx.com.example.commons.exceptions.BusinessException;
import mx.com.example.commons.to.UserTO;
import mx.com.example.model.UserDO;
import mx.com.example.services.facade.IUserFacade;
import mx.com.example.services.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
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
        save(userTO);
    }

    @Override
    public List<UserTO> getUser(int page,int size,String property,String direction) {
       List<UserDO>userDOList= userService.getUsers(page, size, property, direction);

       //model mapper mientras los campos se llamana iguales realiza una transformacion directo
        Type userDOType= new TypeToken<List<UserDO>>(){}.getType();
        return modelMapper.map(userDOList,userDOType);

        /*
        manera 1 de hacer
        return userDOList.stream().map(x->{
            UserTO userTO = new UserTO();
            userTO.setName(x.getName());
            userTO.setLastName(x.getLastName());
            userTO.setAge(x.getAge());
            userTO.setId(x.getId());
            return userTO;
        }).collect(Collectors.toList());
    */
    }


    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @Override
    public void updateUser(UserTO userTO) {
        if( !(userService.validateIfExist(userTO.getId()))){
            throw new IllegalArgumentException("id no valido");
        }
        save(userTO);
    }

    private void save(UserTO userTO) {
        UserDO userDO = modelMapper.map(userTO, UserDO.class);
        userService.saveUser(userDO);
    }
}
