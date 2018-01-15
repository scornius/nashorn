package org.nerdizin.nashorn;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

public class CallJSFunctionTest {

	@Test
	public void testCallFunction_Output() throws FileNotFoundException, ScriptException, NoSuchMethodException {

		final ClassLoader classLoader = getClass().getClassLoader();
		final File script = new File(classLoader.getResource("functions.js").getFile());

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader(script));

		final Invocable invocable = (Invocable) engine;

		final Object result = invocable.invokeFunction("funkyFunction", "Hello");
		System.out.println(result);
		System.out.println(result.getClass());
	}

	@Test
	public void testCallFunction_Input() throws FileNotFoundException, ScriptException, NoSuchMethodException {

		final ClassLoader classLoader = getClass().getClassLoader();
		final File script = new File(classLoader.getResource("functions.js").getFile());

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader(script));

		final Invocable invocable = (Invocable) engine;

		invocable.invokeFunction("printObjectType", "Hello");
		invocable.invokeFunction("printObjectType", new Date());
		invocable.invokeFunction("printObjectType", new Animal("Elefant"));
	}
}
