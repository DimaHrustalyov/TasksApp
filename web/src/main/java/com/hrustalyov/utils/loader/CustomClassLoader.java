package com.hrustalyov.utils.loader;

import com.hrustalyov.utils.json.factory.JsonBuilderFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomClassLoader implements BeanClassLoaderAware {

	private JsonBuilderFactory builderFactory;

	public JsonBuilderFactory getLoadedBuilderFactory() {
		return builderFactory;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		try {
			URL[] classLoaderUrls = new URL[]{new URL("file:///D:/utils.jar")};
			URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls, classLoader);
			Class<?> beanClass = urlClassLoader.loadClass("com.hrustalyov.utils.json.factory.JsonBuilderFactoryImpl");
			builderFactory = (JsonBuilderFactory) beanClass.newInstance();

			/*Using reflction*/

			/*Constructor<?> constructor = beanClass.getConstructor();
			Object jsonBuilderFactory = constructor.newInstance();

			Method method = beanClass.getMethod("createJsonBuilder");
			Object jsonBuilder = method.invoke(jsonBuilderFactory);
			jsonBuilder.getClass()
					.getMethod("add", String.class, String.class)
						.invoke(jsonBuilder, "test", "value").getClass()
					.getMethod("build")
						.invoke(jsonBuilder);*/

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
