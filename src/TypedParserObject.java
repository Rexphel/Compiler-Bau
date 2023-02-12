import java.util.Map;

public interface TypedParserObject {

    Type typeCheck(Map<String, Type> localVars, Clazz clazz);

}
