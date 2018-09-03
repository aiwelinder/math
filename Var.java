import java.lang.*;

public class Var extends Expr{

    private String name;

    public Var(String nm){
	name = nm;
    }
    
    public String unparse(int prec){
	return name;
    }
    
    public Expr derivative(Var x){
	if (isVar(x)){
	    return new Const(1);
	}
	else {
	    return new Const(0);
	}
    }

    public boolean isVar(Var x){
	return name.equals(x.name);
    }
    
};
