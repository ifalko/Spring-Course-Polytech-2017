package ru.spbpu.ics.impls;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import ru.spbpu.ics.annotations.Qualifier;

public class IoCContainer {

	private static Map<String, Object> container = new HashMap<>();

	public static Object produce(Class clazz) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		String name = clazz.getName();
		
		Object object = clazz.newInstance(); // new Computer();
		if (container.containsKey(name)) {
			System.out.println("Container contains this computer");
			return container.get(name);
		} else {
			for (Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);

				if (field.isAnnotationPresent(Qualifier.class)) {

					Qualifier qualifier = field.getAnnotation(Qualifier.class);
					Constructor constructor = field.getType().getConstructors()[0];

					Class[] paramTypes = constructor.getParameterTypes();
					Object obj = field.getType()
										.getConstructor(paramTypes)
										.newInstance(qualifier.freqValue()); // new Cpu("Hz");
					field.set(object, obj);
					container.put(name, object);
				}
			}
		}

		return object;

	}

}
