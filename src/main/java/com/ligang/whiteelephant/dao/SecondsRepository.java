package com.ligang.whiteelephant.dao;

import com.ligang.whiteelephant.entity.home.Seconds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondsRepository extends JpaRepository<Seconds,Integer> {
    @Query("SELECT a from Seconds a")
    public List<Seconds> selectSeconds();
}
