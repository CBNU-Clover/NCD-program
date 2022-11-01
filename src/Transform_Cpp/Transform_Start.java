package Transform_Cpp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Transform_Start { // 시작 순서도에 대한 호출 함수

    public void output() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        //JSON 파일 읽기
        Reader reader = new FileReader("C:\\Users\\tlsgy\\JAVA+Spring\\Block\\StartBlock.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        long BlockType = (Long) jsonObject.get("BlockType");
        long id = (Long) jsonObject.get("BlockID");
        long price = (Long) jsonObject.get("NextBlockID");
        System.out.println("Start!!");

    }
}
