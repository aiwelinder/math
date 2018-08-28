class Main {

    private static Var x = new Var("x");

    private static void test1 (Expr e) {
	System.out.println("---------------------------");

	System.out.println("e=" + e);

	Expr dedx = e.derivative(x);
	System.out.println("de/dx=" + dedx);
    };
    
    public static void main(String[] args) {
	test1 (new Const(4));
	test1 (x);
	test1 (new Var("b"));
    };
};
