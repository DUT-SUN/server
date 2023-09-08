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
 * @date 2023/08/29  10:28
 */
@Data //lombok注解，不用管
@Table(name = "search_history") //对应数据库表名，如果更改表名需要同步更改数据库表名，不然会重新创建表。
public class search_history extends SuperEntity implements Serializable {
    // 搜索的用户的 ID
    @Column(isNull = false)
    private Integer user_id;
    // 用户搜索的关键字
    @Column(isNull = false)
    private String search_query;
}

