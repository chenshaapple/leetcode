package yxc.exp;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class PropertiesReader {

	@Test
	public void useSpace() throws IOException {
		Properties prop = new Properties();
		prop.load(
				this.getClass().getClassLoader().getResourceAsStream("connectionPool.properties"));
		prop.forEach( (k,v) -> {System.out.println(k);System.out.println(v);});
	}
}
