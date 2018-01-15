package org.nerdizin.nashorn;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CallJavaMethodTest {

	@Test
	public void testCallJavaMethod_Output() throws ScriptException {

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

		final StringBuilder script = new StringBuilder();
		script.append("var Utils = Java.type('Utils');");
		script.append("print(Utils.getSampleString())");

		engine.eval(script.toString());
	}

	@Test
	public void testCallJavaMethod_Input() throws ScriptException {

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

		final StringBuilder script = new StringBuilder();
		script.append("var Utils = Java.type('Utils');");

		script.append("Utils.printClass(123);");
		script.append("Utils.printClass(123.45);");
		script.append("Utils.printClass(true);");
		script.append("Utils.printClass('123');");

		script.append("Utils.printClass(new Date());");
		script.append("Utils.printClass({key: 123});");

		engine.eval(script.toString());
	}

	@Test
	public void testCallJavaMethod_Input_JSON() throws ScriptException {

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

		final StringBuilder script = new StringBuilder();
		script.append("var Utils = Java.type('Utils');");

		script.append("Utils.printValue({myKey: 'myValue', anotherKey: 123});");

		engine.eval(script.toString());
	}

	@Test
	public void testCallJavaMethod_Input_CallMethod() throws ScriptException, FileNotFoundException {

		final ClassLoader classLoader = getClass().getClassLoader();
		final File file = new File(classLoader.getResource("animal.js").getFile());

		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader(file));

		final StringBuilder script = new StringBuilder();
		script.append("var Utils = Java.type('Utils');");
		script.append("var animal = new Animal('Harambe');");

		script.append("Utils.callMethod(animal);");

		engine.eval(script.toString());
	}
}
