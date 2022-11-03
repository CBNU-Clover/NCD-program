package Transform_Cpp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Transform_Define { // 선언 순서도에 대한 호출 함수
    public String finalstring; // C++ 로 변환된 코드 내용을 String 형태로 finalstring 변수에 저장
    public ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일를 저장하고 있는 리스트
    public Output_Storage Define_out(JSONObject block){

        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String datatype  = (String) block.get("Datatype");
        String identifier  = (String) block.get("Identifier");
        String initial_value  = (String) block.get("Initialvalue");
        finalstring =datatype+" "+identifier+"="+initial_value+";";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }
}
