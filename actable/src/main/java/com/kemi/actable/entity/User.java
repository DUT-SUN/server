package com.kemi.actable.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;
import org.apache.ibatis.jdbc.Null;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;


@Data //lombok注解，不用管
@Table(name = "User") //对应数据库表名，如果更改表名需要同步更改数据库表名，不然会重新创建表。
public class User extends SuperEntity  implements Serializable {
//    用户名
    @Column
    private String username;
//    密码
    @Column
    private String password;
//    性别
    @Column
    private Integer gender;
//    照片
    @Column
    private String photo;
//    状态
    @Column
    private Integer state;
//    权限
    @Column
    private Integer identity;
//    职位
    private String position;
//    地址
    private String address;
//    相关qq号
    @Column(isNull = true)
    private Integer QQNum;
//    相关微信号
    @Column(isNull = true)
    private Integer WXNum;
//    手机号(非空)
    @Column(isNull = false)
    private Integer PhoneNum;
//    修改记录副本最长保存时间(默认是0，修改审批记录后不会去添加到修改记录表中，如果设定了一个值，在修改后，Record表中变为修改后的值，则会在一天内执行一次清理操作

    @Column(defaultValue = "0")
    private Integer record_history_expiration;

}
