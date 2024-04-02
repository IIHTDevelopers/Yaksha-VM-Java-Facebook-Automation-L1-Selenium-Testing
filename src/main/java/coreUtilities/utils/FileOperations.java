package coreUtilities.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FileOperations 
{
	public JSONParser jsonParser;
	public JSONObject jsonObject;
	public Fillo fillo;
	public Connection connection;
	public Properties properties;
	
	
	/**
	 * This method is useful to read the JSON file which must be simple in structure
	 * @param file - {@link String} JSON file location
	 * @param readQuery - {@link String} - The main parent node
	 * @return {@link Map}
	 * @throws FilloException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> readJson(String file, String jsonNode) throws FileNotFoundException, IOException, ParseException
	{
		
		return null;
	}
	
}