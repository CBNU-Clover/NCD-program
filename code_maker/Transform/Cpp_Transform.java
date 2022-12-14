/*
* 브릿지코드를 cpp로 바꿔주는 클래스
* 작성자: 신효민
* 수정: 이혁수
* */
package code_maker.Transform;

import code_maker.Output_Storage;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Cpp_Transform {
    public static Output_Storage Action(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하는 리스트
        String code = (String) block.get("Code");
        finalstring = code+"\n";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }

    public static Output_Storage Condition(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String>headerfile=new ArrayList<String>(); // 출력을 위해서는 iostream 헤더파일이 필요하다.
        String condition=(String)block.get("Condition");
        finalstring ="if("+condition+"){\n";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }

    public static Output_Storage Else(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String>headerfile=new ArrayList<String>(); // 출력을 위해서는 iostream 헤더파일이 필요하다.
        finalstring ="else{\n";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }

    public static Output_Storage Define(JSONObject block){
        String finalstring; // C++ 로 변환된 코드 내용을 String 형태로 finalstring 변수에 저장
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일를 저장하고 있는 리스트
        String datatype  = (String) block.get("Datatype");
        String identifier  = (String) block.get("Identifier");
        String initial_value  = (String) block.get("Initialvalue");
        finalstring =datatype+" "+identifier+"="+initial_value+";\n";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }
    public static Output_Storage End(JSONObject block){
        String finalstring;
        ArrayList<String> headerfile=new ArrayList<String>();
        String Return = (String) block.get("Return");
        finalstring = "return "+Return+";\n";
        return (new Output_Storage(headerfile,finalstring));
    }

    public static Output_Storage Input(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하고 있는 리스트
        String variable = (String) block.get("Variable");
        headerfile.add("iostream");
        finalstring = "std::cin >>"+variable+";\n";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }

    public static Output_Storage Loop(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String>headerfile=new ArrayList<String>(); // 출력을 위해서는 iostream 헤더파일이 필요하다.
        String initialization=(String)block.get("Initialization");
        String condition=(String)block.get("Condition");
        String update=(String)block.get("Update");
        finalstring="for("+initialization+";"+condition+";"+update+"){\n";


        return (new Output_Storage(headerfile,finalstring));
    }

    public static Output_Storage Output(JSONObject block){
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하고 있는 리스트
        String variable = (String) block.get("Value");
        headerfile.add("iostream");
        finalstring = "std::cout <<"+variable+";\n";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }

    public static Output_Storage Pattern(JSONObject block){ // 패턴 순서도에 대한 호출 함수
        String finalstring; // C++로 변환된 코드를 저장하는 변수
        ArrayList<String> headerfile=new ArrayList<String>(); // 출력을 위해서는 iostream 헤더파일이 필요하다.
        String name = (String) block.get("Name");
        String argument=(String)block.get("Argument");
        String return_value=(String)block.get("Return");
        finalstring =return_value+"="+name+"("+argument+");\n";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }

    public static Output_Storage Start(JSONObject block){
        String finalstring;
        ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일을 저장하고 있는 리스트
        finalstring = "int main()\n{\n";
        return (new Output_Storage(headerfile,finalstring)); //Output_Storage 객체를 생성하고 값을 집어넣은 다음 반환
    }
}
