package code_maker.Transform;

import code_maker.Output_Storage;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Cpp_Transform {
    public static Output_Storage Action_out(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하는 리스트
        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String code = (String) block.get("Code");
        finalstring = code;
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }

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

    public static Output_Storage Define_out(JSONObject block){
        String finalstring; // C++ 로 변환된 코드 내용을 String 형태로 finalstring 변수에 저장
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일를 저장하고 있는 리스트
        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String datatype  = (String) block.get("Datatype");
        String identifier  = (String) block.get("Identifier");
        String initial_value  = (String) block.get("Initialvalue");
        finalstring =datatype+" "+identifier+"="+initial_value+";";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }
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

    public static Output_Storage Loop_out(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String>headerfile=new ArrayList<String>(); // 출력을 위해서는 iostream 헤더파일이 필요하다.
        ArrayList<Integer> TypeId=new ArrayList<Integer>(); // while문 { } 안에 있는 순서도가 저장되어 있는 arraylist
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

    public static Output_Storage Output_out(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하고 있는 리스트
        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String variable = (String) block.get("Variable");
        finalstring = "cout <<"+variable+";";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }

    public static Output_Storage Pattern_out(JSONObject block){ // 패턴 순서도에 대한 호출 함수
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String> headerfile=new ArrayList<String>(); // 출력을 위해서는 iostream 헤더파일이 필요하다.

        long BlockType = (Long) block.get("BlockType");
        long id = (Long) block.get("BlockID");
        long price = (Long) block.get("NextBlockID");
        String name = (String) block.get("Name");
        String argument=(String)block.get("Argument");
        String return_value=(String)block.get("Return");
        finalstring =return_value+"="+name+"("+argument+");";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }

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