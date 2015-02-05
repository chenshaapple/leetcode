package org.leetcode.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Properties;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.util.FileUtils;
import org.junit.Test;

import junit.*;
import static org.junit.Assert.*;

public class Exp {
	class CityAttract {
		int index;
		int attract;

		public CityAttract(int index, int attract) {
			this.index = index;
			this.attract = attract;
		}
	}

	public int solution(int K, int[] C, int[] D) {
		int result = 1;
		List<CityAttract> cityAttracts = new LinkedList<Exp.CityAttract>();
		for (int i = 0; i < D.length; i++) {
			cityAttracts.add(new CityAttract(i, D[i]));
		}
		Collections.sort(cityAttracts, new Comparator<CityAttract>() {
			@Override
			public int compare(CityAttract o1, CityAttract o2) {
				if (o1.attract < o2.attract) {
					return -1;
				} else if (o1.attract > o2.attract) {
					return 1;
				}
				return 0;
			}
		});
		for (int i = 0; i < K; i++) {

		}
		return result;
	}

	// @Test
	// public void testCase1() throws MalformedURLException {
	// URL url1 = new URL("http://localhost:8080");
	// URL url2 = new URL("http://localhost:8080");
	// System.out.println(url1.hashCode());
	// System.out.println(url2.hashCode());
	// assertTrue(url1.equals(url2));
	// }
	enum Status {
		Alive, BreakDown
	}

	@Test
	public void testCase2() {
		Status status = Status.Alive;
		assertTrue(status == Status.Alive);
	}

	@Test
	public void testNonInitReference() {
		Date date;
		// assertTrue(date ==null); //
	}

	@Test
	public void testNullUnbox() {
		Integer number = null;
		int primNumber = number;
		assertTrue(primNumber == 0); // NPE
	}

	@Test
	public void testUrlBuilder() {
		try {
			URL url = new URL("127.0.0.1:8080");
			System.out.println(url.getHost());
			System.out.println(url.getPort());
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException");
		}
	}

	@Test
	public void testCatchNPE() {
		try {
			throw (new NullPointerException());
		} catch (NullPointerException e) {
			System.out.println("catch");
		}
	}

	@Test
	public void testTemplateFormat() {
		Properties emailProperties = new Properties();
		try {
			InputStream inputStream = Exp.class.getResourceAsStream(System
					.getProperty("user.dir")
					+ "/bin/RegisterEmailTemplate.properties");
			String template = "欢迎注册Bench4Q！您可以通过以下链接登录\n%s/activate?userName=%s&token=%s";
			if (inputStream != null) {
				emailProperties.load(inputStream);
			}
			System.out.println(String.format(template, "baseUrl", "userName",
					"token"));
			System.out.println(emailProperties.get("title"));
			System.out.println(emailProperties.get("text"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testSendArrayParamThroughHttpClient() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		// String url = "http://localhost:8901/script/deleteScript";
		String url = "http://www.baidu.com";
		HttpPost httpPost = new HttpPost(url);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("scriptIdList", Arrays.asList(3, 4));

		List<NameValuePair> parametersBody = new LinkedList<>();
		for (Entry<String, Object> entry : params.entrySet()) {
			if (List.class.isAssignableFrom(entry.getValue().getClass())) {
				for (Object obj : (List) entry.getValue()) {
					parametersBody.add(new BasicNameValuePair(entry.getKey(),
							String.valueOf(obj)));
				}
			} else {
				parametersBody.add(new BasicNameValuePair(entry.getKey(),
						String.valueOf(entry.getValue())));
			}
		}
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(parametersBody));
			HttpResponse response = httpClient.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getEntity().getContentType());
			System.out.println(response.getEntity().getContentEncoding());
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	// put it into another file
	public void testSendListThroughCommonsHttpClient() {
		org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
		String url = "http://localhost:8901/script/deleteScript";
		PostMethod postMethod = new PostMethod(url);
		Map<String, ? super List> params = new HashMap<>();
		params.put("scriptIdList", Arrays.asList(3, 4));
		List<org.apache.commons.httpclient.NameValuePair> parametersBody = new LinkedList<>();
		for (Entry<String, ?> entry : params.entrySet()) {
			if (List.class.isAssignableFrom(entry.getValue().getClass())) {
				for (Object obj : (List) entry.getValue()) {
					parametersBody
							.add(new org.apache.commons.httpclient.NameValuePair(
									entry.getKey(), String.valueOf(obj)));
				}
			} else {
				parametersBody
						.add(new org.apache.commons.httpclient.NameValuePair(
								entry.getKey(),
								String.valueOf(entry.getValue())));
			}
		}
		org.apache.commons.httpclient.NameValuePair[] nameValuePairs = new org.apache.commons.httpclient.NameValuePair[parametersBody
				.size()];
		parametersBody.toArray(nameValuePairs);
		postMethod.setRequestBody(nameValuePairs);
		try {
			System.out.println(httpClient.executeMethod(postMethod));
		} catch (org.apache.commons.httpclient.HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGit() throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		Process process;
		process = runtime.exec("/Users/apple/git/Bench4Q/webhook/target/classes/pull.sh");
		// process = runtime.exec("git pull", null, new File(
		// "/Users/apple/git/Bench4Q-hook"));
		System.out.println("error stream");
		printStream(process.getErrorStream());
		System.out.println("output stream");
		printStream(process.getInputStream());
	}
	
	private void printStream(InputStream stream) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				stream));
		String line = "";
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJGitUsingPassword() {
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		try {
			Repository repository = builder
					.setGitDir(new File("/Users/apple/git/Bench4Q-hook/.git"))
					.readEnvironment().findGitDir().build();
			Git git = new Git(repository);
			CredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(
					"chenshaapple", "****");
			PullResult pullResult = git.pull()
					.setCredentialsProvider(credentialsProvider).call();
			System.out.println(pullResult.getFetchedFrom());
			System.out.println(pullResult.getFetchResult().getMessages());
		} catch (IOException | GitAPIException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJGitUsingSsh() {

	}

	@Test
	public void testTokenizer() {
		String command = "echo hello";
		StringTokenizer st = new StringTokenizer(command);
		String[] cmdarray = new String[st.countTokens()];
		for (int i = 0; st.hasMoreTokens(); i++)
			cmdarray[i] = st.nextToken();
		System.out.println(cmdarray);
	}
}
