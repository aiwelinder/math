import java.lang.*;

public class Cos extends Func{

    public Cos(Expr a){super("cos", a);}

    public Func createFunc(Expr arg){return new Cos(arg);}
    
    public Expr simpleDerivative(Expr a){
	return new Mult(new Const(-1), new Sin(a));
    }
    
    public Expr simpleSimplify(){
	Expr a = getArg();
	
	if(a.isConst()){
	    return new Const(Math.cos(a.getConst()));
	}
	
	return this;
    }
};
