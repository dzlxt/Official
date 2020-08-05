package com.g0818.Util;

import com.g0818.config.PayConfig;
import com.g0818.pojo.Order;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WxpayUtils {

    public static HttpResponse sendXML(String url, String xmlData) throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        StringEntity entity = new StringEntity(xmlData);
        httppost.setEntity(entity);
        httppost.setHeader("Content-Type","text/xml;charset=UTF-8");
        HttpResponse resp =httpClient.execute(httppost);
        return resp;
    }

    public static Map unifiedOrder(String  nonce_str, String device_info, String out_trade_no, String total_fee, String ip, String openid) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("appid", PayConfig.getAppID()); 				//微信支付分配的公众账号ID（企业号corpid即为此appId）
        map.put("mch_id", PayConfig.getMchID());				//微信支付分配的商户号
        map.put("nonce_str", nonce_str);					    //随机字符串，长度要求在32位以内
        map.put("device_info",device_info);
        map.put("body", "wisdomlefiDz-ParkingRate");			//商品简单描述，该字段请按照规范传递
        map.put("out_trade_no", out_trade_no);					//商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一
        map.put("total_fee",total_fee );						//订单总金额，单位为分
        map.put("spbill_create_ip", ip);	                	//支持IPV4和IPV6两种格式的IP地址。用户的客户端IP
        map.put("notify_url", PayConfig.getNotifyUrl());  		//异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数
        map.put("trade_type", "JSAPI");							//JSAPI -JSAPI支付  jsapi须获得openid;    NATIVE -Native支付    APP -APP支付
        map.put("openid", openid);

        try {
            map.put("sign", WXPayUtil.generateSignature(map,PayConfig.getStorePassword(), WXPayConstants.SignType.MD5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String getElementValue(InputStream in, String key) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(in);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        List<Element> childelement = root.elements();
        for(Element child:childelement) {
            System.out.println(child.getName()+":"+child.getStringValue());
            if(key.equals(child.getName())) {
                return child.getStringValue();
            }
        }
        return null;
    }

    public  String getopenid(String code) {
        String openid = "";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        StringBuffer a = new StringBuffer();
        a.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
        a.append(PayConfig.getAppID());
        a.append("&secret=");
        a.append(PayConfig.getKey());
        a.append("&code=");
        a.append(code);
        a.append("&grant_type=authorization_code");
        String url = a.toString();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();
        httpGet.setConfig(requestConfig);
        try {
            response = httpClient.execute(httpGet);
            HttpEntity respEntity = response.getEntity();
            String rs = EntityUtils.toString(respEntity);
            JSONObject jO =JSONObject.fromObject(rs);
            openid = jO.getString("openid");
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return openid;
    }

    public static String h5Map(String  nonce_str,String prepay_id,String strtime) {
        String aString=null;
        Map<String, String> map = new TreeMap<String, String>();
        map.put("appId", PayConfig.getAppID()); 			//微信支付分配的公众账号ID（企业号corpid即为此appId）
        map.put("nonceStr", nonce_str);							//随机字符串，长度要求在32位以内2
        map.put("timeStamp", strtime);						//商品简单描述，该字段请按照规范传递5
        map.put("package","prepay_id="+ prepay_id);							//3统一下单接口返回的prepay_id参数值，提交格式为
        map.put("signType","MD5");//4
        try {
            aString = WXPayUtil.generateSignature(map,PayConfig.getStorePassword(), WXPayConstants.SignType.MD5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("==map:=="+map.toString()+"==astring:=="+aString);
        return aString;
    }

    //向前端支付页提供数据
    public Order toJSAPI(Order order){
        String xml;
        InputStream rs = null;																			//接收统一下单后腾讯返回的信息
        String 	prepay_id=null;																		//从腾讯获得的预支付单号
        Map map= this.unifiedOrder(order.getNonce_str(),order.getDevice_info(),order.getOut_trade_no(),  order.getTotal_fee()+"", order.getIp(),order.getOpenid());
        try {
            System.out.println(map.toString());
            xml = WXPayUtil.mapToXml(map);
            rs =CommonlyUsedUtil.sendXML(PayConfig.getUrl(), xml).getEntity().getContent();
            prepay_id=CommonlyUsedUtil.getElementValue(rs,"prepay_id");

        } catch (Exception e) {
            e.printStackTrace();
        }
        order.setPrepay_id(prepay_id);
        return order;
    }

}
