package hit.common;  
  
import java.io.File;  
import java.io.IOException;  
import java.util.ArrayList;  
import java.util.List;  
  
import org.mybatis.generator.api.MyBatisGenerator;  
import org.mybatis.generator.config.Configuration;  
import org.mybatis.generator.config.xml.ConfigurationParser;  
import org.mybatis.generator.internal.DefaultShellCallback;  
  
public class DataBaseUtil {  
    public static void main(String[] args) {  
        DataBaseUtil generatorSqlMap=new DataBaseUtil();  
        try {  
            generatorSqlMap.generator();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    private void generator() throws Exception {  
        List<String> warnings = new ArrayList<String>();  
           boolean overwrite = true;  
           File configFile = new File("F:/generatorConfig.xml");  
           ConfigurationParser cp = new ConfigurationParser(warnings);  
           Configuration config = cp.parseConfiguration(configFile);  
           DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
           MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);  
           myBatisGenerator.generate(null);  
    }  
}  