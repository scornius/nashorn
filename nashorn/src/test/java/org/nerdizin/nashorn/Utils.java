package org.nerdizin.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.Arrays;

public class Utils {

	public static String getSampleString() {
		return "All animals are created equal";
	}

	public static void printClass(final Object object) {
		System.out.println(object.getClass());
	}

	public static void printValue(final ScriptObjectMirror mirror) {
		System.out.println(mirror.getClassName());
		System.out.println(Arrays.toString(mirror.getOwnKeys(true)));
		System.out.println(mirror.getMember("myKey"));
	}

	public static void callMethod2(final Object o) {
		System.out.println(o.toString());
	}

	public static void callMethod(final ScriptObjectMirror mirror) {
		System.out.println(mirror.callMember("getName"));
	}
}
