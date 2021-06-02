package com.ligang.whiteelephant.dao.user;

import com.ligang.whiteelephant.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT a FROM User a")
    public List<User> selectAllUser();

    @Query("SELECT a FROM User a WHERE a.username = ?1 AND a.password = ?2")
    public User selectUserWithPassword(String username,String password);
}
