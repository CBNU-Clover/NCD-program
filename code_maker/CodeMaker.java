/*
 * 브릿지 코드를 프로그래밍 언어로 바꿔주는 클래스들의 추상클래스
 * 작성자: 이혁수
 * */
package code_maker;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public abstract class CodeMaker {
    /*
    * blocks : 각 순서도 블록들에 해당하는
    * */
    protected HashMap<Integer,JSONObject> blocks;
    protected enum BlockType { START, END, DECLARATION, INPUT, OUTPUT, PCODE, PATTERN, CONDITION, LOOP};
    public CodeMaker(String fileName) throws IOException, org.json.simple.parser.ParseException{
        this.setFile(fileName);
    }

    /*
     * 입력받은 파일 이름에 해당하는 json 파일을 읽어와 저장하는 함수
     * fileName : 읽어올 파일의 이름
     * */
    private void clear(){
        blocks.clear();
    }

    /*
    * 입력받은 파일 이름에 해당하는 json 파일을 읽어와 저장하는 함수
    * fileName : 읽어올 파일의 이름
    * */
    public void setFile(String fileName)  throws IOException, org.json.simple.parser.ParseException{
        this.clear();

        Reader reader = new FileReader(fileName);
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(reader);

        JSONArray jsonArr = (JSONArray) obj.get("blocklist");
        for(int i=0;i<jsonArr.size();i++){
            JSONObject block = (JSONObject) jsonArr.get(i);
            int id = (int)block.get("BlockID");
            this.blocks.put(id,block);
        }
    }

    /*
    * json파일에서 입력 받은 내용을 이용해 프로그래밍언어로 된 코드 작성
    * */
    public abstract String makeCode();

    /*
     * header들의 set을 입력으로 주면 그에 해당하는 string으로 제작하여 반환
     * headers : 실행가능한 코드로 변환하고자하는 헤더들의 집합
     * */
    protected abstract StringBuffer getHeaderStr(Set<String> headers);


}
