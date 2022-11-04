package Transform_Cpp;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Transform_Pattern
{
    public String finalstring; // C++로 변환된 코드를 저장하는 변수
    public ArrayList<String> headerfile=new ArrayList<String>(); // 출력을 위해서는 iostream 헤더파일이 필요하다.


    public Output_Storage Pattern_out(JSONObject block){ // 패턴 순서도에 대한 호출 함수

        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String name = (String) block.get("Name");
        String argument=(String)block.get("Argument");
        String return_value=(String)block.get("Return");
        finalstring =return_value+"="+name+"("+argument+");";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }
}
