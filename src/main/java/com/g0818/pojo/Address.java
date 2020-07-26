package com.g0818.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 车位表
 * </p>
 *
 * @author 雷小涛
 * @since 2020-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Address implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 城市代码-与china表的ID关联
     */
    private Integer city;

    /**
     * 街道号
     */
    private Integer street;

    /**
     * 车位号
     */
    private String parkingNumber;


}
