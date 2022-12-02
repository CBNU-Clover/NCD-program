import code_maker.CodeMaker;
import code_maker.Cpp_CodeMaker;
import code_maker.DiagramModelToBridgeCode;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DiagramModelToBridgeCode bridgeCode=new DiagramModelToBridgeCode("src/json_test/testFile.json");
        System.out.println(bridgeCode.getBridgeCode());
        try {
            Cpp_CodeMaker codeMaker=new Cpp_CodeMaker(bridgeCode.getBridgeCode());
            System.out.println(codeMaker.makeCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}