package helloworld1.example;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Band {
	String name;
	String vocal;
	int startYear;

	Band( String name, String vocal, int startYear){
		this.name=name;
		this.vocal=vocal;
		this.startYear=startYear;
	}
	
	@Override
	public String toString(){
		return this.name + " :" + this.vocal  + " :" + Integer.toString(this.startYear);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVocal() {
		return vocal;
	}

	public void setVocal(String vocal) {
		this.vocal = vocal;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
}