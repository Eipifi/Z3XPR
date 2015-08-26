// Generated from XPR.g4 by ANTLR 4.5.1
package z3fol.antlr;
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
		T__0=1, T__1=2, T__2=3, LPAREN=4, RPAREN=5, LBRACKET=6, RPRACKET=7, PLUS=8, 
		MINUS=9, TIMES=10, DIV=11, GT=12, GE=13, LE=14, LT=15, EQ=16, NEQ=17, 
		ASSIGN=18, POINT=19, POW=20, OR=21, AND=22, IMPLIES=23, IFF=24, XOR=25, 
		NOT=26, SEMICOLON=27, SET_IN=28, SET_NOTIN=29, SET_UNION=30, SET_INTERSECT=31, 
		EXISTS=32, FORALL=33, KWD_TYPE=34, KWD_DECLARE=35, KWD_ASSERT=36, NUM_DECIMAL=37, 
		IDENTIFIER_UC=38, IDENTIFIER_LC=39, Whitespace=40, Newline=41, BlockComment=42, 
		LineComment=43;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "LPAREN", "RPAREN", "LBRACKET", "RPRACKET", "PLUS", 
		"MINUS", "TIMES", "DIV", "GT", "GE", "LE", "LT", "EQ", "NEQ", "ASSIGN", 
		"POINT", "POW", "OR", "AND", "IMPLIES", "IFF", "XOR", "NOT", "SEMICOLON", 
		"SET_IN", "SET_NOTIN", "SET_UNION", "SET_INTERSECT", "EXISTS", "FORALL", 
		"KWD_TYPE", "KWD_DECLARE", "KWD_ASSERT", "NUM_DECIMAL", "IDENTIFIER_UC", 
		"IDENTIFIER_LC", "Whitespace", "Newline", "BlockComment", "LineComment"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2-\u0103\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\6&\u00c9\n&\r&\16"+
		"&\u00ca\3\'\3\'\7\'\u00cf\n\'\f\'\16\'\u00d2\13\'\3(\3(\7(\u00d6\n(\f"+
		"(\16(\u00d9\13(\3)\6)\u00dc\n)\r)\16)\u00dd\3)\3)\3*\3*\5*\u00e4\n*\3"+
		"*\5*\u00e7\n*\3*\3*\3+\3+\3+\3+\7+\u00ef\n+\f+\16+\u00f2\13+\3+\3+\3+"+
		"\3+\3+\3,\3,\3,\3,\7,\u00fd\n,\f,\16,\u0100\13,\3,\3,\3\u00f0\2-\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-\3\2\b\3\2\62;\4\2C\\aa\6\2\62;C\\aac|\4\2a"+
		"ac|\4\2\13\13\"\"\4\2\f\f\17\17\u010a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5"+
		"[\3\2\2\2\7]\3\2\2\2\t_\3\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17e\3\2\2\2\21"+
		"g\3\2\2\2\23i\3\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2"+
		"\35t\3\2\2\2\37w\3\2\2\2!y\3\2\2\2#{\3\2\2\2%~\3\2\2\2\'\u0081\3\2\2\2"+
		")\u0083\3\2\2\2+\u0085\3\2\2\2-\u0087\3\2\2\2/\u0089\3\2\2\2\61\u008c"+
		"\3\2\2\2\63\u0090\3\2\2\2\65\u0094\3\2\2\2\67\u0096\3\2\2\29\u0098\3\2"+
		"\2\2;\u009b\3\2\2\2=\u00a1\3\2\2\2?\u00a3\3\2\2\2A\u00a5\3\2\2\2C\u00ac"+
		"\3\2\2\2E\u00b3\3\2\2\2G\u00b8\3\2\2\2I\u00c0\3\2\2\2K\u00c8\3\2\2\2M"+
		"\u00cc\3\2\2\2O\u00d3\3\2\2\2Q\u00db\3\2\2\2S\u00e6\3\2\2\2U\u00ea\3\2"+
		"\2\2W\u00f8\3\2\2\2YZ\7\62\2\2Z\4\3\2\2\2[\\\7.\2\2\\\6\3\2\2\2]^\7<\2"+
		"\2^\b\3\2\2\2_`\7*\2\2`\n\3\2\2\2ab\7+\2\2b\f\3\2\2\2cd\7}\2\2d\16\3\2"+
		"\2\2ef\7\177\2\2f\20\3\2\2\2gh\7-\2\2h\22\3\2\2\2ij\7/\2\2j\24\3\2\2\2"+
		"kl\7,\2\2l\26\3\2\2\2mn\7\61\2\2n\30\3\2\2\2op\7@\2\2p\32\3\2\2\2qr\7"+
		"@\2\2rs\7?\2\2s\34\3\2\2\2tu\7>\2\2uv\7?\2\2v\36\3\2\2\2wx\7>\2\2x \3"+
		"\2\2\2yz\7?\2\2z\"\3\2\2\2{|\7#\2\2|}\7?\2\2}$\3\2\2\2~\177\7<\2\2\177"+
		"\u0080\7?\2\2\u0080&\3\2\2\2\u0081\u0082\7\60\2\2\u0082(\3\2\2\2\u0083"+
		"\u0084\7`\2\2\u0084*\3\2\2\2\u0085\u0086\7~\2\2\u0086,\3\2\2\2\u0087\u0088"+
		"\7(\2\2\u0088.\3\2\2\2\u0089\u008a\7?\2\2\u008a\u008b\7@\2\2\u008b\60"+
		"\3\2\2\2\u008c\u008d\7>\2\2\u008d\u008e\7?\2\2\u008e\u008f\7@\2\2\u008f"+
		"\62\3\2\2\2\u0090\u0091\7Z\2\2\u0091\u0092\7Q\2\2\u0092\u0093\7T\2\2\u0093"+
		"\64\3\2\2\2\u0094\u0095\7#\2\2\u0095\66\3\2\2\2\u0096\u0097\7=\2\2\u0097"+
		"8\3\2\2\2\u0098\u0099\7k\2\2\u0099\u009a\7p\2\2\u009a:\3\2\2\2\u009b\u009c"+
		"\7p\2\2\u009c\u009d\7q\2\2\u009d\u009e\7v\2\2\u009e\u009f\7k\2\2\u009f"+
		"\u00a0\7p\2\2\u00a0<\3\2\2\2\u00a1\u00a2\7\u222c\2\2\u00a2>\3\2\2\2\u00a3"+
		"\u00a4\7\u222b\2\2\u00a4@\3\2\2\2\u00a5\u00a6\7G\2\2\u00a6\u00a7\7z\2"+
		"\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab"+
		"\7u\2\2\u00abB\3\2\2\2\u00ac\u00ad\7H\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af"+
		"\7t\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7n\2\2\u00b2"+
		"D\3\2\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7{\2\2\u00b5\u00b6\7r\2\2\u00b6"+
		"\u00b7\7g\2\2\u00b7F\3\2\2\2\u00b8\u00b9\7f\2\2\u00b9\u00ba\7g\2\2\u00ba"+
		"\u00bb\7e\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7t\2\2"+
		"\u00be\u00bf\7g\2\2\u00bfH\3\2\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7u\2"+
		"\2\u00c2\u00c3\7u\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6"+
		"\7v\2\2\u00c6J\3\2\2\2\u00c7\u00c9\t\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cbL\3\2\2\2\u00cc"+
		"\u00d0\t\3\2\2\u00cd\u00cf\t\4\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1N\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d3\u00d7\t\5\2\2\u00d4\u00d6\t\4\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8P\3\2\2\2"+
		"\u00d9\u00d7\3\2\2\2\u00da\u00dc\t\6\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\b)\2\2\u00e0R\3\2\2\2\u00e1\u00e3\7\17\2\2\u00e2\u00e4\7\f\2\2"+
		"\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e7"+
		"\7\f\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00e9\b*\2\2\u00e9T\3\2\2\2\u00ea\u00eb\7\61\2\2\u00eb\u00ec\7,\2\2\u00ec"+
		"\u00f0\3\2\2\2\u00ed\u00ef\13\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3"+
		"\2\2\2\u00f0\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f3\u00f4\7,\2\2\u00f4\u00f5\7\61\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u00f7\b+\2\2\u00f7V\3\2\2\2\u00f8\u00f9\7\61\2\2\u00f9\u00fa"+
		"\7\61\2\2\u00fa\u00fe\3\2\2\2\u00fb\u00fd\n\7\2\2\u00fc\u00fb\3\2\2\2"+
		"\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\b,\2\2\u0102X\3\2\2\2\13\2\u00ca"+
		"\u00d0\u00d7\u00dd\u00e3\u00e6\u00f0\u00fe\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}