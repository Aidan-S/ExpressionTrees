import java.util.Stack;

public class ExpressionTree extends TreeNode implements Expressions{


	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: call the super class and create an expression tree from treeNodes
	 * @param exp: String array that contanins each digit of the postfix notation 
	 * @return: A Print Writer that I can print to
	 */
	
	ExpressionTree(String[] exp){
		super("");
		TreeNode n = buildTree(exp);
		this.setLeft(n.getLeft());
		this.setRight(n.getRight());
		this.setValue(n.getValue());

	}

	public boolean isNum(String str) {
		if(str.equals("*") || str.equals("+")) {
			return false;
		} else {
			return true;
		}
	}
	
	

	@Override
	public TreeNode buildTree(String[] exp) {
		Stack<TreeNode> c = new Stack<TreeNode>();
		TreeNode r;
		TreeNode l;
		for(int i = 0; i < exp.length; i++) {
			if(isNum(exp[i])) {
				c.push(new TreeNode(exp[i]));
			}else {
				r = c.pop();
				l = c.pop();
				c.push(new TreeNode(exp[i], l, r));
			}
		}
		return c.pop();
	}



	@Override
	public int evalTree() {
		return evalTree(this);
	}

	

	public int evalTree(TreeNode t) {
		if(t == null) {
			return 0;
		}
		
		if(!(isNum((String) t.getValue()))) {
			int a = evalTree(t.getLeft());
			int b = evalTree(t.getRight());
		
			if(t.getValue().equals("*")) {
				return a*b;
			}
			if(t.getValue().equals("+")) {
				return a+b;
			}
		}	
			
		return Integer.parseInt((String) t.getValue());
	
		
	}

	

	@Override
	public String toPrefixNotation() {
		return toPrefixNotation(this);
	}

	
	public String toPrefixNotation(TreeNode t) {
		if(t == null) {
			return "";
		}
		if(!(isNum((String) t.getValue()))) {
			String a = toPrefixNotation(t.getLeft());
			String b = toPrefixNotation(t.getRight());
		
			if(t.getValue().equals("*")) {
				return "* " + a + " " + b + " ";
			}
			if(t.getValue().equals("+")) {
				return "+ " + a + " " + b + " ";
			}
		}	
			return (String) t.getValue();	
	}

	

	@Override
	public String toInfixNotation() {
		return toInfixNotation(this);
	}
	
	
	public String toInfixNotation(TreeNode t) {
		if(t == null) {
			return "";
		}
		if(!(isNum((String) t.getValue()))) {
			String a = toInfixNotation(t.getLeft());
			String b = toInfixNotation(t.getRight());
		
			if(t.getValue().equals("*")) {
				return "( " + a + " * " + b +" ) ";
			}
			if(t.getValue().equals("+")) {
				return "( " + a + " + " + b +" ) ";
			}
		}	
			return (String) t.getValue();
		
	}



	@Override
	public String toPostfixNotation() {
		return toPostNotation(this);
	}

	
	public String toPostNotation(TreeNode t) {
		if(t == null) {
			return "";
		}
		
		if(!(isNum((String) t.getValue()))) {
			String a = toPostNotation(t.getLeft());
			String b = toPostNotation(t.getRight());
		
			if(t.getValue().equals("*")) {
				return a + " " + b + " * ";
			}
			if(t.getValue().equals("+")) {
				return a + " " + b + " + ";
			}
		}	
			return (String) t.getValue();
	}

	
	@Override
	public int postfixEval(String[] exp) {
		Stack<Integer> c = new Stack<Integer>();
		int r;
		int l;
		for(int i = 0; i < exp.length; i++) {
			if(isNum(exp[i])) {
				c.push(Integer.parseInt(exp[i]));
			}else {
				if(exp[i].equals("*")) {
					r = c.pop();
					l = c.pop();
					c.push(l * r);
				}else {
					r = c.pop();
					l = c.pop();
					c.push(l + r);
				}
			}
		}
		return c.pop();
	}
	
	
	
	
}
