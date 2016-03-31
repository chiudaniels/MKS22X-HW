public class ParenDemo{
    public static  MyStack <Character> stack;
    public static boolean isMatching (String s){
	char [] array = s.toCharArray();
	System.out.println(array[0]);
	for (int x=0; x< array.length; x++){
	    if (array[x] == '(' || array[x] == '{' || array[x] == '[' || array[x] == '<'){
		stack.push(array[x]);
	    }
	    if (!stack.isEmpty() && stack.peek()=='(' && array[x]==')'){
		stack.pop();
	    }
	    if (!stack.isEmpty() && stack.peek()=='{' && array[x]=='}'){
		stack.pop();
	    }
	    if (!stack.isEmpty() && stack.peek()=='[' && array[x]==']'){
		stack.pop();
	    }
	    if (!stack.isEmpty() && stack.peek()=='<' && array[x]=='>'){
		stack.pop();
	    }
	}
	return stack.isEmpty();
    }
    
    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
 
    }
}

