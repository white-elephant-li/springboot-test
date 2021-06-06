package com.ligang.whiteelephant.dao.user;

import com.ligang.whiteelephant.entity.user.Administrator;
import com.ligang.whiteelephant.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer> {
    @Query("SELECT a FROM Administrator a")
    public List<Administrator> selectAllAdmin();

    @Query("SELECT a FROM Administrator a WHERE a.username = ?1 AND a.password = ?2")
    public Administrator selectAdminWithPassword(String username,String password);

    @Query("SELECT a FROM Administrator a WHERE a.username = ?1")
    public Administrator selectAdminByName(String username);

    @Query("SELECT a.id FROM Administrator a WHERE a.username = ?1")
    public int selectAdminByNameToId(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Administrator a SET a.loginTime=?1,a.sessionId =?2 where a.id=?3")
    public void updateAdminById(String time, String sessionId , int id);

    @Transactional
    @Modifying
    @Query("UPDATE Administrator a SET a.username=?1,a.password=?2 where a.id=?3")
    public void updateAdminByIdWithUP(String username,String password,int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Administrator a where a.id = ?1")
    public void deleteAdminById(int id);

    @Query("SELECT a FROM Administrator a WHERE a.id = ?1")
    public Administrator selectAdminById(int id);
}
