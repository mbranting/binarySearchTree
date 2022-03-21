import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree<String> BST = LoadData();
		
		// Print the contents of the tree using in-order traversal
		System.out.println("Printing in-order traversal of binary tree...");
		BST.printInOrder();
		
		// Perform search for user input
		String input = "";
		Scanner sc = new Scanner(System.in);
		while(!input.equals("-1"))
		{
			System.out.print("Enter string to find, enter -1 to quit: ");
			input = sc.nextLine();
			if (input.equals("-1"))
				break;
			String result = BST.get(input);
			if (result != null) {
				System.out.println("'" + result + "' located");
			}
			else {
				System.out.println("'" + input + "' not in tree");
			}
			System.out.println("");
		}
		
		
		//TODO: Perform Remove
		input = "";
		sc = new Scanner(System.in);
		System.out.println("");
		while(!input.equals("-1"))
		{
			BST.printInOrder();
			System.out.print("Enter string to remove, enter -1 to quit: ");
			input = sc.nextLine();
			if (input.equals("-1"))
				break;
			String result = BST.get(input);
			if (result != null) {
				BST.delete(input);
				System.out.println("'" + result + "' deleted");
				BST.printInOrder();
			}
			else {
				System.out.println("'" + input + "' not in tree");
			}
			System.out.println("");
		}
		
		
		System.out.println("End of program");

	}

	
	public static BinarySearchTree<String> LoadData()
	{
		BinarySearchTree<String> BST = new BinarySearchTree<String>();
		
		List<String> strings = ReadFile("Data.in");
		
		System.out.println("Reading Test Data...");
		
		for (String value : strings) {
			BST.put(value);
			System.out.print(value + " ");
		}
	    System.out.println("");
	    System.out.println("END: Reading Test Data");
	    System.out.println("");
		return BST;
	}
	
	
	//------------------------------------------------------------------------------------------------------------
	//   Helper method for reading the files
	//------------------------------------------------------------------------------------------------------------
	public static List<String> ReadFile(String filename)
	{
		List<String> strings = new ArrayList<String>();
		
		// assume a file with a list of words (multiple per line, multiple lines)
		try {
			Scanner fin = new Scanner(new File(filename));
			
			while(fin.hasNext()) {
				String item = fin.next();
				strings.add(item);
			}
			
			fin.close();
			
		} catch (Exception e) {
			System.out.println("Error trying to read input file");
			e.printStackTrace();
		}

		return strings;
	}

}
