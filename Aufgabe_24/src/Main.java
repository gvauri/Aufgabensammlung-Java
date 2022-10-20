import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.041er-blj.ch/urnussbaumer/blog/api/index.html");
        BufferedReader textObject = new BufferedReader(new InputStreamReader( url.openStream()));
        String textJson=textObject.readLine();

        Object obj = JSONValue.parse(textJson);
        JSONArray array = (JSONArray)obj;

        for (int i = 0; i < array.size(); i++) {
            JSONObject obj2 = (JSONObject)array.get(i);
            outPrint(obj2.get("0").toString(),obj2.get("1").toString(),obj2.get("2").toString(),obj2.get("3").toString(), obj2.get("4").toString());
        }
    }
    public static void outPrint(String id,String creator, String creatDate, String postTitle, String postText) {
        System.out.println(postTitle);
        System.out.println(postText);
        System.out.print("Das erfassungsDatum ist: "+creatDate+"    ");
        System.out.print("Die Post ID ist: "+id+"    ");
        System.out.println("Der erfasser ist: "+creator+"    ");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println();
        System.out.println();
    }
}