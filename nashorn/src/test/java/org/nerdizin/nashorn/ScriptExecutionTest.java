package org.nerdizin.nashorn;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ScriptExecutionTest {

	@Test
	public void testScriptExecution_usingString() throws ScriptException {

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval("print('Hello World!');");
	}

	@Test
	public void testScriptExecution_usingFile() throws ScriptException, FileNotFoundException {

		final ClassLoader classLoader = getClass().getClassLoader();
		final File file = new File(classLoader.getResource("helloWorld.js").getFile());

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader(file));
	}
}
