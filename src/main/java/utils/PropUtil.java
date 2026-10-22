package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropUtil {

	 static Properties p = new Properties();

	  static {
	    try {
	      p.load(new FileInputStream("src/test/resources/config.properties"));
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	  public static String get(String k) {
	    return p.getProperty(k);
	  }
}
