package com.kemi.actable.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsAutoIncrement;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsKey;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;


@Getter //lombok注解，不用管
@Setter //lombok注解，不用管
public class SuperEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO) //mybatis-plus主键注解
    @IsKey                         //actable主键注解
    @IsAutoIncrement             //自增
    @Column                     //对应数据库字段，不配置name会直接采用属性名作为字段名
    private Long id;
    /**
     * 创建时间
     */
    @Column(name = "create_time",comment = "创建时间",type = MySqlTypeConstant.TIMESTAMP,defaultValue="CURRENT_TIMESTAMP") // name指定数据库字段名，comment为备注
    private Date createTime;
    /**
     * 最后修改时间
     */
    @Column(name = "update_time",comment = "最后修改时间",type = MySqlTypeConstant.TIMESTAMP,defaultValue="NULL ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;

}
