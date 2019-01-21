package fr.dta.mock;

import java.util.Map;

import com.google.gson.Gson;

public class MyIpService {
	private HttpDataService httpDataService;

	public MyIpService(HttpDataService httpDataService) {
		this.httpDataService = httpDataService;
	}

	public String getMyIp() {
		Gson gson = new Gson();
		String jsonIp = httpDataService.getJsonIp();
		Map<String, String> map = gson.<Map<String, String>>fromJson(jsonIp, Map.class);
		return map.get("ip").split(",")[0];
	}
}
