// Generated from Lispy.g4 by ANTLR 4.5.1
package eipifi.lispy.lang;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LispyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, Whitespace=3, Newline=4, BlockComment=5, LineComment=6, 
		ATOM=7;
	public static final int
		RULE_atom = 0, RULE_par = 1, RULE_document = 2;
	public static final String[] ruleNames = {
		"atom", "par", "document"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "Whitespace", "Newline", "BlockComment", "LineComment", 
		"ATOM"
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
	public String getGrammarFileName() { return "Lispy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LispyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(LispyParser.ATOM, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LispyListener ) ((LispyListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LispyListener ) ((LispyListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			match(ATOM);
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

	public static class ParContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(LispyParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LispyParser.RPAREN, 0); }
		public List<ParContext> par() {
			return getRuleContexts(ParContext.class);
		}
		public ParContext par(int i) {
			return getRuleContext(ParContext.class,i);
		}
		public ParContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_par; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LispyListener ) ((LispyListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LispyListener ) ((LispyListener)listener).exitPar(this);
		}
	}

	public final ParContext par() throws RecognitionException {
		ParContext _localctx = new ParContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_par);
		int _la;
		try {
			setState(19);
			switch (_input.LA(1)) {
			case ATOM:
				enterOuterAlt(_localctx, 1);
				{
				setState(8);
				atom();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(9);
				match(LPAREN);
				setState(10);
				atom();
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LPAREN || _la==ATOM) {
					{
					{
					setState(11);
					par();
					}
					}
					setState(16);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(17);
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

	public static class DocumentContext extends ParserRuleContext {
		public List<ParContext> par() {
			return getRuleContexts(ParContext.class);
		}
		public ParContext par(int i) {
			return getRuleContext(ParContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LispyListener ) ((LispyListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LispyListener ) ((LispyListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LPAREN || _la==ATOM) {
				{
				{
				setState(21);
				par();
				}
				}
				setState(26);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t\36\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\3\3\3\3\3\3\3\7\3\17\n\3\f\3\16\3\22\13\3\3\3\3"+
		"\3\5\3\26\n\3\3\4\7\4\31\n\4\f\4\16\4\34\13\4\3\4\2\2\5\2\4\6\2\2\35\2"+
		"\b\3\2\2\2\4\25\3\2\2\2\6\32\3\2\2\2\b\t\7\t\2\2\t\3\3\2\2\2\n\26\5\2"+
		"\2\2\13\f\7\3\2\2\f\20\5\2\2\2\r\17\5\4\3\2\16\r\3\2\2\2\17\22\3\2\2\2"+
		"\20\16\3\2\2\2\20\21\3\2\2\2\21\23\3\2\2\2\22\20\3\2\2\2\23\24\7\4\2\2"+
		"\24\26\3\2\2\2\25\n\3\2\2\2\25\13\3\2\2\2\26\5\3\2\2\2\27\31\5\4\3\2\30"+
		"\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\7\3\2\2\2\34"+
		"\32\3\2\2\2\5\20\25\32";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}