package com.g0818.Util;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.zxing.common.BitMatrix;

public class CommonlyUsedUtil {
	
	@Autowired
	static String sign=null;
	/*
	 * 用于生成MD5加密字串
	 * */
	public  static String  encodeByMd5 (String string ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		Base64.Encoder bEncoder = Base64.getEncoder();
		return  bEncoder.encodeToString(md5.digest(string.getBytes("utf-8")));
	}
	
	/*uuid
	 * 用于生成订单号
	 * */
	public static String generateUuid() {
		String  uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
	
	  /**
     * 获取客户端ip地址
     * @param request
     * @return
     */
    public static String getCliectIp(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip;
    }
    
    /**
     * 微信支付签名算法sign
     * @param map
     * @return
     */
    public static String getSign(Map<String, Object >map){
      
    	String key="asdfawdfhwhwwdhu";
    	StringBuffer sb = new StringBuffer();
    	String[]  keyArr =(String[])map.keySet().toArray(new String[map.keySet().size()]);
    	Arrays.sort(keyArr);
    	for(int i=0,size=keyArr.length;i<size;i++) {	
    		if("sign".equals(keyArr[i])) {
    			continue;
    		}
    		sb.append(keyArr[i]+"="+map.get(keyArr[i])+"&");
    	}
    	sb.append("key="+key);
    	System.out.println("------"+key);
		try {
			return sign = encodeByMd5(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return sign;
    }
    

	public static HttpResponse sendXML(String url, String xmlData) throws Exception {
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost  httppost = new HttpPost(url);
		StringEntity  entity = new StringEntity(xmlData);
		httppost.setEntity(entity);
		httppost.setHeader("Content-Type","text/xml;charset=UTF-8");
		HttpResponse resp =httpClient.execute(httppost);
		return resp;
	}
	
	
	/*用于读取微信支付返回的数据流
	 * */
	public static String getElementValue(InputStream in,String key) {
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
	
    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String getXml(Map<String, String> map) {
    
    	StringBuffer sb  = new StringBuffer();
    	sb.append("<xml>");
    	for(String k:map.keySet()) {
    		Object  value=map.get(k);
    		sb.append("<"+k+">"+value+"</"+k+">");
    	}
    	sb.append("</xml>");
    	try {
			return new String(sb.toString().getBytes(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    //二维码生成工具（使用谷歌二维码生成框架）
    public static BufferedImage toImage(BitMatrix matrix) {
		int width=matrix.getWidth();
		int height=matrix.getHeight();
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for(int x=0;x<width;x++) {
			for(int y=0;y<height;y++) {
				image.setRGB(x, y, matrix.get(x,y)==true?0xff0000:0xffffffff);
			}
		}
    	return image;
        }
    public static String  TimeDifference(String d1,String d2) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
		Date date1;	
		Date date2;	
		long diff=0;
		long days = 0;
		long hours = 0;
		long minutes = 0;
		try {
			date1 = df.parse(d1);
			date2 = df.parse(d2);
			diff	  =  date2.getTime()-date1.getTime();
			days   = diff/(1000*60*60*24);
			hours = (diff-days*(1000*60*60*24))/(1000*60*60);
			minutes = (diff-days*(1000*60*60*24)-hours*(1000*60*60))/(1000*60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String b = days+"天"+hours+"小时"+minutes+"分钟";
    	return  b;
    }
    //计算缴费金额
    public static int charging(int d,int h,String d1,String d2) 
   {
	   DateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
		Date date1;	
		Date date2;	
		long diff=0;
		long days = 0;
		long hours = 0;
		long minutes = 0;
		int menoy;
		try {
			date1 = df.parse(d1);
			date2 = df.parse(d2);
			diff	  =  date2.getTime()-date1.getTime();
			days   = diff/(1000*60*60*24);
			hours = (diff-days*(1000*60*60*24))/(1000*60*60);
			minutes = (diff-days*(1000*60*60*24)-hours*(1000*60*60))/(1000*60);
			} catch (ParseException e) {
			e.printStackTrace();
		}
		menoy =(int) days*d+(int)hours*h;
		if(minutes != 5) {
			menoy=menoy+1;
		}
		return menoy;
   }
    
   
    
}
