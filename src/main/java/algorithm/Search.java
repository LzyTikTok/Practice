class Search{
	public static int divideSearch(int[]arr, int target){
		int start = 0, end = arr.length - 1, mid = 0;
		while(arr[mid] != target){
			mid = (end + start)/2;
			if(arr[mid] > target){
				end = mid - 1;
			} 
			else if(arr[mid] < target){
				start = mid + 1;
			}
		}
		return mid;
	}
	public static void main(String[] args){
		System.out.print(divideSearch(new int[]{1,2,3,4,5,6,7,8,9}, 9));
	}
}