import java.lang.*;

public abstract class Func extends Expr{

    private String name;
    private Expr arg;

    public Func(String nm, Expr a){
	name = nm;
	arg = a;
    }
    
    public String unparse(int prec){
	return name + "(" + arg + ")";
    }
    
    public Expr derivative(Var x){
	// chain rule
	return new Mult(simpleDerivative(arg),
			arg.derivative(x));
    }

    public abstract Expr simpleDerivative(Expr a);

    public Expr simplify(){
	Expr arg2 = arg.simplify();

	if(arg != arg2){
	    Func temp = createFunc(arg2);
	    return temp.simpleSimplify();
	}
	return simpleSimplify();
    }

    public abstract Expr simpleSimplify();

    public abstract Func createFunc(Expr arg);
	    

    public Expr getArg(){
	return arg;
    }
};
