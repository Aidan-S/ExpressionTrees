import java.util.Stack;

public class ExpressionTree extends TreeNode implements Expressions{


	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: call the super class and create an expression tree from treeNodes
	 * @param exp: String array that contains each digit of the postfixnotation 
	 * @return: none
	 */
	ExpressionTree(String[] exp){
		super("");
		TreeNode n = buildTree(exp);
		this.setLeft(n.getLeft());
		this.setRight(n.getRight());
		this.setValue(n.getValue());

	}

	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: decide if the string is a num (not a * or +)
	 * @param str: string that either is or isn't a num
	 * @return: boolean of whether or not the string is a num
	 */
	public boolean isNum(String str) {
		if(str.equals("*") || str.equals("+")) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: build the Expression Tree
	 * @param exp: String array that contains each digit of the postfixnotation 
	 * @return: Treenode that acts as the root of the tree
	 */
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


	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: evaluate the tree by calling the overloaded method
	 * @param none
	 * @return: the evaluation of the expression
	 */
	@Override
	public int evalTree() {
		return evalTree(this);
	}

	
	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: evaluate the tree by traversing it and combining the leafs
	 * @param t: the treenode to be evaluated in that iteration
	 * @return: the evaluation of the expression
	 */
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

	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: evaluate the tree by calling overloaded method
	 * @param none
	 * @return: the expression tree in prefix notation
	 */
	@Override
	public String toPrefixNotation() {
		return toPrefixNotation(this);
	}

	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: evaluate the tree by traversing it and putting together the expression recursively, root, left, right
	 * @param t: t: the treenode to be evaluated in that iteration
	 * @return: the expression tree in prefix notation
	 */
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

	
	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: evaluate the tree by calling overloaded method
	 * @param none
	 * @return: the expression tree in infix notation
	 */
	@Override
	public String toInfixNotation() {
		return toInfixNotation(this);
	}
	
	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: evaluate the tree by traversing it and putting together the expression recursively, left, root, right
	 * @param t: the treenode to be evaluated in that iteration
	 * @return: the expression tree in infix notation
	 */
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

	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: evaluate the tree by calling overloaded method
	 * @param none
	 * @return: the expression tree in postfix notation
	 */
	@Override
	public String toPostfixNotation() {
		return toPostNotation(this);
	}

	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: evaluate the tree by traversing it and putting together the expression recursively, left, right, root
	 * @param t: the treenode to be evaluated in that iteration
	 * @return: the expression tree in postfix notation
	 */
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

	/**
	 * @author Aidan-S
	 * date: March 9th, 2018
	 * method: evaluate a postfix expression  
	 * @param exp: String array that contains each digit of the postfixnotation 
	 * @return: The evaltion of the expression  
	 */
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
