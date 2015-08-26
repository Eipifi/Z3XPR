// Generated from XPR.g4 by ANTLR 4.5.1
package z3fol.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XPRParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LPAREN=4, RPAREN=5, LBRACKET=6, RPRACKET=7, PLUS=8, 
		MINUS=9, TIMES=10, DIV=11, GT=12, GE=13, LE=14, LT=15, EQ=16, NEQ=17, 
		ASSIGN=18, POINT=19, POW=20, OR=21, AND=22, IMPLIES=23, IFF=24, XOR=25, 
		NOT=26, SEMICOLON=27, SET_IN=28, SET_NOTIN=29, SET_UNION=30, SET_INTERSECT=31, 
		EXISTS=32, FORALL=33, KWD_TYPE=34, KWD_DECLARE=35, KWD_ASSERT=36, NUM_DECIMAL=37, 
		IDENTIFIER_UC=38, IDENTIFIER_LC=39, Whitespace=40, Newline=41, BlockComment=42, 
		LineComment=43;
	public static final int
		RULE_number = 0, RULE_type = 1, RULE_typeIdentifier = 2, RULE_typeTuple = 3, 
		RULE_typeGeneric = 4, RULE_variable = 5, RULE_variableTuple = 6, RULE_variableIdentifier = 7, 
		RULE_variableWithType = 8, RULE_variableWithTypeList = 9, RULE_anyExpression = 10, 
		RULE_sumop = 11, RULE_mulop = 12, RULE_arithExpression = 13, RULE_arithExpressionList = 14, 
		RULE_arithSum = 15, RULE_arithMul = 16, RULE_arithPow = 17, RULE_arithAtom = 18, 
		RULE_setExpression = 19, RULE_setSum = 20, RULE_setMul = 21, RULE_setAtom = 22, 
		RULE_inlineSet = 23, RULE_cmpop = 24, RULE_cmpStatement = 25, RULE_eqop = 26, 
		RULE_eqStatement = 27, RULE_setop = 28, RULE_setStatement = 29, RULE_logop = 30, 
		RULE_quantifiedStatement = 31, RULE_statement = 32, RULE_disjunction = 33, 
		RULE_conjunction = 34, RULE_statementAtom = 35, RULE_typeDeclaration = 36, 
		RULE_variableDeclaration = 37, RULE_factDeclaration = 38, RULE_assignment = 39, 
		RULE_document = 40, RULE_line = 41;
	public static final String[] ruleNames = {
		"number", "type", "typeIdentifier", "typeTuple", "typeGeneric", "variable", 
		"variableTuple", "variableIdentifier", "variableWithType", "variableWithTypeList", 
		"anyExpression", "sumop", "mulop", "arithExpression", "arithExpressionList", 
		"arithSum", "arithMul", "arithPow", "arithAtom", "setExpression", "setSum", 
		"setMul", "setAtom", "inlineSet", "cmpop", "cmpStatement", "eqop", "eqStatement", 
		"setop", "setStatement", "logop", "quantifiedStatement", "statement", 
		"disjunction", "conjunction", "statementAtom", "typeDeclaration", "variableDeclaration", 
		"factDeclaration", "assignment", "document", "line"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'0'", "','", "':'", "'('", "')'", "'{'", "'}'", "'+'", "'-'", "'*'", 
		"'/'", "'>'", "'>='", "'<='", "'<'", "'='", "'!='", "':='", "'.'", "'^'", 
		"'|'", "'&'", "'=>'", "'<=>'", "'XOR'", "'!'", "';'", "'in'", "'notin'", 
		"'∪'", "'∩'", "'Exists'", "'Forall'", "'type'", "'declare'", "'assert'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "LPAREN", "RPAREN", "LBRACKET", "RPRACKET", "PLUS", 
		"MINUS", "TIMES", "DIV", "GT", "GE", "LE", "LT", "EQ", "NEQ", "ASSIGN", 
		"POINT", "POW", "OR", "AND", "IMPLIES", "IFF", "XOR", "NOT", "SEMICOLON", 
		"SET_IN", "SET_NOTIN", "SET_UNION", "SET_INTERSECT", "EXISTS", "FORALL", 
		"KWD_TYPE", "KWD_DECLARE", "KWD_ASSERT", "NUM_DECIMAL", "IDENTIFIER_UC", 
		"IDENTIFIER_LC", "Whitespace", "Newline", "BlockComment", "LineComment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XPR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPRParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUM_DECIMAL() { return getToken(XPRParser.NUM_DECIMAL, 0); }
		public TerminalNode MINUS() { return getToken(XPRParser.MINUS, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(84);
				match(MINUS);
				}
			}

			setState(87);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==NUM_DECIMAL) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TypeTupleContext typeTuple() {
			return getRuleContext(TypeTupleContext.class,0);
		}
		public TypeGenericContext typeGeneric() {
			return getRuleContext(TypeGenericContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		try {
			setState(92);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				typeIdentifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				typeTuple();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				typeGeneric();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_UC() { return getToken(XPRParser.IDENTIFIER_UC, 0); }
		public TypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitTypeIdentifier(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(IDENTIFIER_UC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeTupleContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public TypeTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeTuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterTypeTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitTypeTuple(this);
		}
	}

	public final TypeTupleContext typeTuple() throws RecognitionException {
		TypeTupleContext _localctx = new TypeTupleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeTuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(LPAREN);
			setState(97);
			type();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(98);
				match(T__1);
				setState(99);
				type();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeGenericContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TerminalNode LT() { return getToken(XPRParser.LT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GT() { return getToken(XPRParser.GT, 0); }
		public TypeGenericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeGeneric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterTypeGeneric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitTypeGeneric(this);
		}
	}

	public final TypeGenericContext typeGeneric() throws RecognitionException {
		TypeGenericContext _localctx = new TypeGenericContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeGeneric);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			typeIdentifier();
			setState(108);
			match(LT);
			setState(109);
			type();
			setState(110);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public VariableIdentifierContext variableIdentifier() {
			return getRuleContext(VariableIdentifierContext.class,0);
		}
		public VariableTupleContext variableTuple() {
			return getRuleContext(VariableTupleContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variable);
		try {
			setState(114);
			switch (_input.LA(1)) {
			case IDENTIFIER_LC:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				variableIdentifier();
				}
				break;
			case IDENTIFIER_UC:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				variableTuple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableTupleContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public VariableTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableTuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterVariableTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitVariableTuple(this);
		}
	}

	public final VariableTupleContext variableTuple() throws RecognitionException {
		VariableTupleContext _localctx = new VariableTupleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableTuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			typeIdentifier();
			setState(117);
			match(LPAREN);
			setState(118);
			variable();
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				match(T__1);
				setState(120);
				variable();
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(125);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableIdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_LC() { return getToken(XPRParser.IDENTIFIER_LC, 0); }
		public VariableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterVariableIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitVariableIdentifier(this);
		}
	}

	public final VariableIdentifierContext variableIdentifier() throws RecognitionException {
		VariableIdentifierContext _localctx = new VariableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(IDENTIFIER_LC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableWithTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableIdentifierContext variableIdentifier() {
			return getRuleContext(VariableIdentifierContext.class,0);
		}
		public VariableWithTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableWithType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterVariableWithType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitVariableWithType(this);
		}
	}

	public final VariableWithTypeContext variableWithType() throws RecognitionException {
		VariableWithTypeContext _localctx = new VariableWithTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableWithType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			type();
			setState(130);
			variableIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableWithTypeListContext extends ParserRuleContext {
		public List<VariableWithTypeContext> variableWithType() {
			return getRuleContexts(VariableWithTypeContext.class);
		}
		public VariableWithTypeContext variableWithType(int i) {
			return getRuleContext(VariableWithTypeContext.class,i);
		}
		public VariableWithTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableWithTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterVariableWithTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitVariableWithTypeList(this);
		}
	}

	public final VariableWithTypeListContext variableWithTypeList() throws RecognitionException {
		VariableWithTypeListContext _localctx = new VariableWithTypeListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variableWithTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			variableWithType();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(133);
				match(T__1);
				setState(134);
				variableWithType();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyExpressionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ArithExpressionContext arithExpression() {
			return getRuleContext(ArithExpressionContext.class,0);
		}
		public SetExpressionContext setExpression() {
			return getRuleContext(SetExpressionContext.class,0);
		}
		public AnyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterAnyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitAnyExpression(this);
		}
	}

	public final AnyExpressionContext anyExpression() throws RecognitionException {
		AnyExpressionContext _localctx = new AnyExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_anyExpression);
		try {
			setState(143);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				arithExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				setExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SumopContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(XPRParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(XPRParser.MINUS, 0); }
		public SumopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterSumop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitSumop(this);
		}
	}

	public final SumopContext sumop() throws RecognitionException {
		SumopContext _localctx = new SumopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sumop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulopContext extends ParserRuleContext {
		public TerminalNode TIMES() { return getToken(XPRParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(XPRParser.DIV, 0); }
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitMulop(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_la = _input.LA(1);
			if ( !(_la==TIMES || _la==DIV) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithExpressionContext extends ParserRuleContext {
		public ArithSumContext arithSum() {
			return getRuleContext(ArithSumContext.class,0);
		}
		public ArithExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterArithExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitArithExpression(this);
		}
	}

	public final ArithExpressionContext arithExpression() throws RecognitionException {
		ArithExpressionContext _localctx = new ArithExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arithExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			arithSum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithExpressionListContext extends ParserRuleContext {
		public List<ArithExpressionContext> arithExpression() {
			return getRuleContexts(ArithExpressionContext.class);
		}
		public ArithExpressionContext arithExpression(int i) {
			return getRuleContext(ArithExpressionContext.class,i);
		}
		public ArithExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterArithExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitArithExpressionList(this);
		}
	}

	public final ArithExpressionListContext arithExpressionList() throws RecognitionException {
		ArithExpressionListContext _localctx = new ArithExpressionListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arithExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			arithExpression();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(152);
				match(T__1);
				setState(153);
				arithExpression();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithSumContext extends ParserRuleContext {
		public List<ArithMulContext> arithMul() {
			return getRuleContexts(ArithMulContext.class);
		}
		public ArithMulContext arithMul(int i) {
			return getRuleContext(ArithMulContext.class,i);
		}
		public List<SumopContext> sumop() {
			return getRuleContexts(SumopContext.class);
		}
		public SumopContext sumop(int i) {
			return getRuleContext(SumopContext.class,i);
		}
		public ArithSumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithSum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterArithSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitArithSum(this);
		}
	}

	public final ArithSumContext arithSum() throws RecognitionException {
		ArithSumContext _localctx = new ArithSumContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arithSum);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			arithMul();
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(160);
					sumop();
					setState(161);
					arithMul();
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithMulContext extends ParserRuleContext {
		public List<ArithPowContext> arithPow() {
			return getRuleContexts(ArithPowContext.class);
		}
		public ArithPowContext arithPow(int i) {
			return getRuleContext(ArithPowContext.class,i);
		}
		public List<MulopContext> mulop() {
			return getRuleContexts(MulopContext.class);
		}
		public MulopContext mulop(int i) {
			return getRuleContext(MulopContext.class,i);
		}
		public ArithMulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithMul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterArithMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitArithMul(this);
		}
	}

	public final ArithMulContext arithMul() throws RecognitionException {
		ArithMulContext _localctx = new ArithMulContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arithMul);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			arithPow();
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(169);
					mulop();
					setState(170);
					arithPow();
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithPowContext extends ParserRuleContext {
		public ArithAtomContext arithAtom() {
			return getRuleContext(ArithAtomContext.class,0);
		}
		public TerminalNode POW() { return getToken(XPRParser.POW, 0); }
		public ArithExpressionContext arithExpression() {
			return getRuleContext(ArithExpressionContext.class,0);
		}
		public ArithPowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithPow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterArithPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitArithPow(this);
		}
	}

	public final ArithPowContext arithPow() throws RecognitionException {
		ArithPowContext _localctx = new ArithPowContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arithPow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			arithAtom();
			setState(180);
			_la = _input.LA(1);
			if (_la==POW) {
				{
				setState(178);
				match(POW);
				setState(179);
				arithExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithAtomContext extends ParserRuleContext {
		public VariableIdentifierContext variableIdentifier() {
			return getRuleContext(VariableIdentifierContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public ArithExpressionContext arithExpression() {
			return getRuleContext(ArithExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public ArithAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterArithAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitArithAtom(this);
		}
	}

	public final ArithAtomContext arithAtom() throws RecognitionException {
		ArithAtomContext _localctx = new ArithAtomContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arithAtom);
		try {
			setState(188);
			switch (_input.LA(1)) {
			case IDENTIFIER_LC:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				variableIdentifier();
				}
				break;
			case T__0:
			case MINUS:
			case NUM_DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				number();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(LPAREN);
				setState(185);
				arithExpression();
				setState(186);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetExpressionContext extends ParserRuleContext {
		public SetSumContext setSum() {
			return getRuleContext(SetSumContext.class,0);
		}
		public SetExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterSetExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitSetExpression(this);
		}
	}

	public final SetExpressionContext setExpression() throws RecognitionException {
		SetExpressionContext _localctx = new SetExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_setExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			setSum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetSumContext extends ParserRuleContext {
		public List<SetMulContext> setMul() {
			return getRuleContexts(SetMulContext.class);
		}
		public SetMulContext setMul(int i) {
			return getRuleContext(SetMulContext.class,i);
		}
		public List<TerminalNode> SET_UNION() { return getTokens(XPRParser.SET_UNION); }
		public TerminalNode SET_UNION(int i) {
			return getToken(XPRParser.SET_UNION, i);
		}
		public SetSumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setSum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterSetSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitSetSum(this);
		}
	}

	public final SetSumContext setSum() throws RecognitionException {
		SetSumContext _localctx = new SetSumContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_setSum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			setMul();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET_UNION) {
				{
				{
				setState(193);
				match(SET_UNION);
				setState(194);
				setMul();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetMulContext extends ParserRuleContext {
		public List<SetAtomContext> setAtom() {
			return getRuleContexts(SetAtomContext.class);
		}
		public SetAtomContext setAtom(int i) {
			return getRuleContext(SetAtomContext.class,i);
		}
		public List<TerminalNode> SET_INTERSECT() { return getTokens(XPRParser.SET_INTERSECT); }
		public TerminalNode SET_INTERSECT(int i) {
			return getToken(XPRParser.SET_INTERSECT, i);
		}
		public SetMulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setMul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterSetMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitSetMul(this);
		}
	}

	public final SetMulContext setMul() throws RecognitionException {
		SetMulContext _localctx = new SetMulContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_setMul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			setAtom();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET_INTERSECT) {
				{
				{
				setState(201);
				match(SET_INTERSECT);
				setState(202);
				setAtom();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetAtomContext extends ParserRuleContext {
		public VariableIdentifierContext variableIdentifier() {
			return getRuleContext(VariableIdentifierContext.class,0);
		}
		public InlineSetContext inlineSet() {
			return getRuleContext(InlineSetContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public SetExpressionContext setExpression() {
			return getRuleContext(SetExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public SetAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterSetAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitSetAtom(this);
		}
	}

	public final SetAtomContext setAtom() throws RecognitionException {
		SetAtomContext _localctx = new SetAtomContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_setAtom);
		try {
			setState(214);
			switch (_input.LA(1)) {
			case IDENTIFIER_LC:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				variableIdentifier();
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				inlineSet();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				match(LPAREN);
				setState(211);
				setExpression();
				setState(212);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineSetContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(XPRParser.LBRACKET, 0); }
		public ArithExpressionListContext arithExpressionList() {
			return getRuleContext(ArithExpressionListContext.class,0);
		}
		public TerminalNode RPRACKET() { return getToken(XPRParser.RPRACKET, 0); }
		public InlineSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterInlineSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitInlineSet(this);
		}
	}

	public final InlineSetContext inlineSet() throws RecognitionException {
		InlineSetContext _localctx = new InlineSetContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_inlineSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(LBRACKET);
			setState(217);
			arithExpressionList();
			setState(218);
			match(RPRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmpopContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(XPRParser.LT, 0); }
		public TerminalNode LE() { return getToken(XPRParser.LE, 0); }
		public TerminalNode GT() { return getToken(XPRParser.GT, 0); }
		public TerminalNode GE() { return getToken(XPRParser.GE, 0); }
		public CmpopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterCmpop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitCmpop(this);
		}
	}

	public final CmpopContext cmpop() throws RecognitionException {
		CmpopContext _localctx = new CmpopContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cmpop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LE) | (1L << LT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmpStatementContext extends ParserRuleContext {
		public List<ArithExpressionContext> arithExpression() {
			return getRuleContexts(ArithExpressionContext.class);
		}
		public ArithExpressionContext arithExpression(int i) {
			return getRuleContext(ArithExpressionContext.class,i);
		}
		public CmpopContext cmpop() {
			return getRuleContext(CmpopContext.class,0);
		}
		public CmpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterCmpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitCmpStatement(this);
		}
	}

	public final CmpStatementContext cmpStatement() throws RecognitionException {
		CmpStatementContext _localctx = new CmpStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cmpStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			arithExpression();
			setState(223);
			cmpop();
			setState(224);
			arithExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqopContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(XPRParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(XPRParser.NEQ, 0); }
		public EqopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterEqop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitEqop(this);
		}
	}

	public final EqopContext eqop() throws RecognitionException {
		EqopContext _localctx = new EqopContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_eqop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==NEQ) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqStatementContext extends ParserRuleContext {
		public List<AnyExpressionContext> anyExpression() {
			return getRuleContexts(AnyExpressionContext.class);
		}
		public AnyExpressionContext anyExpression(int i) {
			return getRuleContext(AnyExpressionContext.class,i);
		}
		public EqopContext eqop() {
			return getRuleContext(EqopContext.class,0);
		}
		public EqStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterEqStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitEqStatement(this);
		}
	}

	public final EqStatementContext eqStatement() throws RecognitionException {
		EqStatementContext _localctx = new EqStatementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_eqStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			anyExpression();
			setState(229);
			eqop();
			setState(230);
			anyExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetopContext extends ParserRuleContext {
		public TerminalNode SET_IN() { return getToken(XPRParser.SET_IN, 0); }
		public TerminalNode SET_NOTIN() { return getToken(XPRParser.SET_NOTIN, 0); }
		public SetopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterSetop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitSetop(this);
		}
	}

	public final SetopContext setop() throws RecognitionException {
		SetopContext _localctx = new SetopContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_setop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( !(_la==SET_IN || _la==SET_NOTIN) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetStatementContext extends ParserRuleContext {
		public AnyExpressionContext anyExpression() {
			return getRuleContext(AnyExpressionContext.class,0);
		}
		public SetopContext setop() {
			return getRuleContext(SetopContext.class,0);
		}
		public SetExpressionContext setExpression() {
			return getRuleContext(SetExpressionContext.class,0);
		}
		public SetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterSetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitSetStatement(this);
		}
	}

	public final SetStatementContext setStatement() throws RecognitionException {
		SetStatementContext _localctx = new SetStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_setStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			anyExpression();
			setState(235);
			setop();
			setState(236);
			setExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogopContext extends ParserRuleContext {
		public TerminalNode IMPLIES() { return getToken(XPRParser.IMPLIES, 0); }
		public TerminalNode IFF() { return getToken(XPRParser.IFF, 0); }
		public TerminalNode XOR() { return getToken(XPRParser.XOR, 0); }
		public LogopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterLogop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitLogop(this);
		}
	}

	public final LogopContext logop() throws RecognitionException {
		LogopContext _localctx = new LogopContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_logop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPLIES) | (1L << IFF) | (1L << XOR))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifiedStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public VariableWithTypeListContext variableWithTypeList() {
			return getRuleContext(VariableWithTypeListContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(XPRParser.FORALL, 0); }
		public TerminalNode EXISTS() { return getToken(XPRParser.EXISTS, 0); }
		public QuantifiedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifiedStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterQuantifiedStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitQuantifiedStatement(this);
		}
	}

	public final QuantifiedStatementContext quantifiedStatement() throws RecognitionException {
		QuantifiedStatementContext _localctx = new QuantifiedStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_quantifiedStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if (_la==EXISTS || _la==FORALL) {
				{
				setState(240);
				_la = _input.LA(1);
				if ( !(_la==EXISTS || _la==FORALL) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(241);
				variableWithTypeList();
				setState(242);
				match(T__2);
				}
			}

			setState(246);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<DisjunctionContext> disjunction() {
			return getRuleContexts(DisjunctionContext.class);
		}
		public DisjunctionContext disjunction(int i) {
			return getRuleContext(DisjunctionContext.class,i);
		}
		public LogopContext logop() {
			return getRuleContext(LogopContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			disjunction();
			setState(252);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPLIES) | (1L << IFF) | (1L << XOR))) != 0)) {
				{
				setState(249);
				logop();
				setState(250);
				disjunction();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(XPRParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(XPRParser.OR, i);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitDisjunction(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_disjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			conjunction();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(255);
				match(OR);
				setState(256);
				conjunction();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjunctionContext extends ParserRuleContext {
		public List<StatementAtomContext> statementAtom() {
			return getRuleContexts(StatementAtomContext.class);
		}
		public StatementAtomContext statementAtom(int i) {
			return getRuleContext(StatementAtomContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(XPRParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(XPRParser.AND, i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitConjunction(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			statementAtom();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(263);
				match(AND);
				setState(264);
				statementAtom();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementAtomContext extends ParserRuleContext {
		public VariableIdentifierContext variableIdentifier() {
			return getRuleContext(VariableIdentifierContext.class,0);
		}
		public SetStatementContext setStatement() {
			return getRuleContext(SetStatementContext.class,0);
		}
		public CmpStatementContext cmpStatement() {
			return getRuleContext(CmpStatementContext.class,0);
		}
		public EqStatementContext eqStatement() {
			return getRuleContext(EqStatementContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public QuantifiedStatementContext quantifiedStatement() {
			return getRuleContext(QuantifiedStatementContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(XPRParser.NOT, 0); }
		public StatementAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterStatementAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitStatementAtom(this);
		}
	}

	public final StatementAtomContext statementAtom() throws RecognitionException {
		StatementAtomContext _localctx = new StatementAtomContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_statementAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(270);
				match(NOT);
				}
			}

			setState(281);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(273);
				variableIdentifier();
				}
				break;
			case 2:
				{
				setState(274);
				setStatement();
				}
				break;
			case 3:
				{
				setState(275);
				cmpStatement();
				}
				break;
			case 4:
				{
				setState(276);
				eqStatement();
				}
				break;
			case 5:
				{
				setState(277);
				match(LPAREN);
				setState(278);
				quantifiedStatement();
				setState(279);
				match(RPAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public TerminalNode KWD_TYPE() { return getToken(XPRParser.KWD_TYPE, 0); }
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitTypeDeclaration(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(KWD_TYPE);
			setState(284);
			typeIdentifier();
			setState(286);
			_la = _input.LA(1);
			if (_la==LPAREN || _la==IDENTIFIER_UC) {
				{
				setState(285);
				type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode KWD_DECLARE() { return getToken(XPRParser.KWD_DECLARE, 0); }
		public VariableWithTypeContext variableWithType() {
			return getRuleContext(VariableWithTypeContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(KWD_DECLARE);
			setState(289);
			variableWithType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactDeclarationContext extends ParserRuleContext {
		public TerminalNode KWD_ASSERT() { return getToken(XPRParser.KWD_ASSERT, 0); }
		public QuantifiedStatementContext quantifiedStatement() {
			return getRuleContext(QuantifiedStatementContext.class,0);
		}
		public FactDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterFactDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitFactDeclaration(this);
		}
	}

	public final FactDeclarationContext factDeclaration() throws RecognitionException {
		FactDeclarationContext _localctx = new FactDeclarationContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_factDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(KWD_ASSERT);
			setState(292);
			quantifiedStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public VariableIdentifierContext variableIdentifier() {
			return getRuleContext(VariableIdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(XPRParser.ASSIGN, 0); }
		public AnyExpressionContext anyExpression() {
			return getRuleContext(AnyExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			variableIdentifier();
			setState(295);
			match(ASSIGN);
			setState(296);
			anyExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DocumentContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KWD_TYPE) | (1L << KWD_DECLARE) | (1L << KWD_ASSERT) | (1L << IDENTIFIER_LC))) != 0)) {
				{
				{
				setState(298);
				line();
				setState(299);
				match(SEMICOLON);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FactDeclarationContext factDeclaration() {
			return getRuleContext(FactDeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_line);
		try {
			setState(310);
			switch (_input.LA(1)) {
			case KWD_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				typeDeclaration();
				}
				break;
			case KWD_DECLARE:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				variableDeclaration();
				}
				break;
			case KWD_ASSERT:
				enterOuterAlt(_localctx, 3);
				{
				setState(308);
				factDeclaration();
				}
				break;
			case IDENTIFIER_LC:
				enterOuterAlt(_localctx, 4);
				{
				setState(309);
				assignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u013b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\5\2X\n\2\3\2\3\2\3\3\3\3\3\3\5\3_\n\3\3\4\3\4\3\5\3\5\3\5\3\5\7\5g"+
		"\n\5\f\5\16\5j\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7u\n\7\3\b\3"+
		"\b\3\b\3\b\3\b\6\b|\n\b\r\b\16\b}\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\7\13\u008a\n\13\f\13\16\13\u008d\13\13\3\f\3\f\3\f\5\f\u0092\n\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\7\20\u009d\n\20\f\20\16\20"+
		"\u00a0\13\20\3\21\3\21\3\21\3\21\7\21\u00a6\n\21\f\21\16\21\u00a9\13\21"+
		"\3\22\3\22\3\22\3\22\7\22\u00af\n\22\f\22\16\22\u00b2\13\22\3\23\3\23"+
		"\3\23\5\23\u00b7\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00bf\n\24\3"+
		"\25\3\25\3\26\3\26\3\26\7\26\u00c6\n\26\f\26\16\26\u00c9\13\26\3\27\3"+
		"\27\3\27\7\27\u00ce\n\27\f\27\16\27\u00d1\13\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\5\30\u00d9\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3 \3"+
		" \3!\3!\3!\3!\5!\u00f7\n!\3!\3!\3\"\3\"\3\"\3\"\5\"\u00ff\n\"\3#\3#\3"+
		"#\7#\u0104\n#\f#\16#\u0107\13#\3$\3$\3$\7$\u010c\n$\f$\16$\u010f\13$\3"+
		"%\5%\u0112\n%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u011c\n%\3&\3&\3&\5&\u0121\n"+
		"&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\7*\u0130\n*\f*\16*\u0133\13"+
		"*\3+\3+\3+\3+\5+\u0139\n+\3+\2\2,\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT\2\n\4\2\3\3\'\'\3\2\n\13\3\2\f"+
		"\r\3\2\16\21\3\2\22\23\3\2\36\37\3\2\31\33\3\2\"#\u0131\2W\3\2\2\2\4^"+
		"\3\2\2\2\6`\3\2\2\2\bb\3\2\2\2\nm\3\2\2\2\ft\3\2\2\2\16v\3\2\2\2\20\u0081"+
		"\3\2\2\2\22\u0083\3\2\2\2\24\u0086\3\2\2\2\26\u0091\3\2\2\2\30\u0093\3"+
		"\2\2\2\32\u0095\3\2\2\2\34\u0097\3\2\2\2\36\u0099\3\2\2\2 \u00a1\3\2\2"+
		"\2\"\u00aa\3\2\2\2$\u00b3\3\2\2\2&\u00be\3\2\2\2(\u00c0\3\2\2\2*\u00c2"+
		"\3\2\2\2,\u00ca\3\2\2\2.\u00d8\3\2\2\2\60\u00da\3\2\2\2\62\u00de\3\2\2"+
		"\2\64\u00e0\3\2\2\2\66\u00e4\3\2\2\28\u00e6\3\2\2\2:\u00ea\3\2\2\2<\u00ec"+
		"\3\2\2\2>\u00f0\3\2\2\2@\u00f6\3\2\2\2B\u00fa\3\2\2\2D\u0100\3\2\2\2F"+
		"\u0108\3\2\2\2H\u0111\3\2\2\2J\u011d\3\2\2\2L\u0122\3\2\2\2N\u0125\3\2"+
		"\2\2P\u0128\3\2\2\2R\u0131\3\2\2\2T\u0138\3\2\2\2VX\7\13\2\2WV\3\2\2\2"+
		"WX\3\2\2\2XY\3\2\2\2YZ\t\2\2\2Z\3\3\2\2\2[_\5\6\4\2\\_\5\b\5\2]_\5\n\6"+
		"\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\5\3\2\2\2`a\7(\2\2a\7\3\2\2\2bc\7\6"+
		"\2\2ch\5\4\3\2de\7\4\2\2eg\5\4\3\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2"+
		"\2\2ik\3\2\2\2jh\3\2\2\2kl\7\7\2\2l\t\3\2\2\2mn\5\6\4\2no\7\21\2\2op\5"+
		"\4\3\2pq\7\16\2\2q\13\3\2\2\2ru\5\20\t\2su\5\16\b\2tr\3\2\2\2ts\3\2\2"+
		"\2u\r\3\2\2\2vw\5\6\4\2wx\7\6\2\2x{\5\f\7\2yz\7\4\2\2z|\5\f\7\2{y\3\2"+
		"\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7\7\2\2\u0080"+
		"\17\3\2\2\2\u0081\u0082\7)\2\2\u0082\21\3\2\2\2\u0083\u0084\5\4\3\2\u0084"+
		"\u0085\5\20\t\2\u0085\23\3\2\2\2\u0086\u008b\5\22\n\2\u0087\u0088\7\4"+
		"\2\2\u0088\u008a\5\22\n\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\25\3\2\2\2\u008d\u008b\3\2\2"+
		"\2\u008e\u0092\5\f\7\2\u008f\u0092\5\34\17\2\u0090\u0092\5(\25\2\u0091"+
		"\u008e\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092\27\3\2\2"+
		"\2\u0093\u0094\t\3\2\2\u0094\31\3\2\2\2\u0095\u0096\t\4\2\2\u0096\33\3"+
		"\2\2\2\u0097\u0098\5 \21\2\u0098\35\3\2\2\2\u0099\u009e\5\34\17\2\u009a"+
		"\u009b\7\4\2\2\u009b\u009d\5\34\17\2\u009c\u009a\3\2\2\2\u009d\u00a0\3"+
		"\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\37\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a1\u00a7\5\"\22\2\u00a2\u00a3\5\30\r\2\u00a3\u00a4\5"+
		"\"\22\2\u00a4\u00a6\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8!\3\2\2\2\u00a9\u00a7\3\2\2\2"+
		"\u00aa\u00b0\5$\23\2\u00ab\u00ac\5\32\16\2\u00ac\u00ad\5$\23\2\u00ad\u00af"+
		"\3\2\2\2\u00ae\u00ab\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1#\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\5&\24\2"+
		"\u00b4\u00b5\7\26\2\2\u00b5\u00b7\5\34\17\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7%\3\2\2\2\u00b8\u00bf\5\20\t\2\u00b9\u00bf\5\2\2\2"+
		"\u00ba\u00bb\7\6\2\2\u00bb\u00bc\5\34\17\2\u00bc\u00bd\7\7\2\2\u00bd\u00bf"+
		"\3\2\2\2\u00be\u00b8\3\2\2\2\u00be\u00b9\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf"+
		"\'\3\2\2\2\u00c0\u00c1\5*\26\2\u00c1)\3\2\2\2\u00c2\u00c7\5,\27\2\u00c3"+
		"\u00c4\7 \2\2\u00c4\u00c6\5,\27\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2"+
		"\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8+\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00ca\u00cf\5.\30\2\u00cb\u00cc\7!\2\2\u00cc\u00ce\5.\30\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0-\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d9\5\20\t\2\u00d3\u00d9"+
		"\5\60\31\2\u00d4\u00d5\7\6\2\2\u00d5\u00d6\5(\25\2\u00d6\u00d7\7\7\2\2"+
		"\u00d7\u00d9\3\2\2\2\u00d8\u00d2\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d8\u00d4"+
		"\3\2\2\2\u00d9/\3\2\2\2\u00da\u00db\7\b\2\2\u00db\u00dc\5\36\20\2\u00dc"+
		"\u00dd\7\t\2\2\u00dd\61\3\2\2\2\u00de\u00df\t\5\2\2\u00df\63\3\2\2\2\u00e0"+
		"\u00e1\5\34\17\2\u00e1\u00e2\5\62\32\2\u00e2\u00e3\5\34\17\2\u00e3\65"+
		"\3\2\2\2\u00e4\u00e5\t\6\2\2\u00e5\67\3\2\2\2\u00e6\u00e7\5\26\f\2\u00e7"+
		"\u00e8\5\66\34\2\u00e8\u00e9\5\26\f\2\u00e99\3\2\2\2\u00ea\u00eb\t\7\2"+
		"\2\u00eb;\3\2\2\2\u00ec\u00ed\5\26\f\2\u00ed\u00ee\5:\36\2\u00ee\u00ef"+
		"\5(\25\2\u00ef=\3\2\2\2\u00f0\u00f1\t\b\2\2\u00f1?\3\2\2\2\u00f2\u00f3"+
		"\t\t\2\2\u00f3\u00f4\5\24\13\2\u00f4\u00f5\7\5\2\2\u00f5\u00f7\3\2\2\2"+
		"\u00f6\u00f2\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9"+
		"\5B\"\2\u00f9A\3\2\2\2\u00fa\u00fe\5D#\2\u00fb\u00fc\5> \2\u00fc\u00fd"+
		"\5D#\2\u00fd\u00ff\3\2\2\2\u00fe\u00fb\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"C\3\2\2\2\u0100\u0105\5F$\2\u0101\u0102\7\27\2\2\u0102\u0104\5F$\2\u0103"+
		"\u0101\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106E\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010d\5H%\2\u0109\u010a"+
		"\7\30\2\2\u010a\u010c\5H%\2\u010b\u0109\3\2\2\2\u010c\u010f\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010eG\3\2\2\2\u010f\u010d\3\2\2\2"+
		"\u0110\u0112\7\34\2\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u011b"+
		"\3\2\2\2\u0113\u011c\5\20\t\2\u0114\u011c\5<\37\2\u0115\u011c\5\64\33"+
		"\2\u0116\u011c\58\35\2\u0117\u0118\7\6\2\2\u0118\u0119\5@!\2\u0119\u011a"+
		"\7\7\2\2\u011a\u011c\3\2\2\2\u011b\u0113\3\2\2\2\u011b\u0114\3\2\2\2\u011b"+
		"\u0115\3\2\2\2\u011b\u0116\3\2\2\2\u011b\u0117\3\2\2\2\u011cI\3\2\2\2"+
		"\u011d\u011e\7$\2\2\u011e\u0120\5\6\4\2\u011f\u0121\5\4\3\2\u0120\u011f"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121K\3\2\2\2\u0122\u0123\7%\2\2\u0123\u0124"+
		"\5\22\n\2\u0124M\3\2\2\2\u0125\u0126\7&\2\2\u0126\u0127\5@!\2\u0127O\3"+
		"\2\2\2\u0128\u0129\5\20\t\2\u0129\u012a\7\24\2\2\u012a\u012b\5\26\f\2"+
		"\u012bQ\3\2\2\2\u012c\u012d\5T+\2\u012d\u012e\7\35\2\2\u012e\u0130\3\2"+
		"\2\2\u012f\u012c\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132S\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0139\5J&\2\u0135"+
		"\u0139\5L\'\2\u0136\u0139\5N(\2\u0137\u0139\5P)\2\u0138\u0134\3\2\2\2"+
		"\u0138\u0135\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0137\3\2\2\2\u0139U\3"+
		"\2\2\2\32W^ht}\u008b\u0091\u009e\u00a7\u00b0\u00b6\u00be\u00c7\u00cf\u00d8"+
		"\u00f6\u00fe\u0105\u010d\u0111\u011b\u0120\u0131\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}