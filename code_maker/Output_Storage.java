package code_maker;

import java.util.ArrayList;

public class Output_Storage {
    public ArrayList<String> headerFile=new ArrayList<String>(); // 헤더파일이 저장되어 있는 리스트
    public String code; // 순서도에서 C++로 변환된 코드 저장
    public Output_Storage(ArrayList<String> headerfile,String code)
    {
        this.headerFile=headerfile; // 헤더파일 리스트 저장
        this.code=code; // 순서도에서 C++로 변환된 코드 저장
    }
}
