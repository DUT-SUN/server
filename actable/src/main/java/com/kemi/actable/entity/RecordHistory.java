package com.kemi.actable.entity;
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
 * @date 2023/08/27  1:04
 */
//审批记录（修改前的）此时它的创建时间就是修改时间（也可以是record表中的更新时间），然后最初记录的创建时间就是第一个历史版本的创建时间
@Data //lombok注解，不用管
@Table(name = "RecordHistory") //对应数据库表名，如果更改表名需要同步更改数据库表名，不然会重新创建表。
public class RecordHistory extends SuperEntity implements Serializable {
    // 报销记录ID
    @Column(isNull = false)
    private Integer recordId;
    // 修改人
    @Column(isNull = false)
    private String modifier;
    // 修改审批内容
    @Column(isNull = false)
    private String modification_content;
}

