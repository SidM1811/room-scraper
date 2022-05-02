import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public abstract class RoomParser {
    public static void getData(String s) throws IOException {
        Document document = Jsoup.connect(s).get();;
        Elements roomData = document.select("area[href~=https://www.sel.cam.ac.uk/php/accommodation/images/rooms/]");
        for(Element e : roomData) {
            System.out.println(e.attr("data-information"));
        }
    }
    public static void main(String[] args){
        try{
            int i = 11;
            RoomParser.getData(String.format("https://www.sel.cam.ac.uk/student-accommodation?house=%s",i));
        }
        catch(Exception e){}
    }
}
class InfoExtractor{
    public static ArrayList<String> getData(Element e,ArrayList<String> attrList){
        ArrayList<String> ans = new ArrayList<>();
        for(String s : attrList) ans.add(String.format(s+" = %s",e.attr(s)));
        return ans;
     }
}