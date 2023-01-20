package org.kagaka;

import java.util.Random;

public class GeneralKit {
	
	public static final int ID_LENGTH = 16;
	
	public static String genHexId(int length) {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		while(sb.length() < length) {
			sb.append(Integer.toHexString(r.nextInt()));			
		}
		
		return sb.toString().substring(0, length);
	}

}
