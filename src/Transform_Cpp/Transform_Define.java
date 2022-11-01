package Transform_Cpp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Transform_Define {
    public String finalstring;

    public void output() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        //JSON 파일 읽기
        Reader reader = new FileReader("C:\\Users\\tlsgy\\JAVA+Spring\\Block\\DefineBlock.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        long BlockType = (Long) jsonObject.get("BlockType");
        long id = (Long) jsonObject.get("BlockID");
        long price = (Long) jsonObject.get("NextBlockID");
        String Datatype = (String) jsonObject.get("Datatype");
        String Identifier = (String) jsonObject.get("Identifier");
        String Initial_value = (String) jsonObject.get("Initial_value");
        finalstring = Datatype+" "+Identifier+"="+Initial_value;
        System.out.println(finalstring);
    }
}
