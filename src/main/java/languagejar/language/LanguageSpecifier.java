package languagejar.language;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import com.github.pemistahl.lingua.api.*;

public class LanguageSpecifier {
	
	public static void main(String[] args) throws IOException {		
		
		final LanguageDetector detector = LanguageDetectorBuilder.fromLanguages(Language.ENGLISH, Language.SPANISH).build();
		Language detectedLanguage;		
		FileInputStream fstream = new FileInputStream(args[0]);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
			
		
		while ((strLine = br.readLine()) != null) {
			detectedLanguage = detector.detectLanguageOf(strLine);
			
			if(args[1].equals("SPANISH")) {
				if(!detectedLanguage.name().equals("SPANISH")) {
					  System.out.println(detectedLanguage.name() +" : " + strLine);
				  }
			}else if (args[1].equals("ENGLISH")) {
				if(!detectedLanguage.name().equals("ENGLISH")) {
					  System.out.println(detectedLanguage.name() +" : " + strLine);
				  }				
			}								
			
		}				

		fstream.close();		
	}
}
