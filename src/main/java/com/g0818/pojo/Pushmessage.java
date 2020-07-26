package com.g0818.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 车位状态表
 * </p>
 *
 * @author 雷小涛
 * @since 2020-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Pushmessage implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 物联网卡号
     */
    private String nbiotNumber;

    /**
     * 事件发起时间
     */
    private String eventTime;

    /**
     * 车位状态
     */
    private String parkingState;


}
