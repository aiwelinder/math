import java.lang.*;

public class Mult extends Expr{

    private Expr f1;
    private Expr f2;

    public Mult(Expr factor1, Expr factor2){
	f1 = factor1;
	f2 = factor2;
    }
    
    public String toString(){
	String s1 = f1.toString();
	String s2 = f2.toString();

	return "(" + s1 + ") * (" + s2 + ")";
    }
    
    public Expr derivative(Var x){
	return new Add(new Mult(f1, f2.derivative(x)),
		       new Mult(f1.derivative(x), f2));
    }

    public Expr simplify(){
	if(f1.isConst(1)){
	    return f2;
	}
	if(f2.isConst(1)){
	    return f1;
	}
	if(f1.isConst(0)){
	    return f1;
	}
	if(f2.isConst(0)){
	    return f2;
	}
	if(f1.isConst() && f2.isConst()){
	    return new Const(f1.getConst() * f2.getConst());
	}
	
       	Expr s1 = f1.simplify();
	Expr s2 = f2.simplify();

	if(s1 == f1 && s2 == f2){
	    return this;
	}
	else{
	    return new Mult(s1, s2).simplify();
	}
    }
};
