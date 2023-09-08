package com.kemi.actable.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kemi.actable.entity.Initerary;
import com.kemi.actable.entity.IniteraryRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/09/07  23:53
 */
@Mapper
public interface IniteraryMapper extends BaseMapper<Initerary> {
    @Insert("INSERT INTO IniteraryRecord (Initerary_ID, Number, amount, carType, city, endPlace, mileage, pickUpTime, remarks, startPlace) VALUES (#{Initerary_ID}, #{Number}, #{amount}, #{carType}, #{city}, #{endPlace}, #{mileage}, #{pickUpTime}, #{remarks}, #{startPlace})")
    void insertIniteraryRecord(IniteraryRecord initeraryRecord);
}
