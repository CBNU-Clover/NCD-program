import code_maker.CodeMaker;
import code_maker.Cpp_CodeMaker;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            Cpp_CodeMaker codeMaker=new Cpp_CodeMaker("C:/Users/이혁수/IdeaProjects/NCD-program/src/test/testFile4.json");
            System.out.println(codeMaker.makeCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}