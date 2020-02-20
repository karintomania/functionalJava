
package helloworld1.lesson1;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import com.google.common.hash.Hashing;


public class Lesson1 {

	// exercise2
	public static void execise2(){
		List<Human> people = Arrays.asList(new Human[]{
								new Human("takashi", 170),
								new Human("kimu"),
								new Human("toida", 180)});

		List<Integer> heights = people.stream()
									.filter(human -> human.height > 0)
									.map(human -> human.height)
									.collect(Collectors.toList());

		if(heights.size() > 0){
			Double ave = heights.stream()
								.mapToDouble(height -> height)
								.average().getAsDouble();

			System.out.println(ave);

		}else{
			System.out.println("no data");
		}



	}


	// sam count
	public static void countSamFunc(){
		List<String> sentences = Arrays.asList(new String[]{
												"Mary read a story to Sam and Isla.",
												"Isla cuddled Sam.",
												"Sam chortled. Sam" });

		String target = "Sam";

		int samCount = sentences.stream().reduce(0, (count, line) -> (
												count + ( line.length() - line.replace(target,"").length() ) / target.length()
												), Integer::sum);
		
		System.out.println(samCount);
	}

	// sam count
	public static void countSam(){
		List<String> sentences = Arrays.asList(new String[]{
												"Mary read a story to Sam and Isla.",
												"Isla cuddled Sam.",
												"Sam chortled. Sam" });
		int samCount = 0;
		String target = "Sam";

		for(String line : sentences){
			samCount += ( line.length() - line.replace(target,"").length() ) / target.length();
		}

		System.out.println(samCount);

	}
	

	// reduce sum
	public static void reduceSum(){
		List<Integer> nums = Arrays.asList(new Integer[]{0,1,2,3,4});
		int sum = nums.stream().reduce(0, (total, x) -> total + x);

		System.out.println(sum);

	}

	// hash
	public static void hashNames(){
		List<String> names = Arrays.asList(new String[]{"Mary", "Isla", "Sam"});

		List<String> hashedNames = new ArrayList<String>();
		for(String name : names){
			hashedNames.add(hashSha256(name));
		}

		for(String hashedName : hashedNames){
			System.out.println(hashedName);
		}

	}

	// hash
	public static void hashNamesFunc(){
		List<String> names = Arrays.asList(new String[]{"Mary", "Isla", "Sam"});

		List<String> hashedNames = names.stream().map(name -> hashSha256(name))
										.collect(Collectors.toList());

		hashedNames.forEach(System.out::println);

	}

	public static String hashSha256(String str){
		String sha256Name = Hashing.sha256()
								.hashString(str, StandardCharsets.UTF_8)
								.toString();
		return sha256Name;
	}

	// square
	public static void square(){
		List<Integer> nums = Arrays.asList(new Integer[]{0,1,2,3,4});

		nums.stream().map(x -> x * x)
					.forEach(System.out::println);


	}

	// 名前の長さを取得
	public static void nameLength(){
		List<String> names = Arrays.asList(new String[]{"Mary", "Isla", "Sam"});

		for(String name : names){
			System.out.println(name.length());
		}

	}


	// 名前の長さを取得
	public static void nameLengthFunc(){
		List<String> names = Arrays.asList(new String[]{"Mary", "Isla", "Sam"});

		names.stream().map(x -> x.length())
		              .forEach(System.out::println);
	}

}