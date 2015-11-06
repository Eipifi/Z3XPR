// Generated from /Users/eipifi/Sources/z3fol/src/main/java/eipifi/xpr/lang/XPR.g4 by ANTLR 4.5.1
package eipifi.xpr.lang;
package eipifi.xpr.lang;
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
		LPAREN=1, RPAREN=2, LBRACKET=3, RBRACKET=4, PLUS=5, MINUS=6, TIMES=7, 
		DIV=8, GT=9, GE=10, LE=11, LT=12, EQ=13, NEQ=14, ASSIGN=15, DOT=16, COMMA=17, 
		POW=18, OR=19, AND=20, IMPLIES=21, IFF=22, XOR=23, NOT=24, COLON=25, SEMICOLON=26, 
		SET_IN=27, SET_NOTIN=28, SET_UNION=29, SET_INTERSECT=30, SET_DIFF=31, 
		SET_SUB=32, EXISTS=33, FORALL=34, KWD_TYPE=35, KWD_ASSERT=36, KWD_TRUE=37, 
		KWD_FALSE=38, NUM_DECIMAL=39, IDENTIFIER=40, Whitespace=41, Newline=42, 
		BlockComment=43, LineComment=44;
	public static final int
		RULE_id = 0, RULE_num = 1, RULE_declarationList = 2, RULE_declaration = 3, 
		RULE_type = 4, RULE_arithExpr = 5, RULE_boolExpr = 6, RULE_equality = 7, 
		RULE_comparison = 8, RULE_membership = 9, RULE_quantifiedExpr = 10, RULE_arrayExpr = 11, 
		RULE_inlineSet = 12, RULE_expr = 13, RULE_document = 14;
	public static final String[] ruleNames = {
		"id", "num", "declarationList", "declaration", "type", "arithExpr", "boolExpr", 
		"equality", "comparison", "membership", "quantifiedExpr", "arrayExpr", 
		"inlineSet", "expr", "document"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'>'", "'>='", 
		"'<='", "'<'", "'=='", "'!='", "'='", "'.'", "','", "'^'", "'|'", "'&'", 
		"'=>'", "'<=>'", "'XOR'", "'!'", "':'", "';'", "'in'", "'notin'", "'∪'", 
		"'∩'", "'\\'", "'⊂'", "'exists'", "'forall'", "'type'", "'assert'", "'true'", 
		"'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "PLUS", "MINUS", "TIMES", 
		"DIV", "GT", "GE", "LE", "LT", "EQ", "NEQ", "ASSIGN", "DOT", "COMMA", 
		"POW", "OR", "AND", "IMPLIES", "IFF", "XOR", "NOT", "COLON", "SEMICOLON", 
		"SET_IN", "SET_NOTIN", "SET_UNION", "SET_INTERSECT", "SET_DIFF", "SET_SUB", 
		"EXISTS", "FORALL", "KWD_TYPE", "KWD_ASSERT", "KWD_TRUE", "KWD_FALSE", 
		"NUM_DECIMAL", "IDENTIFIER", "Whitespace", "Newline", "BlockComment", 
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
	public static class IdContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(XPRParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(XPRParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(XPRParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(XPRParser.DOT, i);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_id);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(IDENTIFIER);
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					match(DOT);
					setState(32);
					match(IDENTIFIER);
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class NumContext extends ParserRuleContext {
		public TerminalNode NUM_DECIMAL() { return getToken(XPRParser.NUM_DECIMAL, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
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

	public static class DeclarationListContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPRParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPRParser.COMMA, i);
		}
		public DeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationListContext declarationList() throws RecognitionException {
		DeclarationListContext _localctx = new DeclarationListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			declaration();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(41);
				match(COMMA);
				setState(42);
				declaration();
				}
				}
				setState(47);
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

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			type();
			setState(49);
			id();
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
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			id();
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

	public static class ArithExprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TerminalNode POW() { return getToken(XPRParser.POW, 0); }
		public TerminalNode TIMES() { return getToken(XPRParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(XPRParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(XPRParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(XPRParser.MINUS, 0); }
		public ArithExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithExprContext arithExpr() throws RecognitionException {
		return arithExpr(0);
	}

	private ArithExprContext arithExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithExprContext _localctx = new ArithExprContext(_ctx, _parentState);
		ArithExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_arithExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(54);
				match(LPAREN);
				setState(55);
				arithExpr(0);
				setState(56);
				match(RPAREN);
				}
				break;
			case IDENTIFIER:
				{
				setState(58);
				id();
				}
				break;
			case NUM_DECIMAL:
				{
				setState(59);
				num();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(77);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ArithExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
						setState(62);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(63);
						match(POW);
						setState(64);
						arithExpr(8);
						}
						break;
					case 2:
						{
						_localctx = new ArithExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
						setState(65);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(66);
						match(TIMES);
						setState(67);
						arithExpr(7);
						}
						break;
					case 3:
						{
						_localctx = new ArithExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
						setState(68);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(69);
						match(DIV);
						setState(70);
						arithExpr(6);
						}
						break;
					case 4:
						{
						_localctx = new ArithExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
						setState(71);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(72);
						match(PLUS);
						setState(73);
						arithExpr(5);
						}
						break;
					case 5:
						{
						_localctx = new ArithExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
						setState(74);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(75);
						match(MINUS);
						setState(76);
						arithExpr(4);
						}
						break;
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BoolExprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public List<BoolExprContext> boolExpr() {
			return getRuleContexts(BoolExprContext.class);
		}
		public BoolExprContext boolExpr(int i) {
			return getRuleContext(BoolExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode KWD_TRUE() { return getToken(XPRParser.KWD_TRUE, 0); }
		public TerminalNode KWD_FALSE() { return getToken(XPRParser.KWD_FALSE, 0); }
		public MembershipContext membership() {
			return getRuleContext(MembershipContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public QuantifiedExprContext quantifiedExpr() {
			return getRuleContext(QuantifiedExprContext.class,0);
		}
		public TerminalNode IFF() { return getToken(XPRParser.IFF, 0); }
		public TerminalNode XOR() { return getToken(XPRParser.XOR, 0); }
		public TerminalNode IMPLIES() { return getToken(XPRParser.IMPLIES, 0); }
		public TerminalNode AND() { return getToken(XPRParser.AND, 0); }
		public TerminalNode OR() { return getToken(XPRParser.OR, 0); }
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		return boolExpr(0);
	}

	private BoolExprContext boolExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolExprContext _localctx = new BoolExprContext(_ctx, _parentState);
		BoolExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_boolExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(83);
				match(LPAREN);
				setState(84);
				boolExpr(0);
				setState(85);
				match(RPAREN);
				}
				break;
			case 2:
				{
				setState(87);
				id();
				}
				break;
			case 3:
				{
				setState(88);
				_la = _input.LA(1);
				if ( !(_la==KWD_TRUE || _la==KWD_FALSE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 4:
				{
				setState(89);
				membership();
				}
				break;
			case 5:
				{
				setState(90);
				comparison();
				}
				break;
			case 6:
				{
				setState(91);
				equality();
				}
				break;
			case 7:
				{
				setState(92);
				quantifiedExpr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(110);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new BoolExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
						setState(95);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(96);
						match(IFF);
						setState(97);
						boolExpr(12);
						}
						break;
					case 2:
						{
						_localctx = new BoolExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
						setState(98);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(99);
						match(XOR);
						setState(100);
						boolExpr(11);
						}
						break;
					case 3:
						{
						_localctx = new BoolExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
						setState(101);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(102);
						match(IMPLIES);
						setState(103);
						boolExpr(10);
						}
						break;
					case 4:
						{
						_localctx = new BoolExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
						setState(104);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(105);
						match(AND);
						setState(106);
						boolExpr(9);
						}
						break;
					case 5:
						{
						_localctx = new BoolExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
						setState(107);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(108);
						match(OR);
						setState(109);
						boolExpr(8);
						}
						break;
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(XPRParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(XPRParser.NEQ, 0); }
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			expr();
			setState(116);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==NEQ) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(117);
			expr();
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public TerminalNode LE() { return getToken(XPRParser.LE, 0); }
		public TerminalNode GE() { return getToken(XPRParser.GE, 0); }
		public TerminalNode LT() { return getToken(XPRParser.LT, 0); }
		public TerminalNode GT() { return getToken(XPRParser.GT, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			arithExpr(0);
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LE) | (1L << LT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(121);
			arithExpr(0);
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

	public static class MembershipContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SET_IN() { return getToken(XPRParser.SET_IN, 0); }
		public ArrayExprContext arrayExpr() {
			return getRuleContext(ArrayExprContext.class,0);
		}
		public MembershipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_membership; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterMembership(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitMembership(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitMembership(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MembershipContext membership() throws RecognitionException {
		MembershipContext _localctx = new MembershipContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_membership);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			expr();
			setState(124);
			match(SET_IN);
			setState(125);
			arrayExpr(0);
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

	public static class QuantifiedExprContext extends ParserRuleContext {
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(XPRParser.COLON, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(XPRParser.FORALL, 0); }
		public TerminalNode EXISTS() { return getToken(XPRParser.EXISTS, 0); }
		public QuantifiedExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifiedExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterQuantifiedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitQuantifiedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitQuantifiedExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifiedExprContext quantifiedExpr() throws RecognitionException {
		QuantifiedExprContext _localctx = new QuantifiedExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_quantifiedExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !(_la==EXISTS || _la==FORALL) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(128);
			declarationList();
			setState(129);
			match(COLON);
			setState(130);
			boolExpr(0);
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

	public static class ArrayExprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public List<ArrayExprContext> arrayExpr() {
			return getRuleContexts(ArrayExprContext.class);
		}
		public ArrayExprContext arrayExpr(int i) {
			return getRuleContext(ArrayExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public InlineSetContext inlineSet() {
			return getRuleContext(InlineSetContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode SET_INTERSECT() { return getToken(XPRParser.SET_INTERSECT, 0); }
		public TerminalNode SET_UNION() { return getToken(XPRParser.SET_UNION, 0); }
		public TerminalNode SET_DIFF() { return getToken(XPRParser.SET_DIFF, 0); }
		public ArrayExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExprContext arrayExpr() throws RecognitionException {
		return arrayExpr(0);
	}

	private ArrayExprContext arrayExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArrayExprContext _localctx = new ArrayExprContext(_ctx, _parentState);
		ArrayExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_arrayExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(133);
				match(LPAREN);
				setState(134);
				arrayExpr(0);
				setState(135);
				match(RPAREN);
				}
				break;
			case LBRACKET:
				{
				setState(137);
				inlineSet();
				}
				break;
			case IDENTIFIER:
				{
				setState(138);
				id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(150);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ArrayExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arrayExpr);
						setState(141);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(142);
						match(SET_INTERSECT);
						setState(143);
						arrayExpr(6);
						}
						break;
					case 2:
						{
						_localctx = new ArrayExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arrayExpr);
						setState(144);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(145);
						match(SET_UNION);
						setState(146);
						arrayExpr(5);
						}
						break;
					case 3:
						{
						_localctx = new ArrayExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arrayExpr);
						setState(147);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(148);
						match(SET_DIFF);
						setState(149);
						arrayExpr(4);
						}
						break;
					}
					} 
				}
				setState(154);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InlineSetContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(XPRParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(XPRParser.RBRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPRParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPRParser.COMMA, i);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitInlineSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineSetContext inlineSet() throws RecognitionException {
		InlineSetContext _localctx = new InlineSetContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_inlineSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(LBRACKET);
			setState(164);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << NUM_DECIMAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(156);
				expr();
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(157);
					match(COMMA);
					setState(158);
					expr();
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(166);
			match(RBRACKET);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(XPRParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XPRParser.RPAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPRListener ) ((XPRListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(LPAREN);
				setState(169);
				expr();
				setState(170);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				num();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				arithExpr(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				match(LPAREN);
				setState(176);
				boolExpr(0);
				setState(177);
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

	public static class DocumentContext extends ParserRuleContext {
		public List<BoolExprContext> boolExpr() {
			return getRuleContexts(BoolExprContext.class);
		}
		public BoolExprContext boolExpr(int i) {
			return getRuleContext(BoolExprContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPRVisitor ) return ((XPRVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << EXISTS) | (1L << FORALL) | (1L << KWD_TRUE) | (1L << KWD_FALSE) | (1L << NUM_DECIMAL) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(181);
				boolExpr(0);
				}
				}
				setState(186);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return arithExpr_sempred((ArithExprContext)_localctx, predIndex);
		case 6:
			return boolExpr_sempred((BoolExprContext)_localctx, predIndex);
		case 11:
			return arrayExpr_sempred((ArrayExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithExpr_sempred(ArithExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean boolExpr_sempred(BoolExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		}
		return true;
	}
	private boolean arrayExpr_sempred(ArrayExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u00be\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\7\2$\n\2"+
		"\f\2\16\2\'\13\2\3\3\3\3\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\5\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7?\n\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7P\n\7\f\7\16\7S\13\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b`\n\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bq\n\b\f\b\16\bt\13\b\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u008e\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u0099\n\r\f\r\16\r\u009c\13\r\3\16\3\16\3\16\3\16\7\16\u00a2\n"+
		"\16\f\16\16\16\u00a5\13\16\5\16\u00a7\n\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b6\n\17\3\20\7\20\u00b9"+
		"\n\20\f\20\16\20\u00bc\13\20\3\20\2\5\f\16\30\21\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36\2\6\3\2\'(\3\2\17\20\3\2\13\16\3\2#$\u00ce\2 \3\2\2"+
		"\2\4(\3\2\2\2\6*\3\2\2\2\b\62\3\2\2\2\n\65\3\2\2\2\f>\3\2\2\2\16_\3\2"+
		"\2\2\20u\3\2\2\2\22y\3\2\2\2\24}\3\2\2\2\26\u0081\3\2\2\2\30\u008d\3\2"+
		"\2\2\32\u009d\3\2\2\2\34\u00b5\3\2\2\2\36\u00ba\3\2\2\2 %\7*\2\2!\"\7"+
		"\22\2\2\"$\7*\2\2#!\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2"+
		"\'%\3\2\2\2()\7)\2\2)\5\3\2\2\2*/\5\b\5\2+,\7\23\2\2,.\5\b\5\2-+\3\2\2"+
		"\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\7\3\2\2\2\61/\3\2\2\2\62\63\5"+
		"\n\6\2\63\64\5\2\2\2\64\t\3\2\2\2\65\66\5\2\2\2\66\13\3\2\2\2\678\b\7"+
		"\1\289\7\3\2\29:\5\f\7\2:;\7\4\2\2;?\3\2\2\2<?\5\2\2\2=?\5\4\3\2>\67\3"+
		"\2\2\2><\3\2\2\2>=\3\2\2\2?Q\3\2\2\2@A\f\t\2\2AB\7\24\2\2BP\5\f\7\nCD"+
		"\f\b\2\2DE\7\t\2\2EP\5\f\7\tFG\f\7\2\2GH\7\n\2\2HP\5\f\7\bIJ\f\6\2\2J"+
		"K\7\7\2\2KP\5\f\7\7LM\f\5\2\2MN\7\b\2\2NP\5\f\7\6O@\3\2\2\2OC\3\2\2\2"+
		"OF\3\2\2\2OI\3\2\2\2OL\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\r\3\2\2"+
		"\2SQ\3\2\2\2TU\b\b\1\2UV\7\3\2\2VW\5\16\b\2WX\7\4\2\2X`\3\2\2\2Y`\5\2"+
		"\2\2Z`\t\2\2\2[`\5\24\13\2\\`\5\22\n\2]`\5\20\t\2^`\5\26\f\2_T\3\2\2\2"+
		"_Y\3\2\2\2_Z\3\2\2\2_[\3\2\2\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2\2`r\3\2\2"+
		"\2ab\f\r\2\2bc\7\30\2\2cq\5\16\b\16de\f\f\2\2ef\7\31\2\2fq\5\16\b\rgh"+
		"\f\13\2\2hi\7\27\2\2iq\5\16\b\fjk\f\n\2\2kl\7\26\2\2lq\5\16\b\13mn\f\t"+
		"\2\2no\7\25\2\2oq\5\16\b\npa\3\2\2\2pd\3\2\2\2pg\3\2\2\2pj\3\2\2\2pm\3"+
		"\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\17\3\2\2\2tr\3\2\2\2uv\5\34\17\2"+
		"vw\t\3\2\2wx\5\34\17\2x\21\3\2\2\2yz\5\f\7\2z{\t\4\2\2{|\5\f\7\2|\23\3"+
		"\2\2\2}~\5\34\17\2~\177\7\35\2\2\177\u0080\5\30\r\2\u0080\25\3\2\2\2\u0081"+
		"\u0082\t\5\2\2\u0082\u0083\5\6\4\2\u0083\u0084\7\33\2\2\u0084\u0085\5"+
		"\16\b\2\u0085\27\3\2\2\2\u0086\u0087\b\r\1\2\u0087\u0088\7\3\2\2\u0088"+
		"\u0089\5\30\r\2\u0089\u008a\7\4\2\2\u008a\u008e\3\2\2\2\u008b\u008e\5"+
		"\32\16\2\u008c\u008e\5\2\2\2\u008d\u0086\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008c\3\2\2\2\u008e\u009a\3\2\2\2\u008f\u0090\f\7\2\2\u0090\u0091\7 "+
		"\2\2\u0091\u0099\5\30\r\b\u0092\u0093\f\6\2\2\u0093\u0094\7\37\2\2\u0094"+
		"\u0099\5\30\r\7\u0095\u0096\f\5\2\2\u0096\u0097\7!\2\2\u0097\u0099\5\30"+
		"\r\6\u0098\u008f\3\2\2\2\u0098\u0092\3\2\2\2\u0098\u0095\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\31\3\2\2"+
		"\2\u009c\u009a\3\2\2\2\u009d\u00a6\7\5\2\2\u009e\u00a3\5\34\17\2\u009f"+
		"\u00a0\7\23\2\2\u00a0\u00a2\5\34\17\2\u00a1\u009f\3\2\2\2\u00a2\u00a5"+
		"\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u009e\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00a9\7\6\2\2\u00a9\33\3\2\2\2\u00aa\u00ab\7\3\2\2\u00ab\u00ac"+
		"\5\34\17\2\u00ac\u00ad\7\4\2\2\u00ad\u00b6\3\2\2\2\u00ae\u00b6\5\2\2\2"+
		"\u00af\u00b6\5\4\3\2\u00b0\u00b6\5\f\7\2\u00b1\u00b2\7\3\2\2\u00b2\u00b3"+
		"\5\16\b\2\u00b3\u00b4\7\4\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00aa\3\2\2\2"+
		"\u00b5\u00ae\3\2\2\2\u00b5\u00af\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b5\u00b1"+
		"\3\2\2\2\u00b6\35\3\2\2\2\u00b7\u00b9\5\16\b\2\u00b8\u00b7\3\2\2\2\u00b9"+
		"\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\37\3\2\2"+
		"\2\u00bc\u00ba\3\2\2\2\21%/>OQ_pr\u008d\u0098\u009a\u00a3\u00a6\u00b5"+
		"\u00ba";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}