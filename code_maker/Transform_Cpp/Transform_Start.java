package code_maker.Transform_Cpp;

import code_maker.Output_Storage;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Transform_Start { // 시작 순서도에 대한 호출 함수
    public static Output_Storage Start_out(JSONObject block){
        String finalstring;
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하고 있는 리스트
        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        finalstring = "int main()\n{";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }
}
