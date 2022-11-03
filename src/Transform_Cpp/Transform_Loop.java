package Transform_Cpp;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Transform_Loop { //반복문 순서도에 대한 호출 함수

    public String finalstring; // C++로 변환된 코드를 저장하는 변수
    public ArrayList<String>headerfile=new ArrayList<String>(); // 출력을 위해서는 iostream 헤더파일이 필요하다.
    public ArrayList<Integer> TypeId=new ArrayList<Integer>(); // while문 { } 안에 있는 순서도가 저장되어 있는 arraylist
    // 이제 이 아이디를 어떻게 가져올것인가??



    public Output_Storage Loop_out(JSONObject block){

        int i=0;
        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        long end=(Long)block.get("End");
        String initialization=(String)block.get("Initialization");
        String condition=(String)block.get("Condition");
        String update=(String)block.get("Update");
        finalstring="for("+initialization+","+condition+","+update+")\n"+"{\n";
        Iterator iter = TypeId.iterator();
        while(iter.hasNext()) { // while 문 안에 있는 순서도들의 내용을 가져와서 finalstring에 합친다.
            finalstring+=TypeId.get(i)+"\n";
            i=i+1;
        }
        finalstring+="}";


        return (new Output_Storage(headerfile,finalstring));
    }
}
