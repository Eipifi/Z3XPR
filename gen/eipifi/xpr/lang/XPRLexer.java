// Generated from /Users/eipifi/Sources/z3fol/src/main/java/eipifi/xpr/lang/XPR.g4 by ANTLR 4.5.1
package eipifi.xpr.lang;
package eipifi.xpr.lang;
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
		LPAREN=1, RPAREN=2, LBRACKET=3, RBRACKET=4, PLUS=5, MINUS=6, TIMES=7, 
		DIV=8, GT=9, GE=10, LE=11, LT=12, EQ=13, NEQ=14, ASSIGN=15, DOT=16, COMMA=17, 
		POW=18, OR=19, AND=20, IMPLIES=21, IFF=22, XOR=23, NOT=24, COLON=25, SEMICOLON=26, 
		SET_IN=27, SET_NOTIN=28, SET_UNION=29, SET_INTERSECT=30, SET_DIFF=31, 
		SET_SUB=32, EXISTS=33, FORALL=34, KWD_TYPE=35, KWD_ASSERT=36, KWD_TRUE=37, 
		KWD_FALSE=38, NUM_DECIMAL=39, IDENTIFIER=40, Whitespace=41, Newline=42, 
		BlockComment=43, LineComment=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "PLUS", "MINUS", "TIMES", 
		"DIV", "GT", "GE", "LE", "LT", "EQ", "NEQ", "ASSIGN", "DOT", "COMMA", 
		"POW", "OR", "AND", "IMPLIES", "IFF", "XOR", "NOT", "COLON", "SEMICOLON", 
		"SET_IN", "SET_NOTIN", "SET_UNION", "SET_INTERSECT", "SET_DIFF", "SET_SUB", 
		"EXISTS", "FORALL", "KWD_TYPE", "KWD_ASSERT", "KWD_TRUE", "KWD_FALSE", 
		"NUM_DECIMAL", "IDENTIFIER", "Whitespace", "Newline", "BlockComment", 
		"LineComment"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2.\u0101\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#"+
		"\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3(\6(\u00d0\n(\r(\16(\u00d1\3)\6)\u00d5\n)\r)\16)\u00d6\3*\6*\u00da"+
		"\n*\r*\16*\u00db\3*\3*\3+\3+\5+\u00e2\n+\3+\5+\u00e5\n+\3+\3+\3,\3,\3"+
		",\3,\7,\u00ed\n,\f,\16,\u00f0\13,\3,\3,\3,\3,\3,\3-\3-\3-\3-\7-\u00fb"+
		"\n-\f-\16-\u00fe\13-\3-\3-\3\u00ee\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.\3"+
		"\2\6\3\2\62;\6\2\62;C\\aac|\4\2\13\13\"\"\4\2\f\f\17\17\u0107\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13"+
		"c\3\2\2\2\re\3\2\2\2\17g\3\2\2\2\21i\3\2\2\2\23k\3\2\2\2\25m\3\2\2\2\27"+
		"p\3\2\2\2\31s\3\2\2\2\33u\3\2\2\2\35x\3\2\2\2\37{\3\2\2\2!}\3\2\2\2#\177"+
		"\3\2\2\2%\u0081\3\2\2\2\'\u0083\3\2\2\2)\u0085\3\2\2\2+\u0087\3\2\2\2"+
		"-\u008a\3\2\2\2/\u008e\3\2\2\2\61\u0092\3\2\2\2\63\u0094\3\2\2\2\65\u0096"+
		"\3\2\2\2\67\u0098\3\2\2\29\u009b\3\2\2\2;\u00a1\3\2\2\2=\u00a3\3\2\2\2"+
		"?\u00a5\3\2\2\2A\u00a7\3\2\2\2C\u00a9\3\2\2\2E\u00b0\3\2\2\2G\u00b7\3"+
		"\2\2\2I\u00bc\3\2\2\2K\u00c3\3\2\2\2M\u00c8\3\2\2\2O\u00cf\3\2\2\2Q\u00d4"+
		"\3\2\2\2S\u00d9\3\2\2\2U\u00e4\3\2\2\2W\u00e8\3\2\2\2Y\u00f6\3\2\2\2["+
		"\\\7*\2\2\\\4\3\2\2\2]^\7+\2\2^\6\3\2\2\2_`\7}\2\2`\b\3\2\2\2ab\7\177"+
		"\2\2b\n\3\2\2\2cd\7-\2\2d\f\3\2\2\2ef\7/\2\2f\16\3\2\2\2gh\7,\2\2h\20"+
		"\3\2\2\2ij\7\61\2\2j\22\3\2\2\2kl\7@\2\2l\24\3\2\2\2mn\7@\2\2no\7?\2\2"+
		"o\26\3\2\2\2pq\7>\2\2qr\7?\2\2r\30\3\2\2\2st\7>\2\2t\32\3\2\2\2uv\7?\2"+
		"\2vw\7?\2\2w\34\3\2\2\2xy\7#\2\2yz\7?\2\2z\36\3\2\2\2{|\7?\2\2| \3\2\2"+
		"\2}~\7\60\2\2~\"\3\2\2\2\177\u0080\7.\2\2\u0080$\3\2\2\2\u0081\u0082\7"+
		"`\2\2\u0082&\3\2\2\2\u0083\u0084\7~\2\2\u0084(\3\2\2\2\u0085\u0086\7("+
		"\2\2\u0086*\3\2\2\2\u0087\u0088\7?\2\2\u0088\u0089\7@\2\2\u0089,\3\2\2"+
		"\2\u008a\u008b\7>\2\2\u008b\u008c\7?\2\2\u008c\u008d\7@\2\2\u008d.\3\2"+
		"\2\2\u008e\u008f\7Z\2\2\u008f\u0090\7Q\2\2\u0090\u0091\7T\2\2\u0091\60"+
		"\3\2\2\2\u0092\u0093\7#\2\2\u0093\62\3\2\2\2\u0094\u0095\7<\2\2\u0095"+
		"\64\3\2\2\2\u0096\u0097\7=\2\2\u0097\66\3\2\2\2\u0098\u0099\7k\2\2\u0099"+
		"\u009a\7p\2\2\u009a8\3\2\2\2\u009b\u009c\7p\2\2\u009c\u009d\7q\2\2\u009d"+
		"\u009e\7v\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7p\2\2\u00a0:\3\2\2\2\u00a1"+
		"\u00a2\7\u222c\2\2\u00a2<\3\2\2\2\u00a3\u00a4\7\u222b\2\2\u00a4>\3\2\2"+
		"\2\u00a5\u00a6\7^\2\2\u00a6@\3\2\2\2\u00a7\u00a8\7\u2284\2\2\u00a8B\3"+
		"\2\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7z\2\2\u00ab\u00ac\7k\2\2\u00ac"+
		"\u00ad\7u\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7u\2\2\u00afD\3\2\2\2\u00b0"+
		"\u00b1\7h\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7c\2\2"+
		"\u00b4\u00b5\7n\2\2\u00b5\u00b6\7n\2\2\u00b6F\3\2\2\2\u00b7\u00b8\7v\2"+
		"\2\u00b8\u00b9\7{\2\2\u00b9\u00ba\7r\2\2\u00ba\u00bb\7g\2\2\u00bbH\3\2"+
		"\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7u\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0"+
		"\7g\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7v\2\2\u00c2J\3\2\2\2\u00c3\u00c4"+
		"\7v\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7g\2\2\u00c7"+
		"L\3\2\2\2\u00c8\u00c9\7h\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7n\2\2\u00cb"+
		"\u00cc\7u\2\2\u00cc\u00cd\7g\2\2\u00cdN\3\2\2\2\u00ce\u00d0\t\2\2\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2P\3\2\2\2\u00d3\u00d5\t\3\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7R\3\2\2\2\u00d8"+
		"\u00da\t\4\2\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\b*\2\2\u00de"+
		"T\3\2\2\2\u00df\u00e1\7\17\2\2\u00e0\u00e2\7\f\2\2\u00e1\u00e0\3\2\2\2"+
		"\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e5\7\f\2\2\u00e4\u00df"+
		"\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b+\2\2\u00e7"+
		"V\3\2\2\2\u00e8\u00e9\7\61\2\2\u00e9\u00ea\7,\2\2\u00ea\u00ee\3\2\2\2"+
		"\u00eb\u00ed\13\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00f2\7,\2\2\u00f2\u00f3\7\61\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b,"+
		"\2\2\u00f5X\3\2\2\2\u00f6\u00f7\7\61\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00fc"+
		"\3\2\2\2\u00f9\u00fb\n\5\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc\3\2"+
		"\2\2\u00ff\u0100\b-\2\2\u0100Z\3\2\2\2\n\2\u00d1\u00d6\u00db\u00e1\u00e4"+
		"\u00ee\u00fc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}