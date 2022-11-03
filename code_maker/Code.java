package code_maker;

import java.util.HashSet;
import java.util.Set;

public class Code {
    /*
    * headerFile : 해당 코드를 실행 시키는데 필요한 헤더파일
    * code : 프로그래밍 코드
    * */
    public Set<String> headerFile;
    public String code;

    Code(){
        headerFile=new HashSet<String>();
    }

}
