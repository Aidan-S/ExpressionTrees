
public class Tester {

	public static void main(String[] args) {
		String [] num = {"2", "5", "+"};
		TreeNode k = new TreeNode(null);
		ExpressionTree t = new ExpressionTree(k); 
		
		t.buildTree(num);
		
		System.out.println(t.evalTree());
		System.out.println(t.toInfixNotation());

	}

}
