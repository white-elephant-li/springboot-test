package com.ligang.whiteelephant.dao.user;

import com.ligang.whiteelephant.entity.user.Administrator;
import com.ligang.whiteelephant.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer> {
    @Query("SELECT a FROM Administrator a")
    public List<Administrator> selectAllAdmin();

    @Query("SELECT a FROM Administrator a WHERE a.username = ?1 AND a.password = ?2")
    public User selectAdminWithPassword(String username,String password);
}
