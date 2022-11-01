package Transform_Cpp;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Transform_Output
{
    public String finalstring;
    public String headerfile="<iostream>";


    public void output() throws IOException,ParseException{
        JSONParser parser=new JSONParser();
        //JSON 파일 읽기
        Reader reader =new FileReader("C:\\Users\\tlsgy\\JAVA+Spring\\Block\\OutputBlock.json");
        JSONObject jsonObject=(JSONObject) parser.parse(reader);

        long BlockType =(Long)jsonObject.get("BlockType");
        long id=(Long)jsonObject.get("BlockID");
        long price=(Long)jsonObject.get("NextBlockID");
        String Variable_name=(String)jsonObject.get("Variable_name");
        finalstring="cout << "+Variable_name + ";";
    }

}
