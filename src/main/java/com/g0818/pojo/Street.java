package com.g0818.pojo;

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
public class Street implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 街道id号
     */
    private Integer id;

    private String streetName;


}
