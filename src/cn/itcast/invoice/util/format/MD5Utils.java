﻿package cn.itcast.invoice.util.format;
//fixed error id 9
import java.security.MessageDigest;

public class MD5Utils {
	/**
	 * 使用md5的算法进行加密
	 */

	public static String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	    	 System.out.println("Something was wrong");
	    }
	}


}
