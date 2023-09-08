package com.kemi.actable.entity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/09/07  23:30
 */
@Data
@Table(name ="Initerary")
@TableName("Initerary")
public class Initerary extends SuperEntity implements Serializable {

    public void setRideRecords(List<IniteraryRecord> rideRecords) {
        this.rideRecords = rideRecords;
    }

    // 发票图片地址
    @Column(name = "url")
    @TableField(value = "url")
    private String url;

    // 服务提供商
    @Column(name = "serviceProvider")
    @TableField(value = "serviceProvider")
    private String serviceProvider;
    // 申请日期
    @Column(name = "applicationDate")
    @TableField(value = "applicationDate")
    private String applicationDate;
    // 开始时间
    @Column(name = "startTime")
    @TableField(value = "startTime")
    private String startTime;
    // 结束时间
    @Column(name = "endTime")
    @TableField(value = "endTime")
    private String endTime;
    // 电话号码
    @Column(name = "phoneNumber")
    @TableField(value = "phoneNumber")
    private String phoneNumber;
    // 总金额
    @Column(name = "totalAmount")
    @TableField(value = "totalAmount")
    private Double totalAmount;

    private List<IniteraryRecord> rideRecords;
}