package com.g0818.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 装配安装表
 * </p>
 *
 * @author 雷小涛
 * @since 2020-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AssemblyProduction implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 车位号
     */
    private String parkingNumber;

    /**
     * 车位锁号
     */
    private String lockNumber;

    /**
     * 物联网卡号
     */
    private String nbiotcarNumber;

    /**
     * 资费标准
     */
    private Integer postageUnit;

    /**
     * 启用日期
     */
    private LocalDateTime activationDate;


}
