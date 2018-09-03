class Main {

    private static Var x = new Var("x");

    private static void test1 (Expr e) {
	System.out.println("---------------------------");

	System.out.println("e = " + e);

	Expr dedx = e.derivative(x);
	System.out.println("de/dx = " + dedx);
	dedx = dedx.simplify();
	System.out.println("      = " + dedx);
    };
    
    public static void main(String[] args) {
	test1 (new Const(4));
	test1 (x);
	test1 (new Var("b"));
	test1 (new Add(x, new Const (4)));
	test1 (new Mult(x, x));
	test1 (new Mult(x, new Const(2)));
	test1 (new Mult(x, new Add(new Const(1), new Const(1))));
    };
};
