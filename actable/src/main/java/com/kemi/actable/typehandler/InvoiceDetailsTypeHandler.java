package com.kemi.actable.typehandler;

import com.kemi.actable.entity.InvoiceDetail;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDetailsTypeHandler implements TypeHandler<List<InvoiceDetail>> {

    @Override
    public void setParameter(PreparedStatement ps, int i, List<InvoiceDetail> parameter, JdbcType jdbcType) throws SQLException {
        // 在这里实现设置参数的逻辑
    }

    @Override
    public List<InvoiceDetail> getResult(ResultSet rs, String columnName) throws SQLException {
        // 在这里实现从结果集中获取结果的逻辑
        List<InvoiceDetail> invoiceDetails = new ArrayList<>();
        while (rs.next()) {
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            invoiceDetail.setItemName(rs.getString("itemName"));
            invoiceDetail.setQuantity(rs.getInt("quantity"));
            invoiceDetail.setUnitPrice(rs.getDouble("unitPrice"));
            invoiceDetail.setSpecification(rs.getString("specification"));
            invoiceDetail.setUnit(rs.getString("unit"));
            invoiceDetail.setAmount(rs.getDouble("amount"));
            invoiceDetail.setTaxRate(rs.getString("taxRate"));
            invoiceDetail.setTax(rs.getString("tax"));
            invoiceDetails.add(invoiceDetail);
        }
        return invoiceDetails;
    }

    @Override
    public List<InvoiceDetail> getResult(ResultSet rs, int columnIndex) throws SQLException {
        // 在这里实现从结果集中获取结果的逻辑
        return getResult(rs, "");
    }

    @Override
    public List<InvoiceDetail> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 在这里实现从存储过程调用中获取结果的逻辑
        return null;
    }
}
