package org.nerdizin.nashorn;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JavaExtensionsTest {

	@Test
	public void testJavaTypes() throws ScriptException, FileNotFoundException {

		final ClassLoader classLoader = getClass().getClassLoader();
		final File file = new File(classLoader.getResource("javaTypes.js").getFile());

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader(file));
	}

	@Test
	public void testStreams() throws ScriptException, FileNotFoundException {

		final ClassLoader classLoader = getClass().getClassLoader();
		final File file = new File(classLoader.getResource("lambada.js").getFile());

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader(file));
	}

	@Test
	public void testLoad() throws ScriptException, FileNotFoundException {

		final ClassLoader classLoader = getClass().getClassLoader();
		final File file = new File(classLoader.getResource("load.js").getFile());

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader(file));
	}
}
