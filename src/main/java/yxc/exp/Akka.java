package yxc.exp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.io.Tcp;

public class Akka {
	private int id;
	private String name;
	private Akka akka;
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("mySystem");
		ActorRef tcpManager = Tcp.get(system).getManager();
		int httpSenderSize = 100;
		List<ActorRef> senders = new ArrayList<>(httpSenderSize);
		long before = System.nanoTime();
		for (int i = 0; i < httpSenderSize; i++) {
			senders.add(system.actorOf(Props.create(MyActor.class, httpSenderSize), String.valueOf(i)));
		}
		
		long duration = System.nanoTime() - before;
		System.out.println(String.format("Init %d senders takes: %dms.",
				httpSenderSize, TimeUnit.NANOSECONDS.toMillis(duration)));
		System.out.println(LocalDateTime.now());
		before = System.nanoTime();
		senders.parallelStream().forEach(a -> a.tell("http://www.baidu.com/", ActorRef.noSender()));
		duration = System.nanoTime() - before;
		System.out.println(String.format("send takes %dms", TimeUnit.NANOSECONDS.toMillis(duration)));
	}
}

class MyActor extends UntypedActor {
	private static HttpClient httpClient = HttpClients.custom()
			.setConnectionManager(new PoolingHttpClientConnectionManager())
			.build();

	private static int size;
	private static LongAdder adder = new LongAdder();
	
	public MyActor(int size) {
		MyActor.size = size;
	}
	
	@Override
	public void onReceive(Object message) throws Exception {
		HttpGet get = new HttpGet((String) message);
		HttpResponse response = HttpClients.createDefault().execute(get);
		get.releaseConnection();
		if(response.getStatusLine().getStatusCode() != 200)
			System.out.println(response.getStatusLine().getStatusCode());
		adder.increment();
		System.out.println(adder.intValue());
		if(adder.intValue() == size) {
			System.out.println(LocalDateTime.now());
			getContext().stop(getSelf());
		}
	}
}