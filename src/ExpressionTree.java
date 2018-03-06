import java.util.Stack;

public class ExpressionTree extends TreeNode implements Expressions{



	ExpressionTree(Object v){
		super(v);
		TreeNode n = buildTree(null);
		this.setLeft(n.getLeft());
		this.setRight(n.getRight());
		this.setValue(n.getValue());

	}

	public boolean isNum(String str) {
		if(str != "*" && str != "+") {
			return true;
		} else {
			return false;
		}
	}
	
	

	@Override
	public TreeNode buildTree(String[] exp) {
		Stack<TreeNode> c =new Stack<TreeNode>();
		TreeNode r;
		TreeNode l;
		for(int i = 0; i < exp.length-1; i++) {
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
		
		if(t.getValue() == "*" || t.getValue() == "+") {
			int a = evalTree(t.getLeft());
			int b = evalTree(t.getRight());
		
			if(t.getValue() == "*") {
				return a*b;
			}
			if(t.getValue() == "+") {
				return a+b;
			}
		}	
			
		return (int)t.getValue();
		
	}

	

	@Override
	public String toPrefixNotation() {
		return toPrefixNotation(this);
	}

	
	public String toPrefixNotation(TreeNode t) {
		if(t == null) {
			return "";
		}
		if(t.getValue() == "*" || t.getValue() == "+") {
			String a = evalTree(t.getLeft());
			String b = evalTree(t.getRight());
		
			if(t.getValue() == "*") {
				return "* " + a + " " + b + " ";
			}
			if(t.getValue() == "+") {
				return "+ " + a + " " + b + " ";
			}
		}	
			return t.getValue();	
	}

	

	@Override
	public String toInfixNotation() {
		return toInfixNotation(this);
	}
	
	
	public String toInfixNotation(TreeNode t) {
		if(t == null) {
			return "";
		}
		if(t.getValue() == "*" || t.getValue() == "+") {
			String a = evalTree(t.getLeft());
			String b = evalTree(t.getRight());
		
			if(t.getValue() == "*") {
				return "( " + a + " * " + b +" ) ";
			}
			if(t.getValue() == "+") {
				return "( " + a + " + " + b +" ) ";
			}
		}	
			return t.getValue();
		
	}



	@Override
	public String toPostfixNotation() {
		return toPostNotation(this);
	}

	
	public String toPostNotation(TreeNode t) {
		if(t == null) {
			return "";
		}
		
		if(t.getValue() == "*" || t.getValue() == "+") {
			String a = evalTree(t.getLeft());
			String b = evalTree(t.getRight());
		
			if(t.getValue() == "*") {
				return a + " " + b + " * ";
			}
			if(t.getValue() == "+") {
				return a + " " + b + " + ";
			}
		}	
			return t.getValue();
	}

	
	@Override
	public int postfixEval(String[] exp) {
		Stack<Integer> c = new Stack<Integer>();
		int r;
		int l;
		for(int i = 0; i < exp.length-1; i++) {
			if(isNum(exp[i])) {
				c.push(Integer.parseInt(exp[i]));
			}else {
				if(exp[i] == "*") {
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