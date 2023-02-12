class Main {

    public static void main(String args[]) throws java.io.IOException {
        javascanner scanner = new javascanner(new java.io.InputStreamReader(System.in));
        MiniJavaParser parser = new MiniJavaParser();

        try {
            parser.yyparse(scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        while (b.yylex() != -1) {
//        }
    }
}