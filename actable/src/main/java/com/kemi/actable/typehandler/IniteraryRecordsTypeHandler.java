package com.kemi.actable.typehandler;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/09/08  0:09
 */

import com.kemi.actable.entity.IniteraryRecord;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IniteraryRecordsTypeHandler implements TypeHandler<List<IniteraryRecord>> {

    @Override
    public void setParameter(PreparedStatement ps, int i, List<IniteraryRecord> parameter, JdbcType jdbcType) throws SQLException {
        // 在这里实现设置参数的逻辑
    }

    @Override
    public List<IniteraryRecord> getResult(ResultSet rs, String columnName) throws SQLException {
        // 在这里实现从结果集中获取结果的逻辑
        List<IniteraryRecord> rideRecords = new ArrayList<>();
        while (rs.next()) {
            IniteraryRecord rideRecord = new IniteraryRecord();
            rideRecord.setNumber(rs.getInt("Number"));
            rideRecord.setAmount(rs.getDouble("amount"));
            rideRecord.setCarType(rs.getString("carType"));
            rideRecord.setCity(rs.getString("city"));
            rideRecord.setEndPlace(rs.getString("endPlace"));
            rideRecord.setMileage(rs.getDouble("mileage"));
            rideRecord.setPickUpTime(rs.getString("pickUpTime"));
            rideRecord.setRemarks(rs.getString("remarks"));
            rideRecord.setStartPlace(rs.getString("startPlace"));
            rideRecords.add(rideRecord);
        }
        return rideRecords;
    }

    @Override
    public List<IniteraryRecord> getResult(ResultSet rs, int columnIndex) throws SQLException {
        // 在这里实现从结果集中获取结果的逻辑
        return getResult(rs, "");
    }

    @Override
    public List<IniteraryRecord> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 在这里实现从存储过程调用中获取结果的逻辑
        return null;
    }
}
