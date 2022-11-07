package TestDAta;

import java.util.HashMap;
import java.util.Map;

public class RestfulTestData {




    public Map<String,String> bookingDatesMethods(String checkin, String checkout){
        Map<String,String> bookingExpect=new HashMap<>();
        bookingExpect.put("checkin",checkin);
        bookingExpect.put("checkout",checkout);
        return bookingExpect;
    }
    public Map<String,Object> restfulexpect(String firstname, String lastname,int totalPrice,boolean depositpaid,String additionalsneeds,Map<String,String>bookingDates){
        Map<String,Object>restfulexpect = new HashMap<>();
        restfulexpect.put("firstname",firstname);
        restfulexpect.put("lastname",lastname);
        restfulexpect.put("totalPrice",totalPrice);
        restfulexpect.put("depositpaid",depositpaid);
        restfulexpect.put("bookingdates",bookingDates);
        restfulexpect.put("additionalalsneeds",additionalsneeds);
return restfulexpect;
    }
}




