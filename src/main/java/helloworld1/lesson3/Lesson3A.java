package helloworld1.lesson3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;


public class Lesson3A {

	public static void run(){
		List<Car> cars = createCars();
		// List<String> models = getModelsAfter2000UsingFor(cars);
		List<String> models = getModelsAfter2000(cars);

		models.forEach(System.out::println);
		
	}

public static List<String> getModelsAfter2000(final List<Car> cars) {
	return cars.stream().filter(car -> car.getYear()>2000)
						.sorted(Comparator.comparingInt(Car::getYear))
						.map(Car::getModel)
						.collect(Collectors.toList());
}

public static List<String> getModelsAfter2000UsingFor(final List<Car> cars) {
	List<Car> carsSortedByYear = new ArrayList<>();
	
    for(Car car : cars) {
      if(car.getYear() > 2000) {
        carsSortedByYear.add(car);
      }
    }
    
    Collections.sort(carsSortedByYear, new Comparator<Car>() {
      public int compare(Car car1, Car car2) {
        return new Integer(car1.getYear()).compareTo(car2.getYear());
      }
	});
	
    
    List<String> models = new ArrayList<>();
    for(Car car : carsSortedByYear) {
      models.add(car.getModel());
    }
    
    return models;
  }

  public static List<Car> createCars() {
    return Arrays.asList(
      new Car("Jeep", "Wrangler", 2011),
      new Car("Jeep", "Comanche", 1990),
      new Car("Dodge", "Avenger", 2010),
      new Car("Buick", "Cascada", 2016),
      new Car("Ford", "Focus", 2012),
      new Car("Chevrolet", "Geo Metro", 1992)
    );
  }
	
}