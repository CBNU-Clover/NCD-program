package code_maker.Transform_Cpp;

import code_maker.Output_Storage;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Transform_End { // 종료 순서도에 대한 호출 함수


    public static Output_Storage End_out(JSONObject block){
        String finalstring;
        ArrayList<String> headerfile=new ArrayList<String>();
        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String Return = (String) block.get("Return");
        finalstring = "return "+Return+";\n}";
        return (new Output_Storage(headerfile,finalstring));
    }
}