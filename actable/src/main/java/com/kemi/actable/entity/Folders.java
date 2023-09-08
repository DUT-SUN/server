package com.kemi.actable.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;
import org.apache.ibatis.jdbc.Null;
import org.springframework.boot.context.properties.bind.DefaultValue;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;

import java.io.Serializable;

//发票夹表
@Data //lombok注解，不用管
@Table(name = "Folders") //对应数据库表名，如果更改表名需要同步更改数据库表名，不然会重新创建表。
public class Folders extends SuperEntity  implements Serializable {
//   所属用户ID
    private Integer user_id;
}
