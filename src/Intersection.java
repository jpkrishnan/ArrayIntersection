import java.util.HashSet;
import java.util.Set;


public class Intersection {

	public Intersection() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Finds the intersecting elements between the two arrays.
	 * Uses a Set to do accomplish this.
	 */
	public void findIntersection(int A[], int B[]) {
		boolean bFirstArrayIsShorter = false;
		
		Set<Integer> set = new HashSet();
		
		if(A.length <= B.length)  //Find which array is shorter in length
			bFirstArrayIsShorter = true;
		
		int length = (bFirstArrayIsShorter) ? A.length : B.length; //compute the length of the shorter length
		
		for (int i=0; i<length; i++) { //Put the shorter length elements in the Set. Eliminate any duplicates.
			if(bFirstArrayIsShorter) {
				if(!set.contains(A[i])) {
					set.add(A[i]);
				}
			} else {
				if(!set.contains(B[i])) {
					set.add(B[i]);
				}
			}
		}
		
		//Iterate through the other longer array and check to see if the elements are present in the set. 
		//If found then you have a "intersecting" element between the two arrays.
		if (bFirstArrayIsShorter) {
			for(int i=0; i<B.length; i++) {
				if(set.contains(B[i]))
					System.out.print(B[i] + " ");
			}
		} else {
			for(int i=0; i<A.length; i++) {
				if(set.contains(A[i]))
				System.out.print(A[i] + " ");			
			}
		}
		/*
		 * NOTE: This program will print all intersecting elements from the longer array. 
		 * If there are duplicates which are intersecting it will print them twice.
		 * To eliminate duplicates we need to use another Set with just 
		 * intersecting elements and then only add into it if an element already does not exist in the set
		 */		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = { 1,4,3,2,4,2 };
		int B[] = { 6,4,7,3,8,6 };
		
		System.out.println("The intersection of the two arrays are : ");
		new Intersection().findIntersection(A,B);

	}

}
