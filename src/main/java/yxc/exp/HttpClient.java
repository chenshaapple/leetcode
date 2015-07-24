package yxc.exp;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;


public class HttpClient {
	public static void main(String[] args) throws Exception {
		int size = 10000;
		String url = "https://www.baidu.com";
		System.out.println(LocalDateTime.now());
		Executor executor = Executors.newCachedThreadPool();
		for(int i = 0; i < 100; i++) {
			executor.execute(() -> {
				HttpGet get = new HttpGet(url);
				HttpResponse response;
				try {
					response = HttpClients.createDefault().execute(get);
					System.out.println(response.getStatusLine().getStatusCode());
				} catch (Exception e) {
				} finally {
					get.releaseConnection();
				}
			});
		}
		System.out.println(LocalDateTime.now());
	}
	
	@Test
	public void case1() {
		String version = "1.1";
		String version2 = "2";
		System.out.println(Arrays.toString(version.split("\\.")));
		System.out.println(Arrays.toString(version2.split("\\.")));
	}
}
