package br.com.send.consumer.mq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataUtil {

	private static final Logger logger = LogManager.getLogger(DataUtil.class);
	
	private static SimpleDateFormat dateFormatyyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	private static SimpleDateFormat dateFormatddMMyyyyHHmmss = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	
	private static int GMT = -3;
	
	public static Date convert_yyyyMMddHHmmss(String datayyyyMMddHHmmss) throws Exception{
		
		try {
			return dateFormatyyyyMMddHHmmss.parse(datayyyyMMddHHmmss);
		} catch (ParseException e) {
			logger.error("Erro ao formatar data " + e);
			throw e;
		}
	}
	
	public static String converterDataGMT3(Date data) {
		if(data == null)return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.HOUR_OF_DAY, GMT );
		return dateFormatddMMyyyyHHmmss.format(cal.getTime()); 
	}
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * try { System.out.println(
	 * DataUtil.convert_yyyyMMddHHmmss("2019-12-02 20:10:56") ); } catch (Exception
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
}
