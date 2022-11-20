package com.dika.simplecrud.service;

import com.dika.simplecrud.dto.DataReq;
import com.dika.simplecrud.dto.UserBodyReq;
import com.dika.simplecrud.entity.UserEntity;
import com.dika.simplecrud.exception.ResourceNotFoundException;
import com.dika.simplecrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity userBodyReq) {
        return userRepository.save(userBodyReq);
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public void delete(int id) {
        userRepository.deleteById(Long.parseLong(String.valueOf(id)));
    }

    public void deleteByName(String name) {
        var u= userRepository.findByName(name);
        if (u==null) {
            throw new ResourceNotFoundException("Error");
        }
        userRepository.deleteUserEntitiesByName(name);
    }

    public void update(int id, DataReq body, String email) {
        var u= userRepository.findById(Long.parseLong(String.valueOf(id)));
        if (u.isEmpty()) {
            throw new ResourceNotFoundException("Error");
        }
        var ue = u.get();
        ue.setName(body.getName());
        ue.setEmail(email);
        userRepository.save(ue);
    }
}
