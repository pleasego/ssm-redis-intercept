package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("tb_role")
@ToString
public class Role implements Serializable {

    private static final long serialVersionUID = 2979182508221304678L;

    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;
    @TableField("role_name")
    private String roleName;
    @TableField("remarks")
    private String remarks;
    @TableField(exist = false)
    private List<Power> powers;
}
