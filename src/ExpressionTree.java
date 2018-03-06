import java.util.Stack;

public class ExpressionTree extends TreeNode implements Expressions{



	ExpressionTree(Object v){
		super(v);
		TreeNode n = buildTree(null);
		this.setLeft(n.getLeft());
		this.setRight(n.getRight());
		this.setValue(n.getValue());

	}



	@Override
	public TreeNode buildTree(String[] exp) {
		Stack<TreeNode> c =new Stack<TreeNode>();
		TreeNode r;
		TreeNode l;
		for(int i = 0; i < exp.length-1; i++) {
			if(exp[i] != "*" && exp[i] != "+") {
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
		if(t.getLeft() == null) {
			return (int)t.getValue();
		}
		
		int a = evalTree(t.getLeft());
		int b = evalTree(t.getRight());
		
		if(t.getValue() == "*") {
			return a*b;
		}
		if(t.getValue() == "+") {
			return a+b;
		}
		
		return 0;
	}

	

	@Override

	public String toPrefixNotation() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override

	public String toInfixNotation() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override

	public String toPostfixNotation() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override

	public int postfixEval(String[] exp) {
		Stack<Integer> c = new Stack<Integer>();
		int r;
		int l;
		for(int i = 0; i < exp.length-1; i++) {
			if(exp[i] != "*" && exp[i] != "+" ) {
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