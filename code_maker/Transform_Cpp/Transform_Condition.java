package code_maker.Transform_Cpp;
import java.util.ArrayList;
import java.util.Iterator;

import code_maker.Output_Storage;
import org.json.simple.JSONObject;

public class Transform_Condition { // 조건문 순서도에 대한 호출 함수

    //



    public static Output_Storage Condition_out(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String>headerfile=new ArrayList<String>(); // 출력을 위해서는 iostream 헤더파일이 필요하다.
        ArrayList<Integer> TypeId=new ArrayList<Integer>(); // if 문 { } 안에 있는 순서도 아이디가 저장되어 있는 arraylist
        int i=0;
        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        long Else = (Long) block.get("Else");
        long end=(Long)block.get("End");
        String condition=(String)block.get("Condition");
        finalstring ="if("+condition+")\n{";
        Iterator iter = TypeId.iterator();
        while(iter.hasNext()) { // if 문 안에 있는 순서도들의 내용을 가져와서 finalstring에 합친다.
            finalstring+=TypeId.get(i)+"\n";
            i=i+1;
        }
        finalstring+="}";
        // else 뒤 블럭은 어떻게 하는게 좋을까?? -> 상의를 해봐야 할 것 같다.

        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }
}
