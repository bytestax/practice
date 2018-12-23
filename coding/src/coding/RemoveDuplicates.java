package coding;

public class RemoveDuplicates {

	
	public static char[] removeDuplicates(char[] str) {
		
		if (str == null) return str;
		int len = str.length;
		if (len < 2) return str;
		
		int tail = 1;
		for (int i=0; i< len; i++) {
			int j;
			for (j=0; j<tail; j++) {
				if (str[i]==str[j])
					break;
			}
			if (j==tail) str[tail++]=str[i];
				
		}
		char[] result = new char[tail];
		for(int i=0;i<tail;i++)
			result[i]=str[i];
		return result;
		//if (tail < len) str[tail]='\0';
		//System.out.println(str);
		
	}
	public static void main(String[] args) {
		System.out.println(RemoveDuplicates.removeDuplicates("abcd".toCharArray()));
		System.out.println(RemoveDuplicates.removeDuplicates("abcdabcd".toCharArray()));
		System.out.println(RemoveDuplicates.removeDuplicates("aaaa".toCharArray()));
		System.out.println(RemoveDuplicates.removeDuplicates("aabb".toCharArray()));
		System.out.println(RemoveDuplicates.removeDuplicates("abab".toCharArray()));
		System.out.println(RemoveDuplicates.removeDuplicates("a".toCharArray()));
		System.out.println(RemoveDuplicates.removeDuplicates("aa".toCharArray()));
		//System.out.println(RemoveDuplicates.removeDuplicates(null));
		

	}

}
