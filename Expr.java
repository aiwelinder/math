import java.lang.*;

public abstract class Expr {

    public abstract String toString();
    public abstract Expr derivative(Var x);

    public boolean isVar(Var x){
	return false;
    }
};
