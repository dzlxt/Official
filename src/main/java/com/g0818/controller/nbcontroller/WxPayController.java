package com.g0818.controller.nbcontroller;

import com.g0818.Util.CommonlyUsedUtil;
import com.g0818.Util.WxpayUtils;
import com.g0818.config.PayConfig;
import com.g0818.mapper.StartTimeMapper;
import com.g0818.pojo.Order;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;


@Controller
@RequestMapping("/pay")
public class WxPayController {
    @Autowired
    StartTimeMapper startTimeMapper;

    @RequestMapping("/getlu")
    public void getLockNumber(@RequestParam(name = "deviceid")String deviceid, HttpServletResponse resp){
        System.out.println(deviceid);
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc1dfe2fee7d386af&redirect_uri=https://www.g0818.com/pay/code&response_type=code&scope=snsapi_base&state=";
        try {
            resp.sendRedirect(url+deviceid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/payment")     //转到前端支付页
    public String getcode(Model model, HttpServletRequest req){
        System.out.println(req.getParameter("code")+req.getParameter("state"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");

        Order order = new Order();
        order.setCode(req.getParameter("code"));
        order.setDevice_info(req.getParameter("state"));
        order.setNonce_str(WXPayUtil.generateNonceStr());
        order.setOut_trade_no(WXPayUtil.generateNonceStr());
        order.setTotal_fee(CommonlyUsedUtil.charging(8,2,"",""));
        order.setStart_time(startTimeMapper.selectById("1").getTime());
        order.setEnd_time(dateFormat.format(System.currentTimeMillis()));
        order.setIp(CommonlyUsedUtil.getCliectIp(req));

        WxpayUtils wxpayUtils = new WxpayUtils();
        order=wxpayUtils.toJSAPI(order);
        //String sign =this.h5Map(nonce_str, prepay_id,strtime);
        model.addAttribute("total_fee",order.getTotal_fee());
        model.addAttribute("appId", PayConfig.getAppID());
        model.addAttribute("timeStamp",order.getEnd_time());
        model.addAttribute("nonceStr",order.getNonce_str());
        model.addAttribute("package","prepay_id="+order.getPrepay_id());
        model.addAttribute("signType", WXPayConstants.SignType.MD5);
        //model.addAttribute("paySign", sign);
        //model.addAttribute("out_trade_no",out_trade_no);
        model.addAttribute("startime", "vehicleEntry.getEventTime()");
        //model.addAttribute("endtime", endtime);
        //model.addAttribute("device_info", device_info);
        System.out.println(order.toString());
        return "jspay";
    }

}
