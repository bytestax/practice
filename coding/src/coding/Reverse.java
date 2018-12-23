package coding;

import java.util.concurrent.ExecutionException;

public class Reverse 
{
	private static void Reverse(char[] s, int start, int end)
	{
		while (start < end)
		{
			s[start] = (char)( (int)s[start] ^ (int)s[end]);
			s[end] = (char)( (int)s[start] ^ (int)s[end]);
			s[start] = (char)( (int)s[start] ^ (int)s[end]);
			start++;
			end--;
		}
			
	}

	public static void main(String[] args) 
	{
		String s="ashishtiwari";
		String campaignId = null;
		String newValue = "campaignId: " + campaignId;
		System.out.println("original: " + s);
		char[] a = s.toCharArray();		
		Reverse(a, 0, s.length()-1);
		String r = new String(a);
		System.out.println("reversed: " + r);
	}
}
