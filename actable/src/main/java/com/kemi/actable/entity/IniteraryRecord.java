package com.kemi.actable.entity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/09/07  23:31
 */
@Data
@Table(name ="IniteraryRecord")
@TableName("IniteraryRecord")
public class IniteraryRecord extends SuperEntity implements Serializable {
    //所属行程单id
    @Column(name="Initerary_ID")
    @TableField(value = "Initerary_ID")
    private Integer Initerary_ID;
    // 乘车次数
    @Column(name = "Number")
    @TableField(value = "Number")
    private Integer Number;
    // 金额
    @Column(name = "amount")
    @TableField(value = "amount")
    private Double amount;
    // 车型
    @Column(name = "carType")
    @TableField(value = "carType")
    private String carType;
    // 城市
    @Column(name = "city")
    @TableField(value = "city")
    private String city;
    // 终点
    @Column(name = "endPlace")
    @TableField(value = "endPlace")
    private String endPlace;
    // 里程
    @Column(name = "mileage")
    @TableField(value = "mileage")
    private Double mileage;
    // 接送时间
    @Column(name = "pickUpTime")
    @TableField(value = "pickUpTime")
    private String pickUpTime;
    // 备注
    @Column(name = "remarks")
    @TableField(value = "remarks")
    private String remarks;
    // 起点
    @Column(name = "startPlace")
    @TableField(value = "startPlace")
    private String startPlace;
}
