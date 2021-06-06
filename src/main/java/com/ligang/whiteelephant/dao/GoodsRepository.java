package com.ligang.whiteelephant.dao;

import com.ligang.whiteelephant.entity.home.Goods_all.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer> {
    @Query("SELECT a FROM Goods a")
    public List<Goods> selectGoods();

    @Query("SELECT max(a.id) FROM Goods a")
    public int selectMaxId();


    @Query("SELECT a FROM Goods a WHERE a.id=?1")
    public Goods selectGoodsById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Goods a set a.name =?1, a.price=?2, a.volume=?3 ,a.isHave=?4,a.isDirect=?5 where a.id = ?6")
    public void updateNameAndVo(String name,double price, int vol,boolean ishave,boolean isdirect,int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Goods a WHERE a.id =?1")
    public void deleteGoodsById(int id);

}
