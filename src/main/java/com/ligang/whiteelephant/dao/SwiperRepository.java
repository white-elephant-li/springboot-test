package com.ligang.whiteelephant.dao;

import com.ligang.whiteelephant.entity.home.Swiper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwiperRepository extends JpaRepository<Swiper,Integer> {
    @Query("SELECT a FROM Swiper a")
    public List<Swiper> selectSwiper();
}
