package com.ligang.whiteelephant.dao;

import com.ligang.whiteelephant.entity.home.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer> {
    @Query("SELECT a FROM Activity a")
    public List<Activity> selectActivity();
}

