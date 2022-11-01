package Transform_Cpp;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<Output_Storage>op_storage=new ArrayList<Output_Storage>(); // 출력 순서도가 여러개 나올것에 대비해 ArrayList 사용
        System.out.println("원하는 기능을 입력하세요!"); // 임시로 타입 아이디 판별 함수 작성
        Scanner s = new Scanner(System.in);
        // 순서도 타입아이디 받아오기

        int typeId=s.nextInt();
        // 입력 받은 숫자를 정수값 변수 typeId에 저장한다.
        switch(typeId){ // 타입 아이디를 인식하여 거기에 맞는 함수를 호출함.
            case 0:
                Transform_Start startblock=new Transform_Start(); // 시작 순서도에 대한 함수 호출
                startblock.output(); // 함수가 잘 호출되었는지 검사
                break;
            case 1:
                Transform_End endblock=new Transform_End(); // 끝 순서도에 대한 함수 호출
                endblock.output(); // 함수가 잘 호출되었는지 검사
                break;

            case 2:
                Transform_Define defineblock=new Transform_Define(); // 선언 순서도에 대한 함수 호출
                defineblock.output(); // -> JSON 파일안에 JSON 객체를 넣는것이 나을거 같은 느낌(?) -> 한번에 읽어올수 있도록
                break;
            case 3:
                break;

            case 4:
                Transform_Output Output=new Transform_Output(); // 출력 순서도에 대한 함수 호출
                Output.output(); // 출력 순서도에 대한 JSON 파일을 읽어와서 값 저장 
                op_storage.add(new Output_Storage(Output.headerfile,Output.finalstring)); // 헤더파일과 C++로 변환된 코드 저장
                System.out.println(op_storage.get(0).getHeaderfile()); // 잘 저장되었는지 확인
                System.out.println(op_storage.get(0).getCode()); // 잘 저장되었는지 확인
                break;

            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        }
    }
}