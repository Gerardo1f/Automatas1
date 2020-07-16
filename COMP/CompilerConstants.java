package COMP;
public interface CompilerConstants {


  int EOF = 0;
  int ASIGNACION = 1;
  int PLUS = 2;
  int MINUS = 3;
  int MULTIPLY = 4;
  int PUBLIC = 5;
  int PRIVATE = 6;
  int STATIC = 7; 
  int VOID = 8;
  int MAIN = 9;
  int CLASS = 10;  
  int IF = 11; 
  int ELSE = 12;
  int PRINT = 13; 
  int LPAREN = 14;
  int RPAREN = 15;
  int LBRACE = 16; 
  int RBRACE = 17;
  int LBRACKET = 18; 
  int RBRACKET = 19; 
  int SEMICOLON = 20; 
  int COMMA = 21;
  int EQ = 22;
  int MN = 23;
  int GR = 24;
  int INT = 25; 
  int BOOLEAN = 26;
  int STR = 27;
  int INTEGER = 28;
  int STRUE = 29;
  int SFALSE = 30; 
  int USESTRING = 31;
  int IDENTIFIER = 32;
  int DEFAULT = 0;
  
  
  String[] tokenImage = {
		  
    "<EOF>",
    "\"=\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"public\"",
    "\"private\"",
    "\"static\"",
    "\"void\"",
    "\"main\"",
    "\"class\"",
    "\"if\"",
    "\"else\"",
    "\"print\"",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\";\"",
    "\",\"",
    "\"==\"",
    "\"<\"",
    "\">\"",
    "\"int\"",
    "\"boolean\"",
    "\"String\"",
    "<INTEGER>",
    "\"true\"",
    "\"false\"",
    "<USESTRING>",
    "<IDENTIFIER>",
    "\" \"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\r\\n\"",
    "\"\\t\"",};}
