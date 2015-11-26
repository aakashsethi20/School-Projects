import java.util.*;
import java.io.*;

public class DecisionTree {

	private DecisionStump root;
	
	public DecisionTree(int dimension, int numberOfClasses) {
		DecisionStump.nClasses= numberOfClasses;
		DecisionStump.dim= dimension;
		root= new DecisionStump();
	}
	
	// returns the root of the decision tree
	public DecisionStump getRoot() {
	
		return root;
	}
	
	// get the class associated with this vector according to the decision tree
	public int getDecision(double[] vector);
	
	// replace a leaf node by a DecisionStump with two leaves
	public void replace(DecisionStump leaf, int featureIndex, double threshold);
	
	// gets the leaf with the smallest maximal class probability
	public DecisionStump getSmallestMaxProb();

	// updates the probability count of each node of the decision tree
	// based on a sample for which the associated class is known
	public void train(double[] vector, int classNumber) {
	
		root.updateProbCount(vector, classNumber);
	}
	
	// reset the probability counts of all nodes
	public void resetAll() {
	
			reset(root);
	}

	private void reset(DecisionStump ds) {
	
		ds.resetProbCount();
		
		if (!ds.isExternal()) {
		
			reset(ds.getSmallerBranch()); // typo correction here
			reset(ds.getGreaterBranch()); // typo correction here
		}
	}

	// pre-order print of all nodes
	public void print();

	public static void main(String[] args) {
	
		// here is how to read the file containing the pre-classified samples
		try {
			Scanner scanner = new Scanner(new File("iris.data.txt"));
			scanner.useDelimiter("[,\r\n]+");
			while(scanner.hasNextDouble()) {
				System.out.println("="+scanner.nextDouble());
				System.out.println("="+scanner.nextDouble());
				System.out.println("="+scanner.nextDouble());
				System.out.println("="+scanner.nextDouble());
				System.out.println("="+scanner.next());
			}		
		} catch (Exception e) {
			System.out.println("Error reading file...");
		}
		
		// ********* add code for part B and part C here *************** //
	}
}