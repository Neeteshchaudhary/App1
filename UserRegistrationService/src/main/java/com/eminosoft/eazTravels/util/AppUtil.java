package com.eminosoft.eazTravels.util;

import java.security.MessageDigest;

public class AppUtil {

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
		       throw new RuntimeException(ex);
		    }
	}
	
	public static String removespecialchar(final String username) {

		StringBuilder umbldr = new StringBuilder(username);
		umbldr.deleteCharAt(umbldr.indexOf("@"));
		umbldr.deleteCharAt(umbldr.indexOf("."));

		return umbldr.toString();
	}
	
	public static void main(String[] args) {
		String username = "krk.koti@gmail.com";
		System.out.println(removespecialchar(username));
	}
	
	
	
}

