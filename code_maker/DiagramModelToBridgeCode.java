package code_maker;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DiagramModelToBridgeCode {

    public JSONObject getJson(String fileName){
        JSONObject obj=null;
        try {
            Reader reader = new FileReader(fileName);
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(reader);
        }catch (Exception e){
            e.printStackTrace();
        }

        return obj;
    }

    public JSONObject getBridgeCode(){

        JSONObject diagram= getJson("src/json_test/testFile.json");



        Map<Long,JSONObject> blocks=new HashMap<Long,JSONObject>();
        JSONArray blocklist=(JSONArray) diagram.get("nodeDataArray");
        for(int i=0;i<blocklist.size();i++){
            JSONObject code=new JSONObject();
            JSONObject block=(JSONObject) blocklist.get(i);
            Long id=(Long) block.get("key");
            code.put("BlockType",(String) block.get("category"));
            code.put("BlockID",id);

            blocks.put(id,code);
        }

        JSONArray links = (JSONArray) diagram.get("linkDataArray");

        for(int i=0;i<links.size();i++){
            JSONObject edge=(JSONObject)links.get(i);
            Long from=(Long) edge.get("from");
            Long to=(Long) edge.get("to");

            JSONObject block=blocks.get(from);
            block.put("NextBlockID",to);
            blocks.put(from,block);
        }

        JSONArray jsonArray=new JSONArray();

        Iterator<Map.Entry<Long,JSONObject>> entryIterator=blocks.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Long,JSONObject> element =entryIterator.next();
            jsonArray.add(element.getValue());
        }

        JSONObject result=new JSONObject();
        result.put("blocklist",jsonArray);
        return result;
    }
}
