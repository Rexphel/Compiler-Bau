package compiler;

import java.util.Map;

public interface TypedParserObject {

    void codeGen();

    Type typeCheck(Map<String, Type> localVars, Clazz clazz);

}
