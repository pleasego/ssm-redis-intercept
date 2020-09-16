package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@TableName("tb_power")
@ToString
public class Power implements Serializable {

    private static final long serialVersionUID = 2746024335726138440L;

    @TableId(value = "power_id",type = IdType.AUTO)
    private Integer powerId;
    @TableField("power_name")
    private String powerName;
}
