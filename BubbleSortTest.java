public class BubbleSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] {11, 45, 28, -1, 15};
		for(int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length -1 - i; j++) {
				if(arr[j] > arr[j +1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	} 
}
