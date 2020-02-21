
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
		Band result = (Band) band.clone();
		result.name = result.name.replace(".", "");

		return result;
	}


	public static Band capitalizeNames(Band band){
		Band result = (Band) band.clone();
		result.name = title(result.name);

		return result;

	}


	public static String title(String name){
		String[] nameSplit = name.split(" ");
		String capitalized = "";
		for(String s: nameSplit){
			capitalized += s.substring(0,1).toUpperCase() + s.substring(1) + " ";
		}

		return capitalized.trim();
	}

	@Override
	public String toString() {
		return "Country: " + this.country +", Name: "+ this.name +", Active: "+ this.active.toString();
	}

	@Override
	protected Object clone(){

		Band clone = new Band(this.name,this.country,this.active);

		return clone;
	}
}