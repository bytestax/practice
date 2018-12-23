package coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FetchURL {

	private ExecutorService executor = Executors.newSingleThreadExecutor();
	
	public Future<String> getUrl(String url) {
		return executor.submit(()-> {
			URL site = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()));
			
			StringBuffer sb = new StringBuffer();
			String inputLine;
			while((inputLine = in.readLine()) != null) {
				sb.append(inputLine);
			}
			return sb.toString();
		});
		
	}
	
	public void shutdown()
	{
		executor.shutdown();
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		String url="https://www.cnn.com";
		FetchURL furl = new FetchURL();
		String data = furl.getUrl(url).get();
		System.out.println(data);
		furl.shutdown();
	}
}
