package code_maker;

import org.json.simple.JSONObject;

public class TextToAttribute {


    static void Define(JSONObject jsonObject, String value){
        String[] tmp=value.strip().split("\n");
        jsonObject.put("Datatype",tmp[0]);
        jsonObject.put("Identifier",tmp[1]);
        jsonObject.put("Initialvalue",tmp[2]);
    }

    static void Input(JSONObject jsonObject, String value){
        String tmp=value.strip();
        jsonObject.put("Variable",tmp);
    }

    static void Output(JSONObject jsonObject, String value){
        String tmp=value.strip();
        jsonObject.put("Value",tmp);
    }

    static void Action(JSONObject jsonObject, String value){
        String tmp=value.strip();
        jsonObject.put("Code",tmp);
    }

    static void Pattern(JSONObject jsonObject, String value){
        String[] tmp=value.strip().split("\n");
        jsonObject.put("Name",tmp[0]);
        jsonObject.put("Argument",tmp[1]);
        jsonObject.put("Return",tmp[2]);
    }

    static void Condition(JSONObject jsonObject, String value){
        String tmp=value.strip();
        jsonObject.put("Condition",tmp);
    }

    static void Loop(JSONObject jsonObject, String value){
        String[] tmp=value.strip().split("\n");
        jsonObject.put("Initialization",tmp[0]);
        jsonObject.put("Condition",tmp[1]);
        jsonObject.put("Update",tmp[2]);
    }
}
