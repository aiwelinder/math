import java.lang.*;

public class Exp extends Func{

    public Exp(Expr a){super("exp", a);}

    public Func createFunc(Expr arg){return new Exp(arg);}
    
    public Expr simpleDerivative(Expr a){
	return new Exp(a);
    }

    public Expr simpleSimplify(){
	Expr a = getArg();

	if(a.isConst()){
	    return new Const(Math.exp(a.getConst()));
	}
	
	return this;
    }
};
