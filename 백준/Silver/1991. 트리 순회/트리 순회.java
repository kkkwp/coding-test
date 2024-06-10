import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Node[] tree;
	static StringBuilder sb = new StringBuilder();

	static void preOrder(Node node) {
		if (node == null)
			return;
		sb.append(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}

	static void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		sb.append(node.value);
		inOrder(node.right);
	}

	static void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.value);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		tree = new Node[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if (tree[parent - 'A'] == null) {
				tree[parent - 'A'] = new Node(parent);
			}
			if (left != '.') {
				tree[left - 'A'] = new Node(left);
				tree[parent - 'A'].left = tree[left - 'A'];
			}
			if (right != '.') {
				tree[right - 'A'] = new Node(right);
				tree[parent - 'A'].right = tree[right - 'A'];
			}
		}

		preOrder(tree[0]);
		sb.append('\n');
		inOrder(tree[0]);
		sb.append('\n');
		postOrder(tree[0]);
		sb.append('\n');
		System.out.println(sb);
	}

	static class Node {
		char value;
		Node left;
		Node right;

		Node(char value) {
			this.value = value;
		}
	}
}
