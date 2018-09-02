import java.lang.*;

public class Const extends Expr{

    private double d;

    public Const(double dub){
	d = dub;
    }
    
    public String toString(){
	return "(" + d + ")";
    };
    
    public Expr derivative(Var x){return new Const(0);};

    public boolean isConst(){return true;}
    public boolean isConst(double d2){return d == d2;}
    public double getConst(){return d;}
    
};
