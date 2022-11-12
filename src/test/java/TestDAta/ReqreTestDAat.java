package TestDAta;

import java.util.HashMap;
import java.util.Map;

public class ReqreTestDAat {

    public Map<String,String>expectedData(String name,String job){
        Map<String,String> data = new HashMap<>();
       if(name!=null){
        data.put("name",name);}
       if(job!=null){
        data.put("job",job);}
        return data;
    }
}
