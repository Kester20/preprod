package provider.map;

import provider.Reader;
import provider.impl.RandomReader;
import provider.impl.ScannerReader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class MapReader {

	private Map<Integer, Reader> mapReader;

	/**
	 * initializes helper map
	 */
	public MapReader() {
		mapReader = new HashMap<Integer, Reader>() {{
			put(1, new ScannerReader());
			put(2, new RandomReader());
		}};
	}

	/**
	 * @return map helper
	 */
	public Map<Integer, Reader> getMapReader() {
		return mapReader;
	}

}
