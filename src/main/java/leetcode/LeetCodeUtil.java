package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

import org.junit.Test;

class Demo {
	public static void printTreeInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printTreeInorder(root.left);
		System.out.print(root.val + "->");
		printTreeInorder(root.right);
	}

}

class Train {
	public static int CAPACITY = 1;
	private final long[] goodsArray; // 传输运输货物的数组

	private int index;

	public Train() {
		goodsArray = new long[CAPACITY];
	}

	public int goodsCount() { // 返回货物数量
		return index;
	}

	public void addGoods(long i) { // 向列车中添加条目
		goodsArray[index++] = i;
	}

	public long getGoods(int i) { // 从列车中移走条目
		index--;
		return goodsArray[i];
	}

	public int getCapacity() {
		return CAPACITY;
	}
}

class Railway {
	private final Train train = new Train();
	private final AtomicLong index = new AtomicLong();
	private final int stationCount = 2;

	public Train waitForTrain(final int stationNo) {
		while (index.get() % stationCount != stationNo) {
			Thread.yield();
		}
		return train;
	}

	public void sendTrain() {
		index.getAndIncrement();
	}
}

public class LeetCodeUtil {
	private static final Deque<Integer> deque = new LinkedList<>();
	private static int i = 0;
	private static int sampleT = 100000;

	@Test
	public void testRailWay() {
		final Railway railway = new Railway();
		final long n = 20000000000l;
		// 启动一个消费者进程
		new Thread() {
			long lastValue = 0;

			@Override
			public void run() {
				while (lastValue < n) {
					Train train = railway.waitForTrain(1); // 在#1站等列车
					int count = train.goodsCount();
					for (int i = 0; i < count; i++) {
						lastValue = train.getGoods(i); // 卸货
					}
					railway.sendTrain(); // 将当前列车送到第一站
				}
			}
		}.start();

		final long start = System.nanoTime();
		long i = 0;
		while (i < n) {
			Train train = railway.waitForTrain(0); // 在#0站等列车
			int capacity = train.getCapacity();
			for (int j = 0; j < capacity; j++) {
				train.addGoods((int) i++); // 将货物装到列车上
			}
			railway.sendTrain();
			if (i % sampleT == 0) { // 每隔100M个条目测量一次性能
				final long duration = System.nanoTime() - start;
				final long ops = (i * 1000L * 1000L * 1000L) / duration;
				System.out.format("ops/sec = %,d\n", ops);
				System.out.format("trains/sec = %,d\n", ops / Train.CAPACITY);
				System.out.format("latency nanos = %.3f%n\n", duration
						/ (float) (i) * (float) Train.CAPACITY);
			}
		}
	}

	public static void main(String[] args) {
		Thread producer = new Thread(new Runnable() {
			public void run() {
				long start = System.nanoTime();
				while (true) {
					synchronized (deque) {
						if (deque.size() < 5) {
							// System.out.println("produce");
							deque.addLast(new Random().nextInt());
							i++;
						} else {
							Thread.yield();
						}
						if (i % sampleT == 0) {
							System.out.format("ops/sec = %d\n", i * 1000L
									* 1000L * 1000L
									/ (System.nanoTime() - start));
							break;
						}
						deque.notifyAll();
					}
				}
			}
		});
		producer.start();
		Thread consumer = new Thread(new Runnable() {
			public void run() {
				while (true) {
					synchronized (deque) {
						try {
							deque.wait();
							if (!deque.isEmpty()) {
								deque.pollFirst();
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		consumer.start();
	}
}