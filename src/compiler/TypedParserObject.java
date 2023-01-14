package compiler;

import java.util.Map;
import java.util.Vector;

public interface TypedParserObject {

    public void codeGen();

    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes);

}
