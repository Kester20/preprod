package chainResponsibility.view.get_parameters;

import java.util.*;

/**
 * @author Arsalan
 * class for reading values of parameter from console
 */
public class GetParameters {

	private Map<String, Object> parametersMap;
	private List<String> nameOfParameters;
	private Scanner scanner;
	private static final String IS_NEED = "isNeed";

	/**
	 * initialize map of parameters and their values
	 * map keys - parameter name, entry - value of parameter
	 * @param nameOfParameters list of parameter names
	 */
	public GetParameters(List<String> nameOfParameters) {
		parametersMap = new HashMap<>();
		this.nameOfParameters = nameOfParameters;
		scanner = new Scanner(System.in);
	}

	/**
	 * reads values of parameter from console
	 * @param firstAsk first question for user('by name?', 'by size?')
	 * @param secondAsk concrete question for user ('enter the name', 'enter the size')
	 * @return map of parameters and their values
	 * map keys - parameter name, entry - value of parameter
	 */
	public Map<String, Object> getParameters(String firstAsk, String secondAsk) {
		System.out.println(firstAsk);
		int z = scanner.nextInt();
		if (z == 1) {
			System.out.println(secondAsk);
			parametersMap.put(IS_NEED, true);
			for (String nameOfParam : nameOfParameters) {
				parametersMap.put(nameOfParam, scanner.next());
			}
		} else {
			parametersMap.put(IS_NEED, false);
		}
		return parametersMap;
	}

	/**
	 *
	 * @return map parameters
	 */
	public Map<String, Object> getParametersMap() {
		return parametersMap;
	}

	/**
	 *
	 * @return list of parameter names
	 */
	public List<String> getNameOfParameters() {
		return nameOfParameters;
	}

	/**
	 *
	 * @return object of scanner
	 */
	public Scanner getScanner() {
		return scanner;
	}

	/**
	 *
	 * @return key in map 'isNeed'
	 */
	public static String getIsNeed() {
		return IS_NEED;
	}
}
