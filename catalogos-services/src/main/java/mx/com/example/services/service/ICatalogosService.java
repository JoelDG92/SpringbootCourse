package mx.com.example.services.service;

import mx.com.example.commons.to.UserTO;
import mx.com.example.model.UserDO;

import java.util.List;

public interface ICatalogosService {


    List<UserDO> getAllUsers();
}
