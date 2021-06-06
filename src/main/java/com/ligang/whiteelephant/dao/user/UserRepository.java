package com.ligang.whiteelephant.dao.user;

import com.ligang.whiteelephant.entity.user.Administrator;
import com.ligang.whiteelephant.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT a FROM User a")
    public List<User> selectAllUser();

    @Query("SELECT a FROM User a WHERE a.username = ?1 AND a.password = ?2")
    public User selectUserWithPassword(String username,String password);

    @Query("SELECT a FROM User a WHERE a.username = ?1")
    public User selectUserByName(String username);

    @Query(value = "SELECT a.id, a.username, a.loginTime FROM User a")
    public List<Object> selectUserWithoutPass();

    @Query("SELECT a.id FROM User a WHERE a.username = ?1")
    public int selectUserByNameToId(String username);

    @Query("SELECT a FROM User a WHERE a.username = ?1")
    public User selectUserById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE User a SET a.loginTime=?1,a.sessionId =?2 where a.id=?3")
    public void updateUserByName(String time, String sessionId , int id);

    @Transactional
    @Modifying
    @Query("UPDATE User a SET a.password=?1 where a.id=?2")
    public void updatePassById(String password , int id);


    @Transactional
    @Modifying
    @Query("DELETE FROM User a WHERE a.id=?1")
    public void deleteUserById (int id);

}
