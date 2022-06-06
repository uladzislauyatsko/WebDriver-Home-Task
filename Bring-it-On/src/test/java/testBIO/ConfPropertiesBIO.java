package testBIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfPropertiesBIO {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static {
        try{
            fileInputStream = new FileInputStream("Bring-it-On/src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);}
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        {
        }
    }public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
