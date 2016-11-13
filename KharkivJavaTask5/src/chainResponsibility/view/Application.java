package chainResponsibility.view;

import chainResponsibility.builder.ChainBuilder;
import chainResponsibility.directory.Directory;
import chainResponsibility.handlers.RequestHandler;
import chainResponsibility.view.get_parameters.*;
import utility.DateFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 *         class application
 */
public class Application {

	private static final String path = "E:\\new folder";
	private ChainBuilder chainBuilder;
	private GetParametersForFilterByName byName;
	private GetParametersForFilterByExtension byExtension;
	private GetParametersForFilterBySize bySize;
	private GetParametersForFilterByDate byDate;

	public Application() {
		chainBuilder = new ChainBuilder();
		byName = new GetParametersForFilterByName();
		byExtension = new GetParametersForFilterByExtension();
		bySize = new GetParametersForFilterBySize();
		byDate = new GetParametersForFilterByDate();
	}

	/**
	 * starts application
	 *
	 * @throws ParseException
	 */
	public void startApplication() throws ParseException {
		initializeFilters();
		RequestHandler chain = chainBuilder.getChain();

		Directory directory = new Directory();
		directory.fill(path);

		List list = (ArrayList) chain.handleRequest(directory.getResultList());
		System.out.println(list);
	}

	/**
	 * creates filters anyway
	 * first gets maps of parameters
	 * then sees the value of parameter isNeed
	 * if isNeed = true - creates enabled filter
	 * if isNeed = false - creates disabled filter
	 *
	 * @throws ParseException
	 */
	public void initializeFilters() throws ParseException {

		Map<String, Object> paramsByName = byName.getParameters();
		Map<String, Object> paramsByExt = byExtension.getParameters();
		Map<String, Object> paramsBySize = bySize.getParameters();
		Map<String, Object> paramsByDate = byDate.getParameters();

		if ((boolean) paramsByName.get(GetParameters.getIsNeed())) {
			chainBuilder.createFilterByName((String) paramsByName.get(GetParametersForFilterByName.getByName()));
		} else {
			chainBuilder.createFilterByName();
		}

		if ((boolean) paramsByExt.get(GetParameters.getIsNeed())) {
			chainBuilder.createFilterByExtension(
					(String) paramsByExt.get(GetParametersForFilterByExtension.getByExt()));
		} else {
			chainBuilder.createFilterByExtension();
		}

		if ((boolean) paramsBySize.get(GetParameters.getIsNeed())) {
			chainBuilder.createFilterBySize(
					Integer.parseInt((String) paramsBySize.get(GetParametersForFilterBySize.getFirstSize())),
					Integer.parseInt((String) paramsBySize.get(GetParametersForFilterBySize.getSecondSize())));
		} else {
			chainBuilder.createFilterBySize();
		}

		if ((boolean) paramsByDate.get(GetParameters.getIsNeed())) {
			chainBuilder.createFilterByDate(
					DateFormatter.format((String) paramsByDate.get(GetParametersForFilterByDate.getFirstDate())).getTime(),
					DateFormatter.format((String) paramsByDate.get(GetParametersForFilterByDate.getSecondDate())).getTime());
		} else {
			chainBuilder.createFilterByDate();
		}
	}
}
