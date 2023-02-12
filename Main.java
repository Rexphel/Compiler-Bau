class Main {

    public static void main(String args[]) throws java.io.IOException {
        javascanner scanner = new javascanner(new java.io.InputStreamReader(System.in));
        MiniJavaParser parser = new MiniJavaParser();

        try {
            Clazz clazz = (Clazz) parser.yyparse(scanner);
            System.out.println(clazz.toString());
            clazz.typeCheck();
            byte[] bytecode = clazz.codeGen();
            // TODO write to file
        } catch (Exception e) {
            e.printStackTrace();
        }

//        while (b.yylex() != -1) {
//        }
    }
}