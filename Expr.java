import java.lang.*;

public abstract class Expr {

    public static final int PREC_LOWEST = 0;
    public static final int PREC_ADD_SUB = 1;
    public static final int PREC_MULT_DIV = 2;
    
    public String toString(){return unparse(PREC_LOWEST);}
    public abstract String unparse(int prec);
    
    public abstract Expr derivative(Var x);

    public boolean isVar(Var x){return false;}

    public boolean isConst(){return false;}
    public boolean isConst(double d){return false;}
    public double getConst() {throw new UnsupportedOperationException();}

    public Expr simplify(){return this;}
};
