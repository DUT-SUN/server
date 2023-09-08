package com.kemi.actable.entity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;
import org.apache.ibatis.jdbc.Null;
import org.springframework.boot.context.properties.bind.DefaultValue;
import java.io.Serializable;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
//  发票类型
//1.增值税专用发票
//2.增值税普通发票（联式）
//3.增值税普通发票（卷式）
//4.机动车销售统一发票
//5.二手车销售统一发票 二、非增值税发票管理新系统


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;
import org.apache.ibatis.jdbc.Null;
import org.springframework.boot.context.properties.bind.DefaultValue;
import java.io.Serializable;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@Table(name ="Invoices")
@TableName("Invoices")
public class Invoices extends SuperEntity implements Serializable {

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    // 所属发票夹ID
    @Column(name = "Folders_id")
    private Integer Folders_id;
    // 发票图片地址
    @Column(name = "url")
    @TableField(value = "url")
    private String url;
    // 检查状态（未检查0,检查完成1，检查异常-1）
    @Column(name = "examine_state",defaultValue = "0")
    @TableField(value = "examine_state")
    private Integer examine_state;
    //上传方式(手动，导入）
    @Column(name = "Upload_mode")
    @TableField(value = "Upload_mode")
    private String Upload_mode;
    // 发票号码
    @Column(name = "invoiceNumber")
    @TableField(value = "invoiceNumber")
    private String invoiceNumber;
    // 发票代码
    @Column(name = "invoiceCode")
    @TableField(value = "invoiceCode")
    private String invoiceCode;
    // 发票类型
    @Column(name = "invoiceType")
    @TableField(value = "invoiceType")
    private String invoiceType;
    // 发票日期
    @Column(name = "invoiceDate")
    @TableField(value = "invoiceDate")
    private String invoiceDate;
    // 校验码
    @Column(name = "checkCode")
    @TableField(value = "checkCode")
    private String checkCode;
    // 机器编码
    @Column(name = "machineCode")
    @TableField(value = "machineCode")
    private String machineCode;
    // 开票人
    @Column(name = "drawer")
    @TableField(value = "drawer")
    private String drawer;
    // 复核人
    @Column(name = "reviewer")
    @TableField(value = "reviewer")
    private String reviewer;
    // 收款人
    @Column(name = "recipient")
    @TableField(value = "recipient")
    private String recipient;
    // 密码区
    @Column(name = "passwordArea")
    @TableField(value = "passwordArea")
    private String passwordArea;
    // 销售方名称
    @Column(name = "sellerName")
    @TableField(value = "sellerName")
    private String sellerName;
    // 销售方纳税人识别号
    @Column(name = "sellerTaxNumber")
    @TableField(value = "sellerTaxNumber")
    private String sellerTaxNumber;
    // 销售方银行账号信息
    @Column(name = "sellerBankAccountInfo")
    @TableField(value = "sellerBankAccountInfo")
    private String sellerBankAccountInfo;
    // 销售方联系信息
    @Column(name="sellerContactInfo")
    @TableField(value="sellerContactInfo")
    private String sellerContactInfo;
    // 购买方名称
    @Column(name="purchaserName")
    @TableField(value="purchaserName")
    private String purchaserName;
    // 购买方纳税人识别号
    @Column(name="purchaserTaxNumber")
    @TableField(value="purchaserTaxNumber")
    private String purchaserTaxNumber;
    // 合计金额（大写）
    @Column(name="totalAmountInWords")
    @TableField(value="totalAmountInWords")
    private String totalAmountInWords;
    // 合计金额（小写）
    @Column(name="totalAmount")
    @TableField(value="totalAmount")
    private Double totalAmount;
    // 发票金额（不含税）
    @Column(name="invoiceAmountPreTax")
    @TableField(value="invoiceAmountPreTax")
    private Double invoiceAmountPreTax;
    // 发票税额
    @Column(name="invoiceTax")
    @TableField(value="invoiceTax")
    private Double invoiceTax;
    private List<InvoiceDetail> invoiceDetails;
}
