import java.util.Objects;

public class Type {

    public static final Type BOOLEAN = new Type("boolean");
    public static final Type INTEGER = new Type("int");
    public static final Type STRING = new Type("String");
    public static final Type VOID = new Type("void");
    public static final Type NULL = new Type("null");
    public static final Type CHAR = new Type("char");

    final String type;

    public Type(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        return Objects.equals(type, type1.type);
    }

    @Override
    public String toString() {
        return "Type{" +
                "type='" + type + '\'' +
                '}';
    }

    public String getTypeLiteral(){
        return switch (type) {
            case "boolean" -> "Z";
            case "int" -> "I";
            case "String" -> "Ljava/lang/String;"; 
            case "char" -> "C";
            case "void" -> "V";
            default -> "L"+ type + ";";
        };
    }

    public boolean isObjectType(){
        return switch (type){
            case "boolean", "int", "char", "void" -> false;
            default -> true;
        };
    }

    public boolean equalz(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        if (Objects.equals(type, type1.type)){
            return true;
        }
        return ((this.type.equals("int") && type1.type.equals("char")) || (this.type.equals("char") && type1.type.equals("int")));
    }

}
