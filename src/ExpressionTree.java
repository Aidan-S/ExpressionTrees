import java.util.Stack;

public class ExpressionTree extends TreeNode implements Expressions{
	
	
	ExpressionTree(String str) {
		super(str);
		
		
	}

	@Override
	public TreeNode buildTree(String[] exp) {
		Stack c = new Stack<TreeNode>();
		TreeNode t = null;
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
		//asdasd
		return (TreeNode) c.pop();
	}

	@Override
	public int evalTree() {
		if(this.getLeft()==null) {
			return (int) e.getValue();
		}
		
		
		
		
		
		
		
		
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