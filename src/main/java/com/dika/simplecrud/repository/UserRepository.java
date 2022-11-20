package com.dika.simplecrud.repository;

import com.dika.simplecrud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String name);
    public void deleteUserEntitiesByName(String name);
}
