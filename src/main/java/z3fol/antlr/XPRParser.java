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
		SET_DIFF=32, EXISTS=33, FORALL=34, KWD_TYPE=35, KWD_DECLARE=36, KWD_ASSERT=37, 
		NUM_DECIMAL=38, IDENTIFIER_UC=39, IDENTIFIER_LC=40, Whitespace=41, Newline=42, 
		BlockComment=43, LineComment=44;
	public static final int
		RULE_number = 0, RULE_type = 1, RULE_typeIdentifier = 2, RULE_typeTuple = 3, 
		RULE_typeGeneric = 4, RULE_variable = 5, RULE_variableTuple = 6, RULE_variableIdentifier = 7, 
		RULE_variableWithType = 8, RULE_variableWithTypeList = 9, RULE_anyExpression = 10, 
		RULE_anyExpressionList = 11, RULE_sumop = 12, RULE_mulop = 13, RULE_arithExpression = 14, 
		RULE_arithExpressionList = 15, RULE_arithSum = 16, RULE_arithMul = 17, 
		RULE_arithPow = 18, RULE_arithAtom = 19, RULE_setExpression = 20, RULE_setSum = 21, 
		RULE_setMul = 22, RULE_setSumOp = 23, RULE_setAtom = 24, RULE_inlineSet = 25, 
		RULE_cmpop = 26, RULE_cmpStatement = 27, RULE_eqop = 28, RULE_eqStatement = 29, 
		RULE_setop = 30, RULE_setStatement = 31, RULE_logop = 32, RULE_quantifiedStatement = 33, 
		RULE_statement = 34, RULE_disjunction = 35, RULE_conjunction = 36, RULE_statementAtom = 37, 
		RULE_typeDeclaration = 38, RULE_variableDeclaration = 39, RULE_factDeclaration = 40, 
		RULE_assignment = 41, RULE_document = 42, RULE_line = 43;
	public static final String[] ruleNames = {
		"number", "type", "typeIdentifier", "typeTuple", "typeGeneric", "variable", 
		"variableTuple", "variableIdentifier", "variableWithType", "variableWithTypeList", 
		"anyExpression", "anyExpressionList", "sumop", "mulop", "arithExpression", 
		"arithExpressionList", "arithSum", "arithMul", "arithPow", "arithAtom", 
		"setExpression", "setSum", "setMul", "setSumOp", "setAtom", "inlineSet", 
		"cmpop", "cmpStatement", "eqop", "eqStatement", "setop", "setStatement", 
		"logop", "quantifiedStatement", "statement", "disjunction", "conjunction", 
		"statementAtom", "typeDeclaration", "variableDeclaration", "factDeclaration", 
		"assignment", "document", "line"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'0'", "','", "':'", "'('", "')'", "'{'", "'}'", "'+'", "'-'", "'*'", 
		"'/'", "'>'", "'>='", "'<='", "'<'", "'='", "'!='", "':='", "'.'", "'^'", 
		"'|'", "'&'", "'=>'", "'<=>'", "'XOR'", "'!'", "';'", "'in'", "'notin'", 
		"'∪'", "'∩'", "'\\'", "'Exists'", "'Forall'", "'type'", "'declare'", "'assert'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "LPAREN", "RPAREN", "LBRACKET", "RPRACKET", "PLUS", 
		"MINUS", "TIMES", "DIV", "GT", "GE", "LE", "LT", "EQ", "NEQ", "ASSIGN", 
		"POINT", "POW", "OR", "AND", "IMPLIES", "IFF", "XOR", "NOT", "SEMICOLON", 
		"SET_IN", "SET_NOTIN", "SET_UNION", "SET_INTERSECT", "SET_DIFF", "EXISTS", 
		"FORALL", "KWD_TYPE", "KWD_DECLARE", "KWD_ASSERT", "NUM_DECIMAL", "IDENTIFIER_UC", 
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
			setState(89);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(88);
				match(MINUS);
				}
			}

			setState(91);
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
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				typeIdentifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				typeTuple();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
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
			setState(98);
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
			setState(100);
			match(LPAREN);
			setState(101);
			type();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(102);
				match(T__1);
				setState(103);
				type();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
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
			setState(111);
			typeIdentifier();
			setState(112);
			match(LT);
			setState(113);
			type();
			setState(114);
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
			setState(118);
			switch (_input.LA(1)) {
			case IDENTIFIER_LC:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				variableIdentifier();
				}
				break;
			case IDENTIFIER_UC:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
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
		public List<AnyExpressionContext> anyExpression() {
			return getRuleContexts(AnyExpressionContext.class);
		}
		public AnyExpressionContext anyExpression(int i) {
			return getRuleContext(AnyExpressionContext.class,i);
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
			setState(120);
			typeIdentifier();
			setState(121);
			match(LPAREN);
			setState(122);
			anyExpression();
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(123);
				match(T__1);
				setState(124);
				anyExpression();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(129);
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
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(IDENTIFIER_LC);
			setState(134);
			_la = _input.LA(1);
			if (_la==POINT) {
				{
				setState(132);
				match(POINT);
				setState(133);
				number();
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
			setState(136);
			type();
			setState(137);
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
			setState(139);
			variableWithType();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(140);
				match(T__1);
				setState(141);
				variableWithType();
				}
				}
				setState(146);
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
			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				arithExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
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

	public static class AnyExpressionListContext extends ParserRuleContext {
		public List<AnyExpressionContext> anyExpression() {
			return getRuleContexts(AnyExpressionContext.class);
		}
		public AnyExpressionContext anyExpression(int i) {
			return getRuleContext(AnyExpressionContext.class,i);
		}
		public AnyExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterAnyExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitAnyExpressionList(this);
		}
	}

	public final AnyExpressionListContext anyExpressionList() throws RecognitionException {
		AnyExpressionListContext _localctx = new AnyExpressionListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_anyExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			anyExpression();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(153);
				match(T__1);
				setState(154);
				anyExpression();
				}
				}
				setState(159);
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
		enterRule(_localctx, 24, RULE_sumop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
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
		enterRule(_localctx, 26, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
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
		enterRule(_localctx, 28, RULE_arithExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
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
		enterRule(_localctx, 30, RULE_arithExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			arithExpression();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(167);
				match(T__1);
				setState(168);
				arithExpression();
				}
				}
				setState(173);
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
		enterRule(_localctx, 32, RULE_arithSum);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			arithMul();
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(175);
					sumop();
					setState(176);
					arithMul();
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		enterRule(_localctx, 34, RULE_arithMul);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			arithPow();
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(184);
					mulop();
					setState(185);
					arithPow();
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 36, RULE_arithPow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			arithAtom();
			setState(195);
			_la = _input.LA(1);
			if (_la==POW) {
				{
				setState(193);
				match(POW);
				setState(194);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
		enterRule(_localctx, 38, RULE_arithAtom);
		try {
			setState(203);
			switch (_input.LA(1)) {
			case IDENTIFIER_UC:
			case IDENTIFIER_LC:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				variable();
				}
				break;
			case T__0:
			case MINUS:
			case NUM_DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				number();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				match(LPAREN);
				setState(200);
				arithExpression();
				setState(201);
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
		enterRule(_localctx, 40, RULE_setExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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
		public List<SetSumOpContext> setSumOp() {
			return getRuleContexts(SetSumOpContext.class);
		}
		public SetSumOpContext setSumOp(int i) {
			return getRuleContext(SetSumOpContext.class,i);
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
		enterRule(_localctx, 42, RULE_setSum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			setMul();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET_UNION || _la==SET_DIFF) {
				{
				{
				setState(208);
				setSumOp();
				setState(209);
				setMul();
				}
				}
				setState(215);
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
		enterRule(_localctx, 44, RULE_setMul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			setAtom();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET_INTERSECT) {
				{
				{
				setState(217);
				match(SET_INTERSECT);
				setState(218);
				setAtom();
				}
				}
				setState(223);
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

	public static class SetSumOpContext extends ParserRuleContext {
		public TerminalNode SET_UNION() { return getToken(XPRParser.SET_UNION, 0); }
		public TerminalNode SET_DIFF() { return getToken(XPRParser.SET_DIFF, 0); }
		public SetSumOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setSumOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterSetSumOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitSetSumOp(this);
		}
	}

	public final SetSumOpContext setSumOp() throws RecognitionException {
		SetSumOpContext _localctx = new SetSumOpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_setSumOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_la = _input.LA(1);
			if ( !(_la==SET_UNION || _la==SET_DIFF) ) {
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

	public static class SetAtomContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
		enterRule(_localctx, 48, RULE_setAtom);
		try {
			setState(232);
			switch (_input.LA(1)) {
			case IDENTIFIER_UC:
			case IDENTIFIER_LC:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				variable();
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				inlineSet();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				match(LPAREN);
				setState(229);
				setExpression();
				setState(230);
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
		public AnyExpressionListContext anyExpressionList() {
			return getRuleContext(AnyExpressionListContext.class,0);
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
		enterRule(_localctx, 50, RULE_inlineSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(LBRACKET);
			setState(235);
			anyExpressionList();
			setState(236);
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
		enterRule(_localctx, 52, RULE_cmpop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
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
		enterRule(_localctx, 54, RULE_cmpStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			arithExpression();
			setState(241);
			cmpop();
			setState(242);
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
		enterRule(_localctx, 56, RULE_eqop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
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
		enterRule(_localctx, 58, RULE_eqStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			anyExpression();
			setState(247);
			eqop();
			setState(248);
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
		enterRule(_localctx, 60, RULE_setop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
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
		enterRule(_localctx, 62, RULE_setStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			anyExpression();
			setState(253);
			setop();
			setState(254);
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
		enterRule(_localctx, 64, RULE_logop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
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
		enterRule(_localctx, 66, RULE_quantifiedStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if (_la==EXISTS || _la==FORALL) {
				{
				setState(258);
				_la = _input.LA(1);
				if ( !(_la==EXISTS || _la==FORALL) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(259);
				variableWithTypeList();
				setState(260);
				match(T__2);
				}
			}

			setState(264);
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
		enterRule(_localctx, 68, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			disjunction();
			setState(270);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPLIES) | (1L << IFF) | (1L << XOR))) != 0)) {
				{
				setState(267);
				logop();
				setState(268);
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
		enterRule(_localctx, 70, RULE_disjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			conjunction();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(273);
				match(OR);
				setState(274);
				conjunction();
				}
				}
				setState(279);
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
		enterRule(_localctx, 72, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			statementAtom();
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(281);
				match(AND);
				setState(282);
				statementAtom();
				}
				}
				setState(287);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
		enterRule(_localctx, 74, RULE_statementAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(288);
				match(NOT);
				}
			}

			setState(299);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(291);
				variable();
				}
				break;
			case 2:
				{
				setState(292);
				setStatement();
				}
				break;
			case 3:
				{
				setState(293);
				cmpStatement();
				}
				break;
			case 4:
				{
				setState(294);
				eqStatement();
				}
				break;
			case 5:
				{
				setState(295);
				match(LPAREN);
				setState(296);
				quantifiedStatement();
				setState(297);
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
		enterRule(_localctx, 76, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(KWD_TYPE);
			setState(302);
			typeIdentifier();
			setState(304);
			_la = _input.LA(1);
			if (_la==LPAREN || _la==IDENTIFIER_UC) {
				{
				setState(303);
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
		enterRule(_localctx, 78, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(KWD_DECLARE);
			setState(307);
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
		enterRule(_localctx, 80, RULE_factDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(KWD_ASSERT);
			setState(310);
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
		enterRule(_localctx, 82, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			variableIdentifier();
			setState(313);
			match(ASSIGN);
			setState(314);
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
		enterRule(_localctx, 84, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KWD_TYPE) | (1L << KWD_DECLARE) | (1L << KWD_ASSERT) | (1L << IDENTIFIER_LC))) != 0)) {
				{
				{
				setState(316);
				line();
				setState(317);
				match(SEMICOLON);
				}
				}
				setState(323);
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
		enterRule(_localctx, 86, RULE_line);
		try {
			setState(328);
			switch (_input.LA(1)) {
			case KWD_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				typeDeclaration();
				}
				break;
			case KWD_DECLARE:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				variableDeclaration();
				}
				break;
			case KWD_ASSERT:
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				factDeclaration();
				}
				break;
			case IDENTIFIER_LC:
				enterOuterAlt(_localctx, 4);
				{
				setState(327);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u014d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\5\2\\\n\2\3\2\3\2\3\3\3\3\3\3\5\3c\n\3\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\7\5k\n\5\f\5\16\5n\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5"+
		"\7y\n\7\3\b\3\b\3\b\3\b\3\b\6\b\u0080\n\b\r\b\16\b\u0081\3\b\3\b\3\t\3"+
		"\t\3\t\5\t\u0089\n\t\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u0091\n\13\f\13\16"+
		"\13\u0094\13\13\3\f\3\f\3\f\5\f\u0099\n\f\3\r\3\r\3\r\7\r\u009e\n\r\f"+
		"\r\16\r\u00a1\13\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\7\21\u00ac"+
		"\n\21\f\21\16\21\u00af\13\21\3\22\3\22\3\22\3\22\7\22\u00b5\n\22\f\22"+
		"\16\22\u00b8\13\22\3\23\3\23\3\23\3\23\7\23\u00be\n\23\f\23\16\23\u00c1"+
		"\13\23\3\24\3\24\3\24\5\24\u00c6\n\24\3\25\3\25\3\25\3\25\3\25\3\25\5"+
		"\25\u00ce\n\25\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00d6\n\27\f\27\16\27"+
		"\u00d9\13\27\3\30\3\30\3\30\7\30\u00de\n\30\f\30\16\30\u00e1\13\30\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00eb\n\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3!"+
		"\3!\3!\3!\3\"\3\"\3#\3#\3#\3#\5#\u0109\n#\3#\3#\3$\3$\3$\3$\5$\u0111\n"+
		"$\3%\3%\3%\7%\u0116\n%\f%\16%\u0119\13%\3&\3&\3&\7&\u011e\n&\f&\16&\u0121"+
		"\13&\3\'\5\'\u0124\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u012e\n\'\3"+
		"(\3(\3(\5(\u0133\n(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\7,\u0142\n"+
		",\f,\16,\u0145\13,\3-\3-\3-\3-\5-\u014b\n-\3-\2\2.\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX\2\13\4\2\3\3"+
		"((\3\2\n\13\3\2\f\r\4\2  \"\"\3\2\16\21\3\2\22\23\3\2\36\37\3\2\31\33"+
		"\3\2#$\u0143\2[\3\2\2\2\4b\3\2\2\2\6d\3\2\2\2\bf\3\2\2\2\nq\3\2\2\2\f"+
		"x\3\2\2\2\16z\3\2\2\2\20\u0085\3\2\2\2\22\u008a\3\2\2\2\24\u008d\3\2\2"+
		"\2\26\u0098\3\2\2\2\30\u009a\3\2\2\2\32\u00a2\3\2\2\2\34\u00a4\3\2\2\2"+
		"\36\u00a6\3\2\2\2 \u00a8\3\2\2\2\"\u00b0\3\2\2\2$\u00b9\3\2\2\2&\u00c2"+
		"\3\2\2\2(\u00cd\3\2\2\2*\u00cf\3\2\2\2,\u00d1\3\2\2\2.\u00da\3\2\2\2\60"+
		"\u00e2\3\2\2\2\62\u00ea\3\2\2\2\64\u00ec\3\2\2\2\66\u00f0\3\2\2\28\u00f2"+
		"\3\2\2\2:\u00f6\3\2\2\2<\u00f8\3\2\2\2>\u00fc\3\2\2\2@\u00fe\3\2\2\2B"+
		"\u0102\3\2\2\2D\u0108\3\2\2\2F\u010c\3\2\2\2H\u0112\3\2\2\2J\u011a\3\2"+
		"\2\2L\u0123\3\2\2\2N\u012f\3\2\2\2P\u0134\3\2\2\2R\u0137\3\2\2\2T\u013a"+
		"\3\2\2\2V\u0143\3\2\2\2X\u014a\3\2\2\2Z\\\7\13\2\2[Z\3\2\2\2[\\\3\2\2"+
		"\2\\]\3\2\2\2]^\t\2\2\2^\3\3\2\2\2_c\5\6\4\2`c\5\b\5\2ac\5\n\6\2b_\3\2"+
		"\2\2b`\3\2\2\2ba\3\2\2\2c\5\3\2\2\2de\7)\2\2e\7\3\2\2\2fg\7\6\2\2gl\5"+
		"\4\3\2hi\7\4\2\2ik\5\4\3\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3"+
		"\2\2\2nl\3\2\2\2op\7\7\2\2p\t\3\2\2\2qr\5\6\4\2rs\7\21\2\2st\5\4\3\2t"+
		"u\7\16\2\2u\13\3\2\2\2vy\5\20\t\2wy\5\16\b\2xv\3\2\2\2xw\3\2\2\2y\r\3"+
		"\2\2\2z{\5\6\4\2{|\7\6\2\2|\177\5\26\f\2}~\7\4\2\2~\u0080\5\26\f\2\177"+
		"}\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\7\7\2\2\u0084\17\3\2\2\2\u0085\u0088\7*\2\2"+
		"\u0086\u0087\7\25\2\2\u0087\u0089\5\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\21\3\2\2\2\u008a\u008b\5\4\3\2\u008b\u008c\5\20\t\2\u008c"+
		"\23\3\2\2\2\u008d\u0092\5\22\n\2\u008e\u008f\7\4\2\2\u008f\u0091\5\22"+
		"\n\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\25\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0099\5\f\7"+
		"\2\u0096\u0099\5\36\20\2\u0097\u0099\5*\26\2\u0098\u0095\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\27\3\2\2\2\u009a\u009f\5\26\f"+
		"\2\u009b\u009c\7\4\2\2\u009c\u009e\5\26\f\2\u009d\u009b\3\2\2\2\u009e"+
		"\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\31\3\2\2"+
		"\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\t\3\2\2\u00a3\33\3\2\2\2\u00a4\u00a5"+
		"\t\4\2\2\u00a5\35\3\2\2\2\u00a6\u00a7\5\"\22\2\u00a7\37\3\2\2\2\u00a8"+
		"\u00ad\5\36\20\2\u00a9\u00aa\7\4\2\2\u00aa\u00ac\5\36\20\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"!\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b6\5$\23\2\u00b1\u00b2\5\32\16"+
		"\2\u00b2\u00b3\5$\23\2\u00b3\u00b5\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b5\u00b8"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7#\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b9\u00bf\5&\24\2\u00ba\u00bb\5\34\17\2\u00bb\u00bc\5"+
		"&\24\2\u00bc\u00be\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0%\3\2\2\2\u00c1\u00bf\3\2\2\2"+
		"\u00c2\u00c5\5(\25\2\u00c3\u00c4\7\26\2\2\u00c4\u00c6\5\36\20\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\'\3\2\2\2\u00c7\u00ce\5\f\7\2"+
		"\u00c8\u00ce\5\2\2\2\u00c9\u00ca\7\6\2\2\u00ca\u00cb\5\36\20\2\u00cb\u00cc"+
		"\7\7\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00c7\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd"+
		"\u00c9\3\2\2\2\u00ce)\3\2\2\2\u00cf\u00d0\5,\27\2\u00d0+\3\2\2\2\u00d1"+
		"\u00d7\5.\30\2\u00d2\u00d3\5\60\31\2\u00d3\u00d4\5.\30\2\u00d4\u00d6\3"+
		"\2\2\2\u00d5\u00d2\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8-\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00df\5\62\32"+
		"\2\u00db\u00dc\7!\2\2\u00dc\u00de\5\62\32\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0/\3\2\2\2"+
		"\u00e1\u00df\3\2\2\2\u00e2\u00e3\t\5\2\2\u00e3\61\3\2\2\2\u00e4\u00eb"+
		"\5\f\7\2\u00e5\u00eb\5\64\33\2\u00e6\u00e7\7\6\2\2\u00e7\u00e8\5*\26\2"+
		"\u00e8\u00e9\7\7\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e4\3\2\2\2\u00ea\u00e5"+
		"\3\2\2\2\u00ea\u00e6\3\2\2\2\u00eb\63\3\2\2\2\u00ec\u00ed\7\b\2\2\u00ed"+
		"\u00ee\5\30\r\2\u00ee\u00ef\7\t\2\2\u00ef\65\3\2\2\2\u00f0\u00f1\t\6\2"+
		"\2\u00f1\67\3\2\2\2\u00f2\u00f3\5\36\20\2\u00f3\u00f4\5\66\34\2\u00f4"+
		"\u00f5\5\36\20\2\u00f59\3\2\2\2\u00f6\u00f7\t\7\2\2\u00f7;\3\2\2\2\u00f8"+
		"\u00f9\5\26\f\2\u00f9\u00fa\5:\36\2\u00fa\u00fb\5\26\f\2\u00fb=\3\2\2"+
		"\2\u00fc\u00fd\t\b\2\2\u00fd?\3\2\2\2\u00fe\u00ff\5\26\f\2\u00ff\u0100"+
		"\5> \2\u0100\u0101\5*\26\2\u0101A\3\2\2\2\u0102\u0103\t\t\2\2\u0103C\3"+
		"\2\2\2\u0104\u0105\t\n\2\2\u0105\u0106\5\24\13\2\u0106\u0107\7\5\2\2\u0107"+
		"\u0109\3\2\2\2\u0108\u0104\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u010b\5F$\2\u010bE\3\2\2\2\u010c\u0110\5H%\2\u010d\u010e\5"+
		"B\"\2\u010e\u010f\5H%\2\u010f\u0111\3\2\2\2\u0110\u010d\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111G\3\2\2\2\u0112\u0117\5J&\2\u0113\u0114\7\27\2\2\u0114"+
		"\u0116\5J&\2\u0115\u0113\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2"+
		"\2\u0117\u0118\3\2\2\2\u0118I\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011f"+
		"\5L\'\2\u011b\u011c\7\30\2\2\u011c\u011e\5L\'\2\u011d\u011b\3\2\2\2\u011e"+
		"\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120K\3\2\2\2"+
		"\u0121\u011f\3\2\2\2\u0122\u0124\7\34\2\2\u0123\u0122\3\2\2\2\u0123\u0124"+
		"\3\2\2\2\u0124\u012d\3\2\2\2\u0125\u012e\5\f\7\2\u0126\u012e\5@!\2\u0127"+
		"\u012e\58\35\2\u0128\u012e\5<\37\2\u0129\u012a\7\6\2\2\u012a\u012b\5D"+
		"#\2\u012b\u012c\7\7\2\2\u012c\u012e\3\2\2\2\u012d\u0125\3\2\2\2\u012d"+
		"\u0126\3\2\2\2\u012d\u0127\3\2\2\2\u012d\u0128\3\2\2\2\u012d\u0129\3\2"+
		"\2\2\u012eM\3\2\2\2\u012f\u0130\7%\2\2\u0130\u0132\5\6\4\2\u0131\u0133"+
		"\5\4\3\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2\2\u0133O\3\2\2\2\u0134"+
		"\u0135\7&\2\2\u0135\u0136\5\22\n\2\u0136Q\3\2\2\2\u0137\u0138\7\'\2\2"+
		"\u0138\u0139\5D#\2\u0139S\3\2\2\2\u013a\u013b\5\20\t\2\u013b\u013c\7\24"+
		"\2\2\u013c\u013d\5\26\f\2\u013dU\3\2\2\2\u013e\u013f\5X-\2\u013f\u0140"+
		"\7\35\2\2\u0140\u0142\3\2\2\2\u0141\u013e\3\2\2\2\u0142\u0145\3\2\2\2"+
		"\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144W\3\2\2\2\u0145\u0143\3"+
		"\2\2\2\u0146\u014b\5N(\2\u0147\u014b\5P)\2\u0148\u014b\5R*\2\u0149\u014b"+
		"\5T+\2\u014a\u0146\3\2\2\2\u014a\u0147\3\2\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u0149\3\2\2\2\u014bY\3\2\2\2\34[blx\u0081\u0088\u0092\u0098\u009f\u00ad"+
		"\u00b6\u00bf\u00c5\u00cd\u00d7\u00df\u00ea\u0108\u0110\u0117\u011f\u0123"+
		"\u012d\u0132\u0143\u014a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}