/*
* 브릿지 코드를 C++코드로 바꿔주는 클래스
* 작성자: 이혁수
* */
package code_maker;

import code_maker.Transform_Cpp.Transform_Start;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Cpp_CodeMaker extends CodeMaker {

    /*
    * 상속받은 변수
    * protected HashMap<Integer,JSONObject> blocks;
    * protected enum BlockType { START, END, DECLARATION, INPUT, OUTPUT, PCODE, PATTERN, CONDITION, LOOP};
    * */

    public Cpp_CodeMaker(String fileName) throws IOException, ParseException {
        super(fileName);
    }

    @Override
    protected StringBuffer getHeaderStr(Set<String> headers) {
        StringBuffer result=new StringBuffer("");
        for(String header: headers){
            result.append(String.format("#include<%s>\n",header));
        }
        return result;
    }

    @Override
    public String makeCode() {
        Set<String> headers=new HashSet<String>();
        StringBuffer result=new StringBuffer("int main(void){\n");

        /*
        * 실제 작동되는 코드를 만드는 부분
        * */

        //TODO: 들여쓰기 추가
        //TODO: else문 제작
        //TODO: test 필요
        int now=0;
        Stack<Integer> stack=new Stack<Integer>();
        Output_Storage output;
        while(now!=-1){
            JSONObject block=blocks.get(now);
            int type=(int)block.get("BlockType");

            switch ((int) block.get("BlockType")) {
                case 0:
                    output= Transform_Start.Start_out(block);
                    break;
                default:
                    output=new Output_Storage(new ArrayList<>(),"");
                    break;
            }

            headers.addAll(output.headerFile);
            result.append(output.code);

            if(type==BlockType.CONDITION.ordinal()||type==BlockType.LOOP.ordinal()){
                stack.push((int)block.get("End"));
            }

            now=(int)block.get("NextBlockID");
            //다음 블록id가 -1일때 현재 블록탈출
            if(now==-1&&!stack.isEmpty()){
                now=stack.pop();
                result.append("}\n");
            }
        }

        result.append("}\n");

        //헤더 파일 추가
        StringBuffer headerStr=getHeaderStr(headers);
        result=headerStr.append(result);

        return result.toString();
    }

}
