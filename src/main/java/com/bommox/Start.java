package com.bommox;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.google.gson.JsonElement;


public class Start {
	
	static {
	    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.SEVERE);
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		WebDriver driver = new HtmlUnitDriver(true);
		
		JSONObject result = new JSONObject(); 
		
		try {
			
			JSONArray devices = new JSONArray();
			result.put("devices", devices);
			
			driver.get("http://192.168.1.1");
			driver.findElement(By.name("Username")).sendKeys("jazztel");
			driver.findElement(By.name("Password")).sendKeys("jazztel");
			driver.findElement(By.name("fLogin")).submit();
			
			// Se supone que estamos dentro
			//driver.get("http://192.168.1.1/getpage.gch?pid=1002&nextpage=net_dhcp_dynamic_t.gch");
			driver.get("http://192.168.1.1/getpage.gch?pid=1002&nextpage=net_wlanm_assoc1_t.gch");
			for (WebElement row : driver.findElements(By.className("white"))) {
				JSONObject device = new JSONObject();
				String[] text = row.getText().split(" ");				
				Device dev = new Device(text[0], text[1], "");
				dev.setRssi(text[3]);
				device.put("mac", dev.getMac());
				device.put("ip", dev.getIp());
				device.put("name", dev.getName());
				device.put("rssi", dev.getRssi());
				devices.add(device);

			}
			driver.get("http://192.168.1.1/getpage.gch?pid=1002&nextpage=net_wlanm_assoc2_t.gch");
			for (WebElement row : driver.findElements(By.className("white"))) {
				JSONObject device = new JSONObject();
				String[] text = row.getText().split(" ");				
				Device dev = new Device(text[0], text[1], "");
				dev.setRssi(text[3]);
				device.put("mac", dev.getMac());
				device.put("ip", dev.getIp());
				device.put("name", dev.getName());
				device.put("rssi", dev.getRssi());
				devices.add(device);

			}
			result.put("totalDevices", devices.size());
			result.put("status", "ok");
		} catch (Exception e) {
			//System.err.println("Error " + e.getMessage());
			//e.printStackTrace();
			result.put("status", "error");
			result.put("error", e.getMessage());
		}
		
		driver.close();
		long elapsed = System.currentTimeMillis() - start;
		result.put("ellapsed", elapsed);
		System.out.println(result.toJSONString());
      
    }


}
