// Generated from XPR.g4 by ANTLR 4.5.1
package z3fol.xpr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XPRLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, LPAREN=3, RPAREN=4, PLUS=5, MINUS=6, TIMES=7, MOD=8, DIV=9, 
		GT=10, LT=11, EQ=12, POINT=13, POW=14, EXISTS=15, FORALL=16, OR=17, AND=18, 
		NOT=19, NUM_DECIMAL=20, IDENTIFIER=21, WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "LPAREN", "RPAREN", "PLUS", "MINUS", "TIMES", "MOD", "DIV", 
		"GT", "LT", "EQ", "POINT", "POW", "EXISTS", "FORALL", "OR", "AND", "NOT", 
		"NUM_DECIMAL", "IDENTIFIER", "SPACE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "':'", "'('", "')'", "'+'", "'-'", "'*'", "'%'", "'/'", "'>'", 
		"'<'", "'='", "'.'", "'^'", "'Exists'", "'Forall'", "'|'", "'&'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "LPAREN", "RPAREN", "PLUS", "MINUS", "TIMES", "MOD", 
		"DIV", "GT", "LT", "EQ", "POINT", "POW", "EXISTS", "FORALL", "OR", "AND", 
		"NOT", "NUM_DECIMAL", "IDENTIFIER", "WS"
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


	public XPRLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XPR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\6\25d\n\25\r\25\16\25e\3\25\5\25i\n\25\3\26\3\26\7\26m\n\26"+
		"\f\26\16\26p\13\26\3\27\3\27\3\30\6\30u\n\30\r\30\16\30v\3\30\3\30\2\2"+
		"\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\2/\30\3\2\7\3\2\63;\3\2\62;\5\2\62"+
		";aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"|\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2"+
		"\t\67\3\2\2\2\139\3\2\2\2\r;\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23A\3\2\2"+
		"\2\25C\3\2\2\2\27E\3\2\2\2\31G\3\2\2\2\33I\3\2\2\2\35K\3\2\2\2\37M\3\2"+
		"\2\2!T\3\2\2\2#[\3\2\2\2%]\3\2\2\2\'_\3\2\2\2)h\3\2\2\2+j\3\2\2\2-q\3"+
		"\2\2\2/t\3\2\2\2\61\62\7.\2\2\62\4\3\2\2\2\63\64\7<\2\2\64\6\3\2\2\2\65"+
		"\66\7*\2\2\66\b\3\2\2\2\678\7+\2\28\n\3\2\2\29:\7-\2\2:\f\3\2\2\2;<\7"+
		"/\2\2<\16\3\2\2\2=>\7,\2\2>\20\3\2\2\2?@\7\'\2\2@\22\3\2\2\2AB\7\61\2"+
		"\2B\24\3\2\2\2CD\7@\2\2D\26\3\2\2\2EF\7>\2\2F\30\3\2\2\2GH\7?\2\2H\32"+
		"\3\2\2\2IJ\7\60\2\2J\34\3\2\2\2KL\7`\2\2L\36\3\2\2\2MN\7G\2\2NO\7z\2\2"+
		"OP\7k\2\2PQ\7u\2\2QR\7v\2\2RS\7u\2\2S \3\2\2\2TU\7H\2\2UV\7q\2\2VW\7t"+
		"\2\2WX\7c\2\2XY\7n\2\2YZ\7n\2\2Z\"\3\2\2\2[\\\7~\2\2\\$\3\2\2\2]^\7(\2"+
		"\2^&\3\2\2\2_`\7#\2\2`(\3\2\2\2ac\t\2\2\2bd\t\3\2\2cb\3\2\2\2de\3\2\2"+
		"\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2gi\7\62\2\2ha\3\2\2\2hg\3\2\2\2i*\3\2"+
		"\2\2jn\t\4\2\2km\t\5\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o,\3\2"+
		"\2\2pn\3\2\2\2qr\t\6\2\2r.\3\2\2\2su\5-\27\2ts\3\2\2\2uv\3\2\2\2vt\3\2"+
		"\2\2vw\3\2\2\2wx\3\2\2\2xy\b\30\2\2y\60\3\2\2\2\7\2ehnv\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}