package com.kemi.actable.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;
import java.io.Serializable;

//如果有多个审批环节可以按照创建时间来进行排序
//SELECT r.recordId, r.Requester, r.approver, r.approval_status, r.approval_opinion, r.approval_level
//        FROM Record r
//        INNER JOIN UserRelationship u ON r.RequestID = u.userId
//        WHERE r.recordId = [RECORD_ID]
//        ORDER BY r.approval_level ASC;

//报销记录表
@Data //lombok注解，不用管
@Table(name = "Record") //对应数据库表名，如果更改表名需要同步更改数据库表名，不然会重新创建表。
public class Record extends SuperEntity implements Serializable {
    // 报销记录ID
    @Column(isNull = false)
    private Integer recordId;
    // 请求处理方用户id
    @Column(isNull = false)
    private Integer RequestID;
    // 请求人
    @Column
    private String Requester;
    // 审批人ID
    @Column(isNull = false)
    private Integer approverId;
    // 审批人
    @Column
    private String approver;
    // 审批层级
    @Column(defaultValue = "1")
    private Integer approval_level;
    // 审批状态（待审批0,审批通过1，审批拒绝-1）
    @Column(defaultValue = "0")
    private Integer approval_status;
    // 审批完成时间
    @Column
    private String approval_time;
    // 审批意见
    @Column
    private String approval_opinion;
}
