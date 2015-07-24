package yxc.exp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import yxc.exp.rpc.RaceTestService;

public class CglibExp {

	@Test
	public void readOnlyBeanMap() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		BeanGenerator beanGenerator = new BeanGenerator();
		beanGenerator.addProperty("strField", String.class);
		beanGenerator.addProperty("intField", Integer.class);
		BeanMap.Generator mapGenerator = new BeanMap.Generator();
		Object myBean = beanGenerator.create();
		mapGenerator.setRequire(26);
		mapGenerator.setBean(myBean);
//		mapGenerator.setBean(ImmutableBean.create(myBean));
		BeanMap beanMap = mapGenerator.create();
		System.out.println(beanMap.getPropertyType("strField"));
		beanMap.put("strField", "haha");
		beanMap.put("intField", 123);
		for(Field field : myBean.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			System.out.println(field.getModifiers());
			System.out.println(field.get(myBean));
		}
		System.out.println(beanMap);
	}
	
	@Test
	public void generateBeanForInterface() {
		BeanGenerator bg = new BeanGenerator();
		for(Method method : RaceTestService.class.getDeclaredMethods()) {
			System.out.println(method.getName());
			method.getParameters()
			for(Class<?> clazz : method.getParameterTypes())
				System.out.print(clazz.getCanonicalName() + "\t");
		}
	}
}

