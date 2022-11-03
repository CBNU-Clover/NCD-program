package Transform_Cpp;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Transform_Action { // 처리 순서도(블록)에 대한 호출 함수
    public String finalstring; // C++로 변환된 코드를 저장하는 변수
    public ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하는 리스트


    public Output_Storage Action_out(JSONObject block){

        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String code = (String) block.get("Code");
        finalstring = code;
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }
}
