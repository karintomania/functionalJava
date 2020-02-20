

package helloworld1.lesson2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Lesson2 {

	public static String ruleSequence(String str, ArrayList<UnaryOperator<String>> funcs){
		if(funcs.size() > 1){
			return ruleSequence(funcs.remove(0).apply(str), funcs);
		}else{
			return funcs.remove(0).apply(str);
		}
	}

	public static void zeroOne(){
		UnaryOperator<String> zero = (str) -> str.startsWith("0")?str.substring(1):"";
		UnaryOperator<String> one = (str) -> str.startsWith("1")?str.substring(1):"";


		ArrayList<UnaryOperator<String>> functions = new ArrayList<UnaryOperator<String>>();
		functions.add(zero);
		functions.add(one);
		
		System.out.println(ruleSequence("010",functions));
	}

	@FunctionalInterface
	public interface FirstString{
		String method(String str);
	}

	//-----------------------------
	// 関数っぽく
	//-----------------------------

	static Random random = new Random();

	public static List<Integer> moveCars(List<Integer> positions){

		positions = positions.stream().map(position -> {
											if(random.nextDouble() > 0.3){
												position = position + 1;
											}
											return position;
										}).collect(Collectors.toList());

		return positions;
	}

	
	public static Lesson2State runStepRace(Lesson2State state){
		state.time --;
		state.positions = moveCars(state.positions);
		return state;
	}

	public static void outputCar(int position){
		for(int i=0; i < position; i++){
			System.out.print("-");
		}
		System.out.println();
	}

	public static void draw(Lesson2State state){
		System.out.println();
		state.positions.forEach(position -> outputCar(position));
	}

	public static void race(Lesson2State state){
		draw(state);
		if(state.time > 0){
			race(runStepRace(state));
		}
	}

	public static void runRaceFunc(){
		int time = 2;
		List<Integer> positions = Arrays.asList(new Integer[]{1,1,1});

		Lesson2State state = new Lesson2State(time, positions);

		race(state);

	}



	//-----------------------------
	// 従来型
	//-----------------------------

	public static void runRace(){

	int time = 2;
	int[] positions = new int[]{1,1,1};

	Random random = new Random();

	for(int i = 0; i < time; i++){


		System.out.println("");

		// for each car
		for(int j = 0; j < positions.length ; j++ ){

			double rnd = random.nextDouble();

			if(rnd > 0.3){
				positions[j] ++;
			}
			
			for(int k = 0; k < positions[j]; k ++){
				System.out.print("-");
			}
			System.out.println("");
		}
	}


	}



}