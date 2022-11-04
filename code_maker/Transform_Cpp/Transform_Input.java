package code_maker.Transform_Cpp;
import java.util.ArrayList;

import code_maker.Output_Storage;
import org.json.simple.JSONObject;

public class Transform_Input { // 입력 순서도에 대한 호출 함수
    public String finalstring; // C++로 변환된 코드를 저장하는 변수
    public ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하고 있는 리스트


    public static Output_Storage Input_out(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하고 있는 리스트
        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String variable = (String) block.get("Variable");
        finalstring = "cin >>"+variable+";";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }
}
