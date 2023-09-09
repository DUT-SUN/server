package com.kemi.actable.entity;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/09/09  0:14
 */
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

@Data
@Table(name = "PaymentDetail")
@TableName("PaymentDetail")
public class PaymentDetail extends SuperEntity implements Serializable {
    // 总支付金额
    @Column(name = "totalPaymentAmount")
    @TableField(value = "totalPaymentAmount")
    private Double totalPaymentAmount;
    // 起始地点
    @Column(name = "startingLocation")
    @TableField(value = "startingLocation")
    private String startingLocation;
    // 终止地点
    @Column(name = "endingLocation")
    @TableField(value = "endingLocation")
    private String endingLocation;
}
