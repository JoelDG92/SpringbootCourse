package mx.com.example.services.facade;

import mx.com.example.commons.to.UserTO;
import org.apache.catalina.User;

import java.util.List;

public interface ICatalogosFacade {


    List<UserTO> getAllUsers();

    List<UserTO> getAllPageableUsers(int page, int size, String property, String direction);

    void saveUser(UserTO user);


}
