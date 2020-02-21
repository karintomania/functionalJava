
package helloworld1.lesson3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Lesson3 {
	public static void fixBands(){

		System.out.println("using pipeline");

		List<Band> bands = Arrays.asList(new Band[]{
									new Band("sunset rubdown", "UK", false),
									new Band("women", "Germany", false),
									new Band("a silver mt. zion", "Spain", true)});

		bands.stream().map(Band::setCanadaAsCountry)
						.map(Band::capitalizeNames)
						.map(Band::stripPunctuationFromName)
						.forEach(band->System.out.println(band.toString()));
		
	}

	// imperative function
	public static void fixBandsImperatively(){

		List<Band> bands = Arrays.asList(new Band[]{
									new Band("sunset rubdown", "UK", false),
									new Band("women", "Germany", false),
									new Band("a silver mt. zion", "Spain", true)});

		// using for statement
		for(Band band :bands){
			band.country = "Canada";
			band.name = band.name.replace(".", "");
			band.name = Band.title(band.name);
			System.out.println(band.toString());
		}
	}

	

}