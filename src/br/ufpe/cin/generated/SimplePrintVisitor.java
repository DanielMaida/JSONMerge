package br.ufpe.cin.generated;

import java.util.*;
import cide.gast.*;

import java.io.PrintStream;

import cide.languages.*;

import de.ovgu.cide.fstgen.ast.*;

public class SimplePrintVisitor extends AbstractFSTPrintVisitor  {
	public SimplePrintVisitor(PrintStream out) {
		super(out); generateSpaces=true;
	}
	public SimplePrintVisitor() {
		super(); generateSpaces=true;
	}
	public boolean visit(FSTNonTerminal nonTerminal) {
		if (nonTerminal.getType().equals("JSONRoot1")) {
			printFeatures(nonTerminal,true);
			{
				FSTNode v=getChild(nonTerminal, "Object");
				if (v!=null) {
					v.accept(this);
				}
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("JSONRoot2")) {
			printFeatures(nonTerminal,true);
			{
				FSTNode v=getChild(nonTerminal, "Array");
				if (v!=null) {
					v.accept(this);
				}
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Object")) {
			printFeatures(nonTerminal,true);
			printToken("{");
			hintNewLine();
			{
				FSTNode v=getChild(nonTerminal, "Members");
				if (v!=null) {
					v.accept(this);
				}
			}
			printToken("}");
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Members")) {
			printFeatures(nonTerminal,true);
			Iterator<FSTNode> listElements = getChildren(nonTerminal, "Pair").iterator();
			hintIncIndent();
			if (listElements.hasNext()) {
				listElements.next().accept(this);
			}
			while (listElements.hasNext()) {
				listElements.next().accept(this);
			}
			hintNewLine();
			hintDecIndent();
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Pair1")) {
			printFeatures(nonTerminal,true);
			{
				FSTNode v=getChild(nonTerminal, "String");
				if (v!=null) {
					v.accept(this);
				}
			}
			printToken(":");
			{
				FSTNode v=getChild(nonTerminal, "Value");
				if (v!=null) {
					v.accept(this);
				}
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Pair2")) {
			printFeatures(nonTerminal,true);
			printToken(",");
			hintNewLine();
			{
				FSTNode v=getChild(nonTerminal, "String");
				if (v!=null) {
					v.accept(this);
				}
			}
			printToken(":");
			{
				FSTNode v=getChild(nonTerminal, "Value");
				if (v!=null) {
					v.accept(this);
				}
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Array")) {
			printFeatures(nonTerminal,true);
			hintIncIndent();
			printToken("[");
			{
				FSTNode v=getChild(nonTerminal, "Elements");
				if (v!=null) {
					v.accept(this);
				}
			}
			printToken("]");
			hintDecIndent();
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Elements")) {
			printFeatures(nonTerminal,true);
			{
				FSTNode v=getChild(nonTerminal, "Value");
				if (v!=null) {
					v.accept(this);
				}
			}
			for (FSTNode v : getChildren(nonTerminal,"CommaValue")) {
				v.accept(this);
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("CommaValue")) {
			printFeatures(nonTerminal,true);
			printToken(",");
			{
				FSTNode v=getChild(nonTerminal, "Value");
				if (v!=null) {
					v.accept(this);
				}
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Value1")) {
			printFeatures(nonTerminal,true);
			{
				FSTNode v=getChild(nonTerminal, "String");
				if (v!=null) {
					v.accept(this);
				}
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Value2")) {
			printFeatures(nonTerminal,true);
			{
				FSTNode v=getChild(nonTerminal, "Number");
				if (v!=null) {
					v.accept(this);
				}
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Value3")) {
			printFeatures(nonTerminal,true);
			{
				FSTNode v=getChild(nonTerminal, "Object");
				if (v!=null) {
					v.accept(this);
				}
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Value4")) {
			printFeatures(nonTerminal,true);
			{
				FSTNode v=getChild(nonTerminal, "Array");
				if (v!=null) {
					v.accept(this);
				}
			}
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Value5")) {
			printFeatures(nonTerminal,true);
			printToken("true");
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Value6")) {
			printFeatures(nonTerminal,true);
			printToken("false");
			printFeatures(nonTerminal,false);
			return false;
		}
		if (nonTerminal.getType().equals("Value7")) {
			printFeatures(nonTerminal,true);
			printToken("null");
			printFeatures(nonTerminal,false);
			return false;
		}
		throw new RuntimeException("Unknown Non Terminal in FST "+nonTerminal);
	}
	protected boolean isSubtype(String type, String expectedType) {
		if (type.equals(expectedType)) return true;
		if (type.equals("Value3") && expectedType.equals("Value")) return true;
		if (type.equals("Value2") && expectedType.equals("Value")) return true;
		if (type.equals("Pair1") && expectedType.equals("Pair")) return true;
		if (type.equals("Value5") && expectedType.equals("Value")) return true;
		if (type.equals("Pair2") && expectedType.equals("Pair")) return true;
		if (type.equals("Value4") && expectedType.equals("Value")) return true;
		if (type.equals("Value7") && expectedType.equals("Value")) return true;
		if (type.equals("Value6") && expectedType.equals("Value")) return true;
		if (type.equals("JSONRoot1") && expectedType.equals("JSONRoot")) return true;
		if (type.equals("JSONRoot2") && expectedType.equals("JSONRoot")) return true;
		if (type.equals("Value1") && expectedType.equals("Value")) return true;
		return false;
	}
}
