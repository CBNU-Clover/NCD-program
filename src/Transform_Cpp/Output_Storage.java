package Transform_Cpp;

import java.util.ArrayList;

public class Output_Storage {
    public ArrayList<String> headerfile=new ArrayList<String>(); // 헤더파일이 저장되어 있는 리스트
    public String code; // 순서도에서 C++로 변환된 코드 저장
    public Output_Storage(ArrayList<String> headerfile,String code)
    {
        this.headerfile=headerfile; // 헤더파일 리스트 저장
        this.code=code; // 순서도에서 C++로 변환된 코드 저장
    }

    public ArrayList<String> getHeaderfile() {
        return headerfile; //헤더파일 리스트 값 반환
    }

    public String getCode() {
        return code; // 순서도에서 C++로 변환된 코드 반환
    }
}
