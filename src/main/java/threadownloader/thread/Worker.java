package threadownloader.thread;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JProgressBar;

public class Worker implements Runnable{
    public JProgressBar jProgressBar1;
	String link = "https://phoenixnap.dl.sourceforge.net/project/reactos/ReactOS/0.4.14/ReactOS-0.4.14-iso.zip";
	File out= new File("C:\\Users\\WaRiS\\Desktop\\ReactOS-0.4.14-iso.zip");
	int x=0;
    
	public void run() {
		// TODO Auto-generated method stub
		try {
			URL url= new URL(link);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			double fileSize = (double)http.getContentLengthLong();
			BufferedInputStream in= new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new FileOutputStream(this.out);
			BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
			byte[] buffer = new byte[1024];
			double downloaded = 0.00;
			int read= 0;
			double percentDownloaded = 0.00;
			while((read= in.read(buffer,0,1024)) >= 0) 
			{
				bout.write(buffer,0,read);
				downloaded += read;
				percentDownloaded= (downloaded*100/fileSize);
				String percent= String.format("%.4f", percentDownloaded);
				x = (int) Math.round(percentDownloaded);
				jProgressBar1.setValue(x);
				System.out.println("Downloaded "+percent+" % of a file ");
				
			}
			bout.close();
			in.close();
			System.out.println("Downloaded Complete");
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
    
}
}