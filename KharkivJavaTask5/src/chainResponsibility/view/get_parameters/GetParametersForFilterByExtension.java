package chainResponsibility.view.get_parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 * class for reading parameters for filter by extension from console
 */
public class GetParametersForFilterByExtension {

	private GetParameters getParameters;
	private List<String> listParams;
	private static final String ASK_BY_EXT = "By extension ?";
	private static final String ASK_THE_EXT = "Enter the extension of file";
	private static final String BY_EXT = "by ext";

	/**
	 * initialize list of parameter names
	 */
	public GetParametersForFilterByExtension() {
		listParams = new ArrayList<>();
		listParams.add(BY_EXT);
		this.getParameters = new GetParameters(listParams);
	}

	/**
	 * reads parameters from console
	 * @return map of parameters, where key - parameter, entry - value
	 */
	public Map<String, Object> getParameters(){
		return getParameters.getParameters(ASK_BY_EXT, ASK_THE_EXT);
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
	public static String getAskByExt() {
		return ASK_BY_EXT;
	}

	/**
	 *
	 * @return question for user
	 */
	public static String getAskTheExt() {
		return ASK_THE_EXT;
	}

	/**
	 *
	 * @return key in map
	 */
	public static String getByExt() {
		return BY_EXT;
	}
}
