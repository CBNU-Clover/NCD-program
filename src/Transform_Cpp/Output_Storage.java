package Transform_Cpp;

public class Output_Storage {
    public String headerfile; // 헤더파일
    public String code; // 순서도에서 C++로 변환된 코드 저장
    public Output_Storage(String headerfile,String code)
    {
        this.headerfile=headerfile; // 헤더파일 저장
        this.code=code; // 순서도에서 C++로 변환된 코드 저장
    }

    public String getHeaderfile() {
        return headerfile; //헤더파일 값 반환
    }

    public String getCode() {
        return code; // 순서도에서 C++로 변환된 코드 반환
    }
}
