package com.bommox;

public class Device {
	
	private String mac;
	private String ip;
	private String name;
	private String rssi;
	
	public String getRssi() {
		return rssi;
	}

	public void setRssi(String rssi) {
		this.rssi = rssi;
	}

	public Device() {
		
	}
	
	public Device(String mac, String ip, String name) {
		this.mac = mac;
		this.ip = ip;
		this.name = name;
	}
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + "] mac:" + this.mac + " - ip:" + this.ip;
	}
	

}
