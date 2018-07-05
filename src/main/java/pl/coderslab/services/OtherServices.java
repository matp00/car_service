package pl.coderslab.services;

public class OtherServices {
    public static String dateFormatChanger(String date){
        String[] splitter=date.split("/");
        StringBuilder sb=new StringBuilder();
        sb.append(splitter[2]).append("-").append(splitter[0]).append("-").append(splitter[1]);
        return sb.toString();
    }
}
