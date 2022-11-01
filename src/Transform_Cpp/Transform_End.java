package Transform_Cpp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Transform_End {
    public String finalstring;

    public void output() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        //JSON 파일 읽기
        Reader reader = new FileReader("C:\\Users\\tlsgy\\JAVA+Spring\\Block\\EndBlock.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        long BlockType = (Long) jsonObject.get("BlockType");
        long id = (Long) jsonObject.get("BlockID");
        long price = (Long) jsonObject.get("NextBlockID");
        String Return = (String) jsonObject.get("Return");
        finalstring = "return "+Return;
        System.out.println(finalstring);
    }
}