public class CompilerTestTest {
    public static void main(String[] args) {
        CompilerTest cT = new CompilerTest();
        System.out.println("The initial value of field i is: " + cT.getI());
        cT.setI(5);
        System.out.println("i should now be 5 and is: " + cT.getI());
        System.out.println("Here is a char: " + cT.getC());
        System.out.println("The negation of field f is: "+ cT.getNotF());
        cT = cT.getNew();
        System.out.println("i after a reset is: " + cT.getI());
        System.out.println("the volume of a cuboid (h:3, w:4, l:5) is:" + cT.calculateVolumeOfCuboid(3, 4, 5));
        System.out.println("Now we have some complex Calculation\n the result for parameters (35, 27, 6) should be 3 and is " + cT.complexCalculation(35, 27, 6));
        System.out.println(" 5 < 6 :" + cT.lt('5', '6'));
        System.out.println(" 5 > 6 :" + cT.gt('5', '6'));
    }
}
