import java.lang.*;

public class Add extends Expr{

    private Expr t1;
    private Expr t2;

    public Add(Expr term1, Expr term2){
	t1 = term1;
	t2 = term2;
    }
    
    public String unparse(int prec){
	String s1 = t1.unparse(PREC_ADD_SUB);
	String s2 = t2.unparse(PREC_ADD_SUB + 1);

	String res = s1 + " + " + s2;

	if(prec > PREC_ADD_SUB){
	    return "(" + res + ")";
	}

	return res;
    }
    
    public Expr derivative(Var x){
	return new Add(t1.derivative(x), t2.derivative(x));
    }

    public Expr simplify(){
	Expr s1 = t1.simplify();
	Expr s2 = t2.simplify();

	if(s1 != t1 || s2 != t2){
	    return new Add(s1, s2).simplify();
	}
	
	if(t1.isConst(0)){return t2;}
	if(t2.isConst(0)){return t1;}
	
	if(t1.isConst() && t2.isConst()){
	    return new Const(t1.getConst() + t2.getConst());
	}
	
	return this;
    }
    
};
