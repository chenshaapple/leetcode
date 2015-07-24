package yxc.exp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class GsonSample {
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Test
	public void serializeMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("int", 1);
		map.put("string", "a string.");
		System.out.println(gson.toJson(map));
	}

	@Test
	public void serializeWrapper() {
		Wrapper wrapper = new Wrapper();
		Map<String, Object> agentInfo = new HashMap<>();
		agentInfo.put("hostname", "Chens-Imac.local");
		agentInfo.put("port", 8080);
		agentInfo.put("boolean", true);
		wrapper.setAgentInfo(agentInfo);

		System.out.println(gson.toJson(wrapper));
	}
}

class Wrapper {
	@SerializedName("agent_info")
	private Map<String, Object> agentInfo;
	@SerializedName("custom_config_info")
	private Map<String, Object> customConfig;
	private Map<String, Object> environment;

	public Map<String, Object> getAgentInfo() {
		return agentInfo;
	}

	public void setAgentInfo(Map<String, Object> agentInfo) {
		this.agentInfo = agentInfo;
	}

	public Map<String, Object> getCustomConfig() {
		return customConfig;
	}

	public void setCustomConfig(Map<String, Object> customConfig) {
		this.customConfig = customConfig;
	}

	public Map<String, Object> getEnvironment() {
		return environment;
	}

	public void setEnvironment(Map<String, Object> environment) {
		this.environment = environment;
	}
}
