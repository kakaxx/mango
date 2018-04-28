
package cn.li.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {

    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指向逆向工程配置文件
        File configFile = new File("src/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) throws Exception {
        try {
            System.out.println(GeneratorSqlmap.class.getResource("/"));
            // class path根目录 (指定资源名，可以获取根目录下面的资源)
            System.out.println(GeneratorSqlmap.class.getResourceAsStream("/generatorConfig.xml"));
            InputStream in = new FileInputStream("generatorConfig.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}