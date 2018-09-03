import java.lang.*;

public class Mult extends Expr{

    private Expr f1;
    private Expr f2;

    public Mult(Expr factor1, Expr factor2){
	f1 = factor1;
	f2 = factor2;
    }
    
    public String unparse(int prec){
	String s1 = f1.unparse(PREC_MULT_DIV);
	String s2 = f2.unparse(PREC_MULT_DIV + 1);

	String res = s1 + " * " + s2;

	if(prec > PREC_MULT_DIV){
	    return "(" + res + ")";
	}

	return res;
    }
    
    public Expr derivative(Var x){
	return new Add(new Mult(f1, f2.derivative(x)),
		       new Mult(f1.derivative(x), f2));
    }

    public Expr simplify(){
	Expr s1 = f1.simplify();
	Expr s2 = f2.simplify();

	if(s1 != f1 || s2 != f2){
	    return new Mult(s1, s2).simplify();
	}

	if(f1.isConst(1)){return f2;}
	if(f2.isConst(1)){return f1;}
	if(f1.isConst(0)){return f1;}
	if(f2.isConst(0)){return f2;}

	if(f1.isConst() && f2.isConst()){
	    return new Const(f1.getConst() * f2.getConst());
	}
	
       	return this;
    }
};
