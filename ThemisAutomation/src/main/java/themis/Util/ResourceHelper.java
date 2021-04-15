package themis.Util;

import themis.TestBase.TestBase;

public class ResourceHelper extends TestBase{
	
	
	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");
        System.out.println(basePath +"/"+ path);
		return basePath +"/"+ path;
}

}
