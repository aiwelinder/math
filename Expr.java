import java.lang.*;

public abstract class Expr {

    public abstract String toString();
    public abstract Expr derivative(Var x);

    public boolean isVar(Var x){return false;}

    public boolean isConst(){return false;}
    public boolean isConst(double d){return false;}
    public double getConst() {throw new UnsupportedOperationException();}

    public Expr simplify(){return this;}
};
