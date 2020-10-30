/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svm_debdeep;

import java.io.*;
import java.util.*;
import java.sql.*;
import filerandomaccess.FileRandomAccess;   //Externaly Imported Jar for Input log file creation
/**
 *
 * @author debdeep
 */

class Classifier implements java.io.Serializable	//Defining the Bean of Each classifier having 4 parts
{
   private ArrayList <String> pos=new ArrayList <String> ();
   private ArrayList <String> co_location=new ArrayList <String> ();
   private ArrayList <Integer> co_occurence=new ArrayList <Integer> ();
   private ArrayList <String> syntactic_relation=new ArrayList <String> ();
   private ArrayList <String> synset_id=new ArrayList <String> ();

   public ArrayList getPos()
   {
      return pos;
   }
   public ArrayList getCo_Location()
   {
      return co_location;
   }
   public ArrayList getCo_Occurence()
   {
      return co_occurence;
   }
   public ArrayList getSyntactic_Relation()
   {
      return syntactic_relation;
   }
   
   public ArrayList getSynset_ID()
   {
       return synset_id;
   }


   public void setPos(String pos)
   {
      this.pos.add(pos);
   }
   public void setCo_Location(String co_location)
   {
      this.co_location.add(co_location);
   }
   public void setCo_Occurence(int co_occurence)
   {
      this.co_occurence.add(co_occurence);
   }
   public void setSyntactic_Relation(String syntactic_relation)
   {
      this.syntactic_relation.add(syntactic_relation);
   }
   public void setSynset_ID(String synset_id)
   {
       this.synset_id.add(synset_id);
   }
}

class Subsume
{
    Connection conn;
    Statement stmt;
    ResultSet rs1;
    ResultSet rs2;
    
    boolean out=false;
    boolean brk1=false;
    boolean brk2=false;
    
    boolean ret=false;
    
    ArrayList al1=new ArrayList();
    ArrayList al2=new ArrayList();
    
    String LCSitem;
    int prev_counter1=0;
    int prev_counter2=0;
    int next_counter1=0;
    int next_counter2=0;
    
    public boolean findSubsume(String synset_id1, String synset_id2)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
            stmt=conn.createStatement();
            al1.add(synset_id1);
            al2.add(synset_id2);

            while(true)
            {
                if(out==true)
                    break;
                else
                {	    
		    next_counter1=al1.size();
		    next_counter2=al2.size();

                    go1(next_counter1);
		    go2(next_counter2);

		    out=findMatch(al1,al2);
		
		if(out==true)
		  break;
                
                    if(out==false && brk1==true && brk2==true)
                    {	
                        out=true;
                        LCSitem=""+(-1);
                    }                       
                    
                }
            }
        }
        catch(SQLException sqle)
        {
            System.err.println(sqle);
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            try
	    {
	      conn.close();
              if(LCSitem.equals("-1")==true)
              {
                  ret=false;
              }
              else
              {
                  ret=true;
              }
	    }
	    catch(Exception e){}
        }
        return(ret);
    }
    
    public void go1(int next_counter)
    {
      if(prev_counter1==next_counter)
      {
          brk1=true;
	  return;
      }
      String synset_id_go1;
      while(prev_counter1<next_counter)
      {
        try
        {
            synset_id_go1=(String)al1.get(prev_counter1);
            rs1=stmt.executeQuery("select child_synset_id from wordnet_master.wn_master_rel_hypernymy_hyponymy where parent_synset_id='"+synset_id_go1+"';");
            prev_counter1++;    
            while(rs1.next()==true)
            {
              String temp=rs1.getString("child_synset_id");
              al1.add(temp);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
      }
    }
    
    public void go2(int next_counter)
    {
      if(prev_counter2==next_counter)
      {
          brk2=true;	  
	  return;
      }
      String synset_id_go2;
      while(prev_counter2<next_counter)
      {
        try
        {
            synset_id_go2=(String)al2.get(prev_counter2);
            rs2=stmt.executeQuery("select child_synset_id from wordnet_master.wn_master_rel_hypernymy_hyponymy where parent_synset_id='"+synset_id_go2+"';");
            prev_counter2++;
            while(rs2.next()==true)
            {
              String temp=rs2.getString("child_synset_id");
              al2.add(temp);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
      }
    }
    
    public boolean findMatch(ArrayList list1,ArrayList list2)
    {
        boolean flag=false;
        int i;
        for(i=0;i<list1.size();i++)
        {
            flag=list2.contains(list1.get(i));
            if(flag==true)
                break;
        }
        if(flag==true)
        {
            LCSitem=(String)list1.get(i);
        }
        return flag;
    }
}

class Project
{
  String word ="";              //Used for temporary storage of each token
  String a ="";                 //Used to store the Left side colocation words
  String target="";             //Used to store the Disambiguated word
  String b="";                  //Used to store the right side colocation words
  Scanner read;                 //Used to read the Disambiguated word contained Sentence
  Scanner inTarget;             //Target word reader
  String sentence="";
  int window;                   //For Window Size
  int co_o=0;                   //For Colocation
  
  BufferedReader rd;            //Used to Read UTF data from where necessory
  BufferedWriter wr;            //Used to Write UTF data Where necessory
  
  StringTokenizer st;           //Used to Tokenize String where necessory
  Classifier csf;               //Used to create new Classifiers
  
  ArrayList <String> al=new ArrayList <String> ();  //Input Sentence Array
  ArrayList <Classifier> csfal=new ArrayList <Classifier> (); // Classifier List
  
  ArrayList synsetlist=new ArrayList();
  
  Connection conn;
  Statement stmt;
  ResultSet rs;
  
  FileRandomAccess rfile=null;
  
  public void run()
  {
        BufferedReader rd=null;
        boolean go=true;

        try
        {
            rd=new BufferedReader(new InputStreamReader(new FileInputStream("Run.txt"),"UTF-8"));
            while(true)
            {
                String line=rd.readLine();
                if(line==null || go==false)
                    break;
                else
                {
                    StringTokenizer st=new StringTokenizer(line);
                    while(st.hasMoreTokens()==true)
                    {
                        String part1=st.nextToken(":");     //  Get Sentence
                        part1=part1.trim();

                        String part2=st.nextToken();        //  Get Target word
                        part2=part2.trim();

                        BufferedWriter wr=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Input_Sentence.txt"),"UTF-8"));
                        wr.write(part1);
                        wr.close();

                        wr=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Target_Word.txt"),"UTF-8"));
                        wr.write(part2);
                        wr.close();

                        Project pr=new Project();
                        pr.readTargetWord();
                        pr.training();
                        ArrayList csfal=pr.testing();
                        pr.showClassifier(csfal);
                        pr.senseGenerator(csfal);
                    }
                }
                while(true)
                {
                    System.out.println("\nDo you want to Continue testing \nEnter 1 for Yes\nEnter 0 for No");
                    BufferedReader rd1=new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
                    int choice=Integer.parseInt(rd1.readLine());
                    if(choice==1)
                    {
                        go=true;
                        break;
                    }
                    else if(choice==0)
                    {
                        go=false;
                        break;
                    }
                    else
                    {
                        System.out.println("Sorry Invalid Choice\n\tTry Again with Correct Choice\n");
                    }
                }
            }
            rd.close();
        }
        catch(Exception e)
        {
            System.err.println();
        }
    }
  
  public void readTargetWord()
  {
      BufferedReader reader=null;
      try
      {
          rfile=new FileRandomAccess("Input_Log_File.txt");
          reader = new BufferedReader(new InputStreamReader((new FileInputStream("Target_Word.txt")),"UTF-8"));
          target=reader.readLine();
          if(target==null)
          {
              reader.close();
              System.err.println("There is an Error in reading Target Word Please Check Target_Word.txt file");
              System.exit(0);
          }
      }
      catch(Exception e)
      {
          System.err.println(e);
          System.exit(1);
      }
      finally
      {
          try
          {
              rfile.append("\n"+target+" : ");
              reader.close();
          }
          catch(Exception e){}
      }
  }
  
  public String stopWordRemove(String line)
  {
      Scanner inStop=null;
      ArrayList stopal= new ArrayList();    // ArrayList For Stop Words
      String source="";                     // used to Scan single single tokens from the Source file
      
      String part1="";                      // Temporary Storage of Token Word 
      String part2="";                      // Temporary Storage of Token SynsetID
      String line2="";                      // To Store the Stop word removed line
      
      try
      {
          inStop=new Scanner(new File("Stop_Words.txt"));		// File Name of the Stop Words Data
          while(inStop.hasNext())					// Loop to get all the stop word list in the "stopal" arraylist
          {
            source=inStop.next();
            stopal.add(source);
          }
          
            StringTokenizer st=new StringTokenizer(line);
            while(st.hasMoreTokens())
            {
                int flag=1;
                String s1=st.nextToken();
                StringTokenizer st2=new StringTokenizer(s1);
                try
                {
                    part1=st2.nextToken("\\");
                }
                catch(Exception e)
                {
                    part1="";
                }
                try
                {
                    part2=st2.nextToken();
                }
                catch(Exception e)
                {
                    part2="";
                }
                for(int i=0;i<stopal.size();i++)
                {
                    if(stopal.contains(part1)==true)
                    {
                        flag=0;
                        break;
                    }
                }
                if(flag!=0)
                {
                    if(part2=="")
                    {
                        line2=(line2+" "+part1);
                    }
                    else
                    {
                        line2=(line2+" "+part1+"\\"+part2);
                    }
                }
            }  
      }
      catch(Exception e)
      {
          System.err.println(e);
      }
      finally
      {
          return line2.trim();
      }
  }
  
  public void training()
    {
        String line;
        String str;
        String part1="";
        String part2="";
        boolean got=false;
        
        try
        {
            rd=new BufferedReader(new InputStreamReader(new FileInputStream("Training_Data.txt"),"UTF-8"));
            wr=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Training_Output.txt"),"UTF-8"));
            while(true)
            {   
                got=false;
                line=rd.readLine();
                if(line==null)	
                  break;
                else
                {
                    StringTokenizer st=new StringTokenizer(line);
                    while(st.hasMoreTokens())				// Loop to organise the Training Data
                    {
                      str=st.nextToken();
                      StringTokenizer st2=new StringTokenizer(str);			
                      try
                      {
                        part1=st2.nextToken("\\");
                      }
                      catch(Exception e)
                      {
                        part1="";
                      }
                      try
                      {
                        part2=st2.nextToken();
                      }
                      catch(Exception e)
                      {
                        part2="";
                      }
                      if(part1.equals(target.trim()))
                      {
                        got=true;
                        break;
                      }					
                    }
                    if(got==true)
                    {
                      line=stopWordRemove(line);
                      wr.write(line);
                      wr.write("\n");
                      if(synsetlist.contains(part2)==false)
                      {
                            synsetlist.add(part2);
                      }
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            try
            {
                rd.close();
                wr.close();
            }
            catch(Exception e){}
        }
        
        
        
        int length=synsetlist.size();
        String sentence="";
        String no="";
        String [] datalist=new String[length];
        
        try
        {
            rd=new BufferedReader(new InputStreamReader(new FileInputStream("Training_Output.txt"),"UTF-8"));
            wr=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Targetword_Processed_Output.txt"),"UTF-8"));
            while(true)
            {          
                line=rd.readLine();
                if(line==null)	
                  break;
                else
                {
                    StringTokenizer st=new StringTokenizer(line);
                    while(st.hasMoreTokens())				// Loop to organise the Training Data
                    {
                      str=st.nextToken();
                      StringTokenizer st2=new StringTokenizer(str);			
                      try
                      {
                        part1=st2.nextToken("\\");
                      }
                      catch(Exception e)
                      {
                        part1="";
                      }
                      try
                      {
                        part2=st2.nextToken();
                      }
                      catch(Exception e)
                      {
                        part2="";
                      }
                      if(part2=="")
                      {
                          sentence=sentence+" "+part1;
                      }
                      if(part2!="")
                      {
                          no=part2;
                      }
                    }
                    if(synsetlist.contains(no)==true)
                    {
                        int pos=synsetlist.indexOf(no);
                        if(datalist[pos]==null)
                        {
                            datalist[pos]="";
                        }
                        datalist[pos]=datalist[pos]+""+sentence;
                    }
                    sentence=no+":"+sentence.trim();
                    sentence="";
                }
            }
            
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            try
            {
                System.out.println("Training Cpompleted..");
                for(int i=0;i<datalist.length;i++)
                {
                    wr.write(synsetlist.get(i)+" : "+datalist[i].trim());
                    wr.write(" | \n");
                }
                rd.close();
                wr.close();
            }
            catch(Exception e){}
        }
        System.out.println("The Unique Synsets from training are : "+synsetlist);
    }
  
  public ArrayList testing()
  {
      BufferedReader reader=null;
      BufferedReader rd=null;
      
      String test_string="";                 // To read The Testing Sentence
      String stopwordremoved_string="";      // To Store the Stop Word Removed Input Sentence
      
      String c="";
      String d="";
      
      try
      {
          reader = new BufferedReader(new InputStreamReader((new FileInputStream("Input_Sentence.txt")),"UTF-8"));
          test_string=reader.readLine();
          if(test_string==null)
          {
              reader.close();
              System.err.println("There is an Error in reading Input Sentence Please Check Input_Sentence.txt file");
              System.exit(2);
          }
          else
          {
              sentence=test_string;
              stopwordremoved_string=stopWordRemove(test_string);
              System.out.println("The Sentence Before Stop Word Removal is : "+test_string);
              System.out.println("The Sentence After Stop Word Removal is : "+stopwordremoved_string);
              try
              {
                    rfile.append(test_string);
                    StringTokenizer st=new StringTokenizer(stopwordremoved_string);
                    while(st.hasMoreTokens()==true)
                    {
                        al.add(st.nextToken());
                    }
                    System.out.println("ArrayList = "+al);
                    rd=new BufferedReader(new InputStreamReader((System.in),"UTF-8"));
                    System.out.println("Enter the Window Size : ");
                    window=Integer.parseInt(rd.readLine());
                    int pos=al.indexOf(target);
                    if(pos!=0)
                        co_o++;

                    for(int i=1;i<=window;i++)
                    {	
                        try
                        {
                          c=(String)al.get(pos-i);
                        }
                        catch(Exception e)
                        {
                            c="";
                        }
                        finally
                        {
                          a=a+" "+c;
                        }
                        try
                        {
                          d=(String)al.get(pos+i);
                        }
                        catch(Exception e)
                        {
                            d="";
                        }
                        finally
                        {
                          b=b+" "+d;
                        }
                      if(target.equals(a)==true)
                        co_o++;
                      if(target.equals(b)==true)
                        co_o++;
                    }
                    String col_string=a+" "+b; 
                    
            //Conection to get Pos , SynsetID and Set Every Classifier
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
                    stmt=conn.createStatement();
                    
                    //rs=stmt.executeQuery("select wn_word.word, wn_word.word_id, wn_synset.synset_id, wn_master_category.category_value ,wn_synset.concept_definition ,wn_synset_example.example_content from wordnet_bengali.wn_synset join wordnet_bengali.wn_synset_example join wordnet_bengali.wn_synset_words join wordnet_bengali.wn_word join wordnet_master.wn_master_category on wordnet_bengali.wn_synset.synset_id=wordnet_bengali.wn_synset_example.synset_id and wordnet_bengali.wn_synset_example.synset_id=wordnet_bengali.wn_synset_words.synset_id and wordnet_bengali.wn_synset_words.word_id=wordnet_bengali.wn_word.word_id and wordnet_bengali.wn_synset.category_id=wordnet_master.wn_master_category.category_id where wn_word.word='"+target+"'and wn_synset.synset_id='3963' AND wn_synset.category_id='1'");
                    rs=stmt.executeQuery("select wn_word.word, wn_word.word_id, wn_synset.synset_id, wn_master_category.category_value, wn_synset.concept_definition from wordnet_bengali.wn_synset join wordnet_bengali.wn_synset_words join wordnet_bengali.wn_word join wordnet_master.wn_master_category on wordnet_bengali.wn_synset.synset_id=wordnet_bengali.wn_synset_words.synset_id and wordnet_bengali.wn_word.word_id=wordnet_bengali.wn_synset_words.word_id and wordnet_bengali.wn_synset.category_id=wordnet_master.wn_master_category.category_id where wn_word.word='"+target+"';");
                    while(rs.next()==true)
                    {  
                      String pos_string=rs.getString("wn_master_category.category_value");
                      String synset_string=rs.getString("wn_synset.synset_id");
                      if(synsetlist.contains(synset_string.trim())==false)
                          continue;
                      String word_string=rs.getString("wn_word.word");
                //Adding Concept + Example Content from Wordnet Entry
                      //String sys_string=rs.getString("wn_synset.concept_definition")+" # "+rs.getString("wn_synset_example.example_content");
                      
                //Adding only Concept from Wordnet Entry
                      String sys_string=rs.getString("wn_synset.concept_definition");
                      
                      csf=new Classifier();
                      

            //Pos Tokenization
                      
                      st=new StringTokenizer(pos_string);
                      while(st.hasMoreTokens()==true)
                      {
                          csf.setPos(st.nextToken());
                      }

            //Colocation String tokenization
                      
                      st=new StringTokenizer(col_string);
                      while(st.hasMoreTokens()==true)
                      {
                          csf.setCo_Location(st.nextToken());
                      }

            //Setting Cooccurence
                      
                      csf.setCo_Occurence(co_o);

            //Syntactic Relation String tokenization
                      
                      st=new StringTokenizer(sys_string);
                      while(st.hasMoreTokens()==true)
                      {
                          csf.setSyntactic_Relation(st.nextToken());
                      }
                      
            //Adding Trained Data result for better support
                      rd=new BufferedReader(new InputStreamReader(new FileInputStream("Targetword_Processed_Output.txt"),"UTF-8"));
                      while(true)
                      {
                         String line,part1,part2;
                         line=rd.readLine();
                
                        if(line==null)	
                          break;
                        else
                        {
                            StringTokenizer st1=new StringTokenizer(line);
                            while(st1.hasMoreTokens())				// Loop to organise the Training Data
                            {			
                              try
                              {
                                part1=st1.nextToken(":");
                              }
                              catch(Exception e)
                              {
                                part1="";
                              }
                              try
                              {
                                part2=st1.nextToken("|");
                              }
                              catch(Exception e)
                              {
                                part2="";
                              }
                              if(part1.trim().equals(synset_string.trim())==true)
                              {
                                  StringTokenizer st3=new StringTokenizer(part2);
                                  while(st3.hasMoreTokens()==true)
                                  {
                                      csf.setSyntactic_Relation(st3.nextToken());
                                  }
                              }
                            }
                        }
                      }
           
            //Synset ID String tokenization
                      
                      st=new StringTokenizer(synset_string);
                      while(st.hasMoreTokens()==true)
                      {
                          csf.setSynset_ID(st.nextToken());
                      }
                      
                      csfal.add(csf);
                    }
                    conn.close();
                    //***************************************************************
              }
              catch(Exception e)
              {
                  System.err.println(e);
              }
          }
      }
      catch(Exception e)
      {
          System.err.println(e);
          System.exit(3);
      }
      finally
      {
          try
          {
              read.close();
              inTarget.close();
              reader.close();
              rd.close();
              rfile.close();
          }
          catch(FileNotFoundException foe){}
          catch(Exception e){}
          
      }
      return csfal;
  }

  public void showClassifier(ArrayList al)
  {
      System.out.println("\nThere are "+al.size()+" Classifiers Generated\n");
      for(int z=0;z<al.size();z++)
      {
        Classifier csf=(Classifier) al.get(z);
        
        System.out.println("\n\nThe "+(z+1)+" Classifier is : \n");

        System.out.println("The Synset id : ");
        System.out.println("No of Synset_id Entry : "+csf.getSynset_ID().size());
        for(int i=0;i<csf.getSynset_ID().size();i++)
          System.out.print(csf.getSynset_ID().get(i)+"\t");
        System.out.println("\n");
        
        System.out.println("The Pos : ");
        System.out.println("No of Pos Entry: "+csf.getPos().size());
        for(int i=0;i<csf.getPos().size();i++)		
          System.out.print(csf.getPos().get(i)+"\t");
        System.out.println("\n");


        System.out.println("The Co_l : ");
        System.out.println("No Co Location Entry : "+csf.getCo_Location().size());
        for(int i=0;i<csf.getCo_Location().size();i++)
          System.out.print(csf.getCo_Location().get(i)+"\t");
        System.out.println("\n");


        System.out.println("The Co_o : ");
        System.out.println("No of Co Occurence Entry : "+csf.getCo_Occurence().size());
        for(int i=0;i<csf.getCo_Occurence().size();i++)
          System.out.print(csf.getCo_Occurence().get(i)+"\t");
        System.out.println("\n");


        System.out.println("The Syn : ");
        System.out.println("No of Syntactic Relation Entry : "+csf.getSyntactic_Relation().size());
        for(int i=0;i<csf.getSyntactic_Relation().size();i++)
          System.out.print(csf.getSyntactic_Relation().get(i)+"\t");
        System.out.println("\n");
        
        
      }
  }
  
  public ArrayList senseGenerator(ArrayList csfal) throws Exception
  {
      boolean bol;      //Used to check for equality
      double per;
      int mil=0;        //Used to calculate the no of match;
      
      ArrayList <Integer> feature_vector=new ArrayList <Integer>();
      for(int z=0;z<csfal.size();z++)
      {
          Classifier csf=(Classifier) csfal.get(z);
          mil=0;
          for(int i=0;i<csf.getCo_Location().size();i++)
          {
              for(int j=0;j<csf.getSyntactic_Relation().size();j++)
              {
                  if(match(csf.getCo_Location().get(i)+"",csf.getSyntactic_Relation().get(j)+"")==true)
                    mil++;
              }              
          }
          feature_vector.add(mil);
      }
      System.out.println("\n***************************************************");
      System.out.println("The Values of match in each classifier is : ");
      System.out.println(feature_vector);

      int big=feature_vector.get(0);
      int big_count=0;
      for(int i=0;i<feature_vector.size();i++)
      {
          if(big<=feature_vector.get(i))
          {
              if(big==feature_vector.get(i))
                  big_count++;
              else
              {
                  big=feature_vector.get(i);
                  big_count=1;
              }
          }
      }
      System.out.println("\nThe Maximum feature value is : "+big);
      System.out.println("\nThe Maximum feature value frequency Count is : "+big_count);
      
      if(big_count==1)
      {
        int index=feature_vector.indexOf(big);

        csf=(Classifier) csfal.get(index);

        System.out.println("\nSentence is "+sentence);
        System.out.println("\nAmbiguous Word in the Sentence is : "+target);
        System.out.print("\nConcept of the word "+target+ " is : ");
        for(int j=0;j<csf.getSyntactic_Relation().size();j++)
        {
          if(csf.getSyntactic_Relation().get(j).equals("#"))
          {
            System.out.print("\nExample : ");
            j++;
          }
          if(csf.getSyntactic_Relation().get(j).equals(":"))
          {
            break;
          }
          System.out.print(csf.getSyntactic_Relation().get(j)+" ");
        }
        System.out.println();
      }
      else
      {
          System.out.println("Confusion Occur Sense Can not be Disambiguated");
      }
      System.out.println("\n***************************************************");
      return feature_vector;
  }
  
  public boolean match(String one , String two)
  {
      Subsume sm=new Subsume();
      //System.out.println("Word 2 Word Match Starts");
      boolean ret=false;
      double dbl=0;
      double thresold=80.0;     //  Thresold Value to accept structural match
      try
      {
            if(one.equals(two)==true)
            {
                 ret=true;
            }
            else
            {
                ArrayList al1=getSynonyms(one);
                ArrayList al2=getSynonyms(two);
                //System.out.println("No match Found so far \nSynonyms Match Starts");
                ret=listMatch(al1,al2);
                if(ret==false)
                {
                    ret=sm.findSubsume(one, two);
                    if(ret==false)
                    {
                        //System.out.println("No match Found so far \nStructural Match Starts");
                        dbl=structuralMatch(one,two);
                        if(dbl>=thresold)
                            ret=true;
                    }
                }
            }
      }
      catch(Exception e)
      {
          System.err.println(e);
      }
      return ret;
  }
  
  public boolean listMatch(ArrayList al1 , ArrayList al2)
  {
      boolean ret=false;
      if(al1.size()==0 || al2.size()==0)
          ret=false;
      else
      {
          for(int i=0;i<al2.size();i++)
          {
              if(al1.contains(al2.get(i))==true)
              {
                  ret=true;
              }
          }
      }
      return ret;
  }
  
  public double structuralMatch(String one,String two)
  {    
    int one_len=one.length();
    int two_len=two.length();
    int len;
    int count=0;
    double per1;
    double per2;
    int cal;

    if(one_len>two_len)
    {
      cal=one_len;
      len=two_len;
    }
    else
    {
      cal=two_len;
      len=one_len;
    }

    char[] onearray=one.toCharArray();
    char[] twoarray=two.toCharArray();

    for(int i=0;i<len;i++)
    {
      if(onearray[i]==twoarray[i])
        count++;
    }
    per1=(count*100/cal);
    per2=(count*100/len);

    if(per1<=50 && per2==100)
      return per1;
    else
      return ((per1+per2)/2);
  }
  
  public ArrayList getSynonyms(String word)
  {
      Connection conn=null;
      Statement stmt;
      ResultSet rs;
      word=word.trim();
      ArrayList <String> synlist=new ArrayList <String> ();
      try
      {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
            stmt=conn.createStatement();
            rs=stmt.executeQuery("select word from wordnet_bengali.wn_word where word_id IN(select distinct word_id from wordnet_bengali.wn_synset_words where synset_id IN(select synset_id from wordnet_bengali.wn_synset_words where word_id IN (select word_id from wordnet_bengali.wn_word where wn_word.word='"+word+"')));");
            while(rs.next()==true)
            {
                String temp=rs.getString(1);
                synlist.add(temp);
            }
      }
      catch(Exception e)
      {
          System.err.println(e);
      }
      finally
      {
          try
          {
              conn.close();
          }
          catch(Exception e){}
      }
      return synlist;
  }
  
}
public class SVM_Debdeep 
{
    public static void main(String[] args) 
    {
        try
        {
            Project pr=new Project();
            pr.run();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }   
}
