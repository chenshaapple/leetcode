package yxc.exp;

import java.time.Instant;

import org.junit.Test;

public class TimeExp {

	@Test
	public void instantNano() {
		System.out.println(Instant.now().getNano());
	}
}
