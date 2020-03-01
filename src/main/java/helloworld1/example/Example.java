package helloworld1.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import helloworld1.example.*;

public class Example {
	public static void run(){
		List<Band> bands = Arrays.asList(new Band[]{
							new Band("Lin to Shite Samidare", "PK", 2039),
							new Band("Bump Of Beef", "Fujisan", 1998),
							new Band("Gesu no Kiwami Oyaji", "Yamatani Enoki", 2005),
							new Band("Creep pipe pattern", "Ozaki Datsuryokukan", 2008),
							new Band("Osaka Jihen", "Shina Lemon", 1980),
								});

		
		// printBandsAfter2000VocalSorted(bands);
		printBandsAfter2000VocalSortedFunc(bands);

	}

	public static void printBandsAfter2000VocalSortedFunc(List<Band> bands){
		bands.stream()
			.filter(band -> band.getStartYear() >= 2000)
			.sorted(Comparator.comparing(Band::getName).reversed())
			.forEach(System.out::println);
	}

	public static void printBandsAfter2000VocalSorted(List<Band> bands){
		List<Band> result = new ArrayList<Band>();

		for(Band band :bands){
			if(band.startYear >= 2000){
				result.add(band);
			}
		}

		Comparator<Band> comparatorByName = new Comparator<Band>() {
			public int compare(Band band1, Band band2){
				return band1.name.compareTo(band2.name);
			}
		};

		Collections.sort(result,comparatorByName);
		for(Band band : result){
			System.out.println(band.toString());
		}

	}
}