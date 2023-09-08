package com.kemi.actable.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kemi.actable.entity.InvoiceDetail;
import com.kemi.actable.entity.Invoices;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/08/27  22:53
 */
@Mapper
public interface InvoiceMapper extends BaseMapper<Invoices> {
    @Insert("INSERT INTO InvoiceDetails (Invoice_ID, itemName, quantity, unitPrice, specification, unit, amount, taxRate, tax) VALUES (#{Invoice_ID}, #{itemName}, #{quantity}, #{unitPrice}, #{specification}, #{unit}, #{amount}, #{taxRate}, #{tax})")
    void insertInvoiceDetail(InvoiceDetail invoiceDetail);
}
