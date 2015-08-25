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
		T__0=1, T__1=2, LPAREN=3, RPAREN=4, PLUS=5, MINUS=6, TIMES=7, DIV=8, GT=9, 
		GE=10, LE=11, LT=12, EQ=13, POINT=14, POW=15, OR=16, AND=17, IMPLIES=18, 
		IFF=19, XOR=20, NOT=21, SEMICOLON=22, SET_IN=23, SET_NOTIN=24, PLUSEQ=25, 
		MINUSEQ=26, EXISTS=27, FORALL=28, KWD_TYPE=29, KWD_DECLARE=30, KWD_ASSERT=31, 
		NUM_DECIMAL=32, IDENTIFIER_UC=33, IDENTIFIER_LC=34, Whitespace=35, Newline=36, 
		BlockComment=37, LineComment=38;
	public static final int
		RULE_identifier = 0, RULE_identifier_uc = 1, RULE_number = 2, RULE_document = 3, 
		RULE_line = 4, RULE_typeDeclaration = 5, RULE_type = 6, RULE_typeTuple = 7, 
		RULE_typeGeneric = 8, RULE_varDeclaration = 9, RULE_variable = 10, RULE_variableAndType = 11, 
		RULE_variableAndTypeList = 12, RULE_fact = 13, RULE_quantifier = 14, RULE_logic_statement = 15, 
		RULE_disjunction = 16, RULE_conjunction = 17, RULE_negation = 18, RULE_equation = 19, 
		RULE_relop = 20, RULE_logop = 21, RULE_expression = 22, RULE_expression_list = 23, 
		RULE_mulExpression = 24, RULE_powExpression = 25, RULE_atom = 26, RULE_call = 27, 
		RULE_predicate_call = 28, RULE_predicate = 29, RULE_set_theory_statement = 30, 
		RULE_setop = 31, RULE_assignment_op = 32, RULE_instruction = 33;
	public static final String[] ruleNames = {
		"identifier", "identifier_uc", "number", "document", "line", "typeDeclaration", 
		"type", "typeTuple", "typeGeneric", "varDeclaration", "variable", "variableAndType", 
		"variableAndTypeList", "fact", "quantifier", "logic_statement", "disjunction", 
		"conjunction", "negation", "equation", "relop", "logop", "expression", 
		"expression_list", "mulExpression", "powExpression", "atom", "call", "predicate_call", 
		"predicate", "set_theory_statement", "setop", "assignment_op", "instruction"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "':'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'>'", "'>='", 
		"'<='", "'<'", "'='", "'.'", "'^'", "'|'", "'&'", "'=>'", "'<=>'", "'XOR'", 
		"'!'", "';'", "'in'", "'notin'", "'+='", "'-='", "'Exists'", "'Forall'", 
		"'type'", "'declare'", "'assert'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "LPAREN", "RPAREN", "PLUS", "MINUS", "TIMES", "DIV", 
		"GT", "GE", "LE", "LT", "EQ", "POINT", "POW", "OR", "AND", "IMPLIES", 
		"IFF", "XOR", "NOT", "SEMICOLON", "SET_IN", "SET_NOTIN", "PLUSEQ", "MINUSEQ", 
		"EXISTS", "FORALL", "KWD_TYPE", "KWD_DECLARE", "KWD_ASSERT", "NUM_DECIMAL", 
		"IDENTIFIER_UC", "IDENTIFIER_LC", "Whitespace", "Newline", "BlockComment", 
		"LineComment"
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_LC() { return getToken(XPRParser.IDENTIFIER_LC, 0); }
		public TerminalNode IDENTIFIER_UC() { return getToken(XPRParser.IDENTIFIER_UC, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER_UC || _la==IDENTIFIER_LC) ) {
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

	public static class Identifier_ucContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_UC() { return getToken(XPRParser.IDENTIFIER_UC, 0); }
		public Identifier_ucContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier_uc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterIdentifier_uc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitIdentifier_uc(this);
		}
	}

	public final Identifier_ucContext identifier_uc() throws RecognitionException {
		Identifier_ucContext _localctx = new Identifier_ucContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_identifier_uc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
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
		enterRule(_localctx, 4, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(72);
				match(MINUS);
				}
			}

			setState(75);
			match(NUM_DECIMAL);
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
		enterRule(_localctx, 6, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEMICOLON) | (1L << KWD_TYPE) | (1L << KWD_DECLARE) | (1L << KWD_ASSERT) | (1L << IDENTIFIER_UC) | (1L << IDENTIFIER_LC))) != 0)) {
				{
				{
				setState(78);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KWD_TYPE) | (1L << KWD_DECLARE) | (1L << KWD_ASSERT) | (1L << IDENTIFIER_UC) | (1L << IDENTIFIER_LC))) != 0)) {
					{
					setState(77);
					line();
					}
				}

				setState(80);
				match(SEMICOLON);
				}
				}
				setState(85);
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
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
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
		enterRule(_localctx, 8, RULE_line);
		try {
			setState(90);
			switch (_input.LA(1)) {
			case KWD_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				typeDeclaration();
				}
				break;
			case KWD_DECLARE:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				varDeclaration();
				}
				break;
			case KWD_ASSERT:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				fact();
				}
				break;
			case IDENTIFIER_UC:
			case IDENTIFIER_LC:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				instruction();
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

	public static class TypeDeclarationContext extends ParserRuleContext {
		public TerminalNode KWD_TYPE() { return getToken(XPRParser.KWD_TYPE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 10, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(KWD_TYPE);
			setState(93);
			identifier();
			setState(95);
			_la = _input.LA(1);
			if (_la==LPAREN || _la==IDENTIFIER_UC) {
				{
				setState(94);
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

	public static class TypeContext extends ParserRuleContext {
		public Identifier_ucContext identifier_uc() {
			return getRuleContext(Identifier_ucContext.class,0);
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
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				identifier_uc();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				typeTuple();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
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
		enterRule(_localctx, 14, RULE_typeTuple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(LPAREN);
			setState(103);
			type();
			{
			setState(104);
			match(T__0);
			setState(105);
			type();
			}
			setState(107);
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
		public Identifier_ucContext identifier_uc() {
			return getRuleContext(Identifier_ucContext.class,0);
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
		enterRule(_localctx, 16, RULE_typeGeneric);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			identifier_uc();
			setState(110);
			match(LT);
			setState(111);
			type();
			setState(112);
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public TerminalNode KWD_DECLARE() { return getToken(XPRParser.KWD_DECLARE, 0); }
		public VariableAndTypeContext variableAndType() {
			return getRuleContext(VariableAndTypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(KWD_DECLARE);
			setState(115);
			variableAndType();
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 20, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			identifier();
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

	public static class VariableAndTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableAndTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAndType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterVariableAndType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitVariableAndType(this);
		}
	}

	public final VariableAndTypeContext variableAndType() throws RecognitionException {
		VariableAndTypeContext _localctx = new VariableAndTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variableAndType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			type();
			setState(120);
			variable();
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

	public static class VariableAndTypeListContext extends ParserRuleContext {
		public List<VariableAndTypeContext> variableAndType() {
			return getRuleContexts(VariableAndTypeContext.class);
		}
		public VariableAndTypeContext variableAndType(int i) {
			return getRuleContext(VariableAndTypeContext.class,i);
		}
		public VariableAndTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAndTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterVariableAndTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitVariableAndTypeList(this);
		}
	}

	public final VariableAndTypeListContext variableAndTypeList() throws RecognitionException {
		VariableAndTypeListContext _localctx = new VariableAndTypeListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variableAndTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			variableAndType();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(123);
				match(T__0);
				setState(124);
				variableAndType();
				}
				}
				setState(129);
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

	public static class FactContext extends ParserRuleContext {
		public TerminalNode KWD_ASSERT() { return getToken(XPRParser.KWD_ASSERT, 0); }
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterFact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitFact(this);
		}
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(KWD_ASSERT);
			setState(131);
			quantifier();
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

	public static class QuantifierContext extends ParserRuleContext {
		public Logic_statementContext logic_statement() {
			return getRuleContext(Logic_statementContext.class,0);
		}
		public VariableAndTypeListContext variableAndTypeList() {
			return getRuleContext(VariableAndTypeListContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(XPRParser.FORALL, 0); }
		public TerminalNode EXISTS() { return getToken(XPRParser.EXISTS, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_quantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if (_la==EXISTS || _la==FORALL) {
				{
				setState(133);
				_la = _input.LA(1);
				if ( !(_la==EXISTS || _la==FORALL) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(134);
				variableAndTypeList();
				setState(135);
				match(T__1);
				}
			}

			setState(139);
			logic_statement();
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

	public static class Logic_statementContext extends ParserRuleContext {
		public List<DisjunctionContext> disjunction() {
			return getRuleContexts(DisjunctionContext.class);
		}
		public DisjunctionContext disjunction(int i) {
			return getRuleContext(DisjunctionContext.class,i);
		}
		public LogopContext logop() {
			return getRuleContext(LogopContext.class,0);
		}
		public Logic_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterLogic_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitLogic_statement(this);
		}
	}

	public final Logic_statementContext logic_statement() throws RecognitionException {
		Logic_statementContext _localctx = new Logic_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logic_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			disjunction();
			setState(145);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPLIES) | (1L << IFF) | (1L << XOR))) != 0)) {
				{
				setState(142);
				logop();
				setState(143);
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
		enterRule(_localctx, 32, RULE_disjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			conjunction();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(148);
				match(OR);
				setState(149);
				conjunction();
				}
				}
				setState(154);
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
		public List<NegationContext> negation() {
			return getRuleContexts(NegationContext.class);
		}
		public NegationContext negation(int i) {
			return getRuleContext(NegationContext.class,i);
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
		enterRule(_localctx, 34, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			negation();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(156);
				match(AND);
				setState(157);
				negation();
				}
				}
				setState(162);
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

	public static class NegationContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(XPRParser.NOT, 0); }
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitNegation(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_negation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(163);
				match(NOT);
				}
			}

			setState(171);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(166);
				predicate();
				}
				break;
			case 2:
				{
				setState(167);
				match(LPAREN);
				setState(168);
				quantifier();
				setState(169);
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

	public static class EquationContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterEquation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitEquation(this);
		}
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_equation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			expression();
			setState(174);
			relop();
			setState(175);
			expression();
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

	public static class RelopContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(XPRParser.EQ, 0); }
		public TerminalNode GT() { return getToken(XPRParser.GT, 0); }
		public TerminalNode LT() { return getToken(XPRParser.LT, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitRelop(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << EQ))) != 0)) ) {
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
		enterRule(_localctx, 42, RULE_logop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<MulExpressionContext> mulExpression() {
			return getRuleContexts(MulExpressionContext.class);
		}
		public MulExpressionContext mulExpression(int i) {
			return getRuleContext(MulExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(XPRParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(XPRParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(XPRParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(XPRParser.MINUS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			mulExpression();
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(183);
					mulExpression();
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class Expression_listContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterExpression_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitExpression_list(this);
		}
	}

	public final Expression_listContext expression_list() throws RecognitionException {
		Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			expression();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(190);
				match(T__0);
				setState(191);
				expression();
				}
				}
				setState(196);
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

	public static class MulExpressionContext extends ParserRuleContext {
		public List<PowExpressionContext> powExpression() {
			return getRuleContexts(PowExpressionContext.class);
		}
		public PowExpressionContext powExpression(int i) {
			return getRuleContext(PowExpressionContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(XPRParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(XPRParser.TIMES, i);
		}
		public List<TerminalNode> DIV() { return getTokens(XPRParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(XPRParser.DIV, i);
		}
		public MulExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterMulExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitMulExpression(this);
		}
	}

	public final MulExpressionContext mulExpression() throws RecognitionException {
		MulExpressionContext _localctx = new MulExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_mulExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			powExpression();
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(198);
					_la = _input.LA(1);
					if ( !(_la==TIMES || _la==DIV) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(199);
					powExpression();
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class PowExpressionContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode POW() { return getToken(XPRParser.POW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PowExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterPowExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitPowExpression(this);
		}
	}

	public final PowExpressionContext powExpression() throws RecognitionException {
		PowExpressionContext _localctx = new PowExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_powExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			atom();
			setState(208);
			_la = _input.LA(1);
			if (_la==POW) {
				{
				setState(206);
				match(POW);
				setState(207);
				expression();
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

	public static class AtomContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(XPRParser.MINUS, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_atom);
		int _la;
		try {
			setState(220);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(210);
					match(MINUS);
					}
				}

				setState(213);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				match(LPAREN);
				setState(217);
				expression();
				setState(218);
				match(RPAREN);
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

	public static class CallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitCall(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_call);
		try {
			setState(228);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				identifier();
				setState(224);
				match(LPAREN);
				setState(225);
				expression_list();
				setState(226);
				match(RPAREN);
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

	public static class Predicate_callContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public Predicate_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterPredicate_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitPredicate_call(this);
		}
	}

	public final Predicate_callContext predicate_call() throws RecognitionException {
		Predicate_callContext _localctx = new Predicate_callContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_predicate_call);
		try {
			setState(236);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				identifier();
				setState(232);
				match(LPAREN);
				setState(233);
				expression_list();
				setState(234);
				match(RPAREN);
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

	public static class PredicateContext extends ParserRuleContext {
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public Set_theory_statementContext set_theory_statement() {
			return getRuleContext(Set_theory_statementContext.class,0);
		}
		public Predicate_callContext predicate_call() {
			return getRuleContext(Predicate_callContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_predicate);
		try {
			setState(241);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				equation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				set_theory_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				predicate_call();
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

	public static class Set_theory_statementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SetopContext setop() {
			return getRuleContext(SetopContext.class,0);
		}
		public Set_theory_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_theory_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterSet_theory_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitSet_theory_statement(this);
		}
	}

	public final Set_theory_statementContext set_theory_statement() throws RecognitionException {
		Set_theory_statementContext _localctx = new Set_theory_statementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_set_theory_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			expression();
			setState(244);
			setop();
			setState(245);
			expression();
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
		enterRule(_localctx, 62, RULE_setop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
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

	public static class Assignment_opContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(XPRParser.EQ, 0); }
		public TerminalNode PLUSEQ() { return getToken(XPRParser.PLUSEQ, 0); }
		public TerminalNode MINUSEQ() { return getToken(XPRParser.MINUSEQ, 0); }
		public Assignment_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterAssignment_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitAssignment_op(this);
		}
	}

	public final Assignment_opContext assignment_op() throws RecognitionException {
		Assignment_opContext _localctx = new Assignment_opContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_assignment_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << PLUSEQ) | (1L << MINUSEQ))) != 0)) ) {
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

	public static class InstructionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Assignment_opContext assignment_op() {
			return getRuleContext(Assignment_opContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			identifier();
			setState(252);
			assignment_op();
			setState(253);
			expression();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u0102\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\5\4L\n\4\3\4\3\4\3\5\5\5Q\n\5\3"+
		"\5\7\5T\n\5\f\5\16\5W\13\5\3\6\3\6\3\6\3\6\5\6]\n\6\3\7\3\7\3\7\5\7b\n"+
		"\7\3\b\3\b\3\b\5\bg\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\7\16\u0080\n\16\f"+
		"\16\16\16\u0083\13\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u008c\n"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u0094\n\21\3\22\3\22\3\22\7\22"+
		"\u0099\n\22\f\22\16\22\u009c\13\22\3\23\3\23\3\23\7\23\u00a1\n\23\f\23"+
		"\16\23\u00a4\13\23\3\24\5\24\u00a7\n\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u00ae\n\24\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\7\30"+
		"\u00bb\n\30\f\30\16\30\u00be\13\30\3\31\3\31\3\31\7\31\u00c3\n\31\f\31"+
		"\16\31\u00c6\13\31\3\32\3\32\3\32\7\32\u00cb\n\32\f\32\16\32\u00ce\13"+
		"\32\3\33\3\33\3\33\5\33\u00d3\n\33\3\34\5\34\u00d6\n\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u00df\n\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u00e7\n\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00ef\n\36\3\37\3\37\3"+
		"\37\5\37\u00f4\n\37\3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\2\2$\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\n\3"+
		"\2#$\3\2\35\36\4\2\13\13\16\17\3\2\24\26\3\2\7\b\3\2\t\n\3\2\31\32\4\2"+
		"\17\17\33\34\u00fb\2F\3\2\2\2\4H\3\2\2\2\6K\3\2\2\2\bU\3\2\2\2\n\\\3\2"+
		"\2\2\f^\3\2\2\2\16f\3\2\2\2\20h\3\2\2\2\22o\3\2\2\2\24t\3\2\2\2\26w\3"+
		"\2\2\2\30y\3\2\2\2\32|\3\2\2\2\34\u0084\3\2\2\2\36\u008b\3\2\2\2 \u008f"+
		"\3\2\2\2\"\u0095\3\2\2\2$\u009d\3\2\2\2&\u00a6\3\2\2\2(\u00af\3\2\2\2"+
		"*\u00b3\3\2\2\2,\u00b5\3\2\2\2.\u00b7\3\2\2\2\60\u00bf\3\2\2\2\62\u00c7"+
		"\3\2\2\2\64\u00cf\3\2\2\2\66\u00de\3\2\2\28\u00e6\3\2\2\2:\u00ee\3\2\2"+
		"\2<\u00f3\3\2\2\2>\u00f5\3\2\2\2@\u00f9\3\2\2\2B\u00fb\3\2\2\2D\u00fd"+
		"\3\2\2\2FG\t\2\2\2G\3\3\2\2\2HI\7#\2\2I\5\3\2\2\2JL\7\b\2\2KJ\3\2\2\2"+
		"KL\3\2\2\2LM\3\2\2\2MN\7\"\2\2N\7\3\2\2\2OQ\5\n\6\2PO\3\2\2\2PQ\3\2\2"+
		"\2QR\3\2\2\2RT\7\30\2\2SP\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\t\3\2"+
		"\2\2WU\3\2\2\2X]\5\f\7\2Y]\5\24\13\2Z]\5\34\17\2[]\5D#\2\\X\3\2\2\2\\"+
		"Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]\13\3\2\2\2^_\7\37\2\2_a\5\2\2\2`b\5\16"+
		"\b\2a`\3\2\2\2ab\3\2\2\2b\r\3\2\2\2cg\5\4\3\2dg\5\20\t\2eg\5\22\n\2fc"+
		"\3\2\2\2fd\3\2\2\2fe\3\2\2\2g\17\3\2\2\2hi\7\5\2\2ij\5\16\b\2jk\7\3\2"+
		"\2kl\5\16\b\2lm\3\2\2\2mn\7\6\2\2n\21\3\2\2\2op\5\4\3\2pq\7\16\2\2qr\5"+
		"\16\b\2rs\7\13\2\2s\23\3\2\2\2tu\7 \2\2uv\5\30\r\2v\25\3\2\2\2wx\5\2\2"+
		"\2x\27\3\2\2\2yz\5\16\b\2z{\5\26\f\2{\31\3\2\2\2|\u0081\5\30\r\2}~\7\3"+
		"\2\2~\u0080\5\30\r\2\177}\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\33\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085"+
		"\7!\2\2\u0085\u0086\5\36\20\2\u0086\35\3\2\2\2\u0087\u0088\t\3\2\2\u0088"+
		"\u0089\5\32\16\2\u0089\u008a\7\4\2\2\u008a\u008c\3\2\2\2\u008b\u0087\3"+
		"\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\5 \21\2\u008e"+
		"\37\3\2\2\2\u008f\u0093\5\"\22\2\u0090\u0091\5,\27\2\u0091\u0092\5\"\22"+
		"\2\u0092\u0094\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0094\3\2\2\2\u0094!"+
		"\3\2\2\2\u0095\u009a\5$\23\2\u0096\u0097\7\22\2\2\u0097\u0099\5$\23\2"+
		"\u0098\u0096\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b"+
		"\3\2\2\2\u009b#\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u00a2\5&\24\2\u009e"+
		"\u009f\7\23\2\2\u009f\u00a1\5&\24\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3"+
		"\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3%\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a7\7\27\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2"+
		"\u00a7\u00ad\3\2\2\2\u00a8\u00ae\5<\37\2\u00a9\u00aa\7\5\2\2\u00aa\u00ab"+
		"\5\36\20\2\u00ab\u00ac\7\6\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a8\3\2\2\2"+
		"\u00ad\u00a9\3\2\2\2\u00ae\'\3\2\2\2\u00af\u00b0\5.\30\2\u00b0\u00b1\5"+
		"*\26\2\u00b1\u00b2\5.\30\2\u00b2)\3\2\2\2\u00b3\u00b4\t\4\2\2\u00b4+\3"+
		"\2\2\2\u00b5\u00b6\t\5\2\2\u00b6-\3\2\2\2\u00b7\u00bc\5\62\32\2\u00b8"+
		"\u00b9\t\6\2\2\u00b9\u00bb\5\62\32\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3"+
		"\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd/\3\2\2\2\u00be\u00bc"+
		"\3\2\2\2\u00bf\u00c4\5.\30\2\u00c0\u00c1\7\3\2\2\u00c1\u00c3\5.\30\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\61\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00cc\5\64\33\2\u00c8"+
		"\u00c9\t\7\2\2\u00c9\u00cb\5\64\33\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3"+
		"\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\63\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00d2\5\66\34\2\u00d0\u00d1\7\21\2\2\u00d1\u00d3"+
		"\5.\30\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\65\3\2\2\2\u00d4"+
		"\u00d6\7\b\2\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00df\5\26\f\2\u00d8\u00df\5\6\4\2\u00d9\u00df\58\35\2\u00da"+
		"\u00db\7\5\2\2\u00db\u00dc\5.\30\2\u00dc\u00dd\7\6\2\2\u00dd\u00df\3\2"+
		"\2\2\u00de\u00d5\3\2\2\2\u00de\u00d8\3\2\2\2\u00de\u00d9\3\2\2\2\u00de"+
		"\u00da\3\2\2\2\u00df\67\3\2\2\2\u00e0\u00e7\5\2\2\2\u00e1\u00e2\5\2\2"+
		"\2\u00e2\u00e3\7\5\2\2\u00e3\u00e4\5\60\31\2\u00e4\u00e5\7\6\2\2\u00e5"+
		"\u00e7\3\2\2\2\u00e6\u00e0\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e79\3\2\2\2"+
		"\u00e8\u00ef\5\2\2\2\u00e9\u00ea\5\2\2\2\u00ea\u00eb\7\5\2\2\u00eb\u00ec"+
		"\5\60\31\2\u00ec\u00ed\7\6\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00e8\3\2\2\2"+
		"\u00ee\u00e9\3\2\2\2\u00ef;\3\2\2\2\u00f0\u00f4\5(\25\2\u00f1\u00f4\5"+
		"> \2\u00f2\u00f4\5:\36\2\u00f3\u00f0\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f2\3\2\2\2\u00f4=\3\2\2\2\u00f5\u00f6\5.\30\2\u00f6\u00f7\5@!\2\u00f7"+
		"\u00f8\5.\30\2\u00f8?\3\2\2\2\u00f9\u00fa\t\b\2\2\u00faA\3\2\2\2\u00fb"+
		"\u00fc\t\t\2\2\u00fcC\3\2\2\2\u00fd\u00fe\5\2\2\2\u00fe\u00ff\5B\"\2\u00ff"+
		"\u0100\5.\30\2\u0100E\3\2\2\2\30KPU\\af\u0081\u008b\u0093\u009a\u00a2"+
		"\u00a6\u00ad\u00bc\u00c4\u00cc\u00d2\u00d5\u00de\u00e6\u00ee\u00f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}