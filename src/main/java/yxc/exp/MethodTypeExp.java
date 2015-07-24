package yxc.exp;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.junit.Test;

public class MethodTypeExp {

	@Test
	public void lookup() throws Throwable {
		String context = "context";
		MethodHandles.Lookup lk = MethodHandles.lookup();
		MethodHandle mh = lk.findVirtual(getClass(), "toString", MethodType.methodType(String.class));
		
		MethodHandle staticHandle = lk.findStatic(getClass(), "staticMethod", MethodType.methodType(String.class));
		System.out.println(staticHandle.invoke(Void.class));
		System.out.println(mh.invoke(this));
	}
	
	@Override
	public String toString() {
		return "MethodTypeExp";
	}
	
	public static String staticMethod() {
		return "Static Method";
	}
}
