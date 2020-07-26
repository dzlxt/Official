package com.g0818.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 雷小涛
 * @since 2020-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ParkingOrder implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单金额
     */
    private String amountOfMoney;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 发生订单的车位号
     */
    private String parkingNumber;

    /**
     * 支付状态
     */
    private Boolean state;

    /**
     * 命令下发状态 
     */
    private String cmdState;

    /**
     * 定单开始时间
     */
    private String endTime;

    /**
     * 订单结束时间
     */
    private String starTime;


}
