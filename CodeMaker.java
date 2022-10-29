import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public abstract class CodeMaker {
    private HashMap<Object,JSONObject> blocks;

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
            Object id = block.get("BlockID");
            this.blocks.put(id,block);
        }
    }

    /*
    * json파일에서 입력 받은 내용을 이용해 프로그래밍언어로 된 코드 작성
    * */
    public abstract String makeCode();

    /*
    * block을 입력으로 주면 그에 해당하는 Code 자료구조를 반환
    * */
    protected abstract Code getCode(JSONObject block);


}
