
package helloworld1.lesson3;

public class Band{
	String name;
	String country;
	Boolean active;

	Band( String name, String country, Boolean active){
		this.name = name;
		this.country = country;
		this.active = active;
	}

	public static Band setCanadaAsCountry(Band band){
		return band;
	}

	public static Band stripPunctuationFromName (Band band){
		return band;
	}

	public static Band capitalizeNames(Band band){
		return band;
	}

	@Override
	public String toString() {
		return this.country +"-"+ this.name +"-"+ this.active.toString();
	}
}