package mx.com.example.services.facade;

import mx.com.example.commons.to.UserTO;

import java.util.List;

public interface IUserFacade {
    void saveUser(UserTO userTO);
     List<UserTO> getUser();
}
