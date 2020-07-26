package com.g0818.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 收费标准表
 * </p>
 *
 * @author 雷小涛
 * @since 2020-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChargingStandard implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 资费分级
     */
      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 首停计费单位
     */
    private Integer firstDuration;

    /**
     * 首停资费
     */
    private Integer firstTariff;

    /**
     * 续停计费单位
     */
    private Integer extendDuration;

    /**
     * 续集资费标准
     */
    private Integer extendTaniff;


}
