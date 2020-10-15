/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semanticsimilaritypathbased;

import java.io.*;
import java.util.*;
import java.sql.*;

import filerandomaccess.FileRandomAccess;

/**
 *
 * @author debdeep
 */

class RootFinder 
{
    Connection conn;
    Statement stmt;
    ResultSet rs1;
    
    boolean out=false;
    boolean brk1=false;
    
    int prev_counter1=0;
    int next_counter1=0;
    
    ArrayList <String> al1=new ArrayList <String> ();
        
    public String findRoot(String synset_id1) throws Exception
    {
        //String temp="\nSearch Begins with "+synset_id1;
	//System.out.println(temp);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
            stmt=conn.createStatement();
            al1.add(synset_id1);

            while(true)
            {
                if(out==true)
                    break;
                else
                {	    
		    next_counter1=al1.size();
                    go1(next_counter1);
                    
                    if(brk1==true)
                    {	
                        out=true;
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
              if(out==true)
              {
                  //System.out.println("Before : "+al1);
                  al1=removeDuplicate(al1);
                  
                  //showOutput(al1);
                  //showTree(al1);
              }
	    }
	    catch(Exception e){}
        }
        return(al1.get(al1.size()-1));
    }
    
    public void go1(int next_counter)throws Exception
    {
      if(prev_counter1==next_counter)
      {
          brk1=true;
	  return;
      }
      String synset_id_go1;
      while(prev_counter1<next_counter)
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
    }
    
    public ArrayList <String> removeDuplicate(ArrayList <String> al)
    {
        ArrayList <String> temp=new ArrayList <String> ();
        for(int i=0;i<al.size();i++)
        {
            if(temp.contains(al.get(i))==false)
                temp.add(al.get(i));
        }
        return temp;
    }
    
    public void showOutput(ArrayList <String> synset_list)
    {        
        try
        {
                String word=synset_list.get(synset_list.size()-1);
                        
            // Wordnet Connection
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
                stmt=conn.createStatement();
                rs1=stmt.executeQuery("select word from wordnet_bengali.wn_word where word_id IN (select word_id from wordnet_bengali.wn_synset_words where synset_id='" +word +"');");
                while(rs1.next()==true)
                {
                    word=word+" "+rs1.getString(1);
                }
                System.out.println("\nThe List is : "+synset_list);
                System.out.println("\nThe Root is = "+word);
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    
    public String getConcept(String synset)
    {
        String word="";
        try
        {
        // Wordnet Connection
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
            stmt=conn.createStatement();
            rs1=stmt.executeQuery("select concept_definition from wordnet_bengali.wn_synset where synset_id ='" +synset +"';");
            while(rs1.next()==true)
            {
                word=word+" "+rs1.getString(1);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return word;
    }
    
    public void showConcept(String synset)
    {
        String word="";
        try
        {
        // Wordnet Connection
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
            stmt=conn.createStatement();
            rs1=stmt.executeQuery("select concept_definition from wordnet_bengali.wn_synset where synset_id ='" +synset +"';");
            while(rs1.next()==true)
            {
                word=word+" "+rs1.getString(1);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        System.out.println("");
    }
    
    public void showWord(String synset) throws Exception
    {
        String word="";
    // Wordnet Connection
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
        stmt=conn.createStatement();
        rs1=stmt.executeQuery("select word from wordnet_bengali.wn_word where word_id IN (select word_id from wordnet_bengali.wn_synset_words where synset_id='" +synset +"');");
        while(rs1.next()==true)
        {
            word=word+" "+rs1.getString(1);
        }
        System.out.println("\nSynset = "+synset+" Word is = "+word);
    }
    
    public String getWord(String synset) throws Exception
    {
        String word="";
    // Wordnet Connection
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
        stmt=conn.createStatement();
        rs1=stmt.executeQuery("select word from wordnet_bengali.wn_word where word_id IN (select word_id from wordnet_bengali.wn_synset_words where synset_id='" +synset +"');");
        while(rs1.next()==true)
        {
            word=word+" "+rs1.getString(1);
        }
        return word;
    }
    
    public void showTree(ArrayList <String> synset_list) throws Exception
    {
        System.out.println(getWord(synset_list.get(synset_list.size()-1)));
        for(int i=synset_list.size()-2;i>=0;i--)
        {
            System.out.println("|");
            String temp=getWord(synset_list.get(i));
            System.out.println(temp+" = "+synset_list.get(i));
        }
    }
}


class LCS_Finder 
{
    Connection conn;
    Statement stmt;
    ResultSet rs1;
    ResultSet rs2;
    
    boolean out=false;
    boolean brk1=false;
    boolean brk2=false;
    
    ArrayList al1=new ArrayList();
    ArrayList al2=new ArrayList();
    
    String LCSitem;
    int prev_counter1=0;
    int prev_counter2=0;
    int next_counter1=0;
    int next_counter2=0;
    
    public String LCS(String synset_id1, String synset_id2) throws Exception
    {
        String temp="\nSearch Begins with "+synset_id1+" & "+synset_id2;
	//System.out.println(temp);
        
        /*RandomAccessFile rfile=null;
        try
        {
            rfile=new RandomAccessFile("Checked_List.txt","rw");
            rfile.seek(rfile.length()); //  Go To the End
            rfile.writeBytes("\n"+temp);       //  Appand New Data
            rfile.close();
        }
        catch(IOException ioe)
        {
            System.err.println(ioe);
        }*/
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

		//System.out.println("\nNEXT LEVEL SEARCH BEGINS");
                    go1(next_counter1);
		    go2(next_counter2);

		    out=findMatch(al1,al2);
		
		if(out==true)
		  break;
		//System.out.println("\nNO LCS FOUND IN THIS LEVEL");
		//System.out.println("*************************************************");
                    if(out==false && brk1==true && brk2==true)
                    {
			//System.out.println("\nNo New Data Item is Added in Both the Lists after Searching in this Level.\n\n\tChecking is Aborted\n");
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
                  //System.out.println("\tNO LCS ITEM IS FOUND\n");
                  //System.exit(0);
              }
              /*else if(out==true)
              {
                  showOutput(synset_id1,synset_id2,LCSitem);
              }*/
	    }
	    catch(Exception e){}
        }
        //return(Integer.parseInt(LCSitem));
        return LCSitem;
    }
    
    public void go1(int next_counter)throws Exception
    {
      if(prev_counter1==next_counter)
      {
          brk1=true;
	  //System.out.println("\nNo New Data item is added in 1st Synset List.\n Checking Stopped for this List");
	  return;
      }
      String synset_id_go1;
      while(prev_counter1<next_counter)
      {
	synset_id_go1=(String)al1.get(prev_counter1);
	rs1=stmt.executeQuery("select child_synset_id from wordnet_master.wn_master_rel_hypernymy_hyponymy where parent_synset_id='"+synset_id_go1+"';");
	prev_counter1++;
        //System.out.println("For 1st Synset id");    
        while(rs1.next()==true)
        {
	  String temp=rs1.getString("child_synset_id");
          al1.add(temp);
          //System.out.println(temp);
          
        }
      }
      //System.out.println("\n1st Synset List : ");
      //System.out.println(al1);
    }
    
    public void go2(int next_counter) throws Exception
    {
      if(prev_counter2==next_counter)
      {
          brk2=true;
	  //System.out.println("\nNo New Data item is added in 2nd Synset List.\n Checking Stopped for this List");
	  return;
      }
      String synset_id_go2;
      while(prev_counter2<next_counter)
      {
	synset_id_go2=(String)al2.get(prev_counter2);
        rs2=stmt.executeQuery("select child_synset_id from wordnet_master.wn_master_rel_hypernymy_hyponymy where parent_synset_id='"+synset_id_go2+"';");
	prev_counter2++;
        //System.out.println("For 2nd Synset id");
        while(rs2.next()==true)
        {
	  String temp=rs2.getString("child_synset_id");
          al2.add(temp);
          //System.out.println(temp);
        }
      }
      //System.out.println("\n2nd Synset List : ");
      //System.out.println(al2);
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
    
    public void showOutput(String syn1,String syn2,String lcs_syn)
    {
        BufferedWriter wr=null;
        Connection conn;
        Statement stmt;
        ResultSet rs;
        
        String one="";
        String two="";
        String lcs_string="";
        try
        {
            wr=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Target_Word.txt"),"UTF-8"));
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
            stmt=conn.createStatement();
            rs=stmt.executeQuery("select word from wordnet_bengali.wn_word where word_id IN (select word_id from wordnet_bengali.wn_synset_words where synset_id='" + syn1 +"');");
            while(rs.next()==true)
            {
                one=one+"  "+rs.getString("word");
            }
            rs=stmt.executeQuery("select word from wordnet_bengali.wn_word where word_id IN (select word_id from wordnet_bengali.wn_synset_words where synset_id='" + syn2 +"');");
            while(rs.next()==true)
            {
                two=two+"  "+rs.getString("word");
            }
            rs=stmt.executeQuery("select word from wordnet_bengali.wn_word where word_id IN (select word_id from wordnet_bengali.wn_synset_words where synset_id='" + lcs_syn +"');");
            while(rs.next()==true)
            {
                lcs_string=lcs_string+"  "+rs.getString("word");
            }
            conn.close();
            wr.write(lcs_string);
            wr.close();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        int a=Integer.parseInt(LCSitem);
        System.out.println("\n\tLCS FOUND");
        System.out.println("\n\tThe LCS is : "+a);
        System.out.println("\nLCS of "+one+"  & "+two+"\n\nis "+lcs_string+"\n" );
    }
}


public class SemanticSimilarityPathBased 
{
    FileRandomAccess fra;       //  File Pointer to Store Information Contents
    FileRandomAccess fra2;      //  File Pointer to store Word Similarity
    String LCSitem="";          //  To Store LCS item Globally for every function belongs to this class
    
    
    
    public void words(String word1,String word2)
    {
        LCS_Finder lcs;
        Connection conn;
        Statement stmt;
        ResultSet rs;
        
        int word1_counter=0;
        int word2_counter=0;
        int total=word1_counter+word2_counter;
        
        String one="";
        String two="";
        
        LCSitem="";         //  To Avoid any Previous value
        
        
        ArrayList <String> word1_synset_list = new ArrayList <String> ();  //  To store all synset ids of word 1
        ArrayList <String> word2_synset_list = new ArrayList <String> ();  //  To store all synset ids of word 2
        ArrayList <String> combination_list=new ArrayList <String> ();      //  To store the Combination of two Synset lists
        
        //ArrayList <Vector> word1_info_list=new ArrayList <Vector> ();      //   To store all info about word1 in a ArrayList of Vectors
        //ArrayList <Vector> word2_info_list=new ArrayList <Vector> ();      //   To store all info about word2 in a ArrayList of Vectors
        
        ArrayList <String> LCS_list=new ArrayList <String> ();             //   To Store Unique LCS
        ArrayList <Double> LCS_value_list=new ArrayList <Double> ();     //   To Store the LCS count List
        //ArrayList <Integer> LCS_time_list=new ArrayList <Integer> ();      //   To store the frequency counts
        
        //ArrayList <String> synset1_list=new ArrayList <String> ();          //  To Store the 1st Synset id of unique LCS
        //ArrayList <String> synset2_list=new ArrayList <String> ();          //  To Store the 2nd Synset id of unique LCS
        
        try
        {
            fra=new FileRandomAccess("Information_Table.txt");      //  File name to store Information 
            fra2=new FileRandomAccess("Similarity_Table.txt");
            //fra.append("\n\nNew Pair of Words\n\n");
            
            System.out.println("\nNew Pair of Words\n");
            System.out.println("In Word Function ");
                        
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/wordnet_bengali?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
            stmt=conn.createStatement();
            
        // Getting Synset list for 1st Word from Wordnet
            
            rs=stmt.executeQuery("select synset_id from wordnet_bengali.wn_synset_words where word_id IN (select word_id from wordnet_bengali.wn_word where wn_word.word='"+word1+"');");
            while(rs.next()==true)
            {
                word1_synset_list.add(rs.getString(1));
            }
        // End *****************************************************   
            
        // Getting Synset list for 2nd Word from wordnet
            
            rs=stmt.executeQuery("select synset_id from wordnet_bengali.wn_synset_words where word_id IN (select word_id from wordnet_bengali.wn_word where wn_word.word='"+word2+"');");
            while(rs.next()==true)
            {
                word2_synset_list.add(rs.getString(1));
            }
            
        // End  *****************************************************
            
            System.out.println("Word 1 : "+word1+"\tSynsets are "+word1_synset_list);
            System.out.println("Word 2 : "+word2+"\tSynsets are "+word2_synset_list);
            
            combination_list=findCombination(word1_synset_list,word2_synset_list);  //  To generate Combination List of 1st and 2nd Word's Synsets
            
            System.out.println("\nCombination List is : "+combination_list);
                        
            for(int i=0;i<combination_list.size();i+=2)
            {
                //System.out.println("\nCombination List Running time : "+((i/2)+1));
                
                one=combination_list.get(i);             //  Temorary Variable only used in this function
                two=combination_list.get(i+1);           //  Temorary Variable only used in this function
                
                double similarity=sim(one,two);
                if(LCS_list.contains(LCSitem)==true)
                {
                    double temp=LCS_value_list.get(LCS_list.indexOf(LCSitem));
                    if(temp<similarity)
                    {
                        LCS_value_list.set(LCS_list.indexOf(LCSitem),similarity);
                    }
                }
                else
                {
                    LCS_list.add(LCSitem);
                    LCS_value_list.add(similarity);
                }
                fra.append("\n"+word1+" ("+one+")\t"+word2+" ("+two+")\t"+LCSitem+"\t\t\t\t\t"+similarity);
                //wr.write("\n"+word1+"\t\t"+word2+"\t\t"+LCSitem+"\t\t\t\t\t"+similarity);
            }
            double max=0.0;
            for(int i=0;i<LCS_value_list.size();i++)
            {
                max=LCS_value_list.get(0);
                if(max<LCS_value_list.get(i))
                {
                    max=LCS_value_list.get(i);
                }
            }
            fra2.append("\n"+word1+"\t\t"+word2+"\t\t"+LCS_list.get(LCS_value_list.indexOf(max))+"\t\t\t\t\t"+max);
            //System.out.println("\n"+word1+"\t\t"+word2+"\t\t"+LCS_list.get(LCS_value_list.indexOf(max))+"\t\t\t\t\t"+max);
            
        }
        catch(Exception e)
        {
            System.err.println("Words Function exception" + e);
        }
        finally
        {
            try
            {
                fra.close();
                fra2.close();
                /*System.out.println("\n\n Word1 = "+word1+"\tWord2 = "+word2);
                System.out.println("LCS :\t"+LCS_list);
                System.out.println("Values :"+LCS_count_list);
                System.out.println("Countes :"+LCS_time_list);*/
            }
            catch(Exception e){}
        }
    }
    
    public ArrayList<String> findCombination(ArrayList <String> al1 , ArrayList <String> al2)
    {
        ArrayList <String> temp=new ArrayList <String> ();
        for(int i=0;i<al1.size();i++)
        {
            for(int j=0;j<al2.size();j++)
            {
                temp.add(al1.get(i));
                temp.add(al2.get(j));
            }
        }
        return temp;
    }
    
    public double sim(String one, String two)
    {
        double cal=0.0;
        double x=0.0;
        
        RootFinder rf1=new RootFinder();
        RootFinder rf2=new RootFinder();
        
        ArrayList <String> intersection_synset_list=new ArrayList <String> ();
        ArrayList <String> union_synset_list=new ArrayList <String> ();
        
        try
        {
            String root_of_one=(new RootFinder()).findRoot(one);
            String root_of_two=(new RootFinder()).findRoot(two);

            System.out.println("\nRoot of "+one+" is "+root_of_one);
            System.out.println("Root of "+two+" is "+root_of_two);

            if(root_of_one.equals(root_of_two)==true)
            {
                System.out.println("\n"+one+" & "+two+" belongs to Same Ontology");
                String temp=new LCS_Finder().LCS(one,two);
                if(temp=="-1")
                {
                    System.out.println("\n"+one+"\t"+two+"\t"+"LCS = No Lcs item Found");
                    LCSitem="None";
                    cal=0.0;
                }
                else
                {
                    rf1.findRoot(one);
                    rf2.findRoot(two);
                    intersection_synset_list=findIntersection(rf1.al1,rf2.al1);
                    union_synset_list=findUnion(rf1.al1,rf2.al1);
                    x=((double)union_synset_list.size()-(double)intersection_synset_list.size())/(double)union_synset_list.size();
                    cal=-log2(x);
                    if(cal==-0.0)
                        LCSitem="None";
                    else
                        LCSitem=(new RootFinder().getWord(new LCS_Finder().LCS(one,two))).trim();
                }
            }
            else
            {
                System.out.println("\n"+one+" & "+two+" belongs to Different Ontologies");
                System.out.println("Word1 = "+new RootFinder().getConcept(one));
                System.out.println("Word2 = "+new RootFinder().getConcept(two));
                rf1.findRoot(one);
                rf2.findRoot(two);
                intersection_synset_list=findIntersection(rf1.al1,rf2.al1);
                union_synset_list=findUnion(rf1.al1,rf2.al1);
                x=((double)union_synset_list.size()-(double)intersection_synset_list.size())/(double)union_synset_list.size();
                cal=-log2(x);
                if(cal==-0.0)
                    LCSitem="None";
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return cal;
    }

    public ArrayList <String> findIntersection(ArrayList <String> al1,ArrayList <String> al2 )
    {
        ArrayList <String> temp=new ArrayList <String> ();
        for(int i=0;i<al1.size();i++)
        {
            if(al2.contains(al1.get(i))==true)
                temp.add(al1.get(i));
        }
        return temp;        
    }    
    
    public ArrayList <String> findUnion(ArrayList <String> al1,ArrayList <String> al2 )
    {
        ArrayList <String> temp=new ArrayList <String> ();
        for(int i=0;i<al1.size();i++)
        {
            if(al2.contains(al1.get(i))==true)
                temp.add(al1.get(i));
        }
        for(int i=0;i<al1.size();i++)
        {
            if(temp.contains(al1.get(i))==false)
                temp.add(al1.get(i));
        }
        for(int i=0;i<al2.size();i++)
        {
            if(temp.contains(al2.get(i))==false)
                temp.add(al2.get(i));
        }
        return temp;
    }
    
    public double log2(double val)
    {
        return (Math.log10(val)*(1/Math.log10(2)));
    }
    
    
    
    
    public static void main(String[] args) 
    {
        SemanticSimilarityPathBased sm=new SemanticSimilarityPathBased();
        try
        {
            BufferedWriter wr=new BufferedWriter(new OutputStreamWriter((new FileOutputStream("Information_Table.txt")),"UTF-8"));
            wr.write("\nWord 1\t\tWord 2\t\tSubsumer\t\t\t\t\tSimilarity\n\n");
            wr.close();
            
            BufferedWriter wr2=new BufferedWriter(new OutputStreamWriter((new FileOutputStream("Similarity_Table.txt")),"UTF-8"));
            wr2.write("\nWord 1\t\tWord 2\t\tSubsumer\t\t\t\t\tSimilarity\n\n");
            wr2.close();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        try
        {
            BufferedReader rd=new BufferedReader(new InputStreamReader((new FileInputStream("Word_Pair_List.txt")),"UTF-8"));
            BufferedReader or=new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
            int option=0;
            while(true)
            {
                String line=rd.readLine();
                if(line==null)
                    break;
                else
                {
                    String word1="",word2="";
                    StringTokenizer st=new StringTokenizer(line);
                    while(st.hasMoreTokens()==true)
                    {
                        word1=st.nextToken();
                        word2=st.nextToken();
                    }
                    sm.words(word1,word2);
                    while(true)
                    {
                        System.out.println("\n\nDo you Want to Continue \nFor Yes press 1\nFor No press 0\n");
                        option=Integer.parseInt(or.readLine());
                        if(option==1)
                        {
                            System.out.println("Continue With Function Call");
                            sm.words(word1,word2);
                            break;
                        }
                        else if(option==0)
                            return;
                        else
                            System.out.println("Inva1lid Choice\nTry Again with Correct Option");
                    }
                }       
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }    
}
