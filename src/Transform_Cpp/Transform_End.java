package Transform_Cpp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Transform_End { // 종료 순서도에 대한 호출 함수
    public String finalstring;
    public ArrayList<String> headerfile=new ArrayList<String>();

    public Output_Storage End_out(JSONObject block){

        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String Return = (String) block.get("Return");
        finalstring = "return "+Return+";\n}";
        return (new Output_Storage(headerfile,finalstring));
    }
}