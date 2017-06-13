/*
    * Muhammad Ashraf Ewaily        14101380
    * System Programming Project 1 | SIC/XE 2-Pass Assembler
 */
package sic.xe.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class SICXEProject {

    
    public static void main(String[] args) throws FileNotFoundException {
        
        File F = new File ("inSIC-XE.txt");
        Scanner scan = new Scanner(F);
        String[][] table = new String[23][4];
        String[][] table2 = new String[23][5];
        int [] label = new int [32];
        String[] row = new String[17];
        String rr [] = new String [2];
        String S;
        int z = 0;
        int q = 0;
        int rrr=0;
        
        
        //Scanning the txt file
        
       while ( scan.hasNext() ){
            
            
            S = scan.nextLine();
            row = S.split(" "); //Splitting the words with respect of Space
            table[z][1] = row[0];
            table2[z][1] = table[z][1];
            table[z][2] = row[1];
            table2[z][2] = table[z][2];
            table[z][3] = row[2];
            table2[z][3] = table[z][3];
            z ++ ;
            
        
    }
        
        
        // ><><><><><><><><><><>< PASS 1 ><><><><><><><><><><><><><
        
        table[1][0] = table[0][3]; // setting the counter starting location
        table2[1][0] = table[1][0];
        table[0][0] = " ";
        table2[0][0] = table[0][0];
        label[1] = Integer.parseInt(table[1][0]);
        int x = 0; z = 1; 
        
        
                // Setting location counter
                     
        while ( !"END".equals(table[z][2])){
            
            if ( "WORD".equals(table[z][2])){
                
                    
                if (table[z][3].contains(",")){
                        rr = table[z][3].split(",");
                        rrr = (rr.length * 3);
                        label[z+1] = label[z] +rrr;
                          table[z+1][0] = Integer.toHexString(label[z+1]);
                         table[z+1][0] = ("0000" + table[z+1][0]).substring(table[z+1][0].length());
                         table2[z+1][0] = table[z+1][0];
                    }
                
                else    if ("BASE".equals(table[z+1][2])){
                        z++;
                        label[z] = label[z-1];}
                
                
                else {  label[z+1] = label[z] +3;
                    table[z+1][0] = Integer.toHexString(label[z+1]);
                    table[z+1][0] = ("0000" + table[z+1][0]).substring(table[z+1][0].length());
                    table2[z+1][0] = table[z+1][0];
            }
            }
    
            
            else if ( "BYTE".equals(table[z][2])){
                if ("BASE".equals(table[z+1][2])){
                        z++;
                        label[z] = label[z-1];
                }
                if(table[z][2].startsWith("C")){
                    
                    label[z+1] = label[z] + (table[z][2].length()) - 3;
                    table[z+1][0] = Integer.toHexString(label[z+1]);
                    table[z+1][0] = ("0000" + table[z+1][0]).substring(table[z+1][0].length());
                    table2[z+1][0] = table[z+1][0];
                }
                
                else{
                    if ("BASE".equals(table[z+1][2])){
                        z++;
                        label[z] = label[z-1];
                }
                    label[z+1] = label[z] + ((table[z][2].length())/2) - 3;
                    table[z+1][0] = Integer.toHexString(label[z+1]);
                    table[z+1][0] = ("0000" + table[z+1][0]).substring(table[z+1][0].length());
                    table2[z+1][0] = table[z+1][0];
                }
            }
            
           else if ( "RESW".equals(table[z][2])){
                    
              if ("BASE".equals(table[z+1][2])){
                        z++;
                        label[z] = label[z-1];
                }
                    label[z+1] = label[z] + (Integer.parseInt(table[z][3])*3);
                    table[z+1][0] = Integer.toHexString(label[z+1]);
                    table[z+1][0] = ("0000" + table[z+1][0]).substring(table[z+1][0].length());
                    table2[z+1][0] = table[z+1][0];
                  //  System.out.println(table[z+1][0]);
            }
            
           else if ( "RESB".equals(table[z][2])){
                    
               if ("BASE".equals(table[z+1][2])){
                        z++;
                        label[z] = label[z-1];
                }
                    x = Integer.parseInt(table[z][3]);
                    label[z+1] = label[z] + x ;
                    table[z+1][0] = Integer.toHexString(label[z+1]);
                    table[z+1][0] = ("0000" + table[z+1][0]).substring(table[z+1][0].length());
                    table2[z+1][0] = table[z+1][0];
            }
           
           else if (( "ADDR".equals(table[z][2]))|| ( "CLEAR".equals(table[z][2])) || ( "DIVR".equals(table[z][2])) || ( "COMPR".equals(table[z][2]))
                   || ( "MULR".equals(table[z][2])) || ( "RMO".equals(table[z][2])) || ( "SHIFTL".equals(table[z][2])) || ( "SHIFTR".equals(table[z][2]))
                   || ( "SUBR".equals(table[z][2])) || ( "SVC".equals(table[z][2])) || ( "TIXR".equals(table[z][2]))){
               
               if ("BASE".equals(table[z+1][2])){
                        z++;
                        label[z] = label[z-1];
                }
                    label[z+1] = label[z] + 2 ;
                    table[z+1][0] =  Integer.toHexString(label[z+1]);
                    table[z+1][0] = ("0000" + table[z+1][0]).substring(table[z+1][0].length());
                    table2[z+1][0] = table[z+1][0];
           }
           
           
           else if (table[z][2].contains("+")){
                
                if ("BASE".equals(table[z+1][2])){
                        z++;
                        label[z] = label[z-1];
                }
                    label[z+1] = label[z] + 4 ;
                    table[z+1][0] =  Integer.toHexString(label[z+1]);
                    table[z+1][0] = ("0000" + table[z+1][0]).substring(table[z+1][0].length());
                    table2[z+1][0] = table[z+1][0];
           }
          
           
            else {
                   if ("BASE".equals(table[z+1][2])){
                        z++;
                        label[z] = label[z-1];
                }
                    label[z+1] = label[z] + 3 ;
                    table[z+1][0] =  Integer.toHexString(label[z+1]);
                    table[z+1][0] = ("0000" + table[z+1][0]).substring(table[z+1][0].length());
                    table2[z+1][0] = table[z+1][0];

                    
            }
            
        z ++;
        x = 0;
        
        
        
                
        }
    
        
        // Printing the table with the location counter
       
        System.out.println("PASS ONE:\n *Set Location Counter:\n");
        for (int j = 0; j < 23; j++) {
            for (int k = 0; k < 4; k++) {
                System.out.print(table[j][k] +"\t");

            }
            System.out.println();

        }
        
        // Printing the Symbol Table Generation
        
        System.out.println(" \n\n*Symbol Table Generation:\n");
        
        String [][] g = new String [21][2];
        
        int gg=1;
        int yy=1;
        
        g[0][0] = "Symbol"; g[0][1] = "Location";
        
        for (int y = 1 ; y < 22 ; y ++){
            
            if( !"".equals(table[y][1]) ){
                
                g[gg][0] = table[y][1];
                g[gg][1] = table[y][0];
                gg ++ ;
            }
            
            
        }
        
       for (int j = 0; j < 9; j++) {
            for (int k = 0; k < 2; k++) {
                System.out.print(g[j][k] +"\t");

            }
            System.out.println();

        }
       
       System.out.println(" \n\n*Program Lenght:\n");
       
       int l = (label[z]) - (label[1]);
       String Length = Integer.toHexString(l);
       
       System.out.println((Integer.toHexString(l)));
       
       
       
     System.out.println("\n\nEND OF PASS ONE\n\n\n");
     
     
                                        // >>>>>>>>> ENDING OF PASS ONE <<<<<<<<<<
                                        
    
                                        
                                        
    // setting the base
    
    z = 1; String fbase = null; int base = 0;
    while (!"END".equals(table[z][2])){
        if ("BASE".equals(table[z][2])){
            fbase = (table[z][3]);
            break;
        }
        else z++;
    }
    z=1;
    while (!"END".equals(table[z][2])){
        
        
        if(fbase.equals(table[z][1])){
            base = label[z];
            break;
        }
        else
            z++;
    }
    
    //================================================
    
        String[][] INST = new String[30][3];
        INST[0] = new String[]{"LDX", "0","4"};
        INST[1] = new String[]{"LDA", "0","0"};
        INST[2] = new String[]{"LDB", "6","8"};
        INST[3] = new String[]{"ADD", "1","8"};
        INST[4] = new String[]{"TIX", "2","12"};
        INST[5] = new String[]{"JLT", "3","8"};
        INST[6] = new String[]{"STA", "0","12"};
        INST[7] = new String[]{"RSUB", "4","12"};
        INST[8] = new String[]{"+LDX", "0","4"};
        INST[9] = new String[]{"+LDA", "0","0"};
        INST[10] = new String[]{"+LDB", "6","8"};
        INST[11] = new String[]{"+ADD", "1","8"};
        INST[12] = new String[]{"+TIX", "2","12"};
        INST[13] = new String[]{"+JLT", "3","8"};
        INST[14] = new String[]{"+STA", "0","12"};
        INST[15] = new String[]{"+RSUB", "4","12"};
        INST[16] = new String[]{"ADDR", "9","0"};
        INST[17] = new String[]{"CLEAR", "b","4"};
        INST[18] = new String[]{"COMPR", "a","0"};
        INST[19] = new String[]{"DIVR", "9","c"};
        INST[20] = new String[]{"MULR", "9","8"};
        INST[21] = new String[]{"RMO", "a","c"};
        INST[22] = new String[]{"SHIFTL", "a","4"};
        INST[23] = new String[]{"SHIFTR", "a","8"};
        INST[24] = new String[]{"SUBR", "9","4"};
        INST[25] = new String[]{"SVC", "b","0"};
        INST[26] = new String[]{"TIXR", "b","8"};
        
        //================================================
        
        String[][] rg = new String[7][2];
        rg[0] = new String[]{"A", "0"};
        rg[1] = new String[]{"X", "1"};
        rg[2] = new String[]{"L", "2"};
        rg[3] = new String[]{"B", "3"};
        rg[4] = new String[]{"S", "4"};
        rg[5] = new String[]{"T", "5"};
        rg[6] = new String[]{"F", "6"};
        
        //================================================
        
    
   // System.out.println(base);
     int fx =0, fin = 2 , fim = 1, fe=0 , fpc=0,addr=0,fb=0,i=0; int TA = 0;
     String Disp,fflags,o1,o2;
     int ftt=0;
     String r [] = new String [2];
     String tu [] = new String [5];
     String r1 = null,r2 = null;
     int ii = 0;
     int [] sp = new int [32];
      z = 1 ; int zz=1;
      table2[0][4] = " ";
       table2[22][4] = " ";
             while ( !"END".equals(table2[z][2])){
                 
                 if (( "ADDR".equals(table[z][2]))|| ( "CLEAR".equals(table[z][2])) || ( "DIVR".equals(table[z][2])) || ( "COMPR".equals(table[z][2]))
                   || ( "MULR".equals(table[z][2])) || ( "RMO".equals(table[z][2])) || ( "SHIFTL".equals(table[z][2])) || ( "SHIFTR".equals(table[z][2]))
                   || ( "SUBR".equals(table[z][2])) || ( "SVC".equals(table[z][2])) || ( "TIXR".equals(table[z][2]))){
                     
                     for (  ii = 0 ; ii < 28 ; ii ++ ){
                     
                     if ( table[z][2].equals(INST[ii][0])){
                         
                         break;
                     }
                 }
                     
                     if (table2[z][3].contains(",")){
                         
                         r = table2[z][3].split(",");
                         for ( i = 0 ; i < 7 ; i ++ ){
                             
                             if (rg[i][0].equals(r[0])){
                                 
                                  r1 = rg[i][1];
                                 break;
                             }
                         }
                         for ( i = 0 ; i < 7 ; i ++ ){
                             
                             if (rg[i][0].equals(r[1])){
                                 
                                  r2 = rg[i][1];
                                  
                                 break;
                             }
                         }
                         table2[z][4] = INST[ii][1] + INST[ii][2] + r1 + r2;
                         z++;
                         continue;
                     }
                     else {
                         for ( i = 0 ; i < 7 ; i ++ ){
                             
                             if (rg[i][0].equals(table2[z][3])){
                                 
                                  r1 = rg[i][1];
                                 break;
                             }
                         
                     }
                    table2[z][4] = INST[ii][1] + INST[ii][2] + r1 + 0;
                    z++;
                    continue;
                }

}
                 
                 
                  if ("WORD".equals(table2[z][2])){
               
               
                    if (table[z][3].contains(",")){
                        rr = table[z][3].split(",");
                        for ( int t = 0 ; t < rr.length ; t ++ ){
                            
                            int tempr = Integer.parseInt(rr[t]);
                        table2[z][4] += Integer.toHexString(tempr);
                       
                    }
                        table2[z][4] = ("000000" + table2[z][4]).substring(table2[z][4].length());
                      z++; fin = 2 ; fim = 1;
                                        continue;
                        
                    }
                    else {
                       int n = Integer.parseInt(table[z][3]);
           
                      table2[z][4] = Integer.toHexString(n);
                      table2[z][4] = ("000000" + table2[z][4]).substring(table2[z][4].length());
                      z++; fin = 2 ; fim = 1;
                                        continue;
                    }
           }
                if (("RESW".equals(table2[z][2])) || ("REBW".equals(table2[z][2]))) {
               
                    table2[z][4] = "No Obj. Code";
                    z++; fin = 2 ; fim = 1;
                    continue;
                }
                
                 if (("RSUB".equals(table2[z][2])) ) {
               
                    table2[z][4] = "4c0000";
                    z++; fin = 2 ; fim = 1;
                    continue;
                }
                    
                if ("BASE".equals(table2[z][2]))  {
               
                    table2[z][4] = " ";
                    z++; 
                    continue;
               
           }
                
                 
                 
                 if (table2[z][3].contains(",X"))
                     fx = 8;
                 else
                     fx = 0;
                 
                 
                 if (table2[z][2].startsWith("+")){
                     fe = 1;
                     fb = 0;
                     fpc =0;
                 
                 }
                 else{
                     fe = 0;
                     fb = 0;
                     fpc = 2;
                 }
                 
                  // setting the obcode
                 
                 for (  i = 0 ; i < 23 ; i ++ ){
                     
                     if ( table[z][2].equals(INST[i][0]))
                         break;
                 }
                 
                 if ( fe == 0 ){ // if it is not format 4 *format 3*
                     
                     zz=1;
                     fin = 2 ; fim = 1;
                     
                     if (table2[z][3].startsWith("#")){
                     fim = 1;
                     fin = 0;
                 }
                 
                 if (table2[z][3].startsWith("@")){
                     fin = 2;
                     fim=0;
                 }
                 
                 if (fx == 8){
                             r = table[z][3].split(",X");
                         }
                 if (fin == 2 && fim == 0){
                             r = table[z][3].split("@");
                         }
                     
                     
                 while ( !"END".equals(table2[zz][2])){  // setting the TARGET ADDRESS
                    
                     
                     if ( fx == 8 ) {
                         ftt=0;
                     if(r[0].equals(table2[zz][1])){
                         
                        
                             
                          TA = label[zz];
                         int PC = label[z+1];
                         addr = TA - PC;
                         
                         if (( addr <= 2047 ) && ( addr >= -2048 ))
                                 fpc = 2;
                         
                         
                         
                             else{
                             addr = TA - base;
                             fb = 4;
                             fpc =0;
                             
                         }
                         ftt=1;
                           break;
                     }
                     zz++;
                         
                         
                        
                     }
                     
                     else if ((fin == 2 && fim == 0)){
                             
                                                      ftt=0;
                     if(r[1].equals(table2[zz][1])){
                         
                        
                             
                          TA = label[zz];
                         int PC = label[z+1];
                         addr = TA - PC;
                         
                         if (( addr <= 2047 ) && ( addr >= -2048 ))
                                 fpc = 2;
                         
                         
                         
                             else{
                             addr = TA - base;
                             fb = 4;
                             fpc =0;
                             
                         }
                         ftt=1;
                           break;
                     }
                     zz++;
                             
                             
                         }
                     else {
                         ftt=0;
                     if(table2[z][3].equals(table2[zz][1])){
                         
                        
                             
                          TA = label[zz];
                         int PC = label[z+1];
                         addr = TA - PC;
                         
                         if (( addr <= 2047 ) && ( addr >= -2048 ))
                                 fpc = 2;
                         else{
                             addr = TA - base;
                             fb = 4;
                             fpc =0;
                             
                         }
                         ftt=1;
                           break;
                     }
                     zz++;
                             }
                    }
                 if ( ftt == 0 ){
                     r = table2[z][3].split("#");
                     
                     addr = Integer.parseInt(r[1]);
                     String tr = Integer.toHexString(addr);
                     fb = 0;
                     fpc = 0;
                 }
                  //**********************************
                 Disp  = Integer.toHexString(addr);
                          Disp = ("000" + Disp).substring(Disp.length());
                          int flags = fe + fb + fpc + fx;
                          fflags  = Integer.toHexString(flags);
                 int xz = Integer.parseInt(INST[i][2]) + fin + fim;
                 
                 o2 = Integer.toHexString(xz);
                 o1 = INST[i][1];
                 table2[z][4] = o1 + o2 + fflags + Disp;
                 //***********************************
                  z++;
                 
                 
                }
                 
                 else if (fe == 1){  //format 4
                     
                     
                     
                     if (table2[z][3].startsWith("#")){
                     fim = 1;
                     fin = 0;
                 }
                 
                else if (table2[z][3].startsWith("@")){
                     fin = 2;
                     fim=0;
                 }
                else {
                    fin = 1;
                    fim = 2;
                }
                 
                 
                     o1 = INST[i][1];
                     int xz = Integer.parseInt(INST[i][2]);
                     xz += fin + fim;
                     o2 = Integer.toHexString(xz);
                     zz = 1;
                     if (fim == 1){
                             r = table[z][3].split("#");
                             
                         }
                     
                     
                     
                     if (fin == 2){
                             r = table[z][3].split("@");
                         }
                     while ( !"END".equals(table[zz][2])){  // setting the TARGET ADDRESS
                         
                         
                         if (fim == 1 ){
                             
                             if(table[zz][1].equals(r[1])){
                          TA = label[zz];
                          
                          break;
                     }
                             
                         }
                         
                         if (fin == 2 ){
                             
                             if(table[zz][1].equals(r[1])){
                          TA = label[zz];
                          
                          break;
                     }
                             
                         }
                     
                     if(table[zz][1].equals(table[z][3])){
                          TA = label[zz];
                          break;
                     }
                     zz++;
                     }
                     
                     if ( fim == 1 && TA == 0 ){
                         
                         r = table2[z][3].split("#");
                     
                     TA = Integer.parseInt(r[1]);
                     sp[q] = label[z];
                     q++;
                     }
                     Disp  = Integer.toHexString(TA);
                          Disp = ("00000" + Disp).substring(Disp.length());
                          int flags = fe + fb + fpc + fx;
                          fflags  = Integer.toHexString(flags);
                          table2[z][4] = o1 + o2 + fflags + Disp;
                     
                     fx =0; fin = 0 ; fim = 0; z++; 
                 
                 }
                 
             }
             
             
             System.out.println("PASS TWO:\n ");
        for (int j = 0; j < 23; j++) {
            for (int k = 0; k < 5; k++) {
                System.out.print(table2[j][k] +"\t");

            }
            System.out.println();

        }
        
        System.out.println("\n\nHTE RECORD:\n ");
        
        System.out.println("H."+("XXXXXX" + table[0][1]).substring(table[0][1].length())+"."+("000000" + table[1][0]).substring(table[1][0].length())+"."+("000000" + Length).substring(Length.length()));
        
        
        //**************************************************
        int flag = 0, u = 0;
        int v = 1;
        String st;
        String[] temp = new String[30];        
        
        while ( flag == 0 ) {
            
            
            if ( ("RESW".equals(table2[v][2])) || ("RESB".equals(table2[v][2]))) {
               v++;
            }
            else
            {   
                st = table2[v][0];
                    
                while (!"RESW".equals(table2[v][2]) && !"RESB".equals(table2[v][2])){
                    
                    
                   if ("END".equals(table2[v][2])){
                       
                       flag = 1;
                       break;
                   }
                   
                   else{
                       
                       temp[u] = table2[v][4];
                       u++ ;
                     //   System.out.print("."+table2[v][4]);
                        
                       
                       
                   }
                   
                   
                   v++;
                }
                String leng = Integer.toHexString(3*(u));
                System.out.print("T."+("000000" + st).substring(st.length())+"."+("00" + leng).substring(leng.length()));
               
                for (  i = 0 ; i < u ; i ++ ){
                    
                    System.out.print("."+temp[i]);
                    
                }
                System.out.println();
                
                u = 0;
                
                
            }
        }
       
     
        
        //**************************************************
       int yok = 0;
        for ( i = 1 ; i < 22 ; i ++ ){
            
            if ( table2[i][2].startsWith("+")){
                
                for ( int jj = 0 ; jj < 5 ; jj ++ ){
                    
                    if (sp[jj] == label [i])
                       yok = 1; 
                }
                
                if ( yok == 0 ){
                int mo = label[i]+1;
                String modif = Integer.toHexString(mo);
                
                System.out.println("M^"+modif+"^05");
            }
            }
            yok = 0 ;
        }
        
        
        System.out.println("E."+("000000" + table[1][0]).substring(table[1][0].length()));
             
    }
    
}
