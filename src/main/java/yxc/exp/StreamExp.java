package yxc.exp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import com.google.gson.Gson;




public class StreamExp {
	private int value = 1;
	static final LongAdder adder = new LongAdder();
	public StreamExp() {
			adder.add(1);
			try {
				TimeUnit.NANOSECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static StreamExp sum(StreamExp s1, StreamExp s2) {
		StreamExp res = new StreamExp();
		res.value = s1.value + s2.value;
		return res;
	}
	
	@Test
	public void testNewGson() {
		int size = 1000000;
		long beforeSum = System.nanoTime();
		IntStream.range(0, size).forEach(i-> {
			Gson gson = new Gson();
		});
		long thisTakes = System.nanoTime() - beforeSum;
		System.out.println(TimeUnit.NANOSECONDS.toMillis(thisTakes));
	}
	
	@Test
	public void testNewHashMap() {
		int size = 1000000;
		long beforeSum = System.nanoTime();
		IntStream.range(0, size).forEach(i-> {
			Map<String, String> map = new HashMap<>(100);
		});
		long thisTakes = System.nanoTime() - beforeSum;
		System.out.println(TimeUnit.NANOSECONDS.toMillis(thisTakes));
	}
	
	@Test
	public void testNewYaml() {
		int size = 1000000;
		long beforeSum = System.nanoTime();
		IntStream.range(0, size).forEach(i-> {
			Yaml yaml = new Yaml();
		});
		long thisTakes = System.nanoTime() - beforeSum;
		System.out.println(TimeUnit.NANOSECONDS.toMillis(thisTakes));
	}
	
	
	@Test
	public void intStream() {
		int count = 200, size = 6000000;
		long min = Long.MAX_VALUE, max = 0;
		List<Long> resultBucket = new ArrayList<>(200);
		Random seed = new Random();
		
		for(int i = 0; i < count; i++) {
			int randomStart = seed.nextInt(1000);
			long beforeSum = System.nanoTime();
			IntStream.range(randomStart, randomStart + size).sum();
			long thisTakes = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - beforeSum);
			min = Math.min(min, thisTakes);
			max = Math.max(max, thisTakes);
			resultBucket.add(thisTakes);
		}
		System.out.println(min);
		System.out.println(max);
		resultBucket.stream().forEach(l->System.out.println(l));
	}
	
	@Test
	public void heavyStream() {
		int count = 2, size = 10000;
		long min = Long.MAX_VALUE, max = 0;
		List<Long> resultBucket = new ArrayList<>(count);
		List<StreamExp> list = new ArrayList<>(size);
		IntStream.range(0, size).forEach(i->list.add(new StreamExp()));
		StreamExp id = new StreamExp();
		id.value = 0;
		for(int i = 0; i < count; i++) {
			long beforeSum = System.nanoTime();
			StreamExp res = list.parallelStream().reduce(id, StreamExp::sum);
			assertEquals(res.value, size);
			long thisTakes = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - beforeSum);
			min = Math.min(min, thisTakes);
			max = Math.max(max, thisTakes);
			resultBucket.add(thisTakes);
		}
		System.out.println(min);
		System.out.println(max);
		
		min = Long.MAX_VALUE; max = 0;
		for(int i = 0; i < count; i++) {
			long beforeSum = System.nanoTime();
			StreamExp res = list.stream().reduce(id, StreamExp::sum);
			assertEquals(res.value, size);
			long thisTakes = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - beforeSum);
			min = Math.min(min, thisTakes);
			max = Math.max(max, thisTakes);
			resultBucket.add(thisTakes);
		}
		System.out.println(min);
		System.out.println(max);
		
		min = Long.MAX_VALUE; max = 0;
		for(int i = 0; i < count; i++) {
			long beforeSum = System.nanoTime();
			StreamExp res = list.stream().reduce(StreamExp::sum).get();
			assertEquals(res.value, size);
			long thisTakes = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - beforeSum);
			min = Math.min(min, thisTakes);
			max = Math.max(max, thisTakes);
			resultBucket.add(thisTakes);
		}
		System.out.println(min);
		System.out.println(max);
		
		min = Long.MAX_VALUE; max = 0;
		for(int i = 0; i < count; i++) {
			long beforeSum = System.nanoTime();
			StreamExp res = list.parallelStream().reduce(StreamExp::sum).get();
			assertEquals(res.value, size);
			long thisTakes = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - beforeSum);
			min = Math.min(min, thisTakes);
			max = Math.max(max, thisTakes);
			resultBucket.add(thisTakes);
		}
		System.out.println(min);
		System.out.println(max);
		
		System.out.println("adder value: " + StreamExp.adder.longValue());
	}
	
	@Test
	public void sumMaps() {
		Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>(), m3 = new HashMap<>();
		m1.put("a", 1);
		m1.put("b", 1);
		m1.put("c", 1);
		m2.put("a", 1);
		m2.put("b", 1);
		m3.put("a", 1);
		Map<String, Integer> sum = new HashMap<>();
		sum.put("a", 3);
		sum.put("b", 2);
		sum.put("c", 1);
		assertEquals(sum.toString(), 
				Stream.of(m1, m2, m3).map(Map::entrySet).flatMap(Collection::stream)
				.collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                Integer::sum         
            )).toString());
		
		assertEquals(sum.toString(), 
				Stream.of(m1, m2, m3)
				.reduce((a, b)-> {
					b.forEach((k,v) -> a.merge(k, v, Integer::sum));
					return a;
				})
				.get()
				.toString());
		assertEquals(sum.toString(), m1.toString());
	}
}
