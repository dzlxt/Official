package com.g0818.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 城市三级联动
 * </p>
 *
 * @author 雷小涛
 * @since 2020-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class China implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "Id", type = IdType.ASSIGN_ID)
    private Integer Id;

    @TableField("Name")
    private String Name;

    @TableField("Pid")
    private Integer Pid;


}
