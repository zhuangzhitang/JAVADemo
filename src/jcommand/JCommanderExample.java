package jcommand;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhitang
 * @date 2018/6/27
 */
public class JCommanderExample {

    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = {"-v"})
    private Integer verBose =1;

    @Parameter(names = {"-g"})
    private String groups ;

    @Parameter(names = {"-f"})
    private String filename="";

    public static void main(String[] args) throws Exception {
        JCommanderExample jct = new JCommanderExample();
        //String[] arv = {"-v","2","-g","unit"};
        new JCommander(jct,args);
        System.out.println("-v:"+jct.verBose+"-g:"+jct.groups+"");
        List<String> lines = FileUtils.readLines(new File(jct.filename), "utf-8");
        lines.forEach(System.out::println);
    }


}
