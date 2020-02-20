
package helloworld1.lesson1;

public class Human {
	String name;
	int    height;

	Human(String name){
		this.name = name;
	}

	Human(String name, int height){
		this.name = name;
		this.height = height;
	}


	@Override
	public String toString() {
		return "name=" + this.name + " height=" + Integer.toString(this.height);
	}
}