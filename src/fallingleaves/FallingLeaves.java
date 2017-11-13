/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingleaves;

import java.util.Scanner;

/**
 *
 * @author edher
 */
public class FallingLeaves {

    class Nodo{
        char key;
        Nodo izq, der;
        
            public Nodo(char item){
                key= item;
                izq = der = null;
    }

    }
       Nodo root;
       
       FallingLeaves(){
           root=null;
       }
    
       void insert(char key){
           root=Recu(root, key);
       }   
       
       Nodo Recu(Nodo root, char key){
           
           if(root == null){
              root = new Nodo(key);
              return root;
           }
           
           if (key < root.key)
               root.izq=Recu(root.izq, key);
           else if (key > root.key)
               root.der=Recu(root.der, key);
           
           return root;
       }
       
       void preorden(){
           preordenRec(root);
       }
       
       void preordenRec(Nodo root){
           if(root != null){
               System.out.print(root.key);
               preordenRec(root.izq);
               preordenRec(root.der);
           }
       }
       
       public static void main(String[] args){
           FallingLeaves tree = new FallingLeaves();
           Scanner sc=new Scanner(System.in);
           String ingresa;
           String cadena="";
           String entrada="$";
           do{
               ingresa=sc.nextLine();
               if(ingresa.equals(entrada)){
                   break;
               }
               cadena+=ingresa;
           }while(!ingresa.equals(entrada));
           int total=cadena.length();
           
           for(int i=total-1;i>=0;i--){
               tree.insert(cadena.charAt(i));
           }
           
           tree.preordenRec(tree.root);
       }
}
