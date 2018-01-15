package org.nerdizin.nashorn;

public class Animal {

	private String name;

	Animal(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal{" + "name='" + name + '\'' + '}';
	}
}
