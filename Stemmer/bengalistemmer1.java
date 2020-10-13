package Stemmer1;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import java.sql.*;

public class bengalistemmer1 {


	static private Map<String, String> cache = new WeakHashMap<String, String>();

private StringBuilder sb = new StringBuilder();
char arr[]={'০','১','২','৩','৪','৫','৬','৭','৮','৯'};
int lenn=0;
StringBuilder sbb;




public String rep(String s2) {
    StringTokenizer stt=new StringTokenizer(s2);
    s2=" ";
    while(stt.hasMoreTokens())
    {
      String ss=stt.nextToken();
      //System.out.println(ss);
      lenn=ss.length();
       sbb=new StringBuilder(ss);
		for(int i=0;i<10;i++)
		{
		    if(sbb.charAt(0)==arr[i])
			{
			   sbb.delete(0,lenn);
				break;
			}

		}
       ss=sbb.toString();
       //System.out.println(ss);
       s2=s2.concat(ss);
       s2=s2 + " ";
    }
        //lenn=s2.length();
        //System.out.println(s2);
        
        //s2=sbb.toString();
		s2 = s2.toLowerCase();
		s2 = " " + s2 + " ";
//System.out.println(s2);
		//s2 = s2.replace(" অবশ্য "," ");
		//s2 = s2.replace(" অনেক "," ");
		s2 = s2.replace(" অনেকে "," ");
		s2 = s2.replace(" অনেকেই "," ");
		s2 = s2.replace(" অন্তত "," ");
		s2 = s2.replace(" অথবা "," ");
		s2 = s2.replace(" অথচ "," ");
        //s2 = s2.replace(" অতি "," ");
        //s2 = s2.replace(" অনুসারে "," ");
		s2 = s2.replace(" অর্থাত "," ");
		//s2 = s2.replace(" অন্য "," ");
		//s2 = s2.replace(" আজ "," ");
		s2 = s2.replace(" আছে "," ");
		//s2 = s2.replace(" আপনার "," ");
		s2 = s2.replace(" আপনি "," ");
		//s2 = s2.replace(" আবার "," ");
		s2 = s2.replace(" আমরা "," ");
		s2 = s2.replace(" আমাকে "," ");
		s2 = s2.replace(" আমাদের "," ");
		s2 = s2.replace(" আমার "," ");
		s2 = s2.replace(" আমি "," ");
		//s2 = s2.replace(" আরও "," ");
		//s2 = s2.replace(" আর "," ");
		//s2 = s2.replace(" আগে "," ");
		//s2 = s2.replace(" আগেই "," ");
		s2 = s2.replace(" অতএব "," ");
		//s2 = s2.replace(" আগামী "," ");
		//s2 = s2.replace(" অবধি "," ");
		//s2 = s2.replace(" অনুযায়ী "," ");
		s2 = s2.replace(" আদ্যভাগে "," ");
		//s2 = s2.replace(" এই "," ");
		//s2 = s2.replace(" একই "," ");
        s2 = s2.replace(" এক "," ");
		s2 = s2.replace(" একে "," ");
        s2 = s2.replace(" একজন "," ");
		s2 = s2.replace(" একটি "," ");
		//s2 = s2.replace(" এখন "," ");
		//s2 = s2.replace(" এখনও "," ");
		//s2 = s2.replace(" এখানে "," ");
		s2 = s2.replace(" এটি "," ");
		//s2 = s2.replace(" এটা "," ");
		s2 = s2.replace(" এটাই "," ");
		s2 = s2.replace(" এতটাই "," ");
		s2 = s2.replace(" এবং "," ");
		s2 = s2.replace(" একবার "," ");
                //s2 = s2.replace(" এবার "," ");
                s2 = s2.replace(" এদের "," ");
                s2 = s2.replace(" এমন "," ");
                s2 = s2.replace(" এমনকী "," ");
                s2 = s2.replace(" এল "," ");
                s2 = s2.replace(" এর "," ");
                s2 = s2.replace(" এরা "," ");
                s2 = s2.replace(" এস "," ");
                //s2 = s2.replace(" এত "," ");
                //s2 = s2.replace(" এ "," ");
                s2 = s2.replace(" ঐ "," ");
                s2 = s2.replace(" ইহা "," ");
                s2 = s2.replace(" ইত্যাদি "," ");
                s2 = s2.replace(" উনি "," ");
                //s2 = s2.replace(" উপর "," ");
                //s2 = s2.replace(" উচিত "," ");
                s2 = s2.replace(" ও "," ");
                s2 = s2.replace(" ওই "," ");
                s2 = s2.replace(" ওর "," ");
                s2 = s2.replace(" ওরা "," ");
                s2 = s2.replace(" ওদের "," ");
                //s2 = s2.replace(" ওখানে "," ");
                //s2 = s2.replace(" কত "," ");
                s2 = s2.replace(" কবে "," ");
                s2 = s2.replace(" করতে "," ");
                s2 = s2.replace(" কয়েক "," ");
                s2 = s2.replace(" করবে "," ");
                s2 = s2.replace(" কাছ "," ");
                //s2 = s2.replace(" কাছে "," ");
                //s2 = s2.replace(" কারণ "," ");
                //s2 = s2.replace(" কিছু "," ");
                s2 = s2.replace(" কিন্তু "," ");
                s2 = s2.replace(" কিংবা "," ");
                //s2 = s2.replace(" কি "," ");
                //s2 = s2.replace(" কেউ  "," ");
                s2 = s2.replace(" কাউকে "," ");
                //s2 = s2.replace(" কেন  "," ");
                s2 = s2.replace(" কে "," ");
                s2 = s2.replace(" কোনো "," ");
                //s2 = s2.replace(" কোন "," ");
                s2 = s2.replace(" কখনও "," ");
                s2 = s2.replace(" ক্ষেত্রে "," ");
                //s2 = s2.replace(" খুব "," ");
                //s2 = s2.replace(" গুলি "," ");
                //s2 = s2.replace(" গোটা "," ");
                //s2 = s2.replace(" ছাড়া "," ");
                s2 = s2.replace(" ছিল "," ");
                //s2 = s2.replace(" জন্য "," ");
                //s2 = s2.replace(" ঠিক "," ");
                s2 = s2.replace(" তিনি "," ");
                //s2 = s2.replace(" তখন "," ");
                s2 = s2.replace(" তবে "," ");
                s2 = s2.replace(" তবু "," ");
                s2 = s2.replace(" তাদের  "," ");
                //s2 = s2.replace(" তাই "," ");
                s2 = s2.replace(" তেমন "," ");
                s2 = s2.replace(" তাকে "," ");
                //s2 = s2.replace(" তারপর  "," ");
                //s2 = s2.replace(" তারা "," ");
                s2 = s2.replace(" বার "," ");
                //s2 = s2.replace(" তার "," ");
                s2 = s2.replace(" তাহলে "," ");
                //s2 = s2.replace(" তা "," ");
                s2 = s2.replace(" তোর "," ");
                s2 = s2.replace(" তুমি "," ");
                //s2 = s2.replace(" তোমার "," ");
                s2 = s2.replace(" থাকে "," ");
                s2 = s2.replace(" থেকে "," ");
                s2 = s2.replace(" দিকে "," ");
                /*s2 = s2.replace(" ১ "," ");
                s2 = s2.replace(" ২ "," ");
                s2 = s2.replace(" ৩ "," ");
                s2 = s2.replace(" ৪ "," ");
                s2 = s2.replace(" ৫ "," ");
                s2 = s2.replace(" ৬ "," ");
                s2 = s2.replace(" ৭ "," ");
                s2 = s2.replace(" ৮ "," ");
                s2 = s2.replace(" ৯ "," ");
                s2 = s2.replace(" ১.৫০ "," ");
                s2 = s2.replace(" ১.৫ "," ");
                s2 = s2.replace(" ১০০০০ "," ");
                s2 = s2.replace(" ৩০০০ "," ");
                s2 = s2.replace(" ৩০০ "," ");
                s2 = s2.replace(" .৫০ "," ");
                s2 = s2.replace(" ০ "," ");
                s2 = s2.replace(" ১৫০০০ "," ");
                s2 = s2.replace(" ৪৫০০ "," ");
                s2 = s2.replace(" ৭.৫ "," ");
                s2 = s2.replace(" ২০০০ "," ");
                s2 = s2.replace(" ৮০০০ "," ");*/
                s2 = s2.replace(" টা. "," ");
                s2 = s2.replace(" দিয়ে "," ");
                s2 = s2.replace(" দু "," ");
                s2 = s2.replace(" দুই "," ");
                s2 = s2.replace(" দুইটি "," ");
                s2 = s2.replace(" দুটি "," ");
                s2 = s2.replace(" দ্বারা "," ");
                //s2 = s2.replace(" নয় "," ");
                //s2 = s2.replace(" নানা "," ");
                //s2 = s2.replace(" না "," ");
                s2 = s2.replace(" নাকি "," ");
                s2 = s2.replace(" নাগাদ "," ");
                //s2 = s2.replace(" নিজ "," ");
                s2 = s2.replace(" নিজে "," ");
                //s2 = s2.replace(" নিজের "," ");
                s2 = s2.replace(" নিজ "," ");
                s2 = s2.replace(" নেই "," ");
                //s2 = s2.replace(" পক্ষে "," ");
                s2 = s2.replace(" পর্যন্ত "," ");
                //s2 = s2.replace(" পর "," ");
                s2 = s2.replace(" প্রতি "," ");
                //s2 = s2.replace(" প্রকার "," ");
                s2 = s2.replace(" প্রায় "," ");
                s2 = s2.replace(" ফের "," ");
               // s2 = s2.replace(" ব্যবহার "," ");
                //s2 = s2.replace(" বহু "," ");
                s2 = s2.replace(" বা "," ");
                //s2 = s2.replace(" বিনা "," ");
                s2 = s2.replace(" বরং "," ");
                //s2 = s2.replace(" বদলে "," ");
                s2 = s2.replace(" বাদে "," ");
                //s2 = s2.replace(" বিশেষ "," ");
                s2 = s2.replace(" বিভিন্ন "," ");
                s2 = s2.replace(" ভাবে "," ");
                //s2 = s2.replace(" মধ্যে "," ");
                //s2 = s2.replace(" মাধ্যমে "," ");
                s2 = s2.replace(" মাত্র "," ");
                //s2 = s2.replace(" মতো "," ");
                s2 = s2.replace(" মোটেই "," ");
                s2 = s2.replace(" মধ্যেই "," ");
                //s2 = s2.replace(" যখন "," ");
                //s2 = s2.replace(" যদি "," ");
                s2 = s2.replace(" যাকে "," ");
                //s2 = s2.replace(" যত "," ");
                s2 = s2.replace(" যা "," ");
                s2 = s2.replace(" যার "," ");
                s2 = s2.replace(" যারা "," ");
                s2 = s2.replace(" যাদের "," ");
                s2 = s2.replace(" যেন "," ");
                s2 = s2.replace(" যেমন "," ");
                //s2 = s2.replace(" যেখানে "," ");
                s2 = s2.replace(" যিনি "," ");
                s2 = s2.replace(" যে "," ");
                s2 = s2.replace(" রকম "," ");
                s2 = s2.replace(" শুধু "," ");
                //s2 = s2.replace(" সঙ্গে "," ");
                //s2 = s2.replace(" সঙ্গে "," ");
                //s2 = s2.replace(" সমস্ত "," ");
                //s2 = s2.replace(" সব "," ");
                s2 = s2.replace(" সবার "," ");
                //s2 = s2.replace(" সবাই "," ");
                s2 = s2.replace(" সহ "," ");
                s2 = s2.replace(" সুতরাং "," ");
                s2 = s2.replace(" সেই "," ");
                s2 = s2.replace(" সেটা "," ");
                //s2 = s2.replace(" সম্প্রতি "," ");
                //s2 = s2.replace(" প্রতিটি "," ");
                s2 = s2.replace(" সেখান "," ");
                s2 = s2.replace(" সেখানে "," ");
                //s2 = s2.replace(" সহিত "," ");
                //s2 = s2.replace(" সাহায্য "," ");
                s2 = s2.replace(" সেইজন্য "," ");
                s2 = s2.replace(" সে "," ");
                //s2 = s2.replace(" স্পষ্ট "," ");
                s2 = s2.replace(" প্রায়ই "," ");
                //s2 = s2.replace(" স্বয়ং "," ");
                s2 = s2.replace(" হতে "," ");
                s2 = s2.replace(" হইতে "," ");
                s2 = s2.replace(" হইতেই "," ");
                s2 = s2.replace(" হবে "," ");
                s2 = s2.replace(" হইবার "," ");
                s2 = s2.replace(" হয়ে "," ");
                //s2 = s2.replace(" হয় "," ");
                s2 = s2.replace(" হইয়া "," ");
                //s2 = s2.replace(" হয়তো "," ");
                s2 = s2.replace(" হউক "," ");
                //s2 = s2.replace(" হল "," ");
                s2 = s2.replace(" হইল "," ");
                s2 = s2.replace(" হলে "," ");
                s2 = s2.replace(" হইলে "," ");
                s2 = s2.replace(" হোক "," ");
                s2 = s2.replace(" হন "," ");
                //s2 = s2.replace(" বেশ "," ");
                s2 = s2.replace(" সঙ্গেই "," ");
                s2 = s2.replace(" তুলে "," ");
                s2 = s2.replace(" তাহা "," ");
                s2 = s2.replace(" তাহাতে "," ");
                s2 = s2.replace(" তাহাদের "," ");
                s2 = s2.replace(" তাহাকে "," ");
                s2 = s2.replace(" তাহাদিগকে "," ");
                s2 = s2.replace(" তাহারা "," ");
                s2 = s2.replace(" তাঁহারা "," ");
                s2 = s2.replace(" ইহা "," ");
                s2 = s2.replace(" ইহাদের "," ");
                s2 = s2.replace(" কী "," ");
                s2 = s2.replace(" তাহার "," ");
                s2 = s2.replace(" ইত্যাদির "," ");
                s2 = s2.replace(" টি "," ");
                //s2 = s2.replace(" যথেষ্ট "," ");
                s2 = s2.replace(" কর্তৃক "," ");
                s2 = s2.replace(" ইহার "," ");
                s2 = s2.replace(" উহার "," ");
                s2 = s2.replace(" দিয়া "," ");
                //s2 = s2.replace(" সহিত "," ");
                s2 = s2.replace(" নাই "," ");
                s2 = s2.replace(" যাহা "," ");
                s2 = s2.replace(" উহা "," ");
                s2 = s2.replace(" উহারা "," ");
                s2 = s2.replace(" উহাদের "," ");
                s2 = s2.replace(" উহাকেই "," ");
                s2 = s2.replace(" যাহারা "," ");
                s2 = s2.replace(" যাহার "," ");
                s2 = s2.replace(" যাহাদের "," ");
                s2 = s2.replace(" যাহাতে "," ");
                s2 = s2.replace(" যাহাকে "," ");
                s2 = s2.replace(" উহাতে "," ");
                s2 = s2.replace(" যেহেতু "," ");
                s2 = s2.replace(" সেহেতু "," ");
                s2 = s2.replace(" নহে "," ");
                s2 = s2.replace(" পরপর "," ");
                s2 = s2.replace(" তেমনি "," ");
                s2 = s2.replace(" মতই "," ");
                s2 = s2.replace(" হউক "," ");
                s2 = s2.replace(" চারিটি "," ");
                s2 = s2.replace(" তাহা "," ");
                s2 = s2.replace(" প্রভৃতি "," ");
                 s2 = s2.replace(" যেভাবে "," ");
                  s2 = s2.replace(" জন্যই "," ");
                s2 = s2.replace(" উহা "," ");
                s2 = s2.replace(" প্রভৃতিতে "," ");
                 //s2 = s2.replace(" কিভাবে "," ");
                  s2 = s2.replace(" তাহারও "," ");

       		s2 = s2.replaceAll("\\s+"," ");


		return(s2);
		}



	public String stem(String word) {
            //String stt=new String(word);
            String ssttt="";
            String sg="";
         //System.out.println(stt);
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                //System.out.println("Driver loaded");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "root");
             Statement statement5 = connection.createStatement();
             //ResultSet resultSet5=statement5.executeQuery("select w.word_id,w.word from `wn_word` w where w.word_id='12030'");
             ResultSet resultSet5=statement5.executeQuery("select w.word_id,w.word from `wn_word` w where w.word='" + word+ "'  ");
          while(resultSet5.next())
        {
              sg=resultSet5.getString(1);

             System.out.println(sg);
              if(sg!=null )
             {
                 //System.out.println("helllllo"+resultSet1.getString(1));
               return word;

             }
             //System.out.println("gloss are::::::::::" +a);
             //gloss[k]=a;

        }

             
            
            
            
                    System.out.println("now here");

            }
            catch(Exception e)
            {
              System.out.println("i am here");
            }
		String result = cache.get(word);

		if (result != null)
			return result;

		//
		sb.delete(0, sb.length());

		//
		sb.append(word);

		/* remove the case endings from nouns and adjectives */
		remove_case(sb);

		remove_article(sb);

		normalize(sb);

		result = sb.toString();
                result=remove_change(result);
		cache.put(word, result);
		return result;
	}





	private void remove_article(StringBuilder word) {
         String stt=new String(word);
         //System.out.println(stt);
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                //System.out.println("Driver loaded");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet1=statement.executeQuery("select w.word_id,w.word from `wn_word` w where w.word='" + stt+ "'  ");

             
             if(resultSet1.getString(1)!=null )
             {
                 System.out.println("helllllo"+resultSet1.getString(1));
               return;

             }
             

            }
            catch(Exception e)
            {}

		int len = word.length() - 1;
                if(len > 6 ) {
                        if (word.substring(len - 3, len + 1).equals("খানা") )
                              {
                                word.delete(len - 3, len + 1);
				return;
                              }
                         if (word.substring(len - 4, len + 1).equals("ীয়তার") )
                              {
                                word.delete(len - 4, len + 1);
				return;
                              }
                               if (word.substring(len - 5, len + 1).equals("ধিতরূপ")) {
				word.setCharAt(len-4,'ন');
                                                                word.delete(len - 3, len + 1);
                                                                return;
			}

                           }

		if (len > 5) {
			if (word.substring(len - 3, len + 1).equals("খানি")
					|| word.substring(len - 3, len + 1).equals("গুলো")
                                        || word.substring(len - 3, len + 1).equals("গুলি") ) {
				word.delete(len - 3, len + 1);
				return;
			}
                        if (word.substring(len - 4, len + 1).equals("গুলির"))
					 {
				word.delete(len - 4, len + 1);
				return;
			}
                        if (word.substring(len - 5, len + 1).equals("মণ্ডলী"))
					 {
				word.delete(len - 5, len + 1);
				return;
			}
                       if (word.substring(len - 6, len + 1).equals("মণ্ডলীর"))
					 {
				word.delete(len - 6, len + 1);
				return;
			}
		} /* end if len >5 */
		if (len > 4) {
			if (word.substring(len - 2, len + 1).equals("য়োন")) {
				word.delete(len - 2, len + 1);
				return;
			}
                        if (word.substring(len - 2, len + 1).equals("জনক")) {
				word.delete(len - 2, len + 1);
				return;
			}
                        if (word.substring(len - 3, len + 1).equals("সমূহ"))
					 {
				word.delete(len - 3, len + 1);
				return;
			}
                        if (word.substring(len - 3, len + 1).equals("বর্গ"))
					 {
				word.delete(len - 3, len + 1);
				return;
			}
                       if (word.substring(len - 3, len + 1).equals("াবলী"))
		 {
                                       if((word.charAt(0) == 'ক')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'র')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'য')&&(word.charAt(5) == 'া'))
				{
                                                                     word.delete(len - 3, len + 1);
				     return;
                                                                }
                                        if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ম')&&(word.charAt(2) == 'স')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'য')&&(word.charAt(5) == 'া'))
				{
                                                                     word.delete(len - 2, len + 1);
				     return;
                                                                }
		}
                         if (word.substring(len - 3, len + 1).equals("বলীর"))
		 {
                                       if((word.charAt(0) == 'ক')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'র')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'য'))
				{
                                                                     word.delete(len - 3, len + 1);
				     return;
                                                                }
                                        if((word.charAt(0) == 'প')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'শ')&&(word.charAt(4) == '্')&&(word.charAt(5) == 'ন'))
				{
                                                                     word.delete(len - 4, len + 1);
				     return;
                                                                }
		}

                        if (word.substring(len - 2, len + 1).equals("াদি")) {
                                if((word.charAt(0) == 'ত')&&(word.charAt(1) == 'থ')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'য')&&(word.charAt(4) == 'া')&&(word.charAt(len-1) == 'দ'))
                                         {
                                          word.delete(len - 2, len + 1);
                                          return;
                                         }
				word.delete(len - 2, len + 1);
				return;
		}
                       if (word.substring(len , len + 1).equals("ি"))
                              {
                                        if((word.charAt(0) == 'প' )&&(word.charAt(1) == '্' )&&(word.charAt(2) == 'র' )&&(word.charAt(3) == 'ক' )&&(word.charAt(4) == 'ৃ' )&&(word.charAt(5) == 'ত' ))
                                        {
                                            	return;
                                         }
                                        if(word.charAt(len-3) == 'ল')
                                                      return;
                                          if((word.charAt(0) == 'গ' )&&(word.charAt(1) == '্' )&&(word.charAt(2) == 'র' )&&(word.charAt(3) == 'ন' )&&(word.charAt(4) == '্' )&&(word.charAt(5) == 'থ' ))
                                        {
                                            	return;
                                         }
                                         if((word.charAt(0) == 'গ' )&&(word.charAt(1) == 'ত' )&&(word.charAt(2) == 'ি' )&&(word.charAt(3) == 'প' )&&(word.charAt(4) == '্' )&&(word.charAt(5) == 'র' )&&(word.charAt(6) == 'ক' )&&(word.charAt(7) == 'ৃ' )&&(word.charAt(len-1) == 'ত' ))
                                        {
                                            	return;
                                         }
                                      if((word.charAt(0) == 'ব' )&&(word.charAt(1) == '্' )&&(word.charAt(2) == 'য' )&&(word.charAt(3) == 'ক' )&&(word.charAt(4) == '্' )&&(word.charAt(5) == 'ত' ))
                                        {
                                            	return;
                                         }
                                       if((word.charAt(0) == 'জ' )&&(word.charAt(1) == 'ু' )&&(word.charAt(2) == 'য়' )&&(word.charAt(3) == 'া' )&&(word.charAt(4) == 'চ' )&&(word.charAt(5) == 'ু' )&&(word.charAt(len) == 'ি' ))
                                        {
                                            	return;
                                         }
                                     if(word.charAt(len-1) == 'ট')
                                            {
                                                   if(word.charAt(len-2) == 'ু')
                                                      return;
                                                   if((word.charAt(len-3) == 'ষ')&&(word.charAt(len-2) == '্'))
                                                      return;
                                                  else
                                                      {
                                                       word.delete(len - 1, len + 1);
                                                      return;
                                                      }
                                           }
                                          if((word.charAt(len-3) == 'গ')&&(word.charAt(len-2) == '্')&&(word.charAt(len-1) == 'র'))
                                                               return;
                                            if((word.charAt(len-2) == 'গ')&&(word.charAt(len-1) == 'ত'))
                                                               return;
                                            if((word.charAt(len-3) == 'প')&&(word.charAt(len-1) == 'শ'))
                                                               return;
                                             if((word.charAt(0) == 'প')&&(word.charAt(1) == 'র'))
                                                               return;
                                            if(word.charAt(len-1) == 'ঠ')
                                            {
                                                return;
                                             }
                                          if((word.charAt(len-1) == 'ত')&&(word.charAt(len-2) == 'ধ'))
                                            {
                                                               return;

                                           }
                                          if((word.charAt(len-1) == 'ত')&&(word.charAt(len-2) == '্')&&(word.charAt(len-3) == 'ত'))
                                            {
                                                               return;

                                           }
                                     if((word.charAt(len-2) == 'স')&&(word.charAt(len-1) == 'র'))
                                            {

                                                      return;

                                           }
                                    if((word.charAt(len-3) == 'দ')&&(word.charAt(len-2) == '্')&&(word.charAt(len-1) == 'ধ'))
                                            {
                                                   return;
                                           }
                                   else{ word.delete(len, len+1);
                                              return;}

                              }
                          if (word.substring(len , len + 1).equals("ী")) {
                           if(word.charAt(0) == 'শ')
                                              return;
                           if((word.charAt(0) == 'প')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ধ'))
                                              return;
                             if((word.charAt(0) == 'ক')&&(word.charAt(len-3) == 'চ')&&(word.charAt(len-1) == 'র'))
                                              return;
                             if((word.charAt(0) == 'স')&&(word.charAt(len-3) == 'ক')&&(word.charAt(len-1) == 'র'))
                                              return;
                              if((word.charAt(len-3) == 'গ')&&(word.charAt(len-2) == '্')&&(word.charAt(len-1) == 'র'))
                                                               return;
                           if(word.charAt(len-3) == 'থ')
                                               return;
			if(word.charAt(len-2) == 'ক')
                                                       {
                                                              word.delete(len , len + 1);
				return;
                                                       }
                              if(word.charAt(0) == 'ক')
                                                       {
                                                              word.delete(len , len + 1);
				return;
                                                       }

                              if(word.charAt(0) == 'স')
                                                       {
                                                                if((word.charAt(1) == 'ে')&&(word.charAt(2) == 'ব')&&(word.charAt(3) == 'া')&&(word.charAt(4) == 'প')&&(word.charAt(5) == '্')&&(word.charAt(6) == 'র')&&(word.charAt(7) == 'দ'))
                                                                     return;
                                                               else{
                                                                     word.delete(len , len + 1);
				    return;
                                                              }
                                                       }

                              if(word.charAt(0) == 'আ')
                                                       {
                                                              word.delete(len , len + 1);
				return;
                                                       }
                                               if(word.charAt(len-1) == 'ণ')
                                                       {
                                                              word.delete(len , len + 1);
				return;
                                                       }
			}
                        if (word.substring(len - 2, len + 1).equals("বান")) {
				if(word.substring(len - 4, len + 1).equals("হ্বান"))
                                                                   return;
                                                               else{
                                                               word.delete(len - 2, len + 1);
				return;
                                                                  }
			}
		} /* end if len > 3 */
                if (len >3 ) {

			if (word.substring(len - 1, len + 1).equals("গণ")) {
				word.delete(len - 1, len + 1);
				return;
			}

                        if (word.substring(len - 1, len + 1).equals("টা"))
		 { if(word.charAt(len-2) == '্')
                                              return;
                                   else if((word.charAt(len-3) == 'ক')&&(word.charAt(len-2) == 'া'))
                                              return;
                                 else {
				word.delete(len - 1, len + 1);
				return;
                              }

			}
                         if (word.substring(len - 1, len + 1).equals("ের")) {
                               if(word.charAt(0) == 'ব')
                                 {
                                      word.delete(len - 1, len + 1);
                                     return;
                                 }
				word.delete(len - 1, len + 1);
				return;
			}


                        if (word.substring(len - 1, len + 1).equals("টি")) {
		 if(word.charAt(len-2) == '্' || word.charAt(len-2) == 'ু' )
                                              return;
                                 else {
			word.delete(len - 1, len + 1);
			return;
                                }
			}
                        if (word.substring(len - 1, len + 1).equals("কে")) {
		if((word.charAt(len-2) == 'য')&&(word.charAt(0) == 'প' ))
                                   {
                                         word.delete(len, len + 1);
                                         return;
                                    }
                                if((word.charAt(len-3) == 'দ')&&(word.charAt(len-2) == 'ি' ))
                                   {
                                         word.delete(len, len + 1);
                                         return;
                                    }
                                else{
                                      	word.delete(len - 1, len + 1);
				return;
                                      }
			}

		} /* end if len > 3 */

		if (len > 2) {


                       if (word.substring(len - 2, len + 1).equals("টির")){
                             if(word.charAt(len-3) == 'া' || word.charAt(len-3) == 'ু' )
                               {
                              word.delete(len , len + 1);
				return;
			        }
                             else {
				word.delete(len - 2, len + 1);
				return;
                                }
		}

				return;

	}
  }

	private void remove_case(StringBuilder word) {
		int len = word.length() - 1;
        String stt=new String(word);
         //System.out.println(stt);
            /*try
            {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet1=statement.executeQuery("select w.word_id,w.word from `wn_word` w where w.word='" + stt+ "'  ");

             
             if(resultSet1.getString(1)!=null )
             {
                 System.out.println("helllllo"+resultSet1.getString(1));
               return;

             }


            }
            catch(Exception e)
            {}*/
		if (len > 8) {
			if (word.substring(len - 6, len + 1).equals("য়েদেরকে")) {
				word.delete(len - 6, len + 1);
				return;
			}
                        if (word.substring(len - 4, len + 1).equals("পূর্ণ"))
					 {
				word.delete(len - 4, len + 1);
				return;
			}
		} /* end if len >8 */

		if (len > 6) {
			if (word.substring(len - 4, len + 1).equals("দেরকে")
					|| word.substring(len - 4, len + 1).equals("য়েদের")) {
				word.delete(len - 4, len + 1);
				return;
			}
                        if (word.substring(len - 4, len + 1).equals("সাধনও") )
                              {
                                word.delete(len - 4, len + 1);
				return;
                              }
                        if (word.substring(len - 4, len + 1).equals("ছিলাম")) {
				word.delete(len - 4, len + 1);
				return;
			}

                        if (word.substring(len - 6, len + 1).equals("প্রাপ্ত")) {
				word.delete(len - 6, len + 1);
				return;
			}
                          if (word.substring(len - 6, len + 1).equals("ানুসারে")) {
				word.delete(len - 6, len + 1);
				return;
			}
                        if (word.substring(len - 4, len + 1).equals("যুক্ত")) {
			 if((word.charAt(0) == 'য')&&(word.charAt(1) == 'থ')&&(word.charAt(2) == 'ো')&&(word.charAt(3) == 'প'))
                                                      return;
                                   	else
                                                        {
                                                              word.delete(len - 4, len + 1);
				return;
                                                        }
			}

		} /* end if len >6 */
		if (len > 5) {
			if (word.substring(len - 3, len + 1).equals("েদের")
					|| word.substring(len - 3, len + 1).equals("য়েরা")
                                        || word.substring(len - 3, len + 1).equals("বাচক")) {
				word.delete(len - 3, len + 1);
				return;
			}

                        if (word.substring(len - 2, len + 1).equals("ছিল")) {
				word.delete(len - 2, len + 1);
				return;
			}
                        if (word.substring(len - 3, len + 1).equals("য়াছে")) {
				word.delete(len - 3, len + 1);
				return;
			}
                        if (word.substring(len - 2, len + 1).equals("বার")) {
                                if(word.charAt(len-3) == 'ি')
                                      {
                                        word.setCharAt(len-3, 'া');
                                         }

                                if(word.charAt(len-6) == 'ু')
                                      {
                                        word.setCharAt(len-6, 'ো');
                                        word.delete(len - 3, len+1);
                                        return;
                                         }

				word.delete(len - 2, len + 1);
				return;
			}
                        if (word.substring(len - 4, len + 1).equals("নৈতিক")) {
				word.delete(len - 4, len + 1);
				return;
			}
                        if (word.substring(len - 2, len + 1).equals("য়ের")) {
                                  if(word.charAt(1) == 'ি')
                                 {
                                      word.delete(len - 1, len + 1);
                                     return;
                                 }
                                  if(word.charAt(3) == 'য়')
                                              return;
                                  if(word.charAt(0) == 'ন')
                                              return;

                                  if(word.charAt(len-3) == 'ম')
                                      {
                                          return;
                                         }
                                 else {
				word.delete(len - 2, len + 1);
				return;
                               }
			}
                        if (word.substring(len - 3, len + 1).equals("কারী")) {
				word.delete(len - 3, len + 1);
				return;
			}
                        if (word.substring(len - 1, len + 1).equals("ময়")) {
				word.delete(len - 1, len + 1);
				return;
			}
                 if (word.substring(len - 2, len + 1).equals("কার"))
					 {

                                   if(word.charAt(len-4) == 'ব')
                                      {
                                         word.delete(len , len + 1);
                                      //  word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                    if(word.charAt(0) == 'আ')
                                      {
                                         word.delete(len , len + 1);
                                      //  word.setCharAt(len - 1, 'া');
                                          return;
                                         }

                                    if(word.charAt(len-6) == 'ম')
                                      {
                                         word.delete(len , len + 1);
                                      //  word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                  if(word.charAt(len-3) == '্')
                                              return;
                                 else {
			       	word.delete(len - 2, len + 1);
				return;
                                }
			}

		} /* end if len >5 */
		if (len > 4) {
                        if (word.substring(len - 3, len + 1).equals("ভাবে"))
					 {
				word.delete(len - 3, len + 1);
				return;
			}
                        if (word.substring(len - 4, len + 1).equals("ান্তে"))
					 {
                                          if(word.charAt(0) == 'এ')
                                      {
                                       // word.delete(len - 1, len + 1);
				        return;
                                         }
                                  if(word.charAt(1) == 'ি')
                                      {
                                       // word.delete(len , len + 1);
				        return;
                                         }
				word.delete(len - 4, len + 1);
				return;
			}
                        if (word.substring(len - 2, len + 1).equals("বার")) {
                                if(word.charAt(len-3) == 'ি')
                                      {
                                        word.setCharAt(len-3, 'া');
                                         }

				word.delete(len - 2, len + 1);
				return;
			}

                        if (word.substring(len - 1, len + 1).equals("তে")) {

                                       if((word.charAt(0) == 'প')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র'))
                                      {
                                                  if((word.charAt(3) == 'ণ')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'ল')&&(word.charAt(6) == 'ী'))
                                                          {
                                                                 word.delete(len-1 , len + 1);
				   return;
                                                          }
                                                   else{

                                                                  word.delete(len , len + 1);
				   return;
                                                          }

                                         }

                                       if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ম')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'প')&&(word.charAt(4) == 'ত')&&(word.charAt(5) == '্')&&(word.charAt(6) == 'ত')&&(word.charAt(7) == 'ি'))
                                      {
                                          word.delete(len-1 , len + 1);
                                          return;
                                         }
                                       if((word.charAt(0) == 'র')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'শ')&&(word.charAt(0) == 'ি'))
                                      {
                                        word.delete(len - 1, len + 1);
				        return;
                                         }
                                          if(word.charAt(0) == 'প')
                                      {
                                        word.delete(len - 1, len + 1);
				        return;
                                         }
                                        if((word.charAt(len-3) == 'ণ')&&(word.charAt(len-2) == 'ী'))
                                      {
                                         word.delete(len-1 , len + 1);
				        return;
                                         }
                                         if(word.charAt(len-3) == 'ঠ')
                                      {
                                          word.delete(len-1 , len + 1);
                                          return;
                                         }
                                        if((word.charAt(len-2) == 'ী')&&(word.charAt(len-3) == 'ণ'))
                                      {
                                        word.delete(len - 2, len + 1);
				        return;
                                         }
                                       if(word.charAt(1) == 'ত')
                                      {
                                       // word.delete(len - 1, len + 1);
				        return;
                                         }
                                       if((word.charAt(0) == 'ব')&&(word.charAt(2)!= 'ন'))
                                      {
                                        word.setCharAt(len - 2, 'া');
                                         word.delete(len - 1, len + 1);
				        return;
                                         }
                                      if(word.charAt(1) == 'থ')
                                      {
                                         //word.delete(len , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }

                                     if(word.charAt(0) == 'এ')
                                      {
                                       // word.delete(len - 1, len + 1);
				        return;
                                         }
                                     if(word.charAt(2) == 'ই')
                                      {
                                        word.delete(len - 1, len + 1);
				        return;
                                         }
                                   if(word.charAt(0) == 'ভ')
                                      {
                                       // word.delete(len - 1, len + 1);
				        return;
                                         }
                                     if((word.charAt(1) == 'ি')&&(word.charAt(2)!= 'ন'))
                                      {
                                        word.delete(len , len + 1);
				        return;
                                         }
                                     if(word.charAt(len-2) == 'ি')
                                      {
                                       if(word.charAt(0) == 'ত')
                                         {
                                          word.delete(len - 1, len + 1);
                                          return;
                                         }
                                       if(word.charAt(0) == 'ল')
                                         {
                                          word.delete(len - 1, len + 1);
                                          return;
                                         }
                                        word.setCharAt(len-2, 'া');
                                         }

				word.delete(len - 1, len + 1);
				return;
			}

                        if (word.substring(len - 1, len + 1).equals("িক")) {
                               if((word.charAt(0) == 'স' )&&(word.charAt(1) == 'া' ))
                                     return;
                               if((word.charAt(len-2) == 'ত' )&&(word.charAt(len-3) == '্' )&&(word.charAt(len-4) == 'ত' ))
                                     return;
                               if((word.charAt(0) == 'অ' )&&(word.charAt(2) == '্' )&&(word.charAt(3) == 'ব' ))
                                     return;
                               if(word.charAt(len-2) == 'ধ' )
                                     return;
                               if(len==5) {
                                     if(word.charAt(0) == 'আ'
                                    && word.charAt(len-2) == 'ন' )
                                     return;
                                        }
                                  if(word.charAt(0) == 'আ' ){
                                     word.setCharAt(0, 'অ');
                                       }
                                  if(word.charAt(1) == 'ৈ' ){
                                     word.setCharAt(1, 'ি');
                                       }
                                  if(word.charAt(0) == 'ঐ' ){
                                     word.setCharAt(0, 'ই');
                                       }
                                word.delete(len - 1, len + 1);
                                if(word.charAt(1) == 'া' )
                                     word.delete(1, 2);
                                if (word.substring(1, 4).equals("্রা"))
                                     word.delete(3, 4);
				return;
			}
			if (word.substring(len - 2, len + 1).equals("দের")||
					word.substring(len - 2, len + 1).equals("েরা")) {
				word.delete(len - 2, len + 1);
				return;
			}
                        if (word.substring(len - 2, len + 1).equals("শীল")) {
				word.delete(len - 2, len + 1);
				return;
			}
                        if (word.substring(len - 1, len + 1).equals("িত")) {
                                    if((word.charAt(0) == 'উ')&&(word.charAt(1) == 'প')&&(word.charAt(2) == 'স')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'থ'))
                                      {

                                          return;
                                         }
                                        if((word.charAt(0) == 'হ')&&(word.charAt(1) == 'স')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'ত')&&(word.charAt(4) == 'স')&&(word.charAt(5) == '্')&&(word.charAt(6) == 'থ'))
                                      {

                                          return;
                                         }
                                       if((word.charAt(0) == 'র')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'শ')&&(word.charAt(3) == 'ি'))
                                      {
                                        word.delete(len, len + 1);
				        return;
                                         }
                                         if((word.charAt(0) == 'অ')&&(word.charAt(1) == 'ব')&&(word.charAt(2) == 'হ'))
                                        {
                                          return;
                                         }
                                       if(word.charAt(1) == 'ণ')
                                      {
                                        word.setCharAt(len - 1, 'ন');
				        word.delete(len , len + 1);
                                          return;
                                         }
                                       if((word.charAt(0) == 'ব')&&(word.charAt(1) == 'ি')&&(word.charAt(len-2) == 'চ'))
                                      {
                                        word.setCharAt(len - 1, 'ন');
                                        word.setCharAt(len, 'া');
		        //word.delete(len , len + 1);
                                          return;
                                         }

                                        if((word.charAt(0) == 'ব')&&(word.charAt(1) == 'ন'))
                                      {
                                          word.setCharAt(len - 1, 'ন');
                                          word.delete(len , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                        if((word.charAt(0) == 'অ')&&(word.charAt(1) == 'ভ'))
                                      {
                                                      return;
                                         }
                                        if((word.charAt(0) == 'ব'))
                                      {
                                         word.delete(len - 1 , len + 1);
                                      //  word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                if(word.charAt(1) == 'থ')
                                      {
                                         word.delete(len , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                if(word.charAt(0) == 'এ')
                                      {
                                         word.delete(len -1 , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                if(word.charAt(0) == 'চ')
                                      {
                                         word.delete(len -1 , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                               if(word.charAt(len-2) == 'ম')
                                      {
                                         //word.delete(len , len + 1);
                                        //word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                        if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ু')&&(word.charAt(2) == 'প'))
                                      {
                                          return;
                                         }
                                word.setCharAt(len - 1, 'ন');
				word.delete(len , len + 1);
				return;
			}
                        if (word.substring(len - 3, len + 1).equals("সমূহ"))
					 {
				word.delete(len - 3, len + 1);
				return;
			}
			if (word.substring(len - 1, len + 1).equals("মি")) {
				word.delete(len - 1, len + 1);
				return;
			}
                        if (word.substring(len - 1, len + 1).equals("ের")) {
                                if(word.charAt(0) == 'ব')
                                 {
                                      word.delete(len - 1, len + 1);
                                     return;
                                 }
				word.delete(len - 1, len + 1);
				return;
			}
                        if (word.substring(len - 1, len + 1).equals("কর"))
					 {
				word.delete(len - 1, len + 1);
				return;
			}

                        if (word.substring(len - 3, len + 1).equals("লব্ধ")) {
				word.delete(len - 3, len + 1);
				return;
			}
                        if (word.substring(len - 1, len + 1).equals("তর"))
					 {if(word.charAt(len-2) == '্')

                                               return;

                                 else {
				word.delete(len - 1, len + 1);
				return;
                               }
			}
                        if (word.substring(len - 2, len + 1).equals("জনক")) {
				word.delete(len - 2, len + 1);
				return;
			}
                        if (word.substring(len - 3, len + 1).equals("বদ্ধ")) {
				word.delete(len - 3, len + 1);
				return;
			}
                        if (word.substring(len - 2, len + 1).equals("াদি")) {
                                if(word.charAt(0) == 'ত')
                                         {
                                        //  word.delete(len - 1, len + 1);
                                          return;
                                         }
				word.delete(len - 2, len + 1);
				return;
			}

		} /* end if len > 4 */
		if (len > 3) {

			if (word.substring(len - 1, len + 1).equals("তা")) {
                                  if(word.charAt(1) == 'ণ')
                                       return;
                                  if(word.charAt(0) == 'গ')
                                       return;
                                   if(word.charAt(len-2) == 'ম')
                                       return;
                                    if((word.charAt(0) == 'প')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ত')&&(word.charAt(4) == 'ি')&&(word.charAt(5) == 'য')&&(word.charAt(6) == 'ো')&&(word.charAt(7) == 'গ')&&(word.charAt(8) == 'ি'))
                                       return;
                                  if(word.charAt(len-2) == '্')
                                        return;
                                  if(word.charAt(len-3) == 'দ')
                                        return;
                                  if((word.charAt(1) == 'হ')&&(word.charAt(2) != 'া'))
                                     {
                                       word.delete(len - 2, len + 1);
                                       return;
                                     }


                                 else {
				word.delete(len - 1, len + 1);
				return;
                             }
			}

                        if (word.substring(len - 1, len + 1).equals("ীয়"))
					 {
                                if(word.charAt(len-2) == 'ত')

                                               return;

                                 else {
				word.delete(len - 1, len + 1);
				return;
                               }
			}
                        if (word.substring(len - 2, len + 1).equals("তেই")) {
		 if(word.charAt(0) == 'ক')
                                      {
                                          word.setCharAt(len - 2, 'া');
                                           word.delete(len - 2, len + 1);
		           return;
                                       }
                                 else
                                       {
                                               word.delete(len - 2, len + 1);
		           return;
                                       }
			}
			if (word.substring(len - 1, len + 1).equals("তে")) {

                                   if(word.charAt(0) == 'ভ')
                                      {
                                       // word.delete(len - 1, len + 1);
				        return;
                                         }
                                        if((word.charAt(0) == 'র')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'শ')&&(word.charAt(3) == 'ি'))
                                      {
                                        word.delete(len, len + 1);
				        return;
                                         }
                                         if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ম')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'প')&&(word.charAt(4) == 'ত')&&(word.charAt(5) == '্')&&(word.charAt(6) == 'ত')&&(word.charAt(7) == 'ি'))
                                      {
                                          word.delete(len-1 , len + 1);
                                          return;
                                         }
                                         if((word.charAt(0) == 'র')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'শ')&&(word.charAt(3) == 'ি'))
                                      {
                                        word.delete(len - 1, len + 1);
				        return;
                                         }
                                           if((word.charAt(0) == 'প')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র'))
                                      {
                                                          word.delete(len , len + 1);
				   return;
                                         }
                                          if((word.charAt(len-3) == 'ণ')&&(word.charAt(len-2) == 'ী'))
                                      {
                                          word.delete(len-1 , len + 1);
				        return;
                                         }
                                      if(word.charAt(len-3) == 'ঠ')
                                      {
                                          word.delete(len-1 , len + 1);
                                          return;
                                         }
                                     if((word.charAt(len-2) == 'ী')&&(word.charAt(len-3) == 'ণ'))
                                      {
                                        word.delete(len - 2, len + 1);
				        return;
                                         }
                                     if(word.charAt(1) == 'ত')
                                      {
                                       // word.delete(len - 1, len + 1);
				        return;
                                         }
                                    if(word.charAt(0) == 'প')
                                      {
                                        word.delete(len - 1, len + 1);
				        return;
                                         }
                                     if(word.charAt(0) == 'এ')
                                      {
                                       // word.delete(len - 1, len + 1);
				        return;
                                         }
                                     if(word.charAt(0) == 'স')
                                      {
                                        word.delete(len , len + 1);
				        return;
                                         }
                                     if((word.charAt(len-2) == '্')&&(word.charAt(2)!= 'ন')){
                                           word.delete(len , len + 1);
                                              return;
                                         }
                                     if(word.charAt(2) == 'ি'){
                                        word.setCharAt(2, 'া');

                                        word.delete(len - 1, len + 1);

				        return;
                                       }
                                 if(word.charAt(len-2) == 'ই')
                                        {
                                         if(word.charAt(0) == 'ব')
                                       {
                                          word.delete(len - 1, len + 1);
                                          return;
                                       }
                                        else{
                                       word.setCharAt(len - 2, 'য়');
                                       word.delete(len - 1, len + 1);
                                        return;
                                         }
                                 }
                                 if((word.charAt(0) == 'ব')&&(word.charAt(2)!= 'ন'))
                                      {
                                        word.setCharAt(len - 2, 'া');
                                         word.delete(len - 1, len + 1);
				        return;
                                         }

                                 else {
				word.delete(len - 1, len + 1);
				return;
                                       }
			}

                        if (word.substring(len - 1, len + 1).equals("গত")) {
				word.delete(len - 1, len + 1);
				return;
			}
			if (word.substring(len - 1, len + 1).equals("রা")) {
                                if(word.charAt(len-2) == '্')
                                      {
                                          return;
                                         }
                                if((word.charAt(len-2) == 'ব')&&(word.charAt(len-3) == '্'))
                                      {
                                          return;
                                         }
                                 else {
				word.delete(len-1, len + 1);
				return;
                               }
			}


                        if (word.substring(len - 1, len + 1).equals("বি")) {
				word.delete(len-1, len + 1);
				return;
			}
                        if (word.substring(len - 1, len + 1).equals("কর"))
					 {
				word.delete(len - 1, len + 1);
				return;
			}
                        if (word.substring(len - 1, len + 1).equals("য়ে")) {
                               if(word.charAt(0) == 'অ')
                                              return;
                               if((word.charAt(0) == 'ন')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'য়'))
                                 {
				return;
                                  }
                                  if((word.charAt(0) == 'ক')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ম')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'ন'))
                                          {
                                                    word.delete(len, len + 1);
                                                    return;
                                          }
                                     if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ম')&&(word.charAt(2) == 'ন')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'ব'))
                                          {
                                                    word.delete(len, len + 1);
                                                    return;
                                          }
                                 if(word.charAt(3) == 'য')
                                       {
                                         word.delete(len, len + 1);
				return;
                                       }
                               if(word.charAt(0) == 'উ')
                                              return;
                               if(word.charAt(0) == 'ন')
                                  {
                                    if((word.charAt(len) == 'ে')&&(word.charAt(1) != 'ি'))
                                      {
                                         word.delete(len, len+1);
                                         return;
                                       }
                                   return;
                                  }
                               if(word.charAt(1) == 'ি')
                                            {
                                                if((word.charAt(0) == 'ব')&&(word.charAt(2) == 'ষ')&&(word.charAt(3) == 'য়'))
                                                 {
                                                    word.delete(len, len + 1);
				return;
                                                   }
                                                 return;
                                             }
				word.delete(len - 1, len + 1);
				return;
			}
                        if (word.charAt(len) == 'য়')
                              {
                                 if((word.charAt(0) == 'ক')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ম')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'ন'))
                                          {

                                                    return;
                                          }
                                   if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ম')&&(word.charAt(2) == 'ন')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'ব'))
                                          {

                                                    return;
                                          }
                                if((word.charAt(0) == 'ক')&&(word.charAt(0) == '্')&&(word.charAt(0) == 'র'))
                                        {
                                            return;
                                         }
                                   if((word.charAt(0) == 'অ')&&(word.charAt(1) == 'ন')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'য')&&(word.charAt(4) == 'থ'))
                                           {
                                             word.delete(len, len + 1);  return;
                                           }
                                  if(word.charAt(0) == 'অ')
                                              return;
                                  if(word.charAt(3) == 'য')
                                       {
                                	return;
                                       }
                                  if((word.charAt(1) == 'ঞ')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'চ'))
                                              return;
                                if((word.charAt(len-2) == 'ট')&&(word.charAt(len-1) == 'া'))
                                    return;
                              if(word.charAt(0) == 'ন')
                                              return;
                                if(word.charAt(3) == 'য়')
                                              {
                                                    if((word.charAt(0) == 'ক')&&(word.charAt(1)== 'থ'))
                                                      {
                                                              word.delete(len, len + 1);
                                                             return;
                                                       }
                                                     return;
                                              }
                                if((word.charAt(4) == 'ব')&&(word.charAt(0)!= 'ব'))
                                              return;
                                if((word.charAt(len-1) == 'া')&&(word.charAt(len-2) == 'হ'))
                                              return;
                                if (word.substring(len - 1, len + 1).equals("ময়")) {
				return;
			       }
                                if (word.substring(len - 3, len + 1).equals("ক্রয়")) {
				return;
			       }
                             else {
                              word.delete(len, len + 1);
				return;
			}
                      }

		} /* end if len > 3 */
	if (len > 2) {
                        if (word.substring(len - 1, len + 1).equals("বে")) {
                                 if((word.charAt(0) == 'ব')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'স')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'ত'))
                                      {
                                          word.delete(len, len + 1);
                                          return;
                                         }
                                  if((word.charAt(0) == 'ভ')&&(word.charAt(1) == 'ে'))
                                      {
                                        return;
                                      }
                                   if((word.charAt(len-2) == '্'))
                                      {
                                          word.delete(len, len + 1);
                                          return;
                                         }
                                  if((word.charAt(1) == 'ভ'))
                                      {
                                          word.delete(len, len + 1);
                                          return;
                                         }
                                  if((word.charAt(len-3) == 'স'))
                                      {
                                          word.delete(len, len + 1);
                                          return;
                                         }
                                 else if(word.charAt(len-2) == 'ই')
                                      {
                                          word.setCharAt(len - 2, 'য়');
                                          word.delete(len-1, len + 1);
                                          return;
                                         }
                                 else {
				word.delete(len-1, len + 1);
				return;
                               }
			}
                        if (word.substring(len - 1, len + 1).equals("কে")) {
                               if(word.charAt(len-2) == '্')
                                      {
                                             word.delete(len, len + 1);
                                               return;
                                         }
                             if((word.charAt(len-2) == 'য')&&(word.charAt(0) == 'প' ))
                                   {
                                         word.delete(len, len + 1);
                                         return;
                                    }
                                  if((word.charAt(len-3) == 'দ')&&(word.charAt(len-2) == 'ি' ))
                                   {
                                         word.delete(len, len + 1);
                                         return;
                                    }
                                 else {
				word.delete(len-1, len + 1);
				return;
                               }
			}
                        if (word.substring(len - 1, len + 1).equals("িত")) {
                                 if((word.charAt(0) == 'উ')&&(word.charAt(1) == 'প')&&(word.charAt(2) == 'স')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'থ'))
                                      {

                                          return;
                                         }
                                         if((word.charAt(0) == 'হ')&&(word.charAt(1) == 'স')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'ত')&&(word.charAt(4) == 'স')&&(word.charAt(5) == '্')&&(word.charAt(6) == 'থ'))
                                      {

                                          return;
                                         }
                                      if((word.charAt(0) == 'র')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'শ')&&(word.charAt(3) == 'ি'))
                                      {
                                        word.delete(len, len + 1);
				        return;
                                         }
                                         if((word.charAt(0) == 'অ')&&(word.charAt(1) == 'ব')&&(word.charAt(2) == 'হ'))
                                        {
                                          return;
                                         }
                                      if((word.charAt(0) == 'ব')&&(word.charAt(1) == 'ন')&&(word.charAt(2) == '্'))
                                      {
                                          word.setCharAt(len - 1, 'ন');
                                          word.delete(len , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                          if((word.charAt(0) == 'ব')&&(word.charAt(1) == 'ি')&&(word.charAt(len-2) == 'চ'))
                                      {
                                        word.setCharAt(len - 1, 'ন');
                                        word.setCharAt(len , 'া');
		        //word.delete(len , len + 1);
                                          return;
                                         }
                                if(word.charAt(1) == 'ণ')
                                      {
                                        word.setCharAt(len - 1, 'ন');
				        word.delete(len , len + 1);
                                          return;
                                         }
                                        if((word.charAt(0) == 'ব'))
                                      {

                                          word.delete(len -1 , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }

                                if(word.charAt(1) == 'থ')
                                      {
                                         word.delete(len , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                  if(word.charAt(len-2) == 'ড়')
                                      {
                                          word.setCharAt(len - 1, 'া');
                                          word.setCharAt(len, 'ন');
                                          return;
                                         }
                                if(word.charAt(0) == 'এ')
                                      {
                                         word.delete(len -1 , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                if(word.charAt(0) == 'চ')
                                      {
                                         word.delete(len -1 , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                if(word.charAt(len-2) == 'খ')
                                      {
                                         word.delete(len , len + 1);
                                        word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                 if(word.charAt(len-2) == 'র')
                                      {
                                         word.delete(len , len + 1);
                                        word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                if(word.charAt(len-2) == 'ম')
                                      {
                                         //word.delete(len , len + 1);
                                        //word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                    if((word.charAt(0) == 'অ')&&(word.charAt(1) == 'ভ'))
                                      {

                                          return;
                                         }
                                   if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ু')&&(word.charAt(2) == 'প'))
                                      {
                                          return;
                                         }
                                else {
                                word.setCharAt(len - 1, 'ন');
				word.delete(len , len + 1);
				return;
			      }
				//word.delete(len - 1, len + 1);
			}
                        if (word.substring(len - 1, len + 1).equals("িল")) {
                                 if(word.charAt(len-2) == 'ট')
                                      {
                                           if(word.charAt(0)== 'জ')
                                             return;
                                           word.setCharAt(len - 1, 'া');
                                           word.delete(len , len + 1);
                                          return;
                                         }
                                 if(word.charAt(len-2) == 'র')
                                      {
                                           word.setCharAt(len - 1, 'া');
                                           word.delete(len , len + 1);
                                          return;
                                         }
                                 if((word.charAt(len-2) == 'গ')||(word.charAt(len-2) == 'স'))
                                      {
                                         word.delete(len , len + 1);
                                         word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                 else {
				word.delete(len - 1, len + 1);
				return;
                              }
			}
                        if (word.substring(len - 1, len + 1).equals("ছে")) {
				word.delete(len - 1, len + 1);
				return;
			}
                        if (word.substring(len - 1, len + 1).equals("ছি")) {
				word.delete(len - 1, len + 1);
				return;
			}
                        if (word.substring(len - 1, len + 1).equals("ের")) {
                                if(word.charAt(0) == 'ব')
                                 {
                                      word.delete(len - 1, len + 1);
                                     return;
                                 }
				word.delete(len - 1, len + 1);
				return;
			}
                        if (word.substring(len - 2, len + 1).equals("েরও")) {
				word.delete(len - 2, len + 1);
				return;
			}

                        if (word.substring(len - 2, len + 1).equals("ইয়া")) {
                               if((word.charAt(len-3) == 'া')&&(word.charAt(len-4) == 'ট'))
                                 {
                                     word.setCharAt(len - 2, 'য়');
                                     word.delete(len - 1, len + 1);
                                      return;
                                   }
                                  if((word.charAt(0) == 'হ')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'া'))
                                 {
                                     word.setCharAt(3, 'ি');
                                      word.setCharAt(4, 'য়');
                                      word.setCharAt(5, 'ে');
                                     //word.delete(len, len + 1);
                                      return;
                                   }
                                if(word.charAt(0) == 'ল')
                                 {
                                  if(word.charAt(1)== 'া')
                                   {
                                     word.delete(len - 2, len + 1);
                                      return;
                                   }
                                  word.setCharAt(len - 2, 'য়');
                                  word.delete(len - 1, len + 1);
                                  return;
                                 }
				//word.setCharAt(len - 2, 'য়');
                                word.delete(len - 2, len + 1);

				return;
			}
                        if (word.substring(len - 1, len + 1).equals("য়া")) {

                                if(word.charAt(len-2) == 'ি')
                                      {
                                        word.setCharAt(len-2, 'া');
                                        word.delete(len - 1, len + 1);
                                        return;
                                      }
                                    if (word.substring(len - 3, len + 1).equals("তীয়া"))
                                      {
                                         return;
                                       }
                                if(word.charAt(len-2)== 'ও')
                                   {
                                      return;
                                   }
                                 else
                                  {

                                 word.delete(len - 1, len + 1);
				return;
                             }
			}
                        if(word.charAt(len-1)== 'র')
                                   {
                                          if((word.charAt(0) == 'ক' )&&(word.charAt(1) == 'া' )&&(word.charAt(len-2) == 'ক' )&&(word.charAt(len) == 'ী' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                       if((word.charAt(0) == 'হ' )&&(word.charAt(1) == 'া' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                           if((word.charAt(0) == 'জ' )&&(word.charAt(1) == 'ু' )&&(word.charAt(2) == 'য়' )&&(word.charAt(3) == 'া' )&&(word.charAt(4) == 'চ' )&&(word.charAt(5) == 'ু' )&&(word.charAt(len) == 'ি' ))
                                        {
                                            	return;
                                         }
                                          if((word.charAt(0) == 'চ' )&&(word.charAt(1) == 'ু' )&&(word.charAt(len) == 'ি' ))
                                        {

				return;
                                         }

                                         if((word.charAt(0) == 'প' )&&(word.charAt(1) == 'ক' )&&(word.charAt(2) == '্' )&&(word.charAt(5) == 'ন' )&&(word.charAt(6) == '্' )&&(word.charAt(len-2) == 'ত' )&&(word.charAt(len) == 'ে' ))
                                        {
                                              word.delete(len, len + 1);
                                                               return;
                                         }
                                          if((word.charAt(0) == 'ব' )&&(word.charAt(1) == 'া' )&&(word.charAt(2) == 'জ' )&&(word.charAt(3) == 'া' )&&(word.charAt(len) == 'ে' ))
                                        {
                                               word.delete(len, len + 1);
				return;
                                         }
                                         if((word.charAt(0) == 'স' )&&(word.charAt(1) == '্' )&&(word.charAt(2) == 'ত' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                            if((word.charAt(0) == 'প' )&&(word.charAt(3) == 'স' )&&(word.charAt(4) == '্' )&&(word.charAt(5) == 'ত' )&&(word.charAt(len) == 'ও' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                          if((word.charAt(0) == 'অ' )&&(word.charAt(1) == 'ভ' )&&(word.charAt(len-4) == 'ন' )&&(word.charAt(len-3) == '্' )&&(word.charAt(len-2) == 'ত' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                        if((word.charAt(len) == 'ই' )&&(word.charAt(len-2) == 'ে' ))
                                        {
                                            word.delete(len-2, len + 1);
				return;
                                         }
                                     if((word.charAt(len) == 'ই' )&&(word.charAt(len-2) == 'া'))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                     if((word.charAt(0) == 'স' )&&(word.charAt(len) == 'ী' )&&(word.charAt(len-2) == 'া' )&&(word.charAt(len-3) == 'ক' ))
                                        {
                                           	return;
                                         }
                                          if((word.charAt(0) == 'ধ' )&&(word.charAt(1) == 'া' ))
                                        {
                                            if(word.charAt(len) == 'ণ' )
                                                         return;
                                            else{
                                                     word.delete(len, len + 1);
				return;
                                                 }
                                         }
                                          if((word.charAt(len) == 'প' ))
                                        {

				return;
                                         }
                                         if((word.charAt(len) == 'ে' )&&(word.charAt(len-2) == 'ী' )&&(word.charAt(len-3) == 'ন' ))
                                        {
                                            word.delete(len-1, len + 1);
				return;
                                         }
                                        if((word.charAt(len) == 'ে' )&&(word.charAt(len-2) == 'প' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                          if((word.charAt(0) == 'আ' )&&(word.charAt(1) == 'ক' )&&(word.charAt(2) == 'া' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                          if((word.charAt(len) == 'ে' )&&(word.charAt(len-2) == '্' )&&(word.charAt(len-3) == 'থ' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                      if((word.charAt(len) == 'ম' )&&(word.charAt(len-3) == 'ক' ))
                                        {

				return;
                                         }
                                     if((word.charAt(0) == 'ত' )&&(word.charAt(1) == 'ৈ' ))
                                        {

				return;
                                         }
                                      if((word.charAt(len-3) == 'গ' )&&(word.charAt(len-2) == '্' )&&(word.charAt(len) == 'ী' ))
                                        {

				return;
                                         }
                                       if((word.charAt(len) == 'য়' ))
                                        {
                                             if((word.charAt(0) == 'ক')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ম')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'ন'))
                                          {

                                                    return;
                                          }
                                          if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ম')&&(word.charAt(2) == 'ন')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'ব'))
                                          {

                                                    return;
                                          }
			else
                                                  return;
                                         }
                                       if((word.charAt(len-2) == 'স' )&&(word.charAt(len) == 'ি' ))
                                        {

				return;
                                         }
                                      if((word.charAt(len-2) == 'প' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }
                                        if((word.charAt(len) == 'ক' )||(word.charAt(len) == 'ণ' )||(word.charAt(len) == 'হ' ))
                                        {

				return;
                                         }
                                        if((word.charAt(len-3) == 'ত' )&&(word.charAt(len-2) == '্' ))
                                        {
                                            word.delete(len, len + 1);
				return;
                                         }

                                       if((word.charAt(len) == 'ু' ))
                                        {
                                            	return;
                                         }
                                     else{
                                     word.setCharAt(len, 'া');
                                      return;
                                        }
                                   }
		if (word.charAt(len) == 'ে'
                                || word.charAt(len) == 'ই'
                                || word.charAt(len) == 'ও') {
                                if(word.charAt(1) == 'ণ')
                                 return;
                                 if((word.charAt(0) == 'ন')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'য়'))
                                 {
				return;
                                  }
                                  if((word.charAt(0) == 'দ')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'ন'))
                                 {
                                        word.delete(len, len + 1);
				return;

                                  }
                                 if((word.charAt(0) == 'ক')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ূ')&&(word.charAt(len-1) == 'প'))
                                 {
                                        word.delete(len, len + 1);
				return;

                                  }
                                   if((word.charAt(1) == 'ই')&&(word.charAt(len-2) == 'ল')&&(word.charAt(len-1) == 'ে')&&(word.charAt(0) == 'হ'))
                                 {
                                        word.delete(len-1, len + 1);
				return;

                                  }
                                 if((word.charAt(1) == 'ি')&&(word.charAt(len-1) == 'ন')&&(word.charAt(len-2) == 'ছ')&&(word.charAt(0) == 'প'))
                                 {
                                        word.delete(len, len + 1);
				return;

                                  }
                                   if((word.charAt(0) == 'প')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ণ')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'ল')&&(word.charAt(6) == 'ী'))
                                      {
                                                          word.delete(len-1 , len + 1);
				   return;
                                         }
                                if((word.charAt(1) == 'ি')&&(word.charAt(0) != 'চ')&&(word.charAt(2) != 'ক')&&(word.charAt(0) != 'ন')&&(word.charAt(0) != 'স')&&(word.charAt(2) != 'প')&&(word.charAt(0) != 'হ'))
                                 {
                                      if((word.charAt(0) == 'ব')&&(word.charAt(2) == 'ষ')&&(word.charAt(3) == 'য়'))
                                        {
                                                  word.delete(len-2, len + 1);
				return;
                                        }
                                       else
                                              return;
                                  }

                                if(word.charAt(3) == 'য়')
                                 return;
                                if(word.charAt(len-1) == 'ত')
                                 return;
                                if((word.charAt(len-1) == 'থ')&&(word.charAt(0) != 'অ'))
                                 return;
				word.delete(len, len + 1);
				return;
			}
		} /* end if len > 2 */

                if(len>2 && len<=4){
                     if (word.substring(len - 1, len + 1).equals("েন")) {
                               if(word.charAt(0) == 'ই' || word.charAt(0) == 'অ' || word.charAt(0) == 'আ' )
                                              return;
                                 else {
				word.delete(len - 1, len + 1);
				return;
                              }
			}
                  }

               if (len > 4) {
                       if (word.substring(len - 1, len + 1).equals("ভর") ||
                             word.substring(len - 1, len + 1).equals("বর")) {

				return;
			}
                        if (word.substring(len, len + 1).equals("য়"))
				 {
                                    if((word.charAt(0) == 'ক')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ম')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'ন'))
                                          {

                                                    return;
                                          }
                                       if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ম')&&(word.charAt(2) == 'ন')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'ব'))
                                          {

                                                    return;
                                          }
                                 if(word.charAt(0) == 'ন')
                                   {
                                      if(word.charAt(len-1) == 'ে')
                                          {
                                           word.delete(len - 1, len);
				           return;
                                          }
                                              return;
                                   }
                                 if((word.charAt(0) == 'ক')&&(word.charAt(0) == '্')&&(word.charAt(0) == 'র'))
                                              return;
                              if((word.charAt(1) == 'ঞ')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'চ'))
                                              return;
                                    if((word.charAt(len-2) == 'ট')&&(word.charAt(len-1) == 'া'))
                                              return;
                                 if(word.charAt(3) == 'য়')
                                           {
                                                 if((word.charAt(0) == 'ক')&&(word.charAt(1)== 'থ'))
                                                      {
                                                              word.delete(len, len + 1);
                                                             return;
                                                       }
                                                    return;
                                             }
                                if((word.charAt(4) == 'ব')&&(word.charAt(0)!= 'ব'))
                                              return;
                                if(word.charAt(0) == 'অ')
                                              return;
                                if((word.charAt(len-1) == 'া')&&(word.charAt(len-2) == 'হ'))
                                              return;
                                if (word.substring(len - 1, len + 1).equals("ময়")) {
				return;
			       }
                                 if (word.substring(len - 3, len + 1).equals("ক্রয়")) {
				return;
			       }
                                   if(word.charAt(3) == 'য')
                                       {

				return;
                                       }
                             else {
				word.delete(len, len + 1);
				return;
                               }
			}
                               if (word.charAt(len) == 'র'){
                                            if((word.charAt(0) == 'ক')&& (word.charAt(1) == 'ড়')&& (word.charAt(2) == 'ি'))
                                             {
                                                   word.delete(len, len + 1);
                                                   return;
                                             }
                                            if((word.charAt(1) == 'ম')&& (word.charAt(len-2) == '্'))
                                              return;
                                           if((word.charAt(0) == 'ক')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'র')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'য')&&(word.charAt(5) == 'ব')&&(word.charAt(6) == 'ল'))
				{
                                                                     word.delete(len - 3, len + 1);
				     return;
                                                                }
                                           if((word.charAt(len-3) == 'র')&& (word.charAt(len-2) == '্')&&(word.charAt(len-1) == 'ভ'))
                                              return;
                                            if((word.charAt(0) == 'প' )&&(word.charAt(3) == 'স' )&&(word.charAt(4) == '্' )&&(word.charAt(5) == 'ত' ))
                                        {

				return;
                                         }
                                     if((word.charAt(0) == 'প')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(len-3) == 'া')&&(word.charAt(len-2) == 'চ')&&(word.charAt(len-1) == 'ী'))
                                      {

                                     return;
                                    }
                                  if((word.charAt(len-1) == 'া')&&(word.charAt(len-2) == 'ক'))
                                              return;
                                if(word.charAt(len-1) == '্')
                                              return;
                                     if((word.charAt(len) == 'য়' ))
                                        {
                                             if((word.charAt(0) == 'ক')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ম')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'ন'))
                                          {
                                                    word.delete(len, len + 1);
                                                    return;
                                          }
                                          else
                                                            return;
                                         }
                               if((word.charAt(1) == 'া')&&(word.charAt(0) == 'হ'))
                                              return;
                                if(word.charAt(1) == 'ভ')
                                              return;
                                if(word.charAt(len-2) == 'য')
                                              return;
                                if((word.charAt(len-4) == 'হ')&& (word.charAt(1) != '্'))
                                              return;
                                if(word.charAt(1) == 'ব')
                                              return;
                                 if(word.charAt(len-2) == 'ব')
                                              return;

                                if(word.charAt(0) == 'প')
                                   {
                                     if(word.charAt(1) == '্')
                                       {
                                         word.delete(len, len+1);
                                         return;
                                       }
                                     return;
                                    }
                                if(word.charAt(0) == 'শ')
                                              return;
                                if(word.charAt(0) == 'উ')
                                              return;
                                if(word.charAt(0) == 'ব')
                                   {
                                     if(word.charAt(4) == 'ণ')
                                       {
                                         word.delete(len, len+1);
                                         return;
                                       }
                                    return;
                                   }
                                if(word.charAt(0) == 'য')
                                              return;
                                if(word.charAt(1) == 'ে')
                                              return;
                                 else {
                                word.delete(len, len + 1);
				return;
                              }
			}
                   }
		return;
	}


	private void normalize(StringBuilder word) {
		int len = word.length() - 1;
                String stt=new String(word);
         //System.out.println(stt);
           /* try
            {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet1=statement.executeQuery("select w.word_id,w.word from `wn_word` w where w.word='" + stt+ "'  ");
             System.out.println("helllllo"+resultSet1.getString(1));
             
             if(resultSet1.getString(1)!=null )
             {
                 System.out.println("helllllo"+resultSet1.getString(1));
               return;

             }


            }
            catch(Exception e)
            {}*/
                if (len > 6) {
			if (word.substring(len - 1, len + 1).equals("নি")) {
				word.delete(len - 1, len + 1);
				len-=2;
                                return;
			}
		} /* end if len > 5 */
		if (len > 4) {
                         if (word.substring(len - 3, len + 1).equals("ভাবে"))
					 {
				word.delete(len - 3, len + 1);
				return;
			}
			if (word.substring(len - 2, len + 1).equals("িনি")) {
				word.delete(len - 2, len + 1);
				return;
			}

			if (word.substring(len - 1, len + 1).equals("মি")) {
				word.delete(len - 1, len + 1);
				len-=2;
                                return;
			}
                        if (word.substring(len - 1, len + 1).equals("ীয়"))
					 {
                                if(word.charAt(len-2) == 'ত')
                                              return;
                                 else {
				word.delete(len - 1, len + 1);
				return;
                             }
			}

                        if (word.substring(len - 1, len + 1).equals("ীও"))
					 {

				word.delete(len - 1, len + 1);
				return;

			}
                       if (word.substring(len - 3, len + 1).equals("ীয়তা"))
					 {

				word.delete(len - 3, len + 1);
				return;

			}
                        if (word.substring(len - 4, len + 1).equals("কেতিক"))
					 {
				word.deleteCharAt(1);
				return;
			}

                       if (word.substring(len, len + 1).equals("য়"))
				 {
                                 if((word.charAt(0) == 'ক')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ম')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'ন'))
                                          {

                                                    return;
                                          }
                                    if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ম')&&(word.charAt(2) == 'ন')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'ব'))
                                          {

                                                    return;
                                          }
                                 if(word.charAt(0) == 'ন')
                                   {
                                      if(word.charAt(len-1) == 'ে')
                                          {
                                           word.delete(len - 1, len);
				           return;
                                          }
                                              return;
                                   }
                                if((word.charAt(0) == 'ক')&&(word.charAt(0) == '্')&&(word.charAt(0) == 'র'))
                                              return;
                              if((word.charAt(1) == 'ঞ')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'চ'))
                                              return;
                                if((word.charAt(len-2) == 'ট')&&(word.charAt(len-1) == 'া'))
                                              return;

                                 if(word.charAt(3) == 'য়')
                                              {
                                                 if((word.charAt(0) == 'ক')&&(word.charAt(1)== 'থ'))
                                                      {
                                                              word.delete(len, len + 1);
                                                             return;
                                                       }
                                                return;
                                               }
                                if((word.charAt(4) == 'ব')&&(word.charAt(0)!= 'ব'))
                                              return;
                                if(word.charAt(0) == 'অ')
                                              return;
                                if((word.charAt(len-1) == 'া')&&(word.charAt(len-2) == 'হ'))
                                              return;
                                if (word.substring(len - 1, len + 1).equals("ময়")) {
				return;
			       }
                                 if (word.substring(len - 3, len + 1).equals("ক্রয়")) {
				return;
			       }
                                 if(word.charAt(3) == 'য')
                                       {

				return;
                                       }
                             else {
				word.delete(len, len + 1);
				return;
                               }
			}


                     //   if (word.substring(len - 1, len + 1).equals("য়ি")) {
			//	word.delete(len - 1, len + 1);
			//	len-=2;
                        //        return;
			//}
		} /* end if len > 4 */
                     if(len > 3 ){
		          if (word.substring(len - 2, len + 1).equals("িয়া")) {
				 word.setCharAt(len - 2, 'া');
                                 word.delete(len - 1, len + 1);
				return;
			}
                          if (word.substring(len - 2, len + 1).equals("িতে")) {

                                 if((word.charAt(0) == 'ত')&&(word.charAt(1) == 'থ')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'য')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'দ'))
                                      {

                                         word.delete(len-4 , len + 1);
                                          return;
                                         }
                                 if((word.charAt(0) == 'র')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'শ')&&(word.charAt(3) == 'ি'))
                                      {

                                         word.delete(len-1 , len + 1);
                                          return;
                                         }
                                      if((word.charAt(0) == 'স')&&(word.charAt(1) == 'ম')&&(word.charAt(2) == '্')&&(word.charAt(3) == 'প')&&(word.charAt(4) == 'ত')&&(word.charAt(5) == '্')&&(word.charAt(6) == 'ত')&&(word.charAt(7) == 'ি'))
                                      {
                                          word.delete(len-1 , len + 1);
                                          return;
                                         }
                                      if(word.charAt(len-3) == 'খ')
                                      {

                                        word.setCharAt(len - 2, 'া');
                                        word.delete(len-1 , len + 1);
                                          return;
                                         }
                                 if(word.charAt(len-3) == 'ঠ')
                                      {
                                          word.delete(len-1 , len + 1);
                                          return;
                                         }

                               if((word.charAt(0) == 'ব')&&(word.charAt(1) == 'ন')&&(word.charAt(2) == '্'))
                                      {
                                          word.setCharAt(len - 1, 'ন');
                                          word.delete(len , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }
                                        if((word.charAt(0) == 'ব'))
                                      {

                                          word.delete(len -1 , len + 1);
                                       // word.setCharAt(len - 1, 'া');
                                          return;
                                         }

                                     if(word.charAt(1) == 'ত')
                                      {
                                       // word.delete(len - 1, len + 1);
				        return;
                                         }
                                if(word.charAt(0) == 'প')
                                      {

                                       // word.setCharAt(len - 2, 'া');
                                        word.delete(len-1 , len + 1);
                                          return;
                                         }
                                if(word.charAt(0) == 'ল')
                                      {
                                              return;
                                      }
                                 if(word.charAt(1) == 'থ')
                                      {
                                              word.delete(len , len + 1);
                                              return;
                                      }
                                if((word.charAt(len-3) == 'ত')&&(word.charAt(len-4) == '্')&&(word.charAt(len-5) == 'ত'))
                                      {
                                                  word.delete(len-1 , len + 1);
                                                   return;
                                      }
                                     word.setCharAt(len - 2, 'া');
		     word.delete(len - 1, len + 1);
		     return;
			     }
                       if (word.charAt(len) == 'র'){
                                 if((word.charAt(1) == 'ম')&& (word.charAt(len-2) == '্'))
                                              return;
                                    if((word.charAt(0) == 'ক')&& (word.charAt(1) == 'ড়')&& (word.charAt(2) == 'ি'))
                                             {
                                                   word.delete(len, len + 1);
                                                   return;
                                             }
                                  if((word.charAt(0) == 'ক')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'র')&&(word.charAt(3) == '্')&&(word.charAt(4) == 'য')&&(word.charAt(5) == 'ব')&&(word.charAt(6) == 'ল'))
				{
                                                                     word.delete(len - 3, len + 1);
				     return;
                                                                }
                         if((word.charAt(0) == 'প')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(len-3) == 'া')&&(word.charAt(len-2) == 'চ')&&(word.charAt(len-1) == 'ী'))
                                      {

                                     return;
                                    }
                                  if((word.charAt(len-3) == 'র')&& (word.charAt(len-2) == '্')&&(word.charAt(len-1) == 'ভ'))
                                              return;
                                   if((word.charAt(0) == 'প' )&&(word.charAt(3) == 'স' )&&(word.charAt(4) == '্' )&&(word.charAt(5) == 'ত' ))
                                        {

				return;
                                         }
                                     if((word.charAt(len-1) == 'া')&&(word.charAt(len-2) == 'ক'))
                                              return;
                                      if((word.charAt(len-1) == 'প'))
                                              return;
                                         if((word.charAt(len) == 'য়' ))
                                        {

				return;
                                         }
                                if(word.charAt(1) == 'ব')
                                              return;
                                if(word.charAt(len-2) == 'য')
                                              return;
                                if(word.charAt(len-1) == '্')
                                              return;

                                if((word.charAt(len-4) == 'হ')&& (word.charAt(1) != '্'))
                                              return;
                                if(word.charAt(1) == 'ভ')
                                              return;
                               if(word.charAt(len-2) == 'ব')
                                              return;
                                if((word.charAt(0) == 'স')&& (word.charAt(1) != 'ী'))
                                              return;
                                if(word.charAt(0) == 'প')
                                   {
                                     if(word.charAt(1) == '্')
                                       {
                                         word.delete(len, len+1);
                                         return;
                                       }
                                     return;
                                    }
                                if(word.charAt(0) == 'ব')
                                   {
                                     if(word.charAt(4) == 'ণ')
                                       {
                                         word.delete(len, len+1);
                                         return;
                                       }
                                    return;
                                   }
                                if(word.charAt(0) == 'য')
                                              return;
                                if(word.charAt(0) == 'শ')
                                              return;
                                if(word.charAt(1) == 'ে')
                                              return;
                                if(word.charAt(0) == 'উ')
                                              return;
                                 else {
                                word.delete(len, len + 1);
				return;
                              }
			}

                   }
		if (len > 2) {

                        if (word.substring(len - 2, len + 1).equals("ইতে")) {
		 if(word.charAt(0) == 'ব')
                                   {
                                          word.delete(len - 1, len + 1);
                                          return;
                                       }
                                 else{
                                word.setCharAt(len - 2, 'য়');
                                word.delete(len - 1, len + 1);

				return;
                                      }
			}
                        if (word.substring(len - 2, len + 1).equals("ইয়া")) {
                                     if((word.charAt(len-3) == 'া')&&(word.charAt(len-4) == 'ট'))
                                 {
                                     word.setCharAt(len - 2, 'য়');
                                     word.delete(len - 1, len + 1);
                                      return;
                                   }
                                 if((word.charAt(0) == 'হ')&&(word.charAt(1) == 'া')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'া'))
                                 {
                                     word.setCharAt(3, 'ি');
                                      word.setCharAt(4, 'য়');
                                      word.setCharAt(5, 'ে');
                                     //word.delete(len, len + 1);
                                      return;
                                   }
                                if(word.charAt(0) == 'ল')
                                 {
                                   word.delete(len - 2, len + 1);
                                   return;
                                 }
				word.setCharAt(len - 2, 'য়');
                                word.delete(len - 1, len + 1);

				return;
			}
                            if (word.substring(len - 1, len + 1).equals("ীণ")) {
				if(word.substring(len - 2, len + 1).equals("চীণ"))
                                                                     return;
                                                               else{
                                                                 word.delete(len - 1, len + 1);
			     	return;
                                                                }
			}
                         if (word.substring(len - 3, len + 1).equals("িয়াই")) {
				word.setCharAt(len - 3, 'া');
                                word.delete(len - 2, len + 1);

				return;
			}
                        if (word.substring(len - 1, len + 1).equals("ইত")) {
				word.setCharAt(len - 1, 'য়');
                                word.delete(len , len + 1);

				return;
			}
                        if (word.substring(len - 1, len + 1).equals("য়া")) {
		if(word.charAt(len-2)=='ও')
                                    return;
                                if (word.substring(len - 3, len + 1).equals("তীয়া"))
                                      {
                                         return;
                                       }
                                else
                                 {
                                 word.setCharAt(len , 'ে');
                                //word.delete(len , len + 1);

				return;
                              }
			}
			if (word.substring(len, len + 1).equals("ো"))
				 {
                                                                    if((word.charAt(0) == 'দ')&&(word.charAt(2) == 'খ'))
                                                                       {
                                                                        word.delete(len-1, len + 1); return;

				       }
                                                                     if((word.charAt(0) == 'ক')&&(word.charAt(len-3) == 'ঠ')&&(word.charAt(len-1) == 'ম'))
                                                                       {
                                                                         return;

				       }
                                                                else{
                                                                    word.delete(len, len + 1);
				      return;
                                                                      }
			                }
                        if (word.substring(len, len + 1).equals("ে"))
				 {
                               if(word.charAt(1) == 'ণ')
                                 return;
                               if((word.charAt(0) == 'ভ')&&(word.charAt(1) == 'ে'))
                                      {
                                        return;
                                      }
                               if((word.charAt(0) == 'ন')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'য়'))
				return;

                                 if((word.charAt(0) == 'ক')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ূ')&&(word.charAt(len-1) == 'প'))
                                 {
                                        word.delete(len, len + 1);
				return;

                                  }
                               if((word.charAt(0) == 'দ')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'ন'))
                                 {
                                        word.delete(len, len + 1);
				return;

                                  }
                                 if(word.charAt(len-1) == 'থ')
                                 return;
                                 if((word.charAt(1) == 'ই')&&(word.charAt(len-2) == 'ল')&&(word.charAt(len-1) == 'ে')&&(word.charAt(0) == 'হ'))
                                 {
                                        word.delete(len-1, len + 1);
				return;

                                  }
                                  if((word.charAt(0) == 'প')&&(word.charAt(1) == '্')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ণ')&&(word.charAt(4) == 'া')&&(word.charAt(5) == 'ল')&&(word.charAt(6) == 'ী'))
                                      {
                                                          word.delete(len-1 , len + 1);
				   return;
                                         }
                               if((word.charAt(1) == 'ি')&&(word.charAt(0) != 'স'))
                                 return;
                                if((word.charAt(1) == 'ি')&&(word.charAt(len-1) == 'ন')&&(word.charAt(len-2) == 'ছ')&&(word.charAt(0) == 'প'))
                                 {
                                        word.delete(len, len + 1);
				return;

                                  }
				word.delete(len, len + 1);
				return;
			}
		} /* end if len > 2 */
                if (len == 2) {
                        if (word.substring(len - 1, len + 1).equals("ইত")) {
                                if(word.charAt(0) == 'ব')
                                  {
                                    word.delete(len , len + 1);
                                    return;
                                  }
				word.setCharAt(len - 1, 'য়');
                                word.delete(len , len + 1);

				return;
			}
			if (word.substring(len, len + 1).equals("ে") ||
                              word.substring(len, len + 1).equals("ি")) {
                                    if((word.charAt(0) == 'ব' )&&(word.charAt(1) == '্' )&&(word.charAt(2) == 'য' )&&(word.charAt(3) == 'ক' )&&(word.charAt(4) == '্' )&&(word.charAt(5) == 'ত' ))
                                        {
                                            	return;
                                         }
                                    if((word.charAt(0) == 'ভ')&&(word.charAt(1) == 'ে'))
                                      {
                                        return;
                                      }
                                     if((word.charAt(0) == 'ন')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'য়'))
                                 {
				return;
                                  }
                                      if((word.charAt(0) == 'জ' )&&(word.charAt(1) == 'ু' )&&(word.charAt(2) == 'য়' )&&(word.charAt(3) == 'া' )&&(word.charAt(4) == 'চ' )&&(word.charAt(5) == 'ু' )&&(word.charAt(len) == 'ি' ))
                                        {
                                            	return;
                                         }
                                       if((word.charAt(0) == 'ক')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'র')&&(word.charAt(3) == 'ূ')&&(word.charAt(len-1) == 'প'))
                                 {
                                        word.delete(len, len + 1);
				return;

                                  }
                                  if((word.charAt(0) == 'দ')&&(word.charAt(1) == 'ি')&&(word.charAt(2) == 'ন'))
                                 {
                                        word.delete(len, len + 1);
				return;

                                  }
                                     if(word.charAt(len-1) == 'দ'){
                                       word.delete(len, len + 1);
                                        return;
                                       }
                                     if(word.charAt(len-1) == 'ঠ'){

                                        return;
                                       }
                                   if((word.charAt(len-1) == 'ত')&&(word.charAt(len-2) == 'ধ')){

                                        return;
                                       }
                                 if(word.charAt(len-1) == 'থ'){
                                     //  word.delete(len, len + 1);
                                        return;
                                       }
                                 if(word.charAt(1) == 'ট')
                                   return;
                                 if(word.charAt(0) == 'ব')
                                   return;
                                else if(word.charAt(len-1) == 'ত' && word.charAt(len) == 'ি')
                                              return;
                                 else {
                             //   word.setCharAt(len , 'া');
                                  word.delete(len, len + 1);

			    	return;
                               }
			}
		} /* end if len = 2 */
		return;
	}
 private String remove_change(String words)
        {
         
                    if ((words.endsWith("সার"))&&(!words.startsWith("শি"))||(words.endsWith("মস্যার"))||(words.endsWith("খ্যার"))||(words.endsWith("খ্যার"))||(words.endsWith("ণীর"))||(words.endsWith("ড়ির"))||(words.endsWith("সেবার"))||(words.endsWith("ণ্ডীর"))||(words.endsWith("ভ্যতার"))||(words.endsWith("গুহার"))||(words.endsWith("তির"))||(words.endsWith("ন্তুর"))||(words.endsWith("ক্ষার"))||(words.endsWith("দ্ধির"))||(words.endsWith("স্হার"))||(words.endsWith("দির"))||(words.endsWith("নার"))||(words.endsWith("দেনর"))||(words.endsWith("টার"))||(words.endsWith("রার"))||(words.endsWith("টাকার"))||(words.endsWith("ষার"))||(words.endsWith("বীর"))||(words.endsWith("ঠির"))||(words.endsWith("টির"))||(words.endsWith("ব্দীর")))
                 {

                  words=words.substring(0, words.length() - "র".length());

                  return words;
                 }
                  if ((words.endsWith("কেতিক")))
                 {

                  words=words.substring(0, words.length() - "িক".length());

                  return words;
                 }
                      if ((words.endsWith("স্কৃতিক")))
                 {

                    words=words.substring(0, words.length() - "ক".length());
                    StringBuffer strbuf;
                    strbuf = new StringBuffer(words);
                    strbuf.deleteCharAt(1);
                    return strbuf.toString();
                 }
                  if ((words.endsWith("লেই")))
                 {

                    StringBuffer strbuf;
                    int len = words.length();
                    strbuf = new StringBuffer(words);
                    strbuf.delete(len-2, len);
                    return strbuf.toString();
                 }
                 if ((words.endsWith("ষাটি")))
                 {

                  words=words.substring(0, words.length() - "টি".length());

                  return words;
                 }
                 if ((words.endsWith("ীন")))
                 {
                     if ((words.endsWith("াচীন")))
                            return words;
                       if ((words.endsWith("হীন")))
                            return words;
                   else{
                     words=words.substring(0, words.length() - "ীন".length());
                       return words;
                      }
                 }
                  if ((words.endsWith("ইল")))
                 {

                     if ((words.endsWith("হইল")))
                            return words;
                       else
                          {
                            words=words.substring(0, words.length() - "ল".length());
                            return words;
                          }
                 }
                   if ((words.endsWith("বলী")))
                 {
                      if ((words.startsWith("তথ্যা"))||(words.startsWith("প্রশ্না")))
                            words=words.substring(0, words.length() - "াবলী".length());

                      else
                            words=words.substring(0, words.length() - "বলী".length());

                  return words;
                 }

          return words;
        }
}






        