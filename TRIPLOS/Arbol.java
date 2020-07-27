
package TRIPLOS;

import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Arbol{
	static String pos="";
    static int memoria=0;
    static int index=1;
    public Arbol(String valorexpresion) {

  if(String.valueOf(valorexpresion.charAt(valorexpresion.length()-1)).contains("+") || 
     String.valueOf(valorexpresion.charAt(valorexpresion.length()-1)).contains("-") ||
     String.valueOf(valorexpresion.charAt(valorexpresion.length()-1)).contains("*") ||
     String.valueOf(valorexpresion.charAt(valorexpresion.length()-1)).contains("/")){
	  throw new NullPointerException("Error");
  }else {

  valorexpresion=valorexpresion.replaceAll(" ","");
  System.out.println("Expresion ingresada: "+valorexpresion);
  Shunting parentNode=shunt(valorexpresion);
  System.out.println("Utilizando PostOrden");
  postOrder(parentNode);
  System.out.println("|Codigo Intermedio Generado - Triplos|");
  dfs(parentNode);
    
  ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("js");
    
    try {;
        Object result = engine.eval(valorexpresion);
        System.out.println(valorexpresion+" = "+result);
    } catch(ScriptException se) {
        se.printStackTrace();
    }
    }
	}

	public static void main(String[] args) {


        String inputString="4 + (3 + 7) + 9 - (4 + 1) + (2 * 5) + 7 - (4 * 5)";
        inputString=inputString.replaceAll(" ","");
        System.out.println();
        System.out.println("***EXPRESION MATEMATICA:          "+inputString);
        Shunting parentNode=shunt(inputString);
        
     //   System.out.println("*******POST-ORDEN*******");
       // postOrder(parentNode);
        
        System.out.println("****TRIPLOS GENERADOS****");
        
        System.out.println("  Resultado"+"          Op1"+"      Operador"+"        Op2");
        dfs(parentNode);
    }


    public static void dfs(Shunting root){
    if (isOperator(root.charac)){
    dfs(root.operand1);
    dfs(root.operand2);
    System.out.println((pos)+(++memoria)  +" :     "+ root.name +" =              " + root.operand1.name + "         "+ root.charac  + "         " + root.operand2.name);}}
    public static void postOrder(Shunting root){
    if (root.operand1!=null){
        postOrder(root.operand1);}
    if (root.operand2!=null){
        postOrder(root.operand2);}
    System.out.println(root.charac +" ");}
    private static Shunting shunt(String inputString) {

	Pila myStack=new Pila();
	Operador opr=new Operador();
	Stack<Character> operatorStack= new Stack();
	Stack<Shunting> expressionStack=new Stack();

        Character c;
        for (int i=0;i<inputString.length();i++){

            c=inputString.charAt(i);

            if (c=='('){
                operatorStack.push(c);
            }

            else if (Character.isDigit(c)){
                expressionStack.push(new Shunting(c));
            }

            else if (isOperator(c)){

                    while (opr.getOperatorPrecedence(myStack.getTopOfOperator(operatorStack)) >= opr.getOperatorPrecedence(c)) {
                        Character operator = operatorStack.pop();
                        Shunting e2 = expressionStack.pop();
                        Shunting e1 = expressionStack.pop();

                        expressionStack.push(new Shunting(operator,e1,e2,"T"+index++));
                    }

                operatorStack.push(c);
            }

            else if (c==')'){

                    while (myStack.getTopOfOperator(operatorStack) != '(') {

                        Character operator = operatorStack.pop();
                        Shunting e2 = expressionStack.pop();
                        Shunting e1 = expressionStack.pop();

                        expressionStack.push(new Shunting(operator,e1,e2,"T"+index++));
                //        expressionStack.push(new Shunting(operator,e1,e2,"T"+index++));
                    }

                operatorStack.pop();
            }

            else{
                System.out.println("error error");
            }
        }

        while(!operatorStack.empty()){
            Character operator=operatorStack.pop();
            Shunting e2=expressionStack.pop();
            Shunting e1=expressionStack.pop();
            expressionStack.push(new Shunting(operator,e1,e2,"T"+index++));
        }


        return expressionStack.pop();
    }

    public static boolean isOperator(Character c){
        if (c=='+' || c=='-' || c=='/' || c=='*'|| c=='%'){
            return true;
        }
        else{
            return false;
        }
    }
}

