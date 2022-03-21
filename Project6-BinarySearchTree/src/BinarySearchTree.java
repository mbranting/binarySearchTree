

// Binary Search Tree (BST) - Page 398 Algorithms Book
public class BinarySearchTree<T extends Comparable<T>> {
	int inspectedCount = 0;
	
	private Node root;   // root node of the BST

	// Inner class for implementing a BST Node
    private class Node {
        private T key;              // the key value (what will be used to compare against)
        // private V Value;         // could define an assoicated value if needed
        private Node left, right;   // links to subtrees
        private int N;              // # nodes in subtree rooted here
        
        private Node(T key, int N) {
            this.key = key;
            this.N = N;
            left = right = null;
        }
    }
    
    public int size() { return size(root);}
    public int size(Node x) {
    	if (x == null) 
    		return 0;
    	else
    		return x.N;
    }
    
	public T get(T key) {
		inspectedCount = 0;
		T val = get(root, key); 
		System.out.println("Inspected " + inspectedCount + " elements");
		return val;
    }
	
	// search for key.  Update value if found; grow table if new
    public void put (T key) {
    	root = put(root, key);
    }
    
    
    public void printInOrder() { 
    	printInOrder(root); 
    	System.out.println();	
    }
    
    public void printInOrder(Node x) {
    	if (x == null) return;
    	printInOrder(x.left);
    	System.out.print(x.key + ", ");
    	printInOrder(x.right);
    }
	
    
	private T get(Node x, T key) {
		
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			inspectedCount++;
			return get(x.left, key);
		}
		else if (cmp > 0) {
			inspectedCount++;
			return get(x.right, key);
		}
		else
		{
			// we found the item we were searching for
			return x.key;
		}
		
		
	}
	
    private Node put(Node x, T key) {
    	if (x == null) return new Node(key, 1);
    	int cmp = key.compareTo(x.key);
    	if (cmp < 0) 
    		x.left = put(x.left, key);
    	else if (cmp > 0) 
    		x.right = put(x.right, key);
    	else 
    		x.key = key;
    	x.N = size(x.left)+ size (x.right) + 1;  
    	return x;
    }
    
    

    
    
    public void delete(T key) {root = delete(root,key); }
    
    private Node delete(Node x, T key)
    {
    	if (x == null) return null;
    	int cmp = key.compareTo(x.key);
    	if (cmp < 0)
    		x.left = delete(x.left, key);
    	else if (cmp > 0)
    		x.right = delete(x.right, key);
    	else
    	{
    		if (x.right == null) return x.left;
    		if (x.left == null) return x.right;
    		Node t = x;
    		x = min(t.right);
    		x.right = deleteMin(t.right);
    		x.left = t.left;
    	}
    	x.N = size(x.left)+ size(x.right)+ 1;
    	return x;
    }
    
    public T min()
    {
    	return min(root).key;
    }
    
    private Node min(Node x)
    {
    	if (x.left == null) return x;
    	return min(x.left);
    }
    
    public void deleteMin()
    {
    	root = deleteMin(root);
    }
    
    private Node deleteMin(Node x)
    {
    	if (x.left == null) return x.right;
    	x.left = deleteMin(x.left);
    	x.N = size(x.left)+ size(x.right)+ 1;
    	return x;
    }
    
    
	


}
