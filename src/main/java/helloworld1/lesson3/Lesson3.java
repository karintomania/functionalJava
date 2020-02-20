
package helloworld1.lesson3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Lesson3 {
	public static void run(){
		List<Band> bands = Arrays.asList(new Band[]{
									new Band("sunset rubdown", "UK", false),
									new Band("women", "Germany", false),
									new Band("a silver mt. zion", "Spain", true)});

		bands.stream().map(Band::setCanadaAsCountry)
						.forEach(band->System.out.println(band.toString()));
		
	}


}