public class Recursion implements hw01{
    public String name(){
	return "Chiu,Daniel";
    }
    public double sqrtHelper(double n, double guess){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (n==0){
	    return 0;
	}
	if((Math.abs(guess*guess-n)/n)<.0001){
	return guess;
	}
	double nextGuess=(n/guess+guess)/2;
	return sqrtHelper(n, nextGuess);
    }

   
    public double sqrt(double n){
	return sqrtHelper(n,1);
    }
}
