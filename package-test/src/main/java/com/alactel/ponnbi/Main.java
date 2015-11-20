package com.alactel.ponnbi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.log4j.Logger;

public class Main {
	private static void usage() {
		System.out.println("Usage: java [-jvmoptions...] -jar " + getJarName() + ".jar [-options...] <module-spec> [args...]");
		System.out.println("       java [-jvmoptions...] -jar " + getJarName() + ".jar [-options...] -jar <jar-name> [args...]");
		System.out.println("       java [-jvmoptions...] -jar " + getJarName() + ".jar [-options...] -cp <class-path> <class-name> [args...]");
		System.out.println("       java [-jvmoptions...] -jar " + getJarName() + ".jar [-options...] -class <class-name> [args...]");
		System.out.println("where <module-spec> is a valid module specification string");
		System.out.println("and options include:");
		System.out.println("    -help         Display this message");
		System.out.println("    -conf 		  <conf path&name>");
		System.out.println("    -data 		  <import file path&name>");
		System.out.println("    -version      Print version and exit\n");
	}
	private static final String JAR_NAME;
	private static final String VERSION_STRING;

	static {
		final Enumeration<URL> resources;
		String jarName = "(unknown)";
		String versionString = "(unknown)";
		try {
			final ClassLoader classLoader = Main.class.getClassLoader();
			resources = classLoader.getResources("META-INF/MANIFEST.MF");
			while (resources.hasMoreElements()) {
				final URL url = resources.nextElement();
				try {
					final InputStream stream = url.openStream();
					if (stream != null)
						try {
							final Manifest manifest = new Manifest(stream);
							final Attributes mainAttributes = manifest.getMainAttributes();
							if (mainAttributes != null) {
								jarName = mainAttributes.getValue("Jar-Name");
								versionString = mainAttributes.getValue("Jar-Version");
							}
						} finally {
							
							stream.close();
						}
				} catch (IOException ignored) {
				}
			}
		} catch (IOException ignored) {
		}
		JAR_NAME = jarName;
		VERSION_STRING = versionString;
	}

	private static String getJarName() {
		// TODO Auto-generated method stub
		return JAR_NAME;
	}

	public static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("================ START ================");
		for (String arg : args) {
			logger.info("args = " + arg);
		}
		logger.info("================  END  ================");
	}

}
