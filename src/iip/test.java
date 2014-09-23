package iip;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class test{
	public static void main(String[] args) throws IOException {
		String filePath = "test.txt";
		String news=new String();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8"));
	    String str;
	    while ((str = in.readLine()) != null) {
	    	news+=str;
	    }
	   in.close();

	   System.out.println(news);
	   
	
	   
	   //Dictionary.initial(DefaultConfig.getInstance());
	   //Dictionary.getSingleton().addWords(list);
	   
/*	   IKAnalyzer analyzer = new IKAnalyzer(true);
	   StringReader reader = new StringReader(news);
	   TokenStream ts = analyzer.tokenStream("", reader);
	   CharTermAttribute term = (CharTermAttribute) ts.getAttribute(CharTermAttribute.class);
	   while(ts.incrementToken()){
		   System.out.print(term.toString()+"|");
		   }
	   analyzer.close();
	   reader.close();
	   
	   System.out.println();*/
	   StringReader re = new StringReader(news);
	   IKSegmenter ik = new IKSegmenter(re,true);
	   Lexeme lex = null;
	   while((lex=ik.next())!=null){
		  System.out.print(lex.getLexemeText()+"|");
	   }
	}
}
