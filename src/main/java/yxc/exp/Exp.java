package yxc.exp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
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
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Exp {

	@Test
	public void testCallable() throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				System.in));
		String[] numsString = read.readLine().split(" ");
		String sequence = read.readLine();
		int[] nums = new int[3];
		for (int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(numsString[i]);
		}
		Arrays.sort(nums);
		if (nums[0] + nums[1] != nums[2]) {
			System.out.println(sequence.length());
			return;
		}
		int cR = 0, cY = 0, cB = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < sequence.length(); i++) {
			char curt = sequence.charAt(i);
			if (curt == 'R') {
				cR++;
			} else if (curt == 'B') {
				cB++;
			} else if (curt == 'Y') {
				cY++;
			}
			List<Integer> tmp = Arrays.asList(cR, cY, cB);
			Collections.sort(tmp);
			if (tmp.get(1) - tmp.get(0) == nums[0]
					&& tmp.get(2) - tmp.get(1) == nums[1]) {
				max = Math.max(max, cR + cY + cB);
				cR = cY = cB = 0;
			}
		}
		System.out.println(max);
	}

	@Test
	public void solution() {
		List<Integer> list = new ArrayList<>(5);
		list.set(4, Integer.valueOf(2));
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
		process = runtime
				.exec("/Users/apple/git/Bench4Q/webhook/target/classes/pull.sh");
		// process = runtime.exec("git pull", null, new File(
		// "/Users/apple/git/Bench4Q-hook"));
		System.out.println("error stream");
		printStream(process.getErrorStream());
		System.out.println("output stream");
		printStream(process.getInputStream());
	}

	private void printStream(InputStream stream) {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(stream));
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
	

	public static class Push {
		private String ref;

		public String getRef() {
			return ref;
		}

		public void setRef(String ref) {
			this.ref = ref;
		}
	}

	@Test
	public void testGson() {
		Gson gson = new GsonBuilder().create();
		String input = "{\"ref\":\"name\"}";
		Exp.Push push = gson.fromJson(input, Exp.Push.class);
		assertNotNull(push.getRef());
	}

	@Test
	public void testGenericWithWildcard() {
		// List<Number> listNumber = new ArrayList<Integer>(); error

		// ͨ����Ƕ������������ƣ�Ҳ����˵ֻ�����漰��ͨ����Ĳ���
		List<? extends Number> listExtendsNumber = new ArrayList<Integer>();
		// listExtendsNumber.add(new Integer(0)); error
		// ���԰�����add��������
		List<Number> listNumber = new ArrayList<>();
		listNumber.addAll(new ArrayList<>(Arrays.asList(1.0, 2L, 1)));
		listNumber.add(new Integer(0));
		listNumber.add(new Long(0));
		int.class.getSimpleName();
		Integer.class.getSimpleName();

		List<?> listUnbounded = new ArrayList<Integer>();
		listUnbounded.get(0);// will get Object
		// listUnbounded.add(new Object()); error
		listUnbounded = new ArrayList<String>();
	}

	@Test
	public void testTypeInfer() {
		Arrays.asList(1.0, 1.0);// Double
		Arrays.asList(1.0, 1L);// ? extends Number
		Arrays.asList(1.0, 1L, "haha");// ? extends Object
		for (Object o : Arrays.asList(new int[1])) {
			System.out.println(o.getClass().getCanonicalName());
		}
		for (Object o : Arrays.asList(new Number[] { 1 })) {
			System.out.println(o.getClass().getCanonicalName());
		}
		System.out.println(int.class.getCanonicalName());
		int a = Integer.valueOf(0);

	}

	@Test
	public void testSoftReference() {
		List<SoftReference<Integer>> references = new LinkedList<>();
		Integer[] ints = new Integer[6];
		for (int i = 0; i < ints.length; i++) {
			Integer curr = new Integer(i);
			if (i % 3 == 0) {
				ints[i] = curr;
			}
			references.add(new SoftReference<Integer>(curr));
		}
		System.gc();
		System.gc();
		for (int i = 0; i < references.size(); i++) {
			System.out.println("reference get: " + references.get(i).get());
		}
	}

	enum TestIdHashCodeEnum {
		Enum1, Enum2
	}
	@Test
	public void testIdentityHash() {
		String str1 = new String("string 1");
		String str2 = str1.intern();
		System.out.println("str1 == str2 : " + str1 == str2);
		System.out.println("str1 hashCode " + str1.hashCode());
		System.out.println("str2 hashCode " + str2.hashCode());
		System.out.println("str1 idHashCode " + System.identityHashCode(str1));
		System.out.println("str2 idHashCode " + System.identityHashCode(str2));
		System.out.println("Enum1 idHashCode: " + System.identityHashCode(TestIdHashCodeEnum.Enum1));
		System.out.println("Enum2 idHashCode: " + System.identityHashCode(TestIdHashCodeEnum.Enum2));
		System.out.println("Enum1 valueof idHashCode: " + System.identityHashCode(TestIdHashCodeEnum.valueOf("Enum1")));
	}
	
	
	public static class GrandPa {
		public static int a = 1;
	}

	public static class Father extends GrandPa {
		public static int a = 2;
	}
	
	@Test
	public void testNewDate() {
		long timeL = 1429788765435L;
	}
	
	//start testLambda
	private <T> T supply(Supplier<T> supplier) {
		return supplier.get();
	}
	
	private <T, R> void action(T t, Function<T, R> function) {
		System.out.println(function.apply(t));
	}
}
