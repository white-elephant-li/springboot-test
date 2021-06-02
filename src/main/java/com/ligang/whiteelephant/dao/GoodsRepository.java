package com.ligang.whiteelephant.dao;

import com.ligang.whiteelephant.entity.home.Goods_all.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer> {
    @Query("SELECT a FROM Goods a")
    public List<Goods> selectGoods();
}
