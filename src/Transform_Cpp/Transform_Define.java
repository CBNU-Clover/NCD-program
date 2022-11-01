package Transform_Cpp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Transform_Define { // 선언 순서도에 대한 호출 함수
    public String finalstring; // C++ 로 변환된 코드 내용을 String 형태로 finalstring 변수에 저장

    public void output() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        //JSON 파일 읽기
        Reader reader = new FileReader("C:\\Users\\tlsgy\\JAVA+Spring\\Block\\DefineBlock.json"); //JSON 파일 읽어오기
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        //jsonObject.get("")-> 각 key에 맞는 value 값 읽어와서 변수에 저장
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
