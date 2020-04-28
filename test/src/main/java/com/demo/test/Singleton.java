package com.demo.test;

public class Singleton  {    
	 static
     {
         System.out.println("Class outer is loaded");
     }
    private Singleton() {}
    
     
    private static class SingletonHolder {    
    	 static
         {
             System.out.println("Class Inner is loaded");
         }
        public static final Singleton instance = new Singleton();
    }
 
    public static Singleton getInstance() {    
        return SingletonHolder.instance;    
    }
    
    public static void getInstance1() {    
    	System.out.println("nothing loaded");   
    }
}