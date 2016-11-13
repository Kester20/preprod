package chainResponsibility.view.get_parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 * class for reading parameters for filter by name from console
 */
public class GetParametersForFilterByName {

	private GetParameters getParameters;
	private List<String> listParams;
	private static final String ASK_BY_NAME = "By name ?";
	private static final String ASK_THE_NAME_OF_FILE = "Enter the name of file";
	private static final String BY_NAME = "by name";

	/**
	 * initialize list of parameter names
	 */
	public GetParametersForFilterByName() {
		listParams = new ArrayList<>();
		listParams.add(BY_NAME);
		this.getParameters = new GetParameters(listParams);
	}

	/**
	 * reads parameters from console
	 * @return map of parameters, where key - parameter, entry - value
	 */
	public Map<String, Object> getParameters(){
		return getParameters.getParameters(ASK_BY_NAME, ASK_THE_NAME_OF_FILE);
	}

	/**
	 *
	 * @return instance of getParameters
	 */
	public GetParameters getGetParameters() {
		return getParameters;
	}

	/**
	 *
	 * @return list of parameters names
	 */
	public List<String> getListParams() {
		return listParams;
	}

	/**
	 *
	 * @return question for user
	 */
	public static String getAskByName() {
		return ASK_BY_NAME;
	}

	/**
	 *
	 * @return question for user
	 */
	public static String getAskTheNameOfFile() {
		return ASK_THE_NAME_OF_FILE;
	}

	/**
	 *
	 * @return key in map
	 */
	public static String getByName() {
		return BY_NAME;
	}
}
