package fr.dta.mock;

public class Main {

	public static void main(String[] args) {
		HttpDataService http = new HttpDataService();
		MyIpService ip = new MyIpService(http);
		System.out.println(ip.getMyIp());

	}

}
