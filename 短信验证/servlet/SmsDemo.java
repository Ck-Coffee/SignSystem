package com.hellojava.servlet;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.dysmsapi.transform.v20170525.SendSmsResponseUnmarshaller;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
public class SmsDemo { 
    static final String product = "Dysmsapi";  
    static final String domain = "dysmsapi.aliyuncs.com";
    static final String accessKeyId = "LTAI9dWlJprNeG36";
    static final String accessKeySecret = "9ZErUQU8RwKdcxppvjCHuFPsjJZb2p";
    public static String createRandomNum(int num){
		 String randomNumStr = "";
		 for(int i = 0; i < num;i ++){
		  int randomNum = (int)(Math.random() * 10);
		  randomNumStr += randomNum;
		 }
		 return randomNumStr;
		}
    public static void sendSms(String phone,String codeNumber) throws ClientException {    
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);       
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phone);  
        request.setSignName("签到系统");  
        request.setTemplateCode("SMS_123671036");
//    	Random r=new Random();		
//		String base="0123456789";
//		String codeNumber="",serverCode="";
//		while(serverCode.length()<6) {
//			char c=base.charAt(r.nextInt(base.length()));
//			serverCode+=c;
//			if(serverCode.length()==0) {
//				codeNumber+=c;
//			}else {
//				codeNumber+=c;
//			}
//		}
        request.setTemplateParam("{\"code\":\""+codeNumber+"\"}");
        request.setOutId("yourOutId");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);  
    }
}
