// Generated from FOL.g4 by ANTLR 4.5.1
package z3fol.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LPAREN=2, RPAREN=3, AND=4, OR=5, NOT=6, COLON=7, FORALL=8, EXISTS=9, 
		VARIABLE=10, CONSTANT=11, PREPOSITION=12, WS=13;
	public static final int
		RULE_condition = 0, RULE_formula = 1, RULE_disjunction = 2, RULE_conjunction = 3, 
		RULE_negation = 4, RULE_predicate = 5, RULE_predicateTuple = 6, RULE_term = 7, 
		RULE_function = 8, RULE_functionTuple = 9, RULE_variableDeclaration = 10;
	public static final String[] ruleNames = {
		"condition", "formula", "disjunction", "conjunction", "negation", "predicate", 
		"predicateTuple", "term", "function", "functionTuple", "variableDeclaration"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'('", "')'", "'&'", "'|'", "'!'", "':'", "'Forall'", "'Exists'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "LPAREN", "RPAREN", "AND", "OR", "NOT", "COLON", "FORALL", 
		"EXISTS", "VARIABLE", "CONSTANT", "PREPOSITION", "WS"
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
	public String getGrammarFileName() { return "FOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ConditionContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FOLParser.EOF, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			formula();
			setState(23);
			match(EOF);
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

	public static class FormulaContext extends ParserRuleContext {
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(FOLParser.FORALL, 0); }
		public TerminalNode EXISTS() { return getToken(FOLParser.EXISTS, 0); }
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitFormula(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_la = _input.LA(1);
			if (_la==FORALL || _la==EXISTS) {
				{
				setState(25);
				_la = _input.LA(1);
				if ( !(_la==FORALL || _la==EXISTS) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(26);
				variableDeclaration();
				}
			}

			setState(29);
			disjunction();
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
		public List<TerminalNode> OR() { return getTokens(FOLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(FOLParser.OR, i);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitDisjunction(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_disjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			conjunction();
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(32);
				match(OR);
				setState(33);
				conjunction();
				}
				}
				setState(38);
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
		public List<TerminalNode> AND() { return getTokens(FOLParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(FOLParser.AND, i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitConjunction(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			negation();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(40);
				match(AND);
				setState(41);
				negation();
				}
				}
				setState(46);
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
		public TerminalNode LPAREN() { return getToken(FOLParser.LPAREN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FOLParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(FOLParser.NOT, 0); }
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitNegation(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_negation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(47);
				match(NOT);
				}
			}

			setState(55);
			switch (_input.LA(1)) {
			case PREPOSITION:
				{
				setState(50);
				predicate();
				}
				break;
			case LPAREN:
				{
				setState(51);
				match(LPAREN);
				setState(52);
				formula();
				setState(53);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode PREPOSITION() { return getToken(FOLParser.PREPOSITION, 0); }
		public PredicateTupleContext predicateTuple() {
			return getRuleContext(PredicateTupleContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_predicate);
		try {
			setState(60);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(PREPOSITION);
				setState(58);
				predicateTuple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(PREPOSITION);
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

	public static class PredicateTupleContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(FOLParser.LPAREN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(FOLParser.RPAREN, 0); }
		public PredicateTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateTuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterPredicateTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitPredicateTuple(this);
		}
	}

	public final PredicateTupleContext predicateTuple() throws RecognitionException {
		PredicateTupleContext _localctx = new PredicateTupleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_predicateTuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(LPAREN);
			setState(63);
			term();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(64);
				match(T__0);
				setState(65);
				term();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
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

	public static class TermContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(FOLParser.VARIABLE, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_term);
		try {
			setState(75);
			switch (_input.LA(1)) {
			case CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				function();
				}
				break;
			case VARIABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(VARIABLE);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode CONSTANT() { return getToken(FOLParser.CONSTANT, 0); }
		public FunctionTupleContext functionTuple() {
			return getRuleContext(FunctionTupleContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function);
		try {
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(CONSTANT);
				setState(78);
				functionTuple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(CONSTANT);
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

	public static class FunctionTupleContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(FOLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLParser.RPAREN, 0); }
		public List<TerminalNode> CONSTANT() { return getTokens(FOLParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(FOLParser.CONSTANT, i);
		}
		public List<TerminalNode> VARIABLE() { return getTokens(FOLParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(FOLParser.VARIABLE, i);
		}
		public FunctionTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterFunctionTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitFunctionTuple(this);
		}
	}

	public final FunctionTupleContext functionTuple() throws RecognitionException {
		FunctionTupleContext _localctx = new FunctionTupleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionTuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(LPAREN);
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(84);
				match(T__0);
				setState(85);
				_la = _input.LA(1);
				if ( !(_la==VARIABLE || _la==CONSTANT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(FOLParser.VARIABLE, 0); }
		public TerminalNode COLON() { return getToken(FOLParser.COLON, 0); }
		public TerminalNode CONSTANT() { return getToken(FOLParser.CONSTANT, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(VARIABLE);
			setState(94);
			match(COLON);
			setState(95);
			match(CONSTANT);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17d\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\3\3\3\5\3\36\n\3\3\3\3\3\3\4\3\4\3\4\7\4%\n\4\f\4"+
		"\16\4(\13\4\3\5\3\5\3\5\7\5-\n\5\f\5\16\5\60\13\5\3\6\5\6\63\n\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6:\n\6\3\7\3\7\3\7\5\7?\n\7\3\b\3\b\3\b\3\b\7\bE\n\b"+
		"\f\b\16\bH\13\b\3\b\3\b\3\t\3\t\5\tN\n\t\3\n\3\n\3\n\5\nS\n\n\3\13\3\13"+
		"\3\13\3\13\7\13Y\n\13\f\13\16\13\\\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\4\3\2\n\13\3\2\f\rb\2\30\3\2\2\2\4"+
		"\35\3\2\2\2\6!\3\2\2\2\b)\3\2\2\2\n\62\3\2\2\2\f>\3\2\2\2\16@\3\2\2\2"+
		"\20M\3\2\2\2\22R\3\2\2\2\24T\3\2\2\2\26_\3\2\2\2\30\31\5\4\3\2\31\32\7"+
		"\2\2\3\32\3\3\2\2\2\33\34\t\2\2\2\34\36\5\26\f\2\35\33\3\2\2\2\35\36\3"+
		"\2\2\2\36\37\3\2\2\2\37 \5\6\4\2 \5\3\2\2\2!&\5\b\5\2\"#\7\7\2\2#%\5\b"+
		"\5\2$\"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\7\3\2\2\2(&\3\2\2\2)"+
		".\5\n\6\2*+\7\6\2\2+-\5\n\6\2,*\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2"+
		"\2/\t\3\2\2\2\60.\3\2\2\2\61\63\7\b\2\2\62\61\3\2\2\2\62\63\3\2\2\2\63"+
		"9\3\2\2\2\64:\5\f\7\2\65\66\7\4\2\2\66\67\5\4\3\2\678\7\5\2\28:\3\2\2"+
		"\29\64\3\2\2\29\65\3\2\2\2:\13\3\2\2\2;<\7\16\2\2<?\5\16\b\2=?\7\16\2"+
		"\2>;\3\2\2\2>=\3\2\2\2?\r\3\2\2\2@A\7\4\2\2AF\5\20\t\2BC\7\3\2\2CE\5\20"+
		"\t\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7\5"+
		"\2\2J\17\3\2\2\2KN\5\22\n\2LN\7\f\2\2MK\3\2\2\2ML\3\2\2\2N\21\3\2\2\2"+
		"OP\7\r\2\2PS\5\24\13\2QS\7\r\2\2RO\3\2\2\2RQ\3\2\2\2S\23\3\2\2\2TU\7\4"+
		"\2\2UZ\t\3\2\2VW\7\3\2\2WY\t\3\2\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3"+
		"\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\5\2\2^\25\3\2\2\2_`\7\f\2\2`a\7\t\2\2"+
		"ab\7\r\2\2b\27\3\2\2\2\f\35&.\629>FMRZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}