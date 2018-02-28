import java.util.Stack;

public class ExpressionTree extends TreeNode implements Expressions{
	
	TreeNode e;
	
	ExpressionTree(Object v) {
		

	}

	@Override
	public TreeNode buildTree(String[] exp) {
		Stack c =new Stack<String>();
		TreeNode t = null;
		TreeNode r;
		TreeNode l;
		//TreeNode t = new TreeNode(exp[exp.length-1]);
		for(int i = 0; i < exp.length-1; i++) {
			if(exp[i] != "*" && exp[i] != "+" ) {
				c.push(exp[i]);
			}else {
				r = new TreeNode(c.pop());
				l = new TreeNode(c.pop());
				t = new TreeNode(exp[i], l, r);
				c.push(t);
			}
		}
		
		return t;
	}

	@Override
	public int evalTree() {
		if(e.getLeft()==null) {
			return (int) e.getValue();
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
		// TODO Auto-generated method stub
		return 0;
	}
	
}