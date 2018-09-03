import java.lang.*;

public class Sin extends Func{

    public Sin(Expr a){super("sin", a);}

    public Func createFunc(Expr arg){return new Sin(arg);}
    
    public Expr simpleDerivative(Expr a){
	return new Cos(a);
    }
    
    public Expr simpleSimplify(){
	Expr a = getArg();
	
	if(a.isConst()){
	    return new Const(Math.sin(a.getConst()));
	}
	
	return this;
    }
};
