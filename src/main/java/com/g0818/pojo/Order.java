package com.g0818.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String device_info; //锁号
    private String code;        //用户从微信带过来的码
    private String openid;      //用户在公众号的openid
    private String nonce_str;   //随机字符串
    private String start_time;  //停车开始时间
    private String end_time;    //结束时间
    private String out_trade_no;//订单号
    private int total_fee;   //应支付金额
    private String prepay_id;
    private String ip;
    }
