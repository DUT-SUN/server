package com.kemi.actable.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;
import java.io.Serializable;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/08/27  22:12
 */

@Data
@Table(name ="InvoiceDetails")
@TableName("InvoiceDetails")
public class InvoiceDetail extends SuperEntity implements Serializable {
  @Column(name="Invoice_ID")
  @TableField(value = "Invoice_ID")
  private Integer Invoice_ID;
  // 商品名称
  @Column(name = "itemName")
  @TableField(value="itemName")
  private String itemName;
  // 数量
  @Column(name = "quantity")
  @TableField(value="quantity")
  private Integer quantity;
  // 单价
  @Column(name = "unitPrice")
  @TableField(value="unitPrice")
  private Double unitPrice;
  // 规格型号
  @Column(name = "specification")
  @TableField(value="specification")
  private String specification;
  // 单位
  @Column(name = "unit")
  @TableField(value="unit")
  private String unit;
  // 金额
  @Column(name = "amount")
  @TableField(value="amount")
  private Double amount;
  // 税率
  @Column(name = "taxRate")
  @TableField(value="taxRate")
  private String taxRate;
  // 税额
  @Column(name = "tax")
  @TableField(value="tax")
  private String tax;
}
